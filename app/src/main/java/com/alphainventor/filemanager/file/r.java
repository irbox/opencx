package com.alphainventor.filemanager.file;

import java.util.AbstractCollection;
import ax.i7.w;
import ax.o7.a$b;
import ax.u3.q$e;
import android.os.Bundle;
import android.accounts.Account;
import android.content.Intent;
import ax.g3.k;
import ax.Q2.f;
import android.text.TextUtils;
import android.content.SharedPreferences$Editor;
import ax.c3.k0;
import java.util.Collection;
import ax.d3.L;
import androidx.fragment.app.Fragment;
import android.app.Activity;
import ax.o7.a$c$c;
import ax.b3.h;
import ax.c3.B;
import ax.c3.A;
import java.util.Arrays;
import ax.o7.a$c$e;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import ax.i7.g;
import android.net.Uri;
import java.io.InputStream;
import java.util.Stack;
import java.util.HashSet;
import android.content.SharedPreferences;
import ax.b3.q;
import ax.b3.t;
import ax.b3.e;
import ax.b3.s;
import ax.e7.a$a;
import ax.o7.a$c$d;
import ax.p7.d;
import ax.g3.i;
import ax.c3.G;
import java.util.Iterator;
import java.util.List;
import ax.u3.b;
import java.util.ArrayList;
import java.io.IOException;
import ax.c3.d0;
import ax.p7.c;
import ax.b3.j;
import ax.c3.E;
import android.content.Context;
import j$.util.concurrent.ConcurrentHashMap;
import ax.o7.a;
import java.util.logging.Logger;

public class r extends m
{
    private static final Logger n;
    private static c o;
    private a h;
    private String i;
    private boolean j;
    private ConcurrentHashMap<String, n> k;
    private ConcurrentHashMap<String, String> l;
    private e m;
    
    static {
        n = Logger.getLogger("FileManager.GoogleDriveFileHelper");
    }
    
    public r() {
        this.k = (ConcurrentHashMap<String, n>)new ConcurrentHashMap();
        this.l = (ConcurrentHashMap<String, String>)new ConcurrentHashMap();
    }
    
    public static c A0(final Context context) {
        if (r.o == null) {
            r.o = new c(context.getApplicationContext());
        }
        return r.o;
    }
    
    private String B0(final n n) throws j {
        String s;
        if ((s = ((E)n).h0()) == null) {
            final E e = (E)this.z(n.T());
            if (!e.n()) {
                return null;
            }
            s = this.y0(e);
        }
        return this.r0(s);
    }
    
    private E C0(ax.p7.c c, String q, final String s, final String s2) throws IOException {
        if (c.w() == null || c.w().size() <= 0) {
            return this.t0();
        }
        String s3 = (String)c.w().get(0);
        if (this.E0(s3)) {
            return new E(this, "/");
        }
        String s4;
        if (s2 != null && s2.equals((Object)s3)) {
            s3 = q;
            s4 = s;
        }
        else {
            s4 = (String)this.l.get((Object)s3);
        }
        if (s4 != null && this.k.containsKey((Object)s4)) {
            return (E)this.k.get((Object)s4);
        }
        c = (ax.p7.c)((ax.g7.b)this.h.n().d(s3).H("kind,id,name,mimeType,parents,capabilities/canDownload,capabilities/canEdit,size,modifiedTime,createdTime,webContentLink,thumbnailLink,webViewLink,shortcutDetails,trashed")).execute();
        final E c2 = this.C0(c, q, s, s2);
        q = d0.Q(((n)c2).E(), J0(c));
        final E e = new E(this, c2.t(), this.y0(c2), c, q);
        this.k.put((Object)q, (Object)e);
        this.l.put((Object)e.t(), (Object)((n)e).E());
        return e;
    }
    
