package com.alphainventor.filemanager.bookmark;

import ax.c3.d0;
import ax.c3.A;
import android.graphics.drawable.Drawable;
import ax.r8.m;
import ax.r8.g;
import ax.r8.h;
import android.text.TextUtils;
import ax.Z2.s;
import ax.c3.x;
import android.database.Cursor;
import ax.Z2.k;
import android.net.Uri;
import ax.U2.d;
import android.content.Context;
import ax.r8.o;
import ax.r8.i;
import ax.r8.p;
import java.lang.reflect.Type;
import ax.r8.q;
import com.google.gson.a;
import java.util.List;
import ax.Q2.f;
import ax.s8.c;
import ax.c3.K;
import java.io.Serializable;

public class Bookmark implements Serializable
{
    private transient K c0;
    @c("type")
    private int d0;
    @c("name")
    private String e0;
    @c("location_key")
    private final int f0;
    @c("path")
    private String g0;
    @c("file_id")
    private final String h0;
    @c("is_dir")
    private final boolean i0;
    @c("location")
    private f j0;
    @c("time_millis")
    private long k0;
    private transient long q;
    
    private Bookmark(final int d0, final String e0, final K c0, final String g0, final String h0, final boolean i0, final long k0) {
        this.d0 = d0;
        this.e0 = e0;
        this.c0 = c0;
        this.j0 = c0.d();
        this.f0 = c0.b();
        this.g0 = g0;
        this.h0 = h0;
        this.i0 = i0;
        this.k0 = k0;
    }
    
    public static String J(final List<Bookmark> list) {
        return new a().d((Type)f.class, (Object)new q<f>() {
            public i b(final f f, final Type type, final p p3) {
                return (i)new o(f.I());
            }
        }).b().t((Object)list);
    }
    
    public static Bookmark a(final Context context) {
        final K u = d.u(context);
        return b(5, u.f(context), u, d.F(context).v().getAbsolutePath(), null, true, -1L);
    }
    
    private static Bookmark b(final int n, final String s, final K k, final String s2, final String s3, final boolean b, final long n2) {
        return new Bookmark(n, s, k, s2, s3, b, n2);
    }
    
    public static Bookmark c(final Context context, final Uri uri) {
        Label_0044: {
            if (uri.getScheme() == null || uri.getHost() == null) {
                break Label_0044;
            }
            if (uri.getPath() == null) {
                break Label_0044;
            }
            try {
                final k a = k.a(uri);
                return d(context, a.d(), a.e());
                return null;
            }
            catch (final IllegalArgumentException ex) {
                return null;
            }
        }
    }
    
    public static Bookmark d(final Context context, final K k, final String s) {
        return b(5, k.f(context), k, s, null, true, -1L);
    }
    
    public static Bookmark e(final Cursor cursor) {
        final Bookmark b = b(cursor.getInt(cursor.getColumnIndex("type")), cursor.getString(cursor.getColumnIndex("display_name")), K.a(f.p(cursor.getString(cursor.getColumnIndex("location_name"))), cursor.getInt(cursor.getColumnIndex("location_key"))), cursor.getString(cursor.getColumnIndex("path")), cursor.getString(cursor.getColumnIndex("file_id")), cursor.getInt(cursor.getColumnIndex("is_directory")) != 0, cursor.getLong(cursor.getColumnIndex("timestamp")));
        b.E(cursor.getLong(cursor.getColumnIndex("_id")));
        return b;
    }
    
    public static Bookmark f(final Bookmark bookmark) {
        return b(bookmark.d0, bookmark.e0, bookmark.u(), bookmark.g0, bookmark.h0, bookmark.i0, bookmark.y());
    }
    
    public static Bookmark g(final Context context, final String s) {
        return d(context, x.g(s).T(), s);
    }
    
    public static Bookmark h(final String s, final K k, final String s2, final String s3, final boolean b) {
        return new Bookmark(2, s, k, s2, s3, b, System.currentTimeMillis());
    }
    
    public static Bookmark i(final Context context, final K k, final String s) {
        return b(5, k.f(context), k, s, null, true, System.currentTimeMillis());
    }
    
    public static Bookmark j(final K k, final String s, final String s2, final boolean b, final long n) {
        return new Bookmark(3, null, k, s, s2, b, n);
    }
    
    public static Bookmark k(final Bookmark bookmark) {
        final Bookmark f = f(bookmark);
        f.I(4);
        if (bookmark.y() != -5L) {
            f.H(System.currentTimeMillis());
        }
        return f;
    }
    
    public static Bookmark l(final Context context, final f f) {
        return n(context, K.a(f, 0));
    }
    
    public static Bookmark m(final Context context, final f f, final int n) {
        return n(context, K.a(f, n));
    }
    
    public static Bookmark n(final Context context, final K k) {
        return new Bookmark(1, k.f(context), k, k.e(), null, true, -1L);
    }
    
    public static Bookmark o(final s s) {
        final K e = s.e();
        String s2;
        if (TextUtils.isEmpty((CharSequence)s.d())) {
            final com.alphainventor.filemanager.file.o e2 = x.e(e);
            if (e2.a() && e2.w() != null) {
                s2 = e2.w();
            }
            else {
                s2 = e.e();
            }
        }
        else {
            s2 = s.d();
        }
        return new Bookmark(1, s.f(), e, s2, s2, true, -1L);
    }
    
    public static List<Bookmark> p(final String s) {
        try {
            return (List<Bookmark>)new a().d((Type)f.class, (Object)new h<f>() {
                public f b(final i i, final Type type, final g g) throws m {
                    return f.p(i.k());
                }
            }).b().l(s, new ax.x8.a<List<Bookmark>>() {}.d());
        }
        catch (final Exception ex) {
            ax.Ha.c.h().b("GSON TYPE TOKEN").l((Throwable)ex).h();
            return null;
        }
    }
    
    public boolean A() {
        return this.i0;
    }
    
    public boolean B(final f f, final int n) {
        return this.s() == f && this.t() == n;
    }
    
    public boolean C(final Bookmark bookmark) {
        return bookmark != null && (this.s() == bookmark.s() && this.t() == bookmark.t());
    }
    
    public boolean D(final Bookmark bookmark) {
        return bookmark != null && (this.C(bookmark) && bookmark.w().equals((Object)this.w()));
    }
    
    public void E(final long q) {
        this.q = q;
    }
    
    public void F(final String e0) {
        this.e0 = e0;
    }
    
    public void G(final String g0) {
        this.g0 = g0;
    }
    
    public void H(final long k0) {
        this.k0 = k0;
    }
    
    public void I(final int d0) {
        this.d0 = d0;
    }
    
    public String q() {
        return this.h0;
    }
    
    public Drawable r(final Context context) {
        if (this.A()) {
            return ax.s3.a.c(context, 2131231319);
        }
        return A.f(context, this.w(), true);
    }
    
    public f s() {
        return this.j0;
    }
    
    public int t() {
        return this.f0;
    }
    
    public K u() {
        if (this.c0 == null) {
            this.c0 = K.a(this.j0, this.f0);
        }
        return this.c0;
    }
    
    public String v() {
        return this.e0;
    }
    
    public String w() {
        return this.g0;
    }
    
    public String x() {
        if (this.g0 == null) {
            return null;
        }
        return ax.c3.d0.v(this.u(), this.g0, Boolean.valueOf(this.i0));
    }
    
    public long y() {
        return this.k0;
    }
    
    public int z() {
        return this.d0;
    }
}
