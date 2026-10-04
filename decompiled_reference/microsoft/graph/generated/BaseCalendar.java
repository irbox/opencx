package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.m0;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedProperty;
import ax.N9.A0;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedProperty;
import ax.N9.c0;
import java.util.Arrays;
import com.microsoft.graph.extensions.Event;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.MultiValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.SingleValueLegacyExtendedPropertyCollectionPage;
import com.microsoft.graph.extensions.EventCollectionPage;
import com.microsoft.graph.extensions.EmailAddress;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseCalendar extends Entity implements d
{
    @a
    @c("name")
    public String f;
    @a
    @c("color")
    public ax.N9.c g;
    @a
    @c("changeKey")
    public String h;
    @a
    @c("canShare")
    public Boolean i;
    @a
    @c("canViewPrivateItems")
    public Boolean j;
    @a
    @c("canEdit")
    public Boolean k;
    @a
    @c("owner")
    public EmailAddress l;
    public transient EventCollectionPage m;
    public transient EventCollectionPage n;
    public transient SingleValueLegacyExtendedPropertyCollectionPage o;
    public transient MultiValueLegacyExtendedPropertyCollectionPage p;
    private transient l q;
    private transient e r;
    
    public void d(final e r, final l q) {
        this.r = r;
        this.q = q;
        final boolean x = q.x("events");
        final int n = 0;
        if (x) {
            final BaseEventCollectionResponse baseEventCollectionResponse = new BaseEventCollectionResponse();
            if (q.x("events@odata.nextLink")) {
                baseEventCollectionResponse.b = q.t("events@odata.nextLink").k();
            }
            final l[] array = (l[])r.b(q.t("events").toString(), (Class)l[].class);
            final Event[] array2 = new Event[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (Event)r.b(((i)array[i]).toString(), (Class)Event.class)).d(r, array[i]);
            }
            baseEventCollectionResponse.a = Arrays.asList((Object[])array2);
            this.m = new EventCollectionPage(baseEventCollectionResponse, null);
        }
        if (q.x("calendarView")) {
            final BaseEventCollectionResponse baseEventCollectionResponse2 = new BaseEventCollectionResponse();
            if (q.x("calendarView@odata.nextLink")) {
                baseEventCollectionResponse2.b = q.t("calendarView@odata.nextLink").k();
            }
            final l[] array3 = (l[])r.b(q.t("calendarView").toString(), (Class)l[].class);
            final Event[] array4 = new Event[array3.length];
            for (int j = 0; j < array3.length; ++j) {
                (array4[j] = (Event)r.b(((i)array3[j]).toString(), (Class)Event.class)).d(r, array3[j]);
            }
            baseEventCollectionResponse2.a = Arrays.asList((Object[])array4);
            this.n = new EventCollectionPage(baseEventCollectionResponse2, null);
        }
        if (q.x("singleValueExtendedProperties")) {
            final BaseSingleValueLegacyExtendedPropertyCollectionResponse baseSingleValueLegacyExtendedPropertyCollectionResponse = new BaseSingleValueLegacyExtendedPropertyCollectionResponse();
            if (q.x("singleValueExtendedProperties@odata.nextLink")) {
                baseSingleValueLegacyExtendedPropertyCollectionResponse.b = q.t("singleValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array5 = (l[])r.b(q.t("singleValueExtendedProperties").toString(), (Class)l[].class);
            final SingleValueLegacyExtendedProperty[] array6 = new SingleValueLegacyExtendedProperty[array5.length];
            for (int k = 0; k < array5.length; ++k) {
                ((BaseSingleValueLegacyExtendedProperty)(array6[k] = (SingleValueLegacyExtendedProperty)r.b(((i)array5[k]).toString(), (Class)SingleValueLegacyExtendedProperty.class))).d(r, array5[k]);
            }
            baseSingleValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array6);
            this.o = new SingleValueLegacyExtendedPropertyCollectionPage(baseSingleValueLegacyExtendedPropertyCollectionResponse, (A0)null);
        }
        if (q.x("multiValueExtendedProperties")) {
            final BaseMultiValueLegacyExtendedPropertyCollectionResponse baseMultiValueLegacyExtendedPropertyCollectionResponse = new BaseMultiValueLegacyExtendedPropertyCollectionResponse();
            if (q.x("multiValueExtendedProperties@odata.nextLink")) {
                baseMultiValueLegacyExtendedPropertyCollectionResponse.b = q.t("multiValueExtendedProperties@odata.nextLink").k();
            }
            final l[] array7 = (l[])r.b(q.t("multiValueExtendedProperties").toString(), (Class)l[].class);
            final MultiValueLegacyExtendedProperty[] array8 = new MultiValueLegacyExtendedProperty[array7.length];
            for (int l = n; l < array7.length; ++l) {
                (array8[l] = (MultiValueLegacyExtendedProperty)r.b(((i)array7[l]).toString(), (Class)MultiValueLegacyExtendedProperty.class)).d(r, array7[l]);
            }
            baseMultiValueLegacyExtendedPropertyCollectionResponse.a = Arrays.asList((Object[])array8);
            this.p = new MultiValueLegacyExtendedPropertyCollectionPage(baseMultiValueLegacyExtendedPropertyCollectionResponse, null);
        }
    }
}
