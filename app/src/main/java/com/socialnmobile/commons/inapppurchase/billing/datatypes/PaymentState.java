package com.socialnmobile.commons.inapppurchase.billing.datatypes;

import ax.Ea.b;
import androidx.annotation.Keep;

@Keep
public enum PaymentState
{
    private static final PaymentState[] $VALUES;
    
    FREE_TRIAL(2), 
    PAYMENT_PENDING(0), 
    PAYMENT_RECEIVED(1);
    
    public final int code;
    
    private static /* synthetic */ PaymentState[] $values() {
        return new PaymentState[] { PaymentState.PAYMENT_PENDING, PaymentState.PAYMENT_RECEIVED, PaymentState.FREE_TRIAL };
    }
    
    static {
        $VALUES = $values();
    }
    
    private PaymentState(final int code) {
        this.code = code;
    }
    
    public static PaymentState fromCode(final int n) throws b {
        for (final PaymentState paymentState : values()) {
            if (paymentState.code == n) {
                return paymentState;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("PaymentState: unknown code ");
        sb.append(n);
        throw new b(sb.toString());
    }
}
