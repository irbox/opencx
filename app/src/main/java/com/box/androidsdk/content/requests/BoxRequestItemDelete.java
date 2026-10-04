package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxVoid;

public abstract class BoxRequestItemDelete<R extends BoxRequest<BoxVoid, R>> extends BoxRequest<BoxVoid, R>
{
    protected String mId;
    
    public BoxRequestItemDelete(final String mId, final String s, final BoxSession boxSession) {
        super(BoxVoid.class, s, boxSession);
        this.mId = mId;
        super.mRequestMethod = Methods.e0;
    }
}
