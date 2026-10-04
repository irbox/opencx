package com.alphainventor.filemanager.viewer;

import androidx.viewpager.widget.ViewPager;
import androidx.activity.ComponentActivity;
import android.content.pm.PackageItemInfo;
import ax.u3.q$e;
import ax.u3.q;
import ax.X2.v;
import android.view.MenuItem;
import android.view.KeyEvent;
import android.view.Menu;
import ax.x3.E$d;
import android.os.Bundle;
import com.android.ex.photo.PhotoViewPager;
import android.content.res.Configuration;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.Toolbar;
import ax.c3.A;
import ax.c3.w;
import ax.Z2.c$a;
import android.view.ViewGroup;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import ax.u3.z;
import android.content.pm.ResolveInfo;
import java.util.Iterator;
import android.content.ActivityNotFoundException;
import ax.W2.h;
import ax.d3.s;
import android.content.DialogInterface;
import android.content.DialogInterface$OnCancelListener;
import ax.W2.h$b;
import ax.W2.h$a;
import java.util.ArrayList;
import ax.b3.j;
import ax.x3.d$g;
import ax.x3.d$f;
import android.view.View$OnClickListener;
import ax.g3.c;
import android.content.Intent;
import ax.X2.Q;
import ax.d3.n$p;
import ax.Z2.t;
import ax.c3.k;
import ax.c3.B;
import android.content.Context;
import android.widget.Toast;
import android.app.Activity;
import ax.c3.u;
import android.net.Uri;
import java.io.File;
import ax.c3.K;
import com.alphainventor.filemanager.file.x;
import com.alphainventor.filemanager.file.y;
import android.content.ComponentName;
import ax.d3.M;
import android.view.View;
import ax.x3.d;
import com.alphainventor.filemanager.file.o;
import com.alphainventor.filemanager.file.n;
import java.util.List;
import java.util.HashMap;
import ax.x3.E;
import com.android.ex.photo.b;
import com.android.ex.photo.f;
import ax.i.r;
import com.android.ex.photo.f$g;
import com.alphainventor.filemanager.activity.a;

public class ImageViewerActivity extends a implements f$g, ax.R2.a
{
    public static int G = 36102;
    public static String H = "IMAGE_INFO_KEY";
    private long A;
    private boolean B;
    private String C;
    private String D;
    private boolean E;
    r F;
    private f j;
    private b k;
    private E l;
    private final HashMap<String, Boolean> m;
    List<com.alphainventor.filemanager.file.n> n;
    private ax.Q2.f o;
    private int p;
    o q;
    int r;
    d s;
    View t;
    boolean u;
    View v;
    View w;
    M x;
    private HashMap<ComponentName, m> y;
    private com.alphainventor.filemanager.file.n z;
    
    public ImageViewerActivity() {
        this.m = (HashMap<String, Boolean>)new HashMap();
        this.y = (HashMap<ComponentName, m>)new HashMap();
        this.F = new r(true) {
            final ImageViewerActivity d;
            
            public void c() {
                this.d.B = false;
                this.d.p();
            }
            
            public void d() {
                this.d.j.e0();
                this.d.B = false;
                this.d.p();
            }
            
            public void f(final ax.i.b b) {
                this.d.B = true;
            }
        };
    }
    
    private void A0() {
        if (this.j() != null) {
            if (this.j().V() != null) {
                if (!this.j().s()) {
                    this.j().n();
                }
                this.l.z();
            }
        }
    }
    
    private void B0(final com.alphainventor.filemanager.file.n n) {
        if (!(n instanceof y)) {
            String string;
            if (n == null) {
                string = "loc:null";
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append("loc:");
                sb.append(n.P().I());
                string = sb.toString();
            }
            ax.u3.b.g(string);
            return;
        }
        if (!(this.q.u() instanceof x)) {
            ax.u3.b.f();
            return;
        }
        final K b0 = ((y)n).B0();
        if (b0 != null) {
            if (b0.e() != null) {
                new n(n).i((Object[])new Void[0]);
            }
        }
    }
    
