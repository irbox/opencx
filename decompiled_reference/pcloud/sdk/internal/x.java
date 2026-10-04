package com.pcloud.sdk.internal;

import java.util.Locale;
import j$.util.DesugarCollections;
import java.net.URL;
import java.util.List;
import java.util.Date;
import ax.la.a;
import ax.la.k;

class x implements k
{
    private final a a;
    private final Date b;
    private final List<URL> c;
    
    x(final a a, final Date b, final List<URL> list) {
        this.a = a;
        this.b = b;
        this.c = (List<URL>)DesugarCollections.unmodifiableList((List)list);
    }
    
    public URL a() {
        return (URL)this.c.get(0);
    }
    
    public Date b() {
        return this.b;
    }
    
    public List<URL> c() {
        return this.c;
    }
    
    @Override
    public String toString() {
        return String.format(Locale.US, "%s | Valid until:%s", new Object[] { this.a(), this.b() });
    }
}
