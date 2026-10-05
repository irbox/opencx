package com.alphainventor.filemanager.ui

import android.content.Context
import android.os.Environment
import android.os.StatFs
import android.provider.MediaStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

data class StorageStats(
    val usedBytes: Long,
    val totalBytes: Long,
    val percent: Float,
    val imageBytes: Long = 0,
    val audioBytes: Long = 0,
    val videoBytes: Long = 0,
    val docBytes: Long = 0
)

object RealStorageEngine {

    fun getDeviceStorage(): StorageStats {
        val path = Environment.getExternalStorageDirectory()
        val stat = StatFs(path.path)
        val total = stat.totalBytes
        val free = stat.availableBytes
        val used = total - free
        val pct = if (total > 0) (used.toFloat() / total.toFloat()) else 0f
        return StorageStats(used, total, pct)
    }

    suspend fun queryCategorySizes(context: Context): Map<String, Long> = withContext(Dispatchers.IO) {
        val sizes = mutableMapOf("images" to 0L, "audio" to 0L, "videos" to 0L, "docs" to 0L)
        val projection = arrayOf(MediaStore.MediaColumns.SIZE)

        // Images
        context.contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, null)?.use { cursor ->
            val sizeCol = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE)
            var sum = 0L
            while (cursor.moveToNext()) { sum += cursor.getLong(sizeCol) }
            sizes["images"] = sum
        }

        // Audio
        context.contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection, null, null, null)?.use { cursor ->
            val sizeCol = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE)
            var sum = 0L
            while (cursor.moveToNext()) { sum += cursor.getLong(sizeCol) }
            sizes["audio"] = sum
        }

        // Videos
        context.contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, null)?.use { cursor ->
            val sizeCol = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE)
            var sum = 0L
            while (cursor.moveToNext()) { sum += cursor.getLong(sizeCol) }
            sizes["videos"] = sum
        }

        sizes
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
