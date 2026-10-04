package com.microsoft.graph.generated;

import java.util.List;
import ax.r8.i;
import ax.N9.K0;
import com.microsoft.graph.extensions.WorkbookTable;
import ax.N9.J0;
import com.microsoft.graph.extensions.WorkbookPivotTable;
import ax.N9.I0;
import com.microsoft.graph.extensions.WorkbookNamedItem;
import ax.N9.F0;
import java.util.Arrays;
import com.microsoft.graph.extensions.WorkbookChart;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookTableCollectionPage;
import com.microsoft.graph.extensions.WorkbookWorksheetProtection;
import com.microsoft.graph.extensions.WorkbookPivotTableCollectionPage;
import com.microsoft.graph.extensions.WorkbookNamedItemCollectionPage;
import com.microsoft.graph.extensions.WorkbookChartCollectionPage;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookWorksheet extends Entity implements d
{
    @a
    @c("name")
    public String f;
    @a
    @c("position")
    public Integer g;
    @a
    @c("visibility")
    public String h;
    public transient WorkbookChartCollectionPage i;
    public transient WorkbookNamedItemCollectionPage j;
    public transient WorkbookPivotTableCollectionPage k;
    @a
    @c("protection")
    public WorkbookWorksheetProtection l;
    public transient WorkbookTableCollectionPage m;
    private transient l n;
    private transient e o;
    
    public void d(final e o, final l n) {
        this.o = o;
        this.n = n;
        final boolean x = n.x("charts");
        final int n2 = 0;
        if (x) {
            final BaseWorkbookChartCollectionResponse baseWorkbookChartCollectionResponse = new BaseWorkbookChartCollectionResponse();
            if (n.x("charts@odata.nextLink")) {
                baseWorkbookChartCollectionResponse.b = n.t("charts@odata.nextLink").k();
            }
            final l[] array = (l[])o.b(n.t("charts").toString(), (Class)l[].class);
            final WorkbookChart[] array2 = new WorkbookChart[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (WorkbookChart)o.b(((i)array[i]).toString(), (Class)WorkbookChart.class)).d(o, array[i]);
            }
            baseWorkbookChartCollectionResponse.a = (List<WorkbookChart>)Arrays.asList((Object[])array2);
            this.i = new WorkbookChartCollectionPage(baseWorkbookChartCollectionResponse, null);
        }
        if (n.x("names")) {
            final BaseWorkbookNamedItemCollectionResponse baseWorkbookNamedItemCollectionResponse = new BaseWorkbookNamedItemCollectionResponse();
            if (n.x("names@odata.nextLink")) {
                baseWorkbookNamedItemCollectionResponse.b = n.t("names@odata.nextLink").k();
            }
            final l[] array3 = (l[])o.b(n.t("names").toString(), (Class)l[].class);
            final WorkbookNamedItem[] array4 = new WorkbookNamedItem[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                (array4[j] = (WorkbookNamedItem)o.b(((i)array3[j]).toString(), (Class)WorkbookNamedItem.class)).d(o, array3[j]);
            }
            baseWorkbookNamedItemCollectionResponse.a = (List<WorkbookNamedItem>)Arrays.asList((Object[])array4);
            this.j = new WorkbookNamedItemCollectionPage(baseWorkbookNamedItemCollectionResponse, null);
        }
        if (n.x("pivotTables")) {
            final BaseWorkbookPivotTableCollectionResponse baseWorkbookPivotTableCollectionResponse = new BaseWorkbookPivotTableCollectionResponse();
            if (n.x("pivotTables@odata.nextLink")) {
                baseWorkbookPivotTableCollectionResponse.b = n.t("pivotTables@odata.nextLink").k();
            }
            final l[] array5 = (l[])o.b(n.t("pivotTables").toString(), (Class)l[].class);
            final WorkbookPivotTable[] array6 = new WorkbookPivotTable[array5.length];
            for (int k = 0; k < array5.length; ++k) {
                (array6[k] = (WorkbookPivotTable)o.b(((i)array5[k]).toString(), (Class)WorkbookPivotTable.class)).d(o, array5[k]);
            }
            baseWorkbookPivotTableCollectionResponse.a = (List<WorkbookPivotTable>)Arrays.asList((Object[])array6);
            this.k = new WorkbookPivotTableCollectionPage(baseWorkbookPivotTableCollectionResponse, null);
        }
        if (n.x("tables")) {
            final BaseWorkbookTableCollectionResponse baseWorkbookTableCollectionResponse = new BaseWorkbookTableCollectionResponse();
            if (n.x("tables@odata.nextLink")) {
                baseWorkbookTableCollectionResponse.b = n.t("tables@odata.nextLink").k();
            }
            final l[] array7 = (l[])o.b(n.t("tables").toString(), (Class)l[].class);
            final WorkbookTable[] array8 = new WorkbookTable[array7.length];
            for (int l = n2; l < array7.length; ++l) {
                (array8[l] = (WorkbookTable)o.b(((i)array7[l]).toString(), (Class)WorkbookTable.class)).d(o, array7[l]);
            }
            baseWorkbookTableCollectionResponse.a = (List<WorkbookTable>)Arrays.asList((Object[])array8);
            this.m = new WorkbookTableCollectionPage(baseWorkbookTableCollectionResponse, null);
        }
    }
}
