package com.box.androidsdk.content.auth;

import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import java.util.List;
import ax.I3.b;
import ax.I3.c;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import android.content.Context;
import android.widget.ListView;
import android.app.Fragment;

public class a extends Fragment
{
    private ListView a;
    
    public static a a(final Context context) {
        return new a();
    }
    
    public ArrayList<BoxAuthentication.BoxAuthenticationInfo> b() {
        if (this.getArguments() != null && this.getArguments().getCharSequenceArrayList("boxAuthenticationInfos") != null) {
            final ArrayList charSequenceArrayList = this.getArguments().getCharSequenceArrayList("boxAuthenticationInfos");
            final ArrayList list = new ArrayList(charSequenceArrayList.size());
            final int size = charSequenceArrayList.size();
            int i = 0;
            while (i < size) {
                final Object value = charSequenceArrayList.get(i);
                ++i;
                final CharSequence charSequence = (CharSequence)value;
                final BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = new BoxAuthentication.BoxAuthenticationInfo();
                boxAuthenticationInfo.k(charSequence.toString());
                list.add((Object)boxAuthenticationInfo);
            }
            return (ArrayList<BoxAuthentication.BoxAuthenticationInfo>)list;
        }
        final Map<String, BoxAuthentication.BoxAuthenticationInfo> r = BoxAuthentication.o().r((Context)this.getActivity());
        if (r != null) {
            final ArrayList list2 = new ArrayList(r.size());
            final Iterator iterator = r.keySet().iterator();
            while (iterator.hasNext()) {
                list2.add((Object)r.get((Object)iterator.next()));
            }
            return (ArrayList<BoxAuthentication.BoxAuthenticationInfo>)list2;
        }
        return null;
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final ArrayList<BoxAuthentication.BoxAuthenticationInfo> b = this.b();
        final View inflate = layoutInflater.inflate(c.e, (ViewGroup)null);
        final ListView a = (ListView)inflate.findViewById(ax.I3.b.f);
        this.a = a;
        if (b == null) {
            this.getActivity().getFragmentManager().beginTransaction().remove((Fragment)this).commit();
            return inflate;
        }
        a.setAdapter((ListAdapter)new AuthenticatedAccountsAdapter((Context)this.getActivity(), c.f, (List<BoxAuthentication.BoxAuthenticationInfo>)b));
        ((AdapterView)this.a).setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener(this) {
            final a a;
            
            public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                if (adapterView.getAdapter() instanceof AuthenticatedAccountsAdapter) {
                    final BoxAuthentication.BoxAuthenticationInfo a = ((AuthenticatedAccountsAdapter)adapterView.getAdapter()).a(n);
                    if (a instanceof AuthenticatedAccountsAdapter.DifferentAuthenticationInfo) {
                        if (this.a.getActivity() instanceof b) {
                            ((b)this.a.getActivity()).f();
                        }
                    }
                    else if (this.a.getActivity() instanceof b) {
                        ((b)this.a.getActivity()).b(a);
                    }
                }
            }
        });
        return inflate;
    }
    
    public interface b
    {
        void b(final BoxAuthentication.BoxAuthenticationInfo p0);
        
        void f();
    }
}
