package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.G0;
import com.microsoft.graph.extensions.WorkbookChartPoint;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseWorkbookChartPointCollectionPage extends BaseCollectionPage<WorkbookChartPoint, G0> implements IBaseCollectionPage
{
    public BaseWorkbookChartPointCollectionPage(final BaseWorkbookChartPointCollectionResponse baseWorkbookChartPointCollectionResponse, final G0 g0) {
        super((List)baseWorkbookChartPointCollectionResponse.a, (p)g0);
    }
}
