package com.alphainventor.filemanager.viewer;

import androidx.viewpager.widget.ViewPager;
import ax.u3.q$e;
import ax.A3.b$a;
import com.alphainventor.filemanager.file.y;
import ax.d3.M;
import ax.b3.j;
import ax.c3.d0;
import ax.c3.z;
import com.android.ex.photo.e$b;
import ax.J0.a$a;
import android.os.Bundle;
import java.util.Collections;
import java.util.Collection;
import ax.u3.q;
import ax.z3.a$h;
import androidx.fragment.app.Fragment;
import android.view.View$OnClickListener;
import android.content.ActivityNotFoundException;
import android.widget.Toast;
import ax.c3.w;
import com.alphainventor.filemanager.provider.MyFileProvider;
import android.app.Activity;
import android.view.View;
import ax.Z2.c$a;
import ax.c3.v;
import android.content.Intent;
import ax.c3.u;
import ax.c3.A;
import ax.a3.Q;
import android.net.Uri;
import android.content.Context;
import ax.B3.a;
import java.util.ArrayList;
import ax.c3.B;
import android.database.MatrixCursor;
import com.android.ex.photo.c;
import ax.c3.k;
import com.android.ex.photo.f$g;
import android.database.Cursor;
import ax.r3.d;
import com.alphainventor.filemanager.file.o;
import com.alphainventor.filemanager.file.n;
import java.util.List;
import com.android.ex.photo.f;

public class b extends com.android.ex.photo.f
{
    private List<n> P;
    private List<n> Q;
    private boolean R;
    private boolean S;
    private o T;
    private ax.r3.d U;
    private Cursor V;
    private Cursor W;
    private Boolean X;
    private d Y;
    
    public b(final f$g f$g, final List<n> p3, final o t) {
        super(f$g);
        this.P = p3;
        this.T = t;
        this.U = new ax.r3.d(f$g.b(), this.T);
    }
    
    static /* synthetic */ boolean J0(final b b) {
        return b.Y();
    }
    
    private static void N0(final MatrixCursor matrixCursor, final n n) {
        String s;
        if (B.P(n)) {
            s = B.W(n);
        }
        else {
            s = B.Y(n);
        }
        String s2 = s;
        if (B.H(n)) {
            s2 = s;
            if (((ax.c3.b)n).p() < 50000L) {
                s2 = null;
            }
        }
        matrixCursor.newRow().add((Object)n.Q()).add((Object)n.B()).add((Object)n.Q()).add((Object)s2).add((Object)((ax.c3.b)n).s());
    }
    
    public static MatrixCursor O0(final ArrayList<n> list) {
        final MatrixCursor matrixCursor = new MatrixCursor(a.a);
        final int size = list.size();
        int i = 0;
        while (i < size) {
            final Object value = list.get(i);
            ++i;
            N0(matrixCursor, (n)value);
        }
        return matrixCursor;
    }
    
    private ArrayList<com.alphainventor.filemanager.viewer.e.a> Q0(final Context context, final Uri uri, final List<n> list) {
        final boolean i3 = ax.a3.Q.I3(context, uri);
        final ArrayList list2 = new ArrayList();
        for (int j = 0; j < list.size(); ++j) {
            final n n = (n)list.get(j);
            boolean b;
            if (i3) {
                b = A.F(n);
            }
            else {
                b = A.E(n);
            }
            if (b) {
                list2.add((Object)new com.alphainventor.filemanager.viewer.e.a(u.L(n, false), null));
            }
        }
        return (ArrayList<com.alphainventor.filemanager.viewer.e.a>)list2;
    }
    
    private n R0(final String s) {
        if (s == null) {
            return null;
        }
        final List<n> u0 = this.U0();
        if (u0 == null) {
            return null;
        }
        for (int i = 0; i < u0.size(); ++i) {
            final n n = (n)u0.get(i);
            if (s.equals((Object)n.Q())) {
                return n;
            }
        }
        return null;
    }
    
