package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.W;
import com.microsoft.graph.extensions.DriveItem;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseDriveItemSearchCollectionPage extends BaseCollectionPage<DriveItem, W> implements IBaseCollectionPage
{
    public BaseDriveItemSearchCollectionPage(final BaseDriveItemSearchCollectionResponse baseDriveItemSearchCollectionResponse, final W w) {
        super((java.util.List<Object>)baseDriveItemSearchCollectionResponse.a, (p)w);
    }
}
