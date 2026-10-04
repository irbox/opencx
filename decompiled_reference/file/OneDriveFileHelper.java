package com.alphainventor.filemanager.file;

import com.microsoft.graph.generated.BaseQuota;
import com.microsoft.graph.generated.BaseDrive;
import ax.O9.D;
import ax.O9.z;
import ax.O9.A;
import ax.O9.C;
import ax.O9.u;
import java.net.URLConnection;
import ax.O9.v;
import ax.O9.w;
import com.microsoft.graph.generated.BaseDriveItemUploadableProperties;
import com.microsoft.graph.generated.BaseFileSystemInfo;
import ax.O9.H;
import ax.O9.x;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.O9.r;
import ax.O9.y;
import com.microsoft.graph.generated.BaseEntity;
import com.microsoft.graph.generated.BaseBaseItem;
import com.microsoft.graph.generated.BaseRemoteItem;
import com.microsoft.graph.generated.BaseDriveItem;
import com.microsoft.graph.generated.BaseItemReference;
import ax.g3.k;
import android.text.TextUtils;
import com.microsoft.graph.extensions.Quota;
import ax.c3.k0;
import ax.N9.W;
import java.util.Collections;
import com.microsoft.graph.extensions.Folder;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import androidx.fragment.app.Fragment;
import ax.b3.J;
import ax.N9.X;
import ax.c3.B;
import ax.b3.h;
import ax.c3.S;
import ax.c3.g;
import ax.N9.A$a;
import ax.b3.s;
import ax.r8.o;
import ax.r8.l;
import java.io.InputStream;
import ax.c3.F;
import java.net.HttpURLConnection;
import java.net.URL;
import ax.N9.Y;
import java.io.IOException;
import ax.L9.e;
import com.microsoft.graph.extensions.DriveItemUploadableProperties;
import ax.g3.i;
import ax.c3.G;
import java.util.Calendar;
import com.microsoft.graph.extensions.FileSystemInfo;
import android.content.SharedPreferences$Editor;
import android.util.AndroidRuntimeException;
import android.webkit.ValueCallback;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import ax.d3.a0;
import android.app.Activity;
import android.content.SharedPreferences;
import ax.Y2.a;
import ax.c3.c0;
import ax.Q2.f;
import java.util.Iterator;
import ax.N9.N;
import java.util.ArrayList;
import java.util.List;
import ax.u3.b;
import ax.N9.b0;
import android.content.Context;
import android.net.Uri;
import ax.c3.d0;
import com.microsoft.graph.extensions.DriveItem;
import ax.Ha.c;
import ax.b3.t;
import ax.N9.U;
import ax.c3.T;
import com.microsoft.graph.extensions.ItemReference;
import ax.M9.d;
import ax.b3.j;
import java.util.HashMap;
import com.microsoft.graph.extensions.Drive;
import java.util.Map;
import ax.N9.e0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

public class OneDriveFileHelper extends m
{
    private static final Logger l;
    static j m;
    static int n;
    static int o;
    private final AtomicReference<e0> h;
    private final Map<String, String> i;
    private final Map<String, String> j;
    private Drive k;
    
    static {
        l = Logger.getLogger("FileManager.OneDriveFileHelper");
        OneDriveFileHelper.n = 1048576;
        OneDriveFileHelper.o = 5242880;
    }
    
    public OneDriveFileHelper() {
        this.h = (AtomicReference<e0>)new AtomicReference();
        this.i = (Map<String, String>)new HashMap();
        this.j = (Map<String, String>)new HashMap();
        this.s0("/", "/drive/root");
    }
    
    private String A0(final String s, final boolean b) throws ax.b3.j, d {
        final String m0 = this.M0(s);
        String f0;
        if (m0 == null) {
            f0 = "/drive/root";
        }
        else {
            f0 = this.F0(m0);
        }
        if (f0 != null) {
            return f0;
        }
        if (this.P0(s) && b) {
            return "/drive/root";
        }
        return this.a1(s);
    }
    
    private String B0(String s) {
        final Map<String, String> i = this.i;
        synchronized (i) {
            s = (String)this.i.get((Object)s);
            return s;
        }
    }
    
    private ItemReference C0(String o0) throws ax.b3.j {
        final ItemReference itemReference = new ItemReference();
        final String a0 = this.A0(o0, false);
        if ("/drive/root".equals((Object)a0)) {
            ((BaseItemReference)itemReference).c = this.I0();
            final StringBuilder sb = new StringBuilder();
            sb.append("/drives/");
            sb.append(((BaseItemReference)itemReference).c);
            sb.append("/root:");
            final String string = sb.toString();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            String s = o0;
            if ("/".equals((Object)o0)) {
                s = "";
            }
            sb2.append(s);
            ((BaseItemReference)itemReference).g = sb2.toString();
            return itemReference;
        }
        ((BaseItemReference)itemReference).c = this.w0(a0);
        o0 = this.O0(o0);
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(a0);
        sb3.append(":");
        sb3.append(o0);
        ((BaseItemReference)itemReference).g = sb3.toString();
        return itemReference;
    }
    
    private U D0(final T t, final boolean b, final boolean b2) throws ax.b3.j {
        final DriveItem f0 = t.f0();
        if (f0 == null) {
            if (!b) {
                Label_0117: {
                    try {
                        return this.E0(((n)t).E(), true);
                    }
                    catch (final NullPointerException ex) {
                        break Label_0117;
                    }
                    throw new t("item not exist");
                }
                final NullPointerException ex;
                c.h().f().b("Item request builder").l((Throwable)ex).h();
                throw new ax.b3.j("no onedrive item", (Throwable)ex);
            }
            throw new t("item not exist");
        }
        if (((BaseDriveItem)f0).D != null && b2) {
            return ((ax.O9.E)((ax.O9.F)this.z0()).e(((BaseItemReference)((BaseRemoteItem)((BaseDriveItem)f0).D).m).c)).n(((BaseRemoteItem)((BaseDriveItem)f0).D).h);
        }
        return ((ax.O9.E)((ax.O9.F)this.z0()).e(((BaseItemReference)((BaseBaseItem)f0).m).c)).n(((BaseEntity)f0).c);
    }
    
    private U E0(String o0, final boolean b) throws ax.b3.j {
        final String a0 = this.A0(o0, b);
        U u;
        if ("/drive/root".equals((Object)a0)) {
            u = this.L0();
        }
        else {
            u = ((ax.O9.E)((ax.O9.F)this.z0()).e(this.w0(a0))).n(this.x0(a0));
            o0 = this.O0(o0);
        }
        if (!o0.isEmpty() && !"/".equals((Object)o0)) {
            String substring = o0;
            if (d0.B(o0)) {
                substring = o0.substring(1);
            }
            return u.h(Uri.encode(substring));
        }
        return u;
    }
    
    private String F0(String s) {
        final Map<String, String> i = this.i;
        synchronized (i) {
            s = (String)this.j.get((Object)s);
            return s;
        }
    }
    
    public static j G0(final Context context) {
        if (OneDriveFileHelper.m == null) {
            OneDriveFileHelper.m = new j(context.getApplicationContext());
        }
        return OneDriveFileHelper.m;
    }
    
    private b0 K0() throws ax.b3.j {
        return ((ax.O9.F)this.z0()).e(this.I0());
    }
    
    private U L0() throws ax.b3.j {
        return ((ax.O9.E)this.K0()).g();
    }
    
    private String M0(final String s) {
        b.c(d0.B(s));
        final String[] split = s.split("/");
        if (split.length < 2) {
            return null;
        }
        return split[1];
    }
    
    private String O0(final String s) {
        b.c(d0.B(s));
        final int index = s.indexOf("/", 1);
        if (index < 0) {
            return "";
        }
        return s.substring(index);
    }
    
    private boolean P0(final String s) {
        return s.split("/").length == 2;
    }
    
