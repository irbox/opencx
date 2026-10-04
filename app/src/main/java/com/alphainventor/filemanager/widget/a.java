package com.alphainventor.filemanager.widget;

import android.widget.CompoundButton;
import android.widget.BaseAdapter;
import android.widget.Adapter;
import ax.u3.q$e;
import com.alphainventor.filemanager.file.J;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.AnimationDrawable;
import com.alphainventor.filemanager.file.y;
import ax.S4.c$a;
import ax.c3.C;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.content.res.Resources;
import android.widget.AdapterView;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import ax.t3.k;
import ax.x3.r;
import android.view.View$OnLongClickListener;
import android.view.ViewStub;
import android.view.View$OnClickListener;
import android.text.style.BackgroundColorSpan;
import android.text.SpannableString;
import ax.T2.h;
import android.widget.ImageView;
import android.widget.CheckBox;
import android.widget.TextView;
import ax.c3.C$a;
import ax.x3.p;
import android.graphics.Point;
import android.graphics.Canvas;
import android.view.View$DragShadowBuilder;
import ax.u3.u;
import ax.X2.Q;
import ax.t3.e;
import ax.c3.K;
import ax.Ha.c;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.Collection;
import ax.c3.d0;
import ax.c3.A;
import java.util.ArrayList;
import ax.t3.j;
import android.graphics.drawable.InsetDrawable;
import ax.u3.B;
import android.graphics.drawable.Drawable;
import ax.Q.b;
import java.util.List;
import ax.Q2.f;
import ax.x3.z;
import ax.r3.d;
import com.alphainventor.filemanager.file.o;
import android.content.Context;
import java.util.Set;
import java.util.Date;
import ax.Z2.q;
import java.util.TreeMap;
import android.widget.AdapterView$OnItemClickListener;
import android.content.res.ColorStateList;
import com.alphainventor.filemanager.file.n;
import android.widget.ArrayAdapter;

public class a extends ArrayAdapter<n>
{
    private static ColorStateList N;
    private static ColorStateList O;
    private int A;
    private int B;
    private boolean C;
    private AdapterView$OnItemClickListener D;
    private boolean E;
    private TreeMap<Integer, q> F;
    private boolean G;
    private Date H;
    private Date I;
    private String J;
    private boolean K;
    private int L;
    private Set<String> M;
    private final Object a;
    private Context b;
    private boolean c;
    private o d;
    private ax.r3.d e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private z m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private f s;
    private boolean t;
    private int u;
    private String v;
    private int w;
    private int x;
    private boolean y;
    private boolean z;
    
    public a(final Context b, final List<n> list, final o d, final ax.r3.d e, final int n, final z m, final boolean p8, final boolean e2) {
        final boolean b2 = false;
        super(b, 0, (List)list);
        this.a = new Object();
        this.h = false;
        this.i = false;
        this.j = false;
        this.o = false;
        this.p = false;
        this.F = (TreeMap<Integer, q>)new TreeMap();
        this.b = b;
        this.d = d;
        this.e = e;
        this.m = m;
        this.p = p8;
        final f s = d.S();
        this.s = s;
        this.E = e2;
        boolean t = false;
        Label_0135: {
            if (!ax.Q2.f.k0(s) && !ax.Q2.f.g0(this.s)) {
                t = b2;
                if (this.s != ax.Q2.f.t0) {
                    break Label_0135;
                }
            }
            t = true;
        }
        this.t = t;
        if (com.alphainventor.filemanager.widget.a.O == null) {
            com.alphainventor.filemanager.widget.a.O = ax.Q.b.d(b, 2131100722);
            com.alphainventor.filemanager.widget.a.N = ax.Q.b.d(b, 2131100723);
        }
        this.f0();
        this.o0(n);
        this.Y();
    }
    
    private boolean C0() {
        return this.f == 2;
    }
    
    private void K() {
        this.F.clear();
        n n = null;
        int i = 0;
        String s = null;
        int n2 = -1;
        int n3 = -1;
        while (i < ((Adapter)this).getCount()) {
            final n n4 = (n)((Adapter)this).getItem(i);
            String q = null;
            int n5 = 0;
            Label_0107: {
                if (n != null) {
                    q = s;
                    n5 = n3;
                    if (this.d0(n4, n)) {
                        break Label_0107;
                    }
                }
                if (n2 >= 0 && n3 >= 0) {
                    this.F.put((Object)n3, (Object)new q(n3, n2, s));
                }
                q = this.Q(n4);
                n5 = i;
            }
            n2 = i;
            ++i;
            n = n4;
            s = q;
            n3 = n5;
        }
        if (n2 >= 0 && n3 >= 0) {
            this.F.put((Object)n3, (Object)new q(n3, n2, s));
        }
    }
    
    private String Q(final n n) {
        if (n instanceof ax.c3.n) {
            return n.B();
        }
        final int r = this.r;
        if (r == 1) {
            return n.H(this.L);
        }
        if (r == 2) {
            return n.A();
        }
        return null;
    }
    
    private Drawable R(final n n, final boolean b, int f) {
        if (b) {
            if (this.a0(this.f)) {
                return ax.s3.b.i(this.getContext(), n.P());
            }
            return ax.s3.b.g(this.getContext(), n, f != 0, this.C0());
        }
        else {
            f = this.f;
            if (f == 2) {
                return n.M(this.getContext());
            }
            if (f == 10) {
                return (Drawable)new InsetDrawable(n.M(this.getContext()), ax.u3.B.e(this.getContext(), 4));
            }
            if (f != 12 && f != 16) {
                return n.Y(this.getContext());
            }
            return (Drawable)new InsetDrawable(n.M(this.getContext()), ax.u3.B.e(this.getContext(), 8));
        }
    }
    
    private int T() {
        final int f = this.f;
        if (f != 0 && f != 1) {
            if (f == 2) {
                return 2131558540;
            }
            if (f == 3) {
                return 2131558689;
            }
            if (f == 10) {
                return 2131558538;
            }
            if (f == 12 || f == 16) {
                return 2131558537;
            }
            if (f != 20) {
                return 0;
            }
        }
        if (this.q) {
            return 2131558547;
        }
        return 2131558542;
    }
    
