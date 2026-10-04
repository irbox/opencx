package com.alphainventor.filemanager.file;

import ax.c3.v;
import ax.c3.x;
import ax.b3.t;
import android.provider.DocumentsContract;
import ax.Q2.f;
import android.os.ParcelFileDescriptor;
import ax.Ha.b;
import com.alphainventor.filemanager.FileManagerApp;
import android.text.TextUtils;
import ax.Ha.c;
import ax.c3.l;
import android.database.Cursor;
import ax.b3.j;
import ax.c3.d0;
import android.net.Uri;
import android.annotation.TargetApi;
import ax.c3.k;

@TargetApi(21)
public class i extends k
{
    private String m0;
    private String n0;
    private String o0;
    private String p0;
    private String q0;
    private boolean r0;
    private boolean s0;
    private boolean t0;
    private boolean u0;
    private long v0;
    private long w0;
    private Uri x0;
    
    public i(final h h, final String n0) throws j {
        super((m)h);
        this.x0 = h.p0();
        this.n0 = n0;
        this.q0 = d0.h(n0);
        this.r0 = false;
        this.s0 = false;
        this.u0 = true;
        this.t0 = true;
        this.v0 = -1L;
        this.w0 = 0L;
    }
    
    public i(final h h, final String s, final Cursor cursor) throws j {
        super((m)h);
        this.x0 = h.p0();
        final l l = new l(cursor);
        String o0 = l.a;
        this.o0 = o0;
        boolean b;
        if (o0 != null && o0.endsWith("/")) {
            o0 = o0.replaceAll(".$", "_");
            b = true;
        }
        else {
            b = false;
        }
        String n0 = g.q(((n)this).x(), ((n)this).R(), this.x0, o0, s, l);
        if (!d0.I(s, n0)) {
            final b b2 = c.h().b("invalid file document file path");
            final StringBuilder sb = new StringBuilder();
            sb.append("parentPath:");
            sb.append(s);
            sb.append(",docId:");
            sb.append(l.a);
            b2.g((Object)sb.toString());
        }
        else {
            final String substring = d0.n(s, n0).substring(1);
            if (substring.contains((CharSequence)"/")) {
                final String replaceAll = substring.replaceAll("/", "_");
                n0 = d0.Q(s, replaceAll);
                if (replaceAll.length() > 12) {
                    final b j = c.h().f().b("DOCUMENT FILE NAME FIXED UNUSUAL").j();
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("file:");
                    sb2.append(s);
                    sb2.append(",");
                    sb2.append(l.b);
                    sb2.append(",");
                    sb2.append(l.a);
                    sb2.append(",");
                    sb2.append((Object)this.x0);
                    j.g((Object)sb2.toString()).h();
                }
                b = true;
            }
        }
        String s2;
        if (TextUtils.isEmpty((CharSequence)l.b)) {
            final b b3 = c.h().f().b("empty document displayname");
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("docid:");
            sb3.append(l.a);
            sb3.append(",root:");
            sb3.append((Object)this.x0);
            b3.g((Object)sb3.toString()).h();
            s2 = null;
        }
        else if (l.b.contains((CharSequence)"/")) {
            s2 = d0.Q(s, l.b.replaceAll("/", "_"));
        }
        else {
            s2 = d0.Q(s, l.b);
        }
        if (s2 != null && !s2.equals((Object)n0) && !"/".equals((Object)n0)) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("DOCUMENT FILE NAME CONFLICT:");
            sb4.append(s);
            sb4.append(",");
            sb4.append(l.b);
            sb4.append(",");
            sb4.append(s2);
            sb4.append(",");
            sb4.append(n0);
            FileManagerApp.b(sb4.toString());
            if (!b) {
                final b i = c.h().f().b("DOCUMENT FILE NAME CONFLICT 1").j();
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("file:");
                sb5.append(s);
                sb5.append(",");
                sb5.append(l.b);
                sb5.append(",");
                sb5.append(l.a);
                sb5.append(",");
                sb5.append((Object)this.x0);
                i.g((Object)sb5.toString()).h();
            }
        }
        if (n0 == null) {
            final b b4 = c.h().f().b("DOCUMENT FILE PATH NULL");
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("file:");
            sb6.append(s);
            sb6.append(",");
            sb6.append(l.b);
            sb6.append(",");
            sb6.append(s2);
            sb6.append(",");
            sb6.append(n0);
            b4.g((Object)sb6.toString()).h();
        }
        this.n0 = n0;
        this.q0 = d0.h(n0);
        this.r0 = true;
        this.s0 = l.d();
        this.u0 = l.b();
        this.t0 = l.a();
        this.v0 = l.d;
        this.w0 = l.e;
    }
    
    protected String C() {
        return this.q0;
    }
    
    protected String F() {
        return this.n0;
    }
    
    protected String U() {
        return d0.r(this.n0);
    }
    
    public boolean d() {
        return this.t0;
    }
    
    public ParcelFileDescriptor e0(final boolean b) throws j {
        if (b) {
            return g.o(((n)this).x(), this.n0(), "r");
        }
        return g.o(((n)this).x(), this.n0(), "rw");
    }
    
    public boolean h() {
        return this.C().startsWith(".");
    }
    
    public boolean i0() {
        return true;
    }
    
    public boolean isDirectory() {
        return this.s0;
    }
    
    public boolean j() {
        return this.u0;
    }
    
    public boolean j0() {
        return false;
    }
    
    public boolean k0() {
        return true;
    }
    
    public boolean l() {
        return false;
    }
    
    public int l0(final n n) {
        try {
            return this.n0.compareTo(((i)n).n0);
        }
        catch (final ClassCastException ex) {
            return -1;
        }
    }
    
    public String m0() {
        return this.o0;
    }
    
    public boolean n() {
        return this.r0;
    }
    
    public Uri n0() throws j {
        if (f.c0(((n)this).P())) {
            return g.e(((n)this).R(), this.x0, ((n)this).E());
        }
        if (((n)this).P() != f.h1) {
            ax.u3.b.f();
            throw new j("not reachable");
        }
        if (this.o0 != null) {
            return DocumentsContract.buildDocumentUriUsingTree(this.p0(), this.o0);
        }
        throw new t("no doc id");
    }
    
    public Uri o0() throws j {
        if (f.c0(((n)this).P())) {
            return g.e(((n)this).R(), this.x0, ((n)this).T());
        }
        if (((n)this).P() == f.h1) {
            if (this.p0 == null) {
                this.p0 = ((i)x.e(((n)this).R()).z(((n)this).T())).m0();
            }
            return DocumentsContract.buildDocumentUriUsingTree(this.p0(), this.p0);
        }
        ax.u3.b.f();
        throw new j("not reachable");
    }
    
    public long p() {
        return this.w0;
    }
    
    public Uri p0() {
        return this.x0;
    }
    
    public long q() {
        return this.v0;
    }
    
    public void q0(final String p) {
        this.p0 = p;
    }
    
    public int r(final boolean b) {
        if (!this.s0) {
            return -2;
        }
        return ((n)this).X();
    }
    
    public String s() {
        if (this.m0 == null) {
            this.m0 = v.e((n)this, "application/octet-stream");
        }
        return this.m0;
    }
    
    public String t() {
        return this.n0;
    }
}
