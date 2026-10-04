package com.pcloud.sdk;

import android.view.View;
import android.widget.Toast;
import android.content.ActivityNotFoundException;
import ax.la.s;
import ax.la.t;
import android.os.Bundle;
import android.content.IntentFilter;
import android.annotation.TargetApi;
import ax.la.g;
import ax.la.f;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import java.util.Locale;
import android.webkit.WebViewClient;
import java.util.Map;
import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.os.Parcelable;
import android.content.Intent;
import android.content.Context;
import java.util.Iterator;
import android.net.Uri$Builder;
import ax.la.h;
import ax.la.l;
import android.content.BroadcastReceiver;
import android.webkit.WebView;
import android.net.Uri;
import android.app.Activity;

public final class AuthorizationActivity extends Activity
{
    private static final Uri g;
    private final String a;
    private WebView b;
    private b c;
    private BroadcastReceiver d;
    private l e;
    private boolean f;
    
    static {
        g = Uri.parse("https://my.pcloud.com/oauth2/authorize");
    }
    
    public AuthorizationActivity() {
        this.a = "pcloud-oauth://";
        this.e = null;
        this.f = true;
    }
    
    private Uri d(final b b) {
        String s;
        if (b.q == com.pcloud.sdk.b.c.c0) {
            s = "code";
        }
        else {
            s = "token";
        }
        final Uri$Builder appendQueryParameter = AuthorizationActivity.g.buildUpon().appendQueryParameter("response_type", s).appendQueryParameter("client_id", b.c0);
        final StringBuilder sb = new StringBuilder();
        sb.append("pcloud-oauth://");
        sb.append(((Context)this).getPackageName());
        final Uri$Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("redirect_uri", sb.toString());
        if (b.f0) {
            appendQueryParameter2.appendQueryParameter("force_reapprove", "true");
        }
        if (!b.d0.isEmpty()) {
            final StringBuilder sb2 = new StringBuilder();
            final Iterator iterator = b.d0.iterator();
            while (iterator.hasNext()) {
                sb2.append((String)iterator.next());
                if (iterator.hasNext()) {
                    sb2.append(",");
                }
            }
            appendQueryParameter2.appendQueryParameter("permissions", sb2.toString());
        }
        return appendQueryParameter2.build();
    }
    
    public static Intent e(final Context context, final b b) {
        if (context == null) {
            throw new IllegalArgumentException("Context argument cannot be null.");
        }
        if (b != null) {
            final Intent intent = new Intent(context, (Class)AuthorizationActivity.class);
            intent.putExtra("com.pcloud.authentication.AuthorizationActivity.ARGUMENT_AUTH_REQUEST", (Parcelable)b);
            return intent;
        }
        throw new IllegalArgumentException("AuthorizationRequest argument cannot be null.");
    }
    
    @SuppressLint({ "SetJavaScriptEnabled" })
    private void f(final Uri uri) {
        this.b.setWebViewClient(this.j());
        ((View)this.b).setVisibility(0);
        final WebSettings settings = this.b.getSettings();
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.b.loadUrl(uri.toString());
    }
    
    private long g(Map<String, String> i, final String s) {
        i = this.i((Map<String, String>)i, s);
        try {
            return Long.parseLong(i);
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(i);
            sb.append("' is not a valid value for '");
            sb.append(s);
            sb.append("'.");
            throw new IllegalStateException(sb.toString());
        }
    }
    
    public static a h(final Intent intent) {
        if (intent.hasExtra("com.pcloud.authentication.AuthorizationActivity.ARGUMENT_AUTH_RESULT")) {
            return (a)intent.getParcelableExtra("com.pcloud.authentication.AuthorizationActivity.ARGUMENT_AUTH_RESULT");
        }
        throw new IllegalArgumentException("Invalid intent provided.");
    }
    