    private void Y() {
        final f s = this.s;
        if (s == ax.Q2.f.F0) {
            this.q = true;
            this.r = 1;
            return;
        }
        if (s != ax.Q2.f.m1 && s != ax.Q2.f.n1) {
            this.q = false;
            this.r = 0;
            return;
        }
        this.q = true;
        this.r = 3;
    }
    
    private boolean Z() {
        final int f = this.f;
        return f == 2 || f == 16;
    }
    
    private boolean a0(final int n) {
        return n == 10 || n == 12 || n == 16;
    }
    
    private boolean b0(final n n) {
        final Set<String> m = this.M;
        return m != null && m.contains((Object)n.B());
    }
    
    private boolean c0(final long time, final long time2) {
        if (this.H == null) {
            this.H = new Date();
        }
        if (this.I == null) {
            this.I = new Date();
        }
        this.H.setTime(time);
        this.I.setTime(time2);
        return this.H.getYear() == this.I.getYear() && this.H.getMonth() == this.I.getMonth() && this.H.getDate() == this.I.getDate();
    }
    
    private boolean d0(final n n, final n n2) {
        if (n instanceof ax.c3.n) {
            ax.u3.b.d(this.r == 3);
            return ((ax.c3.n)n).z1() == ((ax.c3.n)n2).z1();
        }
        final int r = this.r;
        if (r == 1) {
            return this.c0(((ax.c3.b)n).q(), ((ax.c3.b)n2).q());
        }
        if (r == 2) {
            return n.A().equals((Object)n2.A());
        }
        ax.u3.b.f();
        return true;
    }
    
    public void A0() {
        this.L = ax.t3.j.g(this.b);
    }
    
    public boolean B0() {
        return this.G && this.q;
    }
    
    public void L() {
        this.h = false;
        this.i = false;
        this.k = 0L;
        this.l = 0L;
    }
    
    public int M(int n, final String s) {
        final int n2 = 0;
        int n3 = n;
        if (n < 0) {
            n3 = 0;
        }
        final Object a;
        monitorenter(a = this.a);
        n = n3;
    Label_0089_Outer:
        while (true) {
            int n4 = n2;
        Block_9_Outer:
            while (true) {
                Label_0083: {
                    try {
                        if (n >= ((Adapter)this).getCount()) {
                            break Label_0089;
                        }
                        final String b = ((n)((Adapter)this).getItem(n)).B();
                        if (b != null && b.toLowerCase().startsWith(s.toLowerCase())) {
                            monitorexit(a);
                            return n;
                        }
                        break Label_0083;
                    }
                    finally {
                        monitorexit(a);
                        Block_11: {
                            while (true) {
                                final String b2 = ((n)((Adapter)this).getItem(n4)).B();
                                iftrue(Label_0148:)(b2 == null || !b2.toLowerCase().startsWith(s.toLowerCase()));
                                break Block_11;
                                Label_0154: {
                                    monitorexit(a);
                                }
                                return -1;
                                iftrue(Label_0154:)(n4 >= n3 || n4 >= ((Adapter)this).getCount());
                                continue;
                            }
                            Label_0148: {
                                ++n4;
                            }
                            continue Block_9_Outer;
                            ++n;
                            continue Label_0089_Outer;
                        }
                        monitorexit(a);
                        return n4;
                    }
                }
                break;
            }
        }
    }
    
    public ArrayList<n> N() {
        final Object a;
        monitorenter(a = this.a);
        Label_0055: {
            try {
                final ArrayList list = new ArrayList();
                for (int i = 0; i < ((Adapter)this).getCount(); ++i) {
                    list.add((Object)((Adapter)this).getItem(i));
                }
                break Label_0055;
            }
            finally {
                monitorexit(a);
                monitorexit(a);
                final ArrayList list;
                return (ArrayList<n>)list;
            }
        }
    }
    
    public int O(final String s) {
        final Object a;
        monitorenter(a = this.a);
        int n = 0;
        while (true) {
            Label_0060: {
                try {
                    if (n >= ((Adapter)this).getCount()) {
                        break Label_0060;
                    }
                    final String b = ((n)((Adapter)this).getItem(n)).B();
                    if (b != null && b.equals((Object)s)) {
                        monitorexit(a);
                        return n;
                    }
                    break Label_0060;
                }
                finally {
                    monitorexit(a);
                    monitorexit(a);
                    return -1;
                    ++n;
                    continue;
                }
            }
            break;
        }
    }
    
    public ArrayList<n> P() {
        final ArrayList list = new ArrayList();
        final Object a;
        monitorenter(a = this.a);
        int n = 0;
        while (true) {
            Label_0064: {
                try {
                    if (n >= ((Adapter)this).getCount()) {
                        break Label_0064;
                    }
                    final n n2 = (n)((Adapter)this).getItem(n);
                    if (ax.c3.A.B(n2, true)) {
                        list.add((Object)n2);
                    }
                    break Label_0064;
                }
                finally {
                    monitorexit(a);
                    monitorexit(a);
                    return (ArrayList<n>)list;
                    ++n;
                    continue;
                }
            }
            break;
        }
    }
    
    public int S() {
        return this.g;
    }
    
    public q U(final int n) {
        final q q = (q)this.F.get((Object)n);
        if (q != null) {
            return q;
        }
        final Integer n2 = (Integer)this.F.floorKey((Object)n);
        if (n2 == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("position : ");
            sb.append(n);
            sb.append(":");
            sb.append(((Adapter)this).getCount());
            ax.u3.b.g(sb.toString());
            return null;
        }
        return (q)this.F.get((Object)n2);
    }
    
