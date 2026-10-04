package com.alphainventor.filemanager.musicplayer;

import android.widget.Spinner;
import android.os.BaseBundle;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import android.widget.Adapter;
import android.content.ActivityNotFoundException;
import ax.R4.e;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toast;
import android.content.ComponentName;
import com.example.android.uamp.MusicService;
import android.content.res.Configuration;
import android.view.KeyEvent;
import ax.X2.Q;
import ax.t3.j;
import ax.P4.k;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Intent;
import ax.c3.u;
import ax.c3.v;
import java.util.concurrent.TimeUnit;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import com.alphainventor.filemanager.viewer.d;
import android.text.format.DateUtils;
import android.widget.SeekBar$OnSeekBarChangeListener;
import android.view.View$OnClickListener;
import ax.t3.f;
import android.view.View$OnTouchListener;
import android.view.GestureDetector$OnGestureListener;
import android.view.GestureDetector;
import android.app.Activity;
import android.os.SystemClock;
import ax.P4.a$a;
import android.graphics.Bitmap;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaControllerCompat$e;
import ax.Q2.a;
import android.net.Uri;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.MediaControllerCompat;
import android.content.Context;
import android.view.MotionEvent;
import ax.u3.B;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import java.util.concurrent.Executors;
import ax.S4.b;
import androidx.appcompat.widget.MySpinner;
import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.support.v4.media.MediaBrowserCompat$c;
import android.support.v4.media.session.MediaControllerCompat$a;
import java.io.File;
import ax.d3.C0;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import android.support.v4.media.MediaBrowserCompat;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import ax.d3.Z;
import ax.n.c;

public class FullScreenPlayerActivity extends c implements Z
{
    private static final String Z;
    private TextView A;
    private View B;
    private View C;
    private String D;
    private final Handler E;
    private MediaBrowserCompat F;
    private long G;
    private long H;
    private long I;
    private boolean J;
    private int K;
    private boolean L;
    private float M;
    private boolean N;
    private final Runnable O;
    private final ScheduledExecutorService P;
    private ScheduledFuture<?> Q;
    private PlaybackStateCompat R;
    private C0 S;
    private File T;
    private String U;
    private boolean V;
    private final MediaControllerCompat$a W;
    private final MediaBrowserCompat$c X;
    private final GestureDetector$SimpleOnGestureListener Y;
    private Toolbar a;
    private View b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private SeekBar j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private ProgressBar o;
    private View p;
    private Drawable q;
    private Drawable r;
    private Drawable s;
    private Drawable t;
    private Drawable u;
    private ImageView v;
    private TextView w;
    private MySpinner x;
    private View y;
    private ImageView z;
    
    static {
        Z = b.f((Class)FullScreenPlayerActivity.class);
    }
    
