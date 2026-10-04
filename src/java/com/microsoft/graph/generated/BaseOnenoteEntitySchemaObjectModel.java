package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import java.util.Calendar;
import ax.T9.d;
import com.microsoft.graph.extensions.OnenoteEntityBaseModel;

public class BaseOnenoteEntitySchemaObjectModel extends OnenoteEntityBaseModel implements d
{
    @a
    @c("createdDateTime")
    public Calendar i;
    private transient l j;
    private transient e k;
    
    public void d(final e k, final l j) {
        this.k = k;
        this.j = j;
    }
}
