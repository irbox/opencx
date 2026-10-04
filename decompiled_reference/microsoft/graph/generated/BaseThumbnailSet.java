package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.Thumbnail;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseThumbnailSet extends Entity implements d
{
    @a
    @c("large")
    public Thumbnail f;
    @a
    @c("medium")
    public Thumbnail g;
    @a
    @c("small")
    public Thumbnail h;
    @a
    @c("source")
    public Thumbnail i;
    private transient l j;
    private transient e k;
    
    public void d(final e k, final l j) {
        this.k = k;
        this.j = j;
    }
}
