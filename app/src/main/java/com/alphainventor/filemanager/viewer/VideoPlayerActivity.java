package com.alphainventor.filemanager.viewer;

import androidx.activity.ComponentActivity;
import android.os.BaseBundle;
import android.widget.Adapter;
import androidx.appcompat.widget.u;
import android.widget.Spinner;
import java.util.AbstractCollection;
import android.provider.Settings$System;
import android.view.OrientationEventListener;
import ax.P0.C;
import ax.P0.H$e;
import ax.P0.H$c;
import ax.P0.a0;
import ax.Q2.a$g;
import ax.P0.H$b;
import ax.P0.V;
import ax.f1.L$c;
import ax.u3.q$e;
import ax.P0.P;
import ax.l1.D$a;
import android.util.Pair;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View$OnSystemUiVisibilityChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder$Callback;
import android.view.SurfaceView;
import java.util.Locale;
import ax.i1.Z$b;
import android.os.Bundle;
import android.content.res.Configuration;
import ax.l1.n$f;
import android.view.KeyEvent;
import android.net.Uri$Builder;
import ax.c3.N;
import java.util.Iterator;
import ax.u3.q;
import androidx.appcompat.widget.p;
import com.alphainventor.filemanager.file.x;
import java.io.File;
import com.alphainventor.filemanager.provider.MyFileProvider;
import ax.a3.W;
import ax.P0.y$k$a;
import ax.c3.A;
import ax.P0.y$c;
import android.widget.Toast;
import ax.U0.m;
import ax.m1.j$b;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import ax.w3.h;
import androidx.media3.exoplayer.s;
import java.util.Random;
import ax.P0.F;
import androidx.media3.ui.SubtitleView;
import android.view.accessibility.CaptioningManager;
import android.graphics.Typeface;
import ax.S0.I;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.View$OnTouchListener;
import android.view.GestureDetector$OnGestureListener;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector$OnScaleGestureListener;
import ax.P0.H;
import ax.P0.H$d;
import ax.Y0.Z;
import androidx.media3.exoplayer.o0;
import ax.Y0.X;
import androidx.media3.exoplayer.ExoPlayer$b;
import androidx.media3.exoplayer.j;
import ax.P0.T;
import ax.l1.D$b;
import android.text.TextUtils;
import ax.l1.a$b;
import ax.X2.J;
import ax.Z2.k;
import ax.u3.o;
import ax.X2.Q;
import ax.S0.d0;
import java.util.Collections;
import java.util.ArrayList;
import android.content.res.Resources;
import android.content.Intent;
import android.view.WindowManager$LayoutParams;
import ax.o.a;
import ax.S2.b$c;
import android.app.Activity;
import ax.S2.b$a;
import ax.P0.v;
import ax.u3.B;
import android.view.MotionEvent;
import android.content.Context;
import ax.t3.l;
import android.view.ScaleGestureDetector;
import androidx.media3.ui.G;
import androidx.appcompat.widget.MySpinner;
import ax.c3.K;
import android.widget.ImageButton;
import androidx.media3.ui.d;
import java.util.List;
import androidx.media3.ui.PlayerView;
import android.net.Uri;
import ax.P0.y;
import androidx.media3.exoplayer.ExoPlayer;
import ax.i1.O;
import ax.U0.g$a;
import androidx.media3.ui.b;
import android.graphics.drawable.Drawable;
import android.view.View$OnClickListener;
import ax.P0.V$a;
import ax.r7.z;
import android.view.GestureDetector$SimpleOnGestureListener;
import ax.l1.n$e;
import android.view.ScaleGestureDetector$SimpleOnScaleGestureListener;
import ax.l1.n;
import androidx.media3.ui.G$a;
import ax.i.r;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.snackbar.Snackbar;
import androidx.media3.ui.AspectRatioFrameLayout;
import android.widget.ProgressBar;
import android.widget.ImageView;
import android.os.Handler;
import android.media.AudioManager;
import android.view.View;
import android.widget.TextView;
import java.util.logging.Logger;
import androidx.media3.ui.d$m;
import ax.n.c;

public class VideoPlayerActivity extends ax.n.c implements d$m, c
{
    private static final Logger S1;
    private static boolean T1;
    private static boolean U1;
    private TextView A;
    private boolean A0;
    private boolean A1;
    private View B;
    private AudioManager B0;
    private Handler B1;
    private ImageView C;
    private boolean C0;
    private int C1;
    private ProgressBar D;
    private int D0;
    private int D1;
    private TextView E;
    private int E0;
    private g E1;
    private AspectRatioFrameLayout F;
    private boolean F0;
    int F1;
    private Snackbar G;
    private float G0;
    int G1;
    private View H;
    private boolean H0;
    u H1;
    private Toolbar I;
    private int I0;
    boolean I1;
    private ViewGroup J;
    private boolean J0;
    r J1;
    private ViewGroup K;
    private boolean K0;
    Runnable K1;
    private View L;
    private long L0;
    G$a L1;
    private View M;
    private long M0;
    Runnable M1;
    private View N;
    private n N0;
    private ScaleGestureDetector$SimpleOnScaleGestureListener N1;
    private boolean O;
    private n$e O0;
    private GestureDetector$SimpleOnGestureListener O1;
    private boolean P;
    private z<V$a> P0;
    private View$OnClickListener P1;
    private String Q;
    private Drawable Q0;
    h Q1;
    private String R;
    private Drawable R0;
    private x R1;
    private androidx.media3.ui.b S;
    private Drawable S0;
    private TextView T;
    private Drawable T0;
    private ax.U0.g$a U;
    private Drawable U0;
    private O V;
    private Drawable V0;
    private ExoPlayer W;
    private Drawable W0;
    private ax.b1.O X;
    private Drawable X0;
    private y Y;
    private Drawable Y0;
    private Uri[] Z;
    private Drawable Z0;
    private View a;
    private Uri[] a0;
    private String a1;
    private PlayerView b;
    private Uri[] b0;
    private String b1;
    private boolean c;
    private List<Integer> c0;
    private String c1;
    private Runnable d;
    private boolean d0;
    private String d1;
    private androidx.media3.ui.d e;
    private boolean e0;
    private String e1;
    private ViewGroup f;
    private boolean[] f0;
    private String f1;
    private View g;
    private int g0;
    private String g1;
    private View h;
    private int h0;
    private String h1;
    private View i;
    private int i0;
    private String i1;
    private View j;
    private boolean j0;
    private String j1;
    private ImageButton k;
    private boolean k0;
    private float k1;
    private View l;
    private int l0;
    private float l1;
    private View m;
    private int m0;
    private boolean m1;
    private View n;
    private boolean n0;
    private int n1;
    private View o;
    private int o0;
    private long o1;
    private View p;
    private float p0;
    private String p1;
    private View q;
    private boolean q0;
    private int q1;
    private ImageButton r;
    private boolean r0;
    private boolean r1;
    private View s;
    private boolean s0;
    private boolean s1;
    private ImageView t;
    private long t0;
    private K t1;
    private ImageButton u;
    private long u0;
    private boolean u1;
    private ImageButton v;
    private boolean v0;
    private Uri v1;
    private ImageButton w;
    private int w0;
    private long w1;
    private ImageButton x;
    private int x0;
    private boolean x1;
    private MySpinner y;
    private float y0;
    private int y1;
    private View z;
    private boolean z0;
    private boolean z1;
    
    static {
        S1 = Logger.getLogger("FileManager.VideoPlayer");
        VideoPlayerActivity.T1 = false;
        VideoPlayerActivity.U1 = false;
    }
    
    public VideoPlayerActivity() {
        this.k0 = false;
        this.p0 = 1.0f;
        this.w1 = 150L;
        this.B1 = new Handler();
        this.J1 = new r(true) {
            final VideoPlayerActivity d;
            
            public void d() {
                this.d.b.V();
            }
        };
        this.K1 = (Runnable)new Runnable() {
            final VideoPlayerActivity q;
            
            public void run() {
                if (!this.q.z1) {
                    this.q.r2();
                }
            }
        };
        this.L1 = (G$a)new G$a() {
            private long a;
            final VideoPlayerActivity b;
            
            public void G(final G g, final long a) {
                if (!this.b.U2()) {
                    this.b.p2();
                    this.a = a;
                }
            }
            
            public void K(final G g, final long a) {
                this.b.n2(a, this.a > a, false);
                this.a = a;
            }
            
            public void M(final G g, final long n, final boolean b) {
                if (this.b.U2()) {
                    this.b.u0 = n;
                    this.b.o2();
                }
            }
        };
        this.M1 = (Runnable)new Runnable() {
            final VideoPlayerActivity q;
            
            public void run() {
                this.q.A.setText((CharSequence)"");
            }
        };
        this.N1 = new ScaleGestureDetector$SimpleOnScaleGestureListener() {
            float a;
            float b;
            float c;
            float d;
            final VideoPlayerActivity e;
            
            public boolean onScale(final ScaleGestureDetector scaleGestureDetector) {
                if (this.e.V2() || this.e.Z2()) {
                    return false;
                }
                if (!this.e.h3()) {
                    return false;
                }
                this.e.C4(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), this.c - scaleGestureDetector.getFocusX(), this.d - scaleGestureDetector.getFocusY());
                this.c = scaleGestureDetector.getFocusX();
                this.d = scaleGestureDetector.getFocusY();
                return true;
            }
            
            public boolean onScaleBegin(final ScaleGestureDetector scaleGestureDetector) {
                if (this.e.V2() || this.e.Z2()) {
                    return false;
                }
                if (!ax.t3.l.v((Context)this.e)) {
                    return false;
                }
                this.a = scaleGestureDetector.getFocusX();
                this.b = scaleGestureDetector.getFocusY();
                this.c = scaleGestureDetector.getFocusX();
                this.d = scaleGestureDetector.getFocusY();
                this.e.z0 = true;
                if (!this.e.h3()) {
                    this.e.D4();
                }
                return true;
            }
            
            public void onScaleEnd(final ScaleGestureDetector scaleGestureDetector) {
                if (!this.e.V2()) {
                    if (!this.e.Z2()) {
                        this.e.z0 = false;
                        this.a = 0.0f;
                        this.b = 0.0f;
                        this.c = 0.0f;
                        this.d = 0.0f;
                    }
                }
            }
        };
        this.O1 = new GestureDetector$SimpleOnGestureListener() {
            float a;
            float b;
            long c;
            float d;
            float e;
            final VideoPlayerActivity f;
            
            private void a() {
                this.e = 0.0f;
                this.d = 0.0f;
            }
            
            public boolean onDoubleTap(final MotionEvent motionEvent) {
                this.f.b2();
                if (this.f.W == null) {
                    return false;
                }
                final int width = ((View)this.f.b).getWidth();
                if (width > 0) {
                    final int n = width / 3;
                    final int n2 = width * 2 / 3;
                    if (motionEvent.getX() < n) {
                        if (!ax.t3.l.s((Context)this.f)) {
                            return false;
                        }
                        this.f.m2(false);
                        return true;
                    }
                    else if (motionEvent.getX() > n2) {
                        if (!ax.t3.l.s((Context)this.f)) {
                            return false;
                        }
                        this.f.m2(true);
                        return true;
                    }
                }
                final int i = ((H)this.f.W).i();
                if (i != 2 && i != 3) {
                    if (i == 4) {
                        this.f.a4();
                    }
                }
                else {
                    this.f.c4();
                }
                return true;
            }
            
            public boolean onDoubleTapEvent(final MotionEvent motionEvent) {
                return true;
            }
            
            public boolean onDown(final MotionEvent motionEvent) {
                return true;
            }
            
            public boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
                return this.f.W != null && Math.abs(n) >= Math.abs(n2);
            }
            
            public void onLongPress(final MotionEvent motionEvent) {
                if (!this.f.h3()) {
                    if (!this.f.Z2()) {
                        if (ax.t3.l.q((Context)this.f)) {
                            this.f.l3();
                        }
                    }
                }
            }
            
