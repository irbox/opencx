package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.EmailAddress;
import ax.s8.c;
import ax.s8.a;
import ax.N9.P0;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseInferenceClassificationOverride extends Entity implements d
{
    @a
    @c("classifyAs")
    public P0 f;
    @a
    @c("senderEmailAddress")
    public EmailAddress g;
    private transient l h;
    private transient e i;
    
    public void d(final e i, final l h) {
        this.i = i;
        this.h = h;
    }
}
