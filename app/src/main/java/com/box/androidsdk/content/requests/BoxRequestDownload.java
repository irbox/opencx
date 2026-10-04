package com.box.androidsdk.content.requests;

import java.net.URLConnection;
import java.net.Socket;
import javax.net.ssl.SSLException;
import android.text.TextUtils;
import ax.H3.f;
import com.box.androidsdk.content.utils.SdkUtils;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.BoxException;
import java.util.Locale;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.box.androidsdk.content.models.BoxSession;
import java.io.File;
import java.io.OutputStream;
import ax.F3.a;
import com.box.androidsdk.content.models.BoxObject;

public abstract class BoxRequestDownload<E extends BoxObject, R extends BoxRequest<E, R>> extends BoxRequest<E, R>
{
    protected ax.F3.a mDownloadStartListener;
    protected OutputStream mFileOutputStream;
    protected String mId;
    protected long mRangeEnd;
    protected long mRangeStart;
    private String mSha1;
    protected File mTarget;
    
    public BoxRequestDownload(final String mId, final Class<E> clazz, final File mTarget, final String mRequestUrlString, final BoxSession boxSession) {
        super(clazz, mRequestUrlString, boxSession);
        this.mRangeStart = -1L;
        this.mRangeEnd = -1L;
        this.mId = mId;
        super.mRequestMethod = Methods.q;
        super.mRequestUrlString = mRequestUrlString;
        this.mTarget = mTarget;
        this.C((a)new DownloadRequestHandler(this));
        super.mRequiresSocket = true;
        super.mQueryMap.put((Object)"log_content_access", (Object)Boolean.toString(true));
    }
    
    public BoxRequestDownload(final String mId, final Class<E> clazz, final OutputStream mFileOutputStream, final String mRequestUrlString, final BoxSession boxSession) {
        super(clazz, mRequestUrlString, boxSession);
        this.mRangeStart = -1L;
        this.mRangeEnd = -1L;
        this.mId = mId;
        super.mRequestMethod = Methods.q;
        super.mRequestUrlString = mRequestUrlString;
        this.mFileOutputStream = mFileOutputStream;
        this.C((a)new DownloadRequestHandler(this));
        super.mRequiresSocket = true;
        super.mQueryMap.put((Object)"log_content_access", (Object)Boolean.toString(true));
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        super.c0 = new DownloadRequestHandler(this);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }
    
    @Override
    protected void B(final com.box.androidsdk.content.requests.a a) {
        super.B(a);
        final long mRangeStart = this.mRangeStart;
        if (mRangeStart != -1L && this.mRangeEnd != -1L) {
            a.a("Range", String.format("bytes=%s-%s", new Object[] { Long.toString(mRangeStart), Long.toString(this.mRangeEnd) }));
        }
    }
    
    public File F() {
        return this.mTarget;
    }
    
    public OutputStream G() {
        return this.mFileOutputStream;
    }
    
    public R H(final long mRangeStart, final long mRangeEnd) {
        this.mRangeStart = mRangeStart;
        this.mRangeEnd = mRangeEnd;
        return (R)this;
    }
    
    @Override
    protected void r(final com.box.androidsdk.content.requests.b b) throws BoxException {
        this.s();
        ax.H3.b.d("BoxContentSdk", String.format(Locale.ENGLISH, "Response (%s)", new Object[] { b.f() }));
    }
    
    public static class DownloadRequestHandler extends a<BoxRequestDownload>
    {
        protected int d;
        protected int e;
        
        public DownloadRequestHandler(final BoxRequestDownload boxRequestDownload) {
            super(boxRequestDownload);
            this.d = 0;
            this.e = 1000;
        }
        
        protected OutputStream j(final BoxDownload boxDownload) throws FileNotFoundException, IOException {
            final BoxRequest a = super.a;
            if (((BoxRequestDownload)a).mFileOutputStream == null) {
                if (!boxDownload.D().exists()) {
                    boxDownload.D().createNewFile();
                }
                return (OutputStream)new FileOutputStream(boxDownload.D());
            }
            return ((BoxRequestDownload)a).mFileOutputStream;
        }
        
