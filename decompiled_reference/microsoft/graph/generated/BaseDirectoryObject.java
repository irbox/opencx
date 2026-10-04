package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import java.util.Calendar;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseDirectoryObject extends Entity implements d
{
    @a
    @c("deletedDateTime")
    public Calendar f;
    private transient l g;
    private transient e h;
    
    public void d(final e h, final l g) {
        this.h = h;
        this.g = g;
    }
}
