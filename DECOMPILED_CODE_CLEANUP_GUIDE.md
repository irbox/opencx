# OpenCX Decompiled Code Cleanup & Refactor Guide

**Status:** Reference documentation for production migration

**Last Updated:** 2026-10-05

---

## Executive Summary

This repository contains **decompiled reference artifacts** in `decompiled_reference/file/` that serve as:
- Legacy implementation documentation
- Reverse-engineering artifacts (not production source)
- File abstraction layer patterns for replication

The **actual production code** should exist under:
```
app/src/main/java/com/alphainventor/filemanager/
```

**Goal:** Reconstruct a clean, maintainable codebase from decompilation artifacts and architectural patterns.

---

## Part 1: Understanding Decompiled Code Issues

### 1.1 Classes & Naming Problems

The decompilation process corrupted class names through R8/ProGuard minification:

| Decompiled Name | Likely Intended Name | Evidence |
|---|---|---|
| `A.java` | `CloudStorageProvider` | Imports cloud storage types, inherits from `x` |
| `B.java` | `ArchiveFileManager` | 2,134 lines; handles ZIP operations |
| `G.java` | `DocumentFileOperations` | 2,414 lines; DocumentsContract, content providers |
| `Q.java` | `LocalFileSystemManager` | 3,841 lines; file operations, permissions |
| `N.java` | `SmbClient` | SMB/CIFS protocol client |
| `M.java` | `SftpFileInfo` | SFTP file attributes wrapper |
| `X.java` | `HttpFileInfo` | HTTP file metadata |
| `H.java` | `TempLocationHelper` | Fragment-based temp file dialogs |
| `AbstractC3438n.java` | `FileInfo` (base interface) | Abstract file contract |

### 1.2 Method Naming Obfuscation

Methods are named with cryptic patterns:
- Single letters: `C()`, `H()`, `P()`, `W()`, `Z()`
- Numeric suffixes: `U1()`, `T1()`, `C0()`, `D0()`, `E0()`
- Two-letter combos: `M0()`, `N0()`, `L0()`, `K0()`

**Pattern Recognition:**
- Getters: `E()` = `getFullPath()`, `B()` = `getName()`, `F()` = `getFullPath()`, `T()` = `getParentPath()`, `U()` = `getParentPath()`
- Checkers: `n()` = `exists()`, `d()` = `canRead()`, `j()` = `canWrite()`, `isDirectory()`, `h()` = `isHidden()`
- Size/Time: `p()` = `getSize()`, `q()` = `getLastModified()`
- Operations: `I()` = `delete()`, `E()` = `move/copy to`

### 1.3 Control Flow Issues

**Problem:** Decompiler sometimes produces unreachable code, malformed labels, and confusing flow:

**Example from B.java (lines 254-260):**
```java
// BROKEN: Unreachable label with incorrect variable assignment
Label_0831: {
    Label_0803: {
        Label_0649: {
            I h0;
            try {
                try {
                    h0 = this.H0(((ax.c3.a)ex).t());
                    // ... multiple try/catch/finally with overlapping handlers
```

**Solution:** Map bytecode → reconstruct logical flow → rename → document.

---

## Part 2: Decompiled File Breakdown & Cleanup

### 2.1 Core Abstractions (Foundation Layer)

#### File 1: `AbstractC3438n.java` → `FileInfo.java`
**Purpose:** Base contract for all file types

**Cleanup Steps:**
```
1. Rename AbstractC3438n → FileInfo
2. Extract interface InterfaceC1657b → FileMetadata
3. Map obfuscated methods:
   - C() → getDisplayName()
   - E() → getPath()
   - F() → getFullPath()
   - U() → getParentPath()
   - p() → getSize()
   - q() → getLastModified()
   - n() → exists()
   - isDirectory() → isDirectory()
   - d() → canRead()
   - j() → canWrite()
   - h() → isHidden()
4. Inline Constants:
   - 2131231320 → R.drawable.ic_folder
   - 2131952464 → R.string.size_unknown
5. Add @Nullable, @NonNull annotations
6. Document each abstract method
```

