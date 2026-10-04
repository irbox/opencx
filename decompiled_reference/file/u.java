package com.alphainventor.filemanager.file;

import ax.b3.C;
import ax.u3.q$e;
import android.content.Context;
import ax.u3.q;
import ax.c3.k0;
import ax.g3.h;
import androidx.fragment.app.Fragment;
import android.app.Activity;
import ax.b3.H;
import ax.Q2.o;
import java.io.BufferedInputStream;
import ax.h5.f;
import ax.c3.B;
import ax.c3.z;
import ax.b3.a;
import ax.g3.i;
import ax.u3.c;
import ax.c3.G;
import ax.b3.j;
import java.util.List;
import java.io.InputStream;
import ax.u3.b;
import ax.c3.d0;
import java.io.IOException;
import ax.h5.e;

public class U extends m
{
    private e h;
    
    private boolean k0(final n n, final boolean b) {
        Label_0084: {
            Label_0077: {
                Label_0070: {
                    e l0;
                    String b2;
                    try {
                        if (((ax.c3.b)n).n()) {
                            return false;
                        }
                        l0 = this.l0(n.T());
                        if (l0 == null) {
                            return false;
                        }
                        b2 = n.B();
                        if (b) {
                            l0.n(b2);
                            return true;
                        }
                    }
                    catch (final ArrayIndexOutOfBoundsException ex) {
                        break Label_0070;
                    }
                    catch (final IllegalArgumentException ex2) {
                        break Label_0077;
                    }
                    catch (final IOException ex3) {
                        break Label_0084;
                    }
                    l0.p0(b2).close();
                    return true;
                }
                final ArrayIndexOutOfBoundsException ex;
                ((Throwable)ex).printStackTrace();
                return false;
            }
            final IllegalArgumentException ex2;
            ((Throwable)ex2).printStackTrace();
            return false;
        }
        final IOException ex3;
        ((Throwable)ex3).printStackTrace();
        return false;
    }
    
    private e l0(final String s) throws IOException {
        b.c(d0.B(s));
        final e h = this.h;
        if (h == null) {
            return null;
        }
        if (d0.D(this.v(), s)) {
            return h;
        }
        return h.H0(s.substring(1));
    }
    
    public InputStream A(final String s, final String s2, final String s3) {
        if (!this.a()) {
            return null;
        }
        try {
            return this.J(this.m0(s2), 0L);
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
            return null;
        }
    }
    
    public boolean B(final n n) {
        return false;
    }
    
