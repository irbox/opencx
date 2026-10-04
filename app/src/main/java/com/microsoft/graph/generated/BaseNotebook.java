package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.z0;
import com.microsoft.graph.extensions.SectionGroup;
import ax.N9.r0;
import java.util.Arrays;
import com.microsoft.graph.extensions.OnenoteSection;
import ax.r8.l;
import com.microsoft.graph.extensions.SectionGroupCollectionPage;
import com.microsoft.graph.extensions.OnenoteSectionCollectionPage;
import com.microsoft.graph.extensions.NotebookLinks;
import ax.N9.T0;
import ax.s8.c;
import ax.s8.a;
import ax.T9.e;
import ax.T9.d;
import com.microsoft.graph.extensions.OnenoteEntityHierarchyModel;

public class BaseNotebook extends OnenoteEntityHierarchyModel implements d
{
    private transient e A;
    @a
    @c("isDefault")
    public Boolean r;
    @a
    @c("userRole")
    public T0 s;
    @a
    @c("isShared")
    public Boolean t;
    @a
    @c("sectionsUrl")
    public String u;
    @a
    @c("sectionGroupsUrl")
    public String v;
    @a
    @c("links")
    public NotebookLinks w;
    public transient OnenoteSectionCollectionPage x;
    public transient SectionGroupCollectionPage y;
    private transient l z;
    
    public void d(final e a, final l z) {
        this.A = a;
        this.z = z;
        final boolean x = z.x("sections");
        final int n = 0;
        if (x) {
            final BaseOnenoteSectionCollectionResponse baseOnenoteSectionCollectionResponse = new BaseOnenoteSectionCollectionResponse();
            if (z.x("sections@odata.nextLink")) {
                baseOnenoteSectionCollectionResponse.b = z.t("sections@odata.nextLink").k();
            }
            final l[] array = (l[])a.b(z.t("sections").toString(), (Class)l[].class);
            final OnenoteSection[] array2 = new OnenoteSection[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (OnenoteSection)a.b(((i)array[i]).toString(), (Class)OnenoteSection.class)).d(a, array[i]);
            }
            baseOnenoteSectionCollectionResponse.a = Arrays.asList((Object[])array2);
            this.x = new OnenoteSectionCollectionPage(baseOnenoteSectionCollectionResponse, null);
        }
        if (z.x("sectionGroups")) {
            final BaseSectionGroupCollectionResponse baseSectionGroupCollectionResponse = new BaseSectionGroupCollectionResponse();
            if (z.x("sectionGroups@odata.nextLink")) {
                baseSectionGroupCollectionResponse.b = z.t("sectionGroups@odata.nextLink").k();
            }
            final l[] array3 = (l[])a.b(z.t("sectionGroups").toString(), (Class)l[].class);
            final SectionGroup[] array4 = new SectionGroup[array3.length];
            for (int j = n; j < array3.length; ++j) {
                (array4[j] = (SectionGroup)a.b(((i)array3[j]).toString(), (Class)SectionGroup.class)).d(a, array3[j]);
            }
            baseSectionGroupCollectionResponse.a = Arrays.asList((Object[])array4);
            this.y = new SectionGroupCollectionPage(baseSectionGroupCollectionResponse, null);
        }
    }
}
