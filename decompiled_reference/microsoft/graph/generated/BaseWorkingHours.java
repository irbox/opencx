package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.TimeZoneBase;
import ax.R9.b;
import ax.N9.f;
import java.util.List;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseWorkingHours implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("daysOfWeek")
    public List<f> c;
    @a
    @c("startTime")
    public b d;
    @a
    @c("endTime")
    public b e;
    @a
    @c("timeZone")
    public TimeZoneBase f;
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
