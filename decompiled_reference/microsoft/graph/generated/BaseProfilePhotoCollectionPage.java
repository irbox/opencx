package com.microsoft.graph.generated;

import ax.P9.p;
import java.util.List;
import com.microsoft.graph.http.IBaseCollectionPage;
import ax.N9.y0;
import com.microsoft.graph.extensions.ProfilePhoto;
import com.microsoft.graph.http.BaseCollectionPage;

public class BaseProfilePhotoCollectionPage extends BaseCollectionPage<ProfilePhoto, y0> implements IBaseCollectionPage
{
    public BaseProfilePhotoCollectionPage(final BaseProfilePhotoCollectionResponse baseProfilePhotoCollectionResponse, final y0 y0) {
        super((java.util.List<Object>)baseProfilePhotoCollectionResponse.a, (p)y0);
    }
}
