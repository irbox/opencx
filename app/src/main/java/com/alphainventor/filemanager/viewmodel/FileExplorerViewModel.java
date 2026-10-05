package com.alphainventor.filemanager.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alphainventor.filemanager.contract.FileFilter;
import com.alphainventor.filemanager.contract.FileInfo;
import com.alphainventor.filemanager.contract.ProgressListener;
import com.alphainventor.filemanager.contract.exception.FileSystemException;
import com.alphainventor.filemanager.repository.FileOperationsRepository;
import com.alphainventor.filemanager.ui.state.FileBrowserUiState;
import com.alphainventor.filemanager.util.FilePathUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewModel for the file explorer screen.
 *
 * <p>This manages the state and business logic for navigating and interacting with the file system.
 * It exposes observable UI state and accepts user actions (navigation, operations, filtering).</p>
 */
public class FileExplorerViewModel extends ViewModel {

    private final Context appContext;
    private final FileOperationsRepository repository;
    private final MutableLiveData<FileBrowserUiState> uiStateLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> navigationEventLiveData = new MutableLiveData<>();
    private final MutableLiveData<FileSystemException> errorEventLiveData = new MutableLiveData<>();

    private FileBrowserUiState currentState;
    private String sortMode = "name";
    private boolean showHidden = false;

    public FileExplorerViewModel(@NonNull Context context, @NonNull FileOperationsRepository repository) {
        this.appContext = context;
        this.repository = repository;
        this.currentState = FileBrowserUiState.builder().build();
        updateUiState();
    }

    @NonNull
    public LiveData<FileBrowserUiState> getUiState() {
        return uiStateLiveData;
    }

    @NonNull
    public LiveData<String> getNavigationEvents() {
        return navigationEventLiveData;
    }

    @NonNull
    public LiveData<FileSystemException> getErrorEvents() {
        return errorEventLiveData;
    }

    /**
     * Navigate to a directory and load its contents.
     */
    public void navigateToDirectory(@NonNull String path) {
        String normalizedPath = repository.normalizePath(path);
        loadDirectory(normalizedPath);
    }

    /**
     * Go back to the parent directory.
     */
    public void navigateUp() {
        String parentPath = repository.getLocalFileSystem().getParentPath(currentState.getCurrentPath());
        if (!parentPath.equals(currentState.getCurrentPath())) {
            loadDirectory(parentPath);
        }
    }

    /**
     * Load directory contents into the UI state.
     */
    private void loadDirectory(@NonNull String path) {
        String normalizedPath = repository.normalizePath(path);
        updateUiState(FileBrowserUiState.builder()
                .currentPath(normalizedPath)
                .isLoading(true)
                .build());

        try {
            FileFilter filter = showHidden ? null : FileFilter.excludeHidden();
            List<FileInfo> files = repository.listDirectory(normalizedPath, filter, getSortModeValue());
            updateUiState(FileBrowserUiState.builder()
                    .currentPath(normalizedPath)
                    .files(files)
                    .childCount(files.size())
                    .isLoading(false)
                    .sortMode(sortMode)
                    .showHidden(showHidden)
                    .build());
        } catch (FileSystemException e) {
            updateUiState(FileBrowserUiState.builder()
                    .currentPath(normalizedPath)
                    .isLoading(false)
                    .error(e)
                    .sortMode(sortMode)
                    .showHidden(showHidden)
                    .build());
            errorEventLiveData.postValue(e);
        }
    }

    /**
     * Create a new directory.
     */
    public void createDirectory(@NonNull String parentPath, @NonNull String dirName) {
        String newDirPath = repository.getLocalFileSystem().joinPath(parentPath, dirName);
        try {
            repository.createDirectory(newDirPath, false);
            loadDirectory(parentPath);
        } catch (FileSystemException e) {
            errorEventLiveData.postValue(e);
        }
    }

    /**
     * Delete a file or directory.
     */
    public void deleteFile(@NonNull FileInfo file, @Nullable ProgressListener progress) {
        try {
            if (file.isDirectory()) {
                repository.deleteRecursive(file.getPath(), progress);
            } else {
                repository.delete(file.getPath());
            }
            loadDirectory(currentState.getCurrentPath());
        } catch (FileSystemException e) {
            errorEventLiveData.postValue(e);
        }
    }

    /**
     * Copy a file or directory.
     */
    public void copyFile(@NonNull String sourcePath,
                        @NonNull String destinationPath,
                        boolean overwrite,
                        @Nullable ProgressListener progress) {
        try {
            FileInfo sourceInfo = repository.getFileInfo(sourcePath);
            if (sourceInfo.isDirectory()) {
                repository.getLocalFileSystem().copyDirectory(sourcePath, destinationPath, overwrite, progress);
            } else {
                repository.copy(sourcePath, destinationPath, overwrite, progress);
            }
        } catch (FileSystemException e) {
            errorEventLiveData.postValue(e);
        }
    }

    /**
     * Move a file or directory.
     */
    public void moveFile(@NonNull String sourcePath, @NonNull String destinationPath) {
        try {
            repository.move(sourcePath, destinationPath);
            loadDirectory(currentState.getCurrentPath());
        } catch (FileSystemException e) {
            errorEventLiveData.postValue(e);
        }
    }

    /**
     * Search for files matching a pattern.
     */
    public void search(@NonNull String rootPath, @NonNull String pattern, int maxResults) {
        try {
            List<FileInfo> results = repository.search(rootPath, pattern, maxResults, null);
            updateUiState(FileBrowserUiState.builder()
                    .currentPath("search://" + rootPath)
                    .files(results)
                    .childCount(results.size())
                    .isLoading(false)
                    .build());
        } catch (FileSystemException e) {
            errorEventLiveData.postValue(e);
        }
    }

    /**
     * Toggle showing/hiding hidden files.
     */
    public void toggleHiddenFiles() {
        showHidden = !showHidden;
        loadDirectory(currentState.getCurrentPath());
    }

    /**
     * Change the sort mode.
     */
    public void setSortMode(@NonNull String mode) {
        sortMode = mode;
        loadDirectory(currentState.getCurrentPath());
    }

    /**
     * Retry loading after an error.
     */
    public void retryLoadDirectory() {
        loadDirectory(currentState.getCurrentPath());
    }

    /**
     * Get file info for a specific path.
     */
    @Nullable
    public FileInfo getFileInfo(@NonNull String path) {
        try {
            return repository.getFileInfo(path);
        } catch (FileSystemException e) {
            errorEventLiveData.postValue(e);
            return null;
        }
    }

    private void updateUiState(@NonNull FileBrowserUiState newState) {
        this.currentState = newState;
        uiStateLiveData.postValue(newState);
    }

    private void updateUiState() {
        uiStateLiveData.postValue(currentState);
    }

    private int getSortModeValue() {
        switch (sortMode) {
            case "size":
                return 1;
            case "date":
                return 2;
            case "name":
            default:
                return 0;
        }
    }
}
