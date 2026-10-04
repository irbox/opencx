package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.K;
import com.microsoft.graph.extensions.DirectoryObject;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseDirectoryObjectCollectionPage extends BaseCollectionPage<DirectoryObject, K> implements IBaseCollectionPage
{
    public BaseDirectoryObjectCollectionPage(final BaseDirectoryObjectCollectionResponse baseDirectoryObjectCollectionResponse, final K k) {
        super((java.util.List<Object>)baseDirectoryObjectCollectionResponse.a, (p)k);
    }
}
