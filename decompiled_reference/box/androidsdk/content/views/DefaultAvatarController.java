package com.box.androidsdk.content.views;

import java.lang.ref.Reference;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.utils.SdkUtils;
import java.util.concurrent.TimeUnit;
import ax.H3.b;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.requests.BoxResponse;
import ax.E3.h$b;
import java.lang.ref.WeakReference;
import com.box.androidsdk.content.models.BoxDownload;
import ax.E3.h;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import ax.E3.e;
import com.box.androidsdk.content.models.BoxSession;
import java.util.HashSet;
import java.util.concurrent.ThreadPoolExecutor;
import java.io.Serializable;

public class DefaultAvatarController implements b, Serializable
{
    protected transient ThreadPoolExecutor c0;
    protected HashSet<String> mCleanedDirectories;
    protected BoxSession mSession;
    protected HashSet<String> mUnavailableAvatars;
    protected transient e q;
    
    public DefaultAvatarController(final BoxSession mSession) {
        this.mUnavailableAvatars = (HashSet<String>)new HashSet();
        this.mCleanedDirectories = (HashSet<String>)new HashSet();
        this.mSession = mSession;
        this.q = new e(mSession);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if (this.e() == null) {
            this.q = new e(this.mSession);
        }
    }
    
    @Override
    public File a(final String s) {
        final File f = this.f(s);
        final StringBuilder sb = new StringBuilder();
        sb.append("avatar_");
        sb.append(s);
        sb.append(".");
        sb.append("jpg");
        return new File(f, sb.toString());
    }
    
    @Override
    public h<BoxDownload> b(final String s, final BoxAvatarView boxAvatarView) {
        final WeakReference weakReference = new WeakReference((Object)boxAvatarView);
        try {
            final File a = this.a(s);
            if (this.mUnavailableAvatars.contains((Object)a.getAbsolutePath())) {
                return null;
            }
            final h d = ((BoxRequest)this.e().e(this.f(s), s)).D();
            d.a((h$b)new h$b<BoxDownload>(this, weakReference, s, a) {
                final WeakReference a;
                final String b;
                final File c;
                final DefaultAvatarController d;
                
                public void a(final BoxResponse<BoxDownload> boxResponse) {
                    if (boxResponse.c()) {
                        final BoxAvatarView boxAvatarView = (BoxAvatarView)((Reference)this.a).get();
                        if (boxAvatarView != null) {
                            boxAvatarView.b();
                        }
                    }
                    else {
                        if (boxResponse.a() instanceof BoxException && ((BoxException)boxResponse.a()).e() == 404) {
                            final DefaultAvatarController d = this.d;
                            d.mUnavailableAvatars.add((Object)d.a(this.b).getAbsolutePath());
                        }
                        final File c = this.c;
                        if (c != null) {
                            c.delete();
                        }
                    }
                }
            });
            this.d(d);
            return (h<BoxDownload>)d;
        }
        catch (final IOException ex) {
            ax.H3.b.c("unable to createFile ", (Throwable)ex);
            return null;
        }
    }
    
    protected void c(final File file, int i) {
        if (file != null) {
            if (!this.mCleanedDirectories.contains((Object)file.getAbsolutePath())) {
                final long currentTimeMillis = System.currentTimeMillis();
                final long n = i;
                final long millis = TimeUnit.DAYS.toMillis(n);
                final File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int length;
                    File file2;
                    for (length = listFiles.length, i = 0; i < length; ++i) {
                        file2 = listFiles[i];
                        if (file2.getName().startsWith("avatar_") && file2.lastModified() < currentTimeMillis - n * millis) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }
    
    protected void d(final h h) {
        if (this.c0 == null) {
            this.c0 = SdkUtils.f(2, 2, 3600L, TimeUnit.SECONDS);
        }
        this.c0.execute((Runnable)h);
    }
    
    protected e e() {
        return this.q;
    }
    
    protected File f(final String s) {
        final File file = new File(this.mSession.t(), "avatar");
        if (!file.exists()) {
            file.mkdirs();
        }
        this.c(file, 30);
        return file;
    }
}
