package com.alphainventor.filemanager.musicplayer;

import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import android.app.Activity;
import android.os.BaseBundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.SystemClock;
import android.os.Parcelable;
import java.util.concurrent.TimeUnit;
import android.os.Bundle;
import android.content.Context;
import android.widget.Toast;
import ax.u3.B;
import ax.u3.g;
import android.content.Intent;
import android.support.v4.media.MediaDescriptionCompat;
import ax.P4.a$a;
import android.graphics.Bitmap;
import ax.P4.a;
import android.text.TextUtils;
import ax.P4.k;
import android.support.v4.media.session.MediaControllerCompat;
import ax.Ha.c;
import android.support.v4.media.MediaMetadataCompat;
import java.util.concurrent.Executors;
import android.os.Looper;
import ax.S4.b;
import android.view.View$OnClickListener;
import android.support.v4.media.session.MediaControllerCompat$a;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.ProgressBar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.view.View;
import androidx.fragment.app.Fragment;

public class PlaybackControlsFragment extends Fragment
{
    private static final String x0;
    private View d0;
    private View e0;
    private ImageButton f0;
    private ImageButton g0;
    private TextView h0;
    private TextView i0;
    private TextView j0;
    private ImageView k0;
    private View l0;
    private String m0;
    private ProgressBar n0;
    private PlaybackStateCompat o0;
    private final Handler p0;
    private final ScheduledExecutorService q0;
    private ScheduledFuture<?> r0;
    private boolean s0;
    private final MediaControllerCompat$a t0;
    private final View$OnClickListener u0;
    private final View$OnClickListener v0;
    private final Runnable w0;
    
    static {
        x0 = b.f((Class)PlaybackControlsFragment.class);
    }
    
    public PlaybackControlsFragment() {
        this.p0 = new Handler(Looper.getMainLooper());
        this.q0 = Executors.newSingleThreadScheduledExecutor();
        this.t0 = new MediaControllerCompat$a() {
            final PlaybackControlsFragment d;
            
            public void d(final MediaMetadataCompat mediaMetadataCompat) {
                if (mediaMetadataCompat == null) {
                    return;
                }
                try {
                    b.a(PlaybackControlsFragment.x0, new Object[] { "Received metadata state change to mediaId=", mediaMetadataCompat.e().f(), " song=", mediaMetadataCompat.e().i() });
                }
                catch (final RuntimeException ex) {
                    c.h().f().d("METADATA COULD NOT READ BITMAP").l((Throwable)ex).h();
                }
                this.d.X2(mediaMetadataCompat);
            }
            
            public void e(final PlaybackStateCompat playbackStateCompat) {
                b.a(PlaybackControlsFragment.x0, new Object[] { "Received playback state change to state ", playbackStateCompat.j() });
                this.d.Y2(playbackStateCompat, false);
            }
        };
        this.u0 = (View$OnClickListener)new ax.g3.c() {
            final PlaybackControlsFragment c;
            
            public void a(final View view) {
                final com.alphainventor.filemanager.activity.b b = (com.alphainventor.filemanager.activity.b)this.c.f0();
                if (b != null) {
                    if (this.c.X0()) {
                        b.K0();
                    }
                }
            }
        };
        this.v0 = (View$OnClickListener)new ax.g3.c() {
            final PlaybackControlsFragment c;
            
            public void a(final View view) {
                if (this.c.X0()) {
                    final MediaControllerCompat f0 = ((com.alphainventor.filemanager.activity.b)this.c.f0()).f0();
                    if (f0 == null) {
                        final com.alphainventor.filemanager.activity.b b = (com.alphainventor.filemanager.activity.b)this.c.f0();
                        final ax.Ha.b d = ax.Ha.c.h().d("MediaController == null");
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Stopped:");
                        sb.append(b.n0());
                        sb.append(":isConnecting:");
                        sb.append(b.l0());
                        d.g((Object)sb.toString()).h();
                        return;
                    }
                    final PlaybackStateCompat e = f0.e();
                    int j;
                    if (e == null) {
                        j = 0;
                    }
                    else {
                        j = e.j();
                    }
                    final String k2 = PlaybackControlsFragment.x0;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Button pressed, in state ");
                    sb2.append(j);
                    b.a(k2, new Object[] { sb2.toString() });
                    if (view.getId() == 2131362698) {
                        final String k3 = PlaybackControlsFragment.x0;
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("Play button pressed, in state ");
                        sb3.append(j);
                        b.a(k3, new Object[] { sb3.toString() });
                        if (j != 2 && j != 1 && j != 0) {
                            if (j == 3 || j == 6 || j == 8) {
                                this.c.a3();
                            }
                        }
                        else {
                            this.c.b3();
                        }
                    }
                }
            }
        };
        this.w0 = (Runnable)new Runnable() {
            final PlaybackControlsFragment q;
            
            public void run() {
                this.q.g3();
            }
        };
    }
    