    public FullScreenPlayerActivity() {
        this.E = new Handler();
        this.M = 1.0f;
        this.O = (Runnable)new Runnable() {
            final FullScreenPlayerActivity q;
            
            public void run() {
                this.q.o1();
            }
        };
        this.P = Executors.newSingleThreadScheduledExecutor();
        this.W = new MediaControllerCompat$a() {
            final FullScreenPlayerActivity d;
            
            public void c(final Bundle bundle) {
                if (bundle != null) {
                    this.d.p1(bundle);
                }
            }
            
            public void d(final MediaMetadataCompat mediaMetadataCompat) {
                if (mediaMetadataCompat != null) {
                    this.d.l1(mediaMetadataCompat);
                    this.d.h1(mediaMetadataCompat);
                    this.d.n1(mediaMetadataCompat);
                }
            }
            
            public void e(final PlaybackStateCompat playbackStateCompat) {
                ax.S4.b.a(FullScreenPlayerActivity.Z, new Object[] { "onPlaybackstate changed", playbackStateCompat });
                this.d.m1(playbackStateCompat);
            }
            
            public void h(final int n) {
                this.d.q1(n);
            }
            
            public void l(final int n) {
                this.d.r1(n);
            }
        };
        this.X = new MediaBrowserCompat$c() {
            final FullScreenPlayerActivity c;
            
            public void a() {
                ax.S4.b.a(FullScreenPlayerActivity.Z, new Object[] { "onConnected" });
                try {
                    final FullScreenPlayerActivity c = this.c;
                    c.B0(c.F.c());
                }
                catch (final RemoteException ex) {
                    ax.S4.b.b(FullScreenPlayerActivity.Z, (Throwable)ex, new Object[] { "could not connect media controller" });
                }
            }
        };
        this.Y = new GestureDetector$SimpleOnGestureListener() {
            private float a;
            private long b;
            final FullScreenPlayerActivity c;
            
            private void a(final long n, final boolean b, final boolean b2) {
                if (b2) {
                    this.c.w.setText((CharSequence)ax.u3.B.n(n));
                }
                this.c.I = n;
            }
            
            private void b() {
                if (this.c.I0() == null) {
                    return;
                }
                this.c.J = true;
            }
            
            public boolean onDoubleTap(final MotionEvent motionEvent) {
                final int width = this.c.b.getWidth();
                if (width > 0) {
                    final int n = width / 3;
                    final int n2 = width * 2 / 3;
                    if (motionEvent.getX() < n) {
                        this.c.E0(false);
                        return true;
                    }
                    if (motionEvent.getX() > n2) {
                        this.c.E0(true);
                    }
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
                return this.c.I0() != null && Math.abs(n) >= Math.abs(n2);
            }
            
            public void onLongPress(final MotionEvent motionEvent) {
                if (this.c.I0() == null) {
                    return;
                }
                this.c.S0();
            }
            
            public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, float a) {
                final MediaControllerCompat j = this.c.I0();
                boolean b = false;
                if (j == null) {
                    return false;
                }
                if (motionEvent == null || motionEvent2 == null) {
                    return false;
                }
                if (!this.c.M0()) {
                    if (Math.abs(n) < Math.abs(a)) {
                        return false;
                    }
                    if (Math.abs(motionEvent.getX() - motionEvent2.getX()) < this.c.K) {
                        return false;
                    }
                    if (!this.c.y0()) {
                        return false;
                    }
                    this.a = motionEvent.getX();
                    this.b = this.c.H;
                    this.b();
                }
                if (!this.c.M0()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("what case is this : ");
                    sb.append(this.a);
                    sb.append(",");
                    sb.append(motionEvent.getX());
                    ax.u3.b.e(sb.toString());
                    return true;
                }
                final float x = motionEvent2.getX();
                a = this.a;
                final long n2 = this.b + ax.u3.B.f((Context)this.c, (int)(x - a)) * 40000L / 360L;
                long n3;
                if ((n3 = this.c.G) < 0L) {
                    n3 = 0L;
                }
                long n4;
                if (n2 < 0L) {
                    n4 = 0L;
                }
                else {
                    n4 = n2;
                    if (n2 > n3) {
                        n4 = n3;
                    }
                }
                if (n > 0.0f) {
                    b = true;
                }
                this.a(n4, b, true);
                return true;
            }
            
            public boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
                return true;
            }
            
            public boolean onSingleTapUp(final MotionEvent motionEvent) {
                return true;
            }
        };
    }
    
    private boolean A0() {
        return ((View)this.e).isEnabled() && ((View)this.e).getVisibility() == 0;
    }
    
    private void B0(final MediaSessionCompat$Token mediaSessionCompat$Token) throws RemoteException {
        final MediaControllerCompat mediaControllerCompat = new MediaControllerCompat((Context)this, mediaSessionCompat$Token);
        if (mediaControllerCompat.d() == null && this.T == null) {
            ((Activity)this).finish();
            return;
        }
        this.b1(mediaControllerCompat);
        if (this.T != null) {
            mediaControllerCompat.i().c(Uri.fromFile(this.T), (Bundle)null);
        }
        mediaControllerCompat.j(this.W);
        final PlaybackStateCompat e = mediaControllerCompat.e();
        this.m1(e);
        this.M = e.f();
        this.s1();
        final MediaMetadataCompat d = mediaControllerCompat.d();
        if (d != null) {
            this.l1(d);
            this.h1(d);
            this.n1(d);
        }
        final Bundle b = mediaControllerCompat.b();
        if (b != null) {
            this.p1(b);
        }
        this.q1(mediaControllerCompat.f());
        this.r1(mediaControllerCompat.h());
        this.o1();
        if (e.j() != 3 && e.j() != 6) {
            return;
        }
        this.W0();
    }
    
    private void C0(final MediaControllerCompat mediaControllerCompat, final boolean b, final boolean b2) {
        final PlaybackStateCompat e = mediaControllerCompat.e();
        if (e != null) {
            final MediaControllerCompat$e i = mediaControllerCompat.i();
            final int j = e.j();
            if (j != 0 && j != 1 && j != 2) {
                if (j != 3 && j != 6) {
                    if (j != 7) {
                        b.a(FullScreenPlayerActivity.Z, new Object[] { "onClick with state ", e.j() });
                        return;
                    }
                }
                else {
                    if (!b2) {
                        i.a();
                        this.e1();
                        ax.Q2.a.i().m("menu_music_player", "pause").c("loc", "fullscreen_player").e();
                    }
                    return;
                }
            }
            if (!b) {
                i.b();
                this.W0();
                ax.Q2.a.i().m("menu_music_player", "play").c("loc", "fullscreen_player").e();
            }
        }
    }
    
    private void E0(final boolean b) {
        boolean b2;
        if (b) {
            b2 = this.Y0(10000L);
        }
        else {
            b2 = this.Y0(-10000L);
        }
        if (!b2) {
            return;
        }
        if (b) {
            final TextView w = this.w;
            final StringBuilder sb = new StringBuilder();
            sb.append("+");
            sb.append(ax.u3.B.n(10000L));
            w.setText((CharSequence)sb.toString());
        }
        else {
            final TextView w2 = this.w;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("-");
            sb2.append(ax.u3.B.n(10000L));
            w2.setText((CharSequence)sb2.toString());
        }
        ((View)this.w).postDelayed((Runnable)new Runnable(this) {
            final FullScreenPlayerActivity q;
            
            public void run() {
                this.q.w.setText((CharSequence)"");
            }
        }, 1000L);
    }
    
    private void F0() {
        this.J = false;
        this.w.setText((CharSequence)"");
        if (this.I0() != null) {
            this.X0(this.I, true);
        }
        this.I = 0L;
    }
    
    private void G0(final MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat.d() == null) {
            this.D = null;
            this.v.setImageResource(2131231123);
            return;
        }
        final String string = mediaDescriptionCompat.d().toString();
        this.D = string;
        final ax.P4.a i = ax.P4.a.i();
        final Bitmap g = i.g(string);
        if (g != null) {
            this.v.setImageBitmap(g);
            return;
        }
        this.v.setImageBitmap((Bitmap)null);
        i.f(((Context)this).getApplicationContext(), string, (a$a)new a$a(this) {
            final FullScreenPlayerActivity a;
            
            public void b(final String s, final Exception ex) {
                super.b(s, ex);
                if (s.equals((Object)this.a.D)) {
                    this.a.v.setImageResource(2131231123);
                }
            }
            
            public void c(final String s, final Bitmap imageBitmap, final Bitmap bitmap, final Bitmap bitmap2) {
                if (s.equals((Object)this.a.D)) {
                    this.a.v.setImageBitmap(imageBitmap);
                }
            }
        });
    }
    
    private long H0() {
        long i;
        final long n = i = this.R.i();
        if (this.R.j() != 0) {
            i = n;
            if (this.R.j() != 2) {
                i = n;
                if (this.R.j() != 1) {
                    i = (long)(n + (SystemClock.elapsedRealtime() - this.R.e()) * this.R.f());
                }
            }
        }
        return i;
    }
    
    private MediaControllerCompat I0() {
        return MediaControllerCompat.c((Activity)this);
    }
    
    private void J0() {
        this.K = ax.u3.B.e((Context)this, 30);
        ((View)this.v).setOnTouchListener((View$OnTouchListener)new View$OnTouchListener(this, new com.alphainventor.filemanager.viewer.a((Context)this, 1.0f, (com.alphainventor.filemanager.viewer.a.b)new com.alphainventor.filemanager.viewer.a.b(this) {
            final FullScreenPlayerActivity a;
            
            @Override
            public void a(final MotionEvent motionEvent) {
                this.a.T0();
            }
        }), new GestureDetector((Context)this, (GestureDetector$OnGestureListener)this.Y)) {
            final com.alphainventor.filemanager.viewer.a a;
            final GestureDetector b;
            final FullScreenPlayerActivity c;
            
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                this.a.g(motionEvent);
                final boolean onTouchEvent = this.b.onTouchEvent(motionEvent);
                if (this.c.M0()) {
                    if (motionEvent.getAction() == 1) {
                        this.c.F0();
                    }
                    return true;
                }
                if (this.c.O0()) {
                    if (motionEvent.getAction() == 1) {
                        this.c.Q0();
                    }
                    return true;
                }
                return onTouchEvent;
            }
        });
    }
    
    private void K0() {
        this.N = ax.t3.f.a((Context)this);
        this.g1();
        ((View)this.c).setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final FullScreenPlayerActivity c;
            
            public void a(final View view) {
                final int h = this.c.I0().h();
                final MediaControllerCompat$e i = this.c.I0().i();
                int n;
                if (h == 1) {
                    n = 0;
                }
                else {
                    n = 1;
                }
                i.h(n);
                if (((View)this.c.c).isAccessibilityFocused()) {
                    if (n == 1) {
                        ((View)this.c.c).announceForAccessibility((CharSequence)((Context)this.c).getString(2131952604));
                    }
                    else if (n == 0) {
                        ((View)this.c.c).announceForAccessibility((CharSequence)((Context)this.c).getString(2131952603));
                    }
                }
                ax.Q2.a.i().m("menu_music_player", "shuffle").c("loc", "fullscreen_player").e();
            }
        });
        ((View)this.d).setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final FullScreenPlayerActivity c;
            
            public void a(final View view) {
                final int f = this.c.I0().f();
                final MediaControllerCompat$e i = this.c.I0().i();
                int n;
                if (f == 2) {
                    n = 3;
                }
                else if (f == 3) {
                    n = 1;
                }
                else if (f == 1) {
                    n = 0;
                }
                else {
                    n = 2;
                }
                i.g(n);
                if (((View)this.c.d).isAccessibilityFocused()) {
                    if (n == 2) {
                        ((View)this.c.d).announceForAccessibility((CharSequence)((Context)this.c).getString(2131952536));
                    }
                    else if (n == 0) {
                        ((View)this.c.d).announceForAccessibility((CharSequence)((Context)this.c).getString(2131952537));
                    }
                    else if (n == 1) {
                        ((View)this.c.d).announceForAccessibility((CharSequence)((Context)this.c).getString(2131952540));
                    }
                    else if (n == 3) {
                        ((View)this.c.d).announceForAccessibility((CharSequence)((Context)this.c).getString(2131952538));
                    }
                }
                ax.Q2.a.i().m("menu_music_player", "repeat").c("loc", "fullscreen_player").e();
            }
        });
        ((View)this.f).setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final FullScreenPlayerActivity c;
            
            public void a(final View view) {
                this.c.I0().i().i();
                ax.Q2.a.i().m("menu_music_player", "next").c("loc", "fullscreen_player").e();
            }
        });
        ((View)this.e).setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final FullScreenPlayerActivity c;
            
            public void a(final View view) {
                this.c.I0().i().j();
                ax.Q2.a.i().m("menu_music_player", "prev").c("loc", "fullscreen_player").e();
            }
        });
        ((View)this.g).setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final FullScreenPlayerActivity c;
            
            public void a(final View view) {
                if (this.c.I0() == null) {
                    return;
                }
                final FullScreenPlayerActivity c = this.c;
                c.C0(c.I0(), false, false);
            }
        });
        this.B.setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final FullScreenPlayerActivity c;
            
            public void a(final View view) {
                this.c.Y0(-10000L);
            }
        });
        this.C.setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final FullScreenPlayerActivity c;
            
            public void a(final View view) {
                this.c.Y0(10000L);
            }
        });
        this.j.setOnSeekBarChangeListener((SeekBar$OnSeekBarChangeListener)new SeekBar$OnSeekBarChangeListener(this) {
            boolean a = false;
            final FullScreenPlayerActivity b;
            
            public void onProgressChanged(final SeekBar seekBar, final int n, final boolean b) {
                this.b.h.setText((CharSequence)DateUtils.formatElapsedTime((long)(n / 1000)));
                if (b && !this.a) {
                    this.b.X0(((ProgressBar)seekBar).getProgress(), false);
                }
            }
            
            public void onStartTrackingTouch(final SeekBar seekBar) {
                this.a = true;
                this.b.e1();
            }
            
            public void onStopTrackingTouch(final SeekBar seekBar) {
                this.a = false;
                this.b.X0(((ProgressBar)seekBar).getProgress(), false);
            }
        });
        ((View)this.z).setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final FullScreenPlayerActivity c;
            
            public void a(final View view) {
                this.c.f1();
            }
        });
        final d adapter = new d((Context)this);
        ((androidx.appcompat.widget.u)this.x).setAdapter((SpinnerAdapter)adapter);
        ((AdapterView)this.x).setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new AdapterView$OnItemSelectedListener(this, adapter) {
            final d a;
            final FullScreenPlayerActivity b;
            
            public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                final d.a a = (d.a)((Adapter)this.a).getItem(n);
                if (a != null) {
                    this.b.c1(a.b, true);
                }
            }
            
            public void onNothingSelected(final AdapterView<?> adapterView) {
            }
        });
        if (this.M != 0.0f) {
            this.s1();
        }
    }
    
    private void L0() {
        final Toolbar toolbar = (Toolbar)this.findViewById(2131362981);
        this.a = toolbar;
        if (toolbar != null) {
            this.setSupportActionBar(toolbar);
            return;
        }
        throw new IllegalStateException("Layout is required to include a Toolbar with id 'toolbar'");
    }
    
    private boolean M0() {
        return this.J;
    }
    
    private static boolean N0(final int n) {
        return n == 90 || n == 89 || n == 85 || n == 79 || n == 126 || n == 127 || n == 87 || n == 88;
    }
    
    private boolean O0() {
        return this.L;
    }
    
    private boolean P0() {
        return this.T != null;
    }
    
    private void Q0() {
        this.L = false;
        this.c1(this.M, false);
        ((View)this.A).setVisibility(8);
    }
    
    private void R0(final float n) {
        if (this.I0() != null) {
            final PlaybackStateCompat r = this.R;
            if (r != null && r.j() == 3) {
                this.L = true;
                if (n == 0.5f) {
                    this.A.setText((CharSequence)"0.5X\u25b6\u25b6");
                }
                else if (n == 2.0f) {
                    this.A.setText((CharSequence)"2X\u25b6\u25b6");
                }
                else {
                    ax.u3.b.f();
                    final TextView a = this.A;
                    final StringBuilder sb = new StringBuilder();
                    sb.append(n);
                    sb.append("X\u25b6\u25b6");
                    a.setText((CharSequence)sb.toString());
                }
                this.c1(n, false);
                ((View)this.A).setVisibility(0);
            }
        }
    }
    
    private void S0() {
        this.R0(2.0f);
    }
    
    private void T0() {
        this.R0(0.5f);
    }
    
    private void U0() {
        this.E.post(this.O);
    }
    
    private void V0(final File file) {
        final MediaControllerCompat i0 = this.I0();
        if (i0 == null) {
            return;
        }
        i0.i().c(Uri.fromFile(file), (Bundle)null);
    }
    
    private void W0() {
        this.e1();
        if (!((ExecutorService)this.P).isShutdown()) {
            this.Q = (ScheduledFuture<?>)this.P.scheduleAtFixedRate((Runnable)new Runnable(this) {
                final FullScreenPlayerActivity q;
                
                public void run() {
                    this.q.E.post(this.q.O);
                }
            }, 100L, 1000L, TimeUnit.MILLISECONDS);
        }
    }
    
    private void X0(final long n, final boolean b) {
        if (this.I0() == null) {
            return;
        }
        if (b) {
            ((ProgressBar)this.j).setProgress((int)n);
        }
        this.I0().i().e(n);
        this.a1(n);
        this.W0();
    }
    
    private boolean Y0(long x0) {
        if (this.I0() == null) {
            return false;
        }
        if (!this.y0()) {
            return false;
        }
        final long h = this.H;
        x0 = this.x0(x0);
        if (h == x0) {
            return false;
        }
        this.X0(x0, true);
        return true;
    }
    
    private void Z0(final boolean n) {
        ax.t3.f.b((Context)this, this.N = n);
        this.g1();
        this.invalidateOptionsMenu();
    }
    
    private void a1(final long h) {
        this.H = h;
    }
    
    private void b1(final MediaControllerCompat mediaControllerCompat) {
        MediaControllerCompat.l((Activity)this, mediaControllerCompat);
    }
    
    private void c1(final float m, final boolean b) {
        final MediaControllerCompat i0 = this.I0();
        if (i0 != null) {
            i0.i().f(m);
            if (b) {
                this.M = m;
            }
        }
    }
    
    private void d1() {
        final MediaControllerCompat i0 = this.I0();
        if (i0 != null) {
            final MediaMetadataCompat d = i0.d();
            if (d != null) {
                final String j = d.i("__SOURCE__");
                if (j != null) {
                    final Uri parse = Uri.parse(j);
                    final String h = ax.c3.v.h(parse.getPath());
                    if (h != null) {
                        ax.c3.u.k0((Context)this, h, parse);
                        ax.Q2.a.i().m("menu_music_player", "share").c("loc", "music_player").c("type", "file").e();
                    }
                }
            }
        }
    }
    
    private void e1() {
        final ScheduledFuture<?> q = this.Q;
        if (q != null) {
            ((Future)q).cancel(false);
        }
    }
    
    private void f1() {
        this.Z0(this.N ^ true);
    }
    
    private void g1() {
        if (this.N) {
            this.y.setVisibility(0);
            this.z.setImageResource(2131231112);
            ((View)this.z).setContentDescription((CharSequence)((Context)this).getString(2131952249));
            return;
        }
        this.y.setVisibility(8);
        this.z.setImageResource(2131231135);
        ((View)this.z).setContentDescription((CharSequence)((Context)this).getString(2131952263));
    }
    
    private void h1(final MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null) {
            return;
        }
        ax.S4.b.a(FullScreenPlayerActivity.Z, new Object[] { "updateDuration called " });
        this.G = mediaMetadataCompat.f("android.media.metadata.DURATION");
        this.a1(-1L);
        final int max = (int)this.G;
        ((ProgressBar)this.j).setMax(max);
        this.i.setText((CharSequence)DateUtils.formatElapsedTime((long)(max / 1000)));
    }
    
    private void i1(final Intent intent) {
        if (intent != null) {
            final MediaDescriptionCompat mediaDescriptionCompat = (MediaDescriptionCompat)intent.getParcelableExtra("com.example.android.uamp.CURRENT_MEDIA_DESCRIPTION");
            if (mediaDescriptionCompat != null) {
                this.k1(mediaDescriptionCompat);
            }
        }
    }
    
    private void j1(final int n) {
        final TextView n2 = this.n;
        if (n2 == null) {
            return;
        }
        if (n < 400) {
            final RelativeLayout$LayoutParams layoutParams = (RelativeLayout$LayoutParams)((View)n2).getLayoutParams();
            layoutParams.addRule(2, 2131362069);
            ((View)this.n).setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            return;
        }
        final RelativeLayout$LayoutParams layoutParams2 = (RelativeLayout$LayoutParams)((View)n2).getLayoutParams();
        layoutParams2.addRule(2, 2131361990);
        ((View)this.n).setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
    }
    
    private void k1(final MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        ax.S4.b.a(FullScreenPlayerActivity.Z, new Object[] { "updateMediaDescription called " });
        this.k.setText(mediaDescriptionCompat.b());
        this.l.setText(mediaDescriptionCompat.i());
        this.m.setText(mediaDescriptionCompat.g());
        this.G0(mediaDescriptionCompat);
        this.invalidateOptionsMenu();
    }
    
    private void l1(final MediaMetadataCompat mediaMetadataCompat) {
        this.k1(ax.P4.k.b(mediaMetadataCompat));
    }
    
    private void m1(final PlaybackStateCompat r) {
        final int n = 0;
        if (r == null) {
            return;
        }
        this.R = r;
        final int j = r.j();
        if (j != 0 && j != 1) {
            if (j != 2) {
                if (j != 3) {
                    if (j != 6) {
                        if (j != 7) {
                            ax.S4.b.a(FullScreenPlayerActivity.Z, new Object[] { "Unhandled state ", r.j() });
                        }
                        else {
                            this.p.setVisibility(0);
                            this.g.setVisibility(0);
                            this.g.setImageDrawable(this.r);
                            ((View)this.g).setContentDescription((CharSequence)((Context)this).getString(2131952501));
                            ((View)this.o).setVisibility(4);
                            if (ax.t3.j.o((Context)this)) {
                                final TextView n2 = this.n;
                                final StringBuilder sb = new StringBuilder();
                                sb.append(((Context)this).getString(2131951927));
                                sb.append(" : ");
                                sb.append((Object)r.c());
                                n2.setText((CharSequence)sb.toString());
                            }
                            else {
                                this.n.setText(2131951927);
                            }
                            this.e1();
                        }
                    }
                    else {
                        this.g.setVisibility(0);
                        this.g.setImageDrawable(this.q);
                        ((View)this.g).setContentDescription((CharSequence)((Context)this).getString(2131952500));
                        ((View)this.o).setVisibility(0);
                        this.n.setText(2131952143);
                        this.e1();
                    }
                }
                else {
                    this.g.setVisibility(0);
                    this.g.setImageDrawable(this.q);
                    ((View)this.g).setContentDescription((CharSequence)((Context)this).getString(2131952500));
                    this.p.setVisibility(0);
                    ((View)this.o).setVisibility(4);
                    this.n.setText((CharSequence)"");
                    this.W0();
                }
            }
            else {
                this.p.setVisibility(0);
                this.g.setVisibility(0);
                this.g.setImageDrawable(this.r);
                ((View)this.g).setContentDescription((CharSequence)((Context)this).getString(2131952501));
                ((View)this.o).setVisibility(4);
                this.n.setText((CharSequence)"");
                this.e1();
            }
        }
        else {
            this.p.setVisibility(0);
            this.g.setVisibility(0);
            this.g.setImageDrawable(this.r);
            ((View)this.g).setContentDescription((CharSequence)((Context)this).getString(2131952501));
            ((View)this.o).setVisibility(4);
            this.n.setText((CharSequence)"");
            this.e1();
            this.U0();
        }
        final ImageView f = this.f;
        int visibility;
        if ((r.b() & 0x20L) == 0x0L) {
            visibility = 4;
        }
        else {
            visibility = 0;
        }
        f.setVisibility(visibility);
        final ImageView e = this.e;
        int visibility2 = n;
        if ((r.b() & 0x10L) == 0x0L) {
            visibility2 = 4;
        }
        e.setVisibility(visibility2);
    }
    
    private void n1(final MediaMetadataCompat mediaMetadataCompat) {
        if ((int)mediaMetadataCompat.f("__TRACK_COUNT__") <= 1) {
            ((View)this.f).setEnabled(false);
            ((View)this.f).setAlpha(0.5f);
            ((View)this.e).setEnabled(false);
            ((View)this.e).setAlpha(0.5f);
            return;
        }
        ((View)this.f).setEnabled(true);
        ((View)this.f).setAlpha(1.0f);
        ((View)this.e).setEnabled(true);
        ((View)this.e).setAlpha(1.0f);
    }
    
    private void o1() {
        if (this.R == null) {
            return;
        }
        final long h0 = this.H0();
        ((ProgressBar)this.j).setProgress((int)h0);
        this.a1(h0);
    }
    
    private void p1(final Bundle bundle) {
        if (bundle != null) {
            final int int1 = ((BaseBundle)bundle).getInt("file.manager.music.player.QUEUE_POSITION", -1);
            final int int2 = ((BaseBundle)bundle).getInt("file.manager.music.player.QUEUE_SIZE", -1);
            if (int1 > 0 && int2 > 0 && this.getSupportActionBar() != null) {
                this.getSupportActionBar().H((CharSequence)this.getResources().getString(2131952497, new Object[] { int1, int2 }));
            }
        }
    }
    
    private void q1(final int n) {
        if (n == 1) {
            this.d.setImageDrawable(this.t);
            ((View)this.d).setAlpha(1.0f);
        }
        else if (n == 2) {
            this.d.setImageDrawable(this.s);
            ((View)this.d).setAlpha(1.0f);
        }
        else if (n == 3) {
            this.d.setImageDrawable(this.u);
            ((View)this.d).setAlpha(1.0f);
        }
        else {
            this.d.setImageDrawable(this.s);
            ((View)this.d).setAlpha(0.35f);
        }
        if (ax.X2.Q.a()) {
            if (n == 1) {
                ax.h3.a.a(this.d, (CharSequence)((Context)this).getString(2131952540));
                return;
            }
            if (n == 2) {
                ax.h3.a.a(this.d, (CharSequence)((Context)this).getString(2131952536));
                return;
            }
            if (n == 3) {
                ax.h3.a.a(this.d, (CharSequence)((Context)this).getString(2131952538));
                return;
            }
            ax.h3.a.a(this.d, (CharSequence)((Context)this).getString(2131952537));
        }
    }
    
    private void r1(final int n) {
        if (n == 1) {
            ((View)this.c).setAlpha(1.0f);
        }
        else {
            ((View)this.c).setAlpha(0.35f);
        }
        if (ax.X2.Q.a()) {
            if (n == 1) {
                ax.h3.a.a(this.c, (CharSequence)((Context)this).getString(2131952604));
                return;
            }
            ax.h3.a.a(this.c, (CharSequence)((Context)this).getString(2131952603));
        }
    }
    
    private void s1() {
        ((AdapterView)this.x).setSelection(com.alphainventor.filemanager.viewer.d.c(this.M));
    }
    
    private long x0(long g) {
        final long n = this.H + g;
        if ((g = this.G) < 0L) {
            g = 0L;
        }
        if (n < 0L) {
            return 0L;
        }
        if (n > g) {
            return g;
        }
        return n;
    }
    
    private boolean y0() {
        final PlaybackStateCompat r = this.R;
        if (r != null) {
            if (r.j() != 0) {
                if (this.G != 0L && this.H != -1L) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean z0() {
        return ((View)this.f).isEnabled() && ((View)this.f).getVisibility() == 0;
    }
    
    public boolean D0(final int n, final KeyEvent keyEvent) {
        if (!N0(n)) {
            return false;
        }
        final MediaControllerCompat i0 = this.I0();
        if (i0 == null) {
            return false;
        }
        final MediaControllerCompat$e j = i0.i();
        if (j == null) {
            return false;
        }
        if (n == 90) {
            this.E0(true);
        }
        else if (n == 89) {
            this.E0(false);
        }
        else if (keyEvent.getRepeatCount() == 0) {
            if (n != 79 && n != 85) {
                if (n != 87) {
                    if (n != 88) {
                        if (n != 126) {
                            if (n == 127) {
                                this.C0(i0, true, false);
                            }
                        }
                        else {
                            this.C0(i0, false, true);
                        }
                    }
                    else if (this.A0()) {
                        j.j();
                    }
                }
                else if (this.z0()) {
                    j.i();
                }
            }
            else {
                this.C0(i0, false, false);
            }
        }
        return true;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        this.S.v(configuration);
        super.onConfigurationChanged(configuration);
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131558431);
        this.L0();
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().x(true);
            this.getSupportActionBar().H((CharSequence)"");
        }
        this.b = this.findViewById(2131362661);
        this.v = (ImageView)this.findViewById(2131361912);
        this.w = (TextView)this.findViewById(2131362158);
        this.q = ax.s3.a.c((Context)this, 2131231186);
        this.r = ax.s3.a.c((Context)this, 2131231194);
        this.s = ax.s3.a.c((Context)this, 2131231203);
        this.t = ax.s3.a.c((Context)this, 2131231204);
        this.u = ax.s3.a.c((Context)this, 2131231197);
        this.g = (ImageView)this.findViewById(2131362698);
        this.f = (ImageView)this.findViewById(2131362611);
        this.e = (ImageView)this.findViewById(2131362710);
        this.c = (ImageView)this.findViewById(2131362829);
        this.d = (ImageView)this.findViewById(2131362732);
        this.h = (TextView)this.findViewById(2131362877);
        this.i = (TextView)this.findViewById(2131362183);
        this.j = (SeekBar)this.findViewById(2131362774);
        this.k = (TextView)this.findViewById(2131362447);
        this.l = (TextView)this.findViewById(2131362448);
        this.m = (TextView)this.findViewById(2131362449);
        this.n = (TextView)this.findViewById(2131362450);
        this.B = this.findViewById(2131362739);
        this.C = this.findViewById(2131362265);
        this.o = (ProgressBar)this.findViewById(2131362713);
        this.p = this.findViewById(2131362069);
        ((Spinner)(this.x = (MySpinner)this.findViewById(2131362089))).setPromptId(2131952502);
        this.y = this.findViewById(2131362063);
        this.z = (ImageView)this.findViewById(2131362091);
        this.A = (TextView)this.findViewById(2131362026);
        if (!ax.X2.Q.R()) {
            ((View)this.x).setVisibility(4);
        }
        this.J0();
        this.K0();
        if (bundle == null) {
            this.i1(((Activity)this).getIntent());
        }
        this.F = new MediaBrowserCompat((Context)this, new ComponentName((Context)this, (Class)MusicService.class), this.X, (Bundle)null);
        (this.S = new C0((c)this)).m((Configuration)null);
        final String stringExtra = ((Activity)this).getIntent().getStringExtra("extra_temp_file_path");
        this.U = ((Activity)this).getIntent().getStringExtra("extra_temp_file_type");
        if (stringExtra != null) {
            ax.s3.u.j((Context)this);
            final File t = new File(stringExtra);
            if (t.exists()) {
                this.V0(this.T = t);
                return;
            }
            Toast.makeText((Context)this, 2131951934, 1).show();
            ((Activity)this).finish();
        }
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.getMenuInflater().inflate(2131689491, menu);
        return true;
    }
    
    public void onDestroy() {
        super.onDestroy();
        this.e1();
        ((ExecutorService)this.P).shutdown();
        if (this.T != null) {
            final MediaControllerCompat i0 = this.I0();
            if (i0 != null) {
                i0.i().k();
            }
            if (!this.V) {
                this.T.delete();
            }
        }
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return this.D0(n, keyEvent) || super.onKeyDown(n, keyEvent);
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default: {
                return super.onOptionsItemSelected(menuItem);
            }
            case 2131362545: {
                this.d1();
                return true;
            }
            case 2131362536: {
                final File t = this.T;
                if (t != null) {
                    this.V = true;
                    ax.c3.u.s0((Activity)this, Uri.fromFile(t), this.U);
                    ((Activity)this).finish();
                }
                else {
                    Toast.makeText((Context)this, 2131951927, 1).show();
                }
                return true;
            }
            case 2131362511: {
                final Intent intent = new Intent("android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL");
                if (ax.R4.e.J() != 0) {
                    intent.putExtra("android.media.extra.AUDIO_SESSION", ax.R4.e.J());
                }
                try {
                    ax.c3.u.q0((Activity)this, intent, 1020);
                }
                catch (final ActivityNotFoundException | SecurityException ex) {
                    Toast.makeText((Context)this, 2131951927, 1).show();
                }
                return true;
            }
            case 16908332: {
                ((Activity)this).finish();
                return true;
            }
        }
    }
    
    public boolean onPrepareOptionsMenu(final Menu menu) {
        final MediaControllerCompat i0 = this.I0();
        String j = null;
        boolean b = false;
        Label_0051: {
            if (i0 != null) {
                final MediaMetadataCompat d = i0.d();
                if (d != null) {
                    j = d.i("__SOURCE__");
                    if (j != null) {
                        b = false;
                        break Label_0051;
                    }
                }
            }
            b = true;
        }
        final MenuItem item = menu.findItem(2131362545);
        if (item != null) {
            if (b) {
                item.setVisible(false);
            }
            else if (this.P0()) {
                item.setVisible(false);
            }
            else if (ax.Q4.b.m(j)) {
                item.setVisible(true);
            }
            else {
                item.setVisible(false);
            }
        }
        final MenuItem item2 = menu.findItem(2131362511);
        if (item2 != null) {
            final Intent intent = new Intent("android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL");
            if (b) {
                item2.setVisible(false);
            }
            else if (this.P0()) {
                item2.setVisible(false);
            }
            else if (intent.resolveActivity(((Context)this).getPackageManager()) != null) {
                item2.setVisible(true);
            }
            else {
                item2.setVisible(false);
            }
        }
        final MenuItem item3 = menu.findItem(2131362536);
        if (item3 != null) {
            if (b) {
                item3.setVisible(false);
            }
            else if (this.P0()) {
                item3.setVisible(true);
            }
            else {
                item3.setVisible(false);
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }
    
    public void onStart() {
        super.onStart();
        final MediaBrowserCompat f = this.F;
        if (f != null) {
            try {
                f.a();
            }
            catch (final IllegalStateException ex) {
                final ax.Ha.b l = ax.Ha.c.h().f().b("MEDIA BROWSER CONNECT IN FULL PLAYER").l((Throwable)ex);
                final StringBuilder sb = new StringBuilder();
                sb.append("connected:");
                sb.append(this.F.d());
                l.g((Object)sb.toString()).h();
            }
        }
        if (ax.X2.Q.N1()) {
            ax.X2.v.s(((Activity)this).getWindow(), -16777216);
            ax.X2.v.r(((Activity)this).getWindow(), -16777216);
        }
    }
    
    public void onStop() {
        super.onStop();
        final MediaBrowserCompat f = this.F;
        if (f != null) {
            f.b();
        }
        if (this.I0() != null) {
            this.I0().m(this.W);
        }
    }
    
    public void t(final int n, final int n2) {
        this.j1(n2);
    }
}
