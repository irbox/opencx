package com.microsoft.graph.generated;

import ax.r8.i;
import ax.N9.D;
import java.util.Arrays;
import com.microsoft.graph.extensions.Calendar;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.CalendarCollectionPage;
import java.util.UUID;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseCalendarGroup extends Entity implements d
{
    @a
    @c("name")
    public String f;
    @a
    @c("classId")
    public UUID g;
    @a
    @c("changeKey")
    public String h;
    public transient CalendarCollectionPage i;
    private transient l j;
    private transient e k;
    
    public void d(final e k, final l j) {
        this.k = k;
        this.j = j;
        if (j.x("calendars")) {
            final BaseCalendarCollectionResponse baseCalendarCollectionResponse = new BaseCalendarCollectionResponse();
            if (j.x("calendars@odata.nextLink")) {
                baseCalendarCollectionResponse.b = j.t("calendars@odata.nextLink").k();
            }
            final l[] array = (l[])k.b(j.t("calendars").toString(), (Class)l[].class);
            final Calendar[] array2 = new Calendar[array.length];
            for (int i = 0; i < array.length; ++i) {
                (array2[i] = (Calendar)k.b(((i)array[i]).toString(), (Class)Calendar.class)).d(k, array[i]);
            }
            baseCalendarCollectionResponse.a = Arrays.asList((Object[])array2);
            this.i = new CalendarCollectionPage(baseCalendarCollectionResponse, null);
        }
    }
}
