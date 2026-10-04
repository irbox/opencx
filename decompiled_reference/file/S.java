package com.alphainventor.filemanager.file;

import ax.c3.b;
import ax.c3.B;
import ax.c3.K;
import java.io.File;
import ax.T2.h$h;
import java.util.Collection;
import java.util.ArrayList;
import ax.b3.a;
import ax.b3.j;
import ax.u3.c;
import ax.T2.h$g;
import ax.T2.h;
import ax.c3.d0;
import java.util.List;

public class s extends x
{
    public List<n> C(final n n, final m.f f) throws j {
        if (d0.E(n)) {
            final h t = h.T(n);
            if (!t.m0()) {
                try {
                    t.f(true, (h$g)null, (c)null);
                }
                catch (final a a) {
                    throw new j("Cancelled", (Throwable)a);
                }
            }
            final ArrayList list = new ArrayList((Collection)t.V());
            final ArrayList list2 = new ArrayList();
            final K q = h.q(n.L());
            int n2;
            for (int size = list.size(), i = 0; i < size; i = n2) {
                final Object value = list.get(i);
                n2 = i + 1;
                final y y = new y((x)this, new File(t.z(((h$h)value).a())), q);
                i = n2;
                if (y.n()) {
                    ((List)list2).add((Object)y);
                }
            }
            return (List<n>)list2;
        }
        return (List<n>)super.C(n, f);
    }
    
    public String H(final n n) {
        if (n == null) {
            return null;
        }
        return B.W(n);
    }
    
    public void P(final n n) throws j {
        final long p = ((b)n).p();
        super.P(n);
        final h s = h.S(h.q(((m)this).t()));
        if (s.m0()) {
            final List v = s.V();
            for (int i = 0; i < v.size(); ++i) {
                if (s.z(((h$h)v.get(i)).a()).equals((Object)n.E())) {
                    v.remove(i);
                    s.O0(p);
                    return;
                }
            }
        }
    }
}
