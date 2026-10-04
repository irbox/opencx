package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.m0;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedProperty;
import ax.N9.A0;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedProperty;
import ax.N9.I;
import com.microsoft.graph.extensions.ContactFolder;
import ax.N9.H;
import java.util.Arrays;
import com.microsoft.graph.extensions.Contact;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.ContactFolderCollectionPage;
import com.microsoft.graph.extensions.ContactCollectionPage;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseContactFolder extends Entity implements d
{
    @a
    @c("parentFolderId")
    public String f;
    @a
    @c("displayName")
    public String g;
    public transient ContactCollectionPage h;
    public transient ContactFolderCollectionPage i;
    public transient SingleValueLegacyExtendedPropertyCollectionPage j;
    public transient MultiValueLegacyExtendedPropertyCollectionPage k;
    private transient l l;
    private transient e m;
    
    public void d(final e m, final l l) {
        this.m = m;
        this.l = l;
        final boolean x = l.x("contacts");
        final int n = 0;
        if (x) {
            final BaseContactCollectionResponse baseContactCollectionResponse = new BaseContactCollectionResponse();
            if (l.x("contacts@odata.nextLink")) {
                baseContactCollectionResponse.b = l.t("contacts@odata.nextLink").k();
            }
            final l[] array = (l[])m.b(l.t("contacts").toString(), (Class)l[].class);
            final Contact[] array2 = new Contact[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (Contact)m.b(((i)array[i]).toString(), (Class)Contact.class)).d(m, array[i]);
            }
            baseContactCollectionResponse.a = Arrays.asList((Object[])array2);
            this.h = new ContactCollectionPage(baseContactCollectionResponse, null);
        }
        if (l.x("childFolders")) {
            final BaseContactFolderCollectionResponse baseContactFolderCollectionResponse = new BaseContactFolderCollectionResponse();
            if (l.x("childFolders@odata.nextLink")) {
                baseContactFolderCollectionResponse.b = l.t("childFolders@odata.nextLink").k();
            }
            final l[] array3 = (l[])m.b(l.t("childFolders").toString(), (Class)l[].class);
            final ContactFolder[] array4 = new ContactFolder[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                (array4[j] = (ContactFolder)m.b(((i)array3[j]).toString(), (Class)ContactFolder.class)).d(m, array3[j]);
            }
            baseContactFolderCollectionResponse.a = Arrays.asList((Object[])array4);
            this.i = new ContactFolderCollectionPage(baseContactFolderCollectionResponse, null);
        }
        if (l.x("singleValueExtendedProperties")) {
            final BaseSingleValueLegacyExtendedPropertyCollectionResponse baseSingleValueLegacyExtendedPropertyCollectionResponse = new BaseSingleValueLegacyExtendedPropertyCollectionResponse();
            if (l.x("singleValueExtendedProperties@odata.nextLink")) {
                baseSingleValueLegacyExtendedPropertyCollectionResponse.b = l.t("singleValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array5 = (l[])m.b(l.t("singleValueExtendedProperties").toString(), (Class)l[].class);
            final SingleValueLegacyExtendedProperty[] array6 = new SingleValueLegacyExtendedProperty[array5.length];
            for (int k = 0; k < array5.length; ++k) {
                ((BaseSingleValueLegacyExtendedProperty)(array6[k] = (SingleValueLegacyExtendedProperty)m.b(((i)array5[k]).toString(), (Class)SingleValueLegacyExtendedProperty.class))).d(m, array5[k]);
            }
            baseSingleValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array6);
            this.j = new SingleValueLegacyExtendedPropertyCollectionPage(baseSingleValueLegacyExtendedPropertyCollectionResponse, (A0)null);
        }
        if (l.x("multiValueExtendedProperties")) {
            final BaseMultiValueLegacyExtendedPropertyCollectionResponse baseMultiValueLegacyExtendedPropertyCollectionResponse = new BaseMultiValueLegacyExtendedPropertyCollectionResponse();
            if (l.x("multiValueExtendedProperties@odata.nextLink")) {
                baseMultiValueLegacyExtendedPropertyCollectionResponse.b = l.t("multiValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array7 = (l[])m.b(l.t("multiValueExtendedProperties").toString(), (Class)l[].class);
            final MultiValueLegacyExtendedProperty[] array8 = new MultiValueLegacyExtendedProperty[array7.length];
            for (int n2 = n; n2 < array7.length; ++n2) {
                (array8[n2] = (MultiValueLegacyExtendedProperty)m.b(((i)array7[n2]).toString(), (Class)MultiValueLegacyExtendedProperty.class)).d(m, array7[n2]);
            }
            baseMultiValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array8);
            this.k = new MultiValueLegacyExtendedPropertyCollectionPage(baseMultiValueLegacyExtendedPropertyCollectionResponse, null);
        }
    }
}
