package com.box.androidsdk.content.models;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.EnumSet;

public class BoxPermission extends BoxJsonObject
{
    EnumSet<BoxItem.Permission> C() {
        final EnumSet none = EnumSet.noneOf((Class)BoxItem.Permission.class);
        for (final String s : this.n()) {
            final Boolean p = this.p(s);
            if (p != null) {
                if (!p) {
                    continue;
                }
                final BoxItem.Permission c0 = BoxItem.Permission.c0;
                if (s.equals((Object)c0.toString())) {
                    ((AbstractCollection)none).add((Object)c0);
                }
                else {
                    final BoxItem.Permission d0 = BoxItem.Permission.d0;
                    if (s.equals((Object)d0.toString())) {
                        ((AbstractCollection)none).add((Object)d0);
                    }
                    else {
                        final BoxItem.Permission f0 = BoxItem.Permission.f0;
                        if (s.equals((Object)f0.toString())) {
                            ((AbstractCollection)none).add((Object)f0);
                        }
                        else {
                            final BoxItem.Permission g0 = BoxItem.Permission.g0;
                            if (s.equals((Object)g0.toString())) {
                                ((AbstractCollection)none).add((Object)g0);
                            }
                            else {
                                final BoxItem.Permission h0 = BoxItem.Permission.h0;
                                if (s.equals((Object)h0.toString())) {
                                    ((AbstractCollection)none).add((Object)h0);
                                }
                                else {
                                    final BoxItem.Permission i0 = BoxItem.Permission.i0;
                                    if (s.equals((Object)i0.toString())) {
                                        ((AbstractCollection)none).add((Object)i0);
                                    }
                                    else {
                                        final BoxItem.Permission q = BoxItem.Permission.q;
                                        if (s.equals((Object)q.toString())) {
                                            ((AbstractCollection)none).add((Object)q);
                                        }
                                        else {
                                            final BoxItem.Permission j0 = BoxItem.Permission.j0;
                                            if (s.equals((Object)j0.toString())) {
                                                ((AbstractCollection)none).add((Object)j0);
                                            }
                                            else {
                                                final BoxItem.Permission e0 = BoxItem.Permission.e0;
                                                if (!s.equals((Object)e0.toString())) {
                                                    continue;
                                                }
                                                ((AbstractCollection)none).add((Object)e0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return (EnumSet<BoxItem.Permission>)none;
    }
}
