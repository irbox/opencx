package com.microsoft.graph.extensions;

import ax.N9.c0;
import com.microsoft.graph.generated.BaseEventCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseEventCollectionPage;

public class EventCollectionPage extends BaseEventCollectionPage implements IBaseCollectionPage
{
    public EventCollectionPage(final BaseEventCollectionResponse baseEventCollectionResponse, final c0 c0) {
        super(baseEventCollectionResponse, c0);
    }
}
