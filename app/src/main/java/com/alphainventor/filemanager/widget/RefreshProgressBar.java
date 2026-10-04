package com.alphainventor.filemanager.widget;

import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.view.animation.Interpolator;
import android.graphics.Canvas;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.graphics.drawable.GradientDrawable$Orientation;
import android.animation.TimeInterpolator;
import ax.Q.b;
import ax.Q2.n;
import ax.u3.B;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Paint;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

public class RefreshProgressBar extends View
{
    private final GradientDrawable a;
    final ValueAnimator b;
    private final Paint c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private int h;
    
    public RefreshProgressBar(final Context context, AttributeSet obtainStyledAttributes) {
        super(context, obtainStyledAttributes);
        final Paint c = new Paint();
        this.c = c;
        final float s = B.s(context);
        this.g = s;
        obtainStyledAttributes = (AttributeSet)context.obtainStyledAttributes(obtainStyledAttributes, n.T1);
        try {
            final int color = ((TypedArray)obtainStyledAttributes).getColor(0, ax.Q.b.c(context, 2131100772));
            this.d = color;
            this.e = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(1, Math.round(4.0f * s));
            this.f = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(2, Math.round(s * 3.0f));
            ((TypedArray)obtainStyledAttributes).recycle();
            final ValueAnimator b = new ValueAnimator();
            (this.b = b).setFloatValues(new float[] { 1.0f, 2.0f });
            b.setRepeatCount(-1);
            b.setInterpolator((TimeInterpolator)new b());
            c.setColor(color);
            this.a = new GradientDrawable(GradientDrawable$Orientation.TOP_BOTTOM, new int[] { (color & 0xFFFFFF) | 0x22000000, 0 });
        }
        finally {
            ((TypedArray)obtainStyledAttributes).recycle();
        }
    }
    
    private void a() {
        final ValueAnimator b = this.b;
        if (b != null) {
            if (!b.isStarted()) {
                this.b.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new ValueAnimator$AnimatorUpdateListener(this) {
                    final RefreshProgressBar a;
                    
                    public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                        this.a.invalidate();
                    }
                });
                this.b.start();
            }
        }
    }
    
    private void b() {
        final ValueAnimator b = this.b;
        if (b == null) {
            return;
        }
        b.cancel();
        this.b.removeAllUpdateListeners();
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b();
    }
    
    protected void onDraw(final Canvas canvas) {
        if (this.b.isStarted()) {
            this.a.draw(canvas);
            final float floatValue = (float)this.b.getAnimatedValue();
            final int width = this.getWidth();
            final int n = width >> this.h - 1;
            int n2;
            for (int i = 0; i < this.h; i = n2) {
                n2 = i + 1;
                final float n3 = (width >> n2) * floatValue;
                float n4;
                if (i == 0) {
                    n4 = (float)(width + n);
                }
                else {
                    n4 = 2.0f * n3;
                }
                final float n5 = (float)this.f;
                final float n6 = (float)n;
                canvas.drawRect(n3 + n5 - n6, 0.0f, n4 - n6, (float)this.e, this.c);
            }
        }
    }
    
    protected void onLayout(final boolean b, int width, final int n, final int n2, final int n3) {
        if (b) {
            width = this.getWidth();
            ((Drawable)this.a).setBounds(0, this.e, width, this.getHeight() - this.e);
            final float n4 = width / this.g / 320.0f - 1.0f;
            this.b.setDuration((long)(int)((0.3f * n4 + 1.0f) * 1500.0f));
            this.h = (int)((n4 * 0.1f + 1.0f) * 5.0f);
        }
    }
    
    protected void onVisibilityChanged(final View view, final int n) {
        super.onVisibilityChanged(view, n);
        if (n == 0) {
            if (this.getVisibility() == 0) {
                this.a();
            }
            return;
        }
        this.b();
    }
    
    protected void onWindowVisibilityChanged(final int n) {
        super.onWindowVisibilityChanged(n);
    }
    
    private static class b implements Interpolator
    {
        public float getInterpolation(final float n) {
            return (float)Math.pow(2.0, (double)n) - 1.0f;
        }
    }
}
