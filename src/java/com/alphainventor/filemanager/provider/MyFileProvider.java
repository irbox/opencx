package com.alphainventor.filemanager.provider;

import ax.c3.v;
import ax.c3.d0;
import ax.u3.q$e;
import ax.u3.q;
import java.util.concurrent.CountDownLatch;
import android.database.Cursor;
import ax.b3.t;
import ax.b3.r;
import ax.X2.Q;
import android.content.res.AssetFileDescriptor;
import android.content.ContentValues;
import ax.Ha.c;
import android.content.pm.ProviderInfo;
import android.content.Context;
import android.net.Uri$Builder;
import com.alphainventor.filemanager.file.i;
import com.alphainventor.filemanager.file.y;
import ax.c3.B;
import android.text.TextUtils;
import com.alphainventor.filemanager.file.g;
import com.alphainventor.filemanager.file.c$a;
import ax.b3.h;
import ax.Q2.f;
import com.alphainventor.filemanager.file.o;
import ax.c3.K;
import ax.b3.j;
import ax.c3.x;
import android.database.MatrixCursor;
import ax.Z2.k;
import java.io.FileNotFoundException;
import java.io.IOException;
import ax.o3.b$d;
import android.os.ParcelFileDescriptor$OnCloseListener;
import ax.o3.b;
import android.os.ParcelFileDescriptor;
import java.io.File;
import android.os.Looper;
import com.alphainventor.filemanager.file.n;
import android.net.Uri;
import java.util.HashMap;
import android.os.Handler;
import java.util.logging.Logger;
import android.content.ContentProvider;

public class MyFileProvider extends ContentProvider
{
    private static final Logger d;
    private static final String[] e;
    private static final String[] f;
    private static boolean g;
    private static MyFileProvider h;
    private Handler a;
    private a b;
    private final HashMap<Uri, n> c;
    
    static {
        d = Logger.getLogger("FileManager.MyFileProvider");
        e = new String[] { "_display_name", "_size", "_data" };
        f = new String[] { "_display_name", "_size" };
    }
    
    public MyFileProvider() {
        this.a = new Handler(Looper.getMainLooper());
        this.c = (HashMap<Uri, n>)new HashMap();
    }
    
    public static boolean A(final Uri uri) {
        return "com.cxinventor.file.explorer.fileprovider".equals((Object)uri.getAuthority()) && c.b(uri).i();
    }
    
    public static boolean B(final Uri uri) {
        return "com.cxinventor.file.explorer.fileprovider".equals((Object)uri.getAuthority()) && c.b(uri).k();
    }
    
    public static boolean C(final Uri uri) {
        return D(uri) && "1".equals((Object)uri.getQueryParameter("motion_photo"));
    }
    
    public static boolean D(final Uri uri) {
        return uri != null && "com.cxinventor.file.explorer.fileprovider".equals((Object)uri.getAuthority());
    }
    
    public static boolean E(final Uri uri) {
        return "com.cxinventor.file.explorer.fileprovider".equals((Object)uri.getAuthority()) && c.b(uri).l();
    }
    
