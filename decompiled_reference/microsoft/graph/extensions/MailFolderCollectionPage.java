package com.microsoft.graph.extensions;

import ax.N9.j0;
import com.microsoft.graph.generated.BaseMailFolderCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseMailFolderCollectionPage;

public class MailFolderCollectionPage extends BaseMailFolderCollectionPage implements IBaseCollectionPage
{
    public MailFolderCollectionPage(final BaseMailFolderCollectionResponse baseMailFolderCollectionResponse, final j0 j0) {
        super(baseMailFolderCollectionResponse, j0);
    }
}
