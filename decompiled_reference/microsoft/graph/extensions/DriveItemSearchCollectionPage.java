package com.microsoft.graph.extensions;

import ax.N9.W;
import com.microsoft.graph.generated.BaseDriveItemSearchCollectionResponse;
import com.microsoft.graph.generated.BaseDriveItemSearchCollectionPage;

public class DriveItemSearchCollectionPage extends BaseDriveItemSearchCollectionPage implements IDriveItemSearchCollectionPage
{
    public DriveItemSearchCollectionPage(final BaseDriveItemSearchCollectionResponse baseDriveItemSearchCollectionResponse, final W w) {
        super(baseDriveItemSearchCollectionResponse, w);
    }
}
