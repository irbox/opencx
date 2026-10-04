package com.microsoft.graph.generated;

import com.microsoft.graph.extensions.Recipient;
import ax.N9.Z0;
import ax.N9.O0;
import ax.N9.S0;
import java.util.List;
import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.SizeRange;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseMessageRulePredicates implements d
{
    @a
    @c("isNonDeliveryReport")
    public Boolean A;
    @a
    @c("isPermissionControlled")
    public Boolean B;
    @a
    @c("isReadReceipt")
    public Boolean C;
    @a
    @c("isSigned")
    public Boolean D;
    @a
    @c("isVoicemail")
    public Boolean E;
    @a
    @c("withinSizeRange")
    public SizeRange F;
    private transient l G;
    private transient e H;
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("categories")
    public List<String> c;
    @a
    @c("subjectContains")
    public List<String> d;
    @a
    @c("bodyContains")
    public List<String> e;
    @a
    @c("bodyOrSubjectContains")
    public List<String> f;
    @a
    @c("senderContains")
    public List<String> g;
    @a
    @c("recipientContains")
    public List<String> h;
    @a
    @c("headerContains")
    public List<String> i;
    @a
    @c("messageActionFlag")
    public S0 j;
    @a
    @c("importance")
    public O0 k;
    @a
    @c("sensitivity")
    public Z0 l;
    @a
    @c("fromAddresses")
    public List<Recipient> m;
    @a
    @c("sentToAddresses")
    public List<Recipient> n;
    @a
    @c("sentToMe")
    public Boolean o;
    @a
    @c("sentOnlyToMe")
    public Boolean p;
    @a
    @c("sentCcMe")
    public Boolean q;
    @a
    @c("sentToOrCcMe")
    public Boolean r;
    @a
    @c("notSentToMe")
    public Boolean s;
    @a
    @c("hasAttachments")
    public Boolean t;
    @a
    @c("isApprovalRequest")
    public Boolean u;
    @a
    @c("isAutomaticForward")
    public Boolean v;
    @a
    @c("isAutomaticReply")
    public Boolean w;
    @a
    @c("isEncrypted")
    public Boolean x;
    @a
    @c("isMeetingRequest")
    public Boolean y;
    @a
    @c("isMeetingResponse")
    public Boolean z;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e h, final l g) {
        this.H = h;
        this.G = g;
    }
}
