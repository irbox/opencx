package com.alphainventor.filemanager.contract;

import androidx.annotation.NonNull;

/**
 * Storage quota information for a file system.
 */
public class StorageQuota {
    private final long totalBytes;
    private final long usedBytes;
    private final long freeBytes;

    public StorageQuota(long totalBytes, long usedBytes, long freeBytes) {
        this.totalBytes = totalBytes;
        this.usedBytes = usedBytes;
        this.freeBytes = freeBytes;
    }

    /**
     * Get total storage capacity in bytes.
     */
    public long getTotalBytes() {
        return totalBytes;
    }

    /**
     * Get used storage in bytes.
     */
    public long getUsedBytes() {
        return usedBytes;
    }

    /**
     * Get free storage in bytes.
     */
    public long getFreeBytes() {
        return freeBytes;
    }

    /**
     * Get usage percentage (0-100).
     */
    public int getUsagePercentage() {
        if (totalBytes <= 0) return 0;
        return (int) ((usedBytes * 100) / totalBytes);
    }

    /**
     * Check if storage is low.
     */
    public boolean isLow(long thresholdBytes) {
        return freeBytes < thresholdBytes;
    }

    /**
     * Check if storage is full.
     */
    public boolean isFull() {
        return freeBytes <= 0;
    }

    @Override
    @NonNull
    public String toString() {
        return "StorageQuota{" +
                "total=" + formatBytes(totalBytes) +
                ", used=" + formatBytes(usedBytes) +
                ", free=" + formatBytes(freeBytes) +
                ", usage=" + getUsagePercentage() + "%" +
                '}';
    }

    private static String formatBytes(long bytes) {
        if (bytes <= 0) return "0 B";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int unitIndex = 0;
        double size = bytes;
        while (size >= 1024 && unitIndex < units.length - 1) {
            size /= 1024.0;
            unitIndex++;
        }
        return String.format("%.1f %s", size, units[unitIndex]);
    }
}
