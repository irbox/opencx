package com.alphainventor.filemanager.service;

import android.app.Activity;
import android.os.Binder;
import ax.u3.C;
import java.util.List;
import java.util.Iterator;
import ax.d3.n;
import ax.W2.j$d;
import java.util.Collection;
import android.os.SystemClock;
import ax.a3.y;
import ax.c3.K;
import android.app.Notification;
import ax.Q2.d;
import ax.u3.b;
import android.content.ComponentName;
import android.content.ServiceConnection;
import ax.W2.h$c;
import ax.W2.h;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import ax.X2.Q;
import android.content.Context;
import ax.c3.u;
import com.alphainventor.filemanager.activity.MainActivity;
import ax.Ha.c;
import androidx.fragment.app.e;
import ax.u3.B;
import ax.R2.a;
import android.os.Looper;
import ax.Q2.g;
import android.os.Handler;
import ax.u3.D;
import android.os.IBinder;
import java.util.ArrayList;
import com.alphainventor.filemanager.activity.FileProgressActivity;
import ax.W2.j;
import java.util.HashMap;
import java.util.logging.Logger;
import android.app.Service;

public class CommandService extends Service
{
    private static final Logger s;
    private static long t;
    private static long u;
    private static CommandService v;
    private HashMap<j, c> a;
    private FileProgressActivity b;
    private ArrayList<j> c;
    private ArrayList<j> d;
    private final IBinder e;
    private int f;
    private long g;
    private final Object h;
    private Thread i;
    private D j;
    private boolean k;
    private boolean l;
    private boolean m;
    private long n;
    private boolean o;
    private Runnable p;
    private long q;
    private Handler r;
    
    static {
        s = g.a((Class)CommandService.class);
    }
    
    public CommandService() {
        this.e = (IBinder)new d();
        this.h = new Object();
        this.r = new Handler(Looper.getMainLooper());
    }
    
    private void L(a a, final j j, final ax.a3.j i) {
        final c c = (c)this.a.get((Object)j);
        if (c != null) {
            if (a == null) {
                a = (a)this.b;
                if (a == null) {
                    if (c.a() != null) {
                        a = c.a();
                    }
                    else {
                        a = null;
                    }
                }
            }
            Label_0224: {
                Label_0105: {
                    if (a != null) {
                        Label_0206: {
                            try {
                                if (!a.n()) {
                                    final FragmentManager supportFragmentManager = ((f)a.s()).getSupportFragmentManager();
                                    if (!supportFragmentManager.I0()) {
                                        B.d0(supportFragmentManager, (e)i, "CommandDialog", true);
                                        return;
                                    }
                                }
                            }
                            catch (final IllegalStateException ex) {
                                break Label_0206;
                            }
                            break Label_0105;
                        }
                        final IllegalStateException ex;
                        ax.Ha.c.h().f().d("STARTOP2").l((Throwable)ex).h();
                        break Label_0224;
                    }
                }
                if (a != null && a.n() && a.s() instanceof MainActivity && !((f)a.s()).getSupportFragmentManager().I0()) {
                    c.e(i);
                    this.d.add((Object)j);
                    ((Context)this).startActivity(ax.c3.u.D((Context)this, true));
                    if (Q.M()) {
                        ax.s3.u.j((Context)this).l(102, ax.s3.u.j((Context)this).b((Service)this, i.j3((Context)this), i.i3((Context)this), true));
                    }
                    return;
                }
            }
            c.e(i);
            this.d.add((Object)j);
            final Intent t = ax.c3.u.t((Context)this);
            try {
                ((Context)this).startActivity(t);
            }
            catch (final Exception ex2) {
                ax.Ha.c.h().f().b("COMMAND SERVICE FILE PROGRESS").l((Throwable)ex2).h();
            }
            if (Q.M()) {
                ax.s3.u.j((Context)this).l(102, ax.s3.u.j((Context)this).b((Service)this, i.j3((Context)this), i.i3((Context)this), false));
            }
        }
    }
    
