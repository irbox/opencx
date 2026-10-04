package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxSession;
import java.io.File;
import com.box.androidsdk.content.models.BoxDownload;

public class BoxRequestsFile$DownloadAvatar extends BoxRequestDownload<BoxDownload, BoxRequestsFile$DownloadFile>
{
    public BoxRequestsFile$DownloadAvatar(final String s, final File file, final String s2, final BoxSession boxSession) {
        super(s, BoxDownload.class, file, s2, boxSession);
    }
    
    public BoxRequestsFile$DownloadAvatar I(final String s) {
        super.mQueryMap.put((Object)"pic_type", (Object)s);
        return this;
    }
}
