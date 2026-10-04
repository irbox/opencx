package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.s0;
import java.util.Arrays;
import com.microsoft.graph.extensions.OutlookCategory;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.OutlookCategoryCollectionPage;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseOutlookUser extends Entity implements d
{
    public transient OutlookCategoryCollectionPage f;
    private transient l g;
    private transient e h;
    
    public void d(final e h, final l g) {
        this.h = h;
        this.g = g;
        if (g.x("masterCategories")) {
            final BaseOutlookCategoryCollectionResponse baseOutlookCategoryCollectionResponse = new BaseOutlookCategoryCollectionResponse();
            if (g.x("masterCategories@odata.nextLink")) {
                baseOutlookCategoryCollectionResponse.b = g.t("masterCategories@odata.nextLink").k();
            }
            final l[] array = (l[])h.b(g.t("masterCategories").toString(), (Class)l[].class);
            final OutlookCategory[] array2 = new OutlookCategory[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (OutlookCategory)h.b(((i)array[i]).toString(), (Class)OutlookCategory.class)).d(h, array[i]);
            }
            baseOutlookCategoryCollectionResponse.a = Arrays.asList((Object[])array2);
            this.f = new OutlookCategoryCollectionPage(baseOutlookCategoryCollectionResponse, null);
        }
    }
}
