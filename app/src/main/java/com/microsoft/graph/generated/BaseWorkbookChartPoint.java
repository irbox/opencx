package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookChartPointFormat;
import ax.s8.c;
import ax.s8.a;
import ax.r8.i;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookChartPoint extends Entity implements d
{
    @a
    @c("value")
    public i f;
    @a
    @c("format")
    public WorkbookChartPointFormat g;
    private transient l h;
    private transient e i;
    
    public void d(final e i, final l h) {
        this.i = i;
        this.h = h;
    }
}
