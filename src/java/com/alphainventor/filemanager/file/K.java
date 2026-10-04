package com.alphainventor.filemanager.file;

import java.lang.ref.Reference;
import ax.p4.r;
import java.util.Map;
import ax.u3.q$e;
import android.content.SharedPreferences$Editor;
import java.lang.ref.WeakReference;
import android.text.TextUtils;
import ax.u3.q$f;
import ax.c3.k0;
import ax.G4.Q;
import ax.G4.j0;
import ax.G4.i0;
import ax.G4.e0;
import ax.G4.f0;
import android.content.SharedPreferences;
import ax.c3.c0;
import androidx.fragment.app.Fragment;
import ax.c3.B;
import ax.G4.Z;
import java.util.Iterator;
import ax.G4.L;
import ax.G4.P;
import java.util.ArrayList;
import ax.c3.d0;
import java.util.List;
import ax.G4.s0;
import ax.G4.q0;
import java.io.InputStream;
import ax.s4.b;
import ax.G4.M;
import ax.G4.h;
import ax.G4.J;
import ax.G4.W;
import ax.G4.v0;
import ax.G4.K;
import ax.G4.X;
import ax.G4.w0;
import ax.G4.p;
import ax.p4.d;
import ax.b3.q;
import ax.p4.t;
import ax.b3.o;
import ax.b3.e;
import ax.b3.s;
import ax.G4.S0;
import ax.b3.j;
import ax.g3.i;
import ax.c3.G;
import ax.Ha.c;
import ax.Q2.f;
import ax.c3.g;
import android.content.Context;
import android.app.Activity;
import java.util.Collection;
import java.util.Arrays;
import ax.x4.a;
import java.util.HashSet;
import java.util.logging.Logger;

public class k extends m
{
    private static final Logger o;
    static a p;
    static final HashSet<String> q;
    private ax.x4.a h;
    private b i;
    private c$a j;
    private boolean k;
    private boolean l;
    private String m;
    private boolean n;
    
    static {
        o = Logger.getLogger("FileManager.DropboxFileHelper");
        q = new HashSet((Collection)Arrays.asList((Object[])new String[] { "jpg", "jpeg", "png", "tiff", "tif", "gif", "webp", "ppm", "bmp", "svg", "heic", "cr2", "crw", "nef", "nrw", "sr2", "dng", "arw", "orf", "mp4", "m4v", "3gp", "3gpp", "3gpp2", "webm", "mkv", "wmv", "avi", "mpg", "mpeg", "mov", "asf", "ogv", "ts", "mts", "vob", "pdf" }));
    }
    
    private static boolean C0(final Activity activity) {
        t0((Context)activity);
        try {
            com.dropbox.core.android.a.b((Context)activity, g.c((Context)activity).a(f.N0), v0());
            return true;
        }
        catch (final IllegalStateException ex) {
            ax.Ha.c.h().d("Dropbox OAuth Error").l((Throwable)ex).h();
            return false;
        }
    }
    
    private void D0(final ax.x4.a p0, final G p1, final long p2, final Long p3, final String p4, final boolean p5, final ax.u3.c p6, final i p7) throws j, ax.b3.a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   ax/c3/G.a:()Z
        //     4: ifeq            13
        //     7: iconst_2       
        //     8: istore          10
        //    10: goto            16
        //    13: iconst_1       
        //    14: istore          10
        //    16: aconst_null    
        //    17: astore          12
        //    19: iconst_0       
        //    20: istore          11
        //    22: iload           11
        //    24: iload           10
        //    26: if_icmpge       281
        //    29: new             Lax/c3/e0;
        //    32: dup            
        //    33: aload_2        
        //    34: invokevirtual   ax/c3/G.b:()Ljava/io/InputStream;
        //    37: lconst_0       
        //    38: lload_3        
        //    39: aload           8
        //    41: aload           9
        //    43: invokespecial   ax/c3/e0.<init>:(Ljava/io/InputStream;JJLax/u3/c;Lax/g3/i;)V
        //    46: astore          13
        //    48: aload_1        
        //    49: invokevirtual   ax/x4/b.a:()Lax/G4/f;
        //    52: astore          12
        //    54: aload           12
        //    56: aload           6
        //    58: invokevirtual   ax/G4/f.v:(Ljava/lang/String;)Lax/G4/u0;
        //    61: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    64: invokevirtual   ax/G4/u0.e:(Ljava/lang/Boolean;)Lax/G4/u0;
        //    67: astore          12
        //    69: iload           7
        //    71: ifeq            112
        //    74: aload           12
        //    76: getstatic       ax/G4/T0.d:Lax/G4/T0;
        //    79: invokevirtual   ax/G4/u0.g:(Lax/G4/T0;)Lax/G4/u0;
        //    82: pop            
        //    83: goto            121
        //    86: astore_1       
        //    87: goto            274
        //    90: astore_1       
        //    91: goto            199
        //    94: astore_1       
        //    95: goto            225
        //    98: astore_1       
        //    99: goto            234
        //   102: astore          12
        //   104: goto            245
        //   107: astore          12
        //   109: goto            260
        //   112: aload           12
        //   114: getstatic       ax/G4/T0.c:Lax/G4/T0;
        //   117: invokevirtual   ax/G4/u0.g:(Lax/G4/T0;)Lax/G4/u0;
        //   120: pop            
        //   121: aload           5
        //   123: ifnull          159
        //   126: aload           5
        //   128: invokevirtual   java/lang/Long.longValue:()J
        //   131: lconst_0       
        //   132: lcmp           
        //   133: ifle            159
        //   136: new             Ljava/util/Date;
        //   139: astore          14
        //   141: aload           14
        //   143: aload           5
        //   145: invokevirtual   java/lang/Long.longValue:()J
        //   148: invokespecial   java/util/Date.<init>:(J)V
        //   151: aload           12
        //   153: aload           14
        //   155: invokevirtual   ax/G4/u0.f:(Ljava/util/Date;)Lax/G4/u0;
        //   158: pop            
        //   159: lload_3        
        //   160: lconst_0       
        //   161: lcmp           
        //   162: iflt            181
        //   165: aload           12
        //   167: aload           13
        //   169: lload_3        
        //   170: invokevirtual   ax/x4/e.c:(Ljava/io/InputStream;J)Ljava/lang/Object;
        //   173: checkcast       Lax/G4/t;
        //   176: astore          12
        //   178: goto            193
        //   181: aload           12
        //   183: aload           13
        //   185: invokevirtual   ax/x4/e.b:(Ljava/io/InputStream;)Ljava/lang/Object;
        //   188: checkcast       Lax/G4/t;
        //   191: astore          12
        //   193: aload           13
        //   195: invokevirtual   java/io/InputStream.close:()V
        //   198: return         
        //   199: aload_1        
        //   200: invokevirtual   java/lang/Throwable.getCause:()Ljava/lang/Throwable;
        //   203: instanceof      Lax/b3/a;
        //   206: ifeq            217
        //   209: aload_1        
        //   210: invokevirtual   java/lang/Throwable.getCause:()Ljava/lang/Throwable;
        //   213: checkcast       Lax/b3/a;
        //   216: athrow         
        //   217: ldc_w           "dropbox uploadfile"
        //   220: aload_1        
        //   221: invokestatic    ax/b3/d.b:(Ljava/lang/String;Ljava/lang/Exception;)Lax/b3/j;
        //   224: athrow         
        //   225: aload_0        
        //   226: ldc_w           "dropbox uploadfile"
        //   229: aload_1        
        //   230: invokespecial   com/alphainventor/filemanager/file/k.p0:(Ljava/lang/String;Lax/p4/j;)Lax/b3/j;
        //   233: athrow         
        //   234: aload_0        
        //   235: ldc_w           "upload"
        //   238: aload_1        
        //   239: invokespecial   com/alphainventor/filemanager/file/k.p0:(Ljava/lang/String;Lax/p4/j;)Lax/b3/j;
        //   242: athrow         
        //   243: astore          12
        //   245: aload           12
        //   247: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   250: aload           13
        //   252: invokevirtual   java/io/InputStream.close:()V
        //   255: goto            268
        //   258: astore          12
        //   260: aload           12
        //   262: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   265: goto            250
        //   268: iinc            11, 1
        //   271: goto            22
        //   274: aload           13
        //   276: invokevirtual   java/io/InputStream.close:()V
        //   279: aload_1        
        //   280: athrow         
        //   281: ldc_w           "Maxed out upload attempts to Dropbox"
        //   284: aload           12
        //   286: invokestatic    ax/b3/d.b:(Ljava/lang/String;Ljava/lang/Exception;)Lax/b3/j;
        //   289: athrow         
        //   290: astore_1       
        //   291: goto            198
        //   294: astore          13
        //   296: goto            268
        //   299: astore_2       
        //   300: goto            279
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  48     54     258    260    Lax/p4/x;
        //  48     54     243    245    Lax/p4/t;
        //  48     54     98     102    Lax/G4/w0;
        //  48     54     94     98     Lax/p4/j;
        //  48     54     90     225    Ljava/io/IOException;
        //  48     54     86     281    Any
        //  54     69     107    112    Lax/p4/x;
        //  54     69     102    107    Lax/p4/t;
        //  54     69     98     102    Lax/G4/w0;
        //  54     69     94     98     Lax/p4/j;
        //  54     69     90     225    Ljava/io/IOException;
        //  54     69     86     281    Any
        //  74     83     107    112    Lax/p4/x;
        //  74     83     102    107    Lax/p4/t;
        //  74     83     98     102    Lax/G4/w0;
        //  74     83     94     98     Lax/p4/j;
        //  74     83     90     225    Ljava/io/IOException;
        //  74     83     86     281    Any
        //  112    121    107    112    Lax/p4/x;
        //  112    121    102    107    Lax/p4/t;
        //  112    121    98     102    Lax/G4/w0;
        //  112    121    94     98     Lax/p4/j;
        //  112    121    90     225    Ljava/io/IOException;
        //  112    121    86     281    Any
        //  126    159    107    112    Lax/p4/x;
        //  126    159    102    107    Lax/p4/t;
        //  126    159    98     102    Lax/G4/w0;
        //  126    159    94     98     Lax/p4/j;
        //  126    159    90     225    Ljava/io/IOException;
        //  126    159    86     281    Any
        //  165    178    107    112    Lax/p4/x;
        //  165    178    102    107    Lax/p4/t;
        //  165    178    98     102    Lax/G4/w0;
        //  165    178    94     98     Lax/p4/j;
        //  165    178    90     225    Ljava/io/IOException;
        //  165    178    86     281    Any
        //  181    193    107    112    Lax/p4/x;
        //  181    193    102    107    Lax/p4/t;
        //  181    193    98     102    Lax/G4/w0;
        //  181    193    94     98     Lax/p4/j;
        //  181    193    90     225    Ljava/io/IOException;
        //  181    193    86     281    Any
        //  193    198    290    294    Ljava/io/IOException;
        //  199    217    86     281    Any
        //  217    225    86     281    Any
        //  225    234    86     281    Any
        //  234    243    86     281    Any
        //  245    250    86     281    Any
        //  250    255    294    299    Ljava/io/IOException;
        //  260    265    86     281    Any
        //  274    279    299    303    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 141 out of bounds for length 141
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
    
