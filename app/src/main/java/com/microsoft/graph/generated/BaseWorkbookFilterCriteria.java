package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.r8.i;
import com.microsoft.graph.extensions.WorkbookIcon;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseWorkbookFilterCriteria implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("color")
    public String c;
    @a
    @c("criterion1")
    public String d;
    @a
    @c("criterion2")
    public String e;
    @a
    @c("dynamicCriteria")
    public String f;
    @a
    @c("filterOn")
    public String g;
    @a
    @c("icon")
    public WorkbookIcon h;
    @a
    @c("operator")
    public String i;
    @a
    @c("values")
    public i j;
    private transient l k;
    private transient e l;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e l, final l k) {
        this.l = l;
        this.k = k;
    }
}
