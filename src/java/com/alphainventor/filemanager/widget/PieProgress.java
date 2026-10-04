package com.alphainventor.filemanager.widget;

import android.content.res.TypedArray;
import android.graphics.Paint$Style;
import android.graphics.Canvas;
import android.graphics.Color;
import ax.Q2.n;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.Paint;
import android.view.View;

public class PieProgress extends View
{
    private Paint a;
    private RectF b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    
    public PieProgress(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public PieProgress(Context obtainStyledAttributes, final AttributeSet set, int d) {
        super(obtainStyledAttributes, set, d);
        this.d = -1;
        this.e = -1996488705;
        this.f = 0;
        obtainStyledAttributes = (Context)obtainStyledAttributes.getTheme().obtainStyledAttributes(set, n.D1, 0, 0);
        Label_0133: {
            Label_0104: {
                try {
                    this.f = ((TypedArray)obtainStyledAttributes).getDimensionPixelOffset(0, 0);
                    d = ((TypedArray)obtainStyledAttributes).getColor(1, -1);
                    this.d = d;
                    if (d == -1) {
                        this.e = -1996488705;
                        break Label_0104;
                    }
                }
                finally {
                    break Label_0133;
                }
                d = Color.alpha(d);
                this.e = (d / 2 << 24 | (this.d & 0xFFFFFF));
            }
            if (this.f > 0) {
                this.g = 1;
            }
            else {
                this.g = 2;
            }
            ((TypedArray)obtainStyledAttributes).recycle();
            this.a();
            return;
        }
        ((TypedArray)obtainStyledAttributes).recycle();
    }
    
    private void a() {
        (this.a = new Paint()).setAntiAlias(true);
        this.b = new RectF();
    }
    
    public void b(final int d, final int n) {
        this.d = d;
        this.e = ((d & 0xFFFFFF) | Color.alpha(d) / n << 24);
        this.invalidate();
    }
    
    protected void onDraw(final Canvas canvas) {
        canvas.save();
        int width = this.getWidth();
        final int n = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
        if (width >= n) {
            width = n;
        }
        final int paddingLeft = this.getPaddingLeft();
        final int paddingTop = this.getPaddingTop();
        final float n2 = this.f / 2.0f;
        if (this.g == 1) {
            this.b.set(paddingLeft + n2, paddingTop + n2, paddingLeft + width - n2, paddingTop + width - n2);
            this.a.setStyle(Paint$Style.STROKE);
            this.a.setStrokeWidth((float)this.f);
            this.a.setColor(this.e);
            canvas.drawArc(this.b, 0.0f, 360.0f, false, this.a);
            this.a.setColor(this.d);
            canvas.drawArc(this.b, -90.0f, (float)this.c, false, this.a);
        }
        else {
            final RectF b = this.b;
            final float n3 = (float)paddingLeft;
            final float n4 = (float)paddingTop;
            final float n5 = (float)(paddingLeft + width);
            final float n6 = (float)(paddingTop + width);
            b.set(n3, n4, n5, n6);
            this.a.setStyle(Paint$Style.FILL);
            this.a.setColor(this.e);
            canvas.drawCircle(this.b.centerX(), this.b.centerY(), this.b.width() / 2.0f, this.a);
            this.a.setColor(this.d);
            canvas.drawArc(this.b, -90.0f, (float)this.c, true, this.a);
            if (this.g == 3) {
                this.b.set(n3 + n2, n4 + n2, n5 - n2, n6 - n2);
                this.a.setStyle(Paint$Style.STROKE);
                this.a.setStrokeWidth((float)this.f);
                canvas.drawCircle(this.b.centerX(), this.b.centerY(), this.b.width() / 2.0f, this.a);
            }
        }
        canvas.restore();
    }
    
    public void setProgressAngle(final int c) {
        this.c = c;
        this.invalidate();
    }
    
    public void setProgressPercent(final int n) {
        this.c = n * 360 / 100;
        this.invalidate();
    }
    
    public void setStrokeWidth(final int f) {
        this.f = f;
        this.invalidate();
    }
    
    public void setStyle(final int g) {
        this.g = g;
        this.invalidate();
    }
}
