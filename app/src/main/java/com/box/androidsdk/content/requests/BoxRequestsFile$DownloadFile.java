package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxSession;
import java.io.OutputStream;
import com.box.androidsdk.content.models.BoxDownload;

public class BoxRequestsFile$DownloadFile extends BoxRequestDownload<BoxDownload, BoxRequestsFile$DownloadFile>
{
    private static final long serialVersionUID = 8123965031279971588L;
    
    public BoxRequestsFile$DownloadFile(final String s, final OutputStream outputStream, final String s2, final BoxSession boxSession) {
        super(s, BoxDownload.class, outputStream, s2, boxSession);
    }
}