    private boolean Q0(final DriveItem driveItem) throws ax.b3.j {
        final ItemReference m = ((BaseBaseItem)driveItem).m;
        if (m == null) {
            if (!((BaseBaseItem)driveItem).l.equals((Object)"root") && ((BaseDriveItem)driveItem).E == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("no parent not root? : ");
                sb.append(((BaseBaseItem)driveItem).l);
                b.e(sb.toString());
            }
            return true;
        }
        final String g = ((BaseItemReference)m).g;
        if (g == null) {
            return this.I0().equals((Object)((BaseItemReference)((BaseBaseItem)driveItem).m).c);
        }
        return g.startsWith("/drive/root:") || (((BaseItemReference)((BaseBaseItem)driveItem).m).g.startsWith("/drives/") && ((BaseItemReference)((BaseBaseItem)driveItem).m).g.contains((CharSequence)"/root:"));
    }
    
    private List<n> R0(final T t) throws ax.b3.j {
        while (true) {
            final ArrayList list = new ArrayList();
            final boolean e = d0.E((n)t);
            boolean b = true;
            Label_0303: {
            Label_0223:
                while (true) {
                    Object value;
                    try {
                        value = ((r)((r)((ax.O9.s)((y)this.D0(t, true, true)).b()).a()).f("thumbnails")).get();
                        if (value == null) {
                            b = false;
                        }
                        ax.u3.b.c(b);
                        for (final DriveItem driveItem : ((IBaseCollectionPage)value).b()) {
                            ((List)list).add((Object)new T(this, driveItem, d0.Q(((n)t).E(), ((BaseBaseItem)driveItem).l)));
                            if (e) {
                                this.t0(driveItem);
                            }
                        }
                    }
                    catch (final OutOfMemoryError outOfMemoryError) {
                        break Label_0223;
                    }
                    catch (final NullPointerException ex) {
                        break Label_0303;
                    }
                    catch (final d d) {
                        throw this.u0("listchildren", d);
                    }
                    Object value2;
                    if (((IBaseCollectionPage)value).a() != null) {
                        value2 = ((r)((ax.O9.s)((IBaseCollectionPage)value).a()).a()).get();
                    }
                    else {
                        value2 = null;
                    }
                    if ((value = value2) == null) {
                        return (List<n>)list;
                    }
                    continue;
                }
                final int size = ((List)list).size();
                ((List)list).clear();
                final OutOfMemoryError outOfMemoryError;
                final ax.Ha.b l = c.h().f().b("!! OneDrive listChildren OOM").l((Throwable)outOfMemoryError);
                final StringBuilder sb = new StringBuilder();
                sb.append("children:");
                sb.append(size);
                l.g((Object)sb.toString()).h();
                throw new ax.b3.j((Throwable)outOfMemoryError);
            }
            final NullPointerException ex;
            final ax.Ha.b i = c.h().f().d("!! OneDrive listChildren NullPointError").l((Throwable)ex);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("path:");
            sb2.append(((n)t).E());
            i.g((Object)sb2.toString()).h();
            throw new ax.b3.j((Throwable)ex);
        }
    }
    
