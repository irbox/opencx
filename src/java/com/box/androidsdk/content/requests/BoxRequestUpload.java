package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxIteratorBoxEntity;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxObject;
import java.net.HttpURLConnection;
import ax.F3.b;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import com.box.androidsdk.content.BoxException;
import java.io.IOException;
import com.box.androidsdk.content.models.BoxSession;
import java.io.InputStream;
import java.io.File;
import java.util.Date;
import com.box.androidsdk.content.models.BoxJsonObject;

public abstract class BoxRequestUpload<E extends BoxJsonObject, R extends BoxRequest<E, R>> extends BoxRequestItem<E, R>
{
    Date mCreatedDate;
    File mFile;
    String mFileName;
    Date mModifiedDate;
    String mSha1;
    InputStream mStream;
    long mUploadSize;
    
    public BoxRequestUpload(final Class<E> clazz, final InputStream mStream, final String s, final BoxSession boxSession) {
        super(clazz, null, s, boxSession);
        super.mRequestMethod = Methods.c0;
        this.mStream = mStream;
        this.mFileName = "";
        super.mContentType = null;
        this.C((BoxRequest.a)new a(this));
    }
    
    @Override
    protected void B(final com.box.androidsdk.content.requests.a a) {
        super.B(a);
        final String mSha1 = this.mSha1;
        if (mSha1 != null) {
            a.a("Content-MD5", mSha1);
        }
    }
    
    protected com.box.androidsdk.content.requests.c F() throws IOException, BoxException {
        final com.box.androidsdk.content.requests.c c = new com.box.androidsdk.content.requests.c(this.d(), super.mRequestMethod, super.q);
        this.B(c);
        c.g(this.G(), this.mFileName, this.mUploadSize);
        final Date mCreatedDate = this.mCreatedDate;
        if (mCreatedDate != null) {
            c.e("content_created_at", mCreatedDate);
        }
        final Date mModifiedDate = this.mModifiedDate;
        if (mModifiedDate != null) {
            c.e("content_modified_at", mModifiedDate);
        }
        return c;
    }
    
    protected InputStream G() throws FileNotFoundException {
        final InputStream mStream = this.mStream;
        if (mStream != null) {
            return mStream;
        }
        return (InputStream)new FileInputStream(this.mFile);
    }
    
    public R H(final Date mModifiedDate) {
        this.mModifiedDate = mModifiedDate;
        return (R)this;
    }
    
    public R I(final ax.F3.b q) {
        super.q = q;
        return (R)this;
    }
    
    @Override
    protected com.box.androidsdk.content.requests.a i() throws IOException, BoxException {
        return this.F();
    }
    
    @Override
    protected com.box.androidsdk.content.requests.b y(final com.box.androidsdk.content.requests.a a, final HttpURLConnection httpURLConnection) throws IOException, BoxException {
        if (a instanceof com.box.androidsdk.content.requests.c) {
            ((com.box.androidsdk.content.requests.c)a).h(httpURLConnection, super.q);
        }
        return super.y(a, httpURLConnection);
    }
    
    public static class a extends BoxRequest.a<BoxRequestUpload>
    {
        public a(final BoxRequestUpload boxRequestUpload) {
            super(boxRequestUpload);
        }
        
        @Override
        public <T extends BoxObject> T h(final Class<T> clazz, final com.box.androidsdk.content.requests.b b) throws IllegalAccessException, InstantiationException, BoxException {
            return super.h(BoxIteratorBoxEntity.class, b).D(0);
        }
    }
}
