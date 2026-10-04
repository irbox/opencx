package com.alphainventor.filemanager.activity;

import android.app.Activity;
import android.content.Context;
import ax.R2.f;
import android.os.Handler;
import android.os.Looper;
import android.os.Bundle;
import android.content.Intent;
import android.os.Process;
import ax.n.c;

public class RestartActivity extends c
{
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final int intExtra = ((Activity)this).getIntent().getIntExtra("pid", -1);
        final int myPid = Process.myPid();
        if (intExtra > 0 && intExtra != myPid) {
            Process.killProcess(intExtra);
        }
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new f(this, myPid), 150L);
    }
}
