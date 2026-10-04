package com.alphainventor.filemanager.file;

import ax.c3.B;
import ax.c3.K;
import ax.b3.t;
import java.io.File;
import ax.T2.k;
import java.util.Collection;
import java.util.ArrayList;
import ax.Q2.f;
import ax.b3.a;
import ax.b3.j;
import ax.u3.c;
import ax.T2.h$g;
import ax.T2.h;
import ax.c3.d0;
import java.util.List;

public class l extends x
{
    public List<n> C(final n n, final m.f f) throws j {
        if (!d0.E(n)) {
            return (List<n>)super.C(n, f);
        }
        final h s = h.S(h.q(((m)this).t()));
        if (!s.m0()) {
            try {
                s.f(true, (h$g)null, (c)null);
            }
            catch (final a a) {
                throw new j("Cancelled", (Throwable)a);
            }
        }
        ax.T2.j j;
        if (((m)this).u() == f.m1) {
            j = s.L();
        }
        else {
            j = s.I();
        }
        if (j != null) {
            final ArrayList list = new ArrayList();
            final K q = h.q(n.L());
            final ArrayList list2 = new ArrayList((Collection)j.a());
            for (int i = 0; i < ((List)list2).size(); ++i) {
                final ArrayList list3 = new ArrayList((Collection)((k)((List)list2).get(i)).b());
                for (int k = 0; k < ((List)list3).size(); ++k) {
                    final A a2 = (A)((List)list3).get(k);
                    if (a2 != null) {
                        final ax.c3.n n2 = new ax.c3.n(this, new File(a2.a), q, i, k == 0);
                        if (((y)n2).n()) {
                            ((List)list).add((Object)n2);
                        }
                    }
                }
            }
            return (List<n>)list;
        }
        throw new t();
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
            final ax.T2.j l = s.L();
            if (l != null) {
                l.e(n.E());
                final ax.T2.j i = s.I();
                if (i != null) {
                    i.e(n.E());
                }
            }
        }
    }
}
