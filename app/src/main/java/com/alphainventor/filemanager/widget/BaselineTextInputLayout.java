package com.alphainventor.filemanager.widget;

import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import com.google.android.material.textfield.TextInputLayout;

public class BaselineTextInputLayout extends TextInputLayout
{
    public BaselineTextInputLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public int getBaseline() {
        return ((View)this).getPaddingTop() + ((View)this.getEditText()).getBaseline();
    }
}
