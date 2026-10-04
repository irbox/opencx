package com.microsoft.graph.generated;

import java.util.List;
import ax.r8.i;
import ax.N9.G0;
import java.util.Arrays;
import com.microsoft.graph.extensions.WorkbookChartPoint;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookChartPointCollectionPage;
import com.microsoft.graph.extensions.WorkbookChartSeriesFormat;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookChartSeries extends Entity implements d
{
    @a
    @c("name")
    public String f;
    @a
    @c("format")
    public WorkbookChartSeriesFormat g;
    public transient WorkbookChartPointCollectionPage h;
    private transient l i;
    private transient e j;
    
    public void d(final e j, final l i) {
        this.j = j;
        this.i = i;
        if (i.x("points")) {
            final BaseWorkbookChartPointCollectionResponse baseWorkbookChartPointCollectionResponse = new BaseWorkbookChartPointCollectionResponse();
            if (i.x("points@odata.nextLink")) {
                baseWorkbookChartPointCollectionResponse.b = i.t("points@odata.nextLink").k();
            }
            final l[] array = (l[])j.b(i.t("points").toString(), (Class)l[].class);
            final WorkbookChartPoint[] array2 = new WorkbookChartPoint[array.length];
            for (int k = 0; k < array.length; ++k) {
                (array2[k] = (WorkbookChartPoint)j.b(((i)array[k]).toString(), (Class)WorkbookChartPoint.class)).d(j, array[k]);
            }
            baseWorkbookChartPointCollectionResponse.a = (List<WorkbookChartPoint>)Arrays.asList((Object[])array2);
            this.h = new WorkbookChartPointCollectionPage(baseWorkbookChartPointCollectionResponse, null);
        }
    }
}
