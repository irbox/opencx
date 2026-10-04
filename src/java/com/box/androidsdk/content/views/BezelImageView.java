package com.box.androidsdk.content.views;

import android.view.View;
import android.os.Build$VERSION;
import android.graphics.ColorFilter;
import android.annotation.TargetApi;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import android.graphics.ColorMatrix;
import android.graphics.Bitmap$Config;
import android.graphics.Xfermode;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable$Callback;
import ax.I3.e;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.RectF;
import android.graphics.Rect;
import android.graphics.Paint;
import android.widget.ImageView;

public class BezelImageView extends ImageView
{
    private Paint a;
    private Paint b;
    private Rect c;
    private RectF d;
    private Drawable e;
    private Drawable f;
    private ColorMatrixColorFilter g;
    private boolean h;
    private boolean i;
    private Bitmap j;
    private int k;
    private int l;
    
    public BezelImageView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public BezelImageView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.h = false;
        this.i = false;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, ax.I3.e.a, n, 0);
        final Drawable drawable = obtainStyledAttributes.getDrawable(ax.I3.e.d);
        this.f = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable$Callback)this);
        }
        final Drawable drawable2 = obtainStyledAttributes.getDrawable(ax.I3.e.b);
        if ((this.e = drawable2) != null) {
            drawable2.setCallback((Drawable$Callback)this);
        }
        this.h = obtainStyledAttributes.getBoolean(ax.I3.e.c, this.h);
        obtainStyledAttributes.recycle();
        (this.a = new Paint()).setColor(-16777216);
        (this.b = new Paint()).setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff$Mode.SRC_IN));
        this.j = Bitmap.createBitmap(1, 1, Bitmap$Config.ARGB_8888);
        if (this.h) {
            final ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            this.g = new ColorMatrixColorFilter(colorMatrix);
        }
    }
    
    private void a(final Canvas canvas) {
        canvas.saveLayer(this.d, this.b);
    }
    
    @SuppressLint({ "WrongConstant" })
    @TargetApi(21)
    private void b(final Canvas canvas) {
        canvas.saveLayer(this.d, this.b, 12);
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable e = this.e;
        if (e != null && e.isStateful()) {
            this.e.setState(((View)this).getDrawableState());
        }
        final Drawable f = this.f;
        if (f != null && f.isStateful()) {
            this.f.setState(((View)this).getDrawableState());
        }
        if (((View)this).isDuplicateParentStateEnabled()) {
            ((View)this).postInvalidateOnAnimation();
        }
    }
    
    public void invalidateDrawable(final Drawable drawable) {
        if (drawable != this.e && drawable != this.f) {
            super.invalidateDrawable(drawable);
            return;
        }
        ((View)this).invalidate();
    }
    
    protected void onDraw(final Canvas canvas) {
        final Rect c = this.c;
        if (c != null) {
            final int width = c.width();
            final int height = this.c.height();
            if (width != 0) {
                if (height != 0) {
                    if (!this.i || width != this.k || height != this.l) {
                        if (width == this.k && height == this.l) {
                            this.j.eraseColor(0);
                        }
                        else {
                            this.j.recycle();
                            this.j = Bitmap.createBitmap(width, height, Bitmap$Config.ARGB_8888);
                            this.k = width;
                            this.l = height;
                        }
                        final Canvas canvas2 = new Canvas(this.j);
                        if (this.f != null) {
                            final int save = canvas2.save();
                            this.f.draw(canvas2);
                            final Paint b = this.b;
                            Object g;
                            if (this.h && ((View)this).isPressed()) {
                                g = this.g;
                            }
                            else {
                                g = null;
                            }
                            b.setColorFilter((ColorFilter)g);
                            if (Build$VERSION.SDK_INT > 21) {
                                this.a(canvas2);
                            }
                            else {
                                this.b(canvas2);
                            }
                            super.onDraw(canvas2);
                            canvas2.restoreToCount(save);
                        }
                        else if (this.h && ((View)this).isPressed()) {
                            final int save2 = canvas2.save();
                            canvas2.drawRect(0.0f, 0.0f, (float)this.k, (float)this.l, this.a);
                            this.b.setColorFilter((ColorFilter)this.g);
                            if (Build$VERSION.SDK_INT > 21) {
                                this.a(canvas2);
                            }
                            else {
                                this.b(canvas2);
                            }
                            super.onDraw(canvas2);
                            canvas2.restoreToCount(save2);
                        }
                        else {
                            super.onDraw(canvas2);
                        }
                        final Drawable e = this.e;
                        if (e != null) {
                            e.draw(canvas2);
                        }
                    }
                    final Bitmap j = this.j;
                    final Rect c2 = this.c;
                    canvas.drawBitmap(j, (float)c2.left, (float)c2.top, (Paint)null);
                }
            }
        }
    }
    
    protected boolean setFrame(final int n, final int n2, final int n3, final int n4) {
        final boolean setFrame = super.setFrame(n, n2, n3, n4);
        this.c = new Rect(0, 0, n3 - n, n4 - n2);
        this.d = new RectF(this.c);
        final Drawable e = this.e;
        if (e != null) {
            e.setBounds(this.c);
        }
        final Drawable f = this.f;
        if (f != null) {
            f.setBounds(this.c);
        }
        if (setFrame) {
            this.i = false;
        }
        return setFrame;
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return drawable == this.e || drawable == this.f || super.verifyDrawable(drawable);
    }
}
