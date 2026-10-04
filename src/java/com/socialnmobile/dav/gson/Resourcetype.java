package com.socialnmobile.dav.gson;

import androidx.annotation.Keep;

@Keep
public class Resourcetype
{
    private Object collection;
    private Object principal;
    
    public Object getCollection() {
        return this.collection;
    }
    
    public Object getPrincipal() {
        return this.principal;
    }
    
    public void setCollection(final Object collection) {
        this.collection = collection;
    }
    
    public void setPrincipal(final Object principal) {
        this.principal = principal;
    }
}