    private j E0(final String s, final ax.p4.j j, final S0 s2) {
        if (s2.e()) {
            return (j)new s(s, (Throwable)j);
        }
        if (s2.f()) {
            return (j)new e(s, (Throwable)j);
        }
        if (s2.d()) {
            return (j)new o(s, (Throwable)j);
        }
        return null;
    }
    
    private void o0(final ax.x4.a p0, final G p1, final long p2, final Long p3, final String p4, final boolean p5, final ax.u3.c p6, final i p7) throws j, ax.b3.a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc2_w          4194304
        //     4: lcmp           
        //     5: ifge            15
        //     8: ldc_w           "File too small, use upload() instead."
        //    11: invokestatic    ax/u3/b.g:(Ljava/lang/String;)V
        //    14: return         
        //    15: aload_2        
        //    16: invokevirtual   ax/c3/G.a:()Z
        //    19: istore          12
        //    21: iload           12
        //    23: ifeq            32
        //    26: iconst_5       
        //    27: istore          10
        //    29: goto            35
        //    32: iconst_1       
        //    33: istore          10
        //    35: aconst_null    
        //    36: astore          22
        //    38: aconst_null    
        //    39: astore          21
        //    41: lconst_0       
        //    42: lstore          19
        //    44: iconst_0       
        //    45: istore          11
        //    47: iload           11
        //    49: iload           10
        //    51: if_icmpge       1019
        //    54: iload           12
        //    56: ifeq            91
        //    59: lload           19
        //    61: lconst_0       
        //    62: lcmp           
        //    63: ifle            91
        //    66: new             Lax/c3/e0;
        //    69: dup            
        //    70: aload_2        
        //    71: lload           19
        //    73: invokevirtual   ax/c3/G.c:(J)Ljava/io/InputStream;
        //    76: lload           19
        //    78: lload_3        
        //    79: aload           8
        //    81: aload           9
        //    83: invokespecial   ax/c3/e0.<init>:(Ljava/io/InputStream;JJLax/u3/c;Lax/g3/i;)V
        //    86: astore          26
        //    88: goto            110
        //    91: new             Lax/c3/e0;
        //    94: dup            
        //    95: aload_2        
        //    96: invokevirtual   ax/c3/G.b:()Ljava/io/InputStream;
        //    99: lconst_0       
        //   100: lload_3        
        //   101: aload           8
        //   103: aload           9
        //   105: invokespecial   ax/c3/e0.<init>:(Ljava/io/InputStream;JJLax/u3/c;Lax/g3/i;)V
        //   108: astore          26
        //   110: aload           21
        //   112: astore          22
        //   114: lload           19
        //   116: lstore          17
        //   118: aload           21
        //   120: ifnonnull       217
        //   123: aload           21
        //   125: astore          25
        //   127: aload           21
        //   129: astore          23
        //   131: aload           21
        //   133: astore          24
        //   135: lload           19
        //   137: lstore          15
        //   139: lload           19
        //   141: lstore          13
        //   143: aload_1        
        //   144: invokevirtual   ax/x4/b.a:()Lax/G4/f;
        //   147: invokevirtual   ax/G4/f.A:()Lax/G4/M0;
        //   150: aload           26
        //   152: ldc2_w          4194304
        //   155: invokevirtual   ax/p4/o.e:(Ljava/io/InputStream;J)Ljava/lang/Object;
        //   158: checkcast       Lax/G4/L0;
        //   161: invokevirtual   ax/G4/L0.a:()Ljava/lang/String;
        //   164: astore          22
        //   166: lload           19
        //   168: ldc2_w          4194304
        //   171: ladd           
        //   172: lstore          17
        //   174: goto            217
        //   177: astore_1       
        //   178: goto            997
        //   181: astore_1       
        //   182: goto            843
        //   185: astore_1       
        //   186: goto            872
        //   189: astore          21
        //   191: goto            885
        //   194: astore          21
        //   196: goto            958
        //   199: astore          22
        //   201: lload           15
        //   203: lstore          13
        //   205: aload           24
        //   207: astore          21
        //   209: goto            1004
        //   212: astore          22
        //   214: goto            209
        //   217: aload           22
        //   219: astore          25
        //   221: aload           22
        //   223: astore          23
        //   225: aload           22
        //   227: astore          24
        //   229: lload           17
        //   231: lstore          15
        //   233: aload           22
        //   235: astore          21
        //   237: lload           17
        //   239: lstore          13
        //   241: new             Lax/G4/B0;
        //   244: astore          27
        //   246: aload           22
        //   248: astore          25
        //   250: aload           22
        //   252: astore          23
        //   254: aload           22
        //   256: astore          24
        //   258: lload           17
        //   260: lstore          15
        //   262: aload           22
        //   264: astore          21
        //   266: lload           17
        //   268: lstore          13
        //   270: aload           27
        //   272: aload           22
        //   274: lload           17
        //   276: invokespecial   ax/G4/B0.<init>:(Ljava/lang/String;J)V
        //   279: lload_3        
        //   280: lload           17
        //   282: lsub           
        //   283: lstore          19
        //   285: lload           19
        //   287: ldc2_w          4194304
        //   290: lcmp           
        //   291: ifle            384
        //   294: aload           22
        //   296: astore          25
        //   298: aload           22
        //   300: astore          23
        //   302: aload           22
        //   304: astore          24
        //   306: lload           17
        //   308: lstore          15
        //   310: aload           22
        //   312: astore          21
        //   314: lload           17
        //   316: lstore          13
        //   318: aload_1        
        //   319: invokevirtual   ax/x4/b.a:()Lax/G4/f;
        //   322: aload           27
        //   324: invokevirtual   ax/G4/f.x:(Lax/G4/B0;)Lax/G4/A0;
        //   327: aload           26
        //   329: ldc2_w          4194304
        //   332: invokevirtual   ax/p4/o.e:(Ljava/io/InputStream;J)Ljava/lang/Object;
        //   335: pop            
        //   336: lload           17
        //   338: ldc2_w          4194304
        //   341: ladd           
        //   342: lstore          17
        //   344: aload           22
        //   346: astore          25
        //   348: aload           22
        //   350: astore          23
        //   352: aload           22
        //   354: astore          24
        //   356: lload           17
        //   358: lstore          15
        //   360: aload           22
        //   362: astore          21
        //   364: lload           17
        //   366: lstore          13
        //   368: new             Lax/G4/B0;
        //   371: dup            
        //   372: aload           22
        //   374: lload           17
        //   376: invokespecial   ax/G4/B0.<init>:(Ljava/lang/String;J)V
        //   379: astore          27
        //   381: goto            279
        //   384: aload           22
        //   386: astore          25
        //   388: aload           22
        //   390: astore          23
        //   392: aload           22
        //   394: astore          24
        //   396: lload           17
        //   398: lstore          15
        //   400: aload           22
        //   402: astore          21
        //   404: lload           17
        //   406: lstore          13
        //   408: aload           6
        //   410: invokestatic    ax/G4/a.a:(Ljava/lang/String;)Lax/G4/a$a;
        //   413: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   416: invokevirtual   ax/G4/a$a.b:(Ljava/lang/Boolean;)Lax/G4/a$a;
        //   419: astore          28
        //   421: iload           7
        //   423: ifeq            462
        //   426: aload           22
        //   428: astore          25
        //   430: aload           22
        //   432: astore          23
        //   434: aload           22
        //   436: astore          24
        //   438: lload           17
        //   440: lstore          15
        //   442: aload           22
        //   444: astore          21
        //   446: lload           17
        //   448: lstore          13
        //   450: aload           28
        //   452: getstatic       ax/G4/T0.d:Lax/G4/T0;
        //   455: invokevirtual   ax/G4/a$a.d:(Lax/G4/T0;)Lax/G4/a$a;
        //   458: pop            
        //   459: goto            495
        //   462: aload           22
        //   464: astore          25
        //   466: aload           22
        //   468: astore          23
        //   470: aload           22
        //   472: astore          24
        //   474: lload           17
        //   476: lstore          15
        //   478: aload           22
        //   480: astore          21
        //   482: lload           17
        //   484: lstore          13
        //   486: aload           28
        //   488: getstatic       ax/G4/T0.c:Lax/G4/T0;
        //   491: invokevirtual   ax/G4/a$a.d:(Lax/G4/T0;)Lax/G4/a$a;
        //   494: pop            
        //   495: aload           5
        //   497: ifnull          629
        //   500: aload           22
        //   502: astore          25
        //   504: aload           22
        //   506: astore          23
        //   508: aload           22
        //   510: astore          24
        //   512: lload           17
        //   514: lstore          15
        //   516: aload           22
        //   518: astore          21
        //   520: lload           17
        //   522: lstore          13
        //   524: aload           5
        //   526: invokevirtual   java/lang/Long.longValue:()J
        //   529: lconst_0       
        //   530: lcmp           
        //   531: ifle            629
        //   534: aload           22
        //   536: astore          25
        //   538: aload           22
        //   540: astore          23
        //   542: aload           22
        //   544: astore          24
        //   546: lload           17
        //   548: lstore          15
        //   550: aload           22
        //   552: astore          21
        //   554: lload           17
        //   556: lstore          13
        //   558: new             Ljava/util/Date;
        //   561: astore          29
        //   563: aload           22
        //   565: astore          25
        //   567: aload           22
        //   569: astore          23
        //   571: aload           22
        //   573: astore          24
        //   575: lload           17
        //   577: lstore          15
        //   579: aload           22
        //   581: astore          21
        //   583: lload           17
        //   585: lstore          13
        //   587: aload           29
        //   589: aload           5
        //   591: invokevirtual   java/lang/Long.longValue:()J
        //   594: invokespecial   java/util/Date.<init>:(J)V
        //   597: aload           22
        //   599: astore          25
        //   601: aload           22
        //   603: astore          23
        //   605: aload           22
        //   607: astore          24
        //   609: lload           17
        //   611: lstore          15
        //   613: aload           22
        //   615: astore          21
        //   617: lload           17
        //   619: lstore          13
        //   621: aload           28
        //   623: aload           29
        //   625: invokevirtual   ax/G4/a$a.c:(Ljava/util/Date;)Lax/G4/a$a;
        //   628: pop            
        //   629: aload           22
        //   631: astore          25
        //   633: aload           22
        //   635: astore          23
        //   637: aload           22
        //   639: astore          24
        //   641: lload           17
        //   643: lstore          15
        //   645: aload           22
        //   647: astore          21
        //   649: lload           17
        //   651: lstore          13
        //   653: aload           28
        //   655: invokevirtual   ax/G4/a$a.a:()Lax/G4/a;
        //   658: astore          28
        //   660: aload           22
        //   662: astore          25
        //   664: aload           22
        //   666: astore          23
        //   668: aload           22
        //   670: astore          24
        //   672: lload           17
        //   674: lstore          15
        //   676: aload           22
        //   678: astore          21
        //   680: lload           17
        //   682: lstore          13
        //   684: aload_1        
        //   685: invokevirtual   ax/x4/b.a:()Lax/G4/f;
        //   688: aload           27
        //   690: aload           28
        //   692: invokevirtual   ax/G4/f.y:(Lax/G4/B0;Lax/G4/a;)Lax/G4/F0;
        //   695: aload           26
        //   697: lload           19
        //   699: invokevirtual   ax/p4/o.e:(Ljava/io/InputStream;J)Ljava/lang/Object;
        //   702: checkcast       Lax/G4/t;
        //   705: astore          27
        //   707: aload           27
        //   709: ifnull          837
        //   712: aload           22
        //   714: astore          25
        //   716: aload           22
        //   718: astore          23
        //   720: aload           22
        //   722: astore          24
        //   724: lload           17
        //   726: lstore          15
        //   728: aload           22
        //   730: astore          21
        //   732: lload           17
        //   734: lstore          13
        //   736: aload           27
        //   738: invokevirtual   ax/G4/t.f:()J
        //   741: lload_3        
        //   742: lcmp           
        //   743: iflt            749
        //   746: goto            837
        //   749: aload           22
        //   751: astore          25
        //   753: aload           22
        //   755: astore          23
        //   757: aload           22
        //   759: astore          24
        //   761: lload           17
        //   763: lstore          15
        //   765: aload           22
        //   767: astore          21
        //   769: lload           17
        //   771: lstore          13
        //   773: new             Lax/b3/j;
        //   776: astore          27
        //   778: aload           22
        //   780: astore          25
        //   782: aload           22
        //   784: astore          23
        //   786: aload           22
        //   788: astore          24
        //   790: lload           17
        //   792: lstore          15
        //   794: aload           22
        //   796: astore          21
        //   798: lload           17
        //   800: lstore          13
        //   802: aload           27
        //   804: ldc_w           "The size of the uploaded file is different from the source"
        //   807: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   810: aload           22
        //   812: astore          25
        //   814: aload           22
        //   816: astore          23
        //   818: aload           22
        //   820: astore          24
        //   822: lload           17
        //   824: lstore          15
        //   826: aload           22
        //   828: astore          21
        //   830: lload           17
        //   832: lstore          13
        //   834: aload           27
        //   836: athrow         
        //   837: aload           26
        //   839: invokevirtual   java/io/InputStream.close:()V
        //   842: return         
        //   843: aload_1        
        //   844: invokevirtual   java/lang/Throwable.getCause:()Ljava/lang/Throwable;
        //   847: instanceof      Lax/b3/a;
        //   850: ifeq            861
        //   853: aload_1        
        //   854: invokevirtual   java/lang/Throwable.getCause:()Ljava/lang/Throwable;
        //   857: checkcast       Lax/b3/a;
        //   860: athrow         
        //   861: new             Lax/b3/j;
        //   864: astore_2       
        //   865: aload_2        
        //   866: aload_1        
        //   867: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   870: aload_2        
        //   871: athrow         
        //   872: aload_0        
        //   873: ldc_w           "chunk_upload"
        //   876: aload_1        
        //   877: invokespecial   com/alphainventor/filemanager/file/k.p0:(Ljava/lang/String;Lax/p4/j;)Lax/b3/j;
        //   880: athrow         
        //   881: astore_1       
        //   882: goto            997
        //   885: aload           21
        //   887: getfield        ax/G4/E0.d0:Lax/G4/D0;
        //   890: invokevirtual   ax/G4/D0.e:()Z
        //   893: ifeq            946
        //   896: aload           21
        //   898: getfield        ax/G4/E0.d0:Lax/G4/D0;
        //   901: invokevirtual   ax/G4/D0.d:()Lax/G4/G0;
        //   904: invokevirtual   ax/G4/G0.d:()Z
        //   907: ifeq            946
        //   910: aload           21
        //   912: getfield        ax/G4/E0.d0:Lax/G4/D0;
        //   915: invokevirtual   ax/G4/D0.d:()Lax/G4/G0;
        //   918: invokevirtual   ax/G4/G0.b:()Lax/G4/H0;
        //   921: invokevirtual   ax/G4/H0.a:()J
        //   924: lstore          13
        //   926: aload           25
        //   928: astore          23
        //   930: aload           26
        //   932: invokevirtual   java/io/InputStream.close:()V
        //   935: aload           21
        //   937: astore          22
        //   939: aload           23
        //   941: astore          21
        //   943: goto            1009
        //   946: new             Lax/b3/j;
        //   949: astore_1       
        //   950: aload_1        
        //   951: aload           21
        //   953: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   956: aload_1        
        //   957: athrow         
        //   958: aload           21
        //   960: getfield        ax/G4/z0.d0:Lax/G4/y0;
        //   963: invokevirtual   ax/G4/y0.d:()Z
        //   966: ifeq            985
        //   969: aload           21
        //   971: getfield        ax/G4/z0.d0:Lax/G4/y0;
        //   974: invokevirtual   ax/G4/y0.b:()Lax/G4/H0;
        //   977: invokevirtual   ax/G4/H0.a:()J
        //   980: lstore          13
        //   982: goto            930
        //   985: new             Lax/b3/j;
        //   988: astore_1       
        //   989: aload_1        
        //   990: aload           21
        //   992: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   995: aload_1        
        //   996: athrow         
        //   997: aload           26
        //   999: invokevirtual   java/io/InputStream.close:()V
        //  1002: aload_1        
        //  1003: athrow         
        //  1004: aload           26
        //  1006: invokevirtual   java/io/InputStream.close:()V
        //  1009: iinc            11, 1
        //  1012: lload           13
        //  1014: lstore          19
        //  1016: goto            47
        //  1019: ldc_w           "Maxed out upload attempts to Dropbox"
        //  1022: aload           22
        //  1024: invokestatic    ax/b3/d.b:(Ljava/lang/String;Ljava/lang/Exception;)Lax/b3/j;
        //  1027: athrow         
        //  1028: astore_1       
        //  1029: goto            842
        //  1032: astore          22
        //  1034: goto            935
        //  1037: astore_2       
        //  1038: goto            1002
        //  1041: astore          23
        //  1043: goto            1009
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  143    166    212    217    Lax/p4/x;
        //  143    166    199    209    Lax/p4/t;
        //  143    166    194    997    Lax/G4/z0;
        //  143    166    189    930    Lax/G4/E0;
        //  143    166    185    189    Lax/p4/j;
        //  143    166    181    872    Ljava/io/IOException;
        //  143    166    177    181    Any
        //  241    246    212    217    Lax/p4/x;
        //  241    246    199    209    Lax/p4/t;
        //  241    246    194    997    Lax/G4/z0;
        //  241    246    189    930    Lax/G4/E0;
        //  241    246    185    189    Lax/p4/j;
        //  241    246    181    872    Ljava/io/IOException;
        //  241    246    177    181    Any
        //  270    279    212    217    Lax/p4/x;
        //  270    279    199    209    Lax/p4/t;
        //  270    279    194    997    Lax/G4/z0;
        //  270    279    189    930    Lax/G4/E0;
        //  270    279    185    189    Lax/p4/j;
        //  270    279    181    872    Ljava/io/IOException;
        //  270    279    177    181    Any
        //  318    336    212    217    Lax/p4/x;
        //  318    336    199    209    Lax/p4/t;
        //  318    336    194    997    Lax/G4/z0;
        //  318    336    189    930    Lax/G4/E0;
        //  318    336    185    189    Lax/p4/j;
        //  318    336    181    872    Ljava/io/IOException;
        //  318    336    177    181    Any
        //  368    381    212    217    Lax/p4/x;
        //  368    381    199    209    Lax/p4/t;
        //  368    381    194    997    Lax/G4/z0;
        //  368    381    189    930    Lax/G4/E0;
        //  368    381    185    189    Lax/p4/j;
        //  368    381    181    872    Ljava/io/IOException;
        //  368    381    177    181    Any
        //  408    421    212    217    Lax/p4/x;
        //  408    421    199    209    Lax/p4/t;
        //  408    421    194    997    Lax/G4/z0;
        //  408    421    189    930    Lax/G4/E0;
        //  408    421    185    189    Lax/p4/j;
        //  408    421    181    872    Ljava/io/IOException;
        //  408    421    177    181    Any
        //  450    459    212    217    Lax/p4/x;
        //  450    459    199    209    Lax/p4/t;
        //  450    459    194    997    Lax/G4/z0;
        //  450    459    189    930    Lax/G4/E0;
        //  450    459    185    189    Lax/p4/j;
        //  450    459    181    872    Ljava/io/IOException;
        //  450    459    177    181    Any
        //  486    495    212    217    Lax/p4/x;
        //  486    495    199    209    Lax/p4/t;
        //  486    495    194    997    Lax/G4/z0;
        //  486    495    189    930    Lax/G4/E0;
        //  486    495    185    189    Lax/p4/j;
        //  486    495    181    872    Ljava/io/IOException;
        //  486    495    177    181    Any
        //  524    534    212    217    Lax/p4/x;
        //  524    534    199    209    Lax/p4/t;
        //  524    534    194    997    Lax/G4/z0;
        //  524    534    189    930    Lax/G4/E0;
        //  524    534    185    189    Lax/p4/j;
        //  524    534    181    872    Ljava/io/IOException;
        //  524    534    177    181    Any
        //  558    563    212    217    Lax/p4/x;
        //  558    563    199    209    Lax/p4/t;
        //  558    563    194    997    Lax/G4/z0;
        //  558    563    189    930    Lax/G4/E0;
        //  558    563    185    189    Lax/p4/j;
        //  558    563    181    872    Ljava/io/IOException;
        //  558    563    177    181    Any
        //  587    597    212    217    Lax/p4/x;
        //  587    597    199    209    Lax/p4/t;
        //  587    597    194    997    Lax/G4/z0;
        //  587    597    189    930    Lax/G4/E0;
        //  587    597    185    189    Lax/p4/j;
        //  587    597    181    872    Ljava/io/IOException;
        //  587    597    177    181    Any
        //  621    629    212    217    Lax/p4/x;
        //  621    629    199    209    Lax/p4/t;
        //  621    629    194    997    Lax/G4/z0;
        //  621    629    189    930    Lax/G4/E0;
        //  621    629    185    189    Lax/p4/j;
        //  621    629    181    872    Ljava/io/IOException;
        //  621    629    177    181    Any
        //  653    660    212    217    Lax/p4/x;
        //  653    660    199    209    Lax/p4/t;
        //  653    660    194    997    Lax/G4/z0;
        //  653    660    189    930    Lax/G4/E0;
        //  653    660    185    189    Lax/p4/j;
        //  653    660    181    872    Ljava/io/IOException;
        //  653    660    177    181    Any
        //  684    707    212    217    Lax/p4/x;
        //  684    707    199    209    Lax/p4/t;
        //  684    707    194    997    Lax/G4/z0;
        //  684    707    189    930    Lax/G4/E0;
        //  684    707    185    189    Lax/p4/j;
        //  684    707    181    872    Ljava/io/IOException;
        //  684    707    177    181    Any
        //  736    746    212    217    Lax/p4/x;
        //  736    746    199    209    Lax/p4/t;
        //  736    746    194    997    Lax/G4/z0;
        //  736    746    189    930    Lax/G4/E0;
        //  736    746    185    189    Lax/p4/j;
        //  736    746    181    872    Ljava/io/IOException;
        //  736    746    177    181    Any
        //  773    778    212    217    Lax/p4/x;
        //  773    778    199    209    Lax/p4/t;
        //  773    778    194    997    Lax/G4/z0;
        //  773    778    189    930    Lax/G4/E0;
        //  773    778    185    189    Lax/p4/j;
        //  773    778    181    872    Ljava/io/IOException;
        //  773    778    177    181    Any
        //  802    810    212    217    Lax/p4/x;
        //  802    810    199    209    Lax/p4/t;
        //  802    810    194    997    Lax/G4/z0;
        //  802    810    189    930    Lax/G4/E0;
        //  802    810    185    189    Lax/p4/j;
        //  802    810    181    872    Ljava/io/IOException;
        //  802    810    177    181    Any
        //  834    837    212    217    Lax/p4/x;
        //  834    837    199    209    Lax/p4/t;
        //  834    837    194    997    Lax/G4/z0;
        //  834    837    189    930    Lax/G4/E0;
        //  834    837    185    189    Lax/p4/j;
        //  834    837    181    872    Ljava/io/IOException;
        //  834    837    177    181    Any
        //  837    842    1028   1032   Ljava/io/IOException;
        //  843    861    177    181    Any
        //  861    872    177    181    Any
        //  872    881    881    885    Any
        //  885    926    881    885    Any
        //  930    935    1032   1037   Ljava/io/IOException;
        //  946    958    881    885    Any
        //  958    982    881    885    Any
        //  985    997    881    885    Any
        //  997    1002   1037   1041   Ljava/io/IOException;
        //  1004   1009   1041   1046   Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 497 out of bounds for length 497
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
    
