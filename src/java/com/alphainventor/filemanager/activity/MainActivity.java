package com.alphainventor.filemanager.activity;

import androidx.activity.ComponentActivity;
import android.os.BaseBundle;
import ax.Q2.m;
import ax.X2.J;
import java.util.concurrent.TimeUnit;
import ax.u3.q$e;
import ax.S2.b$a;
import ax.S2.b$c;
import com.alphainventor.filemanager.service.HttpServerService;
import android.view.MenuItem;
import android.view.Menu;
import com.google.android.material.tabs.TabLayout$g;
import com.google.android.material.tabs.TabLayout$d;
import android.view.ViewTreeObserver$OnPreDrawListener;
import ax.u3.z;
import android.content.res.Configuration;
import com.alphainventor.filemanager.file.y;
import com.alphainventor.filemanager.file.o;
import com.alphainventor.filemanager.provider.MyFileProvider;
import android.content.ComponentName;
import ax.c3.x;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import android.view.KeyEvent;
import android.view.View$OnKeyListener;
import ax.a3.n$c;
import androidx.fragment.app.FragmentManager;
import ax.a3.i;
import androidx.fragment.app.t;
import androidx.fragment.app.Fragment;
import ax.a3.w;
import android.content.IntentFilter;
import ax.u3.B;
import android.os.Parcelable;
import android.view.View$OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;
import java.util.Iterator;
import java.util.List;
import android.net.Uri;
import ax.Z2.s;
import android.content.UriPermission;
import ax.c3.d0;
import com.alphainventor.filemanager.musicplayer.FullScreenPlayerActivity;
import ax.X2.Q;
import com.alphainventor.filemanager.service.CommandService;
import ax.c3.K;
import android.content.Intent;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.alphainventor.filemanager.file.OneDriveFileHelper$j;
import com.alphainventor.filemanager.file.Y$e;
import com.alphainventor.filemanager.file.d$f;
import com.alphainventor.filemanager.file.q;
import com.alphainventor.filemanager.file.L;
import com.alphainventor.filemanager.file.W;
import android.content.ActivityNotFoundException;
import com.alphainventor.filemanager.file.OneDriveFileHelper;
import com.alphainventor.filemanager.file.Y;
import com.alphainventor.filemanager.file.I;
import com.alphainventor.filemanager.file.D;
import com.alphainventor.filemanager.file.H;
import com.alphainventor.filemanager.file.k$a;
import ax.a3.u$c;
import ax.a3.u;
import ax.t3.j;
import android.text.TextUtils;
import android.content.Context;
import java.io.Serializable;
import android.os.Bundle;
import ax.a3.v;
import ax.a3.h$d;
import java.util.Map;
import com.alphainventor.filemanager.file.T;
import android.app.Activity;
import ax.m3.a;
import com.alphainventor.filemanager.service.FtpServerService;
import ax.d3.l0;
import ax.d3.E;
import ax.Q2.g;
import androidx.drawerlayout.widget.DrawerLayout;
import ax.i.r;
import ax.g3.c;
import android.os.Handler;
import ax.d3.e0;
import java.util.concurrent.CountDownLatch;
import android.content.BroadcastReceiver;
import ax.S2.b$b;
import android.widget.Toast;
import java.util.ArrayList;
import com.alphainventor.filemanager.bookmark.Bookmark;
import ax.d3.n;
import ax.x3.h;
import android.widget.Button;
import ax.V2.d;
import ax.Z2.l;
import ax.V2.f;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import android.view.ViewGroup;
import ax.x3.A;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ax.S2.b$d;
import android.widget.FrameLayout;
import ax.g3.k;
import com.google.android.material.tabs.TabLayout;
import ax.a3.h$c;
import android.view.View;
import java.util.logging.Logger;
import ax.a3.U$c;
import ax.d3.l0$o;
import ax.g3.e;

public class MainActivity extends b implements e, l0$o, U$c
{
    private static final Logger E0;
    private View A;
    h$c A0;
    private TabLayout B;
    k B0;
    private FrameLayout C;
    ax.g3.b C0;
    private View D;
    ax.S2.b$d D0;
    private View E;
    private CoordinatorLayout F;
    private CoordinatorLayout G;
    private View H;
    private A I;
    private ViewGroup J;
    private Toolbar K;
    private ListView L;
    private f M;
    private l N;
    private d O;
    private View P;
    private Button Q;
    private ViewGroup R;
    private ViewGroup S;
    private h T;
    private n U;
    private Bookmark V;
    private ax.Z2.f W;
    private ArrayList<MainActivity.MainActivity$J> X;
    private int Y;
    private boolean Z;
    private Runnable a0;
    private Bookmark b0;
    private Runnable c0;
    private Bookmark d0;
    private long e0;
    private Toast f0;
    private ax.S2.b$b g0;
    private long h0;
    private long i0;
    private View j0;
    private boolean k0;
    private Object l0;
    private K m0;
    private BroadcastReceiver n0;
    private BroadcastReceiver o0;
    private Boolean p0;
    private CountDownLatch q0;
    private e0 r0;
    private boolean s0;
    private Handler t0;
    private boolean u0;
    private c v0;
    Runnable w0;
    r x0;
    private final Object y;
    private Runnable y0;
    private DrawerLayout z;
    k z0;
    
    static {
        E0 = g.a((Class)MainActivity.class);
    }
    
    public MainActivity() {
        this.y = new Object();
        this.X = (ArrayList<MainActivity.MainActivity$J>)new ArrayList();
        this.Z = false;
        this.g0 = ax.S2.b$b.q;
        this.q0 = new CountDownLatch(1);
        this.t0 = new Handler();
        this.v0 = new c(100L) {
            final MainActivity c;
            
            public void a(final View view) {
                final n x1 = this.c.x1();
                if (x1 instanceof E) {
                    ((E)x1).na("toolbar_back");
                    return;
                }
                if (x1 instanceof l0 && FtpServerService.x()) {
                    ((l0)x1).c6();
                    return;
                }
                this.c.m2(true, "toolbar_back");
            }
        };
        this.w0 = (Runnable)new Runnable() {
            final MainActivity q;
            
            public void run() {
                if (this.q.H != null) {
                    this.q.Q1();
                }
            }
        };
        this.x0 = new r(true) {
            final MainActivity d;
            
            public void d() {
                if (this.d.r0 == null || !((Fragment)this.d.r0).X0() || !this.d.r0.e3()) {
                    if (this.d.z.A(this.d.A)) {
                        this.d.z.d(this.d.A);
                        return;
                    }
                    if (this.d.Z1()) {
                        this.d.R1();
                        return;
                    }
                    if (this.d.x1() != null && !this.d.x1().V2()) {
                        if (this.d.x1().z3() == ax.Q2.f.l0) {
                            if (ax.t3.g.c() || !ax.m3.a.c((Activity)this.d)) {
                                this.d.m1();
                            }
                        }
                        else {
                            this.d.m2(true, "hw_back");
                        }
                    }
                }
            }
        };
        this.y0 = (Runnable)new Runnable() {
            final MainActivity q;
            
            public void run() {
                this.q.u0 = false;
                this.q.p();
            }
        };
        this.z0 = (k)new k() {
            final MainActivity a;
            
            public void a(final ax.Q2.f f, final String s, final int n, final String s2, final String s3) {
            }
            
            public void b(final ax.Q2.f f) {
            }
            
            public void c(final ax.Q2.f f, final int n) {
                this.a.j2();
                this.a.c2(Bookmark.o(((T)com.alphainventor.filemanager.file.T.d(((Context)this.a).getApplicationContext(), f)).f(n)), "remote_add", null, null, null);
            }
            
            public void d(final ax.Q2.f f, final int n, final Map<String, Object> map) {
            }
        };
        this.A0 = (h$c)new h$c() {
            final MainActivity a;
            
            public void a(final h$d h$d) {
                if (this.a.n()) {
                    return;
                }
                final v v = new v();
                final Bundle bundle = new Bundle();
                if (h$d != null) {
                    final String b = h$d.b;
                    if (b == null) {
                        ((BaseBundle)bundle).putString("host", h$d.a);
                    }
                    else {
                        ((BaseBundle)bundle).putString("host", b);
                        ((BaseBundle)bundle).putString("display_name", h$d.a);
                    }
                }
                ((BaseBundle)bundle).putInt("action", 1);
                ((BaseBundle)bundle).putInt("port", 0);
                bundle.putSerializable("location", (Serializable)ax.Q2.f.J0);
                ((Fragment)v).v2(bundle);
                ((androidx.fragment.app.e)v).c3(((androidx.fragment.app.f)this.a).getSupportFragmentManager(), "smb");
            }
        };
        this.B0 = (k)new k() {
            final MainActivity a;
            
            public void a(final ax.Q2.f f, String s, final int n, final String s2, final String s3) {
                final MainActivity a = this.a;
                String s4;
                s = (s4 = ((Context)a).getString(2131952325, new Object[] { f.M((Context)a) }));
                if (!TextUtils.isEmpty((CharSequence)s3)) {
                    if (ax.t3.j.o((Context)this.a.s())) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(s);
                        sb.append(" : ");
                        sb.append(s3);
                        s4 = sb.toString();
                    }
                    else {
                        s4 = s;
                        if (s3.contains((CharSequence)"ERR_SSL_VERSION_OR_CIPHER_MISMATCH")) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(s);
                            sb2.append(" (");
                            sb2.append(s3);
                            sb2.append(")");
                            s4 = sb2.toString();
                        }
                    }
                }
                Toast.makeText((Context)this.a, (CharSequence)s4, 1).show();
            }
            
