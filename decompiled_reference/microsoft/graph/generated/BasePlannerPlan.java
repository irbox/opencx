package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.v0;
import com.microsoft.graph.extensions.PlannerBucket;
import ax.N9.x0;
import java.util.Arrays;
import com.microsoft.graph.extensions.PlannerTask;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.PlannerPlanDetails;
import com.microsoft.graph.extensions.PlannerBucketCollectionPage;
import com.microsoft.graph.extensions.PlannerTaskCollectionPage;
import java.util.Calendar;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.IdentitySet;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BasePlannerPlan extends Entity implements d
{
    @a
    @c("createdBy")
    public IdentitySet f;
    @a
    @c("createdDateTime")
    public Calendar g;
    @a
    @c("owner")
    public String h;
    @a
    @c("title")
    public String i;
    public transient PlannerTaskCollectionPage j;
    public transient PlannerBucketCollectionPage k;
    @a
    @c("details")
    public PlannerPlanDetails l;
    private transient l m;
    private transient e n;
    
    public void d(final e n, final l m) {
        this.n = n;
        this.m = m;
        final boolean x = m.x("tasks");
        final int n2 = 0;
        if (x) {
            final BasePlannerTaskCollectionResponse basePlannerTaskCollectionResponse = new BasePlannerTaskCollectionResponse();
            if (m.x("tasks@odata.nextLink")) {
                basePlannerTaskCollectionResponse.b = m.t("tasks@odata.nextLink").k();
            }
            final l[] array = (l[])n.b(m.t("tasks").toString(), (Class)l[].class);
            final PlannerTask[] array2 = new PlannerTask[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (PlannerTask)n.b(((i)array[i]).toString(), (Class)PlannerTask.class)).d(n, array[i]);
            }
            basePlannerTaskCollectionResponse.a = Arrays.asList((Object[])array2);
            this.j = new PlannerTaskCollectionPage(basePlannerTaskCollectionResponse, null);
        }
        if (m.x("buckets")) {
            final BasePlannerBucketCollectionResponse basePlannerBucketCollectionResponse = new BasePlannerBucketCollectionResponse();
            if (m.x("buckets@odata.nextLink")) {
                basePlannerBucketCollectionResponse.b = m.t("buckets@odata.nextLink").k();
            }
            final l[] array3 = (l[])n.b(m.t("buckets").toString(), (Class)l[].class);
            final PlannerBucket[] array4 = new PlannerBucket[array3.length];
            for (int j = n2; j < array3.length; ++j) {
                (array4[j] = (PlannerBucket)n.b(((i)array3[j]).toString(), (Class)PlannerBucket.class)).d(n, array3[j]);
            }
            basePlannerBucketCollectionResponse.a = Arrays.asList((Object[])array4);
            this.k = new PlannerBucketCollectionPage(basePlannerBucketCollectionResponse, null);
        }
    }
}
