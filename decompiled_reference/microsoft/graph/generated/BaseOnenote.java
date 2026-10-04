package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.o0;
import com.microsoft.graph.extensions.OnenoteOperation;
import ax.N9.q0;
import com.microsoft.graph.extensions.OnenoteResource;
import ax.N9.p0;
import com.microsoft.graph.extensions.OnenotePage;
import ax.N9.z0;
import com.microsoft.graph.extensions.SectionGroup;
import ax.N9.r0;
import com.microsoft.graph.extensions.OnenoteSection;
import ax.N9.n0;
import java.util.Arrays;
import com.microsoft.graph.extensions.Notebook;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.OnenoteOperationCollectionPage;
import com.microsoft.graph.extensions.OnenoteResourceCollectionPage;
import com.microsoft.graph.extensions.OnenotePageCollectionPage;
import com.microsoft.graph.extensions.SectionGroupCollectionPage;
import com.microsoft.graph.extensions.OnenoteSectionCollectionPage;
import com.microsoft.graph.extensions.NotebookCollectionPage;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseOnenote extends Entity implements d
{
    public transient NotebookCollectionPage f;
    public transient OnenoteSectionCollectionPage g;
    public transient SectionGroupCollectionPage h;
    public transient OnenotePageCollectionPage i;
    public transient OnenoteResourceCollectionPage j;
    public transient OnenoteOperationCollectionPage k;
    private transient l l;
    private transient e m;
    
    public void d(final e m, final l l) {
        this.m = m;
        this.l = l;
        final boolean x = l.x("notebooks");
        final int n = 0;
        if (x) {
            final BaseNotebookCollectionResponse baseNotebookCollectionResponse = new BaseNotebookCollectionResponse();
            if (l.x("notebooks@odata.nextLink")) {
                baseNotebookCollectionResponse.b = l.t("notebooks@odata.nextLink").k();
            }
            final l[] array = (l[])m.b(l.t("notebooks").toString(), (Class)l[].class);
            final Notebook[] array2 = new Notebook[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (Notebook)m.b(((i)array[i]).toString(), (Class)Notebook.class)).d(m, array[i]);
            }
            baseNotebookCollectionResponse.a = Arrays.asList((Object[])array2);
            this.f = new NotebookCollectionPage(baseNotebookCollectionResponse, null);
        }
        if (l.x("sections")) {
            final BaseOnenoteSectionCollectionResponse baseOnenoteSectionCollectionResponse = new BaseOnenoteSectionCollectionResponse();
            if (l.x("sections@odata.nextLink")) {
                baseOnenoteSectionCollectionResponse.b = l.t("sections@odata.nextLink").k();
            }
            final l[] array3 = (l[])m.b(l.t("sections").toString(), (Class)l[].class);
            final OnenoteSection[] array4 = new OnenoteSection[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                (array4[j] = (OnenoteSection)m.b(((i)array3[j]).toString(), (Class)OnenoteSection.class)).d(m, array3[j]);
            }
            baseOnenoteSectionCollectionResponse.a = Arrays.asList((Object[])array4);
            this.g = new OnenoteSectionCollectionPage(baseOnenoteSectionCollectionResponse, null);
        }
        if (l.x("sectionGroups")) {
            final BaseSectionGroupCollectionResponse baseSectionGroupCollectionResponse = new BaseSectionGroupCollectionResponse();
            if (l.x("sectionGroups@odata.nextLink")) {
                baseSectionGroupCollectionResponse.b = l.t("sectionGroups@odata.nextLink").k();
            }
            final l[] array5 = (l[])m.b(l.t("sectionGroups").toString(), (Class)l[].class);
            final SectionGroup[] array6 = new SectionGroup[array5.length];
            for (int k = 0; k < array5.length; ++k) {
                (array6[k] = (SectionGroup)m.b(((i)array5[k]).toString(), (Class)SectionGroup.class)).d(m, array5[k]);
            }
            baseSectionGroupCollectionResponse.a = Arrays.asList((Object[])array6);
            this.h = new SectionGroupCollectionPage(baseSectionGroupCollectionResponse, null);
        }
        if (l.x("pages")) {
            final BaseOnenotePageCollectionResponse baseOnenotePageCollectionResponse = new BaseOnenotePageCollectionResponse();
            if (l.x("pages@odata.nextLink")) {
                baseOnenotePageCollectionResponse.b = l.t("pages@odata.nextLink").k();
            }
            final l[] array7 = (l[])m.b(l.t("pages").toString(), (Class)l[].class);
            final OnenotePage[] array8 = new OnenotePage[array7.length];
            for (int n2 = 0; n2 < array7.length; ++n2) {
                (array8[n2] = (OnenotePage)m.b(((i)array7[n2]).toString(), (Class)OnenotePage.class)).d(m, array7[n2]);
            }
            baseOnenotePageCollectionResponse.a = Arrays.asList((Object[])array8);
            this.i = new OnenotePageCollectionPage(baseOnenotePageCollectionResponse, null);
        }
        if (l.x("resources")) {
            final BaseOnenoteResourceCollectionResponse baseOnenoteResourceCollectionResponse = new BaseOnenoteResourceCollectionResponse();
            if (l.x("resources@odata.nextLink")) {
                baseOnenoteResourceCollectionResponse.b = l.t("resources@odata.nextLink").k();
            }
            final l[] array9 = (l[])m.b(l.t("resources").toString(), (Class)l[].class);
            final OnenoteResource[] array10 = new OnenoteResource[array9.length];
            for (int n3 = 0; n3 < array9.length; ++n3) {
                (array10[n3] = (OnenoteResource)m.b(((i)array9[n3]).toString(), (Class)OnenoteResource.class)).d(m, array9[n3]);
            }
            baseOnenoteResourceCollectionResponse.a = Arrays.asList((Object[])array10);
            this.j = new OnenoteResourceCollectionPage(baseOnenoteResourceCollectionResponse, null);
        }
        if (l.x("operations")) {
            final BaseOnenoteOperationCollectionResponse baseOnenoteOperationCollectionResponse = new BaseOnenoteOperationCollectionResponse();
            if (l.x("operations@odata.nextLink")) {
                baseOnenoteOperationCollectionResponse.b = l.t("operations@odata.nextLink").k();
            }
            final l[] array11 = (l[])m.b(l.t("operations").toString(), (Class)l[].class);
            final OnenoteOperation[] array12 = new OnenoteOperation[array11.length];
            for (int n4 = n; n4 < array11.length; ++n4) {
                (array12[n4] = (OnenoteOperation)m.b(((i)array11[n4]).toString(), (Class)OnenoteOperation.class)).d(m, array11[n4]);
            }
            baseOnenoteOperationCollectionResponse.a = Arrays.asList((Object[])array12);
            this.k = new OnenoteOperationCollectionPage(baseOnenoteOperationCollectionResponse, null);
        }
    }
}
