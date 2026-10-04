package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxFile;

public class BoxRequestsFile$UpdateFile extends BoxRequestItemUpdate<BoxFile, BoxRequestsFile$UpdateFile>
{
    private static final long serialVersionUID = 8123965031279971521L;
    
    public BoxRequestsFile$UpdateFile(final String s, final String s2, final BoxSession boxSession) {
        super(BoxFile.class, s, s2, boxSession);
    }
}
