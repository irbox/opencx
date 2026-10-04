package com.microsoft.graph.extensions;

import ax.N9.F;
import com.microsoft.graph.generated.BaseColumnDefinitionCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseColumnDefinitionCollectionPage;

public class ColumnDefinitionCollectionPage extends BaseColumnDefinitionCollectionPage implements IBaseCollectionPage
{
    public ColumnDefinitionCollectionPage(final BaseColumnDefinitionCollectionResponse baseColumnDefinitionCollectionResponse, final F f) {
        super(baseColumnDefinitionCollectionResponse, f);
    }
}
