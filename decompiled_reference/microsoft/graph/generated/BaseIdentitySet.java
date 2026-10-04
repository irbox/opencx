package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.Identity;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseIdentitySet implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("application")
    public Identity c;
    @a
    @c("device")
    public Identity d;
    @a
    @c("user")
    public Identity e;
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
