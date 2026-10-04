package com.alphainventor.filemanager.widget;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;

public class ActivatableLinearLayout extends LinearLayout
{
    public ActivatableLinearLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public void setActivated(final boolean activated) {
        super.setActivated(activated);
    }
    
    public void setOnActivatedListener(final a a) {
    }
    
    public interface a
    {
    }
}
