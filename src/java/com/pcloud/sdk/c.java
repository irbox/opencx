package com.pcloud.sdk;

import java.util.Collections;
import java.util.TreeMap;
import android.net.Uri;
import java.util.Map;
import android.content.pm.ServiceInfo;
import java.util.Iterator;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import android.content.Context;
import java.util.Arrays;
import java.util.List;

abstract class c
{
    static final List<String> a;
    
    static {
        a = Arrays.asList((Object[])new String[] { "com.android.chrome", "com.chrome.beta", "com.chrome.dev", "org.mozilla.firefox", "org.mozilla.firefox_beta", "org.mozilla.fenix" });
    }
    
    public static String a(final Context context, final List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        final List queryIntentServices = context.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (queryIntentServices != null) {
            for (final String s : list) {
                final Iterator iterator2 = queryIntentServices.iterator();
                while (iterator2.hasNext()) {
                    final ServiceInfo serviceInfo = ((ResolveInfo)iterator2.next()).serviceInfo;
                    if (s.equals((Object)serviceInfo.packageName)) {
                        return serviceInfo.packageName;
                    }
                }
            }
        }
        return null;
    }
    
    static Map<String, String> b(final String s) {
        final String fragment = Uri.parse(s).getFragment();
        if (fragment != null) {
            final TreeMap treeMap = new TreeMap();
            for (final String s2 : fragment.split("&")) {
                final int index = s2.indexOf(61);
                ((Map)treeMap).put((Object)s2.substring(0, index), (Object)s2.substring(index + 1));
            }
            return (Map<String, String>)treeMap;
        }
        return (Map<String, String>)Collections.EMPTY_MAP;
    }
}
