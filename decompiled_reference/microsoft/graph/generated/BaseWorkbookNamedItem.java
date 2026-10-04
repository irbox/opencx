package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookWorksheet;
import ax.r8.i;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookNamedItem extends Entity implements d
{
    @a
    @c("comment")
    public String f;
    @a
    @c("name")
    public String g;
    @a
    @c("scope")
    public String h;
    @a
    @c("type")
    public String i;
    @a
    @c("value")
    public i j;
    @a
    @c("visible")
    public Boolean k;
    @a
    @c("worksheet")
    public WorkbookWorksheet l;
    private transient l m;
    private transient e n;
    
    public void d(final e n, final l m) {
        this.n = n;
        this.m = m;
    }
}
