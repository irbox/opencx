package rikka.shizuku;

import android.database.Cursor;
import android.content.ContentValues;
import android.net.Uri;
import ax.oe.a;
import android.content.pm.ProviderInfo;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.os.IBinder;
import android.os.Parcelable;
import moe.shizuku.api.BinderContainer;
import ax.ne.i;
import android.os.Bundle;
import android.content.ContentProvider;

public class ShizukuProvider extends ContentProvider
{
    private static boolean a = false;
    private static boolean b = false;
    private static boolean c = true;
    
    private boolean a(final Bundle bundle) {
        final IBinder z = i.z();
        if (z != null && z.pingBinder()) {
            bundle.putParcelable("moe.shizuku.privileged.api.intent.extra.BINDER", (Parcelable)new BinderContainer(z));
            return true;
        }
        return false;
    }
    
    private void b(final Bundle bundle) {
        if (i.F()) {
            Log.d("ShizukuProvider", "sendBinder is called when already a living binder");
            return;
        }
        final BinderContainer binderContainer = (BinderContainer)bundle.getParcelable("moe.shizuku.privileged.api.intent.extra.BINDER");
        if (binderContainer != null && binderContainer.q != null) {
            Log.d("ShizukuProvider", "binder received");
            i.E(binderContainer.q, this.getContext().getPackageName());
            if (ShizukuProvider.a) {
                Log.d("ShizukuProvider", "broadcast binder");
                this.getContext().sendBroadcast(new Intent("moe.shizuku.api.action.BINDER_RECEIVED").putExtra("moe.shizuku.privileged.api.intent.extra.BINDER", (Parcelable)binderContainer).setPackage(this.getContext().getPackageName()));
            }
        }
    }
    
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.multiprocess) {
            throw new IllegalStateException("android:multiprocess must be false");
        }
        if (providerInfo.exported) {
            ShizukuProvider.b = true;
            return;
        }
        throw new IllegalStateException("android:exported must be true");
    }
    
    public Bundle call(final String s, final String s2, final Bundle bundle) {
        if (ax.oe.a.b()) {
            Log.w("ShizukuProvider", "Provider called when Sui is available. Are you using Shizuku and Sui at the same time?");
            return new Bundle();
        }
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(BinderContainer.class.getClassLoader());
        final Bundle bundle2 = new Bundle();
        s.getClass();
        if (!s.equals((Object)"sendBinder")) {
            if (s.equals((Object)"getBinder")) {
                if (!this.a(bundle2)) {
                    return null;
                }
            }
            return bundle2;
        }
        this.b(bundle);
        return bundle2;
    }
    
    public final int delete(final Uri uri, final String s, final String[] array) {
        return 0;
    }
    
    public final String getType(final Uri uri) {
        return null;
    }
    
    public final Uri insert(final Uri uri, final ContentValues contentValues) {
        return null;
    }
    
    public boolean onCreate() {
        if (ShizukuProvider.c && !ax.oe.a.b()) {
            final boolean a = ax.oe.a.a(this.getContext().getPackageName());
            final StringBuilder sb = new StringBuilder();
            sb.append("Initialize Sui: ");
            sb.append(a);
            Log.d("ShizukuProvider", sb.toString());
        }
        return true;
    }
    
    public final Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        return null;
    }
    
    public final int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        return 0;
    }
}
