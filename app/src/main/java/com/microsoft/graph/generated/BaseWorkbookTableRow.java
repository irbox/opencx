package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.r8.i;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookTableRow extends Entity implements d
{
    @a
    @c("index")
    public Integer f;
    @a
    @c("values")
    public i g;
    private transient l h;
    private transient e i;
    
    public void d(final e i, final l h) {
        this.i = i;
        this.h = h;
    }
}
