package com.alphainventor.filemanager.widget;

import android.view.View;
import android.graphics.Canvas;
import ax.c0.F0$m;
import ax.c0.F0;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Paint;
import ax.T.b;
import android.widget.FrameLayout;

public class WindowInsetsFrameLayout extends FrameLayout
{
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private b j;
    private Paint k;
    
    public WindowInsetsFrameLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.d = -16777216;
        this.b();
    }
    
    public static int a(final b b) {
        if (b.a > 0) {
            return 3;
        }
        if (b.c > 0) {
            return 5;
        }
        if (b.b > 0) {
            return 48;
        }
        return 80;
    }
    
    private void b() {
        this.k = new Paint();
    }
    
    private void setCutoutGravity(final int c) {
        this.c = c;
    }
    
    private void setNavigationGravity(final int b) {
        this.b = b;
    }
    
    public void c(final int f, final int g, final int h, final int i) {
        ((View)this).setPadding(this.f = f, this.g = g, this.h = h, this.i = i);
    }
    
    public void d(final F0 f0, final boolean b) {
        final b f2 = f0.f(F0$m.h());
        final b f3 = f0.f(F0$m.b());
        final b a = b.a(f2, f3);
        final b f4 = f0.f(F0$m.f());
        b a2;
        if (!b) {
            this.c(a.a, a.b, a.c, 0);
            a2 = a;
        }
        else {
            a2 = b.a(a, f0.f(F0$m.c()));
            this.c(a2.a, a2.b, a2.c, a2.d);
        }
        this.setNavigationGravity(a(f4));
        this.setCutoutGravity(a(f3));
        this.j = a2;
    }
    
    public b getAppliedInsets() {
        return this.j;
    }
    
    protected void onDraw(final Canvas canvas) {
        this.k.setColor(this.a);
        if (this.g > 0) {
            canvas.drawRect(0.0f, 0.0f, (float)((View)this).getWidth(), (float)this.g, this.k);
        }
        this.k.setColor(this.e);
        if (this.i > 0) {
            canvas.drawRect(0.0f, (float)(((View)this).getHeight() - this.i), (float)((View)this).getWidth(), (float)((View)this).getHeight(), this.k);
        }
        final int f = this.f;
        if (f > 0 && this.b == 3) {
            canvas.drawRect(0.0f, 0.0f, (float)f, (float)((View)this).getHeight(), this.k);
        }
        if (this.h > 0 && this.b == 5) {
            canvas.drawRect((float)(((View)this).getWidth() - this.h), 0.0f, (float)((View)this).getWidth(), (float)((View)this).getHeight(), this.k);
        }
        this.k.setColor(this.d);
        final int f2 = this.f;
        if (f2 > 0 && this.c == 3) {
            canvas.drawRect(0.0f, 0.0f, (float)f2, (float)((View)this).getHeight(), this.k);
        }
        if (this.h > 0 && this.c == 5) {
            canvas.drawRect((float)(((View)this).getWidth() - this.h), 0.0f, (float)((View)this).getWidth(), (float)((View)this).getHeight(), this.k);
        }
    }
    
    public void setBottomAreaSize(final int i) {
        this.i = i;
        ((View)this).setPadding(((View)this).getPaddingLeft(), ((View)this).getPaddingTop(), ((View)this).getPaddingRight(), i);
    }
    
    public void setCutoutColor(final int d) {
        this.d = d;
    }
    
    public void setNavigationBarColor(final int e) {
        this.e = e;
        ((View)this).invalidate();
    }
    
    public void setStatusBarColor(final int a) {
        this.a = a;
        ((View)this).invalidate();
    }
}
