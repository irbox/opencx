package com.alphainventor.filemanager.service;

import java.util.AbstractCollection;
import java.text.DateFormat;
import com.alphainventor.filemanager.file.y;
import java.util.Collection;
import java.util.Arrays;
import ax.X2.Q;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import ax.b3.t;
import java.util.Map$Entry;
import ax.c3.d0;
import ax.rd.i;
import javax.net.ssl.TrustManager;
import javax.net.ssl.KeyManagerFactory;
import java.security.Key;
import java.security.cert.Certificate;
import java.io.InputStream;
import java.security.KeyPairGenerator;
import ax.rd.k;
import ax.rd.e;
import ax.ud.d;
import java.util.Random;
import java.math.BigInteger;
import java.security.SecureRandom;
import ax.pd.c;
import java.security.cert.X509Certificate;
import java.security.KeyPair;
import java.io.File;
import ax.b3.j;
import com.alphainventor.filemanager.file.c$a;
import ax.c3.x;
import ax.u3.b;
import ax.Q2.f;
import java.util.Date;
import ax.o3.h;
import android.util.Base64;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyStore;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import android.text.TextUtils;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Locale;
import j$.util.concurrent.ConcurrentHashMap;
import ax.Q2.g;
import java.util.List;
import com.alphainventor.filemanager.file.o;
import ax.c3.K;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.net.InetAddress;
import java.net.ServerSocket;
import com.alphainventor.filemanager.file.n;
import java.io.BufferedOutputStream;
import java.net.Socket;
import android.content.Context;
import javax.net.ssl.SSLContext;
import java.util.Map;
import java.util.logging.Logger;
import android.annotation.SuppressLint;

@SuppressLint({ "DefaultLocale", "SimpleDateFormat" })
public class a
{
    private static final Logger E;
    private static final String[] F;
    private static final Map<String, SSLContext> G;
    private long A;
    private boolean B;
    private boolean C;
    private SSLContext D;
    private Context a;
    private Socket b;
    private BufferedOutputStream c;
    private n d;
    private n e;
    private String f;
    private boolean g;
    private ServerSocket h;
    private InetAddress i;
    private int j;
    private boolean k;
    private String l;
    private String m;
    private String n;
    private HashSet<String> o;
    private n p;
    private SimpleDateFormat q;
    private SimpleDateFormat r;
    private SimpleDateFormat s;
    private SimpleDateFormat t;
    private Map<K, o> u;
    private Map<K, n> v;
    private List<K> w;
    private Map<K, String> x;
    private boolean y;
    private boolean z;
    
    static {
        E = g.a((Class)a.class);
        F = new String[] { "CWD", "CDUP", "SMNT", "PORT", "PASV", "MODE", "TYPE", "STRU", "ALL0", "REST", "STOR", "STOU", "RETR", "LIST", "NLST", "APPE", "RNFR", "RNT0", "DELE", "RMD", "MKD", "STAT", "SITE", "MLST", "MLST", "PBSZ", "PROT" };
        G = (Map)new ConcurrentHashMap();
    }
    
    public a(final Context a, final Socket b, final BufferedOutputStream c, final boolean z, final String m) throws IOException {
        this.g = false;
        this.o = (HashSet<String>)new HashSet();
        final Locale us = Locale.US;
        this.q = new SimpleDateFormat(" MMM dd HH:mm ", us);
        this.r = new SimpleDateFormat(" MMM dd  yyyy ", us);
        this.s = new SimpleDateFormat("yyyyMMddHHmmss.SSS", us);
        this.u = (Map<K, o>)new ConcurrentHashMap();
        this.v = (Map<K, n>)new ConcurrentHashMap();
        this.w = (List<K>)new ArrayList();
        this.x = (Map<K, String>)new ConcurrentHashMap();
        this.a = a;
        this.b = b;
        this.z = z;
        this.c = c;
        ((DateFormat)this.s).setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        this.m = m;
        if (TextUtils.isEmpty((CharSequence)m)) {
            this.k = true;
        }
    }
    