    private static int F(final String s) {
        if ("r".equals((Object)s)) {
            return 268435456;
        }
        if ("w".equals((Object)s) || "wt".equals((Object)s)) {
            return 738197504;
        }
        if ("wa".equals((Object)s)) {
            return 704643072;
        }
        if ("rw".equals((Object)s)) {
            return 939524096;
        }
        if ("rwt".equals((Object)s)) {
            return 1006632960;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid mode: ");
        sb.append(s);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private ParcelFileDescriptor G(final File file, final String s) throws FileNotFoundException {
        final int f = F(s);
        try {
            final b$d k = ax.o3.b.j().k();
            k.b(file);
            return ParcelFileDescriptor.open(file, f, this.a, (ParcelFileDescriptor$OnCloseListener)new ParcelFileDescriptor$OnCloseListener(this, k, file) {
                final b$d a;
                final File b;
                final MyFileProvider c;
                
                public void onClose(final IOException ex) {
                    this.a.a(this.b, ex);
                }
            });
        }
        catch (final IOException ex) {
            throw new FileNotFoundException(((Throwable)ex).getMessage());
        }
    }
    
    private ParcelFileDescriptor H(final c c, final String s) throws FileNotFoundException {
        final int f = F(s);
        final k d = c.d();
        if (d != null) {
            try {
                return this.q().b(d, f);
            }
            catch (final IOException ex) {
                ((Throwable)ex).printStackTrace();
                throw new FileNotFoundException(((Throwable)ex).getMessage());
            }
        }
        ax.u3.b.g("location uri is not valid");
        throw new FileNotFoundException("location uri is not valid");
    }
    
    private MatrixCursor b(final String[] array) {
        String[] f = array;
        if (array == null) {
            f = MyFileProvider.f;
        }
        return new MatrixCursor(f, 0);
    }
    
    private MatrixCursor c(final String[] array, final n n) {
        String[] f = array;
        if (array == null) {
            f = MyFileProvider.f;
        }
        final String[] array2 = new String[f.length];
        final Object[] array3 = new Object[f.length];
        final int length = f.length;
        int i = 0;
        int n2 = 0;
        while (i < length) {
            final String s = f[i];
            int n7 = 0;
            Label_0197: {
                int n4;
                if ("_display_name".equals((Object)s)) {
                    array2[n2] = "_display_name";
                    final int n3 = n2 + 1;
                    array3[n2] = n.B();
                    n4 = n3;
                }
                else if ("_size".equals((Object)s)) {
                    array2[n2] = "_size";
                    final int n5 = n2 + 1;
                    array3[n2] = ((ax.c3.b)n).p();
                    n4 = n5;
                }
                else if ("mime_type".equals((Object)s)) {
                    array2[n2] = "mime_type";
                    final int n6 = n2 + 1;
                    array3[n2] = ((ax.c3.b)n).s();
                    n4 = n6;
                }
                else {
                    n7 = n2;
                    if (!"_data".equals((Object)s)) {
                        break Label_0197;
                    }
                    array2[n2] = "_data";
                    final int n8 = n2 + 1;
                    array3[n2] = null;
                    n4 = n8;
                }
                n7 = n4;
            }
            ++i;
            n2 = n7;
        }
        final String[] g = g(array2, n2);
        final Object[] f2 = f(array3, n2);
        final MatrixCursor matrixCursor = new MatrixCursor(g, 1);
        matrixCursor.addRow(f2);
        return matrixCursor;
    }
    
    private MatrixCursor d(final Uri uri, final String[] array) {
        String[] f = array;
        if (array == null) {
            f = MyFileProvider.f;
        }
        final String[] array2 = new String[f.length];
        final Object[] array3 = new Object[f.length];
        final c b = MyFileProvider.c.b(uri);
        final long o = o(uri, "length");
        final int length = f.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final String s = f[i];
            int n6 = 0;
            Label_0245: {
                int n3;
                if ("_display_name".equals((Object)s)) {
                    array2[n] = "_display_name";
                    final int n2 = n + 1;
                    final StringBuilder sb = new StringBuilder();
                    sb.append(new File(b.d).getName());
                    sb.append(".mp4");
                    array3[n] = sb.toString();
                    n3 = n2;
                }
                else if ("_size".equals((Object)s)) {
                    array2[n] = "_size";
                    final int n4 = n + 1;
                    array3[n] = o;
                    n3 = n4;
                }
                else if ("mime_type".equals((Object)s)) {
                    array2[n] = "mime_type";
                    final int n5 = n + 1;
                    array3[n] = n(uri);
                    n3 = n5;
                }
                else {
                    n6 = n;
                    if (!"_data".equals((Object)s)) {
                        break Label_0245;
                    }
                    array2[n] = "_data";
                    final int n7 = n + 1;
                    array3[n] = null;
                    n3 = n7;
                }
                n6 = n3;
            }
            ++i;
            n = n6;
        }
        final MatrixCursor matrixCursor = new MatrixCursor(g(array2, n), 1);
        matrixCursor.addRow(f(array3, n));
        return matrixCursor;
    }
    
    public static k e(final Uri uri) {
        if (!"com.cxinventor.file.explorer.fileprovider".equals((Object)uri.getAuthority())) {
            return null;
        }
        return c.b(uri).d();
    }
    
    private static Object[] f(final Object[] array, final int n) {
        final Object[] array2 = new Object[n];
        System.arraycopy((Object)array, 0, (Object)array2, 0, n);
        return array2;
    }
    
    private static String[] g(final String[] array, final int n) {
        final String[] array2 = new String[n];
        System.arraycopy((Object)array, 0, (Object)array2, 0, n);
        return array2;
    }
    
    private void h(final c c) throws j {
        final K e = c.e();
        if (e != null) {
            final o e2 = x.e(e);
            if (e2.a()) {
                try {
                    e2.n0();
                    e2.P(e2.z(c.d));
                    return;
                }
                finally {
                    e2.k0(true);
                }
            }
            throw new j("Not connected");
        }
        throw new j("Bad Uri");
    }
    
    public static Uri i(final Uri uri) {
        final c b = c.b(uri);
        ax.u3.b.c(b.k());
        return u("external_files", b.d);
    }
    
    private ParcelFileDescriptor j(final c c, final String s) throws j, FileNotFoundException {
        final K e = c.e();
        if (e != null) {
            final o e2 = x.e(e);
            if (!e2.a()) {
                if (!ax.Q2.f.e0(e2.S()) && !ax.Q2.f.o0(e2.S())) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("not document location?");
                    sb.append(e2.S().I());
                    ax.u3.b.g(sb.toString());
                    throw new h("Not connected");
                }
                e2.h(null);
                if (!e2.a()) {
                    throw new h("Not connected");
                }
            }
            try {
                e2.n0();
                return com.alphainventor.filemanager.file.g.o(this.getContext(), com.alphainventor.filemanager.file.g.l(e2.z(c.d)), s);
            }
            finally {
                e2.k0(false);
            }
        }
        throw new j("Bad Uri");
    }
    