    private j p0(final String s, final ax.p4.j j) {
        if (j instanceof t) {
            return (j)new q(s, (Throwable)j);
        }
        if (j instanceof ax.p4.a) {
            return (j)new e(s, (Throwable)j);
        }
        if (j instanceof d && ((d)j).a() == 507) {
            return (j)new s(s, (Throwable)j);
        }
        if (j instanceof p) {
            final p p2 = (p)j;
            final ax.G4.o d0 = p2.d0;
            if (d0 != null && d0.c() && p2.d0.b() != null) {
                final j u0 = this.u0(s, j, p2.d0.b());
                if (u0 != null) {
                    return u0;
                }
            }
        }
        if (j instanceof w0) {
            final w0 w0 = (w0)j;
            final v0 d2 = w0.d0;
            if (d2 != null && d2.d() && w0.d0.c() != null && w0.d0.c().a() != null) {
                final j e0 = this.E0(s, j, w0.d0.c().a());
                if (e0 != null) {
                    return e0;
                }
            }
        }
        if (j instanceof X) {
            final X x = (X)j;
            final W d3 = x.d0;
            if (d3 != null) {
                if (d3.n()) {
                    return (j)new s(s, (Throwable)j);
                }
                if (x.d0.l() && x.d0.j() != null) {
                    final j u2 = this.u0(s, j, x.d0.j());
                    if (u2 != null) {
                        return u2;
                    }
                }
                else if (x.d0.m() && x.d0.k() != null) {
                    final j e2 = this.E0(s, j, x.d0.k());
                    if (e2 != null) {
                        return e2;
                    }
                }
            }
        }
        if (j instanceof K) {
            final K k = (K)j;
            final J d4 = k.d0;
            if (d4 != null && d4.d() && k.d0.c() != null) {
                final j u3 = this.u0(s, j, k.d0.c());
                if (u3 != null) {
                    return u3;
                }
            }
        }
        if (j instanceof ax.G4.i) {
            final ax.G4.i i = (ax.G4.i)j;
            final h d5 = i.d0;
            if (d5 != null) {
                if (d5.e() && i.d0.c() != null) {
                    final j u4 = this.u0(s, j, i.d0.c());
                    if (u4 != null) {
                        return u4;
                    }
                }
                else if (i.d0.f() && i.d0.d() != null) {
                    final j e3 = this.E0(s, j, i.d0.d());
                    if (e3 != null) {
                        return e3;
                    }
                }
            }
        }
        return new j(s, (Throwable)j);
    }
    