    public List<n> C(final n p0, final m.f p1) throws j {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface ax/c3/b.n:()Z
        //     6: ifeq            464
        //     9: aload_1        
        //    10: invokeinterface ax/c3/b.isDirectory:()Z
        //    15: invokestatic    ax/u3/b.c:(Z)V
        //    18: new             Ljava/util/ArrayList;
        //    21: astore_2       
        //    22: aload_2        
        //    23: invokespecial   java/util/ArrayList.<init>:()V
        //    26: aload_0        
        //    27: aload_1        
        //    28: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //    31: invokespecial   com/alphainventor/filemanager/file/U.l0:(Ljava/lang/String;)Lax/h5/e;
        //    34: astore          6
        //    36: aload           6
        //    38: ifnull          412
        //    41: aload           6
        //    43: invokeinterface ax/h5/e.isDirectory:()Z
        //    48: ifeq            400
        //    51: aload           6
        //    53: invokeinterface ax/h5/e.B0:()[Lax/h5/e;
        //    58: astore          6
        //    60: aload           6
        //    62: ifnull          398
        //    65: aload           6
        //    67: arraylength    
        //    68: istore          4
        //    70: iconst_0       
        //    71: istore_3       
        //    72: iload_3        
        //    73: iload           4
        //    75: if_icmpge       398
        //    78: aload           6
        //    80: iload_3        
        //    81: aaload         
        //    82: astore          7
        //    84: aload           7
        //    86: invokeinterface ax/h5/e.getName:()Ljava/lang/String;
        //    91: astore          8
        //    93: aload           8
        //    95: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    98: ifne            189
        //   101: aload           8
        //   103: invokestatic    ax/c3/d0.A:(Ljava/lang/String;)Z
        //   106: ifeq            189
        //   109: aload_1        
        //   110: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   113: aload           8
        //   115: invokestatic    ax/c3/d0.Q:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   118: astore          9
        //   120: new             Lcom/alphainventor/filemanager/file/V;
        //   123: astore          8
        //   125: aload           8
        //   127: aload_0        
        //   128: aload           9
        //   130: aload           7
        //   132: invokespecial   com/alphainventor/filemanager/file/V.<init>:(Lcom/alphainventor/filemanager/file/U;Ljava/lang/String;Lax/h5/e;)V
        //   135: aload           7
        //   137: invokeinterface ax/h5/e.isDirectory:()Z
        //   142: istore          5
        //   144: iload           5
        //   146: ifeq            169
        //   149: aload           8
        //   151: aload           7
        //   153: invokeinterface ax/h5/e.c0:()[Ljava/lang/String;
        //   158: arraylength    
        //   159: invokevirtual   com/alphainventor/filemanager/file/n.d0:(I)V
        //   162: goto            169
        //   165: astore_1       
        //   166: goto            422
        //   169: aload_2        
        //   170: aload           8
        //   172: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   177: pop            
        //   178: goto            392
        //   181: astore_1       
        //   182: goto            446
        //   185: astore_1       
        //   186: goto            455
        //   189: aload           8
        //   191: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   194: istore          5
        //   196: iload           5
        //   198: ifeq            298
        //   201: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   204: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   207: ldc             "USB CHILD NAME 1"
        //   209: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   212: astore          10
        //   214: new             Ljava/lang/StringBuilder;
        //   217: astore          9
        //   219: aload           9
        //   221: invokespecial   java/lang/StringBuilder.<init>:()V
        //   224: aload           9
        //   226: ldc             "name:"
        //   228: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   231: pop            
        //   232: aload           9
        //   234: aload           8
        //   236: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   239: pop            
        //   240: aload           9
        //   242: ldc             ":lfn:"
        //   244: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   247: pop            
        //   248: aload           9
        //   250: aload           7
        //   252: invokeinterface ax/h5/e.W0:()Ljava/lang/String;
        //   257: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   260: pop            
        //   261: aload           9
        //   263: ldc             ":short:"
        //   265: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   268: pop            
        //   269: aload           9
        //   271: aload           7
        //   273: invokeinterface ax/h5/e.z:()Ljava/lang/String;
        //   278: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   281: pop            
        //   282: aload           10
        //   284: aload           9
        //   286: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   289: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   292: invokevirtual   ax/Ha/b.h:()V
        //   295: goto            392
        //   298: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   301: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   304: ldc             "USB CHILD NAME 2"
        //   306: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   309: astore          9
        //   311: new             Ljava/lang/StringBuilder;
        //   314: astore          10
        //   316: aload           10
        //   318: invokespecial   java/lang/StringBuilder.<init>:()V
        //   321: aload           10
        //   323: ldc             "name:"
        //   325: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   328: pop            
        //   329: aload           10
        //   331: aload           8
        //   333: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   336: pop            
        //   337: aload           10
        //   339: ldc             ":lfn:"
        //   341: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   344: pop            
        //   345: aload           10
        //   347: aload           7
        //   349: invokeinterface ax/h5/e.W0:()Ljava/lang/String;
        //   354: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   357: pop            
        //   358: aload           10
        //   360: ldc             ":short:"
        //   362: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   365: pop            
        //   366: aload           10
        //   368: aload           7
        //   370: invokeinterface ax/h5/e.z:()Ljava/lang/String;
        //   375: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   378: pop            
        //   379: aload           9
        //   381: aload           10
        //   383: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   386: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   389: invokevirtual   ax/Ha/b.h:()V
        //   392: iinc            3, 1
        //   395: goto            72
        //   398: aload_2        
        //   399: areturn        
        //   400: new             Lax/b3/j;
        //   403: astore_1       
        //   404: aload_1        
        //   405: ldc             "This is not directory"
        //   407: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   410: aload_1        
        //   411: athrow         
        //   412: new             Lax/b3/t;
        //   415: astore_1       
        //   416: aload_1        
        //   417: invokespecial   ax/b3/t.<init>:()V
        //   420: aload_1        
        //   421: athrow         
        //   422: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   425: ldc             "USB illegalargument"
        //   427: invokevirtual   ax/Ha/b.b:(Ljava/lang/String;)Lax/Ha/b;
        //   430: aload_1        
        //   431: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   434: invokevirtual   ax/Ha/b.h:()V
        //   437: new             Lax/b3/j;
        //   440: dup            
        //   441: aload_1        
        //   442: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   445: athrow         
        //   446: new             Lax/b3/j;
        //   449: dup            
        //   450: aload_1        
        //   451: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   454: athrow         
        //   455: new             Lax/b3/g;
        //   458: dup            
        //   459: aload_1        
        //   460: invokespecial   ax/b3/g.<init>:(Ljava/lang/Throwable;)V
        //   463: athrow         
        //   464: new             Lax/b3/t;
        //   467: dup            
        //   468: invokespecial   ax/b3/t.<init>:()V
        //   471: athrow         
        //   472: astore          7
        //   474: goto            169
        //    Exceptions:
        //  throws ax.b3.j
        //    Signature:
        //  (Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/m$f;)Ljava/util/List<Lcom/alphainventor/filemanager/file/n;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  18     36     185    189    Lcom/github/mjdev/libaums/a;
        //  18     36     181    185    Ljava/io/IOException;
        //  18     36     165    169    Ljava/lang/IllegalArgumentException;
        //  41     60     185    189    Lcom/github/mjdev/libaums/a;
        //  41     60     181    185    Ljava/io/IOException;
        //  41     60     165    169    Ljava/lang/IllegalArgumentException;
        //  65     70     185    189    Lcom/github/mjdev/libaums/a;
        //  65     70     181    185    Ljava/io/IOException;
        //  65     70     165    169    Ljava/lang/IllegalArgumentException;
        //  84     144    185    189    Lcom/github/mjdev/libaums/a;
        //  84     144    181    185    Ljava/io/IOException;
        //  84     144    165    169    Ljava/lang/IllegalArgumentException;
        //  149    162    472    477    Ljava/io/IOException;
        //  149    162    165    169    Ljava/lang/IllegalArgumentException;
        //  169    178    185    189    Lcom/github/mjdev/libaums/a;
        //  169    178    181    185    Ljava/io/IOException;
        //  169    178    165    169    Ljava/lang/IllegalArgumentException;
        //  189    196    185    189    Lcom/github/mjdev/libaums/a;
        //  189    196    181    185    Ljava/io/IOException;
        //  189    196    165    169    Ljava/lang/IllegalArgumentException;
        //  201    295    185    189    Lcom/github/mjdev/libaums/a;
        //  201    295    181    185    Ljava/io/IOException;
        //  201    295    165    169    Ljava/lang/IllegalArgumentException;
        //  298    392    185    189    Lcom/github/mjdev/libaums/a;
        //  298    392    181    185    Ljava/io/IOException;
        //  298    392    165    169    Ljava/lang/IllegalArgumentException;
        //  400    412    185    189    Lcom/github/mjdev/libaums/a;
        //  400    412    181    185    Ljava/io/IOException;
        //  400    412    165    169    Ljava/lang/IllegalArgumentException;
        //  412    422    185    189    Lcom/github/mjdev/libaums/a;
        //  412    422    181    185    Ljava/io/IOException;
        //  412    422    165    169    Ljava/lang/IllegalArgumentException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException: Attempt to invoke virtual method 'g5.m0 g5.d2.L()' on a null object reference
        //     at e5.d0.e(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:26)
        //     at e5.c0.s(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:1643)
        //     at q5.g.o(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:2651)
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
    
    public void D(final n p0, final G p1, final String p2, final long p3, final Long p4, final p p5, final boolean p6, final c p7, final i p8) throws j, ax.b3.a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface ax/c3/b.n:()Z
        //     6: invokestatic    ax/u3/b.a:(Z)V
        //     9: aconst_null    
        //    10: astore          17
        //    12: aconst_null    
        //    13: astore          19
        //    15: aconst_null    
        //    16: astore          20
        //    18: aconst_null    
        //    19: astore          18
        //    21: aload           18
        //    23: astore_3       
        //    24: aload           17
        //    26: astore          7
        //    28: aload           19
        //    30: astore          16
        //    32: aload           20
        //    34: astore          9
        //    36: aload_0        
        //    37: aload_1        
        //    38: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //    41: invokespecial   com/alphainventor/filemanager/file/U.l0:(Ljava/lang/String;)Lax/h5/e;
        //    44: astore          21
        //    46: aload           21
        //    48: ifnull          317
        //    51: aload           18
        //    53: astore_3       
        //    54: aload           17
        //    56: astore          7
        //    58: aload           19
        //    60: astore          16
        //    62: aload           20
        //    64: astore          9
        //    66: aload           21
        //    68: aload_1        
        //    69: invokevirtual   com/alphainventor/filemanager/file/n.B:()Ljava/lang/String;
        //    72: invokeinterface ax/h5/e.p0:(Ljava/lang/String;)Lax/h5/e;
        //    77: astore          21
        //    79: aload           18
        //    81: astore_3       
        //    82: aload           17
        //    84: astore          7
        //    86: aload           19
        //    88: astore          16
        //    90: aload           20
        //    92: astore          9
        //    94: sipush          8192
        //    97: newarray        B
        //    99: astore          22
        //   101: aload           18
        //   103: astore_3       
        //   104: aload           17
        //   106: astore          7
        //   108: aload           19
        //   110: astore          16
        //   112: aload           20
        //   114: astore          9
        //   116: aload_2        
        //   117: invokevirtual   ax/c3/G.b:()Ljava/io/InputStream;
        //   120: astore_1       
        //   121: lconst_0       
        //   122: lstore          12
        //   124: aload_1        
        //   125: astore_3       
        //   126: aload_1        
        //   127: astore          7
        //   129: aload_1        
        //   130: astore          16
        //   132: aload_1        
        //   133: astore          9
        //   135: aload_1        
        //   136: aload           22
        //   138: invokevirtual   java/io/InputStream.read:([B)I
        //   141: istore          11
        //   143: iload           11
        //   145: ifle            242
        //   148: aload_1        
        //   149: astore_3       
        //   150: aload_1        
        //   151: astore          7
        //   153: aload_1        
        //   154: astore          16
        //   156: aload_1        
        //   157: astore          9
        //   159: aload           21
        //   161: lload           12
        //   163: aload           22
        //   165: iconst_0       
        //   166: iload           11
        //   168: invokestatic    java/nio/ByteBuffer.wrap:([BII)Ljava/nio/ByteBuffer;
        //   171: invokeinterface ax/h5/e.l:(JLjava/nio/ByteBuffer;)V
        //   176: lload           12
        //   178: iload           11
        //   180: i2l            
        //   181: ladd           
        //   182: lstore          14
        //   184: lload           14
        //   186: lstore          12
        //   188: aload           10
        //   190: ifnull          124
        //   193: aload_1        
        //   194: astore_3       
        //   195: aload_1        
        //   196: astore          7
        //   198: aload_1        
        //   199: astore          16
        //   201: aload_1        
        //   202: astore          9
        //   204: aload           10
        //   206: lload           14
        //   208: lload           4
        //   210: invokeinterface ax/g3/i.a:(JJ)V
        //   215: lload           14
        //   217: lstore          12
        //   219: goto            124
        //   222: astore_1       
        //   223: goto            543
        //   226: astore_1       
        //   227: goto            372
        //   230: astore_1       
        //   231: aload           16
        //   233: astore          7
        //   235: goto            372
        //   238: astore_1       
        //   239: goto            392
        //   242: aload           6
        //   244: ifnull          286
        //   247: aload_1        
        //   248: astore_3       
        //   249: aload_1        
        //   250: astore          7
        //   252: aload_1        
        //   253: astore          16
        //   255: aload_1        
        //   256: astore          9
        //   258: aload           6
        //   260: invokevirtual   java/lang/Long.longValue:()J
        //   263: lstore          4
        //   265: lload           4
        //   267: lconst_0       
        //   268: lcmp           
        //   269: ifle            286
        //   272: aload_1        
        //   273: astore_3       
        //   274: aload           21
        //   276: aload           6
        //   278: invokevirtual   java/lang/Long.longValue:()J
        //   281: invokeinterface ax/h5/e.R0:(J)V
        //   286: aload_1        
        //   287: astore_3       
        //   288: aload_1        
        //   289: astore          7
        //   291: aload_1        
        //   292: astore          16
        //   294: aload_1        
        //   295: astore          9
        //   297: aload           21
        //   299: invokeinterface ax/h5/e.close:()V
        //   304: aload_1        
        //   305: invokevirtual   java/io/InputStream.close:()V
        //   308: goto            316
        //   311: astore_1       
        //   312: aload_1        
        //   313: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   316: return         
        //   317: aload           18
        //   319: astore_3       
        //   320: aload           17
        //   322: astore          7
        //   324: aload           19
        //   326: astore          16
        //   328: aload           20
        //   330: astore          9
        //   332: new             Lax/b3/t;
        //   335: astore_1       
        //   336: aload           18
        //   338: astore_3       
        //   339: aload           17
        //   341: astore          7
        //   343: aload           19
        //   345: astore          16
        //   347: aload           20
        //   349: astore          9
        //   351: aload_1        
        //   352: invokespecial   ax/b3/t.<init>:()V
        //   355: aload           18
        //   357: astore_3       
        //   358: aload           17
        //   360: astore          7
        //   362: aload           19
        //   364: astore          16
        //   366: aload           20
        //   368: astore          9
        //   370: aload_1        
        //   371: athrow         
        //   372: aload           7
        //   374: astore_3       
        //   375: new             Lax/b3/j;
        //   378: astore_2       
        //   379: aload           7
        //   381: astore_3       
        //   382: aload_2        
        //   383: aload_1        
        //   384: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   387: aload           7
        //   389: astore_3       
        //   390: aload_2        
        //   391: athrow         
        //   392: aload           9
        //   394: astore_3       
        //   395: aload_1        
        //   396: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   399: ifnull          462
        //   402: aload           9
        //   404: astore_3       
        //   405: aload_1        
        //   406: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   409: ldc_w           "Could not write"
        //   412: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   415: ifeq            462
        //   418: aload           9
        //   420: astore_3       
        //   421: invokestatic    ax/Q2/o.i:()Lax/Q2/o;
        //   424: aload_0        
        //   425: invokevirtual   com/alphainventor/filemanager/file/m.p:()Landroid/content/Context;
        //   428: invokevirtual   ax/Q2/o.a:(Landroid/content/Context;)Z
        //   431: ifeq            487
        //   434: aload           9
        //   436: astore_3       
        //   437: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   440: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   443: ldc_w           "!!USB writeFile 1 : could not write"
        //   446: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   449: aload_1        
        //   450: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   453: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   456: invokevirtual   ax/Ha/b.h:()V
        //   459: goto            487
        //   462: aload           9
        //   464: astore_3       
        //   465: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   468: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   471: ldc_w           "!!USB writeFile 3"
        //   474: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   477: aload_1        
        //   478: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   481: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   484: invokevirtual   ax/Ha/b.h:()V
        //   487: aload           9
        //   489: astore_3       
        //   490: invokestatic    ax/Q2/o.i:()Lax/Q2/o;
        //   493: aload_0        
        //   494: invokevirtual   com/alphainventor/filemanager/file/m.p:()Landroid/content/Context;
        //   497: invokevirtual   ax/Q2/o.a:(Landroid/content/Context;)Z
        //   500: ifeq            523
        //   503: aload           9
        //   505: astore_3       
        //   506: new             Lax/b3/j;
        //   509: astore_2       
        //   510: aload           9
        //   512: astore_3       
        //   513: aload_2        
        //   514: aload_1        
        //   515: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   518: aload           9
        //   520: astore_3       
        //   521: aload_2        
        //   522: athrow         
        //   523: aload           9
        //   525: astore_3       
        //   526: new             Lax/b3/H;
        //   529: astore_2       
        //   530: aload           9
        //   532: astore_3       
        //   533: aload_2        
        //   534: aload_1        
        //   535: invokespecial   ax/b3/H.<init>:(Ljava/lang/Throwable;)V
        //   538: aload           9
        //   540: astore_3       
        //   541: aload_2        
        //   542: athrow         
        //   543: aload_3        
        //   544: ifnull          559
        //   547: aload_3        
        //   548: invokevirtual   java/io/InputStream.close:()V
        //   551: goto            559
        //   554: astore_2       
        //   555: aload_2        
        //   556: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   559: aload_1        
        //   560: athrow         
        //   561: astore_2       
        //   562: goto            286
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                      
        //  -----  -----  -----  -----  ------------------------------------------
        //  36     46     238    543    Ljava/io/IOException;
        //  36     46     230    238    Ljava/lang/IllegalArgumentException;
        //  36     46     226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  36     46     222    561    Any
        //  66     79     238    543    Ljava/io/IOException;
        //  66     79     230    238    Ljava/lang/IllegalArgumentException;
        //  66     79     226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  66     79     222    561    Any
        //  94     101    238    543    Ljava/io/IOException;
        //  94     101    230    238    Ljava/lang/IllegalArgumentException;
        //  94     101    226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  94     101    222    561    Any
        //  116    121    238    543    Ljava/io/IOException;
        //  116    121    230    238    Ljava/lang/IllegalArgumentException;
        //  116    121    226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  116    121    222    561    Any
        //  135    143    238    543    Ljava/io/IOException;
        //  135    143    230    238    Ljava/lang/IllegalArgumentException;
        //  135    143    226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  135    143    222    561    Any
        //  159    176    238    543    Ljava/io/IOException;
        //  159    176    230    238    Ljava/lang/IllegalArgumentException;
        //  159    176    226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  159    176    222    561    Any
        //  204    215    238    543    Ljava/io/IOException;
        //  204    215    230    238    Ljava/lang/IllegalArgumentException;
        //  204    215    226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  204    215    222    561    Any
        //  258    265    238    543    Ljava/io/IOException;
        //  258    265    230    238    Ljava/lang/IllegalArgumentException;
        //  258    265    226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  258    265    222    561    Any
        //  274    286    561    565    Ljava/lang/Exception;
        //  274    286    222    561    Any
        //  297    304    238    543    Ljava/io/IOException;
        //  297    304    230    238    Ljava/lang/IllegalArgumentException;
        //  297    304    226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  297    304    222    561    Any
        //  304    308    311    316    Ljava/io/IOException;
        //  332    336    238    543    Ljava/io/IOException;
        //  332    336    230    238    Ljava/lang/IllegalArgumentException;
        //  332    336    226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  332    336    222    561    Any
        //  351    355    238    543    Ljava/io/IOException;
        //  351    355    230    238    Ljava/lang/IllegalArgumentException;
        //  351    355    226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  351    355    222    561    Any
        //  370    372    238    543    Ljava/io/IOException;
        //  370    372    230    238    Ljava/lang/IllegalArgumentException;
        //  370    372    226    230    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  370    372    222    561    Any
        //  375    379    222    561    Any
        //  382    387    222    561    Any
        //  390    392    222    561    Any
        //  395    402    222    561    Any
        //  405    418    222    561    Any
        //  421    434    222    561    Any
        //  437    459    222    561    Any
        //  465    487    222    561    Any
        //  490    503    222    561    Any
        //  506    510    222    561    Any
        //  513    518    222    561    Any
        //  521    523    222    561    Any
        //  526    530    222    561    Any
        //  533    538    222    561    Any
        //  541    543    222    561    Any
        //  547    551    554    559    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 281 out of bounds for length 281
        //     at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
        //     at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
        //     at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
        //     at java.util.Objects.checkIndex(Objects.java:371)
        //     at java.util.ArrayList.get(ArrayList.java:435)
        //     at q5.g.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
        //     at q5.g.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:714)
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
    
    public void E(final n n, final n n2, final c c, final i i) throws j {
        b.a(((ax.c3.b)n2).n());
        Label_0170: {
            long length = 0L;
            Label_0118: {
                e l0;
                String t2;
                try {
                    l0 = this.l0(n.E());
                    if (l0 == null) {
                        throw new j("Cannot get source usb file");
                    }
                    length = l0.getLength();
                    final String t = n.T();
                    t2 = n2.T();
                    if (t.equals((Object)t2)) {
                        l0.w0(n2.B());
                        break Label_0118;
                    }
                }
                catch (final IllegalArgumentException ex) {
                    throw new j((Throwable)ex);
                }
                catch (final IOException ex2) {
                    break Label_0170;
                }
                final e l2 = this.l0(t2);
                if (l2 == null) {
                    throw new j("Target parent does not exist");
                }
                if (!n.B().equals((Object)n2.B())) {
                    l0.w0(n2.B());
                }
                l0.X0(l2);
            }
            if (i != null) {
                i.a(length, length);
            }
            return;
        }
        final IOException ex2;
        ((Throwable)ex2).printStackTrace();
        throw new j((Throwable)ex2);
    }
    
    public void F(final n n, final n n2, final c c, final i i) throws j, ax.b3.a {
        this.D(n2, this.s(n), ((ax.c3.b)n).s(), ((ax.c3.b)n).p(), ((ax.c3.b)n).q(), n.D(), false, c, i);
    }
    
    public int G(final String s, final String s2) {
        return -1;
    }
    
    public String H(final n n) {
        if (z.f0 != n.G()) {
            return null;
        }
        return B.Y(n);
    }
    
    public void I(final n n) throws j {
        b.g("not support delete file recursively");
    }
    
    public InputStream J(final n n, final long n2) throws j {
        try {
            final e l0 = this.l0(n.E());
            if (l0 == null) {
                throw new j("UsbFile is null");
            }
            final BufferedInputStream bufferedInputStream = new BufferedInputStream((InputStream)new f(l0));
            if (n2 != 0L) {
                bufferedInputStream.skip(n2);
                return (InputStream)bufferedInputStream;
            }
            return (InputStream)bufferedInputStream;
        }
        catch (final UnsupportedOperationException ex) {
            throw new j((Throwable)ex);
        }
        catch (final IllegalArgumentException ex) {
            throw new j((Throwable)ex);
        }
        catch (final IOException ex2) {
            if (o.i().a(this.p())) {
                throw new j((Throwable)ex2);
            }
            throw new H((Throwable)ex2);
        }
    }
    
    public void K(final Activity activity, final Fragment fragment, final c$a c$a) {
        if (c$a != null) {
            c$a.B();
        }
        try {
            new a(this.p(), this, c$a).h((Object[])new String[0]);
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
        }
    }
    
    public boolean L() {
        return true;
    }
    
    public boolean M(final n n) {
        return this.k0(n, true);
    }
    
    public boolean N(final n n) {
        return this.k0(n, false);
    }
    
    public boolean O() {
        return false;
    }
    
    public void P(final n n) throws j {
        try {
            final e l0 = this.l0(n.E());
            if (l0 != null) {
                l0.delete();
                return;
            }
            throw new j("USBFile is null");
        }
        catch (final IOException ex) {
            ((Throwable)ex).printStackTrace();
            if (o.i().a(this.p())) {
                ax.Ha.c.h().f().d("Usb delete 1").g((Object)((Throwable)ex).getMessage()).h();
                throw new j((Throwable)ex);
            }
            throw new H((Throwable)ex);
        }
        catch (final com.github.mjdev.libaums.a a) {}
        catch (final IllegalStateException ex2) {}
        catch (final IllegalArgumentException ex3) {}
        final Throwable t;
        t.printStackTrace();
        throw new j(t);
        final Throwable t2;
        ax.Ha.c.h().f().d("USB IllegalArgumentException?").l(t2).h();
        throw new j(t2);
        ax.Ha.c.h().f().d("DELETE USB ROOT?").g((Object)n.E()).h();
        final Throwable t3;
        throw new j(t3);
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
        o.i().d();
        this.n0(null);
    }
    
    void m(final n n, final String s, final boolean b, final boolean b2, final h h, final c c) throws j {
        this.o(n, s, b, b2, h, c);
    }
    
    public V m0(final String s) throws j {
        try {
            if (d0.D(this.v(), s)) {
                return new V(this, s, this.h);
            }
            return new V(this, s, this.l0(s));
        }
        catch (final IllegalArgumentException ex) {
            throw new j((Throwable)ex);
        }
        catch (final IOException ex2) {
            ((Throwable)ex2).printStackTrace();
            if (o.i().a(this.p())) {
                throw new j((Throwable)ex2);
            }
            throw new H((Throwable)ex2);
        }
    }
    
    void n0(final e h) {
        this.h = h;
    }
    
    public k0 y() throws j {
        return new k0(o.i().h(), o.i().j(), 0);
    }
    
    private static class a extends q<String, Void, Boolean>
    {
        Context h;
        c$a i;
        U j;
        String k;
        
        a(final Context h, final U j, final c$a i) {
            super(q$e.c0);
            this.h = h;
            this.i = i;
            this.j = j;
        }
        
        protected Boolean w(final String... array) {
            try {
                o.i().e(this.h);
                final e k = o.i().k();
                this.j.n0(k);
                if (k == null) {
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            }
            catch (final ax.b3.G g) {
                String string;
                if (g.a() == 7) {
                    final Context h = this.h;
                    string = h.getString(2131952456, new Object[] { h.getString(2131952463) });
                }
                else {
                    string = null;
                }
                this.k = string;
                return Boolean.FALSE;
            }
            catch (final j j) {}
            catch (final C c) {
                this.k = this.h.getString(2131952630);
                return Boolean.FALSE;
            }
        }
        
        protected void x(final Boolean b) {
            if (this.i != null) {
                if (b) {
                    this.i.T(true, (Object)null);
                    return;
                }
                this.i.T(false, (Object)this.k);
            }
        }
    }
}