    private static n k(final c c) throws j {
        if (!c.j() && !c.i()) {
            final StringBuilder sb = new StringBuilder();
            sb.append(c.c);
            sb.append(":");
            sb.append(c.d);
            ax.u3.b.g(sb.toString());
        }
        final K e = c.e();
        if (e != null) {
            final o e2 = x.e(e);
            if (e2.a()) {
                try {
                    e2.n0();
                    return e2.z(c.d);
                }
                finally {
                    e2.k0(false);
                }
            }
            throw new j("Not connected");
        }
        throw new j("Bad Uri");
    }
    
    public static MyFileProvider l() {
        return MyFileProvider.h;
    }
    
    public static File m(final Uri uri) {
        return c.b(uri).c();
    }
    
    private static String n(final Uri uri) {
        final String queryParameter = uri.getQueryParameter("mimetype");
        if (!TextUtils.isEmpty((CharSequence)queryParameter)) {
            return queryParameter;
        }
        return "video/mp4";
    }
    
    private static long o(final Uri uri, final String s) {
        final String queryParameter = uri.getQueryParameter(s);
        if (queryParameter == null) {
            return -1L;
        }
        try {
            return Long.parseLong(queryParameter);
        }
        catch (final NumberFormatException ex) {
            return -1L;
        }
    }
    
    public static Uri p(final n n, final long n2, final long n3, final String s) {
        if (B.H(n) && n2 >= 0L && n3 > 0L) {
            Uri uri;
            if (n instanceof y) {
                uri = t((y)n);
            }
            else {
                uri = c.g(n);
            }
            return uri.buildUpon().appendQueryParameter("motion_photo", "1").appendQueryParameter("offset", Long.toString(n2)).appendQueryParameter("length", Long.toString(n3)).appendQueryParameter("mimetype", s).build();
        }
        throw new IllegalArgumentException("Invalid Motion Photo video range");
    }
    
    private a q() {
        this.z();
        return this.b;
    }
    
    public static Uri r(final i i) {
        return c.g((n)i);
    }
    
    public static Uri s(final File file) {
        return u("root", file.getAbsolutePath());
    }
    
    public static Uri t(final y y) {
        return s(y.F0());
    }
    
    private static Uri u(String string, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(Uri.encode(string));
        sb.append(Uri.encode(s, "/"));
        string = sb.toString();
        return new Uri$Builder().scheme("content").authority("com.cxinventor.file.explorer.fileprovider").encodedPath(string).build();
    }
    
    public static Uri v(final y y) {
        return c.h(y);
    }
    
    public static Uri w(final y y) {
        return s(y.F0());
    }
    
    public static Uri x(final n n) {
        final Uri g = c.g(n);
        final MyFileProvider h = MyFileProvider.h;
        if (h != null) {
            h.a(g, n);
        }
        return g;
    }
    
