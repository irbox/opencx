package com.socialnmobile.dav.gson;

import androidx.annotation.Keep;

@Keep
public class ServerType
{
    public static int TYPE_COMMON = 0;
    public static int TYPE_NEXTCLOUD = 3;
    public static int TYPE_NGINX = 4;
    public static int TYPE_OWNCLOUD = 2;
    public static int TYPE_YANDEX = 1;
    public int serverType;
    
    public ServerType(final int serverType) {
        this.serverType = serverType;
    }
}
