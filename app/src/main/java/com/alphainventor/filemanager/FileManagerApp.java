package com.alphainventor.filemanager;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.Configuration;

public class FileManagerApp extends Application implements Configuration.Provider {
    private static final String TAG = "FileManager";

    public FileManagerApp() {
        super();
    }

    public static void b(final String s) {
        Log.e(TAG, s);
    }

    @NonNull
    @Override
    public Configuration getWorkManagerConfiguration() {
        return new Configuration.Builder()
                .setMinimumLoggingLevel(Log.INFO)
                .setInitializationExceptionHandler(throwable -> 
                    Log.e(TAG, "WorkManager initialization failed", throwable)
                )
                .setSchedulingExceptionHandler(throwable -> 
                    Log.e(TAG, "WorkManager scheduling failed", throwable)
                )
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
