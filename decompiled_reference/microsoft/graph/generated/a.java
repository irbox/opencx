package com.microsoft.graph.generated;

import com.microsoft.graph.http.BaseCollectionPage;
import ax.N9.N;
import com.microsoft.graph.extensions.DriveItemCollectionPage;
import ax.N9.h;
import ax.N9.g;
import ax.N9.M;
import ax.M9.d;
import ax.N9.p;
import com.microsoft.graph.extensions.DriveItem;
import ax.S9.c;
import java.util.List;
import ax.M9.f;
import ax.O9.r;
import com.microsoft.graph.extensions.IDriveItemCollectionPage;

public class a extends ax.P9.a<BaseDriveItemCollectionResponse, IDriveItemCollectionPage> implements r
{
    public a(final String s, final f f, final List<c> list) {
        super(s, f, list, BaseDriveItemCollectionResponse.class, IDriveItemCollectionPage.class);
    }
    
    @Override
    public DriveItem b(final DriveItem driveItem) throws d {
        return new p(this.m().d().toString(), this.m().m(), null).q(this.m().o()).b(driveItem);
    }
    
    @Override
    public M f(final String s) {
        this.l(new ax.S9.d("$expand", (Object)s));
        return (g)this;
    }
    
    @Override
    public IDriveItemCollectionPage get() throws d {
        return this.o(((ax.P9.a<BaseDriveItemCollectionResponse, T2>)this).n());
    }
    
    public IDriveItemCollectionPage o(final BaseDriveItemCollectionResponse baseDriveItemCollectionResponse) {
        final String b = baseDriveItemCollectionResponse.b;
        N n = null;
        if (b != null) {
            n = new h(b, this.m().m(), null);
        }
        final DriveItemCollectionPage driveItemCollectionPage = new DriveItemCollectionPage(baseDriveItemCollectionResponse, n);
        ((BaseCollectionPage)driveItemCollectionPage).d(baseDriveItemCollectionResponse.f(), baseDriveItemCollectionResponse.e());
        return (IDriveItemCollectionPage)driveItemCollectionPage;
    }
}
