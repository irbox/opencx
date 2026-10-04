package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseEmailAddress implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("name")
    public String c;
    @a
    @c("address")
    public String d;
    private transient l e;
    private transient e f;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e f, final l e) {
        this.f = f;
        this.e = e;
    }
}
