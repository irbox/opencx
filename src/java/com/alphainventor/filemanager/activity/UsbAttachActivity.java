package com.alphainventor.filemanager.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import ax.Q2.d;
import android.widget.Toast;
import ax.c3.u;
import android.os.SystemClock;
import android.content.Context;
import ax.X2.J;
import android.os.Bundle;
import ax.n.c;

public class UsbAttachActivity extends c
{
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (!J.u((Context)this) && SystemClock.elapsedRealtime() >= 300000L) {
            try {
                u.e0((Context)this);
            }
            catch (final ActivityNotFoundException ex) {
                Toast.makeText((Context)this, 2131952448, 1).show();
                d.b((Throwable)ex);
            }
            ((Activity)this).finish();
            return;
        }
        ((Activity)this).finish();
    }
}
