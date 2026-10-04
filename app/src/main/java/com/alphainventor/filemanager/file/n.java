package com.alphainventor.filemanager.file;

import java.net.URLConnection;
import j$.io.DesugarInputStream;
import java.io.InterruptedIOException;
import ax.pb.h0;
import j$.io.InputStreamRetargetInterface;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedOutputStream;
import ax.pb.e0;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.io.IOException;
import ax.pb.k0;
import ax.Ha.b;
import ax.Ha.c;
import ax.c3.d0;
import java.io.File;
import ax.Q2.f;
import ax.b3.q;
import ax.rb.d;
import ax.b3.m;
import ax.b3.s;
import ax.b3.l;
import ax.b3.t;
import ax.b3.e;
import ax.pb.u;
import ax.b3.j;
import ax.pb.a0;
import ax.pb.r;
import ax.pb.b0;
import android.util.LruCache;
import java.util.logging.Logger;

public class N
{
    private static final Logger e;
    private Q a;
    private LruCache<String, b0> b;
    private r c;
    private String d;
    
    static {
        e = Logger.getLogger("FileManager.Smb1Client");
    }
    
    public N(final Q a) {
        this.a = a;
        this.b = new LruCache<String, b0>(this, 10) {
            final N a;
            
            protected int a(final String s, final b0 b0) {
                return 1;
            }
        };
    }
    
    public static j a(final String s, final a0 a0) {
        if (a0 instanceof u) {
            return (j)new e((Throwable)a0);
        }
        final int c = a0.c();
        if (m(c)) {
            return (j)new t((Throwable)a0);
        }
        if (c == -1073741757) {
            return (j)new l((Throwable)a0);
        }
        if (c == -1073741697) {
            return (j)new s((Throwable)a0);
        }
        if (c == -1073741612) {
            return (j)new m((Throwable)a0);
        }
        if (a0.d() instanceof d) {
            return (j)new q((Throwable)a0);
        }
        return ax.b3.d.b(s, (Exception)a0);
    }
    
    public static String g(final Q q, final b0 b0) {
        final String v = b0.v();
        final StringBuilder sb = new StringBuilder();
        final f j0 = f.J0;
        sb.append(j0.K());
        sb.append("://");
        final String replace = v.replace((CharSequence)sb.toString(), (CharSequence)"");
        if (replace.isEmpty()) {
            return File.separator;
        }
        final int index = replace.indexOf("/");
        if (index != -1) {
            return d0.U(replace.substring(index));
        }
        final ax.Ha.b i = c.h().d("INVALID SMB PATH").j();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("PATH:");
        sb2.append(b0.v());
        sb2.append(",");
        sb2.append(b0.z());
        i.g((Object)sb2.toString()).h();
        if (replace.equals((Object)q.r0())) {
            return File.separator;
        }
        final String z = b0.z();
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(j0.K());
        sb3.append("://");
        final String replace2 = z.replace((CharSequence)sb3.toString(), (CharSequence)"");
        final int index2 = replace2.indexOf("/");
        if (index2 == -1) {
            return d0.U(replace);
        }
        return d0.U(replace2.substring(index2));
    }
    
    private static boolean m(final int n) {
        return n == -1073741810 || n == -1073741809 || n == -1073741773 || n == -1073741772 || n == -1073741766;
    }
    
    public static void r(final ax.jb.b b, final int n) throws IOException {
        k0 k0;
        if (n > 0) {
            k0 = ax.pb.k0.s(b, n);
        }
        else {
            k0 = ax.pb.k0.s(b, 445);
        }
        ((ax.rb.c)k0).a(10000L);
    }
    
    public boolean b(final n n) {
        Label_0028: {
            try {
                this.k(n.E()).h();
                return true;
            }
            catch (final a0 a0) {}
            catch (final MalformedURLException ex) {
                break Label_0028;
            }
            final a0 a0;
            ((Throwable)a0).printStackTrace();
            return false;
        }
        final MalformedURLException ex;
        ((Throwable)ex).printStackTrace();
        return false;
    }
    
    public boolean c(final n n) {
        Label_0028: {
            try {
                this.k(n.E()).O();
                return true;
            }
            catch (final a0 a0) {}
            catch (final MalformedURLException ex) {
                break Label_0028;
            }
            final a0 a0;
            ((Throwable)a0).printStackTrace();
            return false;
        }
        final MalformedURLException ex;
        ((Throwable)ex).printStackTrace();
        return false;
    }
    
