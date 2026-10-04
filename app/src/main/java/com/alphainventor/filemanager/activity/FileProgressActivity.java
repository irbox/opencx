package com.alphainventor.filemanager.activity;

import androidx.fragment.app.f;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.os.Bundle;
import ax.T.b;
import android.os.SystemClock;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView;
import ax.g3.d;
import android.view.View;
import ax.s3.u;
import android.widget.ListAdapter;
import ax.W2.j;
import java.util.List;
import android.content.Context;
import android.widget.Toast;
import com.alphainventor.filemanager.service.CommandService$d;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.ServiceConnection;
import com.alphainventor.filemanager.service.CommandService;
import ax.x3.s;
import android.widget.TextView;
import android.widget.ListView;
import ax.R2.a;
import ax.R2.c;

public class FileProgressActivity extends c implements a
{
    private ListView a;
    private TextView b;
    private s c;
    private CommandService d;
    private long e;
    private boolean f;
    private ServiceConnection g;
    
    public FileProgressActivity() {
        this.g = (ServiceConnection)new ServiceConnection() {
            final FileProgressActivity q;
            
            public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
                if (!(binder instanceof CommandService$d)) {
                    String string;
                    if (binder == null) {
                        string = "service : null";
                    }
                    else {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("service :");
                        sb.append(binder.getClass().getName());
                        string = sb.toString();
                    }
                    ax.Ha.c.h().f().b("INVALID SERVICE CLASS").g((Object)string).h();
                    Toast.makeText((Context)this.q, 2131951927, 1).show();
                    ((Activity)this.q).finish();
                    return;
                }
                this.q.d = ((CommandService$d)binder).a();
                this.q.d.J(this.q);
                this.q.R();
                final FileProgressActivity q = this.q;
                final FileProgressActivity q2 = this.q;
                q.c = new s((Context)q2, (List<j>)q2.d.n());
                this.q.a.setAdapter((ListAdapter)this.q.c);
            }
            
            public void onServiceDisconnected(final ComponentName componentName) {
                this.q.d = null;
            }
        };
    }
    
    private void O() {
        this.f = true;
        ((Context)this).bindService(CommandService.j((Context)this, false), this.g, 1);
    }
    
    private void R() {
        final CommandService d = this.d;
        if (d != null) {
            d.G((a)this);
            u.j((Context)this).a(102);
        }
    }
    
    private void S() {
        this.a = (ListView)((ax.n.c)this).findViewById(2131362286);
        final TextView textView = (TextView)((ax.n.c)this).findViewById(2131362290);
        this.b = textView;
        ((AdapterView)this.a).setEmptyView((View)textView);
        ((AdapterView)this.a).setOnItemClickListener((AdapterView$OnItemClickListener)new d(this) {
            final FileProgressActivity c;
            
            public void a(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                this.c.T(n);
            }
        });
    }
    
    private void T(final int n) {
        final CommandService d = this.d;
        if (d != null) {
            if (n >= 0) {
                if (n < d.n().size()) {
                    this.d.I((a)this, (j)this.d.n().get(n), false);
                }
            }
        }
    }
    
    public void Q() {
        if (this.f) {
            this.f = false;
            final CommandService d = this.d;
            if (d != null) {
                d.H(this);
                ((Context)this).unbindService(this.g);
            }
        }
    }
    
    public void U() {
        ((Activity)this).runOnUiThread((Runnable)new Runnable(this) {
            final FileProgressActivity q;
            
            public void run() {
                if (this.q.c != null) {
                    ((BaseAdapter)this.q.c).notifyDataSetChanged();
                }
            }
        });
    }
    
    public void V(final j j, final int n, final boolean b) {
        final long uptimeMillis = SystemClock.uptimeMillis();
        if (!b && uptimeMillis - this.e <= 100L) {
            return;
        }
        this.e = uptimeMillis;
        ((Activity)this).runOnUiThread((Runnable)new Runnable(this, n, j) {
            final j c0;
            final FileProgressActivity d0;
            final int q;
            
            public void run() {
                final View child = ((ViewGroup)this.d0.a).getChildAt(this.q - ((AdapterView)this.d0.a).getFirstVisiblePosition());
                if (child != null) {
                    ((s.a)child.getTag()).a(this.c0, this.q);
                }
            }
        });
    }
    
    public boolean isContentClipToPadding(final boolean b) {
        return false;
    }
    
    public boolean n() {
        return ((f)this).getSupportFragmentManager().Q0();
    }
    
    public void onApplyWindowsInsets(final b b, final boolean b2) {
        if (!b2) {
            ((ViewGroup)this.a).setClipToPadding(false);
            final ListView a = this.a;
            ((View)a).setPadding(((View)a).getPaddingLeft(), ((View)this.a).getPaddingTop(), ((View)this.a).getPaddingRight(), b.d);
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        ((ax.n.c)this).setContentView(2131558430);
        ((Activity)this).getWindow().addFlags(128);
        this.S();
        this.onSetContentView(true);
        this.O();
    }
    
    protected void onDestroy() {
        this.Q();
        super.onDestroy();
    }
    
    protected void onResume() {
        super.onResume();
        this.R();
    }
    
    public ax.n.c s() {
        return (ax.n.c)this;
    }
}
