package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.H;
import com.microsoft.graph.extensions.Contact;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseContactCollectionPage extends BaseCollectionPage<Contact, H> implements IBaseCollectionPage
{
    public BaseContactCollectionPage(final BaseContactCollectionResponse baseContactCollectionResponse, final H h) {
        super((java.util.List<Object>)baseContactCollectionResponse.a, (p)h);
    }
}
