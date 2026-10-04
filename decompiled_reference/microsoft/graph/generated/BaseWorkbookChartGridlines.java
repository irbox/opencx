package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookChartGridlinesFormat;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookChartGridlines extends Entity implements d
{
    @a
    @c("visible")
    public Boolean f;
    @a
    @c("format")
    public WorkbookChartGridlinesFormat g;
    private transient l h;
    private transient e i;
    
    public void d(final e i, final l h) {
        this.i = i;
        this.h = h;
    }
}
