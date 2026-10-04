package com.alphainventor.filemanager.activity;

import android.content.Context;
import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import ax.T.b;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.webkit.WebView;
import android.net.Uri;
import android.widget.ProgressBar;
import androidx.annotation.Keep;
import ax.R2.c;

@Keep
public class WebViewActivity extends ax.R2.c
{
    private String mDropboxKey;
    private ProgressBar mProgress;
    private Uri mUri;
    private WebView mWebView;
    
    private void setUpWebView() {
        ((View)this.mWebView).setVerticalScrollBarEnabled(false);
        ((View)this.mWebView).setHorizontalScrollBarEnabled(false);
        this.mWebView.setWebViewClient((WebViewClient)new c());
        this.mWebView.setWebChromeClient((WebChromeClient)new b());
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        while (true) {
            try {
                this.mWebView.loadUrl(this.mUri.toString());
                this.mWebView.getSettings().setSavePassword(false);
                this.mWebView.getSettings().setSaveFormData(false);
                ((View)this.mProgress).setVisibility(0);
            }
            catch (final SecurityException ex) {
                continue;
            }
            break;
        }
    }
    
    public boolean isContentClipToPadding(final boolean b) {
        return true;
    }
    
    public void onApplyWindowsInsets(final ax.T.b b, final boolean b2) {
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        ((ax.n.c)this).setContentView(2131558441);
        ((Activity)this).setTitle(2131952156);
        this.onSetContentView(true);
        if (((ax.n.c)this).getSupportActionBar() != null) {
            ((ax.n.c)this).getSupportActionBar().B(2131231111);
        }
        this.mWebView = (WebView)((ax.n.c)this).findViewById(2131363047);
        this.mProgress = (ProgressBar)((ax.n.c)this).findViewById(2131362714);
        final String action = ((Activity)this).getIntent().getAction();
        final Uri data = ((Activity)this).getIntent().getData();
        if ("android.intent.action.VIEW".equals((Object)action) && data != null) {
            this.mUri = data;
            this.mDropboxKey = ((Context)this).getString(2131951919);
            this.setUpWebView();
            ((View)this.mWebView).requestFocus();
            return;
        }
        ((Activity)this).finish();
    }
    
    private class b extends WebChromeClient
    {
        final WebViewActivity a;
        
        private b(final WebViewActivity a) {
            this.a = a;
        }
        
        public void onReceivedTitle(final WebView webView, final String s) {
            super.onReceivedTitle(webView, s);
        }
    }
    
    private class c extends WebViewClient
    {
        final WebViewActivity a;
        
        private c(final WebViewActivity a) {
            this.a = a;
        }
        
        public void onPageFinished(final WebView webView, final String s) {
            super.onPageFinished(webView, s);
            ((View)this.a.mProgress).setVisibility(8);
        }
        
        public void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) {
            super.onPageStarted(webView, s, bitmap);
        }
        
        public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
            super.onReceivedError(webView, n, s, s2);
        }
        
        public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
            if (s.startsWith(this.a.mDropboxKey)) {
                ((Context)this.a).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                ((Activity)this.a).finish();
                return true;
            }
            this.a.mWebView.loadUrl(s);
            return true;
        }
    }
}
