package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxFile;

public class BoxRequestsFile$CopyFile extends BoxRequestItemCopy<BoxFile, BoxRequestsFile$CopyFile>
{
    private static final long serialVersionUID = 8123965031279971533L;
    
    public BoxRequestsFile$CopyFile(final String s, final String s2, final String s3, final BoxSession boxSession) {
        super(BoxFile.class, s, s2, s3, boxSession);
    }
}
