package com.microsoft.graph.extensions;

import ax.N9.C;
import com.microsoft.graph.generated.BaseAttachmentCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseAttachmentCollectionPage;

public class AttachmentCollectionPage extends BaseAttachmentCollectionPage implements IBaseCollectionPage
{
    public AttachmentCollectionPage(final BaseAttachmentCollectionResponse baseAttachmentCollectionResponse, final C c) {
        super(baseAttachmentCollectionResponse, c);
    }
}
