package com.alphainventor.filemanager.service;

import android.os.Binder;
import java.net.Socket;
import ax.Ha.c;
import java.util.Locale;
import ax.s3.u;
import android.app.Notification;
import java.util.Iterator;
import android.content.Context;
import ax.u3.C;
import android.content.Intent;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import ax.Q2.g;
import java.util.HashMap;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.List;
import android.net.wifi.WifiManager;
import ax.u3.D;
import java.net.ServerSocket;
import android.os.IBinder;
import java.util.logging.Logger;
import android.annotation.SuppressLint;
import android.app.Service;

@SuppressLint({ "DefaultLocale" })
public class FtpServerService extends Service
{
    private static final Logger o;
    private static d p;
    private final IBinder a;
    private FtpServerService.FtpServerService$e b;
    private ServerSocket c;
    private f d;
    private D e;
    private int f;
    private String g;
    private boolean h;
    private WifiManager i;
    private int j;
    private String k;
    private List<b> l;
    private HashSet<InetAddress> m;
    private HashMap<InetAddress, Integer> n;
    
    static {
        o = g.a((Class)FtpServerService.class);
    }
    
    public FtpServerService() {
        this.a = (IBinder)new c();
        this.l = (List<b>)new ArrayList();
        this.m = (HashSet<InetAddress>)new HashSet();
        this.n = (HashMap<InetAddress, Integer>)new HashMap();
    }
    
    private void A(final b b) {
        monitorenter(this);
        Label_0038: {
            try {
                this.l.remove((Object)b);
                if (this.l.size() <= 0) {
                    this.stopSelf();
                }
                break Label_0038;
            }
            finally {
                monitorexit(this);
                monitorexit(this);
            }
        }
    }
    
    private void D() throws IOException {
        (this.c = new ServerSocket()).setReuseAddress(true);
        this.c.bind((SocketAddress)new InetSocketAddress(this.f));
    }
    
    private void E(final Intent intent) {
        this.k = intent.getStringExtra("extra_ip_address");
        this.f = intent.getIntExtra("extra_port_number", 0);
        this.g = intent.getStringExtra("extra_password");
        if (FtpServerService.p == null) {
            (FtpServerService.p = new d()).start();
        }
    }
    
    private void F() {
        final FtpServerService.FtpServerService$e b = this.b;
        if (b != null) {
            b.c();
        }
        FtpServerService.p.a(true);
        final d p = FtpServerService.p;
        if (p != null) {
            p.interrupt();
            try {
                FtpServerService.p.join(10000L);
            }
            catch (final InterruptedException ex) {
                ((Throwable)ex).printStackTrace();
            }
            if (!FtpServerService.p.isAlive()) {
                FtpServerService.p = null;
            }
        }
        this.t();
    }
    
    private void r() {
        this.j = C.a((Context)this, 0L, "FtpServerService");
    }
    
    private void s(final b b) {
        monitorenter(this);
        Label_0040: {
            try {
                if (this.l.size() == 0) {
                    ((Context)this).startService(new Intent((Context)this, (Class)FtpServerService.class));
                }
                break Label_0040;
            }
            finally {
                monitorexit(this);
                this.l.add((Object)b);
                monitorexit(this);
            }
        }
    }
    
    private void t() {
        monitorenter(this);
        Label_0048: {
            try {
                for (final b b : this.l) {
                    if (b != null) {
                        b.a();
                    }
                }
                break Label_0048;
            }
            finally {
                monitorexit(this);
                monitorexit(this);
            }
        }
    }
    
    private void u() {
        final ServerSocket c = this.c;
        if (c != null) {
            try {
                c.close();
            }
            catch (final IOException ex) {
                ((Throwable)ex).printStackTrace();
            }
        }
    }
    
    private Notification v() {
        return u.j((Context)this).d((Service)this, w(this.k, this.f));
    }
    
    public static String w(final String s, final int n) {
        return String.format(Locale.US, "ftp://%s:%d", new Object[] { s, n });
    }
    
    public static boolean x() {
        final d p = FtpServerService.p;
        return p != null && p.isAlive();
    }
    
