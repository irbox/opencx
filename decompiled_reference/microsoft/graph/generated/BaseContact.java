package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.m0;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedProperty;
import ax.N9.A0;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedProperty;
import ax.N9.d0;
import java.util.Arrays;
import com.microsoft.graph.extensions.Extension;
import com.microsoft.graph.extensions.EmailAddress;
import java.util.Calendar;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.ProfilePhoto;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.ExtensionCollectionPage;
import com.microsoft.graph.extensions.PhysicalAddress;
import ax.s8.c;
import ax.s8.a;
import java.util.List;
import ax.T9.d;
import com.microsoft.graph.extensions.OutlookItem;

public class BaseContact extends OutlookItem implements d
{
    @a
    @c("imAddresses")
    public List<String> A;
    @a
    @c("jobTitle")
    public String B;
    @a
    @c("companyName")
    public String C;
    @a
    @c("department")
    public String D;
    @a
    @c("officeLocation")
    public String E;
    @a
    @c("profession")
    public String F;
    @a
    @c("businessHomePage")
    public String G;
    @a
    @c("assistantName")
    public String H;
    @a
    @c("manager")
    public String I;
    @a
    @c("homePhones")
    public List<String> J;
    @a
    @c("mobilePhone")
    public String K;
    @a
    @c("businessPhones")
    public List<String> L;
    @a
    @c("homeAddress")
    public PhysicalAddress M;
    @a
    @c("businessAddress")
    public PhysicalAddress N;
    @a
    @c("otherAddress")
    public PhysicalAddress O;
    @a
    @c("spouseName")
    public String P;
    @a
    @c("personalNotes")
    public String Q;
    @a
    @c("children")
    public List<String> R;
    public transient ExtensionCollectionPage S;
    public transient SingleValueLegacyExtendedPropertyCollectionPage T;
    public transient MultiValueLegacyExtendedPropertyCollectionPage U;
    @a
    @c("photo")
    public ProfilePhoto V;
    private transient l W;
    private transient e X;
    @a
    @c("parentFolderId")
    public String l;
    @a
    @c("birthday")
    public Calendar m;
    @a
    @c("fileAs")
    public String n;
    @a
    @c("displayName")
    public String o;
    @a
    @c("givenName")
    public String p;
    @a
    @c("initials")
    public String q;
    @a
    @c("middleName")
    public String r;
    @a
    @c("nickName")
    public String s;
    @a
    @c("surname")
    public String t;
    @a
    @c("title")
    public String u;
    @a
    @c("yomiGivenName")
    public String v;
    @a
    @c("yomiSurname")
    public String w;
    @a
    @c("yomiCompanyName")
    public String x;
    @a
    @c("generation")
    public String y;
    @a
    @c("emailAddresses")
    public List<EmailAddress> z;
    
    public void d(final e x, final l w) {
        this.X = x;
        this.W = w;
        final boolean x2 = w.x("extensions");
        final int n = 0;
        if (x2) {
            final BaseExtensionCollectionResponse baseExtensionCollectionResponse = new BaseExtensionCollectionResponse();
            if (w.x("extensions@odata.nextLink")) {
                baseExtensionCollectionResponse.b = w.t("extensions@odata.nextLink").k();
            }
            final l[] array = (l[])x.b(w.t("extensions").toString(), (Class)l[].class);
            final Extension[] array2 = new Extension[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (Extension)x.b(((i)array[i]).toString(), (Class)Extension.class)).d(x, array[i]);
            }
            baseExtensionCollectionResponse.a = Arrays.asList((Object[])array2);
            this.S = new ExtensionCollectionPage(baseExtensionCollectionResponse, null);
        }
        if (w.x("singleValueExtendedProperties")) {
            final BaseSingleValueLegacyExtendedPropertyCollectionResponse baseSingleValueLegacyExtendedPropertyCollectionResponse = new BaseSingleValueLegacyExtendedPropertyCollectionResponse();
            if (w.x("singleValueExtendedProperties@odata.nextLink")) {
                baseSingleValueLegacyExtendedPropertyCollectionResponse.b = w.t("singleValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array3 = (l[])x.b(w.t("singleValueExtendedProperties").toString(), (Class)l[].class);
            final SingleValueLegacyExtendedProperty[] array4 = new SingleValueLegacyExtendedProperty[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                ((BaseSingleValueLegacyExtendedProperty)(array4[j] = (SingleValueLegacyExtendedProperty)x.b(((i)array3[j]).toString(), (Class)SingleValueLegacyExtendedProperty.class))).d(x, array3[j]);
            }
            baseSingleValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array4);
            this.T = new SingleValueLegacyExtendedPropertyCollectionPage(baseSingleValueLegacyExtendedPropertyCollectionResponse, (A0)null);
        }
        if (w.x("multiValueExtendedProperties")) {
            final BaseMultiValueLegacyExtendedPropertyCollectionResponse baseMultiValueLegacyExtendedPropertyCollectionResponse = new BaseMultiValueLegacyExtendedPropertyCollectionResponse();
            if (w.x("multiValueExtendedProperties@odata.nextLink")) {
                baseMultiValueLegacyExtendedPropertyCollectionResponse.b = w.t("multiValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array5 = (l[])x.b(w.t("multiValueExtendedProperties").toString(), (Class)l[].class);
            final MultiValueLegacyExtendedProperty[] array6 = new MultiValueLegacyExtendedProperty[array5.length];
            for (int k = n; k < array5.length; ++k) {
                (array6[k] = (MultiValueLegacyExtendedProperty)x.b(((i)array5[k]).toString(), (Class)MultiValueLegacyExtendedProperty.class)).d(x, array5[k]);
            }
            baseMultiValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array6);
            this.U = new MultiValueLegacyExtendedPropertyCollectionPage(baseMultiValueLegacyExtendedPropertyCollectionResponse, null);
        }
    }
}
