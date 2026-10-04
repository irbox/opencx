package com.microsoft.graph.extensions;

import ax.N9.v0;
import com.microsoft.graph.generated.BasePlannerBucketCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BasePlannerBucketCollectionPage;

public class PlannerBucketCollectionPage extends BasePlannerBucketCollectionPage implements IBaseCollectionPage
{
    public PlannerBucketCollectionPage(final BasePlannerBucketCollectionResponse basePlannerBucketCollectionResponse, final v0 v0) {
        super(basePlannerBucketCollectionResponse, v0);
    }
}
