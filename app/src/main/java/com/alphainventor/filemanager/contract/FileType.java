package com.alphainventor.filemanager.contract;

import androidx.annotation.NonNull;

/**
 * Enumeration of file types.
 */
public enum FileType {
    /**
     * Regular file
     */
    FILE("file"),
    
    /**
     * Directory/folder
     */
    DIRECTORY("directory"),
    
    /**
     * Symbolic link
     */
    SYMLINK("symlink"),
    
    /**
     * Archive file (ZIP, RAR, 7Z, etc.)
     */
    ARCHIVE("archive"),
    
    /**
     * Unknown type
     */
    UNKNOWN("unknown");

    private final String code;

    FileType(@NonNull String code) {
        this.code = code;
    }

    @NonNull
    public String getCode() {
        return code;
    }

    @NonNull
    public static FileType fromCode(@NonNull String code) {
        for (FileType type : values()) {
            if (type.code.equalsIgnoreCase(code)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
