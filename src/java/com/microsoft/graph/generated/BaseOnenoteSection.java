package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.p0;
import java.util.Arrays;
import com.microsoft.graph.extensions.OnenotePage;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.OnenotePageCollectionPage;
import com.microsoft.graph.extensions.SectionGroup;
import com.microsoft.graph.extensions.Notebook;
import com.microsoft.graph.extensions.SectionLinks;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.OnenoteEntityHierarchyModel;

public class BaseOnenoteSection extends OnenoteEntityHierarchyModel implements d
{
    @a
    @c("isDefault")
    public Boolean r;
    @a
    @c("links")
    public SectionLinks s;
    @a
    @c("pagesUrl")
    public String t;
    @a
    @c("parentNotebook")
    public Notebook u;
    @a
    @c("parentSectionGroup")
    public SectionGroup v;
    public transient OnenotePageCollectionPage w;
    private transient l x;
    private transient e y;
    
    public void d(final e y, final l x) {
        this.y = y;
        this.x = x;
        if (x.x("pages")) {
            final BaseOnenotePageCollectionResponse baseOnenotePageCollectionResponse = new BaseOnenotePageCollectionResponse();
            if (x.x("pages@odata.nextLink")) {
                baseOnenotePageCollectionResponse.b = x.t("pages@odata.nextLink").k();
            }
            final l[] array = (l[])y.b(x.t("pages").toString(), (Class)l[].class);
            final OnenotePage[] array2 = new OnenotePage[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (OnenotePage)y.b(((i)array[i]).toString(), (Class)OnenotePage.class)).d(y, array[i]);
            }
            baseOnenotePageCollectionResponse.a = Arrays.asList((Object[])array2);
            this.w = new OnenotePageCollectionPage(baseOnenotePageCollectionResponse, null);
        }
    }
}
