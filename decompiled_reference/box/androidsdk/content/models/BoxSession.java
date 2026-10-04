package com.box.androidsdk.content.models;

import com.box.androidsdk.content.requests.BoxRequestItem;
import java.util.concurrent.FutureTask;
import java.lang.ref.Reference;
import ax.H3.b;
import com.box.androidsdk.content.requests.BoxRequestsUser$GetUserInfo;
import ax.E3.e;
import com.box.androidsdk.content.requests.BoxRequest;
import java.io.File;
import ax.E3.h$b;
import ax.I3.d;
import com.box.androidsdk.content.BoxException;
import android.content.pm.PackageManager$NameNotFoundException;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import ax.E3.g;
import java.io.Serializable;
import com.box.androidsdk.content.utils.SdkUtils;
import java.util.concurrent.TimeUnit;
import android.content.Context;
import ax.E3.h;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;
import com.box.androidsdk.content.auth.BoxAuthentication;

public class BoxSession extends BoxObject implements e
{
    private static final transient ThreadPoolExecutor e0;
    private static final long serialVersionUID = 8122900496609434013L;
    private transient e c0;
    private transient WeakReference<h<BoxSession>> d0;
    protected String mAccountEmail;
    protected BoxAuthenticationInfo mAuthInfo;
    protected String mClientId;
    protected String mClientRedirectUrl;
    protected String mClientSecret;
    protected String mDeviceId;
    protected String mDeviceName;
    protected boolean mEnableBoxAppAuthentication;
    protected Long mExpiresAt;
    private String mLastAuthCreationTaskId;
    protected BoxMDMData mMDMData;
    protected g mRefreshProvider;
    private boolean mSuppressAuthErrorUIAfterLogin;
    private String mUserAgent;
    private String mUserId;
    private transient Context q;
    
    static {
        e0 = SdkUtils.f(1, 20, 3600L, TimeUnit.SECONDS);
    }
    
    public <E extends g & Serializable> BoxSession(final Context context, final BoxAuthenticationInfo boxAuthenticationInfo, final E e) {
        final StringBuilder sb = new StringBuilder();
        sb.append("com.box.sdk.android/");
        sb.append(ax.E3.g.j);
        this.mUserAgent = sb.toString();
        this.q = ax.E3.g.i;
        this.mSuppressAuthErrorUIAfterLogin = false;
        this.mEnableBoxAppAuthentication = ax.E3.g.e;
        this.q = context.getApplicationContext();
        this.N(boxAuthenticationInfo);
        this.T();
    }
    
    public BoxSession(final Context context, final String s) {
        this(context, s, ax.E3.g.c, ax.E3.g.d, ax.E3.g.f);
        if (!SdkUtils.l(ax.E3.g.g)) {
            this.Q(ax.E3.g.g);
        }
        if (!SdkUtils.l(ax.E3.g.h)) {
            this.Q(ax.E3.g.h);
        }
    }
    
    public <E extends g & Serializable> BoxSession(final Context context, final String s, final E e) {
        this(context, p(s), e);
    }
    
    public BoxSession(final Context context, final String s, final String mClientId, final String mClientSecret, final String mClientRedirectUrl) {
        final StringBuilder sb = new StringBuilder();
        sb.append("com.box.sdk.android/");
        sb.append(ax.E3.g.j);
        this.mUserAgent = sb.toString();
        this.q = ax.E3.g.i;
        this.mSuppressAuthErrorUIAfterLogin = false;
        this.mEnableBoxAppAuthentication = ax.E3.g.e;
        this.mClientId = mClientId;
        this.mClientSecret = mClientSecret;
        this.mClientRedirectUrl = mClientRedirectUrl;
        this.B();
        if (!SdkUtils.l(this.mClientId) && !SdkUtils.l(this.mClientSecret)) {
            this.q = context.getApplicationContext();
            if (!SdkUtils.l(s)) {
                this.mAuthInfo = BoxAuthentication.o().l(s, context);
                this.mUserId = s;
            }
            if (this.mAuthInfo == null) {
                this.mUserId = s;
                this.mAuthInfo = new BoxAuthentication.BoxAuthenticationInfo();
            }
            this.mAuthInfo.P(this.mClientId);
            this.T();
            return;
        }
        throw new RuntimeException("Session must have a valid client id and client secret specified.");
    }
    
