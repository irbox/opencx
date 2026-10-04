package com.microsoft.graph.extensions;

import ax.N9.N0;
import com.microsoft.graph.generated.BaseWorkbookWorksheetCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseWorkbookWorksheetCollectionPage;

public class WorkbookWorksheetCollectionPage extends BaseWorkbookWorksheetCollectionPage implements IBaseCollectionPage
{
    public WorkbookWorksheetCollectionPage(final BaseWorkbookWorksheetCollectionResponse baseWorkbookWorksheetCollectionResponse, final N0 n0) {
        super(baseWorkbookWorksheetCollectionResponse, n0);
    }
}
