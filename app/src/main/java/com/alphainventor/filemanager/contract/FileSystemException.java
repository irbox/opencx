package com.alphainventor.filemanager.contract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Base exception for all file system operations.
 * 
 * This exception wraps underlying errors from different file systems
 * into a unified interface.
 */
public class FileSystemException extends Exception {
    
    private final ErrorCode errorCode;
    private final String path;
    private final String locationId;
    private final long timestamp;

    /**
     * Create a generic file system exception.
     */
    public FileSystemException(@NonNull String message) {
        this(message, null, ErrorCode.UNKNOWN, null, null);
    }

    /**
     * Create a file system exception with cause.
     */
    public FileSystemException(@NonNull String message, @Nullable Throwable cause) {
        this(message, cause, ErrorCode.UNKNOWN, null, null);
    }

    /**
     * Create a file system exception with error code.
     */
    public FileSystemException(@NonNull String message,
                               @Nullable Throwable cause,
                               @NonNull ErrorCode errorCode) {
        this(message, cause, errorCode, null, null);
    }

    /**
     * Create a detailed file system exception.
     */
    public FileSystemException(@NonNull String message,
                               @Nullable Throwable cause,
                               @NonNull ErrorCode errorCode,
                               @Nullable String path,
                               @Nullable String locationId) {
        super(message, cause);
        this.errorCode = errorCode;
        this.path = path;
        this.locationId = locationId;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * Get the error code for this exception.
     */
    @NonNull
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * Get the file path involved in this error (if applicable).
     */
    @Nullable
    public String getPath() {
        return path;
    }

    /**
     * Get the file system location ID.
     */
    @Nullable
    public String getLocationId() {
        return locationId;
    }

    /**
     * Get timestamp when exception occurred.
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Check if this error is recoverable.
     */
    public boolean isRecoverable() {
        switch (errorCode) {
            case NETWORK_TIMEOUT:
            case NETWORK_UNREACHABLE:
            case DISCONNECTED:
            case RESOURCE_BUSY:
                return true;
            default:
                return false;
        }
    }

    /**
     * Check if error is due to permissions.
     */
    public boolean isPermissionError() {
        return errorCode == ErrorCode.PERMISSION_DENIED;
    }

    /**
     * Check if file was not found.
     */
    public boolean isNotFound() {
        return errorCode == ErrorCode.NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(": ");
        sb.append(errorCode.name());
        if (path != null) {
            sb.append(" [path=").append(path).append("]");
        }
        if (getMessage() != null) {
            sb.append(" - ").append(getMessage());
        }
        return sb.toString();
    }

    /**
     * Standardized error codes for file system operations.
     */
    public enum ErrorCode {
        // File not found
        NOT_FOUND,
        
        // Access denied
        PERMISSION_DENIED,
        
        // File already exists
        ALREADY_EXISTS,
        
        // Directory not empty
        DIRECTORY_NOT_EMPTY,
        
        // Disk/quota full
        DISK_FULL,
        
        // Read-only file system
        READ_ONLY,
        
        // Invalid path
        INVALID_PATH,
        
        // Is a directory (expected file)
        IS_DIRECTORY,
        
        // Is not a directory (expected directory)
        NOT_A_DIRECTORY,
        
        // File sharing violation
        SHARING_VIOLATION,
        
        // Archive corrupted or invalid
        ARCHIVE_CORRUPTED,
        
        // Archive encrypted
        ARCHIVE_ENCRYPTED,
        
        // Network not reachable
        NETWORK_UNREACHABLE,
        
        // Network timeout
        NETWORK_TIMEOUT,
        
        // File system disconnected
        DISCONNECTED,
        
        // Connection refused
        CONNECTION_REFUSED,
        
        // Invalid credentials
        INVALID_CREDENTIALS,
        
        // Resource busy/locked
        RESOURCE_BUSY,
        
        // Operation cancelled
        CANCELLED,
        
        // Operation not supported
        NOT_SUPPORTED,
        
        // Generic unknown error
        UNKNOWN
    }
}