**Cleaned Code Preview:**
```java
/**
 * Represents a file in any file system (local, SMB, FTP, cloud, archive).
 * This is the core abstraction layer.
 */
public abstract class FileInfo implements Comparable<FileInfo>, FileMetadata {
    protected ax.c3.K location;           // FileSystemLocation
    protected int childCount = -1;         // Cached child count
    private EnumC1680z fileType;          // Cached MIME type
    protected Context appContext;

    protected FileInfo(FileSystem fileSystem) {
        this.appContext = fileSystem.getApplicationContext();
        this.location = fileSystem.getLocation();
    }

    /** Display name (file name with extension or special label) */
    protected abstract String getDisplayName();

    /** Absolute path in the file system */
    protected abstract String getFullPath();

    /** Parent directory path */
    protected abstract String getParentPath();

    /** True if file exists */
    public abstract boolean exists();

    /** True if is a directory */
    public abstract boolean isDirectory();

    /** File size in bytes */
    public abstract long getSize();

    /** Last modified timestamp in milliseconds */
    public abstract long getLastModified();

    // Computed properties (with caching)
    public final String getPath() {
        String fullPath = getFullPath();
        if (!isNormalized(fullPath)) {
            logWarning("Path not normalized: " + fullPath);
        }
        return fullPath;
    }

    public final String getParent() {
        String parentPath = getParentPath();
        if (!isNormalized(parentPath)) {
            logWarning("Parent path not normalized: " + parentPath);
        }
        return parentPath;
    }

    public FileType getMimeType() {
        if (this.fileType == null) {
            this.fileType = MimeTypeResolver.detect(getExtension());
        }
        return this.fileType;
    }

    public String getFormattedSize(int format) {
        long size = getSize();
        return size <= 0 ? "" : SizeFormatter.format(appContext, size, format);
    }

    public Drawable getIcon(Context context, boolean highQuality) {
        if (isDirectory()) {
            return FolderIconProvider.getIcon(context, this, hasChildren(), highQuality);
        }
        return MimeTypeResolver.getIcon(context, getPath(), highQuality);
    }

    public boolean canRead() {
        return true; // Implement per subclass
    }

    public boolean canWrite() {
        return true; // Implement per subclass
    }

    public boolean isHidden() {
        return getDisplayName().startsWith(".");
    }
}
```

#### File 2: `m.java` → `FileSystem.java`
**Purpose:** Abstract file system provider (SMB, SFTP, HTTP, local, etc.)

**Cleanup:**
```
1. Rename m → FileSystem
2. Extract common interface FileSystemContract
3. Identify subclasses:
   - N.java → SmbFileSystem
   - M.java should be SftpFileInfo (not filesystem)
   - X.java → HttpFileSystem
   - W.java, V.java → Unknown (need inspection)
4. Document each abstract method
5. Add factory pattern for creation
```

#### File 3: `n.java` → `SmbFileSystem.java` (formerly `N.java`)
**Purpose:** SMB/CIFS protocol implementation

**Cleanup Steps:**
```
1. Extract N → SmbFileSystem
2. Extract inner class N.b → SmbInputStream
3. Map constants:
   - Error codes: -1073741810 → SMB_ERROR_NOT_FOUND
   - Port defaults: 445 → SMB_DEFAULT_PORT
4. Wrap jcifs library usage in try/catch blocks
5. Add Javadoc for each method
6. Replace error codes with enum
```

