package com.alphainventor.filemanager.file;

import ax.c3.b;
import android.content.Context;
import ax.c3.B;
import ax.T2.h$h;
import java.util.Collection;
import java.util.ArrayList;
import ax.b3.j;
import ax.u3.c;
import ax.T2.h$g;
import java.util.List;
import ax.U2.d;
import ax.c3.d0;
import ax.c3.K;
import ax.T2.h;

public class a extends x
{
    h A;
    K z;
    
    public static boolean U1(final n n) {
        return d.Q(d0.v(h.q(n.L()), n.E(), Boolean.TRUE));
    }
    
    public List<n> C(final n n, final m.f f) throws j {
        if (d0.E(n)) {
            if (!this.A.m0()) {
                try {
                    this.A.f(true, (h$g)null, (c)null);
                }
                catch (final ax.b3.a a) {
                    throw new j("Cancelled", (Throwable)a);
                }
            }
            final ArrayList list = new ArrayList((Collection)this.A.N());
            final ArrayList list2 = new ArrayList();
            int n2;
            for (int size = list.size(), i = 0; i < size; i = n2) {
                final Object value = list.get(i);
                n2 = i + 1;
                final h$h h$h = (h$h)value;
                i = n2;
                if (h$h.b() != 0L) {
                    ((List)list2).add((Object)this.z(this.A.z(h$h.a())));
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
        if (((b)n).isDirectory() && this.T1(n)) {
            return B.S(this.z, n);
        }
        return B.W(n);
    }
    
    public void P(final n n) throws j {
        final boolean directory = ((b)n).isDirectory();
        final List n2 = this.A.N();
        final int n3 = 0;
        final boolean b = directory && this.T1(n);
        long b2 = 0L;
        Label_0124: {
            if (b && this.A.m0() && n2 != null) {
                for (int i = 0; i < n2.size(); ++i) {
                    final h$h h$h = (h$h)n2.get(i);
                    if (this.A.z(h$h.a()).equals((Object)n.E())) {
                        b2 = h$h.b();
                        break Label_0124;
                    }
                }
            }
            b2 = 0L;
        }
        super.P(n);
        if (b && this.A.m0() && n2 != null) {
            for (int j = n3; j < n2.size(); ++j) {
                if (this.A.z(((h$h)n2.get(j)).a()).equals((Object)n.E())) {
                    n2.remove(j);
                    this.A.N0(b2);
                    return;
                }
            }
        }
    }
    
    boolean T1(final n n) {
        return d.Q(d0.v(this.z, n.E(), Boolean.TRUE));
    }
    
    public void W(final Context context, final K k) {
        super.W(context, k);
        final K q = h.q(((m)this).t());
        this.z = q;
        this.A = h.S(q);
    }
}
