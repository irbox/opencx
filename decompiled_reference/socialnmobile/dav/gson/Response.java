package com.socialnmobile.dav.gson;

import java.util.ArrayList;
import ax.s8.c;
import java.util.List;
import androidx.annotation.Keep;

@Keep
public class Response
{
    private Object error;
    private String href;
    @c("propstat")
    private List<Propstat> propstats;
    private String responsedescription;
    private String status;
    
    public Object getError() {
        return this.error;
    }
    
    public String getHref() {
        String href;
        if ((href = this.href) == null) {
            href = "";
        }
        return href;
    }
    
    public List<Propstat> getPropstat() {
        if (this.propstats == null) {
            this.propstats = (List<Propstat>)new ArrayList();
        }
        return this.propstats;
    }
    
    public String getResponsedescription() {
        return this.responsedescription;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
}
