package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.I0;
import com.microsoft.graph.extensions.WorkbookNamedItem;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseWorkbookNamedItemCollectionPage extends BaseCollectionPage<WorkbookNamedItem, I0> implements IBaseCollectionPage
{
    public BaseWorkbookNamedItemCollectionPage(final BaseWorkbookNamedItemCollectionResponse baseWorkbookNamedItemCollectionResponse, final I0 i0) {
        super((List)baseWorkbookNamedItemCollectionResponse.a, (p)i0);
    }
}
