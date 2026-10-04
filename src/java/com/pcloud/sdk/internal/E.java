package com.pcloud.sdk.internal;

import java.io.Closeable;
import ax.ma.a;
import okhttp3.Callback;
import ax.la.j;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.Call;
import ax.ma.b;
import ax.la.i;

final class e<T> implements i<T>
{
    private final b<T> c0;
    private final Call q;
    
    e(final Call q, final b<T> c0) {
        this.q = q;
        this.c0 = c0;
    }
    
    private T c(final Response response) throws IOException, ax.la.b {
        return (T)this.c0.a(response);
    }
    
    public void A(final j<T> j) {
        if (j != null) {
            this.q.enqueue((Callback)new Callback(this, j) {
                final j a;
                final e b;
                
                public void onFailure(final Call call, final IOException ex) {
                    this.a.a((i)this.b, (Throwable)ex);
                }
                
                public void onResponse(Call a, final Response response) {
                    try {
                        a = (IOException)this.a;
                        final e b = this.b;
                        ((j)a).b((i)b, b.c(response));
                        return;
                    }
                    catch (final IOException a) {}
                    catch (final ax.la.b b2) {}
                    a.a((Closeable)response);
                    this.a.a((i)this.b, (Throwable)a);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Callback argument cannot be null.");
    }
    
    public e<T> d() {
        return new e<T>(this.q.clone(), this.c0);
    }
    
    public T execute() throws IOException, ax.la.b {
        return this.c(this.q.execute());
    }
}
