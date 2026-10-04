package com.box.androidsdk.content.models;

import java.util.Date;

public class BoxFile extends BoxCollaborationItem
{
    public static final String[] d0;
    private static final long serialVersionUID = -4732748896882484735L;
    
    static {
        d0 = new String[] { "type", "id", "file_version", "sequence_id", "etag", "sha1", "name", "created_at", "modified_at", "description", "size", "path_collection", "uploader_display_name", "created_by", "modified_by", "trashed_at", "purged_at", "content_created_at", "content_modified_at", "owned_by", "shared_link", "parent", "item_status", "version_number", "comment_count", "permissions", "extension", "is_package", "collections", "has_collaborations", "can_non_owners_invite", "is_externally_owned", "allowed_invitee_roles", "classification" };
    }
    
    public Date I() {
        return super.I();
    }
    
    @Override
    public Long Q() {
        return super.Q();
    }
}
