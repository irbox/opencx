package com.alphainventor.filemanager.service;

import ax.c3.M;
import ax.X2.Q;
import android.net.Uri;
import ax.Ha.c;
import android.os.SystemClock;
import android.media.MediaScannerConnection;
import java.util.List;
import android.media.MediaScannerConnection$MediaScannerConnectionClient;
import ax.u3.q$e;
import java.util.concurrent.CountDownLatch;
import ax.u3.q;
import ax.Q2.d;
import android.os.Parcelable;
import java.util.Arrays;
import ax.o3.f;
import ax.s3.u;
import ax.u3.C;
import android.content.Context;
import ax.Q2.b;
import android.os.IBinder;
import android.content.Intent;
import ax.Q2.g;
import android.os.Handler;
import java.util.HashMap;
import java.util.logging.Logger;
import android.app.Service;

public class ScanService extends Service
{
    private static final Logger e;
    private int a;
    private HashMap<Integer, Boolean> b;
    private Handler c;
    private long d;
    
    static {
        e = g.a((Class)ScanService.class);
    }
    
    public ScanService() {
        this.b = (HashMap<Integer, Boolean>)new HashMap();
        this.c = new Handler();
    }
    
    public IBinder onBind(final Intent intent) {
        return null;
    }
    
    public void onCreate() {
        ax.Q2.b.f((Context)this, true);
        super.onCreate();
        this.a = C.a((Context)this, 600000L, "ScanService");
        this.d = System.currentTimeMillis();
    }
    
