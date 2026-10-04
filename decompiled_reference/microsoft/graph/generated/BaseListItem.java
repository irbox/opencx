package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.i0;
import java.util.Arrays;
import com.microsoft.graph.extensions.ListItemVersion;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.ListItemVersionCollectionPage;
import com.microsoft.graph.extensions.FieldValueSet;
import com.microsoft.graph.extensions.DriveItem;
import com.microsoft.graph.extensions.SharepointIds;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.ContentTypeInfo;
import ax.T9.d;
import com.microsoft.graph.extensions.BaseItem;

public class BaseListItem extends BaseItem implements d
{
    @a
    @c("contentType")
    public ContentTypeInfo s;
    @a
    @c("sharepointIds")
    public SharepointIds t;
    @a
    @c("driveItem")
    public DriveItem u;
    @a
    @c("fields")
    public FieldValueSet v;
    public transient ListItemVersionCollectionPage w;
    private transient l x;
    private transient e y;
    
    public void d(final e y, final l x) {
        this.y = y;
        this.x = x;
        if (x.x("versions")) {
            final BaseListItemVersionCollectionResponse baseListItemVersionCollectionResponse = new BaseListItemVersionCollectionResponse();
            if (x.x("versions@odata.nextLink")) {
                baseListItemVersionCollectionResponse.b = x.t("versions@odata.nextLink").k();
            }
            final l[] array = (l[])y.b(x.t("versions").toString(), (Class)l[].class);
            final ListItemVersion[] array2 = new ListItemVersion[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (ListItemVersion)y.b(((i)array[i]).toString(), (Class)ListItemVersion.class)).d(y, array[i]);
            }
            baseListItemVersionCollectionResponse.a = Arrays.asList((Object[])array2);
            this.w = new ListItemVersionCollectionPage(baseListItemVersionCollectionResponse, null);
        }
    }
}
