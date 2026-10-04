package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.J0;
import com.microsoft.graph.extensions.WorkbookPivotTable;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseWorkbookPivotTableCollectionPage extends BaseCollectionPage<WorkbookPivotTable, J0> implements IBaseCollectionPage
{
    public BaseWorkbookPivotTableCollectionPage(final BaseWorkbookPivotTableCollectionResponse baseWorkbookPivotTableCollectionResponse, final J0 j0) {
        super((List)baseWorkbookPivotTableCollectionResponse.a, (p)j0);
    }
}
