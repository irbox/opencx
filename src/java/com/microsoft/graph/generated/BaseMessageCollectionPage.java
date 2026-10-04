package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.k0;
import com.microsoft.graph.extensions.Message;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseMessageCollectionPage extends BaseCollectionPage<Message, k0> implements IBaseCollectionPage
{
    public BaseMessageCollectionPage(final BaseMessageCollectionResponse baseMessageCollectionResponse, final k0 k0) {
        super((java.util.List<Object>)baseMessageCollectionResponse.a, (p)k0);
    }
}