**Cleaned Structure:**
```java
public class SmbFileSystem extends FileSystem {
    private static final Logger LOG = Logger.getLogger(SmbFileSystem.class.getName());
    private static final int DEFAULT_SMB_PORT = 445;
    
    private SmbAuthenticationContext auth;
    private LruCache<String, SmbFile> fileCache;
    private SmbConnection connection;
    private String pathPrefix;

    public SmbFileSystem(SmbAuthenticationContext auth, String pathPrefix) {
        this.auth = auth;
        this.pathPrefix = pathPrefix;
        this.fileCache = new LruCache<>(10);
    }

    @Override
    public SmbFileInfo getFileInfo(String path) throws FileSystemException {
        try {
            SmbFile smbFile = resolveSmbFile(path);
            return new SmbFileInfo(this, smbFile);
        } catch (SmbException e) {
            throw new FileSystemException("Failed to get SMB file: " + path, e);
        }
    }

    @Override
    public List<FileInfo> listChildren(FileInfo directory) throws FileSystemException {
        try {
            SmbFile smbDir = ((SmbFileInfo)directory).getSmbFile();
            SmbFile[] children = smbDir.listFiles();
            
            List<FileInfo> result = new ArrayList<>();
            for (SmbFile child : children) {
                result.add(new SmbFileInfo(this, child));
            }
            return result;
        } catch (SmbException e) {
            throw new FileSystemException("Failed to list children", e);
        }
    }

    @Override
    public InputStream openInputStream(FileInfo file, long offset) throws FileSystemException {
        try {
            SmbFile smbFile = ((SmbFileInfo)file).getSmbFile();
            BufferedInputStream stream = new BufferedInputStream(
                new SmbInputStream(smbFile),
                8192
            );
            if (offset > 0) {
                stream.skip(offset);
            }
            return stream;
        } catch (IOException e) {
            throw new FileSystemException("Failed to open input stream", e);
        }
    }

    private SmbFile resolveSmbFile(String path) throws SmbException {
        SmbFile cached = fileCache.get(path);
        if (cached != null) {
            return cached;
        }
        
        String smbUrl = buildSmbUrl(path);
        SmbFile file = new SmbFile(smbUrl, auth.getAuthentication());
        fileCache.put(path, file);
        return file;
    }

    private static class SmbInputStream extends InputStream implements AutoCloseable {
        private SmbRandomAccessFile file;
        private long totalSize;
        private long position = 0;

        SmbInputStream(SmbFile smbFile) throws IOException {
            this.file = new SmbRandomAccessFile(smbFile, "r");
            this.totalSize = smbFile.length();
        }

        @Override
        public int read() throws IOException {
            if (position >= totalSize) return -1;
            int value = file.read();
            if (value >= 0) position++;
            return value;
        }

        @Override
        public int read(byte[] buffer, int offset, int length) throws IOException {
            if (position >= totalSize) return -1;
            int read = file.read(buffer, offset, length);
            position += read;
            return read;
        }

        @Override
        public void close() throws IOException {
            file.close();
        }
    }
}
```

#### File 4: `M.java` → `SftpFileInfo.java`
**Purpose:** SFTP file metadata wrapper

**Cleanup:**
```
1. Rename M → SftpFileInfo
2. Replace jcraft.jsch.SftpATTRS with own FileAttributes
3. Map permission bits:
   - 0x4 → ATTR_READABLE
   - 0x2 → ATTR_WRITABLE
4. Add proper null safety with @Nullable
```

#### File 5: `X.java` → `HttpFileInfo.java`
**Purpose:** HTTP/HTTPS file metadata

**Cleanup:**
```
1. Rename X → HttpFileInfo
2. Replace ax.Ia.c with OkHttp3 or similar
3. Add proper URL parsing and validation
4. Handle HTTP redirects and special cases
```

---

### 2.2 Archive Operations (Secondary Layer)

#### File 6: `B.java` → `ArchiveFileManager.java`
**Purpose:** ZIP/RAR/7Z archive handling (2,134 lines)

**Issues to Fix:**
1. Lines 802-1277: Method `D()` has decompilation corruption (bytecode offset errors)
2. Complex try/catch/finally nesting with unreachable code
3. Variable reuse with confusing types

**Cleanup Approach:**
```
1. Extract D() method logic from bytecode map (lines 805-1250)
2. Split into smaller methods:
   - writeEntry() - writes single file to archive
   - validateArchive() - checks integrity
   - updateArchiveMetadata() - updates timestamps/permissions
3. Replace label-based flow control with loops/conditions
4. Add comprehensive error handling
5. Document each operation
```