    static ax.x4.a q0(final String s) {
        return new ax.x4.a(v0(), s);
    }
    
    static ax.x4.a r0(final ax.u4.a a) {
        return new ax.x4.a(v0(), a);
    }
    
    public static a s0(final Context context) {
        if (k.p == null) {
            k.p = new a(context.getApplicationContext());
        }
        return k.p;
    }
    
    private static void t0(final Context context) {
    }
    
    private j u0(final String s, final ax.p4.j j, final M m) {
        if (m.b()) {
            return (j)new ax.b3.t((Throwable)j);
        }
        if (m.c()) {
            return (j)new e(s, (Throwable)j);
        }
        return null;
    }
    
    private static ax.p4.m v0() {
        return ax.p4.m.e("FileManager/2.7.8").b((ax.s4.a)ax.s4.b.e).a();
    }
    
    private void w0(final boolean b) {
        final c$a j = this.j;
        if (j != null) {
            j.T(b, (Object)null);
        }
    }
    
    public InputStream A(final String s, final String s2, final String s3) {
        final ax.x4.a h = this.h;
        if (h == null) {
            return null;
        }
        try {
            return ((ax.x4.b)h).a().l(s2).d(q0.q).e(s0.d0).c().b();
        }
        catch (final ax.p4.j j) {
            ((Throwable)j).printStackTrace();
            return null;
        }
    }
    
