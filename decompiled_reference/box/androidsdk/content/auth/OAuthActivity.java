package com.box.androidsdk.content.auth;

import android.view.View;
import android.app.FragmentTransaction;
import android.webkit.WebViewClient;
import android.app.Fragment;
import android.app.ProgressDialog;
import ax.I3.b;
import ax.I3.c;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.ArrayList;
import android.content.pm.ResolveInfo;
import android.content.IntentFilter;
import ax.E3.g;
import android.os.Bundle;
import android.webkit.WebView;
import android.content.res.Resources;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.widget.Toast;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.BoxException;
import java.util.concurrent.ExecutionException;
import ax.I3.d;
import java.io.Serializable;
import java.io.File;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.box.androidsdk.content.utils.SdkUtils;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import com.box.androidsdk.content.models.BoxSession;
import android.app.Dialog;
import android.app.Activity;

public class OAuthActivity extends Activity implements a.b, f, d
{
    private static Dialog n;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    protected OAuthWebView g;
    protected c h;
    private boolean i;
    private int j;
    private BoxSession k;
    private AtomicBoolean l;
    private BroadcastReceiver m;
    
    public OAuthActivity() {
        this.i = false;
        this.j = 0;
        this.l = new AtomicBoolean(false);
        this.m = new BroadcastReceiver() {
            final OAuthActivity a;
            
            public void onReceive(final Context context, final Intent intent) {
                if (intent.getAction().equals((Object)"android.net.conn.CONNECTIVITY_CHANGE") && SdkUtils.m(context) && this.a.u()) {
                    this.a.y();
                }
            }
        };
    }
    
    private void i() {
        final OAuthWebView g = this.g;
        if (g != null) {
            g.clearCache(true);
            this.g.clearFormData();
            this.g.clearHistory();
        }
        CookieSyncManager.createInstance((Context)this);
        CookieManager.getInstance().removeAllCookie();
        ((Context)this).deleteDatabase("webview.db");
        ((Context)this).deleteDatabase("webviewCache.db");
        final File cacheDir = ((Context)this).getCacheDir();
        SdkUtils.g(cacheDir);
        cacheDir.mkdir();
    }
    
    public static Intent j(final Context context, final BoxSession boxSession, final boolean b) {
        final Intent k = k(context, boxSession.u(), boxSession.w(), boxSession.A(), b);
        k.putExtra("session", (Serializable)boxSession);
        if (!SdkUtils.l(boxSession.G())) {
            k.putExtra("restrictToUserId", boxSession.G());
        }
        return k;
    }
    
    public static Intent k(final Context context, final String s, final String s2, final String s3, final boolean b) {
        final Intent intent = new Intent(context, (Class)OAuthActivity.class);
        intent.putExtra("client_id", s);
        intent.putExtra("client_secret", s2);
        if (!SdkUtils.l(s3)) {
            intent.putExtra("redirect_uri", s3);
        }
        intent.putExtra("loginviaboxapp", b);
        return intent;
    }
    
    private OAuthWebView.b q(final Exception ex) {
        String s2;
        final String s = s2 = ((Context)this).getString(ax.I3.d.b);
        if (ex != null) {
            Object cause = ex;
            if (ex instanceof ExecutionException) {
                cause = ((Throwable)ex).getCause();
            }
            if (cause instanceof BoxException) {
                final BoxException ex2 = (BoxException)cause;
                final BoxError b = ex2.b();
                if (b != null) {
                    String s3;
                    if (ex2.e() != 403 && ex2.e() != 401 && (b.D() == null || !b.D().equals((Object)"unauthorized_device"))) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(s);
                        sb.append(":");
                        s3 = sb.toString();
                    }
                    else {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append(s);
                        sb2.append(":");
                        sb2.append((Object)((Context)this).getResources().getText(ax.I3.d.c));
                        sb2.append("\n");
                        s3 = sb2.toString();
                    }
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(s3);
                    sb3.append(b.E());
                    return new OAuthWebView.b(3, sb3.toString());
                }
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(s);
            sb4.append(":");
            sb4.append(cause);
            s2 = sb4.toString();
        }
        return new OAuthWebView.b(-1, s2);
    }
    
    public void a(final String s, final String s2) {
        if (this.j == 0) {
            ((View)this.g).setVisibility(4);
        }
        this.x(s, s2);
    }
    
    public void b(final BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        if (boxAuthenticationInfo != null) {
            BoxAuthentication.o().u(boxAuthenticationInfo, (Context)this);
            this.p(boxAuthenticationInfo);
        }
    }
    
