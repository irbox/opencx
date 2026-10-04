package com.microsoft.graph.extensions;

import ax.N9.L;
import com.microsoft.graph.generated.BaseDriveCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseDriveCollectionPage;

public class DriveCollectionPage extends BaseDriveCollectionPage implements IBaseCollectionPage
{
    public DriveCollectionPage(final BaseDriveCollectionResponse baseDriveCollectionResponse, final L l) {
        super(baseDriveCollectionResponse, l);
    }
}
