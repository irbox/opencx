package com.box.androidsdk.content.requests;

import java.util.Map$Entry;
import ax.O4.d;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxFolder;

public class BoxRequestsFolder$UpdateFolder extends BoxRequestItemUpdate<BoxFolder, BoxRequestsFolder$UpdateFolder>
{
    private static final long serialVersionUID = 8123965031279971522L;
    
    public BoxRequestsFolder$UpdateFolder(final String s, final String s2, final BoxSession boxSession) {
        super(BoxFolder.class, s, s2, boxSession);
    }
    
    @Override
    protected void v(final d d, final Map$Entry<String, Object> map$Entry) {
        if (((String)map$Entry.getKey()).equals((Object)"folder_upload_email")) {
            d.B((String)map$Entry.getKey(), this.w(map$Entry.getValue()));
            return;
        }
        if (((String)map$Entry.getKey()).equals((Object)"owned_by")) {
            d.B((String)map$Entry.getKey(), this.w(map$Entry.getValue()));
            return;
        }
        if (((String)map$Entry.getKey()).equals((Object)"sync_state")) {
            d.C((String)map$Entry.getKey(), ((BoxFolder.SyncState)map$Entry.getValue()).toString());
            return;
        }
        super.v(d, map$Entry);
    }
}
