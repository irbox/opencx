package com.alphainventor.filemanager.service;

import ax.o3.b;
import android.os.IBinder;
import ax.Ha.c;
import android.content.Intent;
import java.io.File;
import com.alphainventor.filemanager.file.n;
import android.content.Context;
import java.util.logging.Logger;
import android.app.Service;

public class FileObserverService extends Service
{
    private static final Logger b;
    private String a;
    
    static {
        b = Logger.getLogger("FileManager.FileObserverService");
    }
    
    public static void a(final Context context, final n n, final File file) {
        try {
            final Intent intent = new Intent(context, (Class)FileObserverService.class);
            intent.putExtra("location_uri", n.Q());
            intent.putExtra("filepath", file.getAbsolutePath());
            context.startService(intent);
        }
        catch (final IllegalStateException ex) {
            c.h().f().b("CANNOT START FILE OBSERVER SERVICE").l((Throwable)ex).h();
        }
    }
    
    public static void b(final Context context) {
        try {
            context.stopService(new Intent(context, (Class)FileObserverService.class));
        }
        catch (final RuntimeException ex) {
            c.h().f().b("FILE OBSERVER SERVICE STOP ERROR").h();
        }
    }
    
    public IBinder onBind(final Intent intent) {
        return null;
    }
    
    public void onDestroy() {
        super.onDestroy();
    }
    
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        if (intent == null) {
            this.stopSelf();
            return 2;
        }
        final String stringExtra = intent.getStringExtra("filepath");
        final String stringExtra2 = intent.getStringExtra("location_uri");
        if (stringExtra == null || stringExtra2 == null) {
            this.stopSelf();
            return 2;
        }
        if (!new File(stringExtra).exists()) {
            this.stopSelf();
            return 2;
        }
        this.a = stringExtra2;
        ax.o3.b.j().e(stringExtra, stringExtra2);
        return 2;
    }
}
