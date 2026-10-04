package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookFilter;
import ax.r8.i;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookTableColumn extends Entity implements d
{
    @a
    @c("index")
    public Integer f;
    @a
    @c("name")
    public String g;
    @a
    @c("values")
    public i h;
    @a
    @c("filter")
    public WorkbookFilter i;
    private transient l j;
    private transient e k;
    
    public void d(final e k, final l j) {
        this.k = k;
        this.j = j;
    }
}
