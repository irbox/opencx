package com.box.androidsdk.content.views;

import java.util.concurrent.FutureTask;
import java.lang.ref.Reference;
import com.box.androidsdk.content.models.BoxEntity;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.File;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.SdkUtils;
import ax.i.s;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import java.io.Serializable;
import android.view.View;
import android.content.res.TypedArray;
import ax.I3.b;
import android.view.ViewGroup;
import ax.I3.c;
import ax.I3.e;
import android.view.LayoutInflater;
import android.util.AttributeSet;
import android.content.Context;
import com.box.androidsdk.content.models.BoxDownload;
import ax.E3.h;
import java.lang.ref.WeakReference;
import android.widget.ImageView;
import android.widget.TextView;
import com.box.androidsdk.content.models.BoxCollaborator;
import android.widget.LinearLayout;

public class BoxAvatarView extends LinearLayout
{
    private BoxCollaborator a;
    private b b;
    private TextView c;
    private ImageView d;
    private WeakReference<h<BoxDownload>> e;
    
    public BoxAvatarView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public BoxAvatarView(final Context context, final AttributeSet set, int integer) {
        super(context, set, integer);
        final LayoutInflater from = LayoutInflater.from(context);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, ax.I3.e.e, integer, 0);
        final View inflate = from.inflate(ax.I3.c.d, (ViewGroup)this, true);
        this.c = (TextView)inflate.findViewById(ax.I3.b.e);
        integer = obtainStyledAttributes.getInteger(ax.I3.e.f, 0);
        if (integer != 0) {
            this.c.setTextSize(2, (float)integer);
        }
        this.d = (ImageView)inflate.findViewById(ax.I3.b.d);
    }
    
    public <T extends Serializable & b> void a(final BoxCollaborator a, final T t) {
        if (t != null) {
            this.b = t;
        }
        final BoxCollaborator a2 = this.a;
        if (a2 != null && a != null && TextUtils.equals((CharSequence)((BoxEntity)a2).G(), (CharSequence)((BoxEntity)a).G())) {
            return;
        }
        this.a = a;
        final WeakReference<h<BoxDownload>> e = this.e;
        while (true) {
            if (e == null || ((Reference)e).get() == null) {
                break Label_0076;
            }
            try {
                ((FutureTask)((Reference)this.e).get()).cancel(true);
                this.b();
            }
            catch (final Exception ex) {
                continue;
            }
            break;
        }
    }
    
    protected void b() {
        if (this.a != null) {
            if (this.b != null) {
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    ((View)this).post((Runnable)new Runnable(this) {
                        final BoxAvatarView q;
                        
                        public void run() {
                            this.q.b();
                        }
                    });
                    return;
                }
                final File a = this.b.a(((BoxEntity)this.a).G());
                if (a.exists()) {
                    this.d.setImageDrawable(Drawable.createFromPath(a.getAbsolutePath()));
                    this.d.setVisibility(0);
                    ((View)this.c).setVisibility(8);
                    return;
                }
                String s;
                if (ax.i.s.a((Object)this.a)) {
                    s = this.a.I();
                }
                else {
                    final String s2 = s = "";
                    if (SdkUtils.k("")) {
                        final BoxCollaborator a2 = this.a;
                        s = s2;
                        if (a2 instanceof BoxUser) {
                            s = ((BoxUser)a2).J();
                        }
                    }
                }
                int int1;
                try {
                    int1 = Integer.parseInt(s);
                }
                catch (final NumberFormatException ex) {
                    int1 = 0;
                }
                if (int1 == 0) {
                    SdkUtils.s(((View)this).getContext(), this.c, s);
                }
                else {
                    SdkUtils.o(((View)this).getContext(), this.c, int1);
                }
                this.d.setVisibility(8);
                ((View)this.c).setVisibility(0);
                this.e = (WeakReference<h<BoxDownload>>)new WeakReference((Object)this.b.b(((BoxEntity)this.a).G(), this));
            }
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            final Bundle bundle = (Bundle)parcelable;
            this.b = (b)bundle.getSerializable("extraAvatarController");
            this.a = (BoxCollaborator)bundle.getSerializable("extraUser");
            super.onRestoreInstanceState(bundle.getParcelable("extraParent"));
            if (this.a != null) {
                this.b();
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
    
    protected Parcelable onSaveInstanceState() {
        final Bundle bundle = new Bundle();
        bundle.putSerializable("extraAvatarController", (Serializable)this.b);
        bundle.putSerializable("extraUser", (Serializable)this.a);
        bundle.putParcelable("extraParent", super.onSaveInstanceState());
        return (Parcelable)bundle;
    }
    
    public interface b
    {
        File a(final String p0);
        
        h<BoxDownload> b(final String p0, final BoxAvatarView p1);
    }
}
