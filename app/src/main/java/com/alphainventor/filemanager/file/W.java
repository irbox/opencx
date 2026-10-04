package com.alphainventor.filemanager.file;

import java.util.AbstractCollection;
import android.app.ActivityManager;
import ax.r3.d;
import ax.c3.K;
import ax.c3.O;
import java.util.Stack;
import java.io.IOException;
import ax.Ha.b;
import java.util.Iterator;
import ax.X2.Q;
import android.net.Uri;
import java.io.Writer;
import java.util.Collections;
import java.util.Comparator;
import ax.Ha.c;
import ax.b3.j;
import ax.Z2.i;
import java.io.BufferedWriter;
import ax.Q2.e;
import java.util.Set;
import ax.c3.d0;
import ax.u3.q$f;
import java.io.File;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import ax.u3.q$e;
import android.content.Context;
import java.util.List;
import ax.Q2.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Logger;
import ax.u3.q;

public class w extends q<Void, Void, Boolean>
{
    private static final Logger o;
    private static HashSet<String> p;
    private static HashSet<String> q;
    private static HashSet<String> r;
    private static HashSet<String> s;
    static w t;
    static final Object u;
    private static int v;
    private HashMap<ax.Q2.f, f> h;
    private HashMap<String, Boolean> i;
    private final List<w.w$d> j;
    private Context k;
    private boolean l;
    private boolean m;
    private boolean n;
    
    static {
        o = Logger.getLogger("FileManager.LibraryScanTask");
        w.p = (HashSet<String>)new HashSet();
        w.q = (HashSet<String>)new HashSet();
        w.r = (HashSet<String>)new HashSet();
        w.s = (HashSet<String>)new HashSet();
        w.p.add((Object)"/Android/data/com.utorrent.client/files/Download");
        w.p.add((Object)"/Android/data/com.bittorrent.client/files/Download");
        w.p.add((Object)"/Android/data/com.android.chrome/files/Download");
        w.p.add((Object)"/Android/data/org.telegram.messenger/files/Telegram");
        w.q.add((Object)"mobiletmoney.txt");
        w.q.add((Object)"log.txt");
        w.q.add((Object)"log");
        w.r.add((Object)"/Android/media/com.google.android.gm/Notifications");
        w.r.add((Object)"/Android/media/com.google.android.talk/Notifications");
        w.r.add((Object)"/Android/media/com.google.android.talk/Ringtones");
        w.s.add((Object)"/Documents/Notebloc");
        u = new Object();
    }
    
    public w(final Context context, final boolean m) {
        super(q$e.g0);
        this.j = (List<w.w$d>)DesugarCollections.synchronizedList((List)new ArrayList());
        this.k = context.getApplicationContext();
        this.m = m;
    }
    
    private static void A(final File file) {
        if (file != null && file.exists()) {
            file.delete();
        }
    }
    
    public static w C(final Context context, final w.w$d w$d) {
        try {
            return D(context.getApplicationContext(), w$d, false);
        }
        catch (final IllegalStateException ex) {
            return null;
        }
    }
    
    private static w D(final Context context, final w.w$d w$d, final boolean b) {
        final Object u;
        monitorenter(u = w.u);
        Label_0037: {
            try {
                final w t = w.t;
                if (t != null && t.m() != q$f.d0) {
                    break Label_0037;
                }
                break Label_0037;
            }
            finally {
                monitorexit(u);
                while (true) {
                    while (true) {
                        final w t2 = w.t;
                        monitorexit(u);
                        return t2;
                        w.t.w(w$d);
                        continue;
                    }
                    w.o.fine("Execute scan task");
                    (w.t = new w(context, b)).i((Object[])new Void[0]);
                    iftrue(Label_0083:)(w$d == null);
                    continue;
                }
            }
        }
    }
    
    private boolean E(final n n) {
        return w.q.contains((Object)n.B().toLowerCase());
    }
    
    private boolean F(final n n) {
        final String lowerCase = n.B().toLowerCase();
        final String f = d0.f(lowerCase);
        return "log".equals((Object)f) || lowerCase.endsWith("_log.txt") || lowerCase.endsWith("_logs.txt") || (lowerCase.startsWith("filelog") && "txt".equals((Object)f)) || w.q.contains((Object)lowerCase);
    }
    
    public static Set<String> G() {
        return (Set<String>)w.r;
    }
    
    static File H(final Context context, final boolean b) {
        final File q = ax.Q2.e.q(context);
        if (q == null) {
            throw new IllegalStateException("Can not create index file");
        }
        if (b) {
            return new File(q.getAbsolutePath(), "scanfile.full");
        }
        return new File(q.getAbsolutePath(), "scanfile.fast");
    }
    
    static File I(final Context context) {
        final File q = ax.Q2.e.q(context);
        if (q != null) {
            return new File(q.getAbsolutePath(), "scanfile_new.full");
        }
        throw new IllegalStateException("Can not create index file");
    }
    
    static File J(final Context context, final boolean b) {
        final File q = ax.Q2.e.q(context);
        if (q == null) {
            throw new IllegalStateException("Can not create index file");
        }
        if (b) {
            return new File(q.getAbsolutePath(), "scanfile_sd.full");
        }
        return new File(q.getAbsolutePath(), "scanfile_sd.fast");
    }
    
    private void K(final c c, final n n, final BufferedWriter bufferedWriter, final i i) throws IOException {
        if (((y)n).x0()) {
            List t = null;
            Label_0050: {
                try {
                    t = this.T(c, n, true);
                    break Label_0050;
                }
                catch (final j j) {}
                catch (final OutOfMemoryError outOfMemoryError) {
                    c.h().f().d("SCAN: listFiles OUT OF MEMORY 2").h();
                }
                t = null;
            }
            if (t != null) {
                final ArrayList list = new ArrayList();
                final ArrayList list2 = new ArrayList();
                for (final n n2 : t) {
                    if (((ax.c3.b)n2).isDirectory()) {
                        if (d0.C(n2.B())) {
                            continue;
                        }
                        if (n.E().equals((Object)n2.E())) {
                            continue;
                        }
                        list.add((Object)n2);
                    }
                    else {
                        list2.add((Object)n2);
                    }
                }
                Collections.sort((List)list, (Comparator)new Comparator<n>(this) {
                    final w q;
                    
                    public int a(final n n, final n n2) {
                        return n.E().compareTo(n2.E());
                    }
                });
                this.e0(c, n, (List<n>)list2, (Writer)bufferedWriter);
                if (list.size() != 0) {
                    String s = i.c();
                    int k = 0;
                    while (k < list.size()) {
                        final n n3 = (n)list.get(k);
                        final String e = n3.E();
                        if (!J.j2(n3)) {
                            int compareTo;
                            String[] split;
                            String decode;
                            if (s == null) {
                                compareTo = -1;
                                split = null;
                                decode = null;
                            }
                            else {
                                split = s.split("\u0000");
                                decode = Uri.decode(split[0]);
                                compareTo = e.compareTo(decode);
                            }
                            if (compareTo == 0) {
                                if (Q.h1() && ((ax.c3.b)n3).q() == 0L) {
                                    ((y)n3).v1();
                                    ((ax.c3.b)n3).q();
                                }
                                if (Long.parseLong(split[1]) == ((ax.c3.b)n3).q()) {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append(s);
                                    sb.append("\n");
                                    ((Writer)bufferedWriter).write(sb.toString());
                                    this.X(c, decode, (y)n3, split);
                                    i.a();
                                    this.N(c, decode, bufferedWriter, i);
                                    s = i.c();
                                }
                                else {
                                    i.a();
                                    this.K(c, n3, bufferedWriter, i);
                                    s = i.c();
                                }
                            }
                            else {
                                if (compareTo >= 0) {
                                    i.a();
                                    s = i.c();
                                    continue;
                                }
                                this.M(c, n3, (Writer)bufferedWriter);
                            }
                        }
                        ++k;
                    }
                    this.z(n, i);
                    return;
                }
                if (!d0.B(n.E())) {
                    final b b = c.h().f().b("INVALID LIBRARYSCAN DIR ABSOULTE PATH");
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("dir:");
                    sb2.append(n.E());
                    b.g((Object)sb2.toString()).h();
                    return;
                }
                this.z(n, i);
            }
        }
    }
    
