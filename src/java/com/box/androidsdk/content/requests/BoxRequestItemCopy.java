package com.box.androidsdk.content.requests;

import java.util.AbstractMap;
import java.util.Map$Entry;
import ax.O4.d;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxItem;

abstract class BoxRequestItemCopy<E extends BoxItem, R extends BoxRequest<E, R>> extends BoxRequestItem<E, R>
{
    public BoxRequestItemCopy(final Class<E> clazz, final String s, final String s2, final String s3, final BoxSession boxSession) {
        super(clazz, s, s3, boxSession);
        super.mRequestMethod = Methods.c0;
        this.G(s2);
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
        super.v(d, map$Entry);
    }
}
