package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import java.util.Calendar;
import ax.s8.c;
import ax.s8.a;
import ax.N9.U0;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseOperation extends Entity implements d
{
    @a
    @c("status")
    public U0 f;
    @a
    @c("createdDateTime")
    public Calendar g;
    @a
    @c("lastActionDateTime")
    public Calendar h;
    private transient l i;
    private transient e j;
    
    public void d(final e j, final l i) {
        this.j = j;
        this.i = i;
    }
}
