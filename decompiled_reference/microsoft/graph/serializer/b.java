package com.microsoft.graph.serializer;

import java.util.AbstractMap;
import java.util.Iterator;
import ax.r8.l;
import ax.T9.d;
import ax.r8.i;
import java.util.Map$Entry;
import com.google.gson.Gson;
import ax.T9.e;

public class b implements e
{
    private final Gson a;
    private final ax.Q9.b b;
    
    public b(final ax.Q9.b b) {
        this.b = b;
        this.a = GsonFactory.a(b);
    }
    
    private boolean c(final Map$Entry<String, i> map$Entry) {
        return ((String)map$Entry.getKey()).startsWith("@");
    }
    
    public <T> String a(final T t) {
        final ax.Q9.b b = this.b;
        final StringBuilder sb = new StringBuilder();
        sb.append("Serializing type ");
        sb.append(t.getClass().getSimpleName());
        b.a(sb.toString());
        Object z;
        final i i = (i)(z = this.a.z((Object)t));
        if (t instanceof d) {
            final a c = ((d)t).c();
            z = i;
            if (i.p()) {
                final l h = i.h();
                final Iterator iterator = ((AbstractMap)c).entrySet().iterator();
                while (true) {
                    z = h;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    final Map$Entry map$Entry = (Map$Entry)iterator.next();
                    if (this.c((Map$Entry<String, i>)map$Entry)) {
                        continue;
                    }
                    h.r((String)map$Entry.getKey(), (i)map$Entry.getValue());
                }
            }
        }
        return ((i)z).toString();
    }
    
    public <T> T b(final String s, final Class<T> clazz) {
        final Object k = this.a.k(s, (Class)clazz);
        if (k instanceof d) {
            final ax.Q9.b b = this.b;
            final StringBuilder sb = new StringBuilder();
            sb.append("Deserializing type ");
            sb.append(clazz.getSimpleName());
            b.a(sb.toString());
            final d d = (d)k;
            final l l = (l)this.a.k(s, (Class)l.class);
            d.d((e)this, l);
            d.c().d(l);
            return (T)k;
        }
        final ax.Q9.b b2 = this.b;
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Deserializing a non-IJsonBackedObject type ");
        sb2.append(clazz.getSimpleName());
        b2.a(sb2.toString());
        return (T)k;
    }
}
