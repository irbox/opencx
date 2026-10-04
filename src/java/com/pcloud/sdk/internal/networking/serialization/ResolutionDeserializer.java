package com.pcloud.sdk.internal.networking.serialization;

import ax.r8.m;
import ax.Gb.l;
import ax.r8.g;
import java.lang.reflect.Type;
import ax.r8.i;
import ax.la.x;
import ax.r8.h;

public final class ResolutionDeserializer implements h<x>
{
    public static final ResolutionDeserializer a;
    
    static {
        a = new ResolutionDeserializer();
    }
    
    private ResolutionDeserializer() {
    }
    
    public x b(final i i, final Type type, final g g) {
        l.f((Object)i, "json");
        l.f((Object)type, "typeOfT");
        l.f((Object)g, "context");
        if (i.q() && i.i().z()) {
            final String k = i.k();
            l.c((Object)k);
            final int u = ax.Ob.h.U((CharSequence)k, 'x', 0, false, 6, (Object)null);
            if (u != -1) {
                try {
                    final String substring = k.substring(0, u);
                    l.e((Object)substring, "substring(...)");
                    final int int1 = Integer.parseInt(substring);
                    final String substring2 = k.substring(u + 1);
                    l.e((Object)substring2, "substring(...)");
                    return new x(int1, Integer.parseInt(substring2));
                }
                catch (final NumberFormatException ex) {
                    throw new m((Throwable)ex);
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid resolution format: ");
            sb.append(k);
            throw new m(sb.toString());
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid size value ");
        sb2.append((Object)i);
        sb2.append(".");
        throw new m(sb2.toString());
    }
}
