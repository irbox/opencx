package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.w0;
import com.microsoft.graph.extensions.PlannerPlan;
import ax.N9.x0;
import java.util.Arrays;
import com.microsoft.graph.extensions.PlannerTask;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.PlannerPlanCollectionPage;
import com.microsoft.graph.extensions.PlannerTaskCollectionPage;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BasePlannerUser extends Entity implements d
{
    public transient PlannerTaskCollectionPage f;
    public transient PlannerPlanCollectionPage g;
    private transient l h;
    private transient e i;
    
    public void d(final e i, final l h) {
        this.i = i;
        this.h = h;
        final boolean x = h.x("tasks");
        final int n = 0;
        if (x) {
            final BasePlannerTaskCollectionResponse basePlannerTaskCollectionResponse = new BasePlannerTaskCollectionResponse();
            if (h.x("tasks@odata.nextLink")) {
                basePlannerTaskCollectionResponse.b = h.t("tasks@odata.nextLink").k();
            }
            final l[] array = (l[])i.b(h.t("tasks").toString(), (Class)l[].class);
            final PlannerTask[] array2 = new PlannerTask[array.length];
            for (int j = 0; j < array.length; ++j) {
                (array2[j] = (PlannerTask)i.b(((i)array[j]).toString(), (Class)PlannerTask.class)).d(i, array[j]);
            }
            basePlannerTaskCollectionResponse.a = Arrays.asList((Object[])array2);
            this.f = new PlannerTaskCollectionPage(basePlannerTaskCollectionResponse, null);
        }
        if (h.x("plans")) {
            final BasePlannerPlanCollectionResponse basePlannerPlanCollectionResponse = new BasePlannerPlanCollectionResponse();
            if (h.x("plans@odata.nextLink")) {
                basePlannerPlanCollectionResponse.b = h.t("plans@odata.nextLink").k();
            }
            final l[] array3 = (l[])i.b(h.t("plans").toString(), (Class)l[].class);
            final PlannerPlan[] array4 = new PlannerPlan[array3.length];
            for (int k = n; k < array3.length; ++k) {
                (array4[k] = (PlannerPlan)i.b(((i)array3[k]).toString(), (Class)PlannerPlan.class)).d(i, array3[k]);
            }
            basePlannerPlanCollectionResponse.a = Arrays.asList((Object[])array4);
            this.g = new PlannerPlanCollectionPage(basePlannerPlanCollectionResponse, null);
        }
    }
}
