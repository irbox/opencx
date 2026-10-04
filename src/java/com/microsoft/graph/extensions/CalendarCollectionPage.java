package com.microsoft.graph.extensions;

import ax.N9.D;
import com.microsoft.graph.generated.BaseCalendarCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseCalendarCollectionPage;

public class CalendarCollectionPage extends BaseCalendarCollectionPage implements IBaseCollectionPage
{
    public CalendarCollectionPage(final BaseCalendarCollectionResponse baseCalendarCollectionResponse, final D d) {
        super(baseCalendarCollectionResponse, d);
    }
}