    private int S0(final Uri uri) {
        if (uri == null) {
            return -1;
        }
        final List<n> u0 = this.U0();
        if (u0 == null) {
            return -1;
        }
        for (int i = 0; i < u0.size(); ++i) {
            final n n = (n)u0.get(i);
            if (B.H(n) && uri.equals((Object)u.L(n, false))) {
                return i;
            }
        }
        return -1;
    }
    
    private void T0(final ax.z3.a a) {
        if (this.O() != null) {
            this.O().i();
        }
    }
    
    private List<n> U0() {
        if (this.R) {
            return this.Q;
        }
        return this.P;
    }
    
    public static Intent W0(final Context context, final n n, final boolean b) {
        b.c(B.H(n));
        final String e = v.e(n, "application/octet-stream");
        Uri uri;
        if (B.H(n)) {
            uri = Q.E3(n);
        }
        else {
            uri = u.w(n.Z());
        }
        return Q.z3(context, c$a.d0, uri, e, true, b);
    }
    
    private View X0() {
        return this.N(2131361973);
    }
    
    private View Y0(final ax.z3.a a) {
        if (((Fragment)a).R0() == null) {
            return null;
        }
        return ((Fragment)a).R0().findViewById(2131362067);
    }
    
    private void Z0(final ax.z3.a a) {
        final View y0 = this.Y0(a);
        if (y0 != null) {
            y0.setVisibility(8);
        }
    }
    
    private boolean a1(final int n) {
        final List<n> u0 = this.U0();
        return u0 != null && (n < u0.size() && n >= 0);
    }
    
    private void b1(final k k, final c c) {
        if (this.O() != null) {
            final Activity activity = (Activity)this.O().b();
            try {
                final Intent e = w.e((Context)activity, MyFileProvider.p((n)k, c.c, c.d, c.f));
                this.X = this.s();
                activity.startActivityForResult(e, 36002);
            }
            catch (final ActivityNotFoundException | SecurityException | IllegalArgumentException ex) {
                this.X = null;
                Toast.makeText((Context)activity, 2131951927, 1).show();
            }
        }
    }
    
    private void c1() {
        if (this.O() instanceof ImageViewerActivity) {
            ((ImageViewerActivity)this.O()).x0();
        }
    }
    
    private void d1(final ax.z3.a a) {
        final View y0 = this.Y0(a);
        if (y0 == null) {
            ax.u3.b.f();
            return;
        }
        final Uri parse = Uri.parse(a.Y2());
        if (this.l(parse)) {
            a.U2(false);
            y0.setVisibility(0);
            y0.setOnClickListener((View$OnClickListener)new ax.g3.c(this, parse) {
                final Uri c;
                final b d;
                
                public void a(final View view) {
                    this.d.r(this.c, false);
                }
            });
            y0.requestFocus();
        }
        else {
            y0.setVisibility(8);
        }
        if (!this.y((Fragment)a)) {
            a.m3((a$h)null);
            return;
        }
        final View x0 = this.X0();
        if (x0 == null) {
            ax.u3.b.f();
            return;
        }
        final n r0 = this.R0(a.Y2());
        final c x2 = a.X2();
        if (B.H(r0) && x2 != null && x2.g == r0 && x2.b && x2.c >= 0L && x2.d > 0L) {
            a.m3((a$h)new a$h(this, a) {
                final ax.z3.a a;
                final b b;
                
                public void a(final boolean b) {
                    if (this.b.y((Fragment)this.a)) {
                        this.b.g1(b ^ true);
                    }
                }
            });
            this.g1(a.e3() ^ true);
            x0.setOnClickListener((View$OnClickListener)new ax.g3.c(this, r0, x2) {
                final n c;
                final c d;
                final b e;
                
                public void a(final View view) {
                    this.e.b1((k)this.c, this.d);
                }
            });
            x0.requestFocus();
            return;
        }
        a.m3((a$h)null);
        this.g1(false);
    }
    
