package com.alphainventor.filemanager.file;

import android.os.BaseBundle;
import android.app.Dialog;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import ax.c3.c0;
import ax.u3.q$e;
import ax.d3.D0;
import android.webkit.CookieSyncManager;
import android.os.Bundle;
import android.webkit.ValueCallback;
import ax.c3.d0;
import ax.c3.k0;
import androidx.fragment.app.Fragment;
import ax.c3.B;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.net.Uri;
import ax.Sa.g$b;
import android.util.AndroidRuntimeException;
import android.widget.Toast;
import ax.j3.b;
import ax.j3.b$d;
import android.app.Activity;
import ax.b3.h;
import java.util.Locale;
import android.content.Context;
import ax.b3.D;
import ax.b3.y;
import ax.b3.e;
import ax.b3.s;
import ax.b3.f;
import ax.Ua.g;
import ax.b3.t;
import java.io.InputStream;
import ax.Sa.k;
import ax.c3.G;
import ax.b3.a;
import ax.Va.d;
import ax.b3.j;
import java.io.IOException;
import android.text.TextUtils;
import ax.Va.c$b;
import ax.Va.c;
import ax.u3.q;
import ax.Sa.i;
import java.util.logging.Logger;

public class Y extends m
{
    private static final Logger l;
    private static e m;
    private volatile i h;
    private volatile boolean i;
    private q<Object, Void, Boolean> j;
    private n k;
    
    static {
        l = Logger.getLogger("FileManager.YandexFileHelper");
    }
    
