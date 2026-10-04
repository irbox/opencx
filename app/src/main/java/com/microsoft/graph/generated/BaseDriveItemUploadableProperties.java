package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.FileSystemInfo;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseDriveItemUploadableProperties implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("description")
    public String c;
    @a
    @c("fileSystemInfo")
    public FileSystemInfo d;
    @a
    @c("name")
    public String e;
    private transient l f;
    private transient e g;
    
    public BaseDriveItemUploadableProperties() {
        this.b = new com.microsoft.graph.serializer.a((d)this);
    }
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e g, final l f) {
        this.g = g;
        this.f = f;
    }
}
