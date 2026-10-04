package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.OnenoteOperationError;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Operation;

public class BaseOnenoteOperation extends Operation implements d
{
    @a
    @c("resourceLocation")
    public String k;
    @a
    @c("resourceId")
    public String l;
    @a
    @c("error")
    public OnenoteOperationError m;
    @a
    @c("percentComplete")
    public String n;
    private transient l o;
    private transient e p;
    
    public void d(final e p2, final l o) {
        this.p = p2;
        this.o = o;
    }
}
