package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.L0;
import com.microsoft.graph.extensions.WorkbookTableColumn;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseWorkbookTableColumnCollectionPage extends BaseCollectionPage<WorkbookTableColumn, L0> implements IBaseCollectionPage
{
    public BaseWorkbookTableColumnCollectionPage(final BaseWorkbookTableColumnCollectionResponse baseWorkbookTableColumnCollectionResponse, final L0 l0) {
        super((List)baseWorkbookTableColumnCollectionResponse.a, (p)l0);
    }
}
