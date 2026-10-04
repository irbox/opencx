package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.N;
import com.microsoft.graph.extensions.DriveItem;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseDriveItemCollectionPage extends BaseCollectionPage<DriveItem, N> implements IBaseCollectionPage
{
    public BaseDriveItemCollectionPage(final BaseDriveItemCollectionResponse baseDriveItemCollectionResponse, final N n) {
        super((java.util.List<Object>)baseDriveItemCollectionResponse.a, (p)n);
    }
}
