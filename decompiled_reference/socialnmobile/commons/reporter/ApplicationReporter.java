package com.socialnmobile.commons.reporter;

import android.content.Context;

/**
 * Neutralized dummy stub: Disables telemetry reporting across the app.
 */
public class ApplicationReporter {
    public static void init(Context context) {
        // No-op
    }

    public static void reportException(Throwable t) {
        // No-op
    }

    public static void logEvent(String event, Object... args) {
        // No-op
    }
}
