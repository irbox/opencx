package com.box.androidsdk.content.requests;

import javax.net.SocketFactory;
import java.util.concurrent.FutureTask;
import java.net.URLConnection;
import java.lang.ref.Reference;
import java.util.AbstractMap;
import javax.net.ssl.SSLSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import android.content.Context;
import android.content.Intent;
import com.box.androidsdk.content.auth.BlockedIPErrorActivity;
import java.util.concurrent.ExecutionException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.regex.Pattern;
import com.box.androidsdk.content.models.BoxJsonObject;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import ax.E3.g;
import ax.O4.d;
import java.net.Socket;
import j$.net.URLEncoder;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxSharedLinkSession;
import com.box.androidsdk.content.utils.SdkUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Locale;
import android.text.TextUtils;
import java.util.Map;
import java.net.URL;
import ax.E3.h;
import java.util.Map$Entry;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.box.androidsdk.content.BoxException;
import java.security.SecureRandom;
import javax.net.ssl.TrustManager;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import java.util.Iterator;
import javax.net.ssl.SSLSocketFactory;
import ax.F3.b;
import com.box.androidsdk.content.models.BoxSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.lang.ref.WeakReference;
import java.io.Serializable;
import com.box.androidsdk.content.models.BoxObject;

public abstract class BoxRequest<T extends BoxObject, R extends BoxRequest<T, R>> implements Serializable
{
    transient a c0;
    private transient WeakReference<b> d0;
    protected LinkedHashMap<String, Object> mBodyMap;
    Class<T> mClazz;
    protected ContentTypes mContentType;
    protected LinkedHashMap<String, String> mHeaderMap;
    private String mIfMatchEtag;
    private String mIfNoneMatchEtag;
    protected HashMap<String, String> mQueryMap;
    protected Methods mRequestMethod;
    protected String mRequestUrlString;
    protected boolean mRequiresSocket;
    protected BoxSession mSession;
    private String mStringBody;
    protected int mTimeout;
    protected transient ax.F3.b q;
    
    public BoxRequest(final Class<T> mClazz, final String mRequestUrlString, final BoxSession mSession) {
        this.mQueryMap = (HashMap<String, String>)new HashMap();
        this.mBodyMap = (LinkedHashMap<String, Object>)new LinkedHashMap();
        this.mHeaderMap = (LinkedHashMap<String, String>)new LinkedHashMap();
        this.mContentType = ContentTypes.q;
        this.mRequiresSocket = false;
        this.mClazz = mClazz;
        this.mRequestUrlString = mRequestUrlString;
        this.mSession = mSession;
        this.C(new a((R)this));
    }
    
    private void b(final StringBuilder sb, final HashMap<String, String> hashMap) {
        for (final String s : hashMap.keySet()) {
            sb.append(s);
            sb.append((String)hashMap.get((Object)s));
        }
    }
    
    private boolean c(final HashMap<String, String> hashMap, final HashMap<String, String> hashMap2) {
        if (hashMap.size() != hashMap2.size()) {
            return false;
        }
        for (final String s : hashMap.keySet()) {
            if (!hashMap2.containsKey((Object)s)) {
                return false;
            }
            if (!((String)hashMap.get((Object)s)).equals(hashMap2.get((Object)s))) {
                return false;
            }
        }
        return true;
    }
    
