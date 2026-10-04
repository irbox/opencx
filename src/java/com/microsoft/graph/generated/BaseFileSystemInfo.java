package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import java.util.Calendar;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseFileSystemInfo implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("createdDateTime")
    public Calendar c;
    @a
    @c("lastAccessedDateTime")
    public Calendar d;
    @a
    @c("lastModifiedDateTime")
    public Calendar e;
    private transient l f;
    private transient e g;
    
    public BaseFileSystemInfo() {
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
