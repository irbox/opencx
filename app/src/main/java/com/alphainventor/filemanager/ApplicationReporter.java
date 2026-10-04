package com.alphainventor.filemanager;

import ax.t3.g;
import ax.t3.j;
import ax.Ha.c;
import android.content.Context;
import androidx.annotation.Keep;
import com.socialnmobile.commons.reporter.ReporterService;

@Keep
public class ApplicationReporter implements ReporterService
{
    static final String EVENT_COLLECTOR_URL = "";
    static Context sAppContext;
    static c sReporter;
    
    private String getParentPackage(final String s) {
        final int lastIndex = s.lastIndexOf(".");
        if (lastIndex < 0) {
            return s;
        }
        return s.substring(0, lastIndex);
    }
    
    public static void init(Context context) {
        if (ApplicationReporter.sReporter == null) {
            new ApplicationReporter().initializeService();
            if (ax.Q2.c.a()) {
                if (!c.g()) {
                    throw new RuntimeException("SERVICE LOADER DOES NOT WORK!!!");
                }
            }
        }
        if (ApplicationReporter.sAppContext == null && context != null) {
            context = (ApplicationReporter.sAppContext = context.getApplicationContext());
            c.k(j.n(context));
        }
        final c sReporter = ApplicationReporter.sReporter;
        if (sReporter != null) {
            final Context sAppContext = ApplicationReporter.sAppContext;
            if (sAppContext != null) {
                sReporter.j(sAppContext);
            }
        }
        c.k(false);
    }
    
    public void initializeService() {
        final boolean d = g.d();
        String s = "2.7.8";
        if (d) {
            s = s;
            if (System.currentTimeMillis() > 0L) {
                s = "2.7.8-mod";
            }
        }
        (ApplicationReporter.sReporter = c.f("cxfileexplorer", 278, s, "cxfileApi21-release", "", false)).l("96SB");
    }
}
