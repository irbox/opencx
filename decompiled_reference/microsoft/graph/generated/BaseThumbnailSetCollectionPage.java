package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.B0;
import com.microsoft.graph.extensions.ThumbnailSet;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseThumbnailSetCollectionPage extends BaseCollectionPage<ThumbnailSet, B0> implements IBaseCollectionPage
{
    public BaseThumbnailSetCollectionPage(final BaseThumbnailSetCollectionResponse baseThumbnailSetCollectionResponse, final B0 b0) {
        super((List)baseThumbnailSetCollectionResponse.a, (p)b0);
    }
}
