package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import java.util.List;
import ax.s8.c;
import ax.s8.a;
import java.util.Calendar;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseOutlookItem extends Entity implements d
{
    @a
    @c("createdDateTime")
    public Calendar f;
    @a
    @c("lastModifiedDateTime")
    public Calendar g;
    @a
    @c("changeKey")
    public String h;
    @a
    @c("categories")
    public List<String> i;
    private transient l j;
    private transient e k;
    
    public void d(final e k, final l j) {
        this.k = k;
        this.j = j;
    }
}
