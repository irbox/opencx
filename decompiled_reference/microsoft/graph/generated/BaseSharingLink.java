package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.Identity;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseSharingLink implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("application")
    public Identity c;
    @a
    @c("scope")
    public String d;
    @a
    @c("type")
    public String e;
    @a
    @c("webUrl")
    public String f;
    private transient l g;
    private transient e h;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e h, final l g) {
        this.h = h;
        this.g = g;
    }
}
