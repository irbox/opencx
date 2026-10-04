package com.alphainventor.filemanager.file;

import ax.c3.b;
import java.util.AbstractCollection;
import java.util.Iterator;
import ax.b3.j;
import ax.b3.a;
import java.util.Stack;
import java.util.HashMap;
import ax.u3.q$e;
import java.util.Map;
import java.util.List;
import ax.u3.q;

public class f extends q<Void, Void, Void>
{
    o h;
    private int i;
    private int j;
    private long k;
    private long l;
    private f.f$b m;
    private List<n> n;
    private Map<String, a> o;
    private boolean p;
    private c q;
    
    public f(final c q, final o h, final List<n> n, final boolean p5, final f.f$b m) {
        super(q$e.f0);
        this.o = (Map<String, a>)new HashMap();
        this.q = q;
        this.h = h;
        this.m = m;
        this.n = n;
        this.p = p5;
    }
    
    private void A(n n, final a a) throws ax.b3.a {
        final Stack stack = new Stack();
        stack.push((Object)n);
    Label_0016:
        while (!((AbstractCollection)stack).isEmpty()) {
            n = (n)stack.pop();
            if (this.isCancelled()) {
                throw new ax.b3.a();
            }
            final boolean b = this.q != c.q || (((b)n).l() ^ true);
            if (((b)n).isDirectory() && b) {
            Label_0115_Outer:
                while (true) {
                    ++this.i;
                    ++a.a;
                    this.z();
                    while (true) {
                        n n2 = null;
                        Label_0157: {
                            try {
                                final Iterator iterator = this.h.f0(n).iterator();
                                while (iterator.hasNext()) {
                                    n2 = (n)iterator.next();
                                    if (this.p && J.j2(n2)) {
                                        continue Label_0115_Outer;
                                    }
                                    break Label_0157;
                                }
                                continue Label_0016;
                            }
                            catch (final j j) {
                                break;
                            }
                        }
                        stack.push((Object)n2);
                        continue;
                    }
                }
                final j j;
                ((Throwable)j).printStackTrace();
            }
            else {
                final long p2 = ((b)n).p();
                ++this.j;
                ++a.b;
                this.k += p2;
                a.c += p2;
                this.z();
            }
        }
    }
    
