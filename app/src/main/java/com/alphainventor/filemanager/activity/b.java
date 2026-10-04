package com.alphainventor.filemanager.activity;

import android.os.BaseBundle;
import android.util.Pair;
import java.util.ArrayList;
import com.alphainventor.filemanager.service.HttpServerService;
import ax.u3.g;
import android.content.Intent;
import com.alphainventor.filemanager.bookmark.Bookmark;
import android.content.ComponentName;
import com.example.android.uamp.MusicService;
import android.content.res.Configuration;
import com.alphainventor.filemanager.widget.WindowInsetsFrameLayout;
import android.graphics.Point;
import ax.x3.A;
import ax.Z2.k;
import androidx.fragment.app.Fragment;
import ax.Q2.f;
import android.view.ViewGroup$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout$c;
import com.google.android.material.behavior.SwipeDismissBehavior$c;
import android.view.ViewGroup;
import com.google.android.material.behavior.SwipeDismissBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$f;
import ax.x3.h;
import ax.d3.Z;
import ax.X2.Q;
import ax.c3.B;
import java.util.List;
import com.alphainventor.filemanager.file.n;
import android.app.Activity;
import ax.Ha.c;
import android.content.Context;
import ax.s3.u;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.MediaBrowserCompat$c;
import android.support.v4.media.session.MediaControllerCompat$a;
import ax.d3.x0;
import ax.d3.C0;
import android.os.Bundle;
import android.net.Uri;
import ax.Q2.j;
import com.alphainventor.filemanager.musicplayer.PlaybackControlsFragment;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.MediaBrowserCompat;
import ax.d3.x0$a;

public abstract class b extends a implements x0$a
{
    private MediaBrowserCompat j;
    private MediaControllerCompat k;
    private CoordinatorLayout l;
    private View m;
    protected PlaybackControlsFragment n;
    private j o;
    private boolean p;
    private Uri q;
    private Bundle r;
    private boolean s;
    private boolean t;
    private C0 u;
    private x0 v;
    private final MediaControllerCompat$a w;
    private final MediaBrowserCompat$c x;
    
    public b() {
        this.p = false;
        this.s = false;
        this.t = false;
        this.w = new MediaControllerCompat$a() {
            final b d;
            
            public void d(final MediaMetadataCompat mediaMetadataCompat) {
                this.d.M0();
            }
            
            public void e(final PlaybackStateCompat playbackStateCompat) {
                this.d.M0();
            }
        };
        this.x = new MediaBrowserCompat$c() {
            final b c;
            
            public void a() {
                this.c.p = false;
                try {
                    final b c = this.c;
                    c.c0(c.j.c());
                }
                catch (final RemoteException ex) {
                    this.c.j0();
                }
            }
            
            public void b() {
                this.c.p = false;
            }
            
            public void c() {
                this.c.p = false;
                this.c.s0();
            }
        };
    }
    
    private void D0(final MediaControllerCompat k) {
        this.k = k;
    }
    
    private void b0() {
        if (!this.p) {
            ax.s3.u.j((Context)this);
            try {
                this.j.a();
                this.p = true;
            }
            catch (final IllegalStateException ex) {
                ax.Ha.c.h().f().b("MEDIA BROWSER CONNECT").l((Throwable)ex).h();
            }
        }
    }
    
    private void c0(final MediaSessionCompat$Token mediaSessionCompat$Token) throws RemoteException {
        final MediaControllerCompat mediaControllerCompat = new MediaControllerCompat((Context)this, mediaSessionCompat$Token);
        MediaControllerCompat.l((Activity)this, mediaControllerCompat);
        this.D0(mediaControllerCompat);
        mediaControllerCompat.j(this.w);
        this.M0();
        final PlaybackControlsFragment n = this.n;
        if (n != null) {
            n.V2(mediaControllerCompat);
        }
        this.u0();
        if (this.q != null) {
            if (this.r.getBoolean("PLAY_PREPARE", false)) {
                mediaControllerCompat.i().d(this.q, this.r);
            }
            else {
                mediaControllerCompat.i().c(this.q, this.r);
            }
            this.q = null;
            this.r = null;
        }
    }
    
