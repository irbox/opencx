# OpenCX File Explorer - Architecture Overview

## System Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                    UI Layer (Jetpack Compose)               │
│  ┌──────────────┐ ┌──────────────┐ ┌──────────────┐        │
│  │ FileExplorer │ │ FileDetail   │ │ FileOperation│        │
│  │    Screen    │ │    Screen    │ │   Screen     │        │
│  └──────────────┘ └──────────────┘ └──────────────┘        │
└────────────────────┬────────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────────┐
│          ViewModel Layer (MVVM State Management)            │
│  ┌──────────────────────────────────────────────────┐       │
│  │  FileExplorerViewModel                            │       │
│  │  - Manages navigation state                        │       │
│  │  - Coordinates file operations                     │       │
│  │  - Handles error recovery                          │       │
│  └──────────────────────────────────────────────────┘       │
└────────────────────┬────────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────────┐
│        Repository/UseCase Layer (Business Logic)            │
│  ┌──────────────┐ ┌──────────────┐ ┌──────────────┐        │
│  │ FileOps      │ │ SearchOps    │ │ ArchiveOps   │        │
│  │ Repository   │ │ Repository   │ │ Repository   │        │
│  └──────────────┘ └──────────────┘ └──────────────┘        │
└────────────────────┬────────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────────┐
│     Abstraction Layer (FileSystem Contracts)                │
│  ┌────────────────────────────────────────────────┐         │
│  │  interface FileSystem                           │         │
│  │  interface FileInfo                             │         │
│  │  interface FileSystemException                  │         │
│  └────────────────────────────────────────────────┘         │
└────────────────────┬────────────────────────────────────────┘
                     │
   ┌─────────────────┼─────────────────┬───────────────────┐
   │                 │                 │                   │
┌──▼──────┐ ┌──────▼──────┐ ┌───────▼────┐ ┌──────────▼──┐
│  Local  │ │  Remote     │ │  Archive   │ │  Document  │
│   FS    │ │   FS        │ │   FS       │ │    File    │
│         │ │ ┌────┐┌───┐ │ │ ┌────┐    │ │   API      │
│┌───────┐│ │ │SMB ││FTP│ │ │ │ZIP │    │ │┌─────────┐ │
││Local  ││ │ └────┘└───┘ │ │ │RAR │    │ ││External │ │
││File   ││ │ ┌────┐┌───┐ │ │ │7Z  │    │ ││Storage  │ │
││Info   ││ │ │HTTP││SSH│ │ │ └────┘    │ │└─────────┘ │
│└───────┘│ │ └────┘└───┘ │ │          │ │┌─────────┐ │
│         │ │              │ │ ┌──────┐ │ ││MTP      │ │
│         │ │ ┌──────────┐ │ │ │TAR   │ │ │└─────────┘ │
│         │ │ │Cloud     │ │ │ └──────┘ │ │            │
│         │ │ │Providers │ │ │          │ │ (SAF)      │
│         │ │ └──────────┘ │ │          │ │            │
│         │ │              │ │          │ │            │
│         │ └──────────────┘ └──────────┘ └────────────┘
│         │       │               │            │
│         │   ┌───┴───────────┐   │            │
│         │   │               │   │            │
└────────┴───┴───────────────┴───┴────────────┘
          │
┌─────────▼─────────────────────────────────┐
│   Native Libraries & System APIs           │
│  ┌───┐ ┌────┐ ┌────┐ ┌────────┐ ┌────┐  │
│  │jCIFS  │JSch │OkHttp│Android │libc│  │
│  │(SMB) │(SFTP)       │APIs    │FS  │  │
│  └───┘ └────┘ └────┘ └────────┘ └────┘  │
└─────────────────────────────────────────┘
```

## Package Organization

```
com.alphainventor.filemanager/
├── contract/                  # Core abstractions (protocol-agnostic)
│   ├── FileInfo.java          # File metadata contract
│   ├── FileSystem.java        # File system provider contract
│   ├── FileSystemException.java
│   └── FileMetadata.java
│
├── local/                     # Local file system
│   ├── LocalFileSystem.java
│   ├── LocalFileInfo.java
│   └── LocalFileSystemFactory.java
│
├── remote/                    # Remote protocols
│   ├── smb/                   # SMB/CIFS
│   │   ├── SmbFileSystem.java
│   │   ├── SmbFileInfo.java
│   │   └── SmbConnection.java
│   ├── sftp/                  # SFTP/SSH
│   │   ├── SftpFileSystem.java
│   │   ├── SftpFileInfo.java
│   │   └── SftpSessionPool.java
│   ├── ftp/                   # FTP/FTPS
│   │   ├── FtpFileSystem.java
│   │   └── FtpFileInfo.java
│   └── http/                  # HTTP/HTTPS
│       ├── HttpFileSystem.java
│       └── HttpFileInfo.java
│
├── archive/                   # Archive handling
│   ├── ArchiveFormat.java     # Enum: ZIP, RAR, 7Z, TAR
│   ├── ArchiveFileSystem.java # Archive provider
│   ├── ArchiveEntry.java
│   ├── zip/
│   │   ├── ZipArchiveReader.java
│   │   └── ZipArchiveWriter.java
│   ├── rar/
│   │   └── RarArchiveReader.java
│   └── sevenzip/
│       └── SevenZipArchiveReader.java
│
├── document/                  # Android DocumentFile bridge
│   ├── DocumentFileSystem.java
│   ├── DocumentFileInfo.java
│   ├── ExternalStorageProvider.java
│   ├── MtpDocumentProvider.java
│   └── DocumentProviderFactory.java
│
├── cloud/                     # Cloud storage
│   ├── CloudFileSystem.java
│   ├── dropbox/
│   │   ├── DropboxFileSystem.java
│   │   └── DropboxAuthManager.java
│   ├── google/
│   │   ├── GoogleDriveFileSystem.java
│   │   └── GoogleAuthManager.java
│   └── microsoft/
│       ├── OneDriveFileSystem.java
│       └── MicrosoftAuthManager.java
│
├── repository/                # Data layer / Use cases
│   ├── FileOperationsRepository.java
│   ├── FileSearchRepository.java
│   ├── ArchiveOperationsRepository.java
│   └── FileSystemFactory.java
│
├── viewmodel/                 # Presentation layer
│   ├── FileExplorerViewModel.kt
│   ├── FileDetailViewModel.kt
│   └── FileOperationViewModel.kt
│
├── ui/                        # Compose UI
│   ├── screen/
│   │   ├── FileExplorerScreen.kt
│   │   ├── FileDetailScreen.kt
│   │   └── FileOperationScreen.kt
│   ├── component/
│   │   ├── FileListItem.kt
│   │   ├── BreadcrumbNavigation.kt
│   │   ├── FileTypeIcon.kt
│   │   └── ContextMenu.kt
│   └── theme/
│       ├── Color.kt
│       ├── Typography.kt
│       └── Theme.kt
│
├── di/                        # Dependency Injection (Hilt)
│   ├── AppModule.kt
│   ├── FileSystemModule.kt
│   └── RepositoryModule.kt
│
├── util/                      # Utilities
│   ├── FileUtils.java
│   ├── PathNormalizer.java
│   ├── MimeTypeResolver.java
│   ├── PermissionChecker.java
│   └── ErrorMapper.java
│
└── MainActivity.kt            # Entry point
```

## Data Flow

### File Listing Operation
```
UI (FileExplorerScreen)
  ↓
