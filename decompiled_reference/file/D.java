package com.alphainventor.filemanager.file;

import com.box.androidsdk.content.requests.BoxRequestDownload;
import com.box.androidsdk.content.requests.BoxRequestsFolder$UpdateFolder;
import com.box.androidsdk.content.requests.BoxRequestItemUpdate;
import com.box.androidsdk.content.requests.BoxRequestUpload;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.requests.BoxRequestItem;
import android.text.TextUtils;
import android.os.Handler;
import android.os.Looper;
import ax.g3.k;
import android.content.SharedPreferences$Editor;
import com.box.androidsdk.content.models.BoxUser;
import ax.c3.k0;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.requests.BoxRequestsSearch$Search;
import com.box.androidsdk.content.models.BoxFolder;
import android.content.SharedPreferences;
import com.box.androidsdk.content.auth.BoxAuthentication;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import androidx.fragment.app.Fragment;
import android.app.Activity;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxRequestsFile$DownloadFile;
import ax.c3.B;
import ax.c3.A;
import com.box.androidsdk.content.requests.BoxRequestsFile$CopyFile;
import ax.c3.d0;
import com.box.androidsdk.content.models.BoxBookmark;
import ax.E3.h;
import com.box.androidsdk.content.requests.BoxRequestsFile$DownloadThumbnail;
import ax.u3.v;
import ax.u3.q$e;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.models.BoxDownload;
import ax.E3.h$b;
import java.io.OutputStream;
import android.net.Uri;
import ax.b3.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import ax.g3.i;
import ax.c3.G;
import java.util.Iterator;
import com.box.androidsdk.content.requests.BoxRequestsFolder$GetFolderItems;
import java.util.ArrayList;
import java.util.List;
import ax.c3.g;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequestsFolder$DeleteFolder;
import com.box.androidsdk.content.models.BoxError;
import ax.b3.f;
import ax.b3.D;
import ax.b3.s;
import ax.b3.t;
import ax.b3.q;
import ax.b3.j;
import com.box.androidsdk.content.BoxException;
import android.content.Context;
import j$.util.concurrent.ConcurrentHashMap;
import ax.E3.e;
import ax.E3.c;
import ax.E3.b;
import com.box.androidsdk.content.models.BoxSession;
import java.util.logging.Logger;

public class d extends m
{
    private static final Logger q;
    private static f r;
    private BoxSession h;
    private b i;
    private c j;
    private ax.E3.d k;
    private e l;
    private ConcurrentHashMap<String, ax.c3.c> m;
    private ConcurrentHashMap<String, String> n;
    private ConcurrentHashMap<String, String> o;
    private final Object p;
    
    static {
        q = Logger.getLogger("FileManager.BoxFileHelper");
    }
    
    public d() {
        this.m = (ConcurrentHashMap<String, ax.c3.c>)new ConcurrentHashMap();
        this.n = (ConcurrentHashMap<String, String>)new ConcurrentHashMap();
        this.o = (ConcurrentHashMap<String, String>)new ConcurrentHashMap();
        this.p = new Object();
    }
    
    private j n0(final String s, final BoxException ex) {
        final BoxException.ErrorType c = ex.c();
        final BoxError b = ex.b();
        String c2 = null;
        String d;
        if (b != null) {
            d = b.D();
        }
        else {
            d = null;
        }
        if (b != null) {
            c2 = b.C();
        }
        final int e = ex.e();
        if (c == BoxException.ErrorType.p0) {
            return (j)new q((Throwable)ex);
        }
        if (c == BoxException.ErrorType.e0) {
            return (j)new ax.b3.e((Throwable)ex);
        }
        if (e == 404 && "not_found".equals((Object)c2)) {
            return (j)new t((Throwable)ex);
        }
        if (e == 403 && "access_denied_insufficient_permissions".equals((Object)c2)) {
            return (j)new ax.b3.e(s, (Throwable)ex);
        }
        if (e == 403 && "storage_limit_exceeded".equals((Object)c2)) {
            return (j)new s(s, (Throwable)ex);
        }
        if (e == 403 && "file_size_limit_exceeded".equals((Object)c2)) {
            return (j)new D(s, (Throwable)ex);
        }
        if (e == 409 && ("conflict".equals((Object)c2) || "item_name_in_use".equals((Object)c2))) {
            return (j)new ax.b3.f(false);
        }
        if ("Couldn't connect to the Box API due to a network error".equals((Object)((Throwable)ex).getMessage())) {
            return (j)new q((Throwable)ex);
        }
        String string = "";
        if (c2 != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(" code:");
            sb.append(c2);
            string = sb.toString();
        }
        String string2 = string;
        if (d != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(" error:");
            sb2.append(d);
            string2 = sb2.toString();
        }
        String string3 = string2;
        if (e != 0) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(string2);
            sb3.append(" responseCode:");
            sb3.append(e);
            string3 = sb3.toString();
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append(s);
        sb4.append(string3);
        return ax.b3.d.b(sb4.toString(), (Exception)ex);
    }
    
