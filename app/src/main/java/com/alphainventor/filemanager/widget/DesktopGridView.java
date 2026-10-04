package com.alphainventor.filemanager.widget;

import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.GridView;

public class DesktopGridView extends GridView
{
    public DesktopGridView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(final View view, final int n, final AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfoForItem(view, n, accessibilityNodeInfo);
        if (accessibilityNodeInfo.isSelected()) {
            accessibilityNodeInfo.setSelected(false);
        }
        accessibilityNodeInfo.removeAction(AccessibilityNodeInfo$AccessibilityAction.ACTION_CLEAR_SELECTION);
        accessibilityNodeInfo.removeAction(AccessibilityNodeInfo$AccessibilityAction.ACTION_SELECT);
    }
}
