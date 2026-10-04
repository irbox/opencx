package com.alphainventor.filemanager.license.datatypes;

import ax.Da.c;
import ax.Da.b;
import ax.Da.a;
import java.util.Date;
import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class LicenseByCoupon implements Serializable
{
    private String couponCode;
    private String deviceId;
    private transient Date expiryTimeDate;
    private long expiryTimeMillis;
    private String productId;
    
    private String getProductIdPrivate() {
        final String productId = this.productId;
        if (productId != null) {
            return productId;
        }
        throw new IllegalStateException("Unexpected null productId");
    }
    
    public String getCouponCode() {
        final String couponCode = this.couponCode;
        if (couponCode != null) {
            return couponCode;
        }
        throw new IllegalStateException("Unexpected null couponCode");
    }
    
    public Date getExpiryTime() {
        if (this.expiryTimeDate == null) {
            this.expiryTimeDate = new Date(this.expiryTimeMillis);
        }
        return this.expiryTimeDate;
    }
    
    public a getLicenseState() {
        return a.f0;
    }
    
    public String getLicenseeId() {
        final String deviceId = this.deviceId;
        if (deviceId != null) {
            return deviceId;
        }
        throw new IllegalStateException("Unexpected null deviceId");
    }
    
    public String getProductCategory() {
        final String productIdPrivate = this.getProductIdPrivate();
        try {
            return ProductCatalogImpl.getProductCategoryStatic(productIdPrivate);
        }
        catch (final ax.Ea.a a) {
            throw new IllegalStateException((Throwable)a);
        }
    }
    
    public b getProductId() {
        return new b(this.getProductType(), this.getProductIdPrivate());
    }
    
    public c getProductType() {
        return ProductCatalogImpl.getProductTypeStatic(this.getProductIdPrivate());
    }
    
    public String getProductVariation() {
        final String productIdPrivate = this.getProductIdPrivate();
        try {
            return ProductCatalogImpl.getProductVariationStatic(productIdPrivate);
        }
        catch (final ax.Ea.a a) {
            throw new IllegalStateException((Throwable)a);
        }
    }
    
    @Override
    public String toString() {
        return String.format("LicenseByCoupon(productId=%s deviceId=%s expiryTimeMillis=%s couponCode=%s)", new Object[] { this.productId, this.deviceId, this.expiryTimeMillis, this.couponCode });
    }
}