    private void X2(final MediaMetadataCompat mediaMetadataCompat) {
        final String x0 = PlaybackControlsFragment.x0;
        b.a(x0, new Object[] { "onMetadataChanged ", mediaMetadataCompat });
        if (this.f0() == null) {
            b.j(x0, new Object[] { "onMetadataChanged called when getActivity null,this should not happen if the callback was properly unregistered. Ignoring." });
            return;
        }
        if (mediaMetadataCompat != null) {
            final PlaybackStateCompat o0 = this.o0;
            if (o0 != null && o0.j() == 0) {
                this.h3();
            }
            final MediaDescriptionCompat b = k.b(mediaMetadataCompat);
            this.h0.setText(b.i());
            if (this.d0.isAccessibilityFocused()) {
                this.d0.announceForAccessibility(b.i());
            }
            this.i0.setText(b.g());
            this.f3(mediaMetadataCompat);
            this.g3();
            String string;
            if (b.d() != null) {
                string = b.d().toString();
            }
            else {
                string = null;
            }
            if (!TextUtils.equals((CharSequence)string, (CharSequence)this.m0)) {
                this.m0 = string;
                final Bitmap c = b.c();
                final a i = a.i();
                Bitmap j;
                if ((j = c) == null) {
                    j = i.j(this.m0);
                }
                if (j != null) {
                    this.k0.setImageBitmap(j);
                    return;
                }
                this.k0.setImageBitmap((Bitmap)null);
                if (string == null) {
                    this.k0.setImageResource(2131231122);
                    return;
                }
                i.f(this.b().getApplicationContext(), string, (a$a)new a$a(this) {
                    final PlaybackControlsFragment a;
                    
                    public void b(final String s, final Exception ex) {
                        super.b(s, ex);
                        if (!s.equals((Object)this.a.m0)) {
                            return;
                        }
                        this.a.k0.setImageResource(2131231122);
                    }
                    
                    public void c(final String s, final Bitmap bitmap, final Bitmap imageBitmap, final Bitmap bitmap2) {
                        if (s.equals((Object)this.a.m0)) {
                            if (bitmap2 != null) {
                                this.a.k0.setImageBitmap(imageBitmap);
                            }
                        }
                    }
                });
            }
        }
    }
    
