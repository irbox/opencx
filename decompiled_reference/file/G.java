package com.alphainventor.filemanager.file;

import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.channels.FileChannel;
import android.content.SharedPreferences;
import ax.X2.J;
import android.os.ParcelFileDescriptor$AutoCloseOutputStream;
import java.io.OutputStream;
import android.os.ParcelFileDescriptor$AutoCloseInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import android.database.sqlite.SQLiteException;
import android.net.Uri$Builder;
import ax.c3.B;
import ax.c3.k0;
import android.database.Cursor;
import ax.b3.C;
import ax.b3.p;
import ax.c3.F;
import j$.util.Objects;
import java.util.Iterator;
import ax.b3.d;
import ax.b3.k;
import ax.b3.r;
import android.provider.DocumentsContract;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.FileOutputStream;
import android.content.SharedPreferences$Editor;
import ax.b3.M;
import ax.c3.G;
import ax.b3.a;
import android.content.ContentResolver;
import ax.X2.y;
import ax.b3.t;
import ax.g3.i;
import ax.u3.c;
import java.util.List;
import ax.Z2.j$f;
import ax.X2.v;
import ax.X2.Q;
import ax.u3.b;
import ax.c3.d0;
import ax.Q2.f;
import ax.c3.l;
import android.net.Uri;
import android.text.TextUtils;
import ax.Z2.j;
import ax.c3.K;
import android.content.Context;
import java.util.logging.Logger;

public class g
{
    private static final Logger b;
    Context a;
    
    static {
        b = Logger.getLogger("FileManager.DocumentFileClient");
    }
    
    g(final Context a) {
        this.a = a;
    }
    
    public static String A(final String s) {
        if (s == null) {
            return null;
        }
        final int index = s.indexOf(":");
        if (index < 0) {
            return null;
        }
        return s.substring(0, index);
    }
    
    public static String B(final String s) {
        if (s == null) {
            return null;
        }
        final int index = s.indexOf(":");
        if (index < 0) {
            return null;
        }
        return s.substring(0, index);
    }
    
    public static boolean C(final Context context, final K k, final String s) {
        String s2;
        if (j.F().E0(k) && s != null) {
            final Uri n = n(k, s);
            if (n != null && a(context, n)) {
                s2 = n.toString();
            }
            else {
                s2 = null;
            }
        }
        else {
            s2 = x(context, k, s);
        }
        return !TextUtils.isEmpty((CharSequence)s2) && H(context, k, s, Uri.parse(s2));
    }
    
