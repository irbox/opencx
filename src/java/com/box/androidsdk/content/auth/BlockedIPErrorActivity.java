package com.box.androidsdk.content.auth;

import android.view.View;
import android.view.View$OnClickListener;
import ax.I3.b;
import ax.I3.c;
import android.os.Bundle;
import android.app.Activity;

public class BlockedIPErrorActivity extends Activity
{
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(c.a);
        this.findViewById(b.n).setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final BlockedIPErrorActivity a;
            
            public void onClick(final View view) {
                this.a.finish();
            }
        });
    }
}
