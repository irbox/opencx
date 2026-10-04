package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.M0;
import com.microsoft.graph.extensions.WorkbookTableRow;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseWorkbookTableRowCollectionPage extends BaseCollectionPage<WorkbookTableRow, M0> implements IBaseCollectionPage
{
    public BaseWorkbookTableRowCollectionPage(final BaseWorkbookTableRowCollectionResponse baseWorkbookTableRowCollectionResponse, final M0 m0) {
        super((List)baseWorkbookTableRowCollectionResponse.a, (p)m0);
    }
}
