package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.WorkbookChartAxis;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookChartAxes extends Entity implements d
{
    @a
    @c("categoryAxis")
    public WorkbookChartAxis f;
    @a
    @c("seriesAxis")
    public WorkbookChartAxis g;
    @a
    @c("valueAxis")
    public WorkbookChartAxis h;
    private transient l i;
    private transient e j;
    
    public void d(final e j, final l i) {
        this.j = j;
        this.i = i;
    }
}
