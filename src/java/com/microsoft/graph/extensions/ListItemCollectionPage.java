package com.microsoft.graph.extensions;

import ax.N9.h0;
import com.microsoft.graph.generated.BaseListItemCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseListItemCollectionPage;

public class ListItemCollectionPage extends BaseListItemCollectionPage implements IBaseCollectionPage
{
    public ListItemCollectionPage(final BaseListItemCollectionResponse baseListItemCollectionResponse, final h0 h0) {
        super(baseListItemCollectionResponse, h0);
    }
}
