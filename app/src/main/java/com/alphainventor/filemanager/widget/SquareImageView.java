package com.alphainventor.filemanager.widget;

import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;

public class SquareImageView extends AppCompatImageView
{
    public SquareImageView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        ((View)this).setMeasuredDimension(((View)this).getMeasuredWidth(), ((View)this).getMeasuredWidth());
    }
}