    private void o0(final n n, final boolean b) throws j {
        if (((ax.c3.b)n).n()) {
            Label_0069: {
                BoxRequestsFolder$DeleteFolder d = null;
                Label_0063: {
                    try {
                        this.w0(n.E());
                        if (!((ax.c3.b)n).isDirectory()) {
                            break Label_0069;
                        }
                        d = this.j.d(((ax.c3.b)n).t());
                        if (b) {
                            d.E(true);
                            break Label_0063;
                        }
                    }
                    catch (final BoxException ex) {
                        throw this.n0("deleteFile", ex);
                    }
                    d.E(false);
                }
                d.x();
                return;
            }
            this.i.d(((ax.c3.b)n).t()).x();
            return;
        }
        throw new t();
    }
    
    private BoxItem p0(final String s, final String s2) throws j {
        System.currentTimeMillis();
        int n = 0;
        while (true) {
            Object o;
            try {
                o = this.j.h(s);
                ((BoxRequestItem<BoxJsonObject, BoxRequest>)o).E(this.q0());
                ((BoxRequestsFolder$GetFolderItems)o).F(1000);
                if (n > 0) {
                    ((BoxRequestsFolder$GetFolderItems)o).G(n);
                }
            }
            catch (final BoxException ex) {
                throw this.n0("getChildItem", (BoxException)s);
            }
            finally {
                throw s;
            }
            final BoxIteratorItems boxIteratorItems = ((BoxRequest<BoxIteratorItems, R>)o).x();
            o = boxIteratorItems.iterator();
            while (((Iterator)o).hasNext()) {
                final BoxItem boxItem = (BoxItem)((Iterator)o).next();
                if (s2.equals((Object)boxItem.M())) {
                    return boxItem;
                }
            }
            n = (int)(boxIteratorItems.J() + 1000L);
            if (boxIteratorItems.C() < n) {
                return null;
            }
        }
    }
    
    private String[] q0() {
        return new String[] { "name", "size", "modified_at", "content_modified_at", "item_status", "parent", "permissions" };
    }
    
    public static f r0(final Context context) {
        if (d.r == null) {
            d.r = new f(context.getApplicationContext());
        }
        return d.r;
    }
    
    private String s0(ax.c3.c c) throws j {
        final String g0 = c.g0();
        if (g0 != null) {
            return g0;
        }
        c = (ax.c3.c)this.z(((n)c).T());
        if (c.n()) {
            return c.t();
        }
        return null;
    }
    
    private String[] t0() {
        return new String[] { "name", "size", "modified_at", "content_modified_at", "item_status", "parent", "path_collection", "permissions" };
    }
    
    private static void u0(final Context context) {
        final ax.c3.g c = ax.c3.g.c(context);
        final ax.Q2.f s0 = ax.Q2.f.S0;
        ax.E3.g.c = c.a(s0);
        ax.E3.g.d = ax.c3.g.c(context).b(s0);
    }
    
    private List<BoxItem> v0(final String s, final String[] array) throws BoxException {
        final ArrayList list = new ArrayList();
        int n = 0;
        BoxIteratorItems boxIteratorItems;
        do {
            final BoxRequestsFolder$GetFolderItems h = this.j.h(s);
            ((BoxRequestItem<BoxJsonObject, BoxRequest>)h).E(array);
            h.F(1000);
            if (n > 0) {
                h.G(n);
            }
            boxIteratorItems = ((BoxRequest<BoxIteratorItems, BoxRequest>)h).x();
            final java.util.Iterator<BoxItem> iterator = boxIteratorItems.iterator();
            while (iterator.hasNext()) {
                ((List)list).add((Object)iterator.next());
            }
            n = (int)(boxIteratorItems.J() + 1000L);
        } while (boxIteratorItems.C() >= n);
        return (List<BoxItem>)list;
    }
    
    private void w0(final String s) {
        for (final String s2 : this.m.keySet()) {
            if (s2.startsWith(s)) {
                this.m.remove((Object)s2);
                final String s3 = (String)this.o.remove((Object)s2);
                if (s3 == null) {
                    continue;
                }
                this.n.remove((Object)s3);
            }
        }
    }
    
    private void x0(final ax.c3.c c) {
        this.m.put((Object)((n)c).E(), (Object)c);
        this.n.put((Object)c.t(), (Object)((n)c).E());
        this.o.put((Object)((n)c).E(), (Object)c.t());
    }
    
    private void y0(final BoxSession h) {
        final Object p = this.p;
        synchronized (p) {
            this.h = h;
            this.i = new b(h);
            this.j = new c(h);
            this.k = new ax.E3.d(h);
            this.l = new e(h);
        }
    }
    
