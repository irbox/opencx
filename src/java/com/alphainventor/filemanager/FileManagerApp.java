package com.alphainventor.filemanager;

import ax.Ha.c;
import ax.Q2.b;
import ax.Q2.d;
import androidx.work.a$b;
import androidx.work.a;
import android.util.Log;
import android.content.Context;
import androidx.work.a$c;
import android.app.Application;

public class FileManagerApp extends Application implements a$c
{
    public FileManagerApp() {
        ApplicationReporter.init(null);
    }
    
    public static void b(final String s) {
        Log.e("FileManager", s);
    }
    
    public a a() {
        final a$b a$b = new a$b();
        a$b.c(5000, 7000);
        a$b.b((ax.b0.a)new ax.b0.a<Throwable>(this) {
            final FileManagerApp a;
            
            public void a(final Throwable t) {
                d.c("work manager init", t);
            }
        });
        a$b.d((ax.b0.a)new ax.b0.a<Throwable>(this) {
            final FileManagerApp a;
            
            public void a(final Throwable t) {
                d.c("work manager scheduleing", t);
            }
        });
        return a$b.a();
    }
    
    protected void attachBaseContext(final Context context) {
        super.attachBaseContext(context);
    }
    
    public void onCreate() {
        super.onCreate();
        b.k((Context)this);
        if (b.i()) {
            c.h().d("ApplicationHolder Alrady Initialized").h();
        }
        ax.Q2.c.a();
    }
}
