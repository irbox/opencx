package com.alphainventor.filemanager.provider;

import java.io.IOException;
import ax.l3.c;
import com.alphainventor.filemanager.file.o;
import android.os.ProxyFileDescriptorCallback;
import android.os.storage.StorageManager;
import java.io.FileNotFoundException;
import ax.u3.B;
import ax.c3.x;
import android.os.ParcelFileDescriptor;
import ax.Z2.k;
import ax.b3.e;
import android.system.OsConstants;
import ax.b3.t;
import android.system.ErrnoException;
import ax.b3.j;
import ax.l3.b;
import android.os.Handler;
import android.content.Context;

public class a
{
    private Context a;
    private Handler b;
    private b c;
    
    a(final Context a) {
        this.a = a;
        this.c = new b();
        this.b = new Handler(this.c.b());
    }
    
    public static ErrnoException a(final j j, final String s) {
        String message = s;
        if (s == null) {
            message = ((Throwable)j).getMessage();
        }
        if (j instanceof t) {
            return new ErrnoException(message, OsConstants.ENOENT);
        }
        if (j instanceof e) {
            return new ErrnoException(message, OsConstants.EACCES);
        }
        return new ErrnoException(message, OsConstants.EIO);
    }
    
    public ParcelFileDescriptor b(final k k, final int n) throws IOException {
        final o e = x.e(k.d());
        if (!e.a() && (B.H() || !e.i(10000L))) {
            throw new FileNotFoundException("Network location is not connected");
        }
        return ax.l3.c.a((StorageManager)this.a.getSystemService("storage"), n, (ProxyFileDescriptorCallback)new ProxyFileDescriptorCallback(this, e, k, n) {
            private ax.l3.a a;
            private boolean b;
            final o c;
            final k d;
            final int e;
            final a f;
            
            private void a() throws ErrnoException {
                if (!this.b) {
                    try {
                        this.a = this.c.j0(this.d.e(), this.e);
                        this.b = true;
                    }
                    catch (final j j) {
                        throw com.alphainventor.filemanager.provider.a.a(j, null);
                    }
                }
            }
            
            public void onFsync() throws ErrnoException {
                this.a();
                this.a.a();
            }
            
            public long onGetSize() throws ErrnoException {
                this.a();
                return this.a.b();
            }
            
            public int onRead(final long n, final int n2, final byte[] array) throws ErrnoException {
                this.a();
                return this.a.c(n, array, 0, n2);
            }
            
            public void onRelease() {
                final ax.l3.a a = this.a;
                if (a != null) {
                    a.d();
                }
            }
            
            public int onWrite(final long n, final int n2, final byte[] array) throws ErrnoException {
                this.a();
                return (int)this.a.e(n, array, 0, n2);
            }
        }, this.b);
    }
}
