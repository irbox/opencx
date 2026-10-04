package com.box.androidsdk.content.auth;

import java.lang.ref.Reference;
import android.app.Dialog;
import java.lang.ref.WeakReference;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.content.DialogInterface$OnDismissListener;
import ax.I3.a;
import android.webkit.SslErrorHandler;
import android.widget.EditText;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.webkit.HttpAuthHandler;
import java.util.Formatter;
import android.graphics.Bitmap;
import ax.I3.d;
import android.app.AlertDialog$Builder;
import android.net.http.SslError;
import android.net.Uri;
import android.net.http.SslCertificate$DName;
import ax.I3.b;
import android.widget.TextView;
import android.view.ViewGroup;
import ax.I3.c;
import android.view.LayoutInflater;
import android.view.View;
import android.net.http.SslCertificate;
import android.text.format.DateFormat;
import java.util.Date;
import android.os.Looper;
import android.os.Handler;
import android.webkit.WebViewClient;
import android.view.KeyEvent;
import com.box.androidsdk.content.utils.SdkUtils;
import android.net.Uri$Builder;
import android.util.AttributeSet;
import android.content.Context;
import android.webkit.WebView;

public class OAuthWebView extends WebView
{
    private String a;
    private String b;
    
    public OAuthWebView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public void a(final Uri$Builder uri$Builder) {
        uri$Builder.appendQueryParameter("state", this.a = SdkUtils.i());
        this.loadUrl(uri$Builder.build().toString());
    }
    
    public void b(final String s, final String s2) {
        this.a(this.c(s, s2));
    }
    
    protected Uri$Builder c(String b, final String s) {
        final Uri$Builder uri$Builder = new Uri$Builder();
        uri$Builder.scheme("https");
        uri$Builder.authority("account.box.com");
        uri$Builder.appendPath("api");
        uri$Builder.appendPath("oauth2");
        uri$Builder.appendPath("authorize");
        uri$Builder.appendQueryParameter("response_type", "code");
        uri$Builder.appendQueryParameter("client_id", b);
        uri$Builder.appendQueryParameter("redirect_uri", s);
        b = this.b;
        if (b != null) {
            uri$Builder.appendQueryParameter("box_login", b);
        }
        return uri$Builder;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        final String url = this.getUrl();
        if (url != null && url.contains((CharSequence)"app.box.com")) {
            if (keyEvent.getKeyCode() == 20 && keyEvent.getAction() == 0) {
                this.dispatchKeyEvent(new KeyEvent(0, 61));
                return true;
            }
            if (keyEvent.getKeyCode() == 20 && keyEvent.getAction() == 1) {
                this.dispatchKeyEvent(new KeyEvent(1, 61));
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }
    
    public String getStateString() {
        return this.a;
    }
    
    public void setBoxAccountEmail(final String b) {
        this.b = b;
    }
    
    private static class InvalidUrlException extends Exception
    {
        private static final long serialVersionUID = 1L;
    }
    
    public static class WebViewException extends Exception
    {
        private final String mDescription;
        private final int mErrorCode;
        private final String mFailingUrl;
        
        public WebViewException(final int mErrorCode, final String mDescription, final String mFailingUrl) {
            this.mErrorCode = mErrorCode;
            this.mDescription = mDescription;
            this.mFailingUrl = mFailingUrl;
        }
        
        public String a() {
            return this.mDescription;
        }
        
        public int b() {
            return this.mErrorCode;
        }
    }
    
    public static class b
    {
        public int a;
        public String b;
        public WebViewException c;
        
        public b(final int a, final String b) {
            this.a = a;
            this.b = b;
        }
        
        public b(final WebViewException c) {
            this(2, null);
            this.c = c;
        }
    }
    
    public static class c extends WebViewClient
    {
        private boolean a;
        private f b;
        private String c;
        private d d;
        private g e;
        private Handler f;
        
        public c(final f b, final String c) {
            this.f = new Handler(Looper.getMainLooper());
            this.b = b;
            this.c = c;
        }
        
        private String d(final Context context, final Date date) {
            if (date == null) {
                return "";
            }
            return DateFormat.getDateFormat(context).format(date);
        }
        
        private View e(final Context context, final SslCertificate sslCertificate) {
            final View inflate = LayoutInflater.from(context).inflate(ax.I3.c.h, (ViewGroup)null);
            final SslCertificate$DName issuedTo = sslCertificate.getIssuedTo();
            if (issuedTo != null) {
                ((TextView)inflate.findViewById(ax.I3.b.p)).setText((CharSequence)issuedTo.getCName());
                ((TextView)inflate.findViewById(ax.I3.b.q)).setText((CharSequence)issuedTo.getOName());
                ((TextView)inflate.findViewById(ax.I3.b.r)).setText((CharSequence)issuedTo.getUName());
            }
            final SslCertificate$DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView)inflate.findViewById(ax.I3.b.g)).setText((CharSequence)issuedBy.getCName());
                ((TextView)inflate.findViewById(ax.I3.b.h)).setText((CharSequence)issuedBy.getOName());
                ((TextView)inflate.findViewById(ax.I3.b.i)).setText((CharSequence)issuedBy.getUName());
            }
            ((TextView)inflate.findViewById(ax.I3.b.k)).setText((CharSequence)this.d(context, sslCertificate.getValidNotBeforeDate()));
            ((TextView)inflate.findViewById(ax.I3.b.j)).setText((CharSequence)this.d(context, sslCertificate.getValidNotAfterDate()));
            return inflate;
        }
        
