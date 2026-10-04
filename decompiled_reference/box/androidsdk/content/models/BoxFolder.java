package com.box.androidsdk.content.models;

import android.text.TextUtils;
import ax.O4.d;

public class BoxFolder extends BoxCollaborationItem
{
    public static final String[] d0;
    private static final long serialVersionUID = 8020073615785970254L;
    
    static {
        d0 = new String[] { "type", "sha1", "id", "sequence_id", "etag", "name", "created_at", "modified_at", "description", "size", "path_collection", "created_by", "modified_by", "trashed_at", "purged_at", "content_created_at", "content_modified_at", "owned_by", "shared_link", "folder_upload_email", "parent", "item_status", "item_collection", "sync_state", "has_collaborations", "permissions", "can_non_owners_invite", "is_externally_owned", "allowed_invitee_roles", "collections", "classification" };
    }
    
    public BoxFolder() {
    }
    
    public BoxFolder(final d d) {
        super(d);
    }
    
    public static BoxFolder S(final String s) {
        return T(s, null);
    }
    
    public static BoxFolder T(final String s, final String s2) {
        final d d = new d();
        d.C("id", s);
        d.C("type", "folder");
        if (!TextUtils.isEmpty((CharSequence)s2)) {
            d.C("name", s2);
        }
        return new BoxFolder(d);
    }
    
    @Override
    public Long Q() {
        return super.Q();
    }
    
    public enum SyncState
    {
        c0("not_synced"), 
        d0("partially_synced");
        
        private static final SyncState[] e0;
        
        q("synced");
        
        private final String mValue;
        
        static {
            e0 = d();
        }
        
        private SyncState(final String mValue) {
            this.mValue = mValue;
        }
        
        private static /* synthetic */ SyncState[] d() {
            return new SyncState[] { SyncState.q, SyncState.c0, SyncState.d0 };
        }
        
        public String toString() {
            return this.mValue;
        }
    }
}
