package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.logging.Level;
import java.nio.charset.Charset;
import java.io.IOException;
import java.util.HashMap;
import ax.F3.b;
import java.net.URL;
import java.util.Map;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

class c extends a
{
    private static final Logger j;
    private final StringBuilder c;
    private OutputStream d;
    private InputStream e;
    private String f;
    private long g;
    private Map<String, String> h;
    private boolean i;
    
    static {
        j = Logger.getLogger(c.class.getName());
    }
    
    public c(final URL url, final BoxRequest.Methods methods, final b b) throws IOException {
        super(url, methods, b);
        this.c = new StringBuilder();
        this.h = (Map<String, String>)new HashMap();
        this.i = true;
        this.a("Content-Type", "multipart/form-data; boundary=da39a3ee5e6b4b0d3255bfef95601890afd80709");
    }
    
    private void i() throws IOException {
        if (!this.i) {
            this.j("\r\n");
        }
        this.i = false;
        this.j("--");
        this.j("da39a3ee5e6b4b0d3255bfef95601890afd80709");
    }
    
    private void j(final String s) throws IOException {
        this.d.write(s.getBytes(Charset.forName("UTF-8")));
        if (com.box.androidsdk.content.requests.c.j.isLoggable(Level.FINE)) {
            this.c.append(s);
        }
    }
    
    private void k(final String[][] array) throws IOException {
        this.l(array, null);
    }
    
    private void l(final String[][] array, final String s) throws IOException {
        this.i();
        this.j("\r\n");
        this.j("Content-Disposition: form-data");
        for (int i = 0; i < array.length; ++i) {
            this.j("; ");
            this.j(array[i][0]);
            this.j("=\"");
            this.j(array[i][1]);
            this.j("\"");
        }
        if (s != null) {
            this.j("\r\nContent-Type: ");
            this.j(s);
        }
        this.j("\r\n\r\n");
    }
    
    @Override
    public a c(final InputStream inputStream) throws IOException {
        throw new UnsupportedOperationException();
    }
    
    public void d(final String s, final String s2) {
        this.h.put((Object)s, (Object)s2);
    }
    
    public void e(final String s, final Date date) {
        this.h.put((Object)s, (Object)ax.H3.a.a(date));
    }
    
    public void f(final InputStream e, final String f) {
        this.e = e;
        this.f = f;
    }
    
    public void g(final InputStream inputStream, final String s, final long g) {
        this.f(inputStream, s);
        this.g = g;
    }
    