    private boolean K(final BoxAuthenticationInfo boxAuthenticationInfo) {
        return boxAuthenticationInfo != null && boxAuthenticationInfo.K() != null && this.G() != null && this.G().equals((Object)boxAuthenticationInfo.K().G());
    }
    
    private static void W(final Context context, final int n) {
        SdkUtils.t(context, n, 1);
    }
    
    private static BoxAuthenticationInfo p(final String s) {
        final BoxAuthenticationInfo boxAuthenticationInfo = new BoxAuthentication.BoxAuthenticationInfo();
        boxAuthenticationInfo.N(s);
        return boxAuthenticationInfo;
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        final Context i = ax.E3.g.i;
        if (i != null) {
            this.M(i);
        }
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }
    
    public String A() {
        return this.mClientRedirectUrl;
    }
    
    public g B() {
        BoxAuthentication.o().q();
        return null;
    }
    
    public Long C() {
        return this.mExpiresAt;
    }
    
    public BoxUser D() {
        return this.mAuthInfo.K();
    }
    
    public String E() {
        return this.mUserAgent;
    }
    
    public String G() {
        return this.mUserId;
    }
    
    public boolean I() {
        return this.mEnableBoxAppAuthentication;
    }
    
    public h<BoxSession> J() {
        final WeakReference<h<BoxSession>> d0 = this.d0;
        if (d0 != null && ((Reference)d0).get() != null) {
            final h h = (h)((Reference)this.d0).get();
            if (!((FutureTask)h).isCancelled() && !((FutureTask)h).isDone()) {
                return (h<BoxSession>)h;
            }
        }
        final ax.E3.h<BoxSession> d2 = ((BoxRequest<BoxSession, R>)new BoxSessionRefreshRequest(this)).D();
        new Thread(this, d2) {
            final BoxSession c0;
            final h q;
            
            public void run() {
                ((FutureTask)this.q).run();
            }
        }.start();
        this.d0 = (WeakReference<h<BoxSession>>)new WeakReference((Object)d2);
        return d2;
    }
    
    public void M(final Context context) {
        this.q = context.getApplicationContext();
    }
    
    protected void N(BoxAuthenticationInfo boxAuthenticationInfo) {
        if (boxAuthenticationInfo == null) {
            boxAuthenticationInfo = new BoxAuthentication.BoxAuthenticationInfo();
            (this.mAuthInfo = boxAuthenticationInfo).P(this.mClientId);
        }
        else {
            this.mAuthInfo = boxAuthenticationInfo;
        }
        if (this.mAuthInfo.K() != null && !SdkUtils.k(this.mAuthInfo.K().G())) {
            this.S(this.mAuthInfo.K().G());
            return;
        }
        this.S(null);
    }
    
    public void O(final String mAccountEmail) {
        this.mAccountEmail = mAccountEmail;
    }
    
    public void P(final String mDeviceId) {
        this.mDeviceId = mDeviceId;
    }
    
    public void Q(final String mDeviceName) {
        this.mDeviceName = mDeviceName;
    }
    
    public void R(final e c0) {
        this.c0 = c0;
    }
    
    protected void S(final String mUserId) {
        this.mUserId = mUserId;
    }
    
    protected void T() {
        final boolean b = false;
        while (true) {
            try {
                final Context q = this.q;
                boolean b2 = b;
                if (q != null) {
                    b2 = b;
                    if (q.getPackageManager() != null) {
                        if (ax.E3.g.i == null) {
                            ax.E3.g.i = this.q;
                        }
                        final int flags = this.q.getPackageManager().getPackageInfo(this.q.getPackageName(), 0).applicationInfo.flags;
                        b2 = b;
                        if ((flags & 0x2) != 0x0) {
                            b2 = true;
                        }
                    }
                }
                ax.E3.g.b = b2;
                BoxAuthentication.o().g((BoxAuthentication.e)this);
            }
            catch (final PackageManager$NameNotFoundException ex) {
                final boolean b2 = b;
                continue;
            }
            break;
        }
    }
    
