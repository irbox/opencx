package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.C0;
import com.microsoft.graph.extensions.UserActivity;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseUserActivityCollectionPage extends BaseCollectionPage<UserActivity, C0> implements IBaseCollectionPage
{
    public BaseUserActivityCollectionPage(final BaseUserActivityCollectionResponse baseUserActivityCollectionResponse, final C0 c0) {
        super((List)baseUserActivityCollectionResponse.a, (p)c0);
    }
}
