package com.microsoft.graph.extensions;

import ax.N9.G0;
import com.microsoft.graph.generated.BaseWorkbookChartPointCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseWorkbookChartPointCollectionPage;

public class WorkbookChartPointCollectionPage extends BaseWorkbookChartPointCollectionPage implements IBaseCollectionPage
{
    public WorkbookChartPointCollectionPage(final BaseWorkbookChartPointCollectionResponse baseWorkbookChartPointCollectionResponse, final G0 g0) {
        super(baseWorkbookChartPointCollectionResponse, g0);
    }
}
