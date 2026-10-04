package com.alphainventor.filemanager.widget;

import ax.u3.b;
import android.view.View$OnClickListener;
import android.view.MotionEvent;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.RelativeLayout;

public class BlockTouchRelativeLayout extends RelativeLayout
{
    public BlockTouchRelativeLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public boolean isClickable() {
        return false;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        return motionEvent.getAction() == 0 || super.onTouchEvent(motionEvent);
    }
    
    public void setOnClickListener(final View$OnClickListener onClickListener) {
        b.g("Set click listener on block touch view");
        super.setOnClickListener(onClickListener);
    }
}