    private void L(final c c, final Stack<n> stack, final Writer writer) throws IOException {
        final n n = (n)stack.pop();
        if (c.b.contains((Object)n.E())) {
            goto Label_0267;
        }
        if (J.k2(n.B())) {
            goto Label_0267;
        }
        boolean b;
        if (writer != null) {
            b = true;
        }
        else {
            b = false;
        }
        try {
            this.T(c, n, b);
            goto Label_0097;
        }
        catch (final OutOfMemoryError outOfMemoryError) {
            c.h().f().d("SCAN: listFiles OUT OF MEMORY").h();
        }
        catch (final j j) {
            goto Label_0094;
        }
    }
    
    private void M(final c c, final n n, final Writer writer) throws IOException {
        final Stack stack = new Stack();
        stack.push((Object)n);
        while (!((AbstractCollection)stack).isEmpty()) {
            this.L(c, (Stack<n>)stack, writer);
        }
    }
    
    private void N(final c c, final String s, final BufferedWriter bufferedWriter, final i i) throws IOException {
        final Stack stack = new Stack();
        stack.push((Object)s);
        while (!((AbstractCollection)stack).isEmpty()) {
            this.O(c, (Stack<String>)stack, bufferedWriter, i);
        }
    }
    
    private void O(final c c, final Stack<String> stack, final BufferedWriter bufferedWriter, final i i) throws IOException {
        final String s = (String)stack.pop();
        while (true) {
            final String c2 = i.c();
            if (c2 == null) {
                break;
            }
            final String[] split = c2.split("\u0000");
            final String decode = Uri.decode(split[0]);
            if (!d0.B(decode)) {
                final b d = c.h().f().d("ISCD");
                final StringBuilder sb = new StringBuilder();
                sb.append(decode);
                sb.append(":");
                sb.append(c2.length());
                sb.append(":");
                sb.append(c2);
                d.g((Object)sb.toString()).h();
                i.a();
            }
            else {
                if (!d0.r(decode).equals((Object)s)) {
                    if (s != null) {
                        break;
                    }
                }
                Label_0277: {
                    y y;
                    try {
                        y = (y)c.d.z(decode);
                        if (y.q() == Long.parseLong(split[1])) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(c2);
                            sb2.append("\n");
                            ((Writer)bufferedWriter).write(sb2.toString());
                            this.X(c, decode, y, split);
                            i.a();
                            stack.push((Object)s);
                            stack.push((Object)decode);
                            break;
                        }
                    }
                    catch (final j j) {
                        break Label_0277;
                    }
                    i.a();
                    this.K(c, (n)y, bufferedWriter, i);
                    continue;
                }
                final j j;
                ((Throwable)j).printStackTrace();
            }
        }
    }
    
    private void P(final c p0, final n p1) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          8
        //     3: aload_2        
        //     4: invokeinterface ax/c3/b.isDirectory:()Z
        //     9: ifne            138
        //    12: new             Ljava/lang/StringBuilder;
        //    15: astore_3       
        //    16: aload_3        
        //    17: invokespecial   java/lang/StringBuilder.<init>:()V
        //    20: aload_3        
        //    21: ldc_w           "location:"
        //    24: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    27: pop            
        //    28: aload_3        
        //    29: aload_1        
        //    30: getfield        com/alphainventor/filemanager/file/w$c.c:Lax/c3/K;
        //    33: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    36: pop            
        //    37: aload_3        
        //    38: ldc_w           ","
        //    41: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    44: pop            
        //    45: aload_3        
        //    46: aload_2        
        //    47: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //    50: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    53: pop            
        //    54: aload_3        
        //    55: ldc_w           ","
        //    58: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    61: pop            
        //    62: aload_3        
        //    63: aload_1        
        //    64: getfield        com/alphainventor/filemanager/file/w$c.c:Lax/c3/K;
        //    67: invokevirtual   ax/c3/K.e:()Ljava/lang/String;
        //    70: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    73: pop            
        //    74: aload_3        
        //    75: ldc_w           ","
        //    78: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    81: pop            
        //    82: aload_3        
        //    83: aload_2        
        //    84: invokeinterface ax/c3/b.n:()Z
        //    89: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //    92: pop            
        //    93: aload_3        
        //    94: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    97: astore_3       
        //    98: aload_2        
        //    99: invokeinterface ax/c3/b.n:()Z
        //   104: ifeq            138
        //   107: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   110: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //   113: ldc_w           "SCAN ROOT IS NOT DIR"
        //   116: invokevirtual   ax/Ha/b.b:(Ljava/lang/String;)Lax/Ha/b;
        //   119: aload_3        
        //   120: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   123: invokevirtual   ax/Ha/b.h:()V
        //   126: goto            138
        //   129: astore_1       
        //   130: aconst_null    
        //   131: astore_2       
        //   132: aload           8
        //   134: astore_3       
        //   135: goto            457
        //   138: aload_1        
        //   139: getfield        com/alphainventor/filemanager/file/w$c.e:Ljava/io/File;
        //   142: astore          9
        //   144: new             Ljava/io/File;
        //   147: astore          10
        //   149: new             Ljava/lang/StringBuilder;
        //   152: astore_3       
        //   153: aload_3        
        //   154: invokespecial   java/lang/StringBuilder.<init>:()V
        //   157: aload_3        
        //   158: aload_1        
        //   159: getfield        com/alphainventor/filemanager/file/w$c.e:Ljava/io/File;
        //   162: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   165: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   168: pop            
        //   169: aload_3        
        //   170: ldc_w           ".tmp"
        //   173: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: pop            
        //   177: aload           10
        //   179: aload_3        
        //   180: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   183: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   186: aload           9
        //   188: invokevirtual   java/io/File.exists:()Z
        //   191: ifeq            219
        //   194: new             Ljava/io/BufferedReader;
        //   197: astore_3       
        //   198: new             Ljava/io/FileReader;
        //   201: astore          4
        //   203: aload           4
        //   205: aload           9
        //   207: invokespecial   java/io/FileReader.<init>:(Ljava/io/File;)V
        //   210: aload_3        
        //   211: aload           4
        //   213: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   216: goto            221
        //   219: aconst_null    
        //   220: astore_3       
        //   221: aload_3        
        //   222: astore          4
        //   224: new             Ljava/io/BufferedWriter;
        //   227: astore          6
        //   229: aload_3        
        //   230: astore          4
        //   232: new             Ljava/io/FileWriter;
        //   235: astore          5
        //   237: aload_3        
        //   238: astore          4
        //   240: aload           5
        //   242: aload           10
        //   244: invokespecial   java/io/FileWriter.<init>:(Ljava/io/File;)V
        //   247: aload_3        
        //   248: astore          4
        //   250: aload           6
        //   252: aload           5
        //   254: invokespecial   java/io/BufferedWriter.<init>:(Ljava/io/Writer;)V
        //   257: aload_3        
        //   258: ifnull          283
        //   261: aload_3        
        //   262: astore          4
        //   264: aload_3        
        //   265: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   268: astore          7
        //   270: goto            286
        //   273: astore_1       
        //   274: aload           6
        //   276: astore_2       
        //   277: aload           4
        //   279: astore_3       
        //   280: goto            457
        //   283: aconst_null    
        //   284: astore          7
        //   286: aload_3        
        //   287: astore          4
        //   289: aload_3        
        //   290: astore          5
        //   292: ldc_w           "6"
        //   295: aload           7
        //   297: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   300: ifne            338
        //   303: aload_3        
        //   304: astore          5
        //   306: aload_3        
        //   307: ifnull          338
        //   310: aload_3        
        //   311: astore          4
        //   313: aload_3        
        //   314: invokevirtual   java/io/BufferedReader.close:()V
        //   317: aload           9
        //   319: invokestatic    com/alphainventor/filemanager/file/w.A:(Ljava/io/File;)V
        //   322: aconst_null    
        //   323: astore          5
        //   325: goto            338
        //   328: astore_1       
        //   329: aload           8
        //   331: astore_3       
        //   332: aload           6
        //   334: astore_2       
        //   335: goto            457
        //   338: aload           5
        //   340: astore          4
        //   342: aload           6
        //   344: ldc_w           "6\n"
        //   347: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //   350: aload           5
        //   352: ifnull          365
        //   355: aload           5
        //   357: astore          4
        //   359: aload           5
        //   361: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   364: pop            
        //   365: aload           5
        //   367: astore          4
        //   369: new             Lax/Z2/i;
        //   372: astore_3       
        //   373: aload           5
        //   375: astore          4
        //   377: aload_3        
        //   378: aload           5
        //   380: invokespecial   ax/Z2/i.<init>:(Ljava/io/BufferedReader;)V
        //   383: aload           5
        //   385: astore          4
        //   387: aload_0        
        //   388: aload_1        
        //   389: aload_2        
        //   390: aload           6
        //   392: aload_3        
        //   393: invokespecial   com/alphainventor/filemanager/file/w.K:(Lcom/alphainventor/filemanager/file/w$c;Lcom/alphainventor/filemanager/file/n;Ljava/io/BufferedWriter;Lax/Z2/i;)V
        //   396: aload           5
        //   398: astore_1       
        //   399: aload           5
        //   401: ifnull          415
        //   404: aload           5
        //   406: astore          4
        //   408: aload           5
        //   410: invokevirtual   java/io/BufferedReader.close:()V
        //   413: aconst_null    
        //   414: astore_1       
        //   415: aload_1        
        //   416: astore          4
        //   418: aload           6
        //   420: invokevirtual   java/io/BufferedWriter.close:()V
        //   423: aload_1        
        //   424: astore          4
        //   426: aload           9
        //   428: invokestatic    com/alphainventor/filemanager/file/w.A:(Ljava/io/File;)V
        //   431: aload_1        
        //   432: astore          4
        //   434: aload           10
        //   436: aload           9
        //   438: invokevirtual   java/io/File.renameTo:(Ljava/io/File;)Z
        //   441: pop            
        //   442: aload_1        
        //   443: ifnull          450
        //   446: aload_1        
        //   447: invokevirtual   java/io/BufferedReader.close:()V
        //   450: return         
        //   451: astore_1       
        //   452: aconst_null    
        //   453: astore_2       
        //   454: goto            277
        //   457: aload_3        
        //   458: ifnull          465
        //   461: aload_3        
        //   462: invokevirtual   java/io/BufferedReader.close:()V
        //   465: aload_2        
        //   466: ifnull          473
        //   469: aload_2        
        //   470: invokevirtual   java/io/BufferedWriter.close:()V
        //   473: aload_1        
        //   474: athrow         
        //   475: astore_1       
        //   476: goto            450
        //   479: astore_2       
        //   480: goto            473
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      126    129    138    Any
        //  138    216    129    138    Any
        //  224    229    451    457    Any
        //  232    237    451    457    Any
        //  240    247    451    457    Any
        //  250    257    451    457    Any
        //  264    270    273    277    Any
        //  292    303    273    277    Any
        //  313    317    273    277    Any
        //  317    322    328    338    Any
        //  342    350    273    277    Any
        //  359    365    273    277    Any
        //  369    373    273    277    Any
        //  377    383    273    277    Any
        //  387    396    273    277    Any
        //  408    413    273    277    Any
        //  418    423    273    277    Any
        //  426    431    451    457    Any
        //  434    442    451    457    Any
        //  446    450    475    479    Ljava/io/IOException;
        //  461    465    479    483    Ljava/io/IOException;
        //  469    473    479    483    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0450:
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
    
    private boolean Q(final c c, final n n) {
        if (!c.h) {
            final String b = n.B();
            if (b.length() > 4 && (b.charAt(b.length() - 3) == '.' || b.charAt(b.length() - 4) == '.')) {
                return false;
            }
        }
        return ((ax.c3.b)n).isDirectory();
    }
    
    private boolean R(final Context context) {
        final File h = H(context, true);
        final File j = J(context, true);
        final boolean b = h.exists() && h.length() > 0L;
        final boolean b2 = j.exists() && j.length() > 0L;
        if (ax.Z2.j.F().t0()) {
            return b && b2;
        }
        return b;
    }
    
    public static boolean S(String q) {
        if (w.p.contains((Object)q)) {
            return true;
        }
        q = d0.q(q, 4);
        return w.p.contains((Object)q);
    }
    
    private List<n> T(final c c, final n n, final boolean b) throws j {
        final boolean h1 = Q.h1();
        int i = 0;
        boolean b2 = false;
        Label_0165: {
            if (h1 && b) {
                final String e = n.E();
                if (!c.a.equals((Object)e)) {
                    if (!c.f()) {
                        this.x(c, false);
                    }
                    final List<A> d = c.d(e);
                    if (d != null && d.size() > 0) {
                        if (w.s.contains((Object)n.W())) {
                            b2 = true;
                            break Label_0165;
                        }
                        final ArrayList list = new ArrayList();
                        final x x = (x)c.d.u();
                        while (i < d.size()) {
                            ((List)list).add((Object)x.A0(c.c, (A)d.get(i)));
                            ++i;
                        }
                        return (List<n>)list;
                    }
                }
            }
            b2 = false;
        }
        if (!((y)n).w0()) {
            return null;
        }
        if (!((ax.c3.b)n).isDirectory()) {
            return null;
        }
        final List<n> f0 = c.d.f0(n);
        if (b2 && f0 != null) {
            final HashSet set = new HashSet();
            List<A> d2 = c.d(n.E());
            if (d2 != null) {
                final Iterator iterator = d2.iterator();
                while (iterator.hasNext()) {
                    set.add((Object)((A)iterator.next()).a);
                }
            }
            final ArrayList list2 = new ArrayList();
            final long c2 = O.c();
            final Iterator iterator2 = f0.iterator();
            int n2 = 5000;
            while (iterator2.hasNext()) {
                final n n3 = (n)iterator2.next();
                if (!((ax.c3.b)n3).h() && !((ax.c3.b)n3).isDirectory() && !set.contains((Object)n3.E())) {
                    final A a = new A(n3.E(), ((ax.c3.b)n3).isDirectory(), ((ax.c3.b)n3).q(), (Long)null, ((ax.c3.b)n3).q(), ((ax.c3.b)n3).p());
                    Object o;
                    if ((o = d2) == null) {
                        o = new ArrayList();
                        c.h(n.E(), (List<A>)o);
                    }
                    ((List)o).add((Object)a);
                    if (((ax.c3.b)n3).q() >= c2) {
                        c.a(n3);
                    }
                    d2 = (List<A>)o;
                    if (n2 >= 196608) {
                        continue;
                    }
                    final ax.o3.f f2 = new ax.o3.f(n3.E(), n3.P().K(), n3.L(), ((ax.c3.b)n3).q(), false, false, false, false, false, false);
                    list2.add((Object)f2);
                    n2 += f2.a();
                    d2 = (List<A>)o;
                }
            }
            if (!list2.isEmpty()) {
                x.O1(this.k, list2, false, n2);
            }
        }
        return f0;
    }
    
    public static void W(final Context context) {
        try {
            A(H(context, false));
            A(H(context, true));
            A(J(context, false));
            A(J(context, true));
            A(I(context));
        }
        catch (final IllegalStateException ex) {}
    }
    
    private void X(final c c, final String s, final y c2, final String[] array) {
        Boolean value = null;
        for (int i = 2; i < array.length; ++i) {
            final String s2 = array[i];
            final String[] split = s2.split("/");
            if (i == 2 && split.length < 2) {
                if (!"true".equalsIgnoreCase(s2) && !"false".equalsIgnoreCase(s2)) {
                    if ("null".equalsIgnoreCase(s2)) {
                        value = null;
                    }
                }
                else {
                    value = Boolean.valueOf(s2);
                }
            }
            else if (i == 3 && split.length < 2) {
                if (!"true".equalsIgnoreCase(s2) && !"false".equalsIgnoreCase(s2)) {
                    "null".equalsIgnoreCase(s2);
                }
                else {
                    this.i.put((Object)s, (Object)Boolean.valueOf(s2));
                }
            }
            else {
                final f f = (f)this.h.get((Object)ax.Q2.f.valueOf(split[0]));
                if (f == null) {
                    final b b = c.h().f().b("NULL SCANINFO");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("loc:");
                    sb.append(s2);
                    b.g((Object)sb.toString()).h();
                }
                else {
                    final e e = new e();
                    e.f = Integer.valueOf(split[1]);
                    e.e = Long.valueOf(split[2]);
                    e.g = Long.valueOf(split[3]);
                    e.h = Uri.decode(split[4]);
                    e.b = false;
                    e.a = c.c;
                    e.c = c2;
                    e.d = value;
                    f.a.put((Object)((n)c2).E(), (Object)e);
                }
            }
        }
    }
    
    private void Y(final String s, final boolean b, final ArrayList<n> list) {
        final c c = new c(K.e, s, H(this.k, b), b);
        final Set<String> b2 = c.b;
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("/Android/data");
        b2.add((Object)sb.toString());
        final Set<String> b3 = c.b;
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append("/.localcache");
        b3.add((Object)sb2.toString());
        final Set<String> b4 = c.b;
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(s);
        sb3.append("/Android/media/com.cxinventor.file.explorer/.localcache");
        b4.add((Object)sb3.toString());
        try {
            this.b0(c, c.d.z(c.a), list);
        }
        catch (final j j) {
            ax.u3.b.f();
        }
    }
    
    private void Z(final HashMap<String, v> hashMap, final List<n> list) {
        final File i = I(this.k);
        final o d = ax.c3.x.d(ax.Q2.f.F0, 0);
        d.n0();
        final O o = new O((B)d.u());
        Label_0105: {
            try {
                o.a(i, (HashMap)hashMap, (List)list);
                break Label_0105;
            }
            catch (final Exception ex) {
                ((Throwable)ex).printStackTrace();
                ax.Ha.c.h().d("NEWSCAN1:").l((Throwable)ex).h();
            }
            catch (final IOException ex2) {
                ((Throwable)ex2).printStackTrace();
            }
            try {
                A(i);
                o.a(i, (HashMap)hashMap, (List)list);
            }
            catch (final Exception ex3) {
                ((Throwable)ex3).printStackTrace();
            }
        }
        d.k0(false);
    }
    
    private void a0(final String s, final boolean b, final ArrayList<n> list) {
        final c c = new c(K.f, s, J(this.k, b), b);
        final Set<String> b2 = c.b;
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("/Android/data");
        b2.add((Object)sb.toString());
        try {
            this.b0(c, c.d.z(c.a), list);
        }
        catch (final j j) {
            ax.u3.b.f();
        }
    }
    
    private void b0(final c p0, final n p1, final ArrayList<n> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: aload_2        
        //     3: invokespecial   com/alphainventor/filemanager/file/w.P:(Lcom/alphainventor/filemanager/file/w$c;Lcom/alphainventor/filemanager/file/n;)V
        //     6: invokestatic    ax/X2/Q.L:()Z
        //     9: ifeq            59
        //    12: aload_1        
        //    13: getfield        com/alphainventor/filemanager/file/w$c.c:Lax/c3/K;
        //    16: getstatic       ax/c3/K.f:Lax/c3/K;
        //    19: if_acmpne       59
        //    22: goto            65
        //    25: astore_2       
        //    26: goto            715
        //    29: astore          4
        //    31: goto            78
        //    34: astore          4
        //    36: goto            157
        //    39: astore          4
        //    41: goto            232
        //    44: astore          4
        //    46: goto            307
        //    49: astore          4
        //    51: goto            416
        //    54: astore          4
        //    56: goto            491
        //    59: aload_0        
        //    60: aload_1        
        //    61: aload_2        
        //    62: invokespecial   com/alphainventor/filemanager/file/w.d0:(Lcom/alphainventor/filemanager/file/w$c;Lcom/alphainventor/filemanager/file/n;)V
        //    65: invokestatic    ax/X2/Q.h1:()Z
        //    68: ifeq            658
        //    71: aload_1        
        //    72: invokevirtual   com/alphainventor/filemanager/file/w$c.c:()V
        //    75: goto            658
        //    78: aload           4
        //    80: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //    83: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //    86: ldc_w           "LST4"
        //    89: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //    92: aload           4
        //    94: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //    97: astore          4
        //    99: new             Ljava/lang/StringBuilder;
        //   102: astore          5
        //   104: aload           5
        //   106: invokespecial   java/lang/StringBuilder.<init>:()V
        //   109: aload           5
        //   111: ldc_w           "location:"
        //   114: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   117: pop            
        //   118: aload           5
        //   120: aload_1        
        //   121: getfield        com/alphainventor/filemanager/file/w$c.c:Lax/c3/K;
        //   124: invokevirtual   ax/c3/K.toString:()Ljava/lang/String;
        //   127: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   130: pop            
        //   131: aload           4
        //   133: aload           5
        //   135: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   138: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   141: invokevirtual   ax/Ha/b.h:()V
        //   144: invokestatic    ax/X2/Q.h1:()Z
        //   147: ifeq            505
        //   150: aload_1        
        //   151: invokevirtual   com/alphainventor/filemanager/file/w$c.c:()V
        //   154: goto            505
        //   157: aload           4
        //   159: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   162: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   165: ldc_w           "SCANSTACK!!!"
        //   168: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   171: aload           4
        //   173: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   176: astore          5
        //   178: new             Ljava/lang/StringBuilder;
        //   181: astore          4
        //   183: aload           4
        //   185: invokespecial   java/lang/StringBuilder.<init>:()V
        //   188: aload           4
        //   190: ldc_w           "location:"
        //   193: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   196: pop            
        //   197: aload           4
        //   199: aload_1        
        //   200: getfield        com/alphainventor/filemanager/file/w$c.c:Lax/c3/K;
        //   203: invokevirtual   ax/c3/K.toString:()Ljava/lang/String;
        //   206: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   209: pop            
        //   210: aload           5
        //   212: aload           4
        //   214: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   217: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   220: invokevirtual   ax/Ha/b.h:()V
        //   223: invokestatic    ax/X2/Q.h1:()Z
        //   226: ifeq            505
        //   229: goto            150
        //   232: aload           4
        //   234: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   237: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   240: ldc_w           "LST3"
        //   243: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   246: aload           4
        //   248: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   251: astore          5
        //   253: new             Ljava/lang/StringBuilder;
        //   256: astore          4
        //   258: aload           4
        //   260: invokespecial   java/lang/StringBuilder.<init>:()V
        //   263: aload           4
        //   265: ldc_w           "location:"
        //   268: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   271: pop            
        //   272: aload           4
        //   274: aload_1        
        //   275: getfield        com/alphainventor/filemanager/file/w$c.c:Lax/c3/K;
        //   278: invokevirtual   ax/c3/K.toString:()Ljava/lang/String;
        //   281: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   284: pop            
        //   285: aload           5
        //   287: aload           4
        //   289: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   292: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   295: invokevirtual   ax/Ha/b.h:()V
        //   298: invokestatic    ax/X2/Q.h1:()Z
        //   301: ifeq            505
        //   304: goto            150
        //   307: aload           4
        //   309: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   312: aload           4
        //   314: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   317: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   320: ifeq            387
        //   323: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   326: ldc_w           "LST2:"
        //   329: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   332: aload           4
        //   334: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   337: astore          5
        //   339: new             Ljava/lang/StringBuilder;
        //   342: astore          4
        //   344: aload           4
        //   346: invokespecial   java/lang/StringBuilder.<init>:()V
        //   349: aload           4
        //   351: ldc_w           "location:"
        //   354: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   357: pop            
        //   358: aload           4
        //   360: aload_1        
        //   361: getfield        com/alphainventor/filemanager/file/w$c.c:Lax/c3/K;
        //   364: invokevirtual   ax/c3/K.toString:()Ljava/lang/String;
        //   367: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   370: pop            
        //   371: aload           5
        //   373: aload           4
        //   375: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   378: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   381: invokevirtual   ax/Ha/b.h:()V
        //   384: goto            407
        //   387: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   390: ldc_w           "LST2-2"
        //   393: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   396: aload           4
        //   398: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   401: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   404: invokevirtual   ax/Ha/b.h:()V
        //   407: invokestatic    ax/X2/Q.h1:()Z
        //   410: ifeq            505
        //   413: goto            150
        //   416: aload           4
        //   418: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   421: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   424: ldc_w           "LST1:"
        //   427: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   430: aload           4
        //   432: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   435: astore          5
        //   437: new             Ljava/lang/StringBuilder;
        //   440: astore          4
        //   442: aload           4
        //   444: invokespecial   java/lang/StringBuilder.<init>:()V
        //   447: aload           4
        //   449: ldc_w           "location:"
        //   452: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   455: pop            
        //   456: aload           4
        //   458: aload_1        
        //   459: getfield        com/alphainventor/filemanager/file/w$c.c:Lax/c3/K;
        //   462: invokevirtual   ax/c3/K.toString:()Ljava/lang/String;
        //   465: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   468: pop            
        //   469: aload           5
        //   471: aload           4
        //   473: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   476: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   479: invokevirtual   ax/Ha/b.h:()V
        //   482: invokestatic    ax/X2/Q.h1:()Z
        //   485: ifeq            505
        //   488: goto            150
        //   491: aload           4
        //   493: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   496: invokestatic    ax/X2/Q.h1:()Z
        //   499: ifeq            505
        //   502: goto            150
        //   505: getstatic       com/alphainventor/filemanager/file/w.o:Ljava/util/logging/Logger;
        //   508: ldc_w           "Retry Incremental Scan."
        //   511: invokevirtual   java/util/logging/Logger.severe:(Ljava/lang/String;)V
        //   514: aload_1        
        //   515: invokevirtual   com/alphainventor/filemanager/file/w$c.b:()V
        //   518: aload_1        
        //   519: getfield        com/alphainventor/filemanager/file/w$c.e:Ljava/io/File;
        //   522: invokestatic    com/alphainventor/filemanager/file/w.A:(Ljava/io/File;)V
        //   525: aload_0        
        //   526: aload_1        
        //   527: aload_2        
        //   528: invokespecial   com/alphainventor/filemanager/file/w.P:(Lcom/alphainventor/filemanager/file/w$c;Lcom/alphainventor/filemanager/file/n;)V
        //   531: invokestatic    ax/X2/Q.h1:()Z
        //   534: ifeq            658
        //   537: aload_1        
        //   538: invokevirtual   com/alphainventor/filemanager/file/w$c.c:()V
        //   541: goto            658
        //   544: astore_2       
        //   545: goto            703
        //   548: astore_2       
        //   549: goto            556
        //   552: astore_2       
        //   553: goto            636
        //   556: aload_2        
        //   557: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   560: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //   563: ldc_w           "OOB2"
        //   566: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
        //   569: aload_2        
        //   570: invokevirtual   ax/Ha/b.l:(Ljava/lang/Throwable;)Lax/Ha/b;
        //   573: astore_2       
        //   574: new             Ljava/lang/StringBuilder;
        //   577: astore          4
        //   579: aload           4
        //   581: invokespecial   java/lang/StringBuilder.<init>:()V
        //   584: aload           4
        //   586: ldc_w           "location:"
        //   589: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   592: pop            
        //   593: aload           4
        //   595: aload_1        
        //   596: getfield        com/alphainventor/filemanager/file/w$c.c:Lax/c3/K;
        //   599: invokevirtual   ax/c3/K.toString:()Ljava/lang/String;
        //   602: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   605: pop            
        //   606: aload_2        
        //   607: aload           4
        //   609: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   612: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   615: invokevirtual   ax/Ha/b.h:()V
        //   618: getstatic       com/alphainventor/filemanager/file/w.o:Ljava/util/logging/Logger;
        //   621: ldc_w           "Incremental Scan Failed."
        //   624: invokevirtual   java/util/logging/Logger.severe:(Ljava/lang/String;)V
        //   627: invokestatic    ax/X2/Q.h1:()Z
        //   630: ifeq            658
        //   633: goto            537
        //   636: aload_2        
        //   637: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   640: getstatic       com/alphainventor/filemanager/file/w.o:Ljava/util/logging/Logger;
        //   643: ldc_w           "Incremental Scan Failed."
        //   646: invokevirtual   java/util/logging/Logger.severe:(Ljava/lang/String;)V
        //   649: invokestatic    ax/X2/Q.h1:()Z
        //   652: ifeq            658
        //   655: goto            537
        //   658: invokestatic    ax/X2/Q.h1:()Z
        //   661: ifeq            702
        //   664: aload_1        
        //   665: invokevirtual   com/alphainventor/filemanager/file/w$c.g:()Z
        //   668: ifne            677
        //   671: aload_0        
        //   672: aload_1        
        //   673: iconst_1       
        //   674: invokespecial   com/alphainventor/filemanager/file/w.x:(Lcom/alphainventor/filemanager/file/w$c;Z)V
        //   677: aload_1        
        //   678: getfield        com/alphainventor/filemanager/file/w$c.g:Ljava/util/ArrayList;
        //   681: astore_2       
        //   682: aload_2        
        //   683: ifnull          695
        //   686: aload_3        
        //   687: aload_2        
        //   688: invokevirtual   java/util/ArrayList.addAll:(Ljava/util/Collection;)Z
        //   691: pop            
        //   692: goto            698
        //   695: invokestatic    ax/u3/b.f:()V
        //   698: aload_1        
        //   699: invokevirtual   com/alphainventor/filemanager/file/w$c.b:()V
        //   702: return         
        //   703: invokestatic    ax/X2/Q.h1:()Z
        //   706: ifeq            713
        //   709: aload_1        
        //   710: invokevirtual   com/alphainventor/filemanager/file/w$c.c:()V
        //   713: aload_2        
        //   714: athrow         
        //   715: invokestatic    ax/X2/Q.h1:()Z
        //   718: ifeq            725
        //   721: aload_1        
        //   722: invokevirtual   com/alphainventor/filemanager/file/w$c.c:()V
        //   725: aload_2        
        //   726: athrow         
        //    Signature:
        //  (Lcom/alphainventor/filemanager/file/w$c;Lcom/alphainventor/filemanager/file/n;Ljava/util/ArrayList<Lcom/alphainventor/filemanager/file/n;>;)V
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                 
        //  -----  -----  -----  -----  -------------------------------------
        //  0      22     54     505    Ljava/io/IOException;
        //  0      22     49     491    Ljava/lang/IndexOutOfBoundsException;
        //  0      22     44     416    Ljava/lang/IllegalStateException;
        //  0      22     39     307    Ljava/lang/NumberFormatException;
        //  0      22     34     232    Ljava/lang/StackOverflowError;
        //  0      22     29     150    Ljava/lang/IllegalArgumentException;
        //  0      22     25     727    Any
        //  59     65     54     505    Ljava/io/IOException;
        //  59     65     49     491    Ljava/lang/IndexOutOfBoundsException;
        //  59     65     44     416    Ljava/lang/IllegalStateException;
        //  59     65     39     307    Ljava/lang/NumberFormatException;
        //  59     65     34     232    Ljava/lang/StackOverflowError;
        //  59     65     29     150    Ljava/lang/IllegalArgumentException;
        //  59     65     25     727    Any
        //  78     144    25     727    Any
        //  157    223    25     727    Any
        //  232    298    25     727    Any
        //  307    384    25     727    Any
        //  387    407    25     727    Any
        //  416    482    25     727    Any
        //  491    496    25     727    Any
        //  514    531    552    658    Ljava/io/IOException;
        //  514    531    548    636    Ljava/lang/IndexOutOfBoundsException;
        //  514    531    544    715    Any
        //  556    627    544    715    Any
        //  636    649    544    715    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0537:
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
    
    private void c0(final K k, final f f, final HashMap<String, v> hashMap, final HashMap<String, y.b> hashMap2, final HashMap<String, Set<String>> hashMap3) {
        final o e = ax.c3.x.e(k);
        e.n0();
        ArrayList list;
        ArrayList list2;
        u u = null;
        int size;
        int n;
        Object value = null;
        Object o;
        u u2;
        Object o2;
        y y;
        File file;
        Object o3;
        K i;
        boolean b;
        y y2;
        v v;
        Object o4;
        y y3;
        boolean b2;
        Object o5;
        long n2;
        long n4;
        long n3;
        long n5;
        long n6;
        v v2;
        long n7;
        v v3;
        Object o6;
        String s;
        v v4;
        final j j;
        n n8;
        String h;
        final n n9;
        Label_0267:Label_0189_Outer:
        while (true) {
        Label_0189:
            while (true) {
            Label_0366_Outer:
                while (true) {
                    Label_0392: {
                        try {
                            e.z(k.e());
                            list = new ArrayList();
                            list2 = new ArrayList(f.a.values());
                            u = (u)e.u();
                            ax.Z2.b.k().a(((List)list2).size());
                            size = list2.size();
                            n = 0;
                            if (n >= size) {
                                break Label_0392;
                            }
                            value = list2.get(n);
                            ++n;
                            o = value;
                            value = o;
                            u2 = u;
                            o2 = value;
                            y = ((e)o2).c;
                            file = y.F0();
                            o3 = value;
                            i = ((e)o3).a;
                            b = false;
                            y2 = u2.z0(file, i, b);
                            v = (v)y2;
                            o4 = value;
                            y3 = ((e)o4).c;
                            b2 = y3.isDirectory();
                            if (!b2) {
                                break Label_0267;
                            }
                            o5 = value;
                            n2 = ((e)o5).g;
                            n3 = (n4 = n2);
                            n5 = 0L;
                            n6 = lcmp(n4, n5);
                            if (n6 != 0) {
                                v2 = v;
                                n7 = n3;
                                v2.H1(n7);
                                v3 = v;
                                o6 = value;
                                s = ((e)o6).h;
                                v3.I1(s);
                                v4 = v;
                                ((y)v4).v1();
                            }
                            break Label_0189;
                        }
                        catch (j t) {
                            t = (Throwable)j;
                            t.printStackTrace();
                            e.k0(false);
                            return;
                            while (true) {
                                Label_0348: {
                                    Label_0389: {
                                        while (true) {
                                            ((List)list).add((Object)v);
                                            break Label_0389;
                                            ((y)v).r1();
                                            iftrue(Label_0389:)(!((y)v).n());
                                            continue Label_0366_Outer;
                                        }
                                        ((n)v).d0(((e)value).f);
                                        ((y)v).k1(com.alphainventor.filemanager.file.v.E1(v, (e)value, (Boolean)this.i.get((Object)((n)((e)value).c).T()), (HashMap)hashMap2, (HashMap)hashMap3));
                                        iftrue(Label_0267:)(!((e)value).b);
                                        Block_8: {
                                            break Block_8;
                                            ax.Z2.b.k().m(n8, (List)list);
                                            ((List)list2).clear();
                                            e.k0(false);
                                            return;
                                            Label_0334: {
                                                f.e += ((e)value).e;
                                            }
                                            break Label_0348;
                                        }
                                        h = e.H((n)v);
                                        iftrue(Label_0267:)(h == null);
                                        d.B(this.k, h);
                                        iftrue(Label_0366:)(((y)v).h());
                                        f.b += ((e)value).e;
                                        f.c += ((e)value).f;
                                        iftrue(Label_0334:)(!K.e.equals((Object)((y)v).B0()));
                                        f.d += ((e)value).e;
                                        break Label_0348;
                                    }
                                    continue Label_0189_Outer;
                                }
                                hashMap.put((Object)((n)((e)value).c).E(), (Object)v);
                                continue;
                            }
                        }
                        finally {
                            n8 = n9;
                            break Label_0267;
                        }
                    }
                    break;
                }
                try {
                    o = value;
                    value = o;
                    u2 = u;
                    o2 = value;
                    y = ((e)o2).c;
                    file = y.F0();
                    o3 = value;
                    i = ((e)o3).a;
                    b = false;
                    y2 = u2.z0(file, i, b);
                    v = (v)y2;
                    o4 = value;
                    y3 = ((e)o4).c;
                    b2 = y3.isDirectory();
                    if (!b2) {
                        continue Label_0267;
                    }
                    o5 = value;
                    n2 = ((e)o5).g;
                    n3 = (n4 = n2);
                    n5 = 0L;
                    n6 = lcmp(n4, n5);
                    if (n6 != 0) {
                        v2 = v;
                        n7 = n3;
                        v2.H1(n7);
                        v3 = v;
                        o6 = value;
                        s = ((e)o6).h;
                        v3.I1(s);
                        v4 = v;
                        ((y)v4).v1();
                        continue Label_0189;
                    }
                    continue Label_0189;
                }
                catch (final j j) {}
                break;
            }
            break;
        }
        e.k0(false);
    }
    
    private void d0(final c c, final n n) {
        for (final String s : w.p) {
            Label_0085: {
                n z;
                try {
                    z = c.d.z(d0.P(n.E(), s));
                    if (((ax.c3.b)z).n()) {
                        final w w = this;
                        final c c2 = c;
                        final n n2 = z;
                        final Writer writer = null;
                        w.M(c2, n2, writer);
                        continue;
                    }
                    continue;
                }
                catch (final j j) {
                    break Label_0085;
                }
                try {
                    final w w = this;
                    final c c2 = c;
                    final n n2 = z;
                    final Writer writer = null;
                    w.M(c2, n2, writer);
                    continue;
                }
                catch (final IOException ex) {
                    continue;
                }
            }
            final j j;
            ((Throwable)j).printStackTrace();
            ax.u3.b.e("whiltelist scan failed");
        }
    }
    
    private void e0(final c c, final n n, List<n> true, final Writer writer) throws IOException {
        final HashMap hashMap = new HashMap();
        final Iterator iterator = ((List)true).iterator();
        true = null;
        Boolean true2 = null;
        while (iterator.hasNext()) {
            final n n2 = (n)iterator.next();
            final String b = n2.B();
            final ax.Q2.f l = ax.c3.A.l(ax.c3.A.g(d0.f(b)));
            if (l == ax.Q2.f.C0) {
                if (this.F(n2)) {
                    continue;
                }
                if (this.E(n)) {
                    continue;
                }
            }
            if (l != null) {
                e e;
                if (!hashMap.containsKey((Object)l)) {
                    e = new e();
                    hashMap.put((Object)l, (Object)e);
                    e.c = (y)n;
                    e.a = c.c;
                }
                else {
                    e = (e)hashMap.get((Object)l);
                }
                try {
                    e.e += ((ax.c3.b)n2).p();
                    ++e.f;
                    final long q = ((ax.c3.b)n2).q();
                    if (e.g >= q || ((ax.c3.b)n2).h()) {
                        continue;
                    }
                    e.g = q;
                    e.h = n2.B();
                }
                catch (final IllegalArgumentException ex) {}
            }
            else if (".nomedia".equals((Object)b)) {
                true = Boolean.TRUE;
            }
            else {
                if (!".hidden".equals((Object)b)) {
                    continue;
                }
                true2 = Boolean.TRUE;
            }
        }
        Boolean d;
        Boolean false;
        if (Q.h1()) {
            Boolean value = true;
            try {
                final String q2 = d0.Q(n.E(), ".nomedia");
                value = true;
                final Boolean b2 = value = ((y)c.d.z(q2)).x0();
                final String q3 = d0.Q(n.E(), ".hidden");
                value = b2;
                final Boolean value2 = ((y)c.d.z(q3)).x0();
                d = b2;
                false = value2;
            }
            catch (final j j) {
                ((Throwable)j).printStackTrace();
                ax.u3.b.f();
                d = value;
                false = true2;
            }
        }
        else {
            Boolean false2;
            if ((false2 = true) == null) {
                false2 = Boolean.FALSE;
            }
            d = false2;
            if ((false = true2) == null) {
                false = Boolean.FALSE;
                d = false2;
            }
        }
        if (false != null) {
            this.i.put((Object)n.E(), (Object)false);
        }
        final StringBuffer sb = new StringBuffer();
        sb.append(Uri.encode(n.E()));
        sb.append("\u0000");
        sb.append(String.valueOf(((ax.c3.b)n).q()));
        sb.append("\u0000");
        if (d == null) {
            sb.append("null");
        }
        else {
            sb.append(String.valueOf((Object)d));
        }
        sb.append("\u0000");
        if (false == null) {
            sb.append("null");
        }
        else {
            sb.append(String.valueOf((Object)false));
        }
        for (final ax.Q2.f f : hashMap.keySet()) {
            final e e2 = (e)hashMap.get((Object)f);
            sb.append("\u0000");
            sb.append(((Enum)f).name());
            sb.append("/");
            sb.append(e2.f);
            sb.append("/");
            sb.append(e2.e);
            sb.append("/");
            sb.append(e2.g);
            sb.append("/");
            sb.append(Uri.encode(e2.h));
            e2.b = true;
            ((f)this.h.get((Object)f)).a.put((Object)n.E(), (Object)e2);
            e2.d = d;
        }
        sb.append("\n");
        if (writer != null) {
            writer.write(sb.toString());
        }
    }
    
    private void x(final c c, final boolean b) {
        System.currentTimeMillis();
        final c c3;
        Label_0333: {
            long c2 = 0L;
            x x = null;
            y y = null;
            Label_0173: {
                String v;
                try {
                    c.e();
                    c2 = O.c();
                    v = c.d.V();
                    x = (x)c.d.u();
                    y = (y)x.z(v);
                    if (y.isDirectory()) {
                        break Label_0173;
                    }
                    if (Q.z0() && !ax.u3.o.c()) {
                        return;
                    }
                }
                catch (final RuntimeException ex) {
                    break Label_0333;
                }
                finally {
                    throw c3;
                }
                if (!"/sdcard".equals((Object)v) && !"/storage/emulated/0".equals((Object)v)) {
                    final b b2 = c.h().f().b("LIBRARY ROOT IS NOT DIRECTORY");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("rootPath: ");
                    sb.append(v);
                    sb.append(",");
                    sb.append((Object)c3.c);
                    b2.g((Object)sb.toString()).h();
                    return;
                }
            }
            long n;
            if (b) {
                n = c2;
            }
            else {
                n = 0L;
            }
            final List q1 = x.q1((n)y, true, n, 0L);
            if (q1 != null) {
                for (int i = 0; i < q1.size(); ++i) {
                    final A a = (A)q1.get(i);
                    if (!b) {
                        final String r = d0.r(a.a);
                        if (d0.B(r)) {
                            Object d;
                            if ((d = c3.d(r)) == null) {
                                d = new ArrayList();
                                c3.h(r, (List<A>)d);
                            }
                            ((List)d).add((Object)a);
                        }
                    }
                    if (a.c >= c2) {
                        c3.a((n)x.A0(y.B0(), a));
                    }
                }
                return;
            }
            return;
        }
        ((Throwable)c3).printStackTrace();
        ax.u3.b.e("build media store cache");
    }
    
    private static void y(final w w) {
        final Object u;
        monitorenter(u = w.u);
        Label_0026: {
            try {
                if (w == w.t) {
                    w.t = null;
                }
                break Label_0026;
            }
            finally {
                monitorexit(u);
                monitorexit(u);
            }
        }
    }
    
    private void z(final n n, final i i) throws IOException {
        while (true) {
            final String c = i.c();
            if (c == null) {
                break;
            }
            final String decode = Uri.decode(c.split("\u0000")[0]);
            if (d0.B(decode) && !d0.I(n.E(), decode)) {
                break;
            }
            i.a();
        }
    }
    
    protected Boolean B(Void... ex) {
        long currentTimeMillis = 0L;
        HashMap hashMap = null;
        Label_0430: {
            try {
                Label_0062: {
                    if (!this.m) {
                        try {
                            if (!this.R(this.k)) {
                                w.o.fine("Fast scan start");
                                this.l = false;
                                break Label_0062;
                            }
                        }
                        catch (final IllegalArgumentException ex2) {}
                        catch (final IllegalStateException ex) {
                            goto Label_0041;
                        }
                    }
                    w.o.fine("Full scan start");
                    this.l = true;
                }
                if (!(this.n = ax.u3.o.e(this.k))) {
                    ex = (IllegalStateException)Boolean.FALSE;
                    return (Boolean)ex;
                }
                if (Q.d1() && w.v == 0) {
                    w.v = ((ActivityManager)this.k.getApplicationContext().getSystemService("activity")).getMemoryClass();
                    ax.Z2.b.k().x(w.v);
                }
                ex = (IllegalStateException)new ArrayList();
                currentTimeMillis = System.currentTimeMillis();
                final String o = ax.Z2.j.F().O();
                final String t = ax.Z2.j.F().T();
                this.Y(o, this.l, (ArrayList<n>)ex);
                final Logger o2 = w.o;
                final StringBuilder sb = new StringBuilder();
                sb.append("scan time main : ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                o2.fine(sb.toString());
                if (ax.Z2.j.F().t0() && t != null && !t.startsWith(o)) {
                    this.a0(t, this.l, (ArrayList<n>)ex);
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("scan time sd : ");
                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                    o2.fine(sb2.toString());
                }
                hashMap = new HashMap();
                final HashMap hashMap2 = new HashMap();
                final HashMap hashMap3 = new HashMap();
                for (final K k : K.c()) {
                    if (this.isCancelled()) {
                        return Boolean.FALSE;
                    }
                    final f f = (f)this.h.get((Object)k.d());
                    final HashMap<String, e> a = f.a;
                    try {
                        this.c0(k, f, (HashMap<String, v>)hashMap, (HashMap<String, y.b>)hashMap2, (HashMap<String, Set<String>>)hashMap3);
                        a.clear();
                    }
                    catch (final IllegalArgumentException ex3) {}
                    catch (final IllegalStateException ex) {}
                }
                break Label_0430;
                ex = (IllegalStateException)Boolean.FALSE;
                return (Boolean)ex;
            }
            catch (final IllegalArgumentException ex4) {}
            catch (final IllegalStateException ex) {
                goto Label_0423;
            }
        }
        final Logger o3 = w.o;
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("scan time library : ");
        sb3.append(System.currentTimeMillis() - currentTimeMillis);
        o3.fine(sb3.toString());
        this.v((Object[])new Void[0]);
        this.Z((HashMap<String, v>)hashMap, (List<n>)ex);
        ((ArrayList)ex).clear();
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("scan time new files : ");
        sb4.append(System.currentTimeMillis() - currentTimeMillis);
        o3.fine(sb4.toString());
        return Boolean.TRUE;
    }
    
    protected void U(final Boolean b) {
        final List<w.w$d> j;
        monitorenter(j = this.j);
        Label_0054: {
            try {
                final Iterator iterator = this.j.iterator();
                while (iterator.hasNext()) {
                    ((w.w$d)iterator.next()).a((boolean)b);
                }
                break Label_0054;
            }
            finally {
                monitorexit(j);
                Label_0085: {
                    return;
                }
                monitorexit(j);
                y(this);
                iftrue(Label_0085:)(this.l || !this.n);
                D(this.k, null, true);
            }
        }
    }
    
    protected void V(final Void... array) {
        final List<w.w$d> j;
        monitorenter(j = this.j);
        Label_0053: {
            try {
                final Iterator iterator = this.j.iterator();
                while (iterator.hasNext()) {
                    ((w.w$d)iterator.next()).b((HashMap)this.h);
                }
                break Label_0053;
            }
            finally {
                monitorexit(j);
                monitorexit(j);
            }
        }
    }
    
    protected void o() {
        final List<w.w$d> j;
        monitorenter(j = this.j);
        Label_0050: {
            try {
                final Iterator iterator = this.j.iterator();
                while (iterator.hasNext()) {
                    ((w.w$d)iterator.next()).a(false);
                }
                break Label_0050;
            }
            finally {
                monitorexit(j);
                monitorexit(j);
                y(this);
            }
        }
    }
    
    protected void r() {
        this.h = (HashMap<ax.Q2.f, f>)new HashMap();
        this.i = (HashMap<String, Boolean>)new HashMap();
        final Iterator iterator = K.c().iterator();
        while (iterator.hasNext()) {
            this.h.put((Object)((K)iterator.next()).d(), (Object)new f());
        }
    }
    
    public void w(final w.w$d w$d) {
        if (w$d != null) {
            this.j.add((Object)w$d);
        }
    }
    
    static class c
    {
        String a;
        Set<String> b;
        K c;
        o d;
        File e;
        HashMap<String, List<A>> f;
        ArrayList<n> g;
        boolean h;
        
        c(final K c, final String a, final File e, final boolean h) {
            this.c = c;
            this.d = ax.c3.x.e(c);
            this.b = (Set<String>)new HashSet();
            this.a = a;
            this.e = e;
            this.h = h;
        }
        
        void a(final n n) {
            this.g.add((Object)n);
        }
        
        void b() {
            final ArrayList<n> g = this.g;
            if (g != null) {
                g.clear();
                this.g = null;
            }
            this.c();
        }
        
        void c() {
            final HashMap<String, List<A>> f = this.f;
            if (f != null) {
                f.clear();
                this.f = null;
            }
        }
        
        List<A> d(final String s) {
            return (List<A>)this.f.get((Object)s);
        }
        
        void e() {
            this.f = (HashMap<String, List<A>>)new HashMap();
            this.g = (ArrayList<n>)new ArrayList();
        }
        
        boolean f() {
            return this.f != null;
        }
        
        boolean g() {
            return this.g != null;
        }
        
        void h(final String s, final List<A> list) {
            this.f.put((Object)s, (Object)list);
        }
    }
    
    public static class e
    {
        public K a;
        public boolean b;
        public y c;
        public Boolean d;
        public long e;
        public int f;
        public long g;
        public String h;
        
        public e() {
            this.b = false;
            this.e = 0L;
            this.f = 0;
            this.g = 0L;
        }
    }
    
    public static class f
    {
        public HashMap<String, e> a;
        public long b;
        public int c;
        public long d;
        public long e;
        
        public f() {
            this.a = (HashMap<String, e>)new HashMap();
            this.b = 0L;
            this.c = 0;
            this.d = 0L;
            this.e = 0L;
        }
    }
}
