package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.E;
import com.microsoft.graph.extensions.CalendarGroup;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseCalendarGroupCollectionPage extends BaseCollectionPage<CalendarGroup, E> implements IBaseCollectionPage
{
    public BaseCalendarGroupCollectionPage(final BaseCalendarGroupCollectionResponse baseCalendarGroupCollectionResponse, final E e) {
        super((java.util.List<Object>)baseCalendarGroupCollectionResponse.a, (p)e);
    }
}
