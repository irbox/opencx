package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.f0;
import java.util.Arrays;
import com.microsoft.graph.extensions.InferenceClassificationOverride;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.InferenceClassificationOverrideCollectionPage;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseInferenceClassification extends Entity implements d
{
    public transient InferenceClassificationOverrideCollectionPage f;
    private transient l g;
    private transient e h;
    
    public void d(final e h, final l g) {
        this.h = h;
        this.g = g;
        if (g.x("overrides")) {
            final BaseInferenceClassificationOverrideCollectionResponse baseInferenceClassificationOverrideCollectionResponse = new BaseInferenceClassificationOverrideCollectionResponse();
            if (g.x("overrides@odata.nextLink")) {
                baseInferenceClassificationOverrideCollectionResponse.b = g.t("overrides@odata.nextLink").k();
            }
            final l[] array = (l[])h.b(g.t("overrides").toString(), (Class)l[].class);
            final InferenceClassificationOverride[] array2 = new InferenceClassificationOverride[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (InferenceClassificationOverride)h.b(((i)array[i]).toString(), (Class)InferenceClassificationOverride.class)).d(h, array[i]);
            }
            baseInferenceClassificationOverrideCollectionResponse.a = Arrays.asList((Object[])array2);
            this.f = new InferenceClassificationOverrideCollectionPage(baseInferenceClassificationOverrideCollectionResponse, null);
        }
    }
}
