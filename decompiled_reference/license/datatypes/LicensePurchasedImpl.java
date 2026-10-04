package com.alphainventor.filemanager.license.datatypes;

import ax.Ea.b;
import ax.Da.a;
import com.socialnmobile.commons.inapppurchase.billing.datatypes.InAppPurchaseData;
import java.util.Date;
import androidx.annotation.Keep;
import java.io.Serializable;
import ax.Fa.c;

@Keep
public class LicensePurchasedImpl implements c, Serializable
{
    private Integer consumptionStateCode;
    private String deviceId;
    private transient Date expiryTimeDate;
    private long expiryTimeMillis;
    private InAppPurchaseData inAppPurchaseDataVerified;
    private Integer licenseStateCode;
    private Integer paymentStateCode;
    private String productId;
    private Integer purchaseStateCode;
    private Integer purchaseTypeCode;
    
    private String getProductIdPrivate() {
        final String productId = this.productId;
        if (productId != null) {
            return productId;
        }
        throw new IllegalStateException("Unexpected null productId");
    }
    
    public Integer getConsumptionStateCode() {
        return this.consumptionStateCode;
    }
    
    public Date getExpiryTime() {
        if (this.expiryTimeDate == null) {
            this.expiryTimeDate = new Date(this.expiryTimeMillis);
        }
        return this.expiryTimeDate;
    }
    
    public a getLicenseState() {
        final Integer licenseStateCode = this.licenseStateCode;
        if (licenseStateCode != null) {
            try {
                return a.h((int)licenseStateCode);
            }
            catch (final b b) {
                throw new IllegalStateException((Throwable)b);
            }
        }
        throw new IllegalStateException("Unexpected null licenseStateCode");
    }
    
    public String getLicenseeId() {
        final String deviceId = this.deviceId;
        if (deviceId != null) {
            return deviceId;
        }
        throw new IllegalStateException("Unexpected null deviceId");
    }
    
    public Integer getPaymentStateCode() {
        return this.paymentStateCode;
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
    
    public ax.Da.b getProductId() {
        return new ax.Da.b(this.getProductType(), this.getProductIdPrivate());
    }
    
    public ax.Da.c getProductType() {
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
    
    public Integer getPurchaseStateCode() {
        return this.purchaseStateCode;
    }
    
    public Integer getPurchaseTypeCode() {
        return this.purchaseTypeCode;
    }
    
    public InAppPurchaseData getVerifiedPurchaseData() {
        final InAppPurchaseData inAppPurchaseDataVerified = this.inAppPurchaseDataVerified;
        if (inAppPurchaseDataVerified != null) {
            return inAppPurchaseDataVerified;
        }
        throw new IllegalStateException("Unexpected null inAppPurchaseDataVerified");
    }
    
    @Override
    public String toString() {
        return String.format("LicensePurchasedImpl(expiryTimeMillis=%s productId=%s deviceId=%s inAppPurchaseDataVerified=%s licenseStateCode=%s purchaseTypeCode=%s purchaseStateCode=%s paymentStateCode=%s consumptionStateCode=%s)", new Object[] { this.expiryTimeMillis, this.productId, this.deviceId, this.inAppPurchaseDataVerified, this.licenseStateCode, this.purchaseStateCode, this.purchaseTypeCode, this.paymentStateCode, this.consumptionStateCode });
    }
}
