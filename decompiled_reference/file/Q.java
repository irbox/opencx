package com.alphainventor.filemanager.file;

import javax.net.SocketFactory;
import java.io.BufferedReader;
import java.lang.reflect.AccessibleObject;
import java.text.DateFormat;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.Set;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSession;
import java.util.Collection;
import javax.net.ssl.SSLSocket;
import java.net.Socket;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import java.util.Map$Entry;
import java.util.HashMap;
import ax.c3.c0;
import ax.c3.g0;
import ax.c3.H;
import ax.Sc.u;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import ax.u3.B;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import javax.net.ssl.SSLContext;
import ax.u3.q$e;
import androidx.fragment.app.Fragment;
import android.app.Activity;
import ax.b3.K;
import java.io.File;
import ax.c3.x;
import java.util.Iterator;
import java.lang.reflect.Field;
import ax.c3.D;
import android.text.TextUtils;
import java.util.ArrayList;
import ax.c3.G;
import java.util.List;
import java.io.InputStream;
import java.util.Date;
import j$.util.DesugarTimeZone;
import ax.Ha.c;
import ax.Sc.l;
import ax.b3.o;
import ax.b3.s;
import ax.u3.b;
import ax.b3.f;
import ax.b3.k;
import ax.b3.d;
import ax.Sc.h;
import ax.b3.j;
import ax.c3.d0;
import java.io.IOException;
import ax.Rc.a;
import java.util.Calendar;
import ax.Tc.g;
import java.util.Locale;
import ax.Sc.i;
import android.os.Build$VERSION;
import ax.Sc.t;
import android.content.Context;
import ax.Sc.e;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import ax.c3.i0;

public class q extends m implements i0
{
    private static final Logger u;
    static g v;
    private static int w;
    private static int x;
    private static int y;
    private SimpleDateFormat h;
    private d i;
    private ax.Sc.e j;
    private final Object k;
    private e l;
    private String m;
    private String n;
    private String o;
    private String p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean t;
    
    static {
        u = Logger.getLogger("FileManager.FtpFileHelper");
        q.w = 0;
        q.x = 1;
        q.y = 2;
    }
    
    public q() {
        this.k = new Object();
        this.t = false;
    }
    
    protected static void A0(final Context context) {
        if (G0()) {
            m.X(context);
        }
    }
    
    private boolean C0(final int n) {
        return ax.Sc.t.a(n) || ax.Sc.t.b(n);
    }
    
    public static boolean D0(final int n) {
        return n >= 100000000;
    }
    
    private static boolean G0() {
        return Build$VERSION.SDK_INT > 28;
    }
    
