package com.alphainventor.filemanager.contract;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alphainventor.filemanager.contract.exception.FileSystemException;

import java.util.List;

/**
 * File system abstraction that works uniformly across all protocol types.
 * 
 * Each file system type (local, SMB, SFTP, FTP, HTTP, archive, DocumentFile, cloud)
 * implements this interface to provide a consistent API.
 * 
 * Usage Example:
 * ```java
 * FileSystem fs = FileSystemFactory.getFileSystem("/path/to/file");
 * FileInfo info = fs.getFileInfo("/path/to/file");
 * List<FileInfo> children = fs.listDirectory("/path/to/dir");
 * ```
 * 
 * Threading Model:
 * - All operations are blocking and should be called from a background thread
 * - The underlying implementation handles connection pooling and timeouts
 * - Multiple operations on the same FileSystem instance are serialized
 */
public interface FileSystem {
    
    // ==================== File System Info ====================
    
    /**
     * Get unique identifier for this file system.
     * 
     * Examples:
     * - "local" for device storage
     * - "smb://192.168.1.1/share" for SMB shares
     * - "sftp://user@example.com/home/user" for SFTP
     * - "file:///storage/emulated/0/archive.zip" for archive
     * - "dropbox://" for Dropbox
     *
     * @return file system identifier, never null
     */
    @NonNull
    String getLocationId();

    /**
     * Get human-readable name for this file system.
     *
     * @return display name, never null
     */
    @NonNull
    String getDisplayName();

    /**
     * Get the type of file system.
     *
     * @return file system type
     */
    @NonNull
    FileSystemType getType();

    /**
     * Get Android context for resource access.
     *
     * @return application context
     */
    @NonNull
    Context getContext();

    /**
     * Get connection state.
     *
     * @return true if file system is connected/available
     */
    boolean isConnected();

    /**
     * Get the root path for this file system.
     *
     * @return root path, usually "/"
     */
    @NonNull
    String getRootPath();

    // ==================== File Access ====================
    
    /**
     * Get file information for a specific path.
     * 
     * The returned FileInfo may be cached. Call {@link FileInfo#refresh()} to get
     * current metadata.
     *
     * @param path absolute path in this file system
     * @return file info object
     * @throws FileSystemException if file not found or can't be accessed
     */
    @NonNull
    FileInfo getFileInfo(@NonNull String path) throws FileSystemException;

    /**
     * List children in a directory.
     * 
     * Returns empty list if path is not a directory.
     * Hidden files are included by default.
     *
     * @param directoryPath path to directory
     * @return list of child file info objects
     * @throws FileSystemException if directory can't be accessed
     */
    @NonNull
    List<FileInfo> listDirectory(@NonNull String directoryPath) throws FileSystemException;

    /**
     * List children with filtering and sorting.
     *
     * @param directoryPath path to directory
     * @param filter predicate to filter results (null = no filter)
     * @param sortMode sort order (name, size, date, etc.)
     * @return sorted list of children
     * @throws FileSystemException if directory can't be accessed
     */
    @NonNull
    List<FileInfo> listDirectory(@NonNull String directoryPath,
                                  @Nullable FileFilter filter,
                                  int sortMode) throws FileSystemException;

    /**
     * Check if a path exists.
     *
     * @param path path to check
     * @return true if exists
     * @throws FileSystemException for I/O errors
     */
    boolean exists(@NonNull String path) throws FileSystemException;

    /**
     * Check if a path is a directory.
     *
     * @param path path to check
     * @return true if is directory
     * @throws FileSystemException for I/O errors
     */
    boolean isDirectory(@NonNull String path) throws FileSystemException;

    // ==================== File Operations ====================
    
    /**
     * Create a new directory.
     *
     * @param directoryPath path for new directory
     * @param createParents if true, create parent directories as needed
     * @throws FileSystemException if creation fails
     */
    void createDirectory(@NonNull String directoryPath, boolean createParents)
            throws FileSystemException;

    /**
     * Delete a file or empty directory.
     *
     * @param path path to delete
     * @throws FileSystemException if deletion fails (non-empty directory, permissions, etc.)
     */
    void delete(@NonNull String path) throws FileSystemException;

    /**
     * Delete a file or directory recursively.
     *
     * @param path path to delete
     * @param progress callback for progress updates (null to ignore)
     * @throws FileSystemException if deletion fails
     */
    void deleteRecursive(@NonNull String path, @Nullable ProgressListener progress)
            throws FileSystemException;

