package com.microsoft.graph.extensions;

import ax.N9.t0;
import com.microsoft.graph.generated.BasePermissionCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BasePermissionCollectionPage;

public class PermissionCollectionPage extends BasePermissionCollectionPage implements IBaseCollectionPage
{
    public PermissionCollectionPage(final BasePermissionCollectionResponse basePermissionCollectionResponse, final t0 t0) {
        super(basePermissionCollectionResponse, t0);
    }
}
