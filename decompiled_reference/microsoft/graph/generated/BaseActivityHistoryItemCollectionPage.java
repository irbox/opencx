package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.B;
import com.microsoft.graph.extensions.ActivityHistoryItem;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseActivityHistoryItemCollectionPage extends BaseCollectionPage<ActivityHistoryItem, B> implements IBaseCollectionPage
{
    public BaseActivityHistoryItemCollectionPage(final BaseActivityHistoryItemCollectionResponse baseActivityHistoryItemCollectionResponse, final B b) {
        super((java.util.List<Object>)baseActivityHistoryItemCollectionResponse.a, (p)b);
    }
}
