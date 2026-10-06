package org.opencx.app.data

import android.content.Context
import android.os.Environment
import android.os.StatFs
import android.provider.MediaStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.security.MessageDigest

data class Volume(val label: String, val path: File, val used: Long, val total: Long, val pct: Float)
data class MediaUsage(val img: Long = 0, val audio: Long = 0, val video: Long = 0, val docs: Long = 0)

object StorageEngine {
    fun queryVolumes(): List<Volume> {
        val list = mutableListOf<Volume>()
        val ext = Environment.getExternalStorageDirectory()
        val stat = StatFs(ext.path)
        val u = stat.totalBytes - stat.availableBytes
        val p = if (stat.totalBytes > 0) u.toFloat() / stat.totalBytes else 0f
        list.add(Volume("Main storage", ext, u, stat.totalBytes, p))

        File("/storage").listFiles()?.filter { it.name !in listOf("emulated", "self") && it.canRead() }?.forEach {
            val s = StatFs(it.path)
            val su = s.totalBytes - s.availableBytes
            val sp = if (s.totalBytes > 0) su.toFloat() / s.totalBytes else 0f
            list.add(Volume(it.name, it, su, s.totalBytes, sp))
        }
        return list
    }

    suspend fun queryMediaUsage(ctx: Context): MediaUsage = withContext(Dispatchers.IO) {
        fun size(uri: android.net.Uri): Long {
            var sum = 0L
            ctx.contentResolver.query(uri, arrayOf(MediaStore.MediaColumns.SIZE), null, null, null)?.use {
                val idx = it.getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE)
                while (it.moveToNext()) sum += it.getLong(idx)
            }
            return sum
        }
        MediaUsage(
            img = size(MediaStore.Images.Media.EXTERNAL_CONTENT_URI),
            audio = size(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI),
            video = size(MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
        )
    }

    suspend fun calculateSha256(file: File): String = withContext(Dispatchers.IO) {
        val digest = MessageDigest.getInstance("SHA-256")
        FileInputStream(file).use { fis ->
            val buf = ByteArray(8192)
            var n: Int
            while (fis.read(buf).also { n = it } > 0) digest.update(buf, 0, n)
        }
        digest.digest().joinToString("") { "%02x".format(it) }
    }

    fun humanSize(bytes: Long, binary: Boolean = false): String {
        val unit = if (binary) 1024.0 else 1000.0
        val kb = bytes / unit
        val mb = kb / unit
        val gb = mb / unit
        return when {
            gb >= 1.0 -> String.format("%.2f %s", gb, if (binary) "GiB" else "GB")
            mb >= 1.0 -> String.format("%.1f %s", mb, if (binary) "MiB" else "MB")
            kb >= 1.0 -> String.format("%.1f %s", kb, if (binary) "KiB" else "KB")
            else -> "$bytes B"
        }
    }
}