    private void A0(final c c, final ax.u3.c c2) throws Exception, a {
        if (c != null && c != c.e && c.b() != c$b.q) {
            if (!TextUtils.isEmpty((CharSequence)c.a())) {
                while (true) {
                    y0(c2);
                    final ax.Va.d g = this.s0().g(c);
                    if (g.b()) {
                        try {
                            Thread.sleep(2000L);
                            continue;
                        }
                        catch (final InterruptedException ex) {
                            Thread.currentThread().interrupt();
                            throw new IOException((Throwable)ex);
                        }
                        break;
                    }
                    if (g.c()) {
                        break;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Yandex operation failed: ");
                    sb.append(g.a());
                    throw new j(sb.toString());
                }
            }
        }
    }
    
    private void B0(final n n, final G g, final long n2, final boolean b, final ax.u3.c c, final ax.g3.i i) throws j, a {
        y0(c);
        try {
            this.s0().m(this.s0().i(n.E(), b), (k)new k(this, g, n2) {
                final G a;
                final long b;
                final Y c;
                
                public InputStream a(final long n) throws IOException {
                    try {
                        return this.a.c(n);
                    }
                    catch (final j j) {
                        throw new IOException((Throwable)j);
                    }
                }
                
                public long length() {
                    return this.b;
                }
            }, (ax.Sa.d)new ax.Sa.d(this, i, c) {
                final ax.g3.i a;
                final ax.u3.c b;
                final Y c;
                
                public boolean a() {
                    final ax.u3.c b = this.b;
                    return b != null && b.isCancelled();
                }
                
                public void b(final long n, final long n2) {
                    final ax.g3.i a = this.a;
                    if (a != null) {
                        a.a(n, n2);
                    }
                }
            });
        }
        catch (final Exception ex) {
            if (c != null && c.isCancelled()) {
                throw new a((Throwable)ex);
            }
            if (ex instanceof IOException && ((Throwable)ex).getCause() instanceof j) {
                throw (j)((Throwable)ex).getCause();
            }
            throw this.p0("yandex writeFile", ex);
        }
    }
    
    private static void o0(final n n, final ax.u3.c c) throws t, a {
        if (((ax.c3.b)n).n()) {
            y0(c);
            return;
        }
        throw new t();
    }
    
    private j p0(final String s, final Exception ex) {
        if (ex instanceof j) {
            return (j)ex;
        }
        if (ex instanceof g) {
            final g g = (g)ex;
            final int a = g.a();
            if (a != 401) {
                if (a == 409) {
                    return (j)new f(false, (Throwable)ex);
                }
                if (a != 413) {
                    if (a != 429 && a != 500) {
                        if (a == 507) {
                            return (j)new s((Throwable)ex);
                        }
                        if (a == 403) {
                            return (j)new ax.b3.e((Throwable)ex);
                        }
                        if (a == 404) {
                            return (j)new t((Throwable)ex);
                        }
                        switch (a) {
                            default: {
                                return new j((Throwable)ex);
                            }
                            case 502:
                            case 503:
                            case 504: {
                                break;
                            }
                        }
                    }
                    return (j)new y(String.valueOf(g.a()), (Throwable)ex);
                }
                return (j)new D((Throwable)ex);
            }
            return (j)new ax.b3.e((Throwable)ex);
        }
        return ax.b3.d.b(s, ex);
    }
    
    private void q0(final n n) throws j {
        if (((ax.c3.b)n).n()) {
            try {
                this.A0(this.s0().b(n.E(), false), null);
                return;
            }
            catch (final Exception ex) {}
            catch (final a a) {
                throw new j((Throwable)a);
            }
            final Exception ex;
            throw this.p0("yandex deleteFile", ex);
        }
        throw new t();
    }
    
    private static String r0(final Context context) {
        final String a = ax.c3.g.c(context).a(ax.Q2.f.Q0);
        if ("ru".equalsIgnoreCase(Locale.getDefault().getLanguage())) {
            final StringBuilder sb = new StringBuilder();
            sb.append("https://oauth.yandex.ru/authorize?response_type=token&client_id=");
            sb.append(a);
            return sb.toString();
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("https://oauth.yandex.com/authorize?response_type=token&client_id=");
        sb2.append(a);
        return sb2.toString();
    }
    
    private i s0() throws h {
        final i h = this.h;
        if (this.i && h != null) {
            return h;
        }
        throw new h("Not connected : yandex");
    }
    
    public static e t0(final Context context) {
        if (Y.m == null) {
            Y.m = new e(context.getApplicationContext());
        }
        return Y.m;
    }
    
    static boolean u0(final String s, final String s2) {
        long n;
        if (s2 != null && !s2.equals((Object)"0")) {
            n = System.currentTimeMillis() + Integer.parseInt(s2) * 1000L;
        }
        else {
            n = 0L;
        }
        return s != null && (n == 0L || System.currentTimeMillis() < n);
    }
    
    private static void v0(final ax.g3.i i, final long n) {
        if (i != null) {
            i.a(n, n);
        }
    }
    
    private void w0(final i h) {
        this.h = h;
        this.i = (h != null);
        this.k = null;
    }
    
    static void x0(final Activity activity, final String s, final b$d b$d) {
        String s2 = r0((Context)activity);
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s2);
            sb.append("&login_hint=");
            sb.append(s);
            s2 = sb.toString();
        }
        try {
            ((Dialog)b.D(activity, s2, (String)null, (String)null, (String)null, "https://yxb31d3cb91f694e99bc65b2ed68322b14.oauth.yandex.ru/auth/finish?platform=android", b$d)).show();
            return;
        }
        catch (final NullPointerException ex) {
            ax.Ha.c.h().d("WEBVIEW CREATE").l((Throwable)ex).h();
            Toast.makeText((Context)activity, 2131951927, 1).show();
            goto Label_0111;
        }
        catch (final AndroidRuntimeException ex2) {}
        goto Label_0100;
    }
    
    private static void y0(final ax.u3.c c) throws a {
        if (c != null && c.isCancelled()) {
            throw new a();
        }
    }
    
    public InputStream A(String s, final String s2, final String s3) {
        final InputStream inputStream = null;
        Label_0032: {
            if (s3 == null) {
                break Label_0032;
            }
            try {
                if (!s3.startsWith("url=")) {
                    final ax.Va.e h = this.s0().h(new g$b().d(s2).e("S").a());
                    if (TextUtils.isEmpty((CharSequence)h.h())) {
                        return null;
                    }
                    s = h.h();
                }
                else {
                    s = Uri.decode(s3.substring(4));
                }
                if (s == null) {
                    return null;
                }
                return this.s0().f(s, 0L);
            }
            catch (final Exception ex) {
                return inputStream;
            }
        }
    }
    
    public boolean B(final n n) {
        return true;
    }
    
