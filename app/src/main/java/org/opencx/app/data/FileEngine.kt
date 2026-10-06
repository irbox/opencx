package org.opencx.app.data

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.webkit.MimeTypeMap
import androidx.core.content.FileProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

data class Entry(
    val file: File,
    val isDir: Boolean,
    val size: Long,
    val itemsCount: Int,
    val mtime: Long,
    val permissions: String
)

enum class SortKey { NAME, SIZE, DATE, TYPE }

object FileEngine {
    suspend fun list(dir: File, sortKey: SortKey = SortKey.NAME, desc: Boolean = false): List<Entry> = withContext(Dispatchers.IO) {
        val raw = dir.listFiles() ?: return@withContext emptyList()
        val mapped = raw.map { f ->
            val perms = buildString {
                append(if (f.canRead()) "r" else "-")
                append(if (f.canWrite()) "w" else "-")
                append(if (f.canExecute()) "x" else "-")
            }
            Entry(f, f.isDirectory, if (f.isFile) f.length() else 0L, if (f.isDirectory) (f.listFiles()?.size ?: 0) else 0, f.lastModified(), perms)
        }
        val comparator = when (sortKey) {
            SortKey.NAME -> compareBy<Entry> { !it.isDir }.thenBy { it.file.name.lowercase() }
            SortKey.SIZE -> compareBy<Entry> { !it.isDir }.thenBy { it.size }
            SortKey.DATE -> compareBy<Entry> { !it.isDir }.thenBy { it.mtime }
            SortKey.TYPE -> compareBy<Entry> { !it.isDir }.thenBy { it.file.extension.lowercase() }
        }
        if (desc) mapped.sortedWith(comparator).reversed() else mapped.sortedWith(comparator)
    }

    suspend fun delete(targets: List<File>): Boolean = withContext(Dispatchers.IO) {
        targets.all { if (it.isDirectory) it.deleteRecursively() else it.delete() }
    }

    suspend fun mkdir(parent: File, name: String): Boolean = withContext(Dispatchers.IO) {
        File(parent, name.trim()).mkdirs()
    }

    fun open(ctx: Context, file: File) {
        try {
            val ext = file.extension.lowercase()
            val mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext) ?: "*/*"
            val uri: Uri = FileProvider.getUriForFile(ctx, "${ctx.packageName}.fileprovider", file)
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, mime)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            ctx.startActivity(Intent.createChooser(intent, "Open with"))
        } catch (_: Exception) {}
    }
}
