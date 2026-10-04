package com.microsoft.graph.extensions;

import ax.N9.J0;
import com.microsoft.graph.generated.BaseWorkbookPivotTableCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseWorkbookPivotTableCollectionPage;

public class WorkbookPivotTableCollectionPage extends BaseWorkbookPivotTableCollectionPage implements IBaseCollectionPage
{
    public WorkbookPivotTableCollectionPage(final BaseWorkbookPivotTableCollectionResponse baseWorkbookPivotTableCollectionResponse, final J0 j0) {
        super(baseWorkbookPivotTableCollectionResponse, j0);
    }
}
