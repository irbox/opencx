package com.microsoft.graph.serializer;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import ax.r8.l;
import java.lang.reflect.Field;
import ax.s8.c;
import java.util.HashSet;
import java.util.Set;
import ax.T9.d;
import ax.r8.i;
import java.util.HashMap;

public class a extends HashMap<String, i>
{
    private final d q;
    
    public a(final d q) {
        this.q = q;
    }
    
    private Set<String> b() {
        final Field[] fields = this.q.getClass().getFields();
        final HashSet set = new HashSet();
        for (final Field field : fields) {
            final c c = (c)field.getAnnotation((Class)c.class);
            if (c != null && field.getAnnotation((Class)ax.s8.a.class) != null) {
                ((Set)set).add((Object)c.value());
            }
        }
        return (Set<String>)set;
    }
    
    private Set<String> c(final l l) {
        final HashSet set = new HashSet();
        final Iterator iterator = l.s().iterator();
        while (iterator.hasNext()) {
            ((Set)set).add((Object)((Map$Entry)iterator.next()).getKey());
        }
        return (Set<String>)set;
    }
    
    final void d(final l l) {
        final Set<String> b = this.b();
        final HashSet set = new HashSet((Collection)this.c(l));
        ((Set)set).removeAll((Collection)b);
        for (final String s : set) {
            ((AbstractMap)this).put((Object)s, (Object)l.t(s));
        }
    }
}
