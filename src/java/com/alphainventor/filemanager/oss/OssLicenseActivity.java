package com.alphainventor.filemanager.oss;

import android.widget.Adapter;
import android.os.BaseBundle;
import android.app.Activity;
import androidx.fragment.app.f;
import android.widget.ArrayAdapter;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.text.Spannable;
import android.text.util.Linkify;
import android.text.SpannableString;
import android.content.ActivityNotFoundException;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import ax.c3.u;
import android.net.Uri;
import android.content.Intent;
import android.view.View$OnClickListener;
import android.widget.TextView;
import android.view.ViewGroup;
import androidx.appcompat.app.a$a;
import android.view.LayoutInflater;
import android.app.Dialog;
import ax.a3.I;
import android.os.Bundle;
import ax.T.b;
import androidx.fragment.app.e;
import ax.u3.B;
import android.widget.ListAdapter;
import java.util.List;
import android.content.Context;
import ax.Q2.h;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import ax.k3.a;
import android.widget.ListView;
import ax.R2.c;

public class OssLicenseActivity extends ax.R2.c
{
    private ListView a;
    
    private void H() {
        ((AdapterView)(this.a = (ListView)((ax.n.c)this).findViewById(2131362452))).setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener(this) {
            final OssLicenseActivity a;
            
            public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                this.a.I((a)adapterView.getAdapter().getItem(n));
            }
        });
        this.a.setAdapter((ListAdapter)new c((Context)this, (List<a>)h.a()));
    }
    
    private void I(final a a) {
        B.d0(((f)this).getSupportFragmentManager(), (e)b.j3(a), "OSS", true);
    }
    
    public boolean isContentClipToPadding(final boolean b) {
        return false;
    }
    
    public void onApplyWindowsInsets(final ax.T.b b, final boolean b2) {
        if (!b2) {
            ((ViewGroup)this.a).setClipToPadding(false);
            ((View)this.a).setPadding(0, 0, 0, b.d);
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        ((ax.n.c)this).setContentView(2131558433);
        ((Activity)this).setTitle(2131952467);
        this.H();
        this.onSetContentView(true);
    }
    
    public static class b extends I
    {
        private String t0;
        private String u0;
        
        static b j3(final a a) {
            final b b = new b();
            final Bundle bundle = new Bundle();
            ((BaseBundle)bundle).putString("PROJECT", a.q);
            ((BaseBundle)bundle).putString("URL", a.c0);
            ((Fragment)b).v2(bundle);
            return b;
        }
        
        public void f3() {
            super.f3();
            final Bundle j0 = ((Fragment)this).j0();
            if (j0 != null) {
                this.t0 = ((BaseBundle)j0).getString("URL");
                this.u0 = ((BaseBundle)j0).getString("PROJECT");
            }
        }
        
        public Dialog g3() {
            final LayoutInflater from = LayoutInflater.from(((Fragment)this).b());
            final a$a a$a = new a$a(((Fragment)this).b());
            final View inflate = from.inflate(2131558514, (ViewGroup)null, false);
            final TextView textView = (TextView)inflate.findViewById(2131362944);
            ((View)textView).setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
                final b a;
                
                public void onClick(final View view) {
                    if (((Fragment)this.a).b() != null) {
                        try {
                            final Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(this.a.t0));
                            u.p0((Fragment)this.a, intent);
                        }
                        catch (final ActivityNotFoundException | SecurityException ex) {
                            Toast.makeText(((Fragment)this.a).b(), 2131951927, 1).show();
                        }
                    }
                }
            });
            a$a.setTitle((CharSequence)this.u0);
            final SpannableString text = new SpannableString((CharSequence)this.t0);
            Linkify.addLinks((Spannable)text, 1);
            textView.setText((CharSequence)text);
            a$a.setView(inflate);
            a$a.b(true);
            a$a.setPositiveButton(17039370, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(this) {
                final b a;
                
                public void onClick(final DialogInterface dialogInterface, final int n) {
                }
            });
            return (Dialog)a$a.create();
        }
    }
    
    private static class c extends ArrayAdapter<a>
    {
        c(final Context context, final List<a> list) {
            super(context, 0, (List)list);
        }
        
        public View getView(final int n, View inflate, final ViewGroup viewGroup) {
            inflate = LayoutInflater.from(this.getContext()).inflate(2131558574, (ViewGroup)null, false);
            ((TextView)inflate.findViewById(2131362445)).setText((CharSequence)((a)((Adapter)this).getItem(n)).q);
            return inflate;
        }
    }
}