    private void z0(n ex, final G g, final long n, final Long n2, final boolean b, final ax.u3.c c, final i i) throws j, a {
        try {
            final String s0 = this.s0((ax.c3.c)ex);
            if (s0 != null) {
                final InputStream b2 = g.b();
                Label_0072: {
                    if (b) {
                        try {
                            if (((ax.c3.c)ex).f0() != null) {
                                ex = (BoxException)this.i.o(b2, ((ax.c3.b)ex).t());
                                break Label_0072;
                            }
                        }
                        catch (final BoxException ex) {
                            throw this.n0("writeFile", ex);
                        }
                        ex = (BoxException)this.i.p(b2, ((n)ex).B(), s0);
                    }
                    else {
                        ex = (BoxException)this.i.p(b2, ((n)ex).B(), s0);
                    }
                }
                if (n2 != null && n2 >= 0L) {
                    ((BoxRequestUpload<BoxJsonObject, BoxRequest>)ex).H(new Date((long)n2));
                }
                try {
                    ((BoxRequestUpload<BoxJsonObject, BoxRequest>)ex).I((ax.F3.b)new ax.F3.b(this, i, n, c, b2) {
                        final i a;
                        final long b;
                        final ax.u3.c c;
                        final InputStream d;
                        final d e;
                        
                        public void a(final long n, final long n2) {
                            final i a = this.a;
                            if (a != null) {
                                a.a(n, this.b);
                            }
                            final ax.u3.c c = this.c;
                            if (c == null || !c.isCancelled()) {
                                return;
                            }
                            try {
                                this.d.close();
                            }
                            catch (final IOException ex) {}
                        }
                    });
                    ((BoxRequest<BoxObject, BoxRequest>)ex).x();
                    return;
                }
                catch (final BoxException ex2) {}
                throw this.n0("writeFile", ex);
            }
        }
        catch (final BoxException ex) {
            throw this.n0("writeFile", ex);
        }
        throw new j("Target parent does not exist");
    }
    
