package com.microsoft.graph.generated;

import java.util.List;
import ax.r8.i;
import ax.N9.N0;
import com.microsoft.graph.extensions.WorkbookWorksheet;
import ax.N9.K0;
import com.microsoft.graph.extensions.WorkbookTable;
import ax.N9.I0;
import java.util.Arrays;
import com.microsoft.graph.extensions.WorkbookNamedItem;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkbookFunctions;
import com.microsoft.graph.extensions.WorkbookWorksheetCollectionPage;
import com.microsoft.graph.extensions.WorkbookTableCollectionPage;
import com.microsoft.graph.extensions.WorkbookNamedItemCollectionPage;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.WorkbookApplication;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbook extends Entity implements d
{
    @a
    @c("application")
    public WorkbookApplication f;
    public transient WorkbookNamedItemCollectionPage g;
    public transient WorkbookTableCollectionPage h;
    public transient WorkbookWorksheetCollectionPage i;
    @a
    @c("functions")
    public WorkbookFunctions j;
    private transient l k;
    private transient e l;
    
    public void d(final e l, final l k) {
        this.l = l;
        this.k = k;
        final boolean x = k.x("names");
        final int n = 0;
        if (x) {
            final BaseWorkbookNamedItemCollectionResponse baseWorkbookNamedItemCollectionResponse = new BaseWorkbookNamedItemCollectionResponse();
            if (k.x("names@odata.nextLink")) {
                baseWorkbookNamedItemCollectionResponse.b = k.t("names@odata.nextLink").k();
            }
            final l[] array = (l[])l.b(k.t("names").toString(), (Class)l[].class);
            final WorkbookNamedItem[] array2 = new WorkbookNamedItem[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (WorkbookNamedItem)l.b(((i)array[i]).toString(), (Class)WorkbookNamedItem.class)).d(l, array[i]);
            }
            baseWorkbookNamedItemCollectionResponse.a = (List<WorkbookNamedItem>)Arrays.asList((Object[])array2);
            this.g = new WorkbookNamedItemCollectionPage(baseWorkbookNamedItemCollectionResponse, null);
        }
        if (k.x("tables")) {
            final BaseWorkbookTableCollectionResponse baseWorkbookTableCollectionResponse = new BaseWorkbookTableCollectionResponse();
            if (k.x("tables@odata.nextLink")) {
                baseWorkbookTableCollectionResponse.b = k.t("tables@odata.nextLink").k();
            }
            final l[] array3 = (l[])l.b(k.t("tables").toString(), (Class)l[].class);
            final WorkbookTable[] array4 = new WorkbookTable[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                (array4[j] = (WorkbookTable)l.b(((i)array3[j]).toString(), (Class)WorkbookTable.class)).d(l, array3[j]);
            }
            baseWorkbookTableCollectionResponse.a = (List<WorkbookTable>)Arrays.asList((Object[])array4);
            this.h = new WorkbookTableCollectionPage(baseWorkbookTableCollectionResponse, null);
        }
        if (k.x("worksheets")) {
            final BaseWorkbookWorksheetCollectionResponse baseWorkbookWorksheetCollectionResponse = new BaseWorkbookWorksheetCollectionResponse();
            if (k.x("worksheets@odata.nextLink")) {
                baseWorkbookWorksheetCollectionResponse.b = k.t("worksheets@odata.nextLink").k();
            }
            final l[] array5 = (l[])l.b(k.t("worksheets").toString(), (Class)l[].class);
            final WorkbookWorksheet[] array6 = new WorkbookWorksheet[array5.length];
            for (int n2 = n; n2 < array5.length; ++n2) {
                (array6[n2] = (WorkbookWorksheet)l.b(((i)array5[n2]).toString(), (Class)WorkbookWorksheet.class)).d(l, array5[n2]);
            }
            baseWorkbookWorksheetCollectionResponse.a = (List<WorkbookWorksheet>)Arrays.asList((Object[])array6);
            this.i = new WorkbookWorksheetCollectionPage(baseWorkbookWorksheetCollectionResponse, null);
        }
    }
}