    private static String A(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return "127.0.0.1";
        }
        final int index = s.indexOf(37);
        String substring = s;
        if (index >= 0) {
            substring = s.substring(0, index);
        }
        return substring;
    }
    
    private Socket B() {
        final ServerSocket h = this.h;
        if (h == null) {
            try {
                final Socket socket = new Socket(this.i, this.j);
                socket.setSoTimeout(30000);
                return this.E(socket);
            }
            catch (final Exception ex) {
                ((Throwable)ex).printStackTrace();
                this.d();
                return null;
            }
        }
        try {
            final Socket accept = h.accept();
            this.d();
            return this.E(accept);
        }
        catch (final IOException ex2) {
            ((Throwable)ex2).printStackTrace();
        }
        return null;
    }
    
    private void D(String upperCase, final a a) {
        upperCase = upperCase.toUpperCase(Locale.US);
        if (!"TLS".equals((Object)upperCase) && !"SSL".equals((Object)upperCase)) {
            this.O("504 Unsupported AUTH type\r\n");
            return;
        }
        if (this.B) {
            this.O("503 Control connection is already protected\r\n");
            return;
        }
        if ((this.D = s(this.a, this.r())) == null) {
            this.O("431 TLS is not available\r\n");
            return;
        }
        this.O("234 AUTH TLS OK\r\n");
        try {
            final SSLSocketFactory socketFactory = this.D.getSocketFactory();
            final Socket b = this.b;
            final SSLSocket b2 = (SSLSocket)socketFactory.createSocket(b, b.getInetAddress().getHostAddress(), this.b.getPort(), false);
            b2.setUseClientMode(false);
            b2.setNeedClientAuth(false);
            b2.startHandshake();
            this.b = (Socket)b2;
            this.c = new BufferedOutputStream(((Socket)b2).getOutputStream());
            this.B = true;
            a.c = true;
        }
        catch (final IOException ex) {
            ((Throwable)ex).printStackTrace();
        }
    }
    
    private Socket E(final Socket socket) throws IOException {
        if (!this.C) {
            return socket;
        }
        final SSLContext d = this.D;
        if (d == null) {
            this.f(socket);
            return null;
        }
        final SSLSocket sslSocket = (SSLSocket)d.getSocketFactory().createSocket(socket, socket.getInetAddress().getHostAddress(), socket.getPort(), false);
        sslSocket.setUseClientMode(false);
        sslSocket.setNeedClientAuth(false);
        return (Socket)sslSocket;
    }
    
    private void F(final n p0, final boolean p1, final long p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   com/alphainventor/filemanager/service/a.B:()Ljava/net/Socket;
        //     4: astore          13
        //     6: aload           13
        //     8: ifnonnull       25
        //    11: aload_0        
        //    12: ldc_w           "425 Error opening data socket\r\n"
        //    15: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //    18: aload_0        
        //    19: aload           13
        //    21: invokespecial   com/alphainventor/filemanager/service/a.f:(Ljava/net/Socket;)V
        //    24: return         
        //    25: lload_3        
        //    26: lconst_0       
        //    27: lcmp           
        //    28: istore          5
        //    30: iload           5
        //    32: ifle            54
        //    35: aload_1        
        //    36: invokeinterface ax/c3/b.p:()J
        //    41: lload_3        
        //    42: lcmp           
        //    43: ifge            54
        //    46: aload_0        
        //    47: ldc_w           "451 File IO error\r\n"
        //    50: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //    53: return         
        //    54: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //    57: astore          7
        //    59: aload_0        
        //    60: getfield        com/alphainventor/filemanager/service/a.g:Z
        //    63: ifeq            74
        //    66: ldc_w           "BINARY"
        //    69: astore          6
        //    71: goto            79
        //    74: ldc_w           "ASCII"
        //    77: astore          6
        //    79: aload_0        
        //    80: aload           7
        //    82: ldc_w           "150 Opening %s mode data connection for writing\r\n"
        //    85: iconst_1       
        //    86: anewarray       Ljava/lang/Object;
        //    89: dup            
        //    90: iconst_0       
        //    91: aload           6
        //    93: aastore        
        //    94: invokestatic    java/lang/String.format:(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    97: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   100: aload_0        
        //   101: aload           13
        //   103: invokespecial   com/alphainventor/filemanager/service/a.N:(Ljava/net/Socket;)Z
        //   106: ifne            123
        //   109: aload_0        
        //   110: ldc_w           "426 Data socket or network error\r\n"
        //   113: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   116: aload_0        
        //   117: aload           13
        //   119: invokespecial   com/alphainventor/filemanager/service/a.f:(Ljava/net/Socket;)V
        //   122: return         
        //   123: aconst_null    
        //   124: astore          10
        //   126: aconst_null    
        //   127: astore          11
        //   129: aconst_null    
        //   130: astore          8
        //   132: aconst_null    
        //   133: astore          9
        //   135: aconst_null    
        //   136: astore          7
        //   138: aconst_null    
        //   139: astore          12
        //   141: aload_0        
        //   142: aload_1        
        //   143: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //   146: invokevirtual   com/alphainventor/filemanager/file/o.u:()Lcom/alphainventor/filemanager/file/m;
        //   149: checkcast       Lcom/alphainventor/filemanager/file/e;
        //   152: astore          14
        //   154: aload           13
        //   156: invokevirtual   java/net/Socket.getInputStream:()Ljava/io/InputStream;
        //   159: astore          6
        //   161: iload           5
        //   163: ifle            235
        //   166: aload           12
        //   168: astore          8
        //   170: aload           10
        //   172: astore          7
        //   174: aload           11
        //   176: astore          9
        //   178: aload           14
        //   180: aload_1        
        //   181: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   184: lload_3        
        //   185: invokevirtual   com/alphainventor/filemanager/file/e.l0:(Ljava/lang/String;J)V
        //   188: aload           12
        //   190: astore          8
        //   192: aload           10
        //   194: astore          7
        //   196: aload           11
        //   198: astore          9
        //   200: aload           14
        //   202: aload_1        
        //   203: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   206: iconst_1       
        //   207: invokeinterface ax/c3/X.c:(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   212: astore_1       
        //   213: goto            263
        //   216: astore_1       
        //   217: aload           8
        //   219: astore          7
        //   221: goto            541
        //   224: astore_1       
        //   225: goto            460
        //   228: astore_1       
        //   229: aload           9
        //   231: astore_1       
        //   232: goto            502
        //   235: aload           12
        //   237: astore          8
        //   239: aload           10
        //   241: astore          7
        //   243: aload           11
        //   245: astore          9
        //   247: aload           14
        //   249: aload_1        
        //   250: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   253: iload_2        
        //   254: invokeinterface ax/c3/X.c:(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   259: astore_1       
        //   260: goto            213
        //   263: aload_1        
        //   264: ifnull          382
        //   267: aload_1        
        //   268: astore          8
        //   270: aload_1        
        //   271: astore          7
        //   273: aload_1        
        //   274: astore          9
        //   276: ldc_w           65536
        //   279: newarray        B
        //   281: astore          10
        //   283: aload_1        
        //   284: astore          8
        //   286: aload_1        
        //   287: astore          7
        //   289: aload_1        
        //   290: astore          9
        //   292: aload           6
        //   294: aload           10
        //   296: invokevirtual   java/io/InputStream.read:([B)I
        //   299: istore          5
        //   301: iload           5
        //   303: iflt            350
        //   306: iload           5
        //   308: ifne            329
        //   311: aload_1        
        //   312: astore          8
        //   314: aload_1        
        //   315: astore          7
        //   317: aload_1        
        //   318: astore          9
        //   320: ldc2_w          5
        //   323: invokestatic    java/lang/Thread.sleep:(J)V
        //   326: goto            283
        //   329: aload_1        
        //   330: astore          8
        //   332: aload_1        
        //   333: astore          7
        //   335: aload_1        
        //   336: astore          9
        //   338: aload_1        
        //   339: aload           10
        //   341: iconst_0       
        //   342: iload           5
        //   344: invokevirtual   java/io/OutputStream.write:([BII)V
        //   347: goto            283
        //   350: aload_1        
        //   351: astore          8
        //   353: aload_1        
        //   354: astore          7
        //   356: aload_1        
        //   357: astore          9
        //   359: aload_1        
        //   360: invokevirtual   java/io/OutputStream.flush:()V
        //   363: aload_1        
        //   364: astore          8
        //   366: aload_1        
        //   367: astore          7
        //   369: aload_1        
        //   370: astore          9
        //   372: aload_0        
        //   373: ldc_w           "226 Data transmission for writing succeeded\r\n"
        //   376: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   379: goto            398
        //   382: aload_1        
        //   383: astore          8
        //   385: aload_1        
        //   386: astore          7
        //   388: aload_1        
        //   389: astore          9
        //   391: aload_0        
        //   392: ldc_w           "451 Permission denied\r\n"
        //   395: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   398: aload           6
        //   400: ifnull          413
        //   403: aload           6
        //   405: invokevirtual   java/io/InputStream.close:()V
        //   408: goto            413
        //   411: astore          6
        //   413: aload_1        
        //   414: ifnull          532
        //   417: aload_1        
        //   418: invokevirtual   java/io/OutputStream.close:()V
        //   421: goto            532
        //   424: astore_1       
        //   425: aconst_null    
        //   426: astore          8
        //   428: aload           7
        //   430: astore          6
        //   432: aload           8
        //   434: astore          7
        //   436: goto            541
        //   439: astore_1       
        //   440: aconst_null    
        //   441: astore          7
        //   443: aload           8
        //   445: astore          6
        //   447: goto            460
        //   450: astore_1       
        //   451: aconst_null    
        //   452: astore_1       
        //   453: aload           9
        //   455: astore          6
        //   457: goto            502
        //   460: aload_1        
        //   461: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   464: aload_0        
        //   465: ldc_w           "451 File IO error\r\n"
        //   468: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   471: aload           6
        //   473: ifnull          485
        //   476: aload           6
        //   478: invokevirtual   java/io/InputStream.close:()V
        //   481: goto            485
        //   484: astore_1       
        //   485: aload           7
        //   487: ifnull          532
        //   490: aload           7
        //   492: invokevirtual   java/io/OutputStream.close:()V
        //   495: goto            532
        //   498: astore_1       
        //   499: goto            541
        //   502: aload_0        
        //   503: ldc_w           "550 No such file or directory.\r\n"
        //   506: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   509: aload           6
        //   511: ifnull          524
        //   514: aload           6
        //   516: invokevirtual   java/io/InputStream.close:()V
        //   519: goto            524
        //   522: astore          6
        //   524: aload_1        
        //   525: ifnull          532
        //   528: aload_1        
        //   529: invokevirtual   java/io/OutputStream.close:()V
        //   532: return         
        //   533: astore          8
        //   535: aload_1        
        //   536: astore          7
        //   538: aload           8
        //   540: astore_1       
        //   541: aload           6
        //   543: ifnull          556
        //   546: aload           6
        //   548: invokevirtual   java/io/InputStream.close:()V
        //   551: goto            556
        //   554: astore          6
        //   556: aload           7
        //   558: ifnull          566
        //   561: aload           7
        //   563: invokevirtual   java/io/OutputStream.close:()V
        //   566: aload_1        
        //   567: athrow         
        //   568: astore          7
        //   570: goto            283
        //   573: astore_1       
        //   574: goto            532
        //   577: astore          6
        //   579: goto            566
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  141    161    450    460    Ljava/io/FileNotFoundException;
        //  141    161    439    450    Ljava/io/IOException;
        //  141    161    424    439    Any
        //  178    188    228    235    Ljava/io/FileNotFoundException;
        //  178    188    224    228    Ljava/io/IOException;
        //  178    188    216    224    Any
        //  200    213    228    235    Ljava/io/FileNotFoundException;
        //  200    213    224    228    Ljava/io/IOException;
        //  200    213    216    224    Any
        //  247    260    228    235    Ljava/io/FileNotFoundException;
        //  247    260    224    228    Ljava/io/IOException;
        //  247    260    216    224    Any
        //  276    283    228    235    Ljava/io/FileNotFoundException;
        //  276    283    224    228    Ljava/io/IOException;
        //  276    283    216    224    Any
        //  292    301    228    235    Ljava/io/FileNotFoundException;
        //  292    301    224    228    Ljava/io/IOException;
        //  292    301    216    224    Any
        //  320    326    568    573    Ljava/lang/InterruptedException;
        //  320    326    228    235    Ljava/io/FileNotFoundException;
        //  320    326    224    228    Ljava/io/IOException;
        //  320    326    216    224    Any
        //  338    347    228    235    Ljava/io/FileNotFoundException;
        //  338    347    224    228    Ljava/io/IOException;
        //  338    347    216    224    Any
        //  359    363    228    235    Ljava/io/FileNotFoundException;
        //  359    363    224    228    Ljava/io/IOException;
        //  359    363    216    224    Any
        //  372    379    228    235    Ljava/io/FileNotFoundException;
        //  372    379    224    228    Ljava/io/IOException;
        //  372    379    216    224    Any
        //  391    398    228    235    Ljava/io/FileNotFoundException;
        //  391    398    224    228    Ljava/io/IOException;
        //  391    398    216    224    Any
        //  403    408    411    413    Ljava/io/IOException;
        //  417    421    573    577    Ljava/io/IOException;
        //  460    471    498    502    Any
        //  476    481    484    485    Ljava/io/IOException;
        //  490    495    573    577    Ljava/io/IOException;
        //  502    509    533    541    Any
        //  514    519    522    524    Ljava/io/IOException;
        //  528    532    573    577    Ljava/io/IOException;
        //  546    551    554    556    Ljava/io/IOException;
        //  561    566    577    582    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 288 out of bounds for length 288
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
    
    private static void G(final Context context, final String s, final KeyStore keyStore) {
        try {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            keyStore.store((OutputStream)byteArrayOutputStream, "filemanager".toCharArray());
            h.h(context, s, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
        }
    }
    
    private boolean H(final Socket socket, final byte[] array) {
        return this.I(socket, array, 0, array.length);
    }
    
    private boolean I(final Socket socket, final byte[] array, final int n, final int n2) {
        try {
            socket.getOutputStream().write(array, n, n2);
            return true;
        }
        catch (final IOException ex) {
            ((Throwable)ex).printStackTrace();
            return false;
        }
    }
    
    private void J(final n p0, final long p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //     5: astore          9
        //     7: aload_0        
        //     8: invokespecial   com/alphainventor/filemanager/service/a.B:()Ljava/net/Socket;
        //    11: astore          8
        //    13: aload           8
        //    15: ifnonnull       32
        //    18: aload_0        
        //    19: ldc_w           "425 Error opening data socket\r\n"
        //    22: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //    25: aload_0        
        //    26: aload           8
        //    28: invokespecial   com/alphainventor/filemanager/service/a.f:(Ljava/net/Socket;)V
        //    31: return         
        //    32: aload_0        
        //    33: ldc_w           "150 Sending file\r\n"
        //    36: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //    39: aload_0        
        //    40: aload           8
        //    42: invokespecial   com/alphainventor/filemanager/service/a.N:(Ljava/net/Socket;)Z
        //    45: ifne            62
        //    48: aload_0        
        //    49: ldc_w           "426 Data socket or network error\r\n"
        //    52: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //    55: aload_0        
        //    56: aload           8
        //    58: invokespecial   com/alphainventor/filemanager/service/a.f:(Ljava/net/Socket;)V
        //    61: return         
        //    62: aconst_null    
        //    63: astore          6
        //    65: aconst_null    
        //    66: astore          7
        //    68: aconst_null    
        //    69: astore          5
        //    71: aload           9
        //    73: aload_1        
        //    74: lload_2        
        //    75: invokevirtual   com/alphainventor/filemanager/file/o.J:(Lcom/alphainventor/filemanager/file/n;J)Ljava/io/InputStream;
        //    78: astore_1       
        //    79: aload_1        
        //    80: astore          5
        //    82: aload_1        
        //    83: astore          6
        //    85: aload_1        
        //    86: astore          7
        //    88: ldc_w           65536
        //    91: newarray        B
        //    93: astore          9
        //    95: aload_1        
        //    96: astore          5
        //    98: aload_1        
        //    99: astore          6
        //   101: aload_1        
        //   102: astore          7
        //   104: aload_1        
        //   105: aload           9
        //   107: invokevirtual   java/io/InputStream.read:([B)I
        //   110: istore          4
        //   112: iload           4
        //   114: iflt            163
        //   117: aload_1        
        //   118: astore          5
        //   120: aload_1        
        //   121: astore          6
        //   123: aload_1        
        //   124: astore          7
        //   126: aload_0        
        //   127: aload           8
        //   129: aload           9
        //   131: iconst_0       
        //   132: iload           4
        //   134: invokespecial   com/alphainventor/filemanager/service/a.I:(Ljava/net/Socket;[BII)Z
        //   137: ifne            95
        //   140: aload_1        
        //   141: astore          5
        //   143: aload_1        
        //   144: astore          6
        //   146: aload_1        
        //   147: astore          7
        //   149: aload_0        
        //   150: ldc_w           "426 Data socket or network error\r\n"
        //   153: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   156: goto            179
        //   159: astore_1       
        //   160: goto            239
        //   163: aload_1        
        //   164: astore          5
        //   166: aload_1        
        //   167: astore          6
        //   169: aload_1        
        //   170: astore          7
        //   172: aload_0        
        //   173: ldc_w           "226 File transmission succeeded\r\n"
        //   176: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   179: aload_1        
        //   180: invokevirtual   java/io/InputStream.close:()V
        //   183: goto            232
        //   186: astore_1       
        //   187: aload           6
        //   189: astore          5
        //   191: aload_0        
        //   192: ldc_w           "426 Data socket or network error\r\n"
        //   195: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   198: aload           6
        //   200: ifnull          232
        //   203: aload           6
        //   205: astore_1       
        //   206: goto            179
        //   209: astore_1       
        //   210: aload           7
        //   212: astore          5
        //   214: aload_0        
        //   215: ldc_w           "550 Operation on invalid file\r\n"
        //   218: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   221: aload           7
        //   223: ifnull          232
        //   226: aload           7
        //   228: astore_1       
        //   229: goto            179
        //   232: aload_0        
        //   233: aload           8
        //   235: invokespecial   com/alphainventor/filemanager/service/a.f:(Ljava/net/Socket;)V
        //   238: return         
        //   239: aload           5
        //   241: ifnull          249
        //   244: aload           5
        //   246: invokevirtual   java/io/InputStream.close:()V
        //   249: aload_1        
        //   250: athrow         
        //   251: astore_1       
        //   252: goto            232
        //   255: astore          5
        //   257: goto            249
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  71     79     209    232    Ljava/io/FileNotFoundException;
        //  71     79     209    232    Lax/b3/j;
        //  71     79     186    209    Ljava/io/IOException;
        //  71     79     159    251    Any
        //  88     95     209    232    Ljava/io/FileNotFoundException;
        //  88     95     209    232    Lax/b3/j;
        //  88     95     186    209    Ljava/io/IOException;
        //  88     95     159    251    Any
        //  104    112    209    232    Ljava/io/FileNotFoundException;
        //  104    112    209    232    Lax/b3/j;
        //  104    112    186    209    Ljava/io/IOException;
        //  104    112    159    251    Any
        //  126    140    209    232    Ljava/io/FileNotFoundException;
        //  126    140    209    232    Lax/b3/j;
        //  126    140    186    209    Ljava/io/IOException;
        //  126    140    159    251    Any
        //  149    156    209    232    Ljava/io/FileNotFoundException;
        //  149    156    209    232    Lax/b3/j;
        //  149    156    186    209    Ljava/io/IOException;
        //  149    156    159    251    Any
        //  172    179    209    232    Ljava/io/FileNotFoundException;
        //  172    179    209    232    Lax/b3/j;
        //  172    179    186    209    Ljava/io/IOException;
        //  172    179    159    251    Any
        //  179    183    251    255    Ljava/io/IOException;
        //  191    198    159    251    Any
        //  214    221    159    251    Any
        //  244    249    255    260    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 135 out of bounds for length 135
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
    
    private void K(final String s, final String s2) {
        final Socket b = this.B();
        if (b == null) {
            this.O("425 Error opening data socket\r\n");
            this.f(b);
            return;
        }
        final Locale us = Locale.US;
        String s3;
        if (this.g) {
            s3 = "BINARY";
        }
        else {
            s3 = "ASCII";
        }
        this.O(String.format(us, "150 Opening %s mode data connection for %s\r\n", new Object[] { s3, s }));
        if (!this.N(b)) {
            this.O("426 Data socket or network error\r\n");
            this.f(b);
            return;
        }
        if (this.H(b, s2.getBytes())) {
            this.O("226 Data transmission succeeded\r\n");
        }
        else {
            this.O("426 Data socket or network error\r\n");
        }
        this.f(b);
    }
    
    private int L() {
        this.d();
        try {
            final ServerSocket h = new ServerSocket(0, 5);
            this.h = h;
            return h.getLocalPort();
        }
        catch (final IOException ex) {
            ((Throwable)ex).printStackTrace();
            return 0;
        }
    }
    
    private void M(final n e, final String f) {
        this.e = e;
        this.f = f;
    }
    
    private boolean N(final Socket socket) {
        if (!(socket instanceof SSLSocket)) {
            return true;
        }
        try {
            ((SSLSocket)socket).startHandshake();
            return true;
        }
        catch (final IOException ex) {
            ((Throwable)ex).printStackTrace();
            return false;
        }
    }
    
    private void a(final StringBuilder sb, final boolean b, final n n, final String s) {
        if (b) {
            sb.append(" ");
        }
        if (((ax.c3.b)n).isDirectory()) {
            sb.append("Type=dir;Modify=");
            sb.append(((DateFormat)this.s).format(new Date(((ax.c3.b)n).q())));
            sb.append(";Perm=el; ");
            if (s == null) {
                sb.append(n.B());
            }
            else {
                sb.append(s);
            }
        }
        else {
            sb.append("Type=file;Size=");
            sb.append(((ax.c3.b)n).p());
            sb.append(";Modify=");
            sb.append(((DateFormat)this.s).format(new Date(((ax.c3.b)n).q())));
            sb.append(";Perm=");
            sb.append("r");
            if (n.P() == ax.Q2.f.o0) {
                sb.append("w");
            }
            else if (((ax.c3.b)n).j()) {
                sb.append("w");
            }
            sb.append("; ");
            if (s == null) {
                sb.append(n.B());
            }
            else {
                sb.append(s);
            }
        }
        sb.append("\r\n");
    }
    
    private void b(final K k, final String s) {
        if (!ax.Q2.f.Y(k.d())) {
            ax.u3.b.g("Not local file location in FTP!");
            return;
        }
        final o e = ax.c3.x.e(k);
        if (!e.a()) {
            e.h(null);
            if (!e.a()) {
                return;
            }
        }
        try {
            e.n0();
            final n z = e.z(k.e());
            this.u.put((Object)k, (Object)e);
            this.v.put((Object)k, (Object)z);
            this.x.put((Object)k, (Object)s);
            this.w.add((Object)k);
        }
        catch (final j j) {
            e.k0(false);
        }
    }
    
    private boolean c(final String s, final String s2) {
        return (TextUtils.isEmpty((CharSequence)this.n) || this.n.equals((Object)s)) && (TextUtils.isEmpty((CharSequence)this.m) || this.m.equals((Object)s2));
    }
    
    private void d() {
        final ServerSocket h = this.h;
        if (h != null) {
            try {
                h.close();
            }
            catch (final IOException ex) {
                ((Throwable)ex).printStackTrace();
            }
            this.h = null;
        }
    }
    
    private void f(final Socket socket) {
        if (socket != null && !socket.isClosed()) {
            try {
                socket.getOutputStream().close();
                socket.close();
            }
            catch (final IOException ex) {
                ((Throwable)ex).printStackTrace();
            }
        }
    }
    
    private String g(final n n, final boolean b, final boolean b2) {
        if (!n.B().contains((CharSequence)"*") && !n.B().contains((CharSequence)File.separator)) {
            final StringBuilder sb = new StringBuilder();
            final String q = this.q(n);
            if (b) {
                this.a(sb, false, n, q);
            }
            else {
                if (!b2) {
                    if (((ax.c3.b)n).isDirectory()) {
                        sb.append("drwxr-xr-x 1 owner group");
                    }
                    else {
                        sb.append("-rw-r--r-- 1 owner group");
                    }
                    sb.append(String.format(Locale.US, "%13d", new Object[] { ((ax.c3.b)n).p() }));
                    SimpleDateFormat simpleDateFormat;
                    if (System.currentTimeMillis() - ((ax.c3.b)n).q() > 15552000000L) {
                        simpleDateFormat = this.r;
                    }
                    else {
                        simpleDateFormat = this.q;
                    }
                    sb.append(((DateFormat)simpleDateFormat).format(new Date(((ax.c3.b)n).q())));
                }
                sb.append(q);
                sb.append("\r\n");
            }
            return sb.toString();
        }
        return null;
    }
    
    private static X509Certificate h(final String s, final KeyPair keyPair) throws Exception {
        final long currentTimeMillis = System.currentTimeMillis();
        final Date date = new Date(currentTimeMillis - 86400000L);
        final Date date2 = new Date(currentTimeMillis + 315360000000L);
        final StringBuilder sb = new StringBuilder();
        sb.append("CN=");
        sb.append("Cx File Explorer");
        sb.append(" FTPS Server");
        final c c = new c(sb.toString());
        final d d = new d(c, new BigInteger(160, (Random)new SecureRandom()), date, date2, c, keyPair.getPublic());
        ((ax.td.c)d).a(e.k0, true, (ax.Wc.g)new ax.rd.b(false));
        ((ax.td.c)d).a(e.g0, true, (ax.Wc.g)new k(160));
        ((ax.td.c)d).a(e.y0, false, (ax.Wc.g)new ax.rd.d(ax.rd.j.e0));
        ((ax.td.c)d).a(e.i0, false, (ax.Wc.g)k(s));
        return new ax.ud.c().a(((ax.td.c)d).b(new a("SHA256withRSA").b(keyPair.getPrivate())));
    }
    
    private static KeyStore i(final String s) throws Exception {
        final KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(2048);
        final KeyPair generateKeyPair = instance.generateKeyPair();
        final X509Certificate h = h(s, generateKeyPair);
        final KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
        instance2.load((InputStream)null, (char[])null);
        instance2.setKeyEntry("ftp_server", (Key)generateKeyPair.getPrivate(), "filemanager".toCharArray(), new Certificate[] { (Certificate)h });
        return instance2;
    }
    
    private static SSLContext j(final Context context, final String s) throws Exception {
        KeyStore keyStore;
        if ((keyStore = x(context, s)) == null) {
            keyStore = i(s);
            G(context, s, keyStore);
        }
        final KeyManagerFactory instance = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        instance.init(keyStore, "filemanager".toCharArray());
        final SSLContext instance2 = SSLContext.getInstance("TLSv1.2");
        instance2.init(instance.getKeyManagers(), (TrustManager[])null, new SecureRandom());
        return instance2;
    }
    
    private static i k(final String s) {
        final ArrayList list = new ArrayList();
        if (!TextUtils.isEmpty((CharSequence)s) && !"127.0.0.1".equals((Object)s)) {
            ((List)list).add((Object)new ax.rd.h(7, s));
        }
        return new i((ax.rd.h[])((List)list).toArray((Object[])new ax.rd.h[((List)list).size()]));
    }
    
    private String l(final String s) throws IllegalArgumentException {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("Paramater is empty");
        }
        if (this.v(s)) {
            return "/";
        }
        final String separator = File.separator;
        String substring = s;
        if (s.endsWith(separator)) {
            substring = s.substring(0, s.length() - 1);
        }
        if (substring.startsWith(separator)) {
            return substring;
        }
        return d0.Q(this.f, substring);
    }
    
    private n o(String replaceFirst) throws j {
        if (this.v(replaceFirst)) {
            return this.d;
        }
        final Iterator iterator = this.x.entrySet().iterator();
        String string = replaceFirst;
        while (true) {
            while (iterator.hasNext()) {
                final Map$Entry map$Entry = (Map$Entry)iterator.next();
                final K k = (K)map$Entry.getKey();
                final String s = (String)map$Entry.getValue();
                final n n = (n)this.v.get((Object)k);
                if (n == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(":");
                    sb.append(ax.Z2.j.F().T());
                    sb.append(":");
                    sb.append(ax.Z2.j.F().t0());
                    string = sb.toString();
                    ax.u3.b.g(string);
                }
                else {
                    if (!d0.I(s, string) && !d0.G(s, string)) {
                        continue;
                    }
                    final String e = n.E();
                    replaceFirst = "/";
                    if ("/".equals((Object)e)) {
                        final Object replaceFirst2 = string.replaceFirst(s, "");
                        if (!TextUtils.isEmpty((CharSequence)replaceFirst2)) {
                            replaceFirst = (String)replaceFirst2;
                        }
                    }
                    else {
                        replaceFirst = string.replaceFirst(s, e);
                    }
                    if (replaceFirst == null) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("File not exist : ");
                        sb2.append(string);
                        throw new t(sb2.toString());
                    }
                    final o o = (o)this.u.get((Object)k);
                    if (o != null) {
                        return o.z(replaceFirst);
                    }
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("No file operator available : ");
                    sb3.append(k.k());
                    throw new j(sb3.toString());
                }
            }
            final K k = null;
            replaceFirst = null;
            continue;
        }
    }
    
    private o p(final n n) {
        return (o)this.u.get((Object)n.R());
    }
    
    private String q(final n n) {
        if (!d0.E(n)) {
            return n.B();
        }
        final String s = (String)this.x.get((Object)n.R());
        if (s != null) {
            return d0.h(s);
        }
        ax.u3.b.g("root path is not available");
        return n.B();
    }
    
    private String r() {
        final InetAddress localAddress = this.b.getLocalAddress();
        if (localAddress != null) {
            return A(localAddress.getHostAddress());
        }
        return "127.0.0.1";
    }
    
    private static SSLContext s(final Context context, final String s) {
        final String a = A(s);
        final Map<String, SSLContext> g = com.alphainventor.filemanager.service.a.G;
        final SSLContext sslContext = (SSLContext)g.get((Object)a);
        if (sslContext != null) {
            return sslContext;
        }
        final Class<a> clazz;
        monitorenter(clazz = a.class);
        while (true) {
            try {
                SSLContext sslContext2;
                if ((sslContext2 = (SSLContext)g.get((Object)a)) == null) {
                    final Context context2 = context;
                    final String s2 = a;
                    sslContext2 = j(context2, s2);
                    final Map<String, SSLContext> map = g;
                    final String s3 = a;
                    final SSLContext sslContext3 = sslContext2;
                    map.put((Object)s3, (Object)sslContext3);
                }
                break Label_0086;
            }
            finally {
                monitorexit(clazz);
                monitorexit(clazz);
                return;
            }
            try {
                final Context context2 = context;
                final String s2 = a;
                final SSLContext sslContext2 = j(context2, s2);
                final Map<String, SSLContext> map = g;
                final String s3 = a;
                final SSLContext sslContext3 = sslContext2;
                map.put((Object)s3, (Object)sslContext3);
                continue;
            }
            catch (final Exception ex) {}
            break;
        }
    }
    
    private boolean u(final n n) {
        final boolean b = n.R() == K.h || ((ax.c3.b)n).d();
        return ((ax.c3.b)n).isDirectory() && b && this.w(n);
    }
    
    private boolean v(final String s) {
        return "/".equals((Object)s);
    }
    
    private boolean w(final n n) {
        return n.E().startsWith(n.R().e()) || "/".equals((Object)n.E());
    }
    
    private static KeyStore x(final Context context, final String s) {
        final String c = h.c(context, s);
        if (TextUtils.isEmpty((CharSequence)c)) {
            return null;
        }
        Label_0075: {
            KeyStore instance;
            try {
                final byte[] decode = Base64.decode(c, 2);
                instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load((InputStream)new ByteArrayInputStream(decode), "filemanager".toCharArray());
                if (!instance.containsAlias("ftp_server")) {
                    h.e(context, s);
                    return null;
                }
            }
            catch (final Exception ex) {
                break Label_0075;
            }
            return instance;
        }
        final Exception ex;
        ((Throwable)ex).printStackTrace();
        h.e(context, s);
        return null;
    }
    
    private String y(final String s) {
        return String.format(Locale.US, "550 %s: No such file or directory.\r\n", new Object[] { s });
    }
    
    private boolean z(final String s) {
        return this.o.contains((Object)s);
    }
    
    public void C(final String p0, final a p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           " "
        //     4: iconst_2       
        //     5: invokevirtual   java/lang/String.split:(Ljava/lang/String;I)[Ljava/lang/String;
        //     8: astore          13
        //    10: aload           13
        //    12: ifnull          4607
        //    15: aload           13
        //    17: arraylength    
        //    18: ifne            24
        //    21: goto            4607
        //    24: getstatic       com/alphainventor/filemanager/service/a.E:Ljava/util/logging/Logger;
        //    27: astore          15
        //    29: new             Ljava/lang/StringBuilder;
        //    32: dup            
        //    33: invokespecial   java/lang/StringBuilder.<init>:()V
        //    36: astore          14
        //    38: aload           14
        //    40: ldc_w           "FTP INPUT : "
        //    43: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    46: pop            
        //    47: aload           14
        //    49: aload_1        
        //    50: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    53: pop            
        //    54: aload           15
        //    56: aload           14
        //    58: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    61: invokevirtual   java/util/logging/Logger.fine:(Ljava/lang/String;)V
        //    64: aload           13
        //    66: iconst_0       
        //    67: aaload         
        //    68: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //    71: invokevirtual   java/lang/String.toUpperCase:()Ljava/lang/String;
        //    74: astore          16
        //    76: aload           13
        //    78: arraylength    
        //    79: iconst_1       
        //    80: if_icmple       95
        //    83: aload           13
        //    85: iconst_1       
        //    86: aaload         
        //    87: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //    90: astore          13
        //    92: goto            100
        //    95: ldc_w           ""
        //    98: astore          13
        //   100: aload_0        
        //   101: getfield        com/alphainventor/filemanager/service/a.k:Z
        //   104: istore          7
        //   106: iload           7
        //   108: ifne            140
        //   111: aload_0        
        //   112: aload           16
        //   114: invokespecial   com/alphainventor/filemanager/service/a.z:(Ljava/lang/String;)Z
        //   117: ifeq            140
        //   120: aload_0        
        //   121: ldc_w           "530 Login incorrect\r\n"
        //   124: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   127: aload_0        
        //   128: lconst_0       
        //   129: putfield        com/alphainventor/filemanager/service/a.A:J
        //   132: return         
        //   133: astore_1       
        //   134: iconst_0       
        //   135: istore          4
        //   137: goto            4595
        //   140: ldc_w           "NOOP"
        //   143: aload           16
        //   145: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   148: istore          7
        //   150: iload           7
        //   152: ifeq            165
        //   155: aload_0        
        //   156: ldc_w           "200 NOOP OK\r\n"
        //   159: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   162: goto            4517
        //   165: ldc_w           "AUTH"
        //   168: aload           16
        //   170: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   173: istore          7
        //   175: iload           7
        //   177: ifeq            190
        //   180: aload_0        
        //   181: aload           13
        //   183: aload_2        
        //   184: invokespecial   com/alphainventor/filemanager/service/a.D:(Ljava/lang/String;Lcom/alphainventor/filemanager/service/a$a;)V
        //   187: goto            162
        //   190: ldc             "PBSZ"
        //   192: aload           16
        //   194: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   197: istore          7
        //   199: iload           7
        //   201: ifeq            231
        //   204: aload_0        
        //   205: getfield        com/alphainventor/filemanager/service/a.B:Z
        //   208: ifeq            221
        //   211: aload_0        
        //   212: ldc_w           "200 PBSZ=0\r\n"
        //   215: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   218: goto            162
        //   221: aload_0        
        //   222: ldc_w           "503 TLS is required\r\n"
        //   225: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   228: goto            162
        //   231: ldc             "PROT"
        //   233: aload           16
        //   235: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   238: istore          7
        //   240: iload           7
        //   242: ifeq            336
        //   245: aload_0        
        //   246: getfield        com/alphainventor/filemanager/service/a.B:Z
        //   249: ifne            262
        //   252: aload_0        
        //   253: ldc_w           "503 TLS is required\r\n"
        //   256: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   259: goto            162
        //   262: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //   265: astore_1       
        //   266: ldc_w           "P"
        //   269: aload           13
        //   271: aload_1        
        //   272: invokevirtual   java/lang/String.toUpperCase:(Ljava/util/Locale;)Ljava/lang/String;
        //   275: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   278: ifeq            296
        //   281: aload_0        
        //   282: iconst_1       
        //   283: putfield        com/alphainventor/filemanager/service/a.C:Z
        //   286: aload_0        
        //   287: ldc_w           "200 Protection set to Private\r\n"
        //   290: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   293: goto            162
        //   296: ldc_w           "C"
        //   299: aload           13
        //   301: aload_1        
        //   302: invokevirtual   java/lang/String.toUpperCase:(Ljava/util/Locale;)Ljava/lang/String;
        //   305: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   308: ifeq            326
        //   311: aload_0        
        //   312: iconst_0       
        //   313: putfield        com/alphainventor/filemanager/service/a.C:Z
        //   316: aload_0        
        //   317: ldc_w           "200 Protection set to Clear\r\n"
        //   320: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   323: goto            162
        //   326: aload_0        
        //   327: ldc_w           "536 Unsupported PROT level\r\n"
        //   330: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   333: goto            162
        //   336: ldc_w           "OPTS"
        //   339: aload           16
        //   341: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   344: istore          7
        //   346: iload           7
        //   348: ifeq            443
        //   351: ldc_w           "UTF8 ON"
        //   354: aload           13
        //   356: invokevirtual   java/lang/String.toUpperCase:()Ljava/lang/String;
        //   359: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   362: ifne            433
        //   365: ldc_w           "UTF-8 ON"
        //   368: aload           13
        //   370: invokevirtual   java/lang/String.toUpperCase:()Ljava/lang/String;
        //   373: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   376: ifeq            382
        //   379: goto            433
        //   382: aload           13
        //   384: ldc             "MLST"
        //   386: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   389: istore_3       
        //   390: iload_3        
        //   391: ifeq            404
        //   394: aload_0        
        //   395: ldc_w           "501 Unsupported Options\r\n"
        //   398: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   401: goto            162
        //   404: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   407: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   410: ldc_w           "UNSUPPORTED FTP OPTIONS"
        //   413: invokevirtual   ax/Ha/b.c:(Ljava/lang/String;)Lax/Ha/b;
        //   416: aload_1        
        //   417: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   420: invokevirtual   ax/Ha/b.h:()V
        //   423: aload_0        
        //   424: ldc_w           "501 Unsupported Options\r\n"
        //   427: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   430: goto            162
        //   433: aload_0        
        //   434: ldc_w           "200 UTF8 OK\r\n"
        //   437: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   440: goto            162
        //   443: ldc_w           "USER"
        //   446: aload           16
        //   448: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   451: istore          7
        //   453: iload           7
        //   455: ifeq            491
        //   458: aload_0        
        //   459: getfield        com/alphainventor/filemanager/service/a.k:Z
        //   462: ifeq            475
        //   465: aload_0        
        //   466: ldc_w           "230 Access granted\r\n"
        //   469: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   472: goto            162
        //   475: aload_0        
        //   476: aload           13
        //   478: putfield        com/alphainventor/filemanager/service/a.l:Ljava/lang/String;
        //   481: aload_0        
        //   482: ldc_w           "331 Password required\r\n"
        //   485: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   488: goto            162
        //   491: ldc_w           "PASS"
        //   494: aload           16
        //   496: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   499: istore          7
        //   501: iload           7
        //   503: ifeq            563
        //   506: iload_3        
        //   507: ifeq            520
        //   510: aload_0        
        //   511: ldc_w           "530 Maximum number of login attempts exceeded\r\n"
        //   514: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   517: goto            162
        //   520: aload_0        
        //   521: aload_0        
        //   522: getfield        com/alphainventor/filemanager/service/a.l:Ljava/lang/String;
        //   525: aload           13
        //   527: invokespecial   com/alphainventor/filemanager/service/a.c:(Ljava/lang/String;Ljava/lang/String;)Z
        //   530: ifeq            548
        //   533: aload_0        
        //   534: ldc_w           "230 Access granted\r\n"
        //   537: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   540: aload_0        
        //   541: iconst_1       
        //   542: putfield        com/alphainventor/filemanager/service/a.k:Z
        //   545: goto            162
        //   548: aload_2        
        //   549: iconst_1       
        //   550: putfield        com/alphainventor/filemanager/service/a$a.b:Z
        //   553: aload_0        
        //   554: ldc_w           "530 Login incorrect\r\n"
        //   557: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   560: goto            162
        //   563: ldc_w           "SYST"
        //   566: aload           16
        //   568: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   571: istore_3       
        //   572: iload_3        
        //   573: ifeq            586
        //   576: aload_0        
        //   577: ldc_w           "215 UNIX Type: L8\r\n"
        //   580: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   583: goto            162
        //   586: ldc_w           "PWD"
        //   589: aload           16
        //   591: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   594: istore_3       
        //   595: iload_3        
        //   596: ifeq            626
        //   599: aload_0        
        //   600: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //   603: ldc_w           "257 \"%s\"\r\n"
        //   606: iconst_1       
        //   607: anewarray       Ljava/lang/Object;
        //   610: dup            
        //   611: iconst_0       
        //   612: aload_0        
        //   613: getfield        com/alphainventor/filemanager/service/a.f:Ljava/lang/String;
        //   616: aastore        
        //   617: invokestatic    java/lang/String.format:(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   620: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   623: goto            162
        //   626: ldc             "TYPE"
        //   628: aload           16
        //   630: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   633: istore_3       
        //   634: iload_3        
        //   635: ifeq            728
        //   638: ldc_w           "I"
        //   641: aload           13
        //   643: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   646: ifne            660
        //   649: ldc_w           "L 8"
        //   652: aload           13
        //   654: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   657: ifeq            663
        //   660: goto            713
        //   663: ldc_w           "A"
        //   666: aload           13
        //   668: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   671: ifne            685
        //   674: ldc_w           "A N"
        //   677: aload           13
        //   679: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   682: ifeq            688
        //   685: goto            698
        //   688: aload_0        
        //   689: ldc_w           "503 Unknown TYPE command\r\n"
        //   692: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   695: goto            162
        //   698: aload_0        
        //   699: iconst_0       
        //   700: putfield        com/alphainventor/filemanager/service/a.g:Z
        //   703: aload_0        
        //   704: ldc_w           "200 ASCII type set\r\n"
        //   707: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   710: goto            162
        //   713: aload_0        
        //   714: iconst_1       
        //   715: putfield        com/alphainventor/filemanager/service/a.g:Z
        //   718: aload_0        
        //   719: ldc_w           "200 Binary type set\r\n"
        //   722: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   725: goto            162
        //   728: ldc             "PASV"
        //   730: aload           16
        //   732: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   735: istore_3       
        //   736: iload_3        
        //   737: ifeq            834
        //   740: aload_0        
        //   741: getfield        com/alphainventor/filemanager/service/a.b:Ljava/net/Socket;
        //   744: invokevirtual   java/net/Socket.getLocalAddress:()Ljava/net/InetAddress;
        //   747: astore_1       
        //   748: aload_1        
        //   749: ifnull          824
        //   752: aload_0        
        //   753: invokespecial   com/alphainventor/filemanager/service/a.L:()I
        //   756: istore          4
        //   758: iload           4
        //   760: ifgt            766
        //   763: goto            824
        //   766: aload_0        
        //   767: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //   770: ldc_w           "227 Entering Passive Mode (%s,%d,%d).\r\n"
        //   773: iconst_3       
        //   774: anewarray       Ljava/lang/Object;
        //   777: dup            
        //   778: iconst_0       
        //   779: aload_1        
        //   780: invokevirtual   java/net/InetAddress.getHostAddress:()Ljava/lang/String;
        //   783: bipush          46
        //   785: bipush          44
        //   787: invokevirtual   java/lang/String.replace:(CC)Ljava/lang/String;
        //   790: aastore        
        //   791: dup            
        //   792: iconst_1       
        //   793: iload           4
        //   795: sipush          256
        //   798: idiv           
        //   799: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   802: aastore        
        //   803: dup            
        //   804: iconst_2       
        //   805: iload           4
        //   807: sipush          256
        //   810: irem           
        //   811: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   814: aastore        
        //   815: invokestatic    java/lang/String.format:(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   818: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   821: goto            162
        //   824: aload_0        
        //   825: ldc_w           "502 Cannot open a port\r\n"
        //   828: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   831: goto            162
        //   834: ldc             "PORT"
        //   836: aload           16
        //   838: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   841: istore_3       
        //   842: iload_3        
        //   843: ifeq            1013
        //   846: aload           13
        //   848: ldc_w           ","
        //   851: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   854: astore_1       
        //   855: aload_1        
        //   856: ifnull          1003
        //   859: aload_1        
        //   860: arraylength    
        //   861: bipush          6
        //   863: if_icmpeq       869
        //   866: goto            1003
        //   869: iconst_4       
        //   870: newarray        B
        //   872: astore          13
        //   874: iconst_0       
        //   875: istore          4
        //   877: iload           4
        //   879: iconst_4       
        //   880: if_icmpge       930
        //   883: aload_1        
        //   884: iload           4
        //   886: aaload         
        //   887: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   890: istore          6
        //   892: iload           6
        //   894: istore          5
        //   896: iload           6
        //   898: sipush          128
        //   901: if_icmplt       912
        //   904: iload           6
        //   906: sipush          256
        //   909: isub           
        //   910: istore          5
        //   912: aload           13
        //   914: iload           4
        //   916: iload           5
        //   918: i2b            
        //   919: bastore        
        //   920: iinc            4, 1
        //   923: goto            877
        //   926: astore_1       
        //   927: goto            989
        //   930: aload_0        
        //   931: aload_1        
        //   932: iconst_4       
        //   933: aaload         
        //   934: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   937: sipush          256
        //   940: imul           
        //   941: aload_1        
        //   942: iconst_5       
        //   943: aaload         
        //   944: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   947: iadd           
        //   948: putfield        com/alphainventor/filemanager/service/a.j:I
        //   951: aload_0        
        //   952: aload           13
        //   954: invokestatic    java/net/InetAddress.getByAddress:([B)Ljava/net/InetAddress;
        //   957: putfield        com/alphainventor/filemanager/service/a.i:Ljava/net/InetAddress;
        //   960: aload_0        
        //   961: ldc_w           "200 PORT OK\r\n"
        //   964: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   967: aload_0        
        //   968: invokespecial   com/alphainventor/filemanager/service/a.d:()V
        //   971: goto            162
        //   974: astore_1       
        //   975: aload_1        
        //   976: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   979: aload_0        
        //   980: ldc_w           "550 Unknown host\r\n"
        //   983: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //   986: goto            162
        //   989: aload_1        
        //   990: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   993: aload_0        
        //   994: ldc_w           "550 Invalid PORT arguments\r\n"
        //   997: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1000: goto            162
        //  1003: aload_0        
        //  1004: ldc_w           "550 Invalid PORT arguments\r\n"
        //  1007: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1010: goto            162
        //  1013: ldc_w           "SIZE"
        //  1016: aload           16
        //  1018: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1021: istore_3       
        //  1022: iload_3        
        //  1023: ifeq            1157
        //  1026: aload_0        
        //  1027: aload_0        
        //  1028: aload           13
        //  1030: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  1033: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  1036: astore_1       
        //  1037: aload_1        
        //  1038: ifnull          1063
        //  1041: aload_1        
        //  1042: invokeinterface ax/c3/b.n:()Z
        //  1047: ifne            1063
        //  1050: aload_0        
        //  1051: aload_0        
        //  1052: aload           13
        //  1054: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  1057: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1060: goto            162
        //  1063: aload_1        
        //  1064: ifnull          1111
        //  1067: aload_1        
        //  1068: invokeinterface ax/c3/b.isDirectory:()Z
        //  1073: ifeq            1079
        //  1076: goto            1111
        //  1079: aload_0        
        //  1080: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //  1083: ldc_w           "213 %d\r\n"
        //  1086: iconst_1       
        //  1087: anewarray       Ljava/lang/Object;
        //  1090: dup            
        //  1091: iconst_0       
        //  1092: aload_1        
        //  1093: invokeinterface ax/c3/b.p:()J
        //  1098: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //  1101: aastore        
        //  1102: invokestatic    java/lang/String.format:(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //  1105: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1108: goto            162
        //  1111: aload_0        
        //  1112: ldc_w           "550 SIZE request on an invalid file\r\n"
        //  1115: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1118: goto            162
        //  1121: astore_1       
        //  1122: aload_0        
        //  1123: ldc_w           "501 Syntax error\r\n"
        //  1126: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1129: goto            162
        //  1132: astore_1       
        //  1133: aload_0        
        //  1134: ldc_w           "550 Unknown error.\r\n"
        //  1137: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1140: goto            162
        //  1143: astore_1       
        //  1144: aload_0        
        //  1145: aload_0        
        //  1146: aload           13
        //  1148: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  1151: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1154: goto            162
        //  1157: ldc_w           "MDTM"
        //  1160: aload           16
        //  1162: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1165: istore_3       
        //  1166: iload_3        
        //  1167: ifeq            1325
        //  1170: aload_0        
        //  1171: aload_0        
        //  1172: aload           13
        //  1174: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  1177: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  1180: astore_1       
        //  1181: aload_1        
        //  1182: ifnull          1207
        //  1185: aload_1        
        //  1186: invokeinterface ax/c3/b.n:()Z
        //  1191: ifne            1207
        //  1194: aload_0        
        //  1195: aload_0        
        //  1196: aload           13
        //  1198: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  1201: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1204: goto            162
        //  1207: aload_1        
        //  1208: ifnull          1279
        //  1211: aload_1        
        //  1212: invokeinterface ax/c3/b.isDirectory:()Z
        //  1217: ifeq            1223
        //  1220: goto            1279
        //  1223: aload_1        
        //  1224: invokeinterface ax/c3/b.q:()J
        //  1229: lstore          9
        //  1231: aload_0        
        //  1232: getfield        com/alphainventor/filemanager/service/a.s:Ljava/text/SimpleDateFormat;
        //  1235: astore_1       
        //  1236: new             Ljava/util/Date;
        //  1239: astore          14
        //  1241: aload           14
        //  1243: lload           9
        //  1245: invokespecial   java/util/Date.<init>:(J)V
        //  1248: aload_1        
        //  1249: aload           14
        //  1251: invokevirtual   java/text/DateFormat.format:(Ljava/util/Date;)Ljava/lang/String;
        //  1254: astore_1       
        //  1255: aload_0        
        //  1256: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //  1259: ldc_w           "213 %s\r\n"
        //  1262: iconst_1       
        //  1263: anewarray       Ljava/lang/Object;
        //  1266: dup            
        //  1267: iconst_0       
        //  1268: aload_1        
        //  1269: aastore        
        //  1270: invokestatic    java/lang/String.format:(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //  1273: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1276: goto            162
        //  1279: aload_0        
        //  1280: ldc_w           "550 MDTM request on an invalid file\r\n"
        //  1283: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1286: goto            162
        //  1289: astore_1       
        //  1290: aload_0        
        //  1291: ldc_w           "550 MDTM request on an invalid file\r\n"
        //  1294: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1297: goto            162
        //  1300: astore_1       
        //  1301: aload_0        
        //  1302: ldc_w           "501 Syntax error\r\n"
        //  1305: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1308: goto            162
        //  1311: astore_1       
        //  1312: aload_0        
        //  1313: aload_0        
        //  1314: aload           13
        //  1316: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  1319: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1322: goto            162
        //  1325: ldc_w           "MFMT"
        //  1328: aload           16
        //  1330: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1333: istore_3       
        //  1334: iload_3        
        //  1335: ifeq            1635
        //  1338: aload           13
        //  1340: ldc_w           " "
        //  1343: iconst_2       
        //  1344: invokevirtual   java/lang/String.split:(Ljava/lang/String;I)[Ljava/lang/String;
        //  1347: astore          14
        //  1349: aload           14
        //  1351: arraylength    
        //  1352: iconst_2       
        //  1353: if_icmpge       1366
        //  1356: aload_0        
        //  1357: ldc_w           "501 Syntax error\r\n"
        //  1360: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1363: goto            162
        //  1366: aload           14
        //  1368: iconst_0       
        //  1369: aaload         
        //  1370: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //  1373: astore_1       
        //  1374: aload           14
        //  1376: iconst_1       
        //  1377: aaload         
        //  1378: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //  1381: astore          15
        //  1383: aload_0        
        //  1384: aload_0        
        //  1385: aload           15
        //  1387: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  1390: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  1393: astore          14
        //  1395: aload           14
        //  1397: ifnull          1423
        //  1400: aload           14
        //  1402: invokeinterface ax/c3/b.n:()Z
        //  1407: ifne            1423
        //  1410: aload_0        
        //  1411: aload_0        
        //  1412: aload           13
        //  1414: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  1417: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1420: goto            162
        //  1423: aload           14
        //  1425: ifnonnull       1438
        //  1428: aload_0        
        //  1429: ldc_w           "550 MFMT failed to set time\r\n"
        //  1432: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1435: goto            162
        //  1438: aload_0        
        //  1439: aload           14
        //  1441: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //  1444: astore          17
        //  1446: aload           14
        //  1448: invokestatic    ax/c3/B.P:(Lcom/alphainventor/filemanager/file/n;)Z
        //  1451: ifeq            1589
        //  1454: aload_0        
        //  1455: getfield        com/alphainventor/filemanager/service/a.t:Ljava/text/SimpleDateFormat;
        //  1458: ifnonnull       1494
        //  1461: new             Ljava/text/SimpleDateFormat;
        //  1464: astore          16
        //  1466: aload           16
        //  1468: ldc_w           "yyyyMMddHHmmss"
        //  1471: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //  1474: invokespecial   java/text/SimpleDateFormat.<init>:(Ljava/lang/String;Ljava/util/Locale;)V
        //  1477: aload_0        
        //  1478: aload           16
        //  1480: putfield        com/alphainventor/filemanager/service/a.t:Ljava/text/SimpleDateFormat;
        //  1483: aload           16
        //  1485: ldc_w           "UTC"
        //  1488: invokestatic    j$/util/DesugarTimeZone.getTimeZone:(Ljava/lang/String;)Ljava/util/TimeZone;
        //  1491: invokevirtual   java/text/DateFormat.setTimeZone:(Ljava/util/TimeZone;)V
        //  1494: aload_0        
        //  1495: getfield        com/alphainventor/filemanager/service/a.t:Ljava/text/SimpleDateFormat;
        //  1498: aload_1        
        //  1499: invokevirtual   java/text/DateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
        //  1502: astore          16
        //  1504: aload           17
        //  1506: invokevirtual   com/alphainventor/filemanager/file/o.u:()Lcom/alphainventor/filemanager/file/m;
        //  1509: astore          17
        //  1511: aload           17
        //  1513: instanceof      Lcom/alphainventor/filemanager/file/x;
        //  1516: ifeq            1576
        //  1519: aload           17
        //  1521: checkcast       Lcom/alphainventor/filemanager/file/x;
        //  1524: aload           14
        //  1526: aload           16
        //  1528: invokevirtual   java/util/Date.getTime:()J
        //  1531: invokevirtual   com/alphainventor/filemanager/file/x.d:(Lcom/alphainventor/filemanager/file/n;J)Z
        //  1534: ifeq            1566
        //  1537: aload_0        
        //  1538: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //  1541: ldc_w           "213 Modify=%s; %s\r\n"
        //  1544: iconst_2       
        //  1545: anewarray       Ljava/lang/Object;
        //  1548: dup            
        //  1549: iconst_0       
        //  1550: aload_1        
        //  1551: aastore        
        //  1552: dup            
        //  1553: iconst_1       
        //  1554: aload           15
        //  1556: aastore        
        //  1557: invokestatic    java/lang/String.format:(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //  1560: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1563: goto            162
        //  1566: aload_0        
        //  1567: ldc_w           "550 MFMT failed to set time\r\n"
        //  1570: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1573: goto            162
        //  1576: invokestatic    ax/u3/b.f:()V
        //  1579: aload_0        
        //  1580: ldc_w           "550 MFMT failed to set time\r\n"
        //  1583: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1586: goto            162
        //  1589: aload_0        
        //  1590: ldc_w           "550 MFMT failed to set time\r\n"
        //  1593: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1596: goto            162
        //  1599: astore_1       
        //  1600: aload_0        
        //  1601: ldc_w           "550 MFMT failed to set time\r\n"
        //  1604: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1607: goto            162
        //  1610: astore_1       
        //  1611: aload_0        
        //  1612: aload_0        
        //  1613: aload           13
        //  1615: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  1618: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1621: goto            162
        //  1624: astore_1       
        //  1625: aload_0        
        //  1626: ldc_w           "501 Syntax error\r\n"
        //  1629: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1632: goto            162
        //  1635: ldc             "CWD"
        //  1637: aload           16
        //  1639: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1642: istore_3       
        //  1643: iload_3        
        //  1644: ifeq            1753
        //  1647: aload_0        
        //  1648: aload           13
        //  1650: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  1653: astore_1       
        //  1654: aload_0        
        //  1655: aload_1        
        //  1656: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  1659: astore          14
        //  1661: aload           14
        //  1663: invokeinterface ax/c3/b.n:()Z
        //  1668: ifne            1681
        //  1671: aload_0        
        //  1672: ldc_w           "550 No such file or directory.\r\n"
        //  1675: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1678: goto            162
        //  1681: aload_0        
        //  1682: aload           14
        //  1684: invokespecial   com/alphainventor/filemanager/service/a.u:(Lcom/alphainventor/filemanager/file/n;)Z
        //  1687: ifne            1700
        //  1690: aload_0        
        //  1691: ldc_w           "550 CWD to the invalid path\r\n"
        //  1694: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1697: goto            162
        //  1700: aload_0        
        //  1701: aload           14
        //  1703: aload_1        
        //  1704: invokespecial   com/alphainventor/filemanager/service/a.M:(Lcom/alphainventor/filemanager/file/n;Ljava/lang/String;)V
        //  1707: aload_0        
        //  1708: ldc_w           "250 CWD OK\r\n"
        //  1711: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1714: goto            162
        //  1717: astore_1       
        //  1718: aload_0        
        //  1719: ldc_w           "550 Unknown error.\r\n"
        //  1722: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1725: goto            162
        //  1728: astore_1       
        //  1729: aload_0        
        //  1730: aload_0        
        //  1731: aload           13
        //  1733: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  1736: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1739: goto            162
        //  1742: astore_1       
        //  1743: aload_0        
        //  1744: ldc_w           "501 Syntax error\r\n"
        //  1747: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1750: goto            162
        //  1753: ldc             "MLST"
        //  1755: aload           16
        //  1757: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1760: istore_3       
        //  1761: iload_3        
        //  1762: ifeq            1951
        //  1765: new             Ljava/lang/StringBuilder;
        //  1768: astore          14
        //  1770: aload           14
        //  1772: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1775: aload           13
        //  1777: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //  1780: ifeq            1800
        //  1783: aload_0        
        //  1784: getfield        com/alphainventor/filemanager/service/a.f:Ljava/lang/String;
        //  1787: astore_1       
        //  1788: aload           14
        //  1790: ldc_w           "250- Listing .\r\n"
        //  1793: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1796: pop            
        //  1797: goto            1854
        //  1800: aload_0        
        //  1801: aload           13
        //  1803: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  1806: astore_1       
        //  1807: new             Ljava/lang/StringBuilder;
        //  1810: astore          15
        //  1812: aload           15
        //  1814: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1817: aload           15
        //  1819: ldc_w           "250- Listing "
        //  1822: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1825: pop            
        //  1826: aload           15
        //  1828: aload           13
        //  1830: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1833: pop            
        //  1834: aload           15
        //  1836: ldc_w           "\r\n"
        //  1839: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1842: pop            
        //  1843: aload           14
        //  1845: aload           15
        //  1847: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1850: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1853: pop            
        //  1854: aload_0        
        //  1855: aload_1        
        //  1856: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  1859: astore          15
        //  1861: aload           15
        //  1863: invokeinterface ax/c3/b.n:()Z
        //  1868: ifne            1884
        //  1871: aload_0        
        //  1872: aload_0        
        //  1873: aload           13
        //  1875: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  1878: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1881: goto            162
        //  1884: aload_0        
        //  1885: aload           14
        //  1887: iconst_1       
        //  1888: aload           15
        //  1890: aload_1        
        //  1891: invokespecial   com/alphainventor/filemanager/service/a.a:(Ljava/lang/StringBuilder;ZLcom/alphainventor/filemanager/file/n;Ljava/lang/String;)V
        //  1894: aload           14
        //  1896: ldc_w           "250 End\r\n"
        //  1899: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1902: pop            
        //  1903: aload_0        
        //  1904: aload           14
        //  1906: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1909: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1912: goto            162
        //  1915: astore_1       
        //  1916: aload_0        
        //  1917: ldc_w           "550 Unknown error.\r\n"
        //  1920: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1923: goto            162
        //  1926: astore_1       
        //  1927: aload_0        
        //  1928: aload_0        
        //  1929: aload           13
        //  1931: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  1934: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1937: goto            162
        //  1940: astore_1       
        //  1941: aload_0        
        //  1942: ldc_w           "501 Syntax error\r\n"
        //  1945: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  1948: goto            162
        //  1951: ldc_w           "MLSD"
        //  1954: aload           16
        //  1956: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1959: istore_3       
        //  1960: aload           13
        //  1962: astore_1       
        //  1963: iload_3        
        //  1964: ifne            3847
        //  1967: aload           13
        //  1969: astore_1       
        //  1970: ldc             "LIST"
        //  1972: aload           16
        //  1974: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1977: ifne            3847
        //  1980: ldc             "NLST"
        //  1982: aload           16
        //  1984: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  1987: ifeq            1996
        //  1990: aload           13
        //  1992: astore_1       
        //  1993: goto            3847
        //  1996: ldc_w           "QUIT"
        //  1999: aload           16
        //  2001: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2004: ifeq            2017
        //  2007: aload_0        
        //  2008: ldc_w           "221 Goodbye\r\n"
        //  2011: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2014: goto            162
        //  2017: ldc             "CDUP"
        //  2019: aload           16
        //  2021: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2024: ifeq            2167
        //  2027: aload_0        
        //  2028: aload_0        
        //  2029: getfield        com/alphainventor/filemanager/service/a.f:Ljava/lang/String;
        //  2032: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2035: ifeq            2048
        //  2038: aload_0        
        //  2039: ldc_w           "550 Appropriate parent directory does not exist\r\n"
        //  2042: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2045: goto            162
        //  2048: aload_0        
        //  2049: aload_0        
        //  2050: getfield        com/alphainventor/filemanager/service/a.f:Ljava/lang/String;
        //  2053: invokestatic    ax/c3/d0.r:(Ljava/lang/String;)Ljava/lang/String;
        //  2056: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2059: ifeq            2083
        //  2062: aload_0        
        //  2063: aload_0        
        //  2064: getfield        com/alphainventor/filemanager/service/a.d:Lcom/alphainventor/filemanager/file/n;
        //  2067: ldc_w           "/"
        //  2070: invokespecial   com/alphainventor/filemanager/service/a.M:(Lcom/alphainventor/filemanager/file/n;Ljava/lang/String;)V
        //  2073: aload_0        
        //  2074: ldc_w           "200 CDUP OK\r\n"
        //  2077: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2080: goto            162
        //  2083: aload_0        
        //  2084: getfield        com/alphainventor/filemanager/service/a.f:Ljava/lang/String;
        //  2087: invokestatic    ax/c3/d0.r:(Ljava/lang/String;)Ljava/lang/String;
        //  2090: astore_1       
        //  2091: aload_0        
        //  2092: aload_1        
        //  2093: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  2096: astore          14
        //  2098: aload           14
        //  2100: ifnull          2132
        //  2103: aload_0        
        //  2104: aload           14
        //  2106: invokespecial   com/alphainventor/filemanager/service/a.u:(Lcom/alphainventor/filemanager/file/n;)Z
        //  2109: ifne            2115
        //  2112: goto            2132
        //  2115: aload_0        
        //  2116: aload           14
        //  2118: aload_1        
        //  2119: invokespecial   com/alphainventor/filemanager/service/a.M:(Lcom/alphainventor/filemanager/file/n;Ljava/lang/String;)V
        //  2122: aload_0        
        //  2123: ldc_w           "200 CDUP OK\r\n"
        //  2126: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2129: goto            162
        //  2132: aload_0        
        //  2133: ldc_w           "550 Appropriate parent directory does not exist\r\n"
        //  2136: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2139: goto            162
        //  2142: astore_1       
        //  2143: aload_0        
        //  2144: ldc_w           "550 Unknown error.\r\n"
        //  2147: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2150: goto            162
        //  2153: astore_1       
        //  2154: aload_0        
        //  2155: aload_0        
        //  2156: aload           13
        //  2158: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  2161: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2164: goto            162
        //  2167: ldc_w           "FEAT"
        //  2170: aload           16
        //  2172: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2175: ifeq            2188
        //  2178: aload_0        
        //  2179: ldc_w           "211- Extensions supported:\r\n AUTH TLS\r\n PBSZ\r\n PROT\r\n UTF8\r\n MLST\r\n MLSD\r\n MFMT\r\n REST STREAM\r\n211 End.\r\n"
        //  2182: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2185: goto            162
        //  2188: ldc             "DELE"
        //  2190: aload           16
        //  2192: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2195: istore_3       
        //  2196: iload_3        
        //  2197: ifeq            2379
        //  2200: aload_0        
        //  2201: aload           13
        //  2203: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  2206: astore_1       
        //  2207: aload_0        
        //  2208: aload_1        
        //  2209: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2212: ifne            2328
        //  2215: aload_0        
        //  2216: aload_1        
        //  2217: invokestatic    ax/c3/d0.r:(Ljava/lang/String;)Ljava/lang/String;
        //  2220: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2223: ifeq            2229
        //  2226: goto            2328
        //  2229: aload_0        
        //  2230: aload_1        
        //  2231: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  2234: astore_1       
        //  2235: aload_0        
        //  2236: aload_1        
        //  2237: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //  2240: astore          14
        //  2242: aload_1        
        //  2243: invokeinterface ax/c3/b.n:()Z
        //  2248: ifne            2264
        //  2251: aload_0        
        //  2252: aload_0        
        //  2253: aload           13
        //  2255: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  2258: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2261: goto            2335
        //  2264: aload_1        
        //  2265: invokeinterface ax/c3/b.isDirectory:()Z
        //  2270: ifne            2318
        //  2273: aload_0        
        //  2274: aload_1        
        //  2275: invokespecial   com/alphainventor/filemanager/service/a.w:(Lcom/alphainventor/filemanager/file/n;)Z
        //  2278: istore_3       
        //  2279: iload_3        
        //  2280: ifne            2286
        //  2283: goto            2318
        //  2286: aload           14
        //  2288: aload_1        
        //  2289: invokevirtual   com/alphainventor/filemanager/file/o.P:(Lcom/alphainventor/filemanager/file/n;)V
        //  2292: aload_0        
        //  2293: ldc_w           "250 File successfully deleted\r\n"
        //  2296: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2299: aload_1        
        //  2300: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //  2303: astore_1       
        //  2304: goto            2337
        //  2307: astore_1       
        //  2308: aload_0        
        //  2309: ldc_w           "450 Error deleting file\r\n"
        //  2312: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2315: goto            2335
        //  2318: aload_0        
        //  2319: ldc_w           "550 Operation on invalid file\r\n"
        //  2322: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2325: goto            2335
        //  2328: aload_0        
        //  2329: ldc_w           "550 Operation on invalid file\r\n"
        //  2332: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2335: aconst_null    
        //  2336: astore_1       
        //  2337: iconst_0       
        //  2338: istore          4
        //  2340: goto            4522
        //  2343: astore_1       
        //  2344: aload_0        
        //  2345: ldc_w           "550 Unknown error.\r\n"
        //  2348: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2351: goto            162
        //  2354: astore_1       
        //  2355: aload_0        
        //  2356: aload_0        
        //  2357: aload           13
        //  2359: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  2362: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2365: goto            162
        //  2368: astore_1       
        //  2369: aload_0        
        //  2370: ldc_w           "501 Syntax error\r\n"
        //  2373: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2376: goto            162
        //  2379: ldc             "MKD"
        //  2381: aload           16
        //  2383: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2386: istore_3       
        //  2387: iload_3        
        //  2388: ifeq            2551
        //  2391: aload_0        
        //  2392: aload           13
        //  2394: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  2397: astore_1       
        //  2398: aload_0        
        //  2399: aload_1        
        //  2400: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2403: ifne            2505
        //  2406: aload_0        
        //  2407: aload_1        
        //  2408: invokestatic    ax/c3/d0.r:(Ljava/lang/String;)Ljava/lang/String;
        //  2411: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2414: ifeq            2420
        //  2417: goto            2505
        //  2420: aload_0        
        //  2421: aload_1        
        //  2422: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  2425: astore_1       
        //  2426: aload_0        
        //  2427: aload_1        
        //  2428: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //  2431: astore          14
        //  2433: aload_0        
        //  2434: aload_1        
        //  2435: invokespecial   com/alphainventor/filemanager/service/a.w:(Lcom/alphainventor/filemanager/file/n;)Z
        //  2438: ifne            2451
        //  2441: aload_0        
        //  2442: ldc_w           "550 Operation on invalid file\r\n"
        //  2445: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2448: goto            2335
        //  2451: aload_1        
        //  2452: invokeinterface ax/c3/b.n:()Z
        //  2457: ifeq            2470
        //  2460: aload_0        
        //  2461: ldc_w           "550 Already exists\r\n"
        //  2464: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2467: goto            2335
        //  2470: aload           14
        //  2472: aload_1        
        //  2473: iconst_0       
        //  2474: invokevirtual   com/alphainventor/filemanager/file/o.k:(Lcom/alphainventor/filemanager/file/n;Z)Z
        //  2477: ifne            2490
        //  2480: aload_0        
        //  2481: ldc_w           "550 MKD denied\r\n"
        //  2484: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2487: goto            2335
        //  2490: aload_0        
        //  2491: ldc_w           "250 Directory created\r\n"
        //  2494: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2497: aload_1        
        //  2498: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //  2501: astore_1       
        //  2502: goto            2337
        //  2505: aload_0        
        //  2506: ldc_w           "550 Operation on invalid file\r\n"
        //  2509: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2512: goto            2335
        //  2515: astore_1       
        //  2516: aload_0        
        //  2517: ldc_w           "550 Unknown error.\r\n"
        //  2520: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2523: goto            162
        //  2526: astore_1       
        //  2527: aload_0        
        //  2528: aload_0        
        //  2529: aload           13
        //  2531: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  2534: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2537: goto            162
        //  2540: astore_1       
        //  2541: aload_0        
        //  2542: ldc_w           "501 Syntax error\r\n"
        //  2545: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2548: goto            162
        //  2551: ldc             "RMD"
        //  2553: aload           16
        //  2555: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2558: istore_3       
        //  2559: iload_3        
        //  2560: ifeq            2753
        //  2563: aload_0        
        //  2564: aload           13
        //  2566: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  2569: astore_1       
        //  2570: aload_0        
        //  2571: aload_1        
        //  2572: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2575: ifne            2707
        //  2578: aload_0        
        //  2579: aload_1        
        //  2580: invokestatic    ax/c3/d0.r:(Ljava/lang/String;)Ljava/lang/String;
        //  2583: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2586: ifeq            2592
        //  2589: goto            2707
        //  2592: aload_0        
        //  2593: aload_1        
        //  2594: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  2597: astore          14
        //  2599: aload_0        
        //  2600: aload           14
        //  2602: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //  2605: astore_1       
        //  2606: aload           14
        //  2608: invokeinterface ax/c3/b.n:()Z
        //  2613: ifne            2629
        //  2616: aload_0        
        //  2617: aload_0        
        //  2618: aload           13
        //  2620: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  2623: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2626: goto            2335
        //  2629: aload           14
        //  2631: invokeinterface ax/c3/b.isDirectory:()Z
        //  2636: ifeq            2697
        //  2639: aload_0        
        //  2640: aload           14
        //  2642: invokespecial   com/alphainventor/filemanager/service/a.w:(Lcom/alphainventor/filemanager/file/n;)Z
        //  2645: istore_3       
        //  2646: iload_3        
        //  2647: ifne            2653
        //  2650: goto            2697
        //  2653: aload_1        
        //  2654: aload           14
        //  2656: invokevirtual   com/alphainventor/filemanager/file/o.P:(Lcom/alphainventor/filemanager/file/n;)V
        //  2659: aload_0        
        //  2660: ldc_w           "250 Directory removed\r\n"
        //  2663: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2666: aload           14
        //  2668: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //  2671: astore_1       
        //  2672: goto            2337
        //  2675: astore_1       
        //  2676: aload_0        
        //  2677: ldc_w           "550 RMD failed\r\n"
        //  2680: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2683: goto            2335
        //  2686: astore_1       
        //  2687: aload_0        
        //  2688: ldc_w           "550 Directory not empty\r\n"
        //  2691: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2694: goto            2335
        //  2697: aload_0        
        //  2698: ldc_w           "550 Operation on invalid file\r\n"
        //  2701: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2704: goto            2335
        //  2707: aload_0        
        //  2708: ldc_w           "550 Operation on invalid file\r\n"
        //  2711: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2714: goto            2335
        //  2717: astore_1       
        //  2718: aload_0        
        //  2719: ldc_w           "550 Unknown error.\r\n"
        //  2722: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2725: goto            162
        //  2728: astore_1       
        //  2729: aload_0        
        //  2730: aload_0        
        //  2731: aload           13
        //  2733: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  2736: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2739: goto            162
        //  2742: astore_1       
        //  2743: aload_0        
        //  2744: ldc_w           "501 Syntax error\r\n"
        //  2747: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2750: goto            162
        //  2753: ldc             "RNFR"
        //  2755: aload           16
        //  2757: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2760: istore_3       
        //  2761: iload_3        
        //  2762: ifeq            2901
        //  2765: aload_0        
        //  2766: aload           13
        //  2768: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  2771: astore_1       
        //  2772: aload_0        
        //  2773: aload_1        
        //  2774: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2777: ifne            2855
        //  2780: aload_0        
        //  2781: aload_1        
        //  2782: invokestatic    ax/c3/d0.r:(Ljava/lang/String;)Ljava/lang/String;
        //  2785: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2788: ifeq            2794
        //  2791: goto            2855
        //  2794: aload_0        
        //  2795: aload_1        
        //  2796: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  2799: astore_1       
        //  2800: aload_0        
        //  2801: aload_1        
        //  2802: invokespecial   com/alphainventor/filemanager/service/a.w:(Lcom/alphainventor/filemanager/file/n;)Z
        //  2805: ifne            2818
        //  2808: aload_0        
        //  2809: ldc_w           "550 Operation on invalid file\r\n"
        //  2812: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2815: goto            162
        //  2818: aload_1        
        //  2819: invokeinterface ax/c3/b.n:()Z
        //  2824: ifne            2840
        //  2827: aload_0        
        //  2828: aload_0        
        //  2829: aload           13
        //  2831: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  2834: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2837: goto            162
        //  2840: aload_0        
        //  2841: aload_1        
        //  2842: putfield        com/alphainventor/filemanager/service/a.p:Lcom/alphainventor/filemanager/file/n;
        //  2845: aload_0        
        //  2846: ldc_w           "350 Waiting for RNTO\r\n"
        //  2849: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2852: goto            162
        //  2855: aload_0        
        //  2856: ldc_w           "550 Operation on invalid file\r\n"
        //  2859: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2862: goto            162
        //  2865: astore_1       
        //  2866: aload_0        
        //  2867: ldc_w           "550 Unknown error.\r\n"
        //  2870: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2873: goto            162
        //  2876: astore_1       
        //  2877: aload_0        
        //  2878: aload_0        
        //  2879: aload           13
        //  2881: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  2884: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2887: goto            162
        //  2890: astore_1       
        //  2891: aload_0        
        //  2892: ldc_w           "501 Syntax error\r\n"
        //  2895: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2898: goto            162
        //  2901: ldc_w           "RNTO"
        //  2904: aload           16
        //  2906: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2909: istore_3       
        //  2910: iload_3        
        //  2911: ifeq            3353
        //  2914: aload_0        
        //  2915: aload           13
        //  2917: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  2920: astore_1       
        //  2921: aload_1        
        //  2922: ifnull          3307
        //  2925: aload_0        
        //  2926: aload_1        
        //  2927: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2930: ifne            3307
        //  2933: aload_0        
        //  2934: aload_1        
        //  2935: invokestatic    ax/c3/d0.r:(Ljava/lang/String;)Ljava/lang/String;
        //  2938: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  2941: ifeq            2947
        //  2944: goto            3307
        //  2947: aload_0        
        //  2948: getfield        com/alphainventor/filemanager/service/a.p:Lcom/alphainventor/filemanager/file/n;
        //  2951: ifnonnull       2964
        //  2954: aload_0        
        //  2955: ldc_w           "550 RNFR was not processed\r\n"
        //  2958: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  2961: goto            2335
        //  2964: aload_0        
        //  2965: aload_1        
        //  2966: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  2969: astore          14
        //  2971: aload_0        
        //  2972: aload           14
        //  2974: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //  2977: astore          16
        //  2979: aload_0        
        //  2980: getfield        com/alphainventor/filemanager/service/a.p:Lcom/alphainventor/filemanager/file/n;
        //  2983: astore_1       
        //  2984: aload_0        
        //  2985: aload_1        
        //  2986: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //  2989: astore          17
        //  2991: aload           16
        //  2993: aload           14
        //  2995: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //  2998: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  3001: astore          15
        //  3003: aload_0        
        //  3004: aload           14
        //  3006: invokespecial   com/alphainventor/filemanager/service/a.w:(Lcom/alphainventor/filemanager/file/n;)Z
        //  3009: ifne            3022
        //  3012: aload_0        
        //  3013: ldc_w           "550 Operation on invalid file\r\n"
        //  3016: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3019: goto            2335
        //  3022: aload           14
        //  3024: invokeinterface ax/c3/b.n:()Z
        //  3029: ifeq            3042
        //  3032: aload_0        
        //  3033: ldc_w           "550 Rename failed\r\n"
        //  3036: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3039: goto            2335
        //  3042: aload           15
        //  3044: invokeinterface ax/c3/b.n:()Z
        //  3049: ifne            3062
        //  3052: aload_0        
        //  3053: ldc_w           "553 File name not allowed\r\n"
        //  3056: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3059: goto            2335
        //  3062: aload_1        
        //  3063: invokeinterface ax/c3/b.isDirectory:()Z
        //  3068: istore_3       
        //  3069: iload_3        
        //  3070: ifne            3089
        //  3073: aload           17
        //  3075: aload_1        
        //  3076: aload           16
        //  3078: aload           14
        //  3080: iconst_1       
        //  3081: aconst_null    
        //  3082: aconst_null    
        //  3083: invokevirtual   com/alphainventor/filemanager/file/o.h0:(Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/o;Lcom/alphainventor/filemanager/file/n;ZLax/u3/c;Lax/g3/i;)V
        //  3086: goto            3211
        //  3089: aload           14
        //  3091: invokevirtual   com/alphainventor/filemanager/file/n.P:()Lax/Q2/f;
        //  3094: aload_1        
        //  3095: invokevirtual   com/alphainventor/filemanager/file/n.P:()Lax/Q2/f;
        //  3098: if_acmpne       3227
        //  3101: aload           17
        //  3103: aload_1        
        //  3104: invokevirtual   com/alphainventor/filemanager/file/o.B:(Lcom/alphainventor/filemanager/file/n;)Z
        //  3107: ifne            3125
        //  3110: aload_1        
        //  3111: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //  3114: aload           14
        //  3116: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //  3119: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  3122: ifeq            3128
        //  3125: goto            3201
        //  3128: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //  3131: ldc_w           "FTP MOVE 1"
        //  3134: invokevirtual   ax/Ha/b.c:(Ljava/lang/String;)Lax/Ha/b;
        //  3137: astore          16
        //  3139: new             Ljava/lang/StringBuilder;
        //  3142: astore          15
        //  3144: aload           15
        //  3146: invokespecial   java/lang/StringBuilder.<init>:()V
        //  3149: aload           15
        //  3151: aload_1        
        //  3152: invokevirtual   com/alphainventor/filemanager/file/n.P:()Lax/Q2/f;
        //  3155: invokevirtual   ax/Q2/f.I:()Ljava/lang/String;
        //  3158: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3161: pop            
        //  3162: aload           15
        //  3164: ldc_w           "->"
        //  3167: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3170: pop            
        //  3171: aload           15
        //  3173: aload           14
        //  3175: invokevirtual   com/alphainventor/filemanager/file/n.P:()Lax/Q2/f;
        //  3178: invokevirtual   ax/Q2/f.I:()Ljava/lang/String;
        //  3181: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3184: pop            
        //  3185: aload           16
        //  3187: aload           15
        //  3189: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  3192: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //  3195: invokevirtual   ax/Ha/b.h:()V
        //  3198: goto            3297
        //  3201: aload           17
        //  3203: aload_1        
        //  3204: aload           14
        //  3206: aconst_null    
        //  3207: aconst_null    
        //  3208: invokevirtual   com/alphainventor/filemanager/file/o.E:(Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/n;Lax/u3/c;Lax/g3/i;)V
        //  3211: aload_0        
        //  3212: ldc_w           "250 Rename succeeded\r\n"
        //  3215: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3218: aload           14
        //  3220: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //  3223: astore_1       
        //  3224: goto            2337
        //  3227: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //  3230: ldc_w           "FTP MOVE 2"
        //  3233: invokevirtual   ax/Ha/b.c:(Ljava/lang/String;)Lax/Ha/b;
        //  3236: astore          16
        //  3238: new             Ljava/lang/StringBuilder;
        //  3241: astore          15
        //  3243: aload           15
        //  3245: invokespecial   java/lang/StringBuilder.<init>:()V
        //  3248: aload           15
        //  3250: aload_1        
        //  3251: invokevirtual   com/alphainventor/filemanager/file/n.P:()Lax/Q2/f;
        //  3254: invokevirtual   ax/Q2/f.I:()Ljava/lang/String;
        //  3257: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3260: pop            
        //  3261: aload           15
        //  3263: ldc_w           "->"
        //  3266: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3269: pop            
        //  3270: aload           15
        //  3272: aload           14
        //  3274: invokevirtual   com/alphainventor/filemanager/file/n.P:()Lax/Q2/f;
        //  3277: invokevirtual   ax/Q2/f.I:()Ljava/lang/String;
        //  3280: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  3283: pop            
        //  3284: aload           16
        //  3286: aload           15
        //  3288: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  3291: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //  3294: invokevirtual   ax/Ha/b.h:()V
        //  3297: aload_0        
        //  3298: ldc_w           "550 Rename failed\r\n"
        //  3301: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3304: goto            2335
        //  3307: aload_0        
        //  3308: ldc_w           "550 Operation on invalid file\r\n"
        //  3311: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3314: goto            2335
        //  3317: astore_1       
        //  3318: aload_0        
        //  3319: ldc_w           "550 Unknown error.\r\n"
        //  3322: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3325: goto            162
        //  3328: astore_1       
        //  3329: aload_0        
        //  3330: aload_0        
        //  3331: aload           13
        //  3333: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  3336: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3339: goto            162
        //  3342: astore_1       
        //  3343: aload_0        
        //  3344: ldc_w           "501 Syntax error\r\n"
        //  3347: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3350: goto            162
        //  3353: ldc             "RETR"
        //  3355: aload           16
        //  3357: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  3360: istore_3       
        //  3361: iload_3        
        //  3362: ifeq            3519
        //  3365: aload_0        
        //  3366: aload           13
        //  3368: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  3371: astore_1       
        //  3372: aload_0        
        //  3373: aload_1        
        //  3374: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  3377: ifne            3473
        //  3380: aload_0        
        //  3381: aload_1        
        //  3382: invokestatic    ax/c3/d0.r:(Ljava/lang/String;)Ljava/lang/String;
        //  3385: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  3388: ifeq            3394
        //  3391: goto            3473
        //  3394: aload_0        
        //  3395: aload_1        
        //  3396: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  3399: astore_1       
        //  3400: aload_1        
        //  3401: invokeinterface ax/c3/b.n:()Z
        //  3406: ifne            3422
        //  3409: aload_0        
        //  3410: aload_0        
        //  3411: aload           13
        //  3413: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  3416: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3419: goto            162
        //  3422: aload_1        
        //  3423: invokeinterface ax/c3/b.isDirectory:()Z
        //  3428: ifne            3463
        //  3431: aload_1        
        //  3432: invokeinterface ax/c3/b.d:()Z
        //  3437: ifeq            3463
        //  3440: aload_0        
        //  3441: aload_1        
        //  3442: invokespecial   com/alphainventor/filemanager/service/a.w:(Lcom/alphainventor/filemanager/file/n;)Z
        //  3445: ifne            3451
        //  3448: goto            3463
        //  3451: aload_0        
        //  3452: aload_1        
        //  3453: aload_0        
        //  3454: getfield        com/alphainventor/filemanager/service/a.A:J
        //  3457: invokespecial   com/alphainventor/filemanager/service/a.J:(Lcom/alphainventor/filemanager/file/n;J)V
        //  3460: goto            162
        //  3463: aload_0        
        //  3464: ldc_w           "550 Operation on invalid file\r\n"
        //  3467: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3470: goto            162
        //  3473: aload_0        
        //  3474: ldc_w           "550 Operation on invalid file\r\n"
        //  3477: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3480: goto            162
        //  3483: astore_1       
        //  3484: aload_0        
        //  3485: ldc_w           "550 Unknown error.\r\n"
        //  3488: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3491: goto            162
        //  3494: astore_1       
        //  3495: aload_0        
        //  3496: aload_0        
        //  3497: aload           13
        //  3499: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  3502: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3505: goto            162
        //  3508: astore_1       
        //  3509: aload_0        
        //  3510: ldc_w           "501 Syntax error\r\n"
        //  3513: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3516: goto            162
        //  3519: ldc             "REST"
        //  3521: aload           16
        //  3523: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  3526: istore_3       
        //  3527: iload_3        
        //  3528: ifeq            3592
        //  3531: aload_0        
        //  3532: aload           13
        //  3534: invokestatic    java/lang/Long.valueOf:(Ljava/lang/String;)Ljava/lang/Long;
        //  3537: invokevirtual   java/lang/Long.longValue:()J
        //  3540: putfield        com/alphainventor/filemanager/service/a.A:J
        //  3543: aload_0        
        //  3544: ldc_w           "350 REST set\r\n"
        //  3547: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3550: aconst_null    
        //  3551: astore_1       
        //  3552: iconst_1       
        //  3553: istore          4
        //  3555: goto            4522
        //  3558: astore_1       
        //  3559: iconst_1       
        //  3560: istore          4
        //  3562: goto            4595
        //  3565: astore_1       
        //  3566: iconst_1       
        //  3567: istore          4
        //  3569: goto            3576
        //  3572: astore_1       
        //  3573: iconst_0       
        //  3574: istore          4
        //  3576: aload_0        
        //  3577: ldc_w           "501 Invalid REST option\r\n"
        //  3580: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3583: aconst_null    
        //  3584: astore_1       
        //  3585: goto            4522
        //  3588: astore_1       
        //  3589: goto            4595
        //  3592: ldc             "STOR"
        //  3594: aload           16
        //  3596: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  3599: ifne            3625
        //  3602: ldc             "APPE"
        //  3604: aload           16
        //  3606: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  3609: ifeq            3615
        //  3612: goto            3625
        //  3615: aload_0        
        //  3616: ldc_w           "550 Unsupported command\r\n"
        //  3619: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3622: goto            162
        //  3625: aload_0        
        //  3626: aload           13
        //  3628: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  3631: astore_1       
        //  3632: aload_0        
        //  3633: aload_1        
        //  3634: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  3637: ifne            3801
        //  3640: aload_0        
        //  3641: aload_1        
        //  3642: invokestatic    ax/c3/d0.r:(Ljava/lang/String;)Ljava/lang/String;
        //  3645: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  3648: ifeq            3654
        //  3651: goto            3801
        //  3654: aload_0        
        //  3655: aload_1        
        //  3656: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  3659: astore_1       
        //  3660: aload_1        
        //  3661: invokeinterface ax/c3/b.isDirectory:()Z
        //  3666: ifne            3791
        //  3669: aload_0        
        //  3670: aload_1        
        //  3671: invokespecial   com/alphainventor/filemanager/service/a.w:(Lcom/alphainventor/filemanager/file/n;)Z
        //  3674: ifne            3680
        //  3677: goto            3791
        //  3680: ldc             "APPE"
        //  3682: aload           16
        //  3684: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  3687: istore_3       
        //  3688: aload_0        
        //  3689: aload_1        
        //  3690: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //  3693: astore          14
        //  3695: aload_0        
        //  3696: getfield        com/alphainventor/filemanager/service/a.A:J
        //  3699: lconst_0       
        //  3700: lcmp           
        //  3701: ifle            3751
        //  3704: iload_3        
        //  3705: ifne            3751
        //  3708: aload_1        
        //  3709: invokeinterface ax/c3/b.p:()J
        //  3714: lstore          11
        //  3716: aload_0        
        //  3717: getfield        com/alphainventor/filemanager/service/a.A:J
        //  3720: lstore          9
        //  3722: lload           11
        //  3724: lload           9
        //  3726: lcmp           
        //  3727: ifge            3740
        //  3730: aload_0        
        //  3731: ldc_w           "550 Operation on invalid file\r\n"
        //  3734: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3737: goto            162
        //  3740: aload_0        
        //  3741: aload_1        
        //  3742: iconst_0       
        //  3743: lload           9
        //  3745: invokespecial   com/alphainventor/filemanager/service/a.F:(Lcom/alphainventor/filemanager/file/n;ZJ)V
        //  3748: goto            162
        //  3751: aload_1        
        //  3752: invokeinterface ax/c3/b.n:()Z
        //  3757: ifeq            3770
        //  3760: iload_3        
        //  3761: ifne            3770
        //  3764: aload           14
        //  3766: aload_1        
        //  3767: invokevirtual   com/alphainventor/filemanager/file/o.P:(Lcom/alphainventor/filemanager/file/n;)V
        //  3770: aload_0        
        //  3771: aload_1        
        //  3772: iload_3        
        //  3773: lconst_0       
        //  3774: invokespecial   com/alphainventor/filemanager/service/a.F:(Lcom/alphainventor/filemanager/file/n;ZJ)V
        //  3777: goto            162
        //  3780: astore_1       
        //  3781: aload_0        
        //  3782: ldc_w           "451 Cannot overwrite the file\r\n"
        //  3785: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3788: goto            162
        //  3791: aload_0        
        //  3792: ldc_w           "550 Operation on invalid file\r\n"
        //  3795: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3798: goto            162
        //  3801: aload_0        
        //  3802: ldc_w           "550 Operation on invalid file\r\n"
        //  3805: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3808: goto            162
        //  3811: astore_1       
        //  3812: aload_0        
        //  3813: ldc_w           "550 Unknown error.\r\n"
        //  3816: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3819: goto            162
        //  3822: astore_1       
        //  3823: aload_0        
        //  3824: aload_0        
        //  3825: aload           13
        //  3827: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  3830: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3833: goto            162
        //  3836: astore_1       
        //  3837: aload_0        
        //  3838: ldc_w           "501 Syntax error\r\n"
        //  3841: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3844: goto            162
        //  3847: aload_1        
        //  3848: ldc_w           "-"
        //  3851: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //  3854: istore_3       
        //  3855: aload_1        
        //  3856: astore          13
        //  3858: iload_3        
        //  3859: ifeq            3896
        //  3862: aload_1        
        //  3863: ldc_w           " "
        //  3866: iconst_2       
        //  3867: invokevirtual   java/lang/String.split:(Ljava/lang/String;I)[Ljava/lang/String;
        //  3870: astore_1       
        //  3871: aload_1        
        //  3872: ifnull          3891
        //  3875: aload_1        
        //  3876: arraylength    
        //  3877: iconst_2       
        //  3878: if_icmpge       3884
        //  3881: goto            3891
        //  3884: aload_1        
        //  3885: iconst_1       
        //  3886: aaload         
        //  3887: astore_1       
        //  3888: goto            3847
        //  3891: ldc_w           ""
        //  3894: astore          13
        //  3896: aload           13
        //  3898: ldc_w           "*"
        //  3901: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //  3904: istore_3       
        //  3905: iload_3        
        //  3906: ifeq            3922
        //  3909: aload_0        
        //  3910: ldc_w           "550 LIST/NLST does not support wildcards\r\n"
        //  3913: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  3916: aload_0        
        //  3917: lconst_0       
        //  3918: putfield        com/alphainventor/filemanager/service/a.A:J
        //  3921: return         
        //  3922: aload           13
        //  3924: invokevirtual   java/lang/String.length:()I
        //  3927: istore          4
        //  3929: iload           4
        //  3931: ifne            3956
        //  3934: aload_0        
        //  3935: getfield        com/alphainventor/filemanager/service/a.f:Ljava/lang/String;
        //  3938: astore_1       
        //  3939: aload_0        
        //  3940: getfield        com/alphainventor/filemanager/service/a.e:Lcom/alphainventor/filemanager/file/n;
        //  3943: astore          15
        //  3945: aload_0        
        //  3946: aload           15
        //  3948: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //  3951: astore          14
        //  3953: goto            3978
        //  3956: aload_0        
        //  3957: aload           13
        //  3959: invokespecial   com/alphainventor/filemanager/service/a.l:(Ljava/lang/String;)Ljava/lang/String;
        //  3962: astore_1       
        //  3963: aload_0        
        //  3964: aload_1        
        //  3965: invokespecial   com/alphainventor/filemanager/service/a.o:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //  3968: astore          15
        //  3970: aload_0        
        //  3971: aload           15
        //  3973: invokespecial   com/alphainventor/filemanager/service/a.p:(Lcom/alphainventor/filemanager/file/n;)Lcom/alphainventor/filemanager/file/o;
        //  3976: astore          14
        //  3978: aload           15
        //  3980: invokeinterface ax/c3/b.n:()Z
        //  3985: istore_3       
        //  3986: iload_3        
        //  3987: ifne            4006
        //  3990: aload_0        
        //  3991: aload_0        
        //  3992: aload           13
        //  3994: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  3997: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4000: aload_0        
        //  4001: lconst_0       
        //  4002: putfield        com/alphainventor/filemanager/service/a.A:J
        //  4005: return         
        //  4006: ldc             "NLST"
        //  4008: aload           16
        //  4010: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  4013: istore          7
        //  4015: ldc_w           "MLSD"
        //  4018: aload           16
        //  4020: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  4023: istore_3       
        //  4024: aload           15
        //  4026: invokeinterface ax/c3/b.isDirectory:()Z
        //  4031: istore          8
        //  4033: iload           8
        //  4035: ifeq            4469
        //  4038: aload_0        
        //  4039: aload_1        
        //  4040: invokespecial   com/alphainventor/filemanager/service/a.v:(Ljava/lang/String;)Z
        //  4043: istore          8
        //  4045: iload           8
        //  4047: ifeq            4149
        //  4050: new             Ljava/util/ArrayList;
        //  4053: astore_1       
        //  4054: aload_1        
        //  4055: invokespecial   java/util/ArrayList.<init>:()V
        //  4058: aload_0        
        //  4059: getfield        com/alphainventor/filemanager/service/a.w:Ljava/util/List;
        //  4062: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //  4067: astore          13
        //  4069: aload           13
        //  4071: invokeinterface java/util/Iterator.hasNext:()Z
        //  4076: ifeq            4134
        //  4079: aload           13
        //  4081: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //  4086: checkcast       Lax/c3/K;
        //  4089: astore          14
        //  4091: aload_0        
        //  4092: getfield        com/alphainventor/filemanager/service/a.v:Ljava/util/Map;
        //  4095: aload           14
        //  4097: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //  4102: checkcast       Lcom/alphainventor/filemanager/file/n;
        //  4105: astore          14
        //  4107: aload           14
        //  4109: ifnull          4069
        //  4112: aload_1        
        //  4113: aload           14
        //  4115: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //  4120: pop            
        //  4121: goto            4069
        //  4124: astore          13
        //  4126: goto            4205
        //  4129: astore          13
        //  4131: goto            4208
        //  4134: goto            4181
        //  4137: astore_1       
        //  4138: aconst_null    
        //  4139: astore_1       
        //  4140: goto            4205
        //  4143: astore_1       
        //  4144: aconst_null    
        //  4145: astore_1       
        //  4146: goto            4208
        //  4149: aload           14
        //  4151: aload           15
        //  4153: invokevirtual   com/alphainventor/filemanager/file/o.f0:(Lcom/alphainventor/filemanager/file/n;)Ljava/util/List;
        //  4156: astore_1       
        //  4157: aload_0        
        //  4158: getfield        com/alphainventor/filemanager/service/a.z:Z
        //  4161: istore          8
        //  4163: aload_1        
        //  4164: aconst_null    
        //  4165: iload           8
        //  4167: iconst_1       
        //  4168: invokestatic    ax/c3/B.h:(Ljava/util/List;Ljava/lang/String;ZZ)Ljava/util/List;
        //  4171: ldc_w           "NameUp"
        //  4174: invokestatic    ax/c3/q.c:(Ljava/lang/String;)Lax/c3/q;
        //  4177: invokestatic    ax/c3/q.g:(Ljava/util/List;Lax/c3/q;)Ljava/util/List;
        //  4180: astore_1       
        //  4181: iconst_0       
        //  4182: istore          4
        //  4184: goto            4211
        //  4187: aconst_null    
        //  4188: astore_1       
        //  4189: goto            4205
        //  4192: aconst_null    
        //  4193: astore_1       
        //  4194: goto            4208
        //  4197: astore_1       
        //  4198: goto            4187
        //  4201: astore_1       
        //  4202: goto            4192
        //  4205: goto            4181
        //  4208: iconst_1       
        //  4209: istore          4
        //  4211: aload_1        
        //  4212: ifnull          4444
        //  4215: aload_0        
        //  4216: invokespecial   com/alphainventor/filemanager/service/a.B:()Ljava/net/Socket;
        //  4219: astore          14
        //  4221: aload           14
        //  4223: ifnonnull       4247
        //  4226: aload_0        
        //  4227: aload           14
        //  4229: invokespecial   com/alphainventor/filemanager/service/a.f:(Ljava/net/Socket;)V
        //  4232: aload_0        
        //  4233: ldc_w           "425 Error opening data socket\r\n"
        //  4236: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4239: aload_0        
        //  4240: lconst_0       
        //  4241: putfield        com/alphainventor/filemanager/service/a.A:J
        //  4244: goto            4594
        //  4247: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //  4250: astore          15
        //  4252: aload_0        
        //  4253: getfield        com/alphainventor/filemanager/service/a.g:Z
        //  4256: ifeq            4275
        //  4259: ldc_w           "BINARY"
        //  4262: astore          13
        //  4264: goto            4283
        //  4267: astore_1       
        //  4268: goto            4436
        //  4271: astore_1       
        //  4272: goto            4426
        //  4275: ldc_w           "ASCII"
        //  4278: astore          13
        //  4280: goto            4264
        //  4283: aload_0        
        //  4284: aload           15
        //  4286: ldc_w           "150 Opening %s mode data connection for %s\r\n"
        //  4289: iconst_2       
        //  4290: anewarray       Ljava/lang/Object;
        //  4293: dup            
        //  4294: iconst_0       
        //  4295: aload           13
        //  4297: aastore        
        //  4298: dup            
        //  4299: iconst_1       
        //  4300: aload           16
        //  4302: aastore        
        //  4303: invokestatic    java/lang/String.format:(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //  4306: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4309: aload_0        
        //  4310: aload           14
        //  4312: invokespecial   com/alphainventor/filemanager/service/a.N:(Ljava/net/Socket;)Z
        //  4315: istore          8
        //  4317: iload           8
        //  4319: ifne            4338
        //  4322: aload_0        
        //  4323: ldc_w           "426 Data socket or network error\r\n"
        //  4326: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4329: aload_0        
        //  4330: aload           14
        //  4332: invokespecial   com/alphainventor/filemanager/service/a.f:(Ljava/net/Socket;)V
        //  4335: goto            4239
        //  4338: aload           14
        //  4340: invokevirtual   java/net/Socket.getOutputStream:()Ljava/io/OutputStream;
        //  4343: astore          13
        //  4345: aload_1        
        //  4346: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //  4351: astore_1       
        //  4352: aload_1        
        //  4353: invokeinterface java/util/Iterator.hasNext:()Z
        //  4358: ifeq            4405
        //  4361: aload_0        
        //  4362: aload_1        
        //  4363: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //  4368: checkcast       Lcom/alphainventor/filemanager/file/n;
        //  4371: iload_3        
        //  4372: iload           7
        //  4374: invokespecial   com/alphainventor/filemanager/service/a.g:(Lcom/alphainventor/filemanager/file/n;ZZ)Ljava/lang/String;
        //  4377: astore          15
        //  4379: aload           15
        //  4381: ifnull          4352
        //  4384: aload           15
        //  4386: invokevirtual   java/lang/String.getBytes:()[B
        //  4389: astore          15
        //  4391: aload           13
        //  4393: aload           15
        //  4395: iconst_0       
        //  4396: aload           15
        //  4398: arraylength    
        //  4399: invokevirtual   java/io/OutputStream.write:([BII)V
        //  4402: goto            4352
        //  4405: aload           13
        //  4407: invokevirtual   java/io/OutputStream.flush:()V
        //  4410: aload_0        
        //  4411: ldc_w           "226 Data transmission succeeded\r\n"
        //  4414: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4417: aload_0        
        //  4418: aload           14
        //  4420: invokespecial   com/alphainventor/filemanager/service/a.f:(Ljava/net/Socket;)V
        //  4423: goto            162
        //  4426: aload_0        
        //  4427: ldc_w           "426 Data socket or network error\r\n"
        //  4430: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4433: goto            4329
        //  4436: aload_0        
        //  4437: aload           14
        //  4439: invokespecial   com/alphainventor/filemanager/service/a.f:(Ljava/net/Socket;)V
        //  4442: aload_1        
        //  4443: athrow         
        //  4444: iload           4
        //  4446: ifeq            4459
        //  4449: aload_0        
        //  4450: ldc_w           "550 Permission denied\r\n"
        //  4453: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4456: goto            162
        //  4459: aload_0        
        //  4460: ldc_w           "550 Failed to list files\r\n"
        //  4463: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4466: goto            162
        //  4469: iload_3        
        //  4470: ifeq            4486
        //  4473: aload_0        
        //  4474: ldc_w           "501 Not a directory\r\n"
        //  4477: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4480: aload_0        
        //  4481: lconst_0       
        //  4482: putfield        com/alphainventor/filemanager/service/a.A:J
        //  4485: return         
        //  4486: aload_0        
        //  4487: aload           15
        //  4489: iconst_0       
        //  4490: iload           7
        //  4492: invokespecial   com/alphainventor/filemanager/service/a.g:(Lcom/alphainventor/filemanager/file/n;ZZ)Ljava/lang/String;
        //  4495: astore_1       
        //  4496: aload_1        
        //  4497: ifnonnull       4510
        //  4500: aload_0        
        //  4501: ldc_w           "550 Failed to list files\r\n"
        //  4504: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4507: goto            4517
        //  4510: aload_0        
        //  4511: aload           16
        //  4513: aload_1        
        //  4514: invokespecial   com/alphainventor/filemanager/service/a.K:(Ljava/lang/String;Ljava/lang/String;)V
        //  4517: aconst_null    
        //  4518: astore_1       
        //  4519: goto            2337
        //  4522: aload_2        
        //  4523: aload_1        
        //  4524: putfield        com/alphainventor/filemanager/service/a$a.a:Ljava/lang/String;
        //  4527: iload           4
        //  4529: ifne            4594
        //  4532: goto            4239
        //  4535: astore_1       
        //  4536: goto            4595
        //  4539: astore_1       
        //  4540: goto            134
        //  4543: astore_1       
        //  4544: goto            4555
        //  4547: astore_1       
        //  4548: goto            4570
        //  4551: astore_1       
        //  4552: goto            4584
        //  4555: aload_0        
        //  4556: ldc_w           "550 Unknown error.\r\n"
        //  4559: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4562: goto            4239
        //  4565: astore_1       
        //  4566: goto            134
        //  4569: astore_1       
        //  4570: aload_0        
        //  4571: aload_0        
        //  4572: aload           13
        //  4574: invokespecial   com/alphainventor/filemanager/service/a.y:(Ljava/lang/String;)Ljava/lang/String;
        //  4577: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4580: goto            4239
        //  4583: astore_1       
        //  4584: aload_0        
        //  4585: ldc_w           "501 Syntax error\r\n"
        //  4588: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4591: goto            4239
        //  4594: return         
        //  4595: iload           4
        //  4597: ifne            4605
        //  4600: aload_0        
        //  4601: lconst_0       
        //  4602: putfield        com/alphainventor/filemanager/service/a.A:J
        //  4605: aload_1        
        //  4606: athrow         
        //  4607: aload_0        
        //  4608: ldc_w           "502 Command not recognized\r\n"
        //  4611: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
        //  4614: return         
        //  4615: astore_1       
        //  4616: goto            3297
        //  4619: astore_1       
        //  4620: goto            4192
        //  4623: astore_1       
        //  4624: goto            4187
        //  4627: astore_1       
        //  4628: goto            4426
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  100    106    4539   4543   Any
        //  111    127    133    134    Any
        //  140    150    4539   4543   Any
        //  155    162    133    134    Any
        //  165    175    4539   4543   Any
        //  180    187    133    134    Any
        //  190    199    4539   4543   Any
        //  204    218    133    134    Any
        //  221    228    133    134    Any
        //  231    240    4539   4543   Any
        //  245    259    133    134    Any
        //  262    293    133    134    Any
        //  296    323    133    134    Any
        //  326    333    133    134    Any
        //  336    346    4539   4543   Any
        //  351    379    133    134    Any
        //  382    390    133    134    Any
        //  394    401    133    134    Any
        //  404    430    133    134    Any
        //  433    440    133    134    Any
        //  443    453    4539   4543   Any
        //  458    472    133    134    Any
        //  475    488    133    134    Any
        //  491    501    4539   4543   Any
        //  510    517    133    134    Any
        //  520    545    133    134    Any
        //  548    560    133    134    Any
        //  563    572    4539   4543   Any
        //  576    583    133    134    Any
        //  586    595    4539   4543   Any
        //  599    623    133    134    Any
        //  626    634    4539   4543   Any
        //  638    660    133    134    Any
        //  663    685    133    134    Any
        //  688    695    133    134    Any
        //  698    710    133    134    Any
        //  713    725    133    134    Any
        //  728    736    4539   4543   Any
        //  740    748    133    134    Any
        //  752    758    133    134    Any
        //  766    821    133    134    Any
        //  824    831    133    134    Any
        //  834    842    4539   4543   Any
        //  846    855    133    134    Any
        //  859    866    133    134    Any
        //  869    874    133    134    Any
        //  883    892    926    1003   Ljava/lang/Exception;
        //  883    892    133    134    Any
        //  930    951    926    1003   Ljava/lang/Exception;
        //  930    951    133    134    Any
        //  951    971    974    989    Ljava/net/UnknownHostException;
        //  951    971    133    134    Any
        //  975    986    133    134    Any
        //  989    1000   133    134    Any
        //  1003   1010   133    134    Any
        //  1013   1022   4539   4543   Any
        //  1026   1037   1143   1157   Lax/b3/t;
        //  1026   1037   1132   1143   Lax/b3/j;
        //  1026   1037   1121   1132   Ljava/lang/IllegalArgumentException;
        //  1026   1037   133    134    Any
        //  1041   1060   1143   1157   Lax/b3/t;
        //  1041   1060   1132   1143   Lax/b3/j;
        //  1041   1060   1121   1132   Ljava/lang/IllegalArgumentException;
        //  1041   1060   133    134    Any
        //  1067   1076   1143   1157   Lax/b3/t;
        //  1067   1076   1132   1143   Lax/b3/j;
        //  1067   1076   1121   1132   Ljava/lang/IllegalArgumentException;
        //  1067   1076   133    134    Any
        //  1079   1108   1143   1157   Lax/b3/t;
        //  1079   1108   1132   1143   Lax/b3/j;
        //  1079   1108   1121   1132   Ljava/lang/IllegalArgumentException;
        //  1079   1108   133    134    Any
        //  1111   1118   1143   1157   Lax/b3/t;
        //  1111   1118   1132   1143   Lax/b3/j;
        //  1111   1118   1121   1132   Ljava/lang/IllegalArgumentException;
        //  1111   1118   133    134    Any
        //  1122   1129   133    134    Any
        //  1133   1140   133    134    Any
        //  1144   1154   133    134    Any
        //  1157   1166   4539   4543   Any
        //  1170   1181   1311   1325   Lax/b3/t;
        //  1170   1181   1300   1311   Ljava/lang/IllegalArgumentException;
        //  1170   1181   1289   1300   Lax/b3/j;
        //  1170   1181   133    134    Any
        //  1185   1204   1311   1325   Lax/b3/t;
        //  1185   1204   1300   1311   Ljava/lang/IllegalArgumentException;
        //  1185   1204   1289   1300   Lax/b3/j;
        //  1185   1204   133    134    Any
        //  1211   1220   1311   1325   Lax/b3/t;
        //  1211   1220   1300   1311   Ljava/lang/IllegalArgumentException;
        //  1211   1220   1289   1300   Lax/b3/j;
        //  1211   1220   133    134    Any
        //  1223   1276   1311   1325   Lax/b3/t;
        //  1223   1276   1300   1311   Ljava/lang/IllegalArgumentException;
        //  1223   1276   1289   1300   Lax/b3/j;
        //  1223   1276   133    134    Any
        //  1279   1286   1311   1325   Lax/b3/t;
        //  1279   1286   1300   1311   Ljava/lang/IllegalArgumentException;
        //  1279   1286   1289   1300   Lax/b3/j;
        //  1279   1286   133    134    Any
        //  1290   1297   133    134    Any
        //  1301   1308   133    134    Any
        //  1312   1322   133    134    Any
        //  1325   1334   4539   4543   Any
        //  1338   1363   133    134    Any
        //  1366   1383   133    134    Any
        //  1383   1395   1624   1635   Ljava/lang/IllegalArgumentException;
        //  1383   1395   1624   1635   Ljava/text/ParseException;
        //  1383   1395   1610   1624   Lax/b3/t;
        //  1383   1395   1599   1610   Lax/b3/j;
        //  1383   1395   133    134    Any
        //  1400   1420   1624   1635   Ljava/lang/IllegalArgumentException;
        //  1400   1420   1624   1635   Ljava/text/ParseException;
        //  1400   1420   1610   1624   Lax/b3/t;
        //  1400   1420   1599   1610   Lax/b3/j;
        //  1400   1420   133    134    Any
        //  1428   1435   1624   1635   Ljava/lang/IllegalArgumentException;
        //  1428   1435   1624   1635   Ljava/text/ParseException;
        //  1428   1435   1610   1624   Lax/b3/t;
        //  1428   1435   1599   1610   Lax/b3/j;
        //  1428   1435   133    134    Any
        //  1438   1494   1624   1635   Ljava/lang/IllegalArgumentException;
        //  1438   1494   1624   1635   Ljava/text/ParseException;
        //  1438   1494   1610   1624   Lax/b3/t;
        //  1438   1494   1599   1610   Lax/b3/j;
        //  1438   1494   133    134    Any
        //  1494   1563   1624   1635   Ljava/lang/IllegalArgumentException;
        //  1494   1563   1624   1635   Ljava/text/ParseException;
        //  1494   1563   1610   1624   Lax/b3/t;
        //  1494   1563   1599   1610   Lax/b3/j;
        //  1494   1563   133    134    Any
        //  1566   1573   1624   1635   Ljava/lang/IllegalArgumentException;
        //  1566   1573   1624   1635   Ljava/text/ParseException;
        //  1566   1573   1610   1624   Lax/b3/t;
        //  1566   1573   1599   1610   Lax/b3/j;
        //  1566   1573   133    134    Any
        //  1576   1586   1624   1635   Ljava/lang/IllegalArgumentException;
        //  1576   1586   1624   1635   Ljava/text/ParseException;
        //  1576   1586   1610   1624   Lax/b3/t;
        //  1576   1586   1599   1610   Lax/b3/j;
        //  1576   1586   133    134    Any
        //  1589   1596   1624   1635   Ljava/lang/IllegalArgumentException;
        //  1589   1596   1624   1635   Ljava/text/ParseException;
        //  1589   1596   1610   1624   Lax/b3/t;
        //  1589   1596   1599   1610   Lax/b3/j;
        //  1589   1596   133    134    Any
        //  1600   1607   133    134    Any
        //  1611   1621   133    134    Any
        //  1625   1632   133    134    Any
        //  1635   1643   4539   4543   Any
        //  1647   1678   1742   1753   Ljava/lang/IllegalArgumentException;
        //  1647   1678   1728   1742   Lax/b3/t;
        //  1647   1678   1717   1728   Lax/b3/j;
        //  1647   1678   133    134    Any
        //  1681   1697   1742   1753   Ljava/lang/IllegalArgumentException;
        //  1681   1697   1728   1742   Lax/b3/t;
        //  1681   1697   1717   1728   Lax/b3/j;
        //  1681   1697   133    134    Any
        //  1700   1714   1742   1753   Ljava/lang/IllegalArgumentException;
        //  1700   1714   1728   1742   Lax/b3/t;
        //  1700   1714   1717   1728   Lax/b3/j;
        //  1700   1714   133    134    Any
        //  1718   1725   133    134    Any
        //  1729   1739   133    134    Any
        //  1743   1750   133    134    Any
        //  1753   1761   4539   4543   Any
        //  1765   1797   1940   1951   Ljava/lang/IllegalArgumentException;
        //  1765   1797   1926   1940   Lax/b3/t;
        //  1765   1797   1915   1926   Lax/b3/j;
        //  1765   1797   133    134    Any
        //  1800   1854   1940   1951   Ljava/lang/IllegalArgumentException;
        //  1800   1854   1926   1940   Lax/b3/t;
        //  1800   1854   1915   1926   Lax/b3/j;
        //  1800   1854   133    134    Any
        //  1854   1881   1940   1951   Ljava/lang/IllegalArgumentException;
        //  1854   1881   1926   1940   Lax/b3/t;
        //  1854   1881   1915   1926   Lax/b3/j;
        //  1854   1881   133    134    Any
        //  1884   1912   1940   1951   Ljava/lang/IllegalArgumentException;
        //  1884   1912   1926   1940   Lax/b3/t;
        //  1884   1912   1915   1926   Lax/b3/j;
        //  1884   1912   133    134    Any
        //  1916   1923   133    134    Any
        //  1927   1937   133    134    Any
        //  1941   1948   133    134    Any
        //  1951   1960   4539   4543   Any
        //  1970   1990   133    134    Any
        //  1996   2014   133    134    Any
        //  2017   2045   133    134    Any
        //  2048   2080   133    134    Any
        //  2083   2098   2153   2167   Lax/b3/t;
        //  2083   2098   2142   2153   Lax/b3/j;
        //  2083   2098   133    134    Any
        //  2103   2112   2153   2167   Lax/b3/t;
        //  2103   2112   2142   2153   Lax/b3/j;
        //  2103   2112   133    134    Any
        //  2115   2129   2153   2167   Lax/b3/t;
        //  2115   2129   2142   2153   Lax/b3/j;
        //  2115   2129   133    134    Any
        //  2132   2139   2153   2167   Lax/b3/t;
        //  2132   2139   2142   2153   Lax/b3/j;
        //  2132   2139   133    134    Any
        //  2143   2150   133    134    Any
        //  2154   2164   133    134    Any
        //  2167   2185   133    134    Any
        //  2188   2196   133    134    Any
        //  2200   2226   2368   2379   Ljava/lang/IllegalArgumentException;
        //  2200   2226   2354   2368   Lax/b3/t;
        //  2200   2226   2343   2354   Lax/b3/j;
        //  2200   2226   133    134    Any
        //  2229   2261   2368   2379   Ljava/lang/IllegalArgumentException;
        //  2229   2261   2354   2368   Lax/b3/t;
        //  2229   2261   2343   2354   Lax/b3/j;
        //  2229   2261   133    134    Any
        //  2264   2279   2368   2379   Ljava/lang/IllegalArgumentException;
        //  2264   2279   2354   2368   Lax/b3/t;
        //  2264   2279   2343   2354   Lax/b3/j;
        //  2264   2279   133    134    Any
        //  2286   2304   2307   2318   Lax/b3/j;
        //  2286   2304   2368   2379   Ljava/lang/IllegalArgumentException;
        //  2286   2304   133    134    Any
        //  2308   2315   2368   2379   Ljava/lang/IllegalArgumentException;
        //  2308   2315   2354   2368   Lax/b3/t;
        //  2308   2315   2343   2354   Lax/b3/j;
        //  2308   2315   133    134    Any
        //  2318   2325   2368   2379   Ljava/lang/IllegalArgumentException;
        //  2318   2325   2354   2368   Lax/b3/t;
        //  2318   2325   2343   2354   Lax/b3/j;
        //  2318   2325   133    134    Any
        //  2328   2335   2368   2379   Ljava/lang/IllegalArgumentException;
        //  2328   2335   2354   2368   Lax/b3/t;
        //  2328   2335   2343   2354   Lax/b3/j;
        //  2328   2335   133    134    Any
        //  2344   2351   133    134    Any
        //  2355   2365   133    134    Any
        //  2369   2376   133    134    Any
        //  2379   2387   133    134    Any
        //  2391   2417   2540   2551   Ljava/lang/IllegalArgumentException;
        //  2391   2417   2526   2540   Lax/b3/t;
        //  2391   2417   2515   2526   Lax/b3/j;
        //  2391   2417   133    134    Any
        //  2420   2448   2540   2551   Ljava/lang/IllegalArgumentException;
        //  2420   2448   2526   2540   Lax/b3/t;
        //  2420   2448   2515   2526   Lax/b3/j;
        //  2420   2448   133    134    Any
        //  2451   2467   2540   2551   Ljava/lang/IllegalArgumentException;
        //  2451   2467   2526   2540   Lax/b3/t;
        //  2451   2467   2515   2526   Lax/b3/j;
        //  2451   2467   133    134    Any
        //  2470   2487   2540   2551   Ljava/lang/IllegalArgumentException;
        //  2470   2487   2526   2540   Lax/b3/t;
        //  2470   2487   2515   2526   Lax/b3/j;
        //  2470   2487   133    134    Any
        //  2490   2502   2540   2551   Ljava/lang/IllegalArgumentException;
        //  2490   2502   2526   2540   Lax/b3/t;
        //  2490   2502   2515   2526   Lax/b3/j;
        //  2490   2502   133    134    Any
        //  2505   2512   2540   2551   Ljava/lang/IllegalArgumentException;
        //  2505   2512   2526   2540   Lax/b3/t;
        //  2505   2512   2515   2526   Lax/b3/j;
        //  2505   2512   133    134    Any
        //  2516   2523   133    134    Any
        //  2527   2537   133    134    Any
        //  2541   2548   133    134    Any
        //  2551   2559   133    134    Any
        //  2563   2589   2742   2753   Ljava/lang/IllegalArgumentException;
        //  2563   2589   2728   2742   Lax/b3/t;
        //  2563   2589   2717   2728   Lax/b3/j;
        //  2563   2589   133    134    Any
        //  2592   2626   2742   2753   Ljava/lang/IllegalArgumentException;
        //  2592   2626   2728   2742   Lax/b3/t;
        //  2592   2626   2717   2728   Lax/b3/j;
        //  2592   2626   133    134    Any
        //  2629   2646   2742   2753   Ljava/lang/IllegalArgumentException;
        //  2629   2646   2728   2742   Lax/b3/t;
        //  2629   2646   2717   2728   Lax/b3/j;
        //  2629   2646   133    134    Any
        //  2653   2672   2686   2697   Lax/b3/k;
        //  2653   2672   2675   2686   Lax/b3/j;
        //  2653   2672   2742   2753   Ljava/lang/IllegalArgumentException;
        //  2653   2672   133    134    Any
        //  2676   2683   2742   2753   Ljava/lang/IllegalArgumentException;
        //  2676   2683   2728   2742   Lax/b3/t;
        //  2676   2683   2717   2728   Lax/b3/j;
        //  2676   2683   133    134    Any
        //  2687   2694   2742   2753   Ljava/lang/IllegalArgumentException;
        //  2687   2694   2728   2742   Lax/b3/t;
        //  2687   2694   2717   2728   Lax/b3/j;
        //  2687   2694   133    134    Any
        //  2697   2704   2742   2753   Ljava/lang/IllegalArgumentException;
        //  2697   2704   2728   2742   Lax/b3/t;
        //  2697   2704   2717   2728   Lax/b3/j;
        //  2697   2704   133    134    Any
        //  2707   2714   2742   2753   Ljava/lang/IllegalArgumentException;
        //  2707   2714   2728   2742   Lax/b3/t;
        //  2707   2714   2717   2728   Lax/b3/j;
        //  2707   2714   133    134    Any
        //  2718   2725   133    134    Any
        //  2729   2739   133    134    Any
        //  2743   2750   133    134    Any
        //  2753   2761   133    134    Any
        //  2765   2791   2890   2901   Ljava/lang/IllegalArgumentException;
        //  2765   2791   2876   2890   Lax/b3/t;
        //  2765   2791   2865   2876   Lax/b3/j;
        //  2765   2791   133    134    Any
        //  2794   2815   2890   2901   Ljava/lang/IllegalArgumentException;
        //  2794   2815   2876   2890   Lax/b3/t;
        //  2794   2815   2865   2876   Lax/b3/j;
        //  2794   2815   133    134    Any
        //  2818   2837   2890   2901   Ljava/lang/IllegalArgumentException;
        //  2818   2837   2876   2890   Lax/b3/t;
        //  2818   2837   2865   2876   Lax/b3/j;
        //  2818   2837   133    134    Any
        //  2840   2852   2890   2901   Ljava/lang/IllegalArgumentException;
        //  2840   2852   2876   2890   Lax/b3/t;
        //  2840   2852   2865   2876   Lax/b3/j;
        //  2840   2852   133    134    Any
        //  2855   2862   2890   2901   Ljava/lang/IllegalArgumentException;
        //  2855   2862   2876   2890   Lax/b3/t;
        //  2855   2862   2865   2876   Lax/b3/j;
        //  2855   2862   133    134    Any
        //  2866   2873   133    134    Any
        //  2877   2887   133    134    Any
        //  2891   2898   133    134    Any
        //  2901   2910   133    134    Any
        //  2914   2921   3342   3353   Ljava/lang/IllegalArgumentException;
        //  2914   2921   3328   3342   Lax/b3/t;
        //  2914   2921   3317   3328   Lax/b3/j;
        //  2914   2921   133    134    Any
        //  2925   2944   3342   3353   Ljava/lang/IllegalArgumentException;
        //  2925   2944   3328   3342   Lax/b3/t;
        //  2925   2944   3317   3328   Lax/b3/j;
        //  2925   2944   133    134    Any
        //  2947   2961   3342   3353   Ljava/lang/IllegalArgumentException;
        //  2947   2961   3328   3342   Lax/b3/t;
        //  2947   2961   3317   3328   Lax/b3/j;
        //  2947   2961   133    134    Any
        //  2964   3019   3342   3353   Ljava/lang/IllegalArgumentException;
        //  2964   3019   3328   3342   Lax/b3/t;
        //  2964   3019   3317   3328   Lax/b3/j;
        //  2964   3019   133    134    Any
        //  3022   3039   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3022   3039   3328   3342   Lax/b3/t;
        //  3022   3039   3317   3328   Lax/b3/j;
        //  3022   3039   133    134    Any
        //  3042   3059   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3042   3059   3328   3342   Lax/b3/t;
        //  3042   3059   3317   3328   Lax/b3/j;
        //  3042   3059   133    134    Any
        //  3062   3069   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3062   3069   3328   3342   Lax/b3/t;
        //  3062   3069   3317   3328   Lax/b3/j;
        //  3062   3069   133    134    Any
        //  3073   3086   4615   4619   Lax/b3/j;
        //  3073   3086   4615   4619   Lax/b3/a;
        //  3073   3086   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3073   3086   133    134    Any
        //  3089   3125   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3089   3125   3328   3342   Lax/b3/t;
        //  3089   3125   3317   3328   Lax/b3/j;
        //  3089   3125   133    134    Any
        //  3128   3198   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3128   3198   3328   3342   Lax/b3/t;
        //  3128   3198   3317   3328   Lax/b3/j;
        //  3128   3198   133    134    Any
        //  3201   3211   4615   4619   Lax/b3/j;
        //  3201   3211   4615   4619   Lax/b3/a;
        //  3201   3211   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3201   3211   133    134    Any
        //  3211   3224   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3211   3224   3328   3342   Lax/b3/t;
        //  3211   3224   3317   3328   Lax/b3/j;
        //  3211   3224   133    134    Any
        //  3227   3297   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3227   3297   3328   3342   Lax/b3/t;
        //  3227   3297   3317   3328   Lax/b3/j;
        //  3227   3297   133    134    Any
        //  3297   3304   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3297   3304   3328   3342   Lax/b3/t;
        //  3297   3304   3317   3328   Lax/b3/j;
        //  3297   3304   133    134    Any
        //  3307   3314   3342   3353   Ljava/lang/IllegalArgumentException;
        //  3307   3314   3328   3342   Lax/b3/t;
        //  3307   3314   3317   3328   Lax/b3/j;
        //  3307   3314   133    134    Any
        //  3318   3325   133    134    Any
        //  3329   3339   133    134    Any
        //  3343   3350   133    134    Any
        //  3353   3361   133    134    Any
        //  3365   3391   3508   3519   Ljava/lang/IllegalArgumentException;
        //  3365   3391   3494   3508   Lax/b3/t;
        //  3365   3391   3483   3494   Lax/b3/j;
        //  3365   3391   133    134    Any
        //  3394   3419   3508   3519   Ljava/lang/IllegalArgumentException;
        //  3394   3419   3494   3508   Lax/b3/t;
        //  3394   3419   3483   3494   Lax/b3/j;
        //  3394   3419   133    134    Any
        //  3422   3448   3508   3519   Ljava/lang/IllegalArgumentException;
        //  3422   3448   3494   3508   Lax/b3/t;
        //  3422   3448   3483   3494   Lax/b3/j;
        //  3422   3448   133    134    Any
        //  3451   3460   3508   3519   Ljava/lang/IllegalArgumentException;
        //  3451   3460   3494   3508   Lax/b3/t;
        //  3451   3460   3483   3494   Lax/b3/j;
        //  3451   3460   133    134    Any
        //  3463   3470   3508   3519   Ljava/lang/IllegalArgumentException;
        //  3463   3470   3494   3508   Lax/b3/t;
        //  3463   3470   3483   3494   Lax/b3/j;
        //  3463   3470   133    134    Any
        //  3473   3480   3508   3519   Ljava/lang/IllegalArgumentException;
        //  3473   3480   3494   3508   Lax/b3/t;
        //  3473   3480   3483   3494   Lax/b3/j;
        //  3473   3480   133    134    Any
        //  3484   3491   133    134    Any
        //  3495   3505   133    134    Any
        //  3509   3516   133    134    Any
        //  3519   3527   133    134    Any
        //  3531   3543   3572   3576   Ljava/lang/NumberFormatException;
        //  3531   3543   133    134    Any
        //  3543   3550   3565   3572   Ljava/lang/NumberFormatException;
        //  3543   3550   3558   3565   Any
        //  3576   3583   3588   3592   Any
        //  3592   3612   133    134    Any
        //  3615   3622   133    134    Any
        //  3625   3651   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3625   3651   3822   3836   Lax/b3/t;
        //  3625   3651   3811   3822   Lax/b3/j;
        //  3625   3651   133    134    Any
        //  3654   3677   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3654   3677   3822   3836   Lax/b3/t;
        //  3654   3677   3811   3822   Lax/b3/j;
        //  3654   3677   133    134    Any
        //  3680   3704   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3680   3704   3822   3836   Lax/b3/t;
        //  3680   3704   3811   3822   Lax/b3/j;
        //  3680   3704   133    134    Any
        //  3708   3722   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3708   3722   3822   3836   Lax/b3/t;
        //  3708   3722   3811   3822   Lax/b3/j;
        //  3708   3722   133    134    Any
        //  3730   3737   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3730   3737   3822   3836   Lax/b3/t;
        //  3730   3737   3811   3822   Lax/b3/j;
        //  3730   3737   133    134    Any
        //  3740   3748   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3740   3748   3822   3836   Lax/b3/t;
        //  3740   3748   3811   3822   Lax/b3/j;
        //  3740   3748   133    134    Any
        //  3751   3760   3780   3791   Lax/b3/j;
        //  3751   3760   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3751   3760   133    134    Any
        //  3764   3770   3780   3791   Lax/b3/j;
        //  3764   3770   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3764   3770   133    134    Any
        //  3770   3777   3780   3791   Lax/b3/j;
        //  3770   3777   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3770   3777   133    134    Any
        //  3781   3788   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3781   3788   3822   3836   Lax/b3/t;
        //  3781   3788   3811   3822   Lax/b3/j;
        //  3781   3788   133    134    Any
        //  3791   3798   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3791   3798   3822   3836   Lax/b3/t;
        //  3791   3798   3811   3822   Lax/b3/j;
        //  3791   3798   133    134    Any
        //  3801   3808   3836   3847   Ljava/lang/IllegalArgumentException;
        //  3801   3808   3822   3836   Lax/b3/t;
        //  3801   3808   3811   3822   Lax/b3/j;
        //  3801   3808   133    134    Any
        //  3812   3819   133    134    Any
        //  3823   3833   133    134    Any
        //  3837   3844   133    134    Any
        //  3847   3855   4539   4543   Any
        //  3862   3871   133    134    Any
        //  3875   3881   133    134    Any
        //  3896   3905   4539   4543   Any
        //  3909   3916   133    134    Any
        //  3922   3929   4539   4543   Any
        //  3934   3953   133    134    Any
        //  3956   3963   4583   4584   Ljava/lang/IllegalArgumentException;
        //  3956   3963   4569   4570   Lax/b3/t;
        //  3956   3963   4543   4569   Lax/b3/j;
        //  3956   3963   4539   4543   Any
        //  3963   3978   4551   4555   Ljava/lang/IllegalArgumentException;
        //  3963   3978   4547   4551   Lax/b3/t;
        //  3963   3978   4543   4569   Lax/b3/j;
        //  3963   3978   4539   4543   Any
        //  3978   3986   4539   4543   Any
        //  3990   4000   133    134    Any
        //  4006   4033   4539   4543   Any
        //  4038   4045   4201   4205   Lax/b3/e;
        //  4038   4045   4197   4201   Lax/b3/j;
        //  4038   4045   133    134    Any
        //  4050   4058   4143   4149   Lax/b3/e;
        //  4050   4058   4137   4143   Lax/b3/j;
        //  4050   4058   133    134    Any
        //  4058   4069   4129   4134   Lax/b3/e;
        //  4058   4069   4124   4129   Lax/b3/j;
        //  4058   4069   133    134    Any
        //  4069   4107   4129   4134   Lax/b3/e;
        //  4069   4107   4124   4129   Lax/b3/j;
        //  4069   4107   133    134    Any
        //  4112   4121   4129   4134   Lax/b3/e;
        //  4112   4121   4124   4129   Lax/b3/j;
        //  4112   4121   133    134    Any
        //  4149   4163   4201   4205   Lax/b3/e;
        //  4149   4163   4197   4201   Lax/b3/j;
        //  4149   4163   133    134    Any
        //  4163   4181   4619   4623   Lax/b3/e;
        //  4163   4181   4623   4627   Lax/b3/j;
        //  4163   4181   133    134    Any
        //  4215   4221   133    134    Any
        //  4226   4239   133    134    Any
        //  4247   4259   4271   4275   Ljava/io/IOException;
        //  4247   4259   4267   4271   Any
        //  4283   4317   4271   4275   Ljava/io/IOException;
        //  4283   4317   4267   4271   Any
        //  4322   4329   4627   4631   Ljava/io/IOException;
        //  4322   4329   4267   4271   Any
        //  4329   4335   133    134    Any
        //  4338   4352   4627   4631   Ljava/io/IOException;
        //  4338   4352   4267   4271   Any
        //  4352   4379   4627   4631   Ljava/io/IOException;
        //  4352   4379   4267   4271   Any
        //  4384   4402   4627   4631   Ljava/io/IOException;
        //  4384   4402   4267   4271   Any
        //  4405   4417   4627   4631   Ljava/io/IOException;
        //  4405   4417   4267   4271   Any
        //  4417   4423   133    134    Any
        //  4426   4433   4267   4271   Any
        //  4436   4444   133    134    Any
        //  4449   4456   133    134    Any
        //  4459   4466   133    134    Any
        //  4473   4480   133    134    Any
        //  4486   4496   133    134    Any
        //  4500   4507   133    134    Any
        //  4510   4517   133    134    Any
        //  4522   4527   4535   4539   Any
        //  4555   4562   4565   4569   Any
        //  4570   4580   133    134    Any
        //  4584   4591   133    134    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 2118 out of bounds for length 2118
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
    
    public void O(final String s) {
        this.P(s.getBytes());
    }
    
    public void P(final byte[] array) {
        try {
            ((OutputStream)this.c).write(array);
            this.c.flush();
        }
        catch (final IOException ex) {
            ((Throwable)ex).printStackTrace();
        }
    }
    
    public void e() {
        this.d();
        for (final o o : this.u.values()) {
            if (Q.X1() && o.Y()) {
                o.n(null);
            }
            o.k0(true);
        }
        this.u.clear();
        this.x.clear();
        this.v.clear();
        this.w.clear();
    }
    
    InputStream m() throws IOException {
        return this.b.getInputStream();
    }
    
    BufferedOutputStream n() {
        return this.c;
    }
    
    public void t() {
        ((AbstractCollection)this.o).addAll((Collection)Arrays.asList((Object[])com.alphainventor.filemanager.service.a.F));
        ax.Z2.j.F().K0();
        this.b(K.e, "/device");
        final K h = K.h;
        this.M(this.d = (n)new y((com.alphainventor.filemanager.file.x)ax.c3.x.e(h).u(), new File("/"), h, true, false, true, false, 0L, 0L), "/");
        final boolean t0 = ax.Z2.j.F().t0();
        this.y = t0;
        if (t0) {
            this.b(K.f, "/sdcard");
        }
        if (this.z && ax.t3.j.B(this.a)) {
            this.b(h, "/system");
        }
        final List a = ax.Z2.j.F().A();
        if (a != null) {
            final Iterator iterator = a.iterator();
            int n = 2;
            while (iterator.hasNext()) {
                final K k = (K)iterator.next();
                if (!ax.Q2.f.j0(k.d())) {
                    continue;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("/sdcard");
                sb.append(n);
                this.b(k, sb.toString());
                ++n;
            }
        }
        final List b = ax.Z2.j.F().B();
        final HashSet set = new HashSet();
        if (b != null) {
            for (final K i : b) {
                if (!ax.Q2.f.Y(i.d())) {
                    continue;
                }
                String s2;
                final String s = s2 = i.f(this.a);
                StringBuilder sb2;
                for (int n2 = 2; set.contains((Object)s2); s2 = sb2.toString(), ++n2) {
                    sb2 = new StringBuilder();
                    sb2.append(s);
                    sb2.append(" ");
                    sb2.append(n2);
                }
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("/");
                sb3.append(s2);
                this.b(i, sb3.toString());
                set.add((Object)s2);
            }
        }
    }
    
    static class a
    {
        String a;
        boolean b;
        boolean c;
        
        void a() {
            this.a = null;
            this.b = false;
            this.c = false;
        }
    }
}
