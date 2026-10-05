package com.alphainventor.filemanager.contract;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alphainventor.filemanager.contract.exception.FileSystemException;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Unified file abstraction for all file system types.
 * 
 * This interface represents a single file-like object (file, directory, symlink, etc.)
 * across all supported file systems (local, SMB, SFTP, FTP, HTTP, archive, DocumentFile, cloud).
 * 
 * Implementation Notes:
 * - All path operations are normalized and absolute
 * - All I/O operations may throw FileSystemException
 * - Implementations should handle null gracefully
 * - Caching of metadata is implementation-specific
 */
public interface FileInfo extends FileMetadata, Comparable<FileInfo> {
    
    // ==================== Basic Properties ====================
    
    /**
     * Get the file system that owns this file.
     *
     * @return parent file system, never null
     */
    @NonNull
    FileSystem getFileSystem();

    /**
     * Get a user-friendly display name with context-specific information.
     * 
     * For example:
     * - "Documents" (local)
     * - "share (\\\\192.168.1.1)" (SMB)
     * - "Photos (Dropbox)" (Cloud)
     *
     * @return display name with location context
     */
    @NonNull
    String getDisplayNameWithLocation();

    /**
     * Get file type classification (file, directory, symlink, etc.).
     *
     * @return file type enum
     */
    @NonNull
    FileType getType();

    /**
     * Get file attributes specific to this file system.
     * 
     * Examples:
     * - SMB: Attributes, DOS attributes
     * - SFTP: Unix permissions, owner, group
     * - Local: Attributes, SELinux context
     *
     * @return attributes object, or null if not applicable
     */
    @Nullable
    FileAttributes getAttributes();

    // ==================== UI Properties ====================
    
    /**
     * Get the icon drawable for this file.
     * 
     * Resolution priority:
     * 1. Specific file icon (based on type/extension)
     * 2. Generic type icon (folder, file, symlink)
     * 3. Default icon
     *
     * @param context Android context for resource access
     * @param highQuality true to load high-quality icon (for detail view)
     * @return icon drawable, or placeholder if unavailable
     */
    @NonNull
    Drawable getIcon(@NonNull Context context, boolean highQuality);

    /**
     * Get the resource ID for this file's icon.
     *
     * @return drawable resource ID
     */
    @DrawableRes
    int getIconResourceId();

    /**
     * Get human-readable file size string.
     * 
     * Examples:
     * - "1.5 MB"
     * - "42 B"
     * - "2 items" (for directories)
     *
     * @param formatOptions format flags (compact, full, etc.)
     * @return formatted size string
     */
    @NonNull
    String getFormattedSize(int formatOptions);

    /**
     * Get human-readable date string.
     *
     * @param formatOptions format flags (short, long, relative, etc.)
     * @return formatted date string
     */
    @NonNull
    String getFormattedDate(int formatOptions);

    /**
     * Get permissions in Unix-style format (e.g., "drwxr-xr-x").
     *
     * @return permission string
     */
    @NonNull
    String getPermissionString();

    // ==================== Directory Operations ====================
    
    /**
     * Check if this directory has child items.
     *
     * @return true if directory and has children
     */
    boolean hasChildren();

    /**
     * Check if this file can be entered as a directory.
     * 
     * For archives (ZIP, RAR), this returns true even though they're technically files.
     * For symlinks, follows the target.
     *
     * @return true if can be opened as directory
     */
    boolean isOpenable();

    // ==================== I/O Operations ====================
    
    /**
     * Open an input stream to read file contents.
     * 
     * The caller is responsible for closing the stream.
     *
     * @param offset byte offset to start reading from (0 for beginning)
     * @return input stream positioned at offset
     * @throws FileSystemException if file doesn't exist or can't be read
     */
    @NonNull
    InputStream openInputStream(long offset) throws FileSystemException;

    /**
     * Open an output stream to write file contents.
     * 
     * The caller is responsible for closing the stream.
     * Writing to an existing file overwrites its contents.
     *
     * @param append true to append to file, false to overwrite
     * @return output stream
     * @throws FileSystemException if file can't be written
     */
    @NonNull
    OutputStream openOutputStream(boolean append) throws FileSystemException;

    /**
     * Delete this file or empty directory.
     *
     * @throws FileSystemException if deletion fails (permissions, non-empty dir, etc.)
     */
    void delete() throws FileSystemException;

    /**
     * Rename or move this file.
     *
     * @param newPath new full path for the file
     * @throws FileSystemException if rename fails
     */
    void renameTo(@NonNull String newPath) throws FileSystemException;

    /**
     * Set the file's last-modified timestamp.
     *
     * @param timestamp milliseconds since epoch
     * @throws FileSystemException if operation not supported or fails
     */
    void setLastModified(long timestamp) throws FileSystemException;

    /**
     * Create this file if it doesn't exist.
     * 
     * For directories, use {@link FileSystem#createDirectory(String)} instead.
     *
     * @throws FileSystemException if creation fails
     */
    void create() throws FileSystemException;

    // ==================== List Children ====================
    
    /**
     * List child items in this directory.
     * 
     * Returns an empty list if this is not a directory.
     * The order is unspecified (implementation-dependent).
     * Results may be cached per filesystem.
     *
     * @return list of child FileInfo objects (may be empty, never null)
     * @throws FileSystemException if listing fails (permissions, disconnected, etc.)
     */
    @NonNull
    java.util.List<FileInfo> listChildren() throws FileSystemException;

    /**
     * List child items in this directory with filtering.
     *
     * @param filter predicate to filter results
     * @return filtered list of children
     * @throws FileSystemException if listing fails
     */
    @NonNull
    java.util.List<FileInfo> listChildren(@NonNull FileFilter filter) throws FileSystemException;

    // ==================== Caching & Refresh ====================
    
    /**
     * Refresh metadata from the underlying file system.
     * 
     * This forces re-fetching of size, dates, permissions, etc.
     * Local cache entries are invalidated.
     *
     * @throws FileSystemException if refresh fails
     */
    void refresh() throws FileSystemException;

    /**
     * Get the last time this file's metadata was refreshed.
     *
     * @return timestamp in milliseconds, or 0 if never refreshed
     */
    long getLastRefreshTime();

    // ==================== State Tracking ====================
    
    /**
     * Check if this file object is still valid.
     * 
     * A file becomes invalid if:
     * - The underlying file system disconnected
     * - The file was deleted
     * - Too much time has passed without refresh
     *
     * @return true if this file object is valid for operations
     */
    boolean isValid();

    /**
     * Invalidate this file object, forcing refresh on next access.
     */
    void invalidate();
}
