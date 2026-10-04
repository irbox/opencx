package com.microsoft.graph.http;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.P9.g;
import com.microsoft.graph.serializer.a;
import ax.T9.d;

public class GraphErrorResponse implements d
{
    private transient a a;
    @c("error")
    public g b;
    @ax.s8.a(deserialize = false, serialize = false)
    public l c;
    
    public GraphErrorResponse() {
        this.a = new a((d)this);
    }
    
    public final a c() {
        return this.a;
    }
    
    public void d(final e e, final l c) {
        this.c = c;
    }
}
