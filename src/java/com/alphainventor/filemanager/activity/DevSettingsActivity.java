package com.alphainventor.filemanager.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.app.Fragment;
import android.os.Bundle;
import ax.T.b;
import ax.R2.c;

public class DevSettingsActivity extends c
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
        ((Activity)this).setTitle(2131951801);
        final FragmentManager fragmentManager = ((Activity)this).getFragmentManager();
        final ax.t3.b b = new ax.t3.b();
        final FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(2131362331, (Fragment)b);
        beginTransaction.commit();
    }
}
