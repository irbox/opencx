package com.alphainventor.filemanager.contract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;

/**
 * Metadata interface for file-like objects across all file systems.
 * 
 * This interface provides read-only access to basic file properties
 * in a protocol-agnostic way.
 */
public interface FileMetadata extends Serializable {
    /**
     * Get the file's display name (usually the filename).
     *
     * @return file display name, never null
     */
    @NonNull
    String getDisplayName();

    /**
     * Get the absolute path in the file system.
     *
     * @return absolute path, never null
     */
    @NonNull
    String getPath();

    /**
     * Get the parent directory path.
     *
     * @return parent path, never null (root returns "/")
     */
    @NonNull
    String getParentPath();

    /**
     * Check if this file exists.
     *
     * @return true if file exists
     */
    boolean exists();

    /**
     * Check if this is a directory.
     *
     * @return true if directory
     */
    boolean isDirectory();

    /**
     * Check if file is hidden (e.g., starts with '.').
     *
     * @return true if hidden
     */
    boolean isHidden();

    /**
     * Check if file is readable.
     *
     * @return true if readable
     */
    boolean canRead();

    /**
     * Check if file is writable.
     *
     * @return true if writable
     */
    boolean canWrite();

    /**
     * Get file size in bytes.
     *
     * @return size in bytes, or 0 if unknown/not applicable
     */
    long getSize();

    /**
     * Get last modified timestamp in milliseconds since epoch.
     *
     * @return timestamp, or -1 if unknown
     */
    long getLastModified();

    /**
     * Get number of child items (for directories).
     *
     * @return child count, -1 if unknown, -2 if not a directory
     */
    int getChildCount();

    /**
     * Get MIME type of the file.
     *
     * @return MIME type string, or "application/octet-stream" if unknown
     */
    @NonNull
    String getMimeType();

    /**
     * Get file extension without the dot.
     *
     * @return extension, empty string if no extension
     */
    @NonNull
    String getExtension();

    /**
     * Get the file system location identifier.
     * 
     * Examples: "local", "smb://192.168.1.1", "sftp://example.com", "dropbox://"
     *
     * @return location identifier
     */
    @NonNull
    String getLocationId();

    /**
     * Get file permissions in Unix-style format (e.g., "drwxr-xr-x").
     *
     * @return permission string, or empty if not applicable
     */
    @NonNull
    String getPermissions();

    /**
     * Compare this file with another for sorting.
     *
     * @param other file to compare with
     * @return negative if less, zero if equal, positive if greater
     */
    int compareTo(FileMetadata other);
}
