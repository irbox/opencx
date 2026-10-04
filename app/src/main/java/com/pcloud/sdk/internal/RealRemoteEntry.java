package com.pcloud.sdk.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.Gson;
import ax.r8.m;
import ax.r8.g;
import java.lang.reflect.Type;
import ax.r8.i;
import ax.r8.h;
import ax.la.v;
import ax.la.b;
import java.io.IOException;
import ax.la.w;
import java.util.Date;
import ax.s8.c;
import ax.la.a;
import ax.la.u;

abstract class RealRemoteEntry implements u
{
    private final a a;
    @ax.s8.a
    @c("id")
    private String b;
    @ax.s8.a
    @c("parentfolderid")
    private long c;
    @ax.s8.a
    @c("name")
    private String d;
    @ax.s8.a
    @c("modified")
    private Date e;
    @ax.s8.a
    @c("created")
    private Date f;
    @ax.s8.a
    @c("isfolder")
    private boolean g;
    @ax.s8.a
    @c("isshared")
    private boolean h;
    @ax.s8.a
    @c("ismine")
    private boolean i;
    @ax.s8.a
    @c("canread")
    private boolean j;
    @ax.s8.a
    @c("canmodify")
    private boolean k;
    @ax.s8.a
    @c("candelete")
    private boolean l;
    
    RealRemoteEntry(final a a) {
        this.j = true;
        this.k = true;
        this.l = true;
        this.a = a;
    }
    
    public String a() {
        return this.d;
    }
    
    public w c() {
        throw new IllegalStateException("This entry is not a folder");
    }
    
    public boolean d() {
        return this.i || this.j;
    }
    
    public boolean delete() throws IOException {
        try {
            return (boolean)this.a.c((u)this).execute();
        }
        catch (final b b) {
            throw new IOException((Throwable)b);
        }
    }
    
    public String e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && this.getClass() == o.getClass()) {
            final RealRemoteEntry realRemoteEntry = (RealRemoteEntry)o;
            return this.c == realRemoteEntry.c && this.g == realRemoteEntry.g && this.b.equals((Object)realRemoteEntry.b) && this.d.equals((Object)realRemoteEntry.d) && this.e.equals((Object)realRemoteEntry.e) && this.i == realRemoteEntry.i && this.h == realRemoteEntry.h && this.j == realRemoteEntry.j && this.k == realRemoteEntry.k && this.l == realRemoteEntry.l && this.f.equals((Object)realRemoteEntry.f);
        }
        return false;
    }
    
    public boolean f() {
        return this.g;
    }
    
    public boolean g() {
        return this.i || this.l;
    }
    
    public Date h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.b.hashCode();
        final long c = this.c;
        return ((((hashCode * 31 + (int)(c ^ c >>> 32)) * 31 + this.d.hashCode()) * 31 + this.e.hashCode()) * 31 + this.f.hashCode()) * 31 + (this.g ? 1 : 0);
    }
    
    public boolean i() {
        return this.i || this.k;
    }
    
    public v j() {
        throw new IllegalStateException("This entry is not a file");
    }
    
    public long m() {
        return this.c;
    }
    
    public boolean o() {
        return this.g ^ true;
    }
    
    public Date p() {
        return this.f;
    }
    
    static class FileEntryDeserializer implements h<u>
    {
        public u b(final i i, final Type type, final g g) throws m {
            if (i.h().t("isfolder").e()) {
                return (u)g.a(i, (Type)A.class);
            }
            return (u)g.a(i, (Type)z.class);
        }
    }
    
    static class TypeAdapterFactory implements ax.r8.w
    {
        private static final ax.x8.a<v> c0;
        private static final ax.x8.a<w> d0;
        private static final ax.x8.a<u> q;
        
        static {
            q = new ax.x8.a<u>() {};
            c0 = new ax.x8.a<v>() {};
            d0 = new ax.x8.a<w>() {};
        }
        
        public <T> TypeAdapter<T> b(final Gson gson, final ax.x8.a<T> a) {
            final ax.x8.a<u> q = TypeAdapterFactory.q;
            if (q.equals((Object)a)) {
                return (TypeAdapter<T>)gson.m((ax.x8.a)q);
            }
            if (TypeAdapterFactory.c0.equals((Object)a)) {
                return (TypeAdapter<T>)gson.n((Class)z.class);
            }
            if (TypeAdapterFactory.d0.equals((Object)a)) {
                return (TypeAdapter<T>)gson.n((Class)A.class);
            }
            return null;
        }
    }
}