    public boolean A0(final n n, final String s, final List<n> list, final int n2) {
        if (this.q != null) {
            return false;
        }
        final boolean d = B.d(n);
        return (!Q.a0() || d || !this.n0() || !ax.u3.B.N((Context)this)) && this.y0(n, s, list, true, n2);
    }
    
    protected void B0() {
        final x0 v = this.v;
        if (v != null) {
            v.g();
        }
    }
    
    public void C0(final Z z) {
        final C0 u = this.u;
        if (u != null) {
            u.x(z);
        }
    }
    
    public void E0(final int n) {
        final x0 v = this.v;
        if (v != null) {
            v.i(n);
        }
    }
    
    public void F0(final h.a a) {
        final h e0 = this.e0();
        if (e0 != null) {
            if (a != e0.d()) {
                e0.a(a);
                this.x0();
            }
        }
    }
    
    void G0() {
        final ViewGroup$LayoutParams layoutParams = this.m.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout$f) {
            final SwipeDismissBehavior<ViewGroup> swipeDismissBehavior = new SwipeDismissBehavior<ViewGroup>(this) {
                final b l;
                
                public boolean J(final View view) {
                    return true;
                }
            };
            swipeDismissBehavior.Q(0.1f);
            swipeDismissBehavior.O(0.6f);
            swipeDismissBehavior.R(2);
            swipeDismissBehavior.P((SwipeDismissBehavior$c)new SwipeDismissBehavior$c(this) {
                final b a;
                
                public void a(final View view) {
                    this.a.K0();
                }
                
                public void b(final int n) {
                }
            });
            ((CoordinatorLayout$f)layoutParams).o((CoordinatorLayout$c)swipeDismissBehavior);
        }
    }
    
    protected boolean H0() {
        final MediaControllerCompat f0 = this.f0();
        if (f0 != null && f0.d() != null) {
            if (f0.e() != null) {
                final ax.d3.n d0 = this.d0();
                final int j = f0.e().j();
                if (d0 != null && d0.z3() == ax.Q2.f.A0) {
                    if (j != 1) {
                        return j != 7;
                    }
                    return ax.h3.b.b((Context)this).e();
                }
                else {
                    if (j != 0) {
                        if (j != 1) {
                            if (j == 2) {
                                return true;
                            }
                            if (j != 7) {
                                if (d0 != null && d0.C3() != null) {
                                    Label_0178: {
                                        try {
                                            final String string = ((BaseBundle)f0.d().d()).getString("__SOURCE_FOLDER__");
                                            if (string != null && string.equals((Object)B.U(d0.A3(), d0.C3()))) {
                                                return true;
                                            }
                                        }
                                        catch (final RuntimeException ex) {
                                            break Label_0178;
                                        }
                                        return j != 2;
                                    }
                                    final RuntimeException ex;
                                    ax.Ha.c.h().f().b("MusicPlayer MetaData error").l((Throwable)ex).h();
                                    return false;
                                }
                                return j != 2;
                            }
                        }
                        return false;
                    }
                    if (!ax.h3.b.b((Context)this).f(3600000L)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    protected void I0() {
        if (!this.t) {
            this.m.clearAnimation();
            this.m.setAlpha(1.0f);
            if (((View)this.l).getVisibility() != 0) {
                this.l.setVisibility(0);
                ((androidx.fragment.app.f)this).getSupportFragmentManager().o().t(2130771996, 2130771997, 2130771996, 2130771997).v((Fragment)this.n).j();
                this.B0();
            }
        }
    }
    
    public void J0(final boolean b) {
        final h e0 = this.e0();
        if (e0 == null) {
            return;
        }
        e0.t(b);
    }
    
    public void K0() {
        final MediaControllerCompat f0 = this.f0();
        if (f0 != null && f0.d() != null && f0.e() != null) {
            MediaControllerCompat.c((Activity)this).i().k();
            ax.h3.b.b((Context)this).a();
            this.j0();
            return;
        }
        this.j0();
    }
    
    public abstract void L0();
    
    protected void M0() {
        if (this.n != null) {
            if (!((Activity)this).isFinishing()) {
                if (this.H0()) {
                    this.I0();
                    return;
                }
                this.j0();
                final MediaControllerCompat f0 = this.f0();
                if (f0 != null && f0.e() != null && f0.e().j() == 2) {
                    final k c = ax.h3.b.b((Context)this).c();
                    if (c == null || c.b() != ax.Q2.f.A0) {
                        f0.i().k();
                    }
                }
            }
        }
    }
    
    public void Y(final Z z) {
        final C0 u = this.u;
        if (u != null) {
            u.n(z);
        }
    }
    
    public abstract void a0(final f p0, final int p1, final String p2);
    
    public abstract ax.d3.n d0();
    
    public abstract h e0();
    
    public MediaControllerCompat f0() {
        return this.k;
    }
    
    public j g0() {
        return this.o;
    }
    
    public abstract A h0();
    
    public Point i0() {
        final C0 u = this.u;
        if (u == null) {
            ax.u3.b.g("Invalid WindowSizeChanged Called.");
            return new Point(0, 0);
        }
        return u.t((Context)this);
    }
    
    protected void j0() {
        if (!this.t) {
            final CoordinatorLayout l = this.l;
            if (l != null && ((View)l).getVisibility() != 8) {
                ((androidx.fragment.app.f)this).getSupportFragmentManager().o().p((Fragment)this.n).j();
                this.l.setVisibility(8);
                this.B0();
            }
        }
    }
    
    protected void k0() {
        (this.v = new x0((ax.n.c)this, (x0$a)this)).d((WindowInsetsFrameLayout)this.findViewById(2131362746));
    }
    
    public boolean l0() {
        return this.p;
    }
    
    protected boolean m0() {
        return this.n != null && ((View)this.l).getVisibility() == 0;
    }
    
    public boolean n0() {
        return this.s;
    }
    
    public boolean o0() {
        final C0 u = this.u;
        return u != null && u.u();
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        final C0 u = this.u;
        if (u != null) {
            u.v(configuration);
        }
        super.onConfigurationChanged(configuration);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.j = new MediaBrowserCompat((Context)this, new ComponentName((Context)this, (Class)MusicService.class), this.x, (Bundle)null);
        this.o = new j();
        this.s = false;
        com.alphainventor.filemanager.shizuku.c.t().j();
        (this.u = new C0((ax.n.c)this)).m((Configuration)null);
    }
    
    @Override
    protected void onDestroy() {
        this.t = true;
        super.onDestroy();
        com.alphainventor.filemanager.shizuku.c.t().G();
    }
    
    public void onIMEVisibilityChanged(final boolean b) {
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        this.s = false;
        final CoordinatorLayout l = (CoordinatorLayout)this.findViewById(2131362700);
        this.l = l;
        if (l == null) {
            throw new IllegalStateException("Mising view with id 'controls'. Cannot continue.");
        }
        this.m = this.findViewById(2131362334);
        this.G0();
        if ((this.n = (PlaybackControlsFragment)((androidx.fragment.app.f)this).getSupportFragmentManager().j0(2131362334)) != null) {
            this.j0();
            if (MusicService.G() && !this.p) {
                if (this.j.d()) {
                    this.j.b();
                }
                this.b0();
            }
            return;
        }
        throw new IllegalStateException("Mising fragment with id 'controls'. Cannot continue.");
    }
    
    protected void onStop() {
        super.onStop();
        this.s = true;
        this.p = false;
        this.s0();
        this.j.b();
    }
    
    public abstract void p0();
    
    public abstract void q0(final String p0);
    
    public abstract void r0(final Bookmark p0);
    
    protected void s0() {
        this.q = null;
        this.r = null;
        if (this.f0() != null) {
            this.f0().m(this.w);
            final PlaybackControlsFragment n = this.n;
            if (n != null) {
                n.W2(this.f0());
            }
        }
        this.D0(null);
        MediaControllerCompat.l((Activity)this, (MediaControllerCompat)null);
        this.v0();
        this.j0();
    }
    
    public abstract void t0(final f p0, final int p1, final String p2, final boolean p3);
    
    protected void u0() {
        final Intent intent = new Intent("local.intent.action.ACTION_MEDIA_CONTROLLER_CHANGED");
        intent.putExtra("CONNECTED", true);
        ax.u3.g.a().e(intent);
    }
    
    protected void v0() {
        final Intent intent = new Intent("local.intent.action.ACTION_MEDIA_CONTROLLER_CHANGED");
        intent.putExtra("CONNECTED", false);
        ax.u3.g.a().e(intent);
    }
    
    public abstract void w0(final f p0, final int p1, final String p2, final boolean p3);
    
    public abstract void x0();
    
    public boolean y0(final n n, final String s, final List<n> list, final boolean b, final int n2) {
        ax.Q4.a.b().a();
        final boolean d = B.d(n);
        final int h = com.alphainventor.filemanager.service.b.f((Context)this).h();
        if (!d) {
            HttpServerService.q((Context)this, n.P(), n.L(), true, true, false, (Intent)null);
        }
        final Bundle bundle = new Bundle();
        if (list != null && list.size() != 0) {
            final ArrayList c = ax.c3.A.c((List)list);
            final ArrayList list2 = new ArrayList();
            if (c.size() != 0) {
                final ArrayList list3 = new ArrayList();
                final int size = c.size();
                boolean b2 = false;
                int i = 0;
                while (i < size) {
                    final Object value = c.get(i);
                    ++i;
                    final n n3 = (n)value;
                    if (n.E().equals((Object)n3.E())) {
                        b2 = true;
                    }
                    Uri uri;
                    if (B.d(n3)) {
                        uri = ax.c3.u.H(n3, true);
                    }
                    else {
                        list2.add((Object)n3);
                        uri = HttpServerService.l(h, n3);
                    }
                    list3.add((Object)new Pair((Object)uri, (Object)n3.Q()));
                }
                if (list2.size() > 0) {
                    com.alphainventor.filemanager.service.b.f(this.b()).b((List)list2);
                }
                if (b2) {
                    ax.Q4.a.b().d(list3);
                }
            }
        }
        ((BaseBundle)bundle).putString("PLAY_FOLDER_URI", s);
        bundle.putBoolean("PLAY_LOCAL_HTTP", d ^ true);
        ((BaseBundle)bundle).putInt("PLAYER_ENGINE", ax.t3.j.h((Context)this));
        if (b) {
            bundle.putBoolean("PLAY_PREPARE", b);
        }
        ((BaseBundle)bundle).putInt("PLAY_RESUME_POSITION", n2);
        Uri uri2;
        if (d) {
            uri2 = ax.c3.u.H(n, true);
        }
        else {
            com.alphainventor.filemanager.service.b.f(this.b()).c(n);
            uri2 = HttpServerService.l(h, n);
        }
        b.b((Context)this).h(s, n.Q(), n2);
        this.z0(uri2, bundle);
        return true;
    }
    
    public void z0(final Uri q, final Bundle r) {
        if (this.f0() == null) {
            this.q = q;
            this.r = r;
            this.b0();
            return;
        }
        this.q = null;
        this.r = null;
        if (r.getBoolean("PLAY_PREPARE", false)) {
            this.f0().i().d(q, r);
            return;
        }
        this.f0().i().c(q, r);
    }
}
