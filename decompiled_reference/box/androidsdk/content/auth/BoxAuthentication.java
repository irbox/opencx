package com.box.androidsdk.content.auth;

import java.util.concurrent.AbstractExecutorService;
import java.lang.ref.Reference;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.androidsdk.content.requests.BoxRequest;
import java.util.Map$Entry;
import ax.O4.d;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxJsonObject;
import ax.H3.b;
import java.util.LinkedHashSet;
import java.util.Set;
import android.content.Intent;
import com.box.androidsdk.content.requests.BoxResponse;
import ax.E3.h$b;
import ax.E3.h;
import java.util.Iterator;
import java.util.Map;
import ax.E3.g;
import ax.E3.e;
import com.box.androidsdk.content.requests.BoxRequestsUser$GetUserInfo;
import com.box.androidsdk.content.models.BoxUser;
import java.util.concurrent.Callable;
import android.content.Context;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.utils.SdkUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.FutureTask;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class BoxAuthentication
{
    private static final BoxAuthentication e;
    private static final ThreadPoolExecutor f;
    private static final String g;
    public static final String[] h;
    private ConcurrentLinkedQueue<WeakReference<e>> a;
    private ConcurrentHashMap<String, BoxAuthenticationInfo> b;
    private final ConcurrentHashMap<String, FutureTask> c;
    private f d;
    
    static {
        e = new BoxAuthentication();
        f = SdkUtils.f(1, 1, 3600L, TimeUnit.SECONDS);
        g = BoxAuthentication.class.getName();
        h = new String[] { "type", "id", "name", "login", "space_amount", "space_used", "max_upload_size", "status", "enterprise", "created_at" };
    }
    
    private BoxAuthentication() {
        this.a = (ConcurrentLinkedQueue<WeakReference<e>>)new ConcurrentLinkedQueue();
        this.c = (ConcurrentHashMap<String, FutureTask>)new ConcurrentHashMap();
        this.d = new f();
    }
    
    static /* synthetic */ g c(final BoxAuthentication boxAuthentication) {
        boxAuthentication.getClass();
        return null;
    }
    
    private FutureTask<BoxAuthenticationInfo> i(final BoxSession boxSession, final String s) {
        return (FutureTask<BoxAuthenticationInfo>)new FutureTask((Callable)new Callable<BoxAuthenticationInfo>(this, boxSession, s) {
            final BoxSession a;
            final String b;
            final BoxAuthentication c;
            
            public BoxAuthenticationInfo a() throws Exception {
                final BoxApiAuthentication.BoxCreateAuthRequest c = new BoxApiAuthentication(this.a).c(this.b, this.a.u(), this.a.w());
                final BoxAuthenticationInfo boxAuthenticationInfo = new BoxAuthenticationInfo();
                BoxAuthenticationInfo.E(boxAuthenticationInfo, this.a.r());
                final BoxAuthenticationInfo boxAuthenticationInfo2 = ((BoxRequest<BoxAuthenticationInfo, R>)c).x();
                boxAuthenticationInfo.N(boxAuthenticationInfo2.C());
                boxAuthenticationInfo.S(boxAuthenticationInfo2.M());
                boxAuthenticationInfo.Q(boxAuthenticationInfo2.G());
                boxAuthenticationInfo.R(System.currentTimeMillis());
                boxAuthenticationInfo.T(new ax.E3.e(new BoxSession(this.a.q(), boxAuthenticationInfo, (E)null)).d().E(BoxAuthentication.h).x());
                BoxAuthentication.o().u(boxAuthenticationInfo, this.a.q());
                return boxAuthenticationInfo;
            }
        });
    }
    
    private FutureTask<BoxAuthenticationInfo> j(final BoxSession boxSession, final BoxAuthenticationInfo boxAuthenticationInfo) {
        final boolean b = boxAuthenticationInfo.K() == null && boxSession.D() == null;
        String s;
        if (SdkUtils.k(boxSession.G()) && b) {
            s = boxAuthenticationInfo.C();
        }
        else {
            s = boxSession.G();
        }
        String s2;
        if (boxAuthenticationInfo.K() != null) {
            s2 = boxAuthenticationInfo.K().G();
        }
        else {
            s2 = boxSession.G();
        }
        final FutureTask futureTask = new FutureTask((Callable)new Callable<BoxAuthenticationInfo>(this, boxSession, boxAuthenticationInfo, s, s2, b) {
            final BoxSession a;
            final BoxAuthenticationInfo b;
            final String c;
            final String d;
            final boolean e;
            final BoxAuthentication f;
            
            public BoxAuthenticationInfo a() throws Exception {
                this.a.B();
                BoxAuthentication.c(this.f);
                String m;
                if (this.b.M() != null) {
                    m = this.b.M();
                }
                else {
                    m = "";
                }
                String s;
                if (this.a.u() != null) {
                    s = this.a.u();
                }
                else {
                    s = ax.E3.g.c;
                }
                String s2;
                if (this.a.w() != null) {
                    s2 = this.a.w();
                }
                else {
                    s2 = ax.E3.g.d;
                }
                if (!SdkUtils.k(s) && !SdkUtils.k(s2)) {
                    final BoxApiAuthentication.BoxRefreshAuthRequest e = new BoxApiAuthentication(this.a).e(m, s, s2);
                    try {
                        final BoxAuthenticationInfo boxAuthenticationInfo = ((BoxRequest<BoxAuthenticationInfo, R>)e).x();
                        if (boxAuthenticationInfo != null) {
                            boxAuthenticationInfo.R(System.currentTimeMillis());
                        }
                        BoxAuthenticationInfo.E(this.a.r(), boxAuthenticationInfo);
                        if (!this.e) {
                            this.a.B();
                            BoxAuthentication.c(this.f);
                        }
                        else {
                            this.b.T(((BoxRequest<BoxUser, R>)((BoxRequestItem<E, BoxRequestsUser$GetUserInfo>)new ax.E3.e(this.a).d()).E(BoxAuthentication.h)).x());
                        }
                        this.f.m(this.a.q()).put((Object)this.b.K().G(), (Object)boxAuthenticationInfo);
                        this.f.n().c((Map<String, BoxAuthenticationInfo>)this.f.b, this.a.q());
                        final Iterator iterator = this.f.a.iterator();
                        while (iterator.hasNext()) {
                            final e e2 = (e)((Reference)iterator.next()).get();
                            if (e2 != null) {
                                e2.g(boxAuthenticationInfo);
                            }
                        }
                        if (!this.a.G().equals((Object)this.b.K().G())) {
                            this.a.e(this.b, new BoxException("Session User Id has changed!"));
                        }
                        this.f.c.remove((Object)this.c);
                        return this.b;
                    }
                    catch (final BoxException ex) {
                        this.f.c.remove((Object)this.c);
                        throw this.f.s(this.a, ex, this.b, this.d);
                    }
                }
                throw this.f.s(this.a, new BoxException("client id or secret not specified", 400, "{\"error\": \"bad_request\",\n  \"error_description\": \"client id or secret not specified\"}", null), this.b, this.d);
            }
        });
        this.c.put((Object)s, (Object)futureTask);
        BoxAuthentication.f.execute((Runnable)futureTask);
        return (FutureTask<BoxAuthenticationInfo>)futureTask;
    }
    
    private h<BoxUser> k(final Context context, final BoxAuthenticationInfo boxAuthenticationInfo) {
        final ax.E3.h<BoxUser> d = ((BoxRequest<BoxUser, R>)((BoxRequestItem<E, BoxRequestsUser$GetUserInfo>)new ax.E3.e(new BoxSession(context, boxAuthenticationInfo.C(), (E)null)).d()).E(BoxAuthentication.h)).D();
        d.a((h$b)new h$b<BoxUser>(this, boxAuthenticationInfo, context) {
            final BoxAuthenticationInfo a;
            final Context b;
            final BoxAuthentication c;
            
            public void a(final BoxResponse<BoxUser> boxResponse) {
                if (boxResponse.c()) {
                    this.a.T(boxResponse.b());
                    BoxAuthentication.o().u(this.a, this.b);
                    return;
                }
                BoxAuthentication.o().v(this.a, boxResponse.a());
            }
        });
        BoxAuthentication.f.execute((Runnable)d);
        return d;
    }
    
    private ConcurrentHashMap<String, BoxAuthenticationInfo> m(final Context context) {
        if (this.b == null) {
            this.b = this.d.b(context);
        }
        return this.b;
    }
    
    public static BoxAuthentication o() {
        return BoxAuthentication.e;
    }
    
    private BoxException.RefreshFailure s(final BoxSession boxSession, final BoxException ex, final BoxAuthenticationInfo boxAuthenticationInfo, final String s) {
        final BoxException.RefreshFailure refreshFailure = new BoxException.RefreshFailure(ex);
        if (refreshFailure.g() || refreshFailure.c() == BoxException.ErrorType.i0) {
            if (s != null && s.equals((Object)this.n().a(boxSession.q()))) {
                this.n().d(null, boxSession.q());
            }
            this.m(boxSession.q()).remove((Object)s);
            this.n().c((Map<String, BoxAuthenticationInfo>)this.b, boxSession.q());
        }
        o().v(boxAuthenticationInfo, refreshFailure);
        return refreshFailure;
    }
    
    public static boolean t(final Context context) {
        return context.getPackageManager().queryIntentActivities(new Intent("com.box.android.action.AUTHENTICATE_VIA_BOX_APP"), 65600).size() > 0;
    }
    
    private void x(final BoxSession boxSession) {
        monitorenter(this);
        while (true) {
            Label_0033: {
                try {
                    final Context q = boxSession.q();
                    if (t(q) && boxSession.I()) {
                        final boolean b = true;
                        break Label_0035;
                    }
                    break Label_0033;
                }
                finally {
                    monitorexit(this);
                    final Context q;
                    final boolean b;
                    final Intent j = OAuthActivity.j(q, boxSession, b);
                    j.addFlags(268435456);
                    q.startActivity(j);
                    monitorexit(this);
                    return;
                    b = false;
                    continue;
                }
            }
            break;
        }
    }
    
    public void g(final e e) {
        synchronized (this) {
            if (this.p().contains((Object)e)) {
                return;
            }
            this.a.add((Object)new WeakReference((Object)e));
        }
    }
    
    public FutureTask<BoxAuthenticationInfo> h(final BoxSession boxSession, final String s) {
        synchronized (this) {
            final FutureTask<BoxAuthenticationInfo> i = this.i(boxSession, s);
            ((AbstractExecutorService)BoxAuthentication.f).submit((Runnable)i);
            return i;
        }
    }
    
    public BoxAuthenticationInfo l(final String s, final Context context) {
        if (s == null) {
            return null;
        }
        return (BoxAuthenticationInfo)this.m(context).get((Object)s);
    }
    
    public f n() {
        return this.d;
    }
    
    public Set<e> p() {
        final LinkedHashSet set = new LinkedHashSet();
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            final e e = (e)((Reference)iterator.next()).get();
            if (e != null) {
                ((Set)set).add((Object)e);
            }
        }
        if (this.a.size() > ((Set)set).size()) {
            this.a = (ConcurrentLinkedQueue<WeakReference<e>>)new ConcurrentLinkedQueue();
            final Iterator iterator2 = ((Set)set).iterator();
            while (iterator2.hasNext()) {
                this.a.add((Object)new WeakReference((Object)iterator2.next()));
            }
        }
        return (Set<e>)set;
    }
    
    public g q() {
        return null;
    }
    
    public Map<String, BoxAuthenticationInfo> r(final Context context) {
        return (Map<String, BoxAuthenticationInfo>)this.m(context);
    }
    
    public void u(BoxAuthenticationInfo u, final Context context) {
        u = BoxAuthenticationInfo.U(u);
        if (!SdkUtils.k(u.C()) && (u.K() == null || SdkUtils.k(u.K().G()))) {
            this.k(context, u);
            return;
        }
        this.m(context).put((Object)u.K().G(), (Object)u.D());
        this.d.d(u.K().G(), context);
        this.d.c((Map<String, BoxAuthenticationInfo>)this.b, context);
        final Iterator iterator = this.p().iterator();
        while (iterator.hasNext()) {
            ((e)iterator.next()).h(u);
        }
    }
    
    public void v(final BoxAuthenticationInfo boxAuthenticationInfo, final Exception ex) {
        final f n = this.n();
        String string = "failure:";
        if (n != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("failure:");
            sb.append("auth storage :");
            sb.append(this.n().toString());
            string = sb.toString();
        }
        final BoxAuthenticationInfo u = BoxAuthenticationInfo.U(boxAuthenticationInfo);
        String string2 = string;
        if (u != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            Object value;
            if (u.K() == null) {
                value = "null user";
            }
            else if (u.K().G() == null) {
                value = "null user id";
            }
            else {
                value = u.K().G().length();
            }
            sb2.append(value);
            string2 = sb2.toString();
        }
        ax.H3.b.f("BoxAuthfail", string2, (Throwable)ex);
        final Iterator iterator = this.p().iterator();
        while (iterator.hasNext()) {
            ((e)iterator.next()).e(u, ex);
        }
    }
    
    public FutureTask<BoxAuthenticationInfo> w(final BoxSession boxSession) {
        monitorenter(this);
        Label_0035: {
            try {
                final BoxUser d = boxSession.D();
                if (d == null) {
                    final FutureTask<BoxAuthenticationInfo> j = this.j(boxSession, boxSession.r());
                    monitorexit(this);
                    return j;
                }
                break Label_0035;
            }
            finally {
                monitorexit(this);
            Block_5_Outer:
                while (true) {
                    final BoxUser d;
                    Label_0157: {
                        while (true) {
                            BoxAuthenticationInfo boxAuthenticationInfo = null;
                            while (true) {
                                iftrue(Label_0215:)(boxSession.r().C() == null || (!boxSession.r().C().equals((Object)boxAuthenticationInfo.C()) && boxAuthenticationInfo.J() != null && System.currentTimeMillis() - boxAuthenticationInfo.J() < 15000L));
                                break Label_0157;
                                monitorexit(this);
                                final FutureTask futureTask;
                                return (FutureTask<BoxAuthenticationInfo>)futureTask;
                                final FutureTask<BoxAuthenticationInfo> i;
                                Label_0203: {
                                    i = this.j(boxSession, boxAuthenticationInfo);
                                }
                                monitorexit(this);
                                return i;
                                this.b.put((Object)d.G(), (Object)boxSession.r());
                                boxAuthenticationInfo = (BoxAuthenticationInfo)this.b.get((Object)d.G());
                                continue Block_5_Outer;
                            }
                            Label_0215: {
                                BoxAuthenticationInfo.E(boxSession.r(), boxAuthenticationInfo);
                            }
                            final FutureTask futureTask2 = new FutureTask((Callable)new Callable<BoxAuthenticationInfo>(this, boxAuthenticationInfo) {
                                final BoxAuthenticationInfo a;
                                final BoxAuthentication b;
                                
                                public BoxAuthenticationInfo a() throws Exception {
                                    return this.a;
                                }
                            });
                            BoxAuthentication.f.execute((Runnable)futureTask2);
                            monitorexit(this);
                            return (FutureTask<BoxAuthenticationInfo>)futureTask2;
                            this.m(boxSession.q());
                            iftrue(Label_0102:)((boxAuthenticationInfo = (BoxAuthenticationInfo)this.b.get((Object)d.G())) != null);
                            continue;
                        }
                    }
                    final FutureTask futureTask = (FutureTask)this.c.get((Object)d.G());
                    iftrue(Label_0203:)(futureTask == null || futureTask.isCancelled() || futureTask.isDone());
                    continue;
                }
            }
        }
    }
    
    public void y(final BoxSession boxSession) {
        synchronized (this) {
            this.x(boxSession);
        }
    }
    
    public static class BoxAuthenticationInfo extends BoxJsonObject
    {
        private static final long serialVersionUID = 2878150977399126399L;
        
        public static void E(final BoxAuthenticationInfo boxAuthenticationInfo, final BoxAuthenticationInfo boxAuthenticationInfo2) {
            boxAuthenticationInfo.i(boxAuthenticationInfo2.B());
        }
        
        public static BoxAuthenticationInfo U(final BoxAuthenticationInfo boxAuthenticationInfo) {
            if (boxAuthenticationInfo == null) {
                return null;
            }
            return new BoxImmutableAuthenticationInfo(boxAuthenticationInfo);
        }
        
        public String C() {
            return this.u("access_token");
        }
        
        public BoxAuthenticationInfo D() {
            final BoxAuthenticationInfo boxAuthenticationInfo = new BoxAuthenticationInfo();
            E(boxAuthenticationInfo, this);
            return boxAuthenticationInfo;
        }
        
        public Long G() {
            return this.t("expires_in");
        }
        
        @Deprecated
        public String I() {
            return this.u("base_domain");
        }
        
        public Long J() {
            return this.t("refresh_time");
        }
        
        public BoxUser K() {
            return this.r((b<BoxUser>)BoxEntity.E(), "user");
        }
        
        public String M() {
            return this.u("refresh_token");
        }
        
        public void N(final String s) {
            this.z("access_token", s);
        }
        
        @Deprecated
        public void O(final String s) {
            this.z("base_domain", s);
        }
        
        public void P(final String s) {
            this.z("client_id", s);
        }
        
        public void Q(final Long n) {
            this.y("expires_in", n);
        }
        
        public void R(final Long n) {
            this.y("refresh_time", n);
        }
        
        public void S(final String s) {
            this.z("refresh_token", s);
        }
        
        public void T(final BoxUser boxUser) {
            this.x("user", boxUser);
        }
        
        public static class BoxImmutableAuthenticationInfo extends BoxAuthenticationInfo
        {
            private static final long serialVersionUID = 494874517008319105L;
            
            BoxImmutableAuthenticationInfo(final BoxAuthenticationInfo boxAuthenticationInfo) {
                super.i(boxAuthenticationInfo.B());
            }
            
            @Override
            public void N(final String s) {
                b.c("trying to modify ImmutableBoxAuthenticationInfo", (Throwable)new RuntimeException());
            }
            
            @Override
            public void O(final String s) {
                b.c("trying to modify ImmutableBoxAuthenticationInfo", (Throwable)new RuntimeException());
            }
            
            @Override
            public void P(final String s) {
                b.c("trying to modify ImmutableBoxAuthenticationInfo", (Throwable)new RuntimeException());
            }
            
            @Override
            public void Q(final Long n) {
                b.c("trying to modify ImmutableBoxAuthenticationInfo", (Throwable)new RuntimeException());
            }
            
            @Override
            public void R(final Long n) {
                b.c("trying to modify ImmutableBoxAuthenticationInfo", (Throwable)new RuntimeException());
            }
            
            @Override
            public void S(final String s) {
                b.c("trying to modify ImmutableBoxAuthenticationInfo", (Throwable)new RuntimeException());
            }
            
            @Override
            public void T(final BoxUser boxUser) {
                b.c("trying to modify ImmutableBoxAuthenticationInfo", (Throwable)new RuntimeException());
            }
            
            @Override
            public void i(final d d) {
            }
            
            @Override
            public void k(final String s) {
            }
        }
    }
    
    public interface e
    {
        void e(final BoxAuthenticationInfo p0, final Exception p1);
        
        void g(final BoxAuthenticationInfo p0);
        
        void h(final BoxAuthenticationInfo p0);
    }
    
    public static class f
    {
        private static final String a;
        private static final String b;
        private static final String c;
        
        static {
            final StringBuilder sb = new StringBuilder();
            sb.append(f.class.getCanonicalName());
            sb.append("_SharedPref");
            a = sb.toString();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(f.class.getCanonicalName());
            sb2.append("_authInfoMap");
            b = sb2.toString();
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(f.class.getCanonicalName());
            sb3.append("_lastAuthUserId");
            c = sb3.toString();
        }
        
        protected String a(final Context context) {
            return context.getSharedPreferences(f.a, 0).getString(f.c, (String)null);
        }
        
        protected ConcurrentHashMap<String, BoxAuthenticationInfo> b(final Context context) {
            final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            final String string = context.getSharedPreferences(f.a, 0).getString(f.b, "");
            if (string.length() > 0) {
                final BoxEntity boxEntity = new BoxEntity();
                boxEntity.k(string);
                for (final String s : boxEntity.n()) {
                    final ax.O4.g w = boxEntity.w(s);
                    BoxJsonObject boxJsonObject;
                    if (w.r()) {
                        boxJsonObject = new BoxAuthenticationInfo();
                        boxJsonObject.k(w.k());
                    }
                    else if (w.q()) {
                        boxJsonObject = new BoxAuthenticationInfo();
                        boxJsonObject.i(w.i());
                    }
                    else {
                        boxJsonObject = null;
                    }
                    concurrentHashMap.put((Object)s, (Object)boxJsonObject);
                }
            }
            return (ConcurrentHashMap<String, BoxAuthenticationInfo>)concurrentHashMap;
        }
        
        protected void c(final Map<String, BoxAuthenticationInfo> map, final Context context) {
            final d d = new d();
            for (final Map$Entry map$Entry : map.entrySet()) {
                d.B((String)map$Entry.getKey(), (ax.O4.g)((BoxAuthenticationInfo)map$Entry.getValue()).B());
            }
            context.getSharedPreferences(f.a, 0).edit().putString(f.b, new BoxEntity(d).A()).commit();
        }
        
        protected void d(final String s, final Context context) {
            if (SdkUtils.l(s)) {
                context.getSharedPreferences(f.a, 0).edit().remove(f.c).commit();
                return;
            }
            context.getSharedPreferences(f.a, 0).edit().putString(f.c, s).commit();
        }
    }
    
    public interface g
    {
    }
}
