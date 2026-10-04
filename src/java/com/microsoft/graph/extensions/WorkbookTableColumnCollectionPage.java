package com.microsoft.graph.extensions;

import ax.N9.L0;
import com.microsoft.graph.generated.BaseWorkbookTableColumnCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseWorkbookTableColumnCollectionPage;

public class WorkbookTableColumnCollectionPage extends BaseWorkbookTableColumnCollectionPage implements IBaseCollectionPage
{
    public WorkbookTableColumnCollectionPage(final BaseWorkbookTableColumnCollectionResponse baseWorkbookTableColumnCollectionResponse, final L0 l0) {
        super(baseWorkbookTableColumnCollectionResponse, l0);
    }
}
