package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.G;
import java.util.Arrays;
import com.microsoft.graph.extensions.ColumnLink;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.ColumnLinkCollectionPage;
import com.microsoft.graph.extensions.ContentTypeOrder;
import com.microsoft.graph.extensions.ItemReference;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseContentType extends Entity implements d
{
    @a
    @c("description")
    public String f;
    @a
    @c("group")
    public String g;
    @a
    @c("hidden")
    public Boolean h;
    @a
    @c("inheritedFrom")
    public ItemReference i;
    @a
    @c("name")
    public String j;
    @a
    @c("order")
    public ContentTypeOrder k;
    @a
    @c("parentId")
    public String l;
    @a
    @c("readOnly")
    public Boolean m;
    @a
    @c("sealed")
    public Boolean n;
    public transient ColumnLinkCollectionPage o;
    private transient l p;
    private transient e q;
    
    public void d(final e q, final l p2) {
        this.q = q;
        this.p = p2;
        if (p2.x("columnLinks")) {
            final BaseColumnLinkCollectionResponse baseColumnLinkCollectionResponse = new BaseColumnLinkCollectionResponse();
            if (p2.x("columnLinks@odata.nextLink")) {
                baseColumnLinkCollectionResponse.b = p2.t("columnLinks@odata.nextLink").k();
            }
            final l[] array = (l[])q.b(p2.t("columnLinks").toString(), (Class)l[].class);
            final ColumnLink[] array2 = new ColumnLink[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (ColumnLink)q.b(((i)array[i]).toString(), (Class)ColumnLink.class)).d(q, array[i]);
            }
            baseColumnLinkCollectionResponse.a = Arrays.asList((Object[])array2);
            this.o = new ColumnLinkCollectionPage(baseColumnLinkCollectionResponse, null);
        }
    }
}
