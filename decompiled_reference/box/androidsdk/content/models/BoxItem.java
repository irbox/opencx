package com.box.androidsdk.content.models;

import java.util.Date;
import ax.O4.d;
import java.util.EnumSet;

public abstract class BoxItem extends BoxEntity
{
    private static final long serialVersionUID = 4876182952337609430L;
    protected transient EnumSet<Permission> c0;
    
    public BoxItem() {
        this.c0 = null;
    }
    
    public BoxItem(final d d) {
        super(d);
        this.c0 = null;
    }
    
    protected Date I() {
        return this.q("content_modified_at");
    }
    
    public String J() {
        return this.u("item_status");
    }
    
    public Date K() {
        return this.q("modified_at");
    }
    
    public String M() {
        return this.u("name");
    }
    
    public BoxFolder N() {
        return this.r((b<BoxFolder>)BoxJsonObject.l((Class<T>)BoxFolder.class), "parent");
    }
    
    public BoxIterator<BoxFolder> O() {
        return this.r((b<BoxIterator<BoxFolder>>)BoxJsonObject.l((Class<T>)BoxIteratorBoxEntity.class), "path_collection");
    }
    
    public EnumSet<Permission> P() {
        if (this.c0 == null) {
            this.R();
        }
        return this.c0;
    }
    
    public Long Q() {
        return this.t("size");
    }
    
    protected EnumSet<Permission> R() {
        final BoxPermission boxPermission = this.r((b<BoxPermission>)BoxJsonObject.l((Class<T>)BoxPermission.class), "permissions");
        if (boxPermission == null) {
            return null;
        }
        return this.c0 = boxPermission.C();
    }
    
    public enum Permission
    {
        c0("can_download"), 
        d0("can_upload"), 
        e0("can_invite_collaborator"), 
        f0("can_rename"), 
        g0("can_delete"), 
        h0("can_share"), 
        i0("can_set_share_access"), 
        j0("can_comment");
        
        private static final Permission[] k0;
        
        q("can_preview");
        
        private final String value;
        
        static {
            k0 = d();
        }
        
        private Permission(final String value) {
            this.value = value;
        }
        
        private static /* synthetic */ Permission[] d() {
            return new Permission[] { Permission.q, Permission.c0, Permission.d0, Permission.e0, Permission.f0, Permission.g0, Permission.h0, Permission.i0, Permission.j0 };
        }
        
        public String toString() {
            return this.value;
        }
    }
}