    void A0(final String m) {
        this.m = m;
    }
    
    public boolean B(final n n) {
        return true;
    }
    
    void B0(final boolean n) {
        this.n = n;
    }
    
    public List<n> C(final n n, final m.f f) throws j {
        if (!((ax.c3.b)n).n()) {
            throw new ax.b3.t();
        }
        ax.u3.b.c(((ax.c3.b)n).isDirectory());
        if (this.a()) {
            final ax.c3.m m = (ax.c3.m)n;
            String e = null;
            Label_0053: {
                try {
                    if (d0.E((n)m)) {
                        e = "";
                        break Label_0053;
                    }
                }
                catch (final ax.p4.j j) {
                    throw this.p0("listChildren", j);
                }
                e = ((n)m).E();
            }
            final ArrayList list = new ArrayList();
            L l = ((ax.x4.b)this.h).a().n(e);
            while (true) {
                final List b = l.b();
                if (b != null) {
                    for (final P p2 : b) {
                        if (p2.b() == null && p2.c() == null) {
                            continue;
                        }
                        ((List)list).add((Object)new ax.c3.m(this, p2));
                    }
                }
                if (!l.c()) {
                    break;
                }
                l = ((ax.x4.b)this.h).a().p(l.a());
            }
            return (List<n>)list;
        }
        ax.Ha.c.h().f().b("NOT CONNECT CALL LISTCHILDREN").j().h();
        throw new ax.b3.h("Not connected to server");
    }
    
    public void D(final n n, final G g, final String s, final long n2, final Long n3, final com.alphainventor.filemanager.file.p p9, final boolean b, final ax.u3.c c, final i i) throws j, ax.b3.a {
        ax.u3.b.a(((ax.c3.b)n).n());
        final String e = n.E();
        if (n2 >= 4194304L && n2 != -1L) {
            this.o0(this.h, g, n2, n3, e, false, c, i);
            return;
        }
        this.D0(this.h, g, n2, n3, e, false, c, i);
    }
    
    public void E(final n n, final n n2, final ax.u3.c c, final i i) throws j {
        ax.u3.b.a(((ax.c3.b)n2).n());
        Label_0086: {
            try {
                final long p4 = ((ax.c3.b)n).p();
                final Z r = ((ax.x4.b)this.h).a().r(n.E(), n2.E());
                if (r == null || r.a() == null) {
                    throw new j("null result");
                }
                if (i != null) {
                    i.a(p4, p4);
                    return;
                }
            }
            catch (final IllegalArgumentException ex) {
                break Label_0086;
            }
            catch (final ax.p4.j j) {
                throw this.p0("moveFile", j);
            }
            return;
        }
        final IllegalArgumentException ex;
        ax.Q2.d.c("dropbox move", (Throwable)ex);
        throw new j("moveFile", (Throwable)ex);
    }
    
    public void F(final n n, final n n2, final ax.u3.c c, final i i) throws j {
        ax.u3.b.a(((ax.c3.b)n2).n());
        try {
            final long p4 = ((ax.c3.b)n).p();
            final Z b = ((ax.x4.b)this.h).a().b(n.E(), n2.E());
            if (b == null || b.a() == null) {
                throw new j("Dropbox copy returns null entry");
            }
            if (i != null) {
                i.a(p4, p4);
            }
        }
        catch (final ax.p4.j j) {
            throw this.p0("copyFile", j);
        }
    }
    
    public int G(final String s, final String s2) {
        return -1;
    }
    
    public String H(final n n) {
        if (com.alphainventor.filemanager.file.k.q.contains((Object)n.A())) {
            return B.Y(n);
        }
        return null;
    }
    
    public void I(final n n) throws j {
        Label_0090: {
            try {
                ((ax.x4.b)this.h).a().f(n.E());
                return;
            }
            catch (final IllegalArgumentException ex) {}
            catch (final ax.p4.j j) {
                break Label_0090;
            }
            final IllegalArgumentException ex;
            final ax.Ha.b l = ax.Ha.c.h().f().b("Dropbox Delete").l((Throwable)ex);
            final StringBuilder sb = new StringBuilder();
            sb.append("path:");
            sb.append(n.E());
            l.g((Object)sb.toString()).h();
            throw new j((Throwable)ex);
        }
        final ax.p4.j j;
        ((Throwable)j).printStackTrace();
        throw this.p0("deleteFile", j);
    }
    
