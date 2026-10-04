package com.microsoft.graph.generated;

import com.microsoft.graph.extensions.PlannerTaskDetails;
import com.microsoft.graph.extensions.PlannerAssignments;
import com.microsoft.graph.extensions.PlannerAppliedCategories;
import ax.N9.V0;
import java.util.Calendar;
import com.microsoft.graph.extensions.IdentitySet;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.PlannerBucketTaskBoardTaskFormat;
import com.microsoft.graph.extensions.PlannerProgressTaskBoardTaskFormat;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.PlannerAssignedToTaskBoardTaskFormat;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BasePlannerTask extends Entity implements d
{
    @a
    @c("assignedToTaskBoardFormat")
    public PlannerAssignedToTaskBoardTaskFormat A;
    @a
    @c("progressTaskBoardFormat")
    public PlannerProgressTaskBoardTaskFormat B;
    @a
    @c("bucketTaskBoardFormat")
    public PlannerBucketTaskBoardTaskFormat C;
    private transient l D;
    private transient e E;
    @a
    @c("createdBy")
    public IdentitySet f;
    @a
    @c("planId")
    public String g;
    @a
    @c("bucketId")
    public String h;
    @a
    @c("title")
    public String i;
    @a
    @c("orderHint")
    public String j;
    @a
    @c("assigneePriority")
    public String k;
    @a
    @c("percentComplete")
    public Integer l;
    @a
    @c("startDateTime")
    public Calendar m;
    @a
    @c("createdDateTime")
    public Calendar n;
    @a
    @c("dueDateTime")
    public Calendar o;
    @a
    @c("hasDescription")
    public Boolean p;
    @a
    @c("previewType")
    public V0 q;
    @a
    @c("completedDateTime")
    public Calendar r;
    @a
    @c("completedBy")
    public IdentitySet s;
    @a
    @c("referenceCount")
    public Integer t;
    @a
    @c("checklistItemCount")
    public Integer u;
    @a
    @c("activeChecklistItemCount")
    public Integer v;
    @a
    @c("appliedCategories")
    public PlannerAppliedCategories w;
    @a
    @c("assignments")
    public PlannerAssignments x;
    @a
    @c("conversationThreadId")
    public String y;
    @a
    @c("details")
    public PlannerTaskDetails z;
    
    public void d(final e e, final l d) {
        this.E = e;
        this.D = d;
    }
}
