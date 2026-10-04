package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseSharepointIds implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("listId")
    public String c;
    @a
    @c("listItemId")
    public String d;
    @a
    @c("listItemUniqueId")
    public String e;
    @a
    @c("siteId")
    public String f;
    @a
    @c("siteUrl")
    public String g;
    @a
    @c("webId")
    public String h;
    private transient l i;
    private transient e j;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e j, final l i) {
        this.j = j;
        this.i = i;
    }
}