    public boolean c(final OAuthWebView.b b) {
        if (b.a == 2) {
            if (b.c.b() == -6 || b.c.b() == -2 || b.c.b() == -8) {
                return false;
            }
            final Resources resources = ((Context)this).getResources();
            final String string = resources.getString(ax.I3.d.b);
            final String string2 = resources.getString(ax.I3.d.n);
            final StringBuilder sb = new StringBuilder();
            sb.append(b.c.b());
            sb.append(" ");
            sb.append(b.c.a());
            Toast.makeText((Context)this, (CharSequence)String.format("%s\n%s: %s", new Object[] { string, string2, sb.toString() }), 1).show();
        }
        else if (SdkUtils.l(b.b)) {
            Toast.makeText((Context)this, ax.I3.d.b, 1).show();
        }
        else {
            final int a = b.a;
            if (a != 1) {
                if (a == 3) {
                    ((Dialog)new AlertDialog$Builder((Context)this).setTitle(ax.I3.d.b).setMessage(ax.I3.d.c).setPositiveButton(ax.I3.d.m, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(this) {
                        final OAuthActivity a;
                        
                        public void onClick(final DialogInterface dialogInterface, final int n) {
                            dialogInterface.dismiss();
                            this.a.finish();
                        }
                    }).create()).show();
                    return true;
                }
                Toast.makeText((Context)this, ax.I3.d.b, 1).show();
            }
            else {
                final Resources resources2 = ((Context)this).getResources();
                Toast.makeText((Context)this, (CharSequence)String.format("%s\n%s: %s", new Object[] { resources2.getString(ax.I3.d.b), resources2.getString(ax.I3.d.n), resources2.getString(ax.I3.d.d) }), 1).show();
            }
        }
        this.finish();
        return true;
    }
    
    public void d(final WebView webView, final String s) {
        this.n();
    }
    
    public void e(final String s) {
        this.a(s, null);
    }
    
    public void f() {
        if (this.getFragmentManager().findFragmentByTag("choose_auth") != null) {
            this.getFragmentManager().popBackStack();
        }
    }
    
    public void finish() {
        this.i();
        if (!this.i) {
            BoxAuthentication.o().v(null, null);
        }
        super.finish();
    }
    
    protected OAuthWebView l() {
        final OAuthWebView oAuthWebView = (OAuthWebView)this.findViewById(this.t());
        ((View)oAuthWebView).setVisibility(0);
        oAuthWebView.getSettings().setJavaScriptEnabled(true);
        oAuthWebView.getSettings().setDomStorageEnabled(true);
        oAuthWebView.getSettings().setSaveFormData(false);
        oAuthWebView.getSettings().setSavePassword(false);
        return oAuthWebView;
    }
    
    protected c m() {
        return new OAuthWebView.c((OAuthWebView.c.f)this, this.e);
    }
    
    protected void n() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: dup            
        //     2: astore_3       
        //     3: monitorenter   
        //     4: getstatic       com/box/androidsdk/content/auth/OAuthActivity.n:Landroid/app/Dialog;
        //     7: astore_2       
        //     8: aload_2        
        //     9: ifnull          41
        //    12: aload_2        
        //    13: invokevirtual   android/app/Dialog.isShowing:()Z
        //    16: istore_1       
        //    17: iload_1        
        //    18: ifeq            41
        //    21: getstatic       com/box/androidsdk/content/auth/OAuthActivity.n:Landroid/app/Dialog;
        //    24: invokevirtual   android/app/Dialog.dismiss:()V
        //    27: goto            34
        //    30: astore_2       
        //    31: goto            54
        //    34: aconst_null    
        //    35: putstatic       com/box/androidsdk/content/auth/OAuthActivity.n:Landroid/app/Dialog;
        //    38: goto            51
        //    41: getstatic       com/box/androidsdk/content/auth/OAuthActivity.n:Landroid/app/Dialog;
        //    44: ifnull          51
        //    47: aconst_null    
        //    48: putstatic       com/box/androidsdk/content/auth/OAuthActivity.n:Landroid/app/Dialog;
        //    51: aload_3        
        //    52: monitorexit    
        //    53: return         
        //    54: aload_3        
        //    55: monitorexit    
        //    56: aload_2        
        //    57: athrow         
        //    58: astore_2       
        //    59: goto            34
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  4      8      30     58     Any
        //  12     17     30     58     Any
        //  21     27     58     62     Ljava/lang/IllegalArgumentException;
        //  21     27     30     58     Any
        //  34     38     30     58     Any
        //  41     51     30     58     Any
        //  54     56     30     58     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0034:
        //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
        //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
        //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
        //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
        //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
        //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
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
    
