package com.box.androidsdk.content.views;

import java.io.File;
import com.box.androidsdk.content.models.BoxDownload;
import ax.E3.h;
import com.box.androidsdk.content.models.BoxSession;
import android.content.Context;

public class OfflineAvatarController extends DefaultAvatarController
{
    final Context mContext;
    
    public OfflineAvatarController(final Context context) {
        super(null);
        this.mContext = context.getApplicationContext();
    }
    
    @Override
    public h<BoxDownload> b(final String s, final BoxAvatarView boxAvatarView) {
        return null;
    }
    
    @Override
    protected File f(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getFilesDir().getAbsolutePath());
        final String separator = File.separator;
        sb.append(separator);
        sb.append(s);
        sb.append(separator);
        sb.append("avatar");
        final File file = new File(sb.toString());
        this.c(file, 30);
        return file;
    }
}
