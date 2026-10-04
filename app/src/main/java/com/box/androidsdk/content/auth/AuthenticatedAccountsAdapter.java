package com.box.androidsdk.content.auth;

import com.box.androidsdk.content.models.BoxUser;
import java.io.Serializable;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.views.BoxAvatarView;
import ax.I3.b;
import android.widget.TextView;
import ax.I3.c;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.List;
import android.content.Context;
import com.box.androidsdk.content.views.OfflineAvatarController;
import android.widget.ArrayAdapter;

public class AuthenticatedAccountsAdapter extends ArrayAdapter<BoxAuthentication.BoxAuthenticationInfo>
{
    private OfflineAvatarController a;
    
    public AuthenticatedAccountsAdapter(final Context context, final int n, final List<BoxAuthentication.BoxAuthenticationInfo> list) {
        super(context, n, (List)list);
        this.a = new OfflineAvatarController(context);
    }
    
    public BoxAuthentication.BoxAuthenticationInfo a(final int n) {
        if (n == this.getCount() - 1) {
            return new DifferentAuthenticationInfo();
        }
        return (BoxAuthentication.BoxAuthenticationInfo)super.getItem(n);
    }
    
    public int getCount() {
        return super.getCount() + 1;
    }
    
    public int getItemViewType(final int n) {
        if (n == this.getCount() - 1) {
            return 1;
        }
        return super.getItemViewType(n);
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        if (this.getItemViewType(n) == 1) {
            return LayoutInflater.from(this.getContext()).inflate(c.g, viewGroup, false);
        }
        final View inflate = LayoutInflater.from(this.getContext()).inflate(c.f, viewGroup, false);
        a tag;
        if ((tag = (a)inflate.getTag()) == null) {
            tag = new a();
            tag.a = (TextView)inflate.findViewById(b.c);
            tag.b = (TextView)inflate.findViewById(b.a);
            tag.c = (BoxAvatarView)inflate.findViewById(b.b);
            inflate.setTag((Object)tag);
        }
        final BoxAuthentication.BoxAuthenticationInfo a = this.a(n);
        if (a != null && a.K() != null) {
            final boolean l = SdkUtils.l(a.K().I());
            final BoxUser k = a.K();
            String text;
            if (!l) {
                text = k.I();
            }
            else {
                text = k.J();
            }
            tag.a.setText((CharSequence)text);
            if (!l) {
                tag.b.setText((CharSequence)a.K().J());
            }
            tag.c.a((BoxCollaborator)a.K(), (Serializable)this.a);
            return inflate;
        }
        if (a != null) {
            ax.H3.b.a("invalid account info", a.A());
        }
        return inflate;
    }
    
    public int getViewTypeCount() {
        return 2;
    }
    
    public static class DifferentAuthenticationInfo extends BoxAuthenticationInfo
    {
    }
    
    public static class a
    {
        public TextView a;
        public TextView b;
        public BoxAvatarView c;
    }
}