    public static void M(final f f, final Fragment fragment, final h h, final boolean b, final boolean b2) throws ax.b3.c {
        if (h.g() == h$c.c0) {
            final j a = h.a();
            final Intent l = l((Context)f, h);
            Label_0092: {
                try {
                    B.f0((Context)f, l, true, b2);
                    final CommandService q = q();
                    if (q != null) {
                        q.F(a.p());
                    }
                }
                catch (final SecurityException ex) {
                    break Label_0092;
                }
                catch (final IllegalStateException ex) {
                    break Label_0092;
                }
                ((Context)f).bindService(j((Context)f, true), (ServiceConnection)new ServiceConnection(a, f, fragment, b) {
                    final f c0;
                    final Fragment d0;
                    final boolean e0;
                    final j q;
                    
                    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
                        if (binder instanceof d) {
                            final CommandService a = ((d)binder).a();
                            if (!a.w()) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("cmd:");
                                sb.append(this.q.getClass().getName());
                                sb.append(",");
                                sb.append(this.q.p());
                                sb.append(",");
                                sb.append(a.s());
                                final String string = sb.toString();
                                ax.Ha.c.h().f().b("COMMAND SERVICE IS NOT STARTED").g((Object)string).h();
                                ax.u3.b.g(string);
                            }
                            a.N(this.c0, this.d0, this.q, this.e0);
                            ((Context)this.c0).unbindService((ServiceConnection)this);
                            return;
                        }
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Invalid service binder:");
                        sb2.append(binder.getClass().getName());
                        ax.Q2.d.c("commandconnected", (Throwable)new Exception(sb2.toString()));
                    }
                    
                    public void onServiceDisconnected(final ComponentName componentName) {
                    }
                }, 1);
                return;
            }
            final SecurityException ex;
            if (!(h instanceof ax.W2.B)) {
                final ax.Ha.b i = ax.Ha.c.i((Context)f).f().b("START COMMAND SERVICE FOREGROUND").l((Throwable)ex);
                final StringBuilder sb = new StringBuilder();
                sb.append("command:");
                sb.append(h.getClass().getName());
                i.g((Object)sb.toString()).h();
            }
            throw new ax.b3.c((Throwable)ex);
        }
        final ax.Ha.b j = ax.Ha.c.h().b("INFO NOT FILLED!!!").j();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(h.getClass().getName());
        sb2.append(" : ");
        sb2.append(((Enum)h.g()).name());
        j.g((Object)sb2.toString()).h();
        throw new ax.b3.c("Command is not filled");
    }
    
    private void O() {
        final int n = 0;
        final ArrayList<j> c = this.c;
        if (c != null && c.size() > 0) {
            final String string = ((Context)this).getResources().getString(2131952555, new Object[] { this.c.size() });
            final Object h;
            monitorenter(h = this.h);
            Label_0141: {
                try {
                    final ArrayList<j> c2 = this.c;
                    final int size = c2.size();
                    long n2 = 0L;
                    long n3 = 0L;
                    Object value;
                    j j;
                    for (int i = 0; i < size; ++i, j = (j)value, n2 += j.w().u(), n3 += j.w().t()) {
                        value = c2.get(i);
                    }
                    break Label_0141;
                }
                finally {
                    monitorexit(h);
                    int n4 = 0;
                    Label_0156: {
                        final long n2;
                        final long n3;
                        n4 = (int)(n3 * 100L / n2);
                    }
                    Label_0167: {
                        break Label_0167;
                        monitorexit(h);
                        final long n2;
                        iftrue(Label_0156:)(n2 != 0L);
                        n4 = n;
                    }
                    final Notification k = this.k(string, n4, true);
                    try {
                        ax.s3.u.j(((Context)this).getApplicationContext()).l(100, k);
                    }
                    catch (final NullPointerException ex) {
                        ax.Q2.d.c("update_service_noti", (Throwable)ex);
                    }
                }
            }
        }
    }
    
    private void g() {
        ax.s3.u.j(((Context)this).getApplicationContext()).a(100);
        this.g = 0L;
    }
    
    public static Intent j(final Context context, final boolean b) {
        final Intent intent = new Intent(context, (Class)CommandService.class);
        if (b) {
            intent.setAction("action.start_command");
        }
        return intent;
    }
    
    private Notification k(final String s, final int n, final boolean b) {
        return ax.s3.u.j(((Context)this).getApplicationContext()).c((Service)this, (CharSequence)s, n, b);
    }
    
    public static Intent l(final Context context, final h h) {
        final Intent intent = new Intent(context, (Class)CommandService.class);
        if (h != null) {
            intent.putExtra("extra_command_class", h.getClass().getName());
            intent.putExtra("extra_command_id", h.e());
        }
        return intent;
    }
    
    private void m() {
        if (!this.m) {
            try {
                this.startForeground(100, this.k(((Context)this).getString(2131952465), 0, false));
                this.m = true;
            }
            catch (final IllegalStateException ex) {
                if (!this.o) {
                    final int r = B.r((Context)this);
                    final ax.Ha.b b = ax.Ha.c.i((Context)this).f().b("Foreground not allowed : commandservice onbind");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("importance:");
                    sb.append(r);
                    sb.append(",started;");
                    sb.append(this.k);
                    b.g((Object)sb.toString()).h();
                }
            }
        }
    }
    
    public static CommandService q() {
        return CommandService.v;
    }
    
    private int r(final j j) {
        final Object h = this.h;
        synchronized (h) {
            return this.c.indexOf((Object)j);
        }
    }
    
    public static boolean x(final ax.Q2.f f) {
        final CommandService q = q();
        return q != null && q.u(f);
    }
    
    public static boolean y(final K k) {
        final CommandService q = q();
        return q != null && q.v(k);
    }
    
    private void z(final j j, final boolean b) {
        final c c = (c)this.a.get((Object)j);
        y c2;
        y c3;
        if (c != null) {
            c2 = c.c(true);
            c3 = c.c(false);
        }
        else {
            ax.Ha.c.h().d("COMS4").j().g((Object)j.B()).h();
            c2 = null;
            c3 = null;
        }
        final Object h = this.h;
        synchronized (h) {
            this.c.remove((Object)j);
            monitorexit(h);
            this.a.remove((Object)j);
            if (b) {
                if (c2 != null) {
                    c2.y3(j);
                }
                if (c3 != null) {
                    c3.y3(j);
                }
            }
            else {
                if (c2 != null) {
                    if (((Fragment)c2).e1()) {
                        ((e)c2).N2();
                    }
                    else {
                        c2.D3(true);
                    }
                }
                if (c3 != null) {
                    if (((Fragment)c3).e1()) {
                        ((e)c3).N2();
                    }
                    else {
                        c3.D3(true);
                    }
                }
            }
            final FileProgressActivity b2 = this.b;
            if (b2 != null) {
                b2.U();
            }
        }
    }
    
    public void A(final j j) {
        this.z(j, false);
    }
    
    public void B(final j j) {
        this.z(j, true);
    }
    
    public void C(final j j) {
        final c c = (c)this.a.get((Object)j);
        y c2;
        y c3;
        if (c != null) {
            c2 = c.c(true);
            c3 = c.c(false);
        }
        else {
            ax.Ha.c.h().d("COMS1:").j().g((Object)j.B()).h();
            c2 = null;
            c3 = null;
        }
        if (c2 != null) {
            c2.z3(j);
        }
        if (c3 != null) {
            c3.z3(j);
        }
    }
    
    public void D(final j j) {
        final c c = (c)this.a.get((Object)j);
        y c2;
        y c3;
        if (c != null) {
            c2 = c.c(true);
            c3 = c.c(false);
        }
        else {
            ax.Ha.c.h().d("COMS2:").j().g((Object)j.B()).h();
            c2 = null;
            c3 = null;
        }
        if (c2 != null) {
            c2.A3(j);
        }
        if (c3 != null) {
            c3.A3(j);
        }
        final FileProgressActivity b = this.b;
        if (b != null) {
            b.U();
        }
        this.O();
    }
    
    public void E(final j j, final boolean b) {
        final c c = (c)this.a.get((Object)j);
        y c2;
        y c3;
        if (c != null) {
            c2 = c.c(true);
            c3 = c.c(false);
        }
        else {
            ax.Ha.c.h().d("COMS3").j().g((Object)j.B()).h();
            c2 = null;
            c3 = null;
        }
        if (c2 != null) {
            c2.B3(j, b);
        }
        if (c3 != null) {
            c3.B3(j, b);
        }
        final FileProgressActivity b2 = this.b;
        if (b2 != null) {
            b2.V(j, this.r(j), b);
        }
        final long uptimeMillis = SystemClock.uptimeMillis();
        if (!b && uptimeMillis - this.g <= 2000L) {
            return;
        }
        this.g = uptimeMillis;
        this.O();
    }
    
    public void F(final long n) {
        this.n = n;
        final Runnable p = this.p;
        if (p != null) {
            this.r.removeCallbacks(p);
        }
        final Runnable p2 = (Runnable)new Runnable(this, n) {
            final CommandService c0;
            final long q;
            
            public void run() {
                if (!this.c0.k) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("current service null=");
                    final CommandService b = CommandService.v;
                    final boolean b2 = false;
                    sb.append(b == null);
                    sb.append(",diff=");
                    sb.append(CommandService.v != this.c0);
                    sb.append(",this service destroyed=");
                    sb.append(this.c0.l);
                    sb.append(",not started?");
                    sb.append(CommandService.t < this.q);
                    sb.append(":");
                    boolean b3 = b2;
                    if (CommandService.t > this.q) {
                        b3 = true;
                    }
                    sb.append(b3);
                    ax.Ha.c.h().f().b("!!! PENDING CHECK NOT STARTED !!!").g((Object)sb.toString()).h();
                    this.c0.n = 0L;
                    return;
                }
                if (this.c0.l) {
                    ax.u3.b.g("CommandService started but destroyed");
                    return;
                }
                if (this.c0.n == this.q) {
                    this.c0.n = 0L;
                    this.c0.h();
                }
            }
        };
        this.p = (Runnable)p2;
        this.r.postDelayed((Runnable)p2, 30000L);
    }
    
    public void G(final a a) {
        final ArrayList list = new ArrayList((Collection)this.d);
        this.d.clear();
        final int size = list.size();
        int i = 0;
        while (i < size) {
            final Object value = list.get(i);
            ++i;
            final j j = (j)value;
            final c c = (c)this.a.get((Object)j);
            if (c != null) {
                if (c.b() != null) {
                    this.L(a, j, c.b());
                    c.e(null);
                }
                else {
                    final ax.Ha.b b = ax.Ha.c.h().f().b("NULL PENDING DIALOG");
                    final StringBuilder sb = new StringBuilder();
                    sb.append("command op:");
                    sb.append(j.getClass().getName());
                    b.g((Object)sb.toString()).h();
                }
            }
            else {
                String string;
                if (j != null) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("op:");
                    sb2.append(j.B());
                    string = sb2.toString();
                }
                else {
                    string = "null op";
                }
                ax.Ha.c.h().f().b("NULL PENDING OPERATOR").g((Object)string).h();
            }
        }
        if (this.d.size() > 0) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("statesaved:");
            sb3.append(a.n());
            ax.Ha.c.h().b("Command Operator repended!?").j().g((Object)sb3.toString()).h();
        }
    }
    
    public void H(final FileProgressActivity fileProgressActivity) {
        if (this.b == fileProgressActivity) {
            this.b = null;
        }
    }
    
    public void I(final a a, final j j, final boolean b) {
        final c c = (c)this.a.get((Object)j);
        try {
            final FragmentManager supportFragmentManager = ((f)a.s()).getSupportFragmentManager();
            if (!supportFragmentManager.I0() && !a.n() && j.z() == j$d.d0) {
                final y x3 = y.x3();
                B.d0(supportFragmentManager, (e)x3, "fileProgress", true);
                x3.z3(j);
                x3.A3(j);
                if (b) {
                    c.f(true, x3);
                    return;
                }
                c.f(false, x3);
            }
        }
        catch (final IllegalStateException ex) {}
    }
    
    public void J(final FileProgressActivity b) {
        this.b = b;
    }
    
    public void K(final j j, final ax.a3.j i) {
        this.L(null, j, i);
    }
    
    public void N(final f f, final Fragment fragment, final j j, final boolean b) {
        if (j.T()) {
            ax.Ha.c.h().d("COMMAND SERVICE OPERATOR START TWICE!!!!").g((Object)j.getClass().getSimpleName()).h();
            return;
        }
        final long p4 = j.p();
        if (p4 >= this.n) {
            this.i();
        }
        CommandService.t = p4;
        final boolean b2 = f instanceof a;
        Object x3 = null;
        a a;
        if (b2) {
            a = (a)f;
        }
        else {
            if (f != null) {
                ax.Ha.c.h().d("START OPERATOR FROM UNKNOWN ACTIVITY").g((Object)f.getClass().getName()).h();
            }
            a = null;
        }
        final boolean b3 = a != null && b;
        if (b3) {
            x3 = y.x3();
        }
        final Object h = this.h;
        synchronized (h) {
            this.c.add((Object)j);
            monitorexit(h);
            final c c = new c(a, (y)x3);
            this.a.put((Object)j, (Object)c);
            if (!this.j.b()) {
                final Iterator iterator = j.y().iterator();
                while (iterator.hasNext()) {
                    if (ax.Q2.f.n0(((K)iterator.next()).d())) {
                        this.j.a();
                        break;
                    }
                }
            }
            j.p0(this);
            j.u0(this.i);
            if (b3) {
                Label_0299: {
                    try {
                        final FragmentManager supportFragmentManager = ((f)a.s()).getSupportFragmentManager();
                        if (supportFragmentManager.I0()) {
                            break Label_0299;
                        }
                        if (!a.n()) {
                            B.d0(supportFragmentManager, (e)x3, "fileProgress", true);
                        }
                    }
                    catch (final IllegalStateException ex) {
                        c.d((y)x3);
                        String string = "";
                        if (fragment != null) {
                            string = string;
                            if (fragment instanceof n) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("ActiveState :");
                                sb.append(((n)fragment).L3());
                                string = sb.toString();
                            }
                        }
                        ax.Ha.c.h().d("STARTOP").l((Throwable)ex).g((Object)string).h();
                        c.d((y)x3);
                    }
                }
            }
            final FileProgressActivity b4 = this.b;
            if (b4 != null) {
                b4.U();
            }
        }
    }
    
    public void h() {
        final Object h;
        monitorenter(h = this.h);
        Label_0058: {
            try {
                if (this.c.size() != 0 || this.n != 0L) {
                    break Label_0058;
                }
                final FileProgressActivity b = this.b;
                if (b != null && !((Activity)b).isFinishing()) {
                    ((Activity)this.b).finish();
                }
                break Label_0058;
            }
            finally {
                monitorexit(h);
                this.O();
                Label_0088: {
                    break Label_0088;
                    this.stopForeground(true);
                    this.m = false;
                    this.g();
                    this.stopSelf();
                    this.k = false;
                }
                monitorexit(h);
            }
        }
    }
    
    public void i() {
        this.n = 0L;
        this.r.removeCallbacks(this.p);
    }
    
    public List<j> n() {
        return (List<j>)this.c;
    }
    
    public List<j> o(final K k) {
        return this.p(k, -1);
    }
    
    public IBinder onBind(final Intent intent) {
        if (intent != null && "action.start_command".equals((Object)intent.getAction())) {
            this.m();
        }
        return this.e;
    }
    
    public void onCreate() {
        this.c = (ArrayList<j>)new ArrayList();
        this.a = (HashMap<j, c>)new HashMap();
        this.d = (ArrayList<j>)new ArrayList();
        this.f = C.a((Context)this, 0L, "CommandService");
        CommandService.v = this;
        this.i = Thread.currentThread();
        this.j = new D((Context)this, 3, "COMMAND_SERVICE");
        this.q = System.currentTimeMillis();
    }
    
    public void onDestroy() {
        C.d(this.f);
        this.j.c();
        super.onDestroy();
        CommandService.v = null;
        this.l = true;
    }
    
    public void onRebind(final Intent intent) {
        if (intent != null && "action.start_command".equals((Object)intent.getAction())) {
            this.m();
        }
    }
    
    public int onStartCommand(final Intent intent, final int n, final int n2) {
        while (true) {
            if (intent != null) {
                Label_0145: {
                    try {
                        final long longExtra = intent.getLongExtra("extra_command_id", -1L);
                        if (longExtra <= CommandService.t) {
                            final String stringExtra = intent.getStringExtra("extra_command_class");
                            final StringBuilder sb = new StringBuilder();
                            sb.append("command cls:");
                            sb.append(stringExtra);
                            sb.append(",id:");
                            sb.append(longExtra);
                            sb.append(",lastop:");
                            sb.append(CommandService.t);
                            sb.append(",lastsvc:");
                            sb.append(CommandService.u);
                            ax.Q2.d.c("CommandServiceStartLater", (Throwable)new Exception(sb.toString()));
                        }
                        break Label_0145;
                    }
                    catch (final IllegalStateException ex) {
                        final String stringExtra2 = intent.getStringExtra("extra_command_class");
                        if (stringExtra2 != null && stringExtra2.equals((Object)ax.W2.B.class.getName())) {
                            this.o = true;
                            return 2;
                        }
                        final ax.Ha.b b = ax.Ha.c.i((Context)this).f().b("Foreground not allowed : command service");
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("command class:");
                        sb2.append(stringExtra2);
                        b.g((Object)sb2.toString()).h();
                        final long longExtra;
                        CommandService.u = longExtra;
                        this.o = false;
                        this.k = true;
                        this.startForeground(100, this.k(((Context)this).getString(2131952465), 0, false));
                        this.m = true;
                    }
                }
                return 2;
            }
            continue;
        }
    }
    
    public void onTimeout(int n, int i) {
        super.onTimeout(n, i);
        n = 1;
        ax.o3.a.a(this, 1);
        Object o = null;
        Label_0139: {
            if (this.c != null) {
                final StringBuilder sb = new StringBuilder();
                o = this.h;
                final Object o2;
                monitorenter(o2 = o);
                Label_0115: {
                    try {
                        final ArrayList<j> c = this.c;
                        final int size = c.size();
                        i = 0;
                        while (i < size) {
                            final Object value = c.get(i);
                            ++i;
                            final j j = (j)value;
                            if (n != 0) {
                                n = 0;
                            }
                            else {
                                sb.append(",");
                            }
                            sb.append(j.B());
                        }
                        break Label_0115;
                    }
                    finally {
                        monitorexit(o2);
                        monitorexit(o2);
                        o = sb.toString();
                        break Label_0139;
                    }
                }
            }
            o = "null";
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("CommandServiceTimeout : ");
        sb2.append((String)o);
        sb2.append(":");
        sb2.append(System.currentTimeMillis() - this.q);
        ax.Q2.d.c("Command service timeout", (Throwable)new Exception(sb2.toString()));
    }
    
    public boolean onUnbind(final Intent intent) {
        return true;
    }
    
    public List<j> p(final K k, final int n) {
        final ArrayList list = new ArrayList();
        final Object h;
        monitorenter(h = this.h);
        while (true) {
            Label_0119: {
                try {
                    final ArrayList<j> c = this.c;
                    final int size = c.size();
                    int i = 0;
                    Block_5: {
                        while (i < size) {
                            final Object value = c.get(i);
                            final int n2 = i + 1;
                            final j j = (j)value;
                            if (n == -1) {
                                break Label_0119;
                            }
                            i = n2;
                            if (j.B() == n) {
                                break Block_5;
                            }
                        }
                        break Label_0119;
                    }
                    break Label_0119;
                }
                finally {
                    monitorexit(h);
                    final int n2;
                    int i = n2;
                    final j j;
                    iftrue(Label_0036:)(!j.y().contains((Object)k));
                    ((List)list).add((Object)j);
                    i = n2;
                    continue;
                    monitorexit(h);
                    return (List<j>)list;
                }
            }
            break;
        }
    }
    
    public long s() {
        return this.n;
    }
    
    public boolean t() {
        return this.m;
    }
    
    public boolean u(final ax.Q2.f f) {
        final Object h;
        monitorenter(h = this.h);
        Label_0098: {
            try {
                final ArrayList<j> c = this.c;
                final int size = c.size();
                int i = 0;
                Block_5: {
                    while (i < size) {
                        final Object value = c.get(i);
                        final int n = i + 1;
                        final Iterator iterator = ((j)value).y().iterator();
                        do {
                            i = n;
                            if (iterator.hasNext()) {
                                continue;
                            }
                            continue Block_5;
                        } while (((K)iterator.next()).d() != f);
                        break Block_5;
                    }
                    break Label_0098;
                }
                monitorexit(h);
                return true;
            }
            finally {
                monitorexit(h);
                monitorexit(h);
                return false;
            }
        }
    }
    
    public boolean v(final K k) {
        final Object h;
        monitorenter(h = this.h);
        Label_0068: {
            try {
                final ArrayList<j> c = this.c;
                final int size = c.size();
                int i = 0;
                Block_4: {
                    while (i < size) {
                        final Object value = c.get(i);
                        ++i;
                        if (((j)value).y().contains((Object)k)) {
                            break Block_4;
                        }
                    }
                    break Label_0068;
                }
                monitorexit(h);
                return true;
            }
            finally {
                monitorexit(h);
                monitorexit(h);
                return false;
            }
        }
    }
    
    public boolean w() {
        return this.k;
    }
    
    static class c
    {
        y a;
        y b;
        a c;
        ax.a3.j d;
        
        public c(final a c, final y a) {
            this.c = c;
            this.a = a;
        }
        
        public a a() {
            return this.c;
        }
        
        public ax.a3.j b() {
            return this.d;
        }
        
        public y c(final boolean b) {
            if (b) {
                return this.a;
            }
            return this.b;
        }
        
        public void d(final y y) {
            if (this.a == y) {
                this.a = null;
            }
            if (this.b == y) {
                this.b = null;
            }
        }
        
        public void e(final ax.a3.j d) {
            this.d = d;
        }
        
        public void f(final boolean b, final y y) {
            if (b) {
                this.a = y;
                return;
            }
            this.b = y;
        }
    }
    
    public class d extends Binder
    {
        final CommandService e;
        
        public d(final CommandService e) {
            this.e = e;
        }
        
        public CommandService a() {
            return this.e;
        }
    }
}
