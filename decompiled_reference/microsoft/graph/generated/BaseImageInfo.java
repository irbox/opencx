package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseImageInfo implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("iconUrl")
    public String c;
    @a
    @c("alternativeText")
    public String d;
    @a
    @c("alternateText")
    public String e;
    @a
    @c("addImageQuery")
    public Boolean f;
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