    public void d(final n n) throws j {
        Label_0076: {
            Label_0064: {
                b0 j;
                try {
                    j = this.j(n, false);
                    if (((ax.c3.b)n).isDirectory()) {
                        if (j.M().length > 0) {
                            throw new j("SMB delete Directory failed : has children");
                        }
                    }
                }
                catch (final a0 a0) {
                    break Label_0064;
                }
                catch (final MalformedURLException ex) {
                    break Label_0076;
                }
                this.b.remove((Object)n.E());
                j.i();
                return;
            }
            final a0 a0;
            ((Throwable)a0).printStackTrace();
            throw a("SMB1 deleteFile", a0);
        }
        final MalformedURLException ex;
        ((Throwable)ex).printStackTrace();
        throw new j((Throwable)ex);
    }
    
    public S e(final String s) throws j {
        Label_0188: {
            try {
                return new S(this.a, this.k(s));
            }
            catch (final NumberFormatException ex) {
                break Label_0188;
            }
            catch (final NullPointerException ex2) {
                break Label_0188;
            }
            catch (final MalformedURLException ex3) {
                break Label_0188;
            }
            catch (final a0 a0) {
                ((Throwable)a0).printStackTrace();
                final int c = a0.c();
                if (m(c)) {
                    return S.f0(this.a, s, true);
                }
                final Logger e = N.e;
                final StringBuilder sb = new StringBuilder();
                sb.append("SmbException : ");
                sb.append(c);
                e.severe(sb.toString());
                throw a("SMB1 getfileinfo", a0);
                final MalformedURLException ex3;
                ((Throwable)ex3).printStackTrace();
                final ax.Ha.b l = ax.Ha.c.h().f().d("MARFORMED URL 1").l((Throwable)ex3);
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("prefix:");
                sb2.append(this.d);
                sb2.append(",path:");
                sb2.append(s);
                sb2.append(",connected:");
                sb2.append(this.a.a());
                l.g((Object)sb2.toString()).h();
                throw new j((Throwable)ex3);
                final NumberFormatException ex;
                ((Throwable)ex).printStackTrace();
                final ax.Ha.b i = ax.Ha.c.h().d("SmbFileInfo Number Format Exception").l((Throwable)ex);
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(s);
                sb3.append(":");
                sb3.append(this.l(s));
                i.g((Object)sb3.toString()).h();
                throw new j((Throwable)ex);
                final NullPointerException ex2;
                ((Throwable)ex2).printStackTrace();
                final ax.Ha.b d = ax.Ha.c.h().d("SmbFileInfo Invalid Path?");
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(s);
                sb4.append(":");
                sb4.append(this.l(s));
                d.g((Object)sb4.toString()).h();
                throw new j((Throwable)ex2);
            }
        }
    }
    
    public InputStream f(final n n, final long n2) throws j {
        b a;
        try {
            a = N.b.a(this.l(n.E()), this.c);
            if (n2 != 0L) {
                a.skip(n2);
            }
        }
        catch (final IOException ex) {
            throw new j((Throwable)ex);
        }
        catch (final FileNotFoundException ex2) {
            throw new t((Throwable)ex2);
        }
        catch (final a0 a2) {
            throw a("SMB1 getInputStream", a2);
        }
        return (InputStream)new BufferedInputStream((InputStream)a, a.b());
    }
    
    public OutputStream h(final n n, final boolean b) throws j {
        b0 j;
        try {
            j = this.j(n, false);
            if (b) {
                final e0 e0 = ax.pb.e0.b(j);
                return (OutputStream)new BufferedOutputStream((OutputStream)e0, e0.d());
            }
        }
        catch (final IOException ex) {
            throw ax.b3.d.b("SMB1 getOutputStream", (Exception)ex);
        }
        catch (final a0 a0) {
            throw a("SMB1 getOutputStream", a0);
        }
        final e0 e0 = ax.pb.e0.a(j);
        return (OutputStream)new BufferedOutputStream((OutputStream)e0, e0.d());
    }
    
    public ax.c3.k0 i(final n n) throws j {
        final b0 j0 = ((S)n).j0();
        if (j0 != null) {
            try {
                final long w = j0.w();
                final long l = j0.L();
                return new ax.c3.k0(l, l - w);
            }
            catch (final Exception ex) {
                throw new j((Throwable)ex);
            }
        }
        throw new j("smb file is null");
    }
    
    public b0 j(final n n, final boolean b) throws MalformedURLException {
        final boolean b2 = ((ax.c3.b)n).isDirectory() || b;
        final S s = (S)n;
        final b0 j0 = s.j0();
        if (j0 != null && (!b2 || ((URLConnection)j0).getURL().getPath().endsWith("/"))) {
            return j0;
        }
        b0 b3;
        if (b2) {
            final StringBuilder sb = new StringBuilder();
            sb.append(n.E());
            sb.append("/");
            b3 = this.k(sb.toString());
        }
        else {
            b3 = this.k(n.E());
        }
        s.k0(b3);
        return b3;
    }
    
