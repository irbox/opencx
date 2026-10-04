package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.N0;
import com.microsoft.graph.extensions.WorkbookWorksheet;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseWorkbookWorksheetCollectionPage extends BaseCollectionPage<WorkbookWorksheet, N0> implements IBaseCollectionPage
{
    public BaseWorkbookWorksheetCollectionPage(final BaseWorkbookWorksheetCollectionResponse baseWorkbookWorksheetCollectionResponse, final N0 n0) {
        super((List)baseWorkbookWorksheetCollectionResponse.a, (p)n0);
    }
}
