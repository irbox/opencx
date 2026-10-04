package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.N9.X0;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseRecurrenceRange implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("type")
    public X0 c;
    @a
    @c("startDate")
    public ax.R9.a d;
    @a
    @c("endDate")
    public ax.R9.a e;
    @a
    @c("recurrenceTimeZone")
    public String f;
    @a
    @c("numberOfOccurrences")
    public Integer g;
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
