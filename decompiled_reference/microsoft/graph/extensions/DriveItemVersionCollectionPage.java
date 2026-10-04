package com.microsoft.graph.extensions;

import ax.N9.Z;
import com.microsoft.graph.generated.BaseDriveItemVersionCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseDriveItemVersionCollectionPage;

public class DriveItemVersionCollectionPage extends BaseDriveItemVersionCollectionPage implements IBaseCollectionPage
{
    public DriveItemVersionCollectionPage(final BaseDriveItemVersionCollectionResponse baseDriveItemVersionCollectionResponse, final Z z) {
        super(baseDriveItemVersionCollectionResponse, z);
    }
}
