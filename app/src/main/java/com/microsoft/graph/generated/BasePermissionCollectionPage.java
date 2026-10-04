package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.t0;
import com.microsoft.graph.extensions.Permission;
import com.microsoft.graph.http.BaseCollectionPage;

public class BasePermissionCollectionPage extends BaseCollectionPage<Permission, t0> implements IBaseCollectionPage
{
    public BasePermissionCollectionPage(final BasePermissionCollectionResponse basePermissionCollectionResponse, final t0 t0) {
        super((java.util.List<Object>)basePermissionCollectionResponse.a, (p)t0);
    }
}