    public InputStream J(final n n, final long n2) throws j {
        if (this.a()) {
            Label_0200: {
                Label_0161: {
                    Label_0066: {
                        ax.G4.n h;
                        try {
                            h = ((ax.x4.b)this.h).a().h(n.E());
                            if (n2 > 0L) {
                                ((ax.x4.c)h).b(n2);
                            }
                        }
                        catch (final IllegalArgumentException ex) {
                            break Label_0066;
                        }
                        catch (final ax.p4.j j) {
                            break Label_0161;
                        }
                        catch (final ax.p4.f f) {
                            break Label_0200;
                        }
                        return h.c().b();
                    }
                    final ax.Ha.b b = ax.Ha.c.h().f().b("dropbox path problem");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("path:");
                    sb.append(n.E());
                    b.g((Object)sb.toString()).h();
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("dropbox getInputStream : ");
                    final IllegalArgumentException ex;
                    sb2.append(((Throwable)ex).getMessage());
                    throw new j(sb2.toString(), (Throwable)ex);
                }
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("dropbox getinputstream : ");
                final ax.p4.j j;
                sb3.append(((Throwable)j).getMessage());
                throw this.p0(sb3.toString(), j);
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("dropbox getinputstream : ");
            final ax.p4.f f;
            sb4.append((Object)f.b());
            sb4.append(" ; ");
            sb4.append(((Throwable)f).getMessage());
            throw this.p0(sb4.toString(), (ax.p4.j)f);
        }
        throw new ax.b3.h("Not connected : dropbox");
    }
    
    public void K(final Activity activity, Fragment fragment, final c$a j) {
        if (!this.k) {
            final f n0 = f.N0;
            final c0 c0 = new c0(n0);
            final SharedPreferences sharedPreferences = this.p().getSharedPreferences("DropboxPrefs", 0);
            final StringBuilder sb = new StringBuilder();
            sb.append("version_");
            sb.append(this.t());
            final int int1 = sharedPreferences.getInt(sb.toString(), 0);
            final ax.u4.a a = null;
            String s;
            if (int1 == 0) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("access_token_");
                sb2.append(this.t());
                fragment = (Fragment)sharedPreferences.getString(sb2.toString(), (String)null);
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("credential_");
                sb3.append(this.t());
                s = sharedPreferences.getString(sb3.toString(), (String)null);
            }
            else {
                final String b = ax.Y2.a.a().b(n0);
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("access_token_");
                sb4.append(this.t());
                fragment = (Fragment)c0.a(int1, b, sharedPreferences.getString(sb4.toString(), (String)null));
                final String b2 = ax.Y2.a.a().b(n0);
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("credential_");
                sb5.append(this.t());
                s = c0.a(int1, b2, sharedPreferences.getString(sb5.toString(), (String)null));
            }
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("app_rootspaceid_");
            sb6.append(this.t());
            final String string = sharedPreferences.getString(sb6.toString(), (String)null);
            final StringBuilder sb7 = new StringBuilder();
            sb7.append("app_userootspace_");
            sb7.append(this.t());
            final boolean boolean1 = sharedPreferences.getBoolean(sb7.toString(), false);
            this.A0(string);
            this.B0(boolean1);
            ax.u4.a a2 = a;
            if (s != null) {
                try {
                    a2 = (ax.u4.a)ax.u4.a.f.i(s);
                }
                catch (final ax.t4.a a3) {
                    a2 = a;
                }
            }
            (this.j = j).B();
            if (fragment == null && a2 == null) {
                if (activity == null) {
                    this.w0(false);
                }
                else if (!(this.k = C0(activity))) {
                    this.w0(false);
                }
            }
            else {
                new c(activity, (String)fragment, a2).i((Object[])new Void[0]);
            }
        }
    }
    
    public boolean L() {
        return false;
    }
    
    public boolean M(final n n) {
        Label_0037: {
            try {
                final ax.G4.e d = ((ax.x4.b)this.h).a().d(n.E(), false);
                if (d != null && d.a() != null) {
                    return true;
                }
            }
            catch (final ax.p4.j j) {
                break Label_0037;
            }
            return false;
        }
        final ax.p4.j j;
        ((Throwable)j).printStackTrace();
        return false;
    }
    
    public boolean N(final n n) {
        return this.l(n);
    }
    
    public boolean O() {
        return true;
    }
    
    public void P(final n n) throws j {
        this.I(n);
    }
    
    public boolean Q(final n n, final n n2) {
        return true;
    }
    
    public boolean Y() {
        return true;
    }
    
    public boolean a() {
        return this.h != null;
    }
    
    public void b() {
    }
    
    public boolean g0() {
        return true;
    }
    
    public boolean h0() {
        return true;
    }
    
    public void j0(final n n, final G g, final String s, final long n2, final Long n3, final com.alphainventor.filemanager.file.p p9, final boolean b, final ax.u3.c c, final i i) throws j, ax.b3.a {
        final String e = n.E();
        if (n2 < 4194304L || n2 == -1L) {
            this.D0(this.h, g, n2, n3, e, true, c, i);
            return;
        }
        this.o0(this.h, g, n2, n3, e, true, c, i);
    }
    
    void m(final n n, final String s, final boolean b, final boolean b2, final ax.g3.h h, final ax.u3.c c) throws j {
        monitorenter(this);
        if (b2) {
            Label_0246: {
                final String e;
                Label_0064: {
                    try {
                        try {
                            if ("/".equals((Object)n.E())) {
                                break Label_0064;
                            }
                        }
                        finally {}
                    }
                    catch (final ax.p4.j j) {
                        break Label_0246;
                    }
                    e = ((n)e).E();
                }
                final i0 t = ((ax.x4.b)this.h).a().t(s);
                t.b(f0.a().d(e).c(Long.valueOf(1000L)).b(Boolean.TRUE).a());
                final j0 a = t.a();
                final ArrayList list = new ArrayList();
                if (a != null && a.a() != null) {
                    final Iterator iterator = a.a().iterator();
                    while (iterator.hasNext()) {
                        final Q a2 = ((e0)iterator.next()).a();
                        if (a2 != null && a2.c()) {
                            final P b3 = a2.b();
                            if (b3.b() == null && b3.c() == null) {
                                continue;
                            }
                            ((List)list).add((Object)new ax.c3.m(this, b3));
                        }
                    }
                }
                h.Y(B.h((List)list, (String)null, b, false), true);
                monitorexit(this);
                return;
            }
            final ax.p4.j j;
            ((Throwable)j).printStackTrace();
            throw this.p0("doSearch", j);
        }
        try {
            this.o(n, s, b, b2, h, c);
            monitorexit(this);
            return;
        }
        finally {}
        monitorexit(this);
        throw null;
    }
    
    public void x0() {
        if (this.k) {
            this.l = true;
        }
    }
    
    public k0 y() throws j {
        ax.M4.g a;
        try {
            final ax.M4.h b = ((ax.x4.b)this.h).b().b();
            a = b.a();
            if (a.f()) {
                return new k0(a.c().a(), b.b());
            }
        }
        catch (final ax.p4.j j) {
            throw this.p0("storagespace", j);
        }
        if (a.g()) {
            return new k0(a.d().a(), a.d().b());
        }
        return null;
    }
    
    public void y0() {
        if (this.k && this.l) {
            final b i = this.i;
            if (i == null || i.m().equals(q$f.d0)) {
                final ax.u4.a a = com.dropbox.core.android.a.a();
                if (a != null) {
                    (this.i = new b(this.p(), this, this.j, a)).i((Object[])new Void[0]);
                }
                else {
                    this.j.T(false, (Object)null);
                }
                this.k = false;
                this.l = false;
                this.j = null;
            }
        }
    }
    
    public n z(final String s) throws j {
        if ("/".equals((Object)s)) {
            return (n)new ax.c3.m(this, "/");
        }
        if (this.a()) {
            Label_0059: {
                try {
                    return (n)new ax.c3.m(this, ((ax.x4.b)this.h).a().j(s));
                }
                catch (final Exception ex) {
                    break Label_0059;
                }
                catch (final ax.p4.j j) {
                    if (j instanceof ax.G4.B) {
                        final ax.G4.B b = (ax.G4.B)j;
                        if (b.d0.c() && b.d0.b() == M.c) {
                            return (n)new ax.c3.m(this, s);
                        }
                    }
                    throw this.p0("getFileInfo", j);
                    final Exception ex;
                    ((Throwable)ex).printStackTrace();
                    throw ax.b3.d.b("dropbox getfileinfo", ex);
                }
            }
        }
        ax.Ha.c.h().f().b("NOT CONNECT CALL GET FILE INFO").j().h();
        throw new ax.b3.h("Not connected to server");
    }
    
