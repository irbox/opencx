package com.microsoft.graph.extensions;

import ax.N9.B;
import com.microsoft.graph.generated.BaseActivityHistoryItemCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseActivityHistoryItemCollectionPage;

public class ActivityHistoryItemCollectionPage extends BaseActivityHistoryItemCollectionPage implements IBaseCollectionPage
{
    public ActivityHistoryItemCollectionPage(final BaseActivityHistoryItemCollectionResponse baseActivityHistoryItemCollectionResponse, final B b) {
        super(baseActivityHistoryItemCollectionResponse, b);
    }
}