    private void S0() {
        final SharedPreferences sharedPreferences = this.p().getSharedPreferences("OneDrivePrefs", 0);
        final f p0 = f.P0;
        final c0 c0 = new c0(p0);
        final StringBuilder sb = new StringBuilder();
        sb.append("version_");
        sb.append(this.t());
        final int int1 = sharedPreferences.getInt(sb.toString(), 0);
        String s;
        if (int1 == 0) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("refresh_token_");
            sb2.append(this.t());
            s = sharedPreferences.getString(sb2.toString(), (String)null);
        }
        else {
            final String b = a.a().b(p0);
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("refresh_token_");
            sb3.append(this.t());
            s = c0.a(int1, b, sharedPreferences.getString(sb3.toString(), (String)null));
        }
        this.p().getSharedPreferences("com.microsoft.live", 0).edit().putString("refresh_token", s).commit();
    }
    
    private static void T0(Context applicationContext, final Activity activity, final String s, final ax.L9.c<e0> c) {
        synchronized (OneDriveFileHelper.class) {
            applicationContext = applicationContext.getApplicationContext();
            final e0 v0 = v0(applicationContext);
            ((ax.K9.b)((ax.M9.f)v0).c()).j((ax.L9.c)new OneDriveFileHelper$h((ax.L9.c)c, v0, applicationContext, activity, s));
        }
    }
    
    private String U0(final String s, final String s2) throws ax.b3.j {
        return ((BaseItemReference)((BaseBaseItem)((x)((y)((ax.O9.E)((ax.O9.F)this.z0()).e(s)).n(s2)).a()).get()).m).g;
    }
    
    private void V0(final e0 e0, final a0 a0) {
        ((ax.O9.G)((H)((ax.O9.F)e0).d()).a()).c((ax.L9.c)new OneDriveFileHelper$a(this, a0));
    }
    
    private void W0(String s) {
        if (s == null) {
            return;
        }
        final Map<String, String> i;
        monitorenter(i = this.i);
        Label_0050: {
            try {
                s = (String)this.j.remove((Object)s);
                if (s != null) {
                    this.i.remove((Object)s);
                }
                break Label_0050;
            }
            finally {
                monitorexit(i);
                monitorexit(i);
            }
        }
    }
    
    private static void X0(final Context context) {
        final SharedPreferences$Editor edit = context.getSharedPreferences("com.microsoft.live", 0).edit();
        edit.remove("refresh_token");
        edit.remove("cookies");
        edit.commit();
        try {
            final CookieSyncManager instance = CookieSyncManager.createInstance(context.getApplicationContext());
            CookieManager.getInstance().removeAllCookies((ValueCallback)null);
            instance.sync();
        }
        catch (final AndroidRuntimeException | UnsupportedOperationException ex) {}
    }
    
    private void Y0(final e0 e0) {
        final String f = ((ax.K9.b)((ax.M9.f)e0).c()).f();
        final int t = this.t();
        final f p = ax.Q2.f.P0;
        final c0 c0 = new c0(p);
        final SharedPreferences$Editor edit = this.p().getSharedPreferences("OneDrivePrefs", 0).edit();
        final StringBuilder sb = new StringBuilder();
        sb.append("version_");
        sb.append(t);
        final SharedPreferences$Editor putInt = edit.putInt(sb.toString(), 3);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("refresh_token_");
        sb2.append(t);
        putInt.putString(sb2.toString(), c0.e(a.a().b(p), f)).commit();
    }
    
    private void Z0(final T t, final long timeInMillis) throws ax.b3.j {
        int n = 0;
        while (true) {
            try {
                final DriveItem driveItem = new DriveItem();
                final FileSystemInfo w = new FileSystemInfo();
                final Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(timeInMillis);
                ((BaseFileSystemInfo)w).e = instance;
                ((BaseDriveItem)driveItem).w = w;
                ((x)((y)this.D0(t, false, true)).a()).j(driveItem);
            }
            catch (final d d) {
                Label_0119: {
                    if (((Throwable)d).getMessage() == null || !((Throwable)d).getMessage().contains((CharSequence)"409 :") || ++n >= 3) {
                        break Label_0119;
                    }
                    final long n2 = n;
                    try {
                        Thread.sleep(n2 * 500L);
                        continue;
                        throw this.u0("setLastModified", d);
                    }
                    catch (final Exception ex) {}
                }
            }
            break;
        }
    }
    
    private String a1(String m0) throws ax.b3.j, d {
        m0 = this.M0(m0);
        if (m0 == null) {
            b.f();
            return "/drive/root";
        }
        return this.t0(((x)((y)this.L0().h(Uri.encode(m0))).a()).get());
    }
    
    private void b1(final U u, final G g, final long n, final Long n2, final boolean b, final ax.u3.c c, final i i) throws ax.b3.j, ax.b3.a {
        final AtomicReference atomicReference = new AtomicReference();
        final OneDriveFileHelper.OneDriveFileHelper$MyDriveItemUploadableProperties oneDriveFileHelper$MyDriveItemUploadableProperties = new OneDriveFileHelper.OneDriveFileHelper$MyDriveItemUploadableProperties();
        if (b) {
            oneDriveFileHelper$MyDriveItemUploadableProperties.h = "replace";
        }
        else {
            oneDriveFileHelper$MyDriveItemUploadableProperties.h = "fail";
        }
        if (n2 != null) {
            final FileSystemInfo d = new FileSystemInfo();
            final Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis((long)n2);
            ((BaseFileSystemInfo)d).e = instance;
            ((BaseDriveItemUploadableProperties)oneDriveFileHelper$MyDriveItemUploadableProperties).d = d;
        }
        try {
            final E e = new E(((v)((w)((y)u).m((DriveItemUploadableProperties)oneDriveFileHelper$MyDriveItemUploadableProperties)).a()).e(), this.z0(), g, n, (Class)DriveItem.class);
            final ArrayList list = new ArrayList();
            Label_0219: {
                try {
                    e.a((List)list, c, (e)new OneDriveFileHelper$f(this, i, atomicReference), new int[] { OneDriveFileHelper.o });
                    if (c != null) {
                        if (c.isCancelled()) {
                            throw new ax.b3.a();
                        }
                    }
                }
                catch (final IOException ex) {
                    break Label_0219;
                }
                if (atomicReference.get() == null) {
                    return;
                }
                throw this.u0("onedrive uploadFile 2", (d)atomicReference.get());
            }
            final IOException ex;
            ((Throwable)ex).printStackTrace();
            throw ax.b3.d.b("onedrive chunked upload", (Exception)ex);
        }
        catch (final d d2) {
            throw this.u0("uploadChunk", d2);
        }
    }
    
    private void c1(final Y p0, final G p1, final long p2, final boolean p3, final ax.u3.c p4, final i p5) throws ax.b3.j, ax.b3.a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   ax/L9/f.<init>:()V
        //     7: astore          12
        //     9: new             Ljava/util/concurrent/atomic/AtomicReference;
        //    12: dup            
        //    13: invokespecial   java/util/concurrent/atomic/AtomicReference.<init>:()V
        //    16: astore          15
        //    18: iconst_0       
        //    19: istore          8
        //    21: new             Ljava/util/concurrent/atomic/AtomicBoolean;
        //    24: dup            
        //    25: iconst_0       
        //    26: invokespecial   java/util/concurrent/atomic/AtomicBoolean.<init>:(Z)V
        //    29: astore          13
        //    31: iload           5
        //    33: ifeq            61
        //    36: new             Lax/S9/d;
        //    39: dup            
        //    40: ldc_w           "@microsoft.graph.conflictBehavior"
        //    43: ldc_w           "replace"
        //    46: invokespecial   ax/S9/d.<init>:(Ljava/lang/String;Ljava/lang/Object;)V
        //    49: invokestatic    java/util/Collections.singletonList:(Ljava/lang/Object;)Ljava/util/List;
        //    52: astore          11
        //    54: aload           11
        //    56: astore          14
        //    58: goto            82
        //    61: new             Lax/S9/d;
        //    64: dup            
        //    65: ldc_w           "@microsoft.graph.conflictBehavior"
        //    68: ldc_w           "fail"
        //    71: invokespecial   ax/S9/d.<init>:(Ljava/lang/String;Ljava/lang/Object;)V
        //    74: invokestatic    java/util/Collections.singletonList:(Ljava/lang/Object;)Ljava/util/List;
        //    77: astore          11
        //    79: goto            54
        //    82: aload_2        
        //    83: invokevirtual   ax/c3/G.b:()Ljava/io/InputStream;
        //    86: astore          11
        //    88: new             Lcom/alphainventor/filemanager/file/OneDriveFileHelper$d;
        //    91: astore          16
        //    93: aload           16
        //    95: aload_0        
        //    96: aload           7
        //    98: aload           12
        //   100: aload           13
        //   102: aload           15
        //   104: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper$d.<init>:(Lcom/alphainventor/filemanager/file/OneDriveFileHelper;Lax/g3/i;Lax/L9/f;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicReference;)V
        //   107: new             Lcom/alphainventor/filemanager/file/OneDriveFileHelper$e;
        //   110: astore          17
        //   112: aload_1        
        //   113: invokeinterface ax/P9/p.d:()Ljava/lang/String;
        //   118: astore          18
        //   120: aload_1        
        //   121: invokeinterface ax/P9/p.i:()Lax/M9/f;
        //   126: astore          19
        //   128: aload           17
        //   130: aload_0        
        //   131: aload           18
        //   133: aload           19
        //   135: aload           14
        //   137: ldc_w           Lcom/microsoft/graph/extensions/DriveItem;.class
        //   140: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper$e.<init>:(Lcom/alphainventor/filemanager/file/OneDriveFileHelper;Ljava/lang/String;Lax/M9/f;Ljava/util/List;Ljava/lang/Class;)V
        //   143: aload           17
        //   145: getstatic       ax/P9/k.f0:Lax/P9/k;
        //   148: invokevirtual   ax/P9/b.t:(Lax/P9/k;)V
        //   151: aload           17
        //   153: invokevirtual   ax/P9/b.m:()Lax/M9/f;
        //   156: invokeinterface ax/M9/f.b:()Lax/P9/n;
        //   161: astore          18
        //   163: aload           17
        //   165: invokevirtual   ax/P9/b.q:()Ljava/lang/Class;
        //   168: astore          19
        //   170: new             Lcom/alphainventor/filemanager/file/OneDriveFileHelper$i;
        //   173: astore          20
        //   175: aload           20
        //   177: aload           11
        //   179: lload_3        
        //   180: aload           6
        //   182: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper$i.<init>:(Ljava/io/InputStream;JLax/u3/c;)V
        //   185: aload           18
        //   187: aload           17
        //   189: aload           16
        //   191: aload           19
        //   193: aload           20
        //   195: invokeinterface ax/P9/n.b:(Lax/P9/o;Lax/L9/c;Ljava/lang/Class;Ljava/lang/Object;)V
        //   200: aload           12
        //   202: invokevirtual   ax/L9/f.b:()V
        //   205: aload           6
        //   207: ifnull          242
        //   210: aload           6
        //   212: invokeinterface ax/u3/c.isCancelled:()Z
        //   217: ifne            223
        //   220: goto            242
        //   223: new             Lax/b3/a;
        //   226: astore_1       
        //   227: aload_1        
        //   228: invokespecial   ax/b3/a.<init>:()V
        //   231: aload_1        
        //   232: athrow         
        //   233: astore_1       
        //   234: aload_1        
        //   235: astore_2       
        //   236: aload           11
        //   238: astore_1       
        //   239: goto            470
        //   242: aload           13
        //   244: invokevirtual   java/util/concurrent/atomic/AtomicBoolean.get:()Z
        //   247: ifne            369
        //   250: iload           8
        //   252: iconst_3       
        //   253: if_icmpge       324
        //   256: aload_2        
        //   257: invokevirtual   ax/c3/G.a:()Z
        //   260: ifeq            324
        //   263: aload           15
        //   265: invokevirtual   java/util/concurrent/atomic/AtomicReference.get:()Ljava/lang/Object;
        //   268: instanceof      Lax/P9/j;
        //   271: istore          5
        //   273: iload           5
        //   275: ifne            324
        //   278: iinc            8, 1
        //   281: iload           8
        //   283: sipush          2000
        //   286: imul           
        //   287: iload           8
        //   289: imul           
        //   290: i2l            
        //   291: lstore          9
        //   293: lload           9
        //   295: invokestatic    java/lang/Thread.sleep:(J)V
        //   298: new             Lax/S9/d;
        //   301: astore          14
        //   303: aload           14
        //   305: ldc_w           "@microsoft.graph.conflictBehavior"
        //   308: ldc_w           "replace"
        //   311: invokespecial   ax/S9/d.<init>:(Ljava/lang/String;Ljava/lang/Object;)V
        //   314: aload           14
        //   316: invokestatic    java/util/Collections.singletonList:(Ljava/lang/Object;)Ljava/util/List;
        //   319: astore          14
        //   321: goto            415
        //   324: aload           15
        //   326: invokevirtual   java/util/concurrent/atomic/AtomicReference.get:()Ljava/lang/Object;
        //   329: astore_1       
        //   330: aload_1        
        //   331: ifnull          356
        //   334: aload           15
        //   336: invokevirtual   java/util/concurrent/atomic/AtomicReference.get:()Ljava/lang/Object;
        //   339: checkcast       Lax/M9/d;
        //   342: astore_1       
        //   343: aload_0        
        //   344: ldc_w           "onedrive uploadFile"
        //   347: aload_1        
        //   348: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper.u0:(Ljava/lang/String;Lax/M9/d;)Lax/b3/j;
        //   351: athrow         
        //   352: astore_1       
        //   353: goto            234
        //   356: new             Lax/b3/j;
        //   359: astore_1       
        //   360: aload_1        
        //   361: ldc_w           "onedrive uploadFile"
        //   364: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   367: aload_1        
        //   368: athrow         
        //   369: aload           13
        //   371: invokevirtual   java/util/concurrent/atomic/AtomicBoolean.get:()Z
        //   374: istore          5
        //   376: iload           5
        //   378: ifeq            321
        //   381: aload           11
        //   383: ifnull          414
        //   386: aload           11
        //   388: invokevirtual   java/io/InputStream.close:()V
        //   391: goto            414
        //   394: astore_1       
        //   395: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   398: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   401: ldc_w           "Onedrive close"
        //   404: invokevirtual   ax/Ha/b.b:(Ljava/lang/String;)Lax/Ha/b;
        //   407: aload_1        
        //   408: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   411: invokevirtual   ax/Ha/b.h:()V
        //   414: return         
        //   415: aload           11
        //   417: ifnull          450
        //   420: aload           11
        //   422: invokevirtual   java/io/InputStream.close:()V
        //   425: goto            450
        //   428: astore          11
        //   430: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   433: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   436: ldc_w           "Onedrive close"
        //   439: invokevirtual   ax/Ha/b.b:(Ljava/lang/String;)Lax/Ha/b;
        //   442: aload           11
        //   444: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   447: invokevirtual   ax/Ha/b.h:()V
        //   450: goto            82
        //   453: astore_2       
        //   454: aload           11
        //   456: astore_1       
        //   457: goto            470
        //   460: astore_2       
        //   461: goto            454
        //   464: astore_2       
        //   465: aconst_null    
        //   466: astore_1       
        //   467: goto            457
        //   470: aload_1        
        //   471: ifnull          501
        //   474: aload_1        
        //   475: invokevirtual   java/io/InputStream.close:()V
        //   478: goto            501
        //   481: astore_1       
        //   482: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   485: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   488: ldc_w           "Onedrive close"
        //   491: invokevirtual   ax/Ha/b.b:(Ljava/lang/String;)Lax/Ha/b;
        //   494: aload_1        
        //   495: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   498: invokevirtual   ax/Ha/b.h:()V
        //   501: aload_2        
        //   502: athrow         
        //   503: astore          14
        //   505: goto            298
        //   508: astore_1       
        //   509: goto            414
        //   512: astore          11
        //   514: goto            450
        //   517: astore_1       
        //   518: goto            501
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  82     88     464    470    Any
        //  88     93     460    464    Any
        //  93     107    453    454    Any
        //  107    128    233    234    Any
        //  128    143    352    356    Any
        //  143    205    233    234    Any
        //  210    220    233    234    Any
        //  223    233    233    234    Any
        //  242    250    233    234    Any
        //  256    273    233    234    Any
        //  293    298    503    508    Ljava/lang/InterruptedException;
        //  293    298    233    234    Any
        //  298    321    233    234    Any
        //  324    330    233    234    Any
        //  334    343    233    234    Any
        //  343    352    352    356    Any
        //  356    369    352    356    Any
        //  369    376    352    356    Any
        //  386    391    508    512    Ljava/io/IOException;
        //  386    391    394    414    Ljava/lang/IllegalStateException;
        //  420    425    512    517    Ljava/io/IOException;
        //  420    425    428    450    Ljava/lang/IllegalStateException;
        //  474    478    517    521    Ljava/io/IOException;
        //  474    478    481    501    Ljava/lang/IllegalStateException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0223:
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
    
    private void d1(final String s, final long n, final i i) {
    Label_0139_Outer:
        while (true) {
            Label_0147: {
                Object o = null;
                int s4 = 0;
                Label_0075: {
                    try {
                        o = new URL(s);
                        final Object o2;
                        o = (o2 = ((URL)o).openConnection());
                        final InputStream inputStream = ((URLConnection)o2).getInputStream();
                        final int n2 = 256;
                        final String s2 = F.i(inputStream, n2);
                        final ax.r8.i j = ax.r8.n.d(s2);
                        final l l = j.h();
                        final String s3 = "percentageComplete";
                        final o o3 = l.w(s3);
                        final o o5;
                        final o o4 = o5 = o3;
                        if (o5 == null) {
                            final URL url = (URL)o;
                            ((HttpURLConnection)url).disconnect();
                            break Label_0147;
                        }
                        break Label_0075;
                    }
                    catch (final NullPointerException ex) {
                        break Label_0147;
                    }
                    catch (final IllegalStateException ex2) {
                        break Label_0147;
                    }
                    catch (final NumberFormatException ex3) {
                        break Label_0147;
                    }
                    catch (final IOException ex4) {
                        break Label_0147;
                    }
                    try {
                        final Object o2 = o;
                        final InputStream inputStream = ((URLConnection)o2).getInputStream();
                        final int n2 = 256;
                        final String s2 = F.i(inputStream, n2);
                        final ax.r8.i j = ax.r8.n.d(s2);
                        final l l = j.h();
                        final String s3 = "percentageComplete";
                        final o o3 = l.w(s3);
                        final o o5;
                        final o o4 = o5 = o3;
                        if (o5 == null) {
                            final URL url = (URL)o;
                            ((HttpURLConnection)url).disconnect();
                            break Label_0147;
                        }
                        s4 = o4.s();
                        if (i != null) {
                            i.a(s4 * n / 100L, n);
                        }
                    }
                    finally {
                        break Label_0147;
                    }
                }
                if (s4 >= 100) {
                    ((HttpURLConnection)o).disconnect();
                    return;
                }
                while (true) {
                    if (s4 >= 50) {
                        break Label_0139;
                    }
                    try {
                        Thread.sleep(250L);
                        ((HttpURLConnection)o).disconnect();
                        continue Label_0139_Outer;
                        Label_0182: {
                            return;
                        }
                        while (true) {
                            iftrue(Label_0182:)(i == null);
                            Block_17: {
                                Block_18: {
                                    break Block_18;
                                    ((Throwable)s).printStackTrace();
                                    break Block_17;
                                }
                                i.a(n, n);
                                return;
                                ((HttpURLConnection)o).disconnect();
                                throw s;
                            }
                            try {
                                Thread.sleep(1250L);
                            }
                            catch (final InterruptedException ex5) {}
                            continue;
                        }
                    }
                    catch (final Exception ex6) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private void e1(final n p0, final G p1, final String p2, final long p3, final Long p4, final boolean p5, final boolean p6, final ax.u3.c p7, final i p8) throws ax.b3.j, ax.b3.a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //     5: iconst_0       
        //     6: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper.k0:(Ljava/lang/String;Z)Lax/c3/T;
        //     9: invokevirtual   ax/c3/T.n:()Z
        //    12: ifeq            354
        //    15: aload_1        
        //    16: checkcast       Lax/c3/T;
        //    19: astore          12
        //    21: aload_0        
        //    22: aload           12
        //    24: iconst_0       
        //    25: iconst_1       
        //    26: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper.D0:(Lax/c3/T;ZZ)Lax/N9/U;
        //    29: astore          13
        //    31: lload           4
        //    33: ldc2_w          -1
        //    36: lcmp           
        //    37: ifne            289
        //    40: aconst_null    
        //    41: astore_3       
        //    42: aload_2        
        //    43: invokevirtual   ax/c3/G.b:()Ljava/io/InputStream;
        //    46: astore          11
        //    48: aload_0        
        //    49: invokevirtual   com/alphainventor/filemanager/file/m.p:()Landroid/content/Context;
        //    52: aload_1        
        //    53: invokestatic    ax/Z2/a.l:(Landroid/content/Context;Lcom/alphainventor/filemanager/file/n;)Ljava/io/File;
        //    56: astore_2       
        //    57: new             Ljava/lang/StringBuilder;
        //    60: astore          14
        //    62: aload           14
        //    64: invokespecial   java/lang/StringBuilder.<init>:()V
        //    67: aload           14
        //    69: aload_1        
        //    70: invokevirtual   com/alphainventor/filemanager/file/n.B:()Ljava/lang/String;
        //    73: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    76: pop            
        //    77: aload           14
        //    79: invokestatic    java/lang/System.currentTimeMillis:()J
        //    82: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //    85: pop            
        //    86: aload           14
        //    88: ldc_w           ".tmp"
        //    91: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    94: pop            
        //    95: aload           14
        //    97: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   100: astore          14
        //   102: new             Ljava/io/File;
        //   105: astore_1       
        //   106: aload_1        
        //   107: aload_2        
        //   108: aload           14
        //   110: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   113: aload           11
        //   115: aload_1        
        //   116: ldc2_w          -1
        //   119: aload           9
        //   121: invokestatic    ax/c3/F.f:(Ljava/io/InputStream;Ljava/io/File;JLax/u3/c;)V
        //   124: aload_1        
        //   125: invokestatic    ax/c3/x.f:(Ljava/io/File;)Lcom/alphainventor/filemanager/file/o;
        //   128: astore_2       
        //   129: aload_2        
        //   130: aload_1        
        //   131: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   134: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //   137: astore          11
        //   139: aload           11
        //   141: invokeinterface ax/c3/b.p:()J
        //   146: lstore          4
        //   148: aload_2        
        //   149: aload           11
        //   151: invokevirtual   com/alphainventor/filemanager/file/o.x:(Lcom/alphainventor/filemanager/file/n;)Lax/c3/G;
        //   154: astore_2       
        //   155: lload           4
        //   157: lconst_0       
        //   158: lcmp           
        //   159: ifne            205
        //   162: aload_0        
        //   163: aload           13
        //   165: invokeinterface ax/O9/y.k:()Lax/N9/Y;
        //   170: aload_2        
        //   171: lload           4
        //   173: iload           8
        //   175: aload           9
        //   177: aload           10
        //   179: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper.c1:(Lax/N9/Y;Lax/c3/G;JZLax/u3/c;Lax/g3/i;)V
        //   182: aload           6
        //   184: ifnull          222
        //   187: aload_0        
        //   188: aload           12
        //   190: aload           6
        //   192: invokevirtual   java/lang/Long.longValue:()J
        //   195: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper.Z0:(Lax/c3/T;J)V
        //   198: goto            222
        //   201: astore_2       
        //   202: goto            267
        //   205: aload_0        
        //   206: aload           13
        //   208: aload_2        
        //   209: lload           4
        //   211: aload           6
        //   213: iload           8
        //   215: aload           9
        //   217: aload           10
        //   219: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper.b1:(Lax/N9/U;Lax/c3/G;JLjava/lang/Long;ZLax/u3/c;Lax/g3/i;)V
        //   222: aconst_null    
        //   223: invokestatic    ax/c3/F.a:(Ljava/lang/AutoCloseable;)V
        //   226: aload_1        
        //   227: invokevirtual   java/io/File.exists:()Z
        //   230: ifeq            335
        //   233: aload_1        
        //   234: invokevirtual   java/io/File.delete:()Z
        //   237: pop            
        //   238: return         
        //   239: astore_1       
        //   240: goto            367
        //   243: astore_1       
        //   244: goto            369
        //   247: astore_1       
        //   248: goto            378
        //   251: astore_2       
        //   252: aload           11
        //   254: astore_3       
        //   255: goto            267
        //   258: astore_2       
        //   259: aconst_null    
        //   260: astore_1       
        //   261: goto            252
        //   264: astore_2       
        //   265: aconst_null    
        //   266: astore_1       
        //   267: aload_3        
        //   268: invokestatic    ax/c3/F.a:(Ljava/lang/AutoCloseable;)V
        //   271: aload_1        
        //   272: ifnull          287
        //   275: aload_1        
        //   276: invokevirtual   java/io/File.exists:()Z
        //   279: ifeq            287
        //   282: aload_1        
        //   283: invokevirtual   java/io/File.delete:()Z
        //   286: pop            
        //   287: aload_2        
        //   288: athrow         
        //   289: lload           4
        //   291: getstatic       com/alphainventor/filemanager/file/OneDriveFileHelper.n:I
        //   294: i2l            
        //   295: lcmp           
        //   296: ifge            336
        //   299: aload_0        
        //   300: aload           13
        //   302: invokeinterface ax/O9/y.k:()Lax/N9/Y;
        //   307: aload_2        
        //   308: lload           4
        //   310: iload           8
        //   312: aload           9
        //   314: aload           10
        //   316: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper.c1:(Lax/N9/Y;Lax/c3/G;JZLax/u3/c;Lax/g3/i;)V
        //   319: aload           6
        //   321: ifnull          335
        //   324: aload_0        
        //   325: aload           12
        //   327: aload           6
        //   329: invokevirtual   java/lang/Long.longValue:()J
        //   332: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper.Z0:(Lax/c3/T;J)V
        //   335: return         
        //   336: aload_0        
        //   337: aload           13
        //   339: aload_2        
        //   340: lload           4
        //   342: aload           6
        //   344: iload           8
        //   346: aload           9
        //   348: aload           10
        //   350: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper.b1:(Lax/N9/U;Lax/c3/G;JLjava/lang/Long;ZLax/u3/c;Lax/g3/i;)V
        //   353: return         
        //   354: new             Lax/b3/j;
        //   357: astore_1       
        //   358: aload_1        
        //   359: ldc_w           "parentPath doesn't exist"
        //   362: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   365: aload_1        
        //   366: athrow         
        //   367: aload_1        
        //   368: athrow         
        //   369: aload_0        
        //   370: ldc_w           "writeFileInternal"
        //   373: aload_1        
        //   374: invokespecial   com/alphainventor/filemanager/file/OneDriveFileHelper.u0:(Ljava/lang/String;Lax/M9/d;)Lax/b3/j;
        //   377: athrow         
        //   378: ldc_w           "onedrive upload"
        //   381: aload_1        
        //   382: invokestatic    ax/b3/d.b:(Ljava/lang/String;Ljava/lang/Exception;)Lax/b3/j;
        //   385: athrow         
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      31     247    251    Ljava/io/IOException;
        //  0      31     243    247    Lax/M9/d;
        //  0      31     239    243    Any
        //  42     48     264    267    Any
        //  48     113    258    264    Any
        //  113    124    251    252    Any
        //  124    155    201    205    Any
        //  162    182    201    205    Any
        //  187    198    201    205    Any
        //  205    222    201    205    Any
        //  222    238    247    251    Ljava/io/IOException;
        //  222    238    243    247    Lax/M9/d;
        //  222    238    239    243    Any
        //  267    271    247    251    Ljava/io/IOException;
        //  267    271    243    247    Lax/M9/d;
        //  267    271    239    243    Any
        //  275    287    247    251    Ljava/io/IOException;
        //  275    287    243    247    Lax/M9/d;
        //  275    287    239    243    Any
        //  287    289    247    251    Ljava/io/IOException;
        //  287    289    243    247    Lax/M9/d;
        //  287    289    239    243    Any
        //  289    319    247    251    Ljava/io/IOException;
        //  289    319    243    247    Lax/M9/d;
        //  289    319    239    243    Any
        //  324    335    247    251    Ljava/io/IOException;
        //  324    335    243    247    Lax/M9/d;
        //  324    335    239    243    Any
        //  336    353    247    251    Ljava/io/IOException;
        //  336    353    243    247    Lax/M9/d;
        //  336    353    239    243    Any
        //  354    367    247    251    Ljava/io/IOException;
        //  354    367    243    247    Lax/M9/d;
        //  354    367    239    243    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0205:
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
    
    private T k0(final String s, final boolean b) throws ax.b3.j {
        try {
            Object o;
            final ax.N9.T t = (ax.N9.T)(o = ((y)this.E0(s, (boolean)(0 != 0))).a());
            if (b) {
                o = ((x)t).f("thumbnails");
                return new T(this, ((x)o).get(), s);
            }
            return new T(this, ((x)o).get(), s);
        }
        catch (final d d) {
            if (d.a(ax.M9.e.k0) || (((Throwable)d).getMessage() != null && ((Throwable)d).getMessage().contains((CharSequence)"404 :"))) {
                return new T(this, s);
            }
            if (((Throwable)d).getMessage() != null && ((Throwable)d).getMessage().contains((CharSequence)"400 :") && s.endsWith(".")) {
                throw new ax.b3.o("onedrive getfileinfo", (Throwable)d);
            }
            ((Throwable)d).printStackTrace();
            throw this.u0("onedrive getfileinfo", d);
        }
    }
    
    private void s0(final String s, final String s2) {
        final Map<String, String> i = this.i;
        synchronized (i) {
            this.j.put((Object)s, (Object)s2);
            this.i.put((Object)s2, (Object)s);
        }
    }
    
    private String t0(final DriveItem driveItem) {
        String string;
        if (((BaseDriveItem)driveItem).D != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("/drives/");
            sb.append(((BaseItemReference)((BaseRemoteItem)((BaseDriveItem)driveItem).D).m).c);
            sb.append("/items/");
            sb.append(((BaseRemoteItem)((BaseDriveItem)driveItem).D).h);
            string = sb.toString();
        }
        else {
            string = "/drive/root";
        }
        this.s0(((BaseBaseItem)driveItem).l, string);
        return string;
    }
    
    private ax.b3.j u0(final String s, final d d) {
        if (d.a(ax.M9.e.k0)) {
            return (ax.b3.j)new t((Throwable)d);
        }
        if (d.a(ax.M9.e.q)) {
            return (ax.b3.j)new ax.b3.e(s, (Throwable)d);
        }
        if (d.a(ax.M9.e.p0)) {
            return (ax.b3.j)new s(s, (Throwable)d);
        }
        if (d.a(ax.M9.e.m0)) {
            return (ax.b3.j)new ax.b3.f(false, (Throwable)d);
        }
        if (((Throwable)d).getMessage() != null && ((Throwable)d).getMessage().contains((CharSequence)"404 :")) {
            return (ax.b3.j)new t((Throwable)d);
        }
        if (((Throwable)d).getMessage() != null && ((Throwable)d).getMessage().contains((CharSequence)"507 :")) {
            return (ax.b3.j)new s(s, (Throwable)d);
        }
        if (((Throwable)d).getMessage() != null && ((Throwable)d).getMessage().contains((CharSequence)"409 :")) {
            return (ax.b3.j)new ax.b3.f(false, (Throwable)d);
        }
        if (((Throwable)d).getMessage() != null && ((Throwable)d).getMessage().contains((CharSequence)"403 : Forbidden")) {
            return (ax.b3.j)new ax.b3.e(s, (Throwable)d);
        }
        return ax.b3.d.b(s, (Exception)d);
    }
    
    private static e0 v0(final Context context) {
        return new A$a().d(S.f(context, (ax.K9.a)new OneDriveFileHelper$g(context, g.c(context).a(f.P0)))).b();
    }
    
    private String y0() {
        final SharedPreferences sharedPreferences = this.p().getSharedPreferences("OneDrivePrefs", 0);
        final StringBuilder sb = new StringBuilder();
        sb.append("email_");
        sb.append(this.t());
        return sharedPreferences.getString(sb.toString(), (String)null);
    }
    
    private e0 z0() throws h {
        final e0 e0 = (e0)this.h.get();
        if (e0 != null) {
            return e0;
        }
        throw new h("OneDrive client is null");
    }
    
    public InputStream A(String s, final String s2, final String s3) {
        Label_0037: {
            if (s3 != null) {
                Label_0076: {
                    try {
                        if (s3.startsWith("url=")) {
                            s = Uri.decode(s3.substring(4));
                            return new URL(s).openStream();
                        }
                    }
                    catch (final IOException ex) {
                        break Label_0076;
                    }
                    catch (final ax.b3.j ex) {
                        break Label_0076;
                    }
                    break Label_0037;
                }
                final IOException ex;
                ((Throwable)ex).printStackTrace();
                return null;
            }
        }
        final T t = (T)this.z(s2);
        if (t.g0() == null) {
            return null;
        }
        s = t.g0();
        return new URL(s).openStream();
    }
    
    public boolean B(final n n) {
        return true;
    }
    
    public List<n> C(final n n, final m.f f) throws ax.b3.j {
        if (((ax.c3.b)n).n()) {
            b.c(((ax.c3.b)n).isDirectory());
            final T t = (T)n;
            b.c(t.f0() != null);
            return this.R0(t);
        }
        throw new t();
    }
    
    public void D(final n n, final G g, final String s, final long n2, final Long n3, final p p9, final boolean b, final ax.u3.c c, final i i) throws ax.b3.j, ax.b3.a {
        b.a(((ax.c3.b)n).n());
        this.e1(n, g, s, n2, n3, b, false, c, i);
    }
    
    public void E(final n n, final n n2, final ax.u3.c c, final i i) throws ax.b3.j {
        b.a(((ax.c3.b)n2).n());
        if (((ax.c3.b)n).n()) {
            if (c != null) {
                if (c.isCancelled()) {
                    throw new ax.b3.j("Operation cancelled");
                }
            }
            DriveItem driveItem = null;
            Label_0121: {
                try {
                    driveItem = new DriveItem();
                    if (n.T().equals((Object)n2.T())) {
                        ((BaseBaseItem)driveItem).l = n2.B();
                        break Label_0121;
                    }
                }
                catch (final d d) {
                    throw this.u0("move", d);
                }
                final String t = n2.T();
                if (!((ax.c3.b)this.k0(t, false)).n()) {
                    throw new ax.b3.j("Target parent does not exist");
                }
                ((BaseBaseItem)driveItem).l = n2.B();
                ((BaseBaseItem)driveItem).m = this.C0(t);
            }
            ((x)((y)this.D0((T)n, true, false)).a()).j(driveItem);
            if (i != null) {
                final long p4 = ((ax.c3.b)n).p();
                i.a(p4, p4);
            }
            return;
        }
        throw new t();
    }
    
    public void F(final n n, final n n2, final ax.u3.c c, final i i) throws ax.b3.j, ax.b3.a {
        b.a(((ax.c3.b)n2).n());
        if (!((ax.c3.b)n).n()) {
            throw new t("not existing source file");
        }
        if (c != null && c.isCancelled()) {
            throw new ax.b3.a();
        }
        final long p4 = ((ax.c3.b)n).p();
        final ItemReference c2 = this.C0(n2.T());
        Label_0131: {
            try {
                final DriveItem e = ((ax.O9.t)((u)((y)this.D0((T)n, true, true)).j(n2.B(), c2)).a()).e();
                if (e == null) {
                    break Label_0131;
                }
                if (((BaseBaseItem)e).l != null) {
                    break Label_0131;
                }
                final String n3 = ((BaseBaseItem)e).n;
                if (n3 != null) {
                    this.d1(n3, p4, i);
                    return;
                }
            }
            catch (final d d) {
                throw this.u0("copy", d);
            }
            b.f();
            return;
            try {
                Thread.sleep(1250L);
            }
            catch (final InterruptedException ex) {}
        }
        if (i != null) {
            i.a(p4, p4);
        }
    }
    
    public int G(final String s, final String s2) {
        return -1;
    }
    
    public String H(final n n) {
        final T t = (T)n;
        if (t.g0() == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("url=");
        sb.append(Uri.encode(t.g0()));
        return B.a0(n, sb.toString());
    }
    
    Drive H0() throws h {
        final Drive k = this.k;
        if (k != null) {
            return k;
        }
        b.f();
        throw new h("MyDrive is null");
    }
    
    public void I(final n n) throws ax.b3.j {
        try {
            ((x)((y)this.D0((T)n, true, false)).a()).delete();
        }
        catch (final d d) {
            throw this.u0("deleteRecursively", d);
        }
    }
    
    String I0() throws h {
        return ((BaseEntity)this.H0()).c;
    }
    
    public InputStream J(final n n, final long n2) throws ax.b3.j {
        X a;
        try {
            a = ((C)((y)this.D0((T)n, true, true)).k()).a();
            if (n2 != 0L) {
                final StringBuilder sb = new StringBuilder();
                sb.append("bytes=");
                sb.append(n2);
                sb.append("-");
                ((ax.P9.o)a).k("Range", sb.toString());
            }
        }
        catch (final d d) {
            throw this.u0("getInputStream", d);
        }
        return ((ax.O9.B)a).get();
    }
    
    String J0(String string) throws J {
        try {
            String s;
            if ((s = this.B0(string)) == null) {
                this.b0(this.z("/"));
                s = this.B0(string);
                if (s == null) {
                    final ax.Ha.b d = c.h().f().d("ONEDRIVE LOCAL PATH NULL");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("remoteDrivePath : ");
                    sb.append(s);
                    d.g((Object)sb.toString()).h();
                    throw new J();
                }
            }
            if ("/".equals((Object)s)) {
                return "/";
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("/");
            sb2.append(s);
            string = sb2.toString();
            return string;
        }
        catch (final ax.b3.j j) {
            throw new J();
        }
    }
    
    public void K(final Activity activity, final Fragment fragment, final c$a c$a) {
        if (c$a != null) {
            c$a.B();
        }
        this.S0();
        T0(this.p(), activity, this.y0(), (ax.L9.c<e0>)new OneDriveFileHelper$b(this, fragment, c$a, new AtomicBoolean(false), new AtomicInteger(0)));
    }
    
    public boolean L() {
        return false;
    }
    
    public boolean M(n j) {
        try {
            final String t = ((n)j).T();
            if (!((ax.c3.b)this.k0(t, false)).n()) {
                return false;
            }
            final String b = ((n)j).B();
            j = (ax.b3.j)new OneDriveFileHelper.OneDriveFileHelper$MyDriveItem();
            ((BaseBaseItem)j).l = b;
            ((BaseDriveItem)j).x = new Folder();
            ((OneDriveFileHelper.OneDriveFileHelper$MyDriveItem)j).U = "fail";
            ((r)((ax.O9.s)((y)this.E0(t, false)).b()).a()).b((DriveItem)j);
            return true;
        }
        catch (final ax.b3.j j) {}
        catch (final d d) {}
        ((Throwable)j).printStackTrace();
        return false;
    }
    
    public boolean N(n j) {
        try {
            final String t = ((n)j).T();
            final String b = ((n)j).B();
            j = (ax.b3.j)new ax.S9.d("@microsoft.graph.conflictBehavior", (Object)"fail");
            ((ax.O9.B)((C)((y)((ax.O9.s)((y)this.E0(t, false)).b()).e(Uri.encode(b))).k()).c(Collections.singletonList((Object)j))).i((byte[])null);
            return true;
        }
        catch (final ax.b3.j j) {}
        catch (final d d) {}
        ((Throwable)j).printStackTrace();
        return false;
    }
    
    String N0(final HashMap<String, String> hashMap, final DriveItem driveItem) throws ax.b3.j, J {
        final ItemReference m = ((BaseBaseItem)driveItem).m;
        if ((m == null || ((BaseItemReference)m).e == null) && ((BaseBaseItem)driveItem).l.equals((Object)"root")) {
            return "/";
        }
        if (((BaseBaseItem)driveItem).m == null) {
            b.e("this case is not implemented yet");
            final StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(((BaseBaseItem)driveItem).l);
            return sb.toString();
        }
        if (this.Q0(driveItem)) {
            final ItemReference i = ((BaseBaseItem)driveItem).m;
            String s;
            if ((s = ((BaseItemReference)i).g) == null) {
                if (hashMap != null) {
                    if ((s = (String)hashMap.get((Object)((BaseItemReference)i).e)) == null) {
                        s = this.U0(((BaseItemReference)((BaseBaseItem)driveItem).m).c, ((BaseEntity)driveItem).c);
                        hashMap.put((Object)((BaseItemReference)((BaseBaseItem)driveItem).m).e, (Object)s);
                    }
                }
                else {
                    s = this.U0(((BaseItemReference)i).c, ((BaseEntity)driveItem).c);
                }
            }
            if (s == null) {
                b.e("this case is not implemented yet");
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("/");
                sb2.append(((BaseBaseItem)driveItem).l);
                return sb2.toString();
            }
            final String decode = Uri.decode(s.substring(s.indexOf("/root:") + 6));
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(decode);
            sb3.append("/");
            sb3.append(((BaseBaseItem)driveItem).l);
            return sb3.toString();
        }
        else {
            final String g = ((BaseItemReference)((BaseBaseItem)driveItem).m).g;
            if (g != null && g.startsWith("/drives")) {
                final int index = ((BaseItemReference)((BaseBaseItem)driveItem).m).g.indexOf(":");
                final String j0 = this.J0(((BaseItemReference)((BaseBaseItem)driveItem).m).g.substring(0, index));
                final String substring = ((BaseItemReference)((BaseBaseItem)driveItem).m).g.substring(index + 1);
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(j0);
                sb4.append(substring);
                sb4.append("/");
                sb4.append(((BaseBaseItem)driveItem).l);
                return sb4.toString();
            }
            final ItemReference k = ((BaseBaseItem)driveItem).m;
            if (((BaseItemReference)k).g == null && ((BaseItemReference)k).e == null && !this.I0().equals((Object)((BaseItemReference)((BaseBaseItem)driveItem).m).c)) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("/drives/");
                sb5.append(((BaseItemReference)((BaseBaseItem)driveItem).m).c);
                sb5.append("/items/");
                sb5.append(((BaseEntity)driveItem).c);
                return this.J0(sb5.toString());
            }
            b.e("this case is not implemented yet");
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("/");
            sb6.append(((BaseBaseItem)driveItem).l);
            return sb6.toString();
        }
    }
    
    public boolean O() {
        return true;
    }
    
    public void P(final n n) throws ax.b3.j {
        this.I(n);
        if (this.P0(n.E())) {
            this.W0(this.M0(n.E()));
        }
    }
    
    public boolean Q(final n n, final n n2) {
        final f p2 = n.P();
        final f p3 = f.P0;
        if (p2 != p3) {
            return false;
        }
        if (n2.P() != p3) {
            return false;
        }
        try {
            return this.A0(n.E(), false).equals((Object)this.A0(n2.E(), true));
        }
        catch (final ax.b3.j | d j | d) {
            return false;
        }
    }
    
    public boolean Y() {
        return true;
    }
    
    public boolean a() {
        return this.h.get() != null && this.k != null;
    }
    
    public void b() {
        if (this.h.get() != null) {
            final ax.K9.b b = (ax.K9.b)((ax.M9.f)this.h.get()).c();
            try {
                b.l((ax.L9.c)new OneDriveFileHelper$c(this));
                this.h.set((Object)null);
                this.k = null;
            }
            catch (final AndroidRuntimeException ex) {
                c.h().f().b("ONEDRIVE DISCONNECT").l((Throwable)ex).h();
            }
        }
    }
    
    public boolean g0() {
        return true;
    }
    
    public boolean h0() {
        return true;
    }
    
    public void j0(final n n, final G g, final String s, final long n2, final Long n3, final p p9, final boolean b, final ax.u3.c c, final i i) throws ax.b3.j, ax.b3.a {
        this.e1(n, g, s, n2, n3, b, true, c, i);
    }
    
    void m(n d, String value, final boolean b, final boolean b2, final ax.g3.h h, ax.u3.c c) throws ax.b3.j {
        if (!b2) {
            this.o((n)d, (String)value, b, b2, h, c);
            return;
        }
    Block_9_Outer:
        while (true) {
            Label_0187: {
                ArrayList list;
                DriveItem driveItem;
                try {
                    value = ((z)((A)((y)this.D0((T)d, true, true)).f((String)value)).a()).get();
                    list = new ArrayList();
                    c = (ax.u3.c)new HashMap();
                    Label_0066: {
                        d = (d)((IBaseCollectionPage)value).b().iterator();
                    }
                    while (((Iterator)d).hasNext()) {
                        driveItem = (DriveItem)((Iterator)d).next();
                        final T t = new(ax.c3.T.class)();
                        final T t3;
                        final T t2 = t3 = t;
                        final OneDriveFileHelper oneDriveFileHelper = this;
                        final DriveItem driveItem2 = driveItem;
                        final OneDriveFileHelper oneDriveFileHelper2 = this;
                        final ax.u3.c c2 = c;
                        final DriveItem driveItem3 = driveItem;
                        final String s = oneDriveFileHelper2.N0((HashMap<String, String>)c2, driveItem3);
                        new T(oneDriveFileHelper, driveItem2, s);
                        final Object o = list;
                        final T t4 = t2;
                        ((List)o).add((Object)t4);
                    }
                    break Label_0187;
                }
                catch (final d d) {
                    break Label_0187;
                }
                try {
                    final T t = new(ax.c3.T.class)();
                    final T t3;
                    final T t2 = t3 = t;
                    final OneDriveFileHelper oneDriveFileHelper = this;
                    final DriveItem driveItem2 = driveItem;
                    final OneDriveFileHelper oneDriveFileHelper2 = this;
                    final ax.u3.c c2 = c;
                    final DriveItem driveItem3 = driveItem;
                    final String s = oneDriveFileHelper2.N0((HashMap<String, String>)c2, driveItem3);
                    new T(oneDriveFileHelper, driveItem2, s);
                    final Object o = list;
                    final T t4 = t2;
                    ((List)o).add((Object)t4);
                    continue Block_9_Outer;
                    Label_0168: {
                        d = null;
                    }
                    while (true) {
                        Label_0170: {
                            break Label_0170;
                            throw this.u0("search", d);
                            h.Y((List)list, true);
                            return;
                            iftrue(Label_0168:)(((IBaseCollectionPage)value).a() == null);
                            d = (d)((z)((A)((IBaseCollectionPage)value).a()).a()).get();
                        }
                        value = d;
                        iftrue(Label_0066:)(d != null);
                        continue;
                    }
                }
                catch (final J j) {
                    continue;
                }
            }
            break;
        }
    }
    
    public String w0(String substring) {
        b.c(substring.startsWith("/drives/"));
        substring = substring.substring(8);
        return substring.substring(0, substring.indexOf("/"));
    }
    
    public String x0(final String s) {
        final int index = s.indexOf("/items/");
        if (index < 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("invalid path:");
            sb.append(s);
            b.g(sb.toString());
            return "";
        }
        return s.substring(index + 7);
    }
    
    public k0 y() throws ax.b3.j {
        try {
            final Drive value = ((D)((ax.O9.E)this.K0()).a()).get();
            if (value != null) {
                final Quota u = ((BaseDrive)value).u;
                if (u != null) {
                    final Long f = ((BaseQuota)u).f;
                    if (f != null) {
                        if (((BaseQuota)u).d != null) {
                            return new k0((long)f, ((BaseQuota)((BaseDrive)value).u).f - ((BaseQuota)((BaseDrive)value).u).d);
                        }
                    }
                }
            }
        }
        catch (final d d) {
            throw this.u0("getStorageSpace", d);
        }
        return null;
    }
    
    public n z(final String s) throws ax.b3.j {
        return (n)this.k0(s, true);
    }
    
    public static class j extends com.alphainventor.filemanager.file.T
    {
        private Context a;
        c0 b;
        
        public j(final Context a) {
            this.a = a;
            this.b = new c0(f.P0);
        }
        
        public void a(final int n) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("OneDrivePrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("version_");
            sb.append(n);
            final SharedPreferences$Editor remove = edit.remove(sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("refresh_token_");
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
            final SharedPreferences$Editor remove6 = remove5.remove(sb6.toString());
            final StringBuilder sb7 = new StringBuilder();
            sb7.append("email_");
            sb7.append(n);
            remove6.remove(sb7.toString()).commit();
        }
        
        public ax.Z2.s f(final int n) {
            final SharedPreferences sharedPreferences = this.a.getSharedPreferences("OneDrivePrefs", 0);
            final StringBuilder sb = new StringBuilder();
            sb.append("display_name_");
            sb.append(n);
            String string = sharedPreferences.getString(sb.toString(), (String)null);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("email_");
            sb2.append(n);
            final String string2 = sharedPreferences.getString(sb2.toString(), (String)null);
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                string = string2;
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("location_name_");
            sb3.append(n);
            final String string3 = sb3.toString();
            final f p = f.P0;
            final String string4 = sharedPreferences.getString(string3, p.M(this.a));
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("created_");
            sb4.append(n);
            final long long1 = sharedPreferences.getLong(sb4.toString(), 0L);
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("sortindex_");
            sb5.append(n);
            return new ax.Z2.s(p, n, string4, string, (String)null, (String)null, long1, sharedPreferences.getLong(sb5.toString(), 0L));
        }
        
        public void g(final int n, final String s) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("OneDrivePrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("location_name_");
            sb.append(n);
            edit.putString(sb.toString(), s);
            edit.commit();
        }
        
        public void j(final int n, final long n2) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("OneDrivePrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("sortindex_");
            sb.append(n);
            edit.putLong(sb.toString(), n2);
            edit.apply();
        }
        
        public void k(final Activity activity, final k k) {
            k.b(f.P0);
            X0(this.a);
            T0(this.a, activity, null, (ax.L9.c<e0>)new ax.L9.c<e0>(this, k) {
                final k a;
                final j b;
                
                public void b(final d d) {
                    if (this.a != null) {
                        ax.u3.B.a0((Runnable)new Runnable(this) {
                            final OneDriveFileHelper$j$a q;
                            
                            public void run() {
                                this.q.a.a(f.P0, "", 0, "", (String)null);
                            }
                        });
                    }
                }
                
                public void d(final e0 e0) {
                    final String f = ((ax.K9.b)((ax.M9.f)e0).c()).f();
                    final int l = this.b.l();
                    this.b.n(l, f, "", "");
                    if (this.a != null) {
                        ax.u3.B.a0((Runnable)new OneDriveFileHelper$j$a$a(this, l));
                    }
                }
            });
        }
        
        int l() {
            return this.a.getSharedPreferences("OneDrivePrefs", 0).getInt("count", 0);
        }
        
        public List<ax.Z2.s> m() {
            final ArrayList list = new ArrayList();
            final Context a = this.a;
            int i = 0;
            for (SharedPreferences sharedPreferences = a.getSharedPreferences("OneDrivePrefs", 0); i < sharedPreferences.getInt("count", 0); ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("refresh_token_");
                sb.append(i);
                if (sharedPreferences.getString(sb.toString(), (String)null) != null) {
                    ((List)list).add((Object)this.f(i));
                }
            }
            return (List<ax.Z2.s>)list;
        }
        
        void n(final int n, final String s, final String s2, final String s3) {
            final Context a = this.a;
            boolean b = false;
            final SharedPreferences sharedPreferences = a.getSharedPreferences("OneDrivePrefs", 0);
            if (n >= sharedPreferences.getInt("count", 0)) {
                b = true;
            }
            final SharedPreferences$Editor edit = sharedPreferences.edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("version_");
            sb.append(n);
            final SharedPreferences$Editor putInt = edit.putInt(sb.toString(), 3);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("refresh_token_");
            sb2.append(n);
            final String string = sb2.toString();
            final c0 b2 = this.b;
            final a a2 = ax.Y2.a.a();
            final f p4 = f.P0;
            final SharedPreferences$Editor putString = putInt.putString(string, b2.e(a2.b(p4), s));
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("display_name_");
            sb3.append(n);
            final SharedPreferences$Editor putString2 = putString.putString(sb3.toString(), s2);
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("email_");
            sb4.append(n);
            final SharedPreferences$Editor putString3 = putString2.putString(sb4.toString(), s3);
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("location_name_");
            sb5.append(n);
            putString3.putString(sb5.toString(), p4.M(this.a));
            if (b) {
                final StringBuilder sb6 = new StringBuilder();
                sb6.append("created_");
                sb6.append(n);
                edit.putLong(sb6.toString(), System.currentTimeMillis());
                final StringBuilder sb7 = new StringBuilder();
                sb7.append("sortindex_");
                sb7.append(n);
                edit.putLong(sb7.toString(), System.currentTimeMillis());
            }
            if (b) {
                edit.putInt("count", n + 1);
            }
            edit.commit();
        }
    }
}
