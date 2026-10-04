package com.socialnmobile.dav.gson;

import androidx.annotation.Keep;

@Keep
public class YandexAccountInfo
{
    protected String id;
    protected String login;
    
    public String getAccountName() {
        return this.login;
    }
}