    private void Y2(final PlaybackStateCompat o0, final boolean b) {
        final String x0 = PlaybackControlsFragment.x0;
        b.a(x0, new Object[] { "onPlaybackStateChanged ", o0 });
        if (this.f0() == null) {
            b.j(x0, new Object[] { "onPlaybackStateChanged called when getActivity null,this should not happen if the callback was properly unregistered. Ignoring." });
            return;
        }
        if (o0 == null) {
            return;
        }
        this.o0 = o0;
        final int j = o0.j();
        Label_0380: {
            if (j != 0) {
                if (j != 1 && j != 2) {
                    if (j != 3) {
                        if (j != 6) {
                            if (j == 7) {
                                b.c(x0, new Object[] { "error playbackstate: ", o0.c() });
                                Label_0276: {
                                    if (!b) {
                                        final Bundle d = o0.d();
                                        if (d != null && ((BaseBundle)d).getInt("SUB_ERROR_CODE", 0) == 4005) {
                                            final String string = ((BaseBundle)d).getString("SUB_ERROR_MSG");
                                            if (string != null && ax.P2.a.q(string)) {
                                                final Intent intent = new Intent("local.intent.action.SHOW_CODEC_DOWNLOAD");
                                                intent.putExtra("mimetype", string);
                                                g.a().e(intent);
                                                break Label_0276;
                                            }
                                        }
                                        View viewById;
                                        if (this.f0() != null) {
                                            viewById = ((Activity)this.f0()).findViewById(16908290);
                                        }
                                        else {
                                            viewById = null;
                                        }
                                        if (viewById != null) {
                                            B.T(viewById, o0.c(), 0).a0();
                                        }
                                        else {
                                            Toast.makeText((Context)this.f0(), o0.c(), 1).show();
                                        }
                                    }
                                }
                                this.l0.setVisibility(8);
                                this.e3();
                                break Label_0380;
                            }
                            this.e3();
                            this.l0.setVisibility(8);
                        }
                        else {
                            this.e3();
                            this.l0.setVisibility(0);
                        }
                    }
                    else {
                        this.l0.setVisibility(8);
                        this.c3();
                    }
                    ((ImageView)this.f0).setImageDrawable(ax.s3.a.c((Context)this.f0(), 2131231186));
                    ((View)this.f0).setContentDescription((CharSequence)this.M0(2131952500));
                    return;
                }
                this.l0.setVisibility(8);
                this.Z2();
                this.e3();
            }
            else {
                this.Z2();
                this.h3();
            }
        }
        ((ImageView)this.f0).setImageDrawable(ax.s3.a.c((Context)this.f0(), 2131231194));
        ((View)this.f0).setContentDescription((CharSequence)this.M0(2131952501));
    }
    
    private void Z2() {
        this.p0.post(this.w0);
    }
    
    private void a3() {
        final MediaControllerCompat f0 = ((com.alphainventor.filemanager.activity.b)this.f0()).f0();
        if (f0 != null) {
            f0.i().a();
            this.e3();
        }
        ax.Q2.a.i().m("menu_music_player", "pause").c("loc", "playback_control").e();
    }
    
    private void b3() {
        final MediaControllerCompat f0 = ((com.alphainventor.filemanager.activity.b)this.f0()).f0();
        if (f0 != null) {
            f0.i().b();
            this.c3();
        }
        ax.Q2.a.i().m("menu_music_player", "play").c("loc", "playback_control").e();
    }
    
    private void c3() {
        this.e3();
        if (!((ExecutorService)this.q0).isShutdown()) {
            this.r0 = (ScheduledFuture<?>)this.q0.scheduleAtFixedRate((Runnable)new Runnable(this) {
                final PlaybackControlsFragment q;
                
                public void run() {
                    this.q.p0.post(this.q.w0);
                }
            }, 100L, 1000L, TimeUnit.MILLISECONDS);
        }
    }
    
    private void d3() {
        final com.alphainventor.filemanager.activity.b b = (com.alphainventor.filemanager.activity.b)this.f0();
        final Intent intent = new Intent((Context)this.f0(), (Class)FullScreenPlayerActivity.class);
        intent.setFlags(536870912);
        final MediaControllerCompat f0 = b.f0();
        if (f0 == null) {
            final ax.Ha.b d = c.h().d("MediaController NULL!!");
            final StringBuilder sb = new StringBuilder();
            sb.append(b.n0());
            sb.append(":");
            sb.append(b.l0());
            d.g((Object)sb.toString()).h();
            return;
        }
        final MediaMetadataCompat d2 = f0.d();
        while (true) {
            if (d2 == null) {
                break Label_0117;
            }
            try {
                intent.putExtra("com.example.android.uamp.CURRENT_MEDIA_DESCRIPTION", (Parcelable)d2.e());
                this.F2(intent);
                ax.Q2.a.i().m("menu_music_player", "fullscreen").e();
            }
            catch (final RuntimeException ex) {
                continue;
            }
            break;
        }
    }
    