    private String D0(final ArrayList<d> list, String s, String b, final String s2, final String s3) {
        final StringBuilder sb = new StringBuilder();
    Label_0202:
        while (s != null) {
            if (s.equals((Object)s3)) {
                sb.insert(0, s2);
                break;
            }
            final int size = list.size();
            int i = 0;
            while (true) {
                while (i < size) {
                    final Object value = list.get(i);
                    ++i;
                    final d d = (d)value;
                    if (s.equals((Object)d.a.r())) {
                        b = d.b;
                        sb.insert(0, d.a.v());
                        sb.insert(0, "/");
                        if (b == null) {
                            b.e("what case is this?");
                            break Label_0202;
                        }
                        if (b.equals((Object)this.i)) {
                            break Label_0202;
                        }
                        if (b.equals((Object)"root")) {
                            break Label_0202;
                        }
                        if ("no-parent-id".equals((Object)b)) {
                            sb.insert(0, ".hidden-system-folder");
                            sb.insert(0, "/");
                            break Label_0202;
                        }
                        if (b.equals((Object)s)) {
                            b.e("what case is this?");
                            break Label_0202;
                        }
                        s = b;
                        continue Label_0202;
                    }
                }
                b = s;
                continue;
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }
    
    private boolean E0(final String s) {
        if (!"root".equals((Object)s)) {
            final String i = this.i;
            if (i == null || !i.equals((Object)s)) {
                return false;
            }
        }
        return true;
    }
    
    public static String F0(final String s) {
        if (s == null) {
            return null;
        }
        return s.replace('/', '_');
    }
    
    private List<ax.p7.c> H0(final String p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: dup            
        //     2: astore          6
        //     4: monitorenter   
        //     5: new             Ljava/util/ArrayList;
        //     8: astore_3       
        //     9: aload_3        
        //    10: invokespecial   java/util/ArrayList.<init>:()V
        //    13: aload_0        
        //    14: getfield        com/alphainventor/filemanager/file/r.h:Lax/o7/a;
        //    17: invokevirtual   ax/o7/a.n:()Lax/o7/a$c;
        //    20: invokevirtual   ax/o7/a$c.e:()Lax/o7/a$c$d;
        //    23: ldc_w           "nextPageToken, files(kind,id,name,mimeType,parents,capabilities/canDownload,capabilities/canEdit,size,modifiedTime,createdTime,webContentLink,thumbnailLink,webViewLink,shortcutDetails,trashed)"
        //    26: invokevirtual   ax/o7/a$c$d.I:(Ljava/lang/String;)Lax/o7/a$c$d;
        //    29: aload_1        
        //    30: invokevirtual   ax/o7/a$c$d.K:(Ljava/lang/String;)Lax/o7/a$c$d;
        //    33: astore_1       
        //    34: aload_1        
        //    35: invokevirtual   ax/g7/b.execute:()Ljava/lang/Object;
        //    38: checkcast       Lax/p7/d;
        //    41: astore          4
        //    43: aload           4
        //    45: invokevirtual   ax/p7/d.n:()Ljava/util/List;
        //    48: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    53: astore          5
        //    55: aload           5
        //    57: invokeinterface java/util/Iterator.hasNext:()Z
        //    62: ifeq            94
        //    65: aload_3        
        //    66: aload           5
        //    68: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    73: checkcast       Lax/p7/c;
        //    76: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    81: pop            
        //    82: goto            55
        //    85: astore_1       
        //    86: goto            142
        //    89: astore          4
        //    91: goto            107
        //    94: aload_1        
        //    95: aload           4
        //    97: invokevirtual   ax/p7/d.o:()Ljava/lang/String;
        //   100: invokevirtual   ax/o7/a$c$d.J:(Ljava/lang/String;)Lax/o7/a$c$d;
        //   103: pop            
        //   104: goto            118
        //   107: aload           4
        //   109: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   112: aload_1        
        //   113: aconst_null    
        //   114: invokevirtual   ax/o7/a$c$d.J:(Ljava/lang/String;)Lax/o7/a$c$d;
        //   117: pop            
        //   118: aload_1        
        //   119: invokevirtual   ax/o7/a$c$d.G:()Ljava/lang/String;
        //   122: ifnull          137
        //   125: aload_1        
        //   126: invokevirtual   ax/o7/a$c$d.G:()Ljava/lang/String;
        //   129: invokevirtual   java/lang/String.length:()I
        //   132: istore_2       
        //   133: iload_2        
        //   134: ifgt            34
        //   137: aload           6
        //   139: monitorexit    
        //   140: aload_3        
        //   141: areturn        
        //   142: aload           6
        //   144: monitorexit    
        //   145: aload_1        
        //   146: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    Signature:
        //  (Ljava/lang/String;)Ljava/util/List<Lax/p7/c;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  5      34     85     147    Any
        //  34     55     89     94     Ljava/io/IOException;
        //  34     55     85     147    Any
        //  55     82     89     94     Ljava/io/IOException;
        //  55     82     85     147    Any
        //  94     104    89     94     Ljava/io/IOException;
        //  94     104    85     147    Any
        //  107    118    85     147    Any
        //  118    133    85     147    Any
        //  142    145    85     147    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0034:
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
    
    private void I0(final String s) {
        for (final String s2 : this.k.keySet()) {
            if (s2.startsWith(s)) {
                this.k.remove((Object)s2);
            }
        }
    }
    
    public static String J0(final ax.p7.c c) {
        return F0(c.v());
    }
    
    private void K0(final n p0, final G p1, final String p2, final long p3, final Long p4, final boolean p5, final boolean p6, final ax.u3.c p7, final i p8) throws j, ax.b3.a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   ax/p7/c.<init>:()V
        //     7: astore          12
        //     9: aload           12
        //    11: aload_1        
        //    12: invokevirtual   com/alphainventor/filemanager/file/n.B:()Ljava/lang/String;
        //    15: invokevirtual   ax/p7/c.G:(Ljava/lang/String;)Lax/p7/c;
        //    18: pop            
        //    19: aload           12
        //    21: aload_3        
        //    22: invokevirtual   ax/p7/c.E:(Ljava/lang/String;)Lax/p7/c;
        //    25: pop            
        //    26: aload           6
        //    28: ifnull          59
        //    31: aload           6
        //    33: invokevirtual   java/lang/Long.longValue:()J
        //    36: lconst_0       
        //    37: lcmp           
        //    38: ifle            59
        //    41: aload           12
        //    43: new             Lax/m7/i;
        //    46: dup            
        //    47: aload           6
        //    49: invokevirtual   java/lang/Long.longValue:()J
        //    52: invokespecial   ax/m7/i.<init>:(J)V
        //    55: invokevirtual   ax/p7/c.F:(Lax/m7/i;)Lax/p7/c;
        //    58: pop            
        //    59: iload           8
        //    61: ifeq            79
        //    64: aload_1        
        //    65: invokeinterface ax/c3/b.t:()Ljava/lang/String;
        //    70: ifnull          79
        //    73: iconst_1       
        //    74: istore          11
        //    76: goto            82
        //    79: iconst_0       
        //    80: istore          11
        //    82: aload_2        
        //    83: invokevirtual   ax/c3/G.b:()Ljava/io/InputStream;
        //    86: astore_2       
        //    87: new             Lax/i7/y;
        //    90: astore          13
        //    92: new             Ljava/io/BufferedInputStream;
        //    95: astore          14
        //    97: aload           14
        //    99: aload_2        
        //   100: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //   103: aload           13
        //   105: aload_3        
        //   106: aload           14
        //   108: invokespecial   ax/i7/y.<init>:(Ljava/lang/String;Ljava/io/InputStream;)V
        //   111: lload           4
        //   113: ldc2_w          -1
        //   116: lcmp           
        //   117: ifeq            151
        //   120: aload           13
        //   122: lload           4
        //   124: invokevirtual   ax/i7/y.i:(J)Lax/i7/y;
        //   127: pop            
        //   128: goto            151
        //   131: astore_1       
        //   132: goto            453
        //   135: astore_1       
        //   136: goto            419
        //   139: astore_1       
        //   140: goto            136
        //   143: astore_1       
        //   144: goto            136
        //   147: astore_1       
        //   148: goto            136
        //   151: aload           13
        //   153: iconst_0       
        //   154: invokevirtual   ax/i7/y.h:(Z)Lax/i7/y;
        //   157: pop            
        //   158: iload           11
        //   160: ifeq            191
        //   163: aload_0        
        //   164: aload_1        
        //   165: checkcast       Lax/c3/E;
        //   168: invokespecial   com/alphainventor/filemanager/file/r.y0:(Lax/c3/E;)Ljava/lang/String;
        //   171: astore_1       
        //   172: aload_0        
        //   173: getfield        com/alphainventor/filemanager/file/r.h:Lax/o7/a;
        //   176: invokevirtual   ax/o7/a.n:()Lax/o7/a$c;
        //   179: aload_1        
        //   180: aload           12
        //   182: aload           13
        //   184: invokevirtual   ax/o7/a$c.g:(Ljava/lang/String;Lax/p7/c;Lax/i7/b;)Lax/o7/a$c$e;
        //   187: astore_1       
        //   188: goto            233
        //   191: aload_0        
        //   192: aload_1        
        //   193: invokespecial   com/alphainventor/filemanager/file/r.B0:(Lcom/alphainventor/filemanager/file/n;)Ljava/lang/String;
        //   196: astore_1       
        //   197: aload_1        
        //   198: ifnull          406
        //   201: aload           12
        //   203: iconst_1       
        //   204: anewarray       Ljava/lang/String;
        //   207: dup            
        //   208: iconst_0       
        //   209: aload_1        
        //   210: aastore        
        //   211: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //   214: invokevirtual   ax/p7/c.H:(Ljava/util/List;)Lax/p7/c;
        //   217: pop            
        //   218: aload_0        
        //   219: getfield        com/alphainventor/filemanager/file/r.h:Lax/o7/a;
        //   222: invokevirtual   ax/o7/a.n:()Lax/o7/a$c;
        //   225: aload           12
        //   227: aload           13
        //   229: invokevirtual   ax/o7/a$c.c:(Lax/p7/c;Lax/i7/b;)Lax/o7/a$c$b;
        //   232: astore_1       
        //   233: aload           6
        //   235: ifnull          259
        //   238: aload           6
        //   240: invokevirtual   java/lang/Long.longValue:()J
        //   243: lconst_0       
        //   244: lcmp           
        //   245: ifle            259
        //   248: aload_1        
        //   249: ldc_w           "setModifiedDate"
        //   252: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   255: invokevirtual   ax/o7/b.E:(Ljava/lang/String;Ljava/lang/Object;)Lax/o7/b;
        //   258: pop            
        //   259: aload_1        
        //   260: invokevirtual   ax/g7/b.r:()Lax/f7/b;
        //   263: astore          6
        //   265: aload           6
        //   267: iconst_0       
        //   268: invokevirtual   ax/f7/b.n:(Z)Lax/f7/b;
        //   271: pop            
        //   272: aload           6
        //   274: ldc_w           1048576
        //   277: invokevirtual   ax/f7/b.m:(I)Lax/f7/b;
        //   280: pop            
        //   281: new             Lcom/alphainventor/filemanager/file/r$a;
        //   284: astore_3       
        //   285: aload_3        
        //   286: aload_0        
        //   287: aload           9
        //   289: aload_2        
        //   290: aload           10
        //   292: lload           4
        //   294: invokespecial   com/alphainventor/filemanager/file/r$a.<init>:(Lcom/alphainventor/filemanager/file/r;Lax/u3/c;Ljava/io/InputStream;Lax/g3/i;J)V
        //   297: aload           6
        //   299: aload_3        
        //   300: invokevirtual   ax/f7/b.s:(Lax/f7/c;)Lax/f7/b;
        //   303: pop            
        //   304: aload_1        
        //   305: invokevirtual   ax/g7/b.execute:()Ljava/lang/Object;
        //   308: checkcast       Lax/p7/c;
        //   311: astore_1       
        //   312: aload           9
        //   314: ifnull          360
        //   317: aload           9
        //   319: invokeinterface ax/u3/c.isCancelled:()Z
        //   324: ifne            330
        //   327: goto            360
        //   330: new             Lax/b3/a;
        //   333: astore_1       
        //   334: aload_1        
        //   335: invokespecial   ax/b3/a.<init>:()V
        //   338: aload_1        
        //   339: athrow         
        //   340: astore_1       
        //   341: goto            453
        //   344: astore_1       
        //   345: goto            419
        //   348: astore_1       
        //   349: goto            345
        //   352: astore_1       
        //   353: goto            345
        //   356: astore_1       
        //   357: goto            345
        //   360: aload_1        
        //   361: ifnull          373
        //   364: aload_2        
        //   365: ifnull          372
        //   368: aload_2        
        //   369: invokevirtual   java/io/InputStream.close:()V
        //   372: return         
        //   373: new             Lax/b3/j;
        //   376: astore_1       
        //   377: aload_1        
        //   378: ldc_w           "GoogleDrive insert() returns null"
        //   381: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   384: aload_1        
        //   385: athrow         
        //   386: astore_1       
        //   387: goto            341
        //   390: astore_1       
        //   391: goto            345
        //   394: astore_1       
        //   395: goto            391
        //   398: astore_1       
        //   399: goto            391
        //   402: astore_1       
        //   403: goto            391
        //   406: new             Lax/b3/j;
        //   409: astore_1       
        //   410: aload_1        
        //   411: ldc_w           "Dst parent not found"
        //   414: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   417: aload_1        
        //   418: athrow         
        //   419: aload           9
        //   421: ifnull          444
        //   424: aload           9
        //   426: invokeinterface ax/u3/c.isCancelled:()Z
        //   431: ifeq            444
        //   434: new             Lax/b3/a;
        //   437: astore_1       
        //   438: aload_1        
        //   439: invokespecial   ax/b3/a.<init>:()V
        //   442: aload_1        
        //   443: athrow         
        //   444: aload_0        
        //   445: ldc_w           "googledrive write file"
        //   448: aload_1        
        //   449: invokespecial   com/alphainventor/filemanager/file/r.s0:(Ljava/lang/String;Ljava/lang/Exception;)Lax/b3/j;
        //   452: athrow         
        //   453: aload_2        
        //   454: ifnull          461
        //   457: aload_2        
        //   458: invokevirtual   java/io/InputStream.close:()V
        //   461: aload_1        
        //   462: athrow         
        //   463: astore_1       
        //   464: goto            372
        //   467: astore_2       
        //   468: goto            461
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  87     111    402    406    Ljava/io/IOException;
        //  87     111    398    402    Ljava/lang/SecurityException;
        //  87     111    394    398    Ljava/lang/NullPointerException;
        //  87     111    390    391    Ljava/lang/IllegalArgumentException;
        //  87     111    386    390    Any
        //  120    128    147    151    Ljava/io/IOException;
        //  120    128    143    147    Ljava/lang/SecurityException;
        //  120    128    139    143    Ljava/lang/NullPointerException;
        //  120    128    135    136    Ljava/lang/IllegalArgumentException;
        //  120    128    131    135    Any
        //  151    158    402    406    Ljava/io/IOException;
        //  151    158    398    402    Ljava/lang/SecurityException;
        //  151    158    394    398    Ljava/lang/NullPointerException;
        //  151    158    390    391    Ljava/lang/IllegalArgumentException;
        //  151    158    386    390    Any
        //  163    188    147    151    Ljava/io/IOException;
        //  163    188    143    147    Ljava/lang/SecurityException;
        //  163    188    139    143    Ljava/lang/NullPointerException;
        //  163    188    135    136    Ljava/lang/IllegalArgumentException;
        //  163    188    131    135    Any
        //  191    197    402    406    Ljava/io/IOException;
        //  191    197    398    402    Ljava/lang/SecurityException;
        //  191    197    394    398    Ljava/lang/NullPointerException;
        //  191    197    390    391    Ljava/lang/IllegalArgumentException;
        //  191    197    386    390    Any
        //  201    233    402    406    Ljava/io/IOException;
        //  201    233    398    402    Ljava/lang/SecurityException;
        //  201    233    394    398    Ljava/lang/NullPointerException;
        //  201    233    390    391    Ljava/lang/IllegalArgumentException;
        //  201    233    386    390    Any
        //  238    259    147    151    Ljava/io/IOException;
        //  238    259    143    147    Ljava/lang/SecurityException;
        //  238    259    139    143    Ljava/lang/NullPointerException;
        //  238    259    135    136    Ljava/lang/IllegalArgumentException;
        //  238    259    131    135    Any
        //  259    285    402    406    Ljava/io/IOException;
        //  259    285    398    402    Ljava/lang/SecurityException;
        //  259    285    394    398    Ljava/lang/NullPointerException;
        //  259    285    390    391    Ljava/lang/IllegalArgumentException;
        //  259    285    386    390    Any
        //  285    312    356    360    Ljava/io/IOException;
        //  285    312    352    356    Ljava/lang/SecurityException;
        //  285    312    348    352    Ljava/lang/NullPointerException;
        //  285    312    344    345    Ljava/lang/IllegalArgumentException;
        //  285    312    340    341    Any
        //  317    327    356    360    Ljava/io/IOException;
        //  317    327    352    356    Ljava/lang/SecurityException;
        //  317    327    348    352    Ljava/lang/NullPointerException;
        //  317    327    344    345    Ljava/lang/IllegalArgumentException;
        //  317    327    340    341    Any
        //  330    340    356    360    Ljava/io/IOException;
        //  330    340    352    356    Ljava/lang/SecurityException;
        //  330    340    348    352    Ljava/lang/NullPointerException;
        //  330    340    344    345    Ljava/lang/IllegalArgumentException;
        //  330    340    340    341    Any
        //  368    372    463    467    Ljava/io/IOException;
        //  373    386    356    360    Ljava/io/IOException;
        //  373    386    352    356    Ljava/lang/SecurityException;
        //  373    386    348    352    Ljava/lang/NullPointerException;
        //  373    386    344    345    Ljava/lang/IllegalArgumentException;
        //  373    386    340    341    Any
        //  406    419    356    360    Ljava/io/IOException;
        //  406    419    352    356    Ljava/lang/SecurityException;
        //  406    419    348    352    Ljava/lang/NullPointerException;
        //  406    419    344    345    Ljava/lang/IllegalArgumentException;
        //  406    419    340    341    Any
        //  424    444    340    341    Any
        //  444    453    340    341    Any
        //  457    461    467    471    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0372:
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
    
    private ArrayList<d> p0() throws IOException {
        final ArrayList list = new ArrayList();
        final a$c$d k = this.h.n().e().I("nextPageToken, files(id,name,parents)").K("trashed = false and mimeType = 'application/vnd.google-apps.folder'");
        do {
            Label_0237: {
                ax.p7.d d = null;
            Label_0224:
                while (true) {
                    ax.p7.c c = null;
                    String s = null;
                    Label_0180: {
                        Label_0177: {
                            List w;
                            try {
                                d = (ax.p7.d)((ax.g7.b)k).execute();
                                final Iterator iterator = d.n().iterator();
                                if (!iterator.hasNext()) {
                                    break Label_0224;
                                }
                                c = (ax.p7.c)iterator.next();
                                w = c.w();
                                if (w == null || w.size() == 0) {
                                    break Label_0177;
                                }
                                if (w.size() == 1) {
                                    s = (String)w.get(0);
                                    break Label_0180;
                                }
                            }
                            catch (final IOException ex) {
                                break Label_0237;
                            }
                            final StringBuilder sb = new StringBuilder();
                            sb.append("parent:");
                            sb.append(w.size());
                            b.g(sb.toString());
                            s = (String)w.get(0);
                            break Label_0180;
                        }
                        s = "no-parent-id";
                    }
                    if (s != null && c.r() != null) {
                        list.add((Object)new d(c, s));
                        continue;
                    }
                    b.f();
                    continue;
                }
                k.J(d.o());
                continue;
            }
            final IOException ex;
            ((Throwable)ex).printStackTrace();
            k.J((String)null);
        } while (k.G() != null && k.G().length() > 0);
        return (ArrayList<d>)list;
    }
    
    private String q0(final E e) {
        return this.r0(e.t());
    }
    
    private String r0(final String s) {
        return s;
    }
    
    private j s0(final String s, final Exception ex) {
        if (ex instanceof ax.e7.b) {
            final ax.e7.b b = (ax.e7.b)ex;
            final int b2 = ((ax.i7.t)b).b();
            if (b2 == 403 && b.e() != null) {
                final List n = b.e().n();
                if (n != null) {
                    final Iterator iterator = n.iterator();
                    while (iterator.hasNext()) {
                        final String n2 = ((a$a)iterator.next()).n();
                        if ("quotaExceeded".equals((Object)n2) || "storageQuotaExceeded".equals((Object)n2)) {
                            return (j)new s((Throwable)ex);
                        }
                        if ("forbidden".equals((Object)n2) || "insufficientPermissions".equals((Object)n2) || "insufficientParentPermissions".equals((Object)n2)) {
                            return (j)new ax.b3.e((Throwable)ex);
                        }
                    }
                }
            }
            else if (b2 == 404 && b.e() != null) {
                final List n3 = b.e().n();
                if (n3 != null) {
                    final Iterator iterator2 = n3.iterator();
                    while (iterator2.hasNext()) {
                        if ("notFound".equals((Object)((a$a)iterator2.next()).n())) {
                            return (j)new t((Throwable)ex);
                        }
                    }
                }
            }
        }
        else if (ex instanceof ax.i7.t) {
            final ax.i7.t t = (ax.i7.t)ex;
            final String c = t.c();
            final int b3 = t.b();
            if (b3 == 403 && "Forbidden".equalsIgnoreCase(c)) {
                return (j)new ax.b3.e((Throwable)ex);
            }
            if (b3 == 404 && "Not Found".equalsIgnoreCase(c)) {
                return (j)new t((Throwable)ex);
            }
        }
        if (((Throwable)ex).getMessage() != null && ((Throwable)ex).getMessage().startsWith("NetworkError")) {
            return (j)new q((Throwable)ex);
        }
        return ax.b3.d.b(s, ex);
    }
    
    private E t0() {
        return new E(this, "/.hidden-system-folder", true, true);
    }
    
    private String u0(final String s) {
        return s.replace((CharSequence)"'", (CharSequence)"\\'");
    }
    
    private String v0() {
        final SharedPreferences sharedPreferences = this.p().getSharedPreferences("GoogleDrivePrefs", 0);
        final int t = this.t();
        final StringBuilder sb = new StringBuilder();
        sb.append("account_name_");
        sb.append(t);
        return sharedPreferences.getString(sb.toString(), (String)null);
    }
    
    private HashSet<String> w0(final ArrayList<d> list, String s) {
        final Stack stack = new Stack();
        final HashSet set = new HashSet();
        set.add((Object)s);
        ((AbstractCollection)stack).add((Object)s);
        while (((AbstractCollection)stack).size() > 0) {
            s = (String)stack.pop();
            int n;
            for (int size = list.size(), i = 0; i < size; i = n) {
                final Object value = list.get(i);
                n = i + 1;
                final d d = (d)value;
                i = n;
                if (d.b.equals((Object)s)) {
                    set.add((Object)d.a.r());
                    ((AbstractCollection)stack).add((Object)d.a.r());
                }
            }
        }
        return (HashSet<String>)set;
    }
    
    private String y0(final E e) {
        String n = null;
        Label_0036: {
            if (e.l()) {
                final ax.p7.c g0 = e.g0();
                if (g0 != null && g0.x() != null) {
                    n = g0.x().n();
                    break Label_0036;
                }
            }
            n = null;
        }
        if (n == null) {
            return e.t();
        }
        return n;
    }
    
    private String z0(final ax.p7.c c) {
        if (c.w() == null || c.w().size() <= 0) {
            return "root";
        }
        final String s = (String)c.w().get(0);
        if (this.E0(s)) {
            return "root";
        }
        return s;
    }
    
    public InputStream A(String s, final String s2, final String s3) {
        Label_0060: {
            Label_0037: {
                if (s3 != null) {
                    Label_0113: {
                        try {
                            if (s3.startsWith("url=")) {
                                s = Uri.decode(s3.substring(4));
                                break Label_0060;
                            }
                        }
                        catch (final IOException ex) {
                            break Label_0113;
                        }
                        catch (final j ex) {
                            break Label_0113;
                        }
                        break Label_0037;
                    }
                    final IOException ex;
                    ((Throwable)ex).printStackTrace();
                    return null;
                }
            }
            final E e = (E)this.z(s2);
            if (e.i0() == null) {
                return null;
            }
            s = e.i0();
        }
        final ax.i7.s b = ((ax.g7.a)this.h).e().a(new g(s)).b();
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b.b((OutputStream)byteArrayOutputStream);
        return (InputStream)new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }
    
    public boolean B(final n n) {
        return true;
    }
    
    public List<n> C(final n n, final m.f f) throws j {
        if (!((ax.c3.b)n).n()) {
            throw new t();
        }
        if (!"/.hidden-system-folder".equals((Object)n.E())) {
            b.c(((ax.c3.b)n).isDirectory());
            final List<n> x0 = this.x0((E)n);
            for (final n n2 : x0) {
                if (((ax.c3.b)n2).isDirectory()) {
                    this.k.put((Object)n2.E(), (Object)n2);
                    this.l.put((Object)((ax.c3.b)n2).t(), (Object)n2.E());
                }
            }
            return x0;
        }
        throw new ax.b3.e();
    }
    
    public void D(final n n, final G g, final String s, final long n2, final Long n3, final p p9, final boolean b, final ax.u3.c c, final i i) throws j, ax.b3.a {
        b.a(((ax.c3.b)n).n());
        this.K0(n, g, s, n2, n3, b, false, c, i);
    }
    
    public void E(final n n, final n n2, final ax.u3.c c, final i i) throws j {
        b.a(((ax.c3.b)n2).n());
        if (((ax.c3.b)n).n()) {
            if (((ax.c3.b)n).isDirectory()) {
                this.I0(n.E());
            }
            long p4 = 0L;
            a$c$e f = null;
            Label_0188: {
                try {
                    p4 = ((ax.c3.b)n).p();
                    final ax.p7.c c2 = new ax.p7.c();
                    c2.F(new ax.m7.i(((ax.c3.b)n).q()));
                    c2.G(n2.B());
                    f = this.h.n().f(this.q0((E)n), c2);
                    if (n.T().equals((Object)n2.T())) {
                        break Label_0188;
                    }
                    final String b0 = this.B0(n);
                    final String b2 = this.B0(n2);
                    if (b2 == null) {
                        throw new j("Target parent does not exist");
                    }
                    if (b0 != null) {
                        f.H(b2);
                        f.J(b0);
                        break Label_0188;
                    }
                }
                catch (final SecurityException ex) {
                    throw this.s0("GD moveFile", (Exception)ex);
                }
                catch (final IOException ex) {
                    throw this.s0("GD moveFile", (Exception)ex);
                }
                throw new j("Source parent does not exist");
            }
            f.I("name");
            if (((ax.g7.b)f).execute() != null) {
                if (i != null) {
                    i.a(p4, p4);
                }
                return;
            }
            throw new j("result is null");
        }
        throw new t();
    }
    
    public void F(final n n, final n n2, final ax.u3.c c, final i i) throws j {
        b.a(((ax.c3.b)n2).n());
        if (((ax.c3.b)n).n()) {
            final E e = (E)n;
            final ax.p7.c c2 = new ax.p7.c();
            final long q = ((ax.c3.b)n).q();
            if (q >= 0L) {
                c2.F(new ax.m7.i(q));
            }
            c2.G(n2.B());
            if (!n.T().equals((Object)n2.T())) {
                final String b0 = this.B0(n2);
                if (b0 == null) {
                    throw new j("Dst parent not found");
                }
                c2.H(Arrays.asList((Object[])new String[] { b0 }));
            }
            try {
                final long p4 = ((ax.c3.b)n).p();
                if (((ax.g7.b)this.h.n().a(this.q0(e), c2)).execute() == null) {
                    throw new j("GoogleDrive copy returns null");
                }
                if (i != null) {
                    i.a(p4, p4);
                }
            }
            catch (final SecurityException ex) {
                throw this.s0("GD copyFile", (Exception)ex);
            }
            catch (final IOException ex) {
                throw this.s0("GD copyFile", (Exception)ex);
            }
            return;
        }
        throw new t("not existing source file");
    }
    
    public int G(final String s, final String s2) {
        return -1;
    }
    
    public List<n> G0(String s, final ArrayList<d> list, final String s2, final String s3, final String s4) throws IOException {
        final ArrayList list2 = new ArrayList();
        final a$c$d k = this.h.n().e().I("nextPageToken, files(kind,id,name,mimeType,parents,capabilities/canDownload,capabilities/canEdit,size,modifiedTime,createdTime,webContentLink,thumbnailLink,webViewLink,shortcutDetails,trashed)").K(s);
    Label_0177_Outer:
        do {
            Label_0240: {
                ax.p7.d d = null;
                Label_0226: {
                    while (true) {
                    Label_0184:
                        while (true) {
                            ax.p7.c c = null;
                            String z0 = null;
                            String s5 = null;
                            Label_0112: {
                                try {
                                    d = (ax.p7.d)((ax.g7.b)k).execute();
                                    final Iterator iterator = d.n().iterator();
                                    if (!iterator.hasNext()) {
                                        break Label_0226;
                                    }
                                    c = (ax.p7.c)iterator.next();
                                    z0 = this.z0(c);
                                    if (s4 != null && s4.equals((Object)z0)) {
                                        s5 = s3;
                                        break Label_0112;
                                    }
                                }
                                catch (final IOException ex) {
                                    break Label_0240;
                                }
                                s5 = null;
                            }
                            s = s5;
                            if (s5 == null) {
                                s = s5;
                                if (list != null) {
                                    s = this.D0(list, z0, s2, s3, s4);
                                    b.c(s != null);
                                }
                            }
                            if (s != null) {
                                break Label_0184;
                            }
                            Label_0187: {
                                try {
                                    s = ((n)this.C0(c, s2, s3, s4)).E();
                                    break Label_0187;
                                }
                                catch (final IOException ex) {
                                    break Label_0240;
                                }
                                break Label_0184;
                            }
                            ((List)list2).add((Object)new E(this, z0, z0, c, d0.Q(s, J0(c))));
                            continue Label_0177_Outer;
                        }
                        continue;
                    }
                }
                k.J(d.o());
                continue;
            }
            final IOException ex;
            ((Throwable)ex).printStackTrace();
            k.J((String)null);
        } while (k.G() != null && k.G().length() > 0);
        return (List<n>)list2;
    }
    
    public String H(final n n) {
        final E e = (E)n;
        if (e.i0() == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("url=");
        sb.append(Uri.encode(e.i0()));
        final String string = sb.toString();
        if (A.J(n)) {
            return B.a0(n, string);
        }
        return null;
    }
    
    public void I(final n n) throws j {
        if (this.h != null) {
            Label_0089: {
                try {
                    if (((ax.c3.b)n).n()) {
                        this.I0(n.E());
                        final ax.p7.c c = new ax.p7.c();
                        c.I(Boolean.TRUE);
                        ((ax.g7.b)this.h.n().f(((ax.c3.b)n).t(), c)).execute();
                        return;
                    }
                }
                catch (final SecurityException ex) {
                    throw new j((Throwable)ex);
                }
                catch (final IOException ex2) {
                    break Label_0089;
                }
                throw new t();
            }
            final IOException ex2;
            ((Throwable)ex2).printStackTrace();
            throw this.s0("GoogleDrive deleteFileRecursively", (Exception)ex2);
        }
        throw new h("Service is not connected!");
    }
    
    public InputStream J(final n n, final long n2) throws j {
        if (this.h != null) {
            Label_0117: {
                a$c$c d;
                try {
                    if (((E)n).g0() == null) {
                        break Label_0117;
                    }
                    d = this.h.n().d(this.y0((E)n));
                    if (n2 != 0L) {
                        final ax.i7.m s = ((ax.g7.b)d).s();
                        final StringBuilder sb = new StringBuilder();
                        sb.append("bytes=");
                        sb.append(n2);
                        sb.append("-");
                        s.O(sb.toString());
                    }
                }
                catch (final IllegalArgumentException ex) {
                    throw new j((Throwable)ex);
                }
                catch (final SecurityException ex2) {
                    throw this.s0("googledrive getInputstream", (Exception)ex2);
                }
                catch (final IOException ex2) {
                    throw this.s0("googledrive getInputstream", (Exception)ex2);
                }
                return d.l();
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("The file doesn't have any content stored on Drive : ");
            sb2.append(((ax.c3.b)n).n());
            throw new j(sb2.toString());
        }
        throw new h("Service is not connected!");
    }
    
    public void K(final Activity activity, final Fragment fragment, final c$a c$a) {
        c$a.B();
        final e m = new e((L)fragment, this.v0(), c$a);
        m.i(new Object[0]);
        this.m = m;
    }
    
    public boolean L() {
        return false;
    }
    
    public boolean M(n e) {
        try {
            final E e2 = (E)this.z(((n)e).T());
            if (!e2.n()) {
                return false;
            }
            if (((ax.c3.b)e).n()) {
                return false;
            }
            final ax.p7.c c = new ax.p7.c();
            c.G(((n)e).B());
            c.E("application/vnd.google-apps.folder");
            c.H(Arrays.asList((Object[])new String[] { this.y0(e2) }));
            final ax.p7.c c2 = (ax.p7.c)((ax.g7.b)this.h.n().b(c)).execute();
            if (c2 != null) {
                e = (j)((n)e).E();
                final String t = e2.t();
                final String y0 = this.y0(e2);
                try {
                    final E e3 = new E(this, t, y0, c2, (String)e);
                    this.k.put((Object)e, (Object)e3);
                    this.l.put((Object)((ax.c3.b)e3).t(), (Object)((n)e3).E());
                    return true;
                }
                catch (final SecurityException ex) {}
                catch (final j e) {}
                catch (final IOException e) {}
            }
        }
        catch (final SecurityException ex2) {}
        catch (final j e) {
            goto Label_0178;
        }
        catch (final IOException e) {
            goto Label_0178;
        }
        return false;
    }
    
    public boolean N(n execute) {
        try {
            final E e = (E)this.z(((n)execute).T());
            if (!e.n()) {
                return false;
            }
            if (((ax.c3.b)execute).n()) {
                return false;
            }
            final ax.p7.c c = new ax.p7.c();
            c.G(((n)execute).B());
            c.E(((ax.c3.b)execute).s());
            c.H(Arrays.asList((Object[])new String[] { this.y0(e) }));
            execute = (j)((ax.g7.b)this.h.n().b(c)).execute();
            return execute != null;
        }
        catch (final j execute) {}
        catch (final IOException ex) {}
        ((Throwable)execute).printStackTrace();
        return false;
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
        return this.j;
    }
    
    public void b() {
        this.k.clear();
        this.l.clear();
    }
    
    public boolean g0() {
        return true;
    }
    
    public boolean h0() {
        return true;
    }
    
    public void j0(final n n, final G g, final String s, final long n2, final Long n3, final p p9, final boolean b, final ax.u3.c c, final i i) throws j, ax.b3.a {
        this.K0(n, g, s, n2, n3, b, true, c, i);
    }
    
    void m(final n n, String t, final boolean b, final boolean b2, final ax.g3.h h, ax.u3.c u0) throws j {
        monitorenter(this);
        Label_0608: {
            if (!b2) {
                try {
                    this.o(n, t, b, b2, h, u0);
                    monitorexit(this);
                    return;
                }
                finally {
                    break Label_0608;
                }
            }
            Object g0 = null;
            Label_0572: {
                try {
                    u0 = (ax.u3.c)this.u0(t);
                    if (d0.E(n)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("name contains '");
                        sb.append((String)u0);
                        sb.append("' and trashed = false");
                        g0 = this.G0(sb.toString(), null, null, null, null);
                        break Label_0572;
                    }
                }
                catch (final SecurityException iterator) {
                    throw this.s0("do search", (Exception)iterator);
                }
                catch (final IOException iterator) {
                    throw this.s0("do search", (Exception)iterator);
                }
                final List g2 = ax.Z2.b.k().g(n);
                if (g2 != null) {
                    final List h2 = B.h(ax.c3.q.g((List)new ArrayList((Collection)g2), ax.c3.q.c("Search")), t, b, false);
                    if (h2 != null && !h2.isEmpty()) {
                        h.Y(h2, false);
                    }
                }
                final String e = n.E();
                t = ((ax.c3.b)n).t();
                final String y0 = this.y0((E)n);
                final ArrayList<d> p5 = this.p0();
                final HashSet<String> w0 = this.w0(p5, y0);
                final StringBuilder sb2 = new StringBuilder();
                final Iterator iterator = w0.iterator();
                int n2 = 1;
                int n3 = 0;
                while (iterator.hasNext()) {
                    try {
                        final String s = (String)iterator.next();
                        if (n2 != 0) {
                            n2 = 0;
                        }
                        else {
                            sb2.append(" or ");
                        }
                        sb2.append("'");
                        sb2.append(s);
                        sb2.append("' in parents");
                        if (++n3 < 300) {
                            continue;
                        }
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("name contains '");
                        sb3.append((String)u0);
                        sb3.append("' and (");
                        sb3.append(sb2.toString());
                        sb3.append(") and trashed = false");
                        final String string = sb3.toString();
                        final ArrayList list = new ArrayList();
                        list.addAll((Collection)this.G0(string, p5, t, e, y0));
                        final List h3 = B.h((List)list, (String)null, b, false);
                        if (h3 != null && !h3.isEmpty()) {
                            h.Y(h3, false);
                        }
                    }
                    catch (final SecurityException ex) {
                        throw this.s0("do search", (Exception)iterator);
                    }
                    catch (final IOException ex2) {
                        throw this.s0("do search", (Exception)iterator);
                    }
                    finally {
                        break Label_0608;
                    }
                    sb2.setLength(0);
                    n2 = 1;
                    n3 = 0;
                }
                g0 = new ArrayList();
                if (sb2.length() > 0) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("name contains '");
                    sb4.append((String)u0);
                    sb4.append("' and (");
                    sb4.append(sb2.toString());
                    sb4.append(") and trashed = false");
                    ((List)g0).addAll((Collection)this.G0(sb4.toString(), p5, t, e, y0));
                }
            }
            if (g0 == null) {
                monitorexit(this);
                return;
            }
            h.Y(B.h((List)g0, (String)null, b, false), true);
            monitorexit(this);
            return;
        }
        monitorexit(this);
    }
    
    public void n(final n n) throws j {
        if (n instanceof E) {
            try {
                if (((ax.c3.b)n).l()) {
                    final ax.p7.c g0 = ((E)n).g0();
                    if (g0 != null && g0.x() != null) {
                        final ax.p7.c c = (ax.p7.c)((ax.g7.b)this.h.n().d(g0.x().n()).H("size")).execute();
                        if (c != null && c.y() != null) {
                            ((E)n).l0((long)c.y());
                        }
                    }
                }
            }
            catch (final IOException ex) {
                throw new j((Throwable)ex);
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid File Type :");
        sb.append(n.getClass().getName());
        throw new j(sb.toString());
    }
    
    public List<n> x0(final E ex) throws j {
        final ArrayList list = new ArrayList();
        final String y0 = this.y0((E)ex);
        if (this.a()) {
            while (true) {
                while (true) {
                    a$c$d k = null;
                    ax.p7.d d = null;
                    try {
                        final a$c$d i = this.h.n().e().I("nextPageToken, files(kind,id,name,mimeType,parents,capabilities/canDownload,capabilities/canEdit,size,modifiedTime,createdTime,webContentLink,thumbnailLink,webViewLink,shortcutDetails,trashed)");
                        final StringBuilder sb = new StringBuilder();
                        sb.append("'");
                        sb.append(y0);
                        sb.append("' in parents and trashed = false");
                        k = i.K(sb.toString());
                        d = (ax.p7.d)((ax.g7.b)k).execute();
                        for (final ax.p7.c c : d.n()) {
                            final String t = ((E)ex).t();
                            final String y2 = this.y0((E)ex);
                            final String q = d0.Q(((n)ex).E(), J0(c));
                            try {
                                ((List)list).add((Object)new E(this, t, y2, c, q));
                            }
                            catch (final OutOfMemoryError outOfMemoryError) {}
                            catch (final NullPointerException ex2) {}
                            catch (final IllegalArgumentException ex) {}
                            catch (final SecurityException ex3) {}
                            catch (final IOException ex) {}
                        }
                    }
                    catch (final OutOfMemoryError ex) {
                        goto Label_0191;
                    }
                    catch (final NullPointerException ex4) {}
                    catch (final IllegalArgumentException ex) {
                        goto Label_0215;
                    }
                    catch (final SecurityException ex5) {}
                    catch (final IOException ex) {
                        goto Label_0223;
                    }
                    k.J(d.o());
                    if (k.G() == null) {
                        break;
                    }
                    if (k.G().length() <= 0) {
                        break;
                    }
                    continue;
                }
            }
        }
        return (List<n>)list;
    }
    
    public k0 y() throws j {
        Long n;
        Long o;
        try {
            final ax.p7.a a = (ax.p7.a)((ax.g7.b)this.h.m().a().H("storageQuota")).execute();
            if (a == null || a.n() == null) {
                throw new j("No storage Quota");
            }
            n = a.n().n();
            o = a.n().o();
            if (n != null && o != null) {
                return new k0((long)n, (long)o);
            }
        }
        catch (final SecurityException ex) {
            throw this.s0("GD getStorageSpace", (Exception)ex);
        }
        catch (final IOException ex) {
            throw this.s0("GD getStorageSpace", (Exception)ex);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("no total :");
        sb.append((Object)n);
        sb.append(",");
        sb.append((Object)o);
        throw new j(sb.toString());
    }
    
    public n z(final String ex) throws j {
        if (this.h == null) {
            throw new h("Service is not connected!");
        }
        if (this.k.containsKey((Object)ex)) {
            return (n)this.k.get((Object)ex);
        }
        if (d0.a.equals((Object)ex)) {
            return (n)new E(this, (String)ex);
        }
        if ("/.hidden-system-folder".equals((Object)ex)) {
            return (n)this.t0();
        }
        Label_0549: {
            E e = null;
            while (true) {
            Label_0286:
                while (true) {
                    String h = null;
                    String y0 = null;
                    try {
                        e = (E)this.z(d0.r((String)ex));
                        h = d0.h((String)ex);
                        final String u0 = this.u0(h);
                        if (!e.n() || !e.isDirectory()) {
                            return (n)new E(this, (String)ex);
                        }
                        y0 = this.y0(e);
                        final StringBuilder sb = new StringBuilder();
                        sb.append("'");
                        sb.append(y0);
                        sb.append("' in parents and name = '");
                        sb.append(u0);
                        sb.append("' and trashed = false");
                        final List<ax.p7.c> h2 = this.H0(sb.toString());
                        if (h2 != null && h2.size() > 0) {
                            final ax.p7.c c = (ax.p7.c)h2.get(0);
                            final String t = e.t();
                            final String y2 = this.y0(e);
                            try {
                                final E e2 = new E(this, t, y2, c, (String)ex);
                                if (((ax.c3.b)e2).isDirectory()) {
                                    this.k.put((Object)ex, (Object)e2);
                                    this.l.put((Object)((ax.c3.b)e2).t(), (Object)((n)e2).E());
                                    return (n)e2;
                                }
                                return (n)e2;
                            }
                            catch (final IllegalArgumentException ex2) {}
                            catch (final SecurityException ex) {
                                goto Label_0274;
                            }
                            catch (final IOException ex) {
                                goto Label_0274;
                            }
                            catch (final NullPointerException ex3) {}
                            break Label_0549;
                        }
                    }
                    catch (final IllegalArgumentException ex4) {}
                    catch (final SecurityException ex) {
                        goto Label_0293;
                    }
                    catch (final IOException ex) {
                        goto Label_0293;
                    }
                    catch (final NullPointerException ex) {
                        continue Label_0286;
                    }
                    if (!h.contains((CharSequence)"_")) {
                        break;
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("'");
                    sb2.append(y0);
                    sb2.append("' in parents and trashed = false");
                    final List<ax.p7.c> h3 = this.H0(sb2.toString());
                    if (h3 != null && h3.size() > 0) {
                        for (final ax.p7.c c2 : h3) {
                            if (J0(c2).equals((Object)h)) {
                                final String t2 = e.t();
                                final String y3 = this.y0(e);
                                try {
                                    final E e3 = new E(this, t2, y3, c2, (String)ex);
                                    if (((ax.c3.b)e3).isDirectory()) {
                                        this.k.put((Object)ex, (Object)e3);
                                        this.l.put((Object)((ax.c3.b)e3).t(), (Object)((n)e3).E());
                                    }
                                    return (n)e3;
                                }
                                catch (final IllegalArgumentException ex5) {}
                                catch (final SecurityException ex) {
                                    goto Label_0490;
                                }
                                catch (final IOException ex) {
                                    goto Label_0490;
                                }
                                catch (final NullPointerException ex) {
                                    continue Label_0286;
                                }
                                break;
                            }
                        }
                        break;
                    }
                    break;
                }
                break;
            }
            return (n)new E(this, e.t(), this.y0(e), (String)ex);
        }
        ax.Ha.c.h().f().b("GoogleDrive queryFiles null").l((Throwable)ex).h();
        throw this.s0("GoogleDrive getFileInfo null", (Exception)ex);
    }
    
    public static class c extends T
    {
        Context a;
        
        public c(final Context a) {
            this.a = a;
        }
        
        public void a(final int n) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("GoogleDrivePrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("display_name_");
            sb.append(n);
            final SharedPreferences$Editor remove = edit.remove(sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("account_name_");
            sb2.append(n);
            final SharedPreferences$Editor remove2 = remove.remove(sb2.toString());
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("location_name_");
            sb3.append(n);
            final SharedPreferences$Editor remove3 = remove2.remove(sb3.toString());
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("created_");
            sb4.append(n);
            final SharedPreferences$Editor remove4 = remove3.remove(sb4.toString());
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("sortindex_");
            sb5.append(n);
            remove4.remove(sb5.toString()).commit();
        }
        
        public ax.Z2.s f(final int n) {
            final SharedPreferences sharedPreferences = this.a.getSharedPreferences("GoogleDrivePrefs", 0);
            final StringBuilder sb = new StringBuilder();
            sb.append("display_name_");
            sb.append(n);
            String string = sharedPreferences.getString(sb.toString(), (String)null);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("account_name_");
            sb2.append(n);
            final String string2 = sharedPreferences.getString(sb2.toString(), (String)null);
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                string = string2;
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("location_name_");
            sb3.append(n);
            final String string3 = sb3.toString();
            final ax.Q2.f o0 = ax.Q2.f.O0;
            final String string4 = sharedPreferences.getString(string3, o0.M(this.a));
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("created_");
            sb4.append(n);
            final long long1 = sharedPreferences.getLong(sb4.toString(), 0L);
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("sortindex_");
            sb5.append(n);
            return new ax.Z2.s(o0, n, string4, string, (String)null, (String)null, long1, sharedPreferences.getLong(sb5.toString(), 0L));
        }
        
        public void g(final int n, final String s) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("GoogleDrivePrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("location_name_");
            sb.append(n);
            edit.putString(sb.toString(), s);
            edit.commit();
        }
        
        public void j(final int n, final long n2) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("GoogleDrivePrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("sortindex_");
            sb.append(n);
            edit.putLong(sb.toString(), n2);
            edit.apply();
        }
        
        public void k(final String s, final k k) {
            final ax.Q2.f o0 = ax.Q2.f.O0;
            k.b(o0);
            int m = this.m();
            final int l = this.l(s);
            if (l >= 0) {
                m = l;
            }
            this.p(m, s);
            k.c(o0, m);
        }
        
        int l(final String s) {
            final Context a = this.a;
            int i = 0;
            for (SharedPreferences sharedPreferences = a.getSharedPreferences("GoogleDrivePrefs", 0); i < sharedPreferences.getInt("count", 0); ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("account_name_");
                sb.append(i);
                if (s.equals((Object)sharedPreferences.getString(sb.toString(), (String)null))) {
                    return i;
                }
            }
            return -1;
        }
        
        int m() {
            return this.a.getSharedPreferences("GoogleDrivePrefs", 0).getInt("count", 0);
        }
        
        public Intent n(final String s) {
            if (s != null) {
                return ax.J5.a.a(new Account(s, "com.google"), (ArrayList)null, new String[] { "com.google" }, true, (String)null, (String)null, (String[])null, (Bundle)null);
            }
            final ArrayList list = new ArrayList();
            list.add((Object)"https://www.googleapis.com/auth/drive");
            return ax.d7.a.e(this.a, (Collection)list).c();
        }
        
        public List<ax.Z2.s> o() {
            final ArrayList list = new ArrayList();
            final Context a = this.a;
            int i = 0;
            for (SharedPreferences sharedPreferences = a.getSharedPreferences("GoogleDrivePrefs", 0); i < sharedPreferences.getInt("count", 0); ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("account_name_");
                sb.append(i);
                if (sharedPreferences.getString(sb.toString(), (String)null) != null) {
                    ((List)list).add((Object)this.f(i));
                }
            }
            return (List<ax.Z2.s>)list;
        }
        
        public void p(final int n, final String s) {
            final Context a = this.a;
            boolean b = false;
            final SharedPreferences sharedPreferences = a.getSharedPreferences("GoogleDrivePrefs", 0);
            if (n >= sharedPreferences.getInt("count", 0)) {
                b = true;
            }
            final SharedPreferences$Editor edit = sharedPreferences.edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("account_name_");
            sb.append(n);
            final SharedPreferences$Editor putString = edit.putString(sb.toString(), s);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("display_name_");
            sb2.append(n);
            final SharedPreferences$Editor putString2 = putString.putString(sb2.toString(), "");
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("location_name_");
            sb3.append(n);
            putString2.putString(sb3.toString(), ax.Q2.f.O0.M(this.a));
            if (b) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("created_");
                sb4.append(n);
                edit.putLong(sb4.toString(), System.currentTimeMillis());
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("sortindex_");
                sb5.append(n);
                edit.putLong(sb5.toString(), System.currentTimeMillis());
            }
            if (b) {
                edit.putInt("count", n + 1);
            }
            edit.commit();
        }
    }
    
    static class d
    {
        ax.p7.c a;
        String b;
        
        d(final ax.p7.c a, final String b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private class e extends ax.u3.q<Object, Void, Integer>
    {
        private c$a h;
        String i;
        L j;
        boolean k;
        private Intent l;
        private Throwable m;
        final r n;
        
        public e(final r n, final L j, final String i, final c$a h) {
            this.n = n;
            super(q$e.c0);
            this.i = i;
            this.h = h;
            this.j = j;
            this.k = false;
            this.l = null;
        }
        
        private int w() {
            boolean b = true;
            final boolean b2 = true;
            Label_0338: {
                try {
                    final ArrayList list = new ArrayList();
                    list.add((Object)"https://www.googleapis.com/auth/drive");
                    final ax.d7.a e = ax.d7.a.e(this.n.p(), (Collection)list);
                    e.d(this.i);
                    this.n.h = new a$b((w)new ax.j7.e(), (ax.l7.c)new ax.a7.a(), this.z((ax.i7.r)e)).j(this.n.p().getString(2131951672)).h();
                    final String n = ((ax.p7.a)((ax.g7.b)this.n.h.m().a().H("user")).execute()).o().n();
                    final SharedPreferences sharedPreferences = this.n.p().getSharedPreferences("GoogleDrivePrefs", 0);
                    if (n == null) {
                        break Label_0338;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("display_name_");
                    sb.append(this.n.t());
                    if (!n.equals((Object)sharedPreferences.getString(sb.toString(), (String)null))) {
                        final SharedPreferences$Editor edit = sharedPreferences.edit();
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("display_name_");
                        sb2.append(this.n.t());
                        edit.putString(sb2.toString(), n).apply();
                        this.k = true;
                    }
                    break Label_0338;
                }
                catch (final NoClassDefFoundError m) {
                    break Label_0338;
                }
                catch (final ExceptionInInitializerError m) {
                    break Label_0338;
                }
                catch (final Exception i) {
                    ((Throwable)i).printStackTrace();
                    this.m = (Throwable)i;
                    if ("NetworkError".equals((Object)((Throwable)i).getMessage())) {
                        return -9;
                    }
                    ax.Ha.c.h().f().d("!!GoogleDriveAuth 5!!").l((Throwable)i).h();
                    if (i instanceof ax.d7.b) {
                        final ax.D5.a a = ((ax.d7.b)i).a();
                        if (a != null && "UNREGISTERED_ON_API_CONSOLE".equals((Object)((Throwable)a).getMessage()) && !ax.u3.B.J(this.n.p())) {
                            return -8;
                        }
                    }
                    return -2;
                    this.n.i = ((ax.p7.c)((ax.g7.b)this.n.h.n().d("root")).execute()).r();
                    return 0;
                    final NoClassDefFoundError m;
                    ax.Q2.d.b(this.m = (Throwable)m);
                    return -2;
                }
                catch (final SecurityException ex) {}
                catch (final IllegalArgumentException ex2) {
                    final Throwable t;
                    ax.Ha.c.h().f().d("!!GoogleDriveAuth 4!!").l(t).h();
                    return -5;
                    final Throwable t2;
                    ax.c7.a a2 = null;
                Label_0725_Outer:
                    while (true) {
                        while (true) {
                            break Label_0725;
                            final ax.Ha.b d;
                            Label_0590: {
                                d = ax.Ha.c.h().f().d("!!GoogleDriveAuth 2!!");
                            }
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("ex:");
                            sb3.append(t2.getMessage());
                            sb3.append(", account not null : ");
                            sb3.append(this.i != null && b2);
                            d.g((Object)sb3.toString()).h();
                            return -6;
                            final StringBuilder sb4;
                            sb4.append(b);
                            final ax.Ha.b l;
                            l.g((Object)sb4.toString()).h();
                            return -4;
                            Label_0723:
                            b = false;
                            continue;
                        }
                        t2.printStackTrace();
                        a2 = new ax.c7.a(this.n.p());
                        final Account[] b3 = a2.b();
                        iftrue(Label_0678:)(b3 == null || b3.length <= 0);
                        break Label_0725_Outer;
                        Label_0678: {
                            final ax.Ha.b l = ax.Ha.c.h().f().d("!!GoogleDriveAuth 3!!").l(t2);
                        }
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("account not null : ");
                        iftrue(Label_0723:)(this.i == null);
                        continue Label_0725_Outer;
                    }
                    iftrue(Label_0590:)(a2.a(this.i) != null);
                    final Logger n2 = r.n;
                    final StringBuilder sb5 = new StringBuilder();
                    sb5.append("Google Account '");
                    sb5.append(this.i);
                    sb5.append("' is not found in the device");
                    n2.severe(sb5.toString());
                    ax.Ha.c.h().f().d("!!GoogleDriveAuth 1!!").l(t2).h();
                    return -3;
                }
                catch (final ax.d7.d d2) {}
            }
            final ax.d7.d d3;
            ((Throwable)d3).printStackTrace();
            this.l = d3.c();
            return -1;
        }
        
        private ax.i7.r z(final ax.i7.r r) {
            return (ax.i7.r)new ax.i7.r(this, r) {
                final ax.i7.r a;
                final e b;
                
                public void b(final ax.i7.p p) throws IOException {
                    this.a.b(p);
                    p.y(45000);
                }
            };
        }
        
        protected Integer x(final Object... p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        com/alphainventor/filemanager/file/r$e.n:Lcom/alphainventor/filemanager/file/r;
            //     4: invokevirtual   com/alphainventor/filemanager/file/m.i:()V
            //     7: aload_0        
            //     8: invokespecial   com/alphainventor/filemanager/file/r$e.w:()I
            //    11: istore_3       
            //    12: iload_3        
            //    13: bipush          -6
            //    15: if_icmpeq       32
            //    18: iload_3        
            //    19: bipush          -3
            //    21: if_icmpeq       32
            //    24: iload_3        
            //    25: istore_2       
            //    26: iload_3        
            //    27: bipush          -4
            //    29: if_icmpne       238
            //    32: ldc2_w          500
            //    35: invokestatic    java/lang/Thread.sleep:(J)V
            //    38: goto            45
            //    41: astore_1       
            //    42: goto            250
            //    45: aload_0        
            //    46: invokespecial   com/alphainventor/filemanager/file/r$e.w:()I
            //    49: istore_2       
            //    50: iconst_0       
            //    51: istore          4
            //    53: iconst_0       
            //    54: istore          5
            //    56: iload_2        
            //    57: ifne            140
            //    60: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
            //    63: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
            //    66: ldc_w           "GoogleDriveAuth RETRY SUCCESS"
            //    69: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
            //    72: astore          6
            //    74: new             Ljava/lang/StringBuilder;
            //    77: astore_1       
            //    78: aload_1        
            //    79: invokespecial   java/lang/StringBuilder.<init>:()V
            //    82: aload_1        
            //    83: ldc_w           "result:"
            //    86: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    89: pop            
            //    90: aload_1        
            //    91: iload_3        
            //    92: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
            //    95: pop            
            //    96: aload_1        
            //    97: ldc_w           ",acocunt not null:"
            //   100: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   103: pop            
            //   104: iload           5
            //   106: istore          4
            //   108: aload_0        
            //   109: getfield        com/alphainventor/filemanager/file/r$e.i:Ljava/lang/String;
            //   112: ifnull          118
            //   115: iconst_1       
            //   116: istore          4
            //   118: aload_1        
            //   119: iload           4
            //   121: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
            //   124: pop            
            //   125: aload           6
            //   127: aload_1        
            //   128: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   131: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
            //   134: invokevirtual   ax/Ha/b.h:()V
            //   137: goto            214
            //   140: iload_3        
            //   141: bipush          -6
            //   143: if_icmpne       214
            //   146: iload_2        
            //   147: bipush          -6
            //   149: if_icmpne       214
            //   152: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
            //   155: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
            //   158: ldc_w           "GoogleDriveAuth RETRY FAILURE"
            //   161: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
            //   164: astore_1       
            //   165: new             Ljava/lang/StringBuilder;
            //   168: astore          6
            //   170: aload           6
            //   172: invokespecial   java/lang/StringBuilder.<init>:()V
            //   175: aload           6
            //   177: ldc_w           "acocunt not null:"
            //   180: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   183: pop            
            //   184: aload_0        
            //   185: getfield        com/alphainventor/filemanager/file/r$e.i:Ljava/lang/String;
            //   188: ifnull          194
            //   191: iconst_1       
            //   192: istore          4
            //   194: aload           6
            //   196: iload           4
            //   198: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
            //   201: pop            
            //   202: aload_1        
            //   203: aload           6
            //   205: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   208: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
            //   211: invokevirtual   ax/Ha/b.h:()V
            //   214: iload_2        
            //   215: bipush          -3
            //   217: if_icmpeq       226
            //   220: iload_2        
            //   221: bipush          -4
            //   223: if_icmpne       238
            //   226: invokestatic    ax/X2/Q.l0:()Z
            //   229: ifne            238
            //   232: bipush          -7
            //   234: istore_2       
            //   235: goto            238
            //   238: aload_0        
            //   239: getfield        com/alphainventor/filemanager/file/r$e.n:Lcom/alphainventor/filemanager/file/r;
            //   242: invokevirtual   com/alphainventor/filemanager/file/m.j:()V
            //   245: iload_2        
            //   246: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //   249: areturn        
            //   250: aload_0        
            //   251: getfield        com/alphainventor/filemanager/file/r$e.n:Lcom/alphainventor/filemanager/file/r;
            //   254: invokevirtual   com/alphainventor/filemanager/file/m.j:()V
            //   257: aload_1        
            //   258: athrow         
            //   259: astore_1       
            //   260: goto            45
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                            
            //  -----  -----  -----  -----  --------------------------------
            //  7      12     41     45     Any
            //  32     38     259    263    Ljava/lang/InterruptedException;
            //  32     38     41     45     Any
            //  45     50     41     45     Any
            //  60     104    41     45     Any
            //  108    115    41     45     Any
            //  118    137    41     45     Any
            //  152    184    41     45     Any
            //  184    191    41     45     Any
            //  194    214    41     45     Any
            //  226    232    41     45     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0032:
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
        
        protected void y(final Integer n) {
            if (this.k) {
                final L j = this.j;
                if (j != null) {
                    j.va();
                }
            }
            if (n == 0) {
                this.n.j = true;
                this.h.T(true, (Object)null);
                return;
            }
            this.n.j = false;
            if (n == -1) {
                this.h.T(false, (Object)this.l);
                return;
            }
            if (n == -2) {
                this.h.T(false, (Object)this.m);
                return;
            }
            if (n == -3) {
                this.h.T(false, (Object)this.n.p().getString(2131952085, new Object[] { this.i }));
                return;
            }
            if (n == -4 || n == -5 || n == -6) {
                this.h.T(false, (Object)this.n.p().getString(2131951797));
                return;
            }
            if (n == -7) {
                this.h.T(false, (Object)new f(this.i));
                return;
            }
            if (n == -8) {
                final StringBuilder sb = new StringBuilder();
                sb.append(this.n.p().getString(2131952325, new Object[] { ax.Q2.f.O0 }));
                sb.append(" : THIS APP IS NOT GENUINE");
                this.h.T(false, (Object)sb.toString());
                return;
            }
            if (n == -9) {
                this.h.T(false, (Object)this.n.p().getString(2131951948));
                return;
            }
            this.h.T(false, (Object)this.m);
        }
    }
    
    public static class f
    {
        public String a;
        
        f(final String a) {
            this.a = a;
        }
    }
}
