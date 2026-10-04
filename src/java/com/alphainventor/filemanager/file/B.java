package com.alphainventor.filemanager.file;

import java.util.AbstractCollection;
import java.util.zip.ZipEntry;
import ax.oc.a$a;
import android.system.ErrnoException;
import java.nio.channels.SeekableByteChannel;
import ax.T.l;
import ax.u3.q$e;
import ax.c3.H;
import java.nio.charset.Charset;
import ax.c3.x;
import java.io.FileOutputStream;
import ax.u3.q;
import androidx.fragment.app.Fragment;
import android.app.Activity;
import ax.c3.d0;
import ax.c3.G;
import ax.X2.Q;
import java.io.BufferedInputStream;
import ax.c3.z;
import ax.b3.t;
import java.io.FileInputStream;
import ax.Dc.J;
import ax.Dc.N;
import ax.Dc.U;
import ax.Dc.D;
import ax.g3.i;
import java.util.List;
import android.graphics.Bitmap;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import android.graphics.Bitmap$CompressFormat;
import java.io.ByteArrayOutputStream;
import ax.Q2.f;
import android.content.Context;
import ax.b3.j;
import ax.b3.F;
import ax.rc.e;
import ax.qc.h;
import java.io.InputStream;
import ax.c3.K;
import java.util.Iterator;
import java.util.Stack;
import java.util.Enumeration;
import ax.Q2.d;
import ax.Ha.c;
import android.text.TextUtils;
import ax.Dc.S;
import java.io.IOException;
import ax.c3.B;
import ax.Dc.I;
import j$.util.DesugarCollections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.io.File;
import ax.c3.a;
import ax.Dc.T;
import java.io.Closeable;
import android.os.ParcelFileDescriptor;
import android.net.Uri;
import java.util.Set;
import java.util.logging.Logger;
import java.util.HashMap;

public class b extends m
{
    private static HashMap<String, Integer> A;
    private static final Logger x;
    private static final Set<String> y;
    private static HashMap<Integer, String> z;
    private String h;
    private y i;
    private Uri j;
    private int k;
    private ParcelFileDescriptor l;
    private Closeable m;
    private T n;
    private boolean o;
    private ax.c3.a p;
    private boolean q;
    private int r;
    private boolean s;
    private String t;
    private File u;
    private File v;
    private Object w;
    
    static {
        x = Logger.getLogger("FileManager.ArchiveFileHelper");
        y = DesugarCollections.unmodifiableSet((Set)new HashSet((Collection)Arrays.asList((Object[])new String[] { "jpg", "jpeg", "png", "gif", "webp", "heic", "heif", "avif", "mp4", "m4v", "mov", "mkv", "webm", "avi", "3gp", "3g2", "flv", "wmv", "mp3", "m4a", "aac", "ogg", "oga", "opus", "flac", "zip", "7z", "rar", "gz", "bz2", "xz", "tgz", "tbz", "tbz2", "txz", "aab", "jar" })));
        b.z = (HashMap<Integer, String>)new HashMap();
        b.A = (HashMap<String, Integer>)new HashMap();
    }
    
    public b() {
        this.w = new Object();
        this.q = false;
    }
    
    private void C0(final ax.c3.a a, final I i, final I j) throws IOException {
        final long p3 = a.p();
        if (p1((n)a, p3)) {
            long crc;
            if (i instanceof d) {
                final File l0 = this.L0((n)a);
                if (!l0.exists()) {
                    return;
                }
                if (l0.isDirectory()) {
                    return;
                }
                crc = B.c(l0);
            }
            else if ((crc = ((ZipEntry)i).getCrc()) < 0L) {
                return;
            }
            j.setMethod(0);
            j.setSize(p3);
            ((ZipEntry)j).setCompressedSize(p3);
            ((ZipEntry)j).setCrc(crc);
        }
    }
    