    public b0 k(final String s) throws MalformedURLException {
        final b0 b0 = (b0)this.b.get((Object)s);
        if (b0 != null) {
            return b0;
        }
        final b0 b2 = new b0(this.l(s), this.c);
        this.b.put((Object)s, (Object)b2);
        if (s.endsWith("/")) {
            this.b.remove((Object)s.substring(0, s.length() - 1));
            return b2;
        }
        final LruCache<String, b0> b3 = this.b;
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("/");
        b3.remove((Object)sb.toString());
        return b2;
    }
    
    String l(final String s) {
        return Q.z0(this.d, s);
    }
    
    public List<n> n(final n n) throws j {
        while (true) {
        Label_0148:
            while (true) {
                int n2 = 0;
                Label_0123: {
                    ArrayList list;
                    b0 b2;
                    try {
                        final b0 b0 = new b0(this.l(d0.O(n.E())), this.c);
                        final boolean e = d0.E(n);
                        list = new ArrayList();
                        final b0[] m = b0.M();
                        if (m == null) {
                            return (List<n>)list;
                        }
                        final int length = m.length;
                        n2 = 0;
                        if (n2 >= length) {
                            return (List<n>)list;
                        }
                        b2 = m[n2];
                        if (e && b2.C() != 8) {
                            break Label_0123;
                        }
                    }
                    catch (final NullPointerException ex) {
                        throw new j((Throwable)ex);
                    }
                    catch (final a0 a0) {
                        throw a("SMB1 listChildren", a0);
                    }
                    catch (final MalformedURLException ex2) {
                        break Label_0148;
                    }
                    ((List)list).add((Object)new S(this.a, b2));
                }
                ++n2;
                continue;
            }
            final MalformedURLException ex2;
            ax.Ha.c.h().f().d("MARFORMED URL 2").l((Throwable)ex2).h();
            throw new j((Throwable)ex2);
        }
    }
    
    public void o(final n n, final n n2) throws j {
        Label_0041: {
            try {
                final b0 j = this.j(n, false);
                j.W(this.j(n2, j.G()));
                return;
            }
            catch (final a0 a0) {}
            catch (final MalformedURLException ex) {
                break Label_0041;
            }
            final a0 a0;
            ((Throwable)a0).printStackTrace();
            throw a("SMB1 moveFile", a0);
        }
        final MalformedURLException ex;
        ((Throwable)ex).printStackTrace();
        throw new j((Throwable)ex);
    }
    
    public void p(final n n, final long n2) throws j {
        try {
            this.j(n, false).a0(n2);
            return;
        }
        catch (final IOException ex) {}
        catch (final a0 a0) {
            throw a("SMB1 setLastModified", a0);
        }
        final IOException ex;
        throw ax.b3.d.b("SMB1 setLastModified", (Exception)ex);
    }
    
    public void q(final r c, final String d) {
        this.c = c;
        this.d = d;
    }
    
    public static class b extends InputStream implements InputStreamRetargetInterface, AutoCloseable
    {
        private long c0;
        private long d0;
        private h0 q;
        
        public b(final h0 q) throws IOException {
            this.q = q;
            this.c0 = q.c();
        }
        
        public static b a(final String s, final r r) throws IOException {
            final b0 b0 = new b0(s, r, 1);
            if (b0.s()) {
                return new b(new h0(b0, "r"));
            }
            throw new FileNotFoundException("SmbFile does not exist");
        }
        
        private IOException c(a0 a0) {
            Throwable t2;
            final Throwable t = t2 = a0.d();
            if (t instanceof d) {
                a0 = (a0)t;
                t2 = ((d)a0).a();
            }
            if (t2 instanceof InterruptedException) {
                a0 = (a0)new InterruptedIOException(t2.getMessage());
                ((Throwable)a0).initCause(t2);
            }
            return (IOException)a0;
        }
        
        public int b() {
            return this.q.b();
        }
        
        public void close() {
            try {
                this.q.a();
            }
            catch (final a0 a0) {
                ((Throwable)a0).printStackTrace();
            }
        }
        
        public int read() throws IOException {
            if (this.c0 - this.d0 == 0L) {
                return -1;
            }
            try {
                final int d = this.q.d();
                this.d0 += d;
                return d;
            }
            catch (final a0 a0) {
                ((Throwable)a0).printStackTrace();
                throw this.c(a0);
            }
        }
        
        public int read(final byte[] array) throws IOException {
            return this.read(array, 0, array.length);
        }
        
        public int read(final byte[] array, int e, final int n) throws IOException {
            try {
                if (this.c0 - this.d0 == 0L) {
                    return -1;
                }
                e = this.q.e(array, e, n);
                this.d0 += e;
                return e;
            }
            catch (final a0 a0) {
                ((Throwable)a0).printStackTrace();
                throw this.c(a0);
            }
        }
        
        public long skip(final long n) throws IOException {
            this.q.f(this.d0 + n);
            this.d0 += n;
            return n;
        }
    }
}
