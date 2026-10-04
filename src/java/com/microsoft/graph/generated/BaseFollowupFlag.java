package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.N9.y;
import com.microsoft.graph.extensions.DateTimeTimeZone;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseFollowupFlag implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("completedDateTime")
    public DateTimeTimeZone c;
    @a
    @c("dueDateTime")
    public DateTimeTimeZone d;
    @a
    @c("startDateTime")
    public DateTimeTimeZone e;
    @a
    @c("flagStatus")
    public y f;
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
