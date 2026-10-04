package com.alphainventor.filemanager.viewer;

import android.widget.Adapter;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;
import ax.u3.b;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import java.util.List;
import android.widget.ArrayAdapter;

public class d extends ArrayAdapter<a>
{
    static List<a> b;
    LayoutInflater a;
    
    public d(final Context context) {
        super(context, 0, (List)b());
        this.a = LayoutInflater.from(this.getContext());
    }
    
    static List<a> b() {
        if (d.b == null) {
            (d.b = (List<a>)new ArrayList()).add((Object)new a("0.25X", 0.25f));
            d.b.add((Object)new a("0.5X", 0.5f));
            d.b.add((Object)new a("0.75X", 0.75f));
            d.b.add((Object)new a("1X", 1.0f));
            d.b.add((Object)new a("1.25X", 1.25f));
            d.b.add((Object)new a("1.5X", 1.5f));
            d.b.add((Object)new a("1.75X", 1.75f));
            d.b.add((Object)new a("2X", 2.0f));
        }
        return d.b;
    }
    
    public static int c(final float n) {
        final List<a> b = b();
        for (int i = 0; i < b.size(); ++i) {
            if (((a)b.get(i)).b == n) {
                return i;
            }
        }
        ax.u3.b.f();
        return c(1.0f);
    }
    
    View a(final int n, final View view, final ViewGroup viewGroup, final int n2) {
        View inflate = view;
        if (view == null) {
            inflate = this.a.inflate(n2, viewGroup, false);
        }
        ((TextView)inflate).setText((CharSequence)((a)((Adapter)this).getItem(n)).a);
        return inflate;
    }
    
    public View getDropDownView(final int n, final View view, final ViewGroup viewGroup) {
        return this.a(n, view, viewGroup, 2131558582);
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        return this.a(n, view, viewGroup, 2131558581);
    }
    
    public static class a
    {
        public String a;
        public float b;
        
        a(final String a, final float b) {
            this.a = a;
            this.b = b;
        }
    }
}
