package org.opencx.app.data

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.webkit.MimeTypeMap
import androidx.core.content.FileProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

data class FileItem(
    val file: File,
    val name: String,
    val isDirectory: Boolean,
    val size: Long,
    val childCount: Int,
    val lastModified: Long
)

enum class SortMode { NAME_ASC, NAME_DESC, SIZE_ASC, SIZE_DESC, DATE_ASC, DATE_DESC }

object FileRepository {

    suspend fun getDirectoryContents(dir: File, sort: SortMode = SortMode.NAME_ASC): List<FileItem> = withContext(Dispatchers.IO) {
        val raw = dir.listFiles() ?: return@withContext emptyList()
        val items = raw.map { f ->
            FileItem(
                file = f,
                name = f.name,
                isDirectory = f.isDirectory,
                size = if (f.isFile) f.length() else 0L,
                childCount = if (f.isDirectory) (f.listFiles()?.size ?: 0) else 0,
                lastModified = f.lastModified()
            )
        }

        when (sort) {
            SortMode.NAME_ASC -> items.sortedWith(compareBy({ !it.isDirectory }, { it.name.lowercase() }))
            SortMode.NAME_DESC -> items.sortedWith(compareBy({ !it.isDirectory }, { it.name.lowercase() })).reversed()
            SortMode.SIZE_ASC -> items.sortedWith(compareBy({ !it.isDirectory }, { it.size }))
            SortMode.SIZE_DESC -> items.sortedWith(compareBy({ !it.isDirectory }, { -it.size }))
            SortMode.DATE_ASC -> items.sortedWith(compareBy({ !it.isDirectory }, { it.lastModified }))
            SortMode.DATE_DESC -> items.sortedWith(compareBy({ !it.isDirectory }, { -it.lastModified }))
        }
    }

    suspend fun deleteFiles(files: List<File>): Boolean = withContext(Dispatchers.IO) {
        var allDeleted = true
        files.forEach { file ->
            val ok = if (file.isDirectory) file.deleteRecursively() else file.delete()
            if (!ok) allDeleted = false
        }
        allDeleted
    }

    suspend fun createFolder(parent: File, folderName: String): Boolean = withContext(Dispatchers.IO) {
        val target = File(parent, folderName.trim())
        target.mkdirs()
    }

    fun openFile(context: Context, file: File) {
        try {
            val ext = file.extension.lowercase()
            val mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext) ?: "*/*"
            val uri: Uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, mime)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(Intent.createChooser(intent, "Open with"))
        } catch (_: Exception) {}
    }
}
