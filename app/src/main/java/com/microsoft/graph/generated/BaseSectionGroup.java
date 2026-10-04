package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.z0;
import ax.N9.r0;
import java.util.Arrays;
import com.microsoft.graph.extensions.OnenoteSection;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.SectionGroupCollectionPage;
import com.microsoft.graph.extensions.OnenoteSectionCollectionPage;
import com.microsoft.graph.extensions.SectionGroup;
import com.microsoft.graph.extensions.Notebook;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.OnenoteEntityHierarchyModel;

public class BaseSectionGroup extends OnenoteEntityHierarchyModel implements d
{
    @a
    @c("sectionsUrl")
    public String r;
    @a
    @c("sectionGroupsUrl")
    public String s;
    @a
    @c("parentNotebook")
    public Notebook t;
    @a
    @c("parentSectionGroup")
    public SectionGroup u;
    public transient OnenoteSectionCollectionPage v;
    public transient SectionGroupCollectionPage w;
    private transient l x;
    private transient e y;
    
    public void d(final e y, final l x) {
        this.y = y;
        this.x = x;
        final boolean x2 = x.x("sections");
        final int n = 0;
        if (x2) {
            final BaseOnenoteSectionCollectionResponse baseOnenoteSectionCollectionResponse = new BaseOnenoteSectionCollectionResponse();
            if (x.x("sections@odata.nextLink")) {
                baseOnenoteSectionCollectionResponse.b = x.t("sections@odata.nextLink").k();
            }
            final l[] array = (l[])y.b(x.t("sections").toString(), (Class)l[].class);
            final OnenoteSection[] array2 = new OnenoteSection[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (OnenoteSection)y.b(((i)array[i]).toString(), (Class)OnenoteSection.class)).d(y, array[i]);
            }
            baseOnenoteSectionCollectionResponse.a = Arrays.asList((Object[])array2);
            this.v = new OnenoteSectionCollectionPage(baseOnenoteSectionCollectionResponse, null);
        }
        if (x.x("sectionGroups")) {
            final BaseSectionGroupCollectionResponse baseSectionGroupCollectionResponse = new BaseSectionGroupCollectionResponse();
            if (x.x("sectionGroups@odata.nextLink")) {
                baseSectionGroupCollectionResponse.b = x.t("sectionGroups@odata.nextLink").k();
            }
            final l[] array3 = (l[])y.b(x.t("sectionGroups").toString(), (Class)l[].class);
            final SectionGroup[] array4 = new SectionGroup[array3.length];
            for (int j = n; j < array3.length; ++j) {
                (array4[j] = (SectionGroup)y.b(((i)array3[j]).toString(), (Class)SectionGroup.class)).d(y, array3[j]);
            }
            baseSectionGroupCollectionResponse.a = Arrays.asList((Object[])array4);
            this.w = new SectionGroupCollectionPage(baseSectionGroupCollectionResponse, null);
        }
    }
}