    public static ax.Sc.i H0(String string, final String s) throws IOException {
        String string2 = string;
        if (string.charAt(0) != ' ') {
            final String lowerCase = string.toLowerCase(Locale.ROOT);
            if (string.startsWith("250-modify")) {
                return ax.Tc.g.g(string.substring(4));
            }
            if (lowerCase.startsWith("250 end")) {
                return null;
            }
            string2 = string;
            if (string.length() >= 2) {
                string2 = string;
                if (string.endsWith("; ")) {
                    string2 = string;
                    if (string.startsWith("Size=")) {
                        string2 = string;
                        if ("/".equals((Object)s)) {
                            final String[] split = string.split(" ", 2);
                            string2 = string;
                            if (split.length == 2) {
                                string2 = string;
                                if (split[1].length() == 0) {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append(string);
                                    sb.append(s);
                                    string2 = sb.toString();
                                }
                            }
                        }
                    }
                }
                final ax.Sc.i g = ax.Tc.g.g(string2);
                if (g != null) {
                    return g;
                }
            }
        }
        if (string2.equals((Object)" /") && "/".equals((Object)s)) {
            final ax.Sc.i i = new ax.Sc.i();
            i.q(1);
            i.l(s);
            final Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(0L);
            i.n(string2);
            i.p(instance);
            return i;
        }
        string = string2;
        if (string2.charAt(0) != ' ') {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            sb2.append(string2);
            string = sb2.toString();
        }
        if (string.length() >= 3) {
            return ax.Tc.g.g(string.replaceAll("^\\s+", ""));
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Invalid server reply (MLST): '");
        sb3.append(string);
        sb3.append("'");
        throw new a(sb3.toString());
    }
    
    private void I0() {
        this.b();
        this.o0();
    }
    
    private boolean L0(final ax.Sc.e e, final n n, final long n2, final boolean b) {
        if (n2 <= 0L) {
            return false;
        }
        try {
            if (this.O0() && ((ax.Rc.e)e).w()) {
                if (b) {
                    ((ax.Sc.c)e).X(n.E(), this.y0(n2));
                }
                else {
                    ((ax.Sc.c)e).X(n.B(), this.y0(n2));
                }
                return true;
            }
            return false;
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    private boolean N0() {
        return this.s != com.alphainventor.filemanager.file.q.x;
    }
    
    private boolean O0() throws IOException {
        return this.j.Z0("MFMT");
    }
    
    private boolean P0() throws IOException {
        return this.j.Z0("MLSD") || this.j.Z0("MLST");
    }
    
    private boolean Q0() throws IOException {
        return this.j.Z0("MLST");
    }
    
    private void R0() {
        final Object k;
        monitorenter(k = this.k);
        while (true) {
            Label_0046: {
                try {
                    if (this.a() && ((ax.Rc.e)this.j).v()) {
                        final boolean b = false;
                        break Label_0048;
                    }
                    break Label_0046;
                }
                finally {
                    monitorexit(k);
                    monitorexit(k);
                    final boolean b;
                    iftrue(Label_0060:)(!b);
                    Block_6: {
                        break Block_6;
                        final Object i;
                        Label_0060: {
                            monitorenter(i = this.k);
                        }
                        try {
                            try {
                                final boolean b2 = true ^ this.j.v1();
                            }
                            finally {
                                monitorexit(i);
                                while (true) {
                                    monitorexit(i);
                                    return;
                                    this.I0();
                                    continue;
                                }
                                final boolean b2;
                                iftrue(Label_0109:)(!b2);
                            }
                        }
                        catch (final IOException ex) {}
                        b = true;
                        continue;
                    }
                    this.o0();
                }
            }
            break;
        }
    }
    
    private void o0() {
        try {
            new d(this.p(), this, this.t(), null).h(new Object[0]).l();
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
        }
    }
    
    private boolean p0(final String s) throws IOException {
        return s.equals((Object)this.n) || ax.Sc.t.c(this.q0(this.j, s));
    }
    
    private int q0(final ax.Sc.e e, String q1) throws IOException {
        final boolean b0 = e.B0(d0.O(q1));
        final int r = ((ax.Sc.c)e).R();
        if (b0) {
            if (e == this.j) {
                this.n = q1;
                return r;
            }
            return r;
        }
        else if (r != 550 || !"/".equals((Object)q1)) {
            return r;
        }
        try {
            do {
                q1 = e.q1();
                if (q1 == null) {
                    break;
                }
                if ("/".equals((Object)q1)) {
                    return 250;
                }
            } while (ax.Sc.t.c(((ax.Sc.c)e).I()));
            return r;
        }
        catch (final IOException ex) {
            return r;
        }
    }
    
    private boolean r0(final String s) throws IOException {
        return "/".equals((Object)s) || (s != null && s.equals((Object)this.m) && ax.Sc.t.c(this.q0(this.j, s)));
    }
    
    private ax.b3.j s0(final String s, final IOException ex) {
        if (ex instanceof ax.Sc.h) {
            return (ax.b3.j)new ax.b3.q((Throwable)ex);
        }
        return ax.b3.d.b(s, (Exception)ex);
    }
    
    private ax.b3.j t0(String string, final int n, String lowerCase, final boolean b) {
        final StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(" (");
        sb.append(lowerCase);
        sb.append(")");
        string = sb.toString();
        if (n == 550) {
            if (lowerCase != null) {
                final String lowerCase2 = lowerCase.toLowerCase();
                if (lowerCase2.contains((CharSequence)"no such") || lowerCase2.contains((CharSequence)"not found")) {
                    return (ax.b3.j)new ax.b3.t(string);
                }
                if (lowerCase2.contains((CharSequence)"access") || lowerCase2.contains((CharSequence)"permission")) {
                    return (ax.b3.j)new ax.b3.e(string);
                }
                if (lowerCase2.contains((CharSequence)"not empty")) {
                    return (ax.b3.j)new ax.b3.k(string);
                }
                if (lowerCase2.contains((CharSequence)"already exist")) {
                    return (ax.b3.j)new ax.b3.f(false);
                }
                b.e(lowerCase);
                if (b) {
                    return (ax.b3.j)new ax.b3.t(string);
                }
                return (ax.b3.j)new ax.b3.e(string);
            }
            else {
                if (b) {
                    return (ax.b3.j)new ax.b3.t(string);
                }
                return (ax.b3.j)new ax.b3.e(string);
            }
        }
        else {
            if (n == 452) {
                return (ax.b3.j)new s(string);
            }
            if (n == 552) {
                return (ax.b3.j)new s(string);
            }
            if (n == 553) {
                if (lowerCase != null) {
                    lowerCase = lowerCase.toLowerCase();
                    if (lowerCase.contains((CharSequence)"access") || lowerCase.contains((CharSequence)"permission")) {
                        return (ax.b3.j)new ax.b3.e(string);
                    }
                    if (lowerCase.contains((CharSequence)"name")) {
                        return (ax.b3.j)new o(string);
                    }
                }
                return (ax.b3.j)new ax.b3.e(string);
            }
            if (n == 425) {
                return (ax.b3.j)new ax.b3.q(string);
            }
            if (n == 426) {
                return (ax.b3.j)new ax.b3.q(string);
            }
            return new ax.b3.j(string);
        }
    }
    
    private static void v0(final ax.Sc.e e) {
        if (e != null && ((ax.Rc.e)e).w()) {
            try {
                e.o();
            }
            catch (final IOException ex) {
                ((Throwable)ex).printStackTrace();
            }
        }
    }
    
    public static int w0() {
        return 21;
    }
    
    private ax.Sc.i x0(final String s) throws IOException {
        if ("/".equals((Object)s)) {
            return null;
        }
        final String h = d0.h(s);
        final int q0 = this.q0(this.j, d0.r(s));
        if (!ax.Sc.t.c(q0)) {
            if (q0 == 550) {
                return null;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("ChangeWorkingDirectory Error :");
            sb.append(((ax.Sc.c)this.j).R());
            throw new IOException(sb.toString());
        }
        else {
            try {
                final ax.Sc.i[] k1 = this.j.k1((String)null, (l)new l(this, h) {
                    final String a;
                    final q b;
                    
                    public boolean a(final ax.Sc.i i) {
                        return i != null && i.b().trim().equals((Object)this.a);
                    }
                });
                if (k1.length == 0) {
                    return null;
                }
                return k1[0];
            }
            catch (final IllegalStateException ex) {
                final ax.Ha.b l = c.h().f().d("FTP ILLEGALSTATE").l((Throwable)ex);
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("mode: ");
                sb2.append(this.j.K0());
                l.g((Object)sb2.toString()).h();
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("IllegalState : ");
                sb3.append(((Throwable)ex).getMessage());
                throw new IOException(sb3.toString());
            }
        }
    }
    
    private String y0(final long n) {
        if (this.h == null) {
            ((DateFormat)(this.h = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US))).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }
        return ((DateFormat)this.h).format(new Date(n));
    }
    
    public static g z0(final Context context) {
        if (q.v == null) {
            q.v = new g(context.getApplicationContext());
        }
        return q.v;
    }
    
    public InputStream A(final String s, final String s2, final String s3) {
        if (this.q) {
            return null;
        }
        return this.w(s, s2);
    }
    
    public boolean B(final n n) {
        return true;
    }
    
    boolean B0() {
        return this.j instanceof j;
    }
    
    public List<n> C(n e0, final m.f f) throws ax.b3.j {
        if (((ax.c3.b)e0).n()) {
            b.c(((ax.c3.b)e0).isDirectory());
            this.R0();
            final String b = ((n)e0).B();
            final String e2 = ((n)e0).E();
            Label_0261: {
                Label_0218: {
                    try {
                        final Object k;
                        monitorenter(k = this.k);
                        Label_0066: {
                            try {
                                if (this.N0()) {
                                    this.j.z1(true);
                                }
                                break Label_0066;
                            }
                            finally {
                                monitorexit(k);
                                Label_0154: {
                                    final int q0;
                                    throw this.t0("FTP listChildren CWD", q0, ((ax.Sc.c)this.j).S(), false);
                                }
                                while (true) {
                                    final List<n> e3 = this.E0(b, e2, false);
                                    monitorexit(k);
                                    return e3;
                                    final int q0 = this.q0(this.j, e2);
                                    iftrue(Label_0154:)(!ax.Sc.t.c(q0));
                                    Block_8: {
                                        break Block_8;
                                        ((Throwable)e0).printStackTrace();
                                        continue;
                                    }
                                    iftrue(Label_0139:)(!this.P0());
                                    try {
                                        e0 = (IllegalArgumentException)this.E0(b, e2, true);
                                        if (e0 != null) {
                                            monitorexit(k);
                                            return (List<n>)e0;
                                        }
                                        continue;
                                    }
                                    catch (final IllegalArgumentException e0) {}
                                    catch (final ax.b3.j e0) {}
                                    catch (final IllegalStateException e0) {}
                                    catch (final ax.Tc.n e0) {}
                                    catch (final StringIndexOutOfBoundsException e0) {}
                                    catch (final NullPointerException ex) {}
                                    break;
                                }
                            }
                        }
                    }
                    catch (final IllegalArgumentException ex2) {}
                    catch (final IllegalStateException ex3) {
                        throw new ax.b3.j((Throwable)ex3);
                    }
                    catch (final ax.Tc.n n) {
                        break Label_0218;
                    }
                    catch (final StringIndexOutOfBoundsException ex4) {
                        throw new ax.b3.j((Throwable)ex4);
                    }
                    catch (final NullPointerException ex5) {
                        throw new ax.b3.j((Throwable)ex5);
                    }
                    catch (final IOException ex6) {
                        break Label_0261;
                    }
                    final IllegalArgumentException ex2;
                    throw new ax.b3.j((Throwable)ex2);
                }
                final ax.Tc.n n;
                c.h().d("PARSER ERROR").l((Throwable)n).h();
                throw new ax.b3.j((Throwable)n);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("FTP listchildren FTPS=");
            sb.append(this.B0());
            final IOException ex6;
            throw this.s0(sb.toString(), ex6);
        }
        throw new ax.b3.t();
    }
    
    public void D(final n p0, final G p1, final String p2, final long p3, final Long p4, final p p5, final boolean p6, final ax.u3.c p7, final ax.g3.i p8) throws ax.b3.j, ax.b3.a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   com/alphainventor/filemanager/file/q.R0:()V
        //     4: aload_1        
        //     5: invokeinterface ax/c3/b.n:()Z
        //    10: invokestatic    ax/u3/b.a:(Z)V
        //    13: aconst_null    
        //    14: astore          19
        //    16: aconst_null    
        //    17: astore          7
        //    19: aconst_null    
        //    20: astore          17
        //    22: aconst_null    
        //    23: astore          20
        //    25: aload_0        
        //    26: getfield        com/alphainventor/filemanager/file/q.q:Z
        //    29: istore          8
        //    31: iload           8
        //    33: ifeq            74
        //    36: aload_0        
        //    37: getfield        com/alphainventor/filemanager/file/q.j:Lax/Sc/e;
        //    40: astore_3       
        //    41: goto            176
        //    44: astore          6
        //    46: aconst_null    
        //    47: astore_3       
        //    48: aconst_null    
        //    49: astore_1       
        //    50: aload           17
        //    52: astore_2       
        //    53: goto            1072
        //    56: astore_1       
        //    57: aconst_null    
        //    58: astore          6
        //    60: aconst_null    
        //    61: astore          9
        //    63: aload_1        
        //    64: astore_3       
        //    65: aload           7
        //    67: astore_2       
        //    68: aload           9
        //    70: astore_1       
        //    71: goto            1052
        //    74: aload_0        
        //    75: getfield        com/alphainventor/filemanager/file/q.l:Lcom/alphainventor/filemanager/file/q$e;
        //    78: invokevirtual   com/alphainventor/filemanager/file/q$e.f:()Lax/Sc/e;
        //    81: astore_3       
        //    82: aload_3        
        //    83: astore          7
        //    85: aload_3        
        //    86: astore          15
        //    88: aload_0        
        //    89: iconst_1       
        //    90: putfield        com/alphainventor/filemanager/file/q.r:Z
        //    93: goto            176
        //    96: astore          6
        //    98: aload           7
        //   100: astore_3       
        //   101: aconst_null    
        //   102: astore_1       
        //   103: aload           17
        //   105: astore_2       
        //   106: goto            1072
        //   109: astore_2       
        //   110: aload           15
        //   112: astore_3       
        //   113: aconst_null    
        //   114: astore          6
        //   116: aconst_null    
        //   117: astore_1       
        //   118: aload_3        
        //   119: astore          7
        //   121: aload_2        
        //   122: astore_3       
        //   123: aload           7
        //   125: astore_2       
        //   126: goto            1052
        //   129: astore          7
        //   131: goto            138
        //   134: astore          7
        //   136: aconst_null    
        //   137: astore_3       
        //   138: aload_3        
        //   139: astore          16
        //   141: aload_3        
        //   142: astore          15
        //   144: aload_0        
        //   145: getfield        com/alphainventor/filemanager/file/q.r:Z
        //   148: ifne            1008
        //   151: aload_3        
        //   152: astore          16
        //   154: aload_3        
        //   155: astore          15
        //   157: aload_0        
        //   158: iconst_1       
        //   159: invokevirtual   com/alphainventor/filemanager/file/q.M0:(Z)V
        //   162: aload_3        
        //   163: astore          16
        //   165: aload_3        
        //   166: astore          15
        //   168: aload_0        
        //   169: getfield        com/alphainventor/filemanager/file/q.j:Lax/Sc/e;
        //   172: astore_3       
        //   173: goto            41
        //   176: aload_3        
        //   177: astore          16
        //   179: aload_3        
        //   180: astore          15
        //   182: aload_0        
        //   183: getfield        com/alphainventor/filemanager/file/q.j:Lax/Sc/e;
        //   186: astore          7
        //   188: aload_3        
        //   189: aload           7
        //   191: if_acmpne       213
        //   194: aload_3        
        //   195: astore          7
        //   197: aload_3        
        //   198: astore          15
        //   200: aload_0        
        //   201: getfield        com/alphainventor/filemanager/file/q.k:Ljava/lang/Object;
        //   204: astore          16
        //   206: aload           16
        //   208: astore          7
        //   210: goto            216
        //   213: aload_3        
        //   214: astore          7
        //   216: aload_3        
        //   217: astore          16
        //   219: aload_3        
        //   220: astore          15
        //   222: aload           7
        //   224: dup            
        //   225: astore          21
        //   227: monitorenter   
        //   228: aload_0        
        //   229: aload_3        
        //   230: aload_1        
        //   231: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //   234: invokespecial   com/alphainventor/filemanager/file/q.q0:(Lax/Sc/e;Ljava/lang/String;)I
        //   237: istore          12
        //   239: iload           12
        //   241: invokestatic    ax/Sc/t.c:(I)Z
        //   244: istore          8
        //   246: iconst_0       
        //   247: istore          11
        //   249: iload           8
        //   251: ifeq            939
        //   254: aload_3        
        //   255: checkcast       Lcom/alphainventor/filemanager/file/q$h;
        //   258: bipush          30
        //   260: invokeinterface com/alphainventor/filemanager/file/q$h.a:(I)V
        //   265: aload_3        
        //   266: aload_1        
        //   267: invokevirtual   com/alphainventor/filemanager/file/n.B:()Ljava/lang/String;
        //   270: invokevirtual   ax/Sc/e.D1:(Ljava/lang/String;)Ljava/io/OutputStream;
        //   273: astore          16
        //   275: aload_3        
        //   276: checkcast       Lcom/alphainventor/filemanager/file/q$h;
        //   279: iconst_m1      
        //   280: invokeinterface com/alphainventor/filemanager/file/q$h.a:(I)V
        //   285: aload           16
        //   287: ifnonnull       407
        //   290: aload_3        
        //   291: invokevirtual   ax/Sc/c.R:()I
        //   294: istore          11
        //   296: aload_3        
        //   297: invokevirtual   ax/Sc/c.S:()Ljava/lang/String;
        //   300: astore_1       
        //   301: getstatic       com/alphainventor/filemanager/file/q.u:Ljava/util/logging/Logger;
        //   304: astore_2       
        //   305: new             Ljava/lang/StringBuilder;
        //   308: astore          6
        //   310: aload           6
        //   312: invokespecial   java/lang/StringBuilder.<init>:()V
        //   315: aload           6
        //   317: ldc_w           "StoreFileStream returns null : reply : "
        //   320: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   323: pop            
        //   324: aload           6
        //   326: iload           11
        //   328: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   331: pop            
        //   332: aload           6
        //   334: ldc_w           ":"
        //   337: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   340: pop            
        //   341: aload           6
        //   343: aload_1        
        //   344: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   347: pop            
        //   348: aload_2        
        //   349: aload           6
        //   351: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   354: invokevirtual   java/util/logging/Logger.severe:(Ljava/lang/String;)V
        //   357: aload_3        
        //   358: invokevirtual   ax/Rc/e.w:()Z
        //   361: ifeq            395
        //   364: aload_3        
        //   365: invokevirtual   ax/Sc/c.R:()I
        //   368: invokestatic    ax/Sc/t.a:(I)Z
        //   371: istore          8
        //   373: iload           8
        //   375: ifeq            395
        //   378: aload_3        
        //   379: invokevirtual   ax/Sc/e.o:()V
        //   382: goto            395
        //   385: astore          6
        //   387: aconst_null    
        //   388: astore_1       
        //   389: aload           16
        //   391: astore_2       
        //   392: goto            954
        //   395: aload_0        
        //   396: ldc_w           "FTP writeFile STOR"
        //   399: iload           11
        //   401: aload_1        
        //   402: iconst_0       
        //   403: invokespecial   com/alphainventor/filemanager/file/q.t0:(Ljava/lang/String;ILjava/lang/String;Z)Lax/b3/j;
        //   406: athrow         
        //   407: aload_2        
        //   408: invokevirtual   ax/c3/G.b:()Ljava/io/InputStream;
        //   411: astore          15
        //   413: aload           15
        //   415: aload           16
        //   417: lload           4
        //   419: aload           9
        //   421: aload           10
        //   423: invokestatic    ax/c3/F.c:(Ljava/io/InputStream;Ljava/io/OutputStream;JLax/u3/c;Lax/g3/i;)J
        //   426: lstore          13
        //   428: aload           16
        //   430: invokevirtual   java/io/OutputStream.close:()V
        //   433: aload           20
        //   435: astore          16
        //   437: aload_3        
        //   438: astore          18
        //   440: aload           7
        //   442: astore          17
        //   444: aload           15
        //   446: astore          10
        //   448: aload_3        
        //   449: invokevirtual   ax/Rc/e.w:()Z
        //   452: istore          8
        //   454: iload           8
        //   456: ifeq            683
        //   459: iload           11
        //   461: iconst_1       
        //   462: iadd           
        //   463: istore          12
        //   465: aload_3        
        //   466: invokevirtual   ax/Sc/e.C0:()Z
        //   469: ifeq            475
        //   472: goto            715
        //   475: new             Lax/b3/j;
        //   478: astore_2       
        //   479: new             Ljava/lang/StringBuilder;
        //   482: astore          10
        //   484: aload           10
        //   486: invokespecial   java/lang/StringBuilder.<init>:()V
        //   489: aload           10
        //   491: ldc_w           "FTP ERROR : "
        //   494: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   497: pop            
        //   498: aload           10
        //   500: aload_3        
        //   501: invokevirtual   ax/Sc/c.R:()I
        //   504: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   507: pop            
        //   508: aload           10
        //   510: ldc_w           ":"
        //   513: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   516: pop            
        //   517: aload           10
        //   519: aload_3        
        //   520: invokevirtual   ax/Sc/c.S:()Ljava/lang/String;
        //   523: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   526: pop            
        //   527: aload_2        
        //   528: aload           10
        //   530: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   533: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   536: aload_2        
        //   537: athrow         
        //   538: astore          6
        //   540: aload           19
        //   542: astore_2       
        //   543: aload           15
        //   545: astore_1       
        //   546: goto            954
        //   549: astore_2       
        //   550: aload_2        
        //   551: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   554: getstatic       com/alphainventor/filemanager/file/q.u:Ljava/util/logging/Logger;
        //   557: ldc_w           "FTP completePendingCommand Error"
        //   560: invokevirtual   java/util/logging/Logger.fine:(Ljava/lang/String;)V
        //   563: aload_3        
        //   564: invokevirtual   ax/Sc/e.o:()V
        //   567: goto            571
        //   570: astore_2       
        //   571: lload           13
        //   573: lload           4
        //   575: lcmp           
        //   576: iflt            582
        //   579: goto            715
        //   582: new             Lax/b3/j;
        //   585: astore_1       
        //   586: aload_1        
        //   587: ldc_w           "FTP ERROR : completePendingCommand error 2"
        //   590: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   593: aload_1        
        //   594: athrow         
        //   595: astore_2       
        //   596: aload_3        
        //   597: checkcast       Lcom/alphainventor/filemanager/file/q$h;
        //   600: invokeinterface com/alphainventor/filemanager/file/q$h.e:()Z
        //   605: ifeq            651
        //   608: iload           12
        //   610: bipush          20
        //   612: if_icmpge       651
        //   615: iload           12
        //   617: istore          11
        //   619: aload           9
        //   621: ifnull          459
        //   624: aload           9
        //   626: invokeinterface ax/u3/c.isCancelled:()Z
        //   631: ifne            641
        //   634: iload           12
        //   636: istore          11
        //   638: goto            459
        //   641: new             Lax/b3/a;
        //   644: astore_1       
        //   645: aload_1        
        //   646: invokespecial   ax/b3/a.<init>:()V
        //   649: aload_1        
        //   650: athrow         
        //   651: aload_3        
        //   652: invokevirtual   ax/Sc/e.o:()V
        //   655: goto            659
        //   658: astore_2       
        //   659: lload           13
        //   661: lload           4
        //   663: lcmp           
        //   664: iflt            670
        //   667: goto            715
        //   670: new             Lax/b3/j;
        //   673: astore_1       
        //   674: aload_1        
        //   675: ldc_w           "FTP ERROR : completePendingCommand error 1"
        //   678: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   681: aload_1        
        //   682: athrow         
        //   683: aload           20
        //   685: astore          16
        //   687: aload_3        
        //   688: astore          18
        //   690: aload           7
        //   692: astore          17
        //   694: aload           15
        //   696: astore          10
        //   698: getstatic       com/alphainventor/filemanager/file/q.u:Ljava/util/logging/Logger;
        //   701: ldc_w           "FTP client is disconnected"
        //   704: invokevirtual   java/util/logging/Logger.fine:(Ljava/lang/String;)V
        //   707: lload           13
        //   709: lload           4
        //   711: lcmp           
        //   712: iflt            858
        //   715: aload           6
        //   717: ifnull          809
        //   720: aload           20
        //   722: astore          16
        //   724: aload_3        
        //   725: astore          18
        //   727: aload           7
        //   729: astore          17
        //   731: aload           15
        //   733: astore          10
        //   735: aload           6
        //   737: invokevirtual   java/lang/Long.longValue:()J
        //   740: lconst_0       
        //   741: lcmp           
        //   742: ifle            809
        //   745: aload           20
        //   747: astore          16
        //   749: aload_3        
        //   750: astore          18
        //   752: aload           7
        //   754: astore          17
        //   756: aload           15
        //   758: astore          10
        //   760: aload           6
        //   762: invokevirtual   java/lang/Long.longValue:()J
        //   765: lstore          4
        //   767: aload_0        
        //   768: aload_3        
        //   769: aload_1        
        //   770: lload           4
        //   772: iconst_0       
        //   773: invokespecial   com/alphainventor/filemanager/file/q.L0:(Lax/Sc/e;Lcom/alphainventor/filemanager/file/n;JZ)Z
        //   776: pop            
        //   777: goto            809
        //   780: astore          6
        //   782: aload           19
        //   784: astore_2       
        //   785: aload           15
        //   787: astore_1       
        //   788: goto            954
        //   791: astore          6
        //   793: aload           16
        //   795: astore_2       
        //   796: aload           18
        //   798: astore_3       
        //   799: aload           17
        //   801: astore          7
        //   803: aload           10
        //   805: astore_1       
        //   806: goto            954
        //   809: aload           20
        //   811: astore          16
        //   813: aload_3        
        //   814: astore          18
        //   816: aload           7
        //   818: astore          17
        //   820: aload           15
        //   822: astore          10
        //   824: aload           21
        //   826: monitorexit    
        //   827: aload           15
        //   829: ifnull          841
        //   832: aload           15
        //   834: invokevirtual   java/io/InputStream.close:()V
        //   837: goto            841
        //   840: astore_1       
        //   841: aload_3        
        //   842: aload_0        
        //   843: getfield        com/alphainventor/filemanager/file/q.j:Lax/Sc/e;
        //   846: if_acmpeq       857
        //   849: aload_0        
        //   850: getfield        com/alphainventor/filemanager/file/q.l:Lcom/alphainventor/filemanager/file/q$e;
        //   853: aload_3        
        //   854: invokevirtual   com/alphainventor/filemanager/file/q$e.i:(Lax/Sc/e;)V
        //   857: return         
        //   858: aload           20
        //   860: astore          16
        //   862: aload_3        
        //   863: astore          18
        //   865: aload           7
        //   867: astore          17
        //   869: aload           15
        //   871: astore          10
        //   873: new             Lax/b3/j;
        //   876: astore_1       
        //   877: aload           20
        //   879: astore          16
        //   881: aload_3        
        //   882: astore          18
        //   884: aload           7
        //   886: astore          17
        //   888: aload           15
        //   890: astore          10
        //   892: aload_1        
        //   893: ldc_w           "FTP ERROR : Socket is disconnected"
        //   896: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   899: aload           20
        //   901: astore          16
        //   903: aload_3        
        //   904: astore          18
        //   906: aload           7
        //   908: astore          17
        //   910: aload           15
        //   912: astore          10
        //   914: aload_1        
        //   915: athrow         
        //   916: astore          6
        //   918: aload           15
        //   920: astore_1       
        //   921: goto            389
        //   924: astore          6
        //   926: goto            387
        //   929: astore          6
        //   931: aconst_null    
        //   932: astore_1       
        //   933: aload           19
        //   935: astore_2       
        //   936: goto            954
        //   939: aload_0        
        //   940: ldc_w           "FTP writeFile CWD"
        //   943: iload           12
        //   945: aload_3        
        //   946: invokevirtual   ax/Sc/c.S:()Ljava/lang/String;
        //   949: iconst_0       
        //   950: invokespecial   com/alphainventor/filemanager/file/q.t0:(Ljava/lang/String;ILjava/lang/String;Z)Lax/b3/j;
        //   953: athrow         
        //   954: aload_2        
        //   955: astore          16
        //   957: aload_3        
        //   958: astore          18
        //   960: aload           7
        //   962: astore          17
        //   964: aload_1        
        //   965: astore          10
        //   967: aload           21
        //   969: monitorexit    
        //   970: aload           6
        //   972: athrow         
        //   973: astore          6
        //   975: goto            1072
        //   978: astore          6
        //   980: aload_2        
        //   981: astore          7
        //   983: aload           6
        //   985: astore_2       
        //   986: aload           7
        //   988: astore          6
        //   990: goto            118
        //   993: astore          6
        //   995: aload           16
        //   997: astore_3       
        //   998: goto            101
        //  1001: astore_2       
        //  1002: aload           15
        //  1004: astore_3       
        //  1005: goto            113
        //  1008: aload_3        
        //  1009: astore          16
        //  1011: aload_3        
        //  1012: astore          15
        //  1014: new             Lax/b3/j;
        //  1017: astore_1       
        //  1018: aload_3        
        //  1019: astore          16
        //  1021: aload_3        
        //  1022: astore          15
        //  1024: aload_1        
        //  1025: aload           7
        //  1027: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //  1030: aload           7
        //  1032: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //  1035: aload_3        
        //  1036: astore          16
        //  1038: aload_3        
        //  1039: astore          15
        //  1041: aload_1        
        //  1042: athrow         
        //  1043: astore          6
        //  1045: goto            46
        //  1048: astore_1       
        //  1049: goto            57
        //  1052: aload_0        
        //  1053: ldc_w           "FTP writefile"
        //  1056: aload_3        
        //  1057: invokespecial   com/alphainventor/filemanager/file/q.s0:(Ljava/lang/String;Ljava/io/IOException;)Lax/b3/j;
        //  1060: athrow         
        //  1061: astore          7
        //  1063: aload_2        
        //  1064: astore_3       
        //  1065: aload           6
        //  1067: astore_2       
        //  1068: aload           7
        //  1070: astore          6
        //  1072: aload_2        
        //  1073: ifnull          1084
        //  1076: aload_2        
        //  1077: invokevirtual   java/io/OutputStream.close:()V
        //  1080: goto            1084
        //  1083: astore_2       
        //  1084: aload_1        
        //  1085: ifnull          1096
        //  1088: aload_1        
        //  1089: invokevirtual   java/io/InputStream.close:()V
        //  1092: goto            1096
        //  1095: astore_1       
        //  1096: aload_3        
        //  1097: ifnull          1116
        //  1100: aload_3        
        //  1101: aload_0        
        //  1102: getfield        com/alphainventor/filemanager/file/q.j:Lax/Sc/e;
        //  1105: if_acmpeq       1116
        //  1108: aload_0        
        //  1109: getfield        com/alphainventor/filemanager/file/q.l:Lcom/alphainventor/filemanager/file/q$e;
        //  1112: aload_3        
        //  1113: invokevirtual   com/alphainventor/filemanager/file/q$e.i:(Lax/Sc/e;)V
        //  1116: aload           6
        //  1118: athrow         
        //  1119: astore_2       
        //  1120: goto            395
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  25     31     1048   1052   Ljava/io/IOException;
        //  25     31     1043   1048   Any
        //  36     41     56     57     Ljava/io/IOException;
        //  36     41     44     46     Any
        //  74     82     134    138    Lax/b3/K;
        //  74     82     56     57     Ljava/io/IOException;
        //  74     82     44     46     Any
        //  88     93     129    134    Lax/b3/K;
        //  88     93     109    113    Ljava/io/IOException;
        //  88     93     96     101    Any
        //  144    151    1001   1008   Ljava/io/IOException;
        //  144    151    993    1001   Any
        //  157    162    1001   1008   Ljava/io/IOException;
        //  157    162    993    1001   Any
        //  168    173    1001   1008   Ljava/io/IOException;
        //  168    173    993    1001   Any
        //  182    188    1001   1008   Ljava/io/IOException;
        //  182    188    993    1001   Any
        //  200    206    109    113    Ljava/io/IOException;
        //  200    206    96     101    Any
        //  222    228    1001   1008   Ljava/io/IOException;
        //  222    228    993    1001   Any
        //  228    246    929    939    Any
        //  254    275    929    939    Any
        //  275    285    924    929    Any
        //  290    373    385    387    Any
        //  378    382    1119   1123   Ljava/io/IOException;
        //  378    382    385    387    Any
        //  395    407    385    387    Any
        //  407    413    924    929    Any
        //  413    433    916    924    Any
        //  448    454    791    809    Any
        //  465    472    595    683    Ljava/net/SocketTimeoutException;
        //  465    472    549    595    Ljava/io/IOException;
        //  465    472    538    549    Any
        //  475    538    595    683    Ljava/net/SocketTimeoutException;
        //  475    538    549    595    Ljava/io/IOException;
        //  475    538    538    549    Any
        //  550    563    538    549    Any
        //  563    567    570    571    Ljava/io/IOException;
        //  563    567    538    549    Any
        //  582    595    538    549    Any
        //  596    608    538    549    Any
        //  624    634    538    549    Any
        //  641    651    538    549    Any
        //  651    655    658    659    Ljava/io/IOException;
        //  651    655    538    549    Any
        //  670    683    538    549    Any
        //  698    707    791    809    Any
        //  735    745    791    809    Any
        //  760    767    791    809    Any
        //  767    777    780    791    Any
        //  824    827    791    809    Any
        //  832    837    840    841    Ljava/io/IOException;
        //  873    877    791    809    Any
        //  892    899    791    809    Any
        //  914    916    791    809    Any
        //  939    954    929    939    Any
        //  967    970    791    809    Any
        //  970    973    978    993    Ljava/io/IOException;
        //  970    973    973    978    Any
        //  1014   1018   1001   1008   Ljava/io/IOException;
        //  1014   1018   993    1001   Any
        //  1024   1035   1001   1008   Ljava/io/IOException;
        //  1024   1035   993    1001   Any
        //  1041   1043   1001   1008   Ljava/io/IOException;
        //  1041   1043   993    1001   Any
        //  1052   1061   1061   1072   Any
        //  1076   1080   1083   1084   Ljava/io/IOException;
        //  1088   1092   1095   1096   Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0387:
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
    
    public void E(final n p0, final n p1, final ax.u3.c p2, final ax.g3.i p3) throws ax.b3.j {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   com/alphainventor/filemanager/file/q.R0:()V
        //     4: aload_2        
        //     5: invokeinterface ax/c3/b.n:()Z
        //    10: invokestatic    ax/u3/b.a:(Z)V
        //    13: aload_0        
        //    14: getfield        com/alphainventor/filemanager/file/q.k:Ljava/lang/Object;
        //    17: astore_3       
        //    18: aload_3        
        //    19: dup            
        //    20: astore          6
        //    22: monitorenter   
        //    23: aload_1        
        //    24: invokeinterface ax/c3/b.p:()J
        //    29: lstore          5
        //    31: aload_0        
        //    32: getfield        com/alphainventor/filemanager/file/q.j:Lax/Sc/e;
        //    35: aload_1        
        //    36: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //    39: aload_2        
        //    40: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //    43: invokevirtual   ax/Sc/e.s1:(Ljava/lang/String;Ljava/lang/String;)Z
        //    46: ifeq            76
        //    49: aload           4
        //    51: ifnull          72
        //    54: aload           4
        //    56: lload           5
        //    58: lload           5
        //    60: invokeinterface ax/g3/i.a:(JJ)V
        //    65: goto            72
        //    68: astore_1       
        //    69: goto            99
        //    72: aload           6
        //    74: monitorexit    
        //    75: return         
        //    76: aload_0        
        //    77: ldc_w           "FTP moveFile"
        //    80: aload_0        
        //    81: getfield        com/alphainventor/filemanager/file/q.j:Lax/Sc/e;
        //    84: invokevirtual   ax/Sc/c.R:()I
        //    87: aload_0        
        //    88: getfield        com/alphainventor/filemanager/file/q.j:Lax/Sc/e;
        //    91: invokevirtual   ax/Sc/c.S:()Ljava/lang/String;
        //    94: iconst_1       
        //    95: invokespecial   com/alphainventor/filemanager/file/q.t0:(Ljava/lang/String;ILjava/lang/String;Z)Lax/b3/j;
        //    98: athrow         
        //    99: aload           6
        //   101: monitorexit    
        //   102: aload_1        
        //   103: athrow         
        //   104: astore_1       
        //   105: aload_0        
        //   106: ldc_w           "FTP moveFile"
        //   109: aload_1        
        //   110: invokespecial   com/alphainventor/filemanager/file/q.s0:(Ljava/lang/String;Ljava/io/IOException;)Lax/b3/j;
        //   113: athrow         
        //    Exceptions:
        //  throws ax.b3.j
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  13     23     104    114    Ljava/io/IOException;
        //  23     49     68     104    Any
        //  54     65     68     104    Any
        //  72     75     68     104    Any
        //  76     99     68     104    Any
        //  99     102    68     104    Any
        //  102    104    104    114    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException: Attempt to read from field 'java.util.ArrayList q5.e.c' on a null object reference in method 'void q5.g.c(q5.a[], java.util.ArrayList)'
        //     at q5.g.c(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:871)
        //     at q5.g.o(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:2394)
        //     at q5.g.b(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:2099)
        //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:21)
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
    
    List<n> E0(String s, final String s2, final boolean b) throws IOException, ax.b3.j {
        s = (String)new ArrayList();
        int i = 0;
        Label_0866: {
            ax.Sc.s d2;
            if (b) {
                final ax.Sc.i[] n1 = this.j.n1();
                final int r = ((ax.Sc.c)this.j).R();
                if (!ax.Sc.t.c(r)) {
                    if (r == 425 || r == 426) {
                        this.I0();
                    }
                    return null;
                }
                while (i < n1.length) {
                    final ax.Sc.i j = n1[i];
                    if (j != null && !d0.C(j.b())) {
                        if (!j.b().startsWith("/")) {
                            if (!TextUtils.isEmpty((CharSequence)j.b().trim())) {
                                ((List)s).add((Object)new D(this, this.j, j, d0.Q(s2, j.b()), false));
                            }
                            else {
                                final ax.Ha.b d = c.h().f().d("FTP EMPTY FILE NAME 1");
                                final StringBuilder sb = new StringBuilder();
                                sb.append("name:");
                                sb.append(j.b());
                                sb.append(",size:");
                                sb.append(j.d());
                                sb.append(",dir:");
                                sb.append(j.g());
                                d.g((Object)sb.toString()).h();
                            }
                        }
                    }
                    ++i;
                }
                return (List<n>)s;
            }
            else {
                d2 = this.j.d1((String)null, (String)null);
                final int r2 = ((ax.Sc.c)this.j).R();
                if (r2 == 425 || r2 == 426) {
                    break Label_0866;
                }
                final ArrayList list = new ArrayList();
                boolean b2 = false;
                while (d2.g()) {
                    if (!((ax.Rc.e)this.j).w()) {
                        throw new IOException("FTP disconnected while operation");
                    }
                    final ax.Sc.i[] f = d2.f(1);
                    if (f.length <= 0) {
                        continue;
                    }
                    final ax.Sc.i k = f[0];
                    if (k != null) {
                        list.add((Object)k);
                    }
                    else {
                        b2 = true;
                    }
                }
                for (int size = list.size(), l = 0; l < size; ++l) {
                    final ax.Sc.i m = (ax.Sc.i)list.get(l);
                    if (m != null && !d0.C(m.b())) {
                        if (!TextUtils.isEmpty((CharSequence)m.b().trim())) {
                            ((List)s).add((Object)new D(this, this.j, m, d0.Q(s2, m.b().trim()), true));
                        }
                        else {
                            final ax.Ha.b d3 = c.h().f().d("FTP EMPTY FILE NAME 2");
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("name:");
                            sb2.append(m.b());
                            sb2.append(",size:");
                            sb2.append(m.d());
                            sb2.append(",dir:");
                            sb2.append(m.g());
                            d3.g((Object)sb2.toString()).h();
                        }
                    }
                }
                if (((List)s).size() != 0) {
                    return (List<n>)s;
                }
                if (this.C0(r2)) {
                    break Label_0866;
                }
                if (!b2) {
                    return (List<n>)s;
                }
            }
            try {
                final Field declaredField = ax.Sc.s.class.getDeclaredField("a");
                ((AccessibleObject)declaredField).setAccessible(true);
                final List list2 = (List)declaredField.get((Object)d2);
                final StringBuilder sb3 = new StringBuilder();
                if (list2 != null) {
                    for (final String s3 : list2) {
                        if (s3 != null && !s3.endsWith(" .") && !s3.endsWith(" ..") && !s3.equals((Object)"..") && !s3.equals((Object)"\ufeff")) {
                            sb3.append(s3);
                            sb3.append("\n");
                        }
                    }
                }
                if (TextUtils.isEmpty((CharSequence)sb3.toString().trim())) {
                    return (List<n>)s;
                }
                final ax.Ha.b b3 = c.h().f().b("FTP PARSE ERROR");
                final StringBuilder sb4 = new StringBuilder();
                sb4.append((Object)sb3);
                sb4.append(",welcome:");
                sb4.append(this.o);
                sb4.append(",system:");
                sb4.append(this.p);
                b3.g((Object)sb4.toString()).h();
                throw new ax.b3.j("FTP Parse error");
                final int r2;
                throw this.t0("FTP List", r2, ((ax.Sc.c)this.j).S(), false);
                this.I0();
                iftrue(Label_0904:)(!this.B0());
                s = "FTP List data channel: Cannot support session reuse";
                throw this.t0(s, r2, ((ax.Sc.c)this.j).S(), false);
                Label_0904: {
                    s = "FTP List data channel";
                }
                throw this.t0(s, r2, ((ax.Sc.c)this.j).S(), false);
            }
            catch (final Exception ex) {
                return (List<n>)s;
            }
        }
    }
    
    public void F(final n n, final n n2, final ax.u3.c c, final ax.g3.i i) throws ax.b3.j, ax.b3.a {
        Label_0164: {
            if (!this.q) {
                break Label_0164;
            }
            final File z = n.Z();
            final com.alphainventor.filemanager.file.o f = ax.c3.x.f(z);
            final n z2 = f.z(z.getAbsolutePath());
            final boolean n3 = ((ax.c3.b)z2).n();
            f.D(z2, this.s(n), ((ax.c3.b)n).s(), ((ax.c3.b)n).p(), ((ax.c3.b)n).q(), n.D(), false, c, (ax.g3.i)new ax.g3.i(this, i) {
                final ax.g3.i a;
                final q b;
                
                public void a(final long n, final long n2) {
                    final ax.g3.i a = this.a;
                    if (a != null) {
                        a.a(n / 2L, n2);
                    }
                }
            });
            final n z3 = f.z(z.getAbsolutePath());
            this.D(n2, f.x(z3), ((ax.c3.b)n).s(), ((ax.c3.b)n).p(), ((ax.c3.b)n).q(), n.D(), false, c, (ax.g3.i)new ax.g3.i(this, i) {
                final ax.g3.i a;
                final q b;
                
                public void a(final long n, final long n2) {
                    final ax.g3.i a = this.a;
                    if (a != null) {
                        if (n == n2) {
                            a.a(n2, n2);
                            return;
                        }
                        a.a(n2 / 2L + n / 2L, n2);
                    }
                }
            });
            if (n3) {
                return;
            }
            try {
                f.P(z3);
                return;
                this.D(n2, this.s(n), ((ax.c3.b)n).s(), ((ax.c3.b)n).p(), ((ax.c3.b)n).q(), n.D(), false, c, i);
            }
            catch (final ax.b3.j j) {}
        }
    }
    
    public ax.Sc.i F0(final ax.Sc.e e, String x0) throws IOException {
        if (!ax.Sc.t.c(((ax.Sc.c)e).k0(ax.Sc.g.r0, x0))) {
            return null;
        }
        final String[] t = ((ax.Sc.c)e).T();
        if (t.length < 2) {
            final Logger u = com.alphainventor.filemanager.file.q.u;
            final StringBuilder sb = new StringBuilder();
            sb.append("invalid reply : ");
            sb.append(((ax.Sc.c)e).S());
            u.severe(sb.toString());
            return null;
        }
        final String s = t[1];
        if (s.startsWith("550")) {
            try {
                x0 = e.X0();
                if (((ax.Sc.c)e).R() == 250) {
                    final Logger u2 = com.alphainventor.filemanager.file.q.u;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid getStatus reply : ");
                    sb2.append(x0);
                    u2.severe(sb2.toString());
                    ((ax.Sc.c)e).P();
                }
            }
            catch (final IOException ex) {
                this.I0();
            }
            return null;
        }
        return H0(s, x0);
    }
    
    public int G(final String s, final String s2) {
        return -1;
    }
    
    public String H(final n n) {
        if (this.q) {
            return null;
        }
        if (!this.Z(n)) {
            return null;
        }
        return com.alphainventor.filemanager.file.m.S(n);
    }
    
    public void I(final n n) throws ax.b3.j {
        b.g("not support delete file recursively");
    }
    
    public InputStream J(final n n, final long n2) throws ax.b3.j {
        final e l = this.l;
        if (l != null) {
            ax.Sc.e e = null;
            Label_0074: {
                try {
                    if (this.q) {
                        this.R0();
                        e = this.j;
                        break Label_0074;
                    }
                }
                catch (final IOException ex) {
                    throw this.s0("FTP getinputstream", ex);
                }
                try {
                    e = l.f();
                    this.r = true;
                }
                catch (final K k) {
                    if (this.r) {
                        throw new ax.b3.j(((Throwable)k).getMessage(), (Throwable)k);
                    }
                    this.M0(true);
                    this.R0();
                    e = this.j;
                }
            }
            Object i;
            if (e == this.j) {
                i = this.k;
            }
            else {
                i = e;
            }
            final Object o;
            monitorenter(o = i);
        Block_15_Outer:
            while (true) {
                Label_0143: {
                    try {
                        if (((h)e).c() == 2) {
                            break Label_0154;
                        }
                        if (e.y1(2)) {
                            ((h)e).b(2);
                            break Label_0154;
                        }
                        break Label_0143;
                    }
                    finally {
                        monitorexit(o);
                        while (true) {
                            final InputStream u1;
                            final f f = new f(e, u1);
                            monitorexit(o);
                            return (InputStream)f;
                            Label_0221: {
                                throw new ax.b3.q("FTP client is not connected");
                            }
                            e.B1(n2);
                            iftrue(Label_0221:)(!((ax.Rc.e)e).w());
                            Block_14: {
                                break Block_14;
                                Label_0202:
                                throw this.t0("FTP getInputStream", ((ax.Sc.c)e).R(), ((ax.Sc.c)e).S(), true);
                                ((h)e).b(0);
                                continue Block_15_Outer;
                            }
                            u1 = e.u1(n.E());
                            iftrue(Label_0202:)(u1 == null);
                            continue;
                        }
                    }
                }
                break;
            }
            final K k;
            throw new ax.b3.j(((Throwable)k).getMessage(), (Throwable)k);
        }
        throw new ax.b3.h("Not connected : ftp");
    }
    
    void J0(final ax.Sc.e j) {
        this.j = j;
        this.l = new e();
    }
    
    public void K(final Activity activity, final Fragment fragment, final c$a c$a) {
        Label_0031: {
            try {
                final d i = this.i;
                if (i != null && !i.isCancelled()) {
                    this.i.e();
                }
                break Label_0031;
            }
            catch (final Exception ex) {
                ((Throwable)ex).printStackTrace();
                if (c$a != null) {
                    c$a.B();
                    c$a.T(false, (Object)((Throwable)ex).getMessage());
                }
                return;
                final d j = new d(this.p(), this, this.t(), c$a);
                j.i(new Object[0]);
                this.i = j;
            }
        }
    }
    
    public void K0(final String m) {
        if (TextUtils.isEmpty((CharSequence)m)) {
            this.m = this.x();
            return;
        }
        this.m = m;
    }
    
    public boolean L() {
        return true;
    }
    
    public boolean M(final n n) {
        this.R0();
        try {
            final Object k = this.k;
            synchronized (k) {
                return this.j.m1(n.E());
            }
        }
        catch (final IOException ex) {
            ((Throwable)ex).printStackTrace();
            return false;
        }
    }
    
    void M0(final boolean q) {
        this.q = q;
    }
    
    public boolean N(final n n) {
        return this.l(n);
    }
    
    public boolean O() {
        return false;
    }
    
    public void P(final n n) throws ax.b3.j {
        this.R0();
        try {
            final Object k;
            monitorenter(k = this.k);
            Label_0091: {
                try {
                    if (!this.p0(n.T())) {
                        throw new ax.b3.j("deleteFile - CWD not successful");
                    }
                    if (!((ax.c3.b)n).isDirectory()) {
                        break Label_0091;
                    }
                    if (this.j.r1(n.B())) {
                        break Label_0091;
                    }
                    throw this.t0("FTP deleteFile", ((ax.Sc.c)this.j).R(), ((ax.Sc.c)this.j).S(), true);
                }
                finally {
                    monitorexit(k);
                    Label_0094: {
                        throw this.t0("FTP deleteFile", ((ax.Sc.c)this.j).R(), ((ax.Sc.c)this.j).S(), true);
                    }
                    iftrue(Label_0094:)(!this.j.E0(n.B()));
                    monitorexit(k);
                }
            }
        }
        catch (final IOException ex) {
            ((Throwable)ex).printStackTrace();
            throw this.s0("FTP deleteFile", ex);
        }
    }
    
    public boolean Q(final n n, final n n2) {
        return true;
    }
    
    public boolean V() {
        return this.t;
    }
    
    public boolean a() {
        final ax.Sc.e j = this.j;
        return j != null && ((ax.Rc.e)j).w();
    }
    
    public void b() {
        final Object k;
        monitorenter(k = this.k);
        Label_0041: {
            try {
                this.n = null;
                v0(this.j);
                final e l = this.l;
                if (l != null) {
                    l.b();
                }
                break Label_0041;
            }
            finally {
                monitorexit(k);
                monitorexit(k);
            }
        }
    }
    
    public boolean d(final n n, final long n2) {
        if (n2 < 0L) {
            return false;
        }
        if (!(n instanceof D)) {
            return false;
        }
        this.R0();
        final Object k = this.k;
        synchronized (k) {
            return this.L0(this.j, n, n2, true);
        }
    }
    
    public boolean i0() {
        return !this.q;
    }
    
    void m(final n n, final String s, final boolean b, final boolean b2, final ax.g3.h h, final ax.u3.c c) throws ax.b3.j {
        monitorenter(this);
        try {
            this.o(n, s, b, b2, h, c);
            monitorexit(this);
        }
        finally {
            try {
                monitorexit(this);
            }
            finally {}
        }
    }
    
    public String r() {
        return this.m;
    }
    
    void u0(final String o, final String p2) {
        this.o = o;
        this.p = p2;
        this.s = com.alphainventor.filemanager.file.q.w;
        if (o != null) {
            if (o.contains((CharSequence)"FileZilla Server")) {
                this.s = com.alphainventor.filemanager.file.q.x;
                return;
            }
            if (o.contains((CharSequence)"ESP8266")) {
                this.s = com.alphainventor.filemanager.file.q.y;
                this.M0(true);
                return;
            }
            if (o.contains((CharSequence)"lima-city.de")) {
                this.t = true;
            }
        }
    }
    
    public n z(final String n) throws ax.b3.j {
        this.R0();
        try {
            final Object k;
            monitorenter(k = this.k);
            try {
                Label_0191: {
                    if (this.Q0()) {
                        Object o = null;
                        try {
                            try {
                                o = this.F0(this.j, (String)n);
                            }
                            finally {}
                        }
                        catch (final IOException o) {
                            ((Throwable)o).printStackTrace();
                            break Label_0191;
                        }
                        catch (final a a) {
                            ((Throwable)o).printStackTrace();
                            if (!"/".equals((Object)n)) {
                                final ax.Ha.b l = c.h().f().d("FTP INVALID REPLY!!!! FIX CODE FOR THIS CASE").l((Throwable)o);
                                o = new StringBuilder();
                                ((StringBuilder)o).append(((ax.Sc.c)this.j).S());
                                ((StringBuilder)o).append(",path:");
                                ((StringBuilder)o).append((String)n);
                                ((StringBuilder)o).append(" ,welcomeMessage:");
                                ((StringBuilder)o).append(this.o);
                                l.g((Object)((StringBuilder)o).toString()).h();
                            }
                            break Label_0191;
                        }
                        catch (final RuntimeException ex) {}
                        ((Throwable)o).printStackTrace();
                        c.h().f().d("FTP MLST ERROR").l((Throwable)o).g((Object)((ax.Sc.c)this.j).S()).h();
                    }
                }
                Object o = null;
                if (o == null) {
                    o = this.x0((String)n);
                }
                else {
                    final String trim = ((ax.Sc.i)o).b().trim();
                    final boolean a2 = d0.A(trim);
                    String h = trim;
                    if (!a2) {
                        h = d0.h(d0.U(trim));
                        ((ax.Sc.i)o).l(h);
                    }
                    if (!h.equals((Object)d0.h((String)n))) {
                        o = this.x0((String)n);
                    }
                }
                if (o == null) {
                    o = new D(this, (String)n, this.r0((String)n));
                    monitorexit(k);
                    return (n)o;
                }
                final ax.Sc.e j = this.j;
                try {
                    final D d = new D(this, j, (ax.Sc.i)o, (String)n, true);
                    monitorexit(k);
                    return (n)d;
                }
                finally {}
            }
            finally {}
            monitorexit(k);
            try {
                throw n;
            }
            catch (final ax.Tc.n n2) {}
            catch (final NullPointerException ex2) {}
            catch (final ArrayIndexOutOfBoundsException ex3) {}
            catch (final IOException ex4) {}
            throw this.s0("FTP getfileinfo", (IOException)n);
        }
        catch (final ax.Tc.n n) {
            goto Label_0336;
        }
        catch (final NullPointerException n) {
            goto Label_0340;
        }
        catch (final ArrayIndexOutOfBoundsException n) {
            goto Label_0344;
        }
        catch (final IOException n) {
            throw this.s0("FTP getfileinfo", (IOException)n);
        }
        c.h().d("PARSER ERROR").l((Throwable)n).h();
        throw new ax.b3.j((Throwable)n);
    }
    
    private static class d extends ax.u3.q<Object, Void, Boolean>
    {
        c$a h;
        String i;
        int j;
        String k;
        String l;
        boolean m;
        boolean n;
        boolean o;
        ax.Sc.e p;
        boolean q;
        String r;
        String s;
        q t;
        ax.Z2.o u;
        String v;
        boolean w;
        Context x;
        
        public d(final Context x, final ax.Z2.o u, final c$a h) {
            super(q$e.c0);
            this.x = x;
            this.h = h;
            this.q = true;
            this.E(this.u = u);
        }
        
        public d(final Context x, final q t, final int n, final c$a h) {
            super(q$e.c0);
            this.x = x;
            this.t = t;
            this.h = h;
            this.q = false;
            final ax.Z2.o k = q.z0(x).k(n);
            if (k != null) {
                this.E(k);
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No remote info for index : ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        
        private SSLContext A() {
            Label_0038: {
                try {
                    final SSLContext instance = SSLContext.getInstance("TLSv1.2");
                    instance.init((KeyManager[])null, new TrustManager[] { (TrustManager)ax.Vc.g.a() }, (SecureRandom)null);
                    return instance;
                }
                catch (final Exception ex) {}
                catch (final GeneralSecurityException ex2) {
                    break Label_0038;
                }
                final Exception ex;
                ((Throwable)ex).printStackTrace();
                return null;
            }
            final GeneralSecurityException ex2;
            ((Throwable)ex2).printStackTrace();
            return null;
        }
        
        private void E(final ax.Z2.o o) {
            this.i = o.d();
            this.j = o.h();
            this.k = o.k();
            this.l = o.g();
            this.r = o.f();
            this.m = o.m();
            this.n = o.o();
            this.o = o.n();
            this.s = o.a();
        }
        
        private boolean w(final boolean b, final boolean b2) {
            System.setProperty("org.apache.commons.net.ftp.systemType.default", "UNKNOWN_SYSTEM_TYPE");
            if (!b) {
                this.p = new i();
            }
            else {
                com.alphainventor.filemanager.file.q.A0(this.x);
                final SSLContext a = this.A();
                if (a != null) {
                    this.p = (ax.Sc.e)new j(this.o, a, this.j);
                }
                else {
                    final j p2 = new j(this.o, this.j);
                    p2.R1((TrustManager)ax.Vc.g.a());
                    this.p = (ax.Sc.e)p2;
                }
            }
            ((ax.Sc.c)this.p).n0(false);
            this.p.A1((ax.Tc.d)new ax.c3.p());
            final String s = this.s;
            boolean b3 = false;
            Label_0209: {
                if (s == null) {
                    final String a2 = ax.u3.f.a();
                    if (a2 != null) {
                        ((ax.Sc.c)this.p).m0(a2);
                    }
                    b3 = true;
                }
                else {
                    ((ax.Sc.c)this.p).m0(s);
                    if ("UTF8".equals((Object)this.s) || "UTF-8".equals((Object)this.s)) {
                        b3 = false;
                        final boolean b4 = true;
                        break Label_0209;
                    }
                    b3 = false;
                }
                final boolean b4 = false;
            }
            final boolean b5 = b3 && B.G(this.k) && B.G(this.l);
            if (b3 && !b5) {
                this.p.w1(true);
            }
            ((ax.Rc.e)this.p).x(15000);
            ((ax.Rc.e)this.p).z(15000);
            this.p.x1(30000);
            boolean b4;
            InetAddress[] allByName;
            InetAddress inetAddress;
            int n;
            InetAddress inetAddress2;
            InetAddress inetAddress3;
            StringBuilder sb;
            String s2;
            String q1;
            String trim;
            StringBuilder sb2;
            StringBuilder sb3;
            final IllegalStateException ex2;
            String d;
            String y0;
            String d2;
            StringBuilder sb4;
            StringBuilder sb5;
            Label_0371:Block_33_Outer:Block_24_Outer:Label_0607_Outer:
            while (true) {
                try {
                    allByName = InetAddress.getAllByName(this.i);
                    if (allByName == null || allByName.length <= 1 || !(allByName[0] instanceof Inet6Address)) {
                        break Label_0371;
                    }
                    inetAddress = null;
                    n = 0;
                    while (true) {
                        inetAddress2 = inetAddress;
                        if (n >= allByName.length) {
                            break Label_0371;
                        }
                        inetAddress3 = allByName[n];
                        if (inetAddress3 instanceof Inet4Address) {
                            inetAddress = inetAddress3;
                        }
                        ++n;
                    }
                }
                catch (final Exception ex) {
                    if (ax.b3.d.e((Throwable)ex)) {
                        this.w = true;
                    }
                    sb = new StringBuilder();
                    sb.append("exception error 1 : ");
                    sb.append(((Throwable)ex).getMessage());
                    this.v = sb.toString();
                    ((Throwable)ex).printStackTrace();
                    return false;
                    while (true) {
                    Label_0578:
                        while (true) {
                            Label_0562: {
                                Block_21: {
                                Label_0685_Outer:
                                    while (true) {
                                        Label_0685:Label_0846_Outer:
                                        while (true) {
                                            Block_28: {
                                                Block_37: {
                                                    Label_0407: {
                                                        while (true) {
                                                            Block_36: {
                                                                Label_0661: {
                                                                    while (true) {
                                                                    Block_39:
                                                                        while (true) {
                                                                            s2 = d0.S(this.r);
                                                                            this.r = s2;
                                                                            iftrue(Label_0846:)(d0.B(s2));
                                                                            break Block_36;
                                                                            trim = q1.trim();
                                                                            this.r = trim;
                                                                            iftrue(Label_0846:)(d0.B(trim));
                                                                            Block_34: {
                                                                                break Block_34;
                                                                                Label_0678: {
                                                                                    this.p.G0();
                                                                                }
                                                                                break Label_0685;
                                                                                Block_27_Outer:Block_29_Outer:
                                                                                while (true) {
                                                                                    while (true) {
                                                                                        while (true) {
                                                                                            Label_0548: {
                                                                                                while (true) {
                                                                                                    while (true) {
                                                                                                        Block_20: {
                                                                                                            Label_1000: {
                                                                                                                try {
                                                                                                                    Label_0470:
                                                                                                                    if (!this.p.l1(this.k, this.l)) {
                                                                                                                        sb2 = new StringBuilder();
                                                                                                                        sb2.append("login error : ");
                                                                                                                        sb2.append(((ax.Sc.c)this.p).S());
                                                                                                                        this.v = sb2.toString();
                                                                                                                        v0(this.p);
                                                                                                                        return false;
                                                                                                                    }
                                                                                                                }
                                                                                                                catch (final IllegalStateException ex2) {
                                                                                                                    break Label_1000;
                                                                                                                }
                                                                                                                catch (final IOException ex2) {
                                                                                                                    break Label_1000;
                                                                                                                }
                                                                                                                break Label_0548;
                                                                                                                iftrue(Label_0392:)(inetAddress2 == null);
                                                                                                                break Block_20;
                                                                                                                Label_0392:
                                                                                                                ((ax.Rc.e)this.p).m(this.i, this.j);
                                                                                                                break Label_0407;
                                                                                                                v0(this.p);
                                                                                                                return true;
                                                                                                                iftrue(Label_0846:)(this.h == null || this.t == null || this.r != null);
                                                                                                                break Label_0685;
                                                                                                            }
                                                                                                            sb3 = new StringBuilder();
                                                                                                            sb3.append("exception error 2 : ");
                                                                                                            sb3.append(((Throwable)ex2).getMessage());
                                                                                                            this.v = sb3.toString();
                                                                                                            ((Throwable)ex2).printStackTrace();
                                                                                                            v0(this.p);
                                                                                                            return false;
                                                                                                            ((h)this.p).b(2);
                                                                                                            break Label_0661;
                                                                                                        }
                                                                                                        ((ax.Rc.e)this.p).n(inetAddress2, this.j);
                                                                                                        break Label_0407;
                                                                                                        ((u)this.p).K1(0L);
                                                                                                        ((u)this.p).L1("P");
                                                                                                        continue Block_27_Outer;
                                                                                                    }
                                                                                                    Label_0921:
                                                                                                    iftrue(Label_0984:)(this.t == null);
                                                                                                    break Block_39;
                                                                                                    iftrue(Label_0921:)(!b2);
                                                                                                    break Block_37;
                                                                                                    ((h)this.p).g();
                                                                                                    break Label_0578;
                                                                                                    iftrue(Label_0648:)(!this.p.y1(2));
                                                                                                    continue Block_29_Outer;
                                                                                                }
                                                                                            }
                                                                                            iftrue(Label_0621:)((!b3 || !b5) && !b4);
                                                                                            break Label_0562;
                                                                                            Label_0998:
                                                                                            return true;
                                                                                            ((ax.Sc.c)this.p).l0("OPTS", "UTF8 ON");
                                                                                            continue Label_0607_Outer;
                                                                                        }
                                                                                        iftrue(Label_0713:)(!b);
                                                                                        continue Label_0846_Outer;
                                                                                    }
                                                                                    iftrue(Label_0998:)(!this.q);
                                                                                    continue Block_29_Outer;
                                                                                }
                                                                                inetAddress2 = null;
                                                                                continue Label_0371;
                                                                            }
                                                                            d = this.D(this.r);
                                                                            this.r = d;
                                                                            iftrue(Label_0846:)(d0.B(d));
                                                                            continue Block_33_Outer;
                                                                        }
                                                                        y0 = this.p.Y0();
                                                                        d2 = ((h)this.p).d();
                                                                        this.t.K0(this.r);
                                                                        this.t.J0(this.p);
                                                                        this.t.u0(d2, y0);
                                                                        continue;
                                                                    }
                                                                    Label_0648: {
                                                                        ((h)this.p).b(0);
                                                                    }
                                                                }
                                                                iftrue(Label_0678:)(!this.m);
                                                                break Block_28;
                                                            }
                                                            c.h().c("INVALID FTP INITIAL PATH").g((Object)this.r).h();
                                                            this.r = null;
                                                            continue Block_24_Outer;
                                                        }
                                                    }
                                                    iftrue(Label_0470:)(ax.Sc.t.c(((ax.Sc.c)this.p).R()));
                                                    break Block_21;
                                                }
                                                this.p.i1();
                                                iftrue(Label_0921:)(ax.Sc.t.c(((ax.Sc.c)this.p).R()));
                                                break Label_0685_Outer;
                                            }
                                            this.p.F0();
                                            continue Label_0685;
                                        }
                                        q1 = this.p.q1();
                                        iftrue(Label_0846:)((this.r = q1) == null);
                                        continue Label_0685_Outer;
                                    }
                                    sb4 = new StringBuilder();
                                    sb4.append("list error : ");
                                    sb4.append(((ax.Sc.c)this.p).S());
                                    this.v = sb4.toString();
                                    v0(this.p);
                                    return false;
                                }
                                sb5 = new StringBuilder();
                                sb5.append("connect error : ");
                                sb5.append(((ax.Sc.c)this.p).S());
                                this.v = sb5.toString();
                                this.p.o();
                                return false;
                            }
                            iftrue(Label_0578:)(!b3);
                            continue Label_0607_Outer;
                        }
                        iftrue(Label_0621:)(!this.p.Z0("UTF8") && !this.p.Z0("UTF-8") && !b4);
                        continue;
                    }
                }
                break;
            }
        }
        
        boolean B() {
            return this.w;
        }
        
        protected void C(final Boolean b) {
            if (this.h != null) {
                if (b) {
                    final q t = this.t;
                    if (t != null && com.alphainventor.filemanager.file.q.D0(t.t())) {
                        com.alphainventor.filemanager.file.q.z0(this.x).t(this.t.t());
                    }
                    if (!TextUtils.isEmpty((CharSequence)this.r)) {
                        this.r = d0.U(this.r);
                    }
                    this.h.T((boolean)b, (Object)this.r);
                    return;
                }
                final q t2 = this.t;
                if (t2 != null && com.alphainventor.filemanager.file.q.D0(t2.t())) {
                    com.alphainventor.filemanager.file.q.z0(this.x).m(this.t.t());
                }
                this.h.T((boolean)b, (Object)this.v);
            }
        }
        
        String D(final String s) {
            final int index = s.indexOf("\"");
            if (index < 0) {
                return s;
            }
            try {
                final StringBuilder sb = new StringBuilder();
                int i = index + 1;
                int n = 0;
                while (i < s.length()) {
                    final char char1 = s.charAt(i);
                    if (char1 == '\"') {
                        if (n != 0) {
                            sb.append(char1);
                            n = 0;
                        }
                        else {
                            n = 1;
                        }
                    }
                    else {
                        if (n != 0) {
                            return sb.toString();
                        }
                        sb.append(char1);
                    }
                    ++i;
                }
                String string = s;
                if (n != 0) {
                    string = sb.toString();
                }
                return string;
            }
            catch (final IndexOutOfBoundsException ex) {
                return s;
            }
        }
        
        protected void r() {
            final c$a h = this.h;
            if (h != null) {
                h.B();
            }
        }
        
        protected Boolean x(final Object... array) {
            final q t = this.t;
            if (t != null) {
                t.i();
            }
            while (true) {
                Label_0083: {
                    try {
                        if (!this.q || this.n) {
                            break Label_0092;
                        }
                        if (this.w(true, true) && this.u != null) {
                            com.alphainventor.filemanager.file.q.u.fine("FTPS detected!!!");
                            this.u.C(true);
                            final Boolean true = Boolean.TRUE;
                            final q t2 = this.t;
                            if (t2 != null) {
                                t2.j();
                            }
                            return true;
                        }
                        break Label_0083;
                    }
                    finally {
                        final q t3 = this.t;
                        if (t3 != null) {
                            t3.j();
                        }
                        final boolean w = this.w(this.n, false);
                        final q t4 = this.t;
                        iftrue(Label_0115:)(t4 == null);
                        Block_9: {
                            break Block_9;
                            com.alphainventor.filemanager.file.q.u.fine("FTPS not detected, try FTP");
                            continue;
                        }
                        t4.j();
                        Label_0115: {
                            return w;
                        }
                    }
                }
                break;
            }
        }
        
        String y() {
            return this.v;
        }
        
        public ax.Sc.e z() {
            return this.p;
        }
    }
    
    class e extends ax.u3.t<ax.Sc.e>
    {
        final q b;
        
        e(final q b) {
            this.b = b;
        }
        
        public ax.Sc.e f() throws K {
            ax.Sc.e h;
            final ax.Sc.e e = h = (ax.Sc.e)super.a();
            if (e != null) {
                h = e;
                if (!((ax.Rc.e)e).w()) {
                    h = this.h();
                }
            }
            return h;
        }
        
        protected void g(final ax.Sc.e e) {
            v0(e);
        }
        
        protected ax.Sc.e h() throws K {
            Label_0123: {
                d d;
                try {
                    d = new d(this.b.p(), null, this.b.t(), null);
                    if (d.h(new Object[0]).l()) {
                        return d.z();
                    }
                }
                catch (final Exception ex) {
                    break Label_0123;
                }
                catch (final K k) {
                    throw k;
                }
                if (!d.B()) {
                    final ax.Ha.b c = ax.Ha.c.h().f().c("FTP CHANNEL OPEN ERROR 1");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("msg:");
                    sb.append(d.y());
                    c.g((Object)sb.toString()).h();
                }
                throw new K("Could not create transfer connection");
            }
            final Exception ex;
            c.h().f().d("FTP CHANNEL OPEN ERROR 2").l((Throwable)ex).h();
            ((Throwable)ex).printStackTrace();
            throw new K("Could not create transfer connection", (Throwable)ex);
        }
        
        public void i(final ax.Sc.e e) {
            if (e == null) {
                com.alphainventor.filemanager.file.q.u.severe("Try to release null ftpclient");
                return;
            }
            if (((ax.Rc.e)e).w()) {
                super.e((Object)e);
            }
        }
    }
    
    class f extends H
    {
        ax.Sc.e c0;
        boolean d0;
        final q e0;
        
        f(final q e0, final ax.Sc.e c0, final InputStream inputStream) {
            this.e0 = e0;
            super(inputStream);
            this.c0 = c0;
        }
        
        public void close() throws IOException {
            if (!this.d0) {
                super.close();
                this.d0 = true;
                if (((ax.Rc.e)this.c0).w()) {
                    this.c0.A0();
                    this.c0.C0();
                    if (this.c0 != this.e0.j) {
                        this.e0.l.i(this.c0);
                    }
                }
            }
        }
    }
    
    public static class g extends g0
    {
        Context a;
        d b;
        c0 c;
        int d;
        HashMap<Integer, k> e;
        
        g(final Context a) {
            this.d = 100000000;
            this.e = (HashMap<Integer, k>)new HashMap();
            this.a = a;
            this.c = new c0(ax.Q2.f.H0);
        }
        
        private int o(final ax.o3.o o) {
            final String e = o.e();
            final InetAddress g = o.g();
            final int i = o.i();
            for (final Map$Entry map$Entry : this.e.entrySet()) {
                final ax.Z2.o a = ((k)map$Entry.getValue()).a;
                if (B.j((Object)a.b(), (Object)e) && B.j((Object)a.d(), (Object)g.getHostAddress()) && a.h() == i) {
                    return (int)map$Entry.getKey();
                }
            }
            return 0;
        }
        
        public void a(final int n) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("FTPPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("version_");
            sb.append(n);
            final SharedPreferences$Editor remove = edit.remove(sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("name_");
            sb2.append(n);
            final SharedPreferences$Editor remove2 = remove.remove(sb2.toString());
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("host_");
            sb3.append(n);
            final SharedPreferences$Editor remove3 = remove2.remove(sb3.toString());
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("port_");
            sb4.append(n);
            final SharedPreferences$Editor remove4 = remove3.remove(sb4.toString());
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("username_");
            sb5.append(n);
            final SharedPreferences$Editor remove5 = remove4.remove(sb5.toString());
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("password_");
            sb6.append(n);
            final SharedPreferences$Editor remove6 = remove5.remove(sb6.toString());
            final StringBuilder sb7 = new StringBuilder();
            sb7.append("initialPath_");
            sb7.append(n);
            final SharedPreferences$Editor remove7 = remove6.remove(sb7.toString());
            final StringBuilder sb8 = new StringBuilder();
            sb8.append("mode_");
            sb8.append(n);
            final SharedPreferences$Editor remove8 = remove7.remove(sb8.toString());
            final StringBuilder sb9 = new StringBuilder();
            sb9.append("security_");
            sb9.append(n);
            final SharedPreferences$Editor remove9 = remove8.remove(sb9.toString());
            final StringBuilder sb10 = new StringBuilder();
            sb10.append("charset_");
            sb10.append(n);
            final SharedPreferences$Editor remove10 = remove9.remove(sb10.toString());
            final StringBuilder sb11 = new StringBuilder();
            sb11.append("created_");
            sb11.append(n);
            final SharedPreferences$Editor remove11 = remove10.remove(sb11.toString());
            final StringBuilder sb12 = new StringBuilder();
            sb12.append("sortindex_");
            sb12.append(n);
            remove11.remove(sb12.toString()).commit();
        }
        
        public ax.Z2.s f(final int n) {
            if (!com.alphainventor.filemanager.file.q.D0(n)) {
                final SharedPreferences sharedPreferences = this.a.getSharedPreferences("FTPPrefs", 0);
                final StringBuilder sb = new StringBuilder();
                sb.append("name_");
                sb.append(n);
                final String string = sharedPreferences.getString(sb.toString(), (String)null);
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("username_");
                sb2.append(n);
                final String string2 = sharedPreferences.getString(sb2.toString(), "anonymous");
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("initialPath_");
                sb3.append(n);
                final String string3 = sharedPreferences.getString(sb3.toString(), (String)null);
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("created_");
                sb4.append(n);
                final long long1 = sharedPreferences.getLong(sb4.toString(), 0L);
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("sortindex_");
                sb5.append(n);
                final long long2 = sharedPreferences.getLong(sb5.toString(), 0L);
                final StringBuilder sb6 = new StringBuilder();
                sb6.append("host_");
                sb6.append(n);
                return new ax.Z2.s(ax.Q2.f.H0, n, string, string2, sharedPreferences.getString(sb6.toString(), (String)null), string3, long1, long2);
            }
            final ax.Z2.o k = this.k(n);
            if (k == null) {
                return new ax.Z2.s(ax.Q2.f.H0, n, (String)null, "", (String)null, (String)null, 0L, 0L);
            }
            return new ax.Z2.s(ax.Q2.f.H0, n, k.b(), "", (String)null, (String)null, 0L, 0L);
        }
        
        public void j(final int n, final long n2) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("FTPPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("sortindex_");
            sb.append(n);
            edit.putLong(sb.toString(), n2);
            edit.apply();
        }
        
        public ax.Z2.o k(int int1) {
            if (com.alphainventor.filemanager.file.q.D0(int1)) {
                final k k = (k)this.e.get((Object)int1);
                if (k != null) {
                    return k.a;
                }
                return null;
            }
            else {
                final ax.Z2.o o = new ax.Z2.o();
                final Context a = this.a;
                boolean b = false;
                final SharedPreferences sharedPreferences = a.getSharedPreferences("FTPPrefs", 0);
                final StringBuilder sb = new StringBuilder();
                sb.append("version_");
                sb.append(int1);
                final int int2 = sharedPreferences.getInt(sb.toString(), 0);
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("name_");
                sb2.append(int1);
                o.q(sharedPreferences.getString(sb2.toString(), ""));
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("host_");
                sb3.append(int1);
                final String string = sharedPreferences.getString(sb3.toString(), "");
                o.s(string);
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("port_");
                sb4.append(int1);
                o.z(sharedPreferences.getInt(sb4.toString(), 21));
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("username_");
                sb5.append(int1);
                o.D(sharedPreferences.getString(sb5.toString(), "anonymous"));
                final StringBuilder sb6 = new StringBuilder();
                sb6.append("password_");
                sb6.append(int1);
                o.y(this.c.a(int2, string, sharedPreferences.getString(sb6.toString(), "")));
                final StringBuilder sb7 = new StringBuilder();
                sb7.append("initialPath_");
                sb7.append(int1);
                o.v(sharedPreferences.getString(sb7.toString(), (String)null));
                final StringBuilder sb8 = new StringBuilder();
                sb8.append("mode_");
                sb8.append(int1);
                o.w(sharedPreferences.getBoolean(sb8.toString(), false));
                final StringBuilder sb9 = new StringBuilder();
                sb9.append("charset_");
                sb9.append(int1);
                o.p(sharedPreferences.getString(sb9.toString(), (String)null));
                final StringBuilder sb10 = new StringBuilder();
                sb10.append("security_");
                sb10.append(int1);
                int1 = sharedPreferences.getInt(sb10.toString(), -1);
                if (int1 < 0) {
                    o.C(false);
                    return o;
                }
                o.C(true);
                if (int1 > 0) {
                    b = true;
                }
                o.x(b);
                return o;
            }
        }
        
        public void l(final int n, final ax.Z2.o o, final ax.g3.k k, final boolean b) {
            int n2 = n;
            if (n == -100) {
                n2 = this.n();
            }
            if (b) {
                (this.b = new d(this.a, o, (c$a)new c$a(this, k, n2, o) {
                    final ax.g3.k a;
                    final int b;
                    final ax.Z2.o c;
                    final g d;
                    
                    public void B() {
                        this.a.b(ax.Q2.f.H0);
                    }
                    
                    public void T(final boolean b, final Object o) {
                        if (b) {
                            this.d.s(this.b, this.c);
                            final ax.Q2.f h0 = ax.Q2.f.H0;
                            final com.alphainventor.filemanager.file.o d = ax.c3.x.d(h0, this.b);
                            new m.d(d.u()).i((Object[])new Long[0]);
                            ax.Z2.b.k().s(d.T(), d.V());
                            this.a.c(h0, this.b);
                            return;
                        }
                        String s;
                        if (o instanceof String) {
                            s = (String)o;
                        }
                        else {
                            s = null;
                        }
                        this.a.a(ax.Q2.f.H0, this.c.d(), this.c.h(), this.c.k(), s);
                    }
                })).h(new Object[0]);
                return;
            }
            this.s(n2, o);
            k.c(ax.Q2.f.H0, n2);
        }
        
        public void m(final int n) {
            final k k = (k)this.e.get((Object)n);
            if (k != null) {
                k.c = false;
            }
        }
        
        int n() {
            return this.a.getSharedPreferences("FTPPrefs", 0).getInt("count", 0);
        }
        
        public List<ax.Z2.s> p() {
            final ArrayList list = new ArrayList();
            final Context a = this.a;
            int i = 0;
            for (SharedPreferences sharedPreferences = a.getSharedPreferences("FTPPrefs", 0); i < sharedPreferences.getInt("count", 0); ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("host_");
                sb.append(i);
                if (sharedPreferences.getString(sb.toString(), (String)null) != null) {
                    ((List)list).add((Object)this.f(i));
                }
            }
            return (List<ax.Z2.s>)list;
        }
        
        public int q(final ax.o3.o o) {
            final String h = o.h();
            final int o2 = this.o(o);
            if (o2 != 0) {
                final k k = (k)this.e.get((Object)o2);
                if (k != null && B.j((Object)h, (Object)k.b) && k.c) {
                    return o2;
                }
            }
            return 0;
        }
        
        public int r(final ax.o3.o o, final String s, final String s2) {
            final String e = o.e();
            final InetAddress g = o.g();
            final int i = o.i();
            final String h = o.h();
            final boolean m = o.m();
            final int o2 = this.o(o);
            if (o2 != 0) {
                final k k = (k)this.e.get((Object)o2);
                if (k != null) {
                    if (B.j((Object)k.a.k(), (Object)s) && B.j((Object)k.a.g(), (Object)s2)) {
                        if (!B.j((Object)h, (Object)k.b)) {
                            k.b = h;
                            k.c = false;
                        }
                        return o2;
                    }
                    k.a.D(s);
                    k.a.y(s2);
                    k.b = h;
                    k.c = false;
                    return o2;
                }
            }
            final int n = this.d++;
            final ax.Z2.o o3 = new ax.Z2.o();
            o3.q(e);
            o3.s(g.getHostAddress());
            o3.z(i);
            o3.D(s);
            o3.y(s2);
            o3.w(false);
            o3.p((String)null);
            o3.C(m);
            this.e.put((Object)n, (Object)new k(o3, h));
            return n;
        }
        
        void s(final int n, final ax.Z2.o o) {
            final Context a = this.a;
            boolean b = false;
            final SharedPreferences sharedPreferences = a.getSharedPreferences("FTPPrefs", 0);
            if (n >= sharedPreferences.getInt("count", 0)) {
                b = true;
            }
            final SharedPreferences$Editor edit = sharedPreferences.edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("version_");
            sb.append(n);
            final SharedPreferences$Editor putInt = edit.putInt(sb.toString(), 3);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("host_");
            sb2.append(n);
            final SharedPreferences$Editor putString = putInt.putString(sb2.toString(), o.d());
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("port_");
            sb3.append(n);
            final SharedPreferences$Editor putInt2 = putString.putInt(sb3.toString(), o.h());
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("username_");
            sb4.append(n);
            final SharedPreferences$Editor putString2 = putInt2.putString(sb4.toString(), o.k());
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("password_");
            sb5.append(n);
            final SharedPreferences$Editor putString3 = putString2.putString(sb5.toString(), this.c.e(o.d(), o.g()));
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("name_");
            sb6.append(n);
            final SharedPreferences$Editor putString4 = putString3.putString(sb6.toString(), o.b());
            final StringBuilder sb7 = new StringBuilder();
            sb7.append("initialPath_");
            sb7.append(n);
            final SharedPreferences$Editor putString5 = putString4.putString(sb7.toString(), o.f());
            final StringBuilder sb8 = new StringBuilder();
            sb8.append("charset_");
            sb8.append(n);
            final SharedPreferences$Editor putString6 = putString5.putString(sb8.toString(), o.a());
            final StringBuilder sb9 = new StringBuilder();
            sb9.append("mode_");
            sb9.append(n);
            putString6.putBoolean(sb9.toString(), o.m());
            if (b) {
                final StringBuilder sb10 = new StringBuilder();
                sb10.append("created_");
                sb10.append(n);
                edit.putLong(sb10.toString(), System.currentTimeMillis());
                final StringBuilder sb11 = new StringBuilder();
                sb11.append("sortindex_");
                sb11.append(n);
                edit.putLong(sb11.toString(), System.currentTimeMillis());
            }
            if (o.o()) {
                final StringBuilder sb12 = new StringBuilder();
                sb12.append("security_");
                sb12.append(n);
                edit.putInt(sb12.toString(), (int)(o.n() ? 1 : 0));
            }
            else {
                final StringBuilder sb13 = new StringBuilder();
                sb13.append("security_");
                sb13.append(n);
                edit.putInt(sb13.toString(), -1);
            }
            if (b) {
                edit.putInt("count", n + 1);
            }
            edit.commit();
        }
        
        public void t(final int n) {
            final k k = (k)this.e.get((Object)n);
            if (k != null) {
                k.c = true;
            }
        }
    }
    
    interface h
    {
        void a(final int p0);
        
        void b(final int p0);
        
        int c();
        
        String d();
        
        boolean e();
        
        void g() throws IOException;
    }
    
    static class i extends ax.Sc.e implements h
    {
        boolean g0;
        int h0;
        String i0;
        int j0;
        
        public void a(final int h0) {
            this.g0 = true;
            this.h0 = h0;
        }
        
        public void b(final int j0) {
            this.j0 = j0;
        }
        
        public int c() {
            return this.j0;
        }
        
        public String d() {
            return this.i0;
        }
        
        public boolean e() {
            boolean b = false;
            try {
                ((ax.Sc.c)this).E();
                b = true;
                return b;
            }
            catch (final SocketTimeoutException | IOException ex) {
                return b;
            }
        }
        
        public void g() throws IOException {
            if (!this.Z0("UTF8") && !this.Z0("UTF-8")) {
                return;
            }
            ((ax.Sc.c)this).m0("UTF-8");
            ((ax.Sc.c)this).x = (BufferedReader)new ax.Uc.a((Reader)new InputStreamReader(((ax.Rc.e)this).e, ((ax.Sc.c)this).O()));
            ((ax.Sc.c)this).y = new BufferedWriter((Writer)new OutputStreamWriter(((ax.Rc.e)this).f, ((ax.Sc.c)this).O()));
        }
        
        protected void i() throws IOException {
            super.i();
            if (((ax.Sc.c)this).R() == 220) {
                this.i0 = ((ax.Sc.c)this).S();
            }
        }
        
        protected Socket v0(final String s, final String s2) throws IOException {
            Socket v0;
            try {
                v0 = super.v0(s, s2);
                if (v0 == null) {
                    return null;
                }
                if (v0.getSendBufferSize() > 1048576) {
                    v0.setSendBufferSize(524288);
                }
            }
            catch (final StringIndexOutOfBoundsException ex) {
                throw new IOException((Throwable)ex);
            }
            if (this.g0) {
                final int h0 = this.h0;
                if (h0 > 0) {
                    v0.setSoLinger(true, h0);
                    final Logger l0 = com.alphainventor.filemanager.file.q.u;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("set so linger:");
                    sb.append(v0.getSoLinger());
                    l0.fine(sb.toString());
                }
            }
            return v0;
        }
    }
    
    static class j extends u implements h
    {
        int A0;
        Object B0;
        Object C0;
        int D0;
        private int w0;
        String x0;
        boolean y0;
        int z0;
        
        j(final boolean b, final int d0) {
            super(b);
            this.D0 = d0;
        }
        
        j(final boolean b, final SSLContext sslContext, final int d0) {
            super(b, sslContext);
            this.D0 = d0;
            this.U1(sslContext);
        }
        
        private boolean T1(final Socket socket) {
            if (Build$VERSION.SDK_INT <= 28) {
                return true;
            }
            if (socket == null) {
                return false;
            }
            final String name = ((SSLSocket)socket).getSession().getClass().getName();
            if ("com.android.org.conscrypt.Java8ExtendedSSLSession".equals((Object)name)) {
                return false;
            }
            if ("com.google.android.gms.org.conscrypt.Java8ExtendedSSLSession".equals((Object)name)) {
                return true;
            }
            b.e("new session class detected");
            return name.contains((CharSequence)"gms");
        }
        
        private void U1(final SSLContext sslContext) {
            try {
                final Socket socket = ((SocketFactory)sslContext.getSocketFactory()).createSocket();
                if (this.T1(socket)) {
                    this.w0 = 1;
                }
                else {
                    this.w0 = 2;
                }
                socket.close();
            }
            catch (final IOException ex) {}
        }
        
        private boolean V1(final SSLSocket sslSocket) {
            final Socket b = ((ax.Rc.e)this).b;
            if (b == null) {
                return false;
            }
            final SSLSession session = ((SSLSocket)b).getSession();
            if (!session.isValid()) {
                return false;
            }
            final SSLSessionContext sessionContext = session.getSessionContext();
            Label_0647: {
                Label_0629: {
                    Object value;
                    int peerPort;
                    Set keySet;
                    try {
                        final Field declaredField = sessionContext.getClass().getDeclaredField("sessionsByHostAndPort");
                        ((AccessibleObject)declaredField).setAccessible(true);
                        value = declaredField.get((Object)sessionContext);
                        peerPort = session.getPeerPort();
                        keySet = ((HashMap)value).keySet();
                        if (keySet.size() == 0) {
                            com.alphainventor.filemanager.file.q.u.severe("invalid SSL session 1");
                            return false;
                        }
                    }
                    catch (final Exception ex) {
                        break Label_0629;
                    }
                    catch (final NoSuchFieldException ex2) {
                        break Label_0647;
                    }
                    final Field declaredField2 = keySet.toArray()[0].getClass().getDeclaredField("port");
                    ((AccessibleObject)declaredField2).setAccessible(true);
                    int n;
                    for (n = 0; n < keySet.size() && (int)declaredField2.get(keySet.toArray()[n]) != peerPort; ++n) {}
                    final int size = keySet.size();
                    final Class type = Integer.TYPE;
                    if (n < size) {
                        final Object c0 = keySet.toArray()[n];
                        final java.lang.reflect.Constructor<?> declaredConstructor = c0.getClass().getDeclaredConstructor(String.class, type);
                        ((AccessibleObject)declaredConstructor).setAccessible(true);
                        final Object instance = declaredConstructor.newInstance(new Object[] { ((Socket)sslSocket).getInetAddress().getHostName(), ((Socket)sslSocket).getPort() });
                        final Object instance2 = declaredConstructor.newInstance(new Object[] { ((Socket)sslSocket).getInetAddress().getHostAddress(), ((Socket)sslSocket).getPort() });
                        final Object value2 = ((HashMap)value).get(c0);
                        if (value2 instanceof ArrayList) {
                            this.C0 = c0;
                            this.B0 = new ArrayList((Collection)value2);
                        }
                        final Method declaredMethod = ((HashMap)value).getClass().getDeclaredMethod("put", Object.class, Object.class);
                        ((AccessibleObject)declaredMethod).setAccessible(true);
                        declaredMethod.invoke(value, new Object[] { instance, value2 });
                        declaredMethod.invoke(value, new Object[] { instance2, value2 });
                        return true;
                    }
                    if (this.B0 != null) {
                        final Object c2 = this.C0;
                        if (c2 != null) {
                            final java.lang.reflect.Constructor<?> declaredConstructor2 = c2.getClass().getDeclaredConstructor(String.class, type);
                            ((AccessibleObject)declaredConstructor2).setAccessible(true);
                            final Object instance3 = declaredConstructor2.newInstance(new Object[] { ((Socket)sslSocket).getInetAddress().getHostName(), ((Socket)sslSocket).getPort() });
                            final Object instance4 = declaredConstructor2.newInstance(new Object[] { ((Socket)sslSocket).getInetAddress().getHostAddress(), ((Socket)sslSocket).getPort() });
                            final Method declaredMethod2 = ((HashMap)value).getClass().getDeclaredMethod("put", Object.class, Object.class);
                            ((AccessibleObject)declaredMethod2).setAccessible(true);
                            declaredMethod2.invoke(value, new Object[] { instance3, this.B0 });
                            declaredMethod2.invoke(value, new Object[] { instance4, this.B0 });
                            return true;
                        }
                    }
                    com.alphainventor.filemanager.file.q.u.severe("invalid SSL session 2");
                    return false;
                }
                final Exception ex;
                ((Throwable)ex).printStackTrace();
                com.alphainventor.filemanager.file.q.u.severe("Session reuse : unknown exception");
                ((Throwable)ex).printStackTrace();
                return false;
            }
            final NoSuchFieldException ex2;
            ((Throwable)ex2).printStackTrace();
            final Logger l0 = com.alphainventor.filemanager.file.q.u;
            final StringBuilder sb = new StringBuilder();
            sb.append("This device is not supported!!!! : api ");
            sb.append(Build$VERSION.SDK_INT);
            l0.severe(sb.toString());
            return false;
        }
        
        private boolean W1() {
            return this.w0 == 2;
        }
        
        private boolean X1() {
            return this.w0 == 1;
        }
        
        protected void E1(final Socket socket) throws IOException {
            if (socket != null) {
                if (socket instanceof SSLSocket && this.X1()) {
                    this.V1((SSLSocket)socket);
                }
                if (socket.getSendBufferSize() > 1048576) {
                    socket.setSendBufferSize(524288);
                }
                if (this.y0) {
                    final int z0 = this.z0;
                    if (z0 > 0) {
                        socket.setSoLinger(true, z0);
                    }
                }
            }
        }
        
        protected Socket I1() throws IOException {
            if (this.W1()) {
                return (Socket)new ax.c3.j(new Socket());
            }
            return super.I1();
        }
        
        protected void J1() throws IOException {
            if (((ax.Sc.c)this).R() == 220) {
                this.x0 = ((ax.Sc.c)this).S();
            }
            super.J1();
        }
        
        public String Q0() {
            final String c = ((ax.Rc.e)this).c;
            if (c != null) {
                return c;
            }
            return super.Q0();
        }
        
        protected Socket Q1(final String s, final String s2) throws IOException {
            final Socket q1 = super.Q1(s, s2);
            if (this.W1() && q1 instanceof ax.c3.j && this.N1() != null) {
                final ax.c3.i i = new ax.c3.i((SSLSocket)this.N1().getSocketFactory().createSocket(q1, ((ax.Rc.e)this).c, this.D0, true), q1);
                i.a(this.D0);
                return (Socket)i;
            }
            return q1;
        }
        
        public void a(final int z0) {
            this.y0 = true;
            this.z0 = z0;
        }
        
        public void b(final int a0) {
            this.A0 = a0;
        }
        
        public int c() {
            return this.A0;
        }
        
        public String d() {
            return this.x0;
        }
        
        public boolean e() {
            boolean b = false;
            try {
                ((ax.Sc.c)this).E();
                b = true;
                return b;
            }
            catch (final SocketTimeoutException | IOException ex) {
                return b;
            }
        }
        
        public void g() throws IOException {
            if (!((ax.Sc.e)this).Z0("UTF8") && !((ax.Sc.e)this).Z0("UTF-8")) {
                return;
            }
            ((ax.Sc.c)this).m0("UTF-8");
            ((ax.Sc.c)this).x = (BufferedReader)new ax.Uc.a((Reader)new InputStreamReader(((ax.Rc.e)this).b.getInputStream(), ((ax.Sc.c)this).O()));
            ((ax.Sc.c)this).y = new BufferedWriter((Writer)new OutputStreamWriter(((ax.Rc.e)this).b.getOutputStream(), ((ax.Sc.c)this).O()));
        }
        
        protected Socket v0(final String s, final String s2) throws IOException {
            final Socket v0 = super.v0(s, s2);
            if (this.W1() && v0 instanceof ax.c3.i) {
                ((ax.c3.i)v0).a(0);
            }
            return v0;
        }
    }
    
    public static class k
    {
        final ax.Z2.o a;
        String b;
        boolean c;
        
        public k(final ax.Z2.o a, final String b) {
            this.a = a;
            this.b = b;
        }
    }
}