**Cleaned Structure:**
```java
public class ArchiveFileManager extends FileSystem {
    private File archiveFile;
    private boolean isWriteable = false;
    private ArchiveType archiveType;
    private FileSystemAccessor rootNode;

    /**
     * Write a file entry to the archive.
     * Handles all decompressed archive types uniformly.
     */
    public void writeFileToArchive(
            FileInfo source,
            String destinationPath,
            ArchiveFormat format,
            long timestamp,
            Long customModified,
            ProgressListener progress) throws ArchiveException, CancelledException {
        
        validateArchiveWriteable();
        validateSourceExists(source);
        
        try (InputStream input = source.openInputStream(0)) {
            ArchiveEntry entry = createArchiveEntry(destinationPath, format, timestamp);
            
            // For images: auto-generate thumbnail
            if (shouldGenerateThumbnail(source)) {
                writeImageWithThumbnail(entry, input, format);
            } else {
                writeDataEntry(entry, input, format, progress);
            }
            
            if (customModified != null && customModified > 0) {
                setEntryModificationTime(entry, customModified);
            }
            
            addEntryToArchive(entry);
            this.isModified = true;
        } catch (IOException e) {
            throw new ArchiveException("Failed to write archive entry", e);
        }
    }

    private void writeDataEntry(ArchiveEntry entry, InputStream input, 
                                 ArchiveFormat format, ProgressListener progress) 
            throws IOException, ArchiveException {
        try (OutputStream out = entry.openOutputStream()) {
            IOUtils.copyStream(input, out, format.getBufferSize(), progress);
        }
    }

    private void writeImageWithThumbnail(ArchiveEntry entry, InputStream input,
                                         ArchiveFormat format) throws IOException {
        // Load image
        Bitmap original = ImageUtils.loadBitmap(input, 512);
        if (original == null) {
            original = getDefaultPlaceholder();
        }
        
        // Write PNG to archive
        ByteArrayOutputStream pngBuffer = new ByteArrayOutputStream(32768);
        original.compress(Bitmap.CompressFormat.PNG, 0, pngBuffer);
        
        entry.write(pngBuffer.toByteArray());
    }
}
```

#### File 7: `G.java` → `DocumentFileOperations.java`
**Purpose:** Android DocumentFile + content provider bridge (2,414 lines)

**This is the LARGEST file - indicates complex logic.**

**Issues:**
1. Lines 274-682: Method `J()` has bytecode corruption (expression linking errors)
2. Lines 901-1451: Method `Q()` has bytecode corruption (expression linking errors)
3. Complex state management across multiple providers

**Cleanup Approach:**
```
1. Extract into separate classes by provider type:
   - ExternalStorageDocumentProvider
   - MtpDocumentProvider
   - CustomDocumentProvider
2. Use adapter/strategy pattern to unify interface
3. Fix bytecode corruption by re-implementing from patterns
4. Add comprehensive logging for debugging
```

---

### 2.3 Cloud Integrations (Tertiary Layer)

#### File 8: `A.java` → `CloudStorageProvider.java`
**Purpose:** Cloud storage abstraction (Dropbox, Google Drive, OneDrive, etc.)

**Cleanup:** Extract per-provider implementations from decompiled references.

---

## Part 3: Production-Grade Refactor Plan

### Phase 1: Foundation (Week 1-2)
**Goal:** Establish clean base abstractions

1. **Create Core Interfaces** (no dependencies)
   ```
   src/main/java/com/alphainventor/filemanager/
   ├── contract/
   │   ├── FileInfo.java           (cleaned from AbstractC3438n.java)
   │   ├── FileSystem.java         (cleaned from m.java)
   │   ├── FileSystemException.java
   │   └── FileMetadata.java
   ```

2. **Implement Local File System**
   ```
   ├── local/
   │   ├── LocalFileSystem.java
   │   ├── LocalFileInfo.java
   │   └── LocalFileSystemFactory.java
   ```

