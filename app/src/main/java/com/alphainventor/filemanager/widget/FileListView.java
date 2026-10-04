package com.alphainventor.filemanager.widget;

import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import ax.x3.r;
import android.widget.ListView;

public class FileListView extends ListView implements r
{
    private boolean a;
    
    public FileListView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public void a() {
        this.a = true;
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(final View view, final int n, final AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfoForItem(view, n, accessibilityNodeInfo);
        if (accessibilityNodeInfo.isSelected()) {
            accessibilityNodeInfo.setSelected(false);
        }
        accessibilityNodeInfo.removeAction(AccessibilityNodeInfo$AccessibilityAction.ACTION_CLEAR_SELECTION);
        accessibilityNodeInfo.removeAction(AccessibilityNodeInfo$AccessibilityAction.ACTION_SELECT);
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        motionEvent.getAction();
        if (this.a) {
            final int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.a = false;
                    return true;
                }
                if (action == 2) {
                    return true;
                }
            }
            else {
                this.a = false;
            }
        }
        try {
            return super.onTouchEvent(motionEvent);
        }
        catch (final RuntimeException ex) {
            return false;
        }
    }
}
