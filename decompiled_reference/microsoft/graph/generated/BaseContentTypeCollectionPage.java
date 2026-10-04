package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.J;
import com.microsoft.graph.extensions.ContentType;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseContentTypeCollectionPage extends BaseCollectionPage<ContentType, J> implements IBaseCollectionPage
{
    public BaseContentTypeCollectionPage(final BaseContentTypeCollectionResponse baseContentTypeCollectionResponse, final J j) {
        super((java.util.List<Object>)baseContentTypeCollectionResponse.a, (p)j);
    }
}