3. **Add Comprehensive Tests**
   ```
   src/test/java/com/alphainventor/filemanager/
   ├── contract/FileInfoTest.java
   ├── local/LocalFileSystemTest.java
   ```

### Phase 2: Remote Protocols (Week 3-4)
**Goal:** Implement SMB, SFTP, HTTP file systems

1. **SMB Implementation**
   ```
   ├── smb/
   │   ├── SmbFileSystem.java       (cleaned from N.java)
   │   ├── SmbFileInfo.java
   │   ├── SmbConnection.java
   │   └── SmbErrorMapper.java
   ```

2. **SFTP Implementation**
   ```
   ├── sftp/
   │   ├── SftpFileSystem.java      (cleaned from source)
   │   ├── SftpFileInfo.java        (cleaned from M.java)
   │   └── SftpSessionPool.java
   ```

3. **HTTP/FTP Implementation**
   ```
   ├── http/
   │   ├── HttpFileSystem.java      (cleaned from X.java)
   │   ├── HttpFileInfo.java
   │   └── HttpCacheManager.java
   ```

### Phase 3: Archive Support (Week 5-6)
**Goal:** Rebuild archive operations cleanly

1. **Archive Abstraction**
   ```
   ├── archive/
   │   ├── ArchiveFormat.java       (enum: ZIP, RAR, 7Z, TAR)
   │   ├── ArchiveFileSystem.java   (cleaned from B.java)
   │   ├── ArchiveEntry.java
   │   ├── ArchiveReader.java
   │   └── ArchiveWriter.java
   ```

2. **Format-Specific Implementations**
   ```
   ├── archive/zip/
   │   ├── ZipArchiveReader.java
   │   └── ZipArchiveWriter.java
   ├── archive/rar/
   │   └── RarArchiveReader.java
   ├── archive/sevenzip/
   │   └── SevenZipArchiveReader.java
   ```

### Phase 4: DocumentFile Bridge (Week 7-8)
**Goal:** Android DocumentFile provider integration

1. **DocumentFile Abstraction**
   ```
   ├── document/
   │   ├── DocumentFileSystem.java         (cleaned from G.java)
   │   ├── DocumentFileInfo.java
   │   ├── ExternalStorageProvider.java
   │   ├── MtpDocumentProvider.java
   │   └── DocumentProviderFactory.java
   ```

### Phase 5: Cloud Integration (Week 9-10)
**Goal:** Dropbox, Google Drive, OneDrive support

1. **Cloud Providers**
   ```
   ├── cloud/
   │   ├── CloudFileSystem.java            (cleaned from A.java)
   │   ├── dropbox/
   │   │   ├── DropboxFileSystem.java
   │   │   └── DropboxAuthManager.java
   │   ├── google/
   │   │   ├── GoogleDriveFileSystem.java
   │   │   └── GoogleAuthManager.java
   │   └── microsoft/
   │       ├── OneDriveFileSystem.java
   │       └── MicrosoftAuthManager.java
   ```

### Phase 6: UI Layer (Week 11-12)
**Goal:** Compose-based file explorer UI

1. **Screens & Composables**
   ```
   ├── ui/
   │   ├── screen/
   │   │   ├── FileExplorerScreen.kt
   │   │   ├── FileListScreen.kt
   │   │   ├── FileDetailScreen.kt
   │   │   └── FileOperationScreen.kt
   │   ├── component/
   │   │   ├── FileListItem.kt
   │   │   ├── BreadcrumbNavigation.kt
   │   │   ├── FileTypeIcon.kt
   │   │   └── ContextMenu.kt
   │   └── theme/
   │       ├── Color.kt
   │       └── Typography.kt
   ```

2. **ViewModel & State Management**
   ```
   ├── viewmodel/
   │   ├── FileExplorerViewModel.kt
   │   ├── FileOperationViewModel.kt
   │   └── FileSystemViewModel.kt
   ```

### Phase 7: Integration & Polish (Week 13-14)
**Goal:** Full system integration and testing

