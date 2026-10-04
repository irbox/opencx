package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.PublicationFacet;
import java.util.Calendar;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.IdentitySet;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseBaseItemVersion extends Entity implements d
{
    @a
    @c("lastModifiedBy")
    public IdentitySet f;
    @a
    @c("lastModifiedDateTime")
    public Calendar g;
    @a
    @c("publication")
    public PublicationFacet h;
    private transient l i;
    private transient e j;
    
    public void d(final e j, final l i) {
        this.j = j;
        this.i = i;
    }
}
