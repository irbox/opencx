package com.microsoft.graph.generated;

import java.util.List;
import ax.r8.i;
import ax.N9.M0;
import com.microsoft.graph.extensions.WorkbookTableRow;
import ax.N9.L0;
import java.util.Arrays;
import com.microsoft.graph.extensions.WorkbookTableColumn;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookWorksheet;
import com.microsoft.graph.extensions.WorkbookTableSort;
import com.microsoft.graph.extensions.WorkbookTableRowCollectionPage;
import com.microsoft.graph.extensions.WorkbookTableColumnCollectionPage;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookTable extends Entity implements d
{
    @a
    @c("highlightFirstColumn")
    public Boolean f;
    @a
    @c("highlightLastColumn")
    public Boolean g;
    @a
    @c("name")
    public String h;
    @a
    @c("showBandedColumns")
    public Boolean i;
    @a
    @c("showBandedRows")
    public Boolean j;
    @a
    @c("showFilterButton")
    public Boolean k;
    @a
    @c("showHeaders")
    public Boolean l;
    @a
    @c("showTotals")
    public Boolean m;
    @a
    @c("style")
    public String n;
    public transient WorkbookTableColumnCollectionPage o;
    public transient WorkbookTableRowCollectionPage p;
    @a
    @c("sort")
    public WorkbookTableSort q;
    @a
    @c("worksheet")
    public WorkbookWorksheet r;
    private transient l s;
    private transient e t;
    
    public void d(final e t, final l s) {
        this.t = t;
        this.s = s;
        final boolean x = s.x("columns");
        final int n = 0;
        if (x) {
            final BaseWorkbookTableColumnCollectionResponse baseWorkbookTableColumnCollectionResponse = new BaseWorkbookTableColumnCollectionResponse();
            if (s.x("columns@odata.nextLink")) {
                baseWorkbookTableColumnCollectionResponse.b = s.t("columns@odata.nextLink").k();
            }
            final l[] array = (l[])t.b(s.t("columns").toString(), (Class)l[].class);
            final WorkbookTableColumn[] array2 = new WorkbookTableColumn[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (WorkbookTableColumn)t.b(((i)array[i]).toString(), (Class)WorkbookTableColumn.class)).d(t, array[i]);
            }
            baseWorkbookTableColumnCollectionResponse.a = (List<WorkbookTableColumn>)Arrays.asList((Object[])array2);
            this.o = new WorkbookTableColumnCollectionPage(baseWorkbookTableColumnCollectionResponse, null);
        }
        if (s.x("rows")) {
            final BaseWorkbookTableRowCollectionResponse baseWorkbookTableRowCollectionResponse = new BaseWorkbookTableRowCollectionResponse();
            if (s.x("rows@odata.nextLink")) {
                baseWorkbookTableRowCollectionResponse.b = s.t("rows@odata.nextLink").k();
            }
            final l[] array3 = (l[])t.b(s.t("rows").toString(), (Class)l[].class);
            final WorkbookTableRow[] array4 = new WorkbookTableRow[array3.length];
            for (int j = n; j < array3.length; ++j) {
                (array4[j] = (WorkbookTableRow)t.b(((i)array3[j]).toString(), (Class)WorkbookTableRow.class)).d(t, array3[j]);
            }
            baseWorkbookTableRowCollectionResponse.a = (List<WorkbookTableRow>)Arrays.asList((Object[])array4);
            this.p = new WorkbookTableRowCollectionPage(baseWorkbookTableRowCollectionResponse, null);
        }
    }
}
