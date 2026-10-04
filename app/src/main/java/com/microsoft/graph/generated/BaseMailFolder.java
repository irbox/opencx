package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.m0;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedProperty;
import ax.N9.A0;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedProperty;
import ax.N9.j0;
import com.microsoft.graph.extensions.MailFolder;
import ax.N9.l0;
import com.microsoft.graph.extensions.MessageRule;
import ax.N9.k0;
import java.util.Arrays;
import com.microsoft.graph.extensions.Message;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.MailFolderCollectionPage;
import com.microsoft.graph.extensions.MessageRuleCollectionPage;
import com.microsoft.graph.extensions.MessageCollectionPage;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseMailFolder extends Entity implements d
{
    @a
    @c("displayName")
    public String f;
    @a
    @c("parentFolderId")
    public String g;
    @a
    @c("childFolderCount")
    public Integer h;
    @a
    @c("unreadItemCount")
    public Integer i;
    @a
    @c("totalItemCount")
    public Integer j;
    public transient MessageCollectionPage k;
    public transient MessageRuleCollectionPage l;
    public transient MailFolderCollectionPage m;
    public transient SingleValueLegacyExtendedPropertyCollectionPage n;
    public transient MultiValueLegacyExtendedPropertyCollectionPage o;
    private transient l p;
    private transient e q;
    
    public void d(final e q, final l p2) {
        this.q = q;
        this.p = p2;
        final boolean x = p2.x("messages");
        final int n = 0;
        if (x) {
            final BaseMessageCollectionResponse baseMessageCollectionResponse = new BaseMessageCollectionResponse();
            if (p2.x("messages@odata.nextLink")) {
                baseMessageCollectionResponse.b = p2.t("messages@odata.nextLink").k();
            }
            final l[] array = (l[])q.b(p2.t("messages").toString(), (Class)l[].class);
            final Message[] array2 = new Message[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (Message)q.b(((i)array[i]).toString(), (Class)Message.class)).d(q, array[i]);
            }
            baseMessageCollectionResponse.a = Arrays.asList((Object[])array2);
            this.k = new MessageCollectionPage(baseMessageCollectionResponse, null);
        }
        if (p2.x("messageRules")) {
            final BaseMessageRuleCollectionResponse baseMessageRuleCollectionResponse = new BaseMessageRuleCollectionResponse();
            if (p2.x("messageRules@odata.nextLink")) {
                baseMessageRuleCollectionResponse.b = p2.t("messageRules@odata.nextLink").k();
            }
            final l[] array3 = (l[])q.b(p2.t("messageRules").toString(), (Class)l[].class);
            final MessageRule[] array4 = new MessageRule[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                (array4[j] = (MessageRule)q.b(((i)array3[j]).toString(), (Class)MessageRule.class)).d(q, array3[j]);
            }
            baseMessageRuleCollectionResponse.a = Arrays.asList((Object[])array4);
            this.l = new MessageRuleCollectionPage(baseMessageRuleCollectionResponse, null);
        }
        if (p2.x("childFolders")) {
            final BaseMailFolderCollectionResponse baseMailFolderCollectionResponse = new BaseMailFolderCollectionResponse();
            if (p2.x("childFolders@odata.nextLink")) {
                baseMailFolderCollectionResponse.b = p2.t("childFolders@odata.nextLink").k();
            }
            final l[] array5 = (l[])q.b(p2.t("childFolders").toString(), (Class)l[].class);
            final MailFolder[] array6 = new MailFolder[array5.length];
            for (int k = 0; k < array5.length; ++k) {
                (array6[k] = (MailFolder)q.b(((i)array5[k]).toString(), (Class)MailFolder.class)).d(q, array5[k]);
            }
            baseMailFolderCollectionResponse.a = Arrays.asList((Object[])array6);
            this.m = new MailFolderCollectionPage(baseMailFolderCollectionResponse, null);
        }
        if (p2.x("singleValueExtendedProperties")) {
            final BaseSingleValueLegacyExtendedPropertyCollectionResponse baseSingleValueLegacyExtendedPropertyCollectionResponse = new BaseSingleValueLegacyExtendedPropertyCollectionResponse();
            if (p2.x("singleValueExtendedProperties@odata.nextLink")) {
                baseSingleValueLegacyExtendedPropertyCollectionResponse.b = p2.t("singleValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array7 = (l[])q.b(p2.t("singleValueExtendedProperties").toString(), (Class)l[].class);
            final SingleValueLegacyExtendedProperty[] array8 = new SingleValueLegacyExtendedProperty[array7.length];
            for (int l = 0; l < array7.length; ++l) {
                ((BaseSingleValueLegacyExtendedProperty)(array8[l] = (SingleValueLegacyExtendedProperty)q.b(((i)array7[l]).toString(), (Class)SingleValueLegacyExtendedProperty.class))).d(q, array7[l]);
            }
            baseSingleValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array8);
            this.n = new SingleValueLegacyExtendedPropertyCollectionPage(baseSingleValueLegacyExtendedPropertyCollectionResponse, (A0)null);
        }
        if (p2.x("multiValueExtendedProperties")) {
            final BaseMultiValueLegacyExtendedPropertyCollectionResponse baseMultiValueLegacyExtendedPropertyCollectionResponse = new BaseMultiValueLegacyExtendedPropertyCollectionResponse();
            if (p2.x("multiValueExtendedProperties@odata.nextLink")) {
                baseMultiValueLegacyExtendedPropertyCollectionResponse.b = p2.t("multiValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array9 = (l[])q.b(p2.t("multiValueExtendedProperties").toString(), (Class)l[].class);
            final MultiValueLegacyExtendedProperty[] array10 = new MultiValueLegacyExtendedProperty[array9.length];
            for (int n2 = n; n2 < array9.length; ++n2) {
                (array10[n2] = (MultiValueLegacyExtendedProperty)q.b(((i)array9[n2]).toString(), (Class)MultiValueLegacyExtendedProperty.class)).d(q, array9[n2]);
            }
            baseMultiValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array10);
            this.o = new MultiValueLegacyExtendedPropertyCollectionPage(baseMultiValueLegacyExtendedPropertyCollectionResponse, null);
        }
    }
}