    private void g1(final boolean b) {
        if (this.O() instanceof ImageViewerActivity) {
            ((ImageViewerActivity)this.O()).F0(b);
        }
    }
    
    public void A(final ax.z3.a a, final boolean b) {
        super.A(a, b);
        this.d1(a);
        this.T0(a);
        if (!b) {
            this.d1(a);
            final Uri parse = Uri.parse(a.Y2());
            if (this.l(parse)) {
                final n r0 = this.R0(parse.toString());
                if (r0 != null && ((ax.c3.b)r0).n()) {
                    ((View)a.W2()).setVisibility(8);
                    return;
                }
                this.Z0(a);
            }
        }
    }
    
    public void E0(final boolean b) {
        if (b) {
            this.P0();
            this.R = true;
            this.D0(this.W);
            return;
        }
        final Cursor v = this.V;
        if (v == null) {
            b.f();
            return;
        }
        this.R = false;
        this.D0(v);
        final Cursor w = this.W;
        if (w != null) {
            w.close();
            this.W = null;
            this.Q = null;
        }
    }
    
    public void F0() {
        final int currentItem = ((ViewPager)super.n).getCurrentItem();
        final int n = currentItem + 1;
        final boolean b = super.j >= 0;
        final List<n> u0 = this.U0();
        if (!super.k && b && n > 0 && u0 != null) {
            if (super.j > 1) {
                super.x = this.O().getResources().getString(2131952497, new Object[] { n, super.j });
                if (this.a1(currentItem)) {
                    final n n2 = (n)u0.get(currentItem);
                    if (n2 != null) {
                        super.y = n2.B();
                    }
                    else {
                        super.y = "";
                    }
                }
                else {
                    super.y = "";
                }
            }
            else {
                final n n3 = (n)u0.get(0);
                if (n3 != null) {
                    super.x = n3.B();
                }
                else {
                    super.x = "";
                }
            }
        }
        else {
            super.x = null;
        }
        this.x0(this.O().o());
    }
    
    public void K(final int n) {
        this.g1(false);
        super.K(n);
        final d y = this.Y;
        if (y != null && !y.isCancelled() && q.n((q)this.Y)) {
            this.Y.e();
        }
        (this.Y = new d(n)).i((Object[])new Void[0]);
    }
    
    public void P0() {
        final ArrayList q = new ArrayList((Collection)this.P);
        Collections.shuffle((List)q);
        this.Q = (List<n>)q;
        final Cursor w = this.W;
        if (w != null) {
            w.close();
        }
        this.W = (Cursor)O0((ArrayList<n>)q);
    }
    
    public Uri V0() {
        final int currentItem = ((ViewPager)super.n).getCurrentItem();
        final Cursor x = ((ax.y3.a)super.p).x();
        if (x != null && !x.isClosed()) {
            x.moveToPosition(currentItem);
            return Uri.parse(super.p.E(x));
        }
        return null;
    }
    
    public void c(final boolean b) {
        super.c(b);
        this.c1();
    }
    
    public void d0(int s0, final int n, final Intent intent) {
        if (s0 == 36001 && n == -1 && intent != null) {
            s0 = this.S0(intent.getData());
            if (s0 >= 0) {
                ((ViewPager)this.V()).setCurrentItem(s0);
            }
        }
    }
    
    public void e1() {
        this.S = true;
        super.k = true;
        this.O().getSupportLoaderManager().g(100, (Bundle)null, (a$a)this);
    }
    
    public void f1() {
        final e$b p = this.P();
        if (p != null) {
            p.k();
        }
    }
    
    public void g(final ax.z3.a a) {
        super.g(a);
        this.d1(a);
        this.T0(a);
    }
    