    public InputStream A(String s, final String s2, final String s3) throws IOException {
        Label_0030: {
            if (s3 == null) {
                break Label_0030;
            }
            try {
                if (!s3.startsWith("fileid=")) {
                    final ax.c3.c c = (ax.c3.c)this.z(s2);
                    if (c != null && !c.n()) {
                        return null;
                    }
                    s = c.t();
                }
                else {
                    s = Uri.decode(s3.substring(7));
                }
                final g g = new g(16384);
                final ax.d5.b b = new ax.d5.b((ax.d5.a)g);
                final BoxRequestsFile$DownloadThumbnail f = this.i.f((OutputStream)b, s);
                f.O(128);
                final ax.E3.h<BoxDownload> d = ((BoxRequest<BoxDownload, R>)f).D();
                d.a((h$b)new h$b<BoxDownload>(this, b, g) {
                    final ax.d5.b a;
                    final g b;
                    final d c;
                    
                    public void a(final BoxResponse<BoxDownload> p0) {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     1: invokevirtual   com/box/androidsdk/content/requests/BoxResponse.c:()Z
                        //     4: ifeq            21
                        //     7: aload_0        
                        //     8: getfield        com/alphainventor/filemanager/file/d$a.a:Lax/d5/b;
                        //    11: invokevirtual   ax/d5/b.flush:()V
                        //    14: goto            32
                        //    17: astore_1       
                        //    18: goto            40
                        //    21: aload_0        
                        //    22: getfield        com/alphainventor/filemanager/file/d$a.b:Lcom/alphainventor/filemanager/file/d$g;
                        //    25: aload_1        
                        //    26: invokevirtual   com/box/androidsdk/content/requests/BoxResponse.a:()Ljava/lang/Exception;
                        //    29: invokevirtual   com/alphainventor/filemanager/file/d$g.m:(Ljava/lang/Throwable;)V
                        //    32: aload_0        
                        //    33: getfield        com/alphainventor/filemanager/file/d$a.a:Lax/d5/b;
                        //    36: invokevirtual   ax/d5/b.close:()V
                        //    39: return         
                        //    40: aload_0        
                        //    41: getfield        com/alphainventor/filemanager/file/d$a.a:Lax/d5/b;
                        //    44: invokevirtual   ax/d5/b.close:()V
                        //    47: aload_1        
                        //    48: athrow         
                        //    49: astore_1       
                        //    50: aload_0        
                        //    51: getfield        com/alphainventor/filemanager/file/d$a.a:Lax/d5/b;
                        //    54: invokevirtual   ax/d5/b.close:()V
                        //    57: return         
                        //    58: astore_1       
                        //    59: goto            57
                        //    62: astore_2       
                        //    63: goto            47
                        //    Signature:
                        //  (Lcom/box/androidsdk/content/requests/BoxResponse<Lcom/box/androidsdk/content/models/BoxDownload;>;)V
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                 
                        //  -----  -----  -----  -----  ---------------------
                        //  0      14     49     57     Ljava/io/IOException;
                        //  0      14     17     49     Any
                        //  21     32     49     57     Ljava/io/IOException;
                        //  21     32     17     49     Any
                        //  32     39     58     62     Ljava/io/IOException;
                        //  40     47     62     66     Ljava/io/IOException;
                        //  50     57     58     62     Ljava/io/IOException;
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0040:
                        //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
                        //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
                        //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
                        //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
                        //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
                        //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
                        //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
                        //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
                        //     at u5.m.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:221)
                        //     at u5.m.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:499)
                        //     at u5.m.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:74)
                        //     at u5.m.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:256)
                        //     at u5.m.h(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:46)
                        //     at u5.m.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:628)
                        //     at u5.m.h(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:46)
                        //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:145)
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
                });
                v.f(q$e.f0).execute((Runnable)d);
                return (InputStream)g;
            }
            catch (final j j) {
                return null;
            }
        }
    }
    
    public boolean B(final n n) {
        return true;
    }
    
    public List<n> C(final n n, final m.f f) throws j {
        if (!((ax.c3.b)n).n()) {
            throw new t();
        }
        if (this.j == null) {
            final boolean a = this.a();
            final boolean b = this.j == null;
            final StringBuilder sb = new StringBuilder();
            sb.append("FolderApi == null:connected = ");
            sb.append(a);
            sb.append(":");
            sb.append(b);
            final j j = new j(sb.toString());
            ax.Q2.d.b((Throwable)j);
            throw j;
        }
        ax.u3.b.c(((ax.c3.b)n).isDirectory());
        ArrayList list;
        try {
            list = new ArrayList();
            for (final BoxItem boxItem : this.v0(((ax.c3.b)n).t(), this.q0())) {
                if (boxItem instanceof BoxBookmark) {
                    continue;
                }
                ((List)list).add((Object)new ax.c3.c(this, ((ax.c3.b)n).t(), boxItem, d0.Q(n.E(), boxItem.M())));
            }
        }
        catch (final BoxException ex) {
            throw this.n0("listChildren", ex);
        }
        return (List<n>)list;
    }
    
    public void D(final n n, final G g, final String s, final long n2, final Long n3, final p p9, final boolean b, final ax.u3.c c, final i i) throws j, a {
        ax.u3.b.a(((ax.c3.b)n).n());
        this.z0(n, g, n2, n3, false, c, i);
    }
    
    public void E(final n n, final n n2, final ax.u3.c c, final i i) throws j, a {
        ax.u3.b.a(((ax.c3.b)n2).n());
        if (((ax.c3.b)n).n()) {
            final boolean equals = n.T().equals((Object)n2.T());
            final boolean equals2 = n.B().equals((Object)n2.B());
            if (((ax.c3.b)n).isDirectory()) {
                this.w0(n.E());
            }
            Object o = null;
            Label_0105: {
                try {
                    if (((ax.c3.b)n).isDirectory()) {
                        o = this.j.i(((ax.c3.b)n).t());
                        break Label_0105;
                    }
                }
                catch (final BoxException ex) {
                    throw this.n0("moveFile", ex);
                }
                o = this.i.n(((ax.c3.b)n).t());
            }
            if (!equals) {
                ((BoxRequestItemUpdate<BoxFolder, BoxRequestsFolder$UpdateFolder>)o).G(this.s0((ax.c3.c)n2));
            }
            if (!equals2) {
                ((BoxRequestItemUpdate<BoxFolder, BoxRequestsFolder$UpdateFolder>)o).F(n2.B());
            }
            ((BoxRequest<BoxFolder, BoxRequestsFolder$UpdateFolder>)o).x();
            return;
        }
        throw new t();
    }
    
    public void F(final n n, final n n2, final ax.u3.c c, final i i) throws j, a {
        if (((ax.c3.b)n).n()) {
            long p4;
            BoxRequestsFile$CopyFile c2;
            try {
                final boolean equals = n.B().equals((Object)n2.B());
                final String s0 = this.s0((ax.c3.c)n2);
                if (s0 == null) {
                    throw new j("Target parent does not exist");
                }
                p4 = ((ax.c3.b)n).p();
                c2 = this.i.c(((ax.c3.b)n).t(), s0);
                if (!equals) {
                    c2.F(n2.B());
                }
            }
            catch (final BoxException ex) {
                throw this.n0("copyFile", ex);
            }
            c2.x();
            if (i != null) {
                i.a(p4, p4);
            }
            return;
        }
        throw new t();
    }
    
    public int G(final String s, final String s2) {
        return -1;
    }
    
    public String H(final n n) {
        if (A.J(n)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("fileid=");
            sb.append(Uri.encode(((ax.c3.b)n).t()));
            return B.a0(n, sb.toString());
        }
        return null;
    }
    
    public void I(final n n) throws j {
        this.o0(n, true);
    }
    
    public InputStream J(final n n, final long n2) throws j {
        if (!((ax.c3.b)n).n()) {
            throw new t();
        }
        if (this.a()) {
            Label_0127: {
                g g;
                ax.d5.b b;
                BoxRequestsFile$DownloadFile e;
                try {
                    g = new g(16384);
                    b = new ax.d5.b((ax.d5.a)g);
                    e = this.i.e((OutputStream)b, ((ax.c3.b)n).t());
                    if (n2 > 0L) {
                        ((BoxRequestDownload<BoxObject, BoxRequest>)e).H(n2, ((ax.c3.b)n).p());
                    }
                }
                catch (final IOException ex) {
                    break Label_0127;
                }
                final ax.E3.h<BoxObject> d = ((BoxRequest<BoxObject, R>)e).D();
                d.a((h$b)new h$b<BoxDownload>(this, b, g) {
                    final ax.d5.b a;
                    final g b;
                    final d c;
                    
                    public void a(final BoxResponse<BoxDownload> p0) {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     3: astore_3       
                        //     4: new             Ljava/lang/StringBuilder;
                        //     7: astore_2       
                        //     8: aload_2        
                        //     9: invokespecial   java/lang/StringBuilder.<init>:()V
                        //    12: aload_2        
                        //    13: ldc             "download complete :"
                        //    15: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                        //    18: pop            
                        //    19: aload_2        
                        //    20: aload_1        
                        //    21: invokevirtual   com/box/androidsdk/content/requests/BoxResponse.c:()Z
                        //    24: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
                        //    27: pop            
                        //    28: aload_3        
                        //    29: aload_2        
                        //    30: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                        //    33: invokevirtual   java/util/logging/Logger.fine:(Ljava/lang/String;)V
                        //    36: aload_1        
                        //    37: invokevirtual   com/box/androidsdk/content/requests/BoxResponse.c:()Z
                        //    40: ifeq            57
                        //    43: aload_0        
                        //    44: getfield        com/alphainventor/filemanager/file/d$b.a:Lax/d5/b;
                        //    47: invokevirtual   ax/d5/b.flush:()V
                        //    50: goto            68
                        //    53: astore_2       
                        //    54: goto            76
                        //    57: aload_0        
                        //    58: getfield        com/alphainventor/filemanager/file/d$b.b:Lcom/alphainventor/filemanager/file/d$g;
                        //    61: aload_1        
                        //    62: invokevirtual   com/box/androidsdk/content/requests/BoxResponse.a:()Ljava/lang/Exception;
                        //    65: invokevirtual   com/alphainventor/filemanager/file/d$g.m:(Ljava/lang/Throwable;)V
                        //    68: aload_0        
                        //    69: getfield        com/alphainventor/filemanager/file/d$b.a:Lax/d5/b;
                        //    72: invokevirtual   ax/d5/b.close:()V
                        //    75: return         
                        //    76: aload_0        
                        //    77: getfield        com/alphainventor/filemanager/file/d$b.a:Lax/d5/b;
                        //    80: invokevirtual   ax/d5/b.close:()V
                        //    83: aload_2        
                        //    84: athrow         
                        //    85: astore_1       
                        //    86: aload_0        
                        //    87: getfield        com/alphainventor/filemanager/file/d$b.a:Lax/d5/b;
                        //    90: invokevirtual   ax/d5/b.close:()V
                        //    93: return         
                        //    94: astore_1       
                        //    95: goto            93
                        //    98: astore_1       
                        //    99: goto            83
                        //    Signature:
                        //  (Lcom/box/androidsdk/content/requests/BoxResponse<Lcom/box/androidsdk/content/models/BoxDownload;>;)V
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                 
                        //  -----  -----  -----  -----  ---------------------
                        //  0      50     85     93     Ljava/io/IOException;
                        //  0      50     53     85     Any
                        //  57     68     85     93     Ljava/io/IOException;
                        //  57     68     53     85     Any
                        //  68     75     94     98     Ljava/io/IOException;
                        //  76     83     98     102    Ljava/io/IOException;
                        //  86     93     94     98     Ljava/io/IOException;
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0076:
                        //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
                        //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
                        //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
                        //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
                        //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
                        //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
                        //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
                        //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
                        //     at u5.m.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:221)
                        //     at u5.m.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:499)
                        //     at u5.m.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:74)
                        //     at u5.m.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:256)
                        //     at u5.m.h(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:46)
                        //     at u5.m.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:394)
                        //     at u5.m.h(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:46)
                        //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:145)
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
                });
                v.f(q$e.f0).execute((Runnable)d);
                return (InputStream)g;
            }
            final IOException ex;
            ((Throwable)ex).printStackTrace();
            throw new j((Throwable)ex);
        }
        throw new ax.b3.h("Box is not connected!");
    }
    
    public void K(final Activity activity, final Fragment fragment, final c$a c$a) {
        final int t = this.t();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final SharedPreferences sharedPreferences = this.p().getSharedPreferences("BoxCloudPrefs", 0);
        final StringBuilder sb = new StringBuilder();
        sb.append("accountid_");
        sb.append(t);
        final String string = sharedPreferences.getString(sb.toString(), (String)null);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("email_");
        sb2.append(t);
        final String string2 = sharedPreferences.getString(sb2.toString(), (String)null);
        u0((Context)activity);
        try {
            final BoxSession boxSession = new BoxSession(this.p(), string);
            boxSession.O(string2);
            boxSession.R(new BoxAuthentication.e(this, boxSession, atomicBoolean, atomicInteger, c$a) {
                final AtomicBoolean c0;
                final AtomicInteger d0;
                final c$a e0;
                final d f0;
                final BoxSession q;
                
                @Override
                public void e(final BoxAuthenticationInfo boxAuthenticationInfo, final Exception ex) {
                    d.q.fine("Box : onAuthFailure");
                    if (!this.c0.get()) {
                        this.c0.set(true);
                        this.d0.set(2);
                        this.f0.f0((Runnable)new Runnable(this) {
                            final d$d q;
                            
                            public void run() {
                                this.q.e0.T(false, (Object)null);
                            }
                        });
                        return;
                    }
                    final int value = this.d0.get();
                    final ax.Ha.b d = ax.Ha.c.h().f().d("Box onConnectResult Twice 2");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("called:");
                    sb.append(value);
                    d.g((Object)sb.toString()).h();
                }
                
                @Override
                public void g(final BoxAuthenticationInfo boxAuthenticationInfo) {
                    d.q.fine("Box : onRefreshed");
                }
                
                @Override
                public void h(final BoxAuthenticationInfo boxAuthenticationInfo) {
                    this.f0.y0(this.q);
                    if (!this.c0.get()) {
                        this.c0.set(true);
                        this.d0.set(1);
                        this.f0.f0((Runnable)new Runnable(this) {
                            final d$d q;
                            
                            public void run() {
                                this.q.e0.T(true, (Object)null);
                            }
                        });
                        return;
                    }
                    final int value = this.d0.get();
                    final ax.Ha.b d = ax.Ha.c.h().f().d("Box onConnectResult Twice 1");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("called:");
                    sb.append(value);
                    d.g((Object)sb.toString()).h();
                }
            });
            boxSession.l(this.p()).a((h$b)new h$b<BoxSession>(this, atomicBoolean, atomicInteger, c$a) {
                final AtomicBoolean a;
                final AtomicInteger b;
                final c$a c;
                final d d;
                
                public void a(final BoxResponse<BoxSession> boxResponse) {
                    if (!this.a.get()) {
                        this.a.set(true);
                        this.b.set(3);
                        if (!this.d.a()) {
                            this.d.f0((Runnable)new Runnable(this) {
                                final d$e q;
                                
                                public void run() {
                                    this.q.c.T(false, (Object)null);
                                }
                            });
                        }
                    }
                }
            });
            c$a.B();
        }
        catch (final RuntimeException ex) {
            ax.Q2.d.c("box init", (Throwable)ex);
            c$a.T(false, (Object)null);
        }
    }
    
    public boolean L() {
        return false;
    }
    
    public boolean M(final n n) {
        try {
            final String t = n.T();
            final String b = n.B();
            final ax.c3.c c = (ax.c3.c)this.z(t);
            if (!c.n()) {
                return false;
            }
            final BoxFolder boxFolder = ((BoxRequest<BoxFolder, R>)this.j.c(c.t(), b)).x();
            return true;
        }
        catch (final BoxException | j boxException | j) {
            return false;
        }
    }
    
    public boolean N(final n n) {
        return this.l(n);
    }
    
    public boolean O() {
        return true;
    }
    
    public void P(final n n) throws j {
        this.o0(n, false);
    }
    
    public boolean Q(final n n, final n n2) {
        return true;
    }
    
    public boolean Y() {
        return true;
    }
    
    public boolean a() {
        final Object p = this.p;
        synchronized (p) {
            return this.h != null;
        }
    }
    
    public void b() {
        this.m.clear();
        this.o.clear();
        this.n.clear();
    }
    
    public boolean g0() {
        return true;
    }
    
    public boolean h0() {
        return true;
    }
    
    public void j0(final n n, final G g, final String s, final long n2, final Long n3, final p p9, final boolean b, final ax.u3.c c, final i i) throws j, a {
        this.z0(n, g, n2, n3, true, c, i);
    }
    
    void m(final n n, final String s, final boolean b, final boolean b2, final ax.g3.h h, final ax.u3.c c) throws j {
        if (!b2) {
            this.o(n, s, b, b2, h, c);
            return;
        }
    Label_0104_Outer:
        while (true) {
            ArrayList list = null;
        Label_0244:
            while (true) {
                BoxItem boxItem;
                String q;
                try {
                    final String s2 = this.s0((ax.c3.c)n);
                    final BoxRequestsSearch$Search c2 = this.k.c(s);
                    c2.G(new String[] { BoxRequestsSearch$Search.f0 });
                    c2.F(new String[] { s2 });
                    ((BoxRequestItem<BoxJsonObject, BoxRequest>)c2).E(this.t0());
                    c2.I(200);
                    final BoxIteratorItems boxIteratorItems = ((BoxRequest<BoxIteratorItems, BoxRequest>)c2).x();
                    list = new ArrayList();
                    final java.util.Iterator<BoxItem> iterator = boxIteratorItems.iterator();
                    if (!iterator.hasNext()) {
                        break Label_0244;
                    }
                    boxItem = (BoxItem)iterator.next();
                    final BoxIterator<BoxFolder> o = boxItem.O();
                    q = "/";
                    for (final BoxFolder boxFolder : o) {
                        if (boxFolder.G() == "0") {
                            continue Label_0104_Outer;
                        }
                        q = d0.Q(q, boxFolder.M());
                    }
                }
                catch (final BoxException ex) {
                    throw this.n0("search", ex);
                }
                ((List)list).add((Object)new ax.c3.c(this, boxItem.N().G(), boxItem, d0.Q(q, boxItem.M())));
                continue;
            }
            if (h != null) {
                h.Y((List)list, true);
            }
        }
    }
    
    public k0 y() throws j {
        try {
            final BoxUser boxUser = ((BoxRequest<BoxUser, R>)this.l.d()).x();
            if (boxUser.K() != null && boxUser.M() != null) {
                return new k0((long)boxUser.K(), (long)boxUser.M());
            }
            return null;
        }
        catch (final BoxException ex) {
            if (this.h.D() != null && this.h.D().K() != null && this.h.D().M() != null) {
                return new k0((long)this.h.D().K(), (long)this.h.D().M());
            }
            throw this.n0("getStorageSpace", ex);
        }
    }
    
    public n z(final String s) throws j {
        if (!this.a()) {
            throw new ax.b3.h("Box is not connected!");
        }
        if (this.m.containsKey((Object)s)) {
            return (n)this.m.get((Object)s);
        }
        if (d0.a.equals((Object)s)) {
            return (n)new ax.c3.c(this, s);
        }
        final ax.c3.c c = (ax.c3.c)this.z(d0.r(s));
        final String h = d0.h(s);
        if (!c.n() || !c.isDirectory()) {
            return (n)new ax.c3.c(this, s);
        }
        final BoxItem p = this.p0(c.t(), h);
        if (p != null) {
            final ax.c3.c c2 = new ax.c3.c(this, c.t(), p, s);
            if (c2.isDirectory()) {
                this.x0(c2);
            }
            return (n)c2;
        }
        return (n)new ax.c3.c(this, c, s);
    }
    
    public static class f extends T
    {
        Context a;
        
        public f(final Context a) {
            this.a = a;
        }
        
        public void a(final int n) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("BoxCloudPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("accountid_");
            sb.append(n);
            final SharedPreferences$Editor remove = edit.remove(sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("email_");
            sb2.append(n);
            final SharedPreferences$Editor remove2 = remove.remove(sb2.toString());
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("display_name_");
            sb3.append(n);
            final SharedPreferences$Editor remove3 = remove2.remove(sb3.toString());
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("location_name_");
            sb4.append(n);
            final SharedPreferences$Editor remove4 = remove3.remove(sb4.toString());
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("created_");
            sb5.append(n);
            final SharedPreferences$Editor remove5 = remove4.remove(sb5.toString());
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("sortindex_");
            sb6.append(n);
            remove5.remove(sb6.toString()).commit();
        }
        
        public ax.Z2.s f(final int n) {
            final SharedPreferences sharedPreferences = this.a.getSharedPreferences("BoxCloudPrefs", 0);
            final StringBuilder sb = new StringBuilder();
            sb.append("email_");
            sb.append(n);
            final String string = sharedPreferences.getString(sb.toString(), (String)null);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("location_name_");
            sb2.append(n);
            final String string2 = sb2.toString();
            final ax.Q2.f s0 = ax.Q2.f.S0;
            final String string3 = sharedPreferences.getString(string2, s0.M(this.a));
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("created_");
            sb3.append(n);
            final long long1 = sharedPreferences.getLong(sb3.toString(), 0L);
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("sortindex_");
            sb4.append(n);
            return new ax.Z2.s(s0, n, string3, string, (String)null, (String)null, long1, sharedPreferences.getLong(sb4.toString(), 0L));
        }
        
        public void g(final int n, final String s) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("BoxCloudPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("location_name_");
            sb.append(n);
            edit.putString(sb.toString(), s);
            edit.commit();
        }
        
        public void j(final int n, final long n2) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("BoxCloudPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("sortindex_");
            sb.append(n);
            edit.putLong(sb.toString(), n2);
            edit.apply();
        }
        
        public void k(final com.alphainventor.filemanager.activity.a a, final k k) {
            k.b(ax.Q2.f.S0);
            u0((Context)a);
            final BoxSession boxSession = new BoxSession((Context)a, null);
            boxSession.R(new BoxAuthentication.e(this, k) {
                final d.f c0;
                final k q;
                
                @Override
                public void e(final BoxAuthenticationInfo boxAuthenticationInfo, final Exception ex) {
                    d.q.fine("Box : onAuthFailure");
                    new Handler(Looper.getMainLooper()).post((Runnable)new Runnable(this) {
                        final d$f$a q;
                        
                        public void run() {
                            this.q.q.a(ax.Q2.f.S0, "", 0, "", (String)null);
                        }
                    });
                }
                
                @Override
                public void g(final BoxAuthenticationInfo boxAuthenticationInfo) {
                    d.q.fine("Box : onRefreshed");
                }
                
                @Override
                public void h(final BoxAuthenticationInfo boxAuthenticationInfo) {
                    d.q.fine("Box : onAuthCreated");
                    final String g = boxAuthenticationInfo.K().G();
                    int m = this.c0.m();
                    final int l = this.c0.l(g);
                    if (l >= 0) {
                        m = l;
                    }
                    this.c0.o(m, boxAuthenticationInfo);
                    new Handler(Looper.getMainLooper()).post((Runnable)new Runnable(this, m) {
                        final d$f$a c0;
                        final int q;
                        
                        public void run() {
                            this.c0.q.c(ax.Q2.f.S0, this.q);
                        }
                    });
                }
            });
            boxSession.l((Context)a);
        }
        
        int l(final String s) {
            final Context a = this.a;
            int i = 0;
            for (SharedPreferences sharedPreferences = a.getSharedPreferences("BoxCloudPrefs", 0); i < sharedPreferences.getInt("count", 0); ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("accountid_");
                sb.append(i);
                if (sharedPreferences.contains(sb.toString()) && !TextUtils.isEmpty((CharSequence)s)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("accountid_");
                    sb2.append(i);
                    if (s.equals((Object)sharedPreferences.getString(sb2.toString(), (String)null))) {
                        return i;
                    }
                }
            }
            return -1;
        }
        
        int m() {
            return this.a.getSharedPreferences("BoxCloudPrefs", 0).getInt("count", 0);
        }
        
        public List<ax.Z2.s> n() {
            final ArrayList list = new ArrayList();
            final Context a = this.a;
            int i = 0;
            for (SharedPreferences sharedPreferences = a.getSharedPreferences("BoxCloudPrefs", 0); i < sharedPreferences.getInt("count", 0); ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("email_");
                sb.append(i);
                if (sharedPreferences.getString(sb.toString(), (String)null) != null) {
                    ((List)list).add((Object)this.f(i));
                }
            }
            return (List<ax.Z2.s>)list;
        }
        
        void o(final int n, final BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
            final BoxUser k = boxAuthenticationInfo.K();
            final String i = k.I();
            final String g = k.G();
            final String j = k.J();
            final Context a = this.a;
            boolean b = false;
            final SharedPreferences sharedPreferences = a.getSharedPreferences("BoxCloudPrefs", 0);
            if (n >= sharedPreferences.getInt("count", 0)) {
                b = true;
            }
            final SharedPreferences$Editor edit = sharedPreferences.edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("accountid_");
            sb.append(n);
            final SharedPreferences$Editor putString = edit.putString(sb.toString(), g);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("display_name_");
            sb2.append(n);
            final SharedPreferences$Editor putString2 = putString.putString(sb2.toString(), i);
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("email_");
            sb3.append(n);
            final SharedPreferences$Editor putString3 = putString2.putString(sb3.toString(), j);
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("location_name_");
            sb4.append(n);
            putString3.putString(sb4.toString(), ax.Q2.f.S0.M(this.a));
            if (b) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("created_");
                sb5.append(n);
                edit.putLong(sb5.toString(), System.currentTimeMillis());
                final StringBuilder sb6 = new StringBuilder();
                sb6.append("sortindex_");
                sb6.append(n);
                edit.putLong(sb6.toString(), System.currentTimeMillis());
            }
            if (b) {
                edit.putInt("count", n + 1);
            }
            edit.commit();
        }
    }
    
    protected static class g extends ax.d5.a
    {
        Throwable j0;
        
        protected g(final int n) {
            super(n);
        }
        
        public void m(final Throwable j0) {
            this.j0 = j0;
        }
        
        public int read() throws IOException {
            monitorenter(this);
            try {
                if (this.j0 != null) {
                    throw new IOException("Error raised", this.j0);
                }
                final int read = super.read();
                if (this.j0 == null) {
                    monitorexit(this);
                    return read;
                }
                throw new IOException("Error raised", this.j0);
            }
            finally {
                monitorexit(this);
                throw new IOException("Error raised", this.j0);
            }
        }
    }
}
