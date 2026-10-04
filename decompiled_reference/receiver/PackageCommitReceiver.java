package com.alphainventor.filemanager.receiver;

import ax.U2.f;
import ax.U2.d;
import ax.Ha.c;
import android.widget.Toast;
import android.content.ActivityNotFoundException;
import ax.c3.u;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class PackageCommitReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, Intent intent) {
        final int intExtra = intent.getIntExtra("android.content.pm.extra.STATUS", -9999);
        if (intExtra != -9999) {
            if (intExtra == -1) {
                Label_0088: {
                    try {
                        intent = (Intent)intent.getParcelableExtra("android.intent.extra.INTENT");
                        intent.addFlags(268435456);
                        u.o0(context, intent);
                        return;
                    }
                    catch (final Exception ex) {}
                    catch (final ActivityNotFoundException ex2) {
                        break Label_0088;
                    }
                    Toast.makeText(context, 2131951927, 1).show();
                    final Exception ex;
                    c.i(context).f().b("PACKAGE COMMIT RECEIVER ERROR").l((Throwable)ex).h();
                    return;
                }
                final ActivityNotFoundException ex2;
                ((Throwable)ex2).printStackTrace();
                Toast.makeText(context, 2131952448, 1).show();
            }
            else if (intExtra == 0) {
                final String stringExtra = intent.getStringExtra("android.content.pm.extra.PACKAGE_NAME");
                if (stringExtra != null) {
                    final f x = d.F(context).x(stringExtra);
                    if (x != null) {
                        Toast.makeText(context, (CharSequence)context.getString(2131952318, new Object[] { x.q() }), 1).show();
                        return;
                    }
                    Toast.makeText(context, (CharSequence)context.getString(2131952318, new Object[] { stringExtra }), 1).show();
                }
            }
            else if (intExtra != 3) {
                if (intExtra == 7) {
                    final String stringExtra2 = intent.getStringExtra("android.content.pm.extra.STATUS_MESSAGE");
                    String s = context.getString(2131951927);
                    if (stringExtra2 != null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(s);
                        sb.append(" (");
                        sb.append(stringExtra2);
                        sb.append(")");
                        s = sb.toString();
                    }
                    Toast.makeText(context, (CharSequence)s, 1).show();
                    return;
                }
                if (intExtra > 0) {
                    final String stringExtra3 = intent.getStringExtra("android.content.pm.extra.STATUS_MESSAGE");
                    String s2 = context.getString(2131951927);
                    if (stringExtra3 != null) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append(s2);
                        sb2.append(" (");
                        sb2.append(stringExtra3);
                        sb2.append(")");
                        s2 = sb2.toString();
                    }
                    Toast.makeText(context, (CharSequence)s2, 1).show();
                }
            }
        }
    }
}
