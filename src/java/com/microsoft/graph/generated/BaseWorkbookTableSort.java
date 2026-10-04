package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import java.util.List;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookTableSort extends Entity implements d
{
    @a
    @c("fields")
    public List<Object> f;
    @a
    @c("matchCase")
    public Boolean g;
    @a
    @c("method")
    public String h;
    private transient l i;
    private transient e j;
    
    public void d(final e j, final l i) {
        this.j = j;
        this.i = i;
    }
}
