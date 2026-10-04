package com.alphainventor.filemanager.viewer;

import android.os.Message;
import android.os.SystemClock;
import ax.w3.c;
import ax.w3.b;
import android.os.Build$VERSION;
import android.view.ViewConfiguration;
import android.content.Context;
import android.view.MotionEvent;
import android.os.Handler;

public class a
{
    private int a;
    private float b;
    private final Handler c;
    private final b d;
    private boolean e;
    private boolean f;
    private boolean g;
    private MotionEvent h;
    private MotionEvent i;
    private MotionEvent j;
    private float k;
    private float l;
    private float m;
    private float n;
    private int o;
    private boolean p;
    
    public a(final Context context, final float n, final b b) {
        this(context, b, null, 0);
        this.o = (int)(ViewConfiguration.getLongPressTimeout() * n);
    }
    
    public a(final Context context, final b d, final Handler handler, final int n) {
        if (handler != null) {
            this.c = new a(handler);
        }
        else {
            this.c = new a();
        }
        this.d = d;
        this.f(context);
    }
    
    private void b() {
        this.c.removeMessages(2);
        this.e = false;
        this.g = false;
        this.f = false;
    }
    
    private void c() {
        this.c.removeMessages(2);
        this.g = false;
        this.f = false;
    }
    
    private void d() {
        this.f = true;
        this.d.a(this.h);
    }
    
    private int e() {
        return this.o;
    }
    
    private void f(final Context context) {
        if (this.d != null) {
            this.p = true;
            final ViewConfiguration value = ViewConfiguration.get(context);
            final int scaledTouchSlop = value.getScaledTouchSlop();
            final int sdk_INT = Build$VERSION.SDK_INT;
            if (sdk_INT >= 30) {
                this.b = ax.w3.b.a(value);
            }
            else if (sdk_INT >= 29) {
                this.b = ax.w3.c.a();
            }
            else {
                this.b = 1.0f;
            }
            this.a = scaledTouchSlop * scaledTouchSlop;
            return;
        }
        throw new NullPointerException("OnGestureListener must not be null");
    }
    
    public boolean g(MotionEvent j) {
        final int action = j.getAction();
        final MotionEvent i = this.i;
        if (i != null) {
            i.recycle();
        }
        this.i = MotionEvent.obtain(j);
        final int n = action & 0xFF;
        final int n2 = 1;
        final boolean b = n == 6;
        int actionIndex;
        if (b) {
            actionIndex = j.getActionIndex();
        }
        else {
            actionIndex = -1;
        }
        final int pointerCount = j.getPointerCount();
        float n3 = 0.0f;
        float n4 = 0.0f;
        for (int k = 0; k < pointerCount; ++k) {
            if (actionIndex != k) {
                n3 += j.getX(k);
                n4 += j.getY(k);
            }
        }
        int n5;
        if (b) {
            n5 = pointerCount - 1;
        }
        else {
            n5 = pointerCount;
        }
        final float n6 = (float)n5;
        final float l = n3 / n6;
        final float m = n4 / n6;
        if (n == 0) {
            this.k = l;
            this.m = l;
            this.l = m;
            this.n = m;
            final MotionEvent h = this.h;
            if (h != null) {
                h.recycle();
            }
            this.h = MotionEvent.obtain(j);
            this.g = true;
            this.e = true;
            return this.f = false;
        }
        if (n != 1) {
            if (n != 2) {
                if (n == 3) {
                    this.b();
                    return false;
                }
                if (n != 5) {
                    if (n == 6) {
                        this.k = l;
                        this.m = l;
                        this.l = m;
                        this.n = m;
                        if (pointerCount == 2) {
                            this.c();
                            return false;
                        }
                    }
                }
                else {
                    this.k = l;
                    this.m = l;
                    this.l = m;
                    this.n = m;
                    if (pointerCount != 2) {
                        this.c();
                        return false;
                    }
                    if (this.p) {
                        this.c.removeMessages(2);
                        j = this.h;
                        long n7;
                        int n8;
                        if (j != null) {
                            n7 = j.getDownTime();
                            n8 = this.e();
                        }
                        else {
                            n7 = SystemClock.uptimeMillis();
                            n8 = this.e();
                        }
                        final long n9 = n8;
                        final Handler c = this.c;
                        c.sendMessageAtTime(c.obtainMessage(2, 0, 0), n7 + n9);
                        return false;
                    }
                }
            }
            else if (!this.f) {
                if (this.g) {
                    final int n10 = (int)(l - this.m);
                    final int n11 = (int)(m - this.n);
                    final int n12 = n10 * n10 + n11 * n11;
                    int a;
                    final int n13 = a = this.a;
                    if (Build$VERSION.SDK_INT >= 29) {
                        final int a2 = ax.w3.a.a(j);
                        final boolean hasMessages = this.c.hasMessages(2);
                        int n14;
                        if (a2 == 1) {
                            n14 = n2;
                        }
                        else {
                            n14 = 0;
                        }
                        a = n13;
                        if (hasMessages) {
                            a = n13;
                            if (n14 != 0) {
                                if (n12 > n13) {
                                    this.c.removeMessages(2);
                                    final long n15 = this.e();
                                    final Handler c2 = this.c;
                                    c2.sendMessageAtTime(c2.obtainMessage(2, 0, 0), j.getDownTime() + (long)(n15 * this.b));
                                }
                                final float n16 = (float)n13;
                                final float b2 = this.b;
                                a = (int)(n16 * (b2 * b2));
                            }
                        }
                    }
                    if (n12 > a) {
                        this.k = l;
                        this.l = m;
                        this.g = false;
                        this.c.removeMessages(2);
                    }
                }
            }
            return false;
        }
        this.e = false;
        j = MotionEvent.obtain(j);
        if (this.f) {
            this.f = false;
        }
        final MotionEvent j2 = this.j;
        if (j2 != null) {
            j2.recycle();
        }
        this.j = j;
        this.c.removeMessages(2);
        return false;
    }
    
    private class a extends Handler
    {
        final com.alphainventor.filemanager.viewer.a a;
        
        a(final com.alphainventor.filemanager.viewer.a a) {
            this.a = a;
        }
        
        a(final com.alphainventor.filemanager.viewer.a a, final Handler handler) {
            this.a = a;
            super(handler.getLooper());
        }
        
        public void handleMessage(final Message message) {
            if (message.what == 2) {
                this.a.d();
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Unknown message ");
            sb.append((Object)message);
            throw new RuntimeException(sb.toString());
        }
    }
    
    public interface b
    {
        void a(final MotionEvent p0);
    }
}
