package com.alphainventor.filemanager.contract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Callback for tracking progress of long-running operations.
 */
public interface ProgressListener {
    /**
     * Called when progress is updated.
     *
     * @param current bytes or items completed
     * @param total total bytes or items
     */
    void onProgress(long current, long total);

    /**
     * Called when operation starts.
     *
     * @param message status message
     */
    default void onStart(@Nullable String message) {
    }

    /**
     * Called when operation completes.
     */
    default void onComplete() {
    }

    /**
     * Called when operation is cancelled.
     */
    default void onCancelled() {
    }

    /**
     * Called when an error occurs.
     *
     * @param error exception that occurred
     */
    default void onError(@NonNull FileSystemException error) {
    }

    /**
     * Check if operation should be cancelled.
     *
     * @return true if operation should stop
     */
    default boolean isCancelled() {
        return false;
    }

    /**
     * Get progress percentage (0-100).
     */
    default int getPercentage(long current, long total) {
        if (total <= 0) return 0;
        return (int) ((current * 100) / total);
    }
}
