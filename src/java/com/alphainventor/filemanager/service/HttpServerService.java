package com.alphainventor.filemanager.service;

import ax.Q2.d;
import ax.c3.x;
import java.util.Iterator;
import android.content.IntentFilter;
import ax.L0.a;
import android.os.IBinder;
import android.os.SystemClock;
import ax.u3.B;
import android.os.Parcelable;
import java.io.Serializable;
import ax.Q2.f;
import ax.s3.u;
import android.app.Notification;
import ax.o3.c;
import android.net.Uri$Builder;
import android.net.Uri;
import com.alphainventor.filemanager.file.n;
import android.content.Intent;
import android.content.Context;
import com.example.android.uamp.MusicService;
import android.os.Looper;
import ax.Q2.g;
import android.content.BroadcastReceiver;
import ax.u3.D;
import com.alphainventor.filemanager.file.o;
import java.util.Set;
import android.os.Handler;
import java.util.logging.Logger;
import android.app.Service;

public class HttpServerService extends Service
{
    private static final Logger n;
    private static boolean o;
    private static HttpServerService p;
    private static boolean q;
    private e a;
    private boolean b;
    private boolean c;
    private Handler d;
    private Set<o> e;
    private int f;
    private boolean g;
    private long h;
    private D i;
    private b.a j;
    Runnable k;
    boolean l;
    BroadcastReceiver m;
    
    static {
        n = g.a((Class)HttpServerService.class);
        HttpServerService.o = false;
        HttpServerService.p = null;
        HttpServerService.q = false;
    }
    
    public HttpServerService() {
        this.d = new Handler(Looper.getMainLooper());
        this.e = (Set<o>)new ax.B.b();
        this.j = new b.a() {
            final HttpServerService a;
            
            @Override
            public void a(final int n) {
                if (n == 0) {
                    this.a.a = HttpServerService.e.c0;
                    this.a.r();
                }
                else {
                    this.a.a = HttpServerService.e.d0;
                    if (n > this.a.f) {
                        this.a.m();
                    }
                }
                this.a.f = n;
            }
        };
        this.k = (Runnable)new Runnable() {
            final HttpServerService q;
            
            public void run() {
                final Logger e = HttpServerService.n;
                final StringBuilder sb = new StringBuilder();
                sb.append("Timeout http multimedia server! : ");
                sb.append((Object)this.q.a);
                e.fine(sb.toString());
                final HttpServerService q = this.q;
                if (q.l && q.a != HttpServerService.e.d0) {
                    if (this.q.b && MusicService.I()) {
                        this.q.r();
                        return;
                    }
                    if (HttpServerService.q) {
                        this.q.u();
                        return;
                    }
                    this.q.w();
                    this.q.m();
                }
                else {
                    final HttpServerService q2 = this.q;
                    if (!q2.l || !q2.c || this.q.b || MusicService.G()) {
                        this.q.k();
                        return;
                    }
                    if (HttpServerService.q) {
                        this.q.u();
                        return;
                    }
                    this.q.w();
                    this.q.m();
                }
            }
        };
        this.m = new BroadcastReceiver() {
            final HttpServerService a;
            
            public void onReceive(final Context context, final Intent intent) {
                final int intExtra = intent.getIntExtra("state", 0);
                final Logger e = HttpServerService.n;
                final StringBuilder sb = new StringBuilder();
                sb.append("music playback stop received : ");
                sb.append(this.a.b);
                sb.append(":");
                sb.append(intExtra);
                e.fine(sb.toString());
                if (this.a.b) {
                    if (intExtra == 1) {
                        this.a.b = false;
                    }
                    this.a.s();
                }
            }
        };
    }
    
    public static Uri l(final int n, final n n2) {
        final Uri$Builder scheme = new Uri$Builder().scheme("http");
        final StringBuilder sb = new StringBuilder();
        sb.append("127.0.0.1:");
        sb.append(n);
        return scheme.encodedAuthority(sb.toString()).path(c.C(n2)).build();
    }
    
    private Notification n(final Intent intent, final boolean b) {
        return u.j((Context)this).e((Service)this, intent, b);
    }
    
    public static e p() {
        if (HttpServerService.o) {
            return HttpServerService.p.o();
        }
        return e.q;
    }
    
