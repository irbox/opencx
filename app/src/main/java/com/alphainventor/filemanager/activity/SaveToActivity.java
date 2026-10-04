package com.alphainventor.filemanager.activity;

import android.app.Activity;
import ax.c3.u;
import android.widget.Toast;
import java.util.List;
import ax.u3.q$e;
import ax.u3.q;
import android.content.Intent;
import android.content.Context;
import ax.X2.Q;
import android.os.Bundle;
import android.net.Uri;
import ax.Q2.g;
import android.view.View;
import java.util.logging.Logger;
import ax.n.c;

public class SaveToActivity extends c
{
    private static final Logger b;
    View a;
    
    static {
        b = g.a((Class)SaveToActivity.class);
    }
    
    private Uri F() {
        return ax.R2.g.a(this);
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = ((Activity)this).getIntent();
        final String action = intent.getAction();
        if (!"android.intent.action.SEND".equals((Object)action) && !"android.intent.action.SEND_MULTIPLE".equals((Object)action)) {
            ((Activity)this).finish();
            return;
        }
        this.setContentView(2131558439);
        this.a = this.findViewById(2131362712);
        Uri f;
        if (Q.y1()) {
            f = this.F();
        }
        else {
            f = null;
        }
        new a((Context)this, intent, f).i((Object[])new Void[0]);
    }
    
    private class a extends q<Void, Void, Boolean>
    {
        Intent h;
        Context i;
        Uri j;
        final SaveToActivity k;
        
        a(final SaveToActivity k, final Context i, final Intent h, final Uri j) {
            this.k = k;
            super(q$e.d0);
            this.i = i;
            this.h = h;
            this.j = j;
        }
        
        protected void r() {
            final View a = this.k.a;
            if (a != null) {
                a.setVisibility(0);
            }
        }
        
        protected Boolean w(final Void... array) {
            final List b = ax.W2.g.b((Context)this.k, this.h, this.j);
            if (b.size() > 0) {
                ax.W2.c.q().n(b);
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        
        protected void x(final Boolean b) {
            final View a = this.k.a;
            if (a != null) {
                a.setVisibility(8);
            }
            if (b != null) {
                if (!b) {
                    Toast.makeText(this.i, 2131951934, 1).show();
                }
                else {
                    u.c0(this.i);
                }
            }
            ((Activity)this.k).finish();
        }
    }
}
