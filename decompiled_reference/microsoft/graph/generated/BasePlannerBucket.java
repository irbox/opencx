package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.x0;
import java.util.Arrays;
import com.microsoft.graph.extensions.PlannerTask;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.PlannerTaskCollectionPage;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BasePlannerBucket extends Entity implements d
{
    @a
    @c("name")
    public String f;
    @a
    @c("planId")
    public String g;
    @a
    @c("orderHint")
    public String h;
    public transient PlannerTaskCollectionPage i;
    private transient l j;
    private transient e k;
    
    public void d(final e k, final l j) {
        this.k = k;
        this.j = j;
        if (j.x("tasks")) {
            final BasePlannerTaskCollectionResponse basePlannerTaskCollectionResponse = new BasePlannerTaskCollectionResponse();
            if (j.x("tasks@odata.nextLink")) {
                basePlannerTaskCollectionResponse.b = j.t("tasks@odata.nextLink").k();
            }
            final l[] array = (l[])k.b(j.t("tasks").toString(), (Class)l[].class);
            final PlannerTask[] array2 = new PlannerTask[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (PlannerTask)k.b(((i)array[i]).toString(), (Class)PlannerTask.class)).d(k, array[i]);
            }
            basePlannerTaskCollectionResponse.a = Arrays.asList((Object[])array2);
            this.i = new PlannerTaskCollectionPage(basePlannerTaskCollectionResponse, null);
        }
    }
}
