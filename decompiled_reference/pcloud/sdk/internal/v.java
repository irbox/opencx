package com.pcloud.sdk.internal;

import j$.util.Objects;
import ax.la.a;
import ax.la.c;
import okhttp3.Dispatcher;
import okhttp3.ConnectionPool;
import java.util.concurrent.Executor;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import ax.la.a$a;

class v implements a$a
{
    private static final HttpUrl k;
    private Cache a;
    private Executor b;
    private ConnectionPool c;
    private Dispatcher d;
    private int e;
    private int f;
    private int g;
    private long h;
    private c i;
    private HttpUrl j;
    
    static {
        k = HttpUrl.parse("https://api.pcloud.com");
    }
    
    v() {
        this.j = v.k;
    }
    
    public a a() {
        return (a)new u(this);
    }
    
    public a$a b(final c i) {
        this.i = i;
        return (a$a)this;
    }
    
    public a$a c(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(s);
        final HttpUrl parse = HttpUrl.parse(sb.toString());
        if (parse != null) {
            this.j = parse;
            return (a$a)this;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("'");
        sb2.append(s);
        sb2.append("' is not a valid API host.");
        throw new IllegalArgumentException(sb2.toString());
    }
    
    public HttpUrl d() {
        return this.j;
    }
    
    public c e() {
        return this.i;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && this.getClass() == o.getClass()) {
            final v v = (v)o;
            return this.e == v.e && this.f == v.f && this.g == v.g && this.h == v.h && Objects.equals((Object)this.a, (Object)v.a) && Objects.equals((Object)this.b, (Object)v.b) && Objects.equals((Object)this.c, (Object)v.c) && Objects.equals((Object)this.d, (Object)v.d) && Objects.equals((Object)this.i, (Object)v.i);
        }
        return false;
    }
    
    public Cache f() {
        return this.a;
    }
    
    public Executor g() {
        return this.b;
    }
    
    public int h() {
        return this.g;
    }
    
    @Override
    public int hashCode() {
        final Cache a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a != null) {
            hashCode2 = a.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final Executor b = this.b;
        int hashCode3;
        if (b != null) {
            hashCode3 = b.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final ConnectionPool c = this.c;
        int hashCode4;
        if (c != null) {
            hashCode4 = c.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final Dispatcher d = this.d;
        int hashCode5;
        if (d != null) {
            hashCode5 = d.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final int e = this.e;
        final int f = this.f;
        final int g = this.g;
        final long h = this.h;
        final int n = (int)(h ^ h >>> 32);
        final c i = this.i;
        if (i != null) {
            hashCode = i.hashCode();
        }
        return (((((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + e) * 31 + f) * 31 + g) * 31 + n) * 31 + hashCode;
    }
    
    public ConnectionPool i() {
        return this.c;
    }
    
    public Dispatcher j() {
        return this.d;
    }
    
    public long k() {
        return this.h;
    }
    
    public int l() {
        return this.e;
    }
    
    public int m() {
        return this.f;
    }
}
