package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.PlannerOrderHintsByAssignee;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BasePlannerAssignedToTaskBoardTaskFormat extends Entity implements d
{
    @a
    @c("unassignedOrderHint")
    public String f;
    @a
    @c("orderHintsByAssignee")
    public PlannerOrderHintsByAssignee g;
    private transient l h;
    private transient e i;
    
    public void d(final e i, final l h) {
        this.i = i;
        this.h = h;
    }
}
