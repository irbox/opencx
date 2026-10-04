package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import java.util.Calendar;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseAttachment extends Entity implements d
{
    @a
    @c("lastModifiedDateTime")
    public Calendar f;
    @a
    @c("name")
    public String g;
    @a
    @c("contentType")
    public String h;
    @a
    @c("size")
    public Integer i;
    @a
    @c("isInline")
    public Boolean j;
    private transient l k;
    private transient e l;
    
    public void d(final e l, final l k) {
        this.l = l;
        this.k = k;
    }
}
