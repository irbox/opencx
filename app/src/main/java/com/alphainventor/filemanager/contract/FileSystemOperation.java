package com.alphainventor.filemanager.contract;

/**
 * Enumeration of file system operations that can be supported or unsupported.
 */
public enum FileSystemOperation {
    /**
     * Can read file contents
     */
    READ,
    
    /**
     * Can write file contents
     */
    WRITE,
    
    /**
     * Can delete files
     */
    DELETE,
    
    /**
     * Can rename/move files
     */
    RENAME,
    
    /**
     * Can create directories
     */
    CREATE_DIRECTORY,
    
    /**
     * Can list directory contents
     */
    LIST_DIRECTORY,
    
    /**
     * Can get file metadata (size, dates, permissions)
     */
    GET_METADATA,
    
    /**
     * Can set file metadata
     */
    SET_METADATA,
    
    /**
     * Can set file permissions
     */
    SET_PERMISSIONS,
    
    /**
     * Can copy files
     */
    COPY,
    
    /**
     * Can create symlinks
     */
    CREATE_SYMLINK,
    
    /**
     * Can follow symlinks
     */
    FOLLOW_SYMLINKS,
    
    /**
     * Can search/find files
     */
    SEARCH,
    
    /**
     * Can get storage quota information
     */
    GET_QUOTA
}