ViewModel.listFiles(path)
  ↓
Repository.getFileSystem(path).listChildren(path)
  ↓
FileSystem Implementation (SMB, Local, Archive, etc.)
  ↓
File Info Objects (List<FileInfo>)
  ↓
UI Updates with ListState
```

### File Copy Operation
```
UI (FileOperationScreen)
  ↓
ViewModel.copyFile(source, destination, options, progress)
  ↓
Repository.getFileSystem(source).openInputStream(source)
Repository.getFileSystem(destination).openOutputStream(destination)
  ↓
IOUtils.copyStream(input, output, progress)
  ↓
UI Updates progress
  ↓
Completed callback
```

## Key Design Patterns

### 1. Strategy Pattern (File Systems)
Each protocol (SMB, SFTP, Local, Archive) implements the `FileSystem` interface.
The app selects the appropriate implementation based on the path.

### 2. Factory Pattern (File System Selection)
```java
FileSystem fileSystem = FileSystemFactory.get(path);
// Returns: LocalFileSystem, SmbFileSystem, ArchiveFileSystem, etc.
```

### 3. Adapter Pattern (DocumentFile Bridge)
`DocumentFileSystem` adapts Android's `DocumentFile` API to the common `FileSystem` interface.

### 4. Observer Pattern (Progress)
`ProgressListener` interface for file operation callbacks.

### 5. Repository Pattern
`FileOperationsRepository` coordinates file system operations and caching.

## Exception Hierarchy

```
FileSystemException (parent)
├── FileNotFoundException
├── PermissionDeniedException
├── DirectoryNotEmptyException
├── FileSharingViolationException
├── DiskFullException
├── NetworkException
│   ├── SmbException
│   ├── SftpException
│   └── HttpException
├── ArchiveException
│   ├── ArchiveCorruptedException
│   └── ArchiveEncryptedException
└── CancelledException
```

## Threading Model

- **UI Thread:** Compose rendering, state updates
- **IO Thread Pool:** File operations (via Dispatchers.IO)
- **Network Thread Pool:** Remote protocol operations
- **Archive Thread:** Compression/decompression (CPU-bound)

Using Kotlin Coroutines with appropriate dispatchers for each operation type.

## Security Considerations

1. **Permission Handling**
   - Runtime permissions for local storage
   - Scoped Storage compliance (Android 11+)
   - Shizuku privilege elevation for system files

2. **Credential Management**
   - Encrypted storage for SMB/SFTP/Cloud credentials
   - Session pooling to avoid re-authentication
   - Secure deletion of sensitive data from memory

3. **Input Validation**
   - Path normalization to prevent directory traversal
   - URL validation for HTTP operations
   - Archive content validation before extraction

4. **Network Security**
   - TLS 1.3 minimum for HTTPS
   - Certificate pinning for cloud APIs
   - Timeout configuration for network operations

## Performance Optimizations

1. **Caching**
   - File metadata cache (LRU, 1-minute TTL)
   - Thumbnail cache (disk-based)
   - Directory listing cache (path-based)

2. **Lazy Loading**
   - File children loaded on demand
   - Metadata fetched asynchronously
   - UI virtualization for large lists

3. **Batch Operations**
   - Combine multiple file operations
   - Use streaming for large files
   - Network connection pooling

## Testing Strategy

### Unit Tests (Contract Layer)
- FileSystem interface implementations
- Path normalization utilities
- Error mapping logic

### Integration Tests
- Local file system operations
- Mock remote protocol servers
- Archive operations with real files

### UI Tests
- Compose screen rendering
- Navigation flows
- State management correctness

### Performance Tests
- Large file operations (1GB+)
- Deep directory hierarchies (10K+ items)
- Concurrent operations

---

**Version:** 1.0
**Status:** DRAFT
**Last Updated:** 2026-10-05
