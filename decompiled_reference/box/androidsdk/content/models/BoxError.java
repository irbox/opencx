package com.box.androidsdk.content.models;

public class BoxError extends BoxJsonObject
{
    public String C() {
        return this.u("code");
    }
    
    public String D() {
        String s;
        if ((s = this.u("error")) == null) {
            s = this.C();
        }
        return s;
    }
    
    public String E() {
        return this.u("error_description");
    }
}
