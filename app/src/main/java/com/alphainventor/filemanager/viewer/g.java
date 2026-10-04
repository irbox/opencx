package com.alphainventor.filemanager.viewer;

import java.util.AbstractCollection;
import ax.w3.k;
import java.util.Collections;
import java.util.ArrayList;
import ax.w3.j;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$F;
import android.view.View$OnClickListener;
import ax.w3.i;
import ax.S0.a;
import ax.P0.T;
import androidx.media3.ui.d;
import ax.P0.Q;
import java.util.List;
import ax.u3.b;
import ax.P0.v;
import ax.P0.V$a;
import ax.r7.z$a;
import ax.r7.z;
import ax.P0.V;
import androidx.recyclerview.widget.RecyclerView$h;
import ax.P0.H;
import android.widget.PopupWindow$OnDismissListener;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import ax.S0.d0;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView$p;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import ax.a2.f;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.PopupWindow;

public class g
{
    private final PopupWindow a;
    private final RecyclerView b;
    private final Context c;
    private final c d;
    private final e e;
    private final b f;
    private final ax.a2.f g;
    private final int h;
    private boolean i;
    private h j;
    
    g(final Context c, final c d) {
        this.c = c;
        this.d = d;
        this.h = c.getResources().getDimensionPixelSize(2131165382);
        this.e = new e(c, d);
        this.f = new b(c, d);
        this.g = new ax.a2.f(c.getResources());
        final RecyclerView b = (RecyclerView)LayoutInflater.from(this.g()).inflate(2131558531, (ViewGroup)null);
        (this.b = b).setLayoutManager((RecyclerView$p)new LinearLayoutManager(this.g()));
        final PopupWindow a = new PopupWindow((View)b, -2, -2, true);
        this.a = a;
        if (d0.a < 23) {
            a.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        }
        a.setOnDismissListener((PopupWindow$OnDismissListener)new PopupWindow$OnDismissListener(this) {
            final g a;
            
            public void onDismiss() {
            }
        });
    }
    
    private void e(final RecyclerView$h<?> adapter, final View view) {
        this.b.setAdapter((RecyclerView$h)adapter);
        this.p();
        this.i = false;
        this.a.dismiss();
        this.i = true;
        this.a.showAsDropDown(view, 0, -this.a.getHeight() - this.h - view.getHeight());
    }
    
    private z<f> f(final V v, final int n) {
        final z$a z$a = new z$a();
        final z a = v.a();
        for (int i = 0; i < ((List)a).size(); ++i) {
            final V$a v$a = (V$a)((List)a).get(i);
            if (v$a.d() == n) {
                for (int j = 0; j < v$a.a; ++j) {
                    if (v$a.j(j)) {
                        final v b = v$a.b(j);
                        if ((b.e & 0x2) == 0x0) {
                            z$a.h((Object)new f(v, i, j, this.g.a(b)));
                        }
                    }
                }
            }
        }
        return (z<f>)z$a.k();
    }
    
    private Context g() {
        return this.c;
    }
    
    private void j() {
        final H h = this.h();
        if (h == null) {
            ax.u3.b.g("player is null when init trackselectionadapter");
        }
        ((g)this.e).O();
        ((g)this.f).O();
        if (h != null && h.c0(30)) {
            if (h.c0(29)) {
                final V x = h.X();
                this.f.W((List<f>)this.f(x, 1));
                this.e.V((List<f>)this.f(x, 3));
            }
        }
    }
    
    private void m(final H h, final f f) {
        if (!h.c0(29)) {
            return;
        }
        h.w(h.k0().I().N(new Q(f.a.a(), (List)z.A((Object)f.b))).U(f.a.d(), false).F());
    }
    
    private void p() {
        final androidx.media3.ui.d i = this.i();
        ((View)this.b).measure(0, 0);
        this.a.setWidth(Math.min(((View)this.b).getMeasuredWidth(), ((View)i).getWidth() - this.h * 2));
        this.a.setHeight(Math.min(((View)i).getHeight() - this.h * 2, ((View)this.b).getMeasuredHeight()));
    }
    
    public void d() {
        this.i = false;
        this.a.dismiss();
        this.i = true;
    }
    
    protected H h() {
        return this.d.h();
    }
    
    protected androidx.media3.ui.d i() {
        return this.d.k();
    }
    
    public void k() {
        final H h = this.h();
        if (h == null) {
            return;
        }
        final z<f> f = this.f(h.X(), 3);
        if (((AbstractCollection)f).size() == 0) {
            ax.u3.b.g("no subtitle track");
            return;
        }
        if (((AbstractCollection)f).size() != 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("subtitle count : ");
            sb.append(((AbstractCollection)f).size());
            ax.u3.b.g(sb.toString());
        }
        this.m(h, (f)((List)f).get(0));
    }
    
    public void l() {
        final H h = this.h();
        if (h != null && h.c0(29)) {
            h.w(h.k0().I().G(3).M(-3).U(3, true).F());
        }
    }
    
