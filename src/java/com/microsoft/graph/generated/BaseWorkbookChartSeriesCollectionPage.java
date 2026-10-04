package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.H0;
import com.microsoft.graph.extensions.WorkbookChartSeries;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseWorkbookChartSeriesCollectionPage extends BaseCollectionPage<WorkbookChartSeries, H0> implements IBaseCollectionPage
{
    public BaseWorkbookChartSeriesCollectionPage(final BaseWorkbookChartSeriesCollectionResponse baseWorkbookChartSeriesCollectionResponse, final H0 h0) {
        super((List)baseWorkbookChartSeriesCollectionResponse.a, (p)h0);
    }
}
