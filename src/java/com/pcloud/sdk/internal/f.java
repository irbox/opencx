package com.pcloud.sdk.internal;

import java.io.IOException;
import ax.xc.e;
import ax.xc.A;
import ax.la.r;
import ax.xc.j;

final class f extends j
{
    private final long c0;
    private final r d0;
    private long e0;
    private final long f0;
    private long q;
    
    f(final A a, final long f0, final r d0, final long c0) {
        super(a);
        this.f0 = f0;
        this.c0 = c0;
        this.d0 = d0;
    }
    
    public void write(final e e, long e2) throws IOException {
        super.write(e, e2);
        e2 += this.e0;
        this.e0 = e2;
        if (e2 - this.q >= this.c0) {
            this.d0.a(e2, this.f0);
            this.q = this.e0;
        }
    }
}
