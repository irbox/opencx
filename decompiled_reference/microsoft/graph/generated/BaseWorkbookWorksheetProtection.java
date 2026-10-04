package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.WorkbookWorksheetProtectionOptions;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseWorkbookWorksheetProtection extends Entity implements d
{
    @a
    @c("options")
    public WorkbookWorksheetProtectionOptions f;
    @a
    @c("protected")
    public Boolean g;
    private transient l h;
    private transient e i;
    
    public void d(final e i, final l h) {
        this.i = i;
        this.h = h;
    }
}
