package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.F;
import com.microsoft.graph.extensions.ColumnDefinition;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseColumnDefinitionCollectionPage extends BaseCollectionPage<ColumnDefinition, F> implements IBaseCollectionPage
{
    public BaseColumnDefinitionCollectionPage(final BaseColumnDefinitionCollectionResponse baseColumnDefinitionCollectionResponse, final F f) {
        super((java.util.List<Object>)baseColumnDefinitionCollectionResponse.a, (p)f);
    }
}
