package com.alphainventor.filemanager.activity;

import ax.Q2.f;
import ax.Q2.d;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import ax.Q2.a;
import ax.u3.b;
import ax.c3.d0;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import ax.c3.k;
import ax.d3.E;
import ax.Z2.c$a;
import ax.c3.A;
import ax.t3.j;
import ax.c3.w;
import ax.c3.u;
import com.alphainventor.filemanager.file.n;
import android.content.Context;
import ax.a3.Q;
import com.alphainventor.filemanager.file.y;
import com.alphainventor.filemanager.bookmark.Bookmark;
import android.net.Uri;
import ax.d3.M;
import ax.n.c;

public class ShortcutActivity extends c
{
    M a;
    
    private void F(final Uri uri, final Bookmark bookmark) {
        try {
            final y i0 = y.I0(bookmark.w());
            Intent intent = Q.A3((Context)this, (n)i0);
            Label_0204: {
                if (intent != null && u.S(intent)) {
                    intent = w.d((Context)this, (n)i0, false);
                }
                else {
                    if (intent == null || !u.T(intent)) {
                        if (intent != null) {
                            break Label_0204;
                        }
                        if (j.C((Context)this) && A.B((n)i0, false)) {
                            intent = w.d((Context)this, (n)i0, false);
                            break Label_0204;
                        }
                        if (j.F((Context)this) && A.E((n)i0) && !Q.K3((Context)this, c$a.c0, (n)i0, false)) {
                            intent = w.i((Context)this, (n)i0, -1, false);
                            break Label_0204;
                        }
                        if (!j.D((Context)this) || !A.C((n)i0) || Q.J3((Context)this, (n)i0, false)) {
                            if (j.E((Context)this) && A.D((n)i0)) {
                                intent = w.g((Context)this, (n)null, i0);
                                break Label_0204;
                            }
                            if (!E.X7((Context)this, (n)i0)) {
                                this.a.P2(true);
                                this.a.O2(c$a.c0, (k)i0, i0.s(), false, true);
                                return;
                            }
                        }
                    }
                    intent = null;
                }
            }
            if (intent != null && !u.a0(intent)) {
                this.I(intent, 0, ((n)i0).A());
                ((Activity)this).finish();
                return;
            }
            this.H(uri);
        }
        catch (final ax.b3.j j) {
            Toast.makeText((Context)this, 2131951934, 1).show();
            ((Throwable)j).printStackTrace();
            ((Activity)this).finish();
        }
    }
    
    private void H(final Uri uri) {
        u.d0((Context)this, uri);
        ((Activity)this).finish();
    }
    
    private void I(final Intent intent, final int n, String s) {
        String s2;
        if (w.m((Activity)this, intent, n, false)) {
            s2 = "success";
        }
        else {
            s2 = "failure";
        }
        Label_0109: {
            if (s == null) {
                if (intent.getData() != null) {
                    s = d0.j(d0.h(intent.getData().getPath()));
                }
                else {
                    if ("com.filemanager.plugin.action.LAUNCH_FILE_URI".equals((Object)intent.getAction()) && intent.hasExtra("com.filemanager.plugin.extra.DATA")) {
                        final String stringExtra = intent.getStringExtra("com.filemanager.plugin.extra.DATA");
                        if (stringExtra != null) {
                            s = d0.j(d0.h(Uri.parse(stringExtra).getPath()));
                            break Label_0109;
                        }
                    }
                    else {
                        b.g("What case is this?");
                    }
                    s = "";
                }
            }
        }
        ax.Q2.a.i().m("command", "file_open").c("loc", "ShortCut").c("ext", s).c("result", s2).e();
    }
    
    protected void onCreate(final Bundle bundle) {
        ax.Q2.b.f((Context)this, true);
        super.onCreate(bundle);
        final Intent intent = ((Activity)this).getIntent();
        if (!"com.alphainventor.filemanager.OPEN_SHORTCUT".equals((Object)intent.getAction())) {
            Toast.makeText((Context)this, 2131951927, 1).show();
            ((Activity)this).finish();
            return;
        }
        if ((this.a = (M)((androidx.fragment.app.f)this).getSupportFragmentManager().k0("headless_fragment")) == null) {
            this.a = M.K2("Shortcut");
            ((androidx.fragment.app.f)this).getSupportFragmentManager().o().e((Fragment)this.a, "headless_fragment").i();
        }
        Boolean value;
        if (intent.hasExtra("IS_DIRECTORY")) {
            value = intent.getBooleanExtra("IS_DIRECTORY", false);
        }
        else {
            value = null;
        }
        final Uri data = intent.getData();
        final Bookmark c = Bookmark.c((Context)this, data);
        if (c == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("shortcut error:");
            sb.append((Object)data);
            d.c("shotcuturinull", (Throwable)new Exception(sb.toString()));
            Toast.makeText((Context)this, 2131951927, 1).show();
            ((Activity)this).finish();
            return;
        }
        if (value != null && !value && f.A0(c.s())) {
            this.F(intent.getData(), c);
            return;
        }
        this.H(intent.getData());
    }
}