    private void z() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.l > 100L) {
            this.l = currentTimeMillis;
            this.v((Object[])new Void[0]);
        }
    }
    
    protected void o() {
        this.h.k0(false);
    }
    
    protected void r() {
        this.h.n0();
    }
    
    protected Void w(final Void... p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/alphainventor/filemanager/file/f.h:Lcom/alphainventor/filemanager/file/o;
        //     4: astore_1       
        //     5: aload_1        
        //     6: ifnull          108
        //     9: aload_1        
        //    10: invokevirtual   com/alphainventor/filemanager/file/o.a:()Z
        //    13: ifne            108
        //    16: aload_0        
        //    17: getfield        com/alphainventor/filemanager/file/f.h:Lcom/alphainventor/filemanager/file/o;
        //    20: invokevirtual   com/alphainventor/filemanager/file/o.S:()Lax/Q2/f;
        //    23: getstatic       ax/Q2/f.H0:Lax/Q2/f;
        //    26: if_acmpeq       108
        //    29: aload_0        
        //    30: getfield        com/alphainventor/filemanager/file/f.h:Lcom/alphainventor/filemanager/file/o;
        //    33: invokevirtual   com/alphainventor/filemanager/file/o.S:()Lax/Q2/f;
        //    36: getstatic       ax/Q2/f.I0:Lax/Q2/f;
        //    39: if_acmpeq       108
        //    42: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //    45: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //    48: ldc             "DIRECTORY SCAN DISCONNECTED"
        //    50: invokevirtual   ax/Ha/b.b:(Ljava/lang/String;)Lax/Ha/b;
        //    53: astore_1       
        //    54: new             Ljava/lang/StringBuilder;
        //    57: dup            
        //    58: invokespecial   java/lang/StringBuilder.<init>:()V
        //    61: astore_3       
        //    62: aload_3        
        //    63: ldc             "location:"
        //    65: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    68: pop            
        //    69: aload_3        
        //    70: aload_0        
        //    71: getfield        com/alphainventor/filemanager/file/f.h:Lcom/alphainventor/filemanager/file/o;
        //    74: invokevirtual   com/alphainventor/filemanager/file/o.S:()Lax/Q2/f;
        //    77: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    80: pop            
        //    81: aload_3        
        //    82: ldc             ",scanType:"
        //    84: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    87: pop            
        //    88: aload_3        
        //    89: aload_0        
        //    90: getfield        com/alphainventor/filemanager/file/f.q:Lcom/alphainventor/filemanager/file/f$c;
        //    93: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    96: pop            
        //    97: aload_1        
        //    98: aload_3        
        //    99: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   102: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //   105: invokevirtual   ax/Ha/b.h:()V
        //   108: aload_0        
        //   109: getfield        com/alphainventor/filemanager/file/f.n:Ljava/util/List;
        //   112: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //   117: astore_3       
        //   118: aload_3        
        //   119: invokeinterface java/util/Iterator.hasNext:()Z
        //   124: ifeq            202
        //   127: aload_3        
        //   128: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   133: checkcast       Lcom/alphainventor/filemanager/file/n;
        //   136: astore_1       
        //   137: invokestatic    ax/X2/Q.P1:()Z
        //   140: ifeq            159
        //   143: aload_1        
        //   144: instanceof      Lcom/alphainventor/filemanager/file/y;
        //   147: istore_2       
        //   148: iload_2        
        //   149: ifeq            159
        //   152: aload_1        
        //   153: checkcast       Lcom/alphainventor/filemanager/file/y;
        //   156: invokevirtual   com/alphainventor/filemanager/file/y.t1:()V
        //   159: aload_1        
        //   160: invokeinterface ax/c3/b.n:()Z
        //   165: pop            
        //   166: new             Lcom/alphainventor/filemanager/file/f$a;
        //   169: astore          4
        //   171: aload           4
        //   173: invokespecial   com/alphainventor/filemanager/file/f$a.<init>:()V
        //   176: aload_0        
        //   177: aload_1        
        //   178: aload           4
        //   180: invokespecial   com/alphainventor/filemanager/file/f.A:(Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/f$a;)V
        //   183: aload_0        
        //   184: getfield        com/alphainventor/filemanager/file/f.o:Ljava/util/Map;
        //   187: aload_1        
        //   188: invokevirtual   com/alphainventor/filemanager/file/n.Q:()Ljava/lang/String;
        //   191: aload           4
        //   193: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   198: pop            
        //   199: goto            118
        //   202: aload_0        
        //   203: iconst_0       
        //   204: anewarray       Ljava/lang/Void;
        //   207: invokevirtual   ax/u3/q.v:([Ljava/lang/Object;)V
        //   210: aconst_null    
        //   211: areturn        
        //   212: astore_1       
        //   213: goto            210
        //   216: astore          4
        //   218: goto            159
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  108    118    212    216    Lax/b3/a;
        //  118    148    212    216    Lax/b3/a;
        //  152    159    216    221    Ljava/io/IOException;
        //  152    159    212    216    Lax/b3/a;
        //  159    199    212    216    Lax/b3/a;
        //  202    210    212    216    Lax/b3/a;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0159:
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
    
    protected void x(final Void void1) {
        this.h.k0(false);
        this.m.a(this.i, this.j, this.k, (Map)this.o);
    }
    
    protected void y(final Void... array) {
        this.m.b(this.i, this.j, this.k);
    }
    
    public static class a
    {
        public int a;
        public int b;
        public long c;
    }
    
    public enum c
    {
        c0;
        
        private static final c[] d0;
        
        q;
        
        static {
            d0 = d();
        }
        
        private static /* synthetic */ c[] d() {
            return new c[] { c.q, c.c0 };
        }
    }
}
