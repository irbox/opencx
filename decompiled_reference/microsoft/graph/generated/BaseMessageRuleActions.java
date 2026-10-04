package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.Recipient;
import java.util.List;
import ax.N9.O0;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseMessageRuleActions implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("moveToFolder")
    public String c;
    @a
    @c("copyToFolder")
    public String d;
    @a
    @c("delete")
    public Boolean e;
    @a
    @c("permanentDelete")
    public Boolean f;
    @a
    @c("markAsRead")
    public Boolean g;
    @a
    @c("markImportance")
    public O0 h;
    @a
    @c("forwardTo")
    public List<Recipient> i;
    @a
    @c("forwardAsAttachmentTo")
    public List<Recipient> j;
    @a
    @c("redirectTo")
    public List<Recipient> k;
    @a
    @c("assignCategories")
    public List<String> l;
    @a
    @c("stopProcessingRules")
    public Boolean m;
    private transient l n;
    private transient e o;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e o, final l n) {
        this.o = o;
        this.n = n;
    }
}