1. **Dependency Injection**
   ```
   ├── di/
   │   ├── AppModule.kt
   │   ├── FileSystemModule.kt
   │   └── RepositoryModule.kt
   ```

2. **Integration Tests**
   ```
   src/androidTest/java/com/alphainventor/filemanager/
   ├── integration/
   │   ├── FileExplorerIntegrationTest.kt
   │   ├── MultiProtocolTest.kt
   │   └── ArchiveOperationTest.kt
   ```

---

## Part 4: Quality Assurance Checklist

### Code Quality
- [ ] All classes have single responsibility
- [ ] All public methods have Javadoc
- [ ] All parameters annotated @Nullable/@NonNull
- [ ] No obfuscated names remain
- [ ] All error codes mapped to enums
- [ ] No hardcoded strings (use resources)
- [ ] No hardcoded resource IDs (use constants)

### Testing
- [ ] Unit tests for each FileSystem implementation (>80% coverage)
- [ ] Integration tests for cross-protocol operations
- [ ] Performance tests for large file operations
- [ ] Security tests for authentication/encryption
- [ ] UI tests for Compose screens

### Architecture
- [ ] Clear separation of concerns (contract → impl → ui)
- [ ] No circular dependencies
- [ ] All exceptions properly wrapped
- [ ] Logging at appropriate levels
- [ ] Resources properly managed (streams, connections)

### Documentation
- [ ] README with architecture overview
- [ ] API documentation for each package
- [ ] Examples for adding new file system
- [ ] Troubleshooting guide for common issues
- [ ] Contributing guidelines

---

## Part 5: Mapping Reference

### Decompiled → Production Names

```
DECOMPILED FILE          PRODUCTION CLASS              PURPOSE
─────────────────────────────────────────────────────────────────
AbstractC3438n.java  →   FileInfo (interface)          Base file contract
m.java               →   FileSystem (abstract)         FS provider contract
n.java (N.java)      →   SmbFileSystem                 SMB/CIFS protocol
m.java (M.java)      →   SftpFileInfo                  SFTP file wrapper
x.java (X.java)      →   HttpFileInfo                  HTTP file metadata
h.java (H.java)      →   TempLocationHelper            Temp file UI dialogs
B.java               →   ArchiveFileManager            ZIP/RAR operations (2.1K lines)
G.java               →   DocumentFileOperations        Android DocumentFile (2.4K lines)
A.java               →   CloudStorageProvider          Cloud integration

FILE                 PURPOSE
─────────────────────────────────────────────────────────────────
OneDriveFileHelper.java    OneDrive/SharePoint integration
DropboxFileHelper.java     Dropbox SDK wrapper
GoogleDriveFileHelper.java Google Drive SDK wrapper
```

### Error Code Mapping

```
SMB ERRORS (from N.java)
-1073741810 → FILE_NOT_FOUND
-1073741809 → DIRECTORY_NOT_EMPTY
-1073741773 → SHARING_VIOLATION
-1073741772 → INVALID_FILENAME
-1073741766 → DISK_FULL
-1073741757 → FILE_ALREADY_EXISTS
-1073741697 → NOT_A_DIRECTORY
-1073741612 → ACCESS_DENIED

HTTP/FTP ERRORS (from X.java)
1 → GENERIC_ERROR
(Check HTTP status codes and FTP reply codes)
```

---

## Part 6: Implementation Example

### Before (Decompiled B.java excerpt - 1,277 lines)
```java
// Lines 801-1277 of B.java - BROKEN bytecode
public void D(final n p0, final G p1, final String p2, final long p3, final Long p4, 
              final p p5, final boolean p6, final ax.u3.c p7, final i p8) 
        throws j, ax.b3.a {
    // ... 400+ lines of unreachable code with broken labels ...
    Label_0867: {
        if (ex == null) break Label_0867;
        final I l0 = ((ax.c3.a)ex).l0();
        Label_0854: {
            if (l0 == null) break Label_0854;
            // ... CORRUPT CONTROL FLOW ...
        }
    }
}
```

