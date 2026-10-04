package com.box.androidsdk.content.requests;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import android.text.TextUtils;
import java.util.Locale;
import java.util.Map;
import java.net.URL;
import com.box.androidsdk.content.models.BoxSession;
import java.io.OutputStream;
import com.box.androidsdk.content.models.BoxDownload;

public class BoxRequestsFile$DownloadThumbnail extends BoxRequestDownload<BoxDownload, BoxRequestsFile$DownloadThumbnail>
{
    public static int e0 = 32;
    public static int f0 = 64;
    public static int g0 = 94;
    public static int h0 = 128;
    public static int i0 = 160;
    public static int j0 = 256;
    private static final long serialVersionUID = 8123965031279971587L;
    protected Format mFormat;
    
    public BoxRequestsFile$DownloadThumbnail(final String s, final OutputStream outputStream, final String s2, final BoxSession boxSession) {
        super(s, BoxDownload.class, outputStream, s2, boxSession);
        this.mFormat = null;
    }
    
    public Integer I() {
        if (super.mQueryMap.containsKey((Object)"max_height")) {
            return Integer.parseInt((String)super.mQueryMap.get((Object)"max_height"));
        }
        return null;
    }
    
    public Integer J() {
        if (super.mQueryMap.containsKey((Object)"max_width")) {
            return Integer.parseInt((String)super.mQueryMap.get((Object)"max_width"));
        }
        return null;
    }
    
    public Integer K() {
        if (super.mQueryMap.containsKey((Object)"min_height")) {
            return Integer.parseInt((String)super.mQueryMap.get((Object)"min_height"));
        }
        return null;
    }
    
    public Integer L() {
        if (super.mQueryMap.containsKey((Object)"min_width")) {
            return Integer.parseInt((String)super.mQueryMap.get((Object)"min_width"));
        }
        return null;
    }
    
    protected String M() {
        final Format mFormat = this.mFormat;
        if (mFormat != null) {
            return mFormat.toString();
        }
        Integer n;
        if (this.L() != null) {
            n = this.L();
        }
        else if (this.K() != null) {
            n = this.K();
        }
        else if (this.J() != null) {
            n = this.J();
        }
        else if (this.I() != null) {
            n = this.I();
        }
        else {
            n = null;
        }
        if (n == null) {
            return Format.q.toString();
        }
        final int intValue = n;
        if (intValue <= BoxRequestsFile$DownloadThumbnail.e0) {
            return Format.c0.toString();
        }
        if (intValue <= BoxRequestsFile$DownloadThumbnail.f0) {
            return Format.c0.toString();
        }
        if (intValue <= BoxRequestsFile$DownloadThumbnail.g0) {
            return Format.q.toString();
        }
        if (intValue <= BoxRequestsFile$DownloadThumbnail.h0) {
            return Format.c0.toString();
        }
        if (intValue <= BoxRequestsFile$DownloadThumbnail.i0) {
            return Format.q.toString();
        }
        if (intValue <= BoxRequestsFile$DownloadThumbnail.j0) {
            return Format.c0.toString();
        }
        return Format.q.toString();
    }
    
    public BoxRequestsFile$DownloadThumbnail N(final int n) {
        super.mQueryMap.put((Object)"min_height", (Object)Integer.toString(n));
        return this;
    }
    
    public BoxRequestsFile$DownloadThumbnail O(final int n) {
        this.P(n);
        this.N(n);
        return this;
    }
    
    public BoxRequestsFile$DownloadThumbnail P(final int n) {
        super.mQueryMap.put((Object)"min_width", (Object)Integer.toString(n));
        return this;
    }
    
    @Override
    protected URL d() throws MalformedURLException, UnsupportedEncodingException {
        final String j = this.j((Map<String, String>)super.mQueryMap);
        final Locale english = Locale.ENGLISH;
        final String format = String.format(english, "%s%s", new Object[] { super.mRequestUrlString, this.M() });
        if (TextUtils.isEmpty((CharSequence)j)) {
            return new URL(format);
        }
        return new URL(String.format(english, "%s?%s", new Object[] { format, j }));
    }
    
    public enum Format
    {
        c0(".png");
        
        private static final Format[] d0;
        
        q(".jpg");
        
        private final String mExt;
        
        static {
            d0 = d();
        }
        
        private Format(final String mExt) {
            this.mExt = mExt;
        }
        
        private static /* synthetic */ Format[] d() {
            return new Format[] { Format.q, Format.c0 };
        }
        
        public String toString() {
            return this.mExt;
        }
    }
}
