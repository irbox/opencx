package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.L;
import com.microsoft.graph.extensions.Drive;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseDriveCollectionPage extends BaseCollectionPage<Drive, L> implements IBaseCollectionPage
{
    public BaseDriveCollectionPage(final BaseDriveCollectionResponse baseDriveCollectionResponse, final L l) {
        super((java.util.List<Object>)baseDriveCollectionResponse.a, (p)l);
    }
}
