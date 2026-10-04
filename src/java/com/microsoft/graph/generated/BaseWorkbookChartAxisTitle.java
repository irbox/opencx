package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookChartAxisTitleFormat;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookChartAxisTitle extends Entity implements d
{
    @a
    @c("text")
    public String f;
    @a
    @c("visible")
    public Boolean g;
    @a
    @c("format")
    public WorkbookChartAxisTitleFormat h;
    private transient l i;
    private transient e j;
    
    public void d(final e j, final l i) {
        this.j = j;
        this.i = i;
    }
}