        public BoxDownload k(Class d, final com.box.androidsdk.content.requests.b b) throws IllegalAccessException, InstantiationException, BoxException {
            d = b.d();
            final String contentEncoding = ((URLConnection)b.e()).getContentEncoding();
            if (Thread.currentThread().isInterrupted()) {
                ((a)this).b(b);
            }
            if (b.f() == 429) {
                return ((a)this).i(b);
            }
            if (b.f() == 202) {
                Label_0116: {
                    try {
                        final int d2 = this.d;
                        if (d2 < 2) {
                            this.d = d2 + 1;
                            this.e = BoxRequest.a.c(b, 1);
                            break Label_0116;
                        }
                    }
                    catch (final InterruptedException ex) {
                        throw new BoxException(((Throwable)ex).getMessage(), b);
                    }
                    final int e = this.e;
                    if (e >= 90000) {
                        throw new BoxException.MaxAttemptsExceeded("Max wait time exceeded.", this.d);
                    }
                    this.e = (int)(e * (Math.random() + 1.5));
                }
                Thread.sleep((long)this.e);
                return ((R)super.a).x();
            }
            if (b.f() != 200 && b.f() != 206) {
                return new BoxDownload(null, 0L, null, null, null, null);
            }
            final String headerField = ((URLConnection)b.e()).getHeaderField("Content-Length");
            final String headerField2 = ((URLConnection)b.e()).getHeaderField("Content-Disposition");
            long long1;
            try {
                long1 = Long.parseLong(headerField);
            }
            catch (final Exception ex2) {
                long1 = -1L;
            }
            final BoxDownload boxDownload = new BoxDownload(this, headerField2, long1, d, ((URLConnection)b.e()).getHeaderField("Content-Range"), ((URLConnection)b.e()).getHeaderField("Date"), ((URLConnection)b.e()).getHeaderField("Expiration")) {
                final DownloadRequestHandler this$0;
                
                @Override
                public File D() {
                    if (((BoxRequestDownload)this.this$0.a).F() == null) {
                        return null;
                    }
                    if (((BoxRequestDownload)this.this$0.a).F().isFile()) {
                        return ((BoxRequestDownload)this.this$0.a).F();
                    }
                    if (!SdkUtils.l(this.C())) {
                        return new File(((BoxRequestDownload)this.this$0.a).F(), this.C());
                    }
                    return super.D();
                }
            };
            ((R)super.a).getClass();
            final Object o = null;
            final String s = d = null;
            final OutputStream j;
            Label_0623: {
                try {
                    try {
                        if (((R)super.a).q == null) {}
                        d = s;
                        Object o2 = new(ax.H3.f.class)();
                        d = s;
                        new f(this.j(boxDownload), ((R)super.a).q, long1);
                        try {
                            ((R)super.a).q.a(0L, long1);
                        }
                        catch (final Exception d) {
                            o2 = d;
                        }
                        finally {
                            final String s2 = d = (String)o2;
                        }
                    }
                    finally {}
                }
                catch (final Exception j) {
                    break Label_0623;
                }
                j = this.j(boxDownload);
                if (TextUtils.isEmpty((CharSequence)((BoxRequestDownload<BoxObject, BoxRequest>)super.a).mSha1)) {
                    SdkUtils.c(b.a(), j);
                }
                else {
                    final String e2 = SdkUtils.e(b.a(), j);
                    if (!((BoxRequestDownload<BoxObject, BoxRequest>)super.a).mSha1.equals((Object)e2)) {
                        throw new BoxException.CorruptedContentException("Sha1 checks failed", ((BoxRequestDownload<BoxObject, BoxRequest>)super.a).mSha1, e2);
                    }
                }
                try {
                    b.a().close();
                }
                catch (final IOException ex3) {
                    ax.H3.b.c("error closing inputstream", (Throwable)ex3);
                }
                if (((BoxRequestDownload)super.a).G() == null) {
                    try {
                        j.close();
                    }
                    catch (final IOException ex4) {
                        ax.H3.b.c("error closing outputstream", (Throwable)ex4);
                    }
                }
                return boxDownload;
            }
            final Socket m = ((R)super.a).m();
            if (m != null && contentEncoding != null && contentEncoding.equalsIgnoreCase("gzip")) {
                try {
                    m.close();
                }
                catch (final Exception ex5) {
                    ax.H3.b.c("error closing socket", (Throwable)ex5);
                }
            }
            if (j instanceof BoxException) {
                throw (BoxException)j;
            }
            if (j instanceof SSLException) {
                throw new BoxException.DownloadSSLException(((Throwable)j).getMessage(), (SSLException)j);
            }
            throw new BoxException(((Throwable)j).getMessage(), (Throwable)j);
            try {
                b.a().close();
            }
            catch (final IOException ex6) {
                ax.H3.b.c("error closing inputstream", (Throwable)ex6);
            }
            if (((BoxRequestDownload)super.a).G() == null) {
                try {
                    ((OutputStream)d).close();
                }
                catch (final IOException ex7) {
                    ax.H3.b.c("error closing outputstream", (Throwable)ex7);
                }
            }
        }
    }
}