        private Uri f(final String s) {
            Uri parse;
            final Uri uri = parse = Uri.parse(s);
            if (!SdkUtils.l(this.c)) {
                final Uri parse2 = Uri.parse(this.c);
                if (parse2.getScheme() != null && parse2.getScheme().equals((Object)uri.getScheme())) {
                    parse = uri;
                    if (parse2.getAuthority().equals((Object)uri.getAuthority())) {
                        return parse;
                    }
                }
                parse = null;
            }
            return parse;
        }
        
        private String g(final Uri uri, final String s) throws InvalidUrlException {
            if (uri == null) {
                return null;
            }
            try {
                return uri.getQueryParameter(s);
            }
            catch (final Exception ex) {
                return null;
            }
        }
        
        public void h(final d d) {
            this.d = d;
        }
        
        protected void i(final Context context, final SslError sslError) {
            ((Dialog)new AlertDialog$Builder(context).setTitle(ax.I3.d.g).setView(this.e(context, sslError.getCertificate())).create()).show();
        }
        
        public void onPageFinished(final WebView webView, final String s) {
            final g e = this.e;
            if (e != null) {
                this.f.removeCallbacks((Runnable)e);
            }
            super.onPageFinished(webView, s);
            final d d = this.d;
            if (d != null) {
                d.d(webView, s);
            }
        }
        
