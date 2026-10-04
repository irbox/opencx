package com.example.android.uamp;

import java.lang.ref.Reference;
import android.app.Service;
import android.os.BaseBundle;
import android.os.Message;
import java.lang.ref.WeakReference;
import android.os.Handler;
import android.os.RemoteException;
import android.app.PendingIntent;
import android.content.ComponentName;
import androidx.media.session.MediaButtonReceiver;
import ax.R4.h;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import ax.P4.i;
import ax.R4.h$b;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import java.util.List;
import ax.M0.c$e;
import ax.M0.c$l;
import android.os.Bundle;
import ax.R4.e;
import ax.P4.k;
import android.support.v4.media.session.PlaybackStateCompat;
import ax.R4.f;
import android.content.Intent;
import ax.L0.a;
import android.content.SharedPreferences;
import android.content.Context;
import ax.P4.d;
import android.support.v4.media.session.MediaSessionCompat;
import ax.R4.g;
import ax.Q4.b;
import ax.R4.g$c;
import ax.M0.c;

public class MusicService extends c implements g$c
{
    private static final String r;
    private static boolean s;
    private static int t;
    private static boolean u;
    private static boolean v;
    private ax.Q4.b j;
    private g k;
    private MediaSessionCompat l;
    private d m;
    private final b n;
    private ax.P4.g o;
    private boolean p;
    private boolean q;
    
    static {
        r = ax.S4.b.f((Class)MusicService.class);
        MusicService.s = false;
        MusicService.t = 0;
        MusicService.u = false;
        MusicService.v = false;
    }
    
    public MusicService() {
        this.n = new b(this);
    }
    
    private static int E(final Context context) {
        return context.getSharedPreferences("musicplayer", 0).getInt("repeatmode", 0);
    }
    
    private static int F(final Context context) {
        return context.getSharedPreferences("musicplayer", 0).getInt("shufflemode", 0);
    }
    
    public static boolean G() {
        return MusicService.s;
    }
    
    public static boolean H() {
        return MusicService.s && MusicService.v;
    }
    
    public static boolean I() {
        return MusicService.s && MusicService.t == 3 && MusicService.u;
    }
    