    private boolean C0(final com.alphainventor.filemanager.file.n p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          6
        //     3: aconst_null    
        //     4: astore          7
        //     6: aload           7
        //     8: astore          4
        //    10: aload           6
        //    12: astore          5
        //    14: aload_1        
        //    15: checkcast       Lcom/alphainventor/filemanager/file/y;
        //    18: invokevirtual   com/alphainventor/filemanager/file/y.B0:()Lax/c3/K;
        //    21: astore          8
        //    23: aload           8
        //    25: ifnull          296
        //    28: aload           7
        //    30: astore          4
        //    32: aload           6
        //    34: astore          5
        //    36: aload           8
        //    38: invokevirtual   ax/c3/K.e:()Ljava/lang/String;
        //    41: ifnonnull       47
        //    44: goto            296
        //    47: aload           7
        //    49: astore          4
        //    51: aload           6
        //    53: astore          5
        //    55: aload_0        
        //    56: aload           8
        //    58: invokespecial   com/alphainventor/filemanager/viewer/ImageViewerActivity.i0:(Lax/c3/K;)Z
        //    61: ifne            66
        //    64: iconst_0       
        //    65: ireturn        
        //    66: aload           7
        //    68: astore          4
        //    70: aload           6
        //    72: astore          5
        //    74: aload_1        
        //    75: invokeinterface ax/c3/b.q:()J
        //    80: lstore_2       
        //    81: aload           7
        //    83: astore          4
        //    85: aload           6
        //    87: astore          5
        //    89: aload_0        
        //    90: getfield        com/alphainventor/filemanager/viewer/ImageViewerActivity.q:Lcom/alphainventor/filemanager/file/o;
        //    93: invokevirtual   com/alphainventor/filemanager/file/o.u:()Lcom/alphainventor/filemanager/file/m;
        //    96: checkcast       Lcom/alphainventor/filemanager/file/x;
        //    99: astore          8
        //   101: aload           7
        //   103: astore          4
        //   105: aload           6
        //   107: astore          5
        //   109: aload           8
        //   111: aload_1        
        //   112: checkcast       Lcom/alphainventor/filemanager/file/y;
        //   115: invokevirtual   com/alphainventor/filemanager/file/x.U0:(Lcom/alphainventor/filemanager/file/y;)Landroid/os/ParcelFileDescriptor;
        //   118: astore          6
        //   120: aload           6
        //   122: ifnonnull       137
        //   125: aload           6
        //   127: ifnull          135
        //   130: aload           6
        //   132: invokevirtual   android/os/ParcelFileDescriptor.close:()V
        //   135: iconst_0       
        //   136: ireturn        
        //   137: aload           6
        //   139: astore          4
        //   141: aload           6
        //   143: astore          5
        //   145: new             Lax/y0/a;
        //   148: astore          7
        //   150: aload           6
        //   152: astore          4
        //   154: aload           6
        //   156: astore          5
        //   158: aload           7
        //   160: aload           6
        //   162: invokevirtual   android/os/ParcelFileDescriptor.getFileDescriptor:()Ljava/io/FileDescriptor;
        //   165: invokespecial   ax/y0/a.<init>:(Ljava/io/FileDescriptor;)V
        //   168: aload           6
        //   170: astore          4
        //   172: aload           6
        //   174: astore          5
        //   176: aload           7
        //   178: ldc             "Orientation"
        //   180: iconst_1       
        //   181: invokevirtual   ax/y0/a.l:(Ljava/lang/String;I)I
        //   184: ifne            211
        //   187: aload           6
        //   189: astore          4
        //   191: aload           6
        //   193: astore          5
        //   195: aload           7
        //   197: invokevirtual   ax/y0/a.f0:()V
        //   200: goto            211
        //   203: astore_1       
        //   204: goto            318
        //   207: astore_1       
        //   208: goto            298
        //   211: aload           6
        //   213: astore          4
        //   215: aload           6
        //   217: astore          5
        //   219: aload           7
        //   221: bipush          -90
        //   223: invokevirtual   ax/y0/a.h0:(I)V
        //   226: aload           6
        //   228: astore          4
        //   230: aload           6
        //   232: astore          5
        //   234: aload           7
        //   236: invokevirtual   ax/y0/a.i0:()V
        //   239: aload           6
        //   241: astore          4
        //   243: aload           6
        //   245: astore          5
        //   247: aload           8
        //   249: aload_1        
        //   250: lload_2        
        //   251: invokevirtual   com/alphainventor/filemanager/file/x.d:(Lcom/alphainventor/filemanager/file/n;J)Z
        //   254: pop            
        //   255: aload           6
        //   257: astore          4
        //   259: aload           6
        //   261: astore          5
        //   263: aload           8
        //   265: aload_1        
        //   266: invokevirtual   com/alphainventor/filemanager/file/x.Q1:(Lcom/alphainventor/filemanager/file/n;)V
        //   269: aload           6
        //   271: astore          4
        //   273: aload           6
        //   275: astore          5
        //   277: aload_0        
        //   278: aload_0        
        //   279: getfield        com/alphainventor/filemanager/viewer/ImageViewerActivity.q:Lcom/alphainventor/filemanager/file/o;
        //   282: aload_1        
        //   283: invokevirtual   com/alphainventor/filemanager/file/o.H:(Lcom/alphainventor/filemanager/file/n;)Ljava/lang/String;
        //   286: invokestatic    ax/r3/d.B:(Landroid/content/Context;Ljava/lang/String;)V
        //   289: aload           6
        //   291: invokevirtual   android/os/ParcelFileDescriptor.close:()V
        //   294: iconst_1       
        //   295: ireturn        
        //   296: iconst_0       
        //   297: ireturn        
        //   298: aload           5
        //   300: astore          4
        //   302: aload_1        
        //   303: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   306: aload           5
        //   308: ifnull          316
        //   311: aload           5
        //   313: invokevirtual   android/os/ParcelFileDescriptor.close:()V
        //   316: iconst_0       
        //   317: ireturn        
        //   318: aload           4
        //   320: ifnull          328
        //   323: aload           4
        //   325: invokevirtual   android/os/ParcelFileDescriptor.close:()V
        //   328: aload_1        
        //   329: athrow         
        //   330: astore_1       
        //   331: goto            135
        //   334: astore_1       
        //   335: goto            294
        //   338: astore_1       
        //   339: goto            316
        //   342: astore          4
        //   344: goto            328
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  14     23     207    318    Ljava/lang/Exception;
        //  14     23     203    330    Any
        //  36     44     207    318    Ljava/lang/Exception;
        //  36     44     203    330    Any
        //  55     64     207    318    Ljava/lang/Exception;
        //  55     64     203    330    Any
        //  74     81     207    318    Ljava/lang/Exception;
        //  74     81     203    330    Any
        //  89     101    207    318    Ljava/lang/Exception;
        //  89     101    203    330    Any
        //  109    120    207    318    Ljava/lang/Exception;
        //  109    120    203    330    Any
        //  130    135    330    334    Ljava/io/IOException;
        //  145    150    207    318    Ljava/lang/Exception;
        //  145    150    203    330    Any
        //  158    168    207    318    Ljava/lang/Exception;
        //  158    168    203    330    Any
        //  176    187    207    318    Ljava/lang/Exception;
        //  176    187    203    330    Any
        //  195    200    207    318    Ljava/lang/Exception;
        //  195    200    203    330    Any
        //  219    226    207    318    Ljava/lang/Exception;
        //  219    226    203    330    Any
        //  234    239    207    318    Ljava/lang/Exception;
        //  234    239    203    330    Any
        //  247    255    207    318    Ljava/lang/Exception;
        //  247    255    203    330    Any
        //  263    269    207    318    Ljava/lang/Exception;
        //  263    269    203    330    Any
        //  277    289    207    318    Ljava/lang/Exception;
        //  277    289    203    330    Any
        //  289    294    334    338    Ljava/io/IOException;
        //  302    306    203    330    Any
        //  311    316    338    342    Ljava/io/IOException;
        //  323    328    342    347    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 168 out of bounds for length 168
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
    
    private void D0() {
        if (this.r0()) {
            this.E = true;
            ax.c3.u.s0((Activity)this, Uri.fromFile(new File(this.C)), this.D);
            ((Activity)this).finish();
            return;
        }
        ax.u3.b.f();
        Toast.makeText((Context)this, 2131951927, 1).show();
    }
    
    private void E0(final com.alphainventor.filemanager.file.n n) {
        ax.Q2.a.i().m("menu_image_viewer", "set_as").e();
        if (ax.c3.B.H(n)) {
            ax.c3.u.g0((Context)this.s(), (k)n);
            return;
        }
        final File z = n.Z();
        if (ax.c3.B.G(z, n)) {
            ax.Z2.t.b().e(z);
            ax.c3.u.h0((Context)this.s(), ((ax.c3.b)n).s(), z);
            return;
        }
        this.h0(n, (n$p)new n$p(this, n, z) {
            final com.alphainventor.filemanager.file.n a;
            final File b;
            final ImageViewerActivity c;
            
            public void a() {
                if (this.c.s() == null) {
                    return;
                }
                ax.c3.u.h0((Context)this.c.s(), ((ax.c3.b)this.a).s(), this.b);
            }
        });
    }
    
    private void G0(final com.alphainventor.filemanager.file.n z) {
        this.z = z;
        this.A = ((ax.c3.b)z).q();
    }
    
    private void H0(final com.alphainventor.filemanager.file.n n) {
        ax.Q2.a.i().m("menu_image_viewer", "share").c("loc", "image_viewer").c("type", "file").e();
        if (ax.c3.B.H(n)) {
            ax.c3.u.j0((Context)this.s(), (k)n);
            return;
        }
        final File z = n.Z();
        if (ax.c3.B.G(z, n)) {
            ax.Z2.t.b().e(z);
            ax.c3.u.m0((Context)this.s(), ((ax.c3.b)n).s(), z);
            return;
        }
        this.h0(n, (n$p)new n$p(this, n, z) {
            final com.alphainventor.filemanager.file.n a;
            final File b;
            final ImageViewerActivity c;
            
            public void a() {
                if (this.c.s() == null) {
                    return;
                }
                ax.c3.u.m0((Context)this.c.s(), ((ax.c3.b)this.a).s(), this.b);
            }
        });
    }
    
    private void I0(final com.alphainventor.filemanager.file.n n) {
        this.j().c(true);
        if (!this.j().s()) {
            this.j().n();
        }
    }
    
    private void L0(final com.alphainventor.filemanager.file.n n) {
        if (this.j() != null) {
            if (this.j().V() != null) {
                if (!this.j().s()) {
                    this.j().n();
                }
                this.l.D();
            }
        }
    }
    
    private boolean M0(final com.alphainventor.filemanager.file.n n) {
        if (ax.c3.B.H(n)) {
            return true;
        }
        Q.r0();
        return false;
    }
    
    private void d0() {
        final c c = new c(this, 400L) {
            final ImageViewerActivity c;
            
            public void a(final View view) {
                this.c.w0(view.getId());
            }
        };
        this.s = new d(this.s(), this.findViewById(2131361934), (View)null);
        if (this.r0()) {
            this.s.d(2131362536, 2131952296, 2131231212, (View$OnClickListener)c);
            this.s.d(2131362516, 2131952269, 2131231156, (View$OnClickListener)c);
            this.s.d(2131362543, 2131952576, 2131231086, (View$OnClickListener)c);
            return;
        }
        this.s.d(2131362545, 2131952304, 2131231220, (View$OnClickListener)c);
        this.s.d(2131362535, 2131952295, 2131231211, (View$OnClickListener)c);
        this.s.d(2131362506, 2131952255, 2131231124, (View$OnClickListener)c);
        this.s.d(2131362516, 2131952269, 2131231156, (View$OnClickListener)c);
        this.s.e();
        this.s.l(2131689492);
        this.s.n((d$f)new d$f(this) {
            final ImageViewerActivity a;
            
            public boolean a(final int n) {
                this.a.w0(n);
                return true;
            }
        });
        this.s.x((d$g)new d$g(this) {
            final ImageViewerActivity a;
            
            public void a() {
                final ImageViewerActivity a = this.a;
                final com.alphainventor.filemanager.file.n a2 = this.a.k0(((com.alphainventor.filemanager.viewer.b)a.j()).V0());
                final boolean b = a2 != null && ax.c3.B.H(a2);
                this.a.s.t(2131362524, b);
                boolean b3 = false;
                Label_0119: {
                    if (b) {
                        final Intent w0 = com.alphainventor.filemanager.viewer.b.W0((Context)a, a2, true);
                        if (w0 != null) {
                            final m b2 = this.a.n0(w0);
                            if (b2 != null) {
                                this.a.s.s(2131362522, b2.a);
                                this.a.s.q(2131362522, b2.b);
                                b3 = true;
                                break Label_0119;
                            }
                        }
                    }
                    b3 = false;
                }
                this.a.s.t(2131362522, b3);
                this.a.s.t(2131362547, true);
                this.a.s.t(2131362507, false);
            }
            
            public void b(final boolean b) {
                this.a.j.a(b);
            }
        });
    }
    
    private void e0() {
        final com.alphainventor.filemanager.file.n z = this.z;
        if (z == null) {
            return;
        }
        while (true) {
            if (!(z instanceof k)) {
                break Label_0065;
            }
            try {
                if (((ax.c3.b)ax.c3.x.e(z.R()).z(this.z.E())).q() != this.A) {
                    ((com.alphainventor.filemanager.viewer.b)this.j()).f1();
                }
                this.z = null;
                this.A = 0L;
            }
            catch (final j j) {
                continue;
            }
            break;
        }
    }
    
    private void g0(final com.alphainventor.filemanager.file.n n) {
        ax.Q2.a.i().m("menu_image_viewer", "delete").c("loc", "image_viewer").c("type", "file").e();
        final ArrayList list = new ArrayList();
        ((List)list).add((Object)n);
        final boolean b = ax.c3.B.a((List)list) && ax.Q2.f.l(n.P());
        this.j().L();
        ax.W2.o.m(this.q, (List)list, 0, b, (s)this, false, (h$a)new h$a(this, n) {
            final com.alphainventor.filemanager.file.n a;
            final ImageViewerActivity b;
            
            public void a(final h$b h$b, final String s, final String s2, final ArrayList<String> list, final Object o) {
                if (h$b != h$b.c0) {
                    this.b.J0((CharSequence)s, 0);
                    return;
                }
                final int index = this.b.n.indexOf((Object)this.a);
                this.b.n.remove((Object)this.a);
                if (this.b.n.isEmpty()) {
                    Toast.makeText((Context)this.b, (CharSequence)s, 1).show();
                    ((Activity)this.b).finish();
                    return;
                }
                ((com.alphainventor.filemanager.viewer.b)this.b.j()).e1();
                if (list.size() > 0 && index >= 0) {
                    this.b.K0(this.a, index, (CharSequence)s, (List<String>)list);
                    return;
                }
                this.b.J0((CharSequence)s, -1);
            }
            
            public void b() {
                this.b.j().t0();
            }
        }, (DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener(this) {
            final ImageViewerActivity a;
            
            public void onCancel(final DialogInterface dialogInterface) {
                this.a.j().t0();
            }
        });
    }
    
    private void h0(final com.alphainventor.filemanager.file.n n, final n$p n$p) {
        final ArrayList list = new ArrayList();
        list.add((Object)n);
        final ax.W2.r l = ax.W2.r.l();
        l.k(this.q, (List)list, true, (h$a)new h$a(this, n$p) {
            final n$p a;
            final ImageViewerActivity b;
            
            public void a(final h$b h$b, final String s, final String s2, final ArrayList<String> list, final Object o) {
                final int n = ImageViewerActivity$c.a[((Enum)h$b).ordinal()];
                if (n == 1) {
                    this.a.a();
                    return;
                }
                if (n != 2 && n != 3) {
                    return;
                }
                Toast.makeText((Context)this.b.s(), (CharSequence)s, 1).show();
            }
            
            public void b() {
            }
        });
        try {
            this.l((h)l, true);
        }
        catch (final ax.b3.c c) {
            Toast.makeText((Context)this, 2131951927, 0).show();
        }
    }
    
    private boolean i0(final K k) {
        final String e = k.e();
        if (this.m.containsKey((Object)e)) {
            return (boolean)this.m.get((Object)e);
        }
        final boolean t = ax.c3.B.t(k);
        this.m.put((Object)e, (Object)t);
        return t;
    }
    
    private void j0(final com.alphainventor.filemanager.file.n n) {
        if (ax.c3.B.H(n)) {
            try {
                ax.c3.u.o0((Context)this, ax.c3.u.e((Context)this, (k)n, false));
            }
            catch (final ActivityNotFoundException ex) {
                this.J0((CharSequence)((Context)this).getString(2131952449), -1);
            }
        }
    }
    
    private com.alphainventor.filemanager.file.n k0(final Uri uri) {
        if (uri == null) {
            return null;
        }
        for (final com.alphainventor.filemanager.file.n n : this.n) {
            if (uri.toString().equals((Object)n.Q())) {
                return n;
            }
        }
        return null;
    }
    
    private void m0(final int n) {
        View view;
        if (n == 20) {
            view = this.s.j();
        }
        else {
            view = this.l0();
        }
        if (view != null) {
            if (!this.q0()) {
                this.j().u0();
            }
            else {
                this.j().n();
            }
            view.requestFocus();
        }
    }
    
    private m n0(final Intent intent) {
        final ComponentName component = intent.getComponent();
        if (this.y.containsKey((Object)component)) {
            return (m)this.y.get((Object)component);
        }
        final PackageManager packageManager = ((Context)this).getPackageManager();
        final List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            final ResolveInfo resolveInfo = (ResolveInfo)queryIntentActivities.get(0);
            final CharSequence loadLabel = ((PackageItemInfo)resolveInfo.activityInfo).loadLabel(packageManager);
            final Drawable n = ax.Z2.h.n(packageManager, resolveInfo, 0);
            Object o;
            if ((o = n) != null) {
                final int e = ax.u3.B.e((Context)this, d.n);
                o = new BitmapDrawable(((ax.n.c)this).getResources(), ax.u3.z.f(n, e, e));
            }
            final m m = new m(loadLabel, (Drawable)o);
            this.y.put((Object)component, (Object)m);
            return m;
        }
        return null;
    }
    
    private boolean o0(final ViewGroup viewGroup, final View view) {
        return ax.u3.z.s(viewGroup, view);
    }
    
    private boolean p0(final String s) {
        return "webp".equals((Object)s) || "png".equals((Object)s) || "jpg".equals((Object)s) || "jpeg".equals((Object)s);
    }
    
    private boolean q0() {
        return this.s.k() != 0;
    }
    
    private boolean r0() {
        return this.C != null;
    }
    
    private void s0(final com.alphainventor.filemanager.file.n ex) {
        final Intent w0 = com.alphainventor.filemanager.viewer.b.W0((Context)this, (com.alphainventor.filemanager.file.n)ex, false);
        if (w0 != null && ax.c3.u.U(w0)) {
            ((com.alphainventor.filemanager.viewer.b)this.j()).r(Uri.parse(((com.alphainventor.filemanager.file.n)ex).Q()), true);
            return;
        }
        if (w0 != null) {
            try {
                ax.c3.u.o0((Context)this, w0);
                this.G0((com.alphainventor.filemanager.file.n)ex);
                return;
            }
            catch (final NullPointerException ex) {}
            catch (final SecurityException ex) {}
            catch (final ActivityNotFoundException ex2) {}
            Toast.makeText((Context)this, 2131951927, 1).show();
            ax.Ha.c.h().f().b("ImageViewer openDefault").l((Throwable)ex).h();
        }
    }
    
    private void t0(final k k, final String s, final String s2, final boolean b, final boolean b2) {
        ax.a3.Q.R3(this.m(), c$a.d0, ax.a3.Q.E3((com.alphainventor.filemanager.file.n)k), s, s2, b, b2);
        this.G0((com.alphainventor.filemanager.file.n)k);
    }
    
    private void u0(final com.alphainventor.filemanager.file.n n) {
        if (((Activity)this).isFinishing()) {
            return;
        }
        final String s = ((ax.c3.b)n).s();
        if (!ax.c3.w.a((Context)this, n, s, false)) {
            Toast.makeText((Context)this, 2131952449, 1).show();
            return;
        }
        if (ax.c3.B.H(n)) {
            this.t0((k)n, s, s, true, true);
            return;
        }
        ax.u3.b.f();
    }
    
    private void v0() {
        final Uri v0 = ((com.alphainventor.filemanager.viewer.b)this.j()).V0();
        if (v0 != null) {
            final com.alphainventor.filemanager.file.n k0 = this.k0(v0);
            if (k0 != null) {
                if (this.l.x() && !this.l.w() && ax.c3.B.H(k0) && k0.G() == ax.c3.z.e0 && ax.c3.A.E(k0)) {
                    this.l.y();
                    int r;
                    if (this.l.s()) {
                        r = 0;
                    }
                    else {
                        r = this.l.r();
                    }
                    try {
                        ((ComponentActivity)this).startActivityForResult(ax.c3.w.i((Context)this, (com.alphainventor.filemanager.file.n)k0, r, false), ImageViewerActivity.G);
                        return;
                    }
                    catch (final NullPointerException k0) {}
                    catch (final SecurityException k0) {}
                    catch (final ActivityNotFoundException ex) {}
                    Toast.makeText((Context)this, 2131951927, 1).show();
                    ax.Ha.c.h().f().b("PVI:").l((Throwable)k0).h();
                }
            }
        }
    }
    
    private boolean w0(final int n) {
        this.j().u0();
        final Uri v0 = ((com.alphainventor.filemanager.viewer.b)this.j()).V0();
        if (v0 == null) {
            return false;
        }
        final com.alphainventor.filemanager.file.n k0 = this.k0(v0);
        if (k0 == null) {
            return false;
        }
        switch (n) {
            case 2131362506:
            case 2131362507: {
                if (com.alphainventor.filemanager.file.x.E1((Context)this, k0, false)) {
                    final y y = (y)k0;
                    this.R(3, y.B0(), y.M0(), false, true);
                    return true;
                }
                break;
            }
        }
        switch (n) {
            default: {
                return false;
            }
            case 2131362547: {
                this.L0(k0);
                return true;
            }
            case 2131362545: {
                this.H0(k0);
                return true;
            }
            case 2131362543: {
                this.E0(k0);
                return true;
            }
            case 2131362536: {
                this.D0();
                return true;
            }
            case 2131362535: {
                this.B0(k0);
                return true;
            }
            case 2131362524: {
                this.u0(k0);
                return true;
            }
            case 2131362522: {
                this.s0(k0);
                return true;
            }
            case 2131362516: {
                this.I0(k0);
                return true;
            }
            case 2131362507: {
                this.j0(k0);
                return true;
            }
            case 2131362506: {
                this.g0(k0);
                return true;
            }
        }
    }
    
    public void F0(final boolean u) {
        if (this.v != null && this.w != null) {
            if (this.j() != null) {
                this.u = u;
                final View v = this.v;
                int visibility;
                if (u) {
                    visibility = 0;
                }
                else {
                    visibility = 8;
                }
                v.setVisibility(visibility);
                this.x0();
            }
        }
    }
    
    void J0(final CharSequence charSequence, final int n) {
        ax.u3.B.T(this.t, charSequence, n).a0();
    }
    
    void K0(final com.alphainventor.filemanager.file.n n, final int n2, final CharSequence charSequence, final List<String> list) {
        ax.u3.B.O(this.t, charSequence, 0, 2131952309, false, (View$OnClickListener)new c(this, list, n2, n) {
            final List c;
            final int d;
            final com.alphainventor.filemanager.file.n e;
            final ImageViewerActivity f;
            
            public void a(final View view) {
                ax.Q2.a.i().m("menu_image_viewer", "undo_delete").c("loc", "image_viewer").e();
                final ImageViewerActivity f = this.f;
                ax.W2.x.m((s)f, f.q, this.c, (h$a)new h$a(this) {
                    final ImageViewerActivity$k a;
                    
                    public void a(final h$b h$b, final String s, final String s2, final ArrayList<String> list, final Object o) {
                        if (h$b == h$b.c0) {
                            final c a = this.a;
                            int n;
                            if (a.d > a.f.n.size()) {
                                n = this.a.f.n.size();
                            }
                            else {
                                n = this.a.d;
                            }
                            final c a2 = this.a;
                            a2.f.n.add(n, (Object)a2.e);
                            this.a.f.j().A0(n);
                            ((com.alphainventor.filemanager.viewer.b)this.a.f.j()).e1();
                            this.a.f.J0((CharSequence)s, -1);
                            return;
                        }
                        this.a.f.J0((CharSequence)s, 0);
                    }
                    
                    public void b() {
                    }
                });
            }
        }).a0();
    }
    
    public boolean d() {
        return this.l.u();
    }
    
    public void e(final int n) {
        if (n == 1) {
            this.l.p();
        }
    }
    
    public void f() {
        this.l.q();
    }
    
    protected f f0() {
        final com.alphainventor.filemanager.viewer.c.a a = com.alphainventor.filemanager.viewer.c.b().a(((Activity)this).getIntent().getStringExtra(ImageViewerActivity.H));
        if (a != null) {
            this.n = a.a;
            this.r = a.b;
        }
        ((Activity)this).getIntent().putExtra("photo_index", this.r);
        return new com.alphainventor.filemanager.viewer.b((f$g)this, this.n, this.q);
    }
    
    public View findViewById(final int n) {
        return ((ax.n.c)this).getDelegate().l(n);
    }
    
    public void i() {
        final Uri v0 = ((com.alphainventor.filemanager.viewer.b)this.j()).V0();
        if (v0 != null) {
            final com.alphainventor.filemanager.file.n k0 = this.k0(v0);
            if (k0 != null) {
                final ax.c3.z g = k0.G();
                final ax.c3.z e0 = ax.c3.z.e0;
                boolean b = true;
                if (g == e0 && !this.M0(k0)) {
                    this.s.t(2131362516, false);
                }
                else {
                    this.s.t(2131362516, true);
                }
                if (!this.r0()) {
                    if (this.q.e0(k0)) {
                        this.s.o(2131362506, true);
                    }
                    else {
                        this.s.o(2131362506, false);
                    }
                    if (!Q.E1() || !(k0 instanceof y) || k0.G() != ax.c3.z.f0 || !this.p0(k0.A()) || !this.i0(((y)k0).B0())) {
                        b = false;
                    }
                    this.s.t(2131362535, b);
                }
                this.v0();
            }
        }
    }
    
    public f j() {
        return this.j;
    }
    
    View l0() {
        final Toolbar toolbar = (Toolbar)this.findViewById(2131362981);
        ((ViewGroup)toolbar).setTouchscreenBlocksFocus(false);
        final View child = ((ViewGroup)toolbar).getChildAt(0);
        if (!(child instanceof p)) {
            ax.u3.b.e("not work anymore");
            return child;
        }
        if (toolbar.getNavigationContentDescription() != null && toolbar.getNavigationContentDescription().equals(child.getContentDescription())) {
            child.setId(16908332);
            return child;
        }
        ax.u3.b.e("not work anymore");
        return child;
    }
    
    public Fragment m() {
        return (Fragment)this.x;
    }
    
    public com.android.ex.photo.a o() {
        if (this.k == null) {
            ((ax.n.c)this).setSupportActionBar((Toolbar)this.findViewById(2131362981));
            this.k = new b(((ax.n.c)this).getSupportActionBar());
        }
        return (com.android.ex.photo.a)this.k;
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        this.j.d0(n, n2, intent);
        if (n == ImageViewerActivity.G) {
            if (n2 == -1) {
                this.A0();
                return;
            }
            if (n2 == 0) {
                this.l.p();
                if (this.j.s()) {
                    this.j.n();
                }
            }
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final PhotoViewPager v = this.j().V();
        if (v != null) {
            final int currentItem = ((ViewPager)v).getCurrentItem();
            ((ViewPager)v).setAdapter(((ViewPager)v).getAdapter());
            ((ViewPager)v).setCurrentItem(currentItem);
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final M x = (M)((androidx.fragment.app.f)this).getSupportFragmentManager().k0("headless_fragment");
        this.x = x;
        if (x == null) {
            this.x = M.K2("ImageViewerActivity");
            ((androidx.fragment.app.f)this).getSupportFragmentManager().o().e((Fragment)this.x, "headless_fragment").i();
        }
        this.o = (ax.Q2.f)((Activity)this).getIntent().getSerializableExtra("location");
        final Intent intent = ((Activity)this).getIntent();
        boolean b = false;
        final boolean b2 = false;
        this.p = intent.getIntExtra("location_key", 0);
        if (this.o == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            boolean b3 = b2;
            if (((Activity)this).getIntent().getExtras() == null) {
                b3 = true;
            }
            sb.append(b3);
            sb.append(",key:");
            sb.append(this.p);
            ax.Ha.c.h().d("ImageViewer no location").g((Object)sb.toString()).h();
            Toast.makeText((Context)this, 2131951927, 1).show();
            ((Activity)this).finish();
            return;
        }
        this.C = ((Activity)this).getIntent().getStringExtra("extra_temp_file_path");
        this.D = ((Activity)this).getIntent().getStringExtra("extra_temp_file_type");
        (this.q = ax.c3.x.d(this.o, this.p)).n0();
        (this.j = this.f0()).f0(bundle);
        this.l = new E(this.findViewById(2131362846), this.j.V(), (E$d)new E$d(this) {
            final ImageViewerActivity a;
            
            public void a(final boolean b) {
                if (b) {
                    this.a.j.E0(false);
                }
                if (this.a.j.s()) {
                    this.a.j.n();
                }
                if (((Activity)this.a).getWindow() != null) {
                    ((Activity)this.a).getWindow().clearFlags(128);
                }
            }
            
            public void b(final boolean b) {
                if (b) {
                    this.a.j.E0(false);
                }
                if (((Activity)this.a).getWindow() != null) {
                    ((Activity)this.a).getWindow().clearFlags(128);
                }
            }
            
            public void c(final boolean b) {
                if (b) {
                    this.a.j.E0(true);
                }
                this.a.v0();
                if (((Activity)this.a).getWindow() != null) {
                    ((Activity)this.a).getWindow().addFlags(128);
                }
            }
        });
        final List<com.alphainventor.filemanager.file.n> n = this.n;
        if (n != null && n.size() != 0) {
            if (!this.q.a()) {
                if (this.q.u() instanceof com.alphainventor.filemanager.file.b && !((com.alphainventor.filemanager.file.b)this.q.u()).e1()) {
                    final ax.Ha.b b4 = ax.Ha.c.h().f().b("IMAGEVIEWER NOT CONNECTED OPERATOR ARCHIVE");
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("location:");
                    sb2.append(this.o.I());
                    sb2.append(",");
                    sb2.append(this.p);
                    sb2.append(",");
                    if (bundle != null) {
                        b = true;
                    }
                    sb2.append(b);
                    b4.g((Object)sb2.toString()).h();
                    Toast.makeText((Context)this, 2131951927, 1).show();
                    ((Activity)this).finish();
                    return;
                }
                final ax.Ha.b b5 = ax.Ha.c.h().f().b("IMAGEVIEWER NOT CONNECTED OPERATOR");
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("location:");
                sb3.append(this.o.I());
                b5.g((Object)sb3.toString()).h();
            }
            this.d0();
            this.t = this.findViewById(2131362848);
            this.v = this.findViewById(2131361973);
            this.w = this.findViewById(2131361990);
            ((ComponentActivity)this).getOnBackPressedDispatcher().h((ax.G0.h)this, this.F);
            return;
        }
        ((Activity)this).finish();
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        final f j = this.j;
        return (j != null && j.g0(menu)) || super.onCreateOptionsMenu(menu);
    }
    
    protected void onDestroy() {
        final f j = this.j;
        if (j != null) {
            j.h0();
        }
        final o q = this.q;
        if (q != null) {
            q.k0(false);
        }
        try {
            super.onDestroy();
        }
        catch (final IllegalArgumentException ex) {}
        if (!this.r0() || this.E) {
            return;
        }
        try {
            new File(this.C).delete();
        }
        catch (final Exception ex2) {}
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (this.l.u()) {
            return super.onKeyDown(n, keyEvent);
        }
        this.l.p();
        if (keyEvent.isMetaPressed() || keyEvent.isShiftPressed() || keyEvent.isAltPressed()) {
            return super.onKeyDown(n, keyEvent);
        }
        if (n != 112) {
            switch (n) {
                case 21:
                case 22: {
                    final boolean onKeyDown = super.onKeyDown(n, keyEvent);
                    if (!this.q0()) {
                        final View currentFocus = ((Activity)this).getCurrentFocus();
                        if (currentFocus != null) {
                            final Toolbar toolbar = (Toolbar)this.findViewById(2131362981);
                            final ViewGroup viewGroup = (ViewGroup)this.findViewById(2131361934);
                            if (this.o0((ViewGroup)toolbar, currentFocus) || this.o0(viewGroup, currentFocus)) {
                                this.j().u0();
                            }
                        }
                    }
                    return onKeyDown;
                }
                case 19:
                case 20: {
                    if (this.j().s()) {
                        this.m0(n);
                        return true;
                    }
                    final View currentFocus2 = ((Activity)this).getCurrentFocus();
                    if (currentFocus2 == null) {
                        this.m0(n);
                        return true;
                    }
                    final Toolbar toolbar2 = (Toolbar)this.findViewById(2131362981);
                    final ViewGroup viewGroup2 = (ViewGroup)this.findViewById(2131361934);
                    if (this.o0((ViewGroup)toolbar2, currentFocus2)) {
                        if (n == 20) {
                            this.j().n();
                            return true;
                        }
                        break;
                    }
                    else {
                        if (!this.o0(viewGroup2, currentFocus2)) {
                            this.m0(n);
                            return true;
                        }
                        if (n == 19) {
                            this.j().n();
                            return true;
                        }
                        break;
                    }
                    break;
                }
            }
            return super.onKeyDown(n, keyEvent);
        }
        this.w0(2131362506);
        return true;
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        return this.j.l0(menuItem) || super.onOptionsItemSelected(menuItem) || this.w0(menuItem.getItemId());
    }
    
    protected void onPause() {
        this.j.m0();
        super.onPause();
    }
    
    public boolean onPrepareOptionsMenu(final Menu menu) {
        final f j = this.j;
        return (j != null && j.n0(menu)) || super.onPrepareOptionsMenu(menu);
    }
    
    protected void onResume() {
        super.onResume();
        this.j.o0();
        this.e0();
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.j.p0(bundle);
    }
    
    protected void onStart() {
        super.onStart();
        this.j.q0();
        if (Q.N1()) {
            ax.X2.v.s(((Activity)this).getWindow(), -1157627904);
            ax.X2.v.r(((Activity)this).getWindow(), -1157627904);
        }
    }
    
    protected void onStop() {
        this.j.r0();
        this.l.p();
        super.onStop();
    }
    
    public void p() {
        final f j = this.j;
        if (j != null) {
            if (!this.B) {
                this.F.j(j.b0());
            }
        }
    }
    
    public void q(final boolean b) {
        if (((ax.n.c)this).getSupportActionBar() != null && this.s != null) {
            if (b) {
                ((ax.n.c)this).getSupportActionBar().n();
                this.s.y(8);
            }
            else {
                ((ax.n.c)this).getSupportActionBar().J();
                this.s.y(0);
                this.s.A();
                if (this.j() != null && this.j().B()) {
                    this.j().c(false);
                }
                this.l.p();
            }
            this.x0();
            return;
        }
        ax.u3.b.f();
    }
    
    public boolean r() {
        return this.l.v();
    }
    
    public ax.n.c s() {
        return (ax.n.c)this;
    }
    
    public void x0() {
        if (this.j() == null) {
            return;
        }
        final boolean b = this.j().B();
        final int n = 0;
        final boolean b2 = !b && this.u;
        final View w = this.w;
        int visibility;
        if (b2) {
            visibility = n;
        }
        else {
            visibility = 8;
        }
        w.setVisibility(visibility);
    }
    
    public void y0() {
        this.z0();
    }
    
    void z0() {
        final Fragment k0 = ((androidx.fragment.app.f)this).getSupportFragmentManager().k0("dialog");
        if (k0 != null) {
            final androidx.fragment.app.t o = ((androidx.fragment.app.f)this).getSupportFragmentManager().o();
            o.q(k0);
            o.j();
        }
    }
    
    static class m
    {
        CharSequence a;
        Drawable b;
        
        m(final CharSequence a, final Drawable b) {
            this.a = a;
            this.b = b;
        }
    }
    
    class n extends q<Void, Integer, Boolean>
    {
        private com.alphainventor.filemanager.file.n h;
        final ImageViewerActivity i;
        
        n(final ImageViewerActivity i, final com.alphainventor.filemanager.file.n h) {
            this.i = i;
            super(q$e.e0);
            this.h = h;
        }
        
        protected void o() {
        }
        
        protected void r() {
            super.r();
        }
        
        protected Boolean w(final Void... array) {
            return this.i.C0(this.h);
        }
        
        protected void x(final Boolean b) {
            if (b) {
                ((com.alphainventor.filemanager.viewer.b)this.i.j()).f1();
                return;
            }
            Toast.makeText((Context)this.i, 2131951927, 0).show();
        }
    }
}
