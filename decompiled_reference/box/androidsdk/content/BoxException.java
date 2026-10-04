package com.box.androidsdk.content;

import javax.net.ssl.SSLException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.requests.b;

public class BoxException extends Exception
{
    private static final long serialVersionUID = 1L;
    private b boxHttpResponse;
    private String response;
    private final int responseCode;
    
    public BoxException(final String s) {
        super(s);
        this.responseCode = 0;
        this.boxHttpResponse = null;
        this.response = null;
    }
    
    public BoxException(final String s, final int responseCode, final String response, final Throwable t) {
        super(s, f(t));
        this.responseCode = responseCode;
        this.response = response;
    }
    
    public BoxException(final String s, final b boxHttpResponse) {
        super(s, (Throwable)null);
        this.boxHttpResponse = boxHttpResponse;
        if (boxHttpResponse != null) {
            this.responseCode = boxHttpResponse.f();
        }
        else {
            this.responseCode = 0;
        }
        try {
            this.response = boxHttpResponse.g();
        }
        catch (final Exception ex) {
            this.response = null;
        }
    }
    
    public BoxException(final String s, final Throwable t) {
        super(s, f(t));
        this.responseCode = 0;
        this.response = null;
    }
    
    private static Throwable f(final Throwable t) {
        Throwable cause = t;
        if (t instanceof BoxException) {
            cause = t.getCause();
        }
        return cause;
    }
    
    public BoxError b() {
        try {
            final BoxError boxError = new BoxError();
            boxError.k(this.d());
            return boxError;
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    public ErrorType c() {
        if (((Throwable)this).getCause() instanceof UnknownHostException || ((Throwable)this).getCause() instanceof ConnectException) {
            return ErrorType.p0;
        }
        if (this instanceof CorruptedContentException) {
            return ErrorType.v0;
        }
        final BoxError b = this.b();
        String d;
        if (b != null) {
            d = b.D();
        }
        else {
            d = null;
        }
        return ErrorType.h(d, this.e());
    }
    
    public String d() {
        return this.response;
    }
    
    public int e() {
        return this.responseCode;
    }
    
    public static class CorruptedContentException extends BoxException
    {
        private final String mExpectedSha1;
        private final String mReceivedSha1;
        
        public CorruptedContentException(final String s, final String mExpectedSha1, final String mReceivedSha1) {
            super(s);
            this.mExpectedSha1 = mExpectedSha1;
            this.mReceivedSha1 = mReceivedSha1;
        }
    }
    
    public static class DownloadSSLException extends BoxException
    {
        public DownloadSSLException(final String s, final SSLException ex) {
            super(s, (Throwable)ex);
        }
        
        @Override
        public ErrorType c() {
            if (((Throwable)this).getCause() instanceof SSLException) {
                return ErrorType.p0;
            }
            return super.c();
        }
    }
    
    public enum ErrorType
    {
        c0("invalid_grant", 400), 
        d0("account_deactivated", 400), 
        e0("access_denied", 403), 
        f0("invalid_request", 400), 
        g0("invalid_client", 400), 
        h0("password_reset_required", 400), 
        i0("terms_of_service_required", 400), 
        j0("no_credit_card_trial_ended", 400), 
        k0("temporarily_unavailable", 429), 
        l0("service_blocked", 400), 
        m0("service_blocked", 403), 
        n0("unauthorized_device", 400), 
        o0("grace_period_expired", 403), 
        p0("bad_connection_network_error", 0), 
        q("invalid_grant", 400), 
        q0("access_from_location_blocked", 403), 
        r0("error_access_from_ip_not_allowed", 403), 
        s0("unauthorized", 401), 
        t0("new_owner_not_collaborator", 400), 
        u0("internal_server_error", 500), 
        v0("file corrupted", 0), 
        w0("", 0);
        
        private static final ErrorType[] x0;
        private final int mStatusCode;
        private final String mValue;
        
        static {
            x0 = d();
        }
        
        private ErrorType(final String mValue, final int mStatusCode) {
            this.mValue = mValue;
            this.mStatusCode = mStatusCode;
        }
        
        private static /* synthetic */ ErrorType[] d() {
            return new ErrorType[] { ErrorType.q, ErrorType.c0, ErrorType.d0, ErrorType.e0, ErrorType.f0, ErrorType.g0, ErrorType.h0, ErrorType.i0, ErrorType.j0, ErrorType.k0, ErrorType.l0, ErrorType.m0, ErrorType.n0, ErrorType.o0, ErrorType.p0, ErrorType.q0, ErrorType.r0, ErrorType.s0, ErrorType.t0, ErrorType.u0, ErrorType.v0, ErrorType.w0 };
        }
        
        public static ErrorType h(final String s, final int n) {
            if (n == 500) {
                return ErrorType.u0;
            }
            for (final ErrorType errorType : values()) {
                if (errorType.mStatusCode == n && errorType.mValue.equals((Object)s)) {
                    return errorType;
                }
            }
            return ErrorType.w0;
        }
    }
    
    public static class MaxAttemptsExceeded extends BoxException
    {
        private final int mTimesTried;
        
        public MaxAttemptsExceeded(final String s, final int n) {
            this(s, n, null);
        }
        
        public MaxAttemptsExceeded(final String s, final int mTimesTried, final b b) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(mTimesTried);
            super(sb.toString(), b);
            this.mTimesTried = mTimesTried;
        }
    }
    
    public static class RateLimitAttemptsExceeded extends MaxAttemptsExceeded
    {
        public RateLimitAttemptsExceeded(final String s, final int n, final b b) {
            super(s, n, b);
        }
    }
    
    public static class RefreshFailure extends BoxException
    {
        private static final ErrorType[] q;
        
        static {
            q = new ErrorType[] { ErrorType.c0, ErrorType.q, ErrorType.e0, ErrorType.j0, ErrorType.l0, ErrorType.m0, ErrorType.g0, ErrorType.n0, ErrorType.o0, ErrorType.s0, ErrorType.d0 };
        }
        
        public RefreshFailure(final BoxException ex) {
            super(((Throwable)ex).getMessage(), ex.responseCode, ex.d(), (Throwable)ex);
        }
        
        public boolean g() {
            final ErrorType c = this.c();
            final ErrorType[] q = RefreshFailure.q;
            for (int length = q.length, i = 0; i < length; ++i) {
                if (c == q[i]) {
                    return true;
                }
            }
            return false;
        }
    }
}
