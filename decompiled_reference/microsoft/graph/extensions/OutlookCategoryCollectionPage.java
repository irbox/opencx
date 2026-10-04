package com.microsoft.graph.extensions;

import ax.N9.s0;
import com.microsoft.graph.generated.BaseOutlookCategoryCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseOutlookCategoryCollectionPage;

public class OutlookCategoryCollectionPage extends BaseOutlookCategoryCollectionPage implements IBaseCollectionPage
{
    public OutlookCategoryCollectionPage(final BaseOutlookCategoryCollectionResponse baseOutlookCategoryCollectionResponse, final s0 s0) {
        super(baseOutlookCategoryCollectionResponse, s0);
    }
}
