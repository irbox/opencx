package com.alphainventor.filemanager.widget;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import androidx.viewpager.widget.ViewPager;

public class NoChildScrollViewPager extends ViewPager
{
    private int l0;
    private float m0;
    
    public NoChildScrollViewPager(final Context context, final AttributeSet set) {
        super(context, set);
        this.U(context);
    }
    
    void U(final Context context) {
        this.l0 = ViewConfiguration.get(context).getScaledTouchSlop();
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        try {
            final boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            final float x = motionEvent.getX();
            final int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 2) {
                    if (Math.abs(x - this.m0) > this.l0) {
                        return true;
                    }
                }
                return onInterceptTouchEvent;
            }
            this.m0 = x;
            return onInterceptTouchEvent;
        }
        catch (final IllegalArgumentException ex) {
            return false;
        }
    }
}
