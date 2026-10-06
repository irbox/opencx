package org.opencx.app.data

import android.content.Context
import android.os.Environment
import android.os.StatFs
import android.provider.MediaStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

data class VolumeInfo(
    val name: String,
    val path: File,
    val usedBytes: Long,
    val totalBytes: Long,
    val percent: Float
)

data class CategoryUsage(
    val imagesBytes: Long = 0,
    val audioBytes: Long = 0,
    val videoBytes: Long = 0,
    val docsBytes: Long = 0,
    val downloadsBytes: Long = 0
)

object StorageRepository {

    fun getMainStorageVolume(): VolumeInfo {
        val root = Environment.getExternalStorageDirectory()
        val stat = StatFs(root.path)
        val total = stat.totalBytes
        val available = stat.availableBytes
        val used = total - available
        val pct = if (total > 0) (used.toFloat() / total.toFloat()) else 0f
        return VolumeInfo("Main storage", root, used, total, pct)
    }

    fun getSdCardVolume(): VolumeInfo? {
        val storageDir = File("/storage")
        val sdCard = storageDir.listFiles()?.firstOrNull { it.name != "emulated" && it.name != "self" && it.canRead() }
        return sdCard?.let { file ->
            val stat = StatFs(file.path)
            val total = stat.totalBytes
            val available = stat.availableBytes
            val used = total - available
            val pct = if (total > 0) (used.toFloat() / total.toFloat()) else 0f
            VolumeInfo("SD card", file, used, total, pct)
        }
    }

    suspend fun queryCategoryUsage(context: Context): CategoryUsage = withContext(Dispatchers.IO) {
        var images = 0L
        var audio = 0L
        var videos = 0L
        val proj = arrayOf(MediaStore.MediaColumns.SIZE)

        // Live Image Scan
        context.contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, proj, null, null, null)?.use { cursor ->
            val sizeCol = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE)
            while (cursor.moveToNext()) { images += cursor.getLong(sizeCol) }
        }

        // Live Audio Scan
        context.contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, proj, null, null, null)?.use { cursor ->
            val sizeCol = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE)
            while (cursor.moveToNext()) { audio += cursor.getLong(sizeCol) }
        }

        // Live Video Scan
        context.contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, proj, null, null, null)?.use { cursor ->
            val sizeCol = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE)
            while (cursor.moveToNext()) { videos += cursor.getLong(sizeCol) }
        }

        val dlDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val dlSize = dlDir.listFiles()?.filter { it.isFile }?.sumOf { it.length() } ?: 0L

        CategoryUsage(images, audio, videos, 0L, dlSize)
    }

    fun formatSize(bytes: Long): String {
        val kb = bytes / 1024.0
        val mb = kb / 1024.0
        val gb = mb / 1024.0
        return when {
            gb >= 1.0 -> String.format("%.2f GB", gb)
            mb >= 1.0 -> String.format("%.1f MB", mb)
            kb >= 1.0 -> String.format("%.1f KB", kb)
            else -> "$bytes B"
        }
    }
}
