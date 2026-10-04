package com.microsoft.graph.extensions;

import ax.N9.u0;
import com.microsoft.graph.generated.BasePersonCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BasePersonCollectionPage;

public class PersonCollectionPage extends BasePersonCollectionPage implements IBaseCollectionPage
{
    public PersonCollectionPage(final BasePersonCollectionResponse basePersonCollectionResponse, final u0 u0) {
        super(basePersonCollectionResponse, u0);
    }
}