    protected void U() {
        BoxAuthentication.o().y(this);
    }
    
    public boolean V() {
        return this.mSuppressAuthErrorUIAfterLogin;
    }
    
    @Override
    public void e(final BoxAuthenticationInfo boxAuthenticationInfo, final Exception ex) {
        if (!this.K(boxAuthenticationInfo)) {
            if (boxAuthenticationInfo != null) {
                return;
            }
            if (this.G() != null) {
                return;
            }
        }
        final e c0 = this.c0;
        if (c0 != null) {
            c0.e(boxAuthenticationInfo, ex);
        }
        if (ex instanceof BoxException) {
            if (BoxSession$b.a[((BoxException)ex).c().ordinal()] == 1) {
                W(this.q, ax.I3.d.p);
            }
        }
    }
    
    @Override
    public void g(final BoxAuthenticationInfo boxAuthenticationInfo) {
        if (this.K(boxAuthenticationInfo)) {
            BoxAuthentication.BoxAuthenticationInfo.E(this.mAuthInfo, boxAuthenticationInfo);
            final e c0 = this.c0;
            if (c0 != null) {
                c0.g(boxAuthenticationInfo);
            }
        }
    }
    
    @Override
    public void h(final BoxAuthenticationInfo boxAuthenticationInfo) {
        if (this.K(boxAuthenticationInfo) || this.G() == null) {
            BoxAuthentication.BoxAuthenticationInfo.E(this.mAuthInfo, boxAuthenticationInfo);
            if (boxAuthenticationInfo.K() != null) {
                this.S(boxAuthenticationInfo.K().G());
            }
            final e c0 = this.c0;
            if (c0 != null) {
                c0.h(boxAuthenticationInfo);
            }
        }
    }
    
    public h<BoxSession> l(final Context context) {
        return this.n(context, null);
    }
    
    public h<BoxSession> n(Context applicationContext, final h$b<BoxSession> h$b) {
        if (applicationContext != null) {
            applicationContext = applicationContext.getApplicationContext();
            this.q = applicationContext;
            ax.E3.g.i = applicationContext;
        }
        if (!SdkUtils.k(this.mLastAuthCreationTaskId)) {
            final ThreadPoolExecutor e0 = BoxSession.e0;
            if (e0 instanceof ax.H3.g) {
                final Runnable a = ((ax.H3.g)e0).a(this.mLastAuthCreationTaskId);
                if (a instanceof b) {
                    final b b = (b)a;
                    if (h$b != null) {
                        b.a((h$b)h$b);
                    }
                    b.b();
                    return b;
                }
            }
        }
        final h<BoxSession> d = new BoxSessionAuthCreationRequest(this, this.mEnableBoxAppAuthentication).D();
        if (h$b != null) {
            d.a((h$b)h$b);
        }
        this.mLastAuthCreationTaskId = d.toString();
        BoxSession.e0.execute((Runnable)d);
        return d;
    }
    
    public Context q() {
        return this.q;
    }
    
    public BoxAuthenticationInfo r() {
        return this.mAuthInfo;
    }
    
    public String s() {
        return this.mAccountEmail;
    }
    
    public File t() {
        return new File(this.q().getFilesDir(), this.G());
    }
    
    public String u() {
        return this.mClientId;
    }
    
    public String w() {
        return this.mClientSecret;
    }
    
    public String x() {
        return this.mDeviceId;
    }
    
    public String y() {
        return this.mDeviceName;
    }
    
    public BoxMDMData z() {
        return this.mMDMData;
    }
    
    private static class BoxSessionAuthCreationRequest extends BoxRequest<BoxSession, BoxSessionAuthCreationRequest> implements e
    {
        private static final long serialVersionUID = 8123965031279971545L;
        private boolean mIsWaitingForLoginUi;
        private final BoxSession mSession;
        
