package com.microsoft.graph.extensions;

import ax.N9.w0;
import com.microsoft.graph.generated.BasePlannerPlanCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BasePlannerPlanCollectionPage;

public class PlannerPlanCollectionPage extends BasePlannerPlanCollectionPage implements IBaseCollectionPage
{
    public PlannerPlanCollectionPage(final BasePlannerPlanCollectionResponse basePlannerPlanCollectionResponse, final w0 w0) {
        super(basePlannerPlanCollectionResponse, w0);
    }
}
