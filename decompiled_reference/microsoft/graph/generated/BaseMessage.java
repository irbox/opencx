package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.m0;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedProperty;
import ax.N9.A0;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedProperty;
import ax.N9.d0;
import com.microsoft.graph.extensions.Extension;
import ax.N9.C;
import java.util.Arrays;
import com.microsoft.graph.extensions.Attachment;
import ax.N9.O0;
import java.util.Calendar;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.ExtensionCollectionPage;
import com.microsoft.graph.extensions.AttachmentCollectionPage;
import com.microsoft.graph.extensions.FollowupFlag;
import ax.N9.P0;
import com.microsoft.graph.extensions.ItemBody;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.Recipient;
import java.util.List;
import ax.T9.d;
import com.microsoft.graph.extensions.OutlookItem;

public class BaseMessage extends OutlookItem implements d
{
    @a
    @c("replyTo")
    public List<Recipient> A;
    @a
    @c("conversationId")
    public String B;
    @a
    @c("uniqueBody")
    public ItemBody C;
    @a
    @c("isDeliveryReceiptRequested")
    public Boolean D;
    @a
    @c("isReadReceiptRequested")
    public Boolean E;
    @a
    @c("isRead")
    public Boolean F;
    @a
    @c("isDraft")
    public Boolean G;
    @a
    @c("webLink")
    public String H;
    @a
    @c("inferenceClassification")
    public P0 I;
    @a
    @c("flag")
    public FollowupFlag J;
    public transient AttachmentCollectionPage K;
    public transient ExtensionCollectionPage L;
    public transient SingleValueLegacyExtendedPropertyCollectionPage M;
    public transient MultiValueLegacyExtendedPropertyCollectionPage N;
    private transient l O;
    private transient e P;
    @a
    @c("receivedDateTime")
    public Calendar l;
    @a
    @c("sentDateTime")
    public Calendar m;
    @a
    @c("hasAttachments")
    public Boolean n;
    @a
    @c("internetMessageId")
    public String o;
    @a
    @c("internetMessageHeaders")
    public List<Object> p;
    @a
    @c("subject")
    public String q;
    @a
    @c("body")
    public ItemBody r;
    @a
    @c("bodyPreview")
    public String s;
    @a
    @c("importance")
    public O0 t;
    @a
    @c("parentFolderId")
    public String u;
    @a
    @c("sender")
    public Recipient v;
    @a
    @c("from")
    public Recipient w;
    @a
    @c("toRecipients")
    public List<Recipient> x;
    @a
    @c("ccRecipients")
    public List<Recipient> y;
    @a
    @c("bccRecipients")
    public List<Recipient> z;
    
    public void d(final e p2, final l o) {
        this.P = p2;
        this.O = o;
        final boolean x = o.x("attachments");
        final int n = 0;
        if (x) {
            final BaseAttachmentCollectionResponse baseAttachmentCollectionResponse = new BaseAttachmentCollectionResponse();
            if (o.x("attachments@odata.nextLink")) {
                baseAttachmentCollectionResponse.b = o.t("attachments@odata.nextLink").k();
            }
            final l[] array = (l[])p2.b(o.t("attachments").toString(), (Class)l[].class);
            final Attachment[] array2 = new Attachment[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (Attachment)p2.b(((i)array[i]).toString(), (Class)Attachment.class)).d(p2, array[i]);
            }
            baseAttachmentCollectionResponse.a = Arrays.asList((Object[])array2);
            this.K = new AttachmentCollectionPage(baseAttachmentCollectionResponse, null);
        }
        if (o.x("extensions")) {
            final BaseExtensionCollectionResponse baseExtensionCollectionResponse = new BaseExtensionCollectionResponse();
            if (o.x("extensions@odata.nextLink")) {
                baseExtensionCollectionResponse.b = o.t("extensions@odata.nextLink").k();
            }
            final l[] array3 = (l[])p2.b(o.t("extensions").toString(), (Class)l[].class);
            final Extension[] array4 = new Extension[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                (array4[j] = (Extension)p2.b(((i)array3[j]).toString(), (Class)Extension.class)).d(p2, array3[j]);
            }
            baseExtensionCollectionResponse.a = Arrays.asList((Object[])array4);
            this.L = new ExtensionCollectionPage(baseExtensionCollectionResponse, null);
        }
        if (o.x("singleValueExtendedProperties")) {
            final BaseSingleValueLegacyExtendedPropertyCollectionResponse baseSingleValueLegacyExtendedPropertyCollectionResponse = new BaseSingleValueLegacyExtendedPropertyCollectionResponse();
            if (o.x("singleValueExtendedProperties@odata.nextLink")) {
                baseSingleValueLegacyExtendedPropertyCollectionResponse.b = o.t("singleValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array5 = (l[])p2.b(o.t("singleValueExtendedProperties").toString(), (Class)l[].class);
            final SingleValueLegacyExtendedProperty[] array6 = new SingleValueLegacyExtendedProperty[array5.length];
            for (int k = 0; k < array5.length; ++k) {
                ((BaseSingleValueLegacyExtendedProperty)(array6[k] = (SingleValueLegacyExtendedProperty)p2.b(((i)array5[k]).toString(), (Class)SingleValueLegacyExtendedProperty.class))).d(p2, array5[k]);
            }
            baseSingleValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array6);
            this.M = new SingleValueLegacyExtendedPropertyCollectionPage(baseSingleValueLegacyExtendedPropertyCollectionResponse, (A0)null);
        }
        if (o.x("multiValueExtendedProperties")) {
            final BaseMultiValueLegacyExtendedPropertyCollectionResponse baseMultiValueLegacyExtendedPropertyCollectionResponse = new BaseMultiValueLegacyExtendedPropertyCollectionResponse();
            if (o.x("multiValueExtendedProperties@odata.nextLink")) {
                baseMultiValueLegacyExtendedPropertyCollectionResponse.b = o.t("multiValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array7 = (l[])p2.b(o.t("multiValueExtendedProperties").toString(), (Class)l[].class);
            final MultiValueLegacyExtendedProperty[] array8 = new MultiValueLegacyExtendedProperty[array7.length];
            for (int l = n; l < array7.length; ++l) {
                (array8[l] = (MultiValueLegacyExtendedProperty)p2.b(((i)array7[l]).toString(), (Class)MultiValueLegacyExtendedProperty.class)).d(p2, array7[l]);
            }
            baseMultiValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array8);
            this.N = new MultiValueLegacyExtendedPropertyCollectionPage(baseMultiValueLegacyExtendedPropertyCollectionResponse, null);
        }
    }
}
