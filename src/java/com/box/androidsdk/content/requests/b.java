package com.box.androidsdk.content.requests;

import java.net.URLConnection;
import ax.H3.e;
import java.io.IOException;
import com.box.androidsdk.content.BoxException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class b
{
    protected final HttpURLConnection a;
    protected int b;
    protected String c;
    private String d;
    private String e;
    private InputStream f;
    private InputStream g;
    
    public b(final HttpURLConnection a) {
        this.a = a;
        this.g = null;
    }
    
    private static boolean h(final int n) {
        return n >= 400;
    }
    
    private String j(final InputStream inputStream) throws IOException, BoxException {
        if (inputStream == null) {
            return null;
        }
        final String e = this.e;
        Object o = inputStream;
        if (e != null) {
            o = inputStream;
            if (e.equalsIgnoreCase("gzip")) {
                o = new GZIPInputStream(inputStream);
            }
        }
        final StringBuilder sb = new StringBuilder();
        final char[] array = new char[8192];
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader((InputStream)o, "UTF-8");
            for (int i = inputStreamReader.read(array, 0, 8192); i != -1; i = inputStreamReader.read(array, 0, 8192)) {
                sb.append(array, 0, i);
            }
        }
        catch (final IOException ex) {
            throw new BoxException("Unable to read stream", (Throwable)ex);
        }
        inputStreamReader.close();
        return sb.toString();
    }
    
    public InputStream a() throws BoxException {
        return this.b(null);
    }
    
    public InputStream b(final ax.F3.b b) throws BoxException {
        final InputStream g = this.g;
        if (g == null) {
            final String contentEncoding = ((URLConnection)this.a).getContentEncoding();
            try {
                if (this.f == null) {
                    this.f = ((URLConnection)this.a).getInputStream();
                }
            }
            catch (final IOException ex) {
                throw new BoxException("Couldn't connect to the Box API due to a network error.", (Throwable)ex);
            }
            if (b == null) {
                this.g = this.f;
            }
            else {
                this.g = (InputStream)new e(this.f, b, (long)this.c());
            }
            if (contentEncoding != null && contentEncoding.equalsIgnoreCase("gzip")) {
                this.g = (InputStream)new GZIPInputStream(this.g);
            }
            return this.g;
        }
        return g;
    }
    
    public int c() {
        return ((URLConnection)this.a).getContentLength();
    }
    
    public String d() {
        return this.c;
    }
    
    public HttpURLConnection e() {
        return this.a;
    }
    
    public int f() {
        return this.b;
    }
    
    public String g() throws BoxException {
        final String d = this.d;
        if (d != null) {
            return d;
        }
        try {
            if (h(this.b)) {
                final InputStream inputStream = this.a.getErrorStream();
                return this.d = this.j(inputStream);
            }
        }
        catch (final IOException ex) {
            throw new BoxException("Unable to get string body", (Throwable)ex);
        }
        final InputStream inputStream = ((URLConnection)this.a).getInputStream();
        return this.d = this.j(inputStream);
    }
    
    public void i() throws IOException {
        ((URLConnection)this.a).connect();
        this.c = ((URLConnection)this.a).getContentType();
        this.b = this.a.getResponseCode();
        this.e = ((URLConnection)this.a).getContentEncoding();
    }
}
