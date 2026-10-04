package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import java.util.List;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseChoiceColumn implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("allowTextEntry")
    public Boolean c;
    @a
    @c("choices")
    public List<String> d;
    @a
    @c("displayAs")
    public String e;
    private transient l f;
    private transient e g;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e g, final l f) {
        this.g = g;
        this.f = f;
    }
}
