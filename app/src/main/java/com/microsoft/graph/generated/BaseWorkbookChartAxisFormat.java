package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookChartLineFormat;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.WorkbookChartFont;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookChartAxisFormat extends Entity implements d
{
    @a
    @c("font")
    public WorkbookChartFont f;
    @a
    @c("line")
    public WorkbookChartLineFormat g;
    private transient l h;
    private transient e i;
    
    public void d(final e i, final l h) {
        this.i = i;
        this.h = h;
    }
}
