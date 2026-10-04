package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxVoid;
import java.util.HashMap;
import com.box.androidsdk.content.models.BoxSession;

public class BoxRequestsFolder$DeleteFolder extends BoxRequestItemDelete<BoxRequestsFolder$DeleteFolder>
{
    private static final long serialVersionUID = 8123965031279971594L;
    
    public BoxRequestsFolder$DeleteFolder(final String s, final String s2, final BoxSession boxSession) {
        super(s, s2, boxSession);
        this.E(true);
    }
    
    public BoxRequestsFolder$DeleteFolder E(final boolean b) {
        final HashMap<String, String> mQueryMap = (HashMap<String, String>)super.mQueryMap;
        String s;
        if (b) {
            s = "true";
        }
        else {
            s = "false";
        }
        mQueryMap.put((Object)"recursive", (Object)s);
        return this;
    }
    
    @Override
    protected void u(final BoxResponse<BoxVoid> boxResponse) throws BoxException {
        super.u(boxResponse);
        super.q(boxResponse);
    }
}
