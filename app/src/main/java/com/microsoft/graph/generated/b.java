package com.microsoft.graph.generated;

import ax.N9.W;
import com.microsoft.graph.extensions.DriveItemSearchCollectionPage;
import ax.N9.r;
import ax.M9.d;
import ax.S9.c;
import java.util.List;
import ax.M9.f;
import ax.O9.z;
import com.microsoft.graph.extensions.IDriveItemSearchCollectionPage;
import ax.P9.a;

public class b extends a<BaseDriveItemSearchCollectionResponse, IDriveItemSearchCollectionPage> implements z
{
    public b(final String s, final f f, final List<c> list) {
        super(s, f, list, BaseDriveItemSearchCollectionResponse.class, IDriveItemSearchCollectionPage.class);
    }
    
    @Override
    public IDriveItemSearchCollectionPage get() throws d {
        return this.o(((a<BaseDriveItemSearchCollectionResponse, T2>)this).n());
    }
    
    public IDriveItemSearchCollectionPage o(final BaseDriveItemSearchCollectionResponse baseDriveItemSearchCollectionResponse) {
        final String b = baseDriveItemSearchCollectionResponse.b;
        W w = null;
        if (b != null) {
            w = new r(b, this.m().m(), null, null);
        }
        final DriveItemSearchCollectionPage driveItemSearchCollectionPage = new DriveItemSearchCollectionPage(baseDriveItemSearchCollectionResponse, w);
        ((ax.T9.d)driveItemSearchCollectionPage).d(baseDriveItemSearchCollectionResponse.f(), baseDriveItemSearchCollectionResponse.e());
        return (IDriveItemSearchCollectionPage)driveItemSearchCollectionPage;
    }
}
