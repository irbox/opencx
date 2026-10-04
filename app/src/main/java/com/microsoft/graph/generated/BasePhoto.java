package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import java.util.Calendar;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BasePhoto implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("cameraMake")
    public String c;
    @a
    @c("cameraModel")
    public String d;
    @a
    @c("exposureDenominator")
    public Double e;
    @a
    @c("exposureNumerator")
    public Double f;
    @a
    @c("fNumber")
    public Double g;
    @a
    @c("focalLength")
    public Double h;
    @a
    @c("iso")
    public Integer i;
    @a
    @c("takenDateTime")
    public Calendar j;
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
