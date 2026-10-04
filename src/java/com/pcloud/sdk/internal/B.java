package com.pcloud.sdk.internal;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Executor;
import ax.la.r;

class b implements r, Runnable
{
    private final Executor c0;
    private volatile boolean d0;
    private volatile long e0;
    private volatile long f0;
    private final r q;
    
    b(final r q, final Executor c0) {
        this.q = q;
        this.c0 = c0;
    }
    
    public void a(final long e0, final long f0) {
        if (!this.d0 || e0 == f0) {
            this.e0 = e0;
            this.f0 = f0;
            try {
                this.d0 = true;
                this.c0.execute((Runnable)this);
            }
            catch (final RejectedExecutionException ex) {
                this.d0 = false;
            }
        }
    }
    
    public void run() {
        this.q.a(this.e0, this.f0);
        this.d0 = false;
    }
}
