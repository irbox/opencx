package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.r8.i;
import com.microsoft.graph.extensions.ImageInfo;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseVisualInfo implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("attribution")
    public ImageInfo c;
    @a
    @c("backgroundColor")
    public String d;
    @a
    @c("description")
    public String e;
    @a
    @c("displayText")
    public String f;
    @a
    @c("content")
    public i g;
    private transient l h;
    private transient e i;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e i, final l h) {
        this.i = i;
        this.h = h;
    }
}
