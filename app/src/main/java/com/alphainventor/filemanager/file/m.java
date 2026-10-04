package com.alphainventor.filemanager.file;

import ax.c3.v;
import com.jcraft.jsch.SftpException;
import ax.c3.d0;
import com.jcraft.jsch.SftpATTRS;

public class M extends n
{
    private SftpATTRS k0;
    private String l0;
    private String m0;
    private String n0;
    private boolean o0;
    private Long p0;
    
    public M(final L l, final L.e e, final SftpATTRS k0, final String l2) {
        super((m)l);
        this.k0 = k0;
        this.l0 = l2;
        this.m0 = d0.h(l2);
        this.f0();
        if (k0 == null || !k0.l()) {
            return;
        }
        this.o0 = true;
        try {
            this.k0 = e.o(l2);
        }
        catch (final SftpException ex) {}
    }
    
    public M(final L l, final String s) {
        this(l, null, null, s);
    }
    
    private void f0() {
        this.n0 = v.e((n)this, "");
    }
    
    public String C() {
        return this.m0;
    }
    
    public String F() {
        return this.l0;
    }
    
    public String U() {
        return d0.r(this.l0);
    }
    
    public boolean d() {
        final SftpATTRS k0 = this.k0;
        return k0 != null && (k0.g() & 0x4) != 0x0;
    }
    
    public int e0(final n n) {
        try {
            return this.l0.compareTo(((M)n).l0);
        }
        catch (final ClassCastException ex) {
            return -1;
        }
    }
    
    public boolean h() {
        final String m0 = this.m0;
        return m0 != null && m0.startsWith(".");
    }
    
    public boolean isDirectory() {
        final SftpATTRS k0 = this.k0;
        return k0 != null && k0.k();
    }
    
    public boolean j() {
        final SftpATTRS k0 = this.k0;
        return k0 != null && (k0.g() & 0x2) != 0x0;
    }
    
    public boolean l() {
        return this.o0;
    }
    
    public boolean n() {
        return this.k0 != null;
    }
    
    public long p() {
        final SftpATTRS k0 = this.k0;
        if (k0 != null) {
            return k0.i();
        }
        return 0L;
    }
    
    public long q() {
        if (this.p0 == null) {
            final SftpATTRS k0 = this.k0;
            if (k0 != null) {
                this.p0 = k0.e() * 1000L;
            }
            else {
                this.p0 = -1L;
            }
        }
        return this.p0;
    }
    
    public int r(final boolean b) {
        if (!this.isDirectory()) {
            return -2;
        }
        return this.X();
    }
    
    public String s() {
        return this.n0;
    }
    
    public String t() {
        return this.l0;
    }
}