    public void i(final c c, final View view) {
        if (this.O() == null) {
            return;
        }
        final Object tag = view.getTag();
        ax.w3.e e;
        if (tag instanceof ax.w3.e) {
            e = (ax.w3.e)tag;
        }
        else {
            final ax.w3.e tag2 = new ax.w3.e(view);
            view.setTag((Object)tag2);
            e = tag2;
        }
        n r0 = null;
        Label_0071: {
            if (c == null) {
                final Uri v0 = this.V0();
                if (v0 != null) {
                    r0 = this.R0(v0.toString());
                    break Label_0071;
                }
            }
            r0 = null;
        }
        e.d(this.O().b(), c, r0);
    }
    
    public void k0(final ax.K0.c<Cursor> c, final Cursor v) {
        if (v == null || v != this.V) {
            this.V = v;
            try {
                super.k0((ax.K0.c)c, v);
            }
            catch (final NoSuchMethodError noSuchMethodError) {
                ax.Ha.c.h().d("IVOLF:").l((Throwable)noSuchMethodError).h();
            }
            if (this.S) {
                this.S = false;
                if (this.O() != null) {
                    ((ImageViewerActivity)this.O()).y0();
                    this.F0();
                }
            }
        }
    }
    
    public boolean l(final Uri uri) {
        return z.e0 == A.g(d0.k(uri.getPath()));
    }
    
    public void o0() {
        super.o0();
        if (this.O() != null) {
            final Boolean x = this.X;
            if (x != null) {
                this.y0((boolean)x, false);
                this.X = null;
                return;
            }
            if (!this.O().r()) {
                this.y0(false, false);
            }
        }
    }
    
    public void r(Uri l, final boolean b) {
        if (this.O() != null) {
            final n r0 = this.R0(((Uri)l).toString());
            if (r0 != null) {
                final List<n> u0 = this.U0();
                Object o2 = null;
                List list = null;
                Label_0148: {
                    if (!B.H(r0)) {
                        try {
                            final y o = r0.O();
                            o2 = r0;
                            list = u0;
                            if (o == null) {
                                break Label_0148;
                            }
                            final boolean f = B.F((n)o, r0);
                            o2 = r0;
                            list = u0;
                            if (!f) {
                                break Label_0148;
                            }
                            try {
                                list = Collections.singletonList((Object)o);
                                o2 = o;
                            }
                            catch (final j j) {
                                list = u0;
                            }
                        }
                        catch (final j i) {
                            o2 = r0;
                            list = u0;
                            break Label_0148;
                        }
                    }
                    o2 = r0;
                    if ((list = u0) == null) {
                        b.e("what case is this?");
                        list = Collections.singletonList((Object)r0);
                        o2 = r0;
                    }
                }
                final Activity activity = (Activity)this.O().b();
                if (B.H((n)o2)) {
                    final k k = (k)o2;
                    f f2;
                    if (b) {
                        f2 = f.q;
                    }
                    else {
                        final c$a c0 = c$a.c0;
                        if (ax.a3.Q.K3((Context)activity, c0, (n)k, false) && !ax.a3.Q.N3((Context)activity, c0, (n)k, false)) {
                            f2 = f.c0;
                        }
                        else if (ax.t3.j.F((Context)activity) && A.E((n)k)) {
                            f2 = f.q;
                        }
                        else {
                            final Intent w0 = W0((Context)activity, (n)k, true);
                            if (w0 != null && u.U(w0)) {
                                f2 = f.q;
                            }
                            else {
                                f2 = f.d0;
                            }
                        }
                    }
                    if (f2 == f.q) {
                        l = u.L((n)k, false);
                        final ArrayList<com.alphainventor.filemanager.viewer.e.a> q0 = this.Q0((Context)activity, (Uri)l, (List<n>)list);
                        try {
                            ax.Q2.a.i().m("command", "file_open").c("loc", "ImageViewerActivity").c("ext", ((n)k).A()).c("result", "success").e();
                            activity.startActivityForResult(w.j((Context)activity, (Uri)l, (ArrayList)q0, true, false), 36001);
                            return;
                        }
                        catch (final NullPointerException ex) {}
                        catch (final SecurityException l) {
                            goto Label_0368;
                        }
                        catch (final ActivityNotFoundException l) {
                            goto Label_0368;
                        }
                        Toast.makeText((Context)activity, 2131951927, 1).show();
                        ax.Ha.c.h().f().b("PVI:").l((Throwable)l).h();
                    }
                    else if (f2 == f.c0) {
                        final Fragment m = this.O().m();
                        if (m instanceof M) {
                            ((M)m).M2(c$a.c0, k, ((ax.c3.b)k).s(), false, false);
                        }
                    }
                    else {
                        final Fragment m2 = this.O().m();
                        if (m2 instanceof M) {
                            ((M)m2).M2(c$a.d0, k, ((ax.c3.b)k).s(), false, false);
                        }
                    }
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("PLAY VIDEO:");
                    sb.append(((Uri)l).toString());
                    sb.append(",fileinfo:");
                    sb.append((Object)((n)o2).R());
                    ax.Ha.c.h().f().b("NOT REACHABLE : IMAGE VIEWER").j().g((Object)sb.toString()).h();
                    Toast.makeText((Context)activity, 2131951927, 1).show();
                }
            }
        }
    }
    
