package com.alphainventor.filemanager.license.datatypes;

import ax.Da.b;
import ax.s8.c;
import ax.e3.a;
import androidx.annotation.Keep;
import java.io.Serializable;
import ax.Fa.d;

@Keep
public class ProductCatalogImpl implements d, Serializable
{
    public static String CATEGORY_PREMIUM_BASIC = "premium_basic";
    private static a sProductIdParser;
    @c("premium_basic")
    private ProductCategoryPremiumBasic premiumBasic;
    
    static {
        ProductCatalogImpl.sProductIdParser = new a("com.cxinventor.file.explorer");
    }
    
    public static String getProductCategoryStatic(String s) throws ax.Ea.a {
        s = (String)ProductCatalogImpl.sProductIdParser.b(s).get((Object)"category");
        if (s != null) {
            return s;
        }
        throw new ax.Ea.a("category is null");
    }
    
    public static ax.Da.c getProductTypeStatic(final String s) {
        if (s.contains((CharSequence)".onetime")) {
            return ax.Da.c.c0;
        }
        return ax.Da.c.d0;
    }
    
    public static String getProductVariationStatic(String s) throws ax.Ea.a {
        s = (String)ProductCatalogImpl.sProductIdParser.b(s).get((Object)"variation");
        if (s != null) {
            return s;
        }
        throw new ax.Ea.a("variation is null");
    }
    
    public b getPremiumBasicOnetime() {
        final ProductCategoryPremiumBasic premiumBasic = this.premiumBasic;
        if (premiumBasic == null) {
            return null;
        }
        final String onetime = premiumBasic.onetime;
        if (onetime == null) {
            return null;
        }
        return new b(ax.Da.c.c0, ProductCatalogImpl.sProductIdParser.a(ProductCatalogImpl.CATEGORY_PREMIUM_BASIC, "onetime", onetime));
    }
    
    public b getPremiumBasicOnetimeDiscount() {
        final ProductCategoryPremiumBasic premiumBasic = this.premiumBasic;
        if (premiumBasic == null) {
            return null;
        }
        final String onetime_dc = premiumBasic.onetime_dc;
        if (onetime_dc == null) {
            return null;
        }
        return new b(ax.Da.c.c0, ProductCatalogImpl.sProductIdParser.a(ProductCatalogImpl.CATEGORY_PREMIUM_BASIC, "onetime_dc", onetime_dc));
    }
    
    public b getPremiumBasicYearly() {
        final ProductCategoryPremiumBasic premiumBasic = this.premiumBasic;
        if (premiumBasic == null) {
            return null;
        }
        final String yearly = premiumBasic.yearly;
        if (yearly == null) {
            return null;
        }
        return new b(ax.Da.c.d0, ProductCatalogImpl.sProductIdParser.a(ProductCatalogImpl.CATEGORY_PREMIUM_BASIC, "yearly", yearly));
    }
    
    public b getPremiumBasicYearlyDiscount() {
        final ProductCategoryPremiumBasic premiumBasic = this.premiumBasic;
        if (premiumBasic == null) {
            return null;
        }
        final String yearly_dc = premiumBasic.yearly_dc;
        if (yearly_dc == null) {
            return null;
        }
        return new b(ax.Da.c.d0, ProductCatalogImpl.sProductIdParser.a(ProductCatalogImpl.CATEGORY_PREMIUM_BASIC, "yearly_dc", yearly_dc));
    }
    
    public String getProductCategory(final b b) throws ax.Ea.b {
        try {
            return getProductCategoryStatic(b.c0);
        }
        catch (final ax.Ea.a a) {
            throw new ax.Ea.b((Throwable)a);
        }
    }
    
    public String getProductVariation(final b b) throws ax.Ea.b {
        try {
            return getProductVariationStatic(b.c0);
        }
        catch (final ax.Ea.a a) {
            throw new ax.Ea.b((Throwable)a);
        }
    }
    
    @Override
    public String toString() {
        return String.format("ProductCatalogImpl(premiumBasic=%s)", new Object[] { this.premiumBasic });
    }
}
