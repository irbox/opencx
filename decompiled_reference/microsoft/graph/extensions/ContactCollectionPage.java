package com.microsoft.graph.extensions;

import ax.N9.H;
import com.microsoft.graph.generated.BaseContactCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseContactCollectionPage;

public class ContactCollectionPage extends BaseContactCollectionPage implements IBaseCollectionPage
{
    public ContactCollectionPage(final BaseContactCollectionResponse baseContactCollectionResponse, final H h) {
        super(baseContactCollectionResponse, h);
    }
}
