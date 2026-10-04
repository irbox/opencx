package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import java.io.IOException;
import java.util.Locale;
import android.text.TextUtils;
import com.box.androidsdk.content.models.BoxSession;
import java.io.InputStream;
import com.box.androidsdk.content.models.BoxFile;

public class BoxRequestsFile$UploadNewVersion extends BoxRequestUpload<BoxFile, BoxRequestsFile$UploadNewVersion>
{
    private static String f0 = "{\"name\": \"%s\"}";
    
    public BoxRequestsFile$UploadNewVersion(final InputStream inputStream, final String s, final BoxSession boxSession) {
        super(BoxFile.class, inputStream, s, boxSession);
    }
    
    @Override
    protected com.box.androidsdk.content.requests.c F() throws IOException, BoxException {
        final com.box.androidsdk.content.requests.c f = super.F();
        if (!TextUtils.isEmpty((CharSequence)super.mFileName)) {
            f.d("attributes", String.format(Locale.ENGLISH, BoxRequestsFile$UploadNewVersion.f0, new Object[] { super.mFileName }));
        }
        return f;
    }
}
