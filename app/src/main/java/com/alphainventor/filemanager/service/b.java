package com.alphainventor.filemanager.service;

import ax.Ya.a;
import ax.c3.x;
import ax.c3.K;
import ax.o3.h;
import ax.Q2.f;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import com.alphainventor.filemanager.file.n;
import java.util.List;
import ax.c3.d0;
import java.io.IOException;
import android.net.Uri;
import ax.Q2.g;
import java.util.concurrent.CopyOnWriteArraySet;
import com.alphainventor.filemanager.file.o;
import java.util.concurrent.CopyOnWriteArrayList;
import ax.o3.c;
import android.content.Context;
import java.util.logging.Logger;

public class b
{
    private static final Logger g;
    private static b h;
    private Context a;
    private c b;
    private int c;
    private CopyOnWriteArrayList<o> d;
    private CopyOnWriteArraySet<a> e;
    private CopyOnWriteArraySet<String> f;
    
    static {
        g = ax.Q2.g.a((Class)b.class);
    }
    
    private b(final Context context) {
        this.c = -1;
        this.d = (CopyOnWriteArrayList<o>)new CopyOnWriteArrayList();
        this.e = (CopyOnWriteArraySet<a>)new CopyOnWriteArraySet();
        this.f = (CopyOnWriteArraySet<String>)new CopyOnWriteArraySet();
        this.a = context.getApplicationContext();
    }
    
    public static b f(final Context context) {
        if (b.h == null) {
            b.h = new b(context);
        }
        return b.h;
    }
    
    public static boolean k(final Context context, final Uri uri) {
        final int h = f(context).h();
        return "http".equals((Object)uri.getScheme()) && "127.0.0.1".equals((Object)uri.getHost()) && h == uri.getPort();
    }
    
    private void p() throws IOException {
        try {
            ((ax.Ya.a)(this.b = new c(this, this.h()))).u(5000, false);
        }
        catch (final IOException ex) {
            final ax.Ha.b l = ax.Ha.c.h().d("HTTP SERVER START FAILED").l((Throwable)ex);
            final StringBuilder sb = new StringBuilder();
            sb.append("port:");
            sb.append(this.c);
            l.g((Object)sb.toString()).h();
            this.b = null;
            this.c = -1;
            throw new IOException((Throwable)ex);
        }
    }
    
    private void q() {
        final c b = this.b;
        if (b != null) {
            ((ax.Ya.a)b).v();
            this.b = null;
        }
        this.c = -1;
        this.e.clear();
    }
    
    public boolean a(String t) {
        t = d0.t(t);
        return this.f.add((Object)t);
    }
    
    public void b(final List<n> list) {
        final ArrayList list2 = new ArrayList();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add((Object)d0.p(((n)iterator.next()).Q()));
        }
        this.f.addAll((Collection)list2);
    }
    
    public boolean c(final n n) {
        return this.f.add((Object)d0.p(n.Q()));
    }
    
    public void d(final a a) {
        if (!this.e.contains((Object)a)) {
            this.e.add((Object)a);
        }
    }
    
    public void e(o o) {
        monitorenter(this);
        while (true) {
            try {
                if (this.b == null) {
                    final b b = this;
                    b.p();
                    break Label_0030;
                }
                break Label_0030;
            }
            finally {
                final o o2;
                o = o2;
                Label_0118: {
                    break Label_0118;
                    try {
                        this.p();
                        o.n0();
                        this.d.add((Object)o);
                        final Logger g = com.alphainventor.filemanager.service.b.g;
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Http server operator added : ");
                        sb.append(o.S().I());
                        sb.append(":");
                        sb.append(o.y());
                        sb.append(",port:");
                        sb.append(this.c);
                        g.fine(sb.toString());
                        monitorexit(this);
                        return;
                        monitorexit(this);
                    }
                    catch (final IOException ex) {}
                }
            }
            try {
                final b b = this;
                b.p();
                continue;
            }
            catch (final IOException ex2) {}
            break;
        }
    }
    
    public o g(final f f, final int n) {
        monitorenter(this);
        Label_0066: {
            try {
                Block_5: {
                    for (final o o : this.d) {
                        if (o.S() == f && o.y() == n) {
                            break Block_5;
                        }
                    }
                    break Label_0066;
                }
                monitorexit(this);
                return;
            }
            finally {
                monitorexit(this);
                monitorexit(this);
                return null;
            }
        }
    }
    
    public int h() {
        if (this.c < 0) {
            this.c = ax.o3.h.d(this.a);
        }
        return this.c;
    }
    
    public boolean i() {
        synchronized (this) {
            return this.d.size() != 0;
        }
    }
    
    public boolean j(final String s) {
        final Iterator iterator = this.f.iterator();
        while (iterator.hasNext()) {
            if (s.startsWith((String)iterator.next())) {
                return true;
            }
        }
        return false;
    }
    
    public void l(final boolean b, final K k) {
        final Logger g = b.g;
        final StringBuilder sb = new StringBuilder();
        sb.append("Keep Http Server : ");
        sb.append((Object)k);
        g.fine(sb.toString());
        final o e = x.e(k);
        if (b) {
            this.e(e);
            return;
        }
        this.o(e);
    }
    
    public void m(final int n) {
        final Logger g = com.alphainventor.filemanager.service.b.g;
        final StringBuilder sb = new StringBuilder();
        sb.append("runner count changed : ");
        sb.append(n);
        g.fine(sb.toString());
        final Iterator iterator = this.e.iterator();
        while (iterator.hasNext()) {
            ((a)iterator.next()).a(n);
        }
    }
    
    public void n(final a a) {
        this.e.remove((Object)a);
    }
    
    public void o(final o o) {
        monitorenter(this);
        Label_0023: {
            try {
                if (this.b == null) {
                    ax.u3.b.f();
                    monitorexit(this);
                    return;
                }
                break Label_0023;
            }
            finally {
                monitorexit(this);
                while (true) {
                Block_6:
                    while (true) {
                        iftrue(Label_0122:)(this.i());
                        break Block_6;
                        o.k0(false);
                        final Logger g = com.alphainventor.filemanager.service.b.g;
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Http server operator removed : ");
                        sb.append(o.S().I());
                        sb.append(":");
                        sb.append(o.y());
                        sb.append(",port:");
                        sb.append(this.c);
                        g.fine(sb.toString());
                        continue;
                    }
                    this.q();
                    Label_0122: {
                        monitorexit(this);
                    }
                    return;
                    iftrue(Label_0111:)(!this.d.remove((Object)o));
                    continue;
                }
            }
        }
    }
    
    interface a
    {
        void a(final int p0);
    }
}
