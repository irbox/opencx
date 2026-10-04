package com.alphainventor.filemanager.file;

import ax.c3.v;
import ax.c3.d0;
import ax.b3.j;
import ax.Ia.c;

public class X extends n
{
    c k0;
    String l0;
    String m0;
    
    public X(final W w, final c k0) throws j {
        super((m)w);
        this.k0 = k0;
        this.l0 = w.q0(k0.k());
    }
    
    public X(final W w, final String l0) {
        super((m)w);
        this.l0 = l0;
    }
    
    private boolean f0() {
        final c k0 = this.k0;
        return k0 == null || k0.q() == null || h0(this.k0.q());
    }
    
    private static boolean h0(final String s) {
        try {
            if (Integer.parseInt(s) == 1) {
                return true;
            }
            return false;
        }
        catch (final NumberFormatException ex) {
            return false;
        }
    }
    
    protected String C() {
        return d0.h(this.l0);
    }
    
    protected String F() {
        return this.l0;
    }
    
    protected String U() {
        return d0.r(this.l0);
    }
    
    public boolean d() {
        return true;
    }
    
    public int e0(final n n) {
        try {
            return this.l0.compareTo(((X)n).l0);
        }
        catch (final ClassCastException ex) {
            return -1;
        }
    }
    
    public boolean g0() {
        final c k0 = this.k0;
        return k0 != null && k0.i();
    }
    
    public boolean h() {
        return this.B().startsWith(".") || (this.f0() ^ true);
    }
    
    public boolean isDirectory() {
        if ("/".equals((Object)this.l0)) {
            return true;
        }
        final c k0 = this.k0;
        return k0 != null && k0.s();
    }
    
    public boolean j() {
        final c k0 = this.k0;
        return k0 == null || k0.n() == null || (Boolean.parseBoolean(this.k0.n()) ^ true);
    }
    
    public boolean l() {
        return false;
    }
    
    public boolean n() {
        return "/".equals((Object)this.l0) || this.k0 != null;
    }
    
    public long p() {
        final c k0 = this.k0;
        if (k0 == null) {
            return 0L;
        }
        return k0.c();
    }
    
    public long q() {
        final c k0 = this.k0;
        if (k0 == null) {
            return -1L;
        }
        if (k0.l() == null) {
            return -1L;
        }
        return this.k0.l().getTime();
    }
    
    public int r(final boolean b) {
        if (!this.isDirectory()) {
            return -2;
        }
        return this.X();
    }
    
    public String s() {
        if (this.m0 == null) {
            this.m0 = v.e((n)this, "application/octet-stream");
        }
        return this.m0;
    }
    
    public String t() {
        return this.l0;
    }
}
