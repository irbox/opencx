package com.alphainventor.filemanager.activity;

import android.app.Activity;
import androidx.fragment.app.f;
import android.content.Context;
import ax.s3.u;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.e;
import ax.u3.B;
import ax.a3.k;
import ax.W2.h$b;
import android.content.Intent;
import android.content.DialogInterface$OnDismissListener;
import ax.n.c;

public class ResultActivity extends c implements DialogInterface$OnDismissListener
{
    public static String a = "COMMAND_RESULT";
    public static String b = "MESSAGE";
    public static String c = "SUB_MESSAGE";
    public static String d = "RESULT_INFO";
    
    private void F(final Intent intent) {
        if (!"com.filemanager.BRING_TO_FRONT".equals((Object)intent.getAction())) {
            if ((h$b)intent.getSerializableExtra(ResultActivity.a) == h$b.d0) {
                B.d0(((f)this).getSupportFragmentManager(), (e)k.i3(2131951894, intent.getStringExtra(ResultActivity.b), intent.getStringExtra(ResultActivity.c), intent.getStringArrayListExtra(ResultActivity.d)), "result", false);
            }
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = ((Activity)this).getIntent();
        if (((Activity)this).getIntent() == null) {
            ((Activity)this).finish();
            return;
        }
        if ((h$b)intent.getSerializableExtra(ResultActivity.a) != h$b.d0) {
            ((Activity)this).finish();
            return;
        }
        this.F(intent);
    }
    
    public void onDismiss(final DialogInterface dialogInterface) {
        ((Activity)this).finish();
    }
    
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.F(intent);
    }
    
    protected void onResume() {
        super.onResume();
        u.j((Context)this).a(104);
    }
}