    protected void o(final Exception ex) {
        this.runOnUiThread((Runnable)new Runnable(this, this.q(ex)) {
            final OAuthActivity c0;
            final OAuthWebView.b q;
            
            public void run() {
                this.c0.n();
                this.c0.c(this.q);
                this.c0.setResult(0);
            }
        });
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        if (-1 == n2 && 1 == n) {
            final String stringExtra = intent.getStringExtra("userId");
            final String stringExtra2 = intent.getStringExtra("authcode");
            if (SdkUtils.k(stringExtra2) && !SdkUtils.k(stringExtra)) {
                final BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = (BoxAuthentication.BoxAuthenticationInfo)BoxAuthentication.o().r((Context)this).get((Object)stringExtra);
                if (boxAuthenticationInfo != null) {
                    this.b(boxAuthenticationInfo);
                    return;
                }
                this.c(new OAuthWebView.b(0, ""));
            }
            else if (!SdkUtils.k(stringExtra2)) {
                this.x(stringExtra2, null);
            }
        }
        else if (n2 == 0) {
            this.finish();
        }
    }
    
    public void onBackPressed() {
        if (this.getFragmentManager().findFragmentByTag("choose_auth") != null) {
            this.finish();
            return;
        }
        super.onBackPressed();
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = this.getIntent();
        if (ax.E3.g.k) {
            this.getWindow().addFlags(8192);
        }
        this.setContentView(this.s());
        ((Context)this).registerReceiver(this.m, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.a = intent.getStringExtra("client_id");
        this.b = intent.getStringExtra("client_secret");
        this.c = intent.getStringExtra("box_device_id");
        this.d = intent.getStringExtra("box_device_name");
        this.e = intent.getStringExtra("redirect_uri");
        this.j = (intent.getBooleanExtra("loginviaboxapp", false) ? 1 : 0);
        this.l.getAndSet(false);
        this.k = (BoxSession)intent.getSerializableExtra("session");
        if (bundle != null) {
            this.f = bundle.getBoolean("loggingInViaBoxApp");
        }
        final BoxSession k = this.k;
        if (k != null) {
            k.M(((Context)this).getApplicationContext());
            return;
        }
        (this.k = new BoxSession((Context)this, null, this.a, this.b, this.e)).P(this.c);
        this.k.Q(this.d);
    }
    
    public void onDestroy() {
        ((Context)this).unregisterReceiver(this.m);
        this.l.set(false);
        this.n();
        super.onDestroy();
    }
    
    protected void onResume() {
        super.onResume();
        if (this.u()) {
            this.y();
        }
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        bundle.putBoolean("loggingInViaBoxApp", this.f);
        super.onSaveInstanceState(bundle);
    }
    
    protected void p(final BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        this.runOnUiThread((Runnable)new Runnable(this, boxAuthenticationInfo) {
            final OAuthActivity c0;
            final BoxAuthentication.BoxAuthenticationInfo q;
            
            public void run() {
                this.c0.n();
                final Intent intent = new Intent();
                intent.putExtra("authinfo", (Serializable)this.q);
                this.c0.setResult(-1, intent);
                this.c0.i = true;
                this.c0.finish();
            }
        });
    }
    
    protected Intent r() {
        final Intent intent = new Intent("com.box.android.action.AUTHENTICATE_VIA_BOX_APP");
        final List queryIntentActivities = ((Context)this).getPackageManager().queryIntentActivities(intent, 65600);
        if (queryIntentActivities != null) {
            if (queryIntentActivities.size() >= 1) {
                final String string = ((Context)this).getResources().getString(ax.I3.d.l);
                for (final ResolveInfo resolveInfo : queryIntentActivities) {
                    ArrayList list;
                    try {
                        if (!string.equals((Object)((Context)this).getPackageManager().getPackageInfo(resolveInfo.activityInfo.packageName, 64).signatures[0].toCharsString())) {
                            continue;
                        }
                        intent.setPackage(resolveInfo.activityInfo.packageName);
                        final Map<String, BoxAuthentication.BoxAuthenticationInfo> r = BoxAuthentication.o().r((Context)this);
                        if (r == null || r.size() <= 0) {
                            return intent;
                        }
                        list = new ArrayList(r.size());
                        for (final Map$Entry map$Entry : r.entrySet()) {
                            if (((BoxAuthentication.BoxAuthenticationInfo)map$Entry.getValue()).K() != null) {
                                list.add((Object)((BoxAuthentication.BoxAuthenticationInfo)map$Entry.getValue()).K().A());
                            }
                        }
                    }
                    catch (final Exception ex) {
                        continue;
                    }
                    if (list.size() > 0) {
                        intent.putStringArrayListExtra("boxusers", list);
                    }
                    return intent;
                }
            }
        }
        return null;
    }
    
    protected int s() {
        return ax.I3.c.b;
    }
    
    protected int t() {
        return ax.I3.b.m;
    }
    
    boolean u() {
        if (this.f) {
            return false;
        }
        final OAuthWebView g = this.g;
        return g == null || g.getUrl() == null || !this.g.getUrl().startsWith("http");
    }
    
    protected Dialog v() {
        return (Dialog)ProgressDialog.show((Context)this, ((Context)this).getText(ax.I3.d.a), ((Context)this).getText(ax.I3.d.f));
    }
    
    protected void w() {
        monitorenter(this);
        try {
            Label_0035: {
                try {
                    final Dialog n = OAuthActivity.n;
                    if (n == null) {
                        break Label_0035;
                    }
                    if (n.isShowing()) {
                        monitorexit(this);
                        return;
                    }
                    break Label_0035;
                }
                finally {
                    monitorexit(this);
                    OAuthActivity.n = this.v();
                    monitorexit(this);
                }
            }
        }
        catch (final Exception ex) {}
    }
    
    protected void x(final String s, final String s2) {
        if (this.l.getAndSet(true)) {
            return;
        }
        this.w();
        if (s2 != null) {
            this.k.r().O(s2);
            ax.H3.b.f("setting Base Domain", s2, (Throwable)new RuntimeException("base domain being used"));
        }
        new Thread(this, s) {
            final OAuthActivity c0;
            final String q;
            
            public void run() {
                Label_0131: {
                    BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo;
                    try {
                        boxAuthenticationInfo = (BoxAuthentication.BoxAuthenticationInfo)BoxAuthentication.o().h(this.c0.k, this.q).get();
                        final String stringExtra = this.c0.getIntent().getStringExtra("restrictToUserId");
                        if (!SdkUtils.l(stringExtra)) {
                            if (!boxAuthenticationInfo.K().G().equals((Object)stringExtra)) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Unexpected user logged in. Expected ");
                                sb.append(stringExtra);
                                sb.append(" received ");
                                sb.append(boxAuthenticationInfo.K().G());
                                throw new RuntimeException(sb.toString());
                            }
                        }
                    }
                    catch (final Exception ex) {
                        break Label_0131;
                    }
                    this.c0.p(boxAuthenticationInfo);
                    return;
                }
                final Exception ex;
                ((Throwable)ex).printStackTrace();
                this.c0.o(ex);
            }
        }.start();
    }
    
