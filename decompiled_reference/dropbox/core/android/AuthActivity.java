package com.dropbox.core.android;

import android.os.AsyncTask;
import ax.tb.i;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.content.DialogInterface;
import ax.r4.d;
import ax.r4.c;
import android.os.Build$VERSION;
import ax.p4.m;
import ax.sb.t;
import ax.p4.h;
import ax.r4.f;
import ax.r4.b$a;
import android.os.Bundle;
import android.app.UiModeManager;
import ax.p4.k;
import ax.p4.q;
import ax.p4.z;
import java.util.List;
import android.content.ComponentName;
import android.net.Uri;
import ax.p4.n;
import ax.r4.e;
import ax.tb.o;
import java.util.Collection;
import java.util.Locale;
import android.content.Context;
import android.content.ActivityNotFoundException;
import ax.Gb.l;
import android.util.Log;
import ax.r4.b$b;
import ax.r4.b;
import java.security.SecureRandom;
import ax.Gb.g;
import ax.r4.a;
import android.content.Intent;
import android.app.Activity;

public class AuthActivity extends Activity
{
    public static final b c;
    private static final String d;
    private static c e;
    private static final Object f;
    public static Intent g;
    private static a h;
    private boolean a;
    private Boolean b;
    
    static {
        c = new b(null);
        d = AuthActivity.class.getName();
        AuthActivity.e = (c)new c() {
            @Override
            public SecureRandom a() {
                return new SecureRandom();
            }
        };
        f = new Object();
    }
    
    public static final /* synthetic */ c b() {
        return AuthActivity.e;
    }
    
    public static final /* synthetic */ Object c() {
        return AuthActivity.f;
    }
    
    public static final /* synthetic */ String d() {
        return AuthActivity.d;
    }
    
    public static final /* synthetic */ void e(final a h) {
        AuthActivity.h = h;
    }
    
    private final void f(final Intent g) {
        AuthActivity.g = g;
        ax.r4.b.a.a();
        this.finish();
    }
    
    private final b$b g() {
        return ax.r4.b.a.b();
    }
    
    private static final void i(final AuthActivity authActivity, final Intent intent, final String s) {
        Log.d(AuthActivity.d, "running startActivity in handler");
        Label_0062: {
            Label_0053: {
                try {
                    final com.dropbox.core.android.b.a a = com.dropbox.core.android.b.a;
                    final Context applicationContext = ((Context)authActivity).getApplicationContext();
                    l.e((Object)applicationContext, "getApplicationContext(...)");
                    if (a.a(applicationContext, intent) != null) {
                        ((Context)authActivity).startActivity(intent);
                        break Label_0053;
                    }
                }
                catch (final ActivityNotFoundException ex) {
                    break Label_0062;
                }
                authActivity.j(s);
            }
            authActivity.g().m(s);
            return;
        }
        final ActivityNotFoundException ex;
        Log.e(AuthActivity.d, "Could not launch intent. User may have restricted profile", (Throwable)ex);
        authActivity.finish();
    }
    
