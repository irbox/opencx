package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.C;
import com.microsoft.graph.extensions.Attachment;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseAttachmentCollectionPage extends BaseCollectionPage<Attachment, C> implements IBaseCollectionPage
{
    public BaseAttachmentCollectionPage(final BaseAttachmentCollectionResponse baseAttachmentCollectionResponse, final C c) {
        super((java.util.List<Object>)baseAttachmentCollectionResponse.a, (p)c);
    }
}
