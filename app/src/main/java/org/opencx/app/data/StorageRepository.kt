package org.opencx.app.data

import android.content.Context
import android.os.Environment
import android.os.StatFs
import android.provider.MediaStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

data class VolumeInfo(val name: String, val path: File, val usedBytes: Long, val totalBytes: Long, val percent: Float)
data class CategoryUsage(val imagesBytes: Long = 0, val audioBytes: Long = 0, val videoBytes: Long = 0, val downloadsBytes: Long = 0)

object StorageRepository {
    fun getMainStorageVolume(): VolumeInfo {
        val root = Environment.getExternalStorageDirectory()
        val stat = StatFs(root.path)
        val total = stat.totalBytes
        val used = total - stat.availableBytes
        val pct = if (total > 0) (used.toFloat() / total.toFloat()) else 0f
        return VolumeInfo("Main storage", root, used, total, pct)
    }

    fun getSdCardVolume(): VolumeInfo? {
        val sd = File("/storage").listFiles()?.firstOrNull { it.name !in listOf("emulated", "self") && it.canRead() }
        return sd?.let {
            val stat = StatFs(it.path)
            val total = stat.totalBytes
            val used = total - stat.availableBytes
            val pct = if (total > 0) (used.toFloat() / total.toFloat()) else 0f
            VolumeInfo("SD card", it, used, total, pct)
        }
    }

    suspend fun queryCategoryUsage(context: Context): CategoryUsage = withContext(Dispatchers.IO) {
        fun querySize(uri: android.net.Uri): Long {
            var sum = 0L
            val proj = arrayOf(MediaStore.MediaColumns.SIZE)
            context.contentResolver.query(uri, proj, null, null, null)?.use { c ->
                val col = c.getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE)
                while (c.moveToNext()) { sum += c.getLong(col) }
            }
            return sum
        }
        val dlDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val dlSize = dlDir.listFiles()?.filter { it.isFile }?.sumOf { it.length() } ?: 0L
        CategoryUsage(
            querySize(MediaStore.Images.Media.EXTERNAL_CONTENT_URI),
            querySize(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI),
            querySize(MediaStore.Video.Media.EXTERNAL_CONTENT_URI),
            dlSize
        )
    }

    fun formatSize(bytes: Long): String {
        val gb = bytes / (1024.0 * 1024.0 * 1024.0)
        val mb = bytes / (1024.0 * 1024.0)
        val kb = bytes / 1024.0
        return when {
            gb >= 1.0 -> String.format("%.2f GB", gb)
            mb >= 1.0 -> String.format("%.1f MB", mb)
            kb >= 1.0 -> String.format("%.1f KB", kb)
            else -> "$bytes B"
        }
    }
}