    private static void J(final Context context, final int n) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("musicplayer", 0);
        if (sharedPreferences.getInt("repeatmode", 0) != n) {
            sharedPreferences.edit().putInt("repeatmode", n).apply();
        }
    }
    
    private static void K(final Context context, final int n) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("musicplayer", 0);
        if (sharedPreferences.getInt("shufflemode", 0) != n) {
            sharedPreferences.edit().putInt("shufflemode", n).apply();
        }
    }
    
    public static void L(final Context context) {
        a.b(context).d(new Intent("local.intent.action.LOCAL_PLAYLIST_SAVE"));
    }
    
    public static void M(final Context context) {
        a.b(context).d(new Intent("local.intent.action.LOCAL_PLAYLIST_CLEAR"));
    }
    
    public static void N(final Context context, final String s, final String s2, final int n) {
        final Intent intent = new Intent("local.intent.action.LOCAL_PLAYLIST_SAVE");
        intent.putExtra("folder_uri", s);
        intent.putExtra("media_id", s2);
        intent.putExtra("current_position", n);
        a.b(context).d(intent);
    }
    
    private void O(final boolean p2, final boolean q) {
        this.p = p2;
        this.q = q;
    }
    
    public void a(final f f, final boolean b) {
        this.O(false, b);
        this.n.removeCallbacksAndMessages((Object)null);
        if (b) {
            this.n.sendEmptyMessageDelayed(1, 1800000L);
        }
        else {
            this.n.sendEmptyMessageDelayed(0, 30000L);
        }
        if (ax.P4.b.a()) {
            final d m = this.m;
            if (m != null) {
                m.r(b ^ true);
            }
        }
        else {
            final d i = this.m;
            if (i != null) {
                i.r(b ^ true);
            }
        }
        final Intent intent = new Intent("local.intent.action.LOCAL_PLAYBACK_STOP");
        if (b) {
            intent.putExtra("state", 2);
        }
        else {
            intent.putExtra("state", 1);
        }
        a.b((Context)this).d(intent);
        if (b) {
            N((Context)this, this.j.d(), f.i(), f.j());
        }
    }
    
    public void b() throws ax.S4.a {
        final d m = this.m;
        if (m != null) {
            m.t();
        }
    }
    
    public void c(final PlaybackStateCompat playbackStateCompat) {
        playbackStateCompat.j();
        MusicService.t = playbackStateCompat.j();
        MusicService.v = this.j.j();
        MusicService.u = this.k.B();
        final MediaSessionCompat l = this.l;
        if (l != null) {
            l.m(playbackStateCompat);
        }
    }
    
    public void d() {
        this.O(true, false);
        if (!this.l.e()) {
            this.l.g(true);
        }
        this.n.removeCallbacksAndMessages((Object)null);
        final Intent intent = new Intent(((Context)this).getApplicationContext(), (Class)MusicService.class);
        try {
            ax.P4.k.d((Context)this, intent);
        }
        catch (final IllegalStateException ex) {
            ax.Ha.c.i((Context)this).f().b("MUSIC SERVICE START FOREGROUND ERROR").l((Throwable)ex).h();
        }
    }
    
    public void e(final f f, final String s, final boolean b, final boolean b2) {
        this.O(false, false);
        if (s != null) {
            if (this.k.x() instanceof e) {
                ((e)this.k.x()).I();
            }
            final d m = this.m;
            if (m != null && !m.p() && this.m.o()) {
                this.n.removeCallbacksAndMessages((Object)null);
                this.n.sendEmptyMessageDelayed(0, 9500L);
                if (!ax.P4.b.a()) {
                    this.m.r(true);
                }
            }
            else {
                this.n.removeCallbacksAndMessages((Object)null);
                this.n.sendEmptyMessageDelayed(0, 30000L);
            }
            if (b2) {
                M((Context)this);
            }
        }
    }
    
    public void g(final float n) {
    }
    
    public void j(final int n) {
        this.l.p(n);
        J((Context)this, n);
    }
    
    public void m(final String s, final Bundle bundle, final c$l<Bundle> c$l) {
        super.m(s, bundle, (c$l)c$l);
    }
    
    public c$e n(final String s, final int n, final Bundle bundle) {
        final String r = MusicService.r;
        final StringBuilder sb = new StringBuilder();
        sb.append("OnGetRoot: clientPackageName=");
        sb.append(s);
        final String string = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("; clientUid=");
        sb2.append(n);
        sb2.append(" ; rootHints=");
        ax.S4.b.a(r, new Object[] { string, sb2.toString(), bundle });
        if (this.o == null) {
            this.o = new ax.P4.g((Context)this);
        }
        if (!this.o.a((Context)this, s, n)) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("OnGetRoot: IGNORING request from untrusted package ");
            sb3.append(s);
            ax.S4.b.j(r, new Object[] { sb3.toString() });
            return null;
        }
        return new c$e("__ROOT__", (Bundle)null);
    }
    
    public void o(final String s, final c$l<List<MediaBrowserCompat$MediaItem>> c$l) {
        ax.S4.b.a(MusicService.r, new Object[] { "OnLoadChildren: parentMediaId=", s });
        c$l.f((Object)this.j.c(s, ((Context)this).getResources()));
    }
    
    public void onCreate() {
        super.onCreate();
        ax.S4.b.a(MusicService.r, new Object[] { "onCreate" });
        MusicService.s = true;
        this.j = new ax.Q4.b();
        this.k = new g((g$c)this, ((Context)this).getResources(), this.j, new h((Context)this, this.j, ((Context)this).getResources(), (h$b)new h$b(this) {
            final MusicService a;
            
            public void a() {
                this.a.k.N(((Context)this.a).getString(i.d), 0, (String)null);
            }
            
            public void b(final int n) {
                this.a.k.z();
            }
            
            public void c(final String s, final List<MediaSessionCompat$QueueItem> list) {
                this.a.l.n((List)list);
                this.a.l.o((CharSequence)s);
            }
            
            public void u(final MediaMetadataCompat mediaMetadataCompat) {
                this.a.l.l(mediaMetadataCompat);
                final Bundle bundle = new Bundle();
                ((BaseBundle)bundle).putInt("file.manager.music.player.QUEUE_POSITION", this.a.k.u());
                ((BaseBundle)bundle).putInt("file.manager.music.player.QUEUE_SIZE", this.a.k.v());
                this.a.l.j(bundle);
            }
        }), (f)new e((Context)this, this.j));
        try {
            this.l = new MediaSessionCompat((Context)this, "MusicService");
        }
        catch (final SecurityException ex) {
            ((Service)this).stopSelf();
            return;
        }
        catch (final IllegalArgumentException ex2) {
            this.l = new MediaSessionCompat((Context)this, "MusicService", new ComponentName(((Context)this).getPackageName(), MediaButtonReceiver.class.getCanonicalName()), (PendingIntent)null);
        }
        this.k.C(F((Context)this), E((Context)this));
        this.A(this.l.c());
        this.l.h(this.k.w());
        this.l.k(3);
        this.k.N((String)null, 0, (String)null);
        try {
            this.m = new d(this);
        }
        catch (final RemoteException ex3) {
            throw new IllegalStateException("Could not create a MediaNotificationManager", (Throwable)ex3);
        }
    }
    
    public void onDestroy() {
        super.onDestroy();
        ax.S4.b.a(MusicService.r, new Object[] { "onDestroy" });
        MusicService.s = false;
        MusicService.t = 0;
        MusicService.v = false;
        MusicService.u = false;
        this.k.A((String)null);
        final d m = this.m;
        if (m != null) {
            m.u();
        }
        this.n.removeCallbacksAndMessages((Object)null);
        final MediaSessionCompat l = this.l;
        if (l != null) {
            l.f();
        }
    }
    
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        if (intent == null) {
            final d m = this.m;
            if (m != null) {
                m.r(true);
            }
            this.n.removeCallbacksAndMessages((Object)null);
            this.n.sendEmptyMessageDelayed(0, 10000L);
            return 2;
        }
        if (intent.hasExtra("START_FOREGROUND")) {
            try {
                final d i = this.m;
                if (i != null) {
                    i.l();
                }
            }
            catch (final IllegalStateException ex) {
                final ax.Ha.b b = ax.Ha.c.i((Context)this).f().b("MUSIC SERVICE START BACKGROUND");
                final StringBuilder sb = new StringBuilder();
                sb.append("intent:");
                sb.append(intent.getAction());
                b.g((Object)sb.toString()).h();
                this.n.removeCallbacksAndMessages((Object)null);
                this.n.sendEmptyMessageDelayed(0, 10000L);
                return 2;
            }
        }
        final String action = intent.getAction();
        final String stringExtra = intent.getStringExtra("CMD_NAME");
        if ("com.example.android.uamp.ACTION_CMD".equals((Object)action)) {
            if ("CMD_PAUSE".equals((Object)stringExtra)) {
                this.k.y();
                return 2;
            }
        }
        else {
            MediaButtonReceiver.c(this.l, intent);
        }
        if (!this.p && (this.n.hasMessages(1) || this.n.hasMessages(0))) {
            if (this.q) {
                final d j = this.m;
                if (j != null && j.o()) {
                    this.m.r(false);
                }
            }
        }
        else {
            this.n.removeCallbacksAndMessages((Object)null);
            this.n.sendEmptyMessageDelayed(0, 30000L);
        }
        return 2;
    }
    
    public void p(final int n) {
        this.l.q(n);
        K((Context)this, n);
    }
    
    private static class b extends Handler
    {
        private final WeakReference<MusicService> a;
        
        private b(final MusicService musicService) {
            this.a = (WeakReference<MusicService>)new WeakReference((Object)musicService);
        }
        
        public void handleMessage(final Message message) {
            final MusicService musicService = (MusicService)((Reference)this.a).get();
            if (musicService != null && musicService.k.x() != null) {
                if (musicService.k.x().n()) {
                    ax.S4.b.a(MusicService.r, new Object[] { "Ignoring delayed stop since the media player is in use." });
                    return;
                }
                ax.S4.b.a(MusicService.r, new Object[] { "Stopping service with delay handler." });
                ((Service)musicService).stopSelf();
            }
        }
    }
}
