package com.box.androidsdk.content.requests;

import java.util.AbstractMap;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxFolder;

public class BoxRequestsFolder$CreateFolder extends BoxRequestItem<BoxFolder, BoxRequestsFolder$CreateFolder>
{
    private static final long serialVersionUID = 8123965031279971505L;
    
    public BoxRequestsFolder$CreateFolder(final String s, final String s2, final String s3, final BoxSession boxSession) {
        super(BoxFolder.class, null, s3, boxSession);
        super.mRequestMethod = Methods.c0;
        this.G(s);
        this.F(s2);
    }
    
    public BoxRequestsFolder$CreateFolder F(final String s) {
        ((AbstractMap)super.mBodyMap).put((Object)"name", (Object)s);
        return this;
    }
    
    public BoxRequestsFolder$CreateFolder G(final String s) {
        ((AbstractMap)super.mBodyMap).put((Object)"parent", (Object)BoxFolder.S(s));
        return this;
    }
}
