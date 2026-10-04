package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BasePhysicalAddress implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("street")
    public String c;
    @a
    @c("city")
    public String d;
    @a
    @c("state")
    public String e;
    @a
    @c("countryOrRegion")
    public String f;
    @a
    @c("postalCode")
    public String g;
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
