package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.N9.R0;
import ax.N9.Q0;
import com.microsoft.graph.extensions.OutlookGeoCoordinates;
import com.microsoft.graph.extensions.PhysicalAddress;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseLocation implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("displayName")
    public String c;
    @a
    @c("locationEmailAddress")
    public String d;
    @a
    @c("address")
    public PhysicalAddress e;
    @a
    @c("coordinates")
    public OutlookGeoCoordinates f;
    @a
    @c("locationUri")
    public String g;
    @a
    @c("locationType")
    public Q0 h;
    @a
    @c("uniqueId")
    public String i;
    @a
    @c("uniqueIdType")
    public R0 j;
    private transient l k;
    private transient e l;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e l, final l k) {
        this.l = l;
        this.k = k;
    }
}
