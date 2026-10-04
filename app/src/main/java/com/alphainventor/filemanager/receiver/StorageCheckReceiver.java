package com.alphainventor.filemanager.receiver;

import android.text.Html;
import ax.u3.B;
import ax.u3.o;
import ax.Q2.b;
import android.util.AndroidRuntimeException;
import ax.Q2.a;
import android.app.PendingIntent;
import ax.Ha.c;
import android.app.AlarmManager;
import java.util.Calendar;
import ax.u3.l;
import android.content.Intent;
import ax.t3.j;
import ax.s3.u;
import ax.c3.K;
import android.content.Context;
import android.content.BroadcastReceiver;

public class StorageCheckReceiver extends BroadcastReceiver
{
    public static void a(final Context context, final K k) {
        if (K.e.equals((Object)k)) {
            u.j(context).a(201);
            return;
        }
        if (K.f.equals((Object)k)) {
            u.j(context).a(202);
            return;
        }
        u.j(context).a(201);
        u.j(context).a(202);
    }
    
    public static void b(final Context context, final boolean b) {
        if (j.I(context)) {
            try {
                final Intent intent = new Intent(context, (Class)StorageCheckReceiver.class);
                intent.setAction("filemanager.intent.action.STORAGE_CHECK");
                final PendingIntent b2 = l.b(context, 200, intent, 0);
                final Calendar instance = Calendar.getInstance();
                final int value = instance.get(11);
                instance.set(11, 21);
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                long timeInMillis = instance.getTimeInMillis();
                if (21 - value <= 1) {
                    timeInMillis += 86400000L;
                }
                final AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
                alarmManager.cancel(b2);
                alarmManager.setInexactRepeating(1, timeInMillis, 86400000L, b2);
            }
            catch (final SecurityException | NullPointerException ex) {
                c.h().f().d("AlarmManager Error").l((Throwable)ex).h();
            }
        }
    }
    
    private static void c(final Context context, final CharSequence charSequence, final K k, final int n) {
        try {
            u.j(context).l(n, u.j(context).h(context, k, charSequence));
            a.i().m("notification", "storage_full_notified").c("loc", k.d().I()).e();
        }
        catch (final SecurityException | AndroidRuntimeException ex) {}
    }
    
    public void onReceive(final Context context, final Intent intent) {
        b.k(context);
        if (j.I(context)) {
            if (o.e(context)) {
                if (ax.Z2.j.F().n0(context)) {
                    final String string = context.getString(2131952168);
                    final float p2 = ax.Z2.j.F().P();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("<font color='red'>");
                    sb.append(B.P(p2));
                    sb.append("</font>");
                    c(context, (CharSequence)Html.fromHtml(context.getString(2131952632, new Object[] { string, sb.toString() })), K.e, 201);
                }
                if (ax.Z2.j.F().t0() && ax.Z2.j.F().u0(context)) {
                    final String string2 = context.getString(2131952181);
                    final float u = ax.Z2.j.F().U();
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("<font color='red'>");
                    sb2.append(B.P(u));
                    sb2.append("</font>");
                    c(context, (CharSequence)Html.fromHtml(context.getString(2131952632, new Object[] { string2, sb2.toString() })), K.f, 202);
                }
            }
        }
    }
}
