package com.microsoft.graph.extensions;

import ax.N9.J;
import com.microsoft.graph.generated.BaseContentTypeCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseContentTypeCollectionPage;

public class ContentTypeCollectionPage extends BaseContentTypeCollectionPage implements IBaseCollectionPage
{
    public ContentTypeCollectionPage(final BaseContentTypeCollectionResponse baseContentTypeCollectionResponse, final J j) {
        super(baseContentTypeCollectionResponse, j);
    }
}
