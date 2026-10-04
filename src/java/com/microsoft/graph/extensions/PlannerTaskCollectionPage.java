package com.microsoft.graph.extensions;

import ax.N9.x0;
import com.microsoft.graph.generated.BasePlannerTaskCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BasePlannerTaskCollectionPage;

public class PlannerTaskCollectionPage extends BasePlannerTaskCollectionPage implements IBaseCollectionPage
{
    public PlannerTaskCollectionPage(final BasePlannerTaskCollectionResponse basePlannerTaskCollectionResponse, final x0 x0) {
        super(basePlannerTaskCollectionResponse, x0);
    }
}
