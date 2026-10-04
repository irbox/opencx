package com.alphainventor.filemanager.activity;

import android.app.Activity;
import ax.b3.s;
import ax.U2.d;
import ax.c3.x;
import ax.c3.k;
import ax.t3.j;
import java.io.OutputStream;
import java.io.InputStream;
import ax.c3.F;
import java.io.FileOutputStream;
import android.content.res.AssetFileDescriptor$AutoCloseInputStream;
import java.io.File;
import ax.Z2.a;
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

public class SplitApkInstallerActivity extends c
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
    
    class a extends q<String, Void, Boolean>
    {
        private Context h;
        private Uri i;
        private String j;
        final SplitApkInstallerActivity k;
        
        a(final SplitApkInstallerActivity k, final Context h, final Uri i) {
            this.k = k;
            super(q$e.e0);
            this.h = h;
            this.i = i;
        }
        
        protected void r() {
            final View a = this.k.a;
            if (a != null) {
                a.setVisibility(0);
            }
        }
        
        protected Boolean w(final String... array) {
            final File m = ax.Z2.a.m(this.h, "apks-tmp");
            final StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.i.hashCode()));
            sb.append(".spliatapk");
            final File file = new File(m, sb.toString());
            Label_0248: {
                if (this.i != null) {
                    Object o = null;
                    Object o2 = null;
                    AutoCloseable autoCloseable3 = null;
                    Label_0237: {
                        AutoCloseable autoCloseable;
                        try {
                            final AssetFileDescriptor$AutoCloseInputStream assetFileDescriptor$AutoCloseInputStream = new AssetFileDescriptor$AutoCloseInputStream(this.h.getApplicationContext().getContentResolver().openAssetFileDescriptor(this.i, "r"));
                            try {
                                final FileOutputStream fileOutputStream = (FileOutputStream)(o = new FileOutputStream(file));
                                try {
                                    try {
                                        F.b((InputStream)assetFileDescriptor$AutoCloseInputStream, (OutputStream)fileOutputStream);
                                        F.a((AutoCloseable)assetFileDescriptor$AutoCloseInputStream);
                                        F.a((AutoCloseable)fileOutputStream);
                                        break Label_0248;
                                    }
                                    finally {}
                                }
                                catch (final Exception ex) {}
                            }
                            catch (final Exception ex) {}
                            finally {
                                o = null;
                            }
                        }
                        catch (final Exception ex) {
                            o2 = null;
                            autoCloseable = null;
                        }
                        finally {
                            final AutoCloseable autoCloseable2 = null;
                            o2 = o;
                            autoCloseable3 = autoCloseable2;
                            break Label_0237;
                        }
                        if (ax.t3.j.o(this.h)) {
                            final Exception ex;
                            this.j = ((Throwable)ex).getMessage();
                        }
                        file.delete();
                        final Boolean false = Boolean.FALSE;
                        F.a((AutoCloseable)o2);
                        F.a(autoCloseable);
                        return false;
                    }
                    F.a((AutoCloseable)o2);
                    F.a(autoCloseable3);
                }
                try {
                    final k k = (k)x.f(file).z(file.getAbsolutePath());
                    try {
                        try {
                            final boolean o3 = d.O(this.h, k);
                            file.delete();
                            return o3;
                        }
                        finally {}
                    }
                    catch (final SecurityException ex2) {
                        if (((Throwable)ex2).getMessage() != null && ((Throwable)ex2).getMessage().contains((CharSequence)"FRP")) {
                            this.j = ((Throwable)ex2).getMessage();
                        }
                        final Boolean false2 = Boolean.FALSE;
                        file.delete();
                        return false2;
                    }
                    catch (final ax.b3.j j) {
                        final ax.b3.j i;
                        if (i instanceof s) {
                            this.j = ((Context)this.k).getString(2131951952);
                        }
                        final Boolean false3 = Boolean.FALSE;
                        file.delete();
                        return false3;
                    }
                    file.delete();
                }
                catch (final ax.b3.j l) {
                    if (ax.t3.j.o(this.h)) {
                        this.j = ((Throwable)l).getMessage();
                    }
                    return Boolean.FALSE;
                }
            }
        }
        
        protected void x(final Boolean b) {
            final View a = this.k.a;
            if (a != null) {
                a.setVisibility(8);
            }
            if (b == null || !b) {
                if (this.j != null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(this.h.getString(2131951927));
                    sb.append(":");
                    sb.append(this.j);
                    Toast.makeText(this.h, (CharSequence)sb.toString(), 1).show();
                }
                else {
                    Toast.makeText(this.h, 2131951927, 1).show();
                }
            }
            ((Activity)this.k).finish();
        }
    }
}