        public BoxSessionAuthCreationRequest(final BoxSession mSession, final boolean b) {
            super(null, " ", null);
            this.mSession = mSession;
        }
        
        private void G() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        com/box/androidsdk/content/models/BoxSession$BoxSessionAuthCreationRequest.mSession:Lcom/box/androidsdk/content/models/BoxSession;
            //     4: astore_1       
            //     5: aload_1        
            //     6: dup            
            //     7: astore          4
            //     9: monitorenter   
            //    10: aload_0        
            //    11: iconst_1       
            //    12: putfield        com/box/androidsdk/content/models/BoxSession$BoxSessionAuthCreationRequest.mIsWaitingForLoginUi:Z
            //    15: new             Landroid/os/Handler;
            //    18: astore_3       
            //    19: aload_3        
            //    20: invokestatic    android/os/Looper.getMainLooper:()Landroid/os/Looper;
            //    23: invokespecial   android/os/Handler.<init>:(Landroid/os/Looper;)V
            //    26: new             Lcom/box/androidsdk/content/models/BoxSession$BoxSessionAuthCreationRequest$a;
            //    29: astore_2       
            //    30: aload_2        
            //    31: aload_0        
            //    32: invokespecial   com/box/androidsdk/content/models/BoxSession$BoxSessionAuthCreationRequest$a.<init>:(Lcom/box/androidsdk/content/models/BoxSession$BoxSessionAuthCreationRequest;)V
            //    35: aload_3        
            //    36: aload_2        
            //    37: invokevirtual   android/os/Handler.post:(Ljava/lang/Runnable;)Z
            //    40: pop            
            //    41: aload_0        
            //    42: getfield        com/box/androidsdk/content/models/BoxSession$BoxSessionAuthCreationRequest.mIsWaitingForLoginUi:Z
            //    45: ifeq            75
            //    48: aload_0        
            //    49: getfield        com/box/androidsdk/content/models/BoxSession$BoxSessionAuthCreationRequest.mSession:Lcom/box/androidsdk/content/models/BoxSession;
            //    52: invokevirtual   java/lang/Object.wait:()V
            //    55: goto            41
            //    58: astore_2       
            //    59: goto            79
            //    62: astore_2       
            //    63: aload_0        
            //    64: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
            //    67: invokevirtual   java/lang/Class.getSimpleName:()Ljava/lang/String;
            //    70: ldc             "could not launch auth UI"
            //    72: invokestatic    ax/H3/b.a:(Ljava/lang/String;Ljava/lang/String;)V
            //    75: aload           4
            //    77: monitorexit    
            //    78: return         
            //    79: aload           4
            //    81: monitorexit    
            //    82: aload_2        
            //    83: athrow         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                            
            //  -----  -----  -----  -----  --------------------------------
            //  10     41     58     84     Any
            //  41     55     62     75     Ljava/lang/InterruptedException;
            //  41     55     58     84     Any
            //  63     75     58     84     Any
            //  75     78     58     84     Any
            //  79     82     58     84     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0041:
            //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
            //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
            //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
            //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
            //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:799)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
            //     at s5.b.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:90)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:367)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:162)
            //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
            //     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
            //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1100)
            //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
            //     at java.lang.Thread.run(Thread.java:1571)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        private void H() {
            final BoxSession mSession = this.mSession;
            synchronized (mSession) {
                this.mIsWaitingForLoginUi = false;
                this.mSession.notify();
            }
        }
        
        @Override
        public h<BoxSession> D() {
            return new b(BoxSession.class, this);
        }
        
