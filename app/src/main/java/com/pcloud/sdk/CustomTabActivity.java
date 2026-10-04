package com.pcloud.sdk;

import android.os.Bundle;
import android.content.IntentFilter;
import android.content.Context;
import ax.L0.a;
import android.os.Parcelable;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.app.Activity;

public class CustomTabActivity extends Activity
{
    private BroadcastReceiver a;
    
    protected void onActivityResult(final int n, final int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n2 == 0) {
            intent = new Intent("CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION");
            intent.putExtra("AuthorizationActivity.EXTRA_URL", (Parcelable)this.getIntent().getData());
            ax.L0.a.b((Context)this).d(intent);
            this.a = new BroadcastReceiver(this) {
                final CustomTabActivity a;
                
                public void onReceive(final Context context, final Intent intent) {
                    this.a.finish();
                }
            };
            ax.L0.a.b((Context)this).c(this.a, new IntentFilter("CustomTabActivity.DESTROY_ACTION"));
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = new Intent((Context)this, (Class)AuthorizationActivity.class);
        intent.setAction("CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION");
        intent.putExtra("AuthorizationActivity.EXTRA_URL", (Parcelable)this.getIntent().getData());
        intent.addFlags(603979776);
        this.startActivityForResult(intent, 1338);
    }
    
    protected void onDestroy() {
        ax.L0.a.b((Context)this).f(this.a);
        super.onDestroy();
    }
}
