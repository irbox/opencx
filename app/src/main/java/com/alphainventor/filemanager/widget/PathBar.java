package com.alphainventor.filemanager.widget;

import ax.c3.B$a;
import java.io.File;
import ax.c3.d0;
import android.os.Looper;
import ax.u3.B;
import android.graphics.drawable.Drawable;
import ax.s3.b;
import ax.t3.k;
import com.alphainventor.filemanager.file.Q;
import ax.X2.P;
import ax.Ha.c;
import ax.Q2.a;
import android.view.View$OnClickListener;
import android.view.LayoutInflater;
import android.util.AttributeSet;
import android.content.Context;
import ax.Q2.f;
import ax.c3.K;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import ax.c3.k0;
import android.widget.FrameLayout;

public class PathBar extends FrameLayout
{
    private k0 A;
    private RelativeLayout a;
    private HorizontalScrollView b;
    private LinearLayout c;
    private ViewGroup d;
    private TextView e;
    private View f;
    private TextView g;
    private View h;
    private View i;
    private TextView j;
    private PieProgress k;
    private PathBar.PathBar$h l;
    private TextView m;
    private View n;
    private String o;
    private String p;
    private String q;
    private boolean r;
    private K s;
    private int t;
    private int u;
    private boolean v;
    private f w;
    private int x;
    private int y;
    private boolean z;
    
    public PathBar(final Context context, final AttributeSet set) {
        super(context, set);
        this.u = 0;
        this.v = false;
        this.z = true;
        this.k(context);
    }
    
    private void g(final String text, final String s, final boolean b) {
        final LayoutInflater layoutInflater = (LayoutInflater)((View)this).getContext().getSystemService("layout_inflater");
        ViewGroup viewGroup;
        if (this.u == 2) {
            viewGroup = (ViewGroup)layoutInflater.inflate(2131558663, (ViewGroup)this.c, false);
        }
        else {
            viewGroup = (ViewGroup)layoutInflater.inflate(2131558662, (ViewGroup)this.c, false);
        }
        final TextView textView = (TextView)((View)viewGroup).findViewById(2131361983);
        textView.setText((CharSequence)text);
        int textColor;
        if (b) {
            textColor = this.x;
        }
        else {
            textColor = this.y;
        }
        textView.setTextColor(textColor);
        ((View)textView).setOnClickListener((View$OnClickListener)new View$OnClickListener(this, s) {
            final String a;
            final PathBar b;
            
            public void onClick(final View view) {
                this.b.l.b(this.a);
                ax.Q2.a.i().m("navigation", "open_folder_back").c("loc", this.b.s.d().I()).c("by", "pathbar_directory").e();
            }
        });
        ((ViewGroup)this.c).addView((View)viewGroup);
    }
    
    private void j() {
        final TextView e = this.e;
        if (e != null) {
            ((View)e).setVisibility(8);
        }
        final View f = this.f;
        if (f != null) {
            f.setVisibility(8);
        }
    }
    
    private boolean l(final String s) {
        if (this.s.e() == null) {
            if (this.s.d() != ax.Q2.f.v0) {
                ax.Ha.c.h().f().d("ISROOT!! ROOTPATH NULL").g((Object)this.s.toString()).h();
            }
            return false;
        }
        return this.s.e().equals((Object)s);
    }
    
    private void m() {
        if (this.n != null) {
            if (this.l(this.q) && ax.Q2.f.w0(this.s.d())) {
                this.n.setVisibility(0);
                return;
            }
            this.n.setVisibility(8);
        }
    }
    
    private void n() {
        if (ax.Q2.f.T(this.s.d())) {
            if (this.l(this.q) && this.w == null && this.z && this.A != null) {
                this.i.setVisibility(0);
                return;
            }
            this.i.setVisibility(8);
        }
        else {
            if (this.s.d() == ax.Q2.f.F0) {
                this.i.setVisibility(0);
                if (P.b()) {
                    this.j.setText(2131952260);
                    final View i = this.i;
                    i.setContentDescription((CharSequence)i.getContext().getString(2131952260));
                }
                else {
                    this.j.setText(2131952248);
                    final View j = this.i;
                    j.setContentDescription((CharSequence)j.getContext().getString(2131952248));
                }
                this.k.setVisibility(8);
                return;
            }
            if (ax.Q2.f.v0(this.s.d())) {
                if (this.l(this.q)) {
                    final k0 a = this.A;
                    if (a != null && a.b != 0L) {
                        ((View)this.m).setVisibility(0);
                        return;
                    }
                }
                ((View)this.m).setVisibility(8);
                return;
            }
            if (ax.Q2.f.J0 == this.s.d()) {
                final k0 a2 = this.A;
                if (a2 != null && a2.b != 0L && Q.B0(this.q)) {
                    ((View)this.m).setVisibility(0);
                    return;
                }
                ((View)this.m).setVisibility(8);
            }
        }
    }
    
