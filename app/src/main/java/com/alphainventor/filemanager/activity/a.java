package com.alphainventor.filemanager.activity;

import android.os.BaseBundle;
import android.view.View$OnAttachStateChangeListener;
import ax.W2.h;
import android.content.pm.ApplicationInfo;
import android.content.pm.ActivityInfo;
import java.util.Iterator;
import java.util.List;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import java.io.Serializable;
import android.os.Bundle;
import ax.a3.G;
import ax.X2.y;
import android.content.ActivityNotFoundException;
import ax.c3.u;
import android.net.Uri;
import android.widget.Toast;
import com.alphainventor.filemanager.service.CommandService;
import androidx.fragment.app.Fragment;
import ax.u3.z;
import androidx.fragment.app.e;
import ax.d3.E;
import android.annotation.TargetApi;
import ax.t3.k;
import com.alphainventor.filemanager.file.x;
import ax.X2.Q;
import ax.Z2.n;
import ax.X2.J;
import ax.X2.v;
import ax.c3.K;
import ax.c0.F0;
import ax.t3.k$a;
import ax.t3.j;
import ax.u3.B;
import ax.c0.F0$m;
import ax.c0.d0;
import android.view.View;
import android.app.Activity;
import ax.P.b;
import android.content.Intent;
import android.content.Context;
import ax.Q2.g;
import android.content.BroadcastReceiver;
import ax.Q2.f;
import java.util.logging.Logger;
import ax.d3.s;
import ax.n.c;

public abstract class a extends c implements ax.R2.a, s
{
    private static final Logger h;
    private static boolean i;
    private f a;
    private int b;
    private String c;
    private boolean d;
    private long e;
    private boolean f;
    private BroadcastReceiver g;
    
    static {
        h = g.a((Class)a.class);
    }
    
    public a() {
        this.d = true;
        this.g = new BroadcastReceiver() {
            final a a;
            
            public void onReceive(final Context context, final Intent intent) {
                if ("local.intent.action.THEME_CHANGED".equals((Object)intent.getAction())) {
                    ax.P.b.r((Activity)this.a);
                }
            }
        };
    }
    
    private void I(final View view) {
        final F0 g = d0.G(view);
        if (g != null) {
            final int f = B.f((Context)this, g.f(F0$m.h()).d);
            if (f > 10 && f < 25) {
                final k$a c = j.c((Context)this);
                final k$a q = k$a.q;
                if (c != q) {
                    j.q((Context)this, q);
                }
            }
        }
    }
    
    @TargetApi(21)
    private void O(final int n, final Intent intent) {
        final f a = this.a;
        final int b = this.b;
        final String c = this.c;
        K a2;
        if (a != null) {
            a2 = K.a(a, b);
        }
        else {
            a2 = null;
        }
        this.L();
        f f = a;
        K k = a2;
        if (a2 == null) {
            final K q = this.Q(intent);
            f d = a;
            if (q != null) {
                d = q.d();
                q.b();
            }
            f = d;
            if ((k = q) == null) {
                return;
            }
        }
        String z = c;
        Label_0155: {
            if (k != K.e || (z = c) != null) {
                break Label_0155;
            }
            z = c;
            if (intent == null) {
                break Label_0155;
            }
            z = c;
            if (intent.getData() == null) {
                break Label_0155;
            }
            try {
                z = com.alphainventor.filemanager.file.g.z(v.h(intent.getData()));
                if (z != null) {
                    if (intent != null && intent.getData() != null && intent.getData().getAuthority() != null) {
                        final String authority = intent.getData().getAuthority();
                        if (!"com.android.externalstorage.documents".equals((Object)authority) && !"com.android.mtp.documents".equals((Object)authority) && !J.o() && !"com.android.providers.downloads.documents".equals((Object)authority)) {
                            final ax.Ha.b b2 = ax.Ha.c.h().f().b("Unknown external storage authority");
                            final StringBuilder sb = new StringBuilder();
                            sb.append("authority:");
                            sb.append(authority);
                            b2.g((Object)sb.toString()).h();
                        }
                    }
                    if (n == -1 && intent != null && intent.getData() != null && com.alphainventor.filemanager.file.g.H((Context)this, k, z, intent.getData())) {
                        Label_0359: {
                            Label_0354: {
                                try {
                                    v.t((Context)this, intent);
                                    if (ax.Z2.j.F().E0(k) && z != null) {
                                        n.b((Context)this).a(intent.getData());
                                        break Label_0354;
                                    }
                                }
                                catch (final SecurityException ex) {
                                    break Label_0359;
                                }
                                com.alphainventor.filemanager.file.g.O((Context)this, k, z, intent.getData());
                            }
                            this.S();
                            return;
                        }
                        final SecurityException ex;
                        ((Throwable)ex).printStackTrace();
                        ax.Ha.c.h().d("TAKE PERSITABLE PERMISSION ERROR!").l((Throwable)ex).h();
                    }
                    else {
                        int n2 = 0;
                        Label_0477: {
                            if (n == -1 && intent != null && intent.getData() != null) {
                                final boolean r1 = Q.R1();
                                n2 = 2;
                                if (r1 && k.d() != ax.Q2.f.u0) {
                                    if (!com.alphainventor.filemanager.file.g.I(k, intent.getData())) {
                                        break Label_0477;
                                    }
                                }
                                else if (!x.o1((Context)this, k, intent.getData())) {
                                    break Label_0477;
                                }
                                n2 = 1;
                            }
                            else {
                                if (n == 0 && f == ax.Q2.f.p0 && Q.L1()) {
                                    ax.t3.k.s((Context)this);
                                }
                                n2 = 0;
                            }
                        }
                        if (n != 0 || this.d) {
                            boolean b3 = false;
                            Label_0573: {
                                Label_0570: {
                                    if (Q.L1()) {
                                        if (System.currentTimeMillis() - this.e >= 750L) {
                                            if (n == -1 && intent != null && intent.getData() == null) {
                                                ax.Ha.c.h().f().c("7.0 DOCUMENT TREE OK BUT FAIL").g((Object)intent.toString()).h();
                                            }
                                            else if (n != -1) {
                                                break Label_0570;
                                            }
                                        }
                                        b3 = true;
                                        break Label_0573;
                                    }
                                }
                                b3 = false;
                            }
                            this.R(n2, k, z, b3, true);
                        }
                    }
                }
            }
            catch (final IllegalArgumentException ex2) {}
        }
    }
    
