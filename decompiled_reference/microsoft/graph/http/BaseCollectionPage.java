package com.microsoft.graph.http;

import j$.util.DesugarCollections;
import ax.T9.d;
import ax.T9.e;
import ax.r8.l;
import java.util.List;
import com.microsoft.graph.serializer.a;
import ax.P9.p;

public abstract class BaseCollectionPage<T1, T2 extends p> implements IBaseCollectionPage<T1, T2>
{
    private transient a a;
    private final List<T1> b;
    private final T2 c;
    private transient l d;
    private transient e e;
    
    public BaseCollectionPage(final List<T1> list, final T2 c) {
        this.a = new a((d)this);
        this.b = (List<T1>)DesugarCollections.unmodifiableList((List)list);
        this.c = c;
    }
    
    @Override
    public T2 a() {
        return this.c;
    }
    
    @Override
    public List<T1> b() {
        return this.b;
    }
    
    public final a c() {
        return this.a;
    }
    
    public void d(final e e, final l d) {
        this.e = e;
        this.d = d;
    }
}
