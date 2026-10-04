package com.microsoft.graph.extensions;

import ax.N9.F0;
import com.microsoft.graph.generated.BaseWorkbookChartCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseWorkbookChartCollectionPage;

public class WorkbookChartCollectionPage extends BaseWorkbookChartCollectionPage implements IBaseCollectionPage
{
    public WorkbookChartCollectionPage(final BaseWorkbookChartCollectionResponse baseWorkbookChartCollectionResponse, final F0 f0) {
        super(baseWorkbookChartCollectionResponse, f0);
    }
}