    private static void E0(final File file) {
        if (file != null) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    final String[] list = file.list();
                    if (list != null && list.length == 0) {
                        I0(file);
                    }
                }
                else {
                    file.delete();
                }
            }
        }
    }
    
    private void F0(final S s) {
        this.p = new ax.c3.a(this, this.H0("/"), (ax.c3.a)null);
        Enumeration f = s.f();
        String s2;
        while (true) {
            final boolean hasMoreElements = f.hasMoreElements();
            s2 = "//";
            if (!hasMoreElements) {
                break;
            }
            final I i = (I)f.nextElement();
            if (!i.isDirectory()) {
                continue;
            }
            final String name = i.getName();
            final String[] split = name.split(File.separator);
            ax.c3.a p = this.p;
            final StringBuilder sb = new StringBuilder();
            for (int j = 0; j < split.length - 1; ++j) {
                if (TextUtils.isEmpty((CharSequence)split[j])) {
                    final b d = ax.Ha.c.h().f().d("ARCHIVE INVALID SEGMENT 1");
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Entry:");
                    sb2.append(i.getName());
                    sb2.append(",Length:");
                    sb2.append(i.getName().length());
                    d.g((Object)sb2.toString()).h();
                }
                else {
                    sb.append(split[j]);
                    sb.append(File.separator);
                    ax.c3.a h0;
                    if ((h0 = p.h0(split[j])) == null) {
                        h0 = new ax.c3.a(this, this.H0(sb.toString()), p);
                        p.e0(h0);
                    }
                    p = h0;
                }
            }
            final Enumeration enumeration = f = f;
            if (name.endsWith("//")) {
                continue;
            }
            f = enumeration;
            if (name.endsWith("///")) {
                continue;
            }
            final ax.c3.a a = new ax.c3.a(this, i, p);
            if (!TextUtils.isEmpty((CharSequence)a.k0())) {
                p.e0(a);
                f = enumeration;
            }
            else {
                f = enumeration;
                if ("/".equals((Object)name)) {
                    continue;
                }
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Invalid entry:");
                sb3.append(name);
                ax.Q2.d.c("archivefileinfo name", (Throwable)new Exception(sb3.toString()));
                f = enumeration;
            }
        }
        Enumeration f2 = s.f();
        String s3 = s2;
        while (f2.hasMoreElements()) {
            final I k = (I)f2.nextElement();
            String s4;
            Enumeration enumeration3;
            if (!k.isDirectory()) {
                final String name2 = k.getName();
                final String[] split2 = name2.split(File.separator);
                ax.c3.a p2 = this.p;
                final StringBuilder sb4 = new StringBuilder();
                for (int l = 0; l < split2.length - 1; ++l) {
                    if (TextUtils.isEmpty((CharSequence)split2[l])) {
                        final b d2 = ax.Ha.c.h().f().d("ARCHIVE INVALID SEGMENT 2");
                        final StringBuilder sb5 = new StringBuilder();
                        sb5.append("Entry:");
                        sb5.append(name2);
                        sb5.append(",Length:");
                        sb5.append(name2.length());
                        d2.g((Object)sb5.toString()).h();
                    }
                    else {
                        sb4.append(split2[l]);
                        sb4.append(File.separator);
                        final ax.c3.a h2 = p2.h0(split2[l]);
                        if (h2 == null) {
                            final String string = sb4.toString();
                            if (string.endsWith(s3)) {
                                final b d3 = ax.Ha.c.h().f().d("ARCHIVE ENTRY ERROR");
                                final StringBuilder sb6 = new StringBuilder();
                                sb6.append("Entry:");
                                sb6.append(name2);
                                sb6.append(",");
                                sb6.append(name2.length());
                                sb6.append(",");
                                sb6.append(string);
                                d3.g((Object)sb6.toString()).h();
                            }
                            final ax.c3.a a2 = new ax.c3.a(this, this.H0(string), p2);
                            p2.e0(a2);
                            p2 = a2;
                        }
                        else {
                            p2 = h2;
                        }
                    }
                }
                final Enumeration enumeration2 = f2;
                s4 = s3;
                final ax.c3.a a3 = new ax.c3.a(this, k, p2);
                if (!TextUtils.isEmpty((CharSequence)a3.k0())) {
                    p2.e0(a3);
                    enumeration3 = enumeration2;
                }
                else {
                    final StringBuilder sb7 = new StringBuilder();
                    sb7.append("Invalid entry:");
                    sb7.append(name2);
                    ax.Q2.d.c("archivefileinfo name", (Throwable)new Exception(sb7.toString()));
                    enumeration3 = enumeration2;
                }
            }
            else {
                final Enumeration enumeration4 = f2;
                s4 = s3;
                enumeration3 = enumeration4;
            }
            final Enumeration enumeration5 = enumeration3;
            s3 = s4;
            f2 = enumeration5;
        }
    }
    
    private int G0(ax.c3.a a) {
        if (!a.isDirectory()) {
            return 1;
        }
        final Stack stack = new Stack();
        stack.push((Object)a);
        int n = 0;
        while (!((AbstractCollection)stack).isEmpty()) {
            a = (ax.c3.a)stack.pop();
            if (a.isDirectory()) {
                final Iterator iterator = a.i0().iterator();
                int n2 = n;
                while (true) {
                    n = n2;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    final ax.c3.a a2 = (ax.c3.a)iterator.next();
                    if (a2 == null) {
                        ax.Q2.d.c("null archive child", (Throwable)new Exception("archive child null"));
                    }
                    else if (a2.isDirectory()) {
                        stack.push((Object)a2);
                    }
                    else {
                        ++n2;
                    }
                }
            }
        }
        return n;
    }
    
    private I H0(final String s) {
        return new d(s);
    }
    
    public static boolean I0(final File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                final String[] list = file.list();
                if (list != null) {
                    for (int i = 0; i < list.length; ++i) {
                        if (!I0(new File(file, list[i]))) {
                            return false;
                        }
                    }
                }
            }
            return file.delete();
        }
        return false;
    }
    
    private void J0(final ax.c3.a a) {
        final File l0 = this.L0((n)a);
        if (!l0.exists()) {
            return;
        }
        if (l0.isDirectory()) {
            I0(l0);
            return;
        }
        l0.delete();
    }
    
    public static int M0(final Uri uri) {
        final Class<b> clazz;
        monitorenter(clazz = b.class);
        Label_0103: {
            if (uri == null) {
                break Label_0103;
            }
            Label_0042: {
                try {
                    final String string = uri.toString();
                    final Integer n = (Integer)b.A.get((Object)string);
                    if (n != null) {
                        final int intValue = n;
                        monitorexit(clazz);
                        return intValue;
                    }
                    break Label_0042;
                }
                finally {
                    monitorexit(clazz);
                    final String string;
                    Integer n2 = null;
                    Label_0076: {
                        b.A.put((Object)string, (Object)n2);
                    }
                    b.z.put((Object)n2, (Object)string);
                    final int intValue2 = n2;
                    monitorexit(clazz);
                    return intValue2;
                    while (true) {
                        while (true) {
                            ++n2;
                            iftrue(Label_0076:)(!b.z.containsKey((Object)n2));
                            continue;
                        }
                        n2 = Math.abs(string.hashCode());
                        continue;
                    }
                    ax.u3.b.f();
                    monitorexit(clazz);
                    return 0;
                }
            }
        }
    }
    
    public static Uri P0(final K k) {
        final Class<b> clazz;
        monitorenter(clazz = b.class);
        while (true) {
            try {
                try {
                    final String s = (String)b.z.get((Object)k.b());
                    if (s != null) {
                        return Uri.parse(s);
                    }
                }
                finally {
                    monitorexit(clazz);
                }
                monitorexit(clazz);
                return null;
            }
            catch (final Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public static InputStream Q0(final T t, final I i, final String s) throws IOException, j {
        final h h = new h(t.A0(i), s.toCharArray());
        final ax.rc.e e = new ax.rc.e();
        ((ax.rc.b)e).u(((ZipEntry)i).getCrc());
        ((ax.rc.b)e).w(i.isDirectory());
        ((ax.rc.b)e).s(((ZipEntry)i).getCompressedSize());
        ((ax.rc.b)e).G(i.getSize());
        if (h.g(e, false) != null) {
            return (InputStream)h;
        }
        throw new F("Could not locate local file header for encrypted entry");
    }
    
    private File R0() {
        if (this.h == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(this.h.replace((CharSequence)".", (CharSequence)"_"));
        sb.append(System.currentTimeMillis());
        return new File(ax.Z2.a.m(this.p(), "archive-edit"), sb.toString());
    }
    
    private File S0(final n n, final boolean b) {
        final File u = this.u;
        if (b && !u.exists()) {
            u.mkdirs();
        }
        final File file = new File(u, n.E());
        final File parentFile = file.getParentFile();
        if (b && parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        return file;
    }
    
    private static File U0(final Context context, final ax.Q2.f f, final int n) {
        return ax.Z2.a.i(context, f, n);
    }
    
    private ax.c3.a X0(final String s) {
        final String[] split = s.split(File.separator);
        if (split != null) {
            ax.c3.a p = this.p;
            ax.c3.a h0;
            for (int i = 0; i < split.length - 1; ++i, p = h0) {
                final String s2 = split[i];
                h0 = p;
                if (s2 != null) {
                    if (s2.length() == 0) {
                        h0 = p;
                    }
                    else if ((h0 = p.h0(s2)) == null) {
                        return null;
                    }
                }
            }
            return p;
        }
        return null;
    }
    
    private InputStream Z0(final ax.c3.a a) {
        Bitmap bitmap;
        if ((bitmap = ax.u3.B.i(this.s((n)a), 512)) == null) {
            bitmap = ax.s3.a.b();
        }
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(32768);
        bitmap.compress(Bitmap$CompressFormat.PNG, 0, (OutputStream)byteArrayOutputStream);
        return (InputStream)new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }
    
    private InputStream a1(final I i) throws IOException, j {
        if (this.s && !TextUtils.isEmpty((CharSequence)this.t)) {
            return Q0(this.n, i, this.t);
        }
        return ((S)this.n).j(i);
    }
    
    public static boolean d1(final S s, final ax.u3.c c) throws ax.b3.a {
        final Enumeration f = s.f();
        while (f.hasMoreElements()) {
            if (c != null && c.isCancelled()) {
                throw new ax.b3.a();
            }
            if (((I)f.nextElement()).o().l()) {
                return true;
            }
        }
        return false;
    }
    
    public static String g1(String s, final boolean b) {
        final String separator = File.separator;
        String substring = s;
        if (s.startsWith(separator)) {
            substring = s.substring(1);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(substring);
        if (b) {
            s = separator;
        }
        else {
            s = "";
        }
        sb.append(s);
        return sb.toString();
    }
    
    private boolean h1(final File file, final File file2) throws j {
        if (!file.exists()) {
            return false;
        }
        if (file2.exists() && !I0(file2)) {
            throw new j("Could not delete stale edit copy");
        }
        if (file.renameTo(file2)) {
            return true;
        }
        throw new j("Could not move archive edit copy");
    }
    
    private void i1(final ax.c3.a a) {
        final File l0 = this.L0((n)a);
        if (l0.exists()) {
            a.o0(l0);
        }
        if (a.isDirectory()) {
            final List i0 = a.i0();
            if (i0 != null) {
                final Iterator iterator = i0.iterator();
                while (iterator.hasNext()) {
                    this.i1((ax.c3.a)iterator.next());
                }
            }
        }
    }
    
    private boolean j1(final o o, final n n, n z, final File file) throws j {
        n n3;
        final n n2 = n3 = o.z(file.getAbsolutePath());
        try {
            if (((ax.c3.b)n2).n()) {
                o.P(n2);
                n3 = o.z(file.getAbsolutePath());
            }
            o.m0(n, n3, null, null);
            try {
                o.m0(o.z(z.E()), o.z(n.E()), null, null);
                z = o.z(file.getAbsolutePath());
                if (((ax.c3.b)z).n()) {
                    o.P(z);
                }
                this.q = false;
                return true;
            }
            catch (final j | ax.b3.a j | a) {
                this.k1(o, n, file);
            }
            return false;
        }
        catch (final j | ax.b3.a j | a2) {
            return false;
        }
    }
    
    private void k1(final o o, final n n, final File file) throws j {
        final n z = o.z(file.getAbsolutePath());
        if (((ax.c3.b)z).n()) {
            if (!((ax.c3.b)o.z(n.E())).n()) {
                try {
                    o.m0(z, o.z(n.E()), null, null);
                }
                catch (final ax.b3.a a) {
                    throw new j((Throwable)a);
                }
            }
        }
    }
    
    public static void o1(final I i, final long n) {
        final D d = new D();
        d.s(new U(n / 1000L));
        i.d((N)d);
    }
    
    public static boolean p1(final n n, final long n2) {
        return n2 != -1L && b.y.contains((Object)n.A());
    }
    
    private static void q1(final InputStream inputStream, long n) throws IOException {
        while (n > 0L) {
            final long skip = inputStream.skip(n);
            if (skip > 0L) {
                n -= skip;
            }
            else {
                if (inputStream.read() < 0) {
                    break;
                }
                --n;
            }
        }
    }
    
    private void t1(final ax.c3.a ex, final J j, final Integer[] array, final i i) throws j {
        Label_0867: {
            if (ex == null) {
                break Label_0867;
            }
            final I l0 = ((ax.c3.a)ex).l0();
            Label_0854: {
                if (l0 == null) {
                    break Label_0854;
                }
                final boolean b = false;
                final InputStream inputStream = null;
                Object l2 = null;
                final InputStream inputStream2 = null;
                int n = b ? 1 : 0;
                Object a1 = inputStream2;
                Label_0831: {
                    Label_0803: {
                        Label_0649: {
                            I h0;
                            try {
                                try {
                                    h0 = this.H0(((ax.c3.a)ex).t());
                                    n = (b ? 1 : 0);
                                    a1 = inputStream2;
                                    if (((ax.c3.a)ex).q() >= 0L) {
                                        n = (b ? 1 : 0);
                                        a1 = inputStream2;
                                        ((ZipEntry)h0).setTime(((ax.c3.a)ex).q());
                                        n = (b ? 1 : 0);
                                        a1 = inputStream2;
                                        o1(h0, ((ax.c3.a)ex).q());
                                    }
                                }
                                finally {}
                            }
                            catch (final ArrayIndexOutOfBoundsException ex) {
                                break Label_0649;
                            }
                            catch (final IOException ex) {
                                break Label_0803;
                            }
                            final ax.c3.a a2;
                            if (!a2.isDirectory()) {
                                this.C0(a2, l0, h0);
                            }
                            j.u0((ax.Ac.a)h0);
                            InputStream inputStream3 = inputStream;
                            Label_0568: {
                                Label_0413: {
                                    Label_0388: {
                                        try {
                                            if (a2.isDirectory()) {
                                                break Label_0568;
                                            }
                                            inputStream3 = inputStream;
                                            if (!(l0 instanceof d)) {
                                                break Label_0388;
                                            }
                                            inputStream3 = inputStream;
                                            l2 = this.L0((n)a2);
                                            inputStream3 = inputStream;
                                            if (((File)l2).exists()) {
                                                inputStream3 = inputStream;
                                                inputStream3 = inputStream;
                                                final FileInputStream fileInputStream = new FileInputStream((File)l2);
                                                break Label_0413;
                                            }
                                        }
                                        catch (final ArrayIndexOutOfBoundsException ex2) {
                                            break Label_0649;
                                        }
                                        catch (final IOException ex3) {
                                            break Label_0803;
                                        }
                                        finally {
                                            n = 1;
                                            a1 = inputStream3;
                                            break Label_0831;
                                        }
                                        ax.u3.b.e("Edit copy does not exist");
                                        throw new t("Archive entry input edit copy does not exist");
                                    }
                                    a1 = this.a1(l0);
                                    if (a1 == null) {
                                        throw new t("Archive entry input stream is null");
                                    }
                                }
                                ax.c3.F.b((InputStream)a1, (OutputStream)j);
                                l2 = a1;
                                if (i != null) {
                                    final int n2 = array[0] + 1;
                                    array[0] = n2;
                                    i.a((long)n2, (long)array[1]);
                                    l2 = a1;
                                }
                            }
                            j.d();
                            if (l2 != null) {
                                try {
                                    ((InputStream)l2).close();
                                }
                                catch (final IOException ex4) {}
                            }
                            if (((ax.c3.a)ex).isDirectory()) {
                                final Iterator iterator = ((ax.c3.a)ex).i0().iterator();
                                while (iterator.hasNext()) {
                                    this.t1((ax.c3.a)iterator.next(), j, array, i);
                                }
                            }
                            return;
                        }
                        final b d = ax.Ha.c.h().d("AFWE:");
                        final StringBuilder sb = new StringBuilder();
                        sb.append(l0.getSize());
                        sb.append(":");
                        sb.append(l0.getName());
                        d.g((Object)sb.toString()).h();
                        throw new j((Throwable)ex);
                    }
                    ((Throwable)ex).printStackTrace();
                    throw ax.b3.d.a("write entry error", (Exception)ex);
                }
                if (a1 != null) {
                    try {
                        ((InputStream)a1).close();
                    }
                    catch (final IOException ex5) {}
                }
                if (n == 0) {
                    break Label_0854;
                }
                try {
                    j.d();
                    throw new j("zipEntry == null");
                    throw new j("fileinfo == null");
                }
                catch (final IOException ex6) {
                    throw new j("zipEntry == null");
                }
            }
        }
    }
    
    public InputStream A(final String s, final String s2, final String s3) {
        InputStream z0 = null;
        try {
            final ax.c3.a a = (ax.c3.a)this.z(s2);
            final z g = ((n)a).G();
            if (ax.c3.z.f0 == g) {
                return (InputStream)new ax.ca.a((InputStream)new BufferedInputStream(this.J((n)a, 0L), 32768), (int)a.p());
            }
            if (ax.c3.z.e0 == g) {
                if (Q.e1()) {
                    z0 = this.Z0(a);
                }
                return z0;
            }
            ax.u3.b.f();
            return null;
        }
        catch (final j j) {
            return null;
        }
    }
    
    public boolean B(final n n) {
        return true;
    }
    
    public List<n> C(final n n, final m.f f) throws j {
        if (!((ax.c3.b)n).n()) {
            throw new t();
        }
        if (((ax.c3.b)n).isDirectory()) {
            return (List<n>)((ax.c3.a)n).j0();
        }
        throw new j("file is not directory");
    }
    
    public void D(final n p0, final G p1, final String p2, final long p3, final Long p4, final p p5, final boolean p6, final ax.u3.c p7, final i p8) throws j, ax.b3.a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface ax/c3/b.n:()Z
        //     6: invokestatic    ax/u3/b.a:(Z)V
        //     9: aload_0        
        //    10: invokevirtual   com/alphainventor/filemanager/file/b.D0:()Z
        //    13: ifeq            668
        //    16: aload_0        
        //    17: aload_1        
        //    18: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //    21: invokevirtual   com/alphainventor/filemanager/file/b.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //    24: astore_3       
        //    25: aload_3        
        //    26: invokeinterface ax/c3/b.n:()Z
        //    31: istore          11
        //    33: iconst_0       
        //    34: istore          8
        //    36: iload           11
        //    38: ifeq            69
        //    41: aload_3        
        //    42: invokeinterface ax/c3/b.isDirectory:()Z
        //    47: aload_1        
        //    48: invokeinterface ax/c3/b.isDirectory:()Z
        //    53: if_icmpeq       59
        //    56: iconst_1       
        //    57: istore          8
        //    59: new             Lax/b3/f;
        //    62: dup            
        //    63: iload           8
        //    65: invokespecial   ax/b3/f.<init>:(Z)V
        //    68: athrow         
        //    69: aconst_null    
        //    70: astore          7
        //    72: aconst_null    
        //    73: astore_3       
        //    74: aconst_null    
        //    75: astore          13
        //    77: aconst_null    
        //    78: astore          14
        //    80: aload_1        
        //    81: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //    84: astore_1       
        //    85: aload_0        
        //    86: aload_1        
        //    87: invokespecial   com/alphainventor/filemanager/file/b.X0:(Ljava/lang/String;)Lax/c3/a;
        //    90: astore          16
        //    92: aload           16
        //    94: ifnull          498
        //    97: new             Lax/c3/a;
        //   100: astore          15
        //   102: aload           15
        //   104: aload_0        
        //   105: aload_0        
        //   106: aload_1        
        //   107: iconst_0       
        //   108: invokestatic    com/alphainventor/filemanager/file/b.g1:(Ljava/lang/String;Z)Ljava/lang/String;
        //   111: invokespecial   com/alphainventor/filemanager/file/b.H0:(Ljava/lang/String;)Lax/Dc/I;
        //   114: aload           16
        //   116: invokespecial   ax/c3/a.<init>:(Lcom/alphainventor/filemanager/file/b;Lax/Dc/I;Lax/c3/a;)V
        //   119: aload_0        
        //   120: aload           15
        //   122: invokevirtual   com/alphainventor/filemanager/file/b.Y0:(Lcom/alphainventor/filemanager/file/n;)Ljava/io/File;
        //   125: astore          12
        //   127: aload           15
        //   129: aload           12
        //   131: invokevirtual   ax/c3/a.o0:(Ljava/io/File;)V
        //   134: aload           12
        //   136: invokevirtual   java/io/File.exists:()Z
        //   139: ifeq            217
        //   142: aload           12
        //   144: invokevirtual   java/io/File.isDirectory:()Z
        //   147: ifeq            217
        //   150: aload           12
        //   152: invokestatic    com/alphainventor/filemanager/file/b.I0:(Ljava/io/File;)Z
        //   155: ifeq            161
        //   158: goto            217
        //   161: new             Ljava/io/IOException;
        //   164: astore_1       
        //   165: aload_1        
        //   166: ldc_w           "Could not delete stale edit copy"
        //   169: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   172: aload_1        
        //   173: athrow         
        //   174: astore_1       
        //   175: aconst_null    
        //   176: astore_2       
        //   177: aload           13
        //   179: astore          7
        //   181: goto            634
        //   184: astore_1       
        //   185: aconst_null    
        //   186: astore_3       
        //   187: aconst_null    
        //   188: astore_2       
        //   189: aload_3        
        //   190: astore          6
        //   192: goto            511
        //   195: astore_1       
        //   196: aconst_null    
        //   197: astore_2       
        //   198: aconst_null    
        //   199: astore_3       
        //   200: aload_3        
        //   201: astore          6
        //   203: goto            550
        //   206: astore_1       
        //   207: aconst_null    
        //   208: astore_2       
        //   209: aconst_null    
        //   210: astore_3       
        //   211: aload_3        
        //   212: astore          6
        //   214: goto            589
        //   217: new             Ljava/io/FileOutputStream;
        //   220: astore_1       
        //   221: aload_1        
        //   222: aload           12
        //   224: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   227: aload_2        
        //   228: invokevirtual   ax/c3/G.b:()Ljava/io/InputStream;
        //   231: astore_2       
        //   232: aload_2        
        //   233: astore_3       
        //   234: aload_1        
        //   235: astore          7
        //   237: aload_2        
        //   238: aload_1        
        //   239: lload           4
        //   241: aload           9
        //   243: aload           10
        //   245: invokestatic    ax/c3/F.c:(Ljava/io/InputStream;Ljava/io/OutputStream;JLax/u3/c;Lax/g3/i;)J
        //   248: pop2           
        //   249: aload_2        
        //   250: astore_3       
        //   251: aload_1        
        //   252: astore          7
        //   254: aload_1        
        //   255: invokevirtual   java/io/FileOutputStream.close:()V
        //   258: aload           16
        //   260: aload           15
        //   262: invokevirtual   ax/c3/a.e0:(Lax/c3/a;)V
        //   265: aload           6
        //   267: ifnull          353
        //   270: aload           6
        //   272: invokevirtual   java/lang/Long.longValue:()J
        //   275: lstore          4
        //   277: lload           4
        //   279: lconst_0       
        //   280: lcmp           
        //   281: iflt            353
        //   284: aload           12
        //   286: aload           6
        //   288: invokevirtual   java/lang/Long.longValue:()J
        //   291: invokevirtual   java/io/File.setLastModified:(J)Z
        //   294: pop            
        //   295: goto            353
        //   298: astore_1       
        //   299: aload           13
        //   301: astore          7
        //   303: goto            634
        //   306: astore_1       
        //   307: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   310: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   313: ldc_w           "set last modified 1"
        //   316: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   319: aload_1        
        //   320: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   323: invokevirtual   ax/Ha/b.h:()V
        //   326: goto            353
        //   329: astore_1       
        //   330: aconst_null    
        //   331: astore          6
        //   333: aload_2        
        //   334: astore_3       
        //   335: aload           6
        //   337: astore_2       
        //   338: goto            189
        //   341: astore_1       
        //   342: aconst_null    
        //   343: astore_3       
        //   344: goto            200
        //   347: astore_1       
        //   348: aconst_null    
        //   349: astore_3       
        //   350: goto            211
        //   353: aload_0        
        //   354: iconst_1       
        //   355: putfield        com/alphainventor/filemanager/file/b.q:Z
        //   358: aload_2        
        //   359: ifnull          374
        //   362: aload_2        
        //   363: invokevirtual   java/io/InputStream.close:()V
        //   366: goto            374
        //   369: astore_1       
        //   370: aload_1        
        //   371: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   374: return         
        //   375: astore_1       
        //   376: aload_3        
        //   377: astore_2       
        //   378: goto            634
        //   381: astore          6
        //   383: aload_2        
        //   384: astore_3       
        //   385: aload_1        
        //   386: astore_2       
        //   387: aload           6
        //   389: astore_1       
        //   390: goto            189
        //   393: astore          6
        //   395: aload_1        
        //   396: astore_3       
        //   397: aload           6
        //   399: astore_1       
        //   400: goto            200
        //   403: astore          6
        //   405: aload_1        
        //   406: astore_3       
        //   407: aload           6
        //   409: astore_1       
        //   410: goto            211
        //   413: astore_3       
        //   414: aconst_null    
        //   415: astore_2       
        //   416: aload_1        
        //   417: astore          7
        //   419: aload_3        
        //   420: astore_1       
        //   421: goto            378
        //   424: astore          6
        //   426: aconst_null    
        //   427: astore_3       
        //   428: aload_1        
        //   429: astore_2       
        //   430: aload           6
        //   432: astore_1       
        //   433: goto            189
        //   436: astore          6
        //   438: aconst_null    
        //   439: astore_2       
        //   440: aload_1        
        //   441: astore_3       
        //   442: aload           6
        //   444: astore_1       
        //   445: goto            200
        //   448: astore          6
        //   450: aconst_null    
        //   451: astore_2       
        //   452: aload_1        
        //   453: astore_3       
        //   454: aload           6
        //   456: astore_1       
        //   457: goto            211
        //   460: astore_1       
        //   461: aconst_null    
        //   462: astore          6
        //   464: aconst_null    
        //   465: astore_2       
        //   466: aload           14
        //   468: astore          12
        //   470: goto            511
        //   473: astore_1       
        //   474: aconst_null    
        //   475: astore_2       
        //   476: aconst_null    
        //   477: astore          6
        //   479: aload           7
        //   481: astore          12
        //   483: goto            550
        //   486: astore_1       
        //   487: aconst_null    
        //   488: astore_2       
        //   489: aconst_null    
        //   490: astore          6
        //   492: aload_3        
        //   493: astore          12
        //   495: goto            589
        //   498: new             Lax/b3/j;
        //   501: astore_1       
        //   502: aload_1        
        //   503: ldc_w           "Parent not found"
        //   506: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   509: aload_1        
        //   510: athrow         
        //   511: aload           12
        //   513: ifnull          542
        //   516: aload           6
        //   518: astore_3       
        //   519: aload_2        
        //   520: astore          7
        //   522: aload           12
        //   524: invokevirtual   java/io/File.exists:()Z
        //   527: ifeq            542
        //   530: aload           6
        //   532: astore_3       
        //   533: aload_2        
        //   534: astore          7
        //   536: aload           12
        //   538: invokevirtual   java/io/File.delete:()Z
        //   541: pop            
        //   542: aload           6
        //   544: astore_3       
        //   545: aload_2        
        //   546: astore          7
        //   548: aload_1        
        //   549: athrow         
        //   550: aload           12
        //   552: ifnull          581
        //   555: aload_2        
        //   556: astore_3       
        //   557: aload           6
        //   559: astore          7
        //   561: aload           12
        //   563: invokevirtual   java/io/File.exists:()Z
        //   566: ifeq            581
        //   569: aload_2        
        //   570: astore_3       
        //   571: aload           6
        //   573: astore          7
        //   575: aload           12
        //   577: invokevirtual   java/io/File.delete:()Z
        //   580: pop            
        //   581: aload_2        
        //   582: astore_3       
        //   583: aload           6
        //   585: astore          7
        //   587: aload_1        
        //   588: athrow         
        //   589: aload           12
        //   591: ifnull          620
        //   594: aload_2        
        //   595: astore_3       
        //   596: aload           6
        //   598: astore          7
        //   600: aload           12
        //   602: invokevirtual   java/io/File.exists:()Z
        //   605: ifeq            620
        //   608: aload_2        
        //   609: astore_3       
        //   610: aload           6
        //   612: astore          7
        //   614: aload           12
        //   616: invokevirtual   java/io/File.delete:()Z
        //   619: pop            
        //   620: aload_2        
        //   621: astore_3       
        //   622: aload           6
        //   624: astore          7
        //   626: ldc_w           "archive write file"
        //   629: aload_1        
        //   630: invokestatic    ax/b3/d.a:(Ljava/lang/String;Ljava/lang/Exception;)Lax/b3/j;
        //   633: athrow         
        //   634: aload           7
        //   636: ifnull          651
        //   639: aload           7
        //   641: invokevirtual   java/io/FileOutputStream.close:()V
        //   644: goto            651
        //   647: astore_2       
        //   648: goto            662
        //   651: aload_2        
        //   652: ifnull          666
        //   655: aload_2        
        //   656: invokevirtual   java/io/InputStream.close:()V
        //   659: goto            666
        //   662: aload_2        
        //   663: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   666: aload_1        
        //   667: athrow         
        //   668: new             Lax/b3/j;
        //   671: dup            
        //   672: ldc_w           "zip file is not writeable"
        //   675: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   678: athrow         
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  80     92     486    498    Ljava/io/IOException;
        //  80     92     473    486    Lax/b3/j;
        //  80     92     460    473    Lax/b3/a;
        //  80     92     174    184    Any
        //  97     127    486    498    Ljava/io/IOException;
        //  97     127    473    486    Lax/b3/j;
        //  97     127    460    473    Lax/b3/a;
        //  97     127    174    184    Any
        //  127    158    206    211    Ljava/io/IOException;
        //  127    158    195    200    Lax/b3/j;
        //  127    158    184    189    Lax/b3/a;
        //  127    158    174    184    Any
        //  161    174    206    211    Ljava/io/IOException;
        //  161    174    195    200    Lax/b3/j;
        //  161    174    184    189    Lax/b3/a;
        //  161    174    174    184    Any
        //  217    227    206    211    Ljava/io/IOException;
        //  217    227    195    200    Lax/b3/j;
        //  217    227    184    189    Lax/b3/a;
        //  217    227    174    184    Any
        //  227    232    448    460    Ljava/io/IOException;
        //  227    232    436    448    Lax/b3/j;
        //  227    232    424    436    Lax/b3/a;
        //  227    232    413    424    Any
        //  237    249    403    413    Ljava/io/IOException;
        //  237    249    393    403    Lax/b3/j;
        //  237    249    381    393    Lax/b3/a;
        //  237    249    375    378    Any
        //  254    258    403    413    Ljava/io/IOException;
        //  254    258    393    403    Lax/b3/j;
        //  254    258    381    393    Lax/b3/a;
        //  254    258    375    378    Any
        //  258    265    347    353    Ljava/io/IOException;
        //  258    265    341    347    Lax/b3/j;
        //  258    265    329    341    Lax/b3/a;
        //  258    265    298    306    Any
        //  270    277    347    353    Ljava/io/IOException;
        //  270    277    341    347    Lax/b3/j;
        //  270    277    329    341    Lax/b3/a;
        //  270    277    298    306    Any
        //  284    295    306    329    Ljava/lang/Exception;
        //  284    295    298    306    Any
        //  307    326    347    353    Ljava/io/IOException;
        //  307    326    341    347    Lax/b3/j;
        //  307    326    329    341    Lax/b3/a;
        //  307    326    298    306    Any
        //  353    358    347    353    Ljava/io/IOException;
        //  353    358    341    347    Lax/b3/j;
        //  353    358    329    341    Lax/b3/a;
        //  353    358    298    306    Any
        //  362    366    369    374    Ljava/io/IOException;
        //  498    511    486    498    Ljava/io/IOException;
        //  498    511    473    486    Lax/b3/j;
        //  498    511    460    473    Lax/b3/a;
        //  498    511    174    184    Any
        //  522    530    375    378    Any
        //  536    542    375    378    Any
        //  548    550    375    378    Any
        //  561    569    375    378    Any
        //  575    581    375    378    Any
        //  587    589    375    378    Any
        //  600    608    375    378    Any
        //  614    620    375    378    Any
        //  626    634    375    378    Any
        //  639    644    647    651    Ljava/io/IOException;
        //  655    659    647    651    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 372 out of bounds for length 372
        //     at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
        //     at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
        //     at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
        //     at java.util.Objects.checkIndex(Objects.java:371)
        //     at java.util.ArrayList.get(ArrayList.java:435)
        //     at q5.g.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
        //     at q5.g.b(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:2125)
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
    
    public boolean D0() {
        if (this.s) {
            return false;
        }
        final int r = this.r;
        if (r != 1) {
            if (r != 2 && r != 3) {
                final StringBuilder sb = new StringBuilder();
                sb.append("type:");
                sb.append(this.r);
                sb.append(",uri:");
                sb.append((Object)this.j);
                ax.u3.b.g(sb.toString());
            }
            return false;
        }
        final y i = this.i;
        return i != null && i.j();
    }
    
    public void E(final n n, final n n2, ax.u3.c c, final i i) throws j {
        if (!this.D0()) {
            throw new j("zip file is not writeable");
        }
        ax.u3.b.a(((ax.c3.b)n2).n());
        if (!((ax.c3.b)n).n()) {
            throw new t();
        }
        final long p4 = ((ax.c3.b)n).p();
        final ax.c3.a a = (ax.c3.a)this.z(n.E());
        final File l0 = this.L0((n)a);
        c = (ax.u3.c)n2;
        final File y0 = this.Y0((n)c);
        final ax.c3.a x0 = this.X0(n.E());
        final ax.c3.a x2 = this.X0(n2.E());
        if (x2 == null) {
            throw new j("Target parent does not exist");
        }
        if (x0 == null) {
            throw new j("Source parent does not exist");
        }
        if (((ax.c3.b)n).isDirectory()) {
            ((ax.c3.a)c).n0();
        }
        if (a.n()) {
            Label_0208: {
                ax.c3.a a2;
                try {
                    final boolean h1 = this.h1(l0, y0);
                    x0.m0(a);
                    a2 = new ax.c3.a(this, x2, a.l0(), a.i0(), n2.B());
                    a2.q0();
                    if (h1) {
                        this.i1(a2);
                    }
                }
                catch (final IllegalArgumentException ex) {
                    break Label_0208;
                }
                x2.e0(a2);
                this.q = true;
                if (i != null) {
                    i.a(p4, p4);
                }
                return;
            }
            final b b = c.h().f().b("ARCHIVE FILE NO NAME");
            final StringBuilder sb = new StringBuilder();
            sb.append("dst:");
            sb.append(((ax.c3.a)c).k0());
            final IllegalArgumentException ex;
            b.g((Object)sb.toString()).l((Throwable)ex).h();
            throw ex;
        }
        ax.u3.b.g("no zip entry source");
        throw new t("Source file entry is null");
    }
    
    public void F(final n n, final n n2, final ax.u3.c c, final i i) throws j, ax.b3.a {
        this.D(n2, this.s(n), ((ax.c3.b)n).s(), ((ax.c3.b)n).p(), ((ax.c3.b)n).q(), n.D(), false, c, i);
    }
    
    public int G(final String s, final String s2) {
        return -1;
    }
    
    public String H(final n n) {
        final z g = n.G();
        if (ax.c3.z.f0 != g && ax.c3.z.e0 != g) {
            return null;
        }
        return B.Y(n);
    }
    
    public void I(final n n) throws j {
        if (!this.D0()) {
            throw new j("zip file is not writeable");
        }
        if (!d0.E(n)) {
            final String[] split = ((ax.c3.b)n).t().split(File.separator);
            if (split != null) {
                ax.c3.a p = this.p;
                final int length = split.length;
                ax.c3.a a = p;
                for (final String s : split) {
                    if (s.length() != 0) {
                        if (p == null) {
                            throw new t("Can not found fileinfo");
                        }
                        final ax.c3.a h0 = p.h0(s);
                        a = p;
                        p = h0;
                    }
                }
                if (p != null) {
                    a.m0(p);
                    this.J0(p);
                    this.q = true;
                    return;
                }
            }
            throw new t("Could not delete...");
        }
        throw new j("Could not delete root");
    }
    
    public InputStream J(final n n, final long n2) throws j {
        I i = null;
        try {
            final I l0 = ((ax.c3.a)n).l0();
            if (l0 == null) {
                goto Label_0161;
            }
            i = l0;
            final File l2 = this.L0(n);
            i = l0;
            if (!l2.exists()) {
                goto Label_0083;
            }
            i = l0;
            i = l0;
            final FileInputStream fileInputStream = new FileInputStream(l2);
            if (n2 != 0L) {
                i = l0;
                q1((InputStream)fileInputStream, n2);
                return (InputStream)fileInputStream;
            }
            goto Label_0080;
        }
        catch (final IOException ex) {}
        catch (final ArrayIndexOutOfBoundsException ex2) {
            final b d = ax.Ha.c.h().d("AFGIS");
            final StringBuilder sb = new StringBuilder();
            sb.append(i.getSize());
            sb.append(":");
            sb.append(i.getName());
            d.g((Object)sb.toString()).h();
            throw new j("Zip entry read error");
        }
        final IOException ex;
        throw ax.b3.d.a("archive getinputstream", (Exception)ex);
    }
    
    public void K(final Activity activity, final Fragment fragment, final c$a c$a) {
        monitorenter(this);
        Label_0044: {
            try {
                if (this.k == 0 && this.i == null) {
                    ax.Ha.c.h().f().b("ArchiveFileHelper invalid auth").j().h();
                }
                break Label_0044;
            }
            finally {
                Label_0067: {
                    break Label_0067;
                    try {
                        new b(c$a).i((Object[])new String[0]);
                        monitorexit(this);
                        return;
                        monitorexit(this);
                    }
                    catch (final Exception ex) {}
                }
            }
        }
    }
    
    public q K0() {
        this.o = false;
        return new c(this.p(), this.v(), this.l, this.m, this.i, (S)this.n, this.u, this.v, this.r).i((Object[])new Long[0]);
    }
    
    public boolean L() {
        return false;
    }
    
    public File L0(final n n) {
        return this.S0(n, false);
    }
    
    public boolean M(final n n) {
        if (!this.D0()) {
            return false;
        }
        final ax.c3.a x0 = this.X0(n.E());
        final String b = n.B();
        if (x0 != null) {
            if (x0.n()) {
                if (x0.h0(b) == null) {
                    final ax.c3.a a = new ax.c3.a(this, this.H0(g1(n.E(), true)), x0);
                    final File y0 = this.Y0((n)a);
                    if (y0.exists() && !y0.isDirectory() && !y0.delete()) {
                        return false;
                    }
                    if (!y0.exists() && !y0.mkdirs()) {
                        return false;
                    }
                    a.o0(y0);
                    x0.e0(a);
                    return this.q = true;
                }
            }
        }
        return false;
    }
    
    public boolean N(final n n) {
        if (!this.D0()) {
            return false;
        }
        final ax.c3.a x0 = this.X0(n.E());
        final String b = n.B();
        if (x0 != null) {
            if (x0.n()) {
                if (x0.h0(b) == null) {
                    Label_0145: {
                        ax.c3.a a;
                        File y0;
                        try {
                            a = new ax.c3.a(this, this.H0(g1(n.E(), false)), x0);
                            y0 = this.Y0((n)a);
                            if (y0.exists()) {
                                if (!y0.delete()) {
                                    throw new IOException("Could not delete stale edit copy");
                                }
                            }
                        }
                        catch (final IOException ex) {
                            break Label_0145;
                        }
                        new FileOutputStream(y0, false).close();
                        a.o0(y0);
                        x0.e0(a);
                        return this.q = true;
                    }
                    final IOException ex;
                    ((Throwable)ex).printStackTrace();
                }
            }
        }
        return false;
    }
    
    public int N0() {
        return this.r;
    }
    
    public boolean O() {
        return true;
    }
    
    public Uri O0() {
        return this.j;
    }
    
    public void P(final n n) throws j {
        this.I(n);
    }
    
    public boolean Q(final n n, final n n2) {
        return true;
    }
    
    public int T0() {
        return this.k;
    }
    
    public y V0() {
        return this.i;
    }
    
    public String W0() {
        return this.h;
    }
    
    public File Y0(final n n) {
        return this.S0(n, true);
    }
    
    public boolean a() {
        return this.n != null && this.o;
    }
    
    public boolean a0(final n n) {
        return this.D0();
    }
    
    public void b() {
        synchronized (this) {
            ax.c3.x.h(this.u(), this.t());
            this.K0();
        }
    }
    
    public boolean b1() {
        return this.q;
    }
    
    public boolean c1() {
        return this.s;
    }
    
    public boolean e1() {
        return this.r != 0 && this.j != null;
    }
    
    public boolean f1() {
        return TextUtils.isEmpty((CharSequence)this.t) ^ true;
    }
    
    public void l1(final Uri j, final y i, final int r) {
        this.j = j;
        this.r = r;
        this.i = i;
        this.h = ((n)i).B();
    }
    
    void m(final n n, final String s, final boolean b, final boolean b2, final ax.g3.h h, final ax.u3.c c) {
    }
    
    public void m1(final Uri j, final String h, final int k, final int r) {
        this.j = j;
        this.r = r;
        this.h = h;
        this.k = k;
        try {
            this.l = ParcelFileDescriptor.fromFd(k);
        }
        catch (final IOException ex) {}
    }
    
    public void n1(final String t) {
        this.t = t;
    }
    
    public void r1(final String s, final ax.b0.a<e> a) {
        new f(s, a).i((Object[])new String[0]);
    }
    
    public boolean s1(i i) throws j {
        if (!this.q) {
            return true;
        }
        int n = this.r;
        if (n == 3 || n == 2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("not reachable : ");
            sb.append(this.r);
            sb.append(",");
            sb.append(this.b1());
            ax.u3.b.g(sb.toString());
            return false;
        }
        if (this.i == null) {
            ax.u3.b.g("not reachable");
            return false;
        }
        if (!this.D0()) {
            throw new j("zip file is not writeable");
        }
        final AutoCloseable autoCloseable = null;
        File file = null;
        File file3 = null;
        Exception ex2 = null;
        Label_0472: {
            try {
                final String e = ((n)this.i).E();
                final String r = d0.r(e);
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(d0.h(e));
                sb2.append(".tmp.zip");
                final File file2 = new File(r, sb2.toString());
                try {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(d0.h(e));
                    sb3.append(".tmp.zip");
                    sb3.append(".bak");
                    file = new File(r, sb3.toString());
                    final o f = ax.c3.x.f(file2);
                    final com.alphainventor.filemanager.file.x x = (com.alphainventor.filemanager.file.x)f.u();
                    final n z = f.z(e);
                    final n z2 = f.z(file2.getAbsolutePath());
                    Object o = x.c(file2.getAbsolutePath(), false);
                    final J j = new J((OutputStream)o);
                    J k = null;
                    Label_0381: {
                        try {
                            j.F0(Charset.defaultCharset().name());
                            o = this.p.i0();
                            if (o == null) {
                                break Label_0381;
                            }
                            n = this.G0(this.p);
                            if (i != null) {
                                i.a(0L, (long)n);
                            }
                        }
                        catch (final IOException autoCloseable) {}
                        finally {
                            i = (i)j;
                            k = (J)autoCloseable;
                        }
                        final Iterator iterator = ((List)o).iterator();
                        while (iterator.hasNext()) {
                            this.t1((ax.c3.a)iterator.next(), k, new Integer[] { 0, n }, i);
                        }
                    }
                    k.o();
                    k.close();
                    final boolean j2 = this.j1(f, z, z2, file);
                    ax.c3.F.a((AutoCloseable)null);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    return j2;
                }
                catch (final IOException ex) {}
            }
            catch (final IOException ex2) {
                i = null;
            }
            finally {
                file3 = null;
                ex2 = (Exception)autoCloseable;
                break Label_0472;
            }
            try {
                throw ax.b3.d.a("update archive error", ex2);
            }
            finally {
                goto Label_0296;
            }
        }
        ax.c3.F.a((AutoCloseable)ex2);
        if (file3 != null && file3.exists()) {
            file3.delete();
        }
    }
    
    public n z(final String s) throws j {
        if (this.p != null) {
            final String[] split = s.split(File.separator);
            ax.c3.a p = this.p;
            ax.c3.a h0;
            for (int i = 0; i < split.length; ++i, p = h0) {
                final String s2 = split[i];
                h0 = p;
                if (s2 != null) {
                    if ("".equals((Object)s2)) {
                        h0 = p;
                    }
                    else {
                        if (p == null) {
                            ax.Ha.c.h().d("ARFI").j().h();
                        }
                        if ((h0 = p.h0(split[i])) == null) {
                            return (n)new ax.c3.a(this, s);
                        }
                    }
                }
            }
            return (n)p;
        }
        throw new j("no root");
    }
    
    class a extends H
    {
        final b c0;
        
        a(final b c0, final InputStream inputStream) {
            this.c0 = c0;
            super(inputStream);
        }
        
        public void close() throws IOException {
            final Object l0 = this.c0.w;
            synchronized (l0) {
                super.close();
            }
        }
        
        public int read() throws IOException {
            final Object l0 = this.c0.w;
            synchronized (l0) {
                return super.read();
            }
        }
        
        public int read(final byte[] array) throws IOException {
            final Object l0 = this.c0.w;
            synchronized (l0) {
                return super.read(array);
            }
        }
        
        public int read(final byte[] array, int read, final int n) throws IOException {
            final Object l0 = this.c0.w;
            synchronized (l0) {
                read = super.read(array, read, n);
                return read;
            }
        }
        
        public void reset() throws IOException {
            synchronized (this) {
                final Object l0 = this.c0.w;
                synchronized (l0) {
                    super.reset();
                }
            }
        }
        
        public long skip(final long n) throws IOException {
            if (n <= 0L) {
                return 0L;
            }
            final int n2 = (int)Math.min((long)2048, n);
            final byte[] array = new byte[n2];
            long n3;
            long n4;
            for (n3 = n; n3 > 0L; n3 -= n4) {
                final int read = this.read(array, 0, (int)Math.min((long)n2, n3));
                if (read < 0) {
                    break;
                }
                if (read == 0) {
                    if (this.read() < 0) {
                        break;
                    }
                    n4 = 1L;
                }
                else {
                    n4 = read;
                }
            }
            return n - n3;
        }
    }
    
    private class b extends q<String, Void, Boolean>
    {
        c$a h;
        IOException i;
        final com.alphainventor.filemanager.file.b j;
        
        b(final com.alphainventor.filemanager.file.b j, final c$a h) {
            this.j = j;
            super(q$e.c0);
            this.h = h;
        }
        
        private void A(final ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            final Charset x = this.x(parcelFileDescriptor);
            try {
                B.d0(parcelFileDescriptor, 0L);
                final FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
                this.j.m = (Closeable)fileInputStream;
                this.j.n = T.u0((SeekableByteChannel)ax.T.l.a(fileInputStream), x.name());
            }
            catch (final ErrnoException ex) {
                throw new IOException("reset parcel file descriptor position error", (Throwable)ex);
            }
        }
        
        private void w() {
            this.j.o = false;
            ax.c3.F.a((AutoCloseable)this.j.n);
            this.j.n = null;
            ax.c3.F.a((AutoCloseable)this.j.m);
            this.j.m = null;
            ax.c3.F.a((AutoCloseable)this.j.l);
            this.j.l = null;
        }
        
        private Charset x(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            Object dup = null;
            try {
                parcelFileDescriptor = (ParcelFileDescriptor)(dup = ParcelFileDescriptor.dup(parcelFileDescriptor.getFileDescriptor()));
                return ax.Dc.e.b(parcelFileDescriptor.getFileDescriptor());
            }
            finally {
                ax.c3.F.a((AutoCloseable)dup);
            }
        }
        
        protected void r() {
            final c$a h = this.h;
            if (h != null) {
                h.B();
            }
        }
        
        protected Boolean y(final String... array) {
            Label_0281: {
                Label_0171: {
                    Label_0062: {
                        try {
                            if (this.j.k == 0) {
                                break Label_0062;
                            }
                            if (this.j.l != null) {
                                this.A(this.j.l);
                                break Label_0171;
                            }
                        }
                        catch (final IOException i) {
                            break Label_0281;
                        }
                        catch (final RuntimeException ex) {
                            break Label_0281;
                        }
                        catch (final IllegalArgumentException ex2) {
                            break Label_0281;
                        }
                        catch (final ArrayIndexOutOfBoundsException ex3) {
                            break Label_0281;
                        }
                        throw new IOException("parcel file descriptor not created from fd");
                    }
                    if (this.j.i == null) {
                        break Label_0281;
                    }
                    if (this.j.i.k0()) {
                        try {
                            final com.alphainventor.filemanager.file.b j = this.j;
                            j.l = j.i.e0(true);
                            this.A(this.j.l);
                            break Label_0171;
                        }
                        catch (final j k) {
                            throw new IOException("get parcel file descriptor error", (Throwable)k);
                        }
                    }
                    final Charset a = ax.Dc.e.a(this.j.i.F0());
                    final com.alphainventor.filemanager.file.b l = this.j;
                    l.n = T.s0(l.i.F0(), a.name());
                }
                final com.alphainventor.filemanager.file.b m = this.j;
                m.u = m.R0();
                while (true) {
                    try {
                        final com.alphainventor.filemanager.file.b j2 = this.j;
                        j2.s = com.alphainventor.filemanager.file.b.d1((S)j2.n, null);
                        final com.alphainventor.filemanager.file.b j3 = this.j;
                        j3.F0((S)j3.n);
                        final com.alphainventor.filemanager.file.b j4 = this.j;
                        j4.v = U0(j4.p(), this.j.u(), this.j.t());
                        if (this.j.v != null) {
                            this.j.v.mkdirs();
                        }
                        this.j.o = true;
                        return Boolean.TRUE;
                        final RuntimeException ex;
                        this.i = new IOException((Throwable)ex);
                        while (true) {
                            this.w();
                            return Boolean.FALSE;
                            final IllegalArgumentException ex2;
                            this.i = new IOException((Throwable)ex2);
                            continue;
                            return Boolean.FALSE;
                            final IOException i;
                            this.i = i;
                            continue;
                            final ArrayIndexOutOfBoundsException ex3;
                            this.i = new IOException((Throwable)ex3);
                            continue;
                        }
                    }
                    catch (final ax.b3.a a2) {
                        continue;
                    }
                    break;
                }
            }
        }
        
        protected void z(final Boolean b) {
            final c$a h = this.h;
            if (h != null) {
                h.T((boolean)b, (Object)this.i);
            }
        }
    }
    
    static class c extends q<Long, Integer, Boolean>
    {
        Context h;
        K i;
        S j;
        y k;
        File l;
        File m;
        int n;
        Closeable o;
        ParcelFileDescriptor p;
        
        public c(final Context h, final K i, final ParcelFileDescriptor p9, final Closeable o, final y k, final S j, final File l, final File m, final int n) {
            super(q$e.f0);
            this.h = h;
            this.i = i;
            this.p = p9;
            this.o = o;
            this.k = k;
            this.j = j;
            this.l = l;
            this.m = m;
            this.n = n;
        }
        
        protected Boolean w(final Long... array) {
            ax.r3.d.i(this.h, this.i);
            E0(this.m);
            try {
                final S j = this.j;
                if (j != null) {
                    j.close();
                }
            }
            catch (final IOException ex) {
                ((Throwable)ex).printStackTrace();
            }
            b.I0(this.l);
            final Closeable o = this.o;
            if (o != null) {
                try {
                    o.close();
                }
                catch (final IOException ex2) {}
            }
            final ParcelFileDescriptor p = this.p;
            if (p != null) {
                try {
                    p.close();
                }
                catch (final IOException ex3) {}
            }
            final y k = this.k;
            Label_0131: {
                if (k == null || this.n != 2) {
                    break Label_0131;
                }
                final o f = ax.c3.x.f(k.F0());
                try {
                    f.P((n)this.k);
                    f.P(f.z(((n)this.k).T()));
                    return Boolean.TRUE;
                }
                catch (final j i) {
                    return Boolean.TRUE;
                }
            }
        }
    }
    
    private static class d extends I
    {
        public d(final String s) {
            super(s);
        }
    }
    
    public enum e
    {
        c0, 
        d0;
        
        private static final e[] e0;
        
        q;
        
        static {
            e0 = d();
        }
        
        private static /* synthetic */ e[] d() {
            return new e[] { e.q, e.c0, e.d0 };
        }
    }
    
    private class f extends q<String, Void, e>
    {
        private String h;
        private ax.b0.a<e> i;
        final b j;
        
        f(final b j, final String h, final ax.b0.a<e> i) {
            this.j = j;
            super(q$e.d0);
            this.h = h;
            this.i = i;
        }
        
        protected e w(final String... array) {
            final Enumeration f = ((S)this.j.n).f();
            while (f.hasMoreElements()) {
                final I i = (I)f.nextElement();
                if (i.o().l()) {
                    Object q0 = null;
                    while (true) {
                        try {
                            try {
                                final InputStream inputStream = (InputStream)(q0 = b.Q0(this.j.n, i, this.h));
                                final e q2 = e.q;
                                ax.c3.F.a((AutoCloseable)inputStream);
                                return q2;
                            }
                            finally {}
                        }
                        catch (final ax.oc.a a) {
                            q0 = array;
                            if (a.a() == a$a.q) {
                                final e c0 = e.c0;
                                ax.c3.F.a((AutoCloseable)(Object)array);
                                return c0;
                            }
                            ax.c3.F.a((AutoCloseable)q0);
                        }
                        catch (final IOException | j ioException | j) {
                            continue;
                        }
                        break;
                    }
                }
            }
            goto Label_0140;
        }
        
        protected void x(final e e) {
            this.i.accept((Object)e);
        }
    }
}
