package com.microsoft.graph.extensions;

import ax.N9.g0;
import com.microsoft.graph.generated.BaseLicenseDetailsCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseLicenseDetailsCollectionPage;

public class LicenseDetailsCollectionPage extends BaseLicenseDetailsCollectionPage implements IBaseCollectionPage
{
    public LicenseDetailsCollectionPage(final BaseLicenseDetailsCollectionResponse baseLicenseDetailsCollectionResponse, final g0 g0) {
        super(baseLicenseDetailsCollectionResponse, g0);
    }
}
