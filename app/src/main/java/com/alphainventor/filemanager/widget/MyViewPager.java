package com.alphainventor.filemanager.widget;

import android.view.KeyEvent;
import android.util.AttributeSet;
import android.content.Context;
import androidx.viewpager.widget.ViewPager;

public class MyViewPager extends ViewPager
{
    private boolean l0;
    
    public MyViewPager(final Context context, final AttributeSet set) {
        super(context, set);
        this.l0 = true;
    }
    
    public void U(final boolean l0) {
        this.l0 = l0;
    }
    
    public boolean p(final KeyEvent keyEvent) {
        return this.l0 && super.p(keyEvent);
    }
}
