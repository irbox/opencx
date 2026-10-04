package com.socialnmobile.dav.gson;

import ax.s8.c;
import java.util.List;
import androidx.annotation.Keep;

@Keep
public class Multistatus
{
    protected String responsedescription;
    @c("response")
    protected List<Response> responses;
    @c("sync-token")
    protected String syncToken;
    
    public List<Response> getResponse() {
        return this.responses;
    }
    
    public String getResponseDescription() {
        return this.responsedescription;
    }
}