    public List<n> C(final n n, final m.f f) throws j {
        if (((ax.c3.b)n).n()) {
            ax.u3.b.c(((ax.c3.b)n).isDirectory());
            final ArrayList list = new ArrayList();
            int n2 = 0;
            ax.Va.f i;
            List a;
            do {
                try {
                    i = this.s0().h(new g$b().d(n.E()).b(Integer.valueOf(1000)).c(Integer.valueOf(n2)).e("S").a()).i();
                    if (i == null) {
                        a = null;
                    }
                    else {
                        a = i.a();
                    }
                    if (a == null) {
                        break;
                    }
                    if (a.isEmpty()) {
                        break;
                    }
                    for (final ax.Va.e e : a) {
                        if (e != null && e.g() != null) {
                            list.add((Object)new Z(this, e, null));
                        }
                    }
                }
                catch (final Exception ex) {
                    throw this.p0("yandex listChildren", ex);
                }
            } while (i.b() > (n2 += a.size()));
            return (List<n>)list;
        }
        throw new t();
    }
    
    public void D(final n n, final G g, final String s, final long n2, final Long n3, final p p9, final boolean b, final ax.u3.c c, final ax.g3.i i) throws j, a {
        this.B0(n, g, n2, false, c, i);
    }
    
    public void E(final n n, final n n2, final ax.u3.c c, final ax.g3.i i) throws j, a {
        o0(n, c);
        ax.u3.b.a(((ax.c3.b)n2).n());
        try {
            final c l = this.s0().l(n.E(), n2.E(), false);
            if (l != null && l.a() != null) {
                this.A0(l, c);
                v0(i, ((ax.c3.b)n).p());
                return;
            }
        }
        catch (final Exception ex) {
            throw this.p0("yandex moveFile", ex);
        }
        catch (final a a) {
            throw a;
        }
        throw new j("response body null error");
    }
    
    public void F(final n n, final n n2, final ax.u3.c c, final ax.g3.i i) throws j, a {
        o0(n, c);
        try {
            final c a = this.s0().a(n.E(), n2.E(), false);
            if (a != null && a.a() != null) {
                this.A0(a, c);
                v0(i, ((ax.c3.b)n).p());
                return;
            }
        }
        catch (final Exception ex) {
            throw this.p0("yandex copyFile", ex);
        }
        catch (final a a2) {
            throw a2;
        }
        throw new j("response body null error");
    }
    
    public int G(final String s, final String s2) {
        return -1;
    }
    