    private void y(final InetAddress inetAddress) {
        final Integer n = (Integer)this.n.get((Object)inetAddress);
        Integer n2;
        if (n == null) {
            n2 = 1;
        }
        else {
            n2 = n + 1;
        }
        this.n.put((Object)inetAddress, (Object)n2);
        if (n2 >= 10) {
            this.m.add((Object)inetAddress);
        }
    }
    
    private void z() {
        C.d(this.j);
    }
    
    public void B(final FtpServerService.FtpServerService$e b) {
        this.b = b;
    }
    
    public void C(final boolean h) {
        this.h = h;
    }
    
    public IBinder onBind(final Intent intent) {
        this.E(intent);
        try {
            this.startForeground(301, this.v());
        }
        catch (final IllegalStateException ex) {
            ax.Ha.c.i((Context)this).f().b("Foreground not allowed : ftp server service").h();
        }
        return this.a;
    }
    
    public void onCreate() {
        super.onCreate();
        this.i = (WifiManager)((Context)this).getApplicationContext().getSystemService("wifi");
        this.e = new D((Context)this, 3, "FTP_SERVER");
    }
    
    public void onDestroy() {
        this.stopForeground(true);
        super.onDestroy();
    }
    
    public void onRebind(final Intent intent) {
        this.E(intent);
    }
    
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        return 2;
    }
    
    public boolean onUnbind(final Intent intent) {
        this.F();
        return true;
    }
    
    private class b extends Thread
    {
        private boolean c0;
        private String d0;
        private boolean e0;
        final FtpServerService f0;
        private Socket q;
        
        public b(final FtpServerService f0, final Socket q, final boolean c0, final String d0, final boolean e0) {
            this.f0 = f0;
            this.q = q;
            this.c0 = c0;
            this.d0 = d0;
            this.e0 = e0;
        }
        
        public void a() {
            final Socket q = this.q;
            if (q != null) {
                try {
                    q.close();
                }
                catch (final IOException ex) {
                    ((Throwable)ex).printStackTrace();
                }
            }
        }
        
        public void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        com/alphainventor/filemanager/service/FtpServerService$b.q:Ljava/net/Socket;
            //     4: invokevirtual   java/net/Socket.getRemoteSocketAddress:()Ljava/net/SocketAddress;
            //     7: astore_3       
            //     8: aload_3        
            //     9: instanceof      Ljava/net/InetSocketAddress;
            //    12: istore_1       
            //    13: aconst_null    
            //    14: astore          5
            //    16: aconst_null    
            //    17: astore          9
            //    19: aconst_null    
            //    20: astore          8
            //    22: aconst_null    
            //    23: astore          10
            //    25: iload_1        
            //    26: ifeq            41
            //    29: aload_3        
            //    30: checkcast       Ljava/net/InetSocketAddress;
            //    33: invokevirtual   java/net/InetSocketAddress.getAddress:()Ljava/net/InetAddress;
            //    36: astore          12
            //    38: goto            44
            //    41: aconst_null    
            //    42: astore          12
            //    44: aload           12
            //    46: ifnull          69
            //    49: aload_0        
            //    50: getfield        com/alphainventor/filemanager/service/FtpServerService$b.f0:Lcom/alphainventor/filemanager/service/FtpServerService;
            //    53: invokestatic    com/alphainventor/filemanager/service/FtpServerService.g:(Lcom/alphainventor/filemanager/service/FtpServerService;)Ljava/util/HashSet;
            //    56: aload           12
            //    58: invokevirtual   java/util/HashSet.contains:(Ljava/lang/Object;)Z
            //    61: ifeq            69
            //    64: iconst_1       
            //    65: istore_1       
            //    66: goto            71
            //    69: iconst_0       
            //    70: istore_1       
            //    71: new             Ljava/io/BufferedReader;
            //    74: astore_3       
            //    75: new             Ljava/io/InputStreamReader;
            //    78: astore          4
            //    80: aload           4
            //    82: aload_0        
            //    83: getfield        com/alphainventor/filemanager/service/FtpServerService$b.q:Ljava/net/Socket;
            //    86: invokevirtual   java/net/Socket.getInputStream:()Ljava/io/InputStream;
            //    89: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
            //    92: aload_3        
            //    93: aload           4
            //    95: sipush          8192
            //    98: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;I)V
            //   101: new             Ljava/io/BufferedOutputStream;
            //   104: astore          4
            //   106: aload           4
            //   108: aload_0        
            //   109: getfield        com/alphainventor/filemanager/service/FtpServerService$b.q:Ljava/net/Socket;
            //   112: invokevirtual   java/net/Socket.getOutputStream:()Ljava/io/OutputStream;
            //   115: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
            //   118: aload           10
            //   120: astore          8
            //   122: aload_3        
            //   123: astore          7
            //   125: aload           4
            //   127: astore          6
            //   129: aload_0        
            //   130: getfield        com/alphainventor/filemanager/service/FtpServerService$b.e0:Z
            //   133: istore_2       
            //   134: iload_2        
            //   135: ifeq            216
            //   138: aload           10
            //   140: astore          8
            //   142: aload_3        
            //   143: astore          7
            //   145: aload           4
            //   147: astore          6
            //   149: aload           4
            //   151: ldc             "421 Too Many Connections\r\n"
            //   153: invokevirtual   java/lang/String.getBytes:()[B
            //   156: invokevirtual   java/io/OutputStream.write:([B)V
            //   159: aload           10
            //   161: astore          8
            //   163: aload_3        
            //   164: astore          7
            //   166: aload           4
            //   168: astore          6
            //   170: aload           4
            //   172: invokevirtual   java/io/BufferedOutputStream.flush:()V
            //   175: goto            733
            //   178: astore          4
            //   180: aload           7
            //   182: astore_3       
            //   183: aload           6
            //   185: astore          5
            //   187: goto            856
            //   190: astore          11
            //   192: aload           10
            //   194: astore          8
            //   196: aload_3        
            //   197: astore          7
            //   199: aload           4
            //   201: astore          6
            //   203: aload           11
            //   205: invokevirtual   java/lang/Throwable.printStackTrace:()V
            //   208: goto            733
            //   211: astore          5
            //   213: goto            797
            //   216: aload           10
            //   218: astore          8
            //   220: aload_3        
            //   221: astore          7
            //   223: aload           4
            //   225: astore          6
            //   227: new             Lcom/alphainventor/filemanager/service/a;
            //   230: dup            
            //   231: aload_0        
            //   232: getfield        com/alphainventor/filemanager/service/FtpServerService$b.f0:Lcom/alphainventor/filemanager/service/FtpServerService;
            //   235: invokevirtual   android/content/Context.getApplicationContext:()Landroid/content/Context;
            //   238: aload_0        
            //   239: getfield        com/alphainventor/filemanager/service/FtpServerService$b.q:Ljava/net/Socket;
            //   242: aload           4
            //   244: aload_0        
            //   245: getfield        com/alphainventor/filemanager/service/FtpServerService$b.c0:Z
            //   248: aload_0        
            //   249: getfield        com/alphainventor/filemanager/service/FtpServerService$b.d0:Ljava/lang/String;
            //   252: invokespecial   com/alphainventor/filemanager/service/a.<init>:(Landroid/content/Context;Ljava/net/Socket;Ljava/io/BufferedOutputStream;ZLjava/lang/String;)V
            //   255: astore          11
            //   257: aload_3        
            //   258: astore          7
            //   260: aload           4
            //   262: astore          5
            //   264: aload_3        
            //   265: astore          8
            //   267: aload           4
            //   269: astore          6
            //   271: aload           11
            //   273: invokevirtual   com/alphainventor/filemanager/service/a.t:()V
            //   276: aload_3        
            //   277: astore          7
            //   279: aload           4
            //   281: astore          5
            //   283: aload_3        
            //   284: astore          8
            //   286: aload           4
            //   288: astore          6
            //   290: aload           11
            //   292: ldc             "220 File Manager ready \r\n"
            //   294: invokevirtual   com/alphainventor/filemanager/service/a.O:(Ljava/lang/String;)V
            //   297: aload_3        
            //   298: astore          7
            //   300: aload           4
            //   302: astore          5
            //   304: aload_3        
            //   305: astore          8
            //   307: aload           4
            //   309: astore          6
            //   311: new             Lcom/alphainventor/filemanager/service/a$a;
            //   314: astore          13
            //   316: aload_3        
            //   317: astore          7
            //   319: aload           4
            //   321: astore          5
            //   323: aload_3        
            //   324: astore          8
            //   326: aload           4
            //   328: astore          6
            //   330: aload           13
            //   332: invokespecial   com/alphainventor/filemanager/service/a$a.<init>:()V
            //   335: aload_3        
            //   336: astore          7
            //   338: aload           4
            //   340: astore          5
            //   342: aload_3        
            //   343: astore          8
            //   345: aload           4
            //   347: astore          6
            //   349: aload_3        
            //   350: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
            //   353: astore          9
            //   355: aload           9
            //   357: ifnull          729
            //   360: aload_3        
            //   361: astore          7
            //   363: aload           4
            //   365: astore          5
            //   367: aload_3        
            //   368: astore          8
            //   370: aload           4
            //   372: astore          6
            //   374: aload           13
            //   376: invokevirtual   com/alphainventor/filemanager/service/a$a.a:()V
            //   379: aload_3        
            //   380: astore          7
            //   382: aload           4
            //   384: astore          5
            //   386: aload_3        
            //   387: astore          8
            //   389: aload           4
            //   391: astore          6
            //   393: aload           11
            //   395: aload           9
            //   397: aload           13
            //   399: iload_1        
            //   400: invokevirtual   com/alphainventor/filemanager/service/a.C:(Ljava/lang/String;Lcom/alphainventor/filemanager/service/a$a;Z)V
            //   403: aload_3        
            //   404: astore          7
            //   406: aload           4
            //   408: astore          5
            //   410: aload_3        
            //   411: astore          8
            //   413: aload           4
            //   415: astore          6
            //   417: aload_3        
            //   418: astore          9
            //   420: aload           4
            //   422: astore          10
            //   424: aload           13
            //   426: getfield        com/alphainventor/filemanager/service/a$a.c:Z
            //   429: ifeq            580
            //   432: aload_3        
            //   433: astore          7
            //   435: aload           4
            //   437: astore          5
            //   439: aload_3        
            //   440: astore          8
            //   442: aload           4
            //   444: astore          6
            //   446: new             Ljava/io/BufferedReader;
            //   449: astore          9
            //   451: aload_3        
            //   452: astore          7
            //   454: aload           4
            //   456: astore          5
            //   458: aload_3        
            //   459: astore          8
            //   461: aload           4
            //   463: astore          6
            //   465: new             Ljava/io/InputStreamReader;
            //   468: astore          10
            //   470: aload_3        
            //   471: astore          7
            //   473: aload           4
            //   475: astore          5
            //   477: aload_3        
            //   478: astore          8
            //   480: aload           4
            //   482: astore          6
            //   484: aload           10
            //   486: aload           11
            //   488: invokevirtual   com/alphainventor/filemanager/service/a.m:()Ljava/io/InputStream;
            //   491: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
            //   494: aload_3        
            //   495: astore          7
            //   497: aload           4
            //   499: astore          5
            //   501: aload_3        
            //   502: astore          8
            //   504: aload           4
            //   506: astore          6
            //   508: aload           9
            //   510: aload           10
            //   512: sipush          8192
            //   515: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;I)V
            //   518: aload           11
            //   520: invokevirtual   com/alphainventor/filemanager/service/a.n:()Ljava/io/BufferedOutputStream;
            //   523: astore          10
            //   525: goto            580
            //   528: astore          6
            //   530: aload           9
            //   532: astore_3       
            //   533: aload           4
            //   535: astore          5
            //   537: aload           6
            //   539: astore          4
            //   541: aload           11
            //   543: astore          8
            //   545: goto            856
            //   548: astore          5
            //   550: aload           9
            //   552: astore_3       
            //   553: aload           11
            //   555: astore          9
            //   557: goto            797
            //   560: astore          4
            //   562: aload           7
            //   564: astore_3       
            //   565: goto            541
            //   568: astore          5
            //   570: aload           8
            //   572: astore_3       
            //   573: aload           6
            //   575: astore          4
            //   577: goto            553
            //   580: aload           9
            //   582: astore          7
            //   584: aload           10
            //   586: astore          5
            //   588: aload           9
            //   590: astore          8
            //   592: aload           10
            //   594: astore          6
            //   596: aload           13
            //   598: getfield        com/alphainventor/filemanager/service/a$a.a:Ljava/lang/String;
            //   601: ifnull          663
            //   604: aload           9
            //   606: astore          7
            //   608: aload           10
            //   610: astore          5
            //   612: aload           9
            //   614: astore          8
            //   616: aload           10
            //   618: astore          6
            //   620: aload_0        
            //   621: getfield        com/alphainventor/filemanager/service/FtpServerService$b.f0:Lcom/alphainventor/filemanager/service/FtpServerService;
            //   624: invokestatic    com/alphainventor/filemanager/service/FtpServerService.k:(Lcom/alphainventor/filemanager/service/FtpServerService;)Lcom/alphainventor/filemanager/service/FtpServerService$e;
            //   627: ifnull          663
            //   630: aload           9
            //   632: astore          7
            //   634: aload           10
            //   636: astore          5
            //   638: aload           9
            //   640: astore          8
            //   642: aload           10
            //   644: astore          6
            //   646: aload_0        
            //   647: getfield        com/alphainventor/filemanager/service/FtpServerService$b.f0:Lcom/alphainventor/filemanager/service/FtpServerService;
            //   650: invokestatic    com/alphainventor/filemanager/service/FtpServerService.k:(Lcom/alphainventor/filemanager/service/FtpServerService;)Lcom/alphainventor/filemanager/service/FtpServerService$e;
            //   653: aload           13
            //   655: getfield        com/alphainventor/filemanager/service/a$a.a:Ljava/lang/String;
            //   658: invokeinterface com/alphainventor/filemanager/service/FtpServerService$e.a:(Ljava/lang/String;)V
            //   663: aload           9
            //   665: astore_3       
            //   666: aload           10
            //   668: astore          4
            //   670: aload           9
            //   672: astore          7
            //   674: aload           10
            //   676: astore          5
            //   678: aload           9
            //   680: astore          8
            //   682: aload           10
            //   684: astore          6
            //   686: aload           13
            //   688: getfield        com/alphainventor/filemanager/service/a$a.b:Z
            //   691: ifeq            335
            //   694: aload           9
            //   696: astore          7
            //   698: aload           10
            //   700: astore          5
            //   702: aload           9
            //   704: astore          8
            //   706: aload           10
            //   708: astore          6
            //   710: aload_0        
            //   711: getfield        com/alphainventor/filemanager/service/FtpServerService$b.f0:Lcom/alphainventor/filemanager/service/FtpServerService;
            //   714: aload           12
            //   716: invokestatic    com/alphainventor/filemanager/service/FtpServerService.h:(Lcom/alphainventor/filemanager/service/FtpServerService;Ljava/net/InetAddress;)V
            //   719: aload           9
            //   721: astore_3       
            //   722: aload           10
            //   724: astore          4
            //   726: goto            335
            //   729: aload           11
            //   731: astore          5
            //   733: aload           5
            //   735: ifnull          743
            //   738: aload           5
            //   740: invokevirtual   com/alphainventor/filemanager/service/a.e:()V
            //   743: aload_3        
            //   744: invokevirtual   java/io/BufferedReader.close:()V
            //   747: goto            751
            //   750: astore_3       
            //   751: aload           4
            //   753: ifnull          843
            //   756: aload           4
            //   758: invokevirtual   java/io/OutputStream.close:()V
            //   761: goto            843
            //   764: astore          4
            //   766: aconst_null    
            //   767: astore          5
            //   769: goto            856
            //   772: astore          5
            //   774: aconst_null    
            //   775: astore          4
            //   777: goto            797
            //   780: astore          4
            //   782: aconst_null    
            //   783: astore_3       
            //   784: aconst_null    
            //   785: astore          5
            //   787: goto            856
            //   790: astore          5
            //   792: aconst_null    
            //   793: astore_3       
            //   794: aconst_null    
            //   795: astore          4
            //   797: aload           9
            //   799: astore          8
            //   801: aload_3        
            //   802: astore          7
            //   804: aload           4
            //   806: astore          6
            //   808: aload           5
            //   810: invokevirtual   java/lang/Throwable.printStackTrace:()V
            //   813: aload           9
            //   815: ifnull          823
            //   818: aload           9
            //   820: invokevirtual   com/alphainventor/filemanager/service/a.e:()V
            //   823: aload_3        
            //   824: ifnull          835
            //   827: aload_3        
            //   828: invokevirtual   java/io/BufferedReader.close:()V
            //   831: goto            835
            //   834: astore_3       
            //   835: aload           4
            //   837: ifnull          843
            //   840: goto            756
            //   843: aload_0        
            //   844: invokevirtual   com/alphainventor/filemanager/service/FtpServerService$b.a:()V
            //   847: aload_0        
            //   848: getfield        com/alphainventor/filemanager/service/FtpServerService$b.f0:Lcom/alphainventor/filemanager/service/FtpServerService;
            //   851: aload_0        
            //   852: invokestatic    com/alphainventor/filemanager/service/FtpServerService.i:(Lcom/alphainventor/filemanager/service/FtpServerService;Lcom/alphainventor/filemanager/service/FtpServerService$b;)V
            //   855: return         
            //   856: aload           8
            //   858: ifnull          866
            //   861: aload           8
            //   863: invokevirtual   com/alphainventor/filemanager/service/a.e:()V
            //   866: aload_3        
            //   867: ifnull          878
            //   870: aload_3        
            //   871: invokevirtual   java/io/BufferedReader.close:()V
            //   874: goto            878
            //   877: astore_3       
            //   878: aload           5
            //   880: ifnull          888
            //   883: aload           5
            //   885: invokevirtual   java/io/OutputStream.close:()V
            //   888: aload           4
            //   890: athrow         
            //   891: astore_3       
            //   892: goto            843
            //   895: astore_3       
            //   896: goto            888
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                 
            //  -----  -----  -----  -----  ---------------------
            //  71     101    790    797    Ljava/io/IOException;
            //  71     101    780    790    Any
            //  101    118    772    780    Ljava/io/IOException;
            //  101    118    764    772    Any
            //  129    134    211    216    Ljava/io/IOException;
            //  129    134    178    190    Any
            //  149    159    190    211    Ljava/io/IOException;
            //  149    159    178    190    Any
            //  170    175    190    211    Ljava/io/IOException;
            //  170    175    178    190    Any
            //  203    208    211    216    Ljava/io/IOException;
            //  203    208    178    190    Any
            //  227    257    211    216    Ljava/io/IOException;
            //  227    257    178    190    Any
            //  271    276    568    580    Ljava/io/IOException;
            //  271    276    560    568    Any
            //  290    297    568    580    Ljava/io/IOException;
            //  290    297    560    568    Any
            //  311    316    568    580    Ljava/io/IOException;
            //  311    316    560    568    Any
            //  330    335    568    580    Ljava/io/IOException;
            //  330    335    560    568    Any
            //  349    355    568    580    Ljava/io/IOException;
            //  349    355    560    568    Any
            //  374    379    568    580    Ljava/io/IOException;
            //  374    379    560    568    Any
            //  393    403    568    580    Ljava/io/IOException;
            //  393    403    560    568    Any
            //  424    432    568    580    Ljava/io/IOException;
            //  424    432    560    568    Any
            //  446    451    568    580    Ljava/io/IOException;
            //  446    451    560    568    Any
            //  465    470    568    580    Ljava/io/IOException;
            //  465    470    560    568    Any
            //  484    494    568    580    Ljava/io/IOException;
            //  484    494    560    568    Any
            //  508    518    568    580    Ljava/io/IOException;
            //  508    518    560    568    Any
            //  518    525    548    553    Ljava/io/IOException;
            //  518    525    528    541    Any
            //  596    604    568    580    Ljava/io/IOException;
            //  596    604    560    568    Any
            //  620    630    568    580    Ljava/io/IOException;
            //  620    630    560    568    Any
            //  646    663    568    580    Ljava/io/IOException;
            //  646    663    560    568    Any
            //  686    694    568    580    Ljava/io/IOException;
            //  686    694    560    568    Any
            //  710    719    568    580    Ljava/io/IOException;
            //  710    719    560    568    Any
            //  743    747    750    751    Ljava/io/IOException;
            //  756    761    891    895    Ljava/io/IOException;
            //  808    813    178    190    Any
            //  827    831    834    835    Ljava/io/IOException;
            //  870    874    877    878    Ljava/io/IOException;
            //  883    888    895    899    Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0756:
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
    }
    
    public class c extends Binder
    {
        final FtpServerService e;
        
        public c(final FtpServerService e) {
            this.e = e;
        }
        
        public FtpServerService a() {
            return this.e;
        }
    }
    
    class d extends Thread
    {
        final FtpServerService c0;
        private boolean q;
        
        d(final FtpServerService c0) {
            this.c0 = c0;
            this.q = false;
        }
        
        void a(final boolean q) {
            this.q = q;
        }
        
        public void run() {
            Label_0053: {
                try {
                    this.c0.D();
                    this.c0.e.a();
                    this.c0.r();
                    if (this.c0.b != null) {
                        this.c0.b.b();
                    }
                    break Label_0053;
                }
                catch (final IOException ex) {
                    ((Throwable)ex).printStackTrace();
                    this.c0.stopSelf();
                    if (this.c0.b != null) {
                        this.c0.b.c();
                    }
                    return;
                Block_6_Outer:
                    while (true) {
                    Label_0101:
                        while (true) {
                            FtpServerService c0;
                            Label_0219_Outer:Block_11_Outer:
                            while (true) {
                                this.c0.stopSelf();
                                Label_0163: {
                                    while (true) {
                                        Label_0197: {
                                            break Label_0197;
                                            Block_8: {
                                                while (true) {
                                                    c0 = this.c0;
                                                    c0.d = new f();
                                                    this.c0.d.start();
                                                    break Block_8;
                                                    iftrue(Label_0149:)(this.c0.d != null);
                                                    continue Label_0219_Outer;
                                                }
                                                while (true) {
                                                    this.c0.z();
                                                    this.c0.e.c();
                                                    this.c0.u();
                                                    return;
                                                    iftrue(Label_0197:)(this.q);
                                                    break Label_0219_Outer;
                                                    this.c0.b.c();
                                                    continue Block_11_Outer;
                                                }
                                            }
                                            try {
                                                Label_0149: {
                                                    Thread.sleep(1000L);
                                                }
                                            }
                                            catch (final Exception ex2) {
                                                ((Throwable)ex2).printStackTrace();
                                            }
                                            break Label_0163;
                                        }
                                        iftrue(Label_0219:)(this.c0.b == null);
                                        continue Block_6_Outer;
                                    }
                                    try {
                                        this.c0.d.join();
                                    }
                                    catch (final InterruptedException ex3) {
                                        ((Throwable)ex3).printStackTrace();
                                    }
                                    break Label_0101;
                                }
                                iftrue(Label_0053:)(this.c0.d.isAlive() || this.c0.i.getWifiState() != 1);
                                continue Block_11_Outer;
                            }
                            iftrue(Label_0110:)(this.c0.d == null || this.c0.d.isAlive());
                            continue;
                        }
                        this.c0.d = null;
                        continue Block_6_Outer;
                    }
                }
            }
        }
    }
    
    private class f extends Thread
    {
        final FtpServerService q;
        
        private f(final FtpServerService q) {
            this.q = q;
        }
        
        public void run() {
            try {
                while (true) {
                    final Socket accept = this.q.c.accept();
                    final FtpServerService q = this.q;
                    final b b = q.new b(accept, q.h, this.q.g, this.q.l.size() >= 30);
                    this.q.s(b);
                    b.start();
                }
            }
            catch (final Exception ex) {
                ((Throwable)ex).printStackTrace();
            }
        }
    }
}
