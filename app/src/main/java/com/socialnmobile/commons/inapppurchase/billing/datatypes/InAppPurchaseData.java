package com.socialnmobile.commons.inapppurchase.billing.datatypes;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class InAppPurchaseData implements Serializable
{
    public static final int PURCHASE_STATE_CANCELED = 1;
    public static final int PURCHASE_STATE_PURCHASED = 0;
    public static final int PURCHASE_STATE_REFUNDED = 2;
    public boolean autoRenewing;
    public String developerPayload;
    public String orderId;
    public String packageName;
    public String productId;
    public int purchaseState;
    public long purchaseTime;
    public String purchaseToken;
    
    @Override
    public String toString() {
        return String.format("InAppPurchaseData(autoRenewing=%s orderId=%s packageName=%s productId=%s purchaseTime=%s purchaseState=%s developerPayload=%s purchaseToken=%s)", new Object[] { this.autoRenewing, this.orderId, this.packageName, this.productId, this.purchaseTime, this.purchaseState, this.developerPayload, this.purchaseToken });
    }
}
