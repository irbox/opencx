package com.microsoft.graph.extensions;

import ax.N9.q0;
import com.microsoft.graph.generated.BaseOnenoteResourceCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseOnenoteResourceCollectionPage;

public class OnenoteResourceCollectionPage extends BaseOnenoteResourceCollectionPage implements IBaseCollectionPage
{
    public OnenoteResourceCollectionPage(final BaseOnenoteResourceCollectionResponse baseOnenoteResourceCollectionResponse, final q0 q0) {
        super(baseOnenoteResourceCollectionResponse, q0);
    }
}
