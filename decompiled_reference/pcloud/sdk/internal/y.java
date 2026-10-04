package com.pcloud.sdk.internal;

import java.net.URL;
import java.util.List;
import java.util.Date;
import ax.la.a;
import ax.la.p;

class y extends x implements p
{
    private final String d;
    
    y(final a a, final Date date, final List<URL> list, final String d) {
        super(a, date, list);
        this.d = d;
    }
    
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof y)) {
            return false;
        }
        final y y = (y)o;
        return this.b().equals((Object)y.b()) && this.c().equals((Object)y.c()) && this.d.equals((Object)y.d);
    }
    
    public int hashCode() {
        return (this.b().hashCode() * 31 + this.c().hashCode()) * 31 + this.d.hashCode();
    }
}
