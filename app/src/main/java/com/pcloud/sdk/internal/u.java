package com.pcloud.sdk.internal;

import okhttp3.FormBody;
import okhttp3.FormBody$Builder;
import ax.la.n;
import okhttp3.Request;
import ax.na.e;
import ax.xc.g;
import ax.na.d;
import okhttp3.ResponseBody;
import java.io.Closeable;
import com.google.gson.stream.JsonReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import j$.util.Objects;
import okhttp3.Request$Builder;
import java.io.IOException;
import ax.xc.p;
import ax.xc.f;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody$Builder;
import ax.la.i;
import ax.la.y;
import ax.la.r;
import ax.la.m;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.ArrayList;
import java.net.URL;
import java.util.List;
import okhttp3.HttpUrl$Builder;
import okhttp3.Response;
import com.pcloud.sdk.internal.networking.serialization.ResolutionDeserializer;
import ax.la.x;
import com.pcloud.sdk.internal.networking.serialization.ByteStringTypeAdapter;
import ax.xc.h;
import com.pcloud.sdk.internal.networking.serialization.DateTypeAdapter;
import java.util.Date;
import java.lang.reflect.Type;
import com.pcloud.sdk.internal.networking.serialization.UnmodifiableListTypeFactory;
import okhttp3.Authenticator;
import okhttp3.Interceptor;
import java.util.Map;
import java.util.Collections;
import okhttp3.Protocol;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient$Builder;
import java.util.Locale;
import java.util.TreeMap;
import java.util.UUID;
import okhttp3.HttpUrl;
import java.util.concurrent.Executor;
import okhttp3.OkHttpClient;
import com.google.gson.Gson;
import ax.la.c;
import ax.la.a;

class u implements a
{
    private static final String g;
    private final long a;
    private final c b;
    private final Gson c;
    private final OkHttpClient d;
    private final Executor e;
    private final HttpUrl f;
    
    static {
        final StringBuilder sb = new StringBuilder();
        sb.append("----pCloud-SDK-1.11.0-");
        sb.append((Object)UUID.randomUUID());
        sb.append("----");
        g = sb.toString();
    }
    
    u(final v v) {
        final TreeMap treeMap = new TreeMap();
        ((Map)treeMap).put((Object)"timeformat", (Object)"timestamp");
        final String format = String.format(Locale.US, "pCloud SDK Java %s", new Object[] { "1.11.0" });
        final OkHttpClient$Builder okHttpClient$Builder = new OkHttpClient$Builder();
        final long n = v.l();
        final TimeUnit milliseconds = TimeUnit.MILLISECONDS;
        final OkHttpClient$Builder addInterceptor = okHttpClient$Builder.readTimeout(n, milliseconds).writeTimeout((long)v.m(), milliseconds).connectTimeout((long)v.h(), milliseconds).protocols(Collections.singletonList((Object)Protocol.HTTP_1_1)).addInterceptor((Interceptor)new com.pcloud.sdk.internal.c(format, (Map<String, String>)treeMap));
        if (v.j() != null) {
            addInterceptor.dispatcher(v.j());
        }
        if (v.i() != null) {
            addInterceptor.connectionPool(v.i());
        }
        if (v.f() != null) {
            addInterceptor.cache(v.f());
        }
        addInterceptor.authenticator(Authenticator.NONE);
        if ((this.b = v.e()) != null) {
            addInterceptor.addInterceptor((Interceptor)v.e());
        }
        this.d = addInterceptor.build();
        this.e = v.g();
        this.a = v.k();
        this.c = new com.google.gson.a().c().e((ax.r8.w)new RealRemoteEntry.TypeAdapterFactory()).e((ax.r8.w)new UnmodifiableListTypeFactory()).d((Type)ax.la.u.class, (Object)new RealRemoteEntry.FileEntryDeserializer()).d((Type)Date.class, (Object)new DateTypeAdapter()).d((Type)z.class, (Object)new z.a((a)this)).d((Type)A.class, (Object)new A.a((a)this)).d((Type)h.class, (Object)new ByteStringTypeAdapter()).d((Type)x.class, (Object)ResolutionDeserializer.a).b();
        this.f = v.d();
    }
    
    private static void E(final HttpUrl$Builder httpUrl$Builder, final Long n, final x x, final boolean b) {
        httpUrl$Builder.addQueryParameter("fileid", String.valueOf((Object)n));
        httpUrl$Builder.addQueryParameter("size", String.format(Locale.US, "%dx%d", new Object[] { x.b(), x.a() }));
        if (b) {
            httpUrl$Builder.addQueryParameter("crop", String.valueOf(1));
        }
    }
    
