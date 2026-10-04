package com.microsoft.graph.extensions;

import ax.N9.M0;
import com.microsoft.graph.generated.BaseWorkbookTableRowCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseWorkbookTableRowCollectionPage;

public class WorkbookTableRowCollectionPage extends BaseWorkbookTableRowCollectionPage implements IBaseCollectionPage
{
    public WorkbookTableRowCollectionPage(final BaseWorkbookTableRowCollectionResponse baseWorkbookTableRowCollectionResponse, final M0 m0) {
        super(baseWorkbookTableRowCollectionResponse, m0);
    }
}
