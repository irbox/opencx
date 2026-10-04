package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxIteratorItems;

public class BoxRequestsSearch$Search extends BoxRequestItem<BoxIteratorItems, BoxRequestsSearch$Search>
{
    public static String f0 = "name";
    private static final long serialVersionUID = 8123965031279971584L;
    
    public BoxRequestsSearch$Search(final String s, final String s2, final BoxSession boxSession) {
        super(BoxIteratorItems.class, null, s2, boxSession);
        this.H("query", s);
        super.mRequestMethod = Methods.q;
    }
    
    public BoxRequestsSearch$Search F(final String[] array) {
        this.H("ancestor_folder_ids", SdkUtils.b(array, ","));
        return this;
    }
    
    public BoxRequestsSearch$Search G(final String[] array) {
        this.H("content_types", SdkUtils.b(array, ","));
        return this;
    }
    
    public BoxRequestsSearch$Search H(final String s, final String s2) {
        super.mQueryMap.put((Object)s, (Object)s2);
        return this;
    }
    
    public BoxRequestsSearch$Search I(final int n) {
        this.H("limit", String.valueOf(n));
        return this;
    }
}
