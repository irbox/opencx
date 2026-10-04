package com.microsoft.graph.extensions;

import ax.N9.I;
import com.microsoft.graph.generated.BaseContactFolderCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseContactFolderCollectionPage;

public class ContactFolderCollectionPage extends BaseContactFolderCollectionPage implements IBaseCollectionPage
{
    public ContactFolderCollectionPage(final BaseContactFolderCollectionResponse baseContactFolderCollectionResponse, final I i) {
        super(baseContactFolderCollectionResponse, i);
    }
}
