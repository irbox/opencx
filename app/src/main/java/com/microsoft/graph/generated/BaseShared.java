package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import java.util.Calendar;
import com.microsoft.graph.extensions.IdentitySet;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseShared implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("owner")
    public IdentitySet c;
    @a
    @c("scope")
    public String d;
    @a
    @c("sharedBy")
    public IdentitySet e;
    @a
    @c("sharedDateTime")
    public Calendar f;
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
