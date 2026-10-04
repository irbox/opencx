package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.PlannerChecklistItems;
import com.microsoft.graph.extensions.PlannerExternalReferences;
import ax.N9.V0;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BasePlannerTaskDetails extends Entity implements d
{
    @a
    @c("description")
    public String f;
    @a
    @c("previewType")
    public V0 g;
    @a
    @c("references")
    public PlannerExternalReferences h;
    @a
    @c("checklist")
    public PlannerChecklistItems i;
    private transient l j;
    private transient e k;
    
    public void d(final e k, final l j) {
        this.k = k;
        this.j = j;
    }
}
