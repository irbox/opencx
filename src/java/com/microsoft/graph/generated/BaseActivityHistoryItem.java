package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.UserActivity;
import java.util.Calendar;
import ax.s8.c;
import ax.s8.a;
import ax.N9.a1;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseActivityHistoryItem extends Entity implements d
{
    @a
    @c("status")
    public a1 f;
    @a
    @c("activeDurationSeconds")
    public Integer g;
    @a
    @c("createdDateTime")
    public Calendar h;
    @a
    @c("lastActiveDateTime")
    public Calendar i;
    @a
    @c("lastModifiedDateTime")
    public Calendar j;
    @a
    @c("expirationDateTime")
    public Calendar k;
    @a
    @c("startedDateTime")
    public Calendar l;
    @a
    @c("userTimezone")
    public String m;
    @a
    @c("activity")
    public UserActivity n;
    private transient l o;
    private transient e p;
    
    public void d(final e p2, final l o) {
        this.p = p2;
        this.o = o;
    }
}
