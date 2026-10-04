package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import java.util.Calendar;
import com.microsoft.graph.extensions.IdentitySet;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.OnenoteEntitySchemaObjectModel;

public class BaseOnenoteEntityHierarchyModel extends OnenoteEntitySchemaObjectModel implements d
{
    @a
    @c("displayName")
    public String l;
    @a
    @c("createdBy")
    public IdentitySet m;
    @a
    @c("lastModifiedBy")
    public IdentitySet n;
    @a
    @c("lastModifiedDateTime")
    public Calendar o;
    private transient l p;
    private transient e q;
    
    public void d(final e q, final l p2) {
        this.q = q;
        this.p = p2;
    }
}
