package com.microsoft.graph.extensions;

import ax.N9.G;
import com.microsoft.graph.generated.BaseColumnLinkCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseColumnLinkCollectionPage;

public class ColumnLinkCollectionPage extends BaseColumnLinkCollectionPage implements IBaseCollectionPage
{
    public ColumnLinkCollectionPage(final BaseColumnLinkCollectionResponse baseColumnLinkCollectionResponse, final G g) {
        super(baseColumnLinkCollectionResponse, g);
    }
}