    /**
     * Copy a file.
     *
     * @param sourcePath source file path
     * @param destinationPath destination file path
     * @param overwrite if false, throws exception if destination exists
     * @param progress callback for progress updates (null to ignore)
     * @throws FileSystemException if copy fails
     */
    void copy(@NonNull String sourcePath,
              @NonNull String destinationPath,
              boolean overwrite,
              @Nullable ProgressListener progress) throws FileSystemException;

    /**
     * Move/rename a file.
     *
     * @param sourcePath source file path
     * @param destinationPath destination file path
     * @throws FileSystemException if move fails
     */
    void move(@NonNull String sourcePath, @NonNull String destinationPath)
            throws FileSystemException;

    /**
     * Copy directory and contents.
     *
     * @param sourcePath source directory path
     * @param destinationPath destination directory path
     * @param overwrite if false, throws exception if destination exists
     * @param progress callback for progress updates
     * @throws FileSystemException if copy fails
     */
    void copyDirectory(@NonNull String sourcePath,
                       @NonNull String destinationPath,
                       boolean overwrite,
                       @Nullable ProgressListener progress) throws FileSystemException;

    /**
     * Set file's last-modified timestamp.
     *
     * @param path file path
     * @param timestamp milliseconds since epoch
     * @throws FileSystemException if operation fails
     */
    void setLastModified(@NonNull String path, long timestamp) throws FileSystemException;

    // ==================== Path Operations ====================
    
    /**
     * Get parent directory path.
     * 
     * For root, returns root itself.
     *
     * @param path file path
     * @return parent path
     */
    @NonNull
    String getParentPath(@NonNull String path);

    /**
     * Get file name from path.
     *
     * @param path file path
     * @return file name component
     */
    @NonNull
    String getFileName(@NonNull String path);

    /**
     * Get file extension from path.
     *
     * @param path file path
     * @return extension without dot, or empty string
     */
    @NonNull
    String getFileExtension(@NonNull String path);

    /**
     * Join path components into a single path.
     *
     * @param parent parent path
     * @param child child path component
     * @return joined path
     */
    @NonNull
    String joinPath(@NonNull String parent, @NonNull String child);

    /**
     * Normalize a path (remove . and .., clean separators).
     *
     * @param path path to normalize
     * @return normalized path
     */
    @NonNull
    String normalizePath(@NonNull String path);

    // ==================== Connection Management ====================
    
    /**
     * Connect to the file system.
     * 
     * May be called multiple times (idempotent).
     * Some file systems (local) don't need explicit connection.
     *
     * @throws FileSystemException if connection fails
     */
    void connect() throws FileSystemException;

    /**
     * Disconnect from the file system.
     * 
     * Should be called when done with this file system.
     * Operations after disconnect will fail until reconnect() is called.
     */
    void disconnect();

    /**
     * Reconnect to the file system.
     *
     * @throws FileSystemException if reconnection fails
     */
    void reconnect() throws FileSystemException;

    /**
     * Close all resources and prepare for garbage collection.
     */
    void close();

    // ==================== Capabilities ====================
    
    /**
     * Check if this file system supports a specific operation.
     *
     * @param operation operation to check
     * @return true if operation is supported
     */
    boolean supports(@NonNull FileSystemOperation operation);

    /**
     * Get storage quota information.
     *
     * @return quota info, or null if not applicable
     */
    @Nullable
    StorageQuota getQuota() throws FileSystemException;

    /**
     * Get credentials/authentication state.
     *
     * @return auth info, or null if not applicable
     */
    @Nullable
    AuthenticationInfo getAuthenticationInfo();

    // ==================== Search & Utilities ====================
    
    /**
     * Search for files matching a pattern.
     *
     * @param rootPath starting directory for search
     * @param pattern search pattern (glob or regex)
     * @param maxResults maximum results to return
     * @param progress callback for progress updates
     * @return list of matching files
     * @throws FileSystemException if search fails
     */
    @NonNull
    List<FileInfo> search(@NonNull String rootPath,
                          @NonNull String pattern,
                          int maxResults,
                          @Nullable ProgressListener progress) throws FileSystemException;

    /**
     * Clear any internal caches.
     * 
     * Forces fresh data fetch on next access.
     */
    void clearCache();
}
