package com.alphainventor.filemanager.activity;

import android.app.Activity;
import ax.c3.u;
import android.content.res.AssetFileDescriptor;
import ax.t3.j;
import java.io.InputStream;
import ax.c3.F;
import android.content.res.AssetFileDescriptor$AutoCloseInputStream;
import java.util.Scanner;
import ax.u3.q$e;
import ax.u3.q;
import android.net.Uri;
import android.content.Intent;
import android.widget.Toast;
import android.content.Context;
import ax.Q2.b;
import android.os.Bundle;
import android.view.View;
import ax.n.c;

public class MSURLLauncherActivity extends c
{
    View a;
    
    protected void onCreate(final Bundle bundle) {
        b.f((Context)this, true);
        super.onCreate(bundle);
        this.setContentView(2131558439);
        this.a = this.findViewById(2131362712);
        final Intent intent = ((Activity)this).getIntent();
        final String action = intent.getAction();
        final Uri data = intent.getData();
        if ("android.intent.action.VIEW".equals((Object)action) && data != null) {
            new a((Context)this, data).h((Object[])new String[0]);
            return;
        }
        Toast.makeText((Context)this, 2131951927, 1).show();
        ((Activity)this).finish();
    }
    
    class a extends q<String, Void, String>
    {
        private Context h;
        private Uri i;
        private String j;
        final MSURLLauncherActivity k;
        
        a(final MSURLLauncherActivity k, final Context h, final Uri i) {
            this.k = k;
            super(q$e.e0);
            this.h = h;
            this.i = i;
        }
        
        private String y(String substring) {
            final String s = null;
            if (substring == null) {
                return null;
            }
            final Scanner scanner = new Scanner(substring);
            substring = s;
            while (scanner.hasNextLine()) {
                final String nextLine = scanner.nextLine();
                if (nextLine != null) {
                    if (nextLine.startsWith("InternetShortcut")) {
                        continue;
                    }
                    if (!nextLine.startsWith("URL=")) {
                        continue;
                    }
                    substring = nextLine.substring(4);
                }
            }
            scanner.close();
            return substring;
        }
        
        protected void r() {
            final View a = this.k.a;
            if (a != null) {
                a.setVisibility(0);
            }
        }
        
        protected String w(String... array) {
            final Uri i = this.i;
            array = null;
            if (i != null) {
                Label_0105: {
                    AssetFileDescriptor openAssetFileDescriptor = null;
                    AutoCloseable autoCloseable;
                    try {
                        openAssetFileDescriptor = this.h.getApplicationContext().getContentResolver().openAssetFileDescriptor(this.i, "r");
                        final String[] array2 = array = (String[])(Object)new AssetFileDescriptor$AutoCloseInputStream(openAssetFileDescriptor);
                        try {
                            try {
                                final Object j = F.j((InputStream)(Object)array2, 256, 10240L);
                                F.a((AutoCloseable)(Object)array2);
                                array = (String[])j;
                            }
                            finally {}
                        }
                        catch (final Exception openAssetFileDescriptor) {}
                    }
                    catch (final Exception openAssetFileDescriptor) {
                        autoCloseable = null;
                    }
                    finally {
                        break Label_0105;
                    }
                    if (ax.t3.j.o(this.h)) {
                        this.j = ((Throwable)openAssetFileDescriptor).getMessage();
                    }
                    F.a(autoCloseable);
                    return null;
                }
                F.a((AutoCloseable)(Object)array);
            }
            else {
                array = null;
            }
            if (array != null) {
                return this.y((String)(Object)array);
            }
            return null;
        }
        
        protected void x(String string) {
            final View a = this.k.a;
            if (a != null) {
                a.setVisibility(8);
            }
            if (string == null) {
                if (this.j != null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(this.h.getString(2131951934));
                    sb.append(":");
                    sb.append(this.j);
                    string = sb.toString();
                    Toast.makeText(this.h, (CharSequence)string, 1).show();
                }
                else {
                    Toast.makeText(this.h, 2131951934, 1).show();
                }
            }
            else {
                try {
                    u.o0((Context)this.k, u.n(Uri.parse(string), (String)null, true, false));
                }
                catch (final Exception ex) {
                    Toast.makeText(this.h, 2131951927, 1).show();
                }
            }
            ((Activity)this.k).finish();
        }
    }
}