    void z0(final ax.x4.a h) {
        if (this.n && !TextUtils.isEmpty((CharSequence)this.m)) {
            com.alphainventor.filemanager.file.k.o.fine("Use dropbox team space");
            this.h = h.d(ax.C4.a.c(this.m));
            return;
        }
        com.alphainventor.filemanager.file.k.o.fine("Use dropbox user space");
        this.h = h;
    }
    
    public static class a extends T
    {
        Context a;
        boolean b;
        b c;
        WeakReference<ax.g3.k> d;
        
        public a(final Context a) {
            this.a = a;
        }
        
        public void a(final int n) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("DropboxPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("version_");
            sb.append(n);
            final SharedPreferences$Editor remove = edit.remove(sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("app_userid_");
            sb2.append(n);
            final SharedPreferences$Editor remove2 = remove.remove(sb2.toString());
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("app_accountid_");
            sb3.append(n);
            final SharedPreferences$Editor remove3 = remove2.remove(sb3.toString());
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("access_token_");
            sb4.append(n);
            final SharedPreferences$Editor remove4 = remove3.remove(sb4.toString());
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("credential_");
            sb5.append(n);
            final SharedPreferences$Editor remove5 = remove4.remove(sb5.toString());
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("app_name_");
            sb6.append(n);
            final SharedPreferences$Editor remove6 = remove5.remove(sb6.toString());
            final StringBuilder sb7 = new StringBuilder();
            sb7.append("location_name_");
            sb7.append(n);
            final SharedPreferences$Editor remove7 = remove6.remove(sb7.toString());
            final StringBuilder sb8 = new StringBuilder();
            sb8.append("app_email_");
            sb8.append(n);
            final SharedPreferences$Editor remove8 = remove7.remove(sb8.toString());
            final StringBuilder sb9 = new StringBuilder();
            sb9.append("app_rootspaceid_");
            sb9.append(n);
            final SharedPreferences$Editor remove9 = remove8.remove(sb9.toString());
            final StringBuilder sb10 = new StringBuilder();
            sb10.append("app_userootspace_");
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
            final SharedPreferences sharedPreferences = this.a.getSharedPreferences("DropboxPrefs", 0);
            final StringBuilder sb = new StringBuilder();
            sb.append("app_name_");
            sb.append(n);
            String string = sharedPreferences.getString(sb.toString(), (String)null);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("app_email_");
            sb2.append(n);
            final String string2 = sharedPreferences.getString(sb2.toString(), (String)null);
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                string = string2;
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("location_name_");
            sb3.append(n);
            final String string3 = sb3.toString();
            final f n2 = f.N0;
            final String string4 = sharedPreferences.getString(string3, n2.M(this.a));
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("created_");
            sb4.append(n);
            final long long1 = sharedPreferences.getLong(sb4.toString(), 0L);
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("sortindex_");
            sb5.append(n);
            return new ax.Z2.s(n2, n, string4, string, (String)null, (String)null, long1, sharedPreferences.getLong(sb5.toString(), 0L));
        }
        
        public void g(final int n, final String s) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("DropboxPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("location_name_");
            sb.append(n);
            edit.putString(sb.toString(), s);
            edit.commit();
        }
        
        public void j(final int n, final long n2) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("DropboxPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("sortindex_");
            sb.append(n);
            edit.putLong(sb.toString(), n2);
            edit.apply();
        }
        
        public void k(final Activity activity, final ax.g3.k k) {
            this.d = (WeakReference<ax.g3.k>)new WeakReference((Object)k);
            final f n0 = f.N0;
            k.b(n0);
            if (!(this.b = C0(activity))) {
                k.a(n0, (String)null, 0, (String)null, (String)null);
            }
        }
        
        public void l(final Activity activity, final ax.g3.k k, final int n, final boolean b) {
            this.s(n, b);
            if (k != null) {
                k.c(f.N0, n);
            }
        }
        
        int m(final String s, final String s2) {
            final Context a = this.a;
            int i = 0;
            for (SharedPreferences sharedPreferences = a.getSharedPreferences("DropboxPrefs", 0); i < sharedPreferences.getInt("count", 0); ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("app_accountid_");
                sb.append(i);
                if (sharedPreferences.contains(sb.toString())) {
                    if (!TextUtils.isEmpty((CharSequence)s)) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("app_accountid_");
                        sb2.append(i);
                        if (s.equals((Object)sharedPreferences.getString(sb2.toString(), (String)null))) {
                            return i;
                        }
                    }
                }
                else {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("app_name_");
                    sb3.append(i);
                    if (sharedPreferences.contains(sb3.toString()) && !TextUtils.isEmpty((CharSequence)s2)) {
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("app_name_");
                        sb4.append(i);
                        if (s2.equals((Object)sharedPreferences.getString(sb4.toString(), (String)null))) {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }
        
        int n() {
            return this.a.getSharedPreferences("DropboxPrefs", 0).getInt("count", 0);
        }
        
        public List<ax.Z2.s> o() {
            final ArrayList list = new ArrayList();
            final Context a = this.a;
            int i = 0;
            for (SharedPreferences sharedPreferences = a.getSharedPreferences("DropboxPrefs", 0); i < sharedPreferences.getInt("count", 0); ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("credential_");
                sb.append(i);
                final String string = sharedPreferences.getString(sb.toString(), (String)null);
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("access_token_");
                sb2.append(i);
                final String string2 = sharedPreferences.getString(sb2.toString(), (String)null);
                if (string != null || string2 != null) {
                    ((List)list).add((Object)this.f(i));
                }
            }
            return (List<ax.Z2.s>)list;
        }
        
        public void p(final Activity activity) {
            if (this.b) {
                final b c = this.c;
                if (c == null || c.m().equals(q$f.d0)) {
                    final ax.g3.k k = (ax.g3.k)((Reference)this.d).get();
                    if (k != null) {
                        final ax.u4.a a = com.dropbox.core.android.a.a();
                        if (a != null) {
                            (this.c = new b((Context)activity, k, a)).i((Object[])new Void[0]);
                        }
                        else {
                            k.a(f.N0, (String)null, 0, (String)null, (String)null);
                        }
                    }
                    this.b = false;
                }
            }
        }
        
        void q(final int n, final ax.u4.a a) {
            final f n2 = f.N0;
            final c0 c0 = new c0(n2);
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("DropboxPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("version_");
            sb.append(n);
            edit.putInt(sb.toString(), 3);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("credential_");
            sb2.append(n);
            edit.putString(sb2.toString(), c0.e(ax.Y2.a.a().b(n2), a.toString()));
            edit.commit();
        }
        
        void r(final int n, final String s, final String s2, final String s3, final String s4, final String s5, final ax.u4.a a) {
            final Context a2 = this.a;
            boolean b = false;
            final SharedPreferences sharedPreferences = a2.getSharedPreferences("DropboxPrefs", 0);
            if (n >= sharedPreferences.getInt("count", 0)) {
                b = true;
            }
            final f n2 = f.N0;
            final c0 c0 = new c0(n2);
            final SharedPreferences$Editor edit = sharedPreferences.edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("app_accountid_");
            sb.append(n);
            final SharedPreferences$Editor putString = edit.putString(sb.toString(), s);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("version_");
            sb2.append(n);
            final SharedPreferences$Editor putInt = putString.putInt(sb2.toString(), 3);
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("app_name_");
            sb3.append(n);
            final SharedPreferences$Editor putString2 = putInt.putString(sb3.toString(), s2);
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("access_token_");
            sb4.append(n);
            final SharedPreferences$Editor putString3 = putString2.putString(sb4.toString(), c0.e(ax.Y2.a.a().b(n2), s5));
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("app_email_");
            sb5.append(n);
            final SharedPreferences$Editor putString4 = putString3.putString(sb5.toString(), s3);
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("app_rootspaceid_");
            sb6.append(n);
            final SharedPreferences$Editor putString5 = putString4.putString(sb6.toString(), s4);
            final StringBuilder sb7 = new StringBuilder();
            sb7.append("location_name_");
            sb7.append(n);
            putString5.putString(sb7.toString(), n2.M(this.a));
            if (a != null) {
                final StringBuilder sb8 = new StringBuilder();
                sb8.append("credential_");
                sb8.append(n);
                edit.putString(sb8.toString(), c0.e(ax.Y2.a.a().b(n2), a.toString()));
            }
            else {
                final StringBuilder sb9 = new StringBuilder();
                sb9.append("credential_");
                sb9.append(n);
                edit.putString(sb9.toString(), (String)null);
            }
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
            if (b) {
                edit.putInt("count", n + 1);
            }
            edit.commit();
        }
        
        void s(final int n, final boolean b) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("DropboxPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("app_userootspace_");
            sb.append(n);
            edit.putBoolean(sb.toString(), b);
            edit.commit();
        }
    }
    
    private static class b extends ax.u3.q<Void, Void, Integer>
    {
        private c$a h;
        ax.g3.k i;
        ax.u4.a j;
        Context k;
        k l;
        int m;
        
        public b(final Context k, final ax.g3.k i, final ax.u4.a j) {
            super(q$e.c0);
            this.k = k;
            this.i = i;
            this.j = j;
        }
        
        public b(final Context k, final k l, final c$a h, final ax.u4.a j) {
            super(q$e.c0);
            this.k = k;
            this.h = h;
            this.j = j;
            this.l = l;
        }
        
        protected Integer w(Void... b) {
            String s = "";
            final ax.u4.a j = this.j;
            if (j == null) {
                return -1;
            }
            ax.x4.a r0;
            String a3;
            Object o3;
            String s6;
            boolean b4;
            while (true) {
                r0 = com.alphainventor.filemanager.file.k.r0(j);
                final String s2 = null;
                final Void[] array = null;
                while (true) {
                    String s3 = null;
                    String s4 = null;
                    String s5 = null;
                    Label_0284: {
                        try {
                            final ax.M4.c a = ((ax.x4.b)r0).b().a();
                            final String a2 = a.c().a();
                            try {
                                a3 = a.a();
                                b = array;
                                String b2 = null;
                                Object o = null;
                                boolean b3 = false;
                                Label_0235: {
                                    Label_0233: {
                                        try {
                                            b2 = a.b();
                                            b = array;
                                            s = b2;
                                            o = s2;
                                            if (this.i == null) {
                                                break Label_0233;
                                            }
                                            b = array;
                                            s = b2;
                                            o = s2;
                                            if (a.d() == null) {
                                                break Label_0233;
                                            }
                                            b = array;
                                            s = b2;
                                            final Object o2 = b = (Void[])(Object)a.d().b();
                                            s = b2;
                                            final String a4 = a.d().a();
                                            b = (Void[])o2;
                                            s = b2;
                                            o = o2;
                                            if (TextUtils.isEmpty((CharSequence)o2)) {
                                                break Label_0233;
                                            }
                                            b = (Void[])o2;
                                            s = b2;
                                            o = o2;
                                            if (TextUtils.isEmpty((CharSequence)a4)) {
                                                break Label_0233;
                                            }
                                            b = (Void[])o2;
                                            s = b2;
                                            final boolean equals = ((String)o2).equals(a4);
                                            o = o2;
                                            if (!equals) {
                                                b3 = true;
                                                o = o2;
                                                break Label_0235;
                                            }
                                            break Label_0233;
                                        }
                                        catch (final ax.p4.j i) {
                                            final Void[] array2 = b;
                                            s3 = s;
                                            s4 = a3;
                                            s = (String)(Object)array2;
                                        }
                                        s5 = a2;
                                        break Label_0284;
                                    }
                                    b3 = false;
                                }
                                s = b2;
                                o3 = o;
                                s6 = a2;
                                b4 = b3;
                            }
                            catch (final ax.p4.j k) {
                                s4 = "";
                                s = null;
                                s3 = "";
                            }
                        }
                        catch (final ax.p4.j l) {
                            s4 = "";
                            final String s7 = null;
                            s3 = "";
                            s5 = s;
                            s = s7;
                        }
                    }
                    final String s8 = s3;
                    final String a2 = s;
                    b4 = false;
                    a3 = s4;
                    s6 = s5;
                    s = s8;
                    o3 = a2;
                    continue;
                }
            }
            final a s9 = com.alphainventor.filemanager.file.k.s0(this.k);
            final k m = this.l;
            int m2;
            if (m != null) {
                m2 = m.t();
            }
            else {
                m2 = s9.n();
                final int m3 = s9.m(a3, s6);
                if (m3 >= 0) {
                    m2 = m3;
                }
            }
            s9.r(m2, a3, s6, s, (String)o3, null, this.j);
            this.m = m2;
            if (this.i != null && b4) {
                return -2;
            }
            final k l2 = this.l;
            if (l2 != null) {
                l2.A0((String)o3);
                this.l.z0(r0);
            }
            return 0;
        }
        
        protected void x(final Integer n) {
            if (n == 0) {
                final c$a h = this.h;
                if (h != null) {
                    h.T(true, (Object)null);
                }
                final ax.g3.k i = this.i;
                if (i != null) {
                    i.c(f.N0, this.m);
                }
            }
            else {
                if (n == -2) {
                    try {
                        this.i.d(f.N0, this.m, (Map)null);
                        return;
                    }
                    catch (final IllegalStateException ex) {
                        final c$a h2 = this.h;
                        if (h2 != null) {
                            h2.T(false, (Object)null);
                        }
                        final ax.g3.k j = this.i;
                        if (j != null) {
                            j.a(f.N0, (String)null, 0, (String)null, (String)null);
                        }
                        return;
                    }
                }
                final c$a h3 = this.h;
                if (h3 != null) {
                    h3.T(false, (Object)null);
                }
                final ax.g3.k k = this.i;
                if (k != null) {
                    k.a(f.N0, (String)null, 0, (String)null, (String)null);
                }
            }
        }
    }
    
    private class c extends ax.u3.q<Void, Void, Integer>
    {
        Activity h;
        ax.u4.a i;
        String j;
        final k k;
        
        public c(final k k, final Activity h, final String j, final ax.u4.a i) {
            this.k = k;
            super(q$e.c0);
            this.j = j;
            this.i = i;
            this.h = h;
        }
        
        protected Integer w(final Void... array) {
            Label_0354: {
                Label_0345: {
                    ax.x4.a a = null;
                    Label_0039: {
                        try {
                            final ax.u4.a i = this.i;
                            if (i != null) {
                                a = com.alphainventor.filemanager.file.k.r0(i);
                                break Label_0039;
                            }
                        }
                        catch (final ax.p4.j j) {
                            break Label_0345;
                        }
                        catch (final r r) {
                            break Label_0354;
                        }
                        final String k = this.j;
                        if (k == null) {
                            return -2;
                        }
                        a = com.alphainventor.filemanager.file.k.q0(k);
                    }
                    final ax.u4.a l = this.i;
                    if (l != null && l.i() != null && this.i.a()) {
                        try {
                            a.c();
                            com.alphainventor.filemanager.file.k.s0(this.k.p()).q(this.k.t(), this.i);
                        }
                        catch (final ax.u4.c c) {
                            return -2;
                        }
                    }
                    final ax.M4.c a2 = ((ax.x4.b)a).b().a();
                    final SharedPreferences sharedPreferences = this.k.p().getSharedPreferences("DropboxPrefs", 0);
                    final StringBuilder sb = new StringBuilder();
                    sb.append("app_email_");
                    sb.append(this.k.t());
                    final String string = sb.toString();
                    String b = null;
                    final String string2 = sharedPreferences.getString(string, (String)null);
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("app_rootspaceid_");
                    sb2.append(this.k.t());
                    final String string3 = sharedPreferences.getString(sb2.toString(), (String)null);
                    if (a2.d() != null) {
                        b = a2.d().b();
                    }
                    final String b2 = a2.b();
                    if (!ax.u3.B.j((Object)string2, (Object)b2) || !ax.u3.B.j((Object)string3, (Object)b)) {
                        com.alphainventor.filemanager.file.k.s0(this.k.p()).r(this.k.t(), a2.a(), a2.c().a(), b2, b, this.j, this.i);
                    }
                    this.k.A0(b);
                    this.k.z0(a);
                    return 0;
                }
                final ax.p4.j j;
                ((Throwable)j).printStackTrace();
                return -1;
            }
            final r r;
            ((Throwable)r).printStackTrace();
            return -2;
        }
        
        protected void x(final Integer n) {
            if (n == 0) {
                this.k.w0(true);
                return;
            }
            if (n == -1) {
                this.k.w0(false);
                return;
            }
            if (n == -2) {
                final Activity h = this.h;
                if (h == null) {
                    this.k.w0(false);
                    return;
                }
                this.k.k = C0(h);
                if (!this.k.k) {
                    this.k.w0(false);
                }
            }
        }
    }
}
