package com.alphainventor.filemanager.widget;

import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;

public class CheckedActivatedLinearLayout extends LinearLayout
{
    private static final int[] a;
    
    static {
        a = new int[] { 16842912 };
    }
    
    public CheckedActivatedLinearLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState;
        for (onCreateDrawableState = super.onCreateDrawableState(i + 1), i = 0; i < onCreateDrawableState.length; ++i) {
            if (onCreateDrawableState[i] == 16843518) {
                View.mergeDrawableStates(onCreateDrawableState, CheckedActivatedLinearLayout.a);
            }
        }
        return onCreateDrawableState;
    }
}
