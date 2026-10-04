package com.microsoft.graph.extensions;

import ax.N9.y0;
import com.microsoft.graph.generated.BaseProfilePhotoCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseProfilePhotoCollectionPage;

public class ProfilePhotoCollectionPage extends BaseProfilePhotoCollectionPage implements IBaseCollectionPage
{
    public ProfilePhotoCollectionPage(final BaseProfilePhotoCollectionResponse baseProfilePhotoCollectionResponse, final y0 y0) {
        super(baseProfilePhotoCollectionResponse, y0);
    }
}
