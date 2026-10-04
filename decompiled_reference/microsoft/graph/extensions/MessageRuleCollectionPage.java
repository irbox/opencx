package com.microsoft.graph.extensions;

import ax.N9.l0;
import com.microsoft.graph.generated.BaseMessageRuleCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseMessageRuleCollectionPage;

public class MessageRuleCollectionPage extends BaseMessageRuleCollectionPage implements IBaseCollectionPage
{
    public MessageRuleCollectionPage(final BaseMessageRuleCollectionResponse baseMessageRuleCollectionResponse, final l0 l0) {
        super(baseMessageRuleCollectionResponse, l0);
    }
}
