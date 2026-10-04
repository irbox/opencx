package com.box.androidsdk.content.requests;

import java.util.AbstractMap;
import java.util.Map$Entry;
import ax.O4.d;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxItem;

public abstract class BoxRequestItemUpdate<E extends BoxItem, R extends BoxRequest<E, R>> extends BoxRequestItem<E, R>
{
    public BoxRequestItemUpdate(final Class<E> clazz, final String s, final String s2, final BoxSession boxSession) {
        super(clazz, s, s2, boxSession);
        super.mRequestMethod = Methods.d0;
    }
    
    public R F(final String s) {
        ((AbstractMap)super.mBodyMap).put((Object)"name", (Object)s);
        return (R)this;
    }
    
    public R G(final String s) {
        ((AbstractMap)super.mBodyMap).put((Object)"parent", (Object)BoxFolder.S(s));
        return (R)this;
    }
    
    @Override
    protected void v(final d d, final Map$Entry<String, Object> map$Entry) {
        if (((String)map$Entry.getKey()).equals((Object)"parent")) {
            d.B((String)map$Entry.getKey(), this.w(map$Entry.getValue()));
            return;
        }
        if (!((String)map$Entry.getKey()).equals((Object)"shared_link")) {
            super.v(d, map$Entry);
            return;
        }
        if (map$Entry.getValue() == null) {
            d.C((String)map$Entry.getKey(), (String)null);
            return;
        }
        d.B((String)map$Entry.getKey(), this.w(map$Entry.getValue()));
    }
}