### After (Cleaned Implementation)
```java
public class ArchiveFileManager extends FileSystem {
    /**
     * Writes file content to archive with optional transformation.
     *
     * @param fileInfo      source file to archive
     * @param destinationPath   target path in archive
     * @param archiveEntry  pre-configured archive entry metadata
     * @param options       write options (compressed, encrypted, etc.)
     * @param progress      callback for progress updates
     * @throws ArchiveException if write fails
     * @throws CancelledException if operation cancelled
     */
    public void writeFileToArchive(
            @NonNull FileInfo fileInfo,
            @NonNull String destinationPath,
            @NonNull ArchiveEntry archiveEntry,
            @NonNull WriteOptions options,
            @Nullable ProgressListener progress) 
            throws ArchiveException, CancelledException {
        
        validateState();
        validateFileInfo(fileInfo);
        validatePath(destinationPath);
        
        try (InputStream input = fileInfo.openInputStream(0)) {
            if (shouldGenerateThumbnail(fileInfo)) {
                writeThumbnail(archiveEntry, input, options);
            } else {
                writeRawContent(archiveEntry, input, options, progress);
            }
            
            addToArchive(archiveEntry);
            markModified();
        } catch (IOException e) {
            throw new ArchiveException(
                "Failed to write file to archive: " + fileInfo.getPath(), e);
        }
    }

    private void writeRawContent(@NonNull ArchiveEntry entry,
                                 @NonNull InputStream input,
                                 @NonNull WriteOptions options,
                                 @Nullable ProgressListener progress) 
            throws IOException {
        try (OutputStream output = entry.openOutputStream()) {
            long totalBytes = entry.getUncompressedSize();
            byte[] buffer = new byte[options.getBufferSize()];
            long transferred = 0;
            int read;
            
            while ((read = input.read(buffer)) > 0) {
                output.write(buffer, 0, read);
                transferred += read;
                
                if (progress != null) {
                    progress.onProgress(transferred, totalBytes);
                }
            }
        }
    }

    private void writeThumbnail(@NonNull ArchiveEntry entry,
                                @NonNull InputStream input,
                                @NonNull WriteOptions options) 
            throws IOException {
        Bitmap original = ImageUtils.loadBitmap(input, 512);
        if (original == null) {
            original = ImageUtils.getPlaceholder();
        }
        
        ByteArrayOutputStream pngBuffer = new ByteArrayOutputStream(32768);
        original.compress(Bitmap.CompressFormat.PNG, 0, pngBuffer);
        entry.write(pngBuffer.toByteArray());
    }

    private void validateState() throws ArchiveException {
        if (!isOpen) {
            throw new ArchiveException("Archive is not open");
        }
        if (!isWriteable) {
            throw new ArchiveException("Archive is not writeable");
        }
    }
}
```

---

## Part 7: Next Steps

1. **Immediate (This Week)**
   - [ ] Review this guide with team
   - [ ] Set up clean package structure
   - [ ] Extract FileInfo interface
   - [ ] Write unit tests for FileInfo

2. **Short Term (Weeks 2-4)**
   - [ ] Implement LocalFileSystem
   - [ ] Implement SmbFileSystem
   - [ ] Add integration tests

3. **Medium Term (Weeks 5-8)**
   - [ ] Complete all protocol implementations
   - [ ] Archive support
   - [ ] DocumentFile bridge

4. **Long Term (Weeks 9+)**
   - [ ] Cloud integrations
   - [ ] UI layer with Compose
   - [ ] Full app integration
   - [ ] Production release

---

## References

- Decompiled Files: `decompiled_reference/file/*.java`
- Original Manifest: `app/src/main/AndroidManifest.xml`
- Build Config: `app/build.gradle.kts`
- Technologies:
  - Jetpack Compose (UI framework)
  - Android DocumentFile API
  - jCIFS (SMB protocol)
  - JSch (SFTP protocol)
  - OkHttp3 (HTTP client)
  - Room (local database)

---

**Document Version:** 1.0
**Status:** DRAFT - Ready for implementation
**Last Review:** 2026-10-05
