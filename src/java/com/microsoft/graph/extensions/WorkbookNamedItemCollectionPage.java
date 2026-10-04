package com.microsoft.graph.extensions;

import ax.N9.I0;
import com.microsoft.graph.generated.BaseWorkbookNamedItemCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseWorkbookNamedItemCollectionPage;

public class WorkbookNamedItemCollectionPage extends BaseWorkbookNamedItemCollectionPage implements IBaseCollectionPage
{
    public WorkbookNamedItemCollectionPage(final BaseWorkbookNamedItemCollectionResponse baseWorkbookNamedItemCollectionResponse, final I0 i0) {
        super(baseWorkbookNamedItemCollectionResponse, i0);
    }
}
