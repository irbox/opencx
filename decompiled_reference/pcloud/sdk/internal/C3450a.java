package com.pcloud.sdk.internal;

import java.io.IOException;
import java.util.concurrent.Callable;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: renamed from: com.pcloud.sdk.internal.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /storage/emulated/0/Documents/jadec/sources/com.cxinventor.file.explorer/dex-files/29.dex */
final class C3450a extends w {
    private final Callable<String> a;

    C3450a(Callable<String> callable) {
        if (callable == null) {
            throw new IllegalArgumentException("'tokenProvider' argument cannot be null.");
        }
        this.a = callable;
    }

    private Request a(Request request, String str) {
        if (str == null) {
            return request;
        }
        return request.newBuilder().header("Authorization", "Bearer " + str).build();
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        try {
            String strCall = this.a.call();
            return chain.proceed(strCall != null ? a(chain.request(), strCall) : chain.request());
        } catch (Exception e) {
            throw new IOException("Error while providing access token.", e);
        }
    }
}
