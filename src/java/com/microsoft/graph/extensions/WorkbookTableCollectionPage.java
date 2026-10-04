package com.microsoft.graph.extensions;

import ax.N9.K0;
import com.microsoft.graph.generated.BaseWorkbookTableCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseWorkbookTableCollectionPage;

public class WorkbookTableCollectionPage extends BaseWorkbookTableCollectionPage implements IBaseCollectionPage
{
    public WorkbookTableCollectionPage(final BaseWorkbookTableCollectionResponse baseWorkbookTableCollectionResponse, final K0 k0) {
        super(baseWorkbookTableCollectionResponse, k0);
    }
}