    private void o(final Context context, final View view) {
        final int paddingLeft = view.getPaddingLeft();
        final int paddingRight = view.getPaddingRight();
        final int paddingTop = view.getPaddingTop();
        final int paddingBottom = view.getPaddingBottom();
        view.setBackgroundDrawable(ax.s3.a.c(context, 2131230886));
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
    
    private void p(final String p2, final boolean b) {
        this.p = p2;
        if (ax.t3.k.b()) {
            this.h.setVisibility(8);
            return;
        }
        if (b) {
            this.h.setVisibility(0);
            return;
        }
        this.h.setVisibility(8);
    }
    
    private void q() {
        this.e.setCompoundDrawables(ax.s3.b.j(((View)this).getContext(), ax.Q2.f.l0, true), (Drawable)null, (Drawable)null, (Drawable)null);
        this.e.setCompoundDrawablePadding(0);
        ((View)this.e).setVisibility(0);
        ((View)this.e).setContentDescription((CharSequence)((View)this).getContext().getString(2131952162));
        final int u = this.u;
        if (u == 2 || u == 3) {
            this.f.setVisibility(0);
        }
        ((View)this.e).setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final PathBar a;
            
            public void onClick(final View view) {
                this.a.l.d("pathbar_home");
            }
        });
    }
    
    private void r() {
        this.e.setCompoundDrawables(ax.s3.b.j(((View)this).getContext(), this.w, true), (Drawable)null, (Drawable)null, (Drawable)null);
        this.e.setCompoundDrawablePadding(0);
        ((View)this.e).setContentDescription((CharSequence)this.w.M(((View)this).getContext()));
        ((View)this.e).setVisibility(0);
        final int u = this.u;
        if (u == 2 || u == 3) {
            this.f.setVisibility(0);
        }
        ((View)this.e).setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final PathBar a;
            
            public void onClick(final View view) {
                this.a.l.a("pathbar_home");
            }
        });
    }
    
    private void setAnalyzeButtonProgress(final float n) {
        this.j.setText((CharSequence)B.P(n));
        this.k.setProgressPercent((int)n);
    }
    
    private void t(final boolean b) {
        if (b.k(this.s.d(), (Object)null) > 0) {
            this.g.setCompoundDrawables(b.j(((View)this).getContext(), this.s.d(), b), (Drawable)null, (Drawable)null, (Drawable)null);
            if (b) {
                final String o = this.o;
                if (o != null && !"".equals((Object)o)) {
                    this.g.setCompoundDrawablePadding(0);
                }
                else {
                    this.g.setCompoundDrawablePadding(0);
                }
            }
            else {
                this.g.setText((CharSequence)"");
                this.g.setCompoundDrawablePadding(0);
            }
        }
        else {
            this.g.setText((CharSequence)this.o);
            final TextView g = this.g;
            int textColor;
            if (b) {
                textColor = this.x;
            }
            else {
                textColor = this.y;
            }
            g.setTextColor(textColor);
            this.g.setCompoundDrawablePadding(0);
        }
        ((View)this.g).setContentDescription((CharSequence)((View)this).getContext().getString(2131952134));
    }
    
    public int getParentButtonId() {
        return 2131362378;
    }
    
    public void h(final String q) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            ax.Ha.c.h().d("CD!!!").j().g((Object)this.s.toString()).h();
        }
        if (q != null) {
            ((ViewGroup)this.c).removeAllViews();
            ((ViewGroup)this.c).addView((View)this.d);
            if (this.s.e() != null) {
                final String v = d0.v(this.s, q, Boolean.TRUE);
                if (v == null) {
                    final ax.Ha.b j = ax.Ha.c.h().d("PTHBNU!!").j();
                    final StringBuilder sb = new StringBuilder();
                    sb.append(this.s.toString());
                    sb.append(":");
                    sb.append(this.s.e());
                    j.g((Object)sb.toString()).h();
                    return;
                }
                final String[] split = v.split(File.separator);
                if (split.length > 0 && this.r) {
                    this.g(split[split.length - 1], q, true);
                }
                else {
                    final StringBuilder sb2 = new StringBuilder(this.s.e());
                    for (int i = 0; i < split.length; ++i) {
                        final String s = split[i];
                        if (s.length() != 0) {
                            String s2;
                            if (sb2.toString().endsWith("/")) {
                                sb2.append(s);
                                s2 = sb2.toString();
                            }
                            else {
                                sb2.append(File.separator);
                                sb2.append(s);
                                s2 = sb2.toString();
                            }
                            this.g(s, s2, i == split.length - 1);
                        }
                    }
                }
                String s3;
                if (this.r) {
                    s3 = this.s.e();
                }
                else {
                    s3 = d0.r(q);
                }
                this.q = q;
                if (this.l(q)) {
                    if (ax.t3.k.K()) {
                        this.p(q, true);
                    }
                    else {
                        this.p(q, false);
                    }
                    this.t(true);
                }
                else {
                    this.p(s3, true);
                    this.t(false);
                }
                this.n();
                this.m();
                ((View)this).post((Runnable)new Runnable(this) {
                    final PathBar q;
                    
                    public void run() {
                        this.q.b.fullScroll(66);
                    }
                });
            }
        }
    }
    
    public void i() {
        this.A = null;
        this.n();
    }
    
    public void k(final Context context) {
        final LayoutInflater from = LayoutInflater.from(context);
        ((ViewGroup)this).addView((View)(this.a = (RelativeLayout)from.inflate(2131558661, (ViewGroup)this, false)));
        this.x = ax.Q.b.c(context, 2131100747);
        this.y = ax.Q.b.c(context, 2131100746);
        final HorizontalScrollView b = (HorizontalScrollView)((View)this.a).findViewById(2131362762);
        this.b = b;
        this.c = (LinearLayout)((View)b).findViewById(2131362057);
        final int k = ax.t3.k.k();
        this.t = k;
        final int o = ax.t3.k.o(k);
        this.u = o;
        if (o == 2) {
            this.d = (ViewGroup)from.inflate(2131558665, (ViewGroup)this.c, false);
        }
        else {
            this.d = (ViewGroup)from.inflate(2131558664, (ViewGroup)this.c, false);
        }
        this.e = (TextView)((View)this.d).findViewById(2131362378);
        this.f = ((View)this.d).findViewById(2131362745);
        this.q();
        ((View)(this.g = (TextView)((View)this.d).findViewById(2131362744))).setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final PathBar a;
            
            public void onClick(final View view) {
                ax.Q2.a.i().m("navigation", "open_folder_back").c("loc", this.a.s.d().I()).c("by", "pathbar_root").e();
                this.a.l.b(this.a.s.e());
            }
        });
        ((ViewGroup)this.c).addView((View)this.d);
        ((View)this.b).setHorizontalScrollBarEnabled(false);
        ((View)this.b).setHorizontalFadingEdgeEnabled(true);
        (this.i = ((View)this.a).findViewById(2131361985)).setOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final PathBar c;
            
            public void a(final View view) {
                this.c.l.e();
            }
        });
        final boolean b2 = context instanceof com.alphainventor.filemanager.activity.a;
        this.j = (TextView)((View)this.a).findViewById(2131361986);
        this.k = (PieProgress)((View)this.a).findViewById(2131362695);
        this.o(context, this.i);
        this.m = (TextView)((View)this.a).findViewById(2131362903);
        (this.h = ((View)this.a).findViewById(2131361989)).setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final PathBar a;
            
            public void onClick(final View view) {
                final PathBar a = this.a;
                if (a.l(a.q) && ax.t3.k.K()) {
                    this.a.l.a("pathbar_up");
                    return;
                }
                this.a.l.c(this.a.p);
                ax.Q2.a.i().m("navigation", "open_folder_back").c("loc", this.a.s.d().I()).c("by", "pathbar_up").e();
            }
        });
        this.p = "/";
    }
    
    public void s(final boolean z) {
        this.z = z;
        this.n();
    }
    
    public void setActionButtonEnabled(final boolean b) {
        for (int i = 0; i < ((ViewGroup)this.c).getChildCount(); ++i) {
            final View child = ((ViewGroup)this.c).getChildAt(i);
            if (child instanceof ViewGroup) {
                final View viewById = ((View)child).findViewById(2131361983);
                if (viewById != null) {
                    viewById.setEnabled(b);
                }
            }
        }
        this.e.setEnabled(b);
        this.g.setEnabled(b);
        ((View)this.b).setEnabled(b);
        if (b) {
            this.n();
        }
        else {
            this.i.setVisibility(8);
        }
        this.i.setEnabled(b);
        final View n = this.n;
        if (n != null) {
            if (b) {
                this.m();
            }
            else {
                n.setVisibility(8);
            }
            this.n.setEnabled(b);
        }
    }
    
    public void setIsArchiveFile(final boolean v) {
        this.v = v;
        if (v) {
            this.j();
        }
    }
    
    public void setIsTwoDepth(final boolean r) {
        this.r = r;
    }
    
    public void setLocationUnit(final K s) {
        this.s = s;
    }
    
    public void setParentLocation(final f w) {
        this.w = w;
        if (w != null) {
            this.r();
            return;
        }
        this.q();
    }
    
    public void setPathBarListener(final PathBar.PathBar$h l) {
        this.l = l;
    }
    
    public void setRootInfo(final String o) {
        this.o = o;
        this.t(true);
    }
    
    public void setRootTitle(final String o) {
        this.o = o;
    }
    
    public void setStorageSpace(k0 a) {
        if (a == null) {
            return;
        }
        this.A = a;
        if (ax.Q2.f.T(this.s.d())) {
            a = this.A;
            final long b = a.b;
            float analyzeButtonProgress;
            if (b != 0L) {
                analyzeButtonProgress = (float)(a.a * 100.0 / b);
            }
            else {
                analyzeButtonProgress = -1.0f;
            }
            this.setAnalyzeButtonProgress(analyzeButtonProgress);
        }
        else if (this.A.b != 0L) {
            final Context context = ((View)this).getContext();
            a = this.A;
            this.m.setText((CharSequence)ax.c3.B.m(context, a.b, a.a, B$a.d0));
        }
        else {
            this.m.setText((CharSequence)"");
        }
        this.n();
    }
}