    protected void h(final HttpURLConnection p0, final b p1) throws BoxException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokevirtual   java/net/HttpURLConnection.setChunkedStreamingMode:(I)V
        //     5: aload_1        
        //     6: iconst_1       
        //     7: invokevirtual   java/net/URLConnection.setDoOutput:(Z)V
        //    10: aload_1        
        //    11: iconst_0       
        //    12: invokevirtual   java/net/URLConnection.setUseCaches:(Z)V
        //    15: aload_0        
        //    16: aload_1        
        //    17: invokevirtual   java/net/URLConnection.getOutputStream:()Ljava/io/OutputStream;
        //    20: putfield        com/box/androidsdk/content/requests/c.d:Ljava/io/OutputStream;
        //    23: aload_0        
        //    24: getfield        com/box/androidsdk/content/requests/c.h:Ljava/util/Map;
        //    27: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //    32: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    37: astore_1       
        //    38: aload_1        
        //    39: invokeinterface java/util/Iterator.hasNext:()Z
        //    44: istore          4
        //    46: iload           4
        //    48: ifeq            124
        //    51: aload_1        
        //    52: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    57: checkcast       Ljava/util/Map$Entry;
        //    60: astore          5
        //    62: aload_0        
        //    63: iconst_1       
        //    64: anewarray       [Ljava/lang/String;
        //    67: dup            
        //    68: iconst_0       
        //    69: iconst_2       
        //    70: anewarray       Ljava/lang/String;
        //    73: dup            
        //    74: iconst_0       
        //    75: ldc             "name"
        //    77: aastore        
        //    78: dup            
        //    79: iconst_1       
        //    80: aload           5
        //    82: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //    87: checkcast       Ljava/lang/String;
        //    90: aastore        
        //    91: aastore        
        //    92: invokespecial   com/box/androidsdk/content/requests/c.k:([[Ljava/lang/String;)V
        //    95: aload_0        
        //    96: aload           5
        //    98: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   103: checkcast       Ljava/lang/String;
        //   106: invokespecial   com/box/androidsdk/content/requests/c.j:(Ljava/lang/String;)V
        //   109: goto            38
        //   112: astore_1       
        //   113: goto            329
        //   116: astore_1       
        //   117: goto            302
        //   120: astore_1       
        //   121: goto            315
        //   124: aload_0        
        //   125: getfield        com/box/androidsdk/content/requests/c.f:Ljava/lang/String;
        //   128: astore_1       
        //   129: aload_0        
        //   130: iconst_2       
        //   131: anewarray       [Ljava/lang/String;
        //   134: dup            
        //   135: iconst_0       
        //   136: iconst_2       
        //   137: anewarray       Ljava/lang/String;
        //   140: dup            
        //   141: iconst_0       
        //   142: ldc             "name"
        //   144: aastore        
        //   145: dup            
        //   146: iconst_1       
        //   147: ldc             "filename"
        //   149: aastore        
        //   150: aastore        
        //   151: dup            
        //   152: iconst_1       
        //   153: iconst_2       
        //   154: anewarray       Ljava/lang/String;
        //   157: dup            
        //   158: iconst_0       
        //   159: ldc             "filename"
        //   161: aastore        
        //   162: dup            
        //   163: iconst_1       
        //   164: aload_1        
        //   165: aastore        
        //   166: aastore        
        //   167: ldc             "application/octet-stream"
        //   169: invokespecial   com/box/androidsdk/content/requests/c.l:([[Ljava/lang/String;Ljava/lang/String;)V
        //   172: aload_0        
        //   173: getfield        com/box/androidsdk/content/requests/c.d:Ljava/io/OutputStream;
        //   176: astore_1       
        //   177: aload_2        
        //   178: ifnull          198
        //   181: new             Lax/H3/f;
        //   184: astore_1       
        //   185: aload_1        
        //   186: aload_0        
        //   187: getfield        com/box/androidsdk/content/requests/c.d:Ljava/io/OutputStream;
        //   190: aload_2        
        //   191: aload_0        
        //   192: getfield        com/box/androidsdk/content/requests/c.g:J
        //   195: invokespecial   ax/H3/f.<init>:(Ljava/io/OutputStream;Lax/F3/b;J)V
        //   198: sipush          8192
        //   201: newarray        B
        //   203: astore_2       
        //   204: aload_0        
        //   205: getfield        com/box/androidsdk/content/requests/c.e:Ljava/io/InputStream;
        //   208: aload_2        
        //   209: invokevirtual   java/io/InputStream.read:([B)I
        //   212: istore_3       
        //   213: iload_3        
        //   214: iconst_m1      
        //   215: if_icmpeq       256
        //   218: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //   221: invokevirtual   java/lang/Thread.isInterrupted:()Z
        //   224: ifne            246
        //   227: aload_1        
        //   228: aload_2        
        //   229: iconst_0       
        //   230: iload_3        
        //   231: invokevirtual   java/io/OutputStream.write:([BII)V
        //   234: aload_0        
        //   235: getfield        com/box/androidsdk/content/requests/c.e:Ljava/io/InputStream;
        //   238: aload_2        
        //   239: invokevirtual   java/io/InputStream.read:([B)I
        //   242: istore_3       
        //   243: goto            213
        //   246: new             Ljava/lang/InterruptedException;
        //   249: astore_1       
        //   250: aload_1        
        //   251: invokespecial   java/lang/InterruptedException.<init>:()V
        //   254: aload_1        
        //   255: athrow         
        //   256: getstatic       com/box/androidsdk/content/requests/c.j:Ljava/util/logging/Logger;
        //   259: getstatic       java/util/logging/Level.FINE:Ljava/util/logging/Level;
        //   262: invokevirtual   java/util/logging/Logger.isLoggable:(Ljava/util/logging/Level;)Z
        //   265: ifeq            278
        //   268: aload_0        
        //   269: getfield        com/box/androidsdk/content/requests/c.c:Ljava/lang/StringBuilder;
        //   272: ldc             "<File Contents Omitted>"
        //   274: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   277: pop            
        //   278: aload_0        
        //   279: invokespecial   com/box/androidsdk/content/requests/c.i:()V
        //   282: aload_0        
        //   283: ldc             "--"
        //   285: invokespecial   com/box/androidsdk/content/requests/c.j:(Ljava/lang/String;)V
        //   288: aload_0        
        //   289: getfield        com/box/androidsdk/content/requests/c.d:Ljava/io/OutputStream;
        //   292: astore_1       
        //   293: aload_1        
        //   294: ifnull          301
        //   297: aload_1        
        //   298: invokevirtual   java/io/OutputStream.close:()V
        //   301: return         
        //   302: new             Lcom/box/androidsdk/content/BoxException;
        //   305: astore_2       
        //   306: aload_2        
        //   307: ldc             "Thread has been interrupted"
        //   309: aload_1        
        //   310: invokespecial   com/box/androidsdk/content/BoxException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   313: aload_2        
        //   314: athrow         
        //   315: new             Lcom/box/androidsdk/content/BoxException;
        //   318: astore_2       
        //   319: aload_2        
        //   320: ldc_w           "Couldn't connect to the Box API due to a network error."
        //   323: aload_1        
        //   324: invokespecial   com/box/androidsdk/content/BoxException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   327: aload_2        
        //   328: athrow         
        //   329: aload_0        
        //   330: getfield        com/box/androidsdk/content/requests/c.d:Ljava/io/OutputStream;
        //   333: astore_2       
        //   334: aload_2        
        //   335: ifnull          342
        //   338: aload_2        
        //   339: invokevirtual   java/io/OutputStream.close:()V
        //   342: aload_1        
        //   343: athrow         
        //   344: astore_1       
        //   345: goto            301
        //   348: astore_2       
        //   349: goto            342
        //    Exceptions:
        //  throws com.box.androidsdk.content.BoxException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  0      38     120    124    Ljava/io/IOException;
        //  0      38     116    120    Ljava/lang/InterruptedException;
        //  0      38     112    344    Any
        //  38     46     120    124    Ljava/io/IOException;
        //  38     46     116    120    Ljava/lang/InterruptedException;
        //  38     46     112    344    Any
        //  51     109    120    124    Ljava/io/IOException;
        //  51     109    116    120    Ljava/lang/InterruptedException;
        //  51     109    112    344    Any
        //  124    177    120    124    Ljava/io/IOException;
        //  124    177    116    120    Ljava/lang/InterruptedException;
        //  124    177    112    344    Any
        //  181    198    120    124    Ljava/io/IOException;
        //  181    198    116    120    Ljava/lang/InterruptedException;
        //  181    198    112    344    Any
        //  198    213    120    124    Ljava/io/IOException;
        //  198    213    116    120    Ljava/lang/InterruptedException;
        //  198    213    112    344    Any
        //  218    243    120    124    Ljava/io/IOException;
        //  218    243    116    120    Ljava/lang/InterruptedException;
        //  218    243    112    344    Any
        //  246    256    120    124    Ljava/io/IOException;
        //  246    256    116    120    Ljava/lang/InterruptedException;
        //  246    256    112    344    Any
        //  256    278    120    124    Ljava/io/IOException;
        //  256    278    116    120    Ljava/lang/InterruptedException;
        //  256    278    112    344    Any
        //  278    288    120    124    Ljava/io/IOException;
        //  278    288    116    120    Ljava/lang/InterruptedException;
        //  278    288    112    344    Any
        //  297    301    344    348    Ljava/lang/Exception;
        //  302    315    112    344    Any
        //  315    329    112    344    Any
        //  338    342    348    352    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 188 out of bounds for length 188
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
}