    public String H(final n n) {
        if (n instanceof Z) {
            final Z z = (Z)n;
            if (z.g0()) {
                final String f0 = z.f0();
                if (f0 == null) {
                    return null;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("url=");
                sb.append(Uri.encode(f0));
                return B.a0(n, sb.toString());
            }
        }
        return null;
    }
    
    public void I(final n n) throws j {
        this.q0(n);
    }
    
    public InputStream J(final n n, final long n2) throws j {
        if (((ax.c3.b)n).n()) {
            try {
                return this.s0().e(n.E(), n2);
            }
            catch (final Exception ex) {
                throw this.p0("yandex getInputStream", ex);
            }
        }
        throw new t();
    }
    
    public void K(final Activity ex, final Fragment fragment, final c$a c$a) {
        Label_0089: {
            try {
                final q<Object, Void, Boolean> j = this.j;
                if (j != null) {
                    try {
                        if (!j.isCancelled()) {
                            this.j.e();
                        }
                    }
                    catch (final Exception ex) {
                        break Label_0089;
                    }
                }
                final Context p3 = this.p();
                final int t = this.t();
                try {
                    (this.j = new d(p3, (Activity)ex, fragment, this, t, c$a)).i(new Object[0]);
                    return;
                }
                catch (final Exception ex2) {}
            }
            catch (final Exception ex) {}
        }
        if (c$a != null) {
            c$a.B();
            c$a.T(false, (Object)((Throwable)ex).getMessage());
        }
    }
    
    public boolean L() {
        return false;
    }
    
    public boolean M(final n n) {
        if (((ax.c3.b)n).n()) {
            return false;
        }
        try {
            final c k = this.s0().k(n.E());
            if (k != null && k.a() != null) {
                return true;
            }
            return false;
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    public boolean N(final n n) {
        return this.l(n);
    }
    
    public boolean O() {
        return true;
    }
    
    public void P(final n n) throws j {
        this.q0(n);
    }
    
    public boolean Q(final n n, final n n2) {
        return true;
    }
    
    public boolean Y() {
        return true;
    }
    
    public boolean a() {
        return this.i && this.h != null;
    }
    
    public void b() {
        this.i = false;
        this.k = null;
    }
    
    public boolean h0() {
        return true;
    }
    
    public void j0(final n n, final G g, final String s, final long n2, final Long n3, final p p9, final boolean b, final ax.u3.c c, final ax.g3.i i) throws j, a {
        this.B0(n, g, n2, true, c, i);
    }
    
    void m(final n n, final String s, final boolean b, final boolean b2, final ax.g3.h h, final ax.u3.c c) throws j {
        this.o(n, s, b, b2, h, c);
    }
    
    public k0 y() throws j {
        try {
            final ax.Va.b c = this.s0().c();
            return new k0(c.a(), c.b());
        }
        catch (final Exception ex) {
            throw this.p0("yandex getStorageSpace", ex);
        }
    }
    
    public n z(String u) throws j {
        u = d0.U(u);
        final boolean equals = d0.a.equals((Object)u);
        if (equals) {
            final n k = this.k;
            if (k != null) {
                return k;
            }
        }
        try {
            final Z i = new Z(this, this.s0().h(new g$b().d(u).e("S").a()), u);
            if (equals) {
                return this.k = i;
            }
            return i;
        }
        catch (final Exception ex) {
            throw this.p0("yandex getFileInfo", ex);
        }
        catch (final g g) {
            if (g.a() == 404) {
                return new Z(this, null, u);
            }
            throw this.p0("yandex getFileInfo", (Exception)g);
        }
    }
    
    void z0(final Activity activity, final Fragment fragment, final String s, final int n, final c$a c$a) {
        ax.u3.B.X((ValueCallback)new ValueCallback<Boolean>(this, activity, s, n, fragment, c$a) {
            final Activity a;
            final String b;
            final int c;
            final Fragment d;
            final c$a e;
            final Y f;
            
            public void a(final Boolean b) {
                Y.x0(this.a, this.b, (b$d)new b$d(this) {
                    final Y$c a;
                    
                    public void a() {
                        this.a.e.T(false, (Object)null);
                    }
                    
                    public void b(final Bundle bundle) {
                        CookieSyncManager.getInstance().sync();
                        final String string = ((BaseBundle)bundle).getString("access_token");
                        if (Y.u0(string, ((BaseBundle)bundle).getString("expires_in"))) {
                            Y.t0(this.a.f.p()).n(this.a.c, string, "");
                            final Y f = this.a.f;
                            final Context p = this.a.f.p();
                            final ValueCallback<Boolean> a = (ValueCallback<Boolean>)this.a;
                            final Activity a2 = a.a;
                            final Fragment d = a.d;
                            final Y f2 = a.f;
                            f.j = new d(p, a2, d, f2, f2.t(), this.a.e);
                            this.a.f.j.i(new Object[0]);
                            return;
                        }
                        Y.l.severe("OAUTH : FAILED TO RECEIVE ACCESS TOKEN 2");
                        this.a.e.T(false, (Object)null);
                    }
                    
                    public void c(final ax.j3.c c) {
                        final Logger k0 = Y.l;
                        final StringBuilder sb = new StringBuilder();
                        sb.append("OAUTH ERROR 2:");
                        sb.append(((Throwable)c).getMessage());
                        k0.severe(sb.toString());
                        this.a.e.T(false, (Object)null);
                    }
                });
            }
        });
    }
    
    private static class d extends q<Object, Void, Boolean>
    {
        Context h;
        c$a i;
        String j;
        String k;
        Y l;
        boolean m;
        int n;
        D0 o;
        boolean p;
        Activity q;
        
        public d(final Context h, final Activity q, final Fragment fragment, final Y l, final int n, final c$a i) {
            super(q$e.c0);
            this.h = h;
            this.q = q;
            this.l = l;
            this.i = i;
            this.n = n;
            this.o = (D0)fragment;
            final SharedPreferences sharedPreferences = h.getSharedPreferences("YandexDiskPrefs", 0);
            final ax.Q2.f q2 = ax.Q2.f.Q0;
            final c0 c0 = new c0(q2);
            final StringBuilder sb = new StringBuilder();
            sb.append("version_");
            sb.append(n);
            final int int1 = sharedPreferences.getInt(sb.toString(), 0);
            if (int1 == 0) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("access_token_");
                sb2.append(n);
                this.k = sharedPreferences.getString(sb2.toString(), "");
            }
            else {
                final String b = ax.Y2.a.a().b(q2);
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("access_token_");
                sb3.append(n);
                this.k = c0.a(int1, b, sharedPreferences.getString(sb3.toString(), ""));
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("account_name_");
            sb4.append(n);
            this.j = sharedPreferences.getString(sb4.toString(), "");
        }
        
        protected void r() {
            final c$a i = this.i;
            if (i != null) {
                i.B();
            }
        }
        
        protected Boolean w(final Object... array) {
            boolean p = true;
            Label_0193: {
                try {
                    final i i = new i(new ax.Sa.a(this.j, this.k));
                    final ax.Va.b c = i.c();
                    if (!TextUtils.isEmpty((CharSequence)this.j) || c.c() == null) {
                        break Label_0193;
                    }
                    final String a = c.c().a();
                    this.j = a;
                    if (TextUtils.isEmpty((CharSequence)a)) {
                        this.j = c.c().b();
                    }
                    break Label_0193;
                }
                catch (final Exception ex) {
                    break Label_0193;
                }
                catch (final g g) {
                    if (g.a() != 401) {
                        p = false;
                    }
                    this.p = p;
                    return Boolean.FALSE;
                    while (true) {
                        while (true) {
                            final SharedPreferences$Editor edit = this.h.getSharedPreferences("YandexDiskPrefs", 0).edit();
                            final StringBuilder sb = new StringBuilder();
                            sb.append("account_name_");
                            sb.append(this.n);
                            edit.putString(sb.toString(), this.j).apply();
                            this.m = true;
                            break Label_0193;
                            final i i;
                            final Y l;
                            l.w0(i);
                            return Boolean.TRUE;
                            final Exception ex;
                            ((Throwable)ex).printStackTrace();
                            return Boolean.FALSE;
                            iftrue(Label_0173:)(TextUtils.isEmpty((CharSequence)this.j));
                            continue;
                        }
                        Label_0187: {
                            return Boolean.TRUE;
                        }
                        final Y l = this.l;
                        iftrue(Label_0187:)(l == null);
                        continue;
                    }
                }
            }
        }
        
        protected void x(final Boolean b) {
            if (this.m) {
                final D0 o = this.o;
                if (o != null) {
                    ((ax.d3.a)o).ua();
                }
            }
            if (this.p) {
                final Y l = this.l;
                if (l != null) {
                    final Activity q = this.q;
                    if (q != null) {
                        l.z0(q, (Fragment)this.o, this.j, this.n, this.i);
                        return;
                    }
                }
                final c$a i = this.i;
                if (i != null) {
                    i.T(false, (Object)null);
                }
            }
            else {
                final c$a j = this.i;
                if (j != null) {
                    j.T((boolean)b, (Object)null);
                }
            }
        }
    }
    
    public static class e extends T
    {
        Context a;
        
        public e(final Context a) {
            this.a = a;
        }
        
        private void o(final Activity activity, final ax.g3.k k) {
            CookieSyncManager.createInstance((Context)activity);
            ax.u3.B.X((ValueCallback)new ValueCallback<Boolean>(this, activity, k) {
                final Activity a;
                final ax.g3.k b;
                final e c;
                
                public void a(final Boolean b) {
                    Y.x0(this.a, null, (b$d)new b$d(this) {
                        final Y$e$a a;
                        
                        public void a() {
                        }
                        
                        public void b(final Bundle bundle) {
                            CookieSyncManager.getInstance().sync();
                            final String string = ((BaseBundle)bundle).getString("access_token");
                            if (Y.u0(string, ((BaseBundle)bundle).getString("expires_in"))) {
                                final int l = this.a.c.l();
                                this.a.c.n(l, string, "");
                                final ax.g3.k b = this.a.b;
                                if (b != null) {
                                    b.c(ax.Q2.f.Q0, l);
                                }
                            }
                            else {
                                Y.l.severe("OAUTH : FAILED TO RECEIVE ACCESS TOKEN");
                                final ax.g3.k b2 = this.a.b;
                                if (b2 != null) {
                                    b2.a(ax.Q2.f.Q0, "", 0, "", (String)null);
                                }
                            }
                        }
                        
                        public void c(final ax.j3.c c) {
                            final Logger k0 = Y.l;
                            final StringBuilder sb = new StringBuilder();
                            sb.append("OAUTH ERROR :");
                            sb.append(((Throwable)c).getMessage());
                            k0.severe(sb.toString());
                            final ax.g3.k b = this.a.b;
                            if (b != null) {
                                b.a(ax.Q2.f.Q0, "", 0, "", (String)null);
                            }
                        }
                    });
                }
            });
        }
        
        public void a(final int n) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("YandexDiskPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("version_");
            sb.append(n);
            final SharedPreferences$Editor remove = edit.remove(sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("access_token_");
            sb2.append(n);
            final SharedPreferences$Editor remove2 = remove.remove(sb2.toString());
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("account_name_");
            sb3.append(n);
            final SharedPreferences$Editor remove3 = remove2.remove(sb3.toString());
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("location_name_");
            sb4.append(n);
            final SharedPreferences$Editor remove4 = remove3.remove(sb4.toString());
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("created_");
            sb5.append(n);
            final SharedPreferences$Editor remove5 = remove4.remove(sb5.toString());
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("sortindex_");
            sb6.append(n);
            remove5.remove(sb6.toString()).commit();
        }
        
        public ax.Z2.s f(final int n) {
            final SharedPreferences sharedPreferences = this.a.getSharedPreferences("YandexDiskPrefs", 0);
            final StringBuilder sb = new StringBuilder();
            sb.append("account_name_");
            sb.append(n);
            final String string = sharedPreferences.getString(sb.toString(), (String)null);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("location_name_");
            sb2.append(n);
            final String string2 = sb2.toString();
            final ax.Q2.f q0 = ax.Q2.f.Q0;
            final String string3 = sharedPreferences.getString(string2, q0.M(this.a));
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("created_");
            sb3.append(n);
            final long long1 = sharedPreferences.getLong(sb3.toString(), 0L);
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("sortindex_");
            sb4.append(n);
            return new ax.Z2.s(q0, n, string3, string, (String)null, (String)null, long1, sharedPreferences.getLong(sb4.toString(), 0L));
        }
        
        public void g(final int n, final String s) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("YandexDiskPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("location_name_");
            sb.append(n);
            edit.putString(sb.toString(), s);
            edit.commit();
        }
        
        public void j(final int n, final long n2) {
            final SharedPreferences$Editor edit = this.a.getSharedPreferences("YandexDiskPrefs", 0).edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("sortindex_");
            sb.append(n);
            edit.putLong(sb.toString(), n2);
            edit.apply();
        }
        
        public void k(final com.alphainventor.filemanager.activity.a a, final ax.g3.k k) {
            k.b(ax.Q2.f.Q0);
            this.o((Activity)a, k);
        }
        
        int l() {
            return this.a.getSharedPreferences("YandexDiskPrefs", 0).getInt("count", 0);
        }
        
        public List<ax.Z2.s> m() {
            final ArrayList list = new ArrayList();
            final Context a = this.a;
            int i = 0;
            for (SharedPreferences sharedPreferences = a.getSharedPreferences("YandexDiskPrefs", 0); i < sharedPreferences.getInt("count", 0); ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("access_token_");
                sb.append(i);
                if (sharedPreferences.getString(sb.toString(), (String)null) != null) {
                    ((List)list).add((Object)this.f(i));
                }
            }
            return (List<ax.Z2.s>)list;
        }
        
        void n(final int n, final String s, final String s2) {
            final Context a = this.a;
            boolean b = false;
            final SharedPreferences sharedPreferences = a.getSharedPreferences("YandexDiskPrefs", 0);
            if (n >= sharedPreferences.getInt("count", 0)) {
                b = true;
            }
            final ax.Q2.f q0 = ax.Q2.f.Q0;
            final c0 c0 = new c0(q0);
            final SharedPreferences$Editor edit = sharedPreferences.edit();
            final StringBuilder sb = new StringBuilder();
            sb.append("version_");
            sb.append(n);
            final SharedPreferences$Editor putInt = edit.putInt(sb.toString(), 3);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("access_token_");
            sb2.append(n);
            final SharedPreferences$Editor putString = putInt.putString(sb2.toString(), c0.e(ax.Y2.a.a().b(q0), s));
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("account_name_");
            sb3.append(n);
            final SharedPreferences$Editor putString2 = putString.putString(sb3.toString(), s2);
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("location_name_");
            sb4.append(n);
            putString2.putString(sb4.toString(), q0.M(this.a));
            if (b) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("created_");
                sb5.append(n);
                edit.putLong(sb5.toString(), System.currentTimeMillis());
                final StringBuilder sb6 = new StringBuilder();
                sb6.append("sortindex_");
                sb6.append(n);
                edit.putLong(sb6.toString(), System.currentTimeMillis());
            }
            if (b) {
                edit.putInt("count", n + 1);
            }
            edit.commit();
        }
    }
}
