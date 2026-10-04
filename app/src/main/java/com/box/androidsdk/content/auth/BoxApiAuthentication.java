package com.box.androidsdk.content.auth;

import java.util.AbstractMap;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.models.BoxMDMData;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.requests.BoxRequest;
import java.util.Locale;
import com.box.androidsdk.content.models.BoxSession;
import ax.E3.a;

class BoxApiAuthentication extends a
{
    BoxApiAuthentication(final BoxSession boxSession) {
        super(boxSession);
        super.b = "https://api.box.com";
    }
    
    protected String b() {
        final BoxSession a = super.a;
        if (a != null && a.r() != null && super.a.r().I() != null) {
            return String.format("https://api.%s", new Object[] { super.a.r().I() });
        }
        return super.b();
    }
    
    BoxCreateAuthRequest c(final String s, final String s2, final String s3) {
        return new BoxCreateAuthRequest(super.a, this.d(), s, s2, s3);
    }
    
    protected String d() {
        return String.format(Locale.ENGLISH, "%s/oauth2/token", new Object[] { this.b() });
    }
    
    BoxRefreshAuthRequest e(final String s, final String s2, final String s3) {
        return new BoxRefreshAuthRequest(super.a, this.d(), s, s2, s3);
    }
    
    static class BoxCreateAuthRequest extends BoxRequest<BoxAuthentication.BoxAuthenticationInfo, BoxCreateAuthRequest>
    {
        private static final long serialVersionUID = 8123965031279971580L;
        
        public BoxCreateAuthRequest(final BoxSession boxSession, final String s, final String s2, final String s3, final String s4) {
            super(BoxAuthentication.BoxAuthenticationInfo.class, s, boxSession);
            super.mRequestMethod = Methods.c0;
            this.A(ContentTypes.c0);
            ((AbstractMap)super.mBodyMap).put((Object)"grant_type", (Object)"authorization_code");
            ((AbstractMap)super.mBodyMap).put((Object)"code", (Object)s2);
            ((AbstractMap)super.mBodyMap).put((Object)"client_id", (Object)s3);
            ((AbstractMap)super.mBodyMap).put((Object)"client_secret", (Object)s4);
            if (boxSession.x() != null) {
                this.E(boxSession.x(), boxSession.y());
            }
            if (boxSession.z() != null) {
                this.F(boxSession.z());
            }
            if (boxSession.C() != null) {
                this.G(boxSession.C());
            }
        }
        
        public BoxCreateAuthRequest E(final String s, final String s2) {
            if (!SdkUtils.l(s)) {
                ((AbstractMap)super.mBodyMap).put((Object)"box_device_id", (Object)s);
            }
            if (!SdkUtils.l(s2)) {
                ((AbstractMap)super.mBodyMap).put((Object)"box_device_name", (Object)s2);
            }
            return this;
        }
        
        public BoxCreateAuthRequest F(final BoxMDMData boxMDMData) {
            if (boxMDMData != null) {
                ((AbstractMap)super.mBodyMap).put((Object)"box_mdm_data", (Object)boxMDMData.A());
            }
            return this;
        }
        
        public BoxCreateAuthRequest G(final long n) {
            ((AbstractMap)super.mBodyMap).put((Object)"box_refresh_token_expires_at", (Object)Long.toString(n));
            return this;
        }
    }
    
    static class BoxRefreshAuthRequest extends BoxRequest<BoxAuthentication.BoxAuthenticationInfo, BoxRefreshAuthRequest>
    {
        private static final long serialVersionUID = 8123965031279971570L;
        
        public BoxRefreshAuthRequest(final BoxSession boxSession, final String s, final String s2, final String s3, final String s4) {
            super(BoxAuthentication.BoxAuthenticationInfo.class, s, boxSession);
            super.mContentType = ContentTypes.c0;
            super.mRequestMethod = Methods.c0;
            ((AbstractMap)super.mBodyMap).put((Object)"grant_type", (Object)"refresh_token");
            ((AbstractMap)super.mBodyMap).put((Object)"refresh_token", (Object)s2);
            ((AbstractMap)super.mBodyMap).put((Object)"client_id", (Object)s3);
            ((AbstractMap)super.mBodyMap).put((Object)"client_secret", (Object)s4);
            if (boxSession.x() != null) {
                this.E(boxSession.x(), boxSession.y());
            }
            if (boxSession.C() != null) {
                this.F(boxSession.C());
            }
        }
        
        public BoxRefreshAuthRequest E(final String s, final String s2) {
            if (!SdkUtils.l(s)) {
                ((AbstractMap)super.mBodyMap).put((Object)"box_device_id", (Object)s);
            }
            if (!SdkUtils.l(s2)) {
                ((AbstractMap)super.mBodyMap).put((Object)"box_device_name", (Object)s2);
            }
            return this;
        }
        
        public BoxRefreshAuthRequest F(final long n) {
            ((AbstractMap)super.mBodyMap).put((Object)"box_refresh_token_expires_at", (Object)Long.toString(n));
            return this;
        }
        
        @Override
        protected void u(final BoxResponse<BoxAuthentication.BoxAuthenticationInfo> boxResponse) throws BoxException {
            super.u(boxResponse);
            if (boxResponse.c()) {
                ((BoxAuthentication.BoxAuthenticationInfo)boxResponse.b()).T(super.mSession.D());
            }
        }
    }
}