    protected void y() {
        if (this.j != 1 && !this.getIntent().getBooleanExtra("disableAccountChoosing", false) && this.getFragmentManager().findFragmentByTag("choose_auth") == null) {
            final Map<String, BoxAuthentication.BoxAuthenticationInfo> r = BoxAuthentication.o().r((Context)this);
            if (SdkUtils.l(this.getIntent().getStringExtra("restrictToUserId")) && r != null && r.size() > 0) {
                final FragmentTransaction beginTransaction = this.getFragmentManager().beginTransaction();
                beginTransaction.replace(ax.I3.b.l, (Fragment)com.box.androidsdk.content.auth.a.a((Context)this), "choose_auth");
                beginTransaction.addToBackStack("choose_auth");
                beginTransaction.commit();
            }
        }
        final int j = this.j;
        if (j != 0) {
            if (j != 1) {
                return;
            }
            final Intent r2 = this.r();
            if (r2 != null) {
                r2.putExtra("client_id", this.a);
                r2.putExtra("redirect_uri", this.e);
                if (!SdkUtils.l(this.getIntent().getStringExtra("restrictToUserId"))) {
                    r2.putExtra("restrictToUserId", this.getIntent().getStringExtra("restrictToUserId"));
                }
                this.f = true;
                this.startActivityForResult(r2, 1);
                return;
            }
        }
        this.w();
        this.g = this.l();
        (this.h = this.m()).h(this);
        this.g.setWebViewClient((WebViewClient)this.h);
        if (this.k.s() != null) {
            this.g.setBoxAccountEmail(this.k.s());
        }
        this.g.b(this.a, this.e);
    }
}