        public BoxSession I() throws BoxException {
            final BoxSession mSession;
            monitorenter(mSession = this.mSession);
            Label_0225: {
                try {
                    if (this.mSession.D() != null) {
                        break Label_0225;
                    }
                    if (this.mSession.r() != null && !SdkUtils.k(this.mSession.r().C()) && this.mSession.D() == null) {
                        final ax.E3.e e = new(ax.E3.e.class)();
                        final ax.E3.e e3;
                        final ax.E3.e e2 = e3 = e;
                        final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest = this;
                        final BoxSession boxSession = boxSessionAuthCreationRequest.mSession;
                        new ax.E3.e(boxSession);
                        final ax.E3.e e4 = e2;
                        final BoxRequestsUser$GetUserInfo boxRequestsUser$GetUserInfo = e4.d();
                        final String[] array = BoxAuthentication.h;
                        final BoxRequestsUser$GetUserInfo boxRequestsUser$GetUserInfo2 = ((BoxRequestItem<E, BoxRequestsUser$GetUserInfo>)boxRequestsUser$GetUserInfo).E(array);
                        final BoxRequestsUser$GetUserInfo boxRequestsUser$GetUserInfo3 = boxRequestsUser$GetUserInfo2;
                        final BoxUser boxUser = ((BoxRequest<BoxUser, R>)boxRequestsUser$GetUserInfo3).x();
                        final BoxUser boxUser2 = boxUser;
                        final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest2 = this;
                        final BoxSession boxSession2 = boxSessionAuthCreationRequest2.mSession;
                        final BoxUser boxUser3 = boxUser2;
                        final String s = boxUser3.G();
                        boxSession2.S(s);
                        final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest3 = this;
                        final BoxSession boxSession3 = boxSessionAuthCreationRequest3.mSession;
                        final BoxAuthenticationInfo boxAuthenticationInfo = boxSession3.r();
                        final BoxUser boxUser4 = boxUser2;
                        boxAuthenticationInfo.T(boxUser4);
                        final BoxAuthentication boxAuthentication = BoxAuthentication.o();
                        final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest4 = this;
                        final BoxSession boxSession4 = boxSessionAuthCreationRequest4.mSession;
                        final BoxAuthenticationInfo boxAuthenticationInfo2 = boxSession4.r();
                        final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest5 = this;
                        final BoxSession boxSession5 = boxSessionAuthCreationRequest5.mSession;
                        final Context context = boxSession5.q();
                        boxAuthentication.u(boxAuthenticationInfo2, context);
                        final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest6 = this;
                        final BoxSession boxSession6 = boxSessionAuthCreationRequest6.mSession;
                        final BoxSession boxSession7 = mSession;
                        monitorexit(boxSession7);
                        return boxSession6;
                    }
                    break Label_0225;
                }
                finally {
                    monitorexit(mSession);
                    while (true) {
                        while (true) {
                            final BoxException ex;
                        Label_0534:
                            while (true) {
                                while (true) {
                                    Block_15: {
                                        while (true) {
                                            final BoxAuthentication.BoxAuthenticationInfo l;
                                            BoxAuthentication.BoxAuthenticationInfo.E(this.mSession.mAuthInfo, l);
                                            iftrue(Label_0328:)(!SdkUtils.k(this.mSession.r().C()) || !SdkUtils.k(this.mSession.r().M()));
                                            break Block_15;
                                            l = BoxAuthentication.o().l(this.mSession.G(), this.mSession.q());
                                            iftrue(Label_0519:)(l == null);
                                            continue;
                                        }
                                        while (true) {
                                            W(this.mSession.q(), ax.I3.d.q);
                                            break Label_0225;
                                            W(this.mSession.q(), ax.I3.d.o);
                                            break Label_0225;
                                            Label_0188: {
                                                final BoxException.RefreshFailure refreshFailure;
                                                iftrue(Label_0214:)(refreshFailure.c() != BoxException.ErrorType.i0);
                                            }
                                            continue;
                                        }
                                    }
                                    BoxAuthentication.o().g((BoxAuthentication.e)this);
                                    this.G();
                                    break Label_0534;
                                    final BoxException.RefreshFailure refreshFailure;
                                    iftrue(Label_0188:)(!((BoxException.RefreshFailure)refreshFailure).g());
                                    continue;
                                }
                                this.mSession.e(null, ex);
                                throw ex;
                                BoxAuthentication.BoxAuthenticationInfo l = null;
                                Label_0328: {
                                    iftrue(Label_0350:)(l.K() == null);
                                }
                                Block_16: {
                                    break Block_16;
                                    final BoxSession mSession2 = this.mSession;
                                    monitorexit(mSession);
                                    return mSession2;
                                    final BoxException.RefreshFailure refreshFailure;
                                    Label_0214:
                                    this.mSession.e(null, refreshFailure);
                                    throw refreshFailure;
                                }
                                iftrue(Label_0492:)(!SdkUtils.k(l.K().G()));
                                break Label_0534;
                                BoxAuthentication.o().g((BoxAuthentication.e)this);
                                this.G();
                                final BoxSession mSession3 = this.mSession;
                                monitorexit(mSession);
                                return mSession3;
                                Label_0519:
                                this.mSession.mAuthInfo.T(null);
                                this.G();
                                continue Label_0534;
                                final BoxSession mSession4 = this.mSession;
                                mSession4.h(mSession4.r());
                                continue Label_0534;
                            }
                            try {
                                final BoxUser boxUser5;
                                Label_0350: {
                                    boxUser5 = ((BoxRequest<BoxUser, R>)((BoxRequestItem<E, BoxRequestsUser$GetUserInfo>)new ax.E3.e(this.mSession).d()).E(BoxAuthentication.h)).x();
                                }
                                this.mSession.S(boxUser5.G());
                                this.mSession.r().T(boxUser5);
                                final BoxSession mSession5 = this.mSession;
                                mSession5.h(mSession5.r());
                                final BoxSession mSession6 = this.mSession;
                                monitorexit(mSession);
                                return mSession6;
                            }
                            catch (final BoxException ex) {
                                ax.H3.b.b("BoxSession", "Unable to repair user", (Throwable)ex);
                                if (ex instanceof BoxException.RefreshFailure && ((BoxException.RefreshFailure)ex).g()) {
                                    W(this.mSession.q(), ax.I3.d.o);
                                }
                                else {
                                    if (ex.c() != BoxException.ErrorType.i0) {
                                        continue;
                                    }
                                    W(this.mSession.q(), ax.I3.d.q);
                                }
                            }
                            break;
                        }
                        continue;
                    }
                }
            }
            try {
                final ax.E3.e e = new(ax.E3.e.class)();
                final ax.E3.e e3;
                final ax.E3.e e2 = e3 = e;
                final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest = this;
                final BoxSession boxSession = boxSessionAuthCreationRequest.mSession;
                new ax.E3.e(boxSession);
                final ax.E3.e e4 = e2;
                final BoxRequestsUser$GetUserInfo boxRequestsUser$GetUserInfo = e4.d();
                final String[] array = BoxAuthentication.h;
                final BoxRequestsUser$GetUserInfo boxRequestsUser$GetUserInfo2 = ((BoxRequestItem<E, BoxRequestsUser$GetUserInfo>)boxRequestsUser$GetUserInfo).E(array);
                final BoxRequestsUser$GetUserInfo boxRequestsUser$GetUserInfo3 = boxRequestsUser$GetUserInfo2;
                final BoxUser boxUser = ((BoxRequest<BoxUser, R>)boxRequestsUser$GetUserInfo3).x();
                final BoxUser boxUser2 = boxUser;
                final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest2 = this;
                final BoxSession boxSession2 = boxSessionAuthCreationRequest2.mSession;
                final BoxUser boxUser3 = boxUser2;
                final String s = boxUser3.G();
                boxSession2.S(s);
                final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest3 = this;
                final BoxSession boxSession3 = boxSessionAuthCreationRequest3.mSession;
                final BoxAuthenticationInfo boxAuthenticationInfo = boxSession3.r();
                final BoxUser boxUser4 = boxUser2;
                boxAuthenticationInfo.T(boxUser4);
                final BoxAuthentication boxAuthentication = BoxAuthentication.o();
                final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest4 = this;
                final BoxSession boxSession4 = boxSessionAuthCreationRequest4.mSession;
                final BoxAuthenticationInfo boxAuthenticationInfo2 = boxSession4.r();
                final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest5 = this;
                final BoxSession boxSession5 = boxSessionAuthCreationRequest5.mSession;
                final Context context = boxSession5.q();
                boxAuthentication.u(boxAuthenticationInfo2, context);
                final BoxSessionAuthCreationRequest boxSessionAuthCreationRequest6 = this;
                final BoxSession boxSession6 = boxSessionAuthCreationRequest6.mSession;
                final BoxSession boxSession7 = mSession;
                monitorexit(boxSession7);
                return boxSession6;
            }
            catch (final BoxException ex2) {}
        }
        
