package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxIteratorItems;

public class BoxRequestsFolder$GetFolderItems extends BoxRequestItem<BoxIteratorItems, BoxRequestsFolder$GetFolderItems>
{
    private static final long serialVersionUID = 8123965031279971524L;
    
    public BoxRequestsFolder$GetFolderItems(final String s, final String s2, final BoxSession boxSession) {
        super(BoxIteratorItems.class, s, s2, boxSession);
        super.mRequestMethod = Methods.q;
        super.mQueryMap.put((Object)"limit", (Object)"1000");
        super.mQueryMap.put((Object)"offset", (Object)"0");
    }
    
    public BoxRequestsFolder$GetFolderItems F(final int n) {
        super.mQueryMap.put((Object)"limit", (Object)String.valueOf(n));
        return this;
    }
    
    public BoxRequestsFolder$GetFolderItems G(final int n) {
        super.mQueryMap.put((Object)"offset", (Object)String.valueOf(n));
        return this;
    }
}
