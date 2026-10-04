package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseOutlookGeoCoordinates implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("altitude")
    public Double c;
    @a
    @c("latitude")
    public Double d;
    @a
    @c("longitude")
    public Double e;
    @a
    @c("accuracy")
    public Double f;
    @a
    @c("altitudeAccuracy")
    public Double g;
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
