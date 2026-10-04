package com.socialnmobile.commons.inapppurchase.billing.datatypes;

import androidx.annotation.Keep;

@Keep
public class LicenseAPIError
{
    public int code;
    public String message;
    
    @Override
    public String toString() {
        return String.format("LicenseAPIError(code=%s message=%s)", new Object[] { this.code, this.message });
    }
}
