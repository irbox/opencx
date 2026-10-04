package com.microsoft.graph.extensions;

import ax.N9.E;
import com.microsoft.graph.generated.BaseCalendarGroupCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseCalendarGroupCollectionPage;

public class CalendarGroupCollectionPage extends BaseCalendarGroupCollectionPage implements IBaseCollectionPage
{
    public CalendarGroupCollectionPage(final BaseCalendarGroupCollectionResponse baseCalendarGroupCollectionResponse, final E e) {
        super(baseCalendarGroupCollectionResponse, e);
    }
}