        public void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) {
            try {
                final Uri f = this.f(s);
                final String g = this.g(f, "code");
                if (!SdkUtils.l(g) && webView instanceof OAuthWebView && !SdkUtils.l(((OAuthWebView)webView).getStateString()) && !((OAuthWebView)webView).getStateString().equals((Object)f.getQueryParameter("state"))) {
                    throw new InvalidUrlException();
                }
                if (!SdkUtils.l(this.g(f, "error"))) {
                    this.b.c(new b(0, null));
                }
                else if (!SdkUtils.l(g)) {
                    final String g2 = this.g(f, "base_domain");
                    if (g2 != null) {
                        this.b.a(g, g2);
                    }
                    else {
                        this.b.e(g);
                    }
                }
            }
            catch (final InvalidUrlException ex) {
                this.b.c(new b(1, null));
            }
            final g e = this.e;
            if (e != null) {
                this.f.removeCallbacks((Runnable)e);
            }
            final g e2 = new g(webView, s);
            this.e = e2;
            this.f.postDelayed((Runnable)e2, 30000L);
        }
        
        public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
            final g e = this.e;
            if (e != null) {
                this.f.removeCallbacks((Runnable)e);
            }
            if (this.b.c(new b(new WebViewException(n, s, s2)))) {
                return;
            }
            Label_0273: {
                if (n != -8) {
                    if (n != -6 && n != -2) {
                        break Label_0273;
                    }
                    if (!SdkUtils.m(((View)webView).getContext())) {
                        final String j = SdkUtils.j(((View)webView).getContext(), "offline.html");
                        final Formatter formatter = new Formatter();
                        formatter.format(j, new Object[] { ((View)webView).getContext().getString(ax.I3.d.r), ((View)webView).getContext().getString(ax.I3.d.s), ((View)webView).getContext().getString(ax.I3.d.t) });
                        webView.loadDataWithBaseURL((String)null, formatter.toString(), "text/html", "UTF-8", (String)null);
                        formatter.close();
                        break Label_0273;
                    }
                }
                final String i = SdkUtils.j(((View)webView).getContext(), "offline.html");
                final Formatter formatter2 = new Formatter();
                formatter2.format(i, new Object[] { ((View)webView).getContext().getString(ax.I3.d.C), ((View)webView).getContext().getString(ax.I3.d.D), ((View)webView).getContext().getString(ax.I3.d.E) });
                webView.loadDataWithBaseURL((String)null, formatter2.toString(), "text/html", "UTF-8", (String)null);
                formatter2.close();
            }
            super.onReceivedError(webView, n, s, s2);
        }
        
        public void onReceivedHttpAuthRequest(final WebView webView, final HttpAuthHandler httpAuthHandler, final String s, final String s2) {
            final View inflate = LayoutInflater.from(((View)webView).getContext()).inflate(ax.I3.c.c, (ViewGroup)null);
            ((Dialog)new AlertDialog$Builder(((View)webView).getContext()).setTitle(ax.I3.d.k).setView(inflate).setPositiveButton(ax.I3.d.j, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(this, inflate, httpAuthHandler) {
                final View a;
                final HttpAuthHandler b;
                final c c;
                
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    this.b.proceed(((EditText)this.a.findViewById(ax.I3.b.s)).getText().toString(), ((EditText)this.a.findViewById(ax.I3.b.o)).getText().toString());
                }
            }).setNegativeButton(ax.I3.d.i, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(this, httpAuthHandler) {
                final HttpAuthHandler a;
                final c b;
                
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    this.a.cancel();
                    this.b.b.c(new b(0, null));
                }
            }).create()).show();
        }
        
        public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            final g e = this.e;
            if (e != null) {
                this.f.removeCallbacks((Runnable)e);
            }
            final Resources resources = ((View)webView).getContext().getResources();
            final StringBuilder sb = new StringBuilder(resources.getString(ax.I3.d.h));
            sb.append(" ");
            final int primaryError = sslError.getPrimaryError();
            String s;
            if (primaryError != 0) {
                if (primaryError != 1) {
                    if (primaryError != 2) {
                        if (primaryError != 3) {
                            if (primaryError != 4) {
                                if (primaryError != 5) {
                                    s = resources.getString(ax.I3.d.y);
                                }
                                else {
                                    s = resources.getString(ax.I3.d.y);
                                }
                            }
                            else {
                                s = ((View)webView).getResources().getString(ax.I3.d.v);
                            }
                        }
                        else {
                            s = resources.getString(ax.I3.d.A);
                        }
                    }
                    else {
                        s = resources.getString(ax.I3.d.x);
                    }
                }
                else {
                    s = resources.getString(ax.I3.d.w);
                }
            }
            else {
                s = resources.getString(ax.I3.d.z);
            }
            sb.append(s);
            sb.append(" ");
            sb.append(resources.getString(ax.I3.d.B));
            this.a = false;
            final AlertDialog$Builder setNegativeButton = new AlertDialog$Builder(((View)webView).getContext()).setTitle(ax.I3.d.g).setMessage((CharSequence)sb.toString()).setIcon(ax.I3.a.a).setNegativeButton(ax.I3.d.e, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(this, sslErrorHandler) {
                final SslErrorHandler a;
                final c b;
                
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    this.b.a = true;
                    this.a.cancel();
                    this.b.b.c(new b(0, null));
                }
            });
            setNegativeButton.setNeutralButton(ax.I3.d.u, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(this, webView, sslError) {
                final WebView a;
                final SslError b;
                final c c;
                
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    this.c.i(((View)this.a).getContext(), this.b);
                }
            });
            final AlertDialog create = setNegativeButton.create();
            ((Dialog)create).setOnDismissListener((DialogInterface$OnDismissListener)new DialogInterface$OnDismissListener(this) {
                final c a;
                
                public void onDismiss(final DialogInterface dialogInterface) {
                    if (!this.a.a) {
                        this.a.b.c(new b(0, null));
                    }
                }
            });
            ((Dialog)create).show();
        }
        
        public interface f
        {
            void a(final String p0, final String p1);
            
            boolean c(final b p0);
            
            void e(final String p0);
        }
        
        class g implements Runnable
        {
            final WeakReference<WebView> c0;
            final c d0;
            final String q;
            
            public g(final c d0, final WebView webView, final String q) {
                this.d0 = d0;
                this.q = q;
                this.c0 = (WeakReference<WebView>)new WeakReference((Object)webView);
            }
            
            public void run() {
                this.d0.onReceivedError((WebView)((Reference)this.c0).get(), -8, "loading timed out", this.q);
            }
        }
    }
    
    public interface d
    {
        void d(final WebView p0, final String p1);
    }
}