    public static void q(final Context context, final f f, final int n, final boolean b, final boolean b2, final boolean b3, final Intent intent) {
        final Intent intent2 = new Intent(context, (Class)HttpServerService.class);
        intent2.putExtra("location", (Serializable)f);
        intent2.putExtra("location_key", n);
        intent2.putExtra("play_intent", (Parcelable)intent);
        intent2.putExtra("music_playback", b);
        intent2.putExtra("is_multimedia", b2);
        boolean b4 = b3;
        if (!b3) {
            b4 = b3;
            if (B.V(context)) {
                b4 = true;
            }
        }
        intent2.putExtra("need_foreground", b4);
        if (b4) {
            try {
                B.f0(context, intent2, true, true);
                HttpServerService.q = true;
                return;
            }
            catch (final IllegalStateException ex) {
                ax.Ha.c.i(context).f().b("START HTTP SERVICE FOREGROUND").l((Throwable)ex).h();
                return;
            }
        }
        context.startService(intent2);
    }
    
    public static void v(final Context context) {
        final int ordinal = p().ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    final HttpServerService p = HttpServerService.p;
                    if (p != null) {
                        p.t();
                    }
                }
            }
            else {
                final HttpServerService p2 = HttpServerService.p;
                if (p2 != null && p2.b && MusicService.I()) {
                    HttpServerService.p.r();
                    return;
                }
                final HttpServerService p3 = HttpServerService.p;
                if (p3 != null) {
                    p3.r();
                }
            }
        }
        else {
            final HttpServerService p4 = HttpServerService.p;
            if (p4 != null) {
                p4.t();
            }
        }
    }
    
    private void w() {
        if (this.h <= 0L) {
            this.stopSelf();
            return;
        }
        if (SystemClock.uptimeMillis() - this.h < 100L) {
            this.d.postDelayed((Runnable)new Runnable(this) {
                final HttpServerService q;
                
                public void run() {
                    this.q.stopSelf();
                }
            }, 100L);
            return;
        }
        this.stopSelf();
    }
    
    void k() {
        if (!this.b && ax.Q2.b.h().m()) {
            if (this.g) {
                this.stopForeground(true);
                this.g = false;
            }
        }
        else if (!this.b) {
            ax.Q2.b.h().m();
        }
    }
    
    void m() {
        monitorenter(this);
        Label_0043: {
            try {
                if (this.l) {
                    HttpServerService.n.fine("Cancel timeout to stop multimedia server");
                    this.d.removeCallbacks(this.k);
                    this.l = false;
                }
                break Label_0043;
            }
            finally {
                monitorexit(this);
                monitorexit(this);
            }
        }
    }
    
    e o() {
        return this.a;
    }
    
    public IBinder onBind(final Intent intent) {
        return null;
    }
    
    public void onCreate() {
        super.onCreate();
        HttpServerService.n.fine("Http server created");
        this.a = HttpServerService.e.q;
        this.l = false;
        ax.L0.a.b((Context)this).c(this.m, new IntentFilter("local.intent.action.LOCAL_PLAYBACK_STOP"));
        this.i = new D((Context)this, 3, "HTTP_SERVER");
    }
    
    public void onDestroy() {
        super.onDestroy();
        this.m();
        com.alphainventor.filemanager.service.b.f((Context)this).n(this.j);
        final Iterator iterator = this.e.iterator();
        while (iterator.hasNext()) {
            com.alphainventor.filemanager.service.b.f((Context)this).o((o)iterator.next());
        }
        this.e.clear();
        if (this.g) {
            this.stopForeground(true);
            this.g = false;
        }
        HttpServerService.o = false;
        HttpServerService.p = null;
        ax.L0.a.b((Context)this).f(this.m);
        this.i.c();
        HttpServerService.n.fine("Http server stopped");
    }
    
    public int onStartCommand(final Intent intent, int intExtra, final int n) {
        Intent intent2;
        boolean booleanExtra;
        boolean booleanExtra2;
        if (intent == null) {
            intent2 = null;
            booleanExtra = true;
            booleanExtra2 = true;
        }
        else {
            intent2 = (Intent)intent.getParcelableExtra("play_intent");
            booleanExtra = intent.getBooleanExtra("is_multimedia", true);
            booleanExtra2 = intent.getBooleanExtra("need_foreground", true);
        }
        if (booleanExtra2) {
            try {
                HttpServerService.q = false;
                this.startForeground(232, this.n(intent2, booleanExtra));
                this.h = SystemClock.uptimeMillis();
                this.g = true;
            }
            catch (final IllegalStateException ex) {
                ax.Ha.c.i((Context)this).f().b("Foreground not allowed : http server service").h();
            }
        }
        HttpServerService.p = this;
        HttpServerService.o = true;
        if (intent == null) {
            if (!com.alphainventor.filemanager.service.b.f((Context)this).i()) {
                this.w();
            }
            return 2;
        }
        final f f = (f)intent.getSerializableExtra("location");
        intExtra = intent.getIntExtra("location_key", 0);
        if (f == null) {
            final ax.Ha.b j = ax.Ha.c.i((Context)this).f().b("HTTP SERVER NO LOCATION").j();
            final StringBuilder sb = new StringBuilder();
            sb.append("op:");
            sb.append(com.alphainventor.filemanager.service.b.f((Context)this).i());
            j.g((Object)sb.toString()).h();
            if (!com.alphainventor.filemanager.service.b.f((Context)this).i()) {
                this.w();
            }
            return 2;
        }
        final o d = x.d(f, intExtra);
        if (intent.getBooleanExtra("music_playback", false)) {
            this.b = true;
            if (this.e.size() == 0) {
                this.c = true;
            }
        }
        else {
            this.c = false;
        }
        if (!this.e.contains((Object)d)) {
            this.e.add((Object)d);
            com.alphainventor.filemanager.service.b.f((Context)this).e(d);
        }
        com.alphainventor.filemanager.service.b.f((Context)this).d(this.j);
        this.m();
        this.a = HttpServerService.e.q;
        this.r();
        this.i.a();
        return 2;
    }
    
    public void onTimeout(final int n, final int n2) {
        super.onTimeout(n, n2);
        ax.Q2.d.c("http server service timeout", (Throwable)new Exception("HttpServerServiceTimeout"));
        ax.o3.d.a(this, 1);
    }
    
    void r() {
        monitorenter(this);
    Block_6_Outer:
        while (true) {
            Label_0081: {
                try {
                    if (this.a == HttpServerService.e.q) {
                        final Logger n = HttpServerService.n;
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Start timeout to stop multimedia server : onstart : (music:");
                        sb.append(this.b);
                        sb.append(")");
                        n.fine(sb.toString());
                        this.d.postDelayed(this.k, 180000L);
                        break Label_0200;
                    }
                    break Label_0081;
                }
                finally {
                    monitorexit(this);
                    while (true) {
                        this.d.postDelayed(this.k, 600000L);
                        break Label_0200;
                        Label_0140: {
                            iftrue(Label_0176:)(!ax.Q2.b.h().m());
                        }
                        Block_5: {
                            Block_7: {
                                break Block_7;
                                iftrue(Label_0140:)(!this.b);
                                break Block_5;
                            }
                            HttpServerService.n.fine("Start timeout to stop multimedia server : foreground");
                            this.d.postDelayed(this.k, 3000L);
                            this.l = true;
                            monitorexit(this);
                            return;
                        }
                        HttpServerService.n.fine("Start timeout to stop multimedia server : music playback pause");
                        iftrue(Label_0122:)(!this.g);
                        continue;
                    }
                    Label_0176: {
                        HttpServerService.n.fine("Start timeout to stop multimedia server : background");
                    }
                    this.d.postDelayed(this.k, 600000L);
                    continue Block_6_Outer;
                    Label_0122:
                    this.d.postDelayed(this.k, 1800000L);
                    continue Block_6_Outer;
                }
            }
            break;
        }
    }
    
    void s() {
        synchronized (this) {
            HttpServerService.n.fine("Start timeout to stop multimedia server : music playback stop");
            this.d.postDelayed(this.k, 3000L);
            this.l = true;
        }
    }
    
    void t() {
        synchronized (this) {
            HttpServerService.n.fine("Start timeout to stop multimedia server : onResume UI");
            this.d.postDelayed(this.k, 3000L);
            this.l = true;
        }
    }
    
    void u() {
        synchronized (this) {
            HttpServerService.n.fine("Start timeout to stop multimedia server : wating foreground");
            this.d.postDelayed(this.k, 30000L);
            this.l = true;
        }
    }
    
    public enum e
    {
        c0, 
        d0;
        
        private static final e[] e0;
        
        q;
        
        static {
            e0 = d();
        }
        
        private static /* synthetic */ e[] d() {
            return new e[] { e.q, e.c0, e.d0 };
        }
    }
}
