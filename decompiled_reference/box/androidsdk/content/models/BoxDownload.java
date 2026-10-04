package com.box.androidsdk.content.models;

import java.io.File;
import com.box.androidsdk.content.utils.SdkUtils;

public class BoxDownload extends BoxJsonObject
{
    public BoxDownload(final String s, final long n, final String s2, final String s3, final String s4, final String s5) {
        if (!SdkUtils.l(s)) {
            this.G(s);
        }
        this.y("content_length", n);
        if (!SdkUtils.l(s2)) {
            this.z("content_type", s2);
        }
        if (!SdkUtils.l(s3)) {
            this.E(s3);
        }
        if (!SdkUtils.l(s4)) {
            this.z("date", s4);
        }
        if (!SdkUtils.l(s5)) {
            this.z("expiration", s5);
        }
    }
    
    public String C() {
        return this.u("file_name");
    }
    
    public File D() {
        return null;
    }
    
    protected void E(final String s) {
        final int lastIndex = s.lastIndexOf("/");
        final int index = s.indexOf("-");
        this.y("start_range", Long.parseLong(s.substring(s.indexOf("bytes") + 6, index)));
        this.y("end_range", Long.parseLong(s.substring(index + 1, lastIndex)));
        this.y("total_range", Long.parseLong(s.substring(lastIndex + 1)));
    }
    
    protected void G(String s) {
        final String[] split = s.split(";");
        for (int length = split.length, i = 0; i < length; ++i) {
            s = split[i].trim();
            if (s.startsWith("filename=")) {
                if (s.endsWith("\"")) {
                    s = s.substring(s.indexOf("\"") + 1, s.length() - 1);
                }
                else {
                    s = s.substring(9);
                }
                this.z("file_name", s);
            }
        }
    }
}
