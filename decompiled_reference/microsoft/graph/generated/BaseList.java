package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.h0;
import com.microsoft.graph.extensions.ListItem;
import ax.N9.J;
import com.microsoft.graph.extensions.ContentType;
import ax.N9.F;
import java.util.Arrays;
import com.microsoft.graph.extensions.ColumnDefinition;
import com.microsoft.graph.extensions.ListItemCollectionPage;
import com.microsoft.graph.extensions.Drive;
import com.microsoft.graph.extensions.ContentTypeCollectionPage;
import com.microsoft.graph.extensions.ColumnDefinitionCollectionPage;
import com.microsoft.graph.extensions.SystemFacet;
import com.microsoft.graph.extensions.SharepointIds;
import com.microsoft.graph.extensions.ListInfo;
import ax.s8.c;
import ax.s8.a;
import ax.T9.e;
import ax.r8.l;
import ax.T9.d;
import com.microsoft.graph.extensions.BaseItem;

public class BaseList extends BaseItem implements d
{
    private transient l A;
    private transient e B;
    @a
    @c("displayName")
    public String s;
    @a
    @c("list")
    public ListInfo t;
    @a
    @c("sharepointIds")
    public SharepointIds u;
    @a
    @c("system")
    public SystemFacet v;
    public transient ColumnDefinitionCollectionPage w;
    public transient ContentTypeCollectionPage x;
    @a
    @c("drive")
    public Drive y;
    public transient ListItemCollectionPage z;
    
    public void d(final e b, final l a) {
        this.B = b;
        this.A = a;
        final boolean x = a.x("columns");
        final int n = 0;
        if (x) {
            final BaseColumnDefinitionCollectionResponse baseColumnDefinitionCollectionResponse = new BaseColumnDefinitionCollectionResponse();
            if (a.x("columns@odata.nextLink")) {
                baseColumnDefinitionCollectionResponse.b = a.t("columns@odata.nextLink").k();
            }
            final l[] array = (l[])b.b(a.t("columns").toString(), (Class)l[].class);
            final ColumnDefinition[] array2 = new ColumnDefinition[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (ColumnDefinition)b.b(((i)array[i]).toString(), (Class)ColumnDefinition.class)).d(b, array[i]);
            }
            baseColumnDefinitionCollectionResponse.a = Arrays.asList((Object[])array2);
            this.w = new ColumnDefinitionCollectionPage(baseColumnDefinitionCollectionResponse, null);
        }
        if (a.x("contentTypes")) {
            final BaseContentTypeCollectionResponse baseContentTypeCollectionResponse = new BaseContentTypeCollectionResponse();
            if (a.x("contentTypes@odata.nextLink")) {
                baseContentTypeCollectionResponse.b = a.t("contentTypes@odata.nextLink").k();
            }
            final l[] array3 = (l[])b.b(a.t("contentTypes").toString(), (Class)l[].class);
            final ContentType[] array4 = new ContentType[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                (array4[j] = (ContentType)b.b(((i)array3[j]).toString(), (Class)ContentType.class)).d(b, array3[j]);
            }
            baseContentTypeCollectionResponse.a = Arrays.asList((Object[])array4);
            this.x = new ContentTypeCollectionPage(baseContentTypeCollectionResponse, null);
        }
        if (a.x("items")) {
            final BaseListItemCollectionResponse baseListItemCollectionResponse = new BaseListItemCollectionResponse();
            if (a.x("items@odata.nextLink")) {
                baseListItemCollectionResponse.b = a.t("items@odata.nextLink").k();
            }
            final l[] array5 = (l[])b.b(a.t("items").toString(), (Class)l[].class);
            final ListItem[] array6 = new ListItem[array5.length];
            for (int k = n; k < array5.length; ++k) {
                (array6[k] = (ListItem)b.b(((i)array5[k]).toString(), (Class)ListItem.class)).d(b, array5[k]);
            }
            baseListItemCollectionResponse.a = Arrays.asList((Object[])array6);
            this.z = new ListItemCollectionPage(baseListItemCollectionResponse, null);
        }
    }
}