    private String i(final Map<String, String> map, final String s) {
        final String s2 = (String)map.get((Object)s);
        if (s2 != null) {
            return s2;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Missing '");
        sb.append(s);
        sb.append("' response parameter.");
        throw new IllegalStateException(sb.toString());
    }
    
    private WebViewClient j() {
        return new WebViewClient(this) {
            final AuthorizationActivity a;
            
            public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
                if (!this.a.isFinishing()) {
                    this.a.l(h.f0, String.format(Locale.US, "Error while loading url '%s':\n%d: %s", new Object[] { s2, n, s }));
                }
            }
            
            @TargetApi(23)
            public void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
                this.onReceivedError(webView, ax.la.f.a(webResourceError), ax.la.g.a(webResourceError).toString(), webResourceRequest.getUrl().toString());
            }
            
            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(final WebView webView, final WebResourceRequest webResourceRequest) {
                final Uri url = webResourceRequest.getUrl();
                return url != null && this.shouldOverrideUrlLoading(webView, url.toString());
            }
            
            public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
                return this.a.k(s);
            }
        };
    }
    
    private boolean k(String i) {
        if (i != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("pcloud-oauth://");
            sb.append(((Context)this).getPackageName());
            if (i.startsWith(sb.toString())) {
                Label_0215: {
                    Map<String, String> b;
                    String j;
                    try {
                        b = com.pcloud.sdk.c.b(i);
                        final boolean containsKey = b.containsKey((Object)"access_token");
                        j = null;
                        if (!containsKey) {
                            if (!b.containsKey((Object)"code")) {
                                this.l(h.e0, null);
                                return true;
                            }
                        }
                    }
                    catch (final Exception ex) {
                        break Label_0215;
                    }
                    if (this.c.q == com.pcloud.sdk.b.c.d0) {
                        i = this.i(b, "access_token");
                    }
                    else {
                        i = null;
                    }
                    if (this.c.q == com.pcloud.sdk.b.c.c0) {
                        j = this.i(b, "code");
                    }
                    this.n(new a(this.c, h.c0, i, this.g(b, "userid"), this.g(b, "locationid"), j, this.i(b, "hostname"), null));
                    return true;
                }
                final Exception ex;
                this.l(h.f0, ((Throwable)ex).getMessage());
                return true;
            }
        }
        return false;
    }
    
    private void l(final h h, final String s) {
        this.n(new a(this.c, h, null, 0L, 0L, null, null, s));
    }
    
    private void m(final Uri uri, final String s) {
        ((View)this.b).setVisibility(4);
        (this.e = new l(uri)).e((Activity)this, s);
        this.f = false;
        this.d = new BroadcastReceiver(this) {
            final AuthorizationActivity a;
            
            public void onReceive(final Context context, final Intent intent) {
                final Intent intent2 = new Intent((Context)this.a, (Class)AuthorizationActivity.class);
                intent2.setAction("AuthorizationActivity.REFRESH_ACTION");
                intent2.putExtra("AuthorizationActivity.EXTRA_URL", (Parcelable)intent.getParcelableExtra("AuthorizationActivity.EXTRA_URL"));
                intent2.putExtra("com.pcloud.authentication.AuthorizationActivity.ARGUMENT_AUTH_REQUEST", (Parcelable)this.a.c);
                intent2.addFlags(603979776);
                ((Context)this.a).startActivity(intent2);
            }
        };
        ax.L0.a.b((Context)this).c(this.d, new IntentFilter("CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION"));
    }
    
    private void n(final a a) {
        final Intent intent = new Intent();
        intent.putExtra("com.pcloud.authentication.AuthorizationActivity.ARGUMENT_AUTH_RESULT", (Parcelable)a);
        int n;
        if (a.c0 == h.d0) {
            n = 0;
        }
        else {
            n = -1;
        }
        this.setResult(n, intent);
        this.finish();
    }
    
    public void onBackPressed() {
        if (this.b.canGoBack()) {
            this.b.goBack();
            return;
        }
        this.l(h.d0, null);
    }
    
    protected void onCreate(Bundle d) {
        super.onCreate(d);
        final Intent intent = this.getIntent();
        if ("CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION".equals((Object)this.getIntent().getAction())) {
            this.setResult(0);
            this.finish();
            return;
        }
        if (intent != null && intent.hasExtra("com.pcloud.authentication.AuthorizationActivity.ARGUMENT_AUTH_REQUEST")) {
            this.c = (b)intent.getParcelableExtra("com.pcloud.authentication.AuthorizationActivity.ARGUMENT_AUTH_REQUEST");
            this.setContentView(t.a);
            this.b = (WebView)this.findViewById(s.a);
            d = (Bundle)this.d(this.c);
            final String a = com.pcloud.sdk.c.a((Context)this, this.c.e0);
            if (a != null) {
                try {
                    this.m((Uri)d, a);
                    return;
                }
                catch (final ActivityNotFoundException ex) {
                    this.f((Uri)d);
                    return;
                }
            }
            this.f((Uri)d);
            return;
        }
        this.setResult(0);
        Toast.makeText((Context)this, (CharSequence)"Error", 1).show();
        this.finish();
    }
    
    protected void onDestroy() {
        super.onDestroy();
        final l e = this.e;
        if (e != null) {
            e.d((Activity)this);
            this.e = null;
        }
        if (this.d != null) {
            ax.L0.a.b((Context)this).f(this.d);
            this.d = null;
        }
    }
    
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        final b b = (b)this.getIntent().getParcelableExtra("com.pcloud.authentication.AuthorizationActivity.ARGUMENT_AUTH_REQUEST");
        final Uri uri = (Uri)intent.getParcelableExtra("AuthorizationActivity.EXTRA_URL");
        intent.putExtra("com.pcloud.authentication.AuthorizationActivity.ARGUMENT_AUTH_REQUEST", (Parcelable)b);
        this.setIntent(intent);
        if (b == null || uri == null) {
            String s;
            if (b == null) {
                s = "Missing intent extra ARGUMENT_AUTH_REQUEST";
            }
            else {
                s = "Missing intent extra EXTRA_REDIRECT_URL";
            }
            this.l(h.f0, s);
            return;
        }
        if ("AuthorizationActivity.REFRESH_ACTION".equals((Object)intent.getAction())) {
            intent = new Intent("CustomTabActivity.DESTROY_ACTION");
            ax.L0.a.b((Context)this).d(intent);
            this.k(uri.toString());
            return;
        }
        if ("CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION".equals((Object)intent.getAction())) {
            this.k(uri.toString());
        }
    }
    
    protected void onRestoreInstanceState(final Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            this.b.restoreState(bundle);
        }
    }
    
    protected void onResume() {
        super.onResume();
        if (this.f && ((View)this.b).getVisibility() != 0) {
            this.l(h.d0, null);
        }
        this.f = true;
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.saveState(bundle);
    }
}
