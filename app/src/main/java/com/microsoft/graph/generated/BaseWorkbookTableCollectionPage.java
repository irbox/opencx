package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.K0;
import com.microsoft.graph.extensions.WorkbookTable;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseWorkbookTableCollectionPage extends BaseCollectionPage<WorkbookTable, K0> implements IBaseCollectionPage
{
    public BaseWorkbookTableCollectionPage(final BaseWorkbookTableCollectionResponse baseWorkbookTableCollectionResponse, final K0 k0) {
        super((List)baseWorkbookTableCollectionResponse.a, (p)k0);
    }
}