    private void e3() {
        final ScheduledFuture<?> r0 = this.r0;
        if (r0 != null) {
            ((Future)r0).cancel(false);
        }
    }
    
    private void f3(final MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null) {
            return;
        }
        b.a(PlaybackControlsFragment.x0, new Object[] { "updateDuration called " });
        this.n0.setMax((int)mediaMetadataCompat.f("android.media.metadata.DURATION"));
    }
    
    private void g3() {
        final PlaybackStateCompat o0 = this.o0;
        if (o0 == null) {
            return;
        }
        long i;
        final long n = i = o0.i();
        if (this.o0.j() != 0) {
            i = n;
            if (this.o0.j() != 2) {
                i = n;
                if (this.o0.j() != 1) {
                    i = (long)(n + (int)(SystemClock.elapsedRealtime() - this.o0.e()) * this.o0.f());
                }
            }
        }
        this.n0.setProgress((int)i);
    }
    
    private void h3() {
        if (this.f0() == null) {
            return;
        }
        final MediaControllerCompat f0 = ((com.alphainventor.filemanager.activity.b)this.f0()).f0();
        if (f0 != null && f0.d() != null) {
            final MediaDescriptionCompat e = f0.d().e();
            if (e.f() != null && e.i() == null) {
                this.l0.setVisibility(0);
                return;
            }
        }
        this.l0.setVisibility(8);
    }
    
    public void J1() {
        super.J1();
        b.a(PlaybackControlsFragment.x0, new Object[] { "fragment.onStart" });
        final MediaControllerCompat f0 = ((com.alphainventor.filemanager.activity.b)this.f0()).f0();
        if (f0 != null) {
            this.V2(f0);
        }
    }
    
    public void K1() {
        super.K1();
        b.a(PlaybackControlsFragment.x0, new Object[] { "fragment.onStop" });
        final MediaControllerCompat f0 = ((com.alphainventor.filemanager.activity.b)this.f0()).f0();
        if (f0 != null) {
            this.W2(f0);
        }
    }
    
    public void V2(final MediaControllerCompat mediaControllerCompat) {
        b.a(PlaybackControlsFragment.x0, new Object[] { "onConnected, mediaController==null? ", mediaControllerCompat == null });
        if (mediaControllerCompat != null) {
            this.X2(mediaControllerCompat.d());
            this.Y2(mediaControllerCompat.e(), true);
            mediaControllerCompat.j(this.t0);
            this.s0 = true;
            final PlaybackStateCompat e = mediaControllerCompat.e();
            this.g3();
            if (e != null && (e.j() == 3 || e.j() == 6)) {
                this.c3();
            }
        }
    }
    
    public void W2(final MediaControllerCompat mediaControllerCompat) {
        if (mediaControllerCompat != null && this.s0) {
            mediaControllerCompat.m(this.t0);
            this.s0 = false;
        }
    }
    
    public View r1(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final View inflate = layoutInflater.inflate(2131558556, viewGroup, false);
        this.d0 = inflate;
        this.e0 = inflate.findViewById(2131362989);
        ((View)(this.f0 = (ImageButton)inflate.findViewById(2131362698))).setEnabled(true);
        ((View)this.f0).setOnClickListener(this.v0);
        ((View)(this.g0 = (ImageButton)inflate.findViewById(2131362900))).setEnabled(true);
        ((View)this.g0).setOnClickListener(this.u0);
        (this.h0 = (TextView)inflate.findViewById(2131362963)).setSelected(true);
        this.i0 = (TextView)inflate.findViewById(2131361901);
        this.j0 = (TextView)inflate.findViewById(2131362263);
        this.k0 = (ImageView)inflate.findViewById(2131361877);
        this.n0 = (ProgressBar)inflate.findViewById(2131362699);
        this.l0 = inflate.findViewById(2131362712);
        this.k0.setImageResource(2131231122);
        this.e0.setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final PlaybackControlsFragment c;
            
            public void a(final View view) {
                this.c.d3();
            }
        });
        return inflate;
    }
    
    public void s1() {
        super.s1();
        this.e3();
        ((ExecutorService)this.q0).shutdown();
    }
}
