package com.alphainventor.filemanager.widget;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.FrameLayout;

public class ActivatableFrameLayout extends FrameLayout
{
    private a a;
    
    public ActivatableFrameLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public void setActivated(final boolean activated) {
        super.setActivated(activated);
        final a a = this.a;
        if (a != null) {
            a.a(activated);
        }
    }
    
    public void setOnActivatedListener(final a a) {
        this.a = a;
    }
    
    public interface a
    {
        void a(final boolean p0);
    }
}
