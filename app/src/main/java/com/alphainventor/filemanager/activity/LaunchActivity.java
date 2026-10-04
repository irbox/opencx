package com.alphainventor.filemanager.activity;

import ax.u3.q;
import ax.R2.e;
import ax.c3.F;
import ax.c3.A;
import ax.R2.d;
import ax.c3.d0;
import ax.c3.K;
import ax.c3.N;
import ax.X2.Q;
import android.os.Bundle;
import ax.c3.x;
import ax.c3.h;
import android.content.Intent;
import ax.b3.j;
import ax.u3.b;
import android.app.Activity;
import ax.c3.u;
import com.alphainventor.filemanager.file.n;
import ax.c3.w;
import com.alphainventor.filemanager.file.y;
import java.io.File;
import android.widget.Toast;
import ax.c3.h$a;
import ax.c3.W;
import android.content.res.AssetFileDescriptor;
import java.io.FileNotFoundException;
import android.content.Context;
import ax.c3.B;
import ax.c3.z;
import android.net.Uri;
import android.view.View;
import ax.n.c;

public class LaunchActivity extends c
{
    private View a;
    
    private void H(final Uri uri, final String s, final z z) throws FileNotFoundException {
        this.L();
        this.I(((Context)this).getContentResolver().openAssetFileDescriptor(uri, "r"), B.x((Context)this, uri, (String)null), s, z);
    }
    
    private void I(final AssetFileDescriptor assetFileDescriptor, final W w, final String s, final z z) {
        this.a.setVisibility(0);
        ((q)new h((Context)this, assetFileDescriptor, w, z, (h$a)new h$a(this, z, s) {
            final z a;
            final String b;
            final LaunchActivity c;
            
            public void a(final Throwable t) {
                this.c.a.setVisibility(8);
                if (t != null) {
                    t.printStackTrace();
                }
                if (t instanceof FileNotFoundException) {
                    Toast.makeText((Context)this.c, 2131952548, 1).show();
                }
                else {
                    Toast.makeText((Context)this.c, 2131951934, 1).show();
                }
                ((Activity)this.c).finish();
            }
            
            public void b(final File file) {
                this.c.a.setVisibility(8);
                try {
                    final String absolutePath = file.getAbsolutePath();
                    final z a = this.a;
                    if (a == z.f0) {
                        final Intent d = w.d((Context)this.c, (n)y.I0(absolutePath), false);
                        d.putExtra("extra_temp_file_path", absolutePath);
                        d.putExtra("extra_temp_file_type", this.b);
                        ((Context)this.c).startActivity(d);
                    }
                    else if (a == z.c0) {
                        u.f0((Activity)this.c, absolutePath, this.b);
                    }
                    else if (a == z.i0) {
                        ((Context)this.c).startActivity(w.h((Context)this.c, absolutePath));
                    }
                    else {
                        ax.u3.b.f();
                    }
                }
                catch (final j j) {
                    Toast.makeText((Context)this.c, 2131951934, 1).show();
                }
                ((Activity)this.c).finish();
            }
        })).i((Object[])new Void[0]);
    }
    
    private void J(final String s) {
        u.d0((Context)this, Uri.parse(B.U(x.g(s).T(), s)));
    }
    
    private void L() {
        this.setContentView(2131558439);
        this.a = this.findViewById(2131362712);
    }
    
    private void M(final Intent intent) {
        final Intent f = u.F((Context)this, intent.getAction(), intent.getData(), intent.getType());
        f.putExtras(intent);
        ((Context)this).startActivity(f);
    }
    
