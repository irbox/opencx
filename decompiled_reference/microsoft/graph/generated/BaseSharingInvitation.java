package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.IdentitySet;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseSharingInvitation implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("email")
    public String c;
    @a
    @c("invitedBy")
    public IdentitySet d;
    @a
    @c("redeemedBy")
    public String e;
    @a
    @c("signInRequired")
    public Boolean f;
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
