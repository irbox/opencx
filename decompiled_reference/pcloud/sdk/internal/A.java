package com.pcloud.sdk.internal;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.Interceptor$Chain;
import okhttp3.Request$Builder;
import okhttp3.Request;
import java.util.concurrent.Callable;

final class a extends w
{
    private final Callable<String> a;
    
    a(final Callable<String> a) {
        if (a != null) {
            this.a = a;
            return;
        }
        throw new IllegalArgumentException("'tokenProvider' argument cannot be null.");
    }
    
    private Request a(final Request request, final String s) {
        Request build = request;
        if (s != null) {
            final Request$Builder builder = request.newBuilder();
            final StringBuilder sb = new StringBuilder();
            sb.append("Bearer ");
            sb.append(s);
            build = builder.header("Authorization", sb.toString()).build();
        }
        return build;
    }
    
    public Response intercept(final Interceptor$Chain interceptor$Chain) throws IOException {
        try {
            final String s = (String)this.a.call();
            Request request;
            if (s != null) {
                request = this.a(interceptor$Chain.request(), s);
            }
            else {
                request = interceptor$Chain.request();
            }
            return interceptor$Chain.proceed(request);
        }
        catch (final Exception ex) {
            throw new IOException("Error while providing access token.", (Throwable)ex);
        }
    }
}
