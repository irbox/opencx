package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.G;
import com.microsoft.graph.extensions.ColumnLink;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseColumnLinkCollectionPage extends BaseCollectionPage<ColumnLink, G> implements IBaseCollectionPage
{
    public BaseColumnLinkCollectionPage(final BaseColumnLinkCollectionResponse baseColumnLinkCollectionResponse, final G g) {
        super((java.util.List<Object>)baseColumnLinkCollectionResponse.a, (p)g);
    }
}