    private final void j(final String s) {
        final Locale default1 = Locale.getDefault();
        final Locale locale = new Locale(default1.getLanguage(), default1.getCountry());
        String s2;
        if (!((Collection)this.g().a()).isEmpty()) {
            s2 = (String)this.g().a().get(0);
        }
        else {
            s2 = "0";
        }
        final List n = o.n((Object[])new String[] { "k", this.g().c(), "n", s2, "api", this.g().b(), "state", s });
        if (this.g().l() != null) {
            n.add((Object)"extra_query_params");
            final e a = ax.r4.e.a;
            final z l = this.g().l();
            final String j = this.g().j();
            final q g = this.g().g();
            final String c = this.g().h().c();
            ax.Gb.l.e((Object)c, "getCodeChallenge(...)");
            n.add((Object)a.a(l, j, g, c));
        }
        final String string = locale.toString();
        final k f = this.g().f();
        l.c((Object)f);
        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(ax.p4.n.g(string, f.k(), "1/connect", (String[])((Collection)n).toArray((Object[])new String[0]))));
        if (this.h((Context)this)) {
            intent.setComponent(new ComponentName(((Context)this).getPackageName(), "com.alphainventor.filemanager.activity.WebViewActivity"));
        }
        ((Context)this).startActivity(intent);
    }
    
    public final boolean h(final Context context) {
        l.f((Object)context, "context");
        if (this.b == null) {
            final Object systemService = context.getSystemService("uimode");
            UiModeManager uiModeManager;
            if (systemService instanceof UiModeManager) {
                uiModeManager = (UiModeManager)systemService;
            }
            else {
                uiModeManager = null;
            }
            if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
                this.b = Boolean.TRUE;
            }
            else {
                this.b = context.getPackageManager().hasSystemFeature("android.software.leanback");
            }
        }
        final Boolean b = this.b;
        return b != null && b;
    }
    
    protected void onCreate(final Bundle bundle) {
        final b$a a = ax.r4.b.a;
        if (!a.c()) {
            a.d(b$b.n.a(AuthActivity.h));
        }
        ((Context)this).setTheme(16973840);
        super.onCreate(bundle);
    }
    
    protected void onNewIntent(Intent queryParameter) {
        l.f((Object)queryParameter, "intent");
        final String d = this.g().d();
        final Intent intent = null;
        if (d == null) {
            this.f(null);
            return;
        }
        String s = null;
        String s2 = null;
        Object o = null;
        String s4 = null;
        Label_0207: {
            String stringExtra;
            if (queryParameter.hasExtra("ACCESS_TOKEN")) {
                s = queryParameter.getStringExtra("ACCESS_TOKEN");
                stringExtra = queryParameter.getStringExtra("ACCESS_SECRET");
                final Object stringExtra2 = queryParameter.getStringExtra("UID");
                s2 = queryParameter.getStringExtra("AUTH_STATE");
                queryParameter = (Intent)stringExtra2;
            }
            else {
                final Uri data = queryParameter.getData();
                if (data != null && l.a((Object)"/connect", (Object)data.getPath())) {
                    while (true) {
                        try {
                            s = data.getQueryParameter("oauth_token");
                            try {
                                s2 = data.getQueryParameter("oauth_token_secret");
                                try {
                                    queryParameter = (Intent)data.getQueryParameter("uid");
                                    try {
                                        final String queryParameter2 = data.getQueryParameter("state");
                                        stringExtra = s2;
                                        s2 = queryParameter2;
                                    }
                                    catch (final UnsupportedOperationException ex) {}
                                }
                                catch (final UnsupportedOperationException ex2) {
                                    queryParameter = null;
                                }
                            }
                            catch (final UnsupportedOperationException ex3) {}
                            s2 = null;
                            queryParameter = null;
                        }
                        catch (final UnsupportedOperationException ex4) {
                            s = null;
                            continue;
                        }
                        break;
                    }
                    final String s3 = null;
                    o = queryParameter;
                    s4 = s2;
                    s2 = s3;
                    break Label_0207;
                }
                s2 = null;
                s = null;
                o = (s4 = s);
                break Label_0207;
            }
            final String s5 = stringExtra;
            o = queryParameter;
            s4 = s5;
        }
        Intent intent2 = intent;
        if (s != null) {
            intent2 = intent;
            if (!l.a((Object)s, (Object)"")) {
                intent2 = intent;
                if (s4 != null) {
                    intent2 = intent;
                    if (!l.a((Object)s4, (Object)"")) {
                        intent2 = intent;
                        if (o != null) {
                            intent2 = intent;
                            if (!l.a(o, (Object)"")) {
                                intent2 = intent;
                                if (s2 != null) {
                                    intent2 = intent;
                                    if (!l.a((Object)s2, (Object)"")) {
                                        if (!l.a((Object)this.g().d(), (Object)s2)) {
                                            this.f(null);
                                            return;
                                        }
                                        if (l.a((Object)s, (Object)ax.r4.g.c0.toString())) {
                                            intent2 = new Intent();
                                            intent2.putExtra("ACCESS_TOKEN", s);
                                            intent2.putExtra("ACCESS_SECRET", s4);
                                            l.c((Object)intent2.putExtra("UID", (String)o));
                                        }
                                        else {
                                            intent2 = intent;
                                            if (l.a((Object)s, (Object)ax.r4.g.d0.toString())) {
                                                final ax.p4.l h = this.g().h();
                                                final m i = this.g().i();
                                                l.c((Object)i);
                                                final String c = this.g().c();
                                                l.c((Object)c);
                                                final k f = this.g().f();
                                                l.c((Object)f);
                                                final f f2 = new f(s4, h, i, c, f);
                                                try {
                                                    final h h2 = (h)((AsyncTask)f2).execute((Object[])new Void[0]).get();
                                                    if (h2 == null) {
                                                        final t a = t.a;
                                                        intent2 = intent;
                                                    }
                                                    else {
                                                        intent2 = new Intent();
                                                        intent2.putExtra("ACCESS_TOKEN", h2.a());
                                                        intent2.putExtra("ACCESS_SECRET", h2.a());
                                                        intent2.putExtra("REFRESH_TOKEN", h2.c());
                                                        final Long b = h2.b();
                                                        l.e((Object)b, "getExpiresAt(...)");
                                                        intent2.putExtra("EXPIRES_AT", ((Number)b).longValue());
                                                        intent2.putExtra("UID", h2.e());
                                                        intent2.putExtra("CONSUMER_KEY", this.g().c());
                                                        l.c((Object)intent2.putExtra("SCOPE", h2.d()));
                                                    }
                                                }
                                                catch (final Exception ex5) {
                                                    final t a2 = t.a;
                                                    intent2 = intent;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.f(intent2);
    }
    
    protected void onResume() {
        super.onResume();
        if (Build$VERSION.SDK_INT < 29) {
            this.onTopResumedActivityChanged(true);
        }
    }
    
    public void onTopResumedActivityChanged(final boolean b) {
        if (!this.isFinishing()) {
            if (b) {
                if (this.g().d() == null && this.g().c() != null) {
                    AuthActivity.g = null;
                    if (this.a) {
                        Log.w(AuthActivity.d, "onResume called again before Handler run");
                        return;
                    }
                    String s;
                    if (this.g().l() != null) {
                        final String c = this.g().h().c();
                        l.e((Object)c, "getCodeChallenge(...)");
                        s = ax.r4.c.a(c, String.valueOf((Object)this.g().l()), this.g().j(), this.g().g());
                    }
                    else {
                        s = ax.r4.c.b(AuthActivity.c.e());
                    }
                    this.runOnUiThread((Runnable)new ax.q4.a(this, ax.r4.d.a.b(this.g(), s, this), s));
                    this.a = true;
                }
                else {
                    this.f(null);
                }
            }
        }
    }
    
    public static final class b
    {
        private b() {
        }
        
        private static final void d(final DialogInterface dialogInterface, final int n) {
            dialogInterface.dismiss();
        }
        
        private final c e() {
            final Object c = AuthActivity.c();
            synchronized (c) {
                return AuthActivity.b();
            }
        }
        
        public final boolean c(final Context context, String d, final boolean b) {
            l.f((Object)context, "context");
            l.f((Object)d, "appKey");
            final Intent intent = new Intent("android.intent.action.VIEW");
            final StringBuilder sb = new StringBuilder();
            sb.append("db-");
            sb.append(d);
            final String string = sb.toString();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append("://1/connect");
            intent.setData(Uri.parse(sb2.toString()));
            final List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            l.e((Object)queryIntentActivities, "queryIntentActivities(...)");
            if (queryIntentActivities.size() == 0) {
                final String name = AuthActivity.class.getName();
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("URI scheme in your app's manifest is not set up correctly. You should have a ");
                sb3.append(name);
                sb3.append(" with the scheme: ");
                sb3.append(string);
                throw new IllegalStateException(sb3.toString().toString());
            }
            if (queryIntentActivities.size() > 1) {
                if (b) {
                    final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context);
                    alertDialog$Builder.setTitle((CharSequence)"Security alert");
                    alertDialog$Builder.setMessage((CharSequence)"Another app on your phone may be trying to pose as the app you are currently using. The malicious app can't access your account, but linking to Dropbox has been disabled as a precaution. Please contact support@dropbox.com.");
                    alertDialog$Builder.setPositiveButton((CharSequence)"OK", (DialogInterface$OnClickListener)new ax.q4.b());
                    alertDialog$Builder.show();
                }
                else {
                    d = AuthActivity.d();
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("There are multiple apps registered for the AuthActivity URI scheme (");
                    sb4.append(string);
                    sb4.append(").  Another app may be trying to  impersonate this app, so authentication will be disabled.");
                    Log.w(d, sb4.toString());
                }
                return false;
            }
            final ResolveInfo resolveInfo = (ResolveInfo)queryIntentActivities.get(0);
            ActivityInfo activityInfo;
            if (resolveInfo != null) {
                activityInfo = resolveInfo.activityInfo;
            }
            else {
                activityInfo = null;
            }
            if (activityInfo != null && l.a((Object)context.getPackageName(), (Object)resolveInfo.activityInfo.packageName)) {
                return true;
            }
            final String name2 = AuthActivity.class.getName();
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("There must be a ");
            sb5.append(name2);
            sb5.append(" within your app's package registered for your URI scheme (");
            sb5.append(string);
            sb5.append("). However, it appears that an activity in a different package is registered for that scheme instead. If you have multiple apps that all want to use the same accesstoken pair, designate one of them to do authentication and have the other apps launch it and then retrieve the token pair from it.");
            throw new IllegalStateException(sb5.toString().toString());
        }
        
        public final Intent f(final Context context, final String s, final String s2, final String[] array, final String s3, final String s4, final String s5, final z z, final m m, final k k, final String s6, final q q) {
            if (s != null) {
                this.g(s, s2, array, s3, s4, s5, z, m, k, s6, q);
                return new Intent(context, (Class)AuthActivity.class);
            }
            throw new IllegalArgumentException("'appKey' can't be null");
        }
        
        public final void g(final String s, final String s2, final String[] array, final String s3, final String s4, final String s5, final z z, final m m, final k k, final String s6, final q q) {
            List list;
            if (array == null || (list = i.E((Object[])array)) == null) {
                list = o.j();
            }
            k e2;
            if (k == null) {
                if (s4 != null) {
                    final k e = k.e;
                    e2 = new k(e.h(), e.i(), s4, e.j());
                }
                else {
                    e2 = k.e;
                }
            }
            else {
                e2 = k;
            }
            AuthActivity.e(new a(s, s5, s2, list, s3, z, m, e2, s6, q));
        }
    }
    
    public interface c
    {
        SecureRandom a();
    }
}
