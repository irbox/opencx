package com.pcloud.sdk.internal;

import ax.la.C2335b;
import ax.ma.C2387a;
import ax.ma.InterfaceC2388b;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: renamed from: com.pcloud.sdk.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /storage/emulated/0/Documents/jadec/sources/com.cxinventor.file.explorer/dex-files/29.dex */
final class C3454e<T> implements ax.la.i<T> {
    private final InterfaceC2388b<T> c0;
    private final Call q;

    /* JADX INFO: renamed from: com.pcloud.sdk.internal.e$a */
    class a implements Callback {
        final /* synthetic */ ax.la.j a;

        a(ax.la.j jVar) {
            this.a = jVar;
        }

        public void onFailure(Call call, IOException iOException) {
            this.a.a(C3454e.this, iOException);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onResponse(Call call, Response response) {
            try {
                ax.la.j jVar = this.a;
                C3454e c3454e = C3454e.this;
                jVar.b(c3454e, c3454e.c(response));
            } catch (C2335b | IOException e) {
                C2387a.a(response);
                this.a.a(C3454e.this, e);
            }
        }
    }

    C3454e(Call call, InterfaceC2388b<T> interfaceC2388b) {
        this.q = call;
        this.c0 = interfaceC2388b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public T c(Response response) throws IOException, C2335b {
        return this.c0.a(response);
    }

    @Override // ax.la.i
    public void A(ax.la.j<T> jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Callback argument cannot be null.");
        }
        this.q.enqueue(new a(jVar));
    }

    @Override // ax.la.i
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C3454e<T> m5clone() {
        return new C3454e<>(this.q.clone(), this.c0);
    }

    @Override // ax.la.i
    public T execute() throws IOException, C2335b {
        return c(this.q.execute());
    }
}
