package com.pcloud.sdk.internal;

import java.lang.reflect.Type;
import ax.r8.e;
import java.util.Locale;
import ax.s8.c;
import ax.s8.a;
import ax.la.v;

class z extends RealRemoteEntry implements v
{
    @ax.s8.a
    @c("fileid")
    private long m;
    @ax.s8.a
    @c("contenttype")
    private String n;
    @ax.s8.a
    @c("size")
    private long o;
    @ax.s8.a
    @c("hash")
    private String p;
    @ax.s8.a
    @c("thumb")
    private Boolean q;
    
    z(final ax.la.a a) {
        super(a);
    }
    
    public boolean b() {
        return this.q;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final z z = (z)o;
        return this.m == z.m && this.o == z.o && this.n.equals((Object)z.n) && this.p.equals((Object)z.p);
    }
    
    @Override
    public int hashCode() {
        final int hashCode = super.hashCode();
        final long m = this.m;
        final int n = (int)(m ^ m >>> 32);
        final int hashCode2 = this.n.hashCode();
        final long o = this.o;
        return (((hashCode * 31 + n) * 31 + hashCode2) * 31 + (int)(o ^ o >>> 32)) * 31 + this.p.hashCode();
    }
    
    @Override
    public v j() {
        return (v)this;
    }
    
    public long n() {
        return this.m;
    }
    
    public long size() {
        return this.o;
    }
    
    public String toString() {
        return String.format(Locale.US, "%s | ID:%s | Created:%s | Modified: %s | Size:%s", new Object[] { this.a(), this.e(), this.p(), this.h(), this.size() });
    }
    
    static class a implements e<z>
    {
        private final ax.la.a a;
        
        a(final ax.la.a a) {
            this.a = a;
        }
        
        public z b(final Type type) {
            return new z(this.a);
        }
    }
}
