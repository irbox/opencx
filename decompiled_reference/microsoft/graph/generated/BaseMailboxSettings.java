package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.WorkingHours;
import com.microsoft.graph.extensions.LocaleInfo;
import com.microsoft.graph.extensions.AutomaticRepliesSetting;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseMailboxSettings implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("automaticRepliesSetting")
    public AutomaticRepliesSetting c;
    @a
    @c("archiveFolder")
    public String d;
    @a
    @c("timeZone")
    public String e;
    @a
    @c("language")
    public LocaleInfo f;
    @a
    @c("workingHours")
    public WorkingHours g;
    private transient l h;
    private transient e i;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e i, final l h) {
        this.i = i;
        this.h = h;
    }
}
