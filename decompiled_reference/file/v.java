package com.alphainventor.filemanager.file;

import ax.Ha.c;
import ax.Q2.o;
import java.io.IOException;
import java.io.File;
import android.text.TextUtils;
import ax.c3.v;
import ax.c3.d0;
import ax.h5.e;

public class V extends n
{
    private String k0;
    private String l0;
    private boolean m0;
    private boolean n0;
    private boolean o0;
    private long p0;
    private long q0;
    private e r0;
    
    public V(final U u, final String s, final e r0) {
        super((m)u);
        this.l0 = this.g0(s);
        this.n0 = true;
        this.o0 = true;
        this.f0();
        this.p0 = 0L;
        this.q0 = 0L;
        if (r0 != null) {
            this.r0 = r0;
            this.m0 = r0.isDirectory();
            if (!d0.D(this.R(), s)) {
                this.p0 = r0.h();
                if (!this.r0.isDirectory()) {
                    this.q0 = r0.getLength();
                }
            }
        }
    }
    
    private void f0() {
        this.k0 = v.e((n)this, "");
    }
    
    private String g0(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return File.separator;
        }
        return d0.U(s.substring(s.indexOf("/")));
    }
    
    public String C() {
        return d0.h(this.l0);
    }
    
    public String F() {
        return this.l0;
    }
    
    public String U() {
        return d0.r(this.l0);
    }
    
    public boolean d() {
        return this.n0;
    }
    
    public int e0(final n n) {
        try {
            return this.l0.compareTo(((V)n).l0);
        }
        catch (final ClassCastException ex) {
            return -1;
        }
    }
    
    public boolean h() {
        return this.C().startsWith(".");
    }
    
    public boolean isDirectory() {
        return this.m0;
    }
    
    public boolean j() {
        return this.o0;
    }
    
    public boolean l() {
        return false;
    }
    
    public boolean n() {
        return this.r0 != null;
    }
    
    public long p() {
        return this.q0;
    }
    
    public long q() {
        return this.p0;
    }
    
    public int r(final boolean b) {
        Object o = this.r0;
        if (o == null) {
            return -1000;
        }
        if (!((e)o).isDirectory()) {
            return -2;
        }
        final int x = this.X();
        int length = -1;
        if (x != -1) {
            return this.X();
        }
        Label_0121: {
            try {
                o = this.r0.c0();
                break Label_0121;
            }
            catch (final IllegalArgumentException o) {}
            catch (final IOException ex) {}
            ((Throwable)o).printStackTrace();
            if (ax.Q2.o.i().m()) {
                ax.Q2.o.i().b(this.x());
                if (ax.Q2.o.i().m()) {
                    c.h().f().d("!!USB NUM CHILDREN!!").l((Throwable)o).h();
                }
            }
            o = null;
        }
        if (o != null) {
            length = ((Throwable)o).length;
        }
        return length;
    }
    
    public String s() {
        return this.k0;
    }
    
    public String t() {
        return this.l0;
    }
}