    private static boolean D(final K k, final l l) {
        String s;
        if (f.i0(k.d())) {
            final String e = k.e();
            if (e == null) {
                return false;
            }
            s = d0.h(e);
        }
        else if (f.c0(k.d())) {
            s = j.F().Z(k);
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unexpected location unit : ");
            sb.append((Object)k);
            ax.u3.b.g(sb.toString());
            s = null;
        }
        final String b = l.b;
        if (b != null) {
            if (b.equals((Object)s)) {
                return true;
            }
            final String a = A(l.a);
            if (a != null && a.equals((Object)s)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean E(final String s) {
        return s != null && s.endsWith(":");
    }
    
    public static boolean F(final Context context, final K k, final String s, final Uri uri) {
        if (!Q.V1()) {
            return false;
        }
        try {
            if (k.e() == null) {
                return false;
            }
            final String h = v.h(uri);
            if (s != null) {
                final String z = z(h);
                if (z == null || !z.equals((Object)s)) {
                    return false;
                }
            }
            else if (!E(h)) {
                return false;
            }
            String s2;
            if (s == null) {
                if (f.i0(k.d())) {
                    s2 = d0.h(k.e());
                }
                else if (f.c0(k.d())) {
                    s2 = j.F().Z(k);
                }
                else {
                    if (f.o0(k.d())) {
                        return false;
                    }
                    s2 = "";
                }
            }
            else {
                s2 = d0.h(s);
            }
            final l i = i(context, c(uri), s2);
            if (i == null) {
                return false;
            }
            if (s == null) {
                return D(k, i);
            }
            final String b = B(h);
            if (k == K.e) {
                return "primary".equals((Object)b);
            }
            if (k == K.f) {
                final String h2 = d0.h(k.e());
                return h2 != null && h2.equals((Object)b);
            }
            ax.u3.b.f();
            return false;
        }
        catch (final ax.b3.j j) {
            return false;
        }
    }
    
    public static boolean G(final Context context, final K k, final Uri b) {
        if (!Q.V1()) {
            return false;
        }
        try {
            if (k.e() == null) {
                return false;
            }
            final j$f m = j.F().M(k);
            if (m == null) {
                return false;
            }
            final Uri b2 = m.b;
            if (b2 != null) {
                return b2.equals((Object)b);
            }
            final String lastPathSegment = m.a.getLastPathSegment();
            final String lastPathSegment2 = b.getLastPathSegment();
            if (lastPathSegment2 != null) {
                if (lastPathSegment2.equals((Object)lastPathSegment)) {
                    final l i = i(context, c(b), null);
                    if (i == null) {
                        return false;
                    }
                    j.F().U0(k, b, i.b);
                    k.j(i.b);
                    final String h = v.h(b);
                    if (h != null && h.equals((Object)i.a)) {
                        m.b = b;
                        m.c = i.b;
                        return true;
                    }
                }
            }
            return false;
        }
        catch (final ax.b3.j j) {
            return false;
        }
    }
    
    public static boolean H(final Context context, final K k, final String s, final Uri uri) {
        final String authority = uri.getAuthority();
        if ("com.android.externalstorage.documents".equals((Object)authority)) {
            return F(context, k, s, uri);
        }
        if ("com.android.mtp.documents".equals((Object)authority)) {
            return G(context, k, uri);
        }
        final Logger b = g.b;
        final StringBuilder sb = new StringBuilder();
        sb.append("Unknown Document Athority : ");
        sb.append(authority);
        b.severe(sb.toString());
        return false;
    }
    
    public static boolean I(final K k, final Uri uri) {
        if (f.b0(k.d())) {
            final Uri n = n(k, null);
            return n != null && uri.toString().startsWith(n.toString());
        }
        if (f.h1 == k.d()) {
            return "com.android.mtp.documents".equals((Object)uri.getAuthority());
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("same storage uri :");
        sb.append((Object)k);
        sb.append(":");
        sb.append((Object)uri);
        ax.u3.b.g(sb.toString());
        return false;
    }
    
    public static List<n> J(final e p0, final n p1) throws ax.b3.j {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    com/alphainventor/filemanager/file/g.l:(Lcom/alphainventor/filemanager/file/n;)Landroid/net/Uri;
        //     4: astore_3       
        //     5: aload_0        
        //     6: invokevirtual   com/alphainventor/filemanager/file/m.p:()Landroid/content/Context;
        //     9: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //    12: astore          9
        //    14: aload_3        
        //    15: aload_3        
        //    16: invokestatic    android/provider/DocumentsContract.getDocumentId:(Landroid/net/Uri;)Ljava/lang/String;
        //    19: invokestatic    android/provider/DocumentsContract.buildChildDocumentsUriUsingTree:(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
        //    22: astore_3       
        //    23: aload_3        
        //    24: astore          4
        //    26: invokestatic    ax/X2/Q.L:()Z
        //    29: ifeq            83
        //    32: aload_3        
        //    33: astore          4
        //    35: aload_1        
        //    36: invokestatic    ax/c3/B.P:(Lcom/alphainventor/filemanager/file/n;)Z
        //    39: ifeq            83
        //    42: aload_3        
        //    43: astore          4
        //    45: aload_1        
        //    46: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //    49: ldc_w           "/Android"
        //    52: invokevirtual   java/lang/String.endsWith:(Ljava/lang/String;)Z
        //    55: ifeq            83
        //    58: aload_3        
        //    59: astore          4
        //    61: ldc_w           "/Android"
        //    64: aload_1        
        //    65: checkcast       Lcom/alphainventor/filemanager/file/y;
        //    68: invokevirtual   com/alphainventor/filemanager/file/y.C0:()Ljava/lang/String;
        //    71: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    74: ifeq            83
        //    77: aload_3        
        //    78: invokestatic    com/alphainventor/filemanager/file/g.N:(Landroid/net/Uri;)Landroid/net/Uri;
        //    81: astore          4
        //    83: new             Ljava/util/ArrayList;
        //    86: dup            
        //    87: invokespecial   java/util/ArrayList.<init>:()V
        //    90: astore          8
        //    92: aconst_null    
        //    93: astore          6
        //    95: aconst_null    
        //    96: astore          5
        //    98: aconst_null    
        //    99: astore          7
        //   101: aconst_null    
        //   102: astore_3       
        //   103: aload           9
        //   105: aload           4
        //   107: getstatic       ax/c3/l.g:[Ljava/lang/String;
        //   110: aconst_null    
        //   111: aconst_null    
        //   112: aconst_null    
        //   113: invokevirtual   android/content/ContentResolver.query:(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   116: astore          4
        //   118: aload           4
        //   120: ifnull          416
        //   123: aload_1        
        //   124: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   127: astore_3       
        //   128: aload_1        
        //   129: invokestatic    ax/c3/B.P:(Lcom/alphainventor/filemanager/file/n;)Z
        //   132: ifeq            225
        //   135: aload_1        
        //   136: checkcast       Lcom/alphainventor/filemanager/file/y;
        //   139: invokevirtual   com/alphainventor/filemanager/file/y.N0:()Landroid/net/Uri;
        //   142: astore          6
        //   144: aload_1        
        //   145: checkcast       Lcom/alphainventor/filemanager/file/y;
        //   148: invokevirtual   com/alphainventor/filemanager/file/y.B0:()Lax/c3/K;
        //   151: astore          5
        //   153: aload           4
        //   155: invokeinterface android/database/Cursor.moveToNext:()Z
        //   160: istore_2       
        //   161: iload_2        
        //   162: ifeq            279
        //   165: new             Lcom/alphainventor/filemanager/file/y;
        //   168: astore          7
        //   170: aload           7
        //   172: aload_0        
        //   173: checkcast       Lcom/alphainventor/filemanager/file/x;
        //   176: aload           6
        //   178: aload           5
        //   180: aload_3        
        //   181: aload           4
        //   183: invokespecial   com/alphainventor/filemanager/file/y.<init>:(Lcom/alphainventor/filemanager/file/x;Landroid/net/Uri;Lax/c3/K;Ljava/lang/String;Landroid/database/Cursor;)V
        //   186: aload           8
        //   188: aload           7
        //   190: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   193: pop            
        //   194: goto            153
        //   197: astore_0       
        //   198: aload           4
        //   200: astore_3       
        //   201: goto            600
        //   204: astore_1       
        //   205: aload           4
        //   207: astore_0       
        //   208: goto            454
        //   211: astore_0       
        //   212: aload           4
        //   214: astore_3       
        //   215: goto            528
        //   218: astore_1       
        //   219: aload           4
        //   221: astore_0       
        //   222: goto            530
        //   225: aload_1        
        //   226: checkcast       Lcom/alphainventor/filemanager/file/i;
        //   229: astore          6
        //   231: aload           4
        //   233: invokeinterface android/database/Cursor.moveToNext:()Z
        //   238: ifeq            279
        //   241: new             Lcom/alphainventor/filemanager/file/i;
        //   244: astore          5
        //   246: aload           5
        //   248: aload_0        
        //   249: checkcast       Lcom/alphainventor/filemanager/file/h;
        //   252: aload_3        
        //   253: aload           4
        //   255: invokespecial   com/alphainventor/filemanager/file/i.<init>:(Lcom/alphainventor/filemanager/file/h;Ljava/lang/String;Landroid/database/Cursor;)V
        //   258: aload           5
        //   260: aload           6
        //   262: invokevirtual   com/alphainventor/filemanager/file/i.m0:()Ljava/lang/String;
        //   265: invokevirtual   com/alphainventor/filemanager/file/i.q0:(Ljava/lang/String;)V
        //   268: aload           8
        //   270: aload           5
        //   272: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //   275: pop            
        //   276: goto            231
        //   279: invokestatic    ax/X2/Q.L:()Z
        //   282: ifeq            408
        //   285: aload           8
        //   287: invokevirtual   java/util/ArrayList.size:()I
        //   290: ifne            408
        //   293: aload_1        
        //   294: instanceof      Lcom/alphainventor/filemanager/file/y;
        //   297: ifeq            408
        //   300: aload_1        
        //   301: checkcast       Lcom/alphainventor/filemanager/file/y;
        //   304: astore_0       
        //   305: aload_0        
        //   306: invokevirtual   com/alphainventor/filemanager/file/y.a1:()Z
        //   309: ifeq            408
        //   312: aload_0        
        //   313: invokevirtual   com/alphainventor/filemanager/file/y.F0:()Ljava/io/File;
        //   316: invokevirtual   java/io/File.canRead:()Z
        //   319: ifne            408
        //   322: aload_0        
        //   323: invokevirtual   com/alphainventor/filemanager/file/y.q1:()V
        //   326: aload_0        
        //   327: invokevirtual   com/alphainventor/filemanager/file/y.n:()Z
        //   330: ifeq            398
        //   333: aload_1        
        //   334: invokevirtual   com/alphainventor/filemanager/file/n.R:()Lax/c3/K;
        //   337: getstatic       ax/c3/K.e:Lax/c3/K;
        //   340: if_acmpeq       376
        //   343: ldc_w           "/Android/data"
        //   346: aload_0        
        //   347: invokevirtual   com/alphainventor/filemanager/file/y.C0:()Ljava/lang/String;
        //   350: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   353: istore_2       
        //   354: iload_2        
        //   355: ifne            366
        //   358: aload           4
        //   360: invokestatic    ax/c3/F.a:(Ljava/lang/AutoCloseable;)V
        //   363: aload           8
        //   365: areturn        
        //   366: new             Lax/b3/e;
        //   369: astore_0       
        //   370: aload_0        
        //   371: invokespecial   ax/b3/e.<init>:()V
        //   374: aload_0        
        //   375: athrow         
        //   376: aload_1        
        //   377: checkcast       Lcom/alphainventor/filemanager/file/y;
        //   380: invokevirtual   com/alphainventor/filemanager/file/y.x1:()Landroid/net/Uri;
        //   383: pop            
        //   384: goto            408
        //   387: astore_0       
        //   388: new             Lax/b3/e;
        //   391: astore_0       
        //   392: aload_0        
        //   393: invokespecial   ax/b3/e.<init>:()V
        //   396: aload_0        
        //   397: athrow         
        //   398: new             Lax/b3/t;
        //   401: astore_0       
        //   402: aload_0        
        //   403: invokespecial   ax/b3/t.<init>:()V
        //   406: aload_0        
        //   407: athrow         
        //   408: aload           4
        //   410: invokestatic    ax/c3/F.a:(Ljava/lang/AutoCloseable;)V
        //   413: aload           8
        //   415: areturn        
        //   416: new             Lax/b3/j;
        //   419: astore_0       
        //   420: aload_0        
        //   421: ldc_w           "query return null"
        //   424: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   427: aload_0        
        //   428: athrow         
        //   429: astore_0       
        //   430: goto            600
        //   433: astore_1       
        //   434: aload           6
        //   436: astore_0       
        //   437: goto            454
        //   440: astore_0       
        //   441: aload           5
        //   443: astore_3       
        //   444: goto            528
        //   447: astore_1       
        //   448: aload           7
        //   450: astore_0       
        //   451: goto            530
        //   454: aload_0        
        //   455: astore_3       
        //   456: new             Ljava/lang/StringBuilder;
        //   459: astore          4
        //   461: aload_0        
        //   462: astore_3       
        //   463: aload           4
        //   465: invokespecial   java/lang/StringBuilder.<init>:()V
        //   468: aload_0        
        //   469: astore_3       
        //   470: aload           4
        //   472: ldc_w           "listChildren : "
        //   475: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   478: pop            
        //   479: aload_0        
        //   480: astore_3       
        //   481: aload           4
        //   483: aload_1        
        //   484: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   487: invokevirtual   java/lang/Class.getSimpleName:()Ljava/lang/String;
        //   490: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   493: pop            
        //   494: aload_0        
        //   495: astore_3       
        //   496: aload           4
        //   498: ldc             ":"
        //   500: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   503: pop            
        //   504: aload_0        
        //   505: astore_3       
        //   506: aload           4
        //   508: aload_1        
        //   509: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   512: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   515: pop            
        //   516: aload_0        
        //   517: astore_3       
        //   518: aload           4
        //   520: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   523: aload_1        
        //   524: invokestatic    ax/b3/d.a:(Ljava/lang/String;Ljava/lang/Exception;)Lax/b3/j;
        //   527: athrow         
        //   528: aload_0        
        //   529: athrow         
        //   530: aload_0        
        //   531: astore_3       
        //   532: aload_1        
        //   533: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   536: aload_0        
        //   537: astore_3       
        //   538: aload_1        
        //   539: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   542: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   545: ifne            584
        //   548: aload_0        
        //   549: astore_3       
        //   550: aload_1        
        //   551: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   554: ldc_w           "FileNotFoundException"
        //   557: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   560: ifne            584
        //   563: aload_0        
        //   564: astore_3       
        //   565: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   568: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   571: ldc_w           "DOCUMENT FILE EXCEPTION DO NOT CONTAIN FILENOTFOUND"
        //   574: invokevirtual   ax/Ha/b.b:(Ljava/lang/String;)Lax/Ha/b;
        //   577: aload_1        
        //   578: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   581: invokevirtual   ax/Ha/b.h:()V
        //   584: aload_0        
        //   585: astore_3       
        //   586: new             Lax/b3/t;
        //   589: astore_1       
        //   590: aload_0        
        //   591: astore_3       
        //   592: aload_1        
        //   593: invokespecial   ax/b3/t.<init>:()V
        //   596: aload_0        
        //   597: astore_3       
        //   598: aload_1        
        //   599: athrow         
        //   600: aload_3        
        //   601: invokestatic    ax/c3/F.a:(Ljava/lang/AutoCloseable;)V
        //   604: aload_0        
        //   605: athrow         
        //   606: astore          7
        //   608: goto            153
        //    Exceptions:
        //  throws ax.b3.j
        //    Signature:
        //  (Lcom/alphainventor/filemanager/file/e;Lcom/alphainventor/filemanager/file/n;)Ljava/util/List<Lcom/alphainventor/filemanager/file/n;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  103    118    447    454    Ljava/lang/IllegalArgumentException;
        //  103    118    440    447    Lax/b3/j;
        //  103    118    433    440    Ljava/lang/Exception;
        //  103    118    429    433    Any
        //  123    153    218    225    Ljava/lang/IllegalArgumentException;
        //  123    153    211    218    Lax/b3/j;
        //  123    153    204    211    Ljava/lang/Exception;
        //  123    153    197    204    Any
        //  153    161    218    225    Ljava/lang/IllegalArgumentException;
        //  153    161    211    218    Lax/b3/j;
        //  153    161    204    211    Ljava/lang/Exception;
        //  153    161    197    204    Any
        //  165    194    606    611    Ljava/lang/IllegalArgumentException;
        //  165    194    211    218    Lax/b3/j;
        //  165    194    204    211    Ljava/lang/Exception;
        //  165    194    197    204    Any
        //  225    231    218    225    Ljava/lang/IllegalArgumentException;
        //  225    231    211    218    Lax/b3/j;
        //  225    231    204    211    Ljava/lang/Exception;
        //  225    231    197    204    Any
        //  231    276    218    225    Ljava/lang/IllegalArgumentException;
        //  231    276    211    218    Lax/b3/j;
        //  231    276    204    211    Ljava/lang/Exception;
        //  231    276    197    204    Any
        //  279    354    218    225    Ljava/lang/IllegalArgumentException;
        //  279    354    211    218    Lax/b3/j;
        //  279    354    204    211    Ljava/lang/Exception;
        //  279    354    197    204    Any
        //  366    376    218    225    Ljava/lang/IllegalArgumentException;
        //  366    376    211    218    Lax/b3/j;
        //  366    376    204    211    Ljava/lang/Exception;
        //  366    376    197    204    Any
        //  376    384    387    398    Lax/b3/r;
        //  376    384    218    225    Ljava/lang/IllegalArgumentException;
        //  376    384    211    218    Lax/b3/j;
        //  376    384    204    211    Ljava/lang/Exception;
        //  376    384    197    204    Any
        //  388    398    218    225    Ljava/lang/IllegalArgumentException;
        //  388    398    211    218    Lax/b3/j;
        //  388    398    204    211    Ljava/lang/Exception;
        //  388    398    197    204    Any
        //  398    408    218    225    Ljava/lang/IllegalArgumentException;
        //  398    408    211    218    Lax/b3/j;
        //  398    408    204    211    Ljava/lang/Exception;
        //  398    408    197    204    Any
        //  416    429    218    225    Ljava/lang/IllegalArgumentException;
        //  416    429    211    218    Lax/b3/j;
        //  416    429    204    211    Ljava/lang/Exception;
        //  416    429    197    204    Any
        //  456    461    429    433    Any
        //  463    468    429    433    Any
        //  470    479    429    433    Any
        //  481    494    429    433    Any
        //  496    504    429    433    Any
        //  506    516    429    433    Any
        //  518    528    429    433    Any
        //  528    530    429    433    Any
        //  532    536    429    433    Any
        //  538    548    429    433    Any
        //  550    563    429    433    Any
        //  565    584    429    433    Any
        //  586    590    429    433    Any
        //  592    596    429    433    Any
        //  598    600    429    433    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0225:
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
    
    public static void K(final Context context, final n n, final n n2, c v, final i i) throws ax.b3.j {
        final long p5 = ((ax.c3.b)n).p();
        final Uri l = l(n);
        v = (ax.b3.j)v(n);
        final Uri v2 = v(n2);
        if (!((ax.c3.b)n).n()) {
            throw new t("Source File not exist");
        }
        final boolean equals = n.B().equals((Object)n2.B());
        Uri b = null;
        Label_0091: {
            if (!equals) {
                b = v.b(context.getContentResolver(), l, n2.B(), ((ax.c3.b)n).p(), ((ax.c3.b)n).q());
                if (b != null) {
                    break Label_0091;
                }
            }
            b = l;
        }
        Uri a = null;
        try {
            final ContentResolver contentResolver = context.getContentResolver();
            final long p6 = ((ax.c3.b)n).p();
            final long q = ((ax.c3.b)n).q();
            try {
                a = y.a(contentResolver, b, (Uri)v, v2, p6, q);
                v = null;
            }
            catch (final ax.b3.j v) {}
        }
        catch (final ax.b3.j j) {}
        if (a != null) {
            if (f.b0(n.P())) {
                if (!a.equals((Object)l(n2)) && !equals) {
                    if (v.b(context.getContentResolver(), a, n2.B(), ((ax.c3.b)n).p(), ((ax.c3.b)n).q()) == null) {
                        throw new ax.b3.j("renameDocument in move failed");
                    }
                }
            }
            else if (f.h1 == n.P()) {
                ax.u3.b.f();
            }
            if (i != null) {
                i.a(p5, p5);
            }
            return;
        }
        if (!b.equals((Object)l)) {
            v.b(context.getContentResolver(), b, n.B(), ((ax.c3.b)n).p(), ((ax.c3.b)n).q());
        }
        if (v == null) {
            throw new ax.b3.j("moveDocument failed 1");
        }
        throw new ax.b3.j("moveDocument failed 2", (Throwable)v);
    }
    
    public static void L(final e e, final n j, final n n, final c c, final i i) throws ax.b3.j {
        final long p5 = ((ax.c3.b)j).p();
        if (((ax.c3.b)n).n()) {
            final ax.Ha.b k = ax.Ha.c.h().f().d("!! Move Document FILE ALREADY EXISTS !!").j();
            final StringBuilder sb = new StringBuilder();
            sb.append("location:");
            sb.append(n.P().I());
            k.g((Object)sb.toString()).h();
            throw new ax.b3.j("moveUsingCopyDocumentFile file already exists");
        }
        if (((ax.c3.b)j).isDirectory()) {
            if (((m)e).u() != f.h1) {
                ax.u3.b.g("Not supported : doesSupportMoveFileToDifferentParent() == false");
            }
            throw new ax.b3.j("Folder rename is not supported");
        }
        Label_0139: {
            while (true) {
                try {
                    final G s = ((m)e).s((n)j);
                    final long p6 = ((ax.c3.b)j).p();
                    final long q = ((ax.c3.b)j).q();
                    try {
                        Q(e, n, s, p6, q, true, c, i);
                        g((m)e, (n)j);
                        if (i != null) {
                            i.a(p5, p5);
                        }
                        return;
                    }
                    catch (final ax.b3.j l) {}
                    catch (final a a) {}
                    break Label_0139;
                }
                catch (final ax.b3.j j) {
                    goto Label_0117;
                }
                catch (final a j) {
                    continue;
                }
                break;
            }
            g((m)e, n);
            throw j;
        }
        g((m)e, n);
        throw new ax.b3.j((Throwable)j);
    }
    
    public static void M(final Context context, final n n, final n n2, final c c, final i i) throws ax.b3.j {
        final long p5 = ((ax.c3.b)n).p();
        v.b(context.getContentResolver(), l(n), n2.B(), ((ax.c3.b)n).p(), ((ax.c3.b)n).q());
        if (i != null) {
            i.a(p5, p5);
        }
    }
    
    public static Uri N(final Uri uri) {
        Q.l(31);
        return uri.buildUpon().appendQueryParameter("manage", "true").build();
    }
    
    public static void O(final Context context, final K k, final String s, final Uri uri) {
        try {
            final SharedPreferences$Editor edit = context.getSharedPreferences("pref_secondary", 0).edit();
            edit.putString(y(k, s), uri.toString());
            edit.commit();
        }
        catch (final M m) {
            ((Throwable)m).printStackTrace();
        }
    }
    
    public static void P(e openFileDescriptor, final n n, final long n2) throws IOException, ax.b3.j {
        if (!((ax.c3.b)n).n()) {
            throw new t();
        }
        final Context p3 = ((m)openFileDescriptor).p();
        final Uri l = l(n);
        final e e = null;
        Object o = null;
        Object a = null;
        final Throwable t = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        FileOutputStream fileOutputStream2 = null;
        Label_0471: {
            try {
                openFileDescriptor = (e)p3.getContentResolver().openFileDescriptor(l, "rw");
                try {
                    final FileOutputStream fileOutputStream = new FileOutputStream(((ParcelFileDescriptor)openFileDescriptor).getFileDescriptor());
                    a = t;
                    o = e;
                    try {
                        final Throwable t2 = (Throwable)(o = (a = ax.g2.b.a(fileOutputStream)));
                        ((FileChannel)t2).truncate(n2);
                        ((AbstractInterruptibleChannel)t2).close();
                        fileOutputStream.close();
                        ((ParcelFileDescriptor)openFileDescriptor).close();
                        return;
                    }
                    catch (final SecurityException a) {}
                    catch (final IllegalArgumentException t) {
                        a = openFileDescriptor;
                    }
                    finally {
                        openFileDescriptor = (e)o;
                    }
                }
                catch (final SecurityException a) {
                    o = (openFileDescriptor = null);
                }
                catch (final IllegalArgumentException t) {
                    o = null;
                    a = null;
                    openFileDescriptor = (e)o;
                }
            }
            catch (final SecurityException a) {}
            catch (final IllegalArgumentException t) {}
            finally {
                parcelFileDescriptor = null;
                fileOutputStream2 = null;
                break Label_0471;
            }
            final FileOutputStream fileOutputStream4;
            FileOutputStream fileOutputStream3 = fileOutputStream4;
            Throwable t3 = (Throwable)fileOutputStream2;
            Throwable t4 = (Throwable)parcelFileDescriptor;
            try {
                fileOutputStream3 = fileOutputStream4;
                t3 = (Throwable)fileOutputStream2;
                t4 = (Throwable)parcelFileDescriptor;
                final ax.b3.j j = new ax.b3.j((Throwable)a);
                fileOutputStream3 = fileOutputStream4;
                t3 = (Throwable)fileOutputStream2;
                t4 = (Throwable)parcelFileDescriptor;
                throw j;
            }
            finally {
                a = t4;
                parcelFileDescriptor = (ParcelFileDescriptor)t3;
                fileOutputStream2 = fileOutputStream3;
                break Label_0471;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("FILE:");
            sb.append(((ax.c3.b)fileOutputStream2).n());
            ax.Ha.c.h().f().b("trucate failed").l(t).g((Object)sb.toString()).h();
            throw new IOException(t);
        }
        if (a != null) {
            ((AbstractInterruptibleChannel)a).close();
        }
        if (fileOutputStream2 != null) {
            fileOutputStream2.close();
        }
        if (parcelFileDescriptor != null) {
            parcelFileDescriptor.close();
        }
    }
    
    public static void Q(final e p0, final n p1, final G p2, final long p3, final Long p4, final boolean p5, final c p6, final i p7) throws ax.b3.j, a {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/alphainventor/filemanager/file/m.p:()Landroid/content/Context;
        //     4: astore          22
        //     6: aload_0        
        //     7: aload_1        
        //     8: iconst_0       
        //     9: invokestatic    com/alphainventor/filemanager/file/g.d:(Lcom/alphainventor/filemanager/file/e;Lcom/alphainventor/filemanager/file/n;Z)Landroid/net/Uri;
        //    12: astore          21
        //    14: aload           21
        //    16: ifnull          837
        //    19: aload_1        
        //    20: invokevirtual   com/alphainventor/filemanager/file/n.P:()Lax/Q2/f;
        //    23: invokestatic    ax/Q2/f.b0:(Lax/Q2/f;)Z
        //    26: ifeq            196
        //    29: aload_1        
        //    30: invokestatic    com/alphainventor/filemanager/file/g.l:(Lcom/alphainventor/filemanager/file/n;)Landroid/net/Uri;
        //    33: astore          5
        //    35: aload           5
        //    37: ifnull          201
        //    40: aload           21
        //    42: aload           5
        //    44: invokevirtual   android/net/Uri.equals:(Ljava/lang/Object;)Z
        //    47: ifne            201
        //    50: aload_1        
        //    51: invokevirtual   com/alphainventor/filemanager/file/n.B:()Ljava/lang/String;
        //    54: invokestatic    ax/c3/d0.M:(Ljava/lang/String;)Z
        //    57: ifeq            201
        //    60: aload           21
        //    62: invokevirtual   android/net/Uri.getPath:()Ljava/lang/String;
        //    65: invokestatic    ax/c3/d0.h:(Ljava/lang/String;)Ljava/lang/String;
        //    68: invokestatic    ax/c3/d0.g:(Ljava/lang/String;)Ljava/lang/String;
        //    71: astore_1       
        //    72: aload_1        
        //    73: ifnull          124
        //    76: aload_1        
        //    77: ldc_w           ")"
        //    80: invokevirtual   java/lang/String.endsWith:(Ljava/lang/String;)Z
        //    83: ifeq            124
        //    86: aload_1        
        //    87: ldc_w           "("
        //    90: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //    93: istore          11
        //    95: iload           11
        //    97: ifne            103
        //   100: goto            124
        //   103: aload           22
        //   105: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //   108: aload           21
        //   110: invokestatic    ax/X2/v.f:(Landroid/content/ContentResolver;Landroid/net/Uri;)V
        //   113: new             Lax/b3/f;
        //   116: astore_1       
        //   117: aload_1        
        //   118: iconst_0       
        //   119: invokespecial   ax/b3/f.<init>:(Z)V
        //   122: aload_1        
        //   123: athrow         
        //   124: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   127: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   130: ldc_w           "UNEXPECTED DOCUMENT FILE NAME"
        //   133: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   136: astore_1       
        //   137: new             Ljava/lang/StringBuilder;
        //   140: astore          12
        //   142: aload           12
        //   144: invokespecial   java/lang/StringBuilder.<init>:()V
        //   147: aload           12
        //   149: ldc_w           "expected:"
        //   152: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: pop            
        //   156: aload           12
        //   158: aload           5
        //   160: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   163: pop            
        //   164: aload           12
        //   166: ldc_w           ",uri:"
        //   169: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   172: pop            
        //   173: aload           12
        //   175: aload           21
        //   177: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   180: pop            
        //   181: aload_1        
        //   182: aload           12
        //   184: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   187: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   190: invokevirtual   ax/Ha/b.h:()V
        //   193: goto            201
        //   196: aload_1        
        //   197: invokevirtual   com/alphainventor/filemanager/file/n.P:()Lax/Q2/f;
        //   200: pop            
        //   201: iconst_0       
        //   202: istore          9
        //   204: aconst_null    
        //   205: astore          19
        //   207: aconst_null    
        //   208: astore          16
        //   210: aconst_null    
        //   211: astore          17
        //   213: aconst_null    
        //   214: astore          18
        //   216: aconst_null    
        //   217: astore          5
        //   219: aconst_null    
        //   220: astore          20
        //   222: aload_2        
        //   223: invokevirtual   ax/c3/G.b:()Ljava/io/InputStream;
        //   226: astore_1       
        //   227: aload           20
        //   229: astore          5
        //   231: aload_1        
        //   232: astore          12
        //   234: aload           22
        //   236: aload           21
        //   238: invokestatic    ax/X2/v.p:(Landroid/content/Context;Landroid/net/Uri;)Landroid/content/res/AssetFileDescriptor;
        //   241: astore          14
        //   243: goto            343
        //   246: astore_0       
        //   247: aload           12
        //   249: astore_1       
        //   250: goto            805
        //   253: astore_2       
        //   254: aload           19
        //   256: astore_0       
        //   257: goto            559
        //   260: astore_0       
        //   261: aload_0        
        //   262: astore_2       
        //   263: aload           16
        //   265: astore_0       
        //   266: goto            606
        //   269: astore_0       
        //   270: goto            261
        //   273: astore_0       
        //   274: aload           17
        //   276: astore          5
        //   278: goto            678
        //   281: astore          13
        //   283: aload           18
        //   285: astore          14
        //   287: goto            697
        //   290: astore          5
        //   292: aload           20
        //   294: astore          5
        //   296: aload_1        
        //   297: astore          12
        //   299: aload           22
        //   301: aload           21
        //   303: invokestatic    ax/X2/v.p:(Landroid/content/Context;Landroid/net/Uri;)Landroid/content/res/AssetFileDescriptor;
        //   306: astore          13
        //   308: aload           13
        //   310: astore          14
        //   312: aload           13
        //   314: ifnull          343
        //   317: aload           20
        //   319: astore          5
        //   321: aload_1        
        //   322: astore          12
        //   324: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   327: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   330: ldc_w           "REMOTE EXCEPTION RETRY SUCCESS! : WriteDocumentFile"
        //   333: invokevirtual   ax/Ha/b.c:(Ljava/lang/String;)Lax/Ha/b;
        //   336: invokevirtual   ax/Ha/b.h:()V
        //   339: aload           13
        //   341: astore          14
        //   343: aload           14
        //   345: ifnull          369
        //   348: aload           20
        //   350: astore          5
        //   352: aload_1        
        //   353: astore          12
        //   355: aload           14
        //   357: invokevirtual   android/content/res/AssetFileDescriptor.createOutputStream:()Ljava/io/FileOutputStream;
        //   360: astore          13
        //   362: aload           13
        //   364: astore          5
        //   366: goto            372
        //   369: aconst_null    
        //   370: astore          5
        //   372: aload           5
        //   374: astore          15
        //   376: aload           5
        //   378: ifnonnull       400
        //   381: aload           20
        //   383: astore          5
        //   385: aload_1        
        //   386: astore          12
        //   388: aload           22
        //   390: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //   393: aload           21
        //   395: invokevirtual   android/content/ContentResolver.openOutputStream:(Landroid/net/Uri;)Ljava/io/OutputStream;
        //   398: astore          15
        //   400: aload           20
        //   402: astore          5
        //   404: aload_1        
        //   405: astore          12
        //   407: new             Ljava/io/BufferedOutputStream;
        //   410: astore          13
        //   412: aload           20
        //   414: astore          5
        //   416: aload_1        
        //   417: astore          12
        //   419: aload           13
        //   421: aload           15
        //   423: sipush          8192
        //   426: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;I)V
        //   429: aload_1        
        //   430: aload           13
        //   432: lload_3        
        //   433: aload           7
        //   435: aload           8
        //   437: invokestatic    ax/c3/F.c:(Ljava/io/InputStream;Ljava/io/OutputStream;JLax/u3/c;Lax/g3/i;)J
        //   440: pop2           
        //   441: aload           14
        //   443: ifnull          521
        //   446: iload           6
        //   448: ifeq            521
        //   451: aload_0        
        //   452: invokevirtual   com/alphainventor/filemanager/file/e.k0:()Z
        //   455: ifeq            521
        //   458: aload           14
        //   460: invokevirtual   android/content/res/AssetFileDescriptor.getParcelFileDescriptor:()Landroid/os/ParcelFileDescriptor;
        //   463: invokevirtual   android/os/ParcelFileDescriptor.getFileDescriptor:()Ljava/io/FileDescriptor;
        //   466: invokevirtual   java/io/FileDescriptor.sync:()V
        //   469: goto            521
        //   472: astore_0       
        //   473: aload           13
        //   475: astore          5
        //   477: goto            805
        //   480: astore_2       
        //   481: aload           13
        //   483: astore_0       
        //   484: goto            559
        //   487: astore_0       
        //   488: aload_0        
        //   489: astore_2       
        //   490: aload           13
        //   492: astore_0       
        //   493: goto            606
        //   496: astore_0       
        //   497: goto            488
        //   500: astore_0       
        //   501: aload           13
        //   503: astore          5
        //   505: goto            678
        //   508: astore          5
        //   510: aload           13
        //   512: astore          14
        //   514: aload           5
        //   516: astore          13
        //   518: goto            697
        //   521: aload           13
        //   523: invokevirtual   java/io/OutputStream.close:()V
        //   526: goto            530
        //   529: astore_0       
        //   530: aload_1        
        //   531: ifnull          546
        //   534: aload_1        
        //   535: invokevirtual   java/io/InputStream.close:()V
        //   538: goto            546
        //   541: astore_0       
        //   542: aload_0        
        //   543: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   546: return         
        //   547: astore_0       
        //   548: aconst_null    
        //   549: astore_1       
        //   550: goto            805
        //   553: astore_2       
        //   554: aconst_null    
        //   555: astore_1       
        //   556: aload           19
        //   558: astore_0       
        //   559: aload_0        
        //   560: astore          5
        //   562: aload_1        
        //   563: astore          12
        //   565: new             Lax/b3/j;
        //   568: astore          7
        //   570: aload_0        
        //   571: astore          5
        //   573: aload_1        
        //   574: astore          12
        //   576: aload           7
        //   578: aload_2        
        //   579: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   582: aload_0        
        //   583: astore          5
        //   585: aload_1        
        //   586: astore          12
        //   588: aload           7
        //   590: athrow         
        //   591: astore_0       
        //   592: aload_0        
        //   593: astore_2       
        //   594: aconst_null    
        //   595: astore_1       
        //   596: aload           16
        //   598: astore_0       
        //   599: goto            606
        //   602: astore_0       
        //   603: goto            592
        //   606: aload_0        
        //   607: astore          5
        //   609: aload_1        
        //   610: astore          12
        //   612: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   615: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   618: ldc_w           "LOWDF1:"
        //   621: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   624: aload_2        
        //   625: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   628: aload           21
        //   630: invokevirtual   android/net/Uri.toString:()Ljava/lang/String;
        //   633: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   636: invokevirtual   ax/Ha/b.h:()V
        //   639: aload_0        
        //   640: astore          5
        //   642: aload_1        
        //   643: astore          12
        //   645: new             Lax/b3/j;
        //   648: astore          7
        //   650: aload_0        
        //   651: astore          5
        //   653: aload_1        
        //   654: astore          12
        //   656: aload           7
        //   658: aload_2        
        //   659: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   662: aload_0        
        //   663: astore          5
        //   665: aload_1        
        //   666: astore          12
        //   668: aload           7
        //   670: athrow         
        //   671: astore_0       
        //   672: aconst_null    
        //   673: astore_1       
        //   674: aload           17
        //   676: astore          5
        //   678: aload_1        
        //   679: astore          12
        //   681: ldc_w           "write document error"
        //   684: aload_0        
        //   685: invokestatic    ax/b3/d.a:(Ljava/lang/String;Ljava/lang/Exception;)Lax/b3/j;
        //   688: athrow         
        //   689: astore          13
        //   691: aconst_null    
        //   692: astore_1       
        //   693: aload           18
        //   695: astore          14
        //   697: iload           9
        //   699: ifgt            772
        //   702: aload           14
        //   704: astore          5
        //   706: aload_1        
        //   707: astore          12
        //   709: aload_2        
        //   710: invokevirtual   ax/c3/G.a:()Z
        //   713: istore          11
        //   715: iload           11
        //   717: ifeq            772
        //   720: iload           9
        //   722: iconst_1       
        //   723: iadd           
        //   724: istore          10
        //   726: aload           14
        //   728: ifnull          741
        //   731: aload           14
        //   733: invokevirtual   java/io/OutputStream.close:()V
        //   736: goto            741
        //   739: astore          5
        //   741: iload           10
        //   743: istore          9
        //   745: aload_1        
        //   746: ifnull          204
        //   749: aload_1        
        //   750: invokevirtual   java/io/InputStream.close:()V
        //   753: iload           10
        //   755: istore          9
        //   757: goto            204
        //   760: astore_1       
        //   761: aload_1        
        //   762: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   765: iload           10
        //   767: istore          9
        //   769: goto            204
        //   772: aload           14
        //   774: astore          5
        //   776: aload_1        
        //   777: astore          12
        //   779: new             Lax/b3/j;
        //   782: astore_0       
        //   783: aload           14
        //   785: astore          5
        //   787: aload_1        
        //   788: astore          12
        //   790: aload_0        
        //   791: aload           13
        //   793: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   796: aload           14
        //   798: astore          5
        //   800: aload_1        
        //   801: astore          12
        //   803: aload_0        
        //   804: athrow         
        //   805: aload           5
        //   807: ifnull          819
        //   810: aload           5
        //   812: invokevirtual   java/io/OutputStream.close:()V
        //   815: goto            819
        //   818: astore_2       
        //   819: aload_1        
        //   820: ifnull          835
        //   823: aload_1        
        //   824: invokevirtual   java/io/InputStream.close:()V
        //   827: goto            835
        //   830: astore_1       
        //   831: aload_1        
        //   832: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   835: aload_0        
        //   836: athrow         
        //   837: new             Lax/b3/j;
        //   840: dup            
        //   841: ldc_w           "DocumentFile returns null"
        //   844: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   847: athrow         
        //   848: astore_1       
        //   849: goto            201
        //   852: astore_1       
        //   853: goto            113
        //    Exceptions:
        //  throws ax.b3.j
        //  throws ax.b3.a
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  29     35     848    852    Lax/b3/j;
        //  40     72     848    852    Lax/b3/j;
        //  76     95     848    852    Lax/b3/j;
        //  103    113    852    856    Ljava/lang/SecurityException;
        //  103    113    848    852    Lax/b3/j;
        //  113    124    848    852    Lax/b3/j;
        //  124    193    848    852    Lax/b3/j;
        //  222    227    689    697    Ljava/io/SyncFailedException;
        //  222    227    671    678    Ljava/io/IOException;
        //  222    227    602    606    Ljava/lang/IllegalArgumentException;
        //  222    227    591    592    Ljava/lang/SecurityException;
        //  222    227    553    559    Ljava/lang/NullPointerException;
        //  222    227    547    553    Any
        //  234    243    290    343    Ljava/io/FileNotFoundException;
        //  234    243    281    290    Ljava/io/SyncFailedException;
        //  234    243    273    281    Ljava/io/IOException;
        //  234    243    269    273    Ljava/lang/IllegalArgumentException;
        //  234    243    260    261    Ljava/lang/SecurityException;
        //  234    243    253    260    Ljava/lang/NullPointerException;
        //  234    243    246    253    Any
        //  299    308    281    290    Ljava/io/SyncFailedException;
        //  299    308    273    281    Ljava/io/IOException;
        //  299    308    269    273    Ljava/lang/IllegalArgumentException;
        //  299    308    260    261    Ljava/lang/SecurityException;
        //  299    308    253    260    Ljava/lang/NullPointerException;
        //  299    308    246    253    Any
        //  324    339    281    290    Ljava/io/SyncFailedException;
        //  324    339    273    281    Ljava/io/IOException;
        //  324    339    269    273    Ljava/lang/IllegalArgumentException;
        //  324    339    260    261    Ljava/lang/SecurityException;
        //  324    339    253    260    Ljava/lang/NullPointerException;
        //  324    339    246    253    Any
        //  355    362    281    290    Ljava/io/SyncFailedException;
        //  355    362    273    281    Ljava/io/IOException;
        //  355    362    269    273    Ljava/lang/IllegalArgumentException;
        //  355    362    260    261    Ljava/lang/SecurityException;
        //  355    362    253    260    Ljava/lang/NullPointerException;
        //  355    362    246    253    Any
        //  388    400    281    290    Ljava/io/SyncFailedException;
        //  388    400    273    281    Ljava/io/IOException;
        //  388    400    269    273    Ljava/lang/IllegalArgumentException;
        //  388    400    260    261    Ljava/lang/SecurityException;
        //  388    400    253    260    Ljava/lang/NullPointerException;
        //  388    400    246    253    Any
        //  407    412    281    290    Ljava/io/SyncFailedException;
        //  407    412    273    281    Ljava/io/IOException;
        //  407    412    269    273    Ljava/lang/IllegalArgumentException;
        //  407    412    260    261    Ljava/lang/SecurityException;
        //  407    412    253    260    Ljava/lang/NullPointerException;
        //  407    412    246    253    Any
        //  419    429    281    290    Ljava/io/SyncFailedException;
        //  419    429    273    281    Ljava/io/IOException;
        //  419    429    269    273    Ljava/lang/IllegalArgumentException;
        //  419    429    260    261    Ljava/lang/SecurityException;
        //  419    429    253    260    Ljava/lang/NullPointerException;
        //  419    429    246    253    Any
        //  429    441    508    521    Ljava/io/SyncFailedException;
        //  429    441    500    508    Ljava/io/IOException;
        //  429    441    496    500    Ljava/lang/IllegalArgumentException;
        //  429    441    487    488    Ljava/lang/SecurityException;
        //  429    441    480    487    Ljava/lang/NullPointerException;
        //  429    441    472    480    Any
        //  451    469    508    521    Ljava/io/SyncFailedException;
        //  451    469    500    508    Ljava/io/IOException;
        //  451    469    496    500    Ljava/lang/IllegalArgumentException;
        //  451    469    487    488    Ljava/lang/SecurityException;
        //  451    469    480    487    Ljava/lang/NullPointerException;
        //  451    469    472    480    Any
        //  521    526    529    530    Ljava/io/IOException;
        //  534    538    541    546    Ljava/io/IOException;
        //  565    570    246    253    Any
        //  576    582    246    253    Any
        //  588    591    246    253    Any
        //  612    639    246    253    Any
        //  645    650    246    253    Any
        //  656    662    246    253    Any
        //  668    671    246    253    Any
        //  681    689    246    253    Any
        //  709    715    246    253    Any
        //  731    736    739    741    Ljava/io/IOException;
        //  749    753    760    772    Ljava/io/IOException;
        //  779    783    246    253    Any
        //  790    796    246    253    Any
        //  803    805    246    253    Any
        //  810    815    818    819    Ljava/io/IOException;
        //  823    827    830    835    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0103:
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
    
    public static boolean a(final Context context, final Uri uri) {
        return ax.Z2.n.b(context).d(uri);
    }
    
    public static void b(final Context context, final K k, final String s) {
        try {
            final SharedPreferences$Editor edit = context.getSharedPreferences("pref_secondary", 0).edit();
            if (k.d() == f.p0) {
                edit.remove("secondaryRootUri");
            }
            edit.remove(y(k, s));
            edit.commit();
        }
        catch (final M m) {
            ((Throwable)m).printStackTrace();
        }
    }
    
    public static Uri c(final Uri uri) {
        return DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
    }
    
    public static Uri d(final e e, final n n, final boolean b) throws ax.b3.j {
        final Context p3 = ((m)e).p();
        final String e2 = n.E();
        final String b2 = n.B();
        final n z = ((com.alphainventor.filemanager.file.c)e).z(d0.r(e2));
        if (z != null && ((ax.c3.b)z).n()) {
            final Uri v = v(n);
            if (b) {
                try {
                    return ax.X2.v.e(p3.getContentResolver(), v, b2);
                }
                catch (final SecurityException ex) {
                    ax.Ha.c.h().f().d("CDF1").l((Throwable)ex).h();
                    return null;
                }
            }
            String h;
            if ((h = ax.c3.v.h(e2)) == null) {
                h = "";
            }
            try {
                return ax.X2.v.d(p3.getContentResolver(), v, h, b2);
            }
            catch (final SecurityException ex2) {
                ax.Ha.c.h().f().d("CDF2").l((Throwable)ex2).h();
                return null;
            }
        }
        throw new ax.b3.j("CreateDocument Parent not exists");
    }
    
    public static Uri e(final K k, final Uri uri, final String s) throws ax.b3.j {
        if (uri == null) {
            final ax.Ha.b j = ax.Ha.c.h().b("Null RootUri").j();
            final StringBuilder sb = new StringBuilder();
            sb.append("loc:");
            sb.append(k.toString());
            j.g((Object)sb.toString()).h();
            throw new r("RootUri is empty");
        }
        final String e = k.e();
        if (s.equals((Object)e)) {
            return v.c(uri, v.h(uri));
        }
        Label_0097: {
            try {
                if (d0.I(e, s)) {
                    return f(uri, d0.n(e, s));
                }
            }
            catch (final IllegalArgumentException ex) {
                break Label_0097;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Path is not subdir of root");
            sb2.append(e);
            sb2.append(":");
            sb2.append(s);
            throw new ax.b3.j(sb2.toString());
        }
        final IllegalArgumentException ex;
        ax.Ha.c.h().f().d("Invalid PATH").l((Throwable)ex).g((Object)s).h();
        throw new ax.b3.j((Throwable)ex);
    }
    
    private static Uri f(Uri c, final String s) throws ax.b3.j {
        Label_0097: {
            String substring;
            try {
                final String h = v.h(c);
                if (h.endsWith(":")) {
                    substring = h;
                }
                else {
                    final int index = h.indexOf(":");
                    substring = h;
                    if (index >= 0) {
                        substring = h.substring(0, index + 1);
                    }
                }
            }
            catch (final IllegalArgumentException ex) {
                break Label_0097;
            }
            final String m = d0.m(s);
            final StringBuilder sb = new StringBuilder();
            sb.append(substring);
            sb.append(m);
            c = v.c(c, sb.toString());
            return c;
        }
        final IllegalArgumentException ex;
        ax.Ha.c.h().f().d("Invalid Tree PATH").l((Throwable)ex).g((Object)s).h();
        throw new ax.b3.j((Throwable)ex);
    }
    
    public static void g(final m m, final n n) throws ax.b3.j {
        if (((ax.c3.b)n).isDirectory()) {
            final List b0 = m.b0(n);
            if (b0 != null) {
                if (b0.size() > 0) {
                    throw new k("DocumentFile Delete Failed : has Children");
                }
            }
        }
        final Context p2 = m.p();
        try {
            v.f(p2.getContentResolver(), l(n));
            return;
        }
        catch (final SecurityException p2) {}
        catch (final ax.b3.j j) {}
        if (p2 instanceof SecurityException) {
            if (".$recycle_bin$".equals((Object)d0.h(n.T()))) {
                ax.Ha.c.h().f().d("CDF3").l((Throwable)p2).h();
            }
            else {
                ax.Ha.c.h().f().d("CDF4").l((Throwable)p2).h();
            }
        }
        if (((ax.c3.b)((com.alphainventor.filemanager.file.c)m).z(n.E())).n()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("DocumentFile delete failed : exist=true, dir=");
            sb.append(((ax.c3.b)n).isDirectory());
            throw d.a(sb.toString(), (Exception)p2);
        }
        throw new t("DocumentFile delete failed : File not exist");
    }
    
    public static K h(final Context context, final Uri uri) {
        if (Q.L()) {
            try {
                final String h = v.h(uri);
                final j f = j.F();
                final K e = K.e;
                final String z = f.Z(e);
                if (h != null && z != null && h.startsWith(z)) {
                    return e;
                }
            }
            catch (final IllegalArgumentException ex) {}
        }
        if (j.F().Y() != null) {
            for (final K k : j.F().Y()) {
                if (H(context, k, null, uri)) {
                    return k;
                }
            }
        }
        for (final K i : j.F().L()) {
            if (H(context, i, null, uri)) {
                return i;
            }
        }
        final f p2 = f.p0;
        final f u0 = f.u0;
        for (int j = 0; j < 2; ++j) {
            final K a = K.a((new f[] { p2, u0 })[j], 0);
            if (a.e() != null && H(context, a, null, uri)) {
                return a;
            }
        }
        return null;
    }
    
    public static l i(final Context context, Uri parse, String s) throws ax.b3.j {
        final ContentResolver contentResolver = context.getContentResolver();
        Object o2 = null;
        Label_1000: {
            Object o = null;
            ax.b3.v v = null;
            Label_0889: {
                Label_0842: {
                    try {
                        final Cursor query = contentResolver.query(parse, l.g, (String)null, (String[])null, (String)null);
                        if (query == null) {
                            o = query;
                            Label_0301: {
                                String documentId;
                                AutoCloseable autoCloseable;
                                try {
                                    try {
                                        final String treeDocumentId = DocumentsContract.getTreeDocumentId(parse);
                                        o = query;
                                        documentId = DocumentsContract.getDocumentId(parse);
                                        o = query;
                                        if (!Objects.equals((Object)treeDocumentId, (Object)documentId)) {
                                            break Label_0301;
                                        }
                                        o = query;
                                        o = query;
                                        final StringBuilder sb = new StringBuilder();
                                        o = query;
                                        sb.append(parse.toString());
                                        o = query;
                                        sb.append("$A$B$C$D$E$F$G$H$I$J$K$L");
                                        o = query;
                                        parse = Uri.parse(sb.toString());
                                        final ContentResolver contentResolver2 = contentResolver;
                                        final Uri uri = parse;
                                        final int n = 1;
                                        final String[] array = new String[n];
                                        final int n2 = 0;
                                        final String s2 = "document_id";
                                        array[n2] = s2;
                                        final String s3 = null;
                                        final String[] array2 = null;
                                        final String s4 = null;
                                        final Cursor cursor = contentResolver2.query(uri, array, s3, array2, s4);
                                        final Cursor cursor3;
                                        final Cursor cursor2 = cursor3 = cursor;
                                        if (cursor3 != null) {
                                            o = cursor2;
                                            final ax.Ha.b b = ax.Ha.c.h();
                                            final String s5 = "RETRY success for getting file attribute 1";
                                            final ax.Ha.b b2 = b.c(s5);
                                            b2.h();
                                            o = cursor2;
                                            final String s6 = documentId;
                                            final String s7 = s;
                                            s = (String)new l(s6, s7);
                                            final Cursor cursor4 = cursor2;
                                            F.a((AutoCloseable)cursor4);
                                            final String s8 = s;
                                            return (l)s8;
                                        }
                                        break Label_0301;
                                    }
                                    finally {
                                        final Throwable t;
                                        autoCloseable = (AutoCloseable)t;
                                    }
                                }
                                catch (final RuntimeException ex) {
                                    break Label_0842;
                                }
                                catch (final SecurityException ex2) {
                                    throw new p((Throwable)v);
                                }
                                catch (final IllegalArgumentException ex3) {
                                    break Label_0889;
                                }
                                try {
                                    final ContentResolver contentResolver2 = contentResolver;
                                    final Uri uri = parse;
                                    final int n = 1;
                                    final String[] array = new String[n];
                                    final int n2 = 0;
                                    final String s2 = "document_id";
                                    array[n2] = s2;
                                    final String s3 = null;
                                    final String[] array2 = null;
                                    final String s4 = null;
                                    final Cursor cursor = contentResolver2.query(uri, array, s3, array2, s4);
                                    final Cursor cursor3;
                                    final Cursor cursor2 = cursor3 = cursor;
                                    if (cursor3 != null) {
                                        o = cursor2;
                                        final ax.Ha.b b = ax.Ha.c.h();
                                        final String s5 = "RETRY success for getting file attribute 1";
                                        final ax.Ha.b b2 = b.c(s5);
                                        b2.h();
                                        o = cursor2;
                                        final String s6 = documentId;
                                        final String s7 = s;
                                        s = (String)new l(s6, s7);
                                        final Cursor cursor4 = cursor2;
                                        F.a((AutoCloseable)cursor4);
                                        final String s8 = s;
                                        return (l)s8;
                                    }
                                    o = autoCloseable;
                                    s = new(ax.b3.v.class)();
                                    o = autoCloseable;
                                    new ax.b3.v("Remote Provider Error");
                                    o = autoCloseable;
                                    throw s;
                                }
                                catch (final Exception ex4) {
                                    o = query;
                                    o = query;
                                    s = (String)new ax.b3.j((Throwable)ex4);
                                    o = query;
                                    throw s;
                                }
                                catch (final IllegalArgumentException ex5) {
                                    o = query;
                                    if (((Throwable)v).getMessage() != null) {
                                        o = query;
                                        if (((Throwable)v).getMessage().contains((CharSequence)"No root for")) {
                                            o = query;
                                            s = new(ax.b3.C.class)();
                                            o = query;
                                            new C((Throwable)v);
                                            o = query;
                                            throw s;
                                        }
                                    }
                                    o = query;
                                    if (((Throwable)v).getMessage() != null) {
                                        o = query;
                                        if (((Throwable)v).getMessage().contains((CharSequence)"Missing file")) {
                                            o = query;
                                            ax.Ha.c.h().f().c("RETRY success for getting file attribute 2").l((Throwable)v).h();
                                            o = query;
                                            final l l = new l(documentId, s);
                                            F.a((AutoCloseable)query);
                                            return l;
                                        }
                                    }
                                    o = query;
                                    s = new(ax.b3.j.class)();
                                    o = query;
                                    new ax.b3.j((Throwable)v);
                                    o = query;
                                    throw s;
                                }
                            }
                            o = query;
                            o = query;
                            v = new ax.b3.v("Remote Provider Error");
                            o2 = query;
                            o = query;
                        }
                        else {
                            o = query;
                            if (query.moveToFirst()) {
                                o = query;
                                final l i = new l(query);
                                F.a((AutoCloseable)query);
                                return i;
                            }
                            F.a((AutoCloseable)query);
                            return null;
                        }
                    }
                    catch (final RuntimeException ex6) {}
                    catch (final SecurityException ex7) {}
                    catch (final IllegalArgumentException ex8) {}
                    finally {
                        o2 = null;
                        break Label_1000;
                    }
                }
                ((Throwable)v).printStackTrace();
                throw new ax.b3.j((Throwable)v);
            }
            if (((Throwable)v).getMessage() != null && ((Throwable)v).getMessage().contains((CharSequence)"No root for")) {
                throw new C((Throwable)v);
            }
            if (((Throwable)v).getMessage() != null && ((Throwable)v).getMessage().contains((CharSequence)"Missing file")) {
                F.a((AutoCloseable)o);
                return null;
            }
            ((Throwable)v).printStackTrace();
            throw new t((Throwable)v);
        }
        F.a((AutoCloseable)o2);
    }
    
    public static l j(final Context context, final n n) throws ax.b3.j {
        return i(context, l(n), n.B());
    }
    
    public static k0 k(final Context p0, final m p1, final K p2, final Uri p3) throws ax.b3.j {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ifeq            90
        //     6: aload_2        
        //     7: invokevirtual   ax/c3/K.e:()Ljava/lang/String;
        //    10: ldc_w           "LOST.DIR"
        //    13: invokestatic    ax/c3/d0.Q:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    16: astore          9
        //    18: aload           9
        //    20: astore          8
        //    22: aload_1        
        //    23: aload           9
        //    25: invokeinterface com/alphainventor/filemanager/file/c.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //    30: invokeinterface ax/c3/b.n:()Z
        //    35: ifne            96
        //    38: aload_2        
        //    39: invokevirtual   ax/c3/K.e:()Ljava/lang/String;
        //    42: ldc_w           ".tempfstat"
        //    45: invokestatic    ax/c3/d0.Q:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    48: astore          9
        //    50: aload_1        
        //    51: aload           9
        //    53: invokeinterface com/alphainventor/filemanager/file/c.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
        //    58: astore          10
        //    60: aload           9
        //    62: astore          8
        //    64: aload           10
        //    66: invokeinterface ax/c3/b.n:()Z
        //    71: ifne            96
        //    74: aload_1        
        //    75: aload           10
        //    77: invokeinterface com/alphainventor/filemanager/file/c.N:(Lcom/alphainventor/filemanager/file/n;)Z
        //    82: pop            
        //    83: aload           9
        //    85: astore          8
        //    87: goto            96
        //    90: aload_2        
        //    91: invokevirtual   ax/c3/K.e:()Ljava/lang/String;
        //    94: astore          8
        //    96: aload_2        
        //    97: aload_3        
        //    98: aload           8
        //   100: invokestatic    com/alphainventor/filemanager/file/g.e:(Lax/c3/K;Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
        //   103: astore_3       
        //   104: aconst_null    
        //   105: astore_2       
        //   106: aconst_null    
        //   107: astore_1       
        //   108: aload_0        
        //   109: aload_3        
        //   110: ldc_w           "r"
        //   113: invokestatic    com/alphainventor/filemanager/file/g.o:(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
        //   116: astore_0       
        //   117: aload_0        
        //   118: ifnull          195
        //   121: aload_0        
        //   122: astore_1       
        //   123: aload_0        
        //   124: astore_2       
        //   125: aload_0        
        //   126: invokevirtual   android/os/ParcelFileDescriptor.getFileDescriptor:()Ljava/io/FileDescriptor;
        //   129: invokestatic    android/system/Os.fstatvfs:(Ljava/io/FileDescriptor;)Landroid/system/StructStatVfs;
        //   132: astore_3       
        //   133: aload_0        
        //   134: astore_1       
        //   135: aload_0        
        //   136: astore_2       
        //   137: aload_3        
        //   138: getfield        android/system/StructStatVfs.f_blocks:J
        //   141: lstore          4
        //   143: aload_0        
        //   144: astore_1       
        //   145: aload_0        
        //   146: astore_2       
        //   147: aload_3        
        //   148: getfield        android/system/StructStatVfs.f_bsize:J
        //   151: lstore          6
        //   153: aload_0        
        //   154: astore_1       
        //   155: aload_0        
        //   156: astore_2       
        //   157: new             Lax/c3/k0;
        //   160: dup            
        //   161: lload           4
        //   163: lload           6
        //   165: lmul           
        //   166: lload           6
        //   168: lload           4
        //   170: aload_3        
        //   171: getfield        android/system/StructStatVfs.f_bavail:J
        //   174: lsub           
        //   175: lmul           
        //   176: iconst_0       
        //   177: invokespecial   ax/c3/k0.<init>:(JJI)V
        //   180: astore_3       
        //   181: aload_0        
        //   182: invokevirtual   android/os/ParcelFileDescriptor.close:()V
        //   185: aload_3        
        //   186: areturn        
        //   187: astore_0       
        //   188: goto            237
        //   191: astore_0       
        //   192: goto            220
        //   195: aload_0        
        //   196: astore_1       
        //   197: aload_0        
        //   198: astore_2       
        //   199: new             Lax/b3/j;
        //   202: astore_3       
        //   203: aload_0        
        //   204: astore_1       
        //   205: aload_0        
        //   206: astore_2       
        //   207: aload_3        
        //   208: ldc_w           "faild to get file descriptor"
        //   211: invokespecial   ax/b3/j.<init>:(Ljava/lang/String;)V
        //   214: aload_0        
        //   215: astore_1       
        //   216: aload_0        
        //   217: astore_2       
        //   218: aload_3        
        //   219: athrow         
        //   220: aload_2        
        //   221: astore_1       
        //   222: new             Lax/b3/j;
        //   225: astore_3       
        //   226: aload_2        
        //   227: astore_1       
        //   228: aload_3        
        //   229: aload_0        
        //   230: invokespecial   ax/b3/j.<init>:(Ljava/lang/Throwable;)V
        //   233: aload_2        
        //   234: astore_1       
        //   235: aload_3        
        //   236: athrow         
        //   237: aload_1        
        //   238: ifnull          245
        //   241: aload_1        
        //   242: invokevirtual   android/os/ParcelFileDescriptor.close:()V
        //   245: aload_0        
        //   246: athrow         
        //   247: astore_0       
        //   248: goto            185
        //   251: astore_1       
        //   252: goto            245
        //    Exceptions:
        //  throws ax.b3.j
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  108    117    191    237    Landroid/system/ErrnoException;
        //  108    117    187    247    Any
        //  125    133    191    237    Landroid/system/ErrnoException;
        //  125    133    187    247    Any
        //  137    143    191    237    Landroid/system/ErrnoException;
        //  137    143    187    247    Any
        //  147    153    191    237    Landroid/system/ErrnoException;
        //  147    153    187    247    Any
        //  157    181    191    237    Landroid/system/ErrnoException;
        //  157    181    187    247    Any
        //  181    185    247    251    Ljava/io/IOException;
        //  199    203    191    237    Landroid/system/ErrnoException;
        //  199    203    187    247    Any
        //  207    214    191    237    Landroid/system/ErrnoException;
        //  207    214    187    247    Any
        //  218    220    191    237    Landroid/system/ErrnoException;
        //  218    220    187    247    Any
        //  222    226    187    247    Any
        //  228    233    187    247    Any
        //  235    237    187    247    Any
        //  241    245    251    255    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 144 out of bounds for length 144
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
    
    public static Uri l(final n n) throws ax.b3.j {
        if (B.P(n)) {
            final com.alphainventor.filemanager.file.y y = (com.alphainventor.filemanager.file.y)n;
            return e(y.B0(), y.N0(), n.E());
        }
        if (B.J(n)) {
            return ((com.alphainventor.filemanager.file.i)n).n0();
        }
        ax.u3.b.f();
        throw new ax.b3.j("Illegal File Info Class");
    }
    
    public static Uri m(final K k, final String s) {
        if (!f.b0(k.d()) && !f.Q(k)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("not reachable root uri : ");
            sb.append((Object)k);
            ax.u3.b.g(sb.toString());
            return null;
        }
        final Uri n = n(k, s);
        if (n == null) {
            return null;
        }
        return c(n);
    }
    
    public static Uri n(final K k, String m) {
        if (!f.b0(k.d()) && !f.Q(k)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("not reachable root tree : ");
            sb.append((Object)k);
            ax.u3.b.g(sb.toString());
            return null;
        }
        if (m != null && f.Q(k)) {
            m = d0.m(m);
        }
        else {
            m = "";
        }
        final String z = j.F().Z(k);
        if (z == null) {
            return null;
        }
        final Uri$Builder appendPath = new Uri$Builder().scheme("content").authority("com.android.externalstorage.documents").appendPath("tree");
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(z);
        sb2.append(":");
        sb2.append(m);
        return appendPath.appendPath(sb2.toString()).build();
    }
    
    public static ParcelFileDescriptor o(final Context context, final Uri uri, final String s) throws ax.b3.j {
        try {
            return context.getContentResolver().openFileDescriptor(uri, s);
        }
        catch (final SecurityException | NullPointerException | SQLiteException | IllegalStateException ex) {
            throw new ax.b3.j((Throwable)ex);
        }
        catch (final IllegalArgumentException | FileNotFoundException ex2) {
            throw new t((Throwable)ex2);
        }
    }
    
    private static String p(final String s, String substring) {
        if (substring == null) {
            return null;
        }
        final int index = substring.indexOf(":");
        if (index < 0) {
            return null;
        }
        substring = substring.substring(index + 1);
        if (TextUtils.isEmpty((CharSequence)substring)) {
            return s;
        }
        return d0.Q(s, substring);
    }
    
    public static String q(final Context context, final K k, final Uri uri, final String s, final String s2, final l l) throws ax.b3.j {
        if (f.o0(k.d())) {
            return s(uri, s, s2, l);
        }
        return p(k.e(), s);
    }
    
    public static String r(final Uri uri) {
        try {
            final String g = v.g(uri);
            final String a = A(g);
            if ("primary".equals((Object)a)) {
                return p(K.e.e(), g);
            }
            if (j.F().t0()) {
                final K f = K.f;
                final String e = f.e();
                if (e != null) {
                    final String h = d0.h(e);
                    if (h != null && h.equals((Object)a)) {
                        return p(f.e(), g);
                    }
                }
            }
            return null;
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    private static String s(final Uri uri, final String s, final String s2, final l l) throws ax.b3.j {
        if (!Q.k1()) {
            ax.u3.b.f();
            throw new ax.b3.j("not reachable");
        }
        if (uri != null) {
            final String treeDocumentId = DocumentsContract.getTreeDocumentId(uri);
            if (treeDocumentId != null && treeDocumentId.equals((Object)s)) {
                return "/";
            }
        }
        else {
            ax.u3.b.f();
        }
        final String b = l.b;
        if (b != null) {
            return d0.Q(s2, b);
        }
        ax.u3.b.f();
        throw new ax.b3.j("No displayname");
    }
    
    public static InputStream t(final Context context, final n n, final long n2) throws ax.b3.j {
        try {
            final ParcelFileDescriptor$AutoCloseInputStream parcelFileDescriptor$AutoCloseInputStream = new ParcelFileDescriptor$AutoCloseInputStream(o(context, l(n), "r"));
            if (n2 != 0L) {
                final long skip = ((InputStream)parcelFileDescriptor$AutoCloseInputStream).skip(n2);
                if (skip != n2) {
                    final ax.Ha.b b = ax.Ha.c.h().b("Document file SKIP FAILED");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("offst:");
                    sb.append(n2);
                    sb.append(",skipped:");
                    sb.append(skip);
                    b.g((Object)sb.toString()).h();
                    throw new ax.b3.j("AutoCloseInputStream skip failed");
                }
            }
            return (InputStream)parcelFileDescriptor$AutoCloseInputStream;
        }
        catch (final IOException ex) {
            throw d.a("document getInputStream", (Exception)ex);
        }
        catch (final FileNotFoundException ex2) {
            throw new t((Throwable)ex2);
        }
    }
    
    public static OutputStream u(final e e, final n n, final boolean b) throws IOException, ax.b3.j {
        final Context p3 = ((m)e).p();
        final boolean n2 = ((ax.c3.b)n).n();
        Uri uri = null;
        final Uri uri2 = null;
        Uri uri3;
        Uri uri5;
        if (!n2) {
            uri3 = d(e, n, false);
            if (uri3 == null) {
                throw new IOException("Create Document File failed");
            }
            Uri l = uri2;
            if (f.b0(n.P())) {
                final Uri uri4 = l = l(n);
                if (!uri3.equals((Object)uri4)) {
                    l = uri4;
                    if (d0.M(n.B())) {
                        final String g = d0.g(d0.h(uri3.getPath()));
                        if (g != null && g.endsWith(")") && g.contains((CharSequence)"(")) {
                            l = uri4;
                        }
                        else {
                            final ax.Ha.b d = ax.Ha.c.h().f().d("UNEXPECTED DOCUMENT FILE NAME 2");
                            final StringBuilder sb = new StringBuilder();
                            sb.append("expected:");
                            sb.append((Object)uri4);
                            sb.append(",created:");
                            sb.append((Object)uri3);
                            d.g((Object)sb.toString()).h();
                            l = uri4;
                        }
                    }
                }
            }
            uri = uri3;
            uri5 = l;
        }
        else {
            uri3 = l(n);
            uri5 = null;
        }
        Label_0250: {
            if (!b) {
                break Label_0250;
            }
            try {
                final ParcelFileDescriptor parcelFileDescriptor = p3.getContentResolver().openFileDescriptor(uri3, "wa");
                return (OutputStream)new ParcelFileDescriptor$AutoCloseOutputStream(parcelFileDescriptor);
            }
            catch (final IllegalArgumentException ex) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("FILE:");
                sb2.append(((ax.c3.b)n).n());
                sb2.append(":");
                sb2.append(b);
                String s2;
                final String s = s2 = sb2.toString();
                if (uri != null) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(s);
                    sb3.append(",CREATED:");
                    sb3.append(uri.toString());
                    s2 = sb3.toString();
                }
                String string = s2;
                if (uri5 != null) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append(s2);
                    sb4.append(",EXPECTED:");
                    sb4.append(uri5.toString());
                    string = sb4.toString();
                }
                ax.Ha.c.h().f().b("GetOutputStreamForDocumentFile failed").l((Throwable)ex).g((Object)string).h();
                throw new IOException((Throwable)ex);
                final ParcelFileDescriptor parcelFileDescriptor = p3.getContentResolver().openFileDescriptor(uri3, "wt");
                return (OutputStream)new ParcelFileDescriptor$AutoCloseOutputStream(parcelFileDescriptor);
            }
            catch (final SecurityException ex2) {}
        }
    }
    
    public static Uri v(final n n) throws ax.b3.j {
        if (B.P(n)) {
            final com.alphainventor.filemanager.file.y y = (com.alphainventor.filemanager.file.y)n;
            return e(y.B0(), y.N0(), n.T());
        }
        if (B.J(n)) {
            return ((com.alphainventor.filemanager.file.i)n).o0();
        }
        ax.u3.b.f();
        throw new ax.b3.j("Illegal File Info Class");
    }
    
    public static ParcelFileDescriptor w(final Context context, final n n) throws ax.b3.j {
        return o(context, l(n), "rw");
    }
    
    public static String x(final Context context, final K k, final String s) {
        Label_0091: {
            SharedPreferences sharedPreferences;
            try {
                sharedPreferences = context.getSharedPreferences("pref_secondary", 0);
                if (k.d() == f.p0) {
                    final String string = sharedPreferences.getString("secondaryRootUri", (String)null);
                    if (string != null) {
                        return string;
                    }
                }
            }
            catch (final M m) {
                break Label_0091;
            }
            String s3;
            final String s2 = s3 = sharedPreferences.getString(y(k, s), (String)null);
            if (J.o() && (s3 = s2) != null) {
                s3 = s2;
                if (s2.startsWith("content://0@com.android.externalstorage.documents")) {
                    s3 = s2.replace((CharSequence)"0@com.android.externalstorage.documents", (CharSequence)"com.android.externalstorage.documents");
                }
            }
            return s3;
        }
        final M m;
        ((Throwable)m).printStackTrace();
        return null;
    }
    
    private static String y(final K k, String z) throws M {
        final f d = k.d();
        if (f.i0(d)) {
            if (z != null) {
                ax.u3.b.c(d == f.p0);
                final StringBuilder sb = new StringBuilder();
                sb.append("secondaryRootUri:");
                sb.append(k.e());
                sb.append(":");
                sb.append(z);
                return sb.toString();
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("secondaryRootUri:");
            sb2.append(k.e());
            return sb2.toString();
        }
        else if (d != f.o0 && d != f.s0) {
            if (f.c0(d)) {
                z = j.F().Z(k);
                if (z != null) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("documentRootUri:");
                    sb3.append(d.I());
                    sb3.append(":");
                    sb3.append(z);
                    return sb3.toString();
                }
                throw new M("uuid is null");
            }
            else {
                if (f.o0(d)) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("nonExternalRootUri:");
                    sb4.append(d.I());
                    sb4.append(":");
                    sb4.append(k.b());
                    return sb4.toString();
                }
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("not reachable:");
                sb5.append(d.I());
                ax.u3.b.g(sb5.toString());
                final StringBuilder sb6 = new StringBuilder();
                sb6.append("documentRootUri:");
                sb6.append(d.I());
                sb6.append(":");
                sb6.append(k.b());
                return sb6.toString();
            }
        }
        else {
            if (z == null) {
                ax.Ha.c.h().f().b("ROOT URI PREF NULL ROOT").j().h();
                throw new M("no rootTreePath");
            }
            final String z2 = j.F().Z(k);
            if (z2 != null) {
                final StringBuilder sb7 = new StringBuilder();
                sb7.append("primaryRootUri:");
                sb7.append(z2);
                sb7.append(":");
                sb7.append(z);
                return sb7.toString();
            }
            throw new M("uuid is null");
        }
    }
    
    public static String z(final String s) {
        if (s == null) {
            return null;
        }
        final int index = s.indexOf(":");
        if (index < 0) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(s.substring(index + 1));
        return sb.toString();
    }
}
