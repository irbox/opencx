package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.m0;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedProperty;
import ax.N9.A0;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedProperty;
import ax.N9.C;
import com.microsoft.graph.extensions.Attachment;
import ax.N9.d0;
import com.microsoft.graph.extensions.Extension;
import ax.N9.c0;
import java.util.Arrays;
import com.microsoft.graph.extensions.Event;
import com.microsoft.graph.extensions.DateTimeTimeZone;
import ax.N9.Z0;
import ax.N9.O0;
import com.microsoft.graph.extensions.ItemBody;
import com.microsoft.graph.extensions.ResponseStatus;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.AttachmentCollectionPage;
import com.microsoft.graph.extensions.ExtensionCollectionPage;
import com.microsoft.graph.extensions.EventCollectionPage;
import com.microsoft.graph.extensions.Calendar;
import com.microsoft.graph.extensions.Recipient;
import ax.N9.w;
import ax.N9.z;
import com.microsoft.graph.extensions.PatternedRecurrence;
import java.util.List;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.Location;
import ax.T9.d;
import com.microsoft.graph.extensions.OutlookItem;

public class BaseEvent extends OutlookItem implements d
{
    @a
    @c("location")
    public Location A;
    @a
    @c("locations")
    public List<Location> B;
    @a
    @c("isAllDay")
    public Boolean C;
    @a
    @c("isCancelled")
    public Boolean D;
    @a
    @c("isOrganizer")
    public Boolean E;
    @a
    @c("recurrence")
    public PatternedRecurrence F;
    @a
    @c("responseRequested")
    public Boolean G;
    @a
    @c("seriesMasterId")
    public String H;
    @a
    @c("showAs")
    public z I;
    @a
    @c("type")
    public w J;
    @a
    @c("attendees")
    public List<Object> K;
    @a
    @c("organizer")
    public Recipient L;
    @a
    @c("webLink")
    public String M;
    @a
    @c("onlineMeetingUrl")
    public String N;
    @a
    @c("calendar")
    public Calendar O;
    public transient EventCollectionPage P;
    public transient ExtensionCollectionPage Q;
    public transient AttachmentCollectionPage R;
    public transient SingleValueLegacyExtendedPropertyCollectionPage S;
    public transient MultiValueLegacyExtendedPropertyCollectionPage T;
    private transient l U;
    private transient e V;
    @a
    @c("originalStartTimeZone")
    public String l;
    @a
    @c("originalEndTimeZone")
    public String m;
    @a
    @c("responseStatus")
    public ResponseStatus n;
    @a
    @c("iCalUId")
    public String o;
    @a
    @c("reminderMinutesBeforeStart")
    public Integer p;
    @a
    @c("isReminderOn")
    public Boolean q;
    @a
    @c("hasAttachments")
    public Boolean r;
    @a
    @c("subject")
    public String s;
    @a
    @c("body")
    public ItemBody t;
    @a
    @c("bodyPreview")
    public String u;
    @a
    @c("importance")
    public O0 v;
    @a
    @c("sensitivity")
    public Z0 w;
    @a
    @c("start")
    public DateTimeTimeZone x;
    @a
    @c("originalStart")
    public java.util.Calendar y;
    @a
    @c("end")
    public DateTimeTimeZone z;
    
