package com.alphainventor.filemanager.file;

import ax.c3.K;
import java.io.File;
import ax.c3.B;
import java.util.Iterator;
import ax.T2.h$h;
import java.util.ArrayList;
import ax.b3.a;
import ax.b3.j;
import ax.u3.c;
import ax.T2.h$g;
import ax.T2.h;
import ax.c3.d0;
import java.util.List;

public class t extends x
{
    public List<n> C(final n n, final m.f f) throws j {
        if (!d0.E(n)) {
            return (List<n>)super.C(n, f);
        }
        final h t = h.T(n);
        if (!t.m0()) {
            try {
                t.f(true, (h$g)null, (c)null);
            }
            catch (final a a) {
                throw new j("Cancelled", (Throwable)a);
            }
        }
        final List u = t.U();
        if (u != null) {
            final ArrayList list = new ArrayList();
            final Iterator iterator = u.iterator();
            while (iterator.hasNext()) {
                ((List)list).add((Object)this.z(t.z(((h$h)iterator.next()).a())));
            }
            return (List<n>)list;
        }
        throw new ax.b3.t();
    }
    
    public String H(final n n) {
        if (n == null) {
            return null;
        }
        return B.W(n);
    }
    
    public void P(final n n) throws j {
        super.P(n);
        final h s = h.S(h.q(((m)this).t()));
        if (s.m0()) {
            final List u = s.U();
            for (int i = 0; i < u.size(); ++i) {
                if (s.z(((h$h)u.get(i)).a()).equals((Object)n.E())) {
                    u.remove(i);
                    return;
                }
            }
        }
    }
    
    public n z(final String s) {
        return (n)new y((x)this, new File(s), (K)null);
    }
}
