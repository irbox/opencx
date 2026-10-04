package com.socialnmobile.commons.inapppurchase.billing.datatypes;

import ax.Fa.a;
import ax.Fa.b;
import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class InAppPurchaseDataSigned implements Serializable
{
    public String item;
    public String purchaseData;
    public String signature;
    
    public InAppPurchaseData getUnverifiedPurchaseData(final b b) throws a {
        return b.a(this.purchaseData);
    }
    
    @Override
    public String toString() {
        return String.format("InAppPurchaseDataSigned(item=%s purchaseData=%s signature=%s)", new Object[] { this.item, this.purchaseData, this.signature });
    }
}