    private static SSLSocketFactory o() {
        try {
            final SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[])null, (TrustManager[])null, (SecureRandom)null);
            return instance.getSocketFactory();
        }
        catch (final Exception ex) {
            ax.H3.b.c("Unable to create SSLContext", (Throwable)ex);
            return null;
        }
    }
    
    private T p(final a a, final com.box.androidsdk.content.requests.b b, final Exception ex) throws BoxException {
        if (!(ex instanceof BoxException)) {
            final BoxException ex2 = new BoxException("Couldn't connect to the Box API due to a network error.", (Throwable)ex);
            a.g(this, b, ex2);
            throw ex2;
        }
        final BoxException ex3 = (BoxException)ex;
        if (a.g(this, b, ex3)) {
            return this.x();
        }
        throw ex3;
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.c0 = new a((R)this);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }
    
    public R A(final ContentTypes mContentType) {
        this.mContentType = mContentType;
        return (R)this;
    }
    
    protected void B(final com.box.androidsdk.content.requests.a a) {
        this.f();
        for (final Map$Entry map$Entry : this.mHeaderMap.entrySet()) {
            a.a((String)map$Entry.getKey(), (String)map$Entry.getValue());
        }
    }
    
    public R C(final a c0) {
        this.c0 = c0;
        return (R)this;
    }
    
    public h<T> D() {
        return (h<T>)new h((Class)this.mClazz, this);
    }
    
    protected URL d() throws MalformedURLException, UnsupportedEncodingException {
        final String j = this.j((Map<String, String>)this.mQueryMap);
        if (TextUtils.isEmpty((CharSequence)j)) {
            return new URL(this.mRequestUrlString);
        }
        return new URL(String.format(Locale.ENGLISH, "%s?%s", new Object[] { this.mRequestUrlString, j }));
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof BoxRequest)) {
            return false;
        }
        final BoxRequest boxRequest = (BoxRequest)o;
        return this.mRequestMethod == boxRequest.mRequestMethod && this.mRequestUrlString.equals((Object)boxRequest.mRequestUrlString) && this.c((HashMap<String, String>)this.mHeaderMap, (HashMap<String, String>)boxRequest.mHeaderMap) && this.c(this.mQueryMap, boxRequest.mQueryMap);
    }
    
    protected void f() {
        this.mHeaderMap.clear();
        final BoxAuthentication.BoxAuthenticationInfo r = this.mSession.r();
        String c;
        if (r == null) {
            c = null;
        }
        else {
            c = r.C();
        }
        if (!SdkUtils.l(c)) {
            ((AbstractMap)this.mHeaderMap).put((Object)"Authorization", (Object)String.format(Locale.ENGLISH, "Bearer %s", new Object[] { c }));
        }
        ((AbstractMap)this.mHeaderMap).put((Object)"User-Agent", (Object)this.mSession.E());
        ((AbstractMap)this.mHeaderMap).put((Object)"Accept-Encoding", (Object)"gzip");
        ((AbstractMap)this.mHeaderMap).put((Object)"Accept-Charset", (Object)"utf-8");
        final ContentTypes mContentType = this.mContentType;
        if (mContentType != null) {
            ((AbstractMap)this.mHeaderMap).put((Object)"Content-Type", (Object)mContentType.toString());
        }
        final String mIfMatchEtag = this.mIfMatchEtag;
        if (mIfMatchEtag != null) {
            ((AbstractMap)this.mHeaderMap).put((Object)"If-Match", (Object)mIfMatchEtag);
        }
        final String mIfNoneMatchEtag = this.mIfNoneMatchEtag;
        if (mIfNoneMatchEtag != null) {
            ((AbstractMap)this.mHeaderMap).put((Object)"If-None-Match", (Object)mIfNoneMatchEtag);
        }
        final BoxSession mSession = this.mSession;
        if (mSession instanceof BoxSharedLinkSession) {
            final BoxSharedLinkSession boxSharedLinkSession = (BoxSharedLinkSession)mSession;
            if (!TextUtils.isEmpty((CharSequence)boxSharedLinkSession.Y())) {
                final Locale english = Locale.ENGLISH;
                String s = String.format(english, "shared_link=%s", new Object[] { boxSharedLinkSession.Y() });
                if (!TextUtils.isEmpty((CharSequence)boxSharedLinkSession.X())) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(s);
                    sb.append(String.format(english, "&shared_link_password=%s", new Object[] { boxSharedLinkSession.X() }));
                    s = sb.toString();
                }
                ((AbstractMap)this.mHeaderMap).put((Object)"BoxApi", (Object)s);
            }
        }
    }
    
    @Override
    public int hashCode() {
        final StringBuilder sb = new StringBuilder();
        sb.append((Object)this.mRequestMethod);
        sb.append(this.mRequestUrlString);
        this.b(sb, (HashMap<String, String>)this.mHeaderMap);
        this.b(sb, this.mQueryMap);
        return sb.toString().hashCode();
    }
    
    protected com.box.androidsdk.content.requests.a i() throws IOException, BoxException {
        final com.box.androidsdk.content.requests.a a = new com.box.androidsdk.content.requests.a(this.d(), this.mRequestMethod, this.q);
        this.B(a);
        this.z(a);
        return a;
    }
    
    protected String j(final Map<String, String> map) throws UnsupportedEncodingException {
        final StringBuilder sb = new StringBuilder();
        final Iterator iterator = map.entrySet().iterator();
        String string = "%s=%s";
        int n = 1;
        while (iterator.hasNext()) {
            final Map$Entry map$Entry = (Map$Entry)iterator.next();
            sb.append(String.format(Locale.ENGLISH, string, new Object[] { URLEncoder.encode((String)map$Entry.getKey(), "UTF-8"), URLEncoder.encode((String)map$Entry.getValue(), "UTF-8") }));
            if (n != 0) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("&");
                sb2.append(string);
                string = sb2.toString();
                n = 0;
            }
        }
        return sb.toString();
    }
    
    public a k() {
        return this.c0;
    }
    
    public BoxSession l() {
        return this.mSession;
    }
    
    protected Socket m() {
        final WeakReference<b> d0 = this.d0;
        if (d0 != null && ((Reference)d0).get() != null) {
            return ((b)((Reference)this.d0).get()).a();
        }
        return null;
    }
    
    public String n() throws UnsupportedEncodingException {
        final String mStringBody = this.mStringBody;
        if (mStringBody != null) {
            return mStringBody;
        }
        final ContentTypes mContentType = this.mContentType;
        if (mContentType != null) {
            final int ordinal = mContentType.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        this.mStringBody = ((ax.G3.a)this.mBodyMap.get((Object)"json_object")).h();
                    }
                }
                else {
                    final HashMap hashMap = new HashMap();
                    for (final Map$Entry map$Entry : this.mBodyMap.entrySet()) {
                        hashMap.put((Object)map$Entry.getKey(), (Object)map$Entry.getValue());
                    }
                    this.mStringBody = this.j((Map<String, String>)hashMap);
                }
            }
            else {
                final d d = new d();
                final Iterator iterator2 = this.mBodyMap.entrySet().iterator();
                while (iterator2.hasNext()) {
                    this.v(d, (Map$Entry<String, Object>)iterator2.next());
                }
                this.mStringBody = ((ax.O4.g)d).toString();
            }
        }
        return this.mStringBody;
    }
    
    protected void q(final BoxResponse<T> boxResponse) throws BoxException {
        g.a();
    }
    
    protected void r(final com.box.androidsdk.content.requests.b b) throws BoxException {
        try {
            this.s();
            ax.H3.b.d("BoxContentSdk", String.format(Locale.ENGLISH, "Response (%s):  %s", new Object[] { b.f(), b.g() }));
        }
        catch (final Exception ex) {
            ax.H3.b.c("logDebug", (Throwable)ex);
        }
    }
    
    protected void s() {
        String string;
        try {
            string = this.d().toString();
        }
        catch (final MalformedURLException | UnsupportedEncodingException ex) {
            string = null;
        }
        final Locale english = Locale.ENGLISH;
        ax.H3.b.d("BoxContentSdk", String.format(english, "Request (%s):  %s", new Object[] { this.mRequestMethod, string }));
        ax.H3.b.e("BoxContentSdk", "Request Header", (Map)this.mHeaderMap);
        final ContentTypes mContentType = this.mContentType;
        if (mContentType != null) {
            final int ordinal = mContentType.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    final HashMap hashMap = new HashMap();
                    for (final Map$Entry map$Entry : this.mBodyMap.entrySet()) {
                        hashMap.put((Object)map$Entry.getKey(), (Object)map$Entry.getValue());
                    }
                    ax.H3.b.e("BoxContentSdk", "Request Form Data", (Map)hashMap);
                    return;
                }
                if (ordinal != 2) {
                    return;
                }
            }
            if (!SdkUtils.k(this.mStringBody)) {
                ax.H3.b.d("BoxContentSdk", String.format(english, "Request JSON:  %s", new Object[] { this.mStringBody }));
            }
        }
    }
    
    protected T t() throws BoxException {
        final a k = this.k();
        final com.box.androidsdk.content.requests.b b = null;
        final com.box.androidsdk.content.requests.b b2 = null;
        Object h = null;
        Object y = null;
        Object o = null;
        Object o2 = null;
        Object o3 = null;
        Object sslSocketFactory = null;
        final com.box.androidsdk.content.requests.b b3 = null;
        SSLSocketFactory sslSocketFactory3 = null;
        Label_0706: {
            Label_0681: {
                Label_0656: {
                    Label_0631: {
                        Label_0606: {
                            try {
                                final com.box.androidsdk.content.requests.a i = this.i();
                                HttpURLConnection b4;
                                final HttpURLConnection httpURLConnection = b4 = i.b();
                                y = b3;
                                o = b;
                                o2 = b2;
                                o3 = h;
                                HttpURLConnection httpURLConnection2 = null;
                                Label_0302: {
                                    try {
                                        try {
                                            if (!this.mRequiresSocket) {
                                                break Label_0302;
                                            }
                                            b4 = httpURLConnection;
                                            y = b3;
                                            o = b;
                                            o2 = b2;
                                            o3 = h;
                                            if (httpURLConnection instanceof HttpsURLConnection) {
                                                b4 = httpURLConnection;
                                                y = b3;
                                                o = b;
                                                o2 = b2;
                                                o3 = h;
                                                final SSLSocketFactory sslSocketFactory2 = ((HttpsURLConnection)httpURLConnection).getSSLSocketFactory();
                                                b4 = httpURLConnection;
                                                y = b3;
                                                o = b;
                                                o2 = b2;
                                                o3 = h;
                                                b4 = httpURLConnection;
                                                y = b3;
                                                o = b;
                                                o2 = b2;
                                                o3 = h;
                                                sslSocketFactory = new b(sslSocketFactory2);
                                                b4 = httpURLConnection;
                                                y = b3;
                                                o = b;
                                                o2 = b2;
                                                o3 = h;
                                                b4 = httpURLConnection;
                                                y = b3;
                                                o = b;
                                                o2 = b2;
                                                o3 = h;
                                                final WeakReference d0 = new WeakReference(sslSocketFactory);
                                                b4 = httpURLConnection;
                                                y = b3;
                                                o = b;
                                                o2 = b2;
                                                o3 = h;
                                                this.d0 = (WeakReference<b>)d0;
                                                b4 = httpURLConnection;
                                                y = b3;
                                                o = b;
                                                o2 = b2;
                                                o3 = h;
                                                ((HttpsURLConnection)httpURLConnection).setSSLSocketFactory((SSLSocketFactory)sslSocketFactory);
                                            }
                                        }
                                        finally {
                                            httpURLConnection2 = b4;
                                        }
                                    }
                                    catch (final BoxException h) {
                                        break Label_0606;
                                    }
                                    catch (final IllegalAccessException h) {
                                        break Label_0631;
                                    }
                                    catch (final InstantiationException h) {
                                        break Label_0656;
                                    }
                                    catch (final IOException h) {
                                        break Label_0681;
                                    }
                                }
                                y = b3;
                                o = b;
                                o2 = b2;
                                o3 = h;
                                final int mTimeout = this.mTimeout;
                                if (mTimeout > 0) {
                                    y = b3;
                                    o = b;
                                    o2 = b2;
                                    o3 = h;
                                    ((URLConnection)httpURLConnection2).setConnectTimeout(mTimeout);
                                    y = b3;
                                    o = b;
                                    o2 = b2;
                                    o3 = h;
                                    ((URLConnection)httpURLConnection2).setReadTimeout(this.mTimeout);
                                }
                                y = b3;
                                o = b;
                                o2 = b2;
                                o3 = h;
                                h = (o3 = (o2 = (o = (y = this.y(i, httpURLConnection2)))));
                                this.r((com.box.androidsdk.content.requests.b)h);
                                y = h;
                                o = h;
                                o2 = h;
                                o3 = h;
                                if (k.e((com.box.androidsdk.content.requests.b)h)) {
                                    y = h;
                                    o = h;
                                    o2 = h;
                                    o3 = h;
                                    h = k.h(this.mClazz, (com.box.androidsdk.content.requests.b)h);
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    return (T)h;
                                }
                                y = h;
                                o = h;
                                o2 = h;
                                o3 = h;
                                y = h;
                                o = h;
                                o2 = h;
                                o3 = h;
                                final BoxException ex = new BoxException("An error occurred while sending the request", (com.box.androidsdk.content.requests.b)h);
                                y = h;
                                o = h;
                                o2 = h;
                                o3 = h;
                                throw ex;
                            }
                            catch (final BoxException h) {}
                            catch (final IllegalAccessException h) {
                                break Label_0631;
                            }
                            catch (final InstantiationException h) {
                                break Label_0656;
                            }
                            catch (final IOException h) {
                                break Label_0681;
                            }
                            finally {
                                sslSocketFactory3 = (SSLSocketFactory)sslSocketFactory;
                                break Label_0706;
                            }
                        }
                        final BoxObject p = this.p(k, (com.box.androidsdk.content.requests.b)y, (Exception)h);
                        if (sslSocketFactory3 != null) {
                            ((HttpURLConnection)sslSocketFactory3).disconnect();
                        }
                        return (T)p;
                    }
                    final BoxObject p2 = this.p(k, (com.box.androidsdk.content.requests.b)o, (Exception)h);
                    if (sslSocketFactory3 != null) {
                        ((HttpURLConnection)sslSocketFactory3).disconnect();
                    }
                    return (T)p2;
                }
                final BoxObject p3 = this.p(k, (com.box.androidsdk.content.requests.b)o2, (Exception)h);
                if (sslSocketFactory3 != null) {
                    ((HttpURLConnection)sslSocketFactory3).disconnect();
                }
                return (T)p3;
            }
            final BoxObject p4 = this.p(k, (com.box.androidsdk.content.requests.b)o3, (Exception)h);
            if (sslSocketFactory3 != null) {
                ((HttpURLConnection)sslSocketFactory3).disconnect();
            }
            return (T)p4;
        }
        if (sslSocketFactory3 != null) {
            ((HttpURLConnection)sslSocketFactory3).disconnect();
        }
    }
    
    protected void u(final BoxResponse<T> boxResponse) throws BoxException {
    }
    
    protected void v(final d d, final Map$Entry<String, Object> map$Entry) {
        final Object value = map$Entry.getValue();
        if (value instanceof BoxJsonObject) {
            d.B((String)map$Entry.getKey(), this.w(value));
            return;
        }
        if (value instanceof Double) {
            d.C((String)map$Entry.getKey(), Double.toString((double)value));
            return;
        }
        if (value instanceof Enum || value instanceof Boolean) {
            d.C((String)map$Entry.getKey(), value.toString());
            return;
        }
        if (value instanceof ax.O4.a) {
            d.B((String)map$Entry.getKey(), (ax.O4.g)value);
            return;
        }
        if (value instanceof Long) {
            d.B((String)map$Entry.getKey(), ax.O4.g.x((long)value));
            return;
        }
        if (value instanceof Integer) {
            d.B((String)map$Entry.getKey(), ax.O4.g.w((int)value));
            return;
        }
        if (value instanceof Float) {
            d.B((String)map$Entry.getKey(), ax.O4.g.u((float)value));
            return;
        }
        if (value instanceof String) {
            d.C((String)map$Entry.getKey(), (String)value);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unable to parse value ");
        sb.append(value);
        ax.H3.b.c(sb.toString(), (Throwable)new RuntimeException("Invalid value"));
    }
    
    protected ax.O4.g w(final Object o) {
        return ax.O4.g.t(((BoxJsonObject)o).A());
    }
    
    public final T x() throws BoxException {
        final Pattern compile = Pattern.compile(".*\\/\\.+.*");
        Object mRequestUrlString = this.mRequestUrlString;
        if (mRequestUrlString != null && compile.matcher((CharSequence)mRequestUrlString).matches()) {
            throw new BoxException("An invalid path parameter passed. Relative path parameters cannot be passed.");
        }
        BoxObject boxObject = null;
        try {
            final BoxObject t = this.t();
            mRequestUrlString = null;
            boxObject = t;
        }
        catch (final Exception ex) {}
        this.u(new BoxResponse<T>(boxObject, (Exception)mRequestUrlString, this));
        if (mRequestUrlString == null) {
            return (T)boxObject;
        }
        if (mRequestUrlString instanceof BoxException) {
            throw (BoxException)mRequestUrlString;
        }
        throw new BoxException("unexpected exception ", (Throwable)mRequestUrlString);
    }
    
    protected com.box.androidsdk.content.requests.b y(final com.box.androidsdk.content.requests.a a, final HttpURLConnection httpURLConnection) throws IOException, BoxException {
        final com.box.androidsdk.content.requests.b b = new com.box.androidsdk.content.requests.b(httpURLConnection);
        b.i();
        return b;
    }
    
    protected void z(final com.box.androidsdk.content.requests.a a) throws IOException {
        if (!((AbstractMap)this.mBodyMap).isEmpty()) {
            a.c((InputStream)new ByteArrayInputStream(this.n().getBytes("UTF-8")));
        }
    }
    
    public enum ContentTypes
    {
        c0("application/x-www-form-urlencoded"), 
        d0("application/json-patch+json"), 
        e0("application/octet-stream");
        
        private static final ContentTypes[] f0;
        
        q("application/json");
        
        private String mName;
        
        static {
            f0 = d();
        }
        
        private ContentTypes(final String mName) {
            this.mName = mName;
        }
        
        private static /* synthetic */ ContentTypes[] d() {
            return new ContentTypes[] { ContentTypes.q, ContentTypes.c0, ContentTypes.d0, ContentTypes.e0 };
        }
        
        public String toString() {
            return this.mName;
        }
    }
    
    public enum Methods
    {
        c0, 
        d0, 
        e0, 
        f0;
        
        private static final Methods[] g0;
        
        q;
        
        static {
            g0 = d();
        }
        
        private static /* synthetic */ Methods[] d() {
            return new Methods[] { Methods.q, Methods.c0, Methods.d0, Methods.e0, Methods.f0 };
        }
    }
    
    public static class a<R extends BoxRequest>
    {
        protected R a;
        protected int b;
        private int c;
        
        public a(final R a) {
            this.b = 0;
            this.c = 0;
            this.a = a;
        }
        
        private boolean a(final com.box.androidsdk.content.requests.b b) {
            return b != null && b.f() == 401;
        }
        
        protected static int c(final com.box.androidsdk.content.requests.b b, int int1) {
            final String headerField = ((URLConnection)b.e()).getHeaderField("Retry-After");
            int n = int1;
            if (!SdkUtils.k(headerField)) {
                try {
                    int1 = Integer.parseInt(headerField);
                }
                catch (final NumberFormatException ex) {}
                if (int1 > 0) {
                    n = int1;
                }
                else {
                    n = 1;
                }
            }
            return n * 1000;
        }
        
        private boolean d(String s) {
            final String[] split = s.split("=");
            if (split.length == 2) {
                s = split[0];
                if (s != null && split[1] != null && "error".equalsIgnoreCase(s.trim()) && "invalid_token".equalsIgnoreCase(split[1].replace((CharSequence)"\"", (CharSequence)"").trim())) {
                    return true;
                }
            }
            return false;
        }
        
        private boolean f(final com.box.androidsdk.content.requests.b b) {
            if (b == null) {
                return false;
            }
            if (401 != b.f()) {
                return false;
            }
            final String headerField = ((URLConnection)b.a).getHeaderField("WWW-Authenticate");
            if (!SdkUtils.l(headerField)) {
                final String[] split = headerField.split(",");
                for (int length = split.length, i = 0; i < length; ++i) {
                    if (this.d(split[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        protected void b(final com.box.androidsdk.content.requests.b b) throws BoxException {
            try {
                b.e().disconnect();
            }
            catch (final Exception ex) {
                ax.H3.b.c("Interrupt disconnect", (Throwable)ex);
            }
            throw new BoxException("Thread interrupted request cancelled ", (Throwable)new InterruptedException());
        }
        
        public boolean e(final com.box.androidsdk.content.requests.b b) {
            final int f = b.f();
            return (f >= 200 && f < 300) || f == 429;
        }
        
        public boolean g(final BoxRequest boxRequest, final com.box.androidsdk.content.requests.b b, final BoxException ex) throws BoxException.RefreshFailure {
            final BoxSession l = boxRequest.l();
            if (this.f(b)) {
                Label_0081: {
                    try {
                        final BoxResponse boxResponse = (BoxResponse)((FutureTask)l.J()).get();
                        if (boxResponse.c()) {
                            return true;
                        }
                        if (boxResponse.a() == null) {
                            return false;
                        }
                        if (!(boxResponse.a() instanceof BoxException.RefreshFailure)) {
                            return false;
                        }
                        throw (BoxException.RefreshFailure)boxResponse.a();
                    }
                    catch (final ExecutionException ex2) {}
                    catch (final InterruptedException ex3) {
                        break Label_0081;
                    }
                    final ExecutionException ex2;
                    ax.H3.b.b("oauthRefresh", "Interrupted Exception", (Throwable)ex2);
                    return false;
                }
                final InterruptedException ex3;
                ax.H3.b.b("oauthRefresh", "Interrupted Exception", (Throwable)ex3);
            }
            else if (this.a(b)) {
                final BoxException.ErrorType c = ex.c();
                if (!l.V()) {
                    final Context q = l.q();
                    if (c == BoxException.ErrorType.r0 || c == BoxException.ErrorType.q0) {
                        final Intent intent = new Intent(l.q(), (Class)BlockedIPErrorActivity.class);
                        intent.addFlags(268435456);
                        q.startActivity(intent);
                        return false;
                    }
                    if (c == BoxException.ErrorType.i0) {
                        SdkUtils.t(q, ax.I3.d.q, 1);
                    }
                    Label_0364: {
                        Label_0353: {
                            Label_0295: {
                                String s;
                                try {
                                    if (this.c <= 4) {
                                        break Label_0295;
                                    }
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append(" Exceeded max refresh retries for ");
                                    sb.append(boxRequest.getClass().getName());
                                    sb.append(" response code");
                                    sb.append(ex.e());
                                    sb.append(" response ");
                                    sb.append((Object)b);
                                    s = sb.toString();
                                    if (ex.b() != null) {
                                        final StringBuilder sb2 = new StringBuilder();
                                        sb2.append(s);
                                        sb2.append(ex.b().A());
                                        s = sb2.toString();
                                    }
                                }
                                catch (final ExecutionException ex4) {
                                    break Label_0353;
                                }
                                catch (final InterruptedException ex5) {
                                    break Label_0364;
                                }
                                ax.H3.b.f("authFailed", s, (Throwable)ex);
                                return false;
                            }
                            final BoxResponse boxResponse2 = (BoxResponse)((FutureTask)l.J()).get();
                            if (boxResponse2.c()) {
                                ++this.c;
                                return true;
                            }
                            if (boxResponse2.a() == null) {
                                return false;
                            }
                            if (!(boxResponse2.a() instanceof BoxException.RefreshFailure)) {
                                return false;
                            }
                            throw (BoxException.RefreshFailure)boxResponse2.a();
                        }
                        final ExecutionException ex4;
                        ax.H3.b.b("oauthRefresh", "Interrupted Exception", (Throwable)ex4);
                        return false;
                    }
                    final InterruptedException ex5;
                    ax.H3.b.b("oauthRefresh", "Interrupted Exception", (Throwable)ex5);
                }
            }
            else if (b != null && b.f() == 403) {
                final BoxException.ErrorType c2 = ex.c();
                if (c2 == BoxException.ErrorType.r0 || c2 == BoxException.ErrorType.q0) {
                    final Context q2 = l.q();
                    final Intent intent2 = new Intent(l.q(), (Class)BlockedIPErrorActivity.class);
                    intent2.addFlags(268435456);
                    q2.startActivity(intent2);
                }
            }
            return false;
        }
        
        public <T extends BoxObject> T h(final Class<T> clazz, final com.box.androidsdk.content.requests.b b) throws IllegalAccessException, InstantiationException, BoxException {
            if (b.f() == 429) {
                return this.i(b);
            }
            if (Thread.currentThread().isInterrupted()) {
                this.b(b);
            }
            final String d = b.d();
            final BoxObject boxObject = clazz.newInstance();
            if (boxObject instanceof BoxJsonObject && d.contains((CharSequence)ContentTypes.q.toString())) {
                ((BoxJsonObject)boxObject).k(b.g());
            }
            return (T)boxObject;
        }
        
        protected <T extends BoxObject> T i(final com.box.androidsdk.content.requests.b b) throws BoxException {
            final int b2 = this.b;
            if (b2 < 1) {
                this.b = b2 + 1;
                final long n = c(b, (int)(Math.random() * 10.0) + 20);
                try {
                    Thread.sleep(n);
                    return this.a.x();
                }
                catch (final InterruptedException ex) {
                    throw new BoxException(((Throwable)ex).getMessage(), (Throwable)ex);
                }
            }
            throw new BoxException.RateLimitAttemptsExceeded("Max attempts exceeded", this.b, b);
        }
    }
    
    static class b extends SSLSocketFactory
    {
        public SSLSocketFactory a;
        private WeakReference<Socket> b;
        
        public b(final SSLSocketFactory a) {
            this.a = a;
        }
        
        public Socket a() {
            final WeakReference<Socket> b = this.b;
            if (b != null) {
                return (Socket)((Reference)b).get();
            }
            return null;
        }
        
        Socket b(final Socket socket) {
            this.b = (WeakReference<Socket>)new WeakReference((Object)socket);
            return socket;
        }
        
        public Socket createSocket(final String s, final int n) throws IOException, UnknownHostException {
            return this.b(((SocketFactory)this.a).createSocket(s, n));
        }
        
        public Socket createSocket(final String s, final int n, final InetAddress inetAddress, final int n2) throws IOException, UnknownHostException {
            return this.b(((SocketFactory)this.a).createSocket(s, n, inetAddress, n2));
        }
        
        public Socket createSocket(final InetAddress inetAddress, final int n) throws IOException {
            return this.b(((SocketFactory)this.a).createSocket(inetAddress, n));
        }
        
        public Socket createSocket(final InetAddress inetAddress, final int n, final InetAddress inetAddress2, final int n2) throws IOException {
            return this.b(((SocketFactory)this.a).createSocket(inetAddress, n, inetAddress2, n2));
        }
        
        public Socket createSocket(final Socket socket, final String s, final int n, final boolean b) throws IOException {
            return this.b(this.a.createSocket(socket, s, n, b));
        }
        
        public String[] getDefaultCipherSuites() {
            return this.a.getDefaultCipherSuites();
        }
        
        public String[] getSupportedCipherSuites() {
            return this.a.getDefaultCipherSuites();
        }
    }
    
    public static class c extends b
    {
        private final String[] c;
        
        public c() {
            super(o());
            this.c = new String[] { "TLSv1.1", "TLSv1.2" };
        }
        
        @Override
        Socket b(final Socket socket) {
            if (socket instanceof SSLSocket) {
                ((SSLSocket)socket).setEnabledProtocols(this.c);
            }
            return super.b(socket);
        }
    }
}
