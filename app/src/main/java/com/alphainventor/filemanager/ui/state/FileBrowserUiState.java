package com.alphainventor.filemanager.ui.state;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alphainventor.filemanager.contract.FileInfo;
import com.alphainventor.filemanager.contract.exception.FileSystemException;

import java.util.ArrayList;
import java.util.List;

/**
 * Immutable UI state for the file browser screen.
 *
 * <p>This represents the observable state that the UI renders. The ViewModel creates instances
 * of this and exposes them through a StateFlow.</p>
 */
public class FileBrowserUiState {

    private final String currentPath;
    private final List<FileInfo> files;
    private final boolean isLoading;
    private final FileSystemException error;
    private final int childCount;
    private final String sortMode;
    private final boolean showHidden;

    private FileBrowserUiState(@NonNull Builder builder) {
        this.currentPath = builder.currentPath;
        this.files = new ArrayList<>(builder.files);
        this.isLoading = builder.isLoading;
        this.error = builder.error;
        this.childCount = builder.childCount;
        this.sortMode = builder.sortMode;
        this.showHidden = builder.showHidden;
    }

    @NonNull
    public String getCurrentPath() {
        return currentPath;
    }

    @NonNull
    public List<FileInfo> getFiles() {
        return new ArrayList<>(files);
    }

    public boolean isLoading() {
        return isLoading;
    }

    @Nullable
    public FileSystemException getError() {
        return error;
    }

    public int getChildCount() {
        return childCount;
    }

    @NonNull
    public String getSortMode() {
        return sortMode;
    }

    public boolean isShowHidden() {
        return showHidden;
    }

    public boolean hasError() {
        return error != null;
    }

    @Override
    public String toString() {
        return "FileBrowserUiState{" +
                "currentPath='" + currentPath + '\'' +
                ", fileCount=" + files.size() +
                ", isLoading=" + isLoading +
                ", hasError=" + hasError() +
                ", sortMode='" + sortMode + '\'' +
                ", showHidden=" + showHidden +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String currentPath = "/";
        private List<FileInfo> files = new ArrayList<>();
        private boolean isLoading = false;
        private FileSystemException error = null;
        private int childCount = 0;
        private String sortMode = "name";
        private boolean showHidden = false;

        @NonNull
        public Builder currentPath(@NonNull String currentPath) {
            this.currentPath = currentPath;
            return this;
        }

        @NonNull
        public Builder files(@NonNull List<FileInfo> files) {
            this.files = new ArrayList<>(files);
            return this;
        }

        @NonNull
        public Builder isLoading(boolean isLoading) {
            this.isLoading = isLoading;
            return this;
        }

        @NonNull
        public Builder error(@Nullable FileSystemException error) {
            this.error = error;
            return this;
        }

        @NonNull
        public Builder childCount(int childCount) {
            this.childCount = childCount;
            return this;
        }

        @NonNull
        public Builder sortMode(@NonNull String sortMode) {
            this.sortMode = sortMode;
            return this;
        }

        @NonNull
        public Builder showHidden(boolean showHidden) {
            this.showHidden = showHidden;
            return this;
        }

        @NonNull
        public FileBrowserUiState build() {
            return new FileBrowserUiState(this);
        }
    }
}
