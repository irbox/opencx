package com.alphainventor.filemanager.file;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import ax.b3.C1338j;
import ax.c3.C1651A;
import ax.c3.C1652B;
import ax.c3.C1674t;
import ax.c3.C1678x;
import ax.c3.EnumC1680z;
import ax.c3.InterfaceC1657b;
import ax.c3.d0;
import java.io.File;

/* JADX INFO: renamed from: com.alphainventor.filemanager.file.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /storage/emulated/0/Documents/jadec/sources/com.cxinventor.file.explorer/dex-files/7.dex */
public abstract class AbstractC3438n implements Comparable<AbstractC3438n>, InterfaceC1657b {
    private ax.c3.K c0;
    private int d0 = -1;
    private long e0;
    private int f0;
    private String g0;
    private String h0;
    private EnumC1680z i0;
    private String j0;
    private Context q;

    public AbstractC3438n(AbstractC3437m abstractC3437m) {
        this.q = abstractC3437m.p().getApplicationContext();
        this.c0 = abstractC3437m.v();
    }

    public String A() {
        return d0.j(B());
    }

    public final String B() {
        String absolutePath;
        String strC = C();
        String strH = d0.h(E());
        if (strC != null && !strC.equals(strH)) {
            if (this instanceof C3448y) {
                C3448y c3448y = (C3448y) this;
                File file = c3448y.M0;
                String strSubstring = null;
                if (file != null) {
                    absolutePath = file.getAbsolutePath();
                    String absolutePath2 = c3448y.F0().getAbsolutePath();
                    if (absolutePath2.startsWith(absolutePath)) {
                        String strSubstring2 = absolutePath2.substring(absolutePath.length());
                        if (strSubstring2.startsWith("/")) {
                            strSubstring = strSubstring2.substring(1);
                        }
                    }
                } else {
                    absolutePath = "null";
                }
                ax.Ha.c.h().f().d("GFNA LOCAL!!!").j().g(P().I() + ":" + strC + ":" + strH + ":parentPath=" + absolutePath + ":dir=" + isDirectory() + ":alt=" + strSubstring).h();
                if (strSubstring != null) {
                    return strSubstring;
                }
            } else {
                ax.Ha.c.h().f().d("GFNA").j().g(P().I() + ":" + strC + ":" + strH).h();
            }
        }
        return strC;
    }

    protected abstract String C();

    public C3440p D() {
        return null;
    }

    public final String E() {
        String strF = F();
        if (!d0.B(strF)) {
            String str = P().I() + "-" + C() + "-" + strF;
            if (this instanceof C3448y) {
                C3448y c3448y = (C3448y) this;
                if (c3448y.F0() != null) {
                    str = str + "-" + c3448y.F0().getPath();
                }
            }
            ax.Ha.c.h().f().b("NOT NORMALIZED PATH").g(str).h();
        }
        return strF;
    }

    protected abstract String F();

    public EnumC1680z G() {
        if (this.i0 == null) {
            this.i0 = C1651A.g(A());
        }
        return this.i0;
    }

    public String H(int i) {
        String str;
        long jQ = q();
        u(i);
        if (this.e0 == jQ && (str = this.h0) != null) {
            return str;
        }
        this.e0 = jQ;
        String strW = w(jQ, i);
        this.h0 = strW;
        return strW;
    }

    @SuppressLint({"DefaultLocale"})
    public String I(boolean z) {
        if (isDirectory()) {
            int iR = r(z);
            return iR >= 0 ? this.q.getResources().getQuantityString(2131820559, iR, Integer.valueOf(iR)) : iR == -1100 ? "" : this.q.getString(2131952464);
        }
        long jP = p();
        return jP == -1 ? "-" : C1652B.i(this.q, jP);
    }

    protected Drawable J(Context context, boolean z) {
        return isDirectory() ? ax.s3.b.g(context, this, a0(), z) : C1651A.f(context, E(), z);
    }

    public int K() {
        if (isDirectory()) {
            return 2131231320;
        }
        return C1651A.k(B(), false);
    }

    public int L() {
        return this.c0.b();
    }

    public Drawable M(Context context) {
        return J(context, true);
    }

    public File N() {
        return new File(ax.Z2.a.j(x(), this), B());
    }

    public C3448y O() throws C1338j {
        File fileN = N();
        return (C3448y) C1678x.f(fileN).z(fileN.getAbsolutePath());
    }

    public ax.Q2.f P() {
        return this.c0.d();
    }

    public String Q() {
        return C1652B.U(R(), E());
    }

    public ax.c3.K R() {
        return this.c0;
    }

    public String S() {
        return C1652B.U(R(), T());
    }

    public final String T() {
        String strU = U();
        if (!d0.B(strU)) {
            ax.Ha.c.h().f().b("!! PARENT PATH NOT NORMALIZED !!").j().g("location :" + P().I() + ", parent : " + strU + ", path :" + F()).h();
        }
        return strU;
    }

    protected abstract String U();

    public String V() {
        StringBuilder sb = new StringBuilder();
        sb.append(isDirectory() ? 'd' : '-');
        sb.append(d() ? 'r' : '-');
        sb.append(j() ? 'w' : '-');
        return sb.toString();
    }

    public String W() {
        if (this.j0 == null) {
            this.j0 = d0.w(this);
        }
        return this.j0;
    }

    public int X() {
        return this.d0;
    }

    public Drawable Y(Context context) {
        return J(context, false);
    }

    public File Z() {
        return new File(ax.Z2.a.l(x(), this), B());
    }

    public boolean a0() {
        return r(true) > 0;
    }

    public boolean b0() {
        return false;
    }

    public boolean c0() {
        return false;
    }

    public void d0(int i) {
        this.d0 = i;
    }

    protected boolean u(int i) {
        if (i == this.f0) {
            return false;
        }
        this.g0 = null;
        this.h0 = null;
        this.f0 = i;
        return true;
    }

    protected String w(long j, int i) {
        return j <= 0 ? "" : C1674t.f(this.q, j, i);
    }

    Context x() {
        return this.q;
    }
}
