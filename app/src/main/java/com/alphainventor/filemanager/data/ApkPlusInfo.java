package com.alphainventor.filemanager.data;

import ax.U2.f;
import androidx.annotation.Keep;

@Keep
public class ApkPlusInfo
{
    public static final String ICON_FILENAME = "icon.png";
    public static final String INFO_FILENAME = "apk+.json";
    public String app_name;
    public int min_sdk_version;
    public String package_name;
    public long version_code;
    public String version_name;
    
    public void fillInfo(final f f) {
        this.app_name = f.q();
        this.package_name = f.r();
        this.version_code = f.y();
        this.version_name = f.x();
        this.min_sdk_version = f.p();
    }
}
