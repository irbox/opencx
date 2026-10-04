package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.MessageRuleActions;
import com.microsoft.graph.extensions.MessageRulePredicates;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseMessageRule extends Entity implements d
{
    @a
    @c("displayName")
    public String f;
    @a
    @c("sequence")
    public Integer g;
    @a
    @c("conditions")
    public MessageRulePredicates h;
    @a
    @c("actions")
    public MessageRuleActions i;
    @a
    @c("exceptions")
    public MessageRulePredicates j;
    @a
    @c("isEnabled")
    public Boolean k;
    @a
    @c("hasError")
    public Boolean l;
    @a
    @c("isReadOnly")
    public Boolean m;
    private transient l n;
    private transient e o;
    
    public void d(final e o, final l n) {
        this.o = o;
        this.n = n;
    }
}
