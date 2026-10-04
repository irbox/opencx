package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import java.util.List;
import java.util.Calendar;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseUploadSession implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("expirationDateTime")
    public Calendar c;
    @a
    @c("nextExpectedRanges")
    public List<String> d;
    @a
    @c("uploadUrl")
    public String e;
    private transient l f;
    private transient e g;
    
    public BaseUploadSession() {
        this.b = new com.microsoft.graph.serializer.a((d)this);
    }
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e g, final l f) {
        this.g = g;
        this.f = f;
    }
}