    public n V(final n n) {
        final String e = n.E();
        final Object a;
        monitorenter(a = this.a);
        while (true) {
            Label_0137: {
                try {
                    final String l = d0.l(e);
                    final int n2 = 0;
                    if (n2 >= ((Adapter)this).getCount()) {
                        break Label_0137;
                    }
                    final n n3 = (n)((Adapter)this).getItem(n2);
                    if (n3 == null || !n3.E().startsWith(l)) {
                        break Label_0137;
                    }
                    final String a2 = n3.A();
                    if (!ax.c3.A.R(a2)) {
                        break Label_0137;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append(l);
                    sb.append(".");
                    sb.append(a2);
                    if (n3.E().equals((Object)sb.toString())) {
                        monitorexit(a);
                        return n3;
                    }
                    break Label_0137;
                }
                finally {
                    monitorexit(a);
                    int n2 = 0;
                    ++n2;
                    continue;
                    monitorexit(a);
                    return null;
                }
            }
            break;
        }
    }
    
    public ax.r3.d W() {
        return this.e;
    }
    
    public boolean X(final String s) {
        final Object a;
        monitorenter(a = this.a);
        int n = 0;
        while (true) {
            Label_0088: {
                try {
                    if (n >= ((Adapter)this).getCount()) {
                        break Label_0088;
                    }
                    final String e = ((n)((Adapter)this).getItem(n)).E();
                    if (!((n)((Adapter)this).getItem(n)).P().W()) {
                        break Label_0088;
                    }
                    if (e.equalsIgnoreCase(s)) {
                        monitorexit(a);
                        return true;
                    }
                    break Label_0088;
                }
                finally {
                    monitorexit(a);
                    final String e;
                    iftrue(Label_0088:)(!e.equals((Object)s));
                    Block_6: {
                        break Block_6;
                        ++n;
                        continue;
                    }
                    monitorexit(a);
                    return true;
                    monitorexit(a);
                    return false;
                }
            }
            break;
        }
    }
    
    public void addAll(final Collection<? extends n> collection) {
        final Object a = this.a;
        synchronized (a) {
            super.addAll((Collection)collection);
            monitorexit(a);
            if (this.q) {
                this.K();
            }
        }
    }
    
    public void clear() {
        final Object a = this.a;
        synchronized (a) {
            super.clear();
            monitorexit(a);
            if (this.q) {
                this.K();
            }
        }
    }
    
    public boolean e0() {
        return this.c;
    }
    
    public void f0() {
        this.u = ax.Q.b.c(this.b, 2131100812);
        this.A = ax.Q.b.c(this.b, 2131100497);
        this.B = ax.u3.z.n(this.b);
    }
    
    public void g0(final boolean c) {
        this.C = c;
    }
    
    public View getView(final int n, View inflate, final ViewGroup viewGroup) {
        c tag;
        if (inflate == null) {
            inflate = LayoutInflater.from(this.b).inflate(this.T(), viewGroup, false);
            tag = new c(inflate, viewGroup);
            inflate.setTag((Object)tag);
        }
        else {
            tag = (c)inflate.getTag();
        }
        try {
            tag.y((n)((Adapter)this).getItem(n), n);
            return inflate;
        }
        catch (final IndexOutOfBoundsException ex) {
            ax.Ha.c.h().f().d("!! INDEX OUT OF BOUND !!").l((Throwable)ex).h();
            return inflate;
        }
    }
    
    public void h0(final long k, final long l) {
        this.h = true;
        this.i = true;
        this.k = k;
        this.l = l;
    }
    
    public void i0(final Set<String> m) {
        this.M = m;
    }
    
    public void j0(final boolean z) {
        this.z = z;
    }
    
    public void k0(final String j) {
        this.J = j;
    }
    
    public void l0(final String v) {
        this.v = v;
    }
    
    public void m0(final int g) {
        this.g = g;
    }
    
    public void n0(final boolean n) {
        this.n = n;
    }
    
    public void o0(final int f) {
        this.f = f;
        if (this.a0(f)) {
            this.x = ax.u3.B.e(this.getContext(), 1);
        }
        else {
            this.x = ax.u3.B.e(this.getContext(), 0);
        }
        ((BaseAdapter)this).notifyDataSetChanged();
    }
    
    public void p0(final AdapterView$OnItemClickListener d) {
        this.D = d;
    }
    
    public void q0(final boolean c) {
        final boolean b = this.c != c;
        this.c = c;
        if (b && !c) {
            ((BaseAdapter)this).notifyDataSetChanged();
        }
    }
    
    public void r0(final boolean q, final int r) {
        this.q = q;
        if (q) {
            this.r = r;
            this.K();
            return;
        }
        this.r = 0;
        this.F.clear();
    }
    
    public void s0(final boolean k) {
        this.K = k;
    }
    
    public void t0(final K k, final String s) {
        if (!ax.Q2.f.C0(k.d())) {
            this.y = true;
            return;
        }
        if (!ax.i3.a.e(this.getContext()).m()) {
            this.y = false;
            return;
        }
        if (!ax.t3.e.i(this.b, k.d(), k.b(), s, false)) {
            this.y = false;
            return;
        }
        this.y = true;
    }
    
    public void u0(final boolean g) {
        if (this.q) {
            this.G = g;
            return;
        }
        this.G = false;
    }
    
    public void v0() {
        this.i = true;
    }
    
    boolean w0() {
        return !this.z || !this.Z();
    }
    
    public void x0(final boolean j) {
        this.j = j;
    }
    
    public void y0(final boolean o) {
        this.o = o;
    }
    
    public boolean z0(final List<n> list, final View view, final int n, final int n2, final int n3) {
        if (!Q.M0()) {
            return false;
        }
        if (n >= ((Adapter)this).getCount()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("index : ");
            sb.append(n);
            sb.append(",count:");
            sb.append(((Adapter)this).getCount());
            ax.Q2.d.c("start darg", (Throwable)new Exception(sb.toString()));
            return false;
        }
        final n n4 = (n)((Adapter)this).getItem(n);
        if (n4 == null) {
            return false;
        }
        if (list == null) {
            return false;
        }
        if (view == null) {
            return false;
        }
        if (!ax.u3.u.a((List)list)) {
            return false;
        }
        ax.x3.p.a(view, ax.u3.u.b((List)list, n4), (View$DragShadowBuilder)new View$DragShadowBuilder(this, view, n2, n3) {
            final int a;
            final int b;
            final a c;
            
            public void onDrawShadow(final Canvas canvas) {
                canvas.drawColor(ax.x3.q.a(this.c.getContext(), 2131100494));
                super.onDrawShadow(canvas);
            }
            
            public void onProvideShadowMetrics(final Point point, final Point point2) {
                final View view = this.getView();
                if (view != null) {
                    point.set(view.getWidth(), view.getHeight());
                    point2.set(this.a, this.b);
                }
            }
        }, (Object)new ax.Z2.e(true), 257);
        return true;
    }
    
    public class c
    {
        private String A;
        private String B;
        private boolean C;
        private boolean D;
        private boolean E;
        private int F;
        private int G;
        private long H;
        private d I;
        private C$a J;
        private int K;
        private boolean L;
        private int M;
        private int N;
        private int O;
        final Runnable P;
        final a Q;
        private View a;
        private View b;
        private TextView c;
        private CheckBox d;
        private View e;
        private TextView f;
        private TextView g;
        private TextView h;
        private TextView i;
        private TextView j;
        private TextView k;
        private View l;
        private View m;
        private ImageView n;
        private ImageView o;
        private ImageView p;
        private ImageView q;
        private ImageView r;
        private ImageView s;
        private View t;
        private View u;
        private boolean v;
        private boolean w;
        private String x;
        private long y;
        private ax.c3.z z;
        
        public c(final a q, final View view, final ViewGroup viewGroup) {
            this.Q = q;
            this.K = -1;
            this.L = false;
            this.M = 0;
            this.P = (Runnable)new Runnable() {
                final c q;
                
                public void run() {
                    if (this.q.z == ax.c3.z.n0) {
                        this.q.L = true;
                        this.q.M = 2131231245;
                        this.q.r.setImageResource(2131231245);
                        this.q.r.setVisibility(0);
                        ((View)this.q.r).setBackgroundResource(0);
                        return;
                    }
                    if ("epub".equals((Object)this.q.A)) {
                        this.q.L = true;
                        this.q.M = 2131231244;
                        this.q.r.setImageResource(2131231244);
                        this.q.r.setVisibility(0);
                        ((View)this.q.r).setBackgroundResource(0);
                        return;
                    }
                    if (this.q.z != ax.c3.z.e0 && (this.q.B == null || !this.q.B.startsWith("video"))) {
                        if (this.q.z == ax.c3.z.f0 && ax.c3.A.O(this.q.A)) {
                            this.q.L = true;
                            this.q.M = 2131231246;
                            this.q.r.setImageResource(2131231246);
                            this.q.r.setVisibility(0);
                            ((View)this.q.r).setBackgroundResource(0);
                        }
                        return;
                    }
                    this.q.o.setVisibility(0);
                }
            };
            this.E(view, viewGroup);
        }
        
        private String B(final n n) {
            if (this.Q.f == 20 && ((ax.c3.b)n).isDirectory()) {
                final String v = d0.v(ax.T2.h.q(n.L()), n.E(), Boolean.TRUE);
                if (!ax.U2.d.Q(v)) {
                    return n.B();
                }
                final String g = ax.U2.d.g(v);
                final ax.U2.f x = ax.U2.d.F(this.Q.getContext()).x(g);
                if (x == null) {
                    return g;
                }
                return x.q();
            }
            else {
                if (this.Q.f != 12 || !((ax.c3.b)n).isDirectory()) {
                    return n.B();
                }
                if (this.F >= 0) {
                    return this.Q.getContext().getString(2131952236, new Object[] { n.B(), this.F });
                }
                return n.B();
            }
        }
        
        private CharSequence D(final n n) {
            final String b = this.B(n);
            if (b == null) {
                return null;
            }
            String f;
            if (this.Q.J != null && this.Q.J.equals((Object)n.B())) {
                f = b;
            }
            else {
                f = this.Q.v;
            }
            if (f != null) {
                final int index = b.toLowerCase().indexOf(f.toLowerCase());
                if (index >= 0) {
                    if (this.Q.w == 0) {
                        final a q = this.Q;
                        q.w = ax.Q.b.c(q.getContext(), 2131100781);
                    }
                    final SpannableString spannableString = new SpannableString((CharSequence)b);
                    spannableString.setSpan((Object)new BackgroundColorSpan(this.Q.w), index, f.length() + index, 0);
                    return (CharSequence)spannableString;
                }
            }
            return (CharSequence)b;
        }
        
        private void E(final View l, final ViewGroup viewGroup) {
            final View viewById = l.findViewById(2131362364);
            this.b = viewById;
            if (viewById != null) {
                this.c = (TextView)l.findViewById(2131362363);
                this.d = (CheckBox)l.findViewById(2131362362);
            }
            this.l = l;
            this.u = l.findViewById(2131362428);
            this.t = l.findViewById(2131362780);
            this.e = l.findViewById(2131362075);
            this.g = (TextView)l.findViewById(2131362304);
            this.m = l.findViewById(2131362384);
            this.n = (ImageView)l.findViewById(2131362383);
            this.o = (ImageView)l.findViewById(2131362472);
            this.p = (ImageView)l.findViewById(2131362326);
            this.q = (ImageView)l.findViewById(2131362824);
            this.r = (ImageView)l.findViewById(2131362908);
            this.s = (ImageView)l.findViewById(2131362458);
            final View i = this.l;
            if (i instanceof ActivatableFrameLayout) {
                ((ActivatableFrameLayout)i).setOnActivatedListener((ActivatableFrameLayout.a)new ActivatableFrameLayout.a(this) {
                    final c a;
                    
                    @Override
                    public void a(final boolean b) {
                        if (this.a.t != null) {
                            if (b) {
                                this.a.t.setVisibility(0);
                                return;
                            }
                            this.a.t.setVisibility(8);
                        }
                    }
                });
            }
            if (this.Q.m != null) {
                final boolean b = this.Q.p && (this.Q.f == 0 || this.Q.f == 1 || this.Q.f == 20 || this.Q.f == 3);
                if (this.b != null) {
                    final CheckBox d = this.d;
                    if (d != null) {
                        ((View)d).setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
                            final c c;
                            
                            public void a(final View view) {
                                this.c.Q.m.a(this.c.G);
                            }
                        });
                    }
                }
                if (b) {
                    final ViewStub viewStub = (ViewStub)l.findViewById(2131362905);
                    if (viewStub != null) {
                        final View inflate = viewStub.inflate();
                        inflate.setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
                            final c c;
                            
                            public void a(final View view) {
                                this.c.Q.m.b(this.c.G);
                            }
                        });
                        inflate.setOnLongClickListener((View$OnLongClickListener)new View$OnLongClickListener(this, viewGroup, inflate) {
                            final ViewGroup a;
                            final View b;
                            final c c;
                            
                            public boolean onLongClick(final View view) {
                                final ViewGroup a = this.a;
                                if (a instanceof r) {
                                    ((r)a).a();
                                }
                                this.c.Q.m.c(this.c.G, this.c.u, (int)this.b.getX(), (int)this.b.getY());
                                return true;
                            }
                        });
                        if (ax.Q2.p.a(this.Q.b)) {
                            inflate.setImportantForAccessibility(2);
                        }
                    }
                    final View viewById2 = l.findViewById(2131362187);
                    if (viewById2 != null) {
                        viewById2.setVisibility(8);
                    }
                }
                if (this.Q.E && ax.t3.k.J() && this.Q.f != 10) {
                    Object o = this.m;
                    if (o == null) {
                        o = this.n;
                    }
                    ((View)o).setContentDescription((CharSequence)this.Q.b.getString(2131951746));
                    ((View)o).setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
                        final c c;
                        
                        public void a(final View view) {
                            this.c.Q.m.b(this.c.G);
                        }
                    });
                    ((View)o).setOnLongClickListener((View$OnLongClickListener)new View$OnLongClickListener(this, viewGroup, o) {
                        final ViewGroup a;
                        final View b;
                        final c c;
                        
                        public boolean onLongClick(final View view) {
                            final ViewGroup a = this.a;
                            if (a instanceof FileListView) {
                                ((FileListView)a).a();
                            }
                            this.c.Q.m.c(this.c.G, this.c.u, (int)(this.b.getX() + this.b.getWidth() / 2.0f), (int)(this.b.getY() + this.b.getHeight() / 2.0f));
                            return true;
                        }
                    });
                    if (ax.Q2.p.a(this.Q.b)) {
                        ((View)o).setImportantForAccessibility(2);
                    }
                }
                if (!ax.Q2.p.a(this.Q.b)) {
                    this.u.setOnTouchListener((View$OnTouchListener)new View$OnTouchListener(this) {
                        final c a;
                        
                        public boolean onTouch(final View view, final MotionEvent motionEvent) {
                            if (motionEvent.getActionMasked() == 0) {
                                this.a.N = (int)motionEvent.getX();
                                this.a.O = (int)motionEvent.getY();
                            }
                            else if (motionEvent.getActionMasked() == 1) {
                                this.a.N = 0;
                                this.a.O = 0;
                            }
                            return false;
                        }
                    });
                    this.u.setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
                        final c c;
                        
                        public void a(final View view) {
                            if (this.c.Q.C) {
                                this.c.Q.m.b(this.c.G);
                                return;
                            }
                            this.c.Q.D.onItemClick((AdapterView)null, this.c.l, this.c.G, (long)this.c.G);
                        }
                    });
                    this.u.setOnLongClickListener((View$OnLongClickListener)new View$OnLongClickListener(this, viewGroup) {
                        final ViewGroup a;
                        final c b;
                        
                        public boolean onLongClick(final View view) {
                            final ViewGroup a = this.a;
                            if (a instanceof r) {
                                ((r)a).a();
                            }
                            this.b.Q.m.c(this.b.G, this.b.u, this.b.N, this.b.O);
                            return true;
                        }
                    });
                }
            }
            final int b2 = this.Q.f;
            Label_0857: {
                if (b2 != 0 && b2 != 1) {
                    if (b2 == 3) {
                        this.a = l.findViewById(2131361913);
                        this.h = (TextView)l.findViewById(2131362267);
                        this.i = (TextView)l.findViewById(2131362268);
                        this.k = (TextView)l.findViewById(2131362302);
                        this.f = (TextView)l.findViewById(2131362275);
                        break Label_0857;
                    }
                    if (b2 == 10) {
                        this.a = l.findViewById(2131361913);
                        this.k = (TextView)l.findViewById(2131362302);
                        break Label_0857;
                    }
                    if (b2 == 12) {
                        this.g.setMinLines(1);
                        this.g.setMaxLines(1);
                        break Label_0857;
                    }
                    if (b2 == 16) {
                        this.g.setMinLines(2);
                        this.g.setMaxLines(2);
                        break Label_0857;
                    }
                    if (b2 != 20) {
                        break Label_0857;
                    }
                }
                this.a = l.findViewById(2131361913);
                this.h = (TextView)l.findViewById(2131362267);
                this.i = (TextView)l.findViewById(2131362268);
                this.j = (TextView)l.findViewById(2131362272);
                this.k = (TextView)l.findViewById(2131362302);
                this.f = (TextView)l.findViewById(2131362275);
            }
            if (this.f != null) {
                if (this.Q.j) {
                    ((View)this.f).setVisibility(0);
                }
                else {
                    ((View)this.f).setVisibility(8);
                }
            }
            if (this.i != null) {
                if (this.Q.f == 1) {
                    ((View)this.i).setVisibility(0);
                    return;
                }
                ((View)this.i).setVisibility(8);
            }
        }
        
        private boolean F() {
            return this.K == 4;
        }
        
        private void G(final String text) {
            final TextView f = this.f;
            if (f != null) {
                f.setText((CharSequence)text);
            }
        }
        
        private void H(final ImageView imageView, final boolean b) {
            float alpha;
            if (b) {
                alpha = 0.5f;
            }
            else {
                alpha = 1.0f;
            }
            ((View)imageView).setAlpha(alpha);
        }
        
        private void I(final Resources resources, final View view, int n, final int n2) {
            if (this.F()) {
                n = resources.getDimensionPixelSize(n2);
            }
            else {
                n = resources.getDimensionPixelSize(n);
            }
            final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = n;
            layoutParams.width = n;
            view.setLayoutParams(layoutParams);
        }
        
        private void J(final Resources resources, final View view, int topMargin, final int n) {
            if (this.F()) {
                topMargin = resources.getDimensionPixelSize(n);
            }
            else {
                topMargin = resources.getDimensionPixelSize(topMargin);
            }
            final ViewGroup$MarginLayoutParams layoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
            layoutParams.topMargin = topMargin;
            view.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        }
        
        private void K(final n n, final boolean b) {
            C$a j;
            if (b) {
                j = ax.c3.C.c(n);
            }
            else {
                j = ax.c3.C.b(n);
            }
            if (j != null) {
                final int b2 = j.b;
                if (b2 != 0) {
                    if (b) {
                        this.O(b2);
                        return;
                    }
                    this.M(b2);
                }
                else {
                    final String[] a = j.a;
                    if (a != null) {
                        this.J = j;
                        for (int length = a.length, i = 0; i < length; ++i) {
                            if (this.P(a[i], b)) {
                                this.J = null;
                                return;
                            }
                        }
                    }
                }
            }
            else if (b) {
                this.O(2131231524);
            }
        }
        
        private void L(final n n, final boolean b, final c$a c$a) {
            boolean b2 = false;
            Label_0068: {
                if (this.Q.o) {
                    if (((y)n).X0()) {
                        this.r.setImageResource(2131231215);
                        this.r.setVisibility(0);
                        b2 = true;
                        break Label_0068;
                    }
                    this.r.setVisibility(8);
                }
                else {
                    this.r.setVisibility(8);
                }
                b2 = false;
            }
            if (this.L) {
                this.r.setVisibility(0);
                this.r.setImageResource(this.M);
                ((View)this.r).setBackgroundResource(0);
            }
            else {
                ((View)this.r).setBackgroundResource(2131230868);
            }
            if (c$a != null) {
                final int n2 = a$b.a[((Enum)c$a).ordinal()];
                if (n2 != 1) {
                    if (n2 == 2) {
                        final Drawable r = ax.U.a.r(ax.s3.a.c(this.Q.getContext(), 2131231131));
                        ax.U.a.o(r, com.alphainventor.filemanager.widget.a.O);
                        this.r.setVisibility(0);
                        this.r.setImageDrawable(r);
                        return;
                    }
                    if (n2 == 3) {
                        final AnimationDrawable animationDrawable = (AnimationDrawable)ax.s3.a.c(this.Q.getContext(), 2131231134);
                        final Drawable r2 = ax.U.a.r((Drawable)animationDrawable);
                        ax.U.a.o(r2, com.alphainventor.filemanager.widget.a.N);
                        animationDrawable.start();
                        this.r.setVisibility(0);
                        this.r.setImageDrawable(r2);
                    }
                }
                else if (!b2) {
                    this.r.setVisibility(8);
                }
            }
        }
        
        private void M(final int imageResource) {
            this.p.setImageResource(imageResource);
            ax.h0.e.c(this.p, ColorStateList.valueOf(this.Q.u));
            ((View)this.p).setPadding(this.Q.x, this.Q.x, this.Q.x, this.Q.x);
            this.p.setVisibility(0);
            this.v = true;
        }
        
        private void N(final String s) {
            final ax.U2.f x = ax.U2.d.F(this.Q.b).x(s);
            if (x != null) {
                this.p.setImageDrawable((Drawable)null);
                this.Q.W().s(x, this.p);
                ax.h0.e.c(this.p, (ColorStateList)null);
                this.p.setVisibility(0);
                ((View)this.p).setBackgroundDrawable((Drawable)null);
                ((View)this.p).setPadding(this.Q.x, this.Q.x, this.Q.x, this.Q.x);
                this.v = true;
            }
        }
        
        private void O(final int imageResource) {
            this.p.setImageResource(imageResource);
            ((View)this.p).setBackgroundResource(2131230868);
            this.p.setVisibility(0);
            this.v = true;
        }
        
        private boolean P(final String s, final boolean b) {
            final ax.U2.f x = ax.U2.d.F(this.Q.b).x(s);
            if (x != null) {
                if (this.Q.W().y(x, this.p)) {
                    ax.h0.e.c(this.p, (ColorStateList)null);
                    ((View)this.p).setBackgroundDrawable((Drawable)null);
                    ((View)this.p).setPadding(this.Q.x, this.Q.x, this.Q.x, this.Q.x);
                    this.p.setVisibility(0);
                    return this.v = true;
                }
                return false;
            }
            else {
                if (b) {
                    this.O(2131231524);
                    return true;
                }
                return false;
            }
        }
        
        private void s() {
            if (this.K != this.Q.g) {
                final Resources resources = this.l.getResources();
                this.K = this.Q.g;
                if (this.Q.f == 2) {
                    final ImageView p = this.p;
                    if (p != null) {
                        this.I(resources, (View)p, 2131165409, 2131165408);
                        this.J(resources, (View)this.p, 2131165407, 2131165406);
                    }
                }
                else if (this.Q.f != 1 && this.Q.f != 0) {
                    if (this.Q.f == 10) {
                        final View m = this.m;
                        if (m != null) {
                            this.I(resources, m, 2131165428, 2131165427);
                        }
                    }
                }
                else {
                    final View i = this.m;
                    if (i != null) {
                        this.I(resources, i, 2131165424, 2131165423);
                        int minimumHeight;
                        float n;
                        if (this.F()) {
                            minimumHeight = resources.getDimensionPixelSize(2131165425);
                            n = resources.getDimension(2131165416);
                        }
                        else {
                            minimumHeight = resources.getDimensionPixelSize(2131165426);
                            n = resources.getDimension(2131165417);
                        }
                        this.u.setMinimumHeight(minimumHeight);
                        this.g.setTextSize(0, n);
                    }
                    final ImageView p2 = this.p;
                    if (p2 != null) {
                        this.I(resources, (View)p2, 2131165421, 2131165420);
                        this.J(resources, (View)this.p, 2131165419, 2131165418);
                    }
                }
            }
        }
        
        private void u(final long n) {
            final View a = this.a;
            if (a != null) {
                final LayerDrawable layerDrawable = (LayerDrawable)a.getBackground().mutate();
                if (this.Q.h) {
                    if (this.Q.l > 0L) {
                        layerDrawable.getDrawable(0).mutate().setLevel((int)(n * 10000L / this.Q.l));
                    }
                    else {
                        layerDrawable.getDrawable(0).setLevel(0);
                    }
                    if (this.Q.k > 0L) {
                        layerDrawable.getDrawable(1).setLevel((int)(n * 10000L / this.Q.k));
                        return;
                    }
                    layerDrawable.getDrawable(1).setLevel(0);
                }
                else {
                    layerDrawable.getDrawable(0).setLevel(0);
                    layerDrawable.getDrawable(1).setLevel(0);
                }
            }
        }
        
        private void v(final n n) {
            if (((ax.c3.b)n).isDirectory()) {
                this.F = ((ax.c3.b)n).r(this.Q.n);
                if (((View)this.n).getTag() == null) {
                    if (this.F == 0 && ax.c3.B.P(n)) {
                        if (((y)n).S0()) {
                            this.n.setImageDrawable(this.Q.R(n, true, 1));
                            return;
                        }
                        this.n.setImageDrawable(this.Q.R(n, true, this.F));
                    }
                    else {
                        this.n.setImageDrawable(this.Q.R(n, true, this.F));
                    }
                }
            }
        }
        
        private void w(final n n) {
            if (this.Q.f == 12) {
                if (((ax.c3.b)n).isDirectory()) {
                    this.g.setText(this.D(n));
                }
            }
            else if (this.k != null) {
                if (((ax.c3.b)n).isDirectory()) {
                    if (this.Q.f == 10) {
                        if (this.F >= 0) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("(");
                            sb.append(this.F);
                            sb.append(")");
                            this.k.setText((CharSequence)new SpannableString((CharSequence)sb.toString()));
                            return;
                        }
                        this.k.setText((CharSequence)"");
                    }
                    else {
                        if (this.Q.i) {
                            final TextView k = this.k;
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(n.I(this.Q.n));
                            sb2.append(String.format(" (%s)", new Object[] { ax.c3.B.i(this.Q.getContext(), this.H) }));
                            k.setText((CharSequence)sb2.toString());
                            return;
                        }
                        this.k.setText((CharSequence)n.I(this.Q.n));
                    }
                }
                else {
                    this.k.setText((CharSequence)n.I(this.Q.n));
                }
            }
        }
        
        private void x(final n n, final boolean w, final long y, final boolean d) {
            this.w = w;
            this.y = y;
            this.z = n.G();
            this.A = d0.j(n.B());
            this.B = ((ax.c3.b)n).s();
            this.x = n.Q();
            this.C = ax.c3.A.q(n);
            this.D = d;
            this.o.setVisibility(8);
            this.J = null;
            if (this.v) {
                final ImageView p4 = this.p;
                if (p4 != null) {
                    p4.setVisibility(8);
                    this.Q.W().g(this.p);
                    this.v = false;
                }
            }
            this.Q.W().g(this.n);
            final d i = this.I;
            if (i != null) {
                i.e();
                this.I = null;
            }
            ((View)this.n).setTag((Object)null);
            this.H = 0L;
            this.L = false;
            final TextView g = this.g;
            if (g instanceof GridFilenameTextView) {
                if (w) {
                    ((GridFilenameTextView)g).setUseFilenameEllipsize(false);
                }
                else {
                    ((GridFilenameTextView)g).setUseFilenameEllipsize(true);
                }
            }
            int n2;
            if (!w) {
                n2 = (this.Q.W().z(n, this.n, this.P) ? 1 : 0);
            }
            else if (ax.Q2.f.m0(this.Q.s)) {
                final boolean b = (n2 = (this.Q.W().z(n, this.n, this.P) ? 1 : 0)) != 0;
                if (this.p != null) {
                    n2 = (b ? 1 : 0);
                    if (this.Q.t) {
                        this.K(n, true);
                        n2 = (b ? 1 : 0);
                    }
                }
            }
            else {
                n2 = ((((this.Q.s != ax.Q2.f.l1) ? (this.p != null && this.Q.t) : com.alphainventor.filemanager.file.a.U1(n)) && this.Q.W().z(n, this.n, this.P)) ? 1 : 0);
            }
            this.F = -1;
            if (n2 == 0) {
                this.n.setImageDrawable(this.Q.R(n, w, -1));
            }
            if (((ax.c3.b)n).l()) {
                this.q.setVisibility(0);
            }
            else {
                this.q.setVisibility(4);
            }
            if (this.g != null) {
                if (this.Q.w0()) {
                    ((View)this.g).setVisibility(0);
                    this.E = true;
                }
                else {
                    ((View)this.g).setVisibility(8);
                    this.E = false;
                }
            }
            this.H(this.n, ((ax.c3.b)n).h());
        }
        
        private void z(final n n, int i, final boolean b) {
            if (this.Q.i) {
                if (b) {
                    if (com.alphainventor.filemanager.file.J.g2(n)) {
                        this.H = ((ax.c3.b)n).p();
                    }
                    else {
                        this.H = ax.T2.h.T(n).E(n);
                    }
                }
                else {
                    this.H = ((ax.c3.b)n).p();
                }
            }
            this.u(this.H);
            c$a d;
            if (this.C) {
                d = ax.S4.c.d(this.Q.getContext(), n.Q());
            }
            else {
                d = null;
            }
            if (this.r != null) {
                this.L(n, b, d);
            }
            if (this.s != null) {
                if (!b && !ax.c3.B.P(n)) {
                    if (ax.c3.B.G(n.N(), n)) {
                        this.s.setImageResource(2131231213);
                        this.s.setVisibility(0);
                    }
                    else {
                        this.s.setVisibility(8);
                    }
                }
                else {
                    this.s.setVisibility(8);
                }
            }
            if (d != null && d != c$a.q) {
                this.g.setTextColor(this.Q.B);
            }
            else {
                this.g.setTextColor(this.Q.A);
            }
            boolean b2;
            if (ax.c3.B.P(n) && !((y)n).W0()) {
                b2 = true;
            }
            else {
                if (b) {
                    this.F = ((ax.c3.b)n).r(this.Q.n);
                }
                b2 = false;
            }
            Label_0397: {
                if (this.Q.i && n.P() == ax.Q2.f.l1) {
                    final TextView k = this.k;
                    if (k != null) {
                        k.setText((CharSequence)ax.c3.B.i(this.Q.getContext(), this.H));
                    }
                }
                else if (this.Q.i && com.alphainventor.filemanager.file.J.g2(n)) {
                    final TextView j = this.k;
                    if (j != null) {
                        j.setText((CharSequence)ax.c3.B.i(this.Q.getContext(), this.H));
                    }
                }
                else {
                    if (!b2) {
                        this.v(n);
                        this.w(n);
                    }
                    break Label_0397;
                }
                b2 = false;
            }
            this.g.setText(this.D(n));
            if (this.e != null) {
                if (this.Q.b0(n)) {
                    this.e.setVisibility(0);
                }
                else {
                    this.e.setVisibility(8);
                }
            }
            if (this.b != null) {
                if (this.Q.q) {
                    final q q = (q)this.Q.F.get((Object)i);
                    if (q != null && q.b() != null) {
                        this.b.setVisibility(0);
                        this.c.setText((CharSequence)q.b());
                    }
                    else {
                        this.b.setVisibility(8);
                    }
                    if (this.Q.G && q != null && q.e()) {
                        ((CompoundButton)this.d).setChecked(true);
                    }
                    else {
                        ((CompoundButton)this.d).setChecked(false);
                    }
                }
                else {
                    this.b.setVisibility(8);
                }
                if (this.Q.C && this.Q.G) {
                    ((View)this.d).setVisibility(0);
                }
                else {
                    ((View)this.d).setVisibility(8);
                }
            }
            if (n instanceof ax.c3.n) {
                if (((ax.c3.n)n).A1()) {
                    this.j.setText(2131952125);
                    ((View)this.j).setVisibility(0);
                }
                else {
                    ((View)this.j).setVisibility(8);
                }
            }
            if (this.Q.j) {
                this.G(this.C(n));
            }
            i = this.Q.f;
            if (i != 0) {
                if (i != 1) {
                    if (i != 3) {
                        if (i != 10) {
                            if (i == 20) {
                                ((View)this.h).setVisibility(8);
                            }
                        }
                        else if (b) {
                            ((View)this.k).setVisibility(0);
                        }
                        else {
                            ((View)this.k).setVisibility(4);
                        }
                    }
                    else {
                        this.h.setText((CharSequence)n.H(this.Q.L));
                        this.G(this.C(n));
                    }
                }
                else {
                    if (this.Q.K && n instanceof y) {
                        this.h.setText((CharSequence)((y)n).G0(this.Q.L));
                    }
                    else {
                        this.h.setText((CharSequence)n.H(this.Q.L));
                    }
                    this.i.setText((CharSequence)"");
                }
            }
            else {
                this.h.setText((CharSequence)"");
            }
            if (!this.Q.e0()) {
                if (((View)this.n).getTag() == null || !((View)this.n).getTag().equals(n.Q())) {
                    if (b && !ax.Q2.f.m0(this.Q.d.S())) {
                        if (this.Q.d.S() == ax.Q2.f.l1 && com.alphainventor.filemanager.file.a.U1(n)) {
                            this.Q.W().u(n, this.n, this.P);
                        }
                    }
                    else if (this.Q.y) {
                        this.Q.W().u(n, this.n, this.P);
                    }
                    else {
                        this.Q.W().x(n, this.n, this.P);
                    }
                }
                if (((View)this.n).getTag() == null && b && !ax.c3.B.P(n)) {
                    this.n.setImageDrawable(this.Q.R(n, true, this.F));
                }
                final C$a l = this.J;
                if (l != null) {
                    final String[] a = l.a;
                    if (a != null && this.p != null) {
                        int length;
                        for (length = a.length, i = 0; i < length; ++i) {
                            this.N(a[i]);
                        }
                        this.J = null;
                    }
                }
            }
            if (!b2) {
                return;
            }
            (this.I = new d(this, this.Q.d, this.Q.d.S(), n, this.Q.n, false, b2)).i((Object[])new Void[0]);
        }
        
        public String A() {
            return this.x;
        }
        
        String C(final n n) {
            final String s = d0.s(n);
            if ("/".equals((Object)s)) {
                return "/";
            }
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("/");
            return sb.toString();
        }
        
        public void t() {
            this.x = null;
        }
        
        public void y(final n n, final int g) {
            this.G = g;
            if (n == null) {
                return;
            }
            this.s();
            final boolean directory = ((ax.c3.b)n).isDirectory();
            final long q = ((ax.c3.b)n).q();
            final boolean h = ((ax.c3.b)n).h();
            final String x = this.x;
            if (x == null || !x.equals((Object)n.Q()) || this.w != directory || this.y != q || this.D != h || this.E != this.Q.w0()) {
                this.x(n, directory, q, h);
            }
            this.z(n, g, directory);
        }
    }
    
    static class d extends ax.u3.q<Void, Void, Void>
    {
        c h;
        n i;
        f j;
        boolean k;
        String l;
        boolean m;
        boolean n;
        o o;
        
        d(final c h, final o o, final f j, final n i, final boolean k, final boolean m, final boolean n) {
            super(q$e.e0);
            this.o = o;
            this.h = h;
            this.j = j;
            this.i = i;
            this.k = k;
            this.m = m;
            this.n = n;
        }
        
        protected Void w(final Void... array) {
            if (this.m && ax.c3.B.P(this.i)) {
                this.l = ((y)this.i).E0();
            }
            if (this.n) {
                if (((ax.c3.b)this.i).isDirectory()) {
                    if (ax.c3.B.P(this.i)) {
                        ((y)this.i).g1(this.k);
                    }
                }
                else {
                    ((ax.c3.b)this.i).p();
                }
            }
            return null;
        }
        
        protected void x(final Void void1) {
            if (this.i.Q().equals((Object)this.h.A())) {
                if (this.m) {
                    this.h.i.setText((CharSequence)this.l);
                }
                if (this.n) {
                    this.h.v(this.i);
                    this.h.w(this.i);
                }
            }
        }
    }
}
