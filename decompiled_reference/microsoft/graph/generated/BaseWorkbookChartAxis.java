package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookChartAxisTitle;
import com.microsoft.graph.extensions.WorkbookChartGridlines;
import com.microsoft.graph.extensions.WorkbookChartAxisFormat;
import ax.s8.c;
import ax.s8.a;
import ax.r8.i;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookChartAxis extends Entity implements d
{
    @a
    @c("majorUnit")
    public i f;
    @a
    @c("maximum")
    public i g;
    @a
    @c("minimum")
    public i h;
    @a
    @c("minorUnit")
    public i i;
    @a
    @c("format")
    public WorkbookChartAxisFormat j;
    @a
    @c("majorGridlines")
    public WorkbookChartGridlines k;
    @a
    @c("minorGridlines")
    public WorkbookChartGridlines l;
    @a
    @c("title")
    public WorkbookChartAxisTitle m;
    private transient l n;
    private transient e o;
    
    public void d(final e o, final l n) {
        this.o = o;
        this.n = n;
    }
}