    public void onDestroy() {
        this.stopForeground(true);
        u.j((Context)this).a(401);
        C.d(this.a);
        super.onDestroy();
    }
    
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        try {
            this.startForeground(401, u.j((Context)this).g((Service)this));
        }
        catch (final IllegalStateException ex) {}
        if (intent == null) {
            this.stopSelf();
            return 2;
        }
        Label_0116: {
            Parcelable[] parcelableArrayExtra;
            try {
                parcelableArrayExtra = intent.getParcelableArrayExtra("PENDING_SCAN_ARRAY");
                if (parcelableArrayExtra == null) {
                    this.stopSelf();
                    return 2;
                }
            }
            catch (final Exception ex2) {
                break Label_0116;
            }
            final f[] array = (f[])Arrays.copyOf((Object[])parcelableArrayExtra, parcelableArrayExtra.length, (Class)f[].class);
            this.b.put((Object)n2, (Object)intent.getBooleanExtra("HAS_FOLLOWING_LIST", false));
            new b((Context)this, array, n2).h((Object[])new Void[0]);
            return 3;
        }
        ax.u3.b.e("pending scan array parcelable error");
        final Exception ex2;
        ((Throwable)ex2).printStackTrace();
        this.stopSelf();
        return 2;
    }
    
    public void onTimeout(final int n, final int n2) {
        super.onTimeout(n, n2);
        final StringBuilder sb = new StringBuilder();
        sb.append("ScanServiceTimeout :");
        sb.append(System.currentTimeMillis() - this.d);
        ax.Q2.d.c("Scan service timeout", (Throwable)new Exception(sb.toString()));
        ax.o3.g.a(this, 1);
    }
    
    static class a
    {
        String a;
        boolean b;
        boolean c;
        
        a(final String a, final boolean b, final boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    class b extends q<Void, Void, Void>
    {
        f[] h;
        Context i;
        int j;
        final CountDownLatch k;
        final CountDownLatch l;
        long m;
        final ScanService n;
        
        b(final ScanService n, final Context i, final f[] h, final int j) {
            this.n = n;
            super(q$e.j0);
            this.k = new CountDownLatch(1);
            this.l = new CountDownLatch(1);
            this.i = i;
            this.h = h;
            this.j = j;
        }
        
        protected Void w(final Void... p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: dup            
            //     4: aload_0        
            //     5: getfield        com/alphainventor/filemanager/service/ScanService$b.h:[Lax/o3/f;
            //     8: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
            //    11: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
            //    14: astore_1       
            //    15: aload_0        
            //    16: getfield        com/alphainventor/filemanager/service/ScanService$b.i:Landroid/content/Context;
            //    19: aload_1        
            //    20: aconst_null    
            //    21: invokestatic    ax/c3/M.b:(Landroid/content/Context;Ljava/util/List;Lax/g3/i;)V
            //    24: aload_0        
            //    25: getfield        com/alphainventor/filemanager/service/ScanService$b.i:Landroid/content/Context;
            //    28: astore          7
            //    30: iconst_0       
            //    31: istore_2       
            //    32: aload           7
            //    34: aload_1        
            //    35: iconst_0       
            //    36: aconst_null    
            //    37: invokestatic    ax/c3/M.c:(Landroid/content/Context;Ljava/util/List;ZLax/g3/i;)I
            //    40: pop            
            //    41: new             Ljava/util/ArrayList;
            //    44: dup            
            //    45: invokespecial   java/util/ArrayList.<init>:()V
            //    48: astore          7
            //    50: aload_1        
            //    51: invokevirtual   java/util/ArrayList.size:()I
            //    54: istore          4
            //    56: iload_2        
            //    57: iload           4
            //    59: if_icmpge       133
            //    62: aload_1        
            //    63: iload_2        
            //    64: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
            //    67: astore          8
            //    69: iload_2        
            //    70: iconst_1       
            //    71: iadd           
            //    72: istore_3       
            //    73: aload           8
            //    75: checkcast       Lax/o3/f;
            //    78: astore          8
            //    80: iload_3        
            //    81: istore_2       
            //    82: aload           8
            //    84: getfield        ax/o3/f.q:Z
            //    87: ifne            56
            //    90: iload_3        
            //    91: istore_2       
            //    92: aload           8
            //    94: getfield        ax/o3/f.m0:Z
            //    97: ifeq            56
            //   100: aload           7
            //   102: new             Lcom/alphainventor/filemanager/service/ScanService$a;
            //   105: dup            
            //   106: aload           8
            //   108: getfield        ax/o3/f.c0:Ljava/lang/String;
            //   111: aload           8
            //   113: getfield        ax/o3/f.d0:Z
            //   116: aload           8
            //   118: getfield        ax/o3/f.e0:Z
            //   121: invokespecial   com/alphainventor/filemanager/service/ScanService$a.<init>:(Ljava/lang/String;ZZ)V
            //   124: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
            //   127: pop            
            //   128: iload_3        
            //   129: istore_2       
            //   130: goto            56
            //   133: aload           7
            //   135: invokevirtual   java/util/ArrayList.size:()I
            //   138: ifle            231
            //   141: new             Lcom/alphainventor/filemanager/service/ScanService$b$b;
            //   144: dup            
            //   145: aload_0        
            //   146: aload           7
            //   148: invokespecial   com/alphainventor/filemanager/service/ScanService$b$b.<init>:(Lcom/alphainventor/filemanager/service/ScanService$b;Ljava/util/List;)V
            //   151: astore_1       
            //   152: new             Landroid/media/MediaScannerConnection;
            //   155: dup            
            //   156: aload_0        
            //   157: getfield        com/alphainventor/filemanager/service/ScanService$b.n:Lcom/alphainventor/filemanager/service/ScanService;
            //   160: invokevirtual   android/content/Context.getApplicationContext:()Landroid/content/Context;
            //   163: aload_1        
            //   164: invokespecial   android/media/MediaScannerConnection.<init>:(Landroid/content/Context;Landroid/media/MediaScannerConnection$MediaScannerConnectionClient;)V
            //   167: astore          7
            //   169: aload_1        
            //   170: aload           7
            //   172: putfield        com/alphainventor/filemanager/service/ScanService$b$b.b:Landroid/media/MediaScannerConnection;
            //   175: aload           7
            //   177: invokevirtual   android/media/MediaScannerConnection.connect:()V
            //   180: aload_0        
            //   181: invokestatic    android/os/SystemClock.uptimeMillis:()J
            //   184: putfield        com/alphainventor/filemanager/service/ScanService$b.m:J
            //   187: invokestatic    ax/X2/Q.S:()Z
            //   190: ifeq            201
            //   193: ldc2_w          7
            //   196: lstore          5
            //   198: goto            206
            //   201: ldc2_w          25
            //   204: lstore          5
            //   206: aload_0        
            //   207: getfield        com/alphainventor/filemanager/service/ScanService$b.k:Ljava/util/concurrent/CountDownLatch;
            //   210: lload           5
            //   212: getstatic       java/util/concurrent/TimeUnit.SECONDS:Ljava/util/concurrent/TimeUnit;
            //   215: invokevirtual   java/util/concurrent/CountDownLatch.await:(JLjava/util/concurrent/TimeUnit;)Z
            //   218: ifne            238
            //   221: aload_0        
            //   222: getfield        com/alphainventor/filemanager/service/ScanService$b.l:Ljava/util/concurrent/CountDownLatch;
            //   225: invokevirtual   java/util/concurrent/CountDownLatch.countDown:()V
            //   228: goto            238
            //   231: aload_0        
            //   232: getfield        com/alphainventor/filemanager/service/ScanService$b.l:Ljava/util/concurrent/CountDownLatch;
            //   235: invokevirtual   java/util/concurrent/CountDownLatch.countDown:()V
            //   238: aload_0        
            //   239: getfield        com/alphainventor/filemanager/service/ScanService$b.l:Ljava/util/concurrent/CountDownLatch;
            //   242: ldc2_w          300
            //   245: getstatic       java/util/concurrent/TimeUnit.SECONDS:Ljava/util/concurrent/TimeUnit;
            //   248: invokevirtual   java/util/concurrent/CountDownLatch.await:(JLjava/util/concurrent/TimeUnit;)Z
            //   251: pop            
            //   252: aconst_null    
            //   253: areturn        
            //   254: astore_1       
            //   255: goto            238
            //   258: astore_1       
            //   259: goto            252
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                            
            //  -----  -----  -----  -----  --------------------------------
            //  187    193    254    258    Ljava/lang/InterruptedException;
            //  206    228    254    258    Ljava/lang/InterruptedException;
            //  238    252    258    262    Ljava/lang/InterruptedException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0238:
            //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
            //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
            //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
            //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
            //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:799)
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
        
        protected void x(final Void void1) {
            final Boolean b = (Boolean)this.n.b.get((Object)this.j);
            if (b != null && !b) {
                this.n.stopSelf(this.j);
                return;
            }
            this.n.c.postDelayed((Runnable)new Runnable(this) {
                final ScanService.b q;
                
                public void run() {
                    final ScanService.b q = this.q;
                    q.n.stopSelf(q.j);
                }
            }, 1000L);
        }
        
        class b implements MediaScannerConnection$MediaScannerConnectionClient
        {
            final List<a> a;
            MediaScannerConnection b;
            int c;
            a d;
            final ScanService.b e;
            
            b(final ScanService.b e, final List<a> a) {
                this.e = e;
                this.a = a;
            }
            
            void a() {
                if (this.c >= this.a.size()) {
                    this.b.disconnect();
                    this.e.l.countDown();
                    return;
                }
                final a d = (a)this.a.get(this.c);
                this.d = d;
                this.b.scanFile(d.a, (String)null);
                ++this.c;
            }
            
            public void onMediaScannerConnected() {
                if (!this.b.isConnected()) {
                    return;
                }
                if (this.e.l.getCount() == 0L) {
                    final long n = (SystemClock.uptimeMillis() - this.e.m) / 1000L;
                    final ax.Ha.b b = ax.Ha.c.h().f().b("MediaScanner connected after timeout");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("delay:");
                    sb.append(n);
                    b.g((Object)sb.toString()).h();
                }
                this.e.k.countDown();
                this.a();
            }
            
            public void onScanCompleted(final String s, final Uri uri) {
                if (Q.g0() && s != null && uri != null) {
                    final a d = this.d;
                    if (d != null && d.b && s.equals((Object)d.a)) {
                        M.l(this.e.i, uri);
                    }
                }
                this.a();
            }
        }
    }
}
