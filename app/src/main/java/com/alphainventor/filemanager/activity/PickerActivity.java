package com.alphainventor.filemanager.activity;

import android.app.Activity;
import android.widget.Toast;
import ax.Q2.d;
import android.content.Context;
import ax.c3.u;
import android.os.Bundle;
import android.content.Intent;
import ax.n.c;

public class PickerActivity extends c
{
    private Intent F(final Intent intent, final String s) {
        final Intent intent2 = new Intent(intent);
        if ("com.discord".equals((Object)s) && "android.intent.action.PICK".equals((Object)intent.getAction()) && "image/*".equals((Object)intent.getType())) {
            intent2.setType("*/*");
        }
        return intent2;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = ((Activity)this).getIntent();
        final String callingPackage = ((Activity)this).getCallingPackage();
        final String action = intent.getAction();
        try {
            final Intent f = this.F(intent, callingPackage);
            if ("android.intent.action.GET_CONTENT".equals((Object)action)) {
                try {
                    u.b0((Context)this, f, callingPackage);
                }
                catch (final SecurityException ex) {
                    d.c("picker security", (Throwable)ex);
                    Toast.makeText((Context)this, 2131951927, 1).show();
                }
            }
            else if ("android.intent.action.OPEN_DOCUMENT".equals((Object)action)) {
                u.b0((Context)this, f, callingPackage);
            }
            else if ("android.intent.action.PICK".equals((Object)action)) {
                u.b0((Context)this, f, callingPackage);
            }
            else if (!"android.intent.action.RINGTONE_PICKER".equals((Object)intent.getAction())) {
                if ("android.intent.action.CREATE_SHORTCUT".equals((Object)action)) {
                    try {
                        u.b0((Context)this, f, callingPackage);
                    }
                    catch (final SecurityException ex2) {
                        d.c("picker security", (Throwable)ex2);
                        Toast.makeText((Context)this, 2131951927, 1).show();
                    }
                }
            }
        }
        catch (final IllegalArgumentException ex3) {
            Toast.makeText((Context)this, 2131951927, 1).show();
        }
        ((Activity)this).finish();
    }
}