    public static void y(final Context context) {
        if (context == null || MyFileProvider.g) {
            return;
        }
        try {
            context.grantUriPermission("com.android.systemui", Uri.parse("content://com.cxinventor.file.explorer.fileprovider/"), 129);
            MyFileProvider.g = true;
        }
        catch (final Exception ex) {}
    }
    
    void a(final Uri uri, final n n) {
        this.c.put((Object)uri, (Object)n);
    }
    
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (providerInfo.grantUriPermissions) {
            return;
        }
        throw new SecurityException("Provider must grant uri permissions");
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        final c b = MyFileProvider.c.b(uri);
        if (b.k()) {
            return b.c().delete() ? 1 : 0;
        }
        if (b.l()) {
            ax.Ha.c.i(this.getContext()).f().b("PROXY FILE DELETE REQUESTED").h();
            return 0;
        }
        try {
            this.h(b);
            return 1;
        }
        catch (final j j) {
            return 0;
        }
    }
    
    public String getType(final Uri uri) {
        if (C(uri)) {
            return n(uri);
        }
        return MyFileProvider.c.b(uri).f();
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }
    
    public boolean onCreate() {
        ax.Q2.b.k(this.getContext());
        MyFileProvider.h = this;
        return true;
    }
    
    public AssetFileDescriptor openAssetFile(final Uri uri, final String s) throws FileNotFoundException {
        if (!C(uri)) {
            return super.openAssetFile(uri, s);
        }
        Label_0161: {
            if (!"r".equals((Object)s)) {
                break Label_0161;
            }
            final long o = o(uri, "offset");
            final long o2 = o(uri, "length");
            Label_0150: {
                if (o < 0L || o2 <= 0L || o > Long.MAX_VALUE - o2) {
                    break Label_0150;
                }
                final ParcelFileDescriptor openFile = this.openFile(uri.buildUpon().clearQuery().build(), "r");
                Label_0139: {
                    if (openFile == null) {
                        break Label_0139;
                    }
                    final long statSize = openFile.getStatSize();
                    Label_0126: {
                        if (statSize < 0L || o + o2 <= statSize) {
                            break Label_0126;
                        }
                        try {
                            openFile.close();
                            throw new FileNotFoundException("Motion Photo video range exceeds file size");
                            throw new FileNotFoundException("Unable to open Motion Photo");
                            return new AssetFileDescriptor(openFile, o, o2);
                            throw new FileNotFoundException("Motion Photo is read-only");
                            throw new FileNotFoundException("Invalid Motion Photo video range");
                        }
                        catch (final IOException ex) {
                            throw new FileNotFoundException("Motion Photo video range exceeds file size");
                        }
                    }
                }
            }
        }
    }
    
    public ParcelFileDescriptor openFile(Uri j, final String s) throws FileNotFoundException {
        ax.Q2.b.f(this.getContext(), false);
        if (!C((Uri)j)) {
            this.getContext();
            j = (j)MyFileProvider.c.b((Uri)j);
            if (!Q.V1()) {
                return this.G(((c)j).c(), s);
            }
            if (((c)j).k()) {
                j = (j)((c)j).c();
                final o f = x.f((File)j);
                Label_0096: {
                    y y;
                    try {
                        y = (y)f.z(((File)j).getAbsolutePath());
                        if (y == null) {
                            break Label_0096;
                        }
                        final y y2 = y;
                        final boolean b = y2.d1();
                        if (b) {
                            final com.alphainventor.filemanager.shizuku.c c = com.alphainventor.filemanager.shizuku.c.t();
                            final y y3 = y;
                            final String s2 = ((n)y3).E();
                            return c.w(s2);
                        }
                        break Label_0096;
                    }
                    catch (final j j) {
                        break Label_0096;
                    }
                    catch (final SecurityException ex) {
                        throw new FileNotFoundException();
                    }
                    try {
                        final y y2 = y;
                        final boolean b = y2.d1();
                        if (b) {
                            final com.alphainventor.filemanager.shizuku.c c = com.alphainventor.filemanager.shizuku.c.t();
                            final y y3 = y;
                            final String s2 = ((n)y3).E();
                            return c.w(s2);
                        }
                        if (y == null || !y.i0() || this.getContext() == null) {
                            return this.G((File)j, s);
                        }
                        final ParcelFileDescriptor openFileDescriptor = this.getContext().getContentResolver().openFileDescriptor(com.alphainventor.filemanager.file.g.l((n)y), s);
                        if (openFileDescriptor != null) {
                            return openFileDescriptor.dup();
                        }
                        return null;
                    }
                    catch (final r | IOException ex2) {}
                }
                ((Throwable)j).printStackTrace();
                throw new FileNotFoundException();
            }
            if (((c)j).l()) {
                if (Q.t1()) {
                    return this.H((c)j, s);
                }
                ax.u3.b.g("API VERSION NOT SUPPORTED");
                throw new FileNotFoundException("API VERSION NOT SUPPORTED");
            }
            else {
                try {
                    final ParcelFileDescriptor i = this.j((c)j, s);
                    if (i != null) {
                        return i.dup();
                    }
                    return null;
                }
                catch (final IOException ex3) {
                    throw new FileNotFoundException(((Throwable)ex3).getMessage());
                }
                catch (final j k) {
                    if (!(k instanceof t)) {
                        if (!(k instanceof h)) {
                            if (k instanceof r) {
                                final ax.Ha.b l = ax.Ha.c.h().f().b("MyFileProvider error 1").l((Throwable)k);
                                final StringBuilder sb = new StringBuilder();
                                sb.append("uri:");
                                sb.append(((c)j).d);
                                l.g((Object)sb.toString()).h();
                            }
                            else {
                                ax.Ha.c.h().f().b("MyFileProvider error 2").l((Throwable)k).h();
                            }
                        }
                    }
                    if (((c)j).j()) {
                        return this.G(((c)j).c(), s);
                    }
                    throw new FileNotFoundException(((Throwable)k).getMessage());
                }
            }
        }
        throw new FileNotFoundException("Motion Photo must be opened as an asset file");
    }
    
    public Cursor query(final Uri uri, final String[] array, String b, String[] c, String s) {
        final Context context = this.getContext();
        int i = 0;
        ax.Q2.b.f(context, false);
        if (C(uri)) {
            return (Cursor)this.d(uri, array);
        }
        b = (String)MyFileProvider.c.b(uri);
        if (((c)b).k()) {
            c = (String[])(Object)((c)b).c();
            final o f = x.f((File)(Object)c);
            boolean b2;
            try {
                b2 = (((y)f.z(((File)(Object)c).getAbsolutePath())).a1() ^ true);
            }
            catch (final j j) {
                b2 = true;
            }
            String[] array2 = array;
            if (array == null) {
                if (b2) {
                    array2 = MyFileProvider.e;
                }
                else {
                    array2 = MyFileProvider.f;
                }
            }
            final String[] array3 = new String[array2.length];
            final Object[] array4 = new Object[array2.length];
            final int length = array2.length;
            int n = 0;
            while (i < length) {
                s = array2[i];
                int n2;
                if ("_display_name".equals((Object)s)) {
                    array3[n] = "_display_name";
                    n2 = n + 1;
                    array4[n] = ((File)(Object)c).getName();
                }
                else if ("_size".equals((Object)s)) {
                    array3[n] = "_size";
                    n2 = n + 1;
                    array4[n] = ((File)(Object)c).length();
                }
                else if ("_data".equals((Object)s)) {
                    array3[n] = "_data";
                    array4[n] = ((File)(Object)c).getAbsolutePath();
                    n2 = n + 1;
                }
                else {
                    n2 = n;
                    if ("mime_type".equals((Object)s)) {
                        array3[n] = "mime_type";
                        n2 = n + 1;
                        array4[n] = ((c)b).f();
                    }
                }
                ++i;
                n = n2;
            }
            final String[] g = g(array3, n);
            final Object[] f2 = f(array4, n);
            final MatrixCursor matrixCursor = new MatrixCursor(g, 1);
            matrixCursor.addRow(f2);
            return (Cursor)matrixCursor;
        }
        if (((c)b).l()) {
            final n n3 = (n)this.c.get((Object)uri);
            if (n3 != null) {
                return (Cursor)this.c(array, n3);
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            b = (String)new b((c)b, countDownLatch);
            ((q)b).i((Object[])new Void[0]);
            try {
                countDownLatch.await();
            }
            catch (final InterruptedException ex) {}
            final n x = ((b)b).x();
            if (x != null) {
                return (Cursor)this.c(array, x);
            }
            return (Cursor)this.b(array);
        }
        else {
            try {
                return (Cursor)this.c(array, k((c)b));
            }
            catch (final j k) {
                throw new IllegalStateException((Throwable)k);
            }
        }
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        throw new UnsupportedOperationException("No external updates");
    }
    
    public void z() {
        monitorenter(this);
        Label_0035: {
            try {
                if (this.b == null) {
                    this.b = new a(this.getContext());
                }
                break Label_0035;
            }
            finally {
                monitorexit(this);
                monitorexit(this);
            }
        }
    }
    
    static class b extends q<Void, Void, n>
    {
        c h;
        CountDownLatch i;
        n j;
        boolean k;
        
        b(final c h, final CountDownLatch i) {
            super(q$e.d0);
            this.k = ax.u3.B.H();
            this.h = h;
            this.i = i;
        }
        
        protected void o() {
            this.i.countDown();
        }
        
        protected n w(Void... e) {
            try {
                final K e2 = this.h.e();
                if (e2 == null) {
                    return null;
                }
                e = (Void[])(Object)x.e(e2);
                if (!((o)(Object)e).a()) {
                    boolean i;
                    if (!this.k) {
                        i = ((o)(Object)e).i(0L);
                    }
                    else {
                        ax.Ha.c.h().f().b("PROXY FILE OPERATOR NOT CONNECTED").h();
                        i = false;
                    }
                    if (!i) {
                        return null;
                    }
                }
                try {
                    ((o)(Object)e).n0();
                    return ((o)(Object)e).z(this.h.d);
                }
                finally {
                    ((o)(Object)e).k0(false);
                }
            }
            catch (final j j) {
                return null;
            }
        }
        
        n x() {
            return this.j;
        }
        
        protected void y(final n j) {
            this.j = j;
            this.i.countDown();
        }
    }
    
    static class c
    {
        private K a;
        private boolean b;
        String c;
        String d;
        
        c(final Uri uri) {
            final String encodedPath = uri.getEncodedPath();
            if (encodedPath != null) {
                final boolean b = true;
                final int index = encodedPath.indexOf(47, 1);
                this.c = Uri.decode(encodedPath.substring(1, index));
                this.d = Uri.decode(encodedPath.substring(index));
                boolean b2 = b;
                if (!"root".equals((Object)this.c)) {
                    b2 = ("external_files".equals((Object)this.c) && b);
                }
                this.b = b2;
                if (b2) {
                    this.a = x.g(this.d).T();
                    return;
                }
                this.a = K.h(this.c);
            }
        }
        
        private static String a(final K k, final String s) {
            final StringBuilder sb = new StringBuilder();
            sb.append(Uri.encode(k.k()));
            sb.append(Uri.encode(s, "/"));
            return sb.toString();
        }
        
        static c b(final Uri uri) {
            return new c(uri);
        }
        
        static Uri g(final n n) {
            return new Uri$Builder().scheme("content").authority("com.cxinventor.file.explorer.fileprovider").encodedPath(a(n.R(), n.E())).build();
        }
        
        static Uri h(final y y) {
            return new Uri$Builder().scheme("content").authority("com.cxinventor.file.explorer.fileprovider").encodedPath(a(y.B0(), ((n)y).E())).build();
        }
        
        File c() {
            return new File(this.d).getAbsoluteFile();
        }
        
        k d() {
            final K e = this.e();
            if (e == null) {
                ax.u3.b.f();
                return null;
            }
            return new k(e, this.d);
        }
        
        K e() {
            return this.a;
        }
        
        String f() {
            final String d = this.d;
            if (d != null) {
                final String f = v.f(d0.k(d));
                if (f != null) {
                    return f;
                }
            }
            return "application/octet-stream";
        }
        
        boolean i() {
            if (!this.b) {
                final K a = this.a;
                if (a != null) {
                    return ax.Q2.f.b0(a.d()) || ax.Q2.f.o0(this.a.d());
                }
            }
            return false;
        }
        
        boolean j() {
            if (!this.b) {
                final K a = this.a;
                if (a != null) {
                    return ax.Q2.f.j0(a.d());
                }
            }
            return false;
        }
        
        boolean k() {
            return this.b;
        }
        
        boolean l() {
            if (!this.b) {
                final K a = this.a;
                if (a != null) {
                    return ax.Q2.f.n0(a.d());
                }
            }
            return false;
        }
    }
}
