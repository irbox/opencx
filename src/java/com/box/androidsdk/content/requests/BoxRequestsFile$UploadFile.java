package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import java.io.IOException;
import com.box.androidsdk.content.models.BoxSession;
import java.io.InputStream;
import com.box.androidsdk.content.models.BoxFile;

public class BoxRequestsFile$UploadFile extends BoxRequestUpload<BoxFile, BoxRequestsFile$UploadFile>
{
    private static final long serialVersionUID = 8123965031279971502L;
    String mDestinationFolderId;
    
    public BoxRequestsFile$UploadFile(final InputStream mStream, final String mFileName, final String mDestinationFolderId, final String mRequestUrlString, final BoxSession boxSession) {
        super(BoxFile.class, mStream, mRequestUrlString, boxSession);
        super.mRequestUrlString = mRequestUrlString;
        super.mRequestMethod = Methods.c0;
        super.mFileName = mFileName;
        super.mStream = mStream;
        this.mDestinationFolderId = mDestinationFolderId;
    }
    
    @Override
    protected com.box.androidsdk.content.requests.c F() throws IOException, BoxException {
        final com.box.androidsdk.content.requests.c f = super.F();
        f.d("parent_id", this.mDestinationFolderId);
        return f;
    }
}
