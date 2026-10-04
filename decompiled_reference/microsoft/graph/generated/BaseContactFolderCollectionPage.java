package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.I;
import com.microsoft.graph.extensions.ContactFolder;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseContactFolderCollectionPage extends BaseCollectionPage<ContactFolder, I> implements IBaseCollectionPage
{
    public BaseContactFolderCollectionPage(final BaseContactFolderCollectionResponse baseContactFolderCollectionResponse, final I i) {
        super((java.util.List<Object>)baseContactFolderCollectionResponse.a, (p)i);
    }
}
