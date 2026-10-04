package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.D;
import com.microsoft.graph.extensions.Calendar;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseCalendarCollectionPage extends BaseCollectionPage<Calendar, D> implements IBaseCollectionPage
{
    public BaseCalendarCollectionPage(final BaseCalendarCollectionResponse baseCalendarCollectionResponse, final D d) {
        super((java.util.List<Object>)baseCalendarCollectionResponse.a, (p)d);
    }
}