    private static List<URL> F(final List<String> list, final String s) throws MalformedURLException {
        final ArrayList list2 = new ArrayList(list.size());
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((List)list2).add((Object)new URL("https", (String)iterator.next(), s));
        }
        return (List<URL>)list2;
    }
    
    private i<ax.la.v> G(final Long n, final String s, final String s2, final m m, final Date date, final r r, final y y) {
        if (s2 == null) {
            throw new IllegalArgumentException("Filename cannot be null.");
        }
        if (m == null) {
            throw new IllegalArgumentException("File data cannot be null.");
        }
        if (y != null) {
            final MultipartBody build = new MultipartBody$Builder(u.g).setType(MultipartBody.FORM).addFormDataPart("file", s2, (RequestBody)new RequestBody(this, r, m) {
                final r a;
                final m b;
                final u c;
                
                public long contentLength() {
                    final long a = this.b.a();
                    if (a >= 0L) {
                        return a;
                    }
                    throw new IllegalArgumentException("Content length must be >= 0.");
                }
                
                public MediaType contentType() {
                    return MediaType.parse("multipart/form-data");
                }
                
                public void writeTo(f c) throws IOException {
                    Object a = this.a;
                    if (a != null) {
                        if (this.c.e != null) {
                            a = new b(this.a, this.c.e);
                        }
                        c = p.c((ax.xc.A)new com.pcloud.sdk.internal.f((ax.xc.A)c, this.b.a(), (r)a, this.c.a));
                        this.b.b(c);
                        c.G();
                        return;
                    }
                    this.b.b(c);
                }
            }).build();
            final HttpUrl$Builder addQueryParameter = this.f.newBuilder().addPathSegment("uploadfile").addQueryParameter("renameifexists", String.valueOf((int)((y.c() ^ true) ? 1 : 0))).addQueryParameter("nopartial", String.valueOf((int)((y.d() ^ true) ? 1 : 0)));
            if (n != null) {
                addQueryParameter.addQueryParameter("folderid", String.valueOf((Object)n));
            }
            if (s != null) {
                addQueryParameter.addEncodedQueryParameter("path", s);
            }
            if (date != null) {
                addQueryParameter.addQueryParameter("mtime", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(date.getTime())));
            }
            return this.c0(new Request$Builder().url(addQueryParameter.build()).method("POST", (RequestBody)build).build(), (ax.ma.b<ax.la.v>)new j(this));
        }
        throw new IllegalArgumentException("Upload options cannot be null.");
    }
    
    private <T> T K(final Response response, final Class<? extends T> clazz) throws IOException {
        Label_0126: {
            JsonReader jsonReader;
            try {
                if (response.isSuccessful()) {
                    final ResponseBody body = response.body();
                    Objects.requireNonNull((Object)body);
                    jsonReader = new JsonReader((Reader)new BufferedReader((Reader)new InputStreamReader(body.byteStream())));
                    final u u = this;
                    final Gson gson = u.c;
                    final JsonReader jsonReader2 = jsonReader;
                    final Type type = (Type)clazz;
                    final Object o = gson.h(jsonReader2, type);
                    final JsonReader jsonReader3 = jsonReader;
                    ax.ma.a.a((Closeable)jsonReader3);
                    final Response response2 = response;
                    ax.ma.a.a((Closeable)response2);
                    final Object o2 = o;
                    return (T)o2;
                }
                throw new ax.na.a(response.code(), response.message());
            }
            finally {
                break Label_0126;
            }
            try {
                try {
                    final u u = this;
                    final Gson gson = u.c;
                    final JsonReader jsonReader2 = jsonReader;
                    final Type type = (Type)clazz;
                    final Object o = gson.h(jsonReader2, type);
                    final JsonReader jsonReader3 = jsonReader;
                    ax.ma.a.a((Closeable)jsonReader3);
                    final Response response2 = response;
                    ax.ma.a.a((Closeable)response2);
                    final Object o2 = o;
                    return (T)o2;
                }
                finally {}
            }
            catch (final ax.r8.r r) {
                throw new IOException("Malformed JSON response.", (Throwable)r);
            }
            ax.ma.a.a((Closeable)jsonReader);
            throw;
        }
        ax.ma.a.a((Closeable)response);
    }
    
    private <T extends ax.na.b> T L(final Response response, final Class<? extends T> clazz) throws IOException, ax.la.b {
        final ax.na.b b = this.K(response, clazz);
        if (b == null) {
            throw new IOException("API returned an empty response body.");
        }
        if (b.c()) {
            return (T)b;
        }
        throw new ax.la.b(b.b(), b.a());
    }
    
    private ax.la.p M(final Response response) throws IOException, ax.la.b {
        final d d = this.L(response, (Class<? extends d>)d.class);
        return (ax.la.p)new com.pcloud.sdk.internal.y((a)this, ((ax.na.c)d).d(), F((List<String>)((ax.na.c)d).e(), ((ax.na.c)d).f()), d.g());
    }
    
    private g N(final Response response) throws ax.na.a {
        int n = 0;
        try {
            if (response.isSuccessful()) {
                final int n2 = n = 1;
                final ResponseBody body = response.body();
                n = n2;
                Objects.requireNonNull((Object)body);
                n = n2;
                return body.source();
            }
            throw new ax.na.a(response.code(), response.message());
        }
        finally {
            if (n == 0) {
                ax.ma.a.a((Closeable)response);
            }
            throw new ax.na.a(response.code(), response.message());
        }
    }
    
    private boolean O(final String s) {
        return s != null && !s.isEmpty();
    }
    
    private <T> i<T> c0(final Request request, final ax.ma.b<T> b) {
        final com.pcloud.sdk.internal.e e = new com.pcloud.sdk.internal.e<Object>(this.d.newCall(request), (ax.ma.b<Object>)b);
        final Executor e2 = this.e;
        if (e2 != null) {
            return (i<T>)new E((ax.la.i<Object>)e, e2);
        }
        return (i<T>)e;
    }
    
    private Request d0(final Long n, final String s, final n n2) {
        final HttpUrl$Builder addPathSegment = this.f.newBuilder().addPathSegment("getfilelink");
        if (n != null) {
            addPathSegment.addQueryParameter("fileid", String.valueOf((Object)n));
        }
        if (s != null) {
            addPathSegment.addEncodedQueryParameter("path", s);
        }
        if (n2.c()) {
            addPathSegment.addQueryParameter("forcedownload", String.valueOf(1));
        }
        if (n2.e()) {
            addPathSegment.addQueryParameter("skipfilename", String.valueOf(1));
        }
        if (n2.a() != null) {
            final MediaType parse = MediaType.parse(n2.a());
            if (parse == null) {
                throw new IllegalArgumentException("Invalid or not well-formatted content type DownloadOptions argument");
            }
            addPathSegment.addQueryParameter("contenttype", parse.toString());
        }
        return new Request$Builder().url(addPathSegment.build()).get().build();
    }
    
    private Request$Builder e0() {
        return new Request$Builder().url(this.f);
    }
    
    private Request f0(final Long n, final x x, final boolean b) {
        final HttpUrl$Builder addPathSegment = this.f.newBuilder().addPathSegment("getthumb");
        E(addPathSegment, n, x, b);
        return new Request$Builder().url(addPathSegment.build()).get().build();
    }
    
    private void g0(final String s) {
        this.h0(s, null);
    }
    
    private void h0(final String s, final String s2) {
        if (this.O(s)) {
            return;
        }
        if (s2 != null && !s2.isEmpty()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Path argument `");
            sb.append(s2);
            sb.append("` cannot be null or empty.");
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("Path argument cannot be null or empty.");
    }
    
    private static void i0(final x x) {
        Objects.requireNonNull((Object)x);
        j0(x.b(), "Width");
        j0(x.a(), "Height");
    }
    
    private static void j0(final int n, final String s) {
        if (ax.ma.c.d0.k(n)) {
            return;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s must be in the range [16,2048].", new Object[] { s }));
    }
    
    public i<Boolean> H(final long n) {
        return this.c0(new Request$Builder().url(this.f.newBuilder().addPathSegment("deletefile").build()).get().post((RequestBody)new FormBody$Builder().add("fileid", String.valueOf(n)).build()).build(), (ax.ma.b<Boolean>)new com.pcloud.sdk.internal.r(this));
    }
    
    public i<Boolean> I(final long n) {
        return this.J(n, false);
    }
    
    public i<Boolean> J(final long n, final boolean b) {
        final FormBody build = new FormBody$Builder().add("folderid", String.valueOf(n)).build();
        final Request$Builder e0 = this.e0();
        final HttpUrl$Builder builder = this.f.newBuilder();
        String s;
        if (b) {
            s = "deletefolderrecursive";
        }
        else {
            s = "deletefolder";
        }
        return this.c0(e0.url(builder.addPathSegment(s).build()).post((RequestBody)build).build(), (ax.ma.b<Boolean>)new k(this));
    }
    
    public i<ax.la.w> a(final String s, final String s2) {
        this.h0(s, "path");
        this.h0(s2, "toPath");
        return this.c0(this.e0().url(this.f.newBuilder().addPathSegment("renamefolder").build()).post((RequestBody)new FormBody$Builder().addEncoded("path", s).addEncoded("topath", s2).build()).build(), (ax.ma.b<ax.la.w>)new o(this));
    }
    
    public i<ax.la.v> b(final String s, final String s2, final m m, final Date date, final r r, final y y) {
        this.g0(s);
        return this.G(null, s, s2, m, date, r, y);
    }
    
    public i<ax.la.w> b0(final String s, final boolean b) {
        this.g0(s);
        final HttpUrl$Builder addEncodedQueryParameter = this.f.newBuilder().addPathSegment("listfolder").addEncodedQueryParameter("path", s);
        if (b) {
            addEncodedQueryParameter.addEncodedQueryParameter("recursive", String.valueOf(1));
        }
        return this.c0(this.e0().url(addEncodedQueryParameter.build()).get().build(), (ax.ma.b<ax.la.w>)new com.pcloud.sdk.internal.h(this));
    }
    
    public i<Boolean> c(final ax.la.u u) {
        if (u == null) {
            throw new IllegalArgumentException("RemoteEntry argument cannot be null.");
        }
        if (u.f()) {
            return this.I(u.c().l());
        }
        return this.H(u.j().n());
    }
    
    public i<ax.la.v> d(final String s, final String s2, final boolean b) {
        this.h0(s, "path");
        this.h0(s2, "toPath");
        final FormBody$Builder addEncoded = new FormBody$Builder().addEncoded("path", s).addEncoded("topath", s2);
        if (!b) {
            addEncoded.add("noover", String.valueOf(1));
        }
        return this.c0(this.e0().url(this.f.newBuilder().addPathSegment("copyfile").build()).post((RequestBody)addEncoded.build()).build(), (ax.ma.b<ax.la.v>)new com.pcloud.sdk.internal.p(this));
    }
    
    public i<ax.la.v> e(final String s, final String s2, final m m, final y y) {
        return this.b(s, s2, m, null, null, y);
    }
    
    public i<g> f(final long n, final x x, final boolean b) {
        i0(x);
        return this.c0(this.f0(n, ax.ma.d.g(ax.ma.c.d0, x), b), (ax.ma.b<g>)new com.pcloud.sdk.internal.n(this));
    }
    
    public i<ax.la.p> g(final String s, final n n) {
        this.g0(s);
        if (n != null) {
            return this.c0(this.d0(null, s, n), (ax.ma.b<ax.la.p>)new l(this));
        }
        throw new IllegalArgumentException("DownloadOptions parameter cannot be null.");
    }
    
    public i<Boolean> h(final String s) {
        this.g0(s);
        return this.c0(new Request$Builder().url(this.f.newBuilder().addPathSegment("deletefile").build()).get().post((RequestBody)new FormBody$Builder().addEncoded("path", s).build()).build(), (ax.ma.b<Boolean>)new s(this));
    }
    
    public i<ax.la.v> i(final String s, final String s2) {
        this.h0(s, "path");
        this.h0(s2, "toPath");
        return this.c0(this.e0().url(this.f.newBuilder().addPathSegment("renamefile").build()).post((RequestBody)new FormBody$Builder().addEncoded("path", s).addEncoded("topath", s2).build()).build(), (ax.ma.b<ax.la.v>)new t(this));
    }
    
    public i<ax.la.A> j() {
        return this.c0(this.e0().url(this.f.newBuilder().addPathSegment("userinfo").build()).get().build(), (ax.ma.b<ax.la.A>)new q(this));
    }
    
    public i<Boolean> k(String s, final boolean b) {
        this.g0(s);
        final FormBody build = new FormBody$Builder().addEncoded("path", s).build();
        final Request$Builder e0 = this.e0();
        final HttpUrl$Builder builder = this.f.newBuilder();
        if (b) {
            s = "deletefolderrecursive";
        }
        else {
            s = "deletefolder";
        }
        return this.c0(e0.url(builder.addPathSegment(s).build()).post((RequestBody)build).build(), (ax.ma.b<Boolean>)new com.pcloud.sdk.internal.i(this));
    }
    
    public i<ax.la.w> l(final String s) {
        return this.b0(s, false);
    }
    
    public i<ax.la.v> m(final String s) {
        this.g0(s);
        return this.c0(this.e0().url(this.f.newBuilder().addPathSegment("stat").addEncodedQueryParameter("path", String.valueOf((Object)s)).build()).get().build(), (ax.ma.b<ax.la.v>)new com.pcloud.sdk.internal.g(this));
    }
    
    public i<ax.la.w> n(final String s) {
        this.g0(s);
        return this.c0(this.e0().url(this.f.newBuilder().addPathSegment("createfolder").build()).post((RequestBody)new FormBody$Builder().addEncoded("path", s).build()).build(), (ax.ma.b<ax.la.w>)new com.pcloud.sdk.internal.m(this));
    }
}
