package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseCalculatedColumn implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("format")
    public String c;
    @a
    @c("formula")
    public String d;
    @a
    @c("outputType")
    public String e;
    private transient l f;
    private transient e g;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e g, final l f) {
        this.g = g;
        this.f = f;
    }
}
