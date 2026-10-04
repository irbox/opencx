package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.N;
import java.util.Arrays;
import com.microsoft.graph.extensions.DriveItem;
import com.microsoft.graph.extensions.List;
import com.microsoft.graph.extensions.SystemFacet;
import com.microsoft.graph.extensions.SharepointIds;
import com.microsoft.graph.extensions.Quota;
import com.microsoft.graph.extensions.IdentitySet;
import ax.s8.c;
import ax.s8.a;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.DriveItemCollectionPage;
import ax.T9.d;
import com.microsoft.graph.extensions.BaseItem;

public class BaseDrive extends BaseItem implements d
{
    public transient DriveItemCollectionPage A;
    private transient l B;
    private transient e C;
    @a
    @c("driveType")
    public String s;
    @a
    @c("owner")
    public IdentitySet t;
    @a
    @c("quota")
    public Quota u;
    @a
    @c("sharePointIds")
    public SharepointIds v;
    @a
    @c("system")
    public SystemFacet w;
    public transient DriveItemCollectionPage x;
    @a
    @c("list")
    public List y;
    @a
    @c("root")
    public DriveItem z;
    
    public void d(final e c, final l b) {
        this.C = c;
        this.B = b;
        final boolean x = b.x("items");
        final int n = 0;
        if (x) {
            final BaseDriveItemCollectionResponse baseDriveItemCollectionResponse = new BaseDriveItemCollectionResponse();
            if (b.x("items@odata.nextLink")) {
                baseDriveItemCollectionResponse.b = b.t("items@odata.nextLink").k();
            }
            final l[] array = (l[])c.b(b.t("items").toString(), (Class)l[].class);
            final DriveItem[] array2 = new DriveItem[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (DriveItem)c.b(((i)array[i]).toString(), (Class)DriveItem.class)).d(c, array[i]);
            }
            baseDriveItemCollectionResponse.a = Arrays.asList((Object[])array2);
            this.x = new DriveItemCollectionPage(baseDriveItemCollectionResponse, null);
        }
        if (b.x("special")) {
            final BaseDriveItemCollectionResponse baseDriveItemCollectionResponse2 = new BaseDriveItemCollectionResponse();
            if (b.x("special@odata.nextLink")) {
                baseDriveItemCollectionResponse2.b = b.t("special@odata.nextLink").k();
            }
            final l[] array3 = (l[])c.b(b.t("special").toString(), (Class)l[].class);
            final DriveItem[] array4 = new DriveItem[array3.length];
            for (int j = n; j < array3.length; ++j) {
                (array4[j] = (DriveItem)c.b(((i)array3[j]).toString(), (Class)DriveItem.class)).d(c, array3[j]);
            }
            baseDriveItemCollectionResponse2.a = Arrays.asList((Object[])array4);
            this.A = new DriveItemCollectionPage(baseDriveItemCollectionResponse2, null);
        }
    }
}
