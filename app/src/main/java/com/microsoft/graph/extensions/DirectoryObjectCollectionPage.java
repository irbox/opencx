package com.microsoft.graph.extensions;

import ax.N9.K;
import com.microsoft.graph.generated.BaseDirectoryObjectCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseDirectoryObjectCollectionPage;

public class DirectoryObjectCollectionPage extends BaseDirectoryObjectCollectionPage implements IBaseCollectionPage
{
    public DirectoryObjectCollectionPage(final BaseDirectoryObjectCollectionResponse baseDirectoryObjectCollectionResponse, final K k) {
        super(baseDirectoryObjectCollectionResponse, k);
    }
}