            public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, float n, float n2) {
                final ExoPlayer n3 = this.f.W;
                boolean b = false;
                if (n3 == null) {
                    return false;
                }
                if (motionEvent != null) {
                    if (motionEvent2 != null) {
                        this.f.b2();
                        if (this.f.h3()) {
                            if (!this.f.c3()) {
                                final VideoPlayerActivity f = this.f;
                                f.p3(f.y0, n, n2);
                                return true;
                            }
                            return false;
                        }
                        else {
                            if (this.f.Z2()) {
                                this.a();
                                return false;
                            }
                            if (!this.f.V2()) {
                                if (motionEvent2.getPointerCount() > 1) {
                                    if (motionEvent2.getPointerCount() == 2) {
                                        this.d = motionEvent.getX();
                                        this.e = motionEvent2.getX();
                                    }
                                    return false;
                                }
                                if (Math.abs(n) < Math.abs(n2)) {
                                    if (Math.abs(motionEvent.getY() - motionEvent2.getY()) < this.f.x0) {
                                        return false;
                                    }
                                    int n4;
                                    if (this.f.a.getHeight() < this.f.C1 * 10) {
                                        n4 = this.f.C1;
                                    }
                                    else if (this.f.a.getHeight() < this.f.D1 * 10) {
                                        n4 = this.f.D1;
                                    }
                                    else {
                                        n4 = this.f.a.getHeight() / 10;
                                    }
                                    if (motionEvent.getY() < n4 || motionEvent.getY() > this.f.a.getHeight() - n4) {
                                        return false;
                                    }
                                    this.b = motionEvent.getY();
                                    if (this.f.b != null && motionEvent.getX() < ((View)this.f.b).getWidth() / 2) {
                                        if (!ax.t3.l.o((Context)this.f)) {
                                            return false;
                                        }
                                        this.f.V1();
                                    }
                                    else {
                                        if (!ax.t3.l.u((Context)this.f)) {
                                            return false;
                                        }
                                        this.f.A4();
                                    }
                                }
                                else {
                                    if (Math.abs(motionEvent.getX() - motionEvent2.getX()) < this.f.w0) {
                                        return false;
                                    }
                                    this.a = motionEvent.getX();
                                    this.c = ((H)this.f.W).s0();
                                    if (!ax.t3.l.t((Context)this.f)) {
                                        return false;
                                    }
                                    this.f.p2();
                                }
                            }
                            if (!this.f.V2()) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("what case is this : ");
                                sb.append(this.a);
                                sb.append(",");
                                sb.append(motionEvent.getX());
                                ax.u3.b.e(sb.toString());
                                return true;
                            }
                            if (this.f.U2()) {
                                final float x = motionEvent2.getX();
                                n2 = this.a;
                                final long n5 = this.c + ax.u3.B.f((Context)this.f, (int)(x - n2)) * 40000L / 360L;
                                long g0;
                                if ((g0 = ((H)this.f.W).g0()) == -9223372036854775807L) {
                                    g0 = 0L;
                                }
                                long n6;
                                if (n5 < 0L) {
                                    n6 = 0L;
                                }
                                else {
                                    n6 = n5;
                                    if (n5 > g0) {
                                        n6 = g0;
                                    }
                                }
                                final VideoPlayerActivity f2 = this.f;
                                if (n > 0.0f) {
                                    b = true;
                                }
                                f2.n2(n6, b, true);
                                return true;
                            }
                            if (this.f.g3()) {
                                n = this.b;
                                n2 = motionEvent2.getY();
                                this.f.D3(ax.u3.B.f((Context)this.f, (int)(n - n2)));
                                return true;
                            }
                            if (this.f.S2()) {
                                n = this.b;
                                n2 = motionEvent2.getY();
                                this.f.C3(ax.u3.B.f((Context)this.f, (int)(n - n2)));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            
            public boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
                this.f.b2();
                this.f.a4();
                return true;
            }
            
            public boolean onSingleTapUp(final MotionEvent motionEvent) {
                return true;
            }
        };
        this.P1 = (View$OnClickListener)new ax.g3.c() {
            final VideoPlayerActivity c;
            
            public void a(final View view) {
                switch (view.getId()) {
                    default: {
                        return;
                    }
                    case 2131362092: {
                        this.c.j3(false);
                        return;
                    }
                    case 2131362091: {
                        this.c.b4();
                        return;
                    }
                    case 2131362090: {
                        this.c.g4();
                        return;
                    }
                    case 2131362088: {
                        this.c.f4();
                        return;
                    }
                    case 2131362087: {
                        this.c.B3();
                        return;
                    }
                    case 2131362086: {
                        this.c.e4();
                        return;
                    }
                    case 2131362085: {
                        this.c.d4();
                        return;
                    }
                    case 2131362084: {
                        this.c.u3();
                        return;
                    }
                    case 2131362083: {
                        this.c.n3();
                        return;
                    }
                    case 2131362082: {
                        this.c.F3(true);
                        return;
                    }
                    case 2131362081: {
                        this.c.j3(true);
                        return;
                    }
                    case 2131362080: {
                        this.c.F3(false);
                        return;
                    }
                    case 2131362079: {
                        this.c.d2();
                    }
                }
            }
        };
        this.Q1 = new h() {
            final VideoPlayerActivity a;
            
            @Override
            public void a(final boolean b) {
                VideoPlayerActivity.U1 = true;
                if (!b) {
                    VideoPlayerActivity.T1 = true;
                    return;
                }
                VideoPlayerActivity.T1 = false;
            }
        };
    }
    
    private String A2(final z<V$a> z, final String s) {
        if (z == null) {
            return null;
        }
        for (int i = 0; i < ((AbstractCollection)z).size(); ++i) {
            final V$a v$a = (V$a)((List)z).get(i);
            for (int j = 0; j < v$a.a; ++j) {
                final ax.P0.v b = v$a.b(j);
                if (b != null) {
                    final String o = b.o;
                    if (o != null && o.startsWith(s)) {
                        return b.o;
                    }
                }
            }
        }
        return null;
    }
    
    private void A3() {
        if (this.P) {
            this.e2();
        }
        this.J0 = true;
        if (this.O2()) {
            if (this.Q2()) {
                ((View)this.K).setBackgroundColor(0);
                this.N = ax.S2.b.j((Activity)this, (b$a)new b$a(this) {
                    final VideoPlayerActivity a;
                });
                return;
            }
            ((View)this.K).setBackgroundColor(-1);
            ax.S2.b.k((Activity)this, (b$c)new b$c(this) {
                final VideoPlayerActivity a;
            });
        }
    }
    
    private void A4() {
        if (this.B0 == null && (this.B0 = (AudioManager)((Context)this).getSystemService("audio")) == null) {
            return;
        }
        this.D0 = this.B0.getStreamMaxVolume(3);
        this.E0 = this.B0.getStreamVolume(3);
        this.C0 = true;
        this.B.setVisibility(0);
        this.C.setImageResource(2131231200);
        this.D.setProgressDrawable(ax.o.a.b((Context)this, 2131231547));
        this.D.setMax(this.D0);
    }
    
    private int B2() {
        final Uri[] a0 = this.a0;
        if (a0 == null) {
            return 0;
        }
        return a0.length;
    }
    
    private void B3() {
        if (this.R1 == null) {
            this.R1 = new x((Activity)this, this.B1);
        }
        this.R1.d();
    }
    
    private void B4() {
        this.A0 = false;
        this.y0 = 1.0f;
        this.f2();
    }
    
    private void C3(int progress) {
        final int n = 255;
        progress = progress * 255 / 360;
        progress += (int)(this.G0 * 255.0f);
        if (progress > 255) {
            progress = n;
        }
        else if (progress < 0) {
            progress = 0;
        }
        final WindowManager$LayoutParams attributes = ((Activity)this).getWindow().getAttributes();
        attributes.screenBrightness = progress / 255.0f;
        ((Activity)this).getWindow().setAttributes(attributes);
        this.D.setProgress(progress);
    }
    
    private void C4(float a2, float a3, final float n, final float n2, final float n3) {
        if (!this.d3()) {
            this.f2();
            return;
        }
        final float y0 = this.y0 * a2;
        this.y0 = y0;
        if (y0 < 1.0f) {
            this.y0 = 1.0f;
        }
        else if (y0 > 3.0f) {
            this.y0 = 3.0f;
        }
        if (Float.isNaN(this.y0)) {
            this.y0 = 1.0f;
            this.f2();
            return;
        }
        ((View)this.F).setScaleX(this.y0);
        ((View)this.F).setScaleY(this.y0);
        final float n4 = ((View)this.b).getWidth() / 2.0f;
        final float n5 = ((View)this.b).getHeight() / 2.0f;
        final float translationX = ((View)this.F).getTranslationX();
        final float translationY = ((View)this.F).getTranslationY();
        a3 = this.a2(translationX, n4, a3, a2);
        a2 = this.a2(translationY, n5, n, a2);
        this.p3(this.y0, a3 + n2, a2 + n3);
    }
    
    private boolean D2() {
        return this.J0;
    }
    
    private void D3(int progress) {
        if (this.B0 != null || (this.B0 = (AudioManager)((Context)this).getSystemService("audio")) != null) {
            final int d0 = this.D0;
            progress = progress * d0 / 360;
            progress += this.E0;
            if (progress > d0) {
                progress = d0;
            }
            else if (progress < 0) {
                progress = 0;
            }
            try {
                this.B0.setStreamVolume(3, progress, 0);
                this.D.setProgress(progress);
            }
            catch (final SecurityException ex) {
                ax.Q2.d.c("video set volume exception", (Throwable)ex);
            }
        }
    }
    
    private void D4() {
        this.A0 = true;
    }
    
    private static boolean E2(final Uri[] array) {
        for (final Uri uri : array) {
            if (ax.c3.B.L(uri.getScheme())) {
                if (uri.getHost() == null) {
                    return true;
                }
                if (uri.getHost().startsWith(".")) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void E3(final boolean enabled, final View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(enabled);
        float alpha;
        if (enabled) {
            alpha = this.k1;
        }
        else {
            alpha = this.l1;
        }
        view.setAlpha(alpha);
        view.setVisibility(0);
    }
    
    private void F2() {
        final ax.n.a supportActionBar = this.getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.n();
    }
    
    private void F3(final boolean n0) {
        ax.t3.l.j((Context)this, this.n0 = n0);
        this.n4();
        this.invalidateOptionsMenu();
    }
    
    private void G2() {
        final ax.n.a supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.H((CharSequence)"");
            supportActionBar.x(true);
        }
    }
    
    private void G3() {
        this.b.setControllerShowTimeoutMs(ax.t3.l.b((Context)this) * 1000);
    }
    
    private void H2() {
        if (!ax.t3.l.p((Context)this) || !ax.P2.a.r((Context)this) || !ax.P2.a.m((Context)this)) {
            ax.P2.a.n((Context)this);
        }
    }
    
    private void H3(final int i0) {
        this.i0 = i0;
        this.o4();
    }
    
    private void I2() {
        this.n0 = ax.t3.l.a((Context)this);
        this.n4();
        this.M3(ax.t3.l.d((Context)this));
        final float p0 = this.p0;
        if (p0 != 0.0f) {
            this.L3(p0, true);
            ((AdapterView)this.y).setSelection(com.alphainventor.filemanager.viewer.d.c(this.p0));
        }
        this.u4();
    }
    
    private void I3() {
        if (this.a0 != null && this.y2() != null) {
            final Intent intent = new Intent();
            intent.setData(this.x2());
            ((Activity)this).setResult(-1, intent);
        }
    }
    
    private void J2() {
        final Resources resources = this.getResources();
        this.Q0 = ax.s3.a.c((Context)this, 2131231206);
        this.R0 = ax.s3.a.c((Context)this, 2131231208);
        this.S0 = ax.s3.a.c((Context)this, 2131231207);
        this.W0 = ax.s3.a.c((Context)this, 2131231234);
        this.X0 = ax.s3.a.c((Context)this, 2131231235);
        this.T0 = ax.s3.a.c((Context)this, 2131231019);
        this.U0 = ax.s3.a.c((Context)this, 2131231020);
        this.V0 = ax.s3.a.c((Context)this, 2131231018);
        this.Z0 = ax.s3.a.c((Context)this, 2131231024);
        this.Y0 = ax.s3.a.c((Context)this, 2131231023);
        this.a1 = resources.getString(2131952557);
        this.b1 = resources.getString(2131952559);
        this.c1 = resources.getString(2131952558);
        this.d1 = resources.getString(2131951987);
        this.e1 = resources.getString(2131951988);
        this.f1 = resources.getString(2131951986);
        this.g1 = resources.getString(2131951973);
        this.h1 = resources.getString(2131951972);
        this.i1 = resources.getString(2131951994);
        this.j1 = resources.getString(2131951993);
        this.k1 = resources.getInteger(2131427337) / 100.0f;
        this.l1 = resources.getInteger(2131427336) / 100.0f;
    }
    
    private void K2() {
        final int n = 0;
        if (this.a0 == null) {
            final Intent intent = ((Activity)this).getIntent();
            final String action = intent.getAction();
            this.g0 = -1;
            this.h0 = -1;
            if (!"android.intent.action.VIEW".equals((Object)action) || intent.getData() == null) {
                this.W3(2131951927);
                this.finish();
                return;
            }
            final ArrayList<com.alphainventor.filemanager.viewer.e.a> c = com.alphainventor.filemanager.viewer.e.b().c();
            if (c != null) {
                this.Z = new Uri[c.size()];
                this.a0 = new Uri[c.size()];
                this.b0 = new Uri[c.size()];
                this.c0 = (List<Integer>)new ArrayList();
                for (int i = 0; i < c.size(); ++i) {
                    this.c0.add((Object)i);
                }
                Collections.shuffle((List)this.c0);
                for (int j = 0; j < c.size(); ++j) {
                    final com.alphainventor.filemanager.viewer.e.a a = (com.alphainventor.filemanager.viewer.e.a)c.get(j);
                    final Uri[] z = this.Z;
                    final Uri a2 = a.a;
                    z[j] = a2;
                    this.a0[j] = this.i2(a2);
                    final Uri b = a.b;
                    if (b != null) {
                        this.b0[j] = this.i2(b);
                    }
                }
                for (int k = 0; k < this.Z.length; ++k) {
                    final int intValue = (int)this.c0.get(k);
                    final Uri uri = this.Z[k];
                    if (uri != null && uri.equals((Object)intent.getData())) {
                        this.g0 = k;
                    }
                    final Uri uri2 = this.Z[intValue];
                    if (uri2 != null && uri2.equals((Object)intent.getData())) {
                        this.h0 = k;
                    }
                }
            }
            else {
                final Logger s1 = VideoPlayerActivity.S1;
                final StringBuilder sb = new StringBuilder();
                sb.append("Video play : ");
                sb.append((Object)intent.getData());
                s1.fine(sb.toString());
                this.Z = new Uri[] { intent.getData() };
                this.a0 = new Uri[] { this.i2(intent.getData()) };
                (this.c0 = (List<Integer>)new ArrayList()).add((Object)0);
                this.b0 = new Uri[1];
            }
            final boolean booleanExtra = intent.getBooleanExtra("detect_subtitle", true);
            this.e0 = booleanExtra;
            if (booleanExtra) {
                this.f0 = new boolean[this.a0.length];
            }
            if (this.d0) {
                final int h0 = this.h0;
                if (h0 == -1) {
                    this.H3(0);
                }
                else {
                    this.H3(h0);
                }
            }
            else {
                final int g0 = this.g0;
                if (g0 == -1) {
                    this.H3(0);
                }
                else {
                    this.H3(g0);
                }
            }
            for (final Uri uri3 : this.a0) {
                if (com.alphainventor.filemanager.service.b.k((Context)this, uri3)) {
                    this.x1 = true;
                    this.s1 = true;
                    final k z2 = ax.o3.c.z(uri3.getPath());
                    if (z2 != null) {
                        this.t1 = z2.d();
                    }
                }
                else if (ax.c3.B.L(uri3.getScheme())) {
                    this.x1 = true;
                }
            }
            if (this.s1 && this.t1 != null) {
                com.alphainventor.filemanager.service.b.f((Context)this).l(true, this.t1);
            }
            final y[] array = new y[this.a0.length];
            int n2 = n;
            Uri[] a4;
            while (true) {
                a4 = this.a0;
                if (n2 >= a4.length) {
                    break;
                }
                array[n2] = ax.P0.y.b(a4[n2]);
                ++n2;
            }
            if (E2(a4) || !ax.S0.d0.m(array)) {
                this.W3(2131951927);
                return;
            }
            if (!ax.X2.Q.z0() || !ax.u3.o.c()) {
                ax.S0.d0.X0((Activity)this, this.a0);
            }
        }
    }
    
    private void K3(final boolean keepScreenOn) {
        this.a.setKeepScreenOn(keepScreenOn);
    }
    
    private void L2() {
        this.N3(ax.t3.l.f((Context)this));
        this.K2();
        if (this.a0 != null && this.W == null) {
            this.H2();
            if (ax.X2.J.i()) {
                androidx.media3.decoder.ffmpeg.b.I0(2);
            }
            final a$b a$b = new a$b();
            final ax.Y0.d d = new ax.Y0.d((Context)this);
            d.p(1);
            String q = null;
            Label_0113: {
                if (ax.t3.l.i((Context)this)) {
                    final String g = ax.t3.l.g((Context)this);
                    if (!TextUtils.isEmpty((CharSequence)g)) {
                        q = g;
                        if (!"default".equals((Object)g)) {
                            break Label_0113;
                        }
                    }
                    q = this.Q;
                }
                else {
                    q = "";
                }
            }
            this.R = q;
            (this.N0 = new t((Context)this, (D$b)a$b, q)).m((T)this.O0);
            this.P0 = null;
            final j j = new j();
            final ExoPlayer$b exoPlayer$b = new ExoPlayer$b((Context)this, (X)d);
            exoPlayer$b.m((ax.l1.J)this.N0);
            exoPlayer$b.i((o0)j);
            exoPlayer$b.k(10000L);
            exoPlayer$b.l(10000L);
            (this.W = exoPlayer$b.h()).c(ax.Y0.Z.g);
            ((H)this.W).N((H$d)new w());
            ((H)this.W).S(this.m1);
            this.W.r0((ax.Z0.c)new ax.n1.a((ax.l1.G)this.N0));
            if (this.x1) {
                this.W.a(2);
            }
            else {
                this.W.a(1);
            }
            this.b.setPlayer((H)this.W);
            this.b.G();
            this.q4();
            ((View)this.b).setOnTouchListener((View$OnTouchListener)new View$OnTouchListener(this, new ScaleGestureDetector((Context)this, (ScaleGestureDetector$OnScaleGestureListener)this.N1), new GestureDetector((Context)this, (GestureDetector$OnGestureListener)this.O1), new com.alphainventor.filemanager.viewer.a((Context)this, 1.5f, (com.alphainventor.filemanager.viewer.a.b)new com.alphainventor.filemanager.viewer.a.b(this) {
                final VideoPlayerActivity a;
                
                @Override
                public void a(final MotionEvent motionEvent) {
                    if (!this.a.h3()) {
                        if (l.r((Context)this.a)) {
                            this.a.m3();
                        }
                    }
                }
            })) {
                final ScaleGestureDetector a;
                final GestureDetector b;
                final com.alphainventor.filemanager.viewer.a c;
                final VideoPlayerActivity d;
                
                public boolean onTouch(final View view, final MotionEvent motionEvent) {
                    final boolean x = this.d.r1;
                    boolean b = false;
                    if (x) {
                        return false;
                    }
                    final boolean onTouchEvent = this.a.onTouchEvent(motionEvent);
                    if (this.b.onTouchEvent(motionEvent) || onTouchEvent) {
                        b = true;
                    }
                    this.c.g(motionEvent);
                    if (this.d.h3()) {
                        if (motionEvent.getAction() == 1 && this.d.y0 <= 1.0f) {
                            this.d.B4();
                        }
                        return true;
                    }
                    if (this.d.U2()) {
                        if (motionEvent.getAction() == 1) {
                            this.d.o2();
                        }
                        return true;
                    }
                    if (this.d.g3()) {
                        if (motionEvent.getAction() == 1) {
                            this.d.z4();
                        }
                        return true;
                    }
                    if (this.d.S2()) {
                        if (motionEvent.getAction() == 1) {
                            this.d.U1();
                        }
                        return true;
                    }
                    if (this.d.Z2()) {
                        if (motionEvent.getAction() == 1) {
                            this.d.k3();
                        }
                        return true;
                    }
                    return b;
                }
            });
        }
        final ExoPlayer w = this.W;
        if (w != null) {
            final int n1 = this.n1;
            final boolean b = n1 != -1;
            if (b) {
                ((H)w).s(n1, this.o1);
            }
            this.I2();
            this.l4();
            this.o4();
            this.r3(this.w2(), true ^ b);
        }
    }
    
    private void L3(final float p2, final boolean b) {
        final ExoPlayer w = this.W;
        if (w != null) {
            if (b) {
                this.p0 = p2;
            }
            if (((H)w).h() == null || ((H)this.W).h().a != p2) {
                if (p2 == 1.0f) {
                    ((H)this.W).e(ax.P0.G.d);
                    return;
                }
                ((H)this.W).e(new ax.P0.G(p2));
            }
        }
    }
    
    private void M2(final float n) {
        final ExoPlayer w = this.W;
        if (w != null && ((H)w).n()) {
            this.H0 = true;
            ((View)this.E).setVisibility(0);
            final I m = ((H)this.W).M();
            if (n == 0.5f) {
                this.E.setText((CharSequence)"0.5X\u25b6\u25b6");
            }
            else if (n == 2.0f) {
                this.E.setText((CharSequence)"2X\u25b6\u25b6");
            }
            else {
                ax.u3.b.f();
                final TextView e = this.E;
                final StringBuilder sb = new StringBuilder();
                sb.append(n);
                sb.append("X\u25b6\u25b6");
                e.setText((CharSequence)sb.toString());
            }
            int n2;
            if (m.a() == -1 || ((View)this.b).getHeight() == 0 || ((View)this.b).getHeight() <= m.a() || (n2 = (((View)this.b).getHeight() - m.a()) / 2 - ((View)this.E).getHeight() - ax.u3.B.e((Context)this, 10)) < 0) {
                n2 = 0;
            }
            int n3;
            if ((n3 = n2) == 0) {
                final ax.n.a supportActionBar = this.getSupportActionBar();
                int l;
                if (supportActionBar != null && supportActionBar.p()) {
                    l = supportActionBar.l();
                }
                else {
                    l = 0;
                }
                int n4;
                if (l > 0) {
                    n4 = ax.u3.B.e((Context)this, 25);
                }
                else {
                    n4 = ax.u3.B.e((Context)this, 5);
                }
                n3 = n4 + l;
            }
            final ViewGroup$MarginLayoutParams layoutParams = (ViewGroup$MarginLayoutParams)((View)this.E).getLayoutParams();
            layoutParams.setMargins(0, n3, 0, 0);
            ((View)this.E).setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            this.L3(n, false);
        }
    }
    
    private void M3(final int o0) {
        final ExoPlayer w = this.W;
        if (w == null) {
            return;
        }
        ((H)w).j(this.o0 = o0);
        this.r4();
    }
    
    private boolean N2() {
        return this.K0;
    }
    
    private void N3(final boolean d0) {
        this.d0 = d0;
        this.s4();
    }
    
    private boolean O2() {
        return this.I0 != 0;
    }
    
    private void O3(final int n, final boolean b) {
        final SubtitleView subtitleView = this.b.getSubtitleView();
        if (subtitleView == null) {
            return;
        }
        Typeface typeface;
        if (b) {
            typeface = Typeface.DEFAULT_BOLD;
        }
        else {
            typeface = Typeface.DEFAULT;
        }
        final CaptioningManager captioningManager = (CaptioningManager)((Context)this).getSystemService("captioning");
        ax.a2.a a;
        if (captioningManager != null && captioningManager.isEnabled()) {
            a = ax.a2.a.a(captioningManager.getUserStyle());
        }
        else {
            a = new ax.a2.a(-1, 0, 0, 2, -16777216, typeface);
        }
        subtitleView.setStyle(a);
        subtitleView.b(2, (float)n);
    }
    
    private boolean P2() {
        final boolean b = this.M0 != 0L && System.currentTimeMillis() - this.M0 > 90000L;
        if (b) {
            VideoPlayerActivity.S1.fine("ad is expired");
        }
        return b;
    }
    
    private void P3(final String s) {
        final ax.n.a supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.H((CharSequence)s);
        }
    }
    
    private boolean Q2() {
        final int i0 = this.I0;
        if (i0 != 33 && i0 != 34) {
            return i0 == 17 || i0 == 18;
        }
        return new Random().nextBoolean();
    }
    
    private void Q3() {
        final ax.n.a supportActionBar = this.getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.J();
    }
    
    private static boolean R2(final F f) {
        if (f instanceof s) {
            final s s = (s)f;
            if (s.k0 != 0) {
                return false;
            }
            for (Object o = s.i(); o != null; o = ((Throwable)o).getCause()) {
                if (o instanceof ax.i1.b) {
                    return true;
                }
            }
        }
        else if (f != null) {
            for (Throwable t = ((Throwable)f).getCause(); t != null; t = t.getCause()) {
                if (t instanceof ax.i1.b) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void R3(final String s) {
        final String b = ax.w3.h.b((Context)this, s);
        Snackbar g;
        if (ax.w3.d.w((Context)this, s)) {
            g = ax.u3.B.T(this.a, (CharSequence)b, -2);
            g.q0(2131951915, (View$OnClickListener)new ax.g3.c(this) {
                final VideoPlayerActivity c;
                
                public void a(final View view) {
                    this.c.H.setVisibility(0);
                    ((q)new ax.w3.d((Context)this.c, (ax.b0.a)new com.alphainventor.filemanager.viewer.f(this))).i((Object[])new Void[0]);
                }
            });
            this.G = g;
        }
        else {
            g = ax.u3.B.T(this.a, (CharSequence)b, 0);
        }
        g.a0();
    }
    
    private boolean S2() {
        return this.F0;
    }
    
    private void S3() {
    }
    
    public static final boolean T2(final int n) {
        return n == 23 || n == 66 || n == 160;
    }
    
    private void T3(final boolean b) {
        if (b) {
            this.z.setVisibility(0);
        }
        else {
            this.z.setVisibility(8);
        }
        this.k4();
    }
    
    private void U1() {
        this.F0 = false;
        this.B.setVisibility(8);
    }
    
    private boolean U2() {
        return this.s0;
    }
    
    private void U3(final boolean b) {
        final ImageView imageView = (ImageView)this.findViewById(2131362391);
        imageView.setVisibility(0);
        if (b) {
            imageView.setImageResource(2131231119);
        }
        else {
            imageView.setImageResource(2131231118);
        }
        imageView.setVisibility(0);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        ((Animation)alphaAnimation).setDuration(750L);
        ((Animation)alphaAnimation).setInterpolator((Interpolator)new DecelerateInterpolator());
        ((View)imageView).startAnimation((Animation)alphaAnimation);
        ((Animation)alphaAnimation).setAnimationListener((Animation$AnimationListener)new Animation$AnimationListener(this, imageView) {
            final ImageView a;
            final VideoPlayerActivity b;
            
            public void onAnimationEnd(final Animation animation) {
                this.a.setVisibility(8);
                final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                ((Animation)alphaAnimation).setDuration(750L);
                ((Animation)alphaAnimation).setInterpolator((Interpolator)new DecelerateInterpolator());
                ((View)this.a).startAnimation((Animation)alphaAnimation);
            }
            
            public void onAnimationRepeat(final Animation animation) {
            }
            
            public void onAnimationStart(final Animation animation) {
            }
        });
    }
    
    private void V1() {
        final float screenBrightness = ((Activity)this).getWindow().getAttributes().screenBrightness;
        if (screenBrightness >= 0.0f && screenBrightness <= 1.0f) {
            this.G0 = screenBrightness;
        }
        else {
            this.G0 = 0.5f;
        }
        this.D.setMax(255);
        this.F0 = true;
        this.B.setVisibility(0);
        this.D.setProgressDrawable(ax.o.a.b((Context)this, 2131231548));
        this.C.setImageResource(2131231199);
    }
    
    private boolean V2() {
        return this.U2() || this.g3() || this.S2();
    }
    
    private void V3(final int n) {
        ax.u3.B.S(this.a, n, 0).a0();
    }
    
    private ax.U0.g$a W1() {
        return (ax.U0.g$a)new m((Context)this, this.C2(), (ax.U0.z)new j$b((Context)this).a());
    }
    
    private boolean W2() {
        return this.z.getVisibility() == 0;
    }
    
    private void W3(final int n) {
        this.X3(((Context)this).getString(n));
    }
    
    private y X1(int z2) {
        z2 = this.z2(z2);
        if (this.e0 && !this.f0[z2]) {
            final Uri[] b0 = this.b0;
            if (b0[z2] == null) {
                b0[z2] = this.t2(this.a0[z2]);
                this.f0[z2] = true;
            }
        }
        return this.Y1(this.a0[z2], this.b0[z2], null);
    }
    
    private boolean X2() {
        return this.A1;
    }
    
    private void X3(final String s) {
        Toast.makeText((Context)this, (CharSequence)s, 1).show();
    }
    
    private y Y1(final Uri uri, final Uri uri2, final String s) {
        final y$c y$c = new y$c();
        y$c.f(uri);
        if (uri2 == null) {
            return y$c.a();
        }
        final String n = ax.c3.A.n(ax.c3.d0.f(uri2.getPath()));
        final y$k$a y$k$a = new y$k$a(uri2);
        y$k$a.l(1);
        y$k$a.k(n);
        y$c.d(Collections.singletonList((Object)y$k$a.i()));
        return y$c.a();
    }
    
    private boolean Y2() {
        if (this.y2() == null) {
            return false;
        }
        final String scheme = this.y2().getScheme();
        return "file".equals((Object)scheme) || "content".equals((Object)scheme);
    }
    
    private void Y3() {
        if (((androidx.fragment.app.f)this).getSupportFragmentManager().Q0()) {
            return;
        }
        final ExoPlayer w = this.W;
        if (w != null && ((H)w).n()) {
            this.I1 = true;
            ((H)this.W).f();
        }
        else {
            this.I1 = false;
        }
        ax.u3.B.d0(((androidx.fragment.app.f)this).getSupportFragmentManager(), (androidx.fragment.app.e)ax.a3.W.i3(), "settings", true);
    }
    
    private float Z1(float n, final int n2, float n3, float n4) {
        n3 -= n4;
        n4 = (float)n2;
        final float n5 = n4 / 2.0f;
        final float n6 = n / 2.0f;
        n = n3 + n5;
        if (n - n6 > 0.0f) {
            return n6 - n5;
        }
        if (n + n6 < n4) {
            return n5 - n6;
        }
        return n3;
    }
    
    private boolean Z2() {
        return this.H0;
    }
    
    private float a2(final float n, final float n2, final float n3, final float n4) {
        return n - (n3 - n4 * (n3 - (n + n2))) + n2;
    }
    
    private boolean a3() {
        return ax.u3.z.u((Context)this);
    }
    
    private void a4() {
        if (this.b.I()) {
            this.b.G();
            return;
        }
        this.b.V();
        this.c2();
    }
    
    private void b2() {
        if (this.X2()) {
            this.z1 = true;
            this.B1.removeCallbacks(this.K1);
        }
    }
    
    private boolean b3() {
        final int i0 = this.I0;
        return i0 == 2 || i0 == 18 || i0 == 34;
    }
    
    private void b4() {
        this.F3(this.n0 ^ true);
    }
    
    private void c2() {
        if (!this.b.getControllerAutoShow() && !this.U2()) {
            this.b.setControllerAutoShow(true);
        }
    }
    
    private boolean c3() {
        return this.z0;
    }
    
    private void c4() {
        final ExoPlayer w = this.W;
        if (w != null) {
            final boolean v = ((H)w).v();
            ((H)this.W).S(v ^ true);
            if (!v) {
                this.b.G();
            }
        }
    }
    
    private void d2() {
        this.E1.n((View)this.v);
    }
    
    private boolean d3() {
        final ExoPlayer w = this.W;
        if (w == null) {
            return false;
        }
        final I m = ((H)w).M();
        return m.a() != -1 && m.b() != -1 && ((View)this.b).getHeight() != 0;
    }
    
    private void d4() {
        final ExoPlayer w = this.W;
        if (w == null) {
            return;
        }
        ((H)w).j(ax.S0.H.a(((H)w).o(), 3));
        this.r4();
    }
    
    private void e2() {
        final View n = this.N;
        if (n != null) {
            ax.S2.b.a((Object)n, (Context)this);
        }
        this.N = null;
        this.P = false;
        this.J0 = false;
        this.K.removeAllViews();
    }
    
    private boolean e3() {
        return this.P;
    }
    
    private void e4() {
        final int resizeMode = this.b.getResizeMode();
        int resizeMode2 = 3;
        Drawable imageDrawable;
        String s;
        if (resizeMode != 0) {
            if (resizeMode != 3) {
                resizeMode2 = 0;
                if (resizeMode != 4) {
                    ax.u3.b.f();
                    imageDrawable = this.Q0;
                    s = this.a1;
                }
                else {
                    imageDrawable = this.Q0;
                    s = this.a1;
                }
            }
            else {
                imageDrawable = this.S0;
                s = this.c1;
                resizeMode2 = 4;
            }
        }
        else {
            imageDrawable = this.R0;
            s = this.b1;
        }
        this.b.setResizeMode(resizeMode2);
        ((ImageView)this.r).setImageDrawable(imageDrawable);
        ((View)this.r).setContentDescription((CharSequence)s);
        ((View)this.A).removeCallbacks(this.M1);
        this.A.setText((CharSequence)s);
        ((View)this.A).postDelayed(this.M1, 1000L);
    }
    
    private void f2() {
        ((View)this.F).setScaleX(1.0f);
        ((View)this.F).setScaleY(1.0f);
        ((View)this.F).setTranslationX(0.0f);
        ((View)this.F).setTranslationY(0.0f);
    }
    
    private boolean f3() {
        return this.y1 >= 0;
    }
    
    private void f4() {
        this.d0 ^= true;
        final int w2 = this.w2();
        if (this.d0) {
            for (int i = 0; i < this.c0.size(); ++i) {
                if (w2 == (int)this.c0.get(i)) {
                    this.H3(i);
                }
            }
        }
        else {
            this.H3((int)this.c0.get(w2));
        }
        ax.t3.l.l((Context)this, this.d0);
        this.s4();
    }
    
    private void g2() {
        this.m1 = true;
        this.n1 = -1;
        this.o1 = -9223372036854775807L;
    }
    
    private boolean g3() {
        return this.C0;
    }
    
    private void g4() {
        if (this.l0 != 1) {
            this.E1.o((View)this.v, this.Q1);
            return;
        }
        VideoPlayerActivity.U1 = true;
        if (this.k0) {
            VideoPlayerActivity.T1 = true;
            this.E1.l();
            return;
        }
        VideoPlayerActivity.T1 = false;
        this.E1.k();
    }
    
    private void h2() {
        this.K0 = true;
        this.L0 = System.currentTimeMillis();
        this.e2();
    }
    
    private boolean h3() {
        return this.A0;
    }
    
    private void h4() {
        if (!this.e.n0()) {
            this.F2();
            return;
        }
        if (this.W2()) {
            this.Q3();
            return;
        }
        if (this.r1) {
            this.F2();
            return;
        }
        this.Q3();
    }
    
    private Uri i2(final Uri uri) {
        if (!MyFileProvider.C(uri)) {
            if (MyFileProvider.B(uri)) {
                final k e = MyFileProvider.e(uri);
                final String e2 = e.e();
                final File file = new File(e2);
                final String v = ax.c3.d0.v(e.d(), e2, Boolean.FALSE);
                if (v == null || !ax.c3.d0.H("/Android", v) || !com.alphainventor.filemanager.file.x.O0(file).d1()) {
                    return Uri.fromFile(file);
                }
            }
            else if (!MyFileProvider.A(uri)) {
                MyFileProvider.E(uri);
                return uri;
            }
        }
        return uri;
    }
    
    private void i3(final boolean b) {
        if (ax.X2.Q.u0()) {
            if (b) {
                ((Activity)this).setRequestedOrientation(14);
                return;
            }
            ((Activity)this).setRequestedOrientation(-1);
        }
        else {
            if (b) {
                ((Activity)this).setRequestedOrientation(ax.u3.z.l((Activity)this));
                return;
            }
            ((Activity)this).setRequestedOrientation(-1);
        }
    }
    
    private void i4() {
        if (this.W == null) {
            return;
        }
        if (this.N2() && System.currentTimeMillis() - this.L0 > 30000L) {
            this.K0 = false;
        }
        final boolean b3 = this.b3();
        final int n = 1;
        int n2;
        if (b3) {
            n2 = n;
            if (((H)this.W).v()) {
                if (((H)this.W).i() == 4) {
                    n2 = n;
                }
                else {
                    n2 = 0;
                }
            }
        }
        else {
            n2 = ((true ^ ((H)this.W).v()) ? 1 : 0);
        }
        if (n2 == 0 || this.N2() || this.U2() || !this.O2() || this.a3()) {
            ((View)this.J).setVisibility(8);
            return;
        }
        ((View)this.J).setVisibility(0);
        if (!this.D2() || this.P2()) {
            this.A3();
        }
        if (this.e3()) {
            if (this.M0 == 0L) {
                this.M0 = System.currentTimeMillis();
            }
            if (this.O) {
                final View viewById = this.N.findViewById(2131362499);
                if (viewById != null) {
                    final int f = ax.u3.B.f((Context)this, this.getResources().getDisplayMetrics().heightPixels);
                    int n3 = 150;
                    if (f <= 360 && (n3 = 150 - (360 - f)) < 60) {
                        n3 = 60;
                    }
                    final ViewGroup$LayoutParams layoutParams = viewById.getLayoutParams();
                    layoutParams.height = ax.u3.B.e((Context)this, n3);
                    viewById.setLayoutParams(layoutParams);
                }
            }
            this.M.setVisibility(8);
            this.L.setVisibility(0);
            return;
        }
        this.M.setVisibility(0);
        this.L.setVisibility(8);
    }
    
    private void j3(final boolean r1) {
        this.r1 = r1;
        if (r1) {
            this.b.setControllerShowTimeoutMs(3000);
        }
        else {
            this.G3();
        }
        this.i3(this.r1);
        this.n4();
        this.q4();
        this.k4();
    }
    
    private void j4() {
        if (this.m0 > 1) {
            ((View)this.u).setVisibility(0);
            return;
        }
        ((View)this.u).setVisibility(8);
    }
    
    private String k2() {
        if (this.y2() == null) {
            return "";
        }
        return ax.c3.v.h(this.y2().getPath());
    }
    
    private void k3() {
        this.H0 = false;
        ((View)this.E).setVisibility(4);
        this.L3(this.p0, false);
    }
    
    private void k4() {
        this.J1.j(this.r1 && !this.W2());
    }
    
    private void l2() {
        final MySpinner y = this.y;
        if (y == null) {
            return;
        }
        y.c();
    }
    
    private void l3() {
        this.M2(2.0f);
    }
    
    private void l4() {
    }
    
    private void m2(final boolean b) {
        final ExoPlayer w = this.W;
        if (w != null) {
            final long s0 = ((H)w).s0();
            final long n = ax.t3.l.c((Context)this) * 1000L;
            long n2;
            if (b) {
                n2 = s0 + n;
            }
            else {
                n2 = s0 - n;
            }
            long g0;
            if ((g0 = ((H)this.W).g0()) == -9223372036854775807L) {
                g0 = 0L;
            }
            long n3;
            if (n2 < 0L) {
                n3 = 0L;
            }
            else {
                n3 = n2;
                if (n2 > g0) {
                    n3 = g0;
                }
            }
            if (s0 != n3) {
                this.W.c(ax.Y0.Z.c);
                ((H)this.W).t(n3);
                this.W.c(ax.Y0.Z.g);
                ((View)this.A).removeCallbacks(this.M1);
                if (b) {
                    final TextView a = this.A;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("+");
                    sb.append(ax.u3.B.n(n));
                    a.setText((CharSequence)sb.toString());
                }
                else {
                    final TextView a2 = this.A;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("-");
                    sb2.append(ax.u3.B.n(n));
                    a2.setText((CharSequence)sb2.toString());
                }
                ((View)this.A).postDelayed(this.M1, 1000L);
            }
        }
    }
    
    private void m3() {
        this.M2(0.5f);
    }
    
    private void m4() {
    }
    
    private void n2(long currentTimeMillis, final boolean v0, final boolean b) {
        if (b) {
            this.A.setText((CharSequence)ax.u3.B.n(currentTimeMillis));
        }
        this.u0 = currentTimeMillis;
        final boolean b2 = this.v0 != v0;
        this.v0 = v0;
        currentTimeMillis = System.currentTimeMillis();
        if (!b2 && currentTimeMillis - this.t0 < this.w1) {
            return;
        }
        this.p4(b2);
    }
    
    private void n3() {
        if (this.W != null) {
            if (this.w2() < this.B2() - 1) {
                this.s3();
            }
        }
    }
    
    private void n4() {
        if (this.W2()) {
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.p.setVisibility(8);
            ((View)this.r).setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            ((View)this.f).setVisibility(8);
            this.t.setVisibility(8);
            this.s.setVisibility(8);
        }
        else if (this.r1) {
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            ((View)this.f).setVisibility(8);
        }
        else if (this.n0) {
            this.g.setVisibility(8);
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.p.setVisibility(0);
            ((View)this.r).setVisibility(0);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            ((View)this.f).setVisibility(0);
            this.t.setVisibility(0);
            this.t.setImageResource(2131231112);
            ((View)this.t).setContentDescription((CharSequence)((Context)this).getString(2131952249));
            this.s.setVisibility(0);
        }
        else {
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.p.setVisibility(0);
            ((View)this.r).setVisibility(0);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            ((View)this.f).setVisibility(0);
            this.t.setVisibility(0);
            this.t.setImageResource(2131231135);
            ((View)this.t).setContentDescription((CharSequence)((Context)this).getString(2131952263));
            this.s.setVisibility(0);
        }
        this.h4();
    }
    
    private void o2() {
        this.s0 = false;
        this.A.setText((CharSequence)"");
        if (!this.q0) {
            this.b.setUseController(true);
        }
        if (this.r0) {
            final ExoPlayer w = this.W;
            if (w != null) {
                ((H)w).S(true);
            }
        }
        this.p4(false);
        this.t0 = 0L;
        this.u0 = 0L;
        this.n4();
    }
    
    private void o3() {
        if (this.W == null) {
            return;
        }
        if (this.w2() < this.B2() - 1) {
            this.s3();
            return;
        }
        this.q3();
    }
    
    private void o4() {
        final int b2 = this.B2();
        boolean b3 = false;
        final boolean b4 = b2 > 0;
        if (this.w2() < b2 - 1) {
            b3 = true;
        }
        this.E3(b4, this.o);
        this.E3(b3, this.n);
    }
    
    private void p2() {
        if (this.W != null) {
            this.s0 = true;
            if (!(this.q0 = this.b.I())) {
                this.b.setUseController(false);
                this.b.setControllerAutoShow(false);
            }
            final boolean n = ((H)this.W).n();
            this.r0 = n;
            if (n) {
                ((H)this.W).S(false);
            }
        }
    }
    
    private boolean p3(float z1, final float n, float z2) {
        if (!this.d3()) {
            this.f2();
            return false;
        }
        final I m = ((H)this.W).M();
        final float translationX = ((View)this.F).getTranslationX();
        final float translationY = ((View)this.F).getTranslationY();
        final int n2 = (int)(m.a() * z1);
        final int height = ((View)this.b).getHeight();
        boolean b = false;
        Label_0114: {
            if (n2 > height) {
                z2 = this.Z1((float)n2, height, ((View)this.F).getTranslationY(), z2);
                if (translationY != z2) {
                    ((View)this.F).setTranslationY(z2);
                    b = true;
                    break Label_0114;
                }
            }
            b = false;
        }
        final int n3 = (int)(m.b() * z1);
        final int width = ((View)this.b).getWidth();
        if (n3 > width) {
            z1 = this.Z1((float)n3, width, ((View)this.F).getTranslationX(), n);
            if (translationX != z1) {
                ((View)this.F).setTranslationX(z1);
                return true;
            }
        }
        if (!b) {
            return false;
        }
        return true;
    }
    
    private void p4(final boolean b) {
        final ExoPlayer w = this.W;
        if (w != null) {
            final long s0 = ((H)w).s0();
            if (b || s0 >= this.u0 || !this.v0) {
                if (b || s0 <= this.u0 || this.v0) {
                    if (this.v0) {
                        this.W.c(ax.Y0.Z.e);
                    }
                    else {
                        this.W.c(ax.Y0.Z.f);
                    }
                    ((H)this.W).t(this.u0);
                    this.W.c(ax.Y0.Z.g);
                    this.t0 = System.currentTimeMillis();
                }
            }
        }
    }
    
    private View q2() {
        ((ViewGroup)this.I).setTouchscreenBlocksFocus(false);
        final View child = ((ViewGroup)this.I).getChildAt(0);
        if (!(child instanceof p)) {
            ax.u3.b.e("not work anymore");
            return child;
        }
        if (this.I.getNavigationContentDescription() != null && this.I.getNavigationContentDescription().equals(child.getContentDescription())) {
            child.setId(16908332);
            return child;
        }
        ax.u3.b.e("not work anymore");
        return child;
    }
    
    private void q3() {
        if (this.h3()) {
            this.B4();
        }
        this.H3(0);
        this.r3(this.w2(), true);
    }
    
    private void q4() {
        if (!this.e.n0()) {
            this.J3(true);
        }
        else if (this.W2()) {
            this.J3(false);
        }
        else if (this.r1) {
            this.J3(true);
        }
        else {
            this.J3(false);
        }
        this.h4();
    }
    
    private void r2() {
        this.B1.removeCallbacks(this.K1);
        this.b.setUseController(false);
        this.finish();
    }
    
    private void r3(final int n, final boolean b) {
        if (n < 0 || n >= this.B2()) {
            ax.u3.b.f();
            return;
        }
        if (this.W == null) {
            return;
        }
        final u h1 = this.H1;
        if (h1 != null && !h1.isCancelled() && ax.u3.q.n((q)this.H1)) {
            this.H1.e();
        }
        (this.H1 = new u(n, b)).i((Object[])new Void[0]);
    }
    
    private void r4() {
        final ExoPlayer w = this.W;
        if (w == null) {
            ((ImageView)this.k).setImageDrawable(this.T0);
            ((View)this.k).setContentDescription((CharSequence)this.d1);
            return;
        }
        final int o = ((H)w).o();
        if (o == 0) {
            ((ImageView)this.k).setImageDrawable(this.T0);
            ((View)this.k).setContentDescription((CharSequence)this.d1);
            return;
        }
        if (o == 1) {
            ((ImageView)this.k).setImageDrawable(this.U0);
            ((View)this.k).setContentDescription((CharSequence)this.e1);
            return;
        }
        if (o != 2) {
            return;
        }
        ((ImageView)this.k).setImageDrawable(this.V0);
        ((View)this.k).setContentDescription((CharSequence)this.f1);
    }
    
    private String s2(String l, final List<com.alphainventor.filemanager.file.n> list) {
        if (!ax.c3.d0.B(l)) {
            final ax.Ha.b b = ax.Ha.c.h().f().b("Invalid media path 3");
            final StringBuilder sb = new StringBuilder();
            sb.append("path:");
            sb.append(l);
            b.g((Object)sb.toString()).h();
            return null;
        }
        if (list == null) {
            return null;
        }
        l = ax.c3.d0.l(l);
        for (final String s : ax.c3.A.o()) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(l);
            sb2.append(".");
            sb2.append(s);
            final String string = sb2.toString();
            for (final com.alphainventor.filemanager.file.n n : list) {
                if (string.equals((Object)n.E())) {
                    return n.B();
                }
            }
        }
        return null;
    }
    
    private void s3() {
        if (this.w2() >= this.B2()) {
            ax.u3.b.e("bad index");
            return;
        }
        if (this.h3()) {
            this.B4();
        }
        this.H3(this.w2() + 1);
        this.r3(this.w2(), true);
    }
    
    private void s4() {
        if (this.d0) {
            ((ImageView)this.x).setImageDrawable(this.Z0);
            ((View)this.x).setContentDescription((CharSequence)this.i1);
            return;
        }
        ((ImageView)this.x).setImageDrawable(this.Y0);
        ((View)this.x).setContentDescription((CharSequence)this.j1);
    }
    
    private Uri t2(final Uri uri) {
        final String string = uri.toString();
        if ("file".equals((Object)uri.getScheme())) {
            return this.v2(uri.getPath());
        }
        final boolean startsWith = string.startsWith("content://media");
        final Uri uri2 = null;
        if (startsWith) {
            final String a = ax.c3.N.a((Context)this, uri);
            if (a != null) {
                return this.v2(a);
            }
            return null;
        }
        else {
            if ("content".equals((Object)uri.getScheme())) {
                final Uri u2 = this.u2((Context)this, uri);
                final Logger s1 = VideoPlayerActivity.S1;
                final StringBuilder sb = new StringBuilder();
                sb.append("subtitle uri : ");
                sb.append((Object)u2);
                s1.fine(sb.toString());
                return u2;
            }
            Uri build = uri2;
            if (com.alphainventor.filemanager.service.b.k((Context)this, uri)) {
                final k z = ax.o3.c.z(uri.getPath());
                final String r = ax.c3.d0.r(uri.getPath());
                final k z2 = ax.o3.c.z(r);
                build = uri2;
                if (z2 != null) {
                    build = uri2;
                    if (z != null) {
                        build = uri2;
                        if (ax.c3.x.e(z2.d()).a()) {
                            final List h = ax.Z2.b.k().h(z2.toString());
                            build = uri2;
                            if (h != null) {
                                final String s2 = this.s2(z.e(), (List<com.alphainventor.filemanager.file.n>)h);
                                build = uri2;
                                if (s2 != null) {
                                    final Uri$Builder buildUpon = uri.buildUpon();
                                    buildUpon.path(ax.c3.d0.Q(r, s2));
                                    build = buildUpon.build();
                                    final Logger s3 = VideoPlayerActivity.S1;
                                    final StringBuilder sb2 = new StringBuilder();
                                    sb2.append("subtitle uri : ");
                                    sb2.append((Object)build);
                                    s3.fine(sb2.toString());
                                }
                            }
                        }
                    }
                }
            }
            final Logger s4 = VideoPlayerActivity.S1;
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("media uri : ");
            sb3.append((Object)uri);
            s4.fine(sb3.toString());
            return build;
        }
    }
    
    private void t3() {
        if (this.w2() <= 0) {
            return;
        }
        if (this.h3()) {
            this.B4();
        }
        this.H3(this.w2() - 1);
        this.r3(this.w2(), true);
    }
    
    private void t4() {
        final ExoPlayer w = this.W;
        if (w != null) {
            this.m1 = ((H)w).v();
            this.n1 = ((H)this.W).P();
            this.o1 = Math.max(0L, ((H)this.W).V());
        }
    }
    
    private Uri u2(final Context p0, final Uri p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   android/net/Uri.getPath:()Ljava/lang/String;
        //     4: astore          5
        //     6: aload           5
        //     8: invokestatic    ax/c3/d0.B:(Ljava/lang/String;)Z
        //    11: ifne            63
        //    14: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
        //    17: invokevirtual   ax/Ha/b.f:()Lax/Ha/b;
        //    20: ldc_w           "Invalid media path 2"
        //    23: invokevirtual   ax/Ha/b.b:(Ljava/lang/String;)Lax/Ha/b;
        //    26: astore_1       
        //    27: new             Ljava/lang/StringBuilder;
        //    30: dup            
        //    31: invokespecial   java/lang/StringBuilder.<init>:()V
        //    34: astore_2       
        //    35: aload_2        
        //    36: ldc_w           "path:"
        //    39: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    42: pop            
        //    43: aload_2        
        //    44: aload           5
        //    46: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    49: pop            
        //    50: aload_1        
        //    51: aload_2        
        //    52: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    55: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
        //    58: invokevirtual   ax/Ha/b.h:()V
        //    61: aconst_null    
        //    62: areturn        
        //    63: aload           5
        //    65: invokestatic    ax/c3/d0.l:(Ljava/lang/String;)Ljava/lang/String;
        //    68: astore          5
        //    70: aload_1        
        //    71: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //    74: astore          6
        //    76: invokestatic    ax/c3/A.o:()[Ljava/lang/String;
        //    79: astore_1       
        //    80: aload_1        
        //    81: arraylength    
        //    82: istore          4
        //    84: iconst_0       
        //    85: istore_3       
        //    86: iload_3        
        //    87: iload           4
        //    89: if_icmpge       180
        //    92: aload_1        
        //    93: iload_3        
        //    94: aaload         
        //    95: astore          7
        //    97: new             Ljava/lang/StringBuilder;
        //   100: dup            
        //   101: invokespecial   java/lang/StringBuilder.<init>:()V
        //   104: astore          8
        //   106: aload           8
        //   108: aload           5
        //   110: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   113: pop            
        //   114: aload           8
        //   116: ldc_w           "."
        //   119: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   122: pop            
        //   123: aload           8
        //   125: aload           7
        //   127: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   130: pop            
        //   131: aload           8
        //   133: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   136: astore          7
        //   138: aload_2        
        //   139: invokevirtual   android/net/Uri.buildUpon:()Landroid/net/Uri$Builder;
        //   142: aload           7
        //   144: invokevirtual   android/net/Uri$Builder.path:(Ljava/lang/String;)Landroid/net/Uri$Builder;
        //   147: invokevirtual   android/net/Uri$Builder.build:()Landroid/net/Uri;
        //   150: astore          7
        //   152: aload           6
        //   154: aload           7
        //   156: ldc_w           "r"
        //   159: invokevirtual   android/content/ContentResolver.openFileDescriptor:(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
        //   162: astore          8
        //   164: aload           8
        //   166: invokevirtual   android/os/ParcelFileDescriptor.close:()V
        //   169: aload           7
        //   171: areturn        
        //   172: astore          7
        //   174: iinc            3, 1
        //   177: goto            86
        //   180: aconst_null    
        //   181: areturn        
        //   182: astore_1       
        //   183: goto            169
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  152    164    172    180    Ljava/lang/Exception;
        //  164    169    182    186    Ljava/io/IOException;
        //  164    169    172    180    Ljava/lang/Exception;
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
    
    private void u3() {
        final ExoPlayer w = this.W;
        if (w != null) {
            final int i = ((H)w).i();
            final long s0 = ((H)this.W).s0();
            if (this.w2() == 0 || (i != 4 && s0 > 3000L)) {
                ((H)this.W).t(0L);
                return;
            }
            if (this.w2() > 0) {
                this.t3();
            }
        }
    }
    
    private Uri v2(String l) {
        if (!ax.c3.d0.B(l)) {
            final ax.Ha.b b = ax.Ha.c.h().f().b("Invalid media path 1");
            final StringBuilder sb = new StringBuilder();
            sb.append("path:");
            sb.append(l);
            b.g((Object)sb.toString()).h();
            return null;
        }
        l = ax.c3.d0.l(l);
        for (final String s : ax.c3.A.o()) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(l);
            sb2.append(".");
            sb2.append(s);
            final File file = new File(sb2.toString());
            if (file.exists()) {
                return Uri.fromFile(file);
            }
        }
        return null;
    }
    
    private void v4() {
        this.E3(this.j0, (View)this.v);
        if (!this.j0) {
            ((ImageView)this.v).setImageDrawable(this.W0);
            ((View)this.v).setContentDescription((CharSequence)this.h1);
            ((View)this.v).setVisibility(8);
            ((View)this.b.getSubtitleView()).setVisibility(8);
            return;
        }
        if (this.k0) {
            ((ImageView)this.v).setImageDrawable(this.X0);
            ((View)this.v).setContentDescription((CharSequence)this.g1);
            ((View)this.v).setVisibility(0);
            ((View)this.b.getSubtitleView()).setVisibility(0);
            return;
        }
        ((ImageView)this.v).setImageDrawable(this.W0);
        ((View)this.v).setContentDescription((CharSequence)this.h1);
        ((View)this.v).setVisibility(0);
        ((View)this.b.getSubtitleView()).setVisibility(8);
    }
    
    private int w2() {
        final int i0 = this.i0;
        if (i0 < 0) {
            ax.u3.b.f();
            return 0;
        }
        if (i0 >= this.B2()) {
            ax.u3.b.f();
            return this.B2() - 1;
        }
        return this.i0;
    }
    
    private void w3() {
    }
    
    private void w4() {
        final Uri x2 = this.x2();
        if (x2 == null) {
            this.P3("");
            return;
        }
        if (!"file".equals((Object)x2.getScheme()) && !ax.c3.B.L(x2.getScheme()) && !MyFileProvider.D(x2)) {
            if ("content".equals((Object)x2.getScheme())) {
                this.P3(ax.c3.B.w((Context)this, x2).a);
            }
            return;
        }
        if (x2.getPath() != null) {
            this.P3(ax.c3.d0.h(x2.getPath()));
            return;
        }
        this.P3("");
    }
    
    private Uri x2() {
        if (this.Z == null) {
            ax.u3.b.f();
            return null;
        }
        final int z2 = this.z2(this.w2());
        if (z2 >= 0) {
            final Uri[] z3 = this.Z;
            if (z2 < z3.length) {
                return z3[z2];
            }
        }
        ax.u3.b.e("what case is this");
        return null;
    }
    
    private void x3() {
        final ax.b1.O x = this.X;
        if (x != null) {
            x.d();
            this.X = null;
        }
    }
    
    private void x4() {
        final n n0 = this.N0;
        if (n0 != null) {
            this.O0 = n0.K();
        }
    }
    
    private Uri y2() {
        if (this.a0 == null) {
            ax.u3.b.f();
            return null;
        }
        return this.a0[this.z2(this.w2())];
    }
    
    private void y3() {
        if (this.W != null) {
            this.x4();
            this.t4();
            this.W.d();
            this.W = null;
            this.Y = null;
            this.N0 = null;
        }
        if (ax.X2.Q.g1()) {
            this.x3();
        }
    }
    
    private void y4(final Intent intent) {
        this.B1.removeCallbacks(this.K1);
        this.y1 = intent.getIntExtra("slide_interval", -1);
        this.A1 = intent.getBooleanExtra("finish_after_play", false);
        this.z1 = false;
    }
    
    private int z2(final int n) {
        int intValue = n;
        if (this.d0) {
            intValue = (int)this.c0.get(n);
        }
        return intValue;
    }
    
    private void z4() {
        this.C0 = false;
        this.B.setVisibility(8);
    }
    
    public String C2() {
        if (this.p1 == null) {
            this.p1 = ax.S0.d0.w0((Context)this, "CxFileExplorer");
        }
        return this.p1;
    }
    
    public void J3(final boolean b) {
        int n;
        if (b) {
            n = 3846;
        }
        else {
            n = 1792;
        }
        this.q1 = n;
        this.a.setSystemUiVisibility(n);
    }
    
    public void K(final int n) {
        this.q4();
        if (n == 8) {
            this.l2();
            this.E1.d();
        }
        if (n == 0) {
            final Snackbar g = this.G;
            if (g != null) {
                g.x();
                this.G = null;
            }
        }
    }
    
    public void Z3() {
        this.v3();
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();
        final int action = keyEvent.getAction();
        final View currentFocus = ((Activity)this).getCurrentFocus();
        final boolean b = action == 0 || (action == 1 && this.F1 == 0);
        if (action == 0) {
            this.F1 = keyCode;
        }
        else if (action == 1) {
            this.F1 = 0;
        }
        if (this.G1 == keyCode && action == 1) {
            this.G1 = 0;
            return true;
        }
        if (b) {
            if (keyCode == 20) {
                if (currentFocus == this.b) {
                    if (!this.e.n0()) {
                        this.e.v0();
                    }
                }
                else {
                    if (!ax.u3.z.s((ViewGroup)this.I, currentFocus) || action != 0) {
                        return this.b.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
                    }
                    if (this.e.n0()) {
                        this.a4();
                    }
                }
            }
            else if (keyCode == 19) {
                if (currentFocus == this.b) {
                    if (!this.e.n0()) {
                        final View q2 = this.q2();
                        this.e.v0();
                        q2.requestFocus();
                    }
                }
                else {
                    if (!ax.u3.z.s(this.f, currentFocus) || action != 0) {
                        return this.b.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
                    }
                    if (this.e.n0()) {
                        this.a4();
                    }
                }
            }
            else if (T2(keyCode)) {
                if (currentFocus != this.b) {
                    return this.b.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
                }
                this.c4();
            }
            else if (keyCode != 85 && keyCode != 62) {
                if (keyCode == 126) {
                    if (currentFocus != this.b || !ax.S0.d0.v1((H)this.W)) {
                        return this.b.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
                    }
                    this.b.setControllerAutoShow(false);
                    this.U3(true);
                    ax.S0.d0.z0((H)this.W);
                    this.b.setControllerAutoShow(true);
                }
                else {
                    if (keyCode != 127 || currentFocus != this.b || ax.S0.d0.v1((H)this.W)) {
                        return this.b.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
                    }
                    this.b.setControllerAutoShow(false);
                    this.U3(false);
                    ax.S0.d0.y0((H)this.W);
                    this.b.setControllerAutoShow(true);
                }
            }
            else {
                final PlayerView b2 = this.b;
                if (currentFocus != b2) {
                    return this.b.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
                }
                b2.setControllerAutoShow(false);
                this.U3(ax.S0.d0.v1((H)this.W));
                ax.S0.d0.A0((H)this.W);
                this.b.setControllerAutoShow(true);
            }
            if (action == 0) {
                this.G1 = keyCode;
            }
            return true;
        }
        return this.b.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }
    
    public void finish() {
        if (this.f3()) {
            if (this.z1) {
                ((Activity)this).setResult(0);
            }
            else {
                ((Activity)this).setResult(-1);
            }
        }
        else {
            this.I3();
        }
        super.finish();
        if (this.X2() && !this.z1) {
            if (this.f3()) {
                ((Activity)this).overridePendingTransition(2130772017, 2130772018);
                return;
            }
            ((Activity)this).overridePendingTransition(2130771998, 2130771999);
        }
    }
    
    public H h() {
        return (H)this.W;
    }
    
    n$e j2() {
        final n$f n$f = new n$f((Context)this);
        n$f.c0(this.Q);
        n$f.a0(this.Q);
        n$f.f0(true);
        return n$f.V();
    }
    
    public androidx.media3.ui.d k() {
        return this.e;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.i4();
    }
    
    public void onCreate(final Bundle bundle) {
        ax.Q2.b.f((Context)this, true);
        super.onCreate(bundle);
        if (!ax.X2.Q.N0()) {
            ax.Ha.c.h().f().d("VIDEO PLAYER NOT SUPPORTED").h();
            Toast.makeText((Context)this, 2131951927, 1).show();
            this.finish();
            return;
        }
        this.y4(((Activity)this).getIntent());
        ((Activity)this).overridePendingTransition(17432576, 17432577);
        try {
            final ax.U0.g$a w1 = this.W1();
            this.U = w1;
            this.V = (O)new Z$b(w1);
            this.setContentView(2131558440);
            this.a = this.findViewById(2131362746);
            this.T = (TextView)this.findViewById(2131362099);
            this.setSupportActionBar(this.I = (Toolbar)this.findViewById(2131362981));
            final Locale locale = this.getResources().getConfiguration().locale;
            if (locale != null) {
                this.Q = locale.toLanguageTag();
            }
            else {
                this.Q = Locale.getDefault().toLanguageTag();
            }
            this.E1 = new g((Context)this, (c)this);
            final PlayerView b = (PlayerView)this.findViewById(2131362701);
            this.b = b;
            if (b.getVideoSurfaceView() instanceof SurfaceView) {
                ((SurfaceView)this.b.getVideoSurfaceView()).getHolder().addCallback((SurfaceHolder$Callback)new SurfaceHolder$Callback(this) {
                    final VideoPlayerActivity a;
                    
                    public void surfaceChanged(final SurfaceHolder surfaceHolder, final int n, final int n2, final int n3) {
                    }
                    
                    public void surfaceCreated(final SurfaceHolder surfaceHolder) {
                        this.a.c = true;
                        if (this.a.d != null) {
                            this.a.d.run();
                            this.a.d = null;
                        }
                    }
                    
                    public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
                        this.a.c = false;
                    }
                });
            }
            this.b.setControllerVisibilityListener((d$m)this);
            this.b.setErrorMessageProvider((ax.P0.p)new v());
            ((View)this.b).requestFocus();
            this.H = this.findViewById(2131362712);
            this.F = (AspectRatioFrameLayout)this.findViewById(2131362208);
            this.e = (androidx.media3.ui.d)this.findViewById(2131362209);
            this.G3();
            this.b.setControllerAnimationEnabled(false);
            ((View)this.e).setFitsSystemWindows(true);
            this.A = (TextView)this.findViewById(2131362158);
            this.B = this.findViewById(2131362156);
            this.C = (ImageView)this.findViewById(2131363030);
            this.D = (ProgressBar)this.findViewById(2131363029);
            this.E = (TextView)this.findViewById(2131362026);
            this.f = (ViewGroup)this.findViewById(2131361990);
            this.g = this.findViewById(2131362064);
            this.h = this.findViewById(2131362065);
            this.i = this.findViewById(2131362066);
            this.j = this.findViewById(2131362068);
            (this.m = this.findViewById(2131362080)).setOnClickListener(this.P1);
            (this.l = this.findViewById(2131362082)).setOnClickListener(this.P1);
            ((View)(this.k = (ImageButton)this.findViewById(2131362085))).setOnClickListener(this.P1);
            (this.n = this.findViewById(2131362083)).setOnClickListener(this.P1);
            (this.o = this.findViewById(2131362084)).setOnClickListener(this.P1);
            (this.p = this.findViewById(2131362081)).setOnClickListener(this.P1);
            (this.q = this.findViewById(2131362092)).setOnClickListener(this.P1);
            (this.s = this.findViewById(2131362087)).setOnClickListener(this.P1);
            ((View)(this.r = (ImageButton)this.findViewById(2131362086))).setOnClickListener(this.P1);
            ((View)(this.t = (ImageView)this.findViewById(2131362091))).setOnClickListener(this.P1);
            ((Spinner)(this.y = (MySpinner)this.findViewById(2131362089))).setPromptId(2131952502);
            final com.alphainventor.filemanager.viewer.d adapter = new com.alphainventor.filemanager.viewer.d((Context)this);
            ((androidx.appcompat.widget.u)this.y).setAdapter((SpinnerAdapter)adapter);
            ((AdapterView)this.y).setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new AdapterView$OnItemSelectedListener(this, adapter) {
                final com.alphainventor.filemanager.viewer.d a;
                final VideoPlayerActivity b;
                
                public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                    final com.alphainventor.filemanager.viewer.d.a a = (com.alphainventor.filemanager.viewer.d.a)((Adapter)this.a).getItem(n);
                    if (a != null) {
                        this.b.L3(a.b, true);
                    }
                }
                
                public void onNothingSelected(final AdapterView<?> adapterView) {
                }
            });
            ((View)(this.u = (ImageButton)this.findViewById(2131362079))).setOnClickListener(this.P1);
            ((View)(this.v = (ImageButton)this.findViewById(2131362090))).setOnClickListener(this.P1);
            ((View)(this.x = (ImageButton)this.findViewById(2131362088))).setOnClickListener(this.P1);
            this.w = (ImageButton)this.findViewById(2131362230);
            this.z = this.findViewById(2131362185);
            this.J = (ViewGroup)this.findViewById(2131361874);
            this.K = (ViewGroup)this.findViewById(2131361873);
            this.L = this.findViewById(2131361872);
            this.M = this.findViewById(2131361875);
            this.L.setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
                final VideoPlayerActivity c;
                
                public void a(final View view) {
                    this.c.h2();
                    this.c.i4();
                }
            });
            (this.S = (androidx.media3.ui.b)((View)this.b).findViewById(2131362234)).a(this.L1);
            this.a.setOnSystemUiVisibilityChangeListener((View$OnSystemUiVisibilityChangeListener)new View$OnSystemUiVisibilityChangeListener(this) {
                final VideoPlayerActivity a;
                
                public void onSystemUiVisibilityChange(final int n) {
                    if (n == 0 && this.a.q1 == 3846) {
                        this.a.J3(false);
                    }
                }
            });
            this.w0 = ax.u3.B.e((Context)this, 30);
            this.x0 = ax.u3.B.e((Context)this, 35);
            this.I0 = ax.t3.a.b();
            this.J2();
            this.G2();
            if (bundle != null) {
                final Bundle bundle2 = bundle.getBundle("track_selector_parameters");
                if (bundle2 != null) {
                    this.O0 = n$e.Q(bundle2);
                }
                if (this.O0 == null) {
                    this.O0 = this.j2();
                }
                this.m1 = bundle.getBoolean("auto_play");
                this.n1 = ((BaseBundle)bundle).getInt("window", -1);
                this.o1 = ((BaseBundle)bundle).getLong("position", -1L);
                this.p0 = bundle.getFloat("speed", 1.0f);
            }
            else {
                this.O0 = this.j2();
                this.g2();
            }
            ((ComponentActivity)this).getOnBackPressedDispatcher().h((ax.G0.h)this, this.J1);
            this.C1 = ax.u3.B.e((Context)this, 40);
            this.D1 = ax.u3.B.e((Context)this, 52);
            ((androidx.fragment.app.f)this).getSupportFragmentManager().m1("dialog_dismiss_request", (ax.G0.h)this, (ax.A0.l)new ax.A0.l(this) {
                final VideoPlayerActivity a;
                
                public void a(final String s, final Bundle bundle) {
                    if (bundle.getBoolean("result")) {
                        final VideoPlayerActivity a = this.a;
                        if (a.I1 && a.W != null && !((H)this.a.W).n()) {
                            ((H)this.a.W).S(true);
                        }
                        this.a.G3();
                    }
                }
            });
        }
        catch (final SecurityException ex) {
            ax.Ha.c.h().f().d("VIDEO PLAYER BUILD SOURCE").h();
            Toast.makeText((Context)this, 2131951927, 1).show();
            this.finish();
        }
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(2131689510, menu);
        return true;
    }
    
    public void onDestroy() {
        this.w3();
        if (this.s1 && this.t1 != null) {
            com.alphainventor.filemanager.service.b.f((Context)this).l(false, this.t1);
        }
        if (this.N != null) {
            this.e2();
        }
        super.onDestroy();
    }
    
    public void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.y3();
        this.w3();
        this.g2();
        ((Activity)this).setIntent(intent);
        this.y4(intent);
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        final int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            this.finish();
            return true;
        }
        if (itemId == 2131362544) {
            this.Y3();
            return true;
        }
        if (itemId != 2131362549) {
            return false;
        }
        this.b4();
        return true;
    }
    
    public void onPause() {
        super.onPause();
        if (ax.S0.d0.a <= 23) {
            final PlayerView b = this.b;
            if (b != null) {
                b.P();
            }
            this.y3();
        }
        final View n = this.N;
        if (n != null && !this.O) {
            ax.S2.b.c((Object)n, (Context)this);
        }
    }
    
    public boolean onPrepareOptionsMenu(final Menu menu) {
        final MenuItem item = menu.findItem(2131362549);
        if (item != null) {
            item.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }
    
    public void onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
        super.onRequestPermissionsResult(n, array, array2);
        if (array2.length == 0) {
            return;
        }
        if (array2[0] == 0) {
            this.L2();
            return;
        }
        this.W3(2131951929);
        this.finish();
    }
    
    public void onResume() {
        super.onResume();
        if (ax.S0.d0.a <= 23 || this.W == null) {
            this.L2();
            final PlayerView b = this.b;
            if (b != null) {
                b.Q();
            }
        }
        final View n = this.N;
        if (n != null && !this.O) {
            ax.S2.b.l((Object)n, (Context)this);
        }
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.x4();
        this.t4();
        final n$e o0 = this.O0;
        if (o0 != null) {
            bundle.putBundle("track_selector_parameters", o0.J());
        }
        bundle.putBoolean("auto_play", this.m1);
        ((BaseBundle)bundle).putInt("window", this.n1);
        ((BaseBundle)bundle).putLong("position", this.o1);
        bundle.putFloat("speed", this.p0);
    }
    
    public void onStart() {
        super.onStart();
        if (ax.S0.d0.a > 23) {
            this.L2();
            final PlayerView b = this.b;
            if (b != null) {
                b.Q();
            }
        }
        if (ax.X2.Q.N1()) {
            ax.X2.v.s(((Activity)this).getWindow(), -1157627904);
            ax.X2.v.r(((Activity)this).getWindow(), -1157627904);
        }
    }
    
    public void onStop() {
        super.onStop();
        if (ax.S0.d0.a > 23) {
            final PlayerView b = this.b;
            if (b != null) {
                b.P();
            }
            this.y3();
        }
    }
    
    public void u4() {
        this.O3(ax.t3.l.h((Context)this), true);
    }
    
    public void v3() {
        final PlayerView b = this.b;
        if (b != null) {
            b.P();
        }
        this.y3();
        this.L2();
    }
    
    public void z3() {
        this.r3(this.w2(), true);
    }
    
    static class t extends n
    {
        String m;
        
        public t(final Context context, final D$b d$b, final String m) {
            super((T)n$e.R(context), d$b);
            this.m = m;
        }
        
        public static boolean g0(final ax.P0.v v, final String s) {
            return n.I(v, s, false) > 0;
        }
        
        protected Pair<D$a, Integer> c0(final ax.l1.G$a g$a, final int[][][] array, final n$e n$e, final String s) throws s {
            final Pair c0 = super.c0(g$a, array, n$e, s);
            if (!VideoPlayerActivity.U1) {
                if (c0 != null) {
                    final P a = ((D$a)c0.first).a;
                    final boolean empty = TextUtils.isEmpty((CharSequence)this.m);
                    final boolean b = false;
                    int i = 0;
                    int n = b ? 1 : 0;
                    if (!empty) {
                        n = (b ? 1 : 0);
                        if (a != null) {
                            n = 0;
                            while (i < a.a) {
                                if (g0(a.b(i), this.m)) {
                                    n = 1;
                                }
                                ++i;
                            }
                        }
                    }
                    if (n == 0) {
                        return null;
                    }
                }
            }
            else if (VideoPlayerActivity.T1) {
                return null;
            }
            return (Pair<D$a, Integer>)c0;
        }
    }
    
    class u extends q<Void, Integer, Boolean>
    {
        private int h;
        private boolean i;
        final VideoPlayerActivity j;
        
        u(final VideoPlayerActivity j, final int h, final boolean i) {
            this.j = j;
            super(q$e.d0);
            this.h = h;
            this.i = i;
        }
        
        private void z() {
            if (!((Activity)this.j).isDestroyed()) {
                if (this.j.W != null) {
                    if (this.j.Y != null) {
                        try {
                            ((H)this.j.W).B(this.j.Y, this.i);
                            ((H)this.j.W).k();
                        }
                        catch (final IllegalStateException ex) {
                            this.j.V3(2131951927);
                            final StringBuilder sb = new StringBuilder();
                            sb.append("MediaItemIllegal :");
                            sb.append((Object)this.j.y2());
                            sb.append(":");
                            sb.append(((Throwable)ex).getMessage());
                            ax.Q2.d.c("EXOPLAYER ILLEGALSTATE", (Throwable)new IllegalStateException(sb.toString(), (Throwable)ex));
                        }
                    }
                }
            }
        }
        
        protected void o() {
            this.j.H.setVisibility(8);
        }
        
        protected void r() {
            this.j.H.setVisibility(0);
        }
        
        protected Boolean x(final Void... array) {
            try {
                final VideoPlayerActivity j = this.j;
                j.Y = j.X1(this.h);
                return Boolean.TRUE;
            }
            catch (final IllegalStateException ex) {
                return Boolean.FALSE;
            }
        }
        
        protected void y(final Boolean b) {
            this.j.H.setVisibility(8);
            if (!b) {
                this.j.V3(2131951927);
                return;
            }
            if (this.j.W == null) {
                return;
            }
            if (this.j.c) {
                this.z();
                return;
            }
            this.j.d = (Runnable)new Runnable(this) {
                final u q;
                
                public void run() {
                    this.q.z();
                }
            };
        }
    }
    
    private class v implements ax.P0.p<F>
    {
        final VideoPlayerActivity a;
        
        private v(final VideoPlayerActivity a) {
            this.a = a;
        }
        
        public Pair<Integer, String> b(final F f) {
            String s2;
            final String s = s2 = ((Context)this.a).getString(2131951960);
            if (ax.t3.j.o((Context)this.a)) {
                if (f instanceof s) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(s);
                    sb.append(":");
                    sb.append(((s)f).k0);
                    sb.append(":");
                    sb.append(((Throwable)f).getMessage());
                    s2 = sb.toString();
                }
                else {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(s);
                    sb2.append(":");
                    sb2.append(((Throwable)f).getMessage());
                    s2 = sb2.toString();
                }
            }
            String s3 = s2;
            if (f instanceof s) {
                final s s4 = (s)f;
                final int k0 = s4.k0;
                if (k0 == 0) {
                    s3 = s2;
                }
                else {
                    s3 = s2;
                    if (k0 == 1) {
                        final Exception h = s4.h();
                        s3 = s2;
                        if (h instanceof L$c) {
                            final L$c l$c = (L$c)h;
                            if (l$c.c0) {
                                final VideoPlayerActivity a = this.a;
                                final StringBuilder sb3 = new StringBuilder();
                                sb3.append(l$c.q);
                                sb3.append(":secure");
                                s3 = ax.w3.h.b((Context)a, sb3.toString());
                            }
                            else {
                                s3 = ax.w3.h.b((Context)this.a, l$c.q);
                            }
                        }
                    }
                }
            }
            return (Pair<Integer, String>)Pair.create((Object)0, (Object)s3);
        }
    }
    
    private class w implements H$d
    {
        final VideoPlayerActivity a;
        
        private w(final VideoPlayerActivity a) {
            this.a = a;
        }
        
        public void F(final int n) {
            if (n == 0 && this.a.o0 == 2) {
                this.a.o3();
            }
            this.a.o4();
        }
        
        public void H(final V v) {
            this.a.E1.q();
            final z a = v.a();
            if (a != this.a.P0) {
                this.a.u1 = false;
                this.a.k0 = false;
                this.a.l0 = 0;
                this.a.m0 = 0;
                final ax.l1.G$a o = ((ax.l1.G)this.a.N0).o();
                if (o != null) {
                    if (o.i(2) == 1) {
                        final String e1 = this.a.A2((z<V$a>)a, "video");
                        final String f1 = this.a.k2();
                        final ax.Ha.b b = ax.Ha.c.h().f().b("video codec not available");
                        final StringBuilder sb = new StringBuilder();
                        sb.append("codec : ");
                        sb.append(e1);
                        sb.append(",container : ");
                        sb.append(f1);
                        b.g((Object)sb.toString()).h();
                        final Logger s0 = VideoPlayerActivity.S1;
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("video codec not available : ");
                        sb2.append(e1);
                        sb2.append(", container : ");
                        sb2.append(f1);
                        s0.severe(sb2.toString());
                        this.a.R3(e1);
                    }
                    final int i = o.i(1);
                    if (i == 1) {
                        final String e2 = this.a.A2((z<V$a>)a, "audio");
                        final String f2 = this.a.k2();
                        final ax.Ha.b b2 = ax.Ha.c.h().f().b("audio codec not available");
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("codec : ");
                        sb3.append(e2);
                        sb3.append(",container : ");
                        sb3.append(f2);
                        b2.g((Object)sb3.toString()).h();
                        final Logger s2 = VideoPlayerActivity.S1;
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("audio codec not available : ");
                        sb4.append(e2);
                        sb4.append(", container : ");
                        sb4.append(f2);
                        s2.severe(sb4.toString());
                        this.a.R3(e2);
                    }
                    else if (i == 3) {
                        for (int j = 0; j < ((AbstractCollection)a).size(); ++j) {
                            final V$a v$a = (V$a)((List)a).get(j);
                            if (v$a.d() == 1) {
                                for (int k = 0; k < v$a.a; ++k) {
                                    if (v$a.j(k)) {
                                        this.a.m0++;
                                    }
                                }
                            }
                        }
                    }
                    if (o.i(3) == 3) {
                        for (int l = 0; l < ((AbstractCollection)a).size(); ++l) {
                            final V$a v$a2 = (V$a)((List)a).get(l);
                            if (v$a2.d() == 3) {
                                for (int n = 0; n < v$a2.a; ++n) {
                                    if (v$a2.j(n)) {
                                        if ((v$a2.b(n).e & 0x2) == 0x0) {
                                            this.a.l0++;
                                            if (v$a2.f()) {
                                                this.a.k0 = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        this.a.j0 = true;
                    }
                    else {
                        this.a.j0 = false;
                    }
                }
                else {
                    this.a.j0 = false;
                }
                this.a.P0 = (z<V$a>)a;
            }
            this.a.l4();
            this.a.v4();
            this.a.j4();
        }
        
        public void N(final F f) {
            if (R2(f)) {
                this.a.g2();
                this.a.L2();
                return;
            }
            this.a.j3(false);
            this.a.l4();
            this.a.S3();
        }
        
        public void P(final ax.P0.N n, final int n2) {
            this.a.o4();
        }
        
        public void S(final boolean b) {
            this.a.o4();
        }
        
        public void Z(final boolean b, int bufferedColor) {
            final Logger s0 = VideoPlayerActivity.S1;
            final StringBuilder sb = new StringBuilder();
            sb.append("player state changed : ");
            sb.append(b);
            sb.append(",");
            sb.append(bufferedColor);
            s0.fine(sb.toString());
            if (bufferedColor == 4) {
                if (this.a.X2() && !this.a.z1) {
                    this.a.r2();
                    return;
                }
                this.a.T3(true);
                this.a.S3();
            }
            else if (bufferedColor == 3) {
                if (this.a.f3() && this.a.X2() && !this.a.z1 && this.a.y1 > 0) {
                    final Handler y0 = this.a.B1;
                    final VideoPlayerActivity a = this.a;
                    y0.postDelayed(a.K1, (long)a.y1);
                }
                final Uri o0 = this.a.y2();
                if (!this.a.u1 && (this.a.v1 == null || !this.a.v1.equals((Object)o0))) {
                    this.a.u1 = true;
                    this.a.v1 = o0;
                    long g0;
                    if ((g0 = ((H)this.a.W).g0()) < 0L) {
                        g0 = -1L;
                    }
                    String k;
                    if (o0 != null && o0.getPath() != null) {
                        k = ax.c3.d0.k(o0.getPath());
                    }
                    else {
                        k = "uri_error";
                    }
                    ax.Q2.a.i().o("video_player_ready").a("duration_ms", g0).b("duration_range", a$g.a(g0)).b("ext", k).c();
                }
                this.a.w4();
                this.a.T3(false);
                if (this.a.Y2()) {
                    bufferedColor = ax.Q.b.c((Context)this.a, 2131100859);
                    this.a.w1 = 150L;
                }
                else {
                    bufferedColor = ax.Q.b.c((Context)this.a, 2131100858);
                    this.a.w1 = 300L;
                }
                this.a.S.setBufferedColor(bufferedColor);
            }
            else if (bufferedColor == 2) {
                this.a.w4();
                this.a.T3(false);
            }
            this.a.i4();
            this.a.l2();
            this.a.n4();
            this.a.l4();
            this.a.o4();
            this.a.m4();
        }
        
        public void t0(final boolean b) {
            final Logger s0 = VideoPlayerActivity.S1;
            final StringBuilder sb = new StringBuilder();
            sb.append("VideoPlayer : isPlaying=");
            sb.append(b);
            s0.fine(sb.toString());
            if (b) {
                this.a.K3(true);
                this.a.c2();
                return;
            }
            this.a.K3(false);
        }
        
        public void v(final int n) {
            if (this.a.o0 != n) {
                ax.t3.l.k((Context)this.a, n);
            }
            this.a.o0 = n;
            this.a.r4();
            this.a.o4();
        }
    }
    
    static class x extends OrientationEventListener
    {
        Activity a;
        Handler b;
        boolean c;
        
        x(final Activity a, final Handler b) {
            super((Context)a);
            this.b = b;
            this.a = a;
        }
        
        private boolean a(final int n, final int n2) {
            return n > n2 - 10 && n < n2 + 10;
        }
        
        private boolean b(final int n) {
            return this.a(n, 90) || this.a(n, 270);
        }
        
        private boolean c(final int n) {
            return this.a(n, 0) || this.a(n, 180);
        }
        
        void d() {
            boolean b;
            if (((Context)this.a).getResources().getConfiguration().orientation == 2) {
                this.a.setRequestedOrientation(7);
                b = false;
            }
            else {
                this.a.setRequestedOrientation(6);
                b = true;
            }
            if (Settings$System.getInt(((Context)this.a).getContentResolver(), "accelerometer_rotation", 0) == 1) {
                this.e(b);
            }
        }
        
        void e(final boolean c) {
            this.c = c;
            this.enable();
        }
        
        public void onOrientationChanged(final int n) {
            if ((this.c && this.b(n)) || (!this.c && this.c(n))) {
                this.b.postDelayed((Runnable)new Runnable(this) {
                    final x q;
                    
                    public void run() {
                        if (this.q.a.isFinishing()) {
                            return;
                        }
                        this.q.a.setRequestedOrientation(-1);
                    }
                }, 2000L);
                this.disable();
            }
        }
    }
}
