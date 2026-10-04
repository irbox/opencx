package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseWorkbookWorksheetProtectionOptions implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("allowAutoFilter")
    public Boolean c;
    @a
    @c("allowDeleteColumns")
    public Boolean d;
    @a
    @c("allowDeleteRows")
    public Boolean e;
    @a
    @c("allowFormatCells")
    public Boolean f;
    @a
    @c("allowFormatColumns")
    public Boolean g;
    @a
    @c("allowFormatRows")
    public Boolean h;
    @a
    @c("allowInsertColumns")
    public Boolean i;
    @a
    @c("allowInsertHyperlinks")
    public Boolean j;
    @a
    @c("allowInsertRows")
    public Boolean k;
    @a
    @c("allowPivotTables")
    public Boolean l;
    @a
    @c("allowSort")
    public Boolean m;
    private transient l n;
    private transient e o;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e o, final l n) {
        this.o = o;
        this.n = n;
    }
}
