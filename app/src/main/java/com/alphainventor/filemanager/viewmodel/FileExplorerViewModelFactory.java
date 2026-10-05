package com.alphainventor.filemanager.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.alphainventor.filemanager.repository.FileOperationsRepository;

/**
 * Factory for creating ViewModels with dependency injection.
 */
public class FileExplorerViewModelFactory implements ViewModelProvider.Factory {

    private final Context appContext;
    private final FileOperationsRepository repository;

    public FileExplorerViewModelFactory(@NonNull Context appContext,
                                       @NonNull FileOperationsRepository repository) {
        this.appContext = appContext;
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FileExplorerViewModel.class)) {
            return (T) new FileExplorerViewModel(appContext, repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