    protected void onCreate(Bundle bundle) {
        int n = 1;
        ax.Q2.b.f((Context)this, true);
        super.onCreate(bundle);
        final Intent intent = ((Activity)this).getIntent();
        final String action = intent.getAction();
        Label_1124: {
            if ("android.intent.action.VIEW".equals((Object)action) && intent.getData() != null && "com.android.mtp.documents".equals((Object)intent.getData().getHost())) {
                if (Q.k1()) {
                    final Intent e = u.E((Context)this, action, intent.getData());
                    e.putExtras(intent);
                    ((Context)this).startActivity(e);
                }
                else {
                    Toast.makeText((Context)this, 2131951927, 1).show();
                }
            }
            else if ("android.intent.action.VIEW".equals((Object)action) && intent.getData() != null && "media".equals((Object)intent.getData().getHost())) {
                final String a = N.a((Context)this, intent.getData());
                if (a != null) {
                    final K i = K.i;
                    final String e2 = i.e();
                    if (e2 != null && d0.H(e2, a)) {
                        u.d0((Context)this, Uri.parse(B.U(i, a)));
                    }
                    else {
                        this.J(a);
                    }
                }
                else {
                    Toast.makeText((Context)this, 2131951935, 1).show();
                }
            }
            else {
                final boolean equals = "android.intent.action.VIEW".equals((Object)action);
                final int n2 = 0;
                final int n3 = 0;
                final int n4 = 0;
                final int n5 = 0;
                if (equals && "resource/folder".equals((Object)intent.getType())) {
                    int n6 = n5;
                    if (intent.getData() != null) {
                        n6 = n5;
                        if ("content".equals((Object)intent.getData().getScheme())) {
                            final String path = intent.getData().getPath();
                            Label_0365: {
                                if (path != null && path.startsWith("/external_files/")) {
                                    final String substring = path.substring(15);
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("/storage/emulated/0");
                                    sb.append(substring);
                                    final String string = sb.toString();
                                    if (new File(string).exists()) {
                                        this.J(string);
                                        n6 = n;
                                        break Label_0365;
                                    }
                                }
                                n6 = 0;
                            }
                            if (n6 == 0 && Q.T0() && d.a(this) != null && !"com.android.externalstorage.documents".equals((Object)intent.getData().getHost())) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("invalid call from ");
                                sb2.append(intent.getData().getHost());
                                sb2.append(":");
                                sb2.append(intent.getData().getPath());
                                ax.Q2.d.c("resource/folder content", (Throwable)new Exception(sb2.toString()));
                            }
                        }
                    }
                    if (n6 == 0) {
                        this.M(intent);
                    }
                }
                else if ("android.intent.action.VIEW".equals((Object)action) && intent.getData() != null && "content".equals((Object)intent.getData().getScheme())) {
                    final String o = u.o((Context)this, intent);
                    Label_1072: {
                        Label_1054: {
                            try {
                                if (A.r(o)) {
                                    this.H(intent.getData(), o, z.c0);
                                    return;
                                }
                            }
                            catch (final RuntimeException ex) {
                                break Label_1054;
                            }
                            catch (final FileNotFoundException ex2) {
                                break Label_1072;
                            }
                            if (A.I(o)) {
                                this.H(intent.getData(), o, z.f0);
                                return;
                            }
                            bundle = null;
                            Object o2 = null;
                            Label_0683: {
                                try {
                                    final Object openAssetFileDescriptor = ((Context)this).getContentResolver().openAssetFileDescriptor(intent.getData(), "r");
                                    int n7 = n2;
                                    if (openAssetFileDescriptor == null) {
                                        break Label_0683;
                                    }
                                    o2 = openAssetFileDescriptor;
                                    bundle = (Bundle)openAssetFileDescriptor;
                                    final String y = B.y((AssetFileDescriptor)openAssetFileDescriptor);
                                    n7 = n2;
                                    if (y == null) {
                                        break Label_0683;
                                    }
                                    o2 = openAssetFileDescriptor;
                                    bundle = (Bundle)openAssetFileDescriptor;
                                    n7 = n2;
                                    if (y.startsWith("/storage/")) {
                                        o2 = openAssetFileDescriptor;
                                        bundle = (Bundle)openAssetFileDescriptor;
                                        this.J(y);
                                        n7 = 1;
                                    }
                                    break Label_0683;
                                }
                                catch (final Exception ex3) {
                                    n = n4;
                                    if (bundle != null) {
                                        final int n7 = n3;
                                        break Label_0683;
                                    }
                                }
                                finally {
                                    if (o2 != null) {
                                        F.a((AutoCloseable)o2);
                                    }
                                    final int n7;
                                    while (true) {
                                        final Object openAssetFileDescriptor;
                                        bundle = (Bundle)openAssetFileDescriptor;
                                        break Label_0683;
                                        n = n7;
                                        iftrue(Label_0717:)(openAssetFileDescriptor == null);
                                        continue;
                                    }
                                    F.a((AutoCloseable)bundle);
                                    n = n7;
                                }
                            }
                            Label_0717: {
                                if (n != 0) {
                                    break Label_1124;
                                }
                            }
                            final String path2 = intent.getData().getPath();
                            if (path2 != null && new File(path2).exists()) {
                                this.J(path2);
                                break Label_1124;
                            }
                            if (A.T(o)) {
                                this.H(intent.getData(), o, z.i0);
                                return;
                            }
                            if (intent.getData() != null) {
                                if (Q.T0() && d.a(this) != null) {
                                    final StringBuilder sb3 = new StringBuilder();
                                    sb3.append("invalid call from ");
                                    sb3.append(e.a(d.a(this)));
                                    sb3.append(":Invalid launch mime type 1 : ");
                                    sb3.append(intent.getType());
                                    sb3.append(":");
                                    sb3.append(intent.getData().getHost());
                                    sb3.append(":");
                                    sb3.append(o);
                                    sb3.append(":");
                                    sb3.append(intent.getData().getPath());
                                    ax.Q2.d.c("invalid launch intent", (Throwable)new Exception(sb3.toString()));
                                }
                            }
                            else if (Q.T0() && d.a(this) != null) {
                                final StringBuilder sb4 = new StringBuilder();
                                sb4.append("invalid call from ");
                                sb4.append(e.a(d.a(this)));
                                sb4.append(":Invalid launch mime type 2 : ");
                                sb4.append(intent.getType());
                                sb4.append(":");
                                sb4.append(o);
                                ax.Q2.d.c("invalid launch intent 2", (Throwable)new Exception(sb4.toString()));
                            }
                            this.M(intent);
                            break Label_1124;
                        }
                        final RuntimeException ex;
                        ((Throwable)ex).printStackTrace();
                        Toast.makeText((Context)this, 2131951934, 1).show();
                        break Label_1124;
                    }
                    final FileNotFoundException ex2;
                    ((Throwable)ex2).printStackTrace();
                    Toast.makeText((Context)this, 2131951935, 1).show();
                }
                else if ("com.example.android.uamp.open_ui".equals((Object)action) || "android.intent.action.VIEW".equals((Object)action) || "android.intent.action.VIEW_DOWNLOADS".equals((Object)action)) {
                    this.M(intent);
                }
            }
        }
        ((Activity)this).finish();
    }
}
