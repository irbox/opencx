package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import java.util.Calendar;
import ax.N9.Y0;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseResponseStatus implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("response")
    public Y0 c;
    @a
    @c("time")
    public Calendar d;
    private transient l e;
    private transient e f;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e f, final l e) {
        this.f = f;
        this.e = e;
    }
}
