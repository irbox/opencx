package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.models.BoxSession;

public class BoxRequestsFile$DeleteFile extends BoxRequestItemDelete<BoxRequestsFile$DeleteFile>
{
    private static final long serialVersionUID = 8123965031279971593L;
    
    public BoxRequestsFile$DeleteFile(final String s, final String s2, final BoxSession boxSession) {
        super(s, s2, boxSession);
    }
    
    @Override
    protected void u(final BoxResponse<BoxVoid> boxResponse) throws BoxException {
        super.u(boxResponse);
        super.q(boxResponse);
    }
}
