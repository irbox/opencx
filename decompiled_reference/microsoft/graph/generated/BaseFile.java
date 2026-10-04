package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.Hashes;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseFile implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("hashes")
    public Hashes c;
    @a
    @c("mimeType")
    public String d;
    @a
    @c("processingMetadata")
    public Boolean e;
    private transient l f;
    private transient e g;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e g, final l f) {
        this.g = g;
        this.f = f;
    }
}
