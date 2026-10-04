package com.microsoft.graph.extensions;

import ax.N9.C0;
import com.microsoft.graph.generated.BaseUserActivityCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseUserActivityCollectionPage;

public class UserActivityCollectionPage extends BaseUserActivityCollectionPage implements IBaseCollectionPage
{
    public UserActivityCollectionPage(final BaseUserActivityCollectionResponse baseUserActivityCollectionResponse, final C0 c0) {
        super(baseUserActivityCollectionResponse, c0);
    }
}
