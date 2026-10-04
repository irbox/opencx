package com.alphainventor.filemanager.file;

import ax.u3.q$e;
import ax.u3.q;
import ax.b3.z;
import ax.c3.i0;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.CountDownLatch;
import java.util.Iterator;
import ax.Z2.g;
import ax.c3.d0;
import ax.c3.k0;
import ax.c3.K;
import androidx.fragment.app.Fragment;
import android.app.Activity;
import ax.b3.t;
import ax.c3.x;
import ax.c3.G;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import ax.b3.a;
import ax.Ha.b;
import android.net.Uri;
import ax.b3.r;
import ax.X2.Q;
import ax.Q2.f;
import ax.g3.i;
import ax.b3.j;
import ax.c3.B;
import ax.T2.h;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class o implements c
{
    private static final Logger m;
    m a;
    final AtomicInteger b;
    final String c;
    final Context d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    
    static {
        m = Logger.getLogger("FileManager.FileOperator");
    }
    
    public o(final Context d, final m a) {
        this.b = new AtomicInteger(0);
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.d = d;
        this.a = a;
        String string;
        try {
            string = d.getString(2131951795);
        }
        catch (final IndexOutOfBoundsException ex) {
            string = " - Copy";
        }
        this.c = string;
    }
    
    private boolean a0() {
        return ax.T2.h.n0(this.T());
    }
    
    private boolean b0(final n n) {
        return ax.T2.h.n0(n.R());
    }
    
    private void d(final o o, n n, final n n2) throws j, a {
        final String e = n.E();
        final n n3 = B.n(o, n);
        final Uri uri = null;
        Label_0086: {
            Label_0082: {
                try {
                    if (((ax.c3.b)n).p() == 0L) {
                        o.P(n);
                        break Label_0086;
                    }
                }
                catch (final j j) {
                    break Label_0082;
                }
                n z = n3;
                if (((ax.c3.b)n3).n()) {
                    o.P(n3);
                    z = o.z(n3.E());
                }
                o.E(n, z, null, null);
                break Label_0086;
            }
            final j j;
            ((Throwable)j).printStackTrace();
        }
        final n n4 = n = o.z(e);
        Label_0385: {
            if (!((ax.c3.b)n4).n()) {
                break Label_0385;
            }
            ax.Ha.c.h().f().d("MoveTempToDst 1").g((Object)n4.P().I()).h();
            boolean b;
            try {
                o.P(n4);
                b = true;
            }
            catch (final j i) {
                b = false;
            }
            n = o.z(e);
            if (!((ax.c3.b)n).n()) {
                break Label_0385;
            }
            Label_0304: {
                if (n.P() != ax.Q2.f.p0 || !Q.V1()) {
                    break Label_0304;
                }
                while (true) {
                    try {
                        final Uri n5 = ((y)n).N0();
                        final ax.Ha.b d = ax.Ha.c.h().f().d("MoveTempToDst 2-1");
                        final StringBuilder sb = new StringBuilder();
                        sb.append(n.P().I());
                        sb.append(":");
                        sb.append(e);
                        sb.append(":");
                        sb.append(((ax.c3.b)n).p());
                        sb.append(":");
                        sb.append(b);
                        sb.append(":");
                        sb.append((Object)n5);
                        d.g((Object)sb.toString()).h();
                        throw new j("Could not delete and overwrite");
                        final ax.Ha.b d2 = ax.Ha.c.h().f().d("MoveTempToDst 2-2");
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append(n.P().I());
                        sb2.append(":");
                        sb2.append(e);
                        sb2.append(":");
                        sb2.append(b);
                        d2.g((Object)sb2.toString()).h();
                        throw new j("Could not delete and overwrite");
                        o.E(n2, n, null, null);
                    }
                    catch (final r r) {
                        final Uri n5 = uri;
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void l(final o o, n z, final n n) throws j, a {
        final String e = z.E();
        o.P(z);
        final n z2 = o.z(e);
        boolean n2 = ((ax.c3.b)z2).n();
        ax.Ha.b d = null;
        z = z2;
        Label_0308: {
            if (!n2) {
                break Label_0308;
            }
            ax.Ha.c.h().f().d("MoveTempToDst 1").g((Object)z2.P().I()).h();
            try {
                o.P(z2);
                n2 = true;
            }
            catch (final j j) {
                n2 = false;
            }
            z = o.z(e);
            if (!((ax.c3.b)z).n()) {
                break Label_0308;
            }
            Label_0227: {
                if (z.P() != ax.Q2.f.p0 || !Q.V1()) {
                    break Label_0227;
                }
                while (true) {
                    try {
                        final Uri n3 = ((y)z).N0();
                        d = ax.Ha.c.h().f().d("MoveTempToDst 2-1");
                        final StringBuilder sb = new StringBuilder();
                        sb.append(z.P().I());
                        sb.append(":");
                        sb.append(e);
                        sb.append(":");
                        sb.append(((ax.c3.b)z).p());
                        sb.append(":");
                        sb.append(n2);
                        sb.append(":");
                        sb.append((Object)n3);
                        d.g((Object)sb.toString()).h();
                        throw new j("Could not delete and overwrite");
                        o.E(n, z, null, null);
                        return;
                        final ax.Ha.b d2 = ax.Ha.c.h().f().d("MoveTempToDst 2-2");
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append(z.P().I());
                        sb2.append(":");
                        sb2.append(e);
                        sb2.append(":");
                        sb2.append(n2);
                        d2.g((Object)sb2.toString()).h();
                        throw new j("Could not delete and overwrite");
                    }
                    catch (final r r) {
                        final Uri n3 = (Uri)d;
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void l0() {
        monitorenter(this);
        Label_0058: {
            try {
                if (this.b.get() <= 0) {
                    break Label_0058;
                }
                this.b.getAndDecrement();
                if (this.b.get() == 0) {
                    ((c)this.a).b();
                    ax.Z2.b.k().d(this.T());
                }
                break Label_0058;
            }
            finally {
                monitorexit(this);
                monitorexit(this);
            }
        }
    }
    
    public InputStream A(final String s, final String s2, final String s3) throws IOException {
        return ((c)this.a).A(s, s2, s3);
    }
    
    public boolean B(final n n) {
        return ((c)this.a).B(n);
    }
    
    public List<n> C(final n n, final m.f f) throws j {
        if (((ax.c3.b)n).isDirectory()) {
            final List c = ((c)this.a).C(n, f);
            if (this.u0(n)) {
                ax.Z2.b.k().m(n, c);
            }
            return (List<n>)c;
        }
        final ax.Ha.b j = ax.Ha.c.h().f().d("FOLICH!!!").j();
        final StringBuilder sb = new StringBuilder();
        sb.append(this.S().I());
        sb.append(":");
        sb.append(((ax.c3.b)n).n());
        j.g((Object)sb.toString()).h();
        throw new j("list children : fileinfo is not directory");
    }
    
    public void D(final n n, final G g, final String s, final long n2, final Long n3, final p p9, final boolean b, final ax.u3.c c, final i i) throws j, a {
        ax.Z2.b.k().p(this.T(), n.T());
        ax.Z2.b.k().e(n);
        ((c)this.a).D(n, g, s, n2, n3, p9, b, c, i);
        if (this.b0(n)) {
            ax.T2.h.T(n).b(n);
        }
    }
    
    public void E(final n n, final n n2, final ax.u3.c c, final i i) throws j, a {
        final f s = this.S();
        final f p4 = n.P();
        final boolean b = false;
        ax.u3.b.c(s == p4);
        if (!B.P(n)) {
            ax.u3.b.c(n.P() == n2.P());
        }
        Label_0372: {
            if (!((ax.c3.b)n).n()) {
                break Label_0372;
            }
            if (((ax.c3.b)n2).n()) {
                ax.Ha.c.h().f().d("MV1").j().g((Object)this.S().I()).h();
                boolean b2 = b;
                if (((ax.c3.b)n).isDirectory() != ((ax.c3.b)n2).isDirectory()) {
                    b2 = true;
                }
                throw new ax.b3.f(b2);
            }
            long y;
            if (this.b0(n)) {
                y = ax.T2.h.T(n).Y(n);
            }
            else {
                y = 0L;
            }
            Label_0319: {
                try {
                    ((c)this.a).E(n, n2, c, i);
                    if (this.b0(n)) {
                        ax.T2.h.T(n).s(n, y);
                    }
                }
                finally {
                    break Label_0319;
                }
                while (true) {
                    if (!this.b0(n2)) {
                        break Label_0267;
                    }
                    try {
                        n n3;
                        if (n.R() != n2.R()) {
                            n3 = x.e(n2.R()).z(n2.E());
                        }
                        else {
                            n3 = this.z(n2.E());
                        }
                        ax.T2.h.T(n3).b(n3);
                        ax.Z2.b.k().t(n);
                        ax.Z2.b.k().p(n.R(), n.T());
                        ax.Z2.b.k().p(n2.R(), n2.T());
                        ax.Z2.b.k().e(n);
                        ax.Z2.b.k().e(n2);
                        return;
                        ax.Z2.b.k().t(n);
                        ax.Z2.b.k().p(n.R(), n.T());
                        ax.Z2.b.k().p(n2.R(), n2.T());
                        ax.Z2.b.k().e(n);
                        ax.Z2.b.k().e(n2);
                        ax.Ha.c.h().f().d("MV2").j().g((Object)this.S().I()).h();
                        throw new t("Source file not exists");
                    }
                    catch (final j j) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    public void F(final n n, final n n2, final ax.u3.c c, final i i) throws j, a {
        ax.u3.b.a(((ax.c3.b)n).isDirectory());
        if (((ax.c3.b)n2).n()) {
            ax.Ha.c.h().d("CP1").j().g((Object)this.S().I()).h();
            throw new j("Target is aleady exist");
        }
        if (((ax.c3.b)n).n()) {
            ax.Z2.b.k().p(n2.R(), n2.T());
            ax.Z2.b.k().e(n2);
            ((c)this.a).F(n, n2, c, i);
            if (this.b0(n2)) {
                ax.T2.h.T(n2).b(n2);
            }
            return;
        }
        ax.Ha.c.h().f().d("CP2").j().g((Object)this.S().I()).h();
        throw new t("Source is not exist");
    }
    
    public int G(final String s, final String s2) {
        return ((c)this.a).G(s, s2);
    }
    
    public String H(final n n) {
        return ((c)this.a).H(n);
    }
    
    public void I(final n n) throws j {
        long y;
        if (this.b0(n)) {
            y = ax.T2.h.T(n).Y(n);
        }
        else {
            y = 0L;
        }
        try {
            ((c)this.a).I(n);
            ax.Z2.b.k().s(this.T(), n.E());
            ax.Z2.b.k().p(this.T(), n.T());
            ax.Z2.b.k().e(n);
            if (this.b0(n)) {
                ax.T2.h.T(n).s(n, y);
            }
        }
        finally {
            ax.Z2.b.k().s(this.T(), n.E());
            ax.Z2.b.k().p(this.T(), n.T());
            ax.Z2.b.k().e(n);
        }
    }
    
    public InputStream J(final n n, final long n2) throws j {
        return ((c)this.a).J(n, n2);
    }
    
    public void K(final Activity activity, final Fragment fragment, final c$a c$a) {
        ((c)this.a).K(activity, fragment, c$a);
    }
    
    public boolean L() {
        return ((c)this.a).L();
    }
    
    public boolean N(final n n) {
        final boolean n2 = ((c)this.a).N(n);
        if (n2) {
            ax.Z2.b.k().p(this.T(), n.T());
            ax.Z2.b.k().e(n);
        }
        return n2;
    }
    
    public boolean O() {
        return ((c)this.a).O();
    }
    
    public void P(final n n) throws j {
        long p;
        if (this.b0(n) && !((ax.c3.b)n).isDirectory()) {
            p = ((ax.c3.b)n).p();
        }
        else {
            p = 0L;
        }
        try {
            ((c)this.a).P(n);
            ax.Z2.b.k().s(this.T(), n.E());
            ax.Z2.b.k().p(this.T(), n.T());
            ax.Z2.b.k().e(n);
            if (this.b0(n)) {
                ax.T2.h.T(n).s(n, p);
            }
        }
        finally {
            ax.Z2.b.k().s(this.T(), n.E());
            ax.Z2.b.k().p(this.T(), n.T());
            ax.Z2.b.k().e(n);
        }
    }
    
    public boolean Q(final n n, final n n2) {
        return ((c)this.a).Q(n, n2);
    }
    
    public String R() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.i);
        sb.append(":");
        sb.append(this.j);
        sb.append(":");
        sb.append(this.k);
        sb.append(":");
        sb.append(this.l);
        sb.append(" - ");
        sb.append(this.e);
        sb.append(":");
        sb.append(this.f);
        sb.append(":");
        sb.append(this.g);
        sb.append(":");
        sb.append(this.h);
        return sb.toString();
    }
    
    public f S() {
        return this.a.u();
    }
    
    public K T() {
        return this.a.v();
    }
    
    public int U() {
        synchronized (this) {
            return this.b.get();
        }
    }
    
    public String V() {
        return this.a.r();
    }
    
    public k0 W() throws j {
        return this.a.y();
    }
    
    public n X(final n n, final boolean b) throws j {
        ax.u3.b.c(this.S() == n.P());
        if (!((ax.c3.b)n).n()) {
            return n;
        }
        final String b2 = n.B();
        final String t = n.T();
        final boolean directory = ((ax.c3.b)n).isDirectory();
        String substring = "";
        String substring2;
        if (directory) {
            substring2 = b2;
        }
        else {
            final int lastIndex = b2.lastIndexOf(46);
            substring2 = b2;
            if (lastIndex > 0) {
                substring2 = b2.substring(0, lastIndex);
                substring = b2.substring(lastIndex);
            }
        }
        int n2 = 2;
        if (b) {
            final StringBuilder sb = new StringBuilder();
            sb.append(substring2);
            sb.append(this.c);
            final String q = d0.Q(t, sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(q);
            sb2.append(substring);
            n n3;
            StringBuilder sb3;
            for (n3 = this.z(sb2.toString()); ((ax.c3.b)n3).n(); n3 = this.z(sb3.toString()), ++n2) {
                sb3 = new StringBuilder();
                sb3.append(q);
                sb3.append(" (");
                sb3.append(n2);
                sb3.append(")");
                sb3.append(substring);
            }
            return n3;
        }
        final String q2 = d0.Q(t, substring2);
        n z;
        while (true) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(q2);
            sb4.append(" (");
            sb4.append(n2);
            sb4.append(")");
            sb4.append(substring);
            z = this.z(sb4.toString());
            if (!((ax.c3.b)z).n()) {
                break;
            }
            ++n2;
        }
        return z;
    }
    
    public boolean Y() {
        return this.u() instanceof com.alphainventor.filemanager.file.x && ((com.alphainventor.filemanager.file.x)this.u()).g1();
    }
    
    public boolean Z() {
        return this.a.V();
    }
    
    public boolean a() {
        return ((c)this.a).a();
    }
    
    public void b() {
        ((c)this.a).b();
    }
    
    public boolean c0(final n n) {
        return this.u0(n) && ax.Z2.b.k().f(n);
    }
    
    public boolean d0() {
        return this.a.Y();
    }
    
    public boolean e(final n n, final n n2) {
        if (B.P(n) && B.P(n2)) {
            return this.Q(n, n2);
        }
        return B.N(n, n2) && this.Q(n, n2);
    }
    
    public boolean e0(final n n) {
        return this.a.a0(n);
    }
    
    public void f(String path) {
        path = Uri.parse(path).getPath();
        if (path == null) {
            return;
        }
        this.a.f(path);
    }
    
    public List<n> f0(final n n) throws j {
        return this.C(n, com.alphainventor.filemanager.file.m.f.q);
    }
    
    public void g() {
        this.a.g();
    }
    
    public List<n> g0(final n n, final m.f f, final boolean b, final boolean b2) throws j {
        if (!this.c0(n)) {
            final List<n> c = this.C(n, f);
            if (b2 && c != null && this.u() instanceof com.alphainventor.filemanager.file.x) {
                final n j0 = com.alphainventor.filemanager.file.x.J0((List)c);
                if (j0 != null && !((ax.c3.b)j0).isDirectory()) {
                    final List h1 = ((com.alphainventor.filemanager.file.x)this.u()).H1(j0);
                    if (h1 != null) {
                        for (final String s : h1) {
                            for (final n n2 : c) {
                                if (s.equals((Object)n2.B())) {
                                    ((y)n2).k1(y.b.d0);
                                }
                            }
                        }
                    }
                }
                for (final n n3 : c) {
                    final String f2 = ax.Z2.g.h().f(n3);
                    if (f2 != null) {
                        ((y)n3).k1(ax.Z2.g.c(f2));
                    }
                }
            }
            return c;
        }
        final List g = ax.Z2.b.k().g(n);
        if (b && g != null && f.g0(this.S())) {
            return (List<n>)((u)this.a).g2(n, g, true);
        }
        return (List<n>)g;
    }
    
    public void h(final c$a c$a) {
        this.a.h(c$a);
    }
    
    public void h0(final n p0, final o p1, final n p2, final boolean p3, final ax.u3.c p4, final i p5) throws j, a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/alphainventor/filemanager/file/o.S:()Lax/Q2/f;
        //     4: astore          16
        //     6: aload_1        
        //     7: invokevirtual   com/alphainventor/filemanager/file/n.P:()Lax/Q2/f;
        //    10: astore          17
        //    12: iconst_1       
        //    13: istore          9
        //    15: aload           16
        //    17: aload           17
        //    19: if_acmpne       28
        //    22: iconst_1       
        //    23: istore          11
        //    25: goto            31
        //    28: iconst_0       
        //    29: istore          11
        //    31: iload           11
        //    33: invokestatic    ax/u3/b.c:(Z)V
        //    36: aload_1        
        //    37: invokeinterface ax/c3/b.isDirectory:()Z
        //    42: invokestatic    ax/u3/b.a:(Z)V
        //    45: aload_1        
        //    46: invokeinterface ax/c3/b.n:()Z
        //    51: ifeq            667
        //    54: aload_2        
        //    55: aload_3        
        //    56: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //    59: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //    62: astore          16
        //    64: aload           16
        //    66: invokestatic    ax/c3/d0.E:(Lcom/alphainventor/filemanager/file/n;)Z
        //    69: ifne            106
        //    72: aload           16
        //    74: invokeinterface ax/c3/b.n:()Z
        //    79: ifne            106
        //    82: aload_2        
        //    83: aload           16
        //    85: iconst_0       
        //    86: invokevirtual   com/alphainventor/filemanager/file/o.k:(Lcom/alphainventor/filemanager/file/n;Z)Z
        //    89: ifeq            95
        //    92: goto            106
        //    95: new             Lax/b3/j;
        //    98: dup            
        //    99: ldc_w           "Create target folder failed"
        //   102: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   105: athrow         
        //   106: aconst_null    
        //   107: astore          18
        //   109: aconst_null    
        //   110: astore          19
        //   112: aload           19
        //   114: astore          16
        //   116: aload           18
        //   118: astore          17
        //   120: aload_0        
        //   121: aload_1        
        //   122: aload_3        
        //   123: invokevirtual   com/alphainventor/filemanager/file/o.e:(Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/n;)Z
        //   126: istore          11
        //   128: aload           19
        //   130: astore          16
        //   132: aload           18
        //   134: astore          17
        //   136: aload_3        
        //   137: invokeinterface ax/c3/b.n:()Z
        //   142: ifeq            269
        //   145: aload           19
        //   147: astore          16
        //   149: aload           18
        //   151: astore          17
        //   153: aload_3        
        //   154: invokeinterface ax/c3/b.isDirectory:()Z
        //   159: ifne            235
        //   162: aload           19
        //   164: astore          16
        //   166: aload           18
        //   168: astore          17
        //   170: aload_2        
        //   171: invokevirtual   com/alphainventor/filemanager/file/o.o0:()Z
        //   174: ifeq            202
        //   177: iload           11
        //   179: ifne            202
        //   182: aconst_null    
        //   183: astore          16
        //   185: iconst_1       
        //   186: istore          7
        //   188: iconst_1       
        //   189: istore          10
        //   191: iload           7
        //   193: istore          8
        //   195: iload           10
        //   197: istore          7
        //   199: goto            278
        //   202: aload           19
        //   204: astore          16
        //   206: aload           18
        //   208: astore          17
        //   210: aload_2        
        //   211: aload_3        
        //   212: invokestatic    ax/c3/B.z:(Lcom/alphainventor/filemanager/file/o;Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/n;
        //   215: astore          18
        //   217: iconst_0       
        //   218: istore          7
        //   220: aload           18
        //   222: astore          16
        //   224: goto            188
        //   227: astore_3       
        //   228: goto            598
        //   231: astore_3       
        //   232: goto            638
        //   235: aload           19
        //   237: astore          16
        //   239: aload           18
        //   241: astore          17
        //   243: new             Lax/b3/u;
        //   246: astore_3       
        //   247: aload           19
        //   249: astore          16
        //   251: aload           18
        //   253: astore          17
        //   255: aload_3        
        //   256: invokespecial   ax/b3/u.<init>:()V
        //   259: aload           19
        //   261: astore          16
        //   263: aload           18
        //   265: astore          17
        //   267: aload_3        
        //   268: athrow         
        //   269: aload_3        
        //   270: astore          16
        //   272: iconst_0       
        //   273: istore          8
        //   275: iconst_0       
        //   276: istore          7
        //   278: iload           11
        //   280: ifeq            312
        //   283: aload_0        
        //   284: aload_1        
        //   285: aload           16
        //   287: aload           5
        //   289: aload           6
        //   291: invokevirtual   com/alphainventor/filemanager/file/o.E:(Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/n;Lax/u3/c;Lax/g3/i;)V
        //   294: iconst_0       
        //   295: istore          9
        //   297: goto            452
        //   300: astore_3       
        //   301: goto            598
        //   304: astore_3       
        //   305: aload           16
        //   307: astore          17
        //   309: goto            638
        //   312: aload_1        
        //   313: invokevirtual   com/alphainventor/filemanager/file/n.c0:()Z
        //   316: istore          11
        //   318: iload           11
        //   320: ifeq            333
        //   323: aload_0        
        //   324: aload_1        
        //   325: invokevirtual   com/alphainventor/filemanager/file/o.r:(Lcom/alphainventor/filemanager/file/n;)V
        //   328: goto            333
        //   331: astore          17
        //   333: iload           8
        //   335: ifeq            390
        //   338: aload_2        
        //   339: aload_3        
        //   340: aload_0        
        //   341: aload_1        
        //   342: invokevirtual   com/alphainventor/filemanager/file/o.x:(Lcom/alphainventor/filemanager/file/n;)Lax/c3/G;
        //   345: aload_1        
        //   346: invokeinterface ax/c3/b.s:()Ljava/lang/String;
        //   351: aload_1        
        //   352: invokeinterface ax/c3/b.p:()J
        //   357: aload_1        
        //   358: invokeinterface ax/c3/b.q:()J
        //   363: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   366: aload_1        
        //   367: invokevirtual   com/alphainventor/filemanager/file/n.D:()Lcom/alphainventor/filemanager/file/p;
        //   370: iload           4
        //   372: aload           5
        //   374: aload           6
        //   376: invokevirtual   com/alphainventor/filemanager/file/o.s0:(Lcom/alphainventor/filemanager/file/n;Lax/c3/G;Ljava/lang/String;JLjava/lang/Long;Lcom/alphainventor/filemanager/file/p;ZLax/u3/c;Lax/g3/i;)V
        //   379: goto            452
        //   382: astore_3       
        //   383: goto            301
        //   386: astore_3       
        //   387: goto            305
        //   390: aload_0        
        //   391: aload_1        
        //   392: invokevirtual   com/alphainventor/filemanager/file/o.x:(Lcom/alphainventor/filemanager/file/n;)Lax/c3/G;
        //   395: astore          18
        //   397: aload_1        
        //   398: invokeinterface ax/c3/b.s:()Ljava/lang/String;
        //   403: astore          19
        //   405: aload_1        
        //   406: invokeinterface ax/c3/b.p:()J
        //   411: lstore          12
        //   413: aload_1        
        //   414: invokeinterface ax/c3/b.q:()J
        //   419: lstore          14
        //   421: aload_1        
        //   422: invokevirtual   com/alphainventor/filemanager/file/n.D:()Lcom/alphainventor/filemanager/file/p;
        //   425: astore          17
        //   427: aload_2        
        //   428: aload           16
        //   430: aload           18
        //   432: aload           19
        //   434: lload           12
        //   436: lload           14
        //   438: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   441: aload           17
        //   443: iload           4
        //   445: aload           5
        //   447: aload           6
        //   449: invokevirtual   com/alphainventor/filemanager/file/o.D:(Lcom/alphainventor/filemanager/file/n;Lax/c3/G;Ljava/lang/String;JLjava/lang/Long;Lcom/alphainventor/filemanager/file/p;ZLax/u3/c;Lax/g3/i;)V
        //   452: iload           7
        //   454: ifeq            563
        //   457: iload           8
        //   459: ifne            563
        //   462: aload_2        
        //   463: aload           16
        //   465: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   468: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //   471: astore          5
        //   473: aload           5
        //   475: astore          16
        //   477: aload           5
        //   479: astore          17
        //   481: aload           5
        //   483: invokeinterface ax/c3/b.n:()Z
        //   488: ifeq            514
        //   491: aload           5
        //   493: astore          16
        //   495: aload           5
        //   497: astore          17
        //   499: aload_0        
        //   500: aload_2        
        //   501: aload_3        
        //   502: aload           5
        //   504: invokespecial   com/alphainventor/filemanager/file/o.l:(Lcom/alphainventor/filemanager/file/o;Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/n;)V
        //   507: aload           5
        //   509: astore          17
        //   511: goto            567
        //   514: aload           5
        //   516: astore          16
        //   518: aload           5
        //   520: astore          17
        //   522: new             Lax/b3/t;
        //   525: astore_3       
        //   526: aload           5
        //   528: astore          16
        //   530: aload           5
        //   532: astore          17
        //   534: aload_3        
        //   535: ldc_w           "tmp file not exists"
        //   538: invokespecial   ax/b3/t.<init>:(Ljava/lang/String;)V
        //   541: aload           5
        //   543: astore          16
        //   545: aload           5
        //   547: astore          17
        //   549: aload_3        
        //   550: athrow         
        //   551: astore_3       
        //   552: goto            598
        //   555: astore_3       
        //   556: aload           16
        //   558: astore          17
        //   560: goto            638
        //   563: aload           16
        //   565: astore          17
        //   567: iload           9
        //   569: ifeq            581
        //   572: aload           17
        //   574: astore          16
        //   576: aload_0        
        //   577: aload_1        
        //   578: invokevirtual   com/alphainventor/filemanager/file/o.P:(Lcom/alphainventor/filemanager/file/n;)V
        //   581: return         
        //   582: astore_3       
        //   583: goto            552
        //   586: astore_3       
        //   587: goto            556
        //   590: astore_3       
        //   591: goto            583
        //   594: astore_3       
        //   595: goto            587
        //   598: aload_3        
        //   599: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   602: aload           16
        //   604: ifnull          636
        //   607: aload_3        
        //   608: instanceof      Lax/b3/f;
        //   611: ifne            636
        //   614: aload_0        
        //   615: aload_1        
        //   616: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   619: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //   622: invokeinterface ax/c3/b.n:()Z
        //   627: ifeq            636
        //   630: aload_2        
        //   631: aload           16
        //   633: invokevirtual   com/alphainventor/filemanager/file/o.P:(Lcom/alphainventor/filemanager/file/n;)V
        //   636: aload_3        
        //   637: athrow         
        //   638: aload           17
        //   640: ifnull          665
        //   643: aload_0        
        //   644: aload_1        
        //   645: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   648: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //   651: invokeinterface ax/c3/b.n:()Z
        //   656: ifeq            665
        //   659: aload_2        
        //   660: aload           17
        //   662: invokevirtual   com/alphainventor/filemanager/file/o.P:(Lcom/alphainventor/filemanager/file/n;)V
        //   665: aload_3        
        //   666: athrow         
        //   667: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   670: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   673: ldc_w           "MVEX"
        //   676: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   679: aload_0        
        //   680: invokevirtual   com/alphainventor/filemanager/file/o.S:()Lax/Q2/f;
        //   683: invokevirtual   ax/Q2/f.I:()Ljava/lang/String;
        //   686: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   689: invokevirtual   ax/Ha/b.h:()V
        //   692: new             Lax/b3/t;
        //   695: dup            
        //   696: ldc_w           "Move source file not found"
        //   699: invokespecial   ax/b3/t.<init>:(Ljava/lang/String;)V
        //   702: athrow         
        //   703: astore_1       
        //   704: goto            636
        //   707: astore_1       
        //   708: goto            665
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type     
        //  -----  -----  -----  -----  ---------
        //  120    128    231    235    Lax/b3/a;
        //  120    128    227    231    Lax/b3/j;
        //  136    145    231    235    Lax/b3/a;
        //  136    145    227    231    Lax/b3/j;
        //  153    162    231    235    Lax/b3/a;
        //  153    162    227    231    Lax/b3/j;
        //  170    177    231    235    Lax/b3/a;
        //  170    177    227    231    Lax/b3/j;
        //  210    217    231    235    Lax/b3/a;
        //  210    217    227    231    Lax/b3/j;
        //  243    247    231    235    Lax/b3/a;
        //  243    247    227    231    Lax/b3/j;
        //  255    259    231    235    Lax/b3/a;
        //  255    259    227    231    Lax/b3/j;
        //  267    269    231    235    Lax/b3/a;
        //  267    269    227    231    Lax/b3/j;
        //  283    294    304    305    Lax/b3/a;
        //  283    294    300    301    Lax/b3/j;
        //  312    318    594    598    Lax/b3/a;
        //  312    318    590    594    Lax/b3/j;
        //  323    328    331    333    Lax/b3/j;
        //  323    328    304    305    Lax/b3/a;
        //  338    379    386    390    Lax/b3/a;
        //  338    379    382    386    Lax/b3/j;
        //  390    427    586    587    Lax/b3/a;
        //  390    427    582    583    Lax/b3/j;
        //  427    452    555    556    Lax/b3/a;
        //  427    452    551    552    Lax/b3/j;
        //  462    473    555    556    Lax/b3/a;
        //  462    473    551    552    Lax/b3/j;
        //  481    491    231    235    Lax/b3/a;
        //  481    491    227    231    Lax/b3/j;
        //  499    507    231    235    Lax/b3/a;
        //  499    507    227    231    Lax/b3/j;
        //  522    526    231    235    Lax/b3/a;
        //  522    526    227    231    Lax/b3/j;
        //  534    541    231    235    Lax/b3/a;
        //  534    541    227    231    Lax/b3/j;
        //  549    551    231    235    Lax/b3/a;
        //  549    551    227    231    Lax/b3/j;
        //  576    581    231    235    Lax/b3/a;
        //  576    581    227    231    Lax/b3/j;
        //  614    636    703    707    Lax/b3/j;
        //  643    665    707    711    Lax/b3/j;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0665:
        //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
        //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
        //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
        //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
        //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
        //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
        //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
        //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
        //     at s5.b.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:90)
        //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:367)
        //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:162)
        //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
        //     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
        //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1100)
        //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        //     at java.lang.Thread.run(Thread.java:1571)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean i(final long n) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.h((c$a)new c$a(this, atomicBoolean, countDownLatch) {
            final AtomicBoolean a;
            final CountDownLatch b;
            final o c;
            
            public void B() {
            }
            
            public void T(final boolean b, final Object o) {
                this.a.set(b);
                this.b.countDown();
            }
        });
        long n2 = n;
        if (n == 0L) {
            n2 = 20000L;
        }
        try {
            countDownLatch.await(n2, TimeUnit.MILLISECONDS);
            return atomicBoolean.get();
        }
        catch (final InterruptedException ex) {
            return atomicBoolean.get();
        }
    }
    
    public boolean i0() {
        return this.a.c0();
    }
    
    public void j(final n p0, final o p1, final n p2, final boolean p3, final boolean p4, final boolean p5, final ax.u3.c p6, final i p7) throws j, a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/alphainventor/filemanager/file/o.S:()Lax/Q2/f;
        //     4: aload_1        
        //     5: invokevirtual   com/alphainventor/filemanager/file/n.P:()Lax/Q2/f;
        //     8: if_acmpne       17
        //    11: iconst_1       
        //    12: istore          11
        //    14: goto            20
        //    17: iconst_0       
        //    18: istore          11
        //    20: iload           11
        //    22: invokestatic    ax/u3/b.c:(Z)V
        //    25: aload_1        
        //    26: invokeinterface ax/c3/b.isDirectory:()Z
        //    31: invokestatic    ax/u3/b.a:(Z)V
        //    34: aconst_null    
        //    35: astore          14
        //    37: aconst_null    
        //    38: astore          15
        //    40: aconst_null    
        //    41: astore          16
        //    43: aload_1        
        //    44: aload_3        
        //    45: invokestatic    ax/c3/B.N:(Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/n;)Z
        //    48: istore          11
        //    50: aload_3        
        //    51: invokeinterface ax/c3/b.n:()Z
        //    56: ifeq            114
        //    59: aload_2        
        //    60: invokevirtual   com/alphainventor/filemanager/file/o.o0:()Z
        //    63: ifeq            83
        //    66: iload           11
        //    68: ifne            83
        //    71: aconst_null    
        //    72: astore          14
        //    74: iconst_1       
        //    75: istore          9
        //    77: iconst_1       
        //    78: istore          10
        //    80: goto            123
        //    83: aload_2        
        //    84: aload_3        
        //    85: invokestatic    ax/c3/B.z:(Lcom/alphainventor/filemanager/file/o;Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/n;
        //    88: astore          17
        //    90: aload           17
        //    92: astore          14
        //    94: iconst_0       
        //    95: istore          9
        //    97: goto            77
        //   100: astore_1       
        //   101: aload           14
        //   103: astore_3       
        //   104: goto            395
        //   107: astore_1       
        //   108: aload           15
        //   110: astore_3       
        //   111: goto            428
        //   114: aload_3        
        //   115: astore          14
        //   117: iconst_0       
        //   118: istore          9
        //   120: iconst_0       
        //   121: istore          10
        //   123: iload           11
        //   125: ifeq            156
        //   128: aload_0        
        //   129: aload_1        
        //   130: aload           14
        //   132: aload           7
        //   134: aload           8
        //   136: invokevirtual   com/alphainventor/filemanager/file/o.F:(Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/n;Lax/u3/c;Lax/g3/i;)V
        //   139: goto            295
        //   142: astore_1       
        //   143: aload           14
        //   145: astore_3       
        //   146: goto            395
        //   149: astore_1       
        //   150: aload           14
        //   152: astore_3       
        //   153: goto            428
        //   156: iload           4
        //   158: ifeq            175
        //   161: aload_1        
        //   162: invokeinterface ax/c3/b.q:()J
        //   167: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   170: astore          15
        //   172: goto            178
        //   175: aconst_null    
        //   176: astore          15
        //   178: iload           5
        //   180: ifeq            189
        //   183: aload_1        
        //   184: invokevirtual   com/alphainventor/filemanager/file/n.D:()Lcom/alphainventor/filemanager/file/p;
        //   187: astore          16
        //   189: aload_1        
        //   190: invokevirtual   com/alphainventor/filemanager/file/n.c0:()Z
        //   193: istore          4
        //   195: iload           4
        //   197: ifeq            210
        //   200: aload_0        
        //   201: aload_1        
        //   202: invokevirtual   com/alphainventor/filemanager/file/o.r:(Lcom/alphainventor/filemanager/file/n;)V
        //   205: goto            210
        //   208: astore          17
        //   210: iload           9
        //   212: ifeq            250
        //   215: aload_2        
        //   216: aload_3        
        //   217: aload_0        
        //   218: aload_1        
        //   219: invokevirtual   com/alphainventor/filemanager/file/o.x:(Lcom/alphainventor/filemanager/file/n;)Lax/c3/G;
        //   222: aload_1        
        //   223: invokeinterface ax/c3/b.s:()Ljava/lang/String;
        //   228: aload_1        
        //   229: invokeinterface ax/c3/b.p:()J
        //   234: aload           15
        //   236: aload           16
        //   238: iload           6
        //   240: aload           7
        //   242: aload           8
        //   244: invokevirtual   com/alphainventor/filemanager/file/o.s0:(Lcom/alphainventor/filemanager/file/n;Lax/c3/G;Ljava/lang/String;JLjava/lang/Long;Lcom/alphainventor/filemanager/file/p;ZLax/u3/c;Lax/g3/i;)V
        //   247: goto            139
        //   250: aload_0        
        //   251: aload_1        
        //   252: invokevirtual   com/alphainventor/filemanager/file/o.x:(Lcom/alphainventor/filemanager/file/n;)Lax/c3/G;
        //   255: astore          17
        //   257: aload_1        
        //   258: invokeinterface ax/c3/b.s:()Ljava/lang/String;
        //   263: astore          18
        //   265: aload_1        
        //   266: invokeinterface ax/c3/b.p:()J
        //   271: lstore          12
        //   273: aload_2        
        //   274: aload           14
        //   276: aload           17
        //   278: aload           18
        //   280: lload           12
        //   282: aload           15
        //   284: aload           16
        //   286: iload           6
        //   288: aload           7
        //   290: aload           8
        //   292: invokevirtual   com/alphainventor/filemanager/file/o.D:(Lcom/alphainventor/filemanager/file/n;Lax/c3/G;Ljava/lang/String;JLjava/lang/Long;Lcom/alphainventor/filemanager/file/p;ZLax/u3/c;Lax/g3/i;)V
        //   295: iload           10
        //   297: ifeq            378
        //   300: iload           9
        //   302: ifne            378
        //   305: aload_2        
        //   306: aload           14
        //   308: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   311: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //   314: astore          7
        //   316: aload           7
        //   318: invokeinterface ax/c3/b.n:()Z
        //   323: ifeq            351
        //   326: aload_0        
        //   327: aload_2        
        //   328: aload_3        
        //   329: aload           7
        //   331: invokespecial   com/alphainventor/filemanager/file/o.l:(Lcom/alphainventor/filemanager/file/o;Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/n;)V
        //   334: goto            378
        //   337: astore_1       
        //   338: aload           7
        //   340: astore_3       
        //   341: goto            395
        //   344: astore_1       
        //   345: aload           7
        //   347: astore_3       
        //   348: goto            428
        //   351: new             Lax/b3/t;
        //   354: astore_1       
        //   355: aload_1        
        //   356: ldc_w           "tmp file not exists"
        //   359: invokespecial   ax/b3/t.<init>:(Ljava/lang/String;)V
        //   362: aload_1        
        //   363: athrow         
        //   364: astore_1       
        //   365: aload           14
        //   367: astore_3       
        //   368: goto            395
        //   371: astore_1       
        //   372: aload           14
        //   374: astore_3       
        //   375: goto            428
        //   378: return         
        //   379: astore_1       
        //   380: goto            365
        //   383: astore_1       
        //   384: goto            372
        //   387: astore_1       
        //   388: goto            365
        //   391: astore_1       
        //   392: goto            372
        //   395: aload_3        
        //   396: ifnull          422
        //   399: aload_2        
        //   400: aload_3        
        //   401: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   404: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //   407: astore_3       
        //   408: aload_3        
        //   409: invokeinterface ax/c3/b.n:()Z
        //   414: ifeq            422
        //   417: aload_2        
        //   418: aload_3        
        //   419: invokevirtual   com/alphainventor/filemanager/file/o.P:(Lcom/alphainventor/filemanager/file/n;)V
        //   422: aload_1        
        //   423: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   426: aload_1        
        //   427: athrow         
        //   428: aload_3        
        //   429: ifnull          455
        //   432: aload_2        
        //   433: aload_3        
        //   434: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   437: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //   440: astore_3       
        //   441: aload_3        
        //   442: invokeinterface ax/c3/b.n:()Z
        //   447: ifeq            455
        //   450: aload_2        
        //   451: aload_3        
        //   452: invokevirtual   com/alphainventor/filemanager/file/o.P:(Lcom/alphainventor/filemanager/file/n;)V
        //   455: aload_1        
        //   456: athrow         
        //   457: astore_2       
        //   458: goto            422
        //   461: astore_2       
        //   462: goto            455
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type     
        //  -----  -----  -----  -----  ---------
        //  43     66     107    114    Lax/b3/a;
        //  43     66     100    107    Lax/b3/j;
        //  83     90     107    114    Lax/b3/a;
        //  83     90     100    107    Lax/b3/j;
        //  128    139    149    156    Lax/b3/a;
        //  128    139    142    149    Lax/b3/j;
        //  161    172    149    156    Lax/b3/a;
        //  161    172    142    149    Lax/b3/j;
        //  183    189    149    156    Lax/b3/a;
        //  183    189    142    149    Lax/b3/j;
        //  189    195    391    395    Lax/b3/a;
        //  189    195    387    391    Lax/b3/j;
        //  200    205    208    210    Lax/b3/j;
        //  200    205    149    156    Lax/b3/a;
        //  215    247    149    156    Lax/b3/a;
        //  215    247    142    149    Lax/b3/j;
        //  250    273    391    395    Lax/b3/a;
        //  250    273    387    391    Lax/b3/j;
        //  273    295    383    387    Lax/b3/a;
        //  273    295    379    383    Lax/b3/j;
        //  305    316    371    372    Lax/b3/a;
        //  305    316    364    365    Lax/b3/j;
        //  316    334    344    351    Lax/b3/a;
        //  316    334    337    344    Lax/b3/j;
        //  351    364    344    351    Lax/b3/a;
        //  351    364    337    344    Lax/b3/j;
        //  399    422    457    461    Lax/b3/j;
        //  432    455    461    465    Lax/b3/j;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0455:
        //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
        //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
        //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
        //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
        //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
        //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
        //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
        //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
        //     at s5.b.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:90)
        //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:367)
        //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:162)
        //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
        //     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
        //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1100)
        //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        //     at java.lang.Thread.run(Thread.java:1571)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public ax.l3.a j0(final String s, final int n) throws j {
        return this.a.e0(s, n);
    }
    
    public boolean k(n z, final boolean b) {
        Label_0070: {
            if (b) {
                break Label_0070;
            }
            try {
                final boolean m = ((c)this.a).M(z);
                if (m) {
                    ax.Z2.b.k().p(this.T(), z.T());
                    ax.Z2.b.k().e(z);
                    if (this.a0()) {
                        z = this.z(z.E());
                        ax.T2.h.S(this.T()).b(z);
                    }
                }
                return m;
                Label_0115: {
                    final n z2;
                    iftrue(Label_0137:)(!this.k(z2, true) || !this.k(z, false));
                }
                return true;
                iftrue(Label_0081:)(!this.k(z, false));
                return true;
                Label_0137:
                return false;
                final String t;
                Label_0098:
                final n z2 = this.z(t);
                iftrue(Label_0115:)(!((ax.c3.b)z2).n());
                return false;
                Label_0081:
                t = z.T();
                iftrue(Label_0098:)(!d0.a.equals((Object)t));
                return false;
            }
            catch (final j j) {
                return false;
            }
        }
    }
    
    public void k0(final boolean b) {
        monitorenter(this);
        Label_0091: {
            try {
                if (this.b.get() == 0) {
                    o.m.severe("OPEROATOR RELEASED MORE THAN RETAINED!!!!!");
                    final ax.Ha.b j = ax.Ha.c.h().d("REL").j();
                    final StringBuilder sb = new StringBuilder();
                    sb.append(this.S().I());
                    sb.append(":");
                    sb.append(this.R());
                    j.g((Object)sb.toString()).h();
                    break Label_0091;
                }
                break Label_0091;
            }
            finally {
                monitorexit(this);
            Block_5_Outer:
                while (true) {
                    while (true) {
                    Label_0236:
                        while (true) {
                            while (true) {
                                Q.a0();
                                final com.alphainventor.filemanager.file.x x;
                                x.G0();
                                break Label_0236;
                                x = (com.alphainventor.filemanager.file.x)this.u();
                                iftrue(Label_0236:)(!x.g1());
                                continue Block_5_Outer;
                            }
                            monitorexit(this);
                            return;
                            new b(this).i((Object[])new Long[0]);
                            continue Label_0236;
                        }
                        this.l = this.k;
                        this.k = this.j;
                        this.j = this.i;
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("(");
                        sb2.append(this.b.get());
                        sb2.append(") ");
                        sb2.append(ax.Q2.a.g());
                        this.i = sb2.toString();
                        iftrue(Label_0195:)(!this.L());
                        continue;
                    }
                    Label_0195: {
                        this.l0();
                    }
                    iftrue(Label_0236:)(!b || !(this.u() instanceof com.alphainventor.filemanager.file.x));
                    continue Block_5_Outer;
                }
            }
        }
    }
    
    public void m(final n n) throws j {
        if (this.O()) {
            this.I(n);
            return;
        }
        if (((ax.c3.b)n).isDirectory()) {
            final Iterator iterator = this.f0(n).iterator();
            while (iterator.hasNext()) {
                this.m((n)iterator.next());
            }
            this.P(n);
            return;
        }
        this.P(n);
    }
    
    public void m0(final n n, final n n2, final ax.u3.c c, final i i) throws j, a {
        if (((ax.c3.b)n2).n()) {
            throw new ax.b3.f(((ax.c3.b)n).isDirectory() != ((ax.c3.b)n2).isDirectory());
        }
        this.E(n, n2, c, i);
    }
    
    public void n(final i i) {
        if (!(this.u() instanceof com.alphainventor.filemanager.file.x)) {
            return;
        }
        ((com.alphainventor.filemanager.file.x)this.u()).E0(i);
    }
    
    public void n0() {
        synchronized (this) {
            this.b.getAndIncrement();
            this.h = this.g;
            this.g = this.f;
            this.f = this.e;
            final StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(this.b.get());
            sb.append(") ");
            sb.append(ax.Q2.a.g());
            this.e = sb.toString();
        }
    }
    
    public void o(final n n, final String s, final boolean b, final boolean b2, final ax.g3.h h, final ax.u3.c c) throws j {
        this.a.m(n, s, b, b2, h, c);
    }
    
    public boolean o0() {
        return this.a.g0();
    }
    
    public void p(final n n, final File file, final ax.u3.c c, final i i) throws j, a {
        final o f = x.f(file);
        n n3;
        final n n2 = n3 = f.z(file.getAbsolutePath());
        if (((ax.c3.b)n2).n()) {
            f.P(n2);
            n3 = f.z(file.getAbsolutePath());
        }
        this.j(n, f, n3, System.currentTimeMillis() <= ((ax.c3.b)n).q(), false, false, c, i);
    }
    
    public boolean p0() {
        return this.a.h0();
    }
    
    public void q(final n n, final m.f f) throws j {
        List list;
        if ((list = ax.Z2.b.k().g(n)) == null) {
            list = this.C(n, f);
        }
        n.d0(list.size());
    }
    
    public boolean q0() {
        return this.a.i0();
    }
    
    public void r(final n n) throws j {
        this.a.n(n);
    }
    
    public boolean r0() {
        return this.a instanceof i0;
    }
    
    public void s(final n n, final m.f f) throws j {
        n.d0(this.C(n, f).size());
    }
    
    public void s0(final n n, final G g, final String s, final long n2, final Long n3, final p p9, final boolean b, final ax.u3.c c, final i i) throws j, a {
        ax.Z2.b.k().p(this.T(), n.T());
        ax.Z2.b.k().e(n);
        this.a.j0(n, g, s, n2, n3, p9, b, c, i);
        if (this.b0(n)) {
            ax.T2.h.T(n).b(n);
        }
    }
    
    public Context t() {
        return this.d;
    }
    
    public void t0(n a, final o o, n a2, ax.u3.c z, final i i) throws j, a {
        Object z2 = null;
        Object o2 = null;
        Label_0385: {
            while (true) {
                try {
                    final boolean n = ((ax.c3.b)a2).n();
                    boolean b = false;
                    boolean b2 = false;
                    Label_0081: {
                        if (n) {
                            try {
                                if (!o.o0()) {
                                    if (!o.p0()) {
                                        o2 = (z2 = B.z(o, (n)a2));
                                        b2 = true;
                                        break Label_0081;
                                    }
                                }
                            }
                            catch (final a a2) {
                                a = (a)z2;
                                break Label_0385;
                            }
                            z2 = null;
                            b2 = true;
                            b = true;
                        }
                        else {
                            z2 = a2;
                            b2 = false;
                        }
                    }
                    Label_0221: {
                        if (b) {
                            try {
                                o.o0();
                                final o o3 = this;
                                final a a3 = a;
                                o2 = o3.x((n)a3);
                                final a a4 = a;
                                final String s = ((ax.c3.b)a4).s();
                                final a a5 = a;
                                final long n2 = ((ax.c3.b)a5).p();
                                final a a6 = a;
                                final long n3 = ((ax.c3.b)a6).q();
                                final a a7 = a;
                                final p p5 = ((n)a7).D();
                                final o o4 = o;
                                final a a8 = a2;
                                final Object o5 = o2;
                                final String s2 = s;
                                final long n4 = n2;
                                final long n5 = n3;
                                final Long n6 = n5;
                                final p p6 = p5;
                                final boolean b3 = true;
                                final ax.u3.c c = z;
                                final i j = i;
                                o4.s0((n)a8, (G)o5, s2, n4, n6, p6, b3, c, j);
                                return;
                            }
                            catch (final a a2) {
                                a = (a)z2;
                                break Label_0385;
                            }
                            try {
                                final o o3 = this;
                                final a a3 = a;
                                o2 = o3.x((n)a3);
                                final a a4 = a;
                                final String s = ((ax.c3.b)a4).s();
                                final a a5 = a;
                                final long n2 = ((ax.c3.b)a5).p();
                                final a a6 = a;
                                final long n3 = ((ax.c3.b)a6).q();
                                final a a7 = a;
                                final p p5 = ((n)a7).D();
                                try {
                                    final o o4 = o;
                                    final a a8 = a2;
                                    final Object o5 = o2;
                                    final String s2 = s;
                                    final long n4 = n2;
                                    final long n5 = n3;
                                    final Long n6 = n5;
                                    final p p6 = p5;
                                    final boolean b3 = true;
                                    final ax.u3.c c = z;
                                    final i j = i;
                                    o4.s0((n)a8, (G)o5, s2, n4, n6, p6, b3, c, j);
                                    return;
                                }
                                catch (final z o2) {}
                            }
                            catch (final z z3) {}
                            final n z4 = B.z(o, (n)a2);
                            try {
                                o.D(z4, this.x((n)a), ((ax.c3.b)a).s(), ((ax.c3.b)a).p(), ((ax.c3.b)a).q(), ((n)a).D(), true, z, i);
                                throw o2;
                            }
                            catch (final a a2) {
                                a = (a)z4;
                            }
                        }
                        else {
                            try {
                                o2 = this.x((n)a);
                                final String s3 = ((ax.c3.b)a).s();
                                final long p7 = ((ax.c3.b)a).p();
                                final long q = ((ax.c3.b)a).q();
                                final p d = ((n)a).D();
                                try {
                                    o.D((n)z2, (G)o2, s3, p7, q, d, true, z, i);
                                    if (b2) {
                                        try {
                                            z = (ax.u3.c)o.z(((n)z2).E());
                                            Label_0338: {
                                                try {
                                                    if (!((ax.c3.b)z).n()) {
                                                        throw new t("tmp file not exists");
                                                    }
                                                    if (((ax.c3.b)a).p() == 0L) {
                                                        this.d(o, (n)a2, (n)z);
                                                        return;
                                                    }
                                                    break Label_0338;
                                                }
                                                catch (final a a2) {
                                                    a = (a)z;
                                                }
                                                break Label_0385;
                                            }
                                            this.l(o, (n)a2, (n)z);
                                            return;
                                            a = (a)new t("tmp file not exists");
                                            throw a;
                                        }
                                        catch (final a a9) {}
                                        a2 = a;
                                        a = (a)z2;
                                        break Label_0221;
                                    }
                                    return;
                                }
                                catch (final a a) {}
                            }
                            catch (final a a) {}
                        }
                    }
                }
                catch (final a a2) {
                    a = (a)o2;
                    continue;
                }
                break;
            }
        }
        Label_0394: {
            if (a == null) {
                break Label_0394;
            }
            try {
                o.P((n)a);
                throw a2;
            }
            catch (final j k) {
                throw a2;
            }
        }
    }
    
    public m u() {
        return this.a;
    }
    
    public boolean u0(final n n) {
        return ax.Q2.f.E0(this.S(), n);
    }
    
    public long v() throws j {
        return this.a.q();
    }
    
    public void v0(final n j, final G g, final String s, final long n, final Long n2, final p p9, final boolean b, final ax.u3.c c, final i i) throws j, a {
        while (true) {
            final n n3 = null;
            Object z;
            final Object o = z = null;
            n n4 = n3;
            Label_0232: {
                boolean b2 = false;
                boolean b3 = false;
                Label_0103: {
                    while (true) {
                        try {
                            if (((ax.c3.b)j).n()) {
                                z = o;
                                n4 = n3;
                                final boolean o2 = this.o0();
                                b2 = true;
                                if (o2) {
                                    z = null;
                                    b3 = true;
                                    break Label_0103;
                                }
                                z = o;
                                n4 = n3;
                                z = B.z(this, (n)j);
                                b3 = true;
                                b2 = false;
                                break Label_0103;
                            }
                        }
                        catch (final j j) {
                            break Label_0232;
                        }
                        catch (final a j) {
                            z = n4;
                            break Label_0232;
                        }
                        z = j;
                        b3 = false;
                        continue;
                    }
                }
                if (b2) {
                    try {
                        this.s0((n)j, g, s, n, n2, p9, b, c, i);
                        return;
                    }
                    catch (final j k) {}
                    catch (final a j) {
                        goto Label_0129;
                    }
                }
                this.D((n)z, g, s, n, n2, p9, b, c, i);
                if (!b3) {
                    return;
                }
                final n z2 = this.z(((n)z).E());
                if (((ax.c3.b)z2).n()) {
                    this.l(this, (n)j, z2);
                    return;
                }
                throw new t("tmp file not exists");
            }
            Label_0243: {
                if (z == null) {
                    break Label_0243;
                }
                try {
                    this.P((n)z);
                    throw j;
                }
                catch (final j l) {
                    throw j;
                }
            }
        }
    }
    
    public String w() {
        return this.a.r();
    }
    
    public G x(final n n) {
        return this.a.s(n);
    }
    
    public int y() {
        return this.a.t();
    }
    
    public n z(final String s) throws j {
        if (d0.B(s)) {
            return ((c)this.a).z(s);
        }
        final ax.Ha.b j = ax.Ha.c.h().f().b("GFI!!!").j();
        final StringBuilder sb = new StringBuilder();
        sb.append(this.S().I());
        sb.append(":");
        sb.append(s);
        j.g((Object)sb.toString()).h();
        throw new j("Not normalzied path in getFileInfo param");
    }
    
    public static class b extends q<Long, Long, Long>
    {
        o h;
        
        public b(final o h) {
            super(q$e.e0);
            this.h = h;
        }
        
        protected Long w(final Long... array) {
            this.h.l0();
            return null;
        }
    }
}
