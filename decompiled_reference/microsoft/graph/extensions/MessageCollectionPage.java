package com.microsoft.graph.extensions;

import ax.N9.k0;
import com.microsoft.graph.generated.BaseMessageCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseMessageCollectionPage;

public class MessageCollectionPage extends BaseMessageCollectionPage implements IBaseCollectionPage
{
    public MessageCollectionPage(final BaseMessageCollectionResponse baseMessageCollectionResponse, final k0 k0) {
        super(baseMessageCollectionResponse, k0);
    }
}
