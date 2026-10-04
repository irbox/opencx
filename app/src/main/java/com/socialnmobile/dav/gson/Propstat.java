package com.socialnmobile.dav.gson;

import androidx.annotation.Keep;

@Keep
public class Propstat
{
    private Object error;
    private Prop prop;
    private String responsedescription;
    private String status;
    
    public Object getError() {
        return this.error;
    }
    
    public Prop getProp() {
        return this.prop;
    }
    
    public String getResponsedescription() {
        return this.responsedescription;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setProp(final Prop prop) {
        this.prop = prop;
    }
    
    public void setResponsedescription(final String responsedescription) {
        this.responsedescription = responsedescription;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
}