            public void b(final ax.Q2.f f) {
            }
            
            public void c(final ax.Q2.f f, final int n) {
                this.a.j2();
                this.a.c2(Bookmark.o(com.alphainventor.filemanager.file.T.b(((Context)this.a).getApplicationContext(), f).f(n)), "cloud_add", null, null, null);
            }
            
            public void d(final ax.Q2.f f, final int n, final Map<String, Object> map) {
                if (f == ax.Q2.f.N0) {
                    final u u = new u();
                    ((androidx.fragment.app.e)u).c3(((androidx.fragment.app.f)this.a).getSupportFragmentManager(), "dropbox_confirm");
                    u.j3((u$c)new u$c(this, n) {
                        final int a;
                        final MainActivity$h b;
                        
                        public void a(final boolean b) {
                            if (this.b.a.s() == null) {
                                return;
                            }
                            final k$a s0 = com.alphainventor.filemanager.file.k.s0(((Context)this.b.a).getApplicationContext());
                            final MainActivity a = this.b.a;
                            s0.l((Activity)a, a.B0, this.a, b);
                        }
                    });
                    return;
                }
                ax.u3.b.f();
            }
        };
        this.C0 = (ax.g3.b)new ax.g3.b() {
            final MainActivity a;
            
            public void a(final ax.Q2.f f, final Object o) {
                switch (MainActivity$z.a[((Enum)f).ordinal()]) {
                    case 13: {
                        this.a.j2();
                        final d$f r0 = com.alphainventor.filemanager.file.d.r0(((Context)this.a).getApplicationContext());
                        final MainActivity a = this.a;
                        r0.k((a)a, a.B0);
                        return;
                    }
                    case 12: {
                        this.a.j2();
                        com.alphainventor.filemanager.file.H.U0(((Context)this.a).getApplicationContext()).l(this.a);
                        return;
                    }
                    case 11: {
                        this.a.j2();
                        com.alphainventor.filemanager.file.D.a1(((Context)this.a).getApplicationContext()).n(this.a);
                        return;
                    }
                    case 10: {
                        this.a.j2();
                        final com.alphainventor.filemanager.file.I.d r2 = com.alphainventor.filemanager.file.I.r0(((Context)this.a).getApplicationContext());
                        final MainActivity a2 = this.a;
                        r2.q(a2, a2.B0);
                        return;
                    }
                    case 9: {
                        this.a.j2();
                        final Y$e t0 = com.alphainventor.filemanager.file.Y.t0(((Context)this.a).getApplicationContext());
                        final MainActivity a3 = this.a;
                        t0.k((a)a3, a3.B0);
                        return;
                    }
                    case 8: {
                        this.a.j2();
                        final OneDriveFileHelper$j g0 = OneDriveFileHelper.G0(((Context)this.a).getApplicationContext());
                        final MainActivity a4 = this.a;
                        g0.k((Activity)a4, a4.B0);
                        return;
                    }
                    case 7: {
                        final int g2 = ax.J5.h.o().g((Context)this.a);
                        if (g2 == 0) {
                            try {
                                final MainActivity a5 = this.a;
                                ax.c3.u.q0((Activity)a5, com.alphainventor.filemanager.file.r.A0(((Context)a5).getApplicationContext()).n((String)null), 1);
                                return;
                            }
                            catch (final ActivityNotFoundException ex) {
                                Toast.makeText((Context)this.a, 2131951927, 1).show();
                            }
                            break;
                        }
                        ax.J5.h.o().l((Activity)this.a, g2, 10002).show();
                        return;
                    }
                    case 6: {
                        this.a.j2();
                        final k$a s0 = com.alphainventor.filemanager.file.k.s0(((Context)this.a).getApplicationContext());
                        final MainActivity a6 = this.a;
                        s0.k((Activity)a6, a6.B0);
                        return;
                    }
                    case 5: {
                        final v v = new v();
                        final Bundle bundle = new Bundle();
                        ((BaseBundle)bundle).putInt("action", 1);
                        ((BaseBundle)bundle).putInt("port", com.alphainventor.filemanager.file.W.w0());
                        bundle.putSerializable("location", (Serializable)ax.Q2.f.K0);
                        ((Fragment)v).v2(bundle);
                        this.a.A((androidx.fragment.app.e)v, "webdav", true);
                        return;
                    }
                    case 4: {
                        final v v2 = new v();
                        final Bundle bundle2 = new Bundle();
                        ((BaseBundle)bundle2).putInt("action", 1);
                        ((BaseBundle)bundle2).putInt("port", com.alphainventor.filemanager.file.L.y0());
                        bundle2.putSerializable("location", (Serializable)ax.Q2.f.I0);
                        ((Fragment)v2).v2(bundle2);
                        this.a.A((androidx.fragment.app.e)v2, "sftp", true);
                        return;
                    }
                    case 3: {
                        final v v3 = new v();
                        final Bundle bundle3 = new Bundle();
                        ((BaseBundle)bundle3).putInt("action", 1);
                        ((BaseBundle)bundle3).putInt("port", com.alphainventor.filemanager.file.q.w0());
                        bundle3.putSerializable("location", (Serializable)ax.Q2.f.H0);
                        ((Fragment)v3).v2(bundle3);
                        this.a.A((androidx.fragment.app.e)v3, "ftp", true);
                        return;
                    }
                    case 2: {
                        final v v4 = new v();
                        final Bundle bundle4 = new Bundle();
                        ((BaseBundle)bundle4).putInt("action", 1);
                        ((BaseBundle)bundle4).putInt("port", 0);
                        bundle4.putSerializable("location", (Serializable)ax.Q2.f.J0);
                        ((Fragment)v4).v2(bundle4);
                        this.a.A((androidx.fragment.app.e)v4, "smb", true);
                        return;
                    }
                    case 1: {
                        this.a.A((androidx.fragment.app.e)new ax.a3.h(), "chooseSmb", true);
                    }
                }
            }
        };
        this.D0 = (ax.S2.b$d)new ax.S2.b$d() {
            final MainActivity a;
        };
    }
    
    private void D2(final String s) {
        ((ViewGroup)this.G).removeAllViews();
        final View viewById = ((Activity)this).getLayoutInflater().inflate(2131558711, (ViewGroup)this.G, true).findViewById(2131362568);
        this.H = viewById;
        ((TextView)viewById.findViewById(2131362553)).setText((CharSequence)((Context)this).getString(2131952028, new Object[] { s }));
        this.H.startAnimation(AnimationUtils.loadAnimation((Context)this, 2130771996));
        this.B0();
        this.t0.postDelayed(this.w0, 30000L);
    }
    
    private void E2(final Bookmark bookmark, final ax.Z2.f f) {
        ax.Q2.f f2;
        int b;
        if (f != null && f.c()) {
            f2 = f.a();
            b = f.b();
        }
        else {
            b = 0;
            if (bookmark != null && bookmark.s().J() != null) {
                f2 = bookmark.s().J();
            }
            else {
                f2 = null;
            }
        }
        if (f2 != null) {
            final int c = this.N.c(f2, b);
            if (c >= 0) {
                this.c2(this.N.d(c), "show_parent", this.N.f(c), null, null);
            }
        }
    }
    
    private boolean F1(final Intent intent) {
        if (intent != null) {
            if (intent.getAction() != null) {
                if ("com.alphainventor.filemanager.OPEN_ANALYSIS".equals((Object)intent.getAction())) {
                    ax.c3.K d;
                    if (intent.getData() != null) {
                        d = ax.Z2.k.a(intent.getData()).d();
                    }
                    else {
                        d = null;
                    }
                    if (d != null) {
                        ax.Q2.a.i().m("notification", "storage_full_noti_clicked").c("loc", d.d().I()).e();
                        this.K2(d, true, "notification");
                    }
                    else {
                        this.K2(null, false, "notification");
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean G1(final Intent intent) {
        if (intent != null && !intent.getBooleanExtra("com.filemanager.extra.HAS_PENDING_DIALOG", false)) {
            return false;
        }
        final CommandService q = CommandService.q();
        if (q != null) {
            q.G((ax.R2.a)this);
        }
        ax.s3.u.j((Context)this).a(102);
        return true;
    }
    
    private boolean H1(final Intent intent) {
        if (intent != null) {
            if (intent.getAction() != null) {
                if ("com.alphainventor.filemanager.OPEN_FILE".equals((Object)intent.getAction()) && intent.getData() != null) {
                    final Bookmark c = Bookmark.c((Context)this, intent.getData());
                    if (c == null) {
                        return false;
                    }
                    this.c2(c, null, null, null, null);
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean I1(final Intent intent) {
        boolean b2;
        final boolean b = b2 = false;
        if (intent != null) {
            if (intent.getAction() == null) {
                b2 = b;
            }
            else {
                b2 = b;
                if ("com.alphainventor.filemanager.SAVE_FILE".equals((Object)intent.getAction())) {
                    this.q0("save_file");
                    final n d0 = this.d0();
                    b2 = true;
                    if (d0 != null) {
                        d0.e4(true);
                        b2 = b2;
                    }
                }
            }
        }
        return b2;
    }
    
    private void J1(final Intent intent) {
        this.g0().m(false);
        if (!this.M1(intent)) {
            if (!this.H1(intent)) {
                if (!this.F1(intent)) {
                    if (!this.I1(intent)) {
                        if (!this.K1(intent)) {
                            if (!this.P1(intent)) {
                                if (!this.G1(intent)) {
                                    if (!this.L1(intent)) {
                                        if (!this.O1(intent)) {
                                            this.N1(intent);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private boolean K1(final Intent intent) {
        boolean booleanExtra = false;
        if (intent == null || intent.getAction() == null) {
            return false;
        }
        final String action = intent.getAction();
        if (!"android.intent.action.GET_CONTENT".equals((Object)action) && !"android.intent.action.OPEN_DOCUMENT".equals((Object)action) && !"android.intent.action.PICK".equals((Object)action) && !"android.intent.action.CREATE_SHORTCUT".equals((Object)action)) {
            return false;
        }
        if (ax.W2.c.q().v()) {
            ax.W2.c.q().l();
        }
        if (ax.X2.Q.l1()) {
            booleanExtra = intent.getBooleanExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        }
        this.g0().i(intent.getStringExtra("com.filemanager.plugin.extra.CALLING_PACKAGE"));
        this.g0().l(intent.getAction());
        this.g0().m(true);
        this.g0().k(booleanExtra);
        this.g0().j(intent.getType());
        return true;
    }
    
    private boolean L1(final Intent intent) {
        if (intent != null) {
            if (intent.getAction() != null) {
                if ("com.filemanager.SET_PERMISSION".equals((Object)intent.getAction())) {
                    return this.s0 = true;
                }
            }
        }
        return false;
    }
    
    private void L2(final String s) {
        final boolean equals = "Favorite".equals((Object)s);
        int visibility = 0;
        int visibility2 = 4;
        int visibility3;
        if (equals) {
            visibility3 = 4;
        }
        else if ("History".equals((Object)s)) {
            visibility3 = 4;
            visibility = 4;
            visibility2 = 0;
        }
        else {
            if ("LastVisited".equals((Object)s)) {
                visibility3 = 0;
            }
            else {
                visibility3 = 4;
            }
            visibility = 4;
        }
        final View d = this.D;
        if (d != null) {
            d.setVisibility(visibility);
        }
        final View e = this.E;
        if (e != null) {
            e.setVisibility(visibility2);
        }
        final View p = this.P;
        if (p != null) {
            p.setVisibility(visibility3);
        }
    }
    
    private boolean M1(final Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return false;
        }
        final String action = intent.getAction();
        action.getClass();
        if (!action.equals((Object)"com.example.android.uamp.open_ui")) {
            return false;
        }
        final String stringExtra = intent.getStringExtra("PLAY_FOLDER_URI");
        final Intent putExtra = new Intent((Context)this, (Class)FullScreenPlayerActivity.class).setFlags(603979776).putExtra("com.example.android.uamp.CURRENT_MEDIA_DESCRIPTION", intent.getParcelableExtra("com.example.android.uamp.CURRENT_MEDIA_DESCRIPTION"));
        if (stringExtra != null) {
            if (intent.getBooleanExtra("com.example.android.uamp.EXTRA_START_FULLSCREEN", false)) {
                this.e2(stringExtra, (Runnable)new Runnable(this, putExtra) {
                    final MainActivity c0;
                    final Intent q;
                    
                    public void run() {
                        ((Context)this.c0).startActivity(this.q);
                    }
                });
            }
            else {
                this.e2(stringExtra, null);
            }
        }
        else {
            ((Context)this).startActivity(putExtra);
        }
        return true;
    }
    
    private boolean N1(final Intent intent) {
        if (intent != null) {
            if (intent.getAction() != null) {
                if ("android.intent.action.VIEW".equals((Object)intent.getAction()) && intent.getData() != null && "content".equals((Object)intent.getData().getScheme())) {
                    Toast.makeText((Context)this, 2131951943, 1).show();
                }
            }
        }
        return false;
    }
    
    private n N2(final ax.Q2.f f, final int n, final Bundle bundle, final ax.Z2.f f2) {
        final String p4 = this.p1(f, n);
        n n2;
        if ((n2 = (n)((androidx.fragment.app.f)this).getSupportFragmentManager().k0(p4)) == null) {
            final n b2 = this.b2(f);
            Bundle bundle2;
            if ((bundle2 = bundle) == null) {
                bundle2 = new Bundle();
            }
            bundle2.putSerializable("location", (Serializable)f);
            ((BaseBundle)bundle2).putInt("location_key", n);
            ((Fragment)b2).v2(bundle2);
            n2 = b2;
        }
        if (n2 instanceof E) {
            final E e = (E)n2;
            if (f2 != null && f2.c()) {
                e.E9(f2.a());
            }
            else {
                e.E9((ax.Q2.f)null);
            }
        }
        this.r2(n2, p4);
        return n2;
    }
    
    private boolean O1(final Intent intent) {
        if (intent != null) {
            if (intent.getAction() != null) {
                if ("android.intent.action.VIEW_DOWNLOADS".equals((Object)intent.getAction())) {
                    final ax.c3.K i = ax.c3.K.i;
                    this.c2(Bookmark.i((Context)this, i, i.e()), null, null, null, null);
                    return true;
                }
            }
        }
        return false;
    }
    
    private void O2() {
        ax.u3.g.a().h(this.n0);
        ax.u3.g.a().h(this.o0);
        this.t0.removeCallbacks(this.w0);
    }
    
    static /* synthetic */ ax.V2.e P0(final MainActivity mainActivity) {
        mainActivity.getClass();
        return null;
    }
    
    private boolean P1(final Intent intent) {
        boolean b = false;
        if (intent != null) {
            if (intent.getAction() != null) {
                if ("android.intent.action.VIEW".equals((Object)intent.getAction()) && intent.getData() != null) {
                    final Uri data = intent.getData();
                    final String scheme = intent.getData().getScheme();
                    if ("content".equals((Object)scheme) && "com.android.externalstorage.documents".equals((Object)intent.getData().getHost())) {
                        final String r = com.alphainventor.filemanager.file.g.r(data);
                        if (r == null) {
                            return false;
                        }
                        this.c2(Bookmark.g((Context)this, ax.c3.d0.U(r)), null, null, null, null);
                        return true;
                    }
                    else if (scheme != null && !"file".equals((Object)scheme)) {
                        if (!"smb".equals((Object)scheme) && !"ftp".equals((Object)scheme)) {
                            if (!"sftp".equals((Object)scheme)) {
                                if (!"content".equals((Object)scheme) || !"com.android.mtp.documents".equals((Object)intent.getData().getHost()) || !ax.X2.Q.k1()) {
                                    return false;
                                }
                                try {
                                    final List persistedUriPermissions = ((Context)this).getContentResolver().getPersistedUriPermissions();
                                    final Uri r2 = ax.c3.L.r0(intent.getData());
                                    if (persistedUriPermissions != null) {
                                        final Iterator iterator = persistedUriPermissions.iterator();
                                        b = false;
                                        while (iterator.hasNext()) {
                                            final UriPermission uriPermission = (UriPermission)iterator.next();
                                            if (uriPermission.getUri() != null && uriPermission.getUri().equals((Object)r2)) {
                                                b = true;
                                            }
                                        }
                                    }
                                    if (!b) {
                                        final ax.c3.K v0 = ax.Z2.j.F().V0(intent.getData());
                                        if (v0 != null) {
                                            this.R(0, v0, null, true, true);
                                        }
                                    }
                                    else {
                                        ax.Z2.j.F().t();
                                    }
                                    return true;
                                }
                                catch (final Exception ex) {
                                    return false;
                                }
                            }
                        }
                        final String host = data.getHost();
                        List list;
                        if ("smb".equals((Object)scheme)) {
                            list = com.alphainventor.filemanager.file.Q.t0((Context)this).n();
                        }
                        else if ("ftp".equals((Object)scheme)) {
                            list = com.alphainventor.filemanager.file.q.z0((Context)this).p();
                        }
                        else {
                            if (!"sftp".equals((Object)scheme)) {
                                return false;
                            }
                            list = com.alphainventor.filemanager.file.L.A0((Context)this).n();
                        }
                        final Iterator iterator2 = list.iterator();
                        ax.c3.K e = null;
                        while (iterator2.hasNext()) {
                            final s s = (s)iterator2.next();
                            if (s.c() != null && s.c().equals((Object)host)) {
                                e = s.e();
                            }
                        }
                        if (e == null) {
                            return false;
                        }
                        final String path = data.getPath();
                        if (path == null) {
                            return false;
                        }
                        this.c2(Bookmark.i((Context)this, e, ax.c3.d0.U(path)), null, null, null, null);
                        return true;
                    }
                    else {
                        final String path2 = data.getPath();
                        if (path2 == null) {
                            return false;
                        }
                        this.c2(Bookmark.g((Context)this, ax.c3.d0.U(path2)), null, null, null, null);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void Q1() {
        if (this.H == null) {
            return;
        }
        final Animation loadAnimation = AnimationUtils.loadAnimation((Context)this, 2130771997);
        loadAnimation.setAnimationListener((Animation$AnimationListener)new Animation$AnimationListener(this) {
            final MainActivity a;
            
            public void onAnimationEnd(final Animation animation) {
                if (this.a.H != null) {
                    this.a.H.setVisibility(8);
                    this.a.H = null;
                    this.a.B0();
                }
            }
            
            public void onAnimationRepeat(final Animation animation) {
            }
            
            public void onAnimationStart(final Animation animation) {
            }
        });
        this.H.startAnimation(loadAnimation);
    }
    
    private void Q2() {
        this.R2();
    }
    
    private void R2() {
        final Bookmark v = this.V;
        if (v != null && v.s() == ax.Q2.f.l0) {
            this.T.i();
            this.T.l(false);
        }
        else {
            this.T.l(true);
            final Bookmark v2 = this.V;
            if (v2 != null && v2.s() == ax.Q2.f.s1) {
                this.T.m(2131231109);
            }
            else {
                this.T.m(2131230781);
            }
        }
        this.k2();
    }
    
    private void S1() {
        this.T.n((View$OnClickListener)this.v0);
    }
    
    private void a2() {
        this.k2();
    }
    
    private n b2(final ax.Q2.f f) {
        if (f.A() == null) {
            return null;
        }
        Label_0036: {
            try {
                return f.A().newInstance();
            }
            catch (final InstantiationException ex) {}
            catch (final IllegalAccessException ex2) {
                break Label_0036;
            }
            final InstantiationException ex;
            ((Throwable)ex).printStackTrace();
            return null;
        }
        final IllegalAccessException ex2;
        ((Throwable)ex2).printStackTrace();
        return null;
    }
    
    private void i1() {
        if (this.f0 != null) {
            this.t0.removeCallbacks(this.y0);
            this.f0.cancel();
            this.f0 = null;
        }
    }
    
    private void k1(Bundle bundle) {
        final Object value = ((BaseBundle)bundle).get("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (value instanceof Bundle) {
            final Object value2 = ((BaseBundle)value).get("android:support:fragments");
            if (value2 instanceof Bundle) {
                bundle = (Bundle)value2;
                for (final String s : ((BaseBundle)bundle).keySet()) {
                    if (s != null && s.startsWith("fragment_")) {
                        final Object value3 = ((BaseBundle)bundle).get(s);
                        if (!(value3 instanceof Bundle)) {
                            continue;
                        }
                        final Object value4 = ((BaseBundle)value3).get("state");
                        if (!(value4 instanceof Parcelable) || ax.u3.B.x((Parcelable)value4) < 524288L) {
                            continue;
                        }
                        androidx.fragment.app.q.a(value4);
                    }
                }
            }
        }
    }
    
    private void k2() {
        final Bookmark v = this.V;
        if (v != null && ax.Q2.f.n(v.s()) && !this.T1() && this.W1() && this.C1().i() > 1) {
            this.T.r(true);
            this.T.k(true);
            return;
        }
        this.T.r(false);
        this.T.k(false);
    }
    
    private void l1() {
        if (this.l0 != null) {
            this.l0 = null;
        }
    }
    
    private void l2() {
        this.n0 = new BroadcastReceiver(this) {
            final MainActivity a;
            
            public void onReceive(final Context context, final Intent intent) {
                if (intent != null) {
                    if (!"local.intent.action.LICENSE_STATUS_CHANGED".equals((Object)intent.getAction())) {
                        "local.intent.action.SETTING_CHANGED".equals((Object)intent.getAction());
                        return;
                    }
                    if (ax.t3.g.c()) {
                        if (this.a.Q != null) {
                            ((View)this.a.Q).setVisibility(8);
                        }
                        ax.t3.j.a(context);
                    }
                }
            }
        };
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("local.intent.action.LICENSE_STATUS_CHANGED");
        intentFilter.addAction("local.intent.action.SETTING_CHANGED");
        ax.u3.g.a().c(intentFilter, this.n0);
        this.o0 = new BroadcastReceiver(this) {
            final MainActivity a;
            
            public void onReceive(final Context context, final Intent intent) {
                if (intent != null) {
                    if ("local.intent.action.USB_IS_EJECTING".equals((Object)intent.getAction())) {
                        this.a.D2(intent.getStringExtra("desc"));
                        return;
                    }
                    if ("local.intent.action.USB_IS_EJECTED".equals((Object)intent.getAction())) {
                        this.a.Q1();
                    }
                }
            }
        };
        final IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("local.intent.action.USB_IS_EJECTING");
        intentFilter2.addAction("local.intent.action.USB_IS_EJECTED");
        ax.u3.g.a().c(intentFilter2, this.o0);
    }
    
    private void m1() {
        if (this.e0 + 3500L > System.currentTimeMillis()) {
            ax.Q2.a.i().m("general", "double_back_exit").c("from", "Main").e();
            ((Activity)this).finish();
            this.i1();
            return;
        }
        while (true) {
            if (this.U1() && ax.t3.a.k(this.b())) {
                ax.u3.B.d0(((androidx.fragment.app.f)this).getSupportFragmentManager(), (androidx.fragment.app.e)new w(), "exitads", true);
                break Label_0141;
            }
            if (!ax.t3.j.e((Context)this)) {
                ax.t3.j.r((Context)this);
            }
            this.u0 = true;
            this.p();
            this.t0.postDelayed(this.y0, 3500L);
            try {
                (this.f0 = Toast.makeText((Context)this, 2131951680, 1)).show();
                this.e0 = System.currentTimeMillis();
            }
            catch (final NullPointerException | SecurityException ex) {
                continue;
            }
            break;
        }
    }
    
    private void n1(final boolean b) {
        if (b) {
            this.S.setDescendantFocusability(131072);
            return;
        }
        this.S.setDescendantFocusability(393216);
    }
    
    private void n2(final String s) {
        final Fragment k0 = ((androidx.fragment.app.f)this).getSupportFragmentManager().k0(s);
        if (k0 != null) {
            if (k0 instanceof n) {
                ((n)k0).q4();
            }
            ((androidx.fragment.app.f)this).getSupportFragmentManager().o().q(k0).j();
        }
    }
    
    private void o1(final boolean b) {
        if (b) {
            this.R.setDescendantFocusability(131072);
            return;
        }
        this.R.setDescendantFocusability(393216);
    }
    
    private void p() {
        final n x1 = this.x1();
        boolean b = true;
        if (x1 != null) {
            b = b;
            if (this.x1().z3() == ax.Q2.f.l0) {
                b = (true ^ this.u0);
            }
        }
        this.x0.j(b);
    }
    
    private String p1(final ax.Q2.f f, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(f.I());
        sb.append(n);
        return sb.toString();
    }
    
    private String q1(final Bookmark bookmark) {
        return this.p1(bookmark.s(), bookmark.t());
    }
    
    private void q2(final ax.Q2.f f, final int n) {
        this.n2(this.p1(f, n));
        ((Activity)this).runOnUiThread((Runnable)new Runnable(this, f, n) {
            final int c0;
            final MainActivity d0;
            final ax.Q2.f q;
            
            public void run() {
                this.d0.C1().s(this.q, this.c0);
                MainActivity.P0(this.d0);
                this.d0.N.h(this.q, this.c0);
                this.d0.j2();
            }
        });
    }
    
    private void r2(final n n, final String s) {
        if (!this.Z) {
            final n d0 = this.d0();
            if (d0 != n) {
                final t o = ((androidx.fragment.app.f)this).getSupportFragmentManager().o();
                if (d0 != null && !d0.O3()) {
                    o.p((Fragment)d0);
                }
                if (((Fragment)n).X0()) {
                    o.v((Fragment)n);
                }
                else {
                    o.c(2131362331, (Fragment)n, s);
                }
                o.j();
            }
        }
    }
    
    private void u2(Bookmark f, final ax.Z2.f w, final n u) {
        f = Bookmark.f(f);
        f.G(u.C3());
        this.N.a(f, w);
        this.V = f;
        this.W = w;
        this.U = u;
        this.v2(f);
        this.p();
    }
    
    private void v2(final Bookmark bookmark) {
        if (this.getSupportActionBar() != null && this.T != null) {
            final String h = ax.Q2.f.H((Context)this, bookmark.u());
            final String g = ax.Q2.f.G((Context)this, bookmark.u());
            if (bookmark.s() == ax.Q2.f.l0) {
                this.T.p(2131951672);
            }
            else if (bookmark.s() == ax.Q2.f.i1) {
                final int t = bookmark.t();
                if (ax.T2.h.C0(t)) {
                    this.T.q(h);
                }
                else {
                    this.T.q(ax.Q2.f.H((Context)this, ax.T2.h.q(t)));
                }
            }
            else {
                this.T.q(h);
            }
            if (g != null) {
                this.T.o(g);
                return;
            }
            this.T.o(null);
        }
    }
    
    private ax.c3.K y1() {
        final n d0 = this.d0();
        if (d0 == null) {
            return null;
        }
        return d0.A3();
    }
    
    private String z1() {
        final n d0 = this.d0();
        if (d0 == null) {
            return null;
        }
        return d0.C3();
    }
    
    public View A1() {
        return this.j0;
    }
    
    public void A2() {
        if (this.n()) {
            return;
        }
        ((androidx.fragment.app.e)ax.a3.i.d3()).c3(((androidx.fragment.app.f)this).getSupportFragmentManager(), "add_sublocation");
    }
    
    public long B1() {
        return this.h0;
    }
    
    public void B2() {
        if (this.n()) {
            return;
        }
        ((androidx.fragment.app.e)new ax.a3.g()).c3(((androidx.fragment.app.f)this).getSupportFragmentManager(), "add_sublocation");
    }
    
    public d C1() {
        if (this.O == null) {
            (this.O = new d((Context)this)).o();
        }
        return this.O;
    }
    
    public void C2() {
        if (this.n()) {
            return;
        }
        ((androidx.fragment.app.e)ax.a3.i.e3()).c3(((androidx.fragment.app.f)this).getSupportFragmentManager(), "add_sublocation");
    }
    
    public k D1() {
        return this.z0;
    }
    
    public ax.g3.l E1(final String s) {
        return (ax.g3.l)new ax.g3.l(this, s) {
            final String a;
            final MainActivity b;
            
            public void d(final ax.Q2.f f, final int n) {
                this.b.q2(f, n);
            }
            
            public void e(final s s) {
                this.b.g2(s, null, this.a);
            }
        };
    }
    
    public void F2(final boolean b) {
        final Fragment k0 = ((androidx.fragment.app.f)this).getSupportFragmentManager().k0("permission_screen");
        final t o = ((androidx.fragment.app.f)this).getSupportFragmentManager().o();
        if (k0 != null) {
            o.q(k0);
        }
        o.c(2131362746, (Fragment)(this.r0 = ax.d3.e0.V2(b)), "permission_screen");
        o.j();
        ((View)this.z).setVisibility(4);
    }
    
    public void G2(final String s) {
        this.c2(Bookmark.m((Context)this, ax.Q2.f.p1, 0), s, null, null, null);
    }
    
    public void H2(final ax.c3.K k, final String s) {
        this.d2(k, true, Bookmark.m((Context)this, ax.Q2.f.p1, 0), s);
    }
    
    public void I2() {
        if (this.m0 == null) {
            ax.u3.b.g("rewarded ads null?");
            return;
        }
        try {
            final FragmentManager supportFragmentManager = ((androidx.fragment.app.f)this).getSupportFragmentManager();
            final Fragment k0 = supportFragmentManager.k0("progress");
            if (k0 != null) {
                final t o = supportFragmentManager.o();
                o.q(k0);
                o.j();
            }
        }
        catch (final Exception ex) {}
        final K m0 = this.m0;
        if (m0 == MainActivity.K.c0) {
            this.m0 = MainActivity.K.d0;
            this.A((androidx.fragment.app.e)new ax.a3.D(), "progress", true);
        }
        else if (m0 == MainActivity.K.g0) {
            this.h2();
        }
        else if (m0 == MainActivity.K.h0) {
            Toast.makeText((Context)this, 2131951948, 1).show();
        }
        else if (m0 == MainActivity.K.e0) {
            final Object l0 = this.l0;
            if (l0 != null) {
                ax.S2.b.m((Activity)this, l0, this.D0);
            }
        }
    }
    
    public void J2(final boolean b, final String s) {
        if (this.n()) {
            return;
        }
        ax.Q2.a.i().m("ads", "rewarded_ads_open").c("from", s).e();
        int n;
        if (b) {
            n = 2131952533;
        }
        else {
            n = 2131952551;
        }
        final ax.a3.n k3 = ax.a3.n.k3(n, 2131952550, 2131952552, 17039360);
        ((androidx.fragment.app.e)k3).c3(((androidx.fragment.app.f)this).getSupportFragmentManager(), "rewardads");
        k3.n3((n$c)new n$c(this, s) {
            final String a;
            final MainActivity b;
            
            public void G(final ax.a3.n n) {
            }
            
            public void P(final ax.a3.n n) {
                if (this.b.s() == null) {
                    return;
                }
                ((MainActivity)this.b.s()).I2();
                ax.Q2.a.i().o("ads_rewarded_dialog").b("unit", "desktop_reward").b("from", this.a).b("result", "confirm").c();
            }
            
            public void Z(final ax.a3.n n) {
                ax.Q2.a.i().o("ads_rewarded_dialog").b("unit", "desktop_reward").b("from", this.a).b("result", "cancel").c();
            }
        });
    }
    
    public void K2(final ax.c3.K k, final boolean b, final String s) {
        this.c2(Bookmark.n((Context)this, ax.T2.h.B(k)), s, null, (MainActivity$H)new MainActivity$H(this, b) {
            final boolean a;
            final MainActivity b;
            
            public void a(final n n) {
                if (this.a && n instanceof ax.d3.b) {
                    ((ax.d3.b)n).W5();
                }
            }
        }, null);
    }
    
    @Override
    public void L0() {
        this.Q2();
        this.invalidateOptionsMenu();
        this.o1(true);
    }
    
    public void M2() {
        if (this.J == null) {
            final c c = new c(this) {
                final MainActivity c;
                
                public void a(final View view) {
                    this.c.R1();
                }
            };
            this.J = (ViewGroup)this.findViewById(2131362991);
            (this.K = (Toolbar)this.findViewById(2131362996)).setNavigationIcon(2131231109);
            this.K.setNavigationOnClickListener((View$OnClickListener)c);
            this.K.setNavigationContentDescription(2131951765);
            ((View)this.J).setOnClickListener((View$OnClickListener)c);
            ((View)(this.L = (ListView)this.findViewById(2131362992))).setOnKeyListener((View$OnKeyListener)new View$OnKeyListener(this) {
                final MainActivity a;
                
                public boolean onKey(View view, final int n, final KeyEvent keyEvent) {
                    if (n == 22 && keyEvent.getAction() == 0) {
                        this.a.L.setItemsCanFocus(true);
                        view = ((AdapterView)this.a.L).getSelectedView();
                        if (view != null) {
                            view = view.findViewById(2131362040);
                            if (view != null) {
                                view.requestFocus();
                            }
                        }
                        return true;
                    }
                    return false;
                }
            });
            final f f = new f((Context)this, this.C1());
            this.M = f;
            this.L.setAdapter((ListAdapter)f);
            ((AdapterView)this.L).setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener(this) {
                final MainActivity a;
                
                public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                    final ax.c3.K z0 = this.a.y1();
                    final String a1 = this.a.z1();
                    if (z0 != null && a1 != null) {
                        this.a.C1().a(Bookmark.i((Context)this.a, z0, a1));
                    }
                    final Bookmark bookmark = (Bookmark)this.a.M.getItem(n);
                    if (bookmark != null) {
                        ax.Q2.a.i().m("menu_drawer", "open_in_drawer").c("by", "top_window").c("tgt", bookmark.s().I()).e();
                        this.a.R1();
                        this.a.c2(bookmark, "history", null, null, null);
                    }
                }
            });
        }
        ((View)this.J).setVisibility(0);
        final TextView textView = (TextView)((View)this.K).findViewById(2131362994);
        final TextView textView2 = (TextView)((View)this.K).findViewById(2131362993);
        textView.setText((CharSequence)this.T.h());
        final String g = this.T.g();
        if (!TextUtils.isEmpty((CharSequence)g)) {
            textView2.setText((CharSequence)g);
            ((View)textView2).setVisibility(0);
        }
        else {
            ((View)textView2).setVisibility(8);
        }
        ((View)this.L).startAnimation(AnimationUtils.loadAnimation((Context)this, 2130772019));
        this.M.d(this.y1(), this.z1());
        this.o1(false);
        this.n1(false);
        ((View)this.J).requestFocus();
    }
    
    public void P2(final ax.Q2.f f, final int n) {
        this.N.l(f, n);
    }
    
    public void R1() {
        final ViewGroup j = this.J;
        if (j == null) {
            return;
        }
        ((View)j).setVisibility(8);
        this.o1(true);
        this.n1(true);
        ((View)this.S).requestFocus();
        this.k2();
    }
    
    public boolean T1() {
        return this.x1() != null && this.x1().K3();
    }
    
    public boolean U1() {
        return this.j0 != null && this.k0;
    }
    
    public boolean V1() {
        return this.s0;
    }
    
    public boolean W1() {
        return this.O != null;
    }
    
    public boolean X1() {
        final e0 r0 = this.r0;
        return r0 != null && ((Fragment)r0).X0();
    }
    
    public boolean Y1() {
        return this.m0 == MainActivity.K.e0 && this.l0 != null;
    }
    
    public boolean Z1() {
        final ViewGroup j = this.J;
        return j != null && ((View)j).getVisibility() == 0;
    }
    
    public void a(final String s) {
        final n x1 = this.x1();
        if (x1 instanceof ax.d3.Q && x1.C3().equals((Object)s)) {
            ((E)x1).j9();
        }
    }
    
    @Override
    public void a0(final ax.Q2.f f, final int n, final String s) {
        final String p3 = this.p1(f, n);
        final Bookmark v = this.V;
        if (v != null && this.q1(v).equals((Object)p3)) {
            this.m2(true, s);
            return;
        }
        this.n2(p3);
        this.N.h(f, n);
    }
    
    public void c(final ax.Q2.f f, final String s) {
        if (f == ax.Q2.f.T0) {
            com.alphainventor.filemanager.file.D.a1(((Context)this).getApplicationContext()).k(this, s, this.B0);
            return;
        }
        if (f == ax.Q2.f.U0) {
            com.alphainventor.filemanager.file.H.U0(((Context)this).getApplicationContext()).k(this, s, this.B0);
            return;
        }
        ax.u3.b.f();
    }
    
    public void c2(final Bookmark bookmark, final String s, final ax.Z2.f f, final MainActivity$H mainActivity$H, final MainActivity$G mainActivity$G) {
        if (this.Z) {
            final ax.Ha.b j = ax.Ha.c.h().d("OPEN_BOOKMARK_AFTER_DESTORY").j();
            final StringBuilder sb = new StringBuilder();
            sb.append("from:");
            sb.append(s);
            j.g((Object)sb.toString()).h();
            return;
        }
        final ax.Q2.f s2 = bookmark.s();
        final int t = bookmark.t();
        if (s2 == ax.Q2.f.Y0) {
            this.B2();
            return;
        }
        if (s2 == ax.Q2.f.Z0) {
            ((Context)this).startActivity(new Intent((Context)this, (Class)PaymentActivity.class));
            return;
        }
        if (s2 == ax.Q2.f.X0) {
            this.e2(ax.c3.B.U(bookmark.u(), bookmark.w()), null);
            return;
        }
        if (s2 == ax.Q2.f.a1) {
            ((ComponentActivity)this).startActivityForResult(new Intent((Context)this, (Class)DevSettingsActivity.class), 10004);
            return;
        }
        final Bundle bundle = new Bundle();
        if (f != null && f.c()) {
            bundle.putSerializable("parent_location", (Serializable)f.a());
        }
        if (f != null) {
            final Bundle d0 = f.d0;
            if (d0 != null) {
                bundle.putAll(d0);
            }
        }
        final n n2 = this.N2(s2, t, bundle, f);
        if (s != null) {
            final Logger e0 = MainActivity.E0;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Open location : ");
            sb2.append(s2.I());
            e0.fine(sb2.toString());
            ax.Q2.a.i().n("navigation", "open_location").c("loc", s2.I()).c("from", s).e();
        }
        if (n2 != null) {
            if (mainActivity$H != null) {
                mainActivity$H.a(n2);
            }
            if (mainActivity$G != null) {
                this.y2(bookmark, (Runnable)new Runnable(this, mainActivity$G, n2) {
                    final n c0;
                    final MainActivity d0;
                    final MainActivity$G q;
                    
                    public void run() {
                        this.q.a(this.c0);
                    }
                });
            }
            if (bookmark.w() == null && bookmark.u().e() != null) {
                if (bookmark.s() != ax.Q2.f.V0) {
                    final ax.Ha.b i = ax.Ha.c.h().f().d("!!INVLIAD OPEN PATH!!").j();
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(bookmark.s().I());
                    sb3.append(",");
                    sb3.append(bookmark.z());
                    i.g((Object)sb3.toString()).h();
                }
                bookmark.G(bookmark.u().e());
            }
            if (!bookmark.A()) {
                final Bookmark f2 = Bookmark.f(bookmark);
                f2.G(ax.c3.d0.r(bookmark.w()));
                this.x2(f2, (Runnable)new Runnable(this, n2, bookmark) {
                    final Bookmark c0;
                    final MainActivity d0;
                    final n q;
                    
                    public void run() {
                        this.q.Z3(this.c0.w());
                    }
                });
                n2.Z3(f2.w());
            }
            else {
                n2.Z3(bookmark.w());
            }
            n2.n4(f);
            this.u2(bookmark, f, n2);
            this.M0();
        }
        this.Q2();
    }
    
    @Override
    public n d0() {
        return this.U;
    }
    
    public void d2(final ax.c3.K k, final boolean b, final Bookmark bookmark, final String s) {
        if (k.d() == ax.Q2.f.i1) {
            this.c2(bookmark, s, new ax.Z2.f(k, b), (MainActivity$H)new MainActivity$H(this) {
                final MainActivity a;
                
                public void a(final n n) {
                    if (n instanceof E) {
                        final E e = (E)n;
                        e.U6();
                        e.J9(((Context)this.a).getApplicationContext(), true);
                    }
                }
            }, null);
            return;
        }
        this.c2(bookmark, s, new ax.Z2.f(k, b), null, null);
    }
    
    @Override
    public h e0() {
        return this.T;
    }
    
    public void e2(String o, final Runnable runnable) {
        final Uri parse = Uri.parse((String)o);
        final boolean g = ax.Z2.k.g(parse, ax.Q2.f.X0);
        final MainActivity$G mainActivity$G = null;
        Uri uri = parse;
        Label_0396: {
            if (g) {
                final ax.Z2.k a = ax.Z2.k.a(parse);
                final o e = ax.c3.x.e(a.d());
                final boolean a2 = e.a();
                com.alphainventor.filemanager.file.b b;
                if (!a2) {
                    o = com.alphainventor.filemanager.file.b.P0(a.d());
                    b = null;
                }
                else {
                    b = (com.alphainventor.filemanager.file.b)e.u();
                    o = b.O0();
                }
                if (o == null) {
                    return;
                }
                Label_0176: {
                    Intent intent;
                    try {
                        intent = new Intent("android.intent.action.VIEW");
                        intent.setComponent(new ComponentName((Context)this, (Class)ArchiveActivity.class));
                        intent.putExtra("data_uri", (Parcelable)o);
                        intent.putExtra("open_uri", (Parcelable)parse);
                        if (a2) {
                            e.n0();
                            intent.putExtra("open_uri_release", true);
                        }
                    }
                    catch (final ActivityNotFoundException ex) {
                        break Label_0176;
                    }
                    ((Context)this).startActivity(intent);
                }
                if (b != null && b.N0() == 1 && b.V0() != null) {
                    final Logger e2 = MainActivity.E0;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Open local file archive viewer : ");
                    sb.append(o);
                    e2.fine(sb.toString());
                    final y v0 = b.V0();
                    if (!ax.Z2.a.p((Context)this, ((com.alphainventor.filemanager.file.n)v0).T())) {
                        uri = Uri.parse(((com.alphainventor.filemanager.file.n)v0).S());
                        break Label_0396;
                    }
                }
                else if (ax.c3.u.P((Uri)o)) {
                    o = ax.c3.d0.r(((Uri)o).getPath());
                    if (!ax.Z2.a.p((Context)this, (String)o)) {
                        uri = Uri.parse(ax.c3.B.U(ax.c3.x.g((String)o).T(), (String)o));
                        break Label_0396;
                    }
                }
                else if (MyFileProvider.B((Uri)o) || MyFileProvider.A((Uri)o)) {
                    final Logger e3 = MainActivity.E0;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Open document file archive viewer : ");
                    sb2.append(o);
                    e3.fine(sb2.toString());
                    final ax.Z2.k e4 = MyFileProvider.e((Uri)o);
                    if (e4 == null) {
                        return;
                    }
                    uri = Uri.parse(ax.c3.B.U(e4.d(), ax.c3.d0.r(e4.e())));
                    break Label_0396;
                }
                uri = null;
            }
        }
        if (uri != null) {
            final Bookmark c = Bookmark.c((Context)this, uri);
            if (c != null) {
                Object o2 = mainActivity$G;
                if (runnable != null) {
                    o2 = new MainActivity$G(this, runnable) {
                        final Runnable a;
                        final MainActivity b;
                        
                        public void a(final n n) {
                            this.a.run();
                        }
                    };
                }
                this.c2(c, "location_uri", null, null, (MainActivity$G)o2);
                return;
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Illegal location uri : ");
            sb3.append(uri.toString());
            throw new IllegalArgumentException(sb3.toString());
        }
    }
    
    public void f2(final ax.c3.K k, final Bundle bundle) {
        this.c2(Bookmark.m((Context)this, ax.Q2.f.s1, k.hashCode()), "search", new ax.Z2.f(k, false, bundle), null, null);
    }
    
    public void g(final ax.c3.K k) {
        if (k.d() != ax.Q2.f.p0 || ax.Z2.j.F().t0()) {
            this.c2(Bookmark.n(((Context)this).getApplicationContext(), k), "home", null, (MainActivity$H)new MainActivity$H(this) {
                final MainActivity a;
                
                public void a(final n n) {
                    if (n instanceof E) {
                        ((E)n).U6();
                    }
                }
            }, null);
            return;
        }
        if (ax.Z2.j.F().v0()) {
            this.N(k);
            return;
        }
        Toast.makeText((Context)this, 2131952633, 1).show();
    }
    
    public void g2(final s s, final ax.c3.K k, final String s2) {
        final Bookmark o = Bookmark.o(s);
        if (k != null) {
            this.d2(k, false, o, s2);
            return;
        }
        this.c2(o, s2, null, null, null);
    }
    
    @Override
    public A h0() {
        if (this.I == null) {
            (this.I = new A(this, this.findViewById(2131362675), this.findViewById(2131362676))).D();
            this.I.v((ax.x3.d.h)new ax.x3.d.h(this) {
                final MainActivity a;
                
                @Override
                public void a(final int n) {
                    this.a.B0();
                }
            });
        }
        return this.I;
    }
    
    public void h1(final MainActivity.MainActivity$J mainActivity$J) {
        this.X.add((Object)mainActivity$J);
    }
    
    public void h2() {
        ax.t3.a.f((Context)this);
        ax.u3.g.a().e(new Intent("local.intent.action.LICENSE_STATUS_CHANGED"));
        this.m0 = MainActivity.K.q;
        this.l1();
    }
    
    public void i2(final ax.Q2.f f, final int n) {
        this.j2();
        this.P2(f, n);
        this.v2(this.V);
    }
    
    public boolean isContentClipToPadding(final boolean b) {
        if (!ax.t3.a.i() && !this.m0()) {
            final A i = this.I;
            if (i == null || !i.m()) {
                final View h = this.H;
                if (h == null || h.getVisibility() != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void j1() {
        final View j0 = this.j0;
        if (j0 != null) {
            ax.S2.b.a((Object)j0, (Context)this);
            this.j0 = null;
        }
    }
    
    public void j2() {
        this.s2();
    }
    
    public void m2(final boolean b, final String s) {
        if (this.z.A(this.A)) {
            this.z.d(this.A);
        }
        final Bookmark v = this.V;
        final ax.Z2.f w = this.W;
        if (v != null) {
            this.n2(this.q1(v));
            this.N.h(v.s(), v.t());
        }
        this.c2(Bookmark.l((Context)this, ax.Q2.f.l0), s, null, null, null);
        if (v != null && b) {
            this.E2(v, w);
        }
    }
    
    public void o2() {
        if (this.r0 == null) {
            return;
        }
        final t o = ((androidx.fragment.app.f)this).getSupportFragmentManager().o();
        o.q((Fragment)this.r0);
        o.j();
        this.r0 = null;
        ((View)this.z).setVisibility(0);
    }
    
    protected void onActivityResult(int k, final int n, final Intent intent) {
        super.onActivityResult(k, n, intent);
        if (k != 1) {
            if (k != 10004) {
                if (k == 10006) {
                    com.alphainventor.filemanager.file.I.r0(((Context)this).getApplicationContext()).t(n, intent);
                }
            }
            else {
                k = ax.t3.k.k();
                if (this.Y != k) {
                    this.Y = k;
                    this.Q2();
                }
            }
        }
        else if (n == -1 && intent != null && intent.getExtras() != null) {
            final String stringExtra = intent.getStringExtra("authAccount");
            if (stringExtra != null) {
                com.alphainventor.filemanager.file.r.A0(((Context)this).getApplicationContext()).k(stringExtra, this.B0);
            }
        }
    }
    
    public void onApplyWindowsInsets(final ax.T.b b, final boolean b2) {
        if (!b2) {
            ((View)this.C).setPadding(0, 0, 0, b.d);
            return;
        }
        ((View)this.C).setPadding(0, 0, 0, 0);
    }
    
    public void onAttachFragment(final Fragment fragment) {
        super.onAttachFragment(fragment);
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ax.u3.z.c((ax.n.c)this);
        this.J();
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131558432);
        if (ax.X2.Q.N1() && ax.u3.z.w((Context)this)) {
            ax.X2.v.r(((Activity)this).getWindow(), -16777216);
        }
        if (((androidx.fragment.app.f)this).getSupportFragmentManager().v0() != null) {
            final t o = ((androidx.fragment.app.f)this).getSupportFragmentManager().o();
            for (final Fragment fragment : ((androidx.fragment.app.f)this).getSupportFragmentManager().v0()) {
                if (fragment instanceof n) {
                    o.p(fragment);
                }
                else {
                    if (!(fragment instanceof e0)) {
                        continue;
                    }
                    o.q(fragment);
                }
            }
            o.j();
        }
        final DrawerLayout z = (DrawerLayout)this.findViewById(2131362160);
        this.z = z;
        ((View)z).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)new ViewTreeObserver$OnPreDrawListener(this) {
            final MainActivity a;
            
            public boolean onPreDraw() {
                ax.u3.z.c((ax.n.c)this.a);
                this.a.q0.countDown();
                ((View)this.a.z).getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
                return true;
            }
        });
        this.z.setDrawerLockMode(1);
        this.F = (CoordinatorLayout)this.findViewById(2131361866);
        this.G = (CoordinatorLayout)this.findViewById(2131361864);
        this.R = (ViewGroup)this.findViewById(2131362982);
        this.S = (ViewGroup)this.findViewById(2131362331);
        this.A = this.findViewById(2131362928);
        this.B = (TabLayout)this.findViewById(2131362927);
        this.C = (FrameLayout)this.findViewById(2131362926);
        this.B.s();
        this.B.h((TabLayout$d)new TabLayout$d(this) {
            final MainActivity a;
            
            public void a(final TabLayout$g tabLayout$g) {
            }
            
            public void b(final TabLayout$g tabLayout$g) {
                final Object i = tabLayout$g.i();
                if (i != null) {
                    this.a.L2(i.toString());
                }
            }
            
            public void c(final TabLayout$g tabLayout$g) {
            }
        });
        (this.T = new h(this, this.R)).s((View$OnClickListener)new c(this) {
            final MainActivity c;
            
            public void a(final View view) {
                this.c.M2();
            }
        });
        this.k0();
        this.Y = ax.t3.k.k();
        this.N = new l((Context)this);
        this.S1();
        if (bundle == null) {
            this.c2(Bookmark.l((Context)this, ax.Q2.f.l0), "on_create", null, null, null);
            ((androidx.fragment.app.f)this).getSupportFragmentManager().g0();
            this.J1(((Activity)this).getIntent());
        }
        else {
            this.Q2();
        }
        ((ComponentActivity)this).getOnBackPressedDispatcher().h((ax.G0.h)this, this.x0);
        new I(this).h((Object[])new Long[0]);
        this.l2();
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        return true;
    }
    
    public boolean onCreatePanelMenu(final int n, final Menu menu) {
        return (n != 0 || menu == this.T.f()) && super.onCreatePanelMenu(n, menu);
    }
    
    @Override
    protected void onDestroy() {
        this.Z = true;
        super.onDestroy();
        this.j1();
        this.O2();
        this.l1();
        this.i1();
        final View s1 = this.s1();
        if (s1 != null) {
            ax.S2.b.a((Object)s1, (Context)this);
            ((ViewGroup)this.F).removeAllViews();
        }
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return (this.x1() != null && this.x1().Y3(n, keyEvent)) || super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyLongPress(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.x1() != null) {
            this.q0("long_back");
            return true;
        }
        return super.onKeyLongPress(n, keyEvent);
    }
    
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        ax.u3.z.c((ax.n.c)this);
        this.J1(intent);
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default: {
                return super.onOptionsItemSelected(menuItem);
            }
            case 2131362544: {
                ax.Q2.a.i().m("menu_desktop", "general_settings").e();
                ((Context)this).startActivity(new Intent((Context)this, (Class)SettingsActivity.class));
            }
            case 2131362538: {
                return true;
            }
            case 2131362530: {
                ax.Q2.a.i().m("menu_folder", "refresh").c("loc", this.V.s().I()).e();
                final n x1 = this.x1();
                if (x1 != null) {
                    x1.c4(true);
                    return true;
                }
                return true;
            }
            case 16908332: {
                return true;
            }
        }
    }
    
    protected void onPause() {
        super.onPause();
        final View j0 = this.j0;
        if (j0 != null) {
            ax.S2.b.c((Object)j0, (Context)this);
        }
        final View s1 = this.s1();
        if (s1 != null) {
            ax.S2.b.c((Object)s1, (Context)this);
        }
    }
    
    protected void onPostCreate(final Bundle bundle) {
        super.onPostCreate(bundle);
    }
    
    public boolean onPrepareOptionsMenu(final Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
    
    protected void onRestoreInstanceState(final Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.V = (Bookmark)bundle.getSerializable("CURRENT_BOOKMARK");
        this.W = (ax.Z2.f)bundle.getParcelable("CURRENT_EXTRAINFO");
        final ArrayList list = (ArrayList)bundle.getSerializable("OPEN_BOOKMARK");
        final ArrayList list2 = (ArrayList)bundle.getSerializable("OPEN_EXTRAINFOS");
        if (list != null) {
            this.N.i(list);
        }
        if (list2 != null) {
            this.N.j(list2);
        }
        final Bookmark v = this.V;
        if (v != null) {
            this.c2(v, "on_restore_instance", this.W, null, null);
        }
    }
    
    protected void onResume() {
        super.onResume();
        com.alphainventor.filemanager.file.k.s0(((Context)this).getApplicationContext()).p((Activity)this);
        this.j2();
        HttpServerService.v((Context)this);
        final View j0 = this.j0;
        if (j0 != null) {
            ax.S2.b.l((Object)j0, (Context)this);
        }
        final View s1 = this.s1();
        if (s1 != null) {
            ax.S2.b.l((Object)s1, (Context)this);
        }
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("CURRENT_BOOKMARK", (Serializable)this.V);
            bundle.putParcelable("CURRENT_EXTRAINFO", (Parcelable)this.W);
            bundle.putSerializable("OPEN_BOOKMARK", (Serializable)this.N.e());
            bundle.putSerializable("OPEN_EXTRAINFOS", (Serializable)this.N.g());
        }
        catch (final IllegalStateException ex) {
            ax.Ha.c.h().d("MainActivity onSaveInstanceState Error").l((Throwable)ex).h();
        }
        try {
            this.k1(bundle);
        }
        catch (final Exception ex2) {}
    }
    
    @Override
    protected void onStart() {
        super.onStart();
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        this.C1().u();
    }
    
    @Override
    public void p0() {
        this.a2();
        this.e0().b();
        this.o1(false);
    }
    
    public void p2(final MainActivity.MainActivity$J mainActivity$J) {
        this.X.remove((Object)mainActivity$J);
    }
    
    @Override
    public void q0(final String s) {
        if (this.z.A(this.A)) {
            this.z.d(this.A);
        }
        final Bookmark l = Bookmark.l((Context)this, ax.Q2.f.l0);
        l.G("/moveToHome");
        this.c2(l, s, null, null, null);
    }
    
    @Override
    public void r0(final Bookmark bookmark) {
        final Boolean p = this.p0;
        if (p != null && p) {
            ax.V2.a.b((Context)this).a(bookmark);
        }
        if (bookmark.A()) {
            this.C1().a(bookmark);
        }
    }
    
    public CoordinatorLayout r1() {
        return this.F;
    }
    
    View s1() {
        final CoordinatorLayout f = this.F;
        if (f != null) {
            final View child = ((ViewGroup)f).getChildAt(0);
            if (child != null) {
                return child;
            }
        }
        return null;
    }
    
    public void s2() {
        final ArrayList<MainActivity.MainActivity$J> x = this.X;
        final int size = x.size();
        int i = 0;
        while (i < size) {
            final Object value = x.get(i);
            ++i;
            ((MainActivity.MainActivity$J)value).C();
        }
    }
    
    @Override
    public void t0(final ax.Q2.f f, final int n, final String s, final boolean b) {
        final Bookmark d0 = this.d0;
        if (d0 != null && d0.s() == f && this.d0.t() == n && this.d0.w().equals((Object)s)) {
            this.c0.run();
            this.c0 = null;
            this.d0 = null;
        }
    }
    
    public long t1() {
        if (this.i0 == 0L) {
            this.i0 = ax.t3.a.a();
        }
        return this.i0;
    }
    
    public void t2(final ax.S2.b$b g0) {
        final Object y = this.y;
        synchronized (y) {
            this.g0 = g0;
            monitorexit(y);
            if (g0 == ax.S2.b$b.c0) {
                if (ax.t3.a.h((Context)this) && !ax.S2.a.b() && !ax.u3.z.u((Context)this)) {
                    ax.S2.a.a((Context)this);
                }
                if (ax.t3.a.k((Context)this) && !this.U1() && !ax.u3.z.u((Context)this)) {
                    if (ax.t3.a.e()) {
                        ax.S2.b.g((Activity)this, (ax.S2.b$c)new ax.S2.b$c(this) {
                            final MainActivity a;
                        });
                        return;
                    }
                    final int l = ax.t3.c.n().l();
                    int m3;
                    if (ax.a3.B.l((Activity)this.s()) && ax.a3.w.n3(l)) {
                        m3 = ax.a3.w.m3((Context)this);
                    }
                    else {
                        m3 = 300;
                    }
                    this.j0 = ax.S2.b.h((Activity)this, m3, (ax.S2.b$a)new ax.S2.b$a(this) {
                        final MainActivity a;
                    });
                }
            }
        }
    }
    
    public ax.S2.b$b u1() {
        final Object y = this.y;
        synchronized (y) {
            return this.g0;
        }
    }
    
    public ax.g3.b v1() {
        return this.C0;
    }
    
    @Override
    public void w0(final ax.Q2.f f, final int n, final String s, final boolean b) {
        if (b) {
            final int c = this.N.c(f, n);
            if (c >= 0) {
                this.N.k(f, n, s);
                this.C1().c(this.N.d(c));
                this.M0();
                this.k2();
            }
        }
        final Bookmark b2 = this.b0;
        if (b2 != null && b2.s() == f && this.b0.t() == n && this.b0.w().equals((Object)s)) {
            this.a0.run();
            this.a0 = null;
            this.b0 = null;
        }
    }
    
    public h$c w1() {
        return this.A0;
    }
    
    public void w2(final long h0) {
        this.h0 = h0;
    }
    
    @Override
    public void x0() {
        this.Q2();
    }
    
    public n x1() {
        final Bookmark v = this.V;
        if (v == null) {
            return null;
        }
        return (n)((androidx.fragment.app.f)this).getSupportFragmentManager().k0(this.q1(v));
    }
    
    void x2(final Bookmark d0, final Runnable c0) {
        this.d0 = d0;
        this.c0 = c0;
    }
    
    void y2(final Bookmark b0, final Runnable a0) {
        this.b0 = b0;
        this.a0 = a0;
    }
    
    public void z2(final String s, final String s2) {
        if (this.getSupportActionBar() != null) {
            final h t = this.T;
            if (t != null) {
                t.q(s);
                if (s2 != null) {
                    this.T.o(s2);
                    return;
                }
                this.T.o(null);
            }
        }
    }
    
    public static class I extends ax.u3.q<Long, Long, Long>
    {
        private MainActivity h;
        private boolean i;
        private boolean j;
        private CountDownLatch k;
        
        I(final MainActivity h) {
            super(q$e.e0);
            this.h = h;
            this.k = h.q0;
        }
        
        protected Long w(final Long... array) {
            if (ax.t3.k.v()) {
                ax.V2.b.d((Context)this.h);
            }
            while (true) {
                try {
                    this.k.await(3000L, TimeUnit.MILLISECONDS);
                    try {
                        Thread.sleep(100L);
                    }
                    catch (final Exception ex) {}
                    if (!ax.u3.z.y() && !ax.u3.z.t((Context)this.h) && (this.i = ax.u3.z.a((Activity)this.h))) {
                        final boolean f = ax.u3.z.F((Context)this.h);
                        this.j = f;
                        if (f) {
                            if (!ax.X2.Q.J()) {
                                ax.u3.z.A((Context)this.h);
                            }
                        }
                        else {
                            ax.Ha.c.h().f().b("WebView Locked detected!!").h();
                        }
                    }
                    if (ax.X2.J.G() && ax.t3.j.b((Context)this.h)) {
                        ax.t3.j.p((Context)this.h, false);
                        ax.u3.B.c0((Context)this.h, (Class)UsbAttachActivity.class, false);
                    }
                    ax.Q2.m.d(((Context)this.h).getApplicationContext());
                    return null;
                }
                catch (final Exception ex2) {
                    continue;
                }
                break;
            }
        }
        
        protected void x(final Long n) {
            if (!((Activity)this.h).isFinishing()) {
                if (this.i) {
                    if (this.j) {
                        ax.u3.z.q((Activity)this.h);
                    }
                    ax.u3.z.g((ax.n.c)this.h);
                }
                if (ax.t3.k.w((Context)this.h)) {
                    ((Activity)this.h).finish();
                }
            }
        }
    }
    
    enum K
    {
        c0, 
        d0, 
        e0, 
        f0, 
        g0, 
        h0;
        
        private static final K[] i0;
        
        q;
        
        static {
            i0 = d();
        }
        
        private static /* synthetic */ K[] d() {
            return new K[] { K.q, K.c0, K.d0, K.e0, K.f0, K.g0, K.h0 };
        }
    }
}
