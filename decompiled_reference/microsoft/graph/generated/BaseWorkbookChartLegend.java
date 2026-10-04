package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookChartLegendFormat;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookChartLegend extends Entity implements d
{
    @a
    @c("overlay")
    public Boolean f;
    @a
    @c("position")
    public String g;
    @a
    @c("visible")
    public Boolean h;
    @a
    @c("format")
    public WorkbookChartLegendFormat i;
    private transient l j;
    private transient e k;
    
    public void d(final e k, final l j) {
        this.k = k;
        this.j = j;
    }
}
