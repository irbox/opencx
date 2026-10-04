package com.microsoft.graph.generated;

import java.util.List;
import ax.N9.B;
import java.util.Arrays;
import com.microsoft.graph.extensions.ActivityHistoryItem;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.ActivityHistoryItemCollectionPage;
import ax.N9.a1;
import ax.r8.i;
import java.util.Calendar;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.VisualInfo;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseUserActivity extends Entity implements d
{
    @a
    @c("visualElements")
    public VisualInfo f;
    @a
    @c("activitySourceHost")
    public String g;
    @a
    @c("activationUrl")
    public String h;
    @a
    @c("appActivityId")
    public String i;
    @a
    @c("appDisplayName")
    public String j;
    @a
    @c("contentUrl")
    public String k;
    @a
    @c("createdDateTime")
    public Calendar l;
    @a
    @c("expirationDateTime")
    public Calendar m;
    @a
    @c("fallbackUrl")
    public String n;
    @a
    @c("lastModifiedDateTime")
    public Calendar o;
    @a
    @c("userTimezone")
    public String p;
    @a
    @c("contentInfo")
    public i q;
    @a
    @c("status")
    public a1 r;
    public transient ActivityHistoryItemCollectionPage s;
    private transient l t;
    private transient e u;
    
    public void d(final e u, final l t) {
        this.u = u;
        this.t = t;
        if (t.x("historyItems")) {
            final BaseActivityHistoryItemCollectionResponse baseActivityHistoryItemCollectionResponse = new BaseActivityHistoryItemCollectionResponse();
            if (t.x("historyItems@odata.nextLink")) {
                baseActivityHistoryItemCollectionResponse.b = t.t("historyItems@odata.nextLink").k();
            }
            final l[] array = (l[])u.b(t.t("historyItems").toString(), (Class)l[].class);
            final ActivityHistoryItem[] array2 = new ActivityHistoryItem[array.length];
            for (int i = 0; i < array.length; ++i) {
                ((BaseActivityHistoryItem)(array2[i] = (ActivityHistoryItem)u.b(((i)array[i]).toString(), (Class)ActivityHistoryItem.class))).d(u, array[i]);
            }
            baseActivityHistoryItemCollectionResponse.a = (List<ActivityHistoryItem>)Arrays.asList((Object[])array2);
            this.s = new ActivityHistoryItemCollectionPage(baseActivityHistoryItemCollectionResponse, (B)null);
        }
    }
}
