package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.N9.d1;
import ax.N9.f;
import java.util.List;
import ax.N9.W0;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseRecurrencePattern implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("type")
    public W0 c;
    @a
    @c("interval")
    public Integer d;
    @a
    @c("month")
    public Integer e;
    @a
    @c("dayOfMonth")
    public Integer f;
    @a
    @c("daysOfWeek")
    public List<f> g;
    @a
    @c("firstDayOfWeek")
    public f h;
    @a
    @c("index")
    public d1 i;
    private transient l j;
    private transient e k;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e k, final l j) {
        this.k = k;
        this.j = j;
    }
}
