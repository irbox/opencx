package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.h0;
import com.microsoft.graph.extensions.ListItem;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseListItemCollectionPage extends BaseCollectionPage<ListItem, h0> implements IBaseCollectionPage
{
    public BaseListItemCollectionPage(final BaseListItemCollectionResponse baseListItemCollectionResponse, final h0 h0) {
        super((java.util.List<Object>)baseListItemCollectionResponse.a, (p)h0);
    }
}