    public ax.K0.c<Cursor> w(final int n, final Bundle bundle) {
        if (n == 100) {
            return (ax.K0.c<Cursor>)new e(this.O().b(), this.P);
        }
        return (ax.K0.c<Cursor>)super.w(n, bundle);
    }
    
    public ax.K0.c<ax.A3.b$a> z(final int n, final Bundle bundle, final String s) {
        if (n != 1) {
            if (n == 2) {
                return (ax.K0.c<ax.A3.b$a>)new ax.w3.f(this.O().b(), this.T, (n)null, s, true, false);
            }
            if (n != 3) {
                return (ax.K0.c<ax.A3.b$a>)super.z(n, bundle, s);
            }
        }
        return (ax.K0.c<ax.A3.b$a>)new ax.w3.f(this.O().b(), this.T, this.R0(s), s, false, bundle == null || bundle.getBoolean("use_factory_if_possible", true));
    }
    
    class d extends q<Void, Integer, Void>
    {
        int h;
        final b i;
        
        d(final b i, final int h) {
            this.i = i;
            super(q$e.e0);
            this.h = h;
        }
        
        private void w(final int n) {
            if (!this.isCancelled()) {
                final List k0 = this.i.U0();
                if (k0 != null && this.i.a1(n)) {
                    final n n2 = (n)k0.get(n);
                    if ((B.P(n2) || n2.P() == ax.Q2.f.b1) && ax.r3.d.l(this.i.O().b(), B.Y(n2)) == null) {
                        this.i.U.t(n2);
                    }
                }
            }
        }
        
        protected Void x(final Void... array) {
            if (b.J0(this.i)) {
                return null;
            }
            this.w(this.h - 1);
            this.w(this.h + 1);
            this.w(this.h - 2);
            this.w(this.h + 2);
            return null;
        }
    }
    
    public static class e extends ax.K0.b
    {
        ArrayList<n> w;
        
        public e(final Context context, final List<n> list) {
            super(context);
            final ArrayList w = new ArrayList();
            this.w = (ArrayList<n>)w;
            if (list != null) {
                w.addAll((Collection)list);
            }
        }
        
        public Cursor M() {
            return (Cursor)b.O0(this.w);
        }
    }
    
    private enum f
    {
        c0, 
        d0;
        
        private static final f[] e0;
        
        q;
        
        static {
            e0 = d();
        }
        
        private static /* synthetic */ f[] d() {
            return new f[] { f.q, f.c0, f.d0 };
        }
    }
}
