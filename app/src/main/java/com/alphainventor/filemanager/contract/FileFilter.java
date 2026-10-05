package com.alphainventor.filemanager.contract;

import androidx.annotation.NonNull;

/**
 * Predicate for filtering files.
 */
public interface FileFilter {
    /**
     * Test if a file should be included.
     *
     * @param file file to test
     * @return true if file matches filter
     */
    boolean accept(@NonNull FileInfo file);

    /**
     * Create a filter that accepts only files.
     */
    @NonNull
    static FileFilter filesOnly() {
        return file -> !file.isDirectory();
    }

    /**
     * Create a filter that accepts only directories.
     */
    @NonNull
    static FileFilter directoriesOnly() {
        return FileInfo::isDirectory;
    }

    /**
     * Create a filter that accepts hidden files.
     */
    @NonNull
    static FileFilter hiddenFilesOnly() {
        return FileInfo::isHidden;
    }

    /**
     * Create a filter that excludes hidden files.
     */
    @NonNull
    static FileFilter excludeHidden() {
        return file -> !file.isHidden();
    }

    /**
     * Create a filter for file extensions.
     */
    @NonNull
    static FileFilter withExtension(@NonNull String... extensions) {
        return file -> {
            if (file.isDirectory()) return true;
            String ext = file.getExtension();
            for (String expected : extensions) {
                if (ext.equalsIgnoreCase(expected)) {
                    return true;
                }
            }
            return false;
        };
    }

    /**
     * Create a filter for file name pattern.
     */
    @NonNull
    static FileFilter withNamePattern(@NonNull String pattern) {
        return file -> file.getDisplayName().matches(pattern);
    }

    /**
     * Combine two filters with AND logic.
     */
    @NonNull
    default FileFilter and(@NonNull FileFilter other) {
        return file -> accept(file) && other.accept(file);
    }

    /**
     * Combine two filters with OR logic.
     */
    @NonNull
    default FileFilter or(@NonNull FileFilter other) {
        return file -> accept(file) || other.accept(file);
    }

    /**
     * Negate this filter.
     */
    @NonNull
    default FileFilter negate() {
        return file -> !accept(file);
    }
}
