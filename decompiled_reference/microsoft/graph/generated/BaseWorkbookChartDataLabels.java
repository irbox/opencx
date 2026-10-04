package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookChartDataLabelFormat;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookChartDataLabels extends Entity implements d
{
    @a
    @c("position")
    public String f;
    @a
    @c("separator")
    public String g;
    @a
    @c("showBubbleSize")
    public Boolean h;
    @a
    @c("showCategoryName")
    public Boolean i;
    @a
    @c("showLegendKey")
    public Boolean j;
    @a
    @c("showPercentage")
    public Boolean k;
    @a
    @c("showSeriesName")
    public Boolean l;
    @a
    @c("showValue")
    public Boolean m;
    @a
    @c("format")
    public WorkbookChartDataLabelFormat n;
    private transient l o;
    private transient e p;
    
    public void d(final e p2, final l o) {
        this.p = p2;
        this.o = o;
    }
}
