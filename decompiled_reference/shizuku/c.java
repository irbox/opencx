package com.alphainventor.filemanager.shizuku;

import ax.X2.L;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor$AutoCloseOutputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.os.ParcelFileDescriptor$AutoCloseInputStream;
import java.io.InputStream;
import com.alphainventor.filemanager.file.n;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.ActivityNotFoundException;
import android.util.AndroidRuntimeException;
import ax.c3.u;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.ArrayList;
import com.alphainventor.filemanager.file.y;
import java.util.List;
import ax.c3.K;
import com.alphainventor.filemanager.file.x;
import ax.u3.B;
import ax.X2.Q;
import ax.Q2.d;
import ax.ne.i;
import ax.g3.g;
import android.os.IBinder;
import ax.p3.b;
import android.content.ComponentName;
import android.content.ServiceConnection;
import ax.ne.i$e;
import ax.ne.i$c;
import ax.ne.i$d;
import ax.ne.i$f;
import ax.Q2.i$a;
import android.content.Context;

public class c
{
    private static c m;
    private a a;
    private Context b;
    private Boolean c;
    private boolean d;
    private int e;
    private boolean f;
    private i$a g;
    private final i$f h;
    private final i$d i;
    private final i$c j;
    private final i$e k;
    private final ServiceConnection l;
    
