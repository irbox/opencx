package com.box.androidsdk.content.models;

import java.util.Iterator;
import java.text.ParseException;
import ax.H3.a;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.io.Serializable;
import ax.O4.g;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import ax.H3.b;
import ax.O4.d;

public abstract class BoxJsonObject extends BoxObject
{
    private static final long serialVersionUID = 7174936367401884790L;
    private CacheMap mCacheMap;
    
    public BoxJsonObject() {
        this.i(new d());
    }
    
    public BoxJsonObject(final d d) {
        this.i(d);
    }
    
    public static <T extends BoxJsonObject> b<T> l(final Class<T> clazz) {
        return (b<T>)new b<T>(clazz) {
            final Class a;
            
            @Override
            public T a(final d d) {
                Label_0063: {
                    try {
                        final BoxJsonObject boxJsonObject = this.a.newInstance();
                        boxJsonObject.i(d);
                        return (T)boxJsonObject;
                    }
                    catch (final IllegalAccessException ex) {}
                    catch (final InstantiationException ex2) {
                        break Label_0063;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("getBoxJsonObjectCreator ");
                    sb.append((Object)this.a);
                    final IllegalAccessException ex;
                    ax.H3.b.b("BoxJsonObject", sb.toString(), (Throwable)ex);
                    return null;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("getBoxJsonObjectCreator ");
                sb2.append((Object)this.a);
                final InstantiationException ex2;
                ax.H3.b.b("BoxJsonObject", sb2.toString(), (Throwable)ex2);
                return null;
            }
        };
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.i(d.I((Reader)new BufferedReader((Reader)new InputStreamReader((InputStream)objectInputStream))));
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter((Writer)new OutputStreamWriter((OutputStream)objectOutputStream));
        this.mCacheMap.n((Writer)bufferedWriter);
        bufferedWriter.flush();
    }
    
    public String A() {
        return this.mCacheMap.m();
    }
    
    public d B() {
        return d.J(this.A());
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof BoxJsonObject && this.mCacheMap.equals(((BoxJsonObject)o).mCacheMap);
    }
    
    @Override
    public int hashCode() {
        return this.mCacheMap.hashCode();
    }
    
    public void i(final d d) {
        this.mCacheMap = new CacheMap(d);
    }
    
    public void k(final String s) {
        this.i(d.J(s));
    }
    
    public List<String> n() {
        return this.mCacheMap.i();
    }
    
    protected Boolean p(final String s) {
        return this.mCacheMap.a(s);
    }
    
    protected Date q(final String s) {
        return this.mCacheMap.b(s);
    }
    
    protected <T extends BoxJsonObject> T r(final b<T> b, final String s) {
        return this.mCacheMap.e(b, s);
    }
    
    protected <T extends BoxJsonObject> ArrayList<T> s(final b<T> b, final String s) {
        return this.mCacheMap.f(b, s);
    }
    
    protected Long t(final String s) {
        if (this.mCacheMap.c(s) == null) {
            return null;
        }
        return this.mCacheMap.c(s).longValue();
    }
    
    protected String u(final String s) {
        return this.mCacheMap.h(s);
    }
    
    public g w(final String s) {
        final g g = this.mCacheMap.g(s);
        if (g == null) {
            return null;
        }
        return ax.O4.g.t(g.toString());
    }
    
    protected void x(final String s, final BoxJsonObject boxJsonObject) {
        this.mCacheMap.j(s, boxJsonObject);
    }
    
    protected void y(final String s, final Long n) {
        this.mCacheMap.k(s, n);
    }
    
    protected void z(final String s, final String s2) {
        this.mCacheMap.l(s, s2);
    }
    
    class CacheMap implements Serializable
    {
        private d mJsonObject;
        private transient HashMap<String, Object> q;
        final BoxJsonObject this$0;
        
        public CacheMap(final BoxJsonObject this$0, final d mJsonObject) {
            this.this$0 = this$0;
            this.mJsonObject = mJsonObject;
            this.q = (HashMap<String, Object>)new LinkedHashMap();
        }
        
        public Boolean a(final String s) {
            final g g = this.g(s);
            if (g == null) {
                return null;
            }
            return g.g();
        }
        
        public Date b(final String s) {
            final g g = this.g(s);
            if (g != null) {
                if (!g.p()) {
                    final Date date = (Date)this.q.get((Object)s);
                    if (date != null) {
                        return date;
                    }
                    try {
                        final Date c = a.c(g.k());
                        this.q.put((Object)s, (Object)c);
                        return c;
                    }
                    catch (final ParseException ex) {
                        ax.H3.b.b("BoxJsonObject", "getAsDate", (Throwable)ex);
                    }
                }
            }
            return null;
        }
        
        public Double c(final String s) {
            final g g = this.g(s);
            if (g != null && !g.p()) {
                return g.h();
            }
            return null;
        }
        
        public ax.O4.a d(final String s) {
            final g g = this.g(s);
            if (g != null && !g.p()) {
                return g.e();
            }
            return null;
        }
        
        public <T extends BoxJsonObject> T e(final b<T> b, final String s) {
            if (this.q.get((Object)s) != null) {
                return (T)this.q.get((Object)s);
            }
            final g g = this.g(s);
            if (g != null && !g.p() && g.q()) {
                final BoxJsonObject a = b.a(g.i());
                this.q.put((Object)s, (Object)a);
                return (T)a;
            }
            return null;
        }
        
        @Override
        public boolean equals(final Object o) {
            return this.mJsonObject.equals((Object)((CacheMap)o).mJsonObject);
        }
        
        public <T extends BoxJsonObject> ArrayList<T> f(final b<T> b, final String s) {
            if (this.q.get((Object)s) != null) {
                return (ArrayList<T>)this.q.get((Object)s);
            }
            final g g = this.g(s);
            if (g != null && !g.n() && g.q()) {
                final ArrayList list = new ArrayList(1);
                list.add(b.a(g.i()));
                this.q.put((Object)s, (Object)list);
                return (ArrayList<T>)list;
            }
            final ax.O4.a d = this.d(s);
            if (d == null) {
                return null;
            }
            final ArrayList list2 = new ArrayList(d.size());
            final Iterator iterator = d.iterator();
            while (iterator.hasNext()) {
                list2.add(b.a(((g)iterator.next()).i()));
            }
            this.q.put((Object)s, (Object)list2);
            return (ArrayList<T>)list2;
        }
        
        public g g(final String s) {
            return this.mJsonObject.D(s);
        }
        
        public String h(final String s) {
            final g g = this.g(s);
            if (g != null && !g.p()) {
                return g.k();
            }
            return null;
        }
        
        @Override
        public int hashCode() {
            return this.mJsonObject.hashCode();
        }
        
        public List<String> i() {
            return (List<String>)this.mJsonObject.G();
        }
        
        public void j(final String s, final BoxJsonObject boxJsonObject) {
            this.mJsonObject.M(s, (g)boxJsonObject.B());
            if (this.q.containsKey((Object)s)) {
                this.q.remove((Object)s);
            }
        }
        
        public void k(final String s, final Long n) {
            this.mJsonObject.K(s, (long)n);
            if (this.q.containsKey((Object)s)) {
                this.q.remove((Object)s);
            }
        }
        
        public void l(final String s, final String s2) {
            this.mJsonObject.N(s, s2);
            if (this.q.containsKey((Object)s)) {
                this.q.remove((Object)s);
            }
        }
        
        public String m() {
            return ((g)this.mJsonObject).toString();
        }
        
        public void n(final Writer writer) throws IOException {
            ((g)this.mJsonObject).A(writer);
        }
    }
    
    public interface b<E extends BoxJsonObject>
    {
        E a(final d p0);
    }
}
