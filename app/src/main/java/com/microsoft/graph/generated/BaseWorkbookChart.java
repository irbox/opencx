package com.microsoft.graph.generated;

import java.util.List;
import ax.r8.i;
import ax.N9.H0;
import java.util.Arrays;
import com.microsoft.graph.extensions.WorkbookChartSeries;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookWorksheet;
import com.microsoft.graph.extensions.WorkbookChartTitle;
import com.microsoft.graph.extensions.WorkbookChartSeriesCollectionPage;
import com.microsoft.graph.extensions.WorkbookChartLegend;
import com.microsoft.graph.extensions.WorkbookChartAreaFormat;
import com.microsoft.graph.extensions.WorkbookChartDataLabels;
import com.microsoft.graph.extensions.WorkbookChartAxes;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookChart extends Entity implements d
{
    @a
    @c("height")
    public Double f;
    @a
    @c("left")
    public Double g;
    @a
    @c("name")
    public String h;
    @a
    @c("top")
    public Double i;
    @a
    @c("width")
    public Double j;
    @a
    @c("axes")
    public WorkbookChartAxes k;
    @a
    @c("dataLabels")
    public WorkbookChartDataLabels l;
    @a
    @c("format")
    public WorkbookChartAreaFormat m;
    @a
    @c("legend")
    public WorkbookChartLegend n;
    public transient WorkbookChartSeriesCollectionPage o;
    @a
    @c("title")
    public WorkbookChartTitle p;
    @a
    @c("worksheet")
    public WorkbookWorksheet q;
    private transient l r;
    private transient e s;
    
    public void d(final e s, final l r) {
        this.s = s;
        this.r = r;
        if (r.x("series")) {
            final BaseWorkbookChartSeriesCollectionResponse baseWorkbookChartSeriesCollectionResponse = new BaseWorkbookChartSeriesCollectionResponse();
            if (r.x("series@odata.nextLink")) {
                baseWorkbookChartSeriesCollectionResponse.b = r.t("series@odata.nextLink").k();
            }
            final l[] array = (l[])s.b(r.t("series").toString(), (Class)l[].class);
            final WorkbookChartSeries[] array2 = new WorkbookChartSeries[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (WorkbookChartSeries)s.b(((i)array[i]).toString(), (Class)WorkbookChartSeries.class)).d(s, array[i]);
            }
            baseWorkbookChartSeriesCollectionResponse.a = (List<WorkbookChartSeries>)Arrays.asList((Object[])array2);
            this.o = new WorkbookChartSeriesCollectionPage(baseWorkbookChartSeriesCollectionResponse, null);
        }
    }
}
