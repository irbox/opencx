package com.dropbox.core.android;

import android.content.Intent;
import android.app.Activity;
import ax.w4.f;
import java.util.Arrays;
import ax.Gb.l;
import ax.p4.q;
import java.util.Collection;
import ax.p4.k;
import ax.p4.z;
import ax.p4.m;
import android.content.Context;
import ax.Gb.g;

public final class a
{
    public static final a a;
    
    static {
        a = new a(null);
    }
    
    public static final a a() {
        return com.dropbox.core.android.a.a.a();
    }
    
    public static final void b(final Context context, final String s, final m m) {
        com.dropbox.core.android.a.a.c(context, s, m);
    }
    
    public static final class a
    {
        private a() {
        }
        
        private final void b(final Context context, final String s, final String s2, final String[] array, final String s3, final String s4, final z z, final m m, final k k, final Collection<String> collection, final q q) {
            final AuthActivity.b c = AuthActivity.c;
            l.c((Object)s);
            if (!c.c(context, s, true)) {
                return;
            }
            if (array != null && Arrays.asList(Arrays.copyOf((Object[])array, array.length)).contains((Object)s2)) {
                throw new IllegalArgumentException("desiredUid cannot be present in alreadyAuthedUids");
            }
            String e;
            if (collection != null) {
                e = f.e((Collection)collection, " ");
            }
            else {
                e = null;
            }
            final Intent f = c.f(context, s, s2, array, s3, s4, "1", z, m, k, e, q);
            if (!(context instanceof Activity)) {
                f.addFlags(268435456);
            }
            context.startActivity(f);
        }
        
        public static /* synthetic */ void f(final a a, final Context context, final String s, final m m, Collection collection, final int n, final Object o) {
            if ((n & 0x8) != 0x0) {
                collection = null;
            }
            a.e(context, s, m, (Collection<String>)collection);
        }
        
        public final ax.u4.a a() {
            final Intent g = AuthActivity.g;
            Long value = null;
            if (g == null) {
                return null;
            }
            final String stringExtra = g.getStringExtra("ACCESS_TOKEN");
            final String stringExtra2 = g.getStringExtra("ACCESS_SECRET");
            final String stringExtra3 = g.getStringExtra("UID");
            if (stringExtra != null && !l.a((Object)"", (Object)stringExtra) && stringExtra2 != null && !l.a((Object)"", (Object)stringExtra2) && stringExtra3 != null && !l.a((Object)"", (Object)stringExtra3)) {
                final String stringExtra4 = g.getStringExtra("CONSUMER_KEY");
                final String stringExtra5 = g.getStringExtra("REFRESH_TOKEN");
                final long longExtra = g.getLongExtra("EXPIRES_AT", -1L);
                if (longExtra >= 0L) {
                    value = longExtra;
                }
                return new ax.u4.a(stringExtra2, value, stringExtra5, stringExtra4);
            }
            return null;
        }
        
        public final void c(final Context context, final String s, final m m) {
            l.f((Object)context, "context");
            f(this, context, s, m, null, 8, null);
        }
        
        public final void d(final Context context, final String s, final m m, final k k, final Collection<String> collection) {
            l.f((Object)context, "context");
            if (m != null) {
                this.b(context, s, null, null, null, null, z.d0, m, k, collection, null);
                return;
            }
            throw new IllegalArgumentException("Invalid Dbx requestConfig for PKCE flow.");
        }
        
        public final void e(final Context context, final String s, final m m, final Collection<String> collection) {
            l.f((Object)context, "context");
            this.d(context, s, m, null, collection);
        }
    }
}
