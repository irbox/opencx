package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.SpecialFolder;
import com.microsoft.graph.extensions.SharepointIds;
import com.microsoft.graph.extensions.Shared;
import com.microsoft.graph.extensions.ItemReference;
import com.microsoft.graph.extensions.Package;
import com.microsoft.graph.extensions.Folder;
import com.microsoft.graph.extensions.FileSystemInfo;
import com.microsoft.graph.extensions.File;
import java.util.Calendar;
import com.microsoft.graph.extensions.IdentitySet;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseRemoteItem implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("createdBy")
    public IdentitySet c;
    @a
    @c("createdDateTime")
    public Calendar d;
    @a
    @c("file")
    public File e;
    @a
    @c("fileSystemInfo")
    public FileSystemInfo f;
    @a
    @c("folder")
    public Folder g;
    @a
    @c("id")
    public String h;
    @a
    @c("lastModifiedBy")
    public IdentitySet i;
    @a
    @c("lastModifiedDateTime")
    public Calendar j;
    @a
    @c("name")
    public String k;
    @a
    @c("package")
    public Package l;
    @a
    @c("parentReference")
    public ItemReference m;
    @a
    @c("shared")
    public Shared n;
    @a
    @c("sharepointIds")
    public SharepointIds o;
    @a
    @c("size")
    public Long p;
    @a
    @c("specialFolder")
    public SpecialFolder q;
    @a
    @c("webDavUrl")
    public String r;
    @a
    @c("webUrl")
    public String s;
    private transient l t;
    private transient e u;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e u, final l t) {
        this.u = u;
        this.t = t;
    }
}
