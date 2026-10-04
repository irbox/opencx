package com.box.androidsdk.content.requests;

import java.net.URLConnection;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.HttpsURLConnection;
import ax.E3.g;
import java.net.URL;
import ax.F3.b;
import java.net.HttpURLConnection;

class a
{
    protected final HttpURLConnection a;
    protected final b b;
    
    public a(final URL url, final BoxRequest.Methods methods, final b b) throws IOException {
        final HttpURLConnection a = (HttpURLConnection)url.openConnection();
        (this.a = a).setRequestMethod(methods.toString());
        this.b = b;
        if (g.l && a instanceof HttpsURLConnection) {
            ((HttpsURLConnection)a).setSSLSocketFactory((SSLSocketFactory)new BoxRequest.c());
        }
    }
    
    public a a(final String s, final String s2) {
        ((URLConnection)this.a).addRequestProperty(s, s2);
        return this;
    }
    
    public HttpURLConnection b() {
        return this.a;
    }
    
    public a c(final InputStream inputStream) throws IOException {
        ((URLConnection)this.a).setDoOutput(true);
        final OutputStream outputStream = ((URLConnection)this.a).getOutputStream();
        for (int i = inputStream.read(); i != -1; i = inputStream.read()) {
            outputStream.write(i);
        }
        outputStream.close();
        return this;
    }
}
