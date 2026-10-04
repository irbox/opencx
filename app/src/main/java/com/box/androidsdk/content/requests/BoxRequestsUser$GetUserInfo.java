package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUser;

public class BoxRequestsUser$GetUserInfo extends BoxRequestItem<BoxUser, BoxRequestsUser$GetUserInfo>
{
    public BoxRequestsUser$GetUserInfo(final String s, final BoxSession boxSession) {
        super(BoxUser.class, null, s, boxSession);
        super.mRequestMethod = Methods.q;
    }
}
