package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.Z;
import com.microsoft.graph.extensions.DriveItemVersion;
import ax.N9.B0;
import com.microsoft.graph.extensions.ThumbnailSet;
import ax.N9.t0;
import com.microsoft.graph.extensions.Permission;
import ax.N9.N;
import java.util.Arrays;
import com.microsoft.graph.extensions.DriveItem;
import com.microsoft.graph.extensions.GeoCoordinates;
import com.microsoft.graph.extensions.Image;
import com.microsoft.graph.extensions.Folder;
import com.microsoft.graph.extensions.FileSystemInfo;
import com.microsoft.graph.extensions.File;
import com.microsoft.graph.extensions.Deleted;
import com.microsoft.graph.extensions.Audio;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.Workbook;
import com.microsoft.graph.extensions.DriveItemVersionCollectionPage;
import com.microsoft.graph.extensions.ThumbnailSetCollectionPage;
import com.microsoft.graph.extensions.PermissionCollectionPage;
import com.microsoft.graph.extensions.ListItem;
import com.microsoft.graph.extensions.DriveItemCollectionPage;
import com.microsoft.graph.extensions.Video;
import com.microsoft.graph.extensions.SpecialFolder;
import com.microsoft.graph.extensions.SharepointIds;
import com.microsoft.graph.extensions.Shared;
import com.microsoft.graph.extensions.SearchResult;
import com.microsoft.graph.extensions.Root;
import com.microsoft.graph.extensions.RemoteItem;
import com.microsoft.graph.extensions.PublicationFacet;
import com.microsoft.graph.extensions.Photo;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.Package;
import ax.T9.d;
import com.microsoft.graph.extensions.BaseItem;

public class BaseDriveItem extends BaseItem implements d
{
    @a
    @c("package")
    public Package A;
    @a
    @c("photo")
    public Photo B;
    @a
    @c("publication")
    public PublicationFacet C;
    @a
    @c("remoteItem")
    public RemoteItem D;
    @a
    @c("root")
    public Root E;
    @a
    @c("searchResult")
    public SearchResult F;
    @a
    @c("shared")
    public Shared G;
    @a
    @c("sharepointIds")
    public SharepointIds H;
    @a
    @c("size")
    public Long I;
    @a
    @c("specialFolder")
    public SpecialFolder J;
    @a
    @c("video")
    public Video K;
    @a
    @c("webDavUrl")
    public String L;
    public transient DriveItemCollectionPage M;
    @a
    @c("listItem")
    public ListItem N;
    public transient PermissionCollectionPage O;
    public transient ThumbnailSetCollectionPage P;
    public transient DriveItemVersionCollectionPage Q;
    @a
    @c("workbook")
    public Workbook R;
    private transient l S;
    private transient e T;
    @a
    @c("audio")
    public Audio s;
    @a
    @c("cTag")
    public String t;
    @a
    @c("deleted")
    public Deleted u;
    @a
    @c("file")
    public File v;
    @a
    @c("fileSystemInfo")
    public FileSystemInfo w;
    @a
    @c("folder")
    public Folder x;
    @a
    @c("image")
    public Image y;
    @a
    @c("location")
    public GeoCoordinates z;
    
    public void d(final e t, final l s) {
        this.T = t;
        this.S = s;
        final boolean x = s.x("children");
        final int n = 0;
        if (x) {
            final BaseDriveItemCollectionResponse baseDriveItemCollectionResponse = new BaseDriveItemCollectionResponse();
            if (s.x("children@odata.nextLink")) {
                baseDriveItemCollectionResponse.b = s.t("children@odata.nextLink").k();
            }
            final l[] array = (l[])t.b(s.t("children").toString(), (Class)l[].class);
            final DriveItem[] array2 = new DriveItem[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (DriveItem)t.b(((i)array[i]).toString(), (Class)DriveItem.class)).d(t, array[i]);
            }
            baseDriveItemCollectionResponse.a = Arrays.asList((Object[])array2);
            this.M = new DriveItemCollectionPage(baseDriveItemCollectionResponse, null);
        }
        if (s.x("permissions")) {
            final BasePermissionCollectionResponse basePermissionCollectionResponse = new BasePermissionCollectionResponse();
            if (s.x("permissions@odata.nextLink")) {
                basePermissionCollectionResponse.b = s.t("permissions@odata.nextLink").k();
            }
            final l[] array3 = (l[])t.b(s.t("permissions").toString(), (Class)l[].class);
            final Permission[] array4 = new Permission[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                (array4[j] = (Permission)t.b(((i)array3[j]).toString(), (Class)Permission.class)).d(t, array3[j]);
            }
            basePermissionCollectionResponse.a = Arrays.asList((Object[])array4);
            this.O = new PermissionCollectionPage(basePermissionCollectionResponse, null);
        }
        if (s.x("thumbnails")) {
            final BaseThumbnailSetCollectionResponse baseThumbnailSetCollectionResponse = new BaseThumbnailSetCollectionResponse();
            if (s.x("thumbnails@odata.nextLink")) {
                baseThumbnailSetCollectionResponse.b = s.t("thumbnails@odata.nextLink").k();
            }
            final l[] array5 = (l[])t.b(s.t("thumbnails").toString(), (Class)l[].class);
            final ThumbnailSet[] array6 = new ThumbnailSet[array5.length];
            for (int k = 0; k < array5.length; ++k) {
                ((BaseThumbnailSet)(array6[k] = (ThumbnailSet)t.b(((i)array5[k]).toString(), (Class)ThumbnailSet.class))).d(t, array5[k]);
            }
            baseThumbnailSetCollectionResponse.a = Arrays.asList((Object[])array6);
            this.P = new ThumbnailSetCollectionPage(baseThumbnailSetCollectionResponse, (B0)null);
        }
        if (s.x("versions")) {
            final BaseDriveItemVersionCollectionResponse baseDriveItemVersionCollectionResponse = new BaseDriveItemVersionCollectionResponse();
            if (s.x("versions@odata.nextLink")) {
                baseDriveItemVersionCollectionResponse.b = s.t("versions@odata.nextLink").k();
            }
            final l[] array7 = (l[])t.b(s.t("versions").toString(), (Class)l[].class);
            final DriveItemVersion[] array8 = new DriveItemVersion[array7.length];
            for (int l = n; l < array7.length; ++l) {
                (array8[l] = (DriveItemVersion)t.b(((i)array7[l]).toString(), (Class)DriveItemVersion.class)).d(t, array7[l]);
            }
            baseDriveItemVersionCollectionResponse.a = Arrays.asList((Object[])array8);
            this.Q = new DriveItemVersionCollectionPage(baseDriveItemVersionCollectionResponse, null);
        }
    }
    
    public l e() {
        return this.S;
    }
}
