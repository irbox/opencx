package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.DateTimeTimeZone;
import ax.N9.x;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseAutomaticRepliesSetting implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("status")
    public ax.N9.a c;
    @a
    @c("externalAudience")
    public x d;
    @a
    @c("scheduledStartDateTime")
    public DateTimeTimeZone e;
    @a
    @c("scheduledEndDateTime")
    public DateTimeTimeZone f;
    @a
    @c("internalReplyMessage")
    public String g;
    @a
    @c("externalReplyMessage")
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