    public void d(final e v, final l u) {
        this.V = v;
        this.U = u;
        final boolean x = u.x("instances");
        final int n = 0;
        if (x) {
            final BaseEventCollectionResponse baseEventCollectionResponse = new BaseEventCollectionResponse();
            if (u.x("instances@odata.nextLink")) {
                baseEventCollectionResponse.b = u.t("instances@odata.nextLink").k();
            }
            final l[] array = (l[])v.b(u.t("instances").toString(), (Class)l[].class);
            final Event[] array2 = new Event[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (Event)v.b(((i)array[i]).toString(), (Class)Event.class)).d(v, array[i]);
            }
            baseEventCollectionResponse.a = Arrays.asList((Object[])array2);
            this.P = new EventCollectionPage(baseEventCollectionResponse, null);
        }
        if (u.x("extensions")) {
            final BaseExtensionCollectionResponse baseExtensionCollectionResponse = new BaseExtensionCollectionResponse();
            if (u.x("extensions@odata.nextLink")) {
                baseExtensionCollectionResponse.b = u.t("extensions@odata.nextLink").k();
            }
            final l[] array3 = (l[])v.b(u.t("extensions").toString(), (Class)l[].class);
            final Extension[] array4 = new Extension[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                (array4[j] = (Extension)v.b(((i)array3[j]).toString(), (Class)Extension.class)).d(v, array3[j]);
            }
            baseExtensionCollectionResponse.a = Arrays.asList((Object[])array4);
            this.Q = new ExtensionCollectionPage(baseExtensionCollectionResponse, null);
        }
        if (u.x("attachments")) {
            final BaseAttachmentCollectionResponse baseAttachmentCollectionResponse = new BaseAttachmentCollectionResponse();
            if (u.x("attachments@odata.nextLink")) {
                baseAttachmentCollectionResponse.b = u.t("attachments@odata.nextLink").k();
            }
            final l[] array5 = (l[])v.b(u.t("attachments").toString(), (Class)l[].class);
            final Attachment[] array6 = new Attachment[array5.length];
            for (int k = 0; k < array5.length; ++k) {
                (array6[k] = (Attachment)v.b(((i)array5[k]).toString(), (Class)Attachment.class)).d(v, array5[k]);
            }
            baseAttachmentCollectionResponse.a = Arrays.asList((Object[])array6);
            this.R = new AttachmentCollectionPage(baseAttachmentCollectionResponse, null);
        }
        if (u.x("singleValueExtendedProperties")) {
            final BaseSingleValueLegacyExtendedPropertyCollectionResponse baseSingleValueLegacyExtendedPropertyCollectionResponse = new BaseSingleValueLegacyExtendedPropertyCollectionResponse();
            if (u.x("singleValueExtendedProperties@odata.nextLink")) {
                baseSingleValueLegacyExtendedPropertyCollectionResponse.b = u.t("singleValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array7 = (l[])v.b(u.t("singleValueExtendedProperties").toString(), (Class)l[].class);
            final SingleValueLegacyExtendedProperty[] array8 = new SingleValueLegacyExtendedProperty[array7.length];
            for (int l = 0; l < array7.length; ++l) {
                ((BaseSingleValueLegacyExtendedProperty)(array8[l] = (SingleValueLegacyExtendedProperty)v.b(((i)array7[l]).toString(), (Class)SingleValueLegacyExtendedProperty.class))).d(v, array7[l]);
            }
            baseSingleValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array8);
            this.S = new SingleValueLegacyExtendedPropertyCollectionPage(baseSingleValueLegacyExtendedPropertyCollectionResponse, (A0)null);
        }
        if (u.x("multiValueExtendedProperties")) {
            final BaseMultiValueLegacyExtendedPropertyCollectionResponse baseMultiValueLegacyExtendedPropertyCollectionResponse = new BaseMultiValueLegacyExtendedPropertyCollectionResponse();
            if (u.x("multiValueExtendedProperties@odata.nextLink")) {
                baseMultiValueLegacyExtendedPropertyCollectionResponse.b = u.t("multiValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array9 = (l[])v.b(u.t("multiValueExtendedProperties").toString(), (Class)l[].class);
            final MultiValueLegacyExtendedProperty[] array10 = new MultiValueLegacyExtendedProperty[array9.length];
            for (int n2 = n; n2 < array9.length; ++n2) {
                (array10[n2] = (MultiValueLegacyExtendedProperty)v.b(((i)array9[n2]).toString(), (Class)MultiValueLegacyExtendedProperty.class)).d(v, array9[n2]);
            }
            baseMultiValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array10);
            this.T = new MultiValueLegacyExtendedPropertyCollectionPage(baseMultiValueLegacyExtendedPropertyCollectionResponse, null);
        }
    }
}
