package com.alphainventor.filemanager.activity;

import androidx.activity.ComponentActivity;
import androidx.fragment.app.f;
import android.app.Activity;
import ax.Q2.a;
import androidx.fragment.app.t;
import android.view.View$OnClickListener;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import ax.d3.n0;
import android.os.Bundle;
import ax.T.b;
import ax.R2.c;

public class SettingsActivity extends c
{
    public boolean isContentClipToPadding(final boolean b) {
        return false;
    }
    
    public void onApplyWindowsInsets(final b b, final boolean b2) {
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        ((ax.n.c)this).setContentView(2131558437);
        this.onSetContentView(true);
        ((Activity)this).setTitle(2131952303);
        if (((f)this).getSupportFragmentManager().j0(2131362331) == null) {
            final t o = ((f)this).getSupportFragmentManager().o();
            o.r(2131362331, (Fragment)new n0());
            o.i();
        }
        ((Toolbar)((ax.n.c)this).findViewById(2131362981)).setNavigationOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final SettingsActivity c;
            
            public void a(final View view) {
                ((ComponentActivity)this.c).getOnBackPressedDispatcher().k();
            }
        });
    }
    
    protected void onStart() {
        super.onStart();
        a.i().q(this.getClass().getSimpleName());
    }
    
    protected void onStop() {
        super.onStop();
    }
}