    private void S() {
        if (this instanceof com.alphainventor.filemanager.activity.b) {
            final ax.d3.n d0 = ((com.alphainventor.filemanager.activity.b)this).d0();
            if (d0 instanceof E) {
                ((E)d0).W8();
            }
        }
    }
    
    public boolean A(final e e, final String s, final boolean b) {
        if (this.n()) {
            return false;
        }
        B.d0(((androidx.fragment.app.f)this).getSupportFragmentManager(), e, s, b);
        return true;
    }
    
    protected void J() {
        if (z.w((Context)this) != this.f) {
            final int i = j.i((Context)this);
            if (i == 0 || i == -1) {
                ax.P.b.r((Activity)this);
            }
        }
    }
    
    public void L() {
        final Fragment k0 = ((androidx.fragment.app.f)this).getSupportFragmentManager().k0("guide_document_tree");
        if (k0 instanceof e) {
            ((e)k0).O2();
        }
    }
    
    public boolean M() {
        return ((androidx.fragment.app.f)this).getSupportFragmentManager().k0("guide_document_tree") != null;
    }
    
    public void N(final K k) {
        if (CommandService.y(k)) {
            Toast.makeText((Context)this, 2131951932, 1).show();
            return;
        }
        while (true) {
            if (!Q.R1() || k.d() == ax.Q2.f.u0) {
                break Label_0117;
            }
            Q.l(37);
            final Intent intent = new Intent("android.provider.action.DOCUMENT_ROOT_SETTINGS");
            final String z = ax.Z2.j.F().Z(k);
            if (z == null) {
                break Label_0117;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("content://com.android.externalstorage.documents/root/");
            sb.append(z);
            intent.setDataAndType(Uri.parse(sb.toString()), "vnd.android.document/root");
            if (!B.K((Context)this, intent)) {
                break Label_0117;
            }
            try {
                u.q0((Activity)this, intent, 50201);
                return;
                final Intent intent2 = new Intent("android.settings.MEMORY_CARD_SETTINGS");
                try {
                    u.q0((Activity)this, intent2, 50201);
                }
                catch (final SecurityException | NullPointerException ex) {
                    Toast.makeText((Context)this, 2131951927, 1).show();
                }
                catch (final ActivityNotFoundException ex2) {
                    Toast.makeText((Context)this, 2131952448, 1).show();
                }
            }
            catch (final ActivityNotFoundException ex3) {
                continue;
            }
            break;
        }
    }
    
    K Q(final Intent intent) {
        if (!Q.V1()) {
            return null;
        }
        if (intent != null && intent.getData() != null) {
            final K h = com.alphainventor.filemanager.file.g.h((Context)this, intent.getData());
            if (h != null) {
                return h;
            }
        }
        if (this instanceof com.alphainventor.filemanager.activity.b) {
            final ax.d3.n d0 = ((com.alphainventor.filemanager.activity.b)this).d0();
            if (d0 != null) {
                final K l = ax.Q2.f.L(d0.A3());
                if (l != null && l.e() != null) {
                    return l;
                }
            }
        }
        return null;
    }
    
    public void R(final int n, final K k, final String c, final boolean b, final boolean b2) {
        final K l = ax.Q2.f.L(k);
        if (l == null) {
            final ax.Ha.b b3 = ax.Ha.c.h().b("ILLEGAL LOCATION FOR TREEDOCUMENT");
            final StringBuilder sb = new StringBuilder();
            sb.append("loc:");
            sb.append(k.toString());
            b3.g((Object)sb.toString()).j().h();
            return;
        }
        Label_0247: {
            if (!b && Q.L1() && c == null && ax.Q2.f.c0(l.d())) {
                final String z = ax.Z2.j.F().Z(l);
                Intent c2;
                if (z != null) {
                    c2 = y.c((Context)this.s(), z);
                }
                else {
                    c2 = null;
                }
                Intent b4 = c2;
                if (c2 == null) {
                    b4 = c2;
                    if (ax.Q2.f.i0(l.d())) {
                        b4 = c2;
                        if (l.e() != null) {
                            b4 = y.b((Context)this.s(), l.e());
                        }
                    }
                }
                if (b4 != null) {
                    Label_0243: {
                        Label_0236: {
                            Label_0229: {
                                Label_0219: {
                                    try {
                                        this.a = l.d();
                                        this.b = l.b();
                                        this.c = c;
                                        if (n == 0) {
                                            this.d = false;
                                            break Label_0219;
                                        }
                                    }
                                    catch (final SecurityException ex) {
                                        break Label_0229;
                                    }
                                    catch (final NullPointerException ex2) {
                                        break Label_0236;
                                    }
                                    catch (final ActivityNotFoundException ex3) {
                                        break Label_0243;
                                    }
                                    this.d = true;
                                }
                                u.q0((Activity)this, b4, 50101);
                                return;
                            }
                            final SecurityException ex;
                            ((Throwable)ex).printStackTrace();
                            break Label_0247;
                        }
                        final NullPointerException ex2;
                        ((Throwable)ex2).printStackTrace();
                        break Label_0247;
                    }
                    final ActivityNotFoundException ex3;
                    ((Throwable)ex3).printStackTrace();
                }
            }
        }
        final G g = new G();
        final Bundle bundle = new Bundle();
        if (n != 0) {
            ((BaseBundle)bundle).putInt("ERROR_CAUSE", n);
        }
        bundle.putBoolean("SHOW_CANCEL", b2);
        bundle.putSerializable("LOCATION", (Serializable)l.d());
        ((BaseBundle)bundle).putInt("LOCATION_KEY", l.b());
        ((BaseBundle)bundle).putString("TREE_PATH", c);
        ((Fragment)g).v2(bundle);
        this.A((e)g, "guide_document_tree", true);
    }
    
    public void T(final int n) {
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().v((Drawable)new ColorDrawable(n));
        }
    }
    
