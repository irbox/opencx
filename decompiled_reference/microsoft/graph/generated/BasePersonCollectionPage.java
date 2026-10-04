package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.u0;
import com.microsoft.graph.extensions.Person;
import com.microsoft.graph.http.BaseCollectionPage;

public class BasePersonCollectionPage extends BaseCollectionPage<Person, u0> implements IBaseCollectionPage
{
    public BasePersonCollectionPage(final BasePersonCollectionResponse basePersonCollectionResponse, final u0 u0) {
        super((java.util.List<Object>)basePersonCollectionResponse.a, (p)u0);
    }
}
