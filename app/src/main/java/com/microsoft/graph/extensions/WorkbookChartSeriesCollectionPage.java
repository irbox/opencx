package com.microsoft.graph.extensions;

import ax.N9.H0;
import com.microsoft.graph.generated.BaseWorkbookChartSeriesCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseWorkbookChartSeriesCollectionPage;

public class WorkbookChartSeriesCollectionPage extends BaseWorkbookChartSeriesCollectionPage implements IBaseCollectionPage
{
    public WorkbookChartSeriesCollectionPage(final BaseWorkbookChartSeriesCollectionResponse baseWorkbookChartSeriesCollectionResponse, final H0 h0) {
        super(baseWorkbookChartSeriesCollectionResponse, h0);
    }
}
