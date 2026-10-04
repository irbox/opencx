package com.microsoft.graph.extensions;

import ax.N9.B0;
import com.microsoft.graph.generated.BaseThumbnailSetCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseThumbnailSetCollectionPage;

public class ThumbnailSetCollectionPage extends BaseThumbnailSetCollectionPage implements IBaseCollectionPage
{
    public ThumbnailSetCollectionPage(final BaseThumbnailSetCollectionResponse baseThumbnailSetCollectionResponse, final B0 b0) {
        super(baseThumbnailSetCollectionResponse, b0);
    }
}
