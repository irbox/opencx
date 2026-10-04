package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import java.util.List;
import com.microsoft.graph.extensions.SharingLink;
import com.microsoft.graph.extensions.SharingInvitation;
import com.microsoft.graph.extensions.ItemReference;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.IdentitySet;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BasePermission extends Entity implements d
{
    @a
    @c("grantedTo")
    public IdentitySet f;
    @a
    @c("inheritedFrom")
    public ItemReference g;
    @a
    @c("invitation")
    public SharingInvitation h;
    @a
    @c("link")
    public SharingLink i;
    @a
    @c("roles")
    public List<String> j;
    @a
    @c("shareId")
    public String k;
    private transient l l;
    private transient e m;
    
    public void d(final e m, final l l) {
        this.m = m;
        this.l = l;
    }
}