    private c(final Context b) {
        this.d = false;
        this.e = 0;
        this.f = false;
        this.h = new i$f(new ComponentName("com.cxinventor.file.explorer", ShizukuUserService.class.getName())).c(false).g("service").d(false).h(278);
        this.i = (i$d)new b(this);
        this.j = (i$c)new ax.p3.c();
        this.k = (i$e)new i$e() {
            final c a;
            
            public void a(final int n, final int n2) {
                if (n2 == 0) {
                    this.a.k();
                }
                else if (this.a.g != null) {
                    this.a.g.c();
                    this.a.g = null;
                }
                this.a.f = false;
            }
        };
        this.l = (ServiceConnection)new ServiceConnection() {
            final c q;
            
            public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
                if (binder != null && binder.pingBinder()) {
                    this.q.J(com.alphainventor.filemanager.shizuku.a.a.r(binder));
                    if (this.q.g != null) {
                        this.q.g.b();
                        this.q.g = null;
                    }
                }
            }
            
            public void onServiceDisconnected(final ComponentName componentName) {
                this.q.n();
            }
        };
        this.b = b;
        ax.Q2.b.h().e((g)new g(this) {
            final c a;
            
            public void J(final String s) {
                this.a.c = null;
            }
        });
    }
    
    private boolean D() {
        return this.a != null;
    }
    
    private void J(final a a) {
        this.a = a;
    }
    
    private void K() {
        try {
            if (ax.ne.i.C() < 10) {
                return;
            }
            ax.ne.i.Q(this.h, this.l, true);
        }
        finally {
            final Throwable t;
            t.printStackTrace();
            t.toString();
        }
    }
    
    private void k() {
        try {
            ax.ne.i.y();
            try {
                if (ax.ne.i.C() >= 10) {
                    ax.ne.i.x(this.h, this.l);
                }
            }
            finally {
                final Throwable t;
                t.printStackTrace();
            }
        }
        catch (final RuntimeException ex) {}
    }
    
    private void n() {
        this.a = null;
    }
    
    public static c t() {
        if (c.m == null) {
            d.b((Throwable)new Exception("Shizuku not initialized"));
        }
        return c.m;
    }
    
    public static void z(final Context context) {
        if (c.m == null) {
            c.m = new c(context);
        }
    }
    
    public boolean A() {
        return this.f;
    }
    
    public boolean B() {
        boolean b = false;
        try {
            if (ax.ne.i.B() != -1) {
                b = true;
            }
            return b;
        }
        catch (final Exception ex) {
            return b;
        }
    }
    
    public boolean C() {
        if (!Q.F1()) {
            return false;
        }
        if (this.c == null) {
            this.c = B.L(this.b, "moe.shizuku.privileged.api");
        }
        return this.c;
    }
    
    public List<y> E(final x x, final K k, final String s) {
        Label_0088: {
            ArrayList list;
            try {
                final List<ax.p3.a> d1 = this.a.d1(s);
                if (d1 == null) {
                    return null;
                }
                list = new ArrayList();
                final Iterator iterator = d1.iterator();
                while (iterator.hasNext()) {
                    list.add((Object)new y(x, k, (ax.p3.a)iterator.next()));
                }
            }
            catch (final Exception ex) {
                break Label_0088;
            }
            return (List<y>)list;
        }
        final Exception ex;
        ((Throwable)ex).printStackTrace();
        return null;
    }
    
    public void F(final Fragment fragment) {
        if (fragment.b() != null) {
            final PackageManager packageManager = fragment.b().getPackageManager();
            Label_0058: {
                try {
                    final Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage("moe.shizuku.privileged.api");
                    if (launchIntentForPackage != null) {
                        u.p0(fragment, launchIntentForPackage);
                    }
                    return;
                }
                catch (final AndroidRuntimeException ex) {}
                catch (final NullPointerException ex) {}
                catch (final SecurityException ex) {}
                catch (final ActivityNotFoundException ex2) {
                    break Label_0058;
                }
                final AndroidRuntimeException ex;
                ((Throwable)ex).printStackTrace();
                return;
            }
            final ActivityNotFoundException ex2;
            ((Throwable)ex2).printStackTrace();
        }
    }
    
    public void G() {
        final int e = this.e - 1;
        this.e = e;
        if (e <= 0) {
            ax.ne.i.H(this.i);
            ax.ne.i.G(this.j);
            ax.ne.i.I(this.k);
            this.K();
        }
    }
    
    public boolean H(final String s, final String s2) {
        try {
            return this.a.X0(s, s2);
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    public boolean I(final String s, final long n) {
        try {
            return this.a.l0(s, n);
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    public void j() {
        if (this.e == 0) {
            ax.ne.i.r(this.i);
            ax.ne.i.o(this.j);
            ax.ne.i.t(this.k);
            this.k();
        }
        ++this.e;
    }
    
    public boolean l() {
        return this.C() && this.B() && this.D();
    }
    
    public boolean m(final i$a g) {
        this.f = false;
        if (!this.B()) {
            return false;
        }
        if (ax.ne.i.D()) {
            return false;
        }
        try {
            if (ax.ne.i.y() == 0) {
                return true;
            }
            if (ax.ne.i.P()) {
                return false;
            }
            this.g = g;
            ax.ne.i.J(65001);
            this.f = true;
            return false;
        }
        finally {
            return false;
        }
    }
    
    public boolean o(final String s) {
        try {
            return this.a.W1(s);
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    public boolean p(final String s) {
        try {
            return this.a.x1(s);
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    public boolean q(final String s) {
        try {
            return this.a.h(s);
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    public n r(final x x, final K k, final String s) {
        try {
            return (n)new y(x, k, this.a.z(s));
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    public InputStream s(final String s, final long n) throws IOException {
        try {
            final ParcelFileDescriptor$AutoCloseInputStream parcelFileDescriptor$AutoCloseInputStream = new ParcelFileDescriptor$AutoCloseInputStream(this.a.z0(s));
            if (n > 0L && ((InputStream)parcelFileDescriptor$AutoCloseInputStream).skip(n) != n) {
                throw new IOException("AutoCloseInputStream skip failed");
            }
            return (InputStream)parcelFileDescriptor$AutoCloseInputStream;
        }
        catch (final Exception ex) {
            throw new IOException((Throwable)ex);
        }
        catch (final IOException ex2) {
            throw ex2;
        }
        catch (final IllegalStateException ex3) {
            final com.alphainventor.filemanager.shizuku.b.c e = com.alphainventor.filemanager.shizuku.b.e(ex3);
            if (e == null) {
                throw new IOException((Throwable)ex3);
            }
            if (e.a == com.alphainventor.filemanager.shizuku.b.d) {
                throw new FileNotFoundException(e.b);
            }
            throw new IOException(e.b);
        }
    }
    
    public int u(final String s, final boolean b) {
        try {
            return this.a.K1(s, b);
        }
        catch (final Exception ex) {
            return -2;
        }
    }
    
    public OutputStream v(final String s, final boolean b) throws IOException {
        try {
            return (OutputStream)new ParcelFileDescriptor$AutoCloseOutputStream(this.a.G1(s, b));
        }
        catch (final Exception ex) {
            throw new IOException((Throwable)ex);
        }
        catch (final IllegalStateException ex2) {
            final com.alphainventor.filemanager.shizuku.b.c e = b.e(ex2);
            if (e != null) {
                throw new IOException(e.b);
            }
            throw new IOException((Throwable)ex2);
        }
    }
    
    public ParcelFileDescriptor w(final String s) throws IOException {
        try {
            return this.a.z0(s);
        }
        catch (final Exception ex) {
            throw new IOException((Throwable)ex);
        }
        catch (final IllegalStateException ex2) {
            final com.alphainventor.filemanager.shizuku.b.c e = com.alphainventor.filemanager.shizuku.b.e(ex2);
            if (e == null) {
                throw new IOException((Throwable)ex2);
            }
            if (e.a == com.alphainventor.filemanager.shizuku.b.d) {
                throw new FileNotFoundException(e.b);
            }
            throw new IOException(e.b);
        }
    }
    
    public ParcelFileDescriptor x(final String s) throws IOException {
        try {
            return this.a.w0(s);
        }
        catch (final Exception ex) {
            throw new IOException((Throwable)ex);
        }
        catch (final IllegalStateException ex2) {
            final com.alphainventor.filemanager.shizuku.b.c e = com.alphainventor.filemanager.shizuku.b.e(ex2);
            if (e != null) {
                throw new IOException(e.b);
            }
            throw new IOException((Throwable)ex2);
        }
    }
    
    public L y(final String s) throws IOException {
        try {
            final ax.p3.a l0 = this.a.L0(s);
            final L i = new L();
            i.e = l0.d0;
            i.b = l0.e0;
            i.a = l0.i0;
            i.c = l0.j0;
            return i;
        }
        catch (final Exception ex) {
            throw new IOException((Throwable)ex);
        }
    }
}
