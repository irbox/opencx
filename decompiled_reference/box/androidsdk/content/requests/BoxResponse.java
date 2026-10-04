package com.box.androidsdk.content.requests;

import java.io.Serializable;
import com.box.androidsdk.content.models.BoxObject;

public class BoxResponse<E extends BoxObject> implements Serializable
{
    protected final Exception mException;
    protected final BoxRequest mRequest;
    protected final E mResult;
    
    public BoxResponse(final E mResult, final Exception mException, final BoxRequest mRequest) {
        this.mResult = mResult;
        this.mException = mException;
        this.mRequest = mRequest;
    }
    
    public Exception a() {
        return this.mException;
    }
    
    public E b() {
        return this.mResult;
    }
    
    public boolean c() {
        return this.mException == null;
    }
}