    public void n(final View view) {
        this.e(this.f, view);
    }
    
    public void o(final View view, final h j) {
        this.e(this.e, view);
        this.j = j;
    }
    
    public void q() {
        this.j();
    }
    
    public final class b extends g
    {
        final g h;
        
        public b(final g h, final Context context, final c c) {
            this.h = h.super(context, c);
        }
        
        private boolean V(final T t) {
            for (int i = 0; i < super.d.size(); ++i) {
                if (t.D.containsKey((Object)((f)super.d.get(i)).a.a())) {
                    return true;
                }
            }
            return false;
        }
        
        public void R(final d d) {
            d.u.setText(2131952015);
            final H h = this.h.h();
            if (h == null) {
                return;
            }
            final boolean v = this.V(((H)ax.S0.a.e((Object)h)).k0());
            final View v2 = d.v;
            int visibility;
            if (v) {
                visibility = 4;
            }
            else {
                visibility = 0;
            }
            v2.setVisibility(visibility);
            d.a.setOnClickListener((View$OnClickListener)new i(this, h));
        }
        
        public void T(final String s) {
        }
        
        public void W(final List<f> d) {
            super.d = d;
        }
    }
    
    public interface c
    {
        H h();
        
        androidx.media3.ui.d k();
    }
    
    public static class d extends RecyclerView$F
    {
        public final TextView u;
        public final View v;
        
        public d(final View view) {
            super(view);
            if (d0.a < 26) {
                view.setFocusable(true);
            }
            this.u = (TextView)view.findViewById(2131362246);
            this.v = view.findViewById(2131362207);
        }
    }
    
    public final class e extends g
    {
        final g h;
        
        public e(final g h, final Context context, final c c) {
            this.h = h.super(context, c);
        }
        
        @Override
        public void Q(final d d, int visibility) {
            super.Q(d, visibility);
            if (visibility > 0) {
                final f f = (f)super.d.get(visibility - 1);
                final View v = d.v;
                if (f.a()) {
                    visibility = 0;
                }
                else {
                    visibility = 4;
                }
                v.setVisibility(visibility);
            }
        }
        
        public void R(final d d) {
            d.u.setText(2131952016);
            final int n = 0;
            while (true) {
                for (int i = 0; i < super.d.size(); ++i) {
                    if (((f)super.d.get(i)).a()) {
                        final boolean b = false;
                        final View v = d.v;
                        int visibility;
                        if (b) {
                            visibility = n;
                        }
                        else {
                            visibility = 4;
                        }
                        v.setVisibility(visibility);
                        d.a.setOnClickListener((View$OnClickListener)new j(this));
                        return;
                    }
                }
                final boolean b = true;
                continue;
            }
        }
        
        public void T(final String s) {
            if (this.h.j != null) {
                this.h.j.a(true);
            }
        }
        
        public void V(final List<f> d) {
            super.d = d;
        }
    }
    
    public static final class f
    {
        public final V$a a;
        public final int b;
        public final String c;
        
        public f(final V v, final int n, final int b, final String c) {
            this.a = (V$a)((List)v.a()).get(n);
            this.b = b;
            this.c = c;
        }
        
        public boolean a() {
            return this.a.i(this.b);
        }
    }
    
    public abstract class g extends RecyclerView$h<d>
    {
        protected List<f> d;
        protected Context e;
        protected c f;
        final com.alphainventor.filemanager.viewer.g g;
        
        protected g(final com.alphainventor.filemanager.viewer.g g, final Context e, final c f) {
            this.g = g;
            this.d = (List<f>)new ArrayList();
            this.e = e;
            this.f = f;
        }
        
        protected void O() {
            this.d = (List<f>)Collections.EMPTY_LIST;
        }
        
        protected Context P() {
            return this.e;
        }
        
        public void Q(final d d, int visibility) {
            final H h = this.g.h();
            if (h == null) {
                return;
            }
            if (visibility == 0) {
                this.R(d);
                return;
            }
            final List<f> d2 = this.d;
            final int n = 1;
            final f f = (f)d2.get(visibility - 1);
            final Object value = h.k0().D.get((Object)f.a.a());
            final int n2 = 0;
            if (value != null && f.a()) {
                visibility = n;
            }
            else {
                visibility = 0;
            }
            d.u.setText((CharSequence)f.c);
            final View v = d.v;
            if (visibility != 0) {
                visibility = n2;
            }
            else {
                visibility = 4;
            }
            v.setVisibility(visibility);
            d.a.setOnClickListener((View$OnClickListener)new k(this, h, f));
        }
        
        protected abstract void R(final d p0);
        
        public d S(final ViewGroup viewGroup, final int n) {
            return new d(LayoutInflater.from(this.P()).inflate(2131558533, viewGroup, false));
        }
        
        protected abstract void T(final String p0);
        
        public int l() {
            if (this.d.isEmpty()) {
                return 0;
            }
            return this.d.size() + 1;
        }
    }
    
    public interface h
    {
        void a(final boolean p0);
    }
}