        @Override
        public void e(final BoxAuthenticationInfo boxAuthenticationInfo, final Exception ex) {
            this.H();
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof BoxSessionAuthCreationRequest && ((BoxSessionAuthCreationRequest)o).mSession.equals(this.mSession) && super.equals(o);
        }
        
        @Override
        public void g(final BoxAuthenticationInfo boxAuthenticationInfo) {
        }
        
        @Override
        public void h(final BoxAuthenticationInfo boxAuthenticationInfo) {
            this.H();
        }
        
        @Override
        public int hashCode() {
            return this.mSession.hashCode() + super.hashCode();
        }
        
        static class b extends h<BoxSession>
        {
            public b(final Class<BoxSession> clazz, final BoxRequest boxRequest) {
                super((Class)clazz, boxRequest);
            }
            
            public void b() {
                final BoxRequest q = super.q;
                if (q instanceof BoxSessionAuthCreationRequest && ((BoxSessionAuthCreationRequest)q).mIsWaitingForLoginUi) {
                    ((BoxSessionAuthCreationRequest)super.q).mSession.U();
                }
            }
        }
    }
    
    private static class BoxSessionRefreshRequest extends BoxRequest<BoxSession, BoxSessionRefreshRequest>
    {
        private static final long serialVersionUID = 8123965031279971587L;
        private BoxSession mSession;
        
        public BoxSessionRefreshRequest(final BoxSession mSession) {
            super(null, " ", null);
            this.mSession = mSession;
        }
        
        public BoxSession E() throws BoxException {
            Label_0078: {
                try {
                    final BoxAuthenticationInfo boxAuthenticationInfo = (BoxAuthenticationInfo)BoxAuthentication.o().w(this.mSession).get();
                    break Label_0078;
                }
                catch (final Exception ex) {
                    b.b("BoxSession", "Unable to repair user", (Throwable)ex);
                    Exception ex2;
                    if (((Throwable)ex).getCause() instanceof BoxException) {
                        ex2 = (Exception)((Throwable)ex).getCause();
                    }
                    else {
                        ex2 = ex;
                    }
                    if (!(ex2 instanceof BoxException)) {
                        throw new BoxException("BoxSessionRefreshRequest failed", (Throwable)ex2);
                    }
                    if (this.mSession.mSuppressAuthErrorUIAfterLogin) {
                        this.mSession.e(null, ex2);
                        BoxAuthentication.BoxAuthenticationInfo.E(this.mSession.mAuthInfo, BoxAuthentication.o().l(this.mSession.G(), this.mSession.q()));
                        return this.mSession;
                    }
                    if (ex2 instanceof BoxException.RefreshFailure && ((BoxException.RefreshFailure)ex2).g()) {
                        W(this.mSession.q(), ax.I3.d.o);
                        this.mSession.U();
                        final BoxSession mSession = this.mSession;
                        mSession.e(mSession.r(), ex2);
                        throw (BoxException)ex2;
                    }
                    if (((BoxException)ex).c() == BoxException.ErrorType.i0) {
                        W(this.mSession.q(), ax.I3.d.q);
                        this.mSession.U();
                        final BoxSession mSession2 = this.mSession;
                        mSession2.e(mSession2.r(), ex2);
                        b.b("BoxSession", "TOS refresh exception ", (Throwable)ex2);
                        throw (BoxException)ex2;
                    }
                    this.mSession.e(null, ex2);
                    throw (BoxException)ex2;
                }
            }
        }
    }
}
