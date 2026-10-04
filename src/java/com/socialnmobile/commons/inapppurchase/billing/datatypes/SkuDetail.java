package com.socialnmobile.commons.inapppurchase.billing.datatypes;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class SkuDetail implements Serializable
{
    public String description;
    public String price;
    public long price_amount_micros;
    public String price_currency_code;
    public String productId;
    public String title;
    public String type;
    
    @Override
    public String toString() {
        return String.format("SkuDetail(title=%s description=%s productId=%s type=%s price=%s price_amount_micros=%s price_currency_code=%s)", new Object[] { this.title, this.description, this.productId, this.type, this.price, this.price_amount_micros, this.price_currency_code });
    }
}