    public boolean U(final K k, final String c) {
        if (k == null) {
            Toast.makeText((Context)this, 2131951927, 1).show();
            return false;
        }
        if (k == K.e && !ax.c3.d0.B(c)) {
            Toast.makeText((Context)this, 2131951927, 1).show();
            return false;
        }
        final Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        Label_0161: {
            if (Q.J0()) {
                if (!ax.Q2.f.b0(k.d()) && !ax.Q2.f.Q(k)) {
                    if (ax.Q2.f.h1 == k.d()) {
                        final Uri n = ax.Z2.j.F().N(k);
                        if (n != null) {
                            intent.putExtra("android.provider.extra.INITIAL_URI", (Parcelable)n);
                            break Label_0161;
                        }
                    }
                }
                else {
                    final Uri m = com.alphainventor.filemanager.file.g.m(k, c);
                    if (m != null) {
                        intent.putExtra("android.provider.extra.INITIAL_URI", (Parcelable)m);
                        break Label_0161;
                    }
                }
            }
            intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
            intent.putExtra("android.provider.extra.SHOW_ADVANCED", true);
        }
        final List queryIntentActivities = ((Context)this).getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null) {
            final Iterator iterator = queryIntentActivities.iterator();
            while (iterator.hasNext()) {
                final ResolveInfo resolveInfo = (ResolveInfo)iterator.next();
                final ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    final ApplicationInfo applicationInfo = activityInfo.applicationInfo;
                    if (applicationInfo != null && (applicationInfo.flags & 0x1) == 0x1) {
                        continue;
                    }
                }
                if (resolveInfo.priority < 0) {
                    iterator.remove();
                }
            }
        }
        if (queryIntentActivities != null && queryIntentActivities.size() > 1) {
            for (final ResolveInfo resolveInfo2 : queryIntentActivities) {
                if (Q.L0()) {
                    final ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
                    if (activityInfo2 != null && "com.google.android.documentsui".equals((Object)activityInfo2.packageName)) {
                        intent.setPackage("com.google.android.documentsui");
                        continue;
                    }
                }
                final ActivityInfo activityInfo3 = resolveInfo2.activityInfo;
                if (activityInfo3 != null && "com.android.documentsui".equals((Object)activityInfo3.packageName)) {
                    intent.setPackage("com.android.documentsui");
                }
            }
        }
        try {
            this.a = k.d();
            this.b = k.b();
            this.d = true;
            this.c = c;
            u.q0((Activity)this, intent, 50101);
            return true;
        }
        catch (final ActivityNotFoundException ex) {
            Toast.makeText((Context)this, 2131952448, 1).show();
            return false;
        }
        catch (final NullPointerException | SecurityException ex2) {
            Toast.makeText((Context)this, 2131951927, 1).show();
            return false;
        }
    }
    
    public Context b() {
        return (Context)this;
    }
    
    public void l(final h h, final boolean b) throws ax.b3.c {
        CommandService.M((androidx.fragment.app.f)this, (Fragment)null, h, b, true);
    }
    
    public boolean n() {
        return ((androidx.fragment.app.f)this).getSupportFragmentManager().Q0();
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 50101) {
            this.O(n2, intent);
            return;
        }
        if (n != 50201) {
            return;
        }
        ax.Z2.j.F().K0();
    }
    
    protected void onCreate(final Bundle bundle) {
        ax.Q2.b.f((Context)this, true);
        super.onCreate(bundle);
        if (Q.N1()) {
            v.s(((Activity)this).getWindow(), ax.Q.b.c((Context)this, 2131100837));
        }
        ax.u3.g.a().d("local.intent.action.THEME_CHANGED", this.g);
        this.f = z.w((Context)this);
    }
    
    protected void onDestroy() {
        ax.u3.g.a().h(this.g);
        super.onDestroy();
    }
    
    protected void onPause() {
        super.onPause();
        this.e = System.currentTimeMillis();
    }
    
    protected void onPostCreate(final Bundle bundle) {
        super.onPostCreate(bundle);
        if (Q.R0() && k.v() && !com.alphainventor.filemanager.activity.a.i) {
            final View viewById = this.findViewById(16908290);
            viewById.addOnAttachStateChangeListener((View$OnAttachStateChangeListener)new View$OnAttachStateChangeListener(this, viewById) {
                final View a;
                final a b;
                
                public void onViewAttachedToWindow(final View view) {
                    this.b.I(this.a);
                    com.alphainventor.filemanager.activity.a.i = true;
                }
                
                public void onViewDetachedFromWindow(final View view) {
                }
            });
        }
    }
    
    protected void onRestoreInstanceState(final Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.a = (f)bundle.getSerializable("DOCUMENT_TREE_REQUEST_LOCATION");
        this.b = ((BaseBundle)bundle).getInt("DOCUMENT_TREE_REQUEST_LOCATION_KEY");
        this.c = ((BaseBundle)bundle).getString("DOCUMENT_TREE_REQUEST_ROOT_TREE_PATH");
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("DOCUMENT_TREE_REQUEST_LOCATION", (Serializable)this.a);
            ((BaseBundle)bundle).putInt("DOCUMENT_TREE_REQUEST_LOCATION_KEY", this.b);
            ((BaseBundle)bundle).putString("DOCUMENT_TREE_REQUEST_ROOT_TREE_PATH", this.c);
        }
        catch (final IllegalStateException ex) {
            ax.Ha.c.h().d("BaseAppCompatActivity onSaveInstanceState Error").l((Throwable)ex).h();
        }
    }
    
    protected void onStart() {
        super.onStart();
    }
    
    public c s() {
        return this;
    }
}
