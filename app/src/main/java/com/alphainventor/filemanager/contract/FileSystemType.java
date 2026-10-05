package com.alphainventor.filemanager.contract;

import androidx.annotation.NonNull;

/**
 * Enumeration of supported file system types.
 */
public enum FileSystemType {
    /**
     * Device local file system
     */
    LOCAL("local", "Local Storage"),
    
    /**
     * SMB/CIFS network protocol (Windows shares, Samba)
     */
    SMB("smb", "SMB/CIFS"),
    
    /**
     * SFTP network protocol (SSH file transfer)
     */
    SFTP("sftp", "SFTP/SSH"),
    
    /**
     * FTP network protocol
     */
    FTP("ftp", "FTP"),
    
    /**
     * HTTP/HTTPS web server
     */
    HTTP("http", "HTTP"),
    
    /**
     * Archive file (ZIP, RAR, 7Z, TAR)
     */
    ARCHIVE("archive", "Archive"),
    
    /**
     * Android DocumentFile API (external storage, MTP, etc.)
     */
    DOCUMENT("document", "Document"),
    
    /**
     * Dropbox cloud storage
     */
    DROPBOX("dropbox", "Dropbox"),
    
    /**
     * Google Drive cloud storage
     */
    GOOGLE_DRIVE("google_drive", "Google Drive"),
    
    /**
     * Microsoft OneDrive cloud storage
     */
    ONE_DRIVE("one_drive", "OneDrive"),
    
    /**
     * Amazon S3 object storage
     */
    S3("s3", "Amazon S3"),
    
    /**
     * Unknown type
     */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String displayName;

    FileSystemType(@NonNull String code, @NonNull String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    @NonNull
    public String getCode() {
        return code;
    }

    @NonNull
    public String getDisplayName() {
        return displayName;
    }

    @NonNull
    public static FileSystemType fromCode(@NonNull String code) {
        for (FileSystemType type : values()) {
            if (type.code.equalsIgnoreCase(code)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
