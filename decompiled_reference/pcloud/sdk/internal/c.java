package com.pcloud.sdk.internal;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.Interceptor$Chain;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import okhttp3.Interceptor;

class c implements Interceptor
{
    private final String a;
    private final String b;
    
    c(final String a, final Map<String, String> map) {
        this.a = a;
        this.b = a(map);
    }
    
    private static String a(final Map<String, String> map) {
        final StringBuilder sb = new StringBuilder();
        for (final Map$Entry map$Entry : map.entrySet()) {
            sb.append((String)map$Entry.getKey());
            sb.append('=');
            sb.append((String)map$Entry.getValue());
            sb.append("; ");
        }
        sb.append("Domain=api.pcloud.com; Path=/; Secure; HttpOnly");
        return sb.toString();
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && this.b.equals((Object)((c)o).b));
    }
    
    @Override
    public int hashCode() {
        return this.b.hashCode();
    }
    
    public Response intercept(final Interceptor$Chain interceptor$Chain) throws IOException {
        return interceptor$Chain.proceed(interceptor$Chain.request().newBuilder().header("User-Agent", this.a).addHeader("Cookie", this.b).build());
    }
}
