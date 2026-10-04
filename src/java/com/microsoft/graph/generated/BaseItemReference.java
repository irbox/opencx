package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.SharepointIds;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseItemReference implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("driveId")
    public String c;
    @a
    @c("driveType")
    public String d;
    @a
    @c("id")
    public String e;
    @a
    @c("name")
    public String f;
    @a
    @c("path")
    public String g;
    @a
    @c("shareId")
    public String h;
    @a
    @c("sharepointIds")
    public SharepointIds i;
    private transient l j;
    private transient e k;
    
    public BaseItemReference() {
        this.b = new com.microsoft.graph.serializer.a((d)this);
    }
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e k, final l j) {
        this.k = k;
        this.j = j;
    }
}
