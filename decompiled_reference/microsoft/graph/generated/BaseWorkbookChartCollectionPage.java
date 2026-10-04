package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.F0;
import com.microsoft.graph.extensions.WorkbookChart;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseWorkbookChartCollectionPage extends BaseCollectionPage<WorkbookChart, F0> implements IBaseCollectionPage
{
    public BaseWorkbookChartCollectionPage(final BaseWorkbookChartCollectionResponse baseWorkbookChartCollectionResponse, final F0 f0) {
        super((List)baseWorkbookChartCollectionResponse.a, (p)f0);
    }
}
