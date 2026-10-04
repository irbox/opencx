package com.microsoft.graph.extensions;

import ax.N9.d0;
import com.microsoft.graph.generated.BaseExtensionCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseExtensionCollectionPage;

public class ExtensionCollectionPage extends BaseExtensionCollectionPage implements IBaseCollectionPage
{
    public ExtensionCollectionPage(final BaseExtensionCollectionResponse baseExtensionCollectionResponse, final d0 d0) {
        super(baseExtensionCollectionResponse, d0);
    }
}
