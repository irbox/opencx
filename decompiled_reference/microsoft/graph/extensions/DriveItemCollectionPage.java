package com.microsoft.graph.extensions;

import ax.N9.N;
import com.microsoft.graph.generated.BaseDriveItemCollectionResponse;
import com.microsoft.graph.generated.BaseDriveItemCollectionPage;

public class DriveItemCollectionPage extends BaseDriveItemCollectionPage implements IDriveItemCollectionPage
{
    public DriveItemCollectionPage(final BaseDriveItemCollectionResponse baseDriveItemCollectionResponse, final N n) {
        super(baseDriveItemCollectionResponse, n);
    }
}
