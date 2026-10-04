package com.alphainventor.filemanager.texteditor;

import android.os.BaseBundle;
import android.app.Activity;
import androidx.fragment.app.Fragment;
import android.text.Html;
import android.os.Debug;
import android.app.ActivityManager;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import ax.Q2.a$f;
import ax.u3.q$e;
import ax.u3.q;
import android.view.ScaleGestureDetector$SimpleOnScaleGestureListener;
import android.text.TextWatcher;
import android.view.View$OnKeyListener;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView$OnEditorActionListener;
import ax.X2.Q;
import ax.S.h;
import ax.X2.J;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$F;
import androidx.recyclerview.widget.RecyclerView$h;
import android.text.style.SuggestionSpan;
import android.text.Spanned;
import android.text.SpannableStringBuilder;
import android.text.Editable;
import android.text.Editable$Factory;
import android.view.MenuItem;
import android.view.Menu;
import ax.t3.j;
import com.alphainventor.filemanager.file.c$a;
import android.widget.Toast;
import com.alphainventor.filemanager.provider.MyFileProvider;
import ax.c3.K;
import android.net.Uri;
import ax.c3.x;
import android.os.Bundle;
import ax.T.b;
import ax.c3.d0;
import ax.Q2.a;
import androidx.recyclerview.widget.RecyclerView$t;
import android.view.ScaleGestureDetector$OnScaleGestureListener;
import android.view.GestureDetector$OnGestureListener;
import ax.u3.z;
import android.view.MotionEvent;
import android.view.GestureDetector$SimpleOnGestureListener;
import ax.a3.n;
import ax.u3.B;
import ax.a3.D;
import android.text.Layout;
import android.graphics.Rect;
import android.widget.EditText;
import ax.Q2.f;
import androidx.recyclerview.widget.RecyclerView$r;
import androidx.recyclerview.widget.RecyclerView$m;
import androidx.recyclerview.widget.RecyclerView$B;
import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.View$OnClickListener;
import android.view.View;
import android.text.TextUtils;
import android.os.Build$VERSION;
import ax.Q2.g;
import androidx.fragment.app.e;
import android.view.View$OnTouchListener;
import android.view.ScaleGestureDetector;
import ax.Z2.k;
import com.alphainventor.filemanager.file.o;
import ax.c0.s;
import java.nio.charset.Charset;
import java.util.ArrayList;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView$p;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import java.util.regex.Pattern;
import java.util.logging.Logger;
import ax.a3.n$c;
import ax.R2.c;

public class TextEditorActivity extends c implements n$c
{
    private static final Logger D;
    private static boolean E;
    private static final int F;
    private static final int G;
    private static Pattern H;
    private String A;
    private String B;
    private int C;
    private Toolbar a;
    private RecyclerView b;
    private i c;
    private RecyclerView$p d;
    private ProgressBar e;
    private boolean f;
    private h g;
    private String h;
    private String i;
    private ArrayList<j> j;
    private Charset k;
    private String l;
    private int m;
    private int n;
    private int o;
    private int p;
    s q;
    private boolean r;
    private o s;
    private ax.Z2.k t;
    private ScaleGestureDetector u;
    private View$OnTouchListener v;
    private float w;
    private int x;
    private n y;
    private e z;
    
    static {
        D = ax.Q2.g.a((Class)TextEditorActivity.class);
        TextEditorActivity.E = false;
        int f;
        if (Build$VERSION.SDK_INT >= 30) {
            f = 1500;
        }
        else {
            f = 2500;
        }
        F = f;
        G = f * 2;
    }
    
    public TextEditorActivity() {
        this.m = -1;
        this.o = -1;
    }
    
    public static int E0(final String s, final char c) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        int index = 0;
        if (empty) {
            return 0;
        }
        int n = 0;
        while (true) {
            index = s.indexOf((int)c, index);
            if (index == -1) {
                break;
            }
            ++n;
            ++index;
        }
        return n;
    }
    
    public static int F0(final String s, final String s2) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        int n = 0;
        if (!empty && !TextUtils.isEmpty((CharSequence)s2)) {
            int n2 = 0;
            while (true) {
                final int index = s.indexOf(s2, n);
                if (index == -1) {
                    break;
                }
                ++n2;
                n = index + s2.length();
            }
            return n2;
        }
        return 0;
    }
    
    private void G0(final boolean b) {
        if (this.n()) {
            return;
        }
        (this.y = new n(b)).h((Object[])new Void[0]);
    }
    
    public static int H0(final String s, final char c, final int n) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return -1;
        }
        int index = 0;
        int n2 = 0;
        while (true) {
            index = s.indexOf((int)c, index);
            if (index == -1) {
                return -1;
            }
            if (++n2 == n) {
                return index;
            }
            ++index;
        }
    }
    
    private void I0() {
        try {
            final e z = this.z;
            if (z != null && ((Fragment)z).X0()) {
                this.z.O2();
            }
        }
        catch (final Exception ex) {}
    }
    
    private void J0() {
        ((ax.n.c)this).setSupportActionBar(this.a);
        ((ax.n.c)this).getSupportActionBar().x(true);
        this.a.setNavigationOnClickListener((View$OnClickListener)new ax.g3.c(this) {
            final TextEditorActivity c;
            
            public void a(final View view) {
                this.c.onBackPressed();
            }
        });
    }
    
    private void L0() {
        this.a = (Toolbar)((ax.n.c)this).findViewById(2131362981);
        this.b = (RecyclerView)((ax.n.c)this).findViewById(2131362729);
        this.e = (ProgressBar)((ax.n.c)this).findViewById(2131362712);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, this) {
            final TextEditorActivity I;
            
            public boolean g1(final RecyclerView recyclerView, final RecyclerView$B recyclerView$B, final View view, final View view2) {
                return true;
            }
        };
        this.d = (RecyclerView$p)linearLayoutManager;
        this.b.setLayoutManager((RecyclerView$p)linearLayoutManager);
        this.b.setItemAnimator((RecyclerView$m)null);
        this.b.l((RecyclerView$r)new k());
        this.K0();
    }
    
    private boolean M0() {
        final ax.Z2.k t = this.t;
        return t == null || ax.Q2.f.Y(t.b());
    }
    
    private void N0(final EditText editText) {
        ((View)editText).post((Runnable)new Runnable(this, editText) {
            final TextEditorActivity c0;
            final EditText q;
            
            public void run() {
                if (((View)this.q).hasFocus()) {
                    final int selectionStart = ((TextView)this.q).getSelectionStart();
                    final Layout layout = ((TextView)this.q).getLayout();
                    if (layout != null && selectionStart != -1) {
                        final int lineForOffset = layout.getLineForOffset(selectionStart);
                        final int lineBaseline = layout.getLineBaseline(lineForOffset);
                        final int lineAscent = layout.getLineAscent(lineForOffset);
                        final float primaryHorizontal = layout.getPrimaryHorizontal(selectionStart);
                        final float n = (float)(lineBaseline + lineAscent);
                        final EditText q = this.q;
                        final int n2 = (int)primaryHorizontal;
                        final int n3 = (int)n;
                        ((View)q).requestRectangleOnScreen(new Rect(n2, n3, n2, n3), false);
                    }
                }
            }
        });
    }
    
    private void O0(final h g) {
        this.g = g;
        final int ordinal = g.ordinal();
        if (ordinal != 2) {
            if (ordinal == 3) {
                this.a.setTitle((CharSequence)this.i);
            }
        }
        else {
            final Toolbar a = this.a;
            final StringBuilder sb = new StringBuilder();
            sb.append("* ");
            sb.append(this.i);
            a.setTitle((CharSequence)sb.toString());
        }
        ((ax.n.c)this).invalidateOptionsMenu();
    }
    
    private void P0() {
        this.z = (e)new D();
        ax.u3.B.d0(((androidx.fragment.app.f)this).getSupportFragmentManager(), this.z, "save_progress", true);
    }
    
    static /* synthetic */ float x0(final TextEditorActivity textEditorActivity, float w) {
        w *= textEditorActivity.w;
        return textEditorActivity.w = w;
    }
    
    public void G(final ax.a3.n n) {
    }
    
    void K0() {
        this.q = new s((Context)this, (GestureDetector$OnGestureListener)new GestureDetector$SimpleOnGestureListener(this) {
            final TextEditorActivity a;
            
            public boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
                if (this.a.d.P() > 0) {
                    final View o = this.a.d.O(this.a.d.P() - 1);
                    if (!this.a.f) {
                        o.requestFocus();
                        o.postDelayed((Runnable)new Runnable(this, o) {
                            final TextEditorActivity$c c0;
                            final View q;
                            
                            public void run() {
                                if (!this.c0.a.n()) {
                                    ax.u3.z.E((Context)this.c0.a, this.q);
                                }
                            }
                        }, 100L);
                    }
                }
                return true;
            }
        });
        this.u = new ScaleGestureDetector((Context)this, (ScaleGestureDetector$OnScaleGestureListener)new l());
        final View$OnTouchListener view$OnTouchListener = (View$OnTouchListener)new View$OnTouchListener(this) {
            final TextEditorActivity a;
            
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                this.a.u.onTouchEvent(motionEvent);
                return false;
            }
        };
        this.v = (View$OnTouchListener)view$OnTouchListener;
        ((View)this.b).setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
        this.b.m((RecyclerView$t)new RecyclerView$t(this) {
            final TextEditorActivity a;
            
            public void b(final RecyclerView recyclerView, final MotionEvent motionEvent) {
                this.a.q.a(motionEvent);
            }
            
            public boolean c(final RecyclerView recyclerView, final MotionEvent motionEvent) {
                if (this.a.b.X(motionEvent.getX(), motionEvent.getY()) != null) {
                    return false;
                }
                this.a.q.a(motionEvent);
                return true;
            }
            
            public void e(final boolean b) {
            }
        });
    }
    
    public void P(final ax.a3.n n) {
        ax.Q2.a.i().m("menu_text_editor", "text_save").c("ext", d0.j(this.i)).e();
        this.G0(true);
    }
    
    public void Z(final ax.a3.n n) {
        ((Activity)this).finish();
    }
    
    public boolean isContentClipToPadding(final boolean b) {
        return b;
    }
    
    public boolean n() {
        return ((androidx.fragment.app.f)this).getSupportFragmentManager().Q0();
    }
    
    public void onApplyWindowsInsets(final b b, final boolean b2) {
        if (!b2) {
            final RecyclerView b3 = this.b;
            if (b3 != null) {
                b3.setClipToPadding(false);
                ((View)this.b).setPadding(0, 0, 0, b.d);
            }
        }
    }
    
    public void onBackPressed() {
        if (!this.n()) {
            if (this.g == TextEditorActivity.h.d0) {
                ((e)ax.a3.n.k3(2131951786, 2131951790, 2131952296, 2131952256)).c3(((androidx.fragment.app.f)this).getSupportFragmentManager(), "dialog");
                return;
            }
            super.onBackPressed();
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        ax.Q2.b.f((Context)this, true);
        super.onCreate(bundle);
        ((ax.n.c)this).setContentView(2131558438);
        this.L0();
        this.J0();
        final Uri data = ((Activity)this).getIntent().getData();
        if (data == null) {
            ax.Ha.c.h().d("TextEditor DataUri == null").h();
            ((Activity)this).finish();
            return;
        }
        this.onSetContentView(false);
        this.g = TextEditorActivity.h.q;
        final Logger d = TextEditorActivity.D;
        final StringBuilder sb = new StringBuilder();
        sb.append("TextEditor open : ");
        sb.append((Object)data);
        d.fine(sb.toString());
        this.f = ((Activity)this).getIntent().getBooleanExtra("read_only", false);
        final boolean equals = "file".equals((Object)data.getScheme());
        String s = null;
        final String s2 = null;
        final String s3 = null;
        String k = null;
        Label_0787: {
            if (equals) {
                final String path = data.getPath();
                this.h = path;
                this.s = ax.c3.x.g(path);
                this.i = d0.h(this.h);
                final String stringExtra = ((Activity)this).getIntent().getStringExtra("original_file_location_uri");
                if (TextUtils.isEmpty((CharSequence)stringExtra)) {
                    final String i = null;
                    final String j = s3;
                    break Label_0787;
                }
                String s4 = null;
                Label_0321: {
                    String l = null;
                    Label_0313: {
                        try {
                            final ax.Z2.k a = ax.Z2.k.a(Uri.parse(stringExtra));
                            this.t = a;
                            final K d2 = a.d();
                            final K h = K.h;
                            if (d2 == h) {
                                this.s = ax.c3.x.e(h);
                            }
                        }
                        catch (final Exception ex) {
                            l = null;
                            break Label_0313;
                        }
                        final ax.Z2.k t = this.t;
                        if (t == null) {
                            s4 = null;
                            break Label_0321;
                        }
                        l = t.b().I();
                        try {
                            k = d0.k(this.t.e());
                        }
                        catch (final Exception ex2) {}
                    }
                    s = l;
                    s4 = k;
                }
                String i = s4;
                String j = s;
                if (this.t == null) {
                    break Label_0787;
                }
                i = s4;
                j = s;
                if (bundle == null) {
                    break Label_0787;
                }
                final String string = ((BaseBundle)bundle).getString("file_open_path");
                final long long1 = ((BaseBundle)bundle).getLong("file_open_last_modified", -1L);
                i = s4;
                j = s;
                if (string == null) {
                    break Label_0787;
                }
                i = s4;
                j = s;
                if (!string.equals((Object)this.t.e())) {
                    break Label_0787;
                }
                i = s4;
                j = s;
                if (long1 != -1L) {
                    ax.o3.e.b().i(this.t.d(), this.t.e(), long1);
                    i = s4;
                    j = s;
                    break Label_0787;
                }
                break Label_0787;
            }
            else if ("content".equals((Object)data.getScheme())) {
                if (!MyFileProvider.B(data) && !MyFileProvider.A(data)) {
                    Toast.makeText((Context)this, 2131951934, 1).show();
                    ((Activity)this).finish();
                    return;
                }
                final ax.Z2.k e = MyFileProvider.e(data);
                this.h = e.e();
                final K d3 = e.d();
                this.s = ax.c3.x.e(d3);
                this.i = d0.h(this.h);
                String m;
                if (d3 != null && this.h != null) {
                    final String j = d3.d().I();
                    m = d0.k(this.h);
                }
                else {
                    m = null;
                    final String j = s2;
                }
                final String i = m;
                break Label_0787;
            }
            try {
                final ax.Z2.k a2 = ax.Z2.k.a(data);
                this.h = a2.e();
                final K d4 = a2.d();
                this.s = ax.c3.x.e(d4);
                this.i = d0.h(this.h);
                String i;
                String i2;
                if (d4 != null && this.h != null) {
                    i2 = d4.d().I();
                    i = d0.k(this.h);
                }
                else {
                    i2 = null;
                    i = null;
                }
                if (!this.s.a()) {
                    if (ax.Q2.f.e0(this.s.S()) || ax.Q2.f.o0(this.s.S())) {
                        this.s.h(null);
                    }
                    if (!this.s.a()) {
                        final ax.Ha.b d5 = ax.Ha.c.h().f().d("TextEditor : FileOperator not connected");
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("location:");
                        sb2.append(this.s.S().I());
                        d5.g((Object)sb2.toString()).h();
                        ((Activity)this).finish();
                        return;
                    }
                }
                final String j = i2;
                if (j != null && i != null) {
                    this.A = j;
                    this.B = i;
                }
                final int m2 = ax.t3.j.m((Context)this);
                this.x = m2;
                this.w = m2 / 14.0f;
                ((Activity)this).setTitle((CharSequence)this.i);
                new m().i((Object[])new Void[0]);
            }
            catch (final IllegalArgumentException ex3) {
                Toast.makeText((Context)this, 2131951934, 1).show();
                ((Activity)this).finish();
            }
        }
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        ((ax.n.c)this).getMenuInflater().inflate(2131689509, menu);
        return true;
    }
    
    public void onIMEVisibilityChanged(final boolean b) {
        if (b) {
            final View currentFocus = ((Activity)this).getCurrentFocus();
            if (currentFocus instanceof EditText) {
                this.N0((EditText)currentFocus);
            }
        }
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem.getItemId() != 2131362536) {
            return super.onOptionsItemSelected(menuItem);
        }
        ax.Q2.a.i().m("menu_text_editor", "text_save").c("ext", d0.j(this.i)).e();
        this.G0(false);
        return true;
    }
    
    protected void onPause() {
        super.onPause();
        if (this.x != ax.t3.j.m((Context)this)) {
            ax.t3.j.u((Context)this, this.x);
        }
    }
    
    public boolean onPrepareOptionsMenu(final Menu menu) {
        final MenuItem item = menu.findItem(2131362536);
        if (item != null) {
            if (this.f) {
                item.setVisible(false);
            }
            else {
                item.setVisible(true);
                if (this.g == TextEditorActivity.h.d0) {
                    item.setEnabled(true);
                    item.getIcon().setAlpha(255);
                }
                else {
                    item.setEnabled(false);
                    item.getIcon().setAlpha(85);
                }
            }
        }
        else {
            ax.Ha.c.h().f().d("not created options menu!!").j().h();
        }
        return super.onPrepareOptionsMenu(menu);
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.t != null) {
            final long c = ax.o3.e.b().c(this.t.d(), this.t.e());
            if (c != 0L) {
                ((BaseBundle)bundle).putString("file_open_path", this.t.e());
                ((BaseBundle)bundle).putLong("file_open_last_modified", c);
            }
        }
    }
    
    protected void onStart() {
        super.onStart();
        ax.Q2.a.i().q(this.getClass().getSimpleName());
    }
    
    public static class g extends Editable$Factory
    {
        public Editable newEditable(final CharSequence charSequence) {
            return (Editable)new SpannableStringBuilder(this, charSequence) {
                final g q;
                
                public SpannableStringBuilder replace(final int n, final int n2, final CharSequence charSequence, final int n3, final int n4) {
                    if (n == 0 && n3 == 0 && n2 == n4 && n2 == this.length() && this.length() == charSequence.length() && charSequence.toString().equals((Object)this.toString()) && charSequence instanceof Spanned && ((Spanned)charSequence).nextSpanTransition(n3, n4, (Class)SuggestionSpan.class) < n4) {
                        return this;
                    }
                    return super.replace(n, n2, charSequence, n3, n4);
                }
            };
        }
    }
    
    enum h
    {
        c0, 
        d0, 
        e0;
        
        private static final h[] f0;
        
        q;
        
        static {
            f0 = d();
        }
        
        private static /* synthetic */ h[] d() {
            return new h[] { h.q, h.c0, h.d0, h.e0 };
        }
    }
    
    class i extends RecyclerView$h<a>
    {
        private ArrayList<j> d;
        final TextEditorActivity e;
        
        public i(final TextEditorActivity e, final ArrayList<j> d) {
            this.e = e;
            this.d = d;
        }
        
        public void O(final a a, final int n) {
            a.N(n);
            a.O((float)this.e.x);
        }
        
        public a P(final ViewGroup viewGroup, final int n) {
            View view;
            if (this.e.f) {
                view = LayoutInflater.from(((View)viewGroup).getContext()).inflate(2131558579, viewGroup, false);
            }
            else {
                view = LayoutInflater.from(((View)viewGroup).getContext()).inflate(2131558578, viewGroup, false);
            }
            return new a(view);
        }
        
        public int l() {
            return this.d.size();
        }
        
        class a extends RecyclerView$F
        {
            public EditText u;
            public boolean v;
            public boolean w;
            public boolean x;
            final i y;
            
            public a(final i y, final View view) {
                this.y = y;
                super(view);
                this.u = (EditText)view;
                if (J.e()) {
                    ((TextView)this.u).setEditableFactory((Editable$Factory)new g());
                }
                ((View)this.u).setOnTouchListener(y.e.v);
                try {
                    ((TextView)this.u).setTypeface(ax.S.h.g(view.getContext(), 2131296257));
                }
                catch (final Exception ex) {
                    ax.Ha.c.h().f().b("FONT LOAD ERROR").l((Throwable)ex).h();
                }
                if (Q.r()) {
                    ((TextView)this.u).setOnEditorActionListener((TextView$OnEditorActionListener)new TextView$OnEditorActionListener(this, y) {
                        final i a;
                        final a b;
                        
                        public boolean onEditorAction(final TextView textView, int max, final KeyEvent keyEvent) {
                            if ((max == 6 || max == 5) && keyEvent == null) {
                                max = Math.max(((TextView)this.b.u).getSelectionStart(), 0);
                                final int max2 = Math.max(((TextView)this.b.u).getSelectionEnd(), 0);
                                this.b.u.getText().replace(Math.min(max, max2), Math.max(max, max2), (CharSequence)"\n", 0, 1);
                                return true;
                            }
                            return false;
                        }
                    });
                }
                ((View)this.u).setOnKeyListener((View$OnKeyListener)new View$OnKeyListener(this, y) {
                    final i a;
                    final a b;
                    
                    public boolean onKey(final View view, int k0, final KeyEvent keyEvent) {
                        if (k0 == 47 && keyEvent.isCtrlPressed()) {
                            this.b.y.e.G0(false);
                        }
                        if (k0 == 67 && keyEvent.getAction() == 0 && ((TextView)this.b.u).getSelectionStart() == 0) {
                            final int k2 = this.b.y.e.b.k0((View)this.b.u);
                            if (k2 >= 0) {
                                if (k2 < this.b.y.d.size()) {
                                    if (k2 > 0) {
                                        this.b.y.e.O0(TextEditorActivity.h.d0);
                                        final TextEditorActivity e = this.b.y.e;
                                        k0 = k2 - 1;
                                        e.o = k0;
                                        final i y = this.b.y;
                                        y.e.p = ((j)y.d.get(k0)).a.length();
                                        final StringBuilder sb = new StringBuilder();
                                        final j j = (j)this.b.y.d.get(k0);
                                        sb.append(j.a);
                                        sb.append(((j)this.b.y.d.get(k2)).a);
                                        j.a = sb.toString();
                                        this.b.y.d.remove(k2);
                                        this.b.y.e.c.s(k0);
                                        this.b.y.e.c.z(k2);
                                    }
                                }
                            }
                            return true;
                        }
                        if (k0 == 112) {
                            k0 = 1;
                        }
                        else {
                            k0 = 0;
                        }
                        if ((k0 & ((keyEvent.getAction() == 0) ? 1 : 0)) != 0x0 && ((TextView)this.b.u).getSelectionStart() == ((TextView)this.b.u).length()) {
                            k0 = this.b.y.e.b.k0((View)this.b.u);
                            if (k0 >= 0) {
                                if (k0 < this.b.y.d.size()) {
                                    if (k0 < this.b.y.d.size() - 1) {
                                        this.b.y.e.O0(TextEditorActivity.h.d0);
                                        this.b.y.e.o = k0;
                                        final i y2 = this.b.y;
                                        y2.e.p = ((j)y2.d.get(k0)).a.length();
                                        final StringBuilder sb2 = new StringBuilder();
                                        final j i = (j)this.b.y.d.get(k0);
                                        sb2.append(i.a);
                                        final ArrayList n = this.b.y.d;
                                        final int n2 = k0 + 1;
                                        sb2.append(((j)n.get(n2)).a);
                                        i.a = sb2.toString();
                                        this.b.y.d.remove(n2);
                                        this.b.y.e.c.s(k0);
                                        this.b.y.e.c.z(n2);
                                    }
                                }
                            }
                            return true;
                        }
                        return false;
                    }
                });
                ((TextView)this.u).addTextChangedListener((TextWatcher)new TextWatcher(this, y) {
                    final i a;
                    final a b;
                    
                    public void afterTextChanged(final Editable editable) {
                        final a b = this.b;
                        if (!b.v && !b.w) {
                            b.y.e.O0(TextEditorActivity.h.d0);
                            final int m0 = this.b.y.e.d.m0((View)this.b.u);
                            final String string = editable.toString();
                            if (m0 < 0) {
                                ax.Ha.c.h().f().b("TEXTEDITOR IndexOutOfBound -1").h();
                            }
                            else if (m0 < this.b.y.d.size()) {
                                ((j)this.b.y.d.get(m0)).a = string;
                            }
                            else {
                                ax.Ha.c.h().f().b("TEXTEDITOR IndexOutOfBound").h();
                            }
                            if (this.b.y.e.r) {
                                if (TextEditorActivity.E0(string, '\n') >= TextEditorActivity.G - 1) {
                                    final int selectionStart = ((TextView)this.b.u).getSelectionStart();
                                    final int h0 = TextEditorActivity.H0(string, '\n', TextEditorActivity.F);
                                    int n;
                                    if (h0 > 0 && string.charAt(h0 - 1) == '\r') {
                                        n = h0 - 1;
                                    }
                                    else {
                                        n = h0;
                                    }
                                    final String substring = string.substring(0, n);
                                    final String substring2 = string.substring(h0 + 1);
                                    final a b2 = this.b;
                                    if (b2.x) {
                                        ((j)b2.y.d.get(m0)).a = substring;
                                        final ArrayList n2 = this.b.y.d;
                                        final int n3 = m0 + 1;
                                        ((j)n2.get(n3)).a = substring2;
                                        this.b.y.e.c.s(m0);
                                        this.b.y.e.c.s(n3);
                                        return;
                                    }
                                    ((j)b2.y.d.get(m0)).a = substring;
                                    final ArrayList n4 = this.b.y.d;
                                    final int n5 = m0 + 1;
                                    n4.add(n5, (Object)this.b.y.e.new j(substring2));
                                    this.b.y.e.c.s(m0);
                                    this.b.y.e.c.u(n5);
                                    if (selectionStart > substring.length()) {
                                        this.b.y.e.m = n5;
                                        this.b.y.e.n = selectionStart - h0 - 1;
                                    }
                                    this.b.y.e.b.B1(0, ((TextView)this.b.u).getLineHeight());
                                    this.b.x = true;
                                }
                            }
                            else if (string.contains((CharSequence)"\n")) {
                                final int index = string.indexOf("\n");
                                final String substring3 = string.substring(0, index);
                                final String substring4 = string.substring(index + 1);
                                final a b3 = this.b;
                                if (b3.x) {
                                    ((j)b3.y.d.get(m0)).a = substring3;
                                    final ArrayList n6 = this.b.y.d;
                                    final int n7 = m0 + 1;
                                    ((j)n6.get(n7)).a = substring4;
                                    this.b.y.e.c.s(m0);
                                    this.b.y.e.c.s(n7);
                                    return;
                                }
                                ((j)b3.y.d.get(m0)).a = substring3;
                                final ArrayList n8 = this.b.y.d;
                                final int n9 = m0 + 1;
                                n8.add(n9, (Object)this.b.y.e.new j(substring4));
                                this.b.y.e.c.s(m0);
                                this.b.y.e.c.u(n9);
                                this.b.y.e.m = n9;
                                this.b.y.e.n = 0;
                                this.b.y.e.b.B1(0, ((TextView)this.b.u).getLineHeight());
                                this.b.x = true;
                            }
                            return;
                        }
                        b.v = false;
                        b.x = false;
                    }
                    
                    public void beforeTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
                    }
                    
                    public void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
                    }
                });
            }
            
            public void N(final int n) {
                this.v = true;
                this.w = true;
                final boolean x = this.x;
                ((TextView)this.u).setTextKeepState((CharSequence)((j)this.y.d.get(n)).a);
                if (!x) {
                    final EditText u = this.u;
                    u.setSelection(((TextView)u).length());
                }
                this.w = false;
            }
            
            public void O(final float textSize) {
                ((TextView)this.u).setTextSize(textSize);
            }
        }
    }
    
    class j
    {
        String a;
        final TextEditorActivity b;
        
        j(final TextEditorActivity b, final String a) {
            this.b = b;
            this.a = a;
        }
    }
    
    class k implements RecyclerView$r
    {
        final TextEditorActivity a;
        
        k(final TextEditorActivity a) {
            this.a = a;
        }
        
        public void a(final View view) {
            if (this.a.o != -1) {
                final EditText editText = (EditText)this.a.d.I(this.a.o);
                if (editText == null) {
                    ax.Ha.c.h().d("INVALID TEXTEDITOR SELECTION NULL").g((Object)this.a.p).h();
                    this.a.o = -1;
                    return;
                }
                if (!this.a.f) {
                    ((View)editText).requestFocus();
                    ax.u3.z.E((Context)this.a, (View)editText);
                }
                if (this.a.p <= ((CharSequence)editText.getText()).length()) {
                    editText.setSelection(this.a.p);
                }
                else {
                    final ax.Ha.b d = ax.Ha.c.h().d("INVALID TEXTEDITOR SELECTION");
                    final StringBuilder sb = new StringBuilder();
                    sb.append(this.a.p);
                    sb.append(" > ");
                    sb.append(((CharSequence)editText.getText()).length());
                    d.g((Object)sb.toString()).h();
                }
                this.a.o = -1;
            }
        }
        
        public void d(final View view) {
            if (view != null && this.a.m == this.a.d.m0(view)) {
                final EditText editText = (EditText)view;
                if (!this.a.f) {
                    ((View)editText).requestFocus();
                    ax.u3.z.E((Context)this.a, (View)editText);
                }
                if (((CharSequence)editText.getText()).length() > this.a.n) {
                    editText.setSelection(this.a.n);
                }
                this.a.m = -1;
            }
        }
    }
    
    private class l extends ScaleGestureDetector$SimpleOnScaleGestureListener
    {
        final TextEditorActivity a;
        
        private l(final TextEditorActivity a) {
            this.a = a;
        }
        
        public boolean onScale(final ScaleGestureDetector scaleGestureDetector) {
            TextEditorActivity.x0(this.a, scaleGestureDetector.getScaleFactor());
            final TextEditorActivity a = this.a;
            a.w = Math.max(0.6f, Math.min(a.w, 4.0f));
            final TextEditorActivity a2 = this.a;
            a2.x = (int)(a2.w * 14.0f);
            if (this.a.c != null) {
                this.a.c.r();
            }
            return true;
        }
    }
    
    class m extends q<Void, Void, Integer>
    {
        private boolean h;
        final TextEditorActivity i;
        
        m(final TextEditorActivity i) {
            this.i = i;
            super(q$e.d0);
        }
        
        private boolean A(final int n) {
            return n == 0;
        }
        
        private int C(final o p0, final com.alphainventor.filemanager.file.n p1) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //     4: new             Ljava/util/ArrayList;
            //     7: dup            
            //     8: invokespecial   java/util/ArrayList.<init>:()V
            //    11: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.Q:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/util/ArrayList;)Ljava/util/ArrayList;
            //    14: pop            
            //    15: aconst_null    
            //    16: astore          12
            //    18: aconst_null    
            //    19: astore          13
            //    21: aconst_null    
            //    22: astore          14
            //    24: aload           14
            //    26: astore          11
            //    28: new             Lax/q3/a;
            //    31: astore          10
            //    33: aload           14
            //    35: astore          11
            //    37: new             Ljava/io/InputStreamReader;
            //    40: astore          15
            //    42: aload           14
            //    44: astore          11
            //    46: aload           15
            //    48: aload_1        
            //    49: aload_2        
            //    50: lconst_0       
            //    51: invokevirtual   com/alphainventor/filemanager/file/o.J:(Lcom/alphainventor/filemanager/file/n;J)Ljava/io/InputStream;
            //    54: aload_0        
            //    55: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //    58: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.T:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/nio/charset/Charset;
            //    61: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
            //    64: aload           14
            //    66: astore          11
            //    68: aload           10
            //    70: aload           15
            //    72: invokespecial   ax/q3/a.<init>:(Ljava/io/Reader;)V
            //    75: invokestatic    ax/X2/J.h:()Z
            //    78: ifeq            89
            //    81: sipush          8000
            //    84: istore          4
            //    86: goto            92
            //    89: iconst_0       
            //    90: istore          4
            //    92: new             Ljava/lang/StringBuffer;
            //    95: astore_1       
            //    96: aload_1        
            //    97: invokespecial   java/lang/StringBuffer.<init>:()V
            //   100: iconst_0       
            //   101: istore          6
            //   103: iconst_0       
            //   104: istore_3       
            //   105: iconst_0       
            //   106: istore          5
            //   108: iconst_0       
            //   109: istore          8
            //   111: aload           10
            //   113: invokevirtual   ax/q3/a.e:()Ljava/lang/String;
            //   116: astore          11
            //   118: aload           11
            //   120: ifnonnull       266
            //   123: iload           6
            //   125: ifeq            185
            //   128: aload_0        
            //   129: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   132: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   135: astore          11
            //   137: new             Lcom/alphainventor/filemanager/texteditor/TextEditorActivity$j;
            //   140: astore_2       
            //   141: aload_2        
            //   142: aload_0        
            //   143: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   146: aload_1        
            //   147: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
            //   150: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$j.<init>:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/lang/String;)V
            //   153: aload           11
            //   155: aload_2        
            //   156: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
            //   159: pop            
            //   160: goto            185
            //   163: astore_1       
            //   164: aload           10
            //   166: astore          11
            //   168: goto            540
            //   171: astore_2       
            //   172: aload           10
            //   174: astore_1       
            //   175: goto            509
            //   178: astore_1       
            //   179: aload           10
            //   181: astore_1       
            //   182: goto            552
            //   185: iload           8
            //   187: ifeq            218
            //   190: aload_0        
            //   191: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   194: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   197: astore_1       
            //   198: new             Lcom/alphainventor/filemanager/texteditor/TextEditorActivity$j;
            //   201: astore_2       
            //   202: aload_2        
            //   203: aload_0        
            //   204: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   207: ldc             ""
            //   209: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$j.<init>:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/lang/String;)V
            //   212: aload_1        
            //   213: aload_2        
            //   214: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
            //   217: pop            
            //   218: aload_0        
            //   219: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   222: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   225: invokevirtual   java/util/ArrayList.size:()I
            //   228: ifne            259
            //   231: aload_0        
            //   232: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   235: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   238: astore_1       
            //   239: new             Lcom/alphainventor/filemanager/texteditor/TextEditorActivity$j;
            //   242: astore_2       
            //   243: aload_2        
            //   244: aload_0        
            //   245: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   248: ldc             ""
            //   250: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$j.<init>:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/lang/String;)V
            //   253: aload_1        
            //   254: aload_2        
            //   255: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
            //   258: pop            
            //   259: aload           10
            //   261: invokevirtual   ax/q3/a.close:()V
            //   264: iconst_0       
            //   265: ireturn        
            //   266: aload           10
            //   268: invokevirtual   ax/q3/a.a:()Z
            //   271: istore          8
            //   273: aload           11
            //   275: invokevirtual   java/lang/String.length:()I
            //   278: istore          6
            //   280: iload           6
            //   282: ldc             200000
            //   284: if_icmple       295
            //   287: aload           10
            //   289: invokevirtual   ax/q3/a.close:()V
            //   292: bipush          -3
            //   294: ireturn        
            //   295: iconst_0       
            //   296: istore          7
            //   298: iload           7
            //   300: aload           11
            //   302: invokevirtual   java/lang/String.length:()I
            //   305: if_icmpge       362
            //   308: aload_0        
            //   309: aload           11
            //   311: iload           7
            //   313: invokevirtual   java/lang/String.charAt:(I)C
            //   316: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$m.A:(I)Z
            //   319: istore          9
            //   321: iload           5
            //   323: istore          6
            //   325: iload           9
            //   327: ifeq            352
            //   330: iinc            5, 1
            //   333: iload           5
            //   335: istore          6
            //   337: iload           5
            //   339: bipush          10
            //   341: if_icmplt       352
            //   344: aload           10
            //   346: invokevirtual   ax/q3/a.close:()V
            //   349: bipush          -3
            //   351: ireturn        
            //   352: iinc            7, 1
            //   355: iload           6
            //   357: istore          5
            //   359: goto            298
            //   362: iconst_1       
            //   363: istore          6
            //   365: iload_3        
            //   366: ifne            384
            //   369: aload_1        
            //   370: iconst_0       
            //   371: invokevirtual   java/lang/StringBuffer.setLength:(I)V
            //   374: aload_1        
            //   375: aload           11
            //   377: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
            //   380: pop            
            //   381: goto            485
            //   384: iload_3        
            //   385: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.h0:()I
            //   388: iconst_1       
            //   389: isub           
            //   390: if_icmpge       438
            //   393: iload           4
            //   395: ifeq            416
            //   398: aload_1        
            //   399: invokevirtual   java/lang/StringBuffer.length:()I
            //   402: aload           11
            //   404: invokevirtual   java/lang/String.length:()I
            //   407: iadd           
            //   408: iload           4
            //   410: if_icmple       416
            //   413: goto            438
            //   416: aload_1        
            //   417: aload_0        
            //   418: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   421: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.R:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/lang/String;
            //   424: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
            //   427: pop            
            //   428: aload_1        
            //   429: aload           11
            //   431: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
            //   434: pop            
            //   435: goto            485
            //   438: aload_0        
            //   439: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   442: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   445: astore_2       
            //   446: new             Lcom/alphainventor/filemanager/texteditor/TextEditorActivity$j;
            //   449: astore          12
            //   451: aload           12
            //   453: aload_0        
            //   454: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   457: aload_1        
            //   458: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
            //   461: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$j.<init>:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/lang/String;)V
            //   464: aload_2        
            //   465: aload           12
            //   467: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
            //   470: pop            
            //   471: aload_1        
            //   472: iconst_0       
            //   473: invokevirtual   java/lang/StringBuffer.setLength:(I)V
            //   476: aload_1        
            //   477: aload           11
            //   479: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
            //   482: pop            
            //   483: iconst_0       
            //   484: istore_3       
            //   485: iinc            3, 1
            //   488: goto            111
            //   491: astore_1       
            //   492: goto            540
            //   495: astore_2       
            //   496: aload           12
            //   498: astore_1       
            //   499: goto            509
            //   502: astore_1       
            //   503: aload           13
            //   505: astore_1       
            //   506: goto            552
            //   509: aload_1        
            //   510: astore          11
            //   512: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
            //   515: ldc             "TEXT EDITOR OOM"
            //   517: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
            //   520: aload_2        
            //   521: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
            //   524: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
            //   527: invokevirtual   ax/Ha/b.h:()V
            //   530: aload_1        
            //   531: ifnull          538
            //   534: aload_1        
            //   535: invokevirtual   ax/q3/a.close:()V
            //   538: iconst_m1      
            //   539: ireturn        
            //   540: aload           11
            //   542: ifnull          550
            //   545: aload           11
            //   547: invokevirtual   ax/q3/a.close:()V
            //   550: aload_1        
            //   551: athrow         
            //   552: aload_1        
            //   553: ifnull          560
            //   556: aload_1        
            //   557: invokevirtual   ax/q3/a.close:()V
            //   560: bipush          -10
            //   562: ireturn        
            //   563: astore_1       
            //   564: goto            264
            //   567: astore_1       
            //   568: goto            292
            //   571: astore_1       
            //   572: goto            349
            //   575: astore_1       
            //   576: goto            538
            //   579: astore_2       
            //   580: goto            550
            //   583: astore_1       
            //   584: goto            560
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                        
            //  -----  -----  -----  -----  ----------------------------
            //  28     33     502    509    Ljava/io/IOException;
            //  28     33     502    509    Lax/b3/j;
            //  28     33     495    502    Ljava/lang/OutOfMemoryError;
            //  28     33     491    495    Any
            //  37     42     502    509    Ljava/io/IOException;
            //  37     42     502    509    Lax/b3/j;
            //  37     42     495    502    Ljava/lang/OutOfMemoryError;
            //  37     42     491    495    Any
            //  46     64     502    509    Ljava/io/IOException;
            //  46     64     502    509    Lax/b3/j;
            //  46     64     495    502    Ljava/lang/OutOfMemoryError;
            //  46     64     491    495    Any
            //  68     75     502    509    Ljava/io/IOException;
            //  68     75     502    509    Lax/b3/j;
            //  68     75     495    502    Ljava/lang/OutOfMemoryError;
            //  68     75     491    495    Any
            //  75     81     178    185    Ljava/io/IOException;
            //  75     81     178    185    Lax/b3/j;
            //  75     81     171    178    Ljava/lang/OutOfMemoryError;
            //  75     81     163    171    Any
            //  92     100    178    185    Ljava/io/IOException;
            //  92     100    178    185    Lax/b3/j;
            //  92     100    171    178    Ljava/lang/OutOfMemoryError;
            //  92     100    163    171    Any
            //  111    118    178    185    Ljava/io/IOException;
            //  111    118    178    185    Lax/b3/j;
            //  111    118    171    178    Ljava/lang/OutOfMemoryError;
            //  111    118    163    171    Any
            //  128    160    178    185    Ljava/io/IOException;
            //  128    160    178    185    Lax/b3/j;
            //  128    160    171    178    Ljava/lang/OutOfMemoryError;
            //  128    160    163    171    Any
            //  190    218    178    185    Ljava/io/IOException;
            //  190    218    178    185    Lax/b3/j;
            //  190    218    171    178    Ljava/lang/OutOfMemoryError;
            //  190    218    163    171    Any
            //  218    259    178    185    Ljava/io/IOException;
            //  218    259    178    185    Lax/b3/j;
            //  218    259    171    178    Ljava/lang/OutOfMemoryError;
            //  218    259    163    171    Any
            //  259    264    563    567    Ljava/io/IOException;
            //  266    280    178    185    Ljava/io/IOException;
            //  266    280    178    185    Lax/b3/j;
            //  266    280    171    178    Ljava/lang/OutOfMemoryError;
            //  266    280    163    171    Any
            //  287    292    567    571    Ljava/io/IOException;
            //  298    321    178    185    Ljava/io/IOException;
            //  298    321    178    185    Lax/b3/j;
            //  298    321    171    178    Ljava/lang/OutOfMemoryError;
            //  298    321    163    171    Any
            //  344    349    571    575    Ljava/io/IOException;
            //  369    381    178    185    Ljava/io/IOException;
            //  369    381    178    185    Lax/b3/j;
            //  369    381    171    178    Ljava/lang/OutOfMemoryError;
            //  369    381    163    171    Any
            //  384    393    178    185    Ljava/io/IOException;
            //  384    393    178    185    Lax/b3/j;
            //  384    393    171    178    Ljava/lang/OutOfMemoryError;
            //  384    393    163    171    Any
            //  398    413    178    185    Ljava/io/IOException;
            //  398    413    178    185    Lax/b3/j;
            //  398    413    171    178    Ljava/lang/OutOfMemoryError;
            //  398    413    163    171    Any
            //  416    435    178    185    Ljava/io/IOException;
            //  416    435    178    185    Lax/b3/j;
            //  416    435    171    178    Ljava/lang/OutOfMemoryError;
            //  416    435    163    171    Any
            //  438    483    178    185    Ljava/io/IOException;
            //  438    483    178    185    Lax/b3/j;
            //  438    483    171    178    Ljava/lang/OutOfMemoryError;
            //  438    483    163    171    Any
            //  512    530    491    495    Any
            //  534    538    575    579    Ljava/io/IOException;
            //  545    550    579    583    Ljava/io/IOException;
            //  556    560    583    587    Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index 290 out of bounds for length 290
            //     at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            //     at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            //     at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            //     at java.util.Objects.checkIndex(Objects.java:371)
            //     at java.util.ArrayList.get(ArrayList.java:435)
            //     at q5.g.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
            //     at q5.g.b(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:2125)
            //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:21)
            //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
            //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:799)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
            //     at s5.b.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:90)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:367)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:162)
            //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
            //     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
            //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1100)
            //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
            //     at java.lang.Thread.run(Thread.java:1571)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        private int D(final o p0, final com.alphainventor.filemanager.file.n p1) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //     4: new             Ljava/util/ArrayList;
            //     7: dup            
            //     8: invokespecial   java/util/ArrayList.<init>:()V
            //    11: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.Q:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/util/ArrayList;)Ljava/util/ArrayList;
            //    14: pop            
            //    15: aconst_null    
            //    16: astore          10
            //    18: aconst_null    
            //    19: astore          11
            //    21: aconst_null    
            //    22: astore          12
            //    24: aload           12
            //    26: astore          9
            //    28: new             Lax/q3/a;
            //    31: astore          8
            //    33: aload           12
            //    35: astore          9
            //    37: new             Ljava/io/InputStreamReader;
            //    40: astore          13
            //    42: aload           12
            //    44: astore          9
            //    46: aload           13
            //    48: aload_1        
            //    49: aload_2        
            //    50: lconst_0       
            //    51: invokevirtual   com/alphainventor/filemanager/file/o.J:(Lcom/alphainventor/filemanager/file/n;J)Ljava/io/InputStream;
            //    54: aload_0        
            //    55: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //    58: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.T:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/nio/charset/Charset;
            //    61: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
            //    64: aload           12
            //    66: astore          9
            //    68: aload           8
            //    70: aload           13
            //    72: invokespecial   ax/q3/a.<init>:(Ljava/io/Reader;)V
            //    75: iconst_0       
            //    76: istore          6
            //    78: iconst_0       
            //    79: istore_3       
            //    80: aload           8
            //    82: invokevirtual   ax/q3/a.e:()Ljava/lang/String;
            //    85: astore          9
            //    87: aload           9
            //    89: ifnonnull       198
            //    92: iload           6
            //    94: ifeq            150
            //    97: aload_0        
            //    98: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   101: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   104: astore_1       
            //   105: new             Lcom/alphainventor/filemanager/texteditor/TextEditorActivity$j;
            //   108: astore_2       
            //   109: aload_2        
            //   110: aload_0        
            //   111: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   114: ldc             ""
            //   116: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$j.<init>:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/lang/String;)V
            //   119: aload_1        
            //   120: aload_2        
            //   121: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
            //   124: pop            
            //   125: goto            150
            //   128: astore_1       
            //   129: aload           8
            //   131: astore          9
            //   133: goto            377
            //   136: astore_2       
            //   137: aload           8
            //   139: astore_1       
            //   140: goto            346
            //   143: astore_1       
            //   144: aload           8
            //   146: astore_1       
            //   147: goto            389
            //   150: aload_0        
            //   151: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   154: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   157: invokevirtual   java/util/ArrayList.size:()I
            //   160: ifne            191
            //   163: aload_0        
            //   164: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   167: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   170: astore_2       
            //   171: new             Lcom/alphainventor/filemanager/texteditor/TextEditorActivity$j;
            //   174: astore_1       
            //   175: aload_1        
            //   176: aload_0        
            //   177: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   180: ldc             ""
            //   182: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$j.<init>:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/lang/String;)V
            //   185: aload_2        
            //   186: aload_1        
            //   187: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
            //   190: pop            
            //   191: aload           8
            //   193: invokevirtual   ax/q3/a.close:()V
            //   196: iconst_0       
            //   197: ireturn        
            //   198: aload           8
            //   200: invokevirtual   ax/q3/a.a:()Z
            //   203: istore          6
            //   205: aload           9
            //   207: invokevirtual   java/lang/String.length:()I
            //   210: istore          4
            //   212: iload           4
            //   214: ldc             200000
            //   216: if_icmple       227
            //   219: aload           8
            //   221: invokevirtual   ax/q3/a.close:()V
            //   224: bipush          -3
            //   226: ireturn        
            //   227: iconst_0       
            //   228: istore          4
            //   230: iload_3        
            //   231: istore          5
            //   233: iload           4
            //   235: aload           9
            //   237: invokevirtual   java/lang/String.length:()I
            //   240: if_icmpge       294
            //   243: aload_0        
            //   244: aload           9
            //   246: iload           4
            //   248: invokevirtual   java/lang/String.charAt:(I)C
            //   251: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$m.A:(I)Z
            //   254: istore          7
            //   256: iload           5
            //   258: istore_3       
            //   259: iload           7
            //   261: ifeq            285
            //   264: iinc            5, 1
            //   267: iload           5
            //   269: istore_3       
            //   270: iload           5
            //   272: bipush          10
            //   274: if_icmplt       285
            //   277: aload           8
            //   279: invokevirtual   ax/q3/a.close:()V
            //   282: bipush          -3
            //   284: ireturn        
            //   285: iinc            4, 1
            //   288: iload_3        
            //   289: istore          5
            //   291: goto            233
            //   294: aload_0        
            //   295: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   298: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   301: astore_1       
            //   302: new             Lcom/alphainventor/filemanager/texteditor/TextEditorActivity$j;
            //   305: astore_2       
            //   306: aload_2        
            //   307: aload_0        
            //   308: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   311: aload           9
            //   313: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$j.<init>:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/lang/String;)V
            //   316: aload_1        
            //   317: aload_2        
            //   318: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
            //   321: pop            
            //   322: iload           5
            //   324: istore_3       
            //   325: goto            80
            //   328: astore_1       
            //   329: goto            377
            //   332: astore_2       
            //   333: aload           10
            //   335: astore_1       
            //   336: goto            346
            //   339: astore_1       
            //   340: aload           11
            //   342: astore_1       
            //   343: goto            389
            //   346: aload_1        
            //   347: astore          9
            //   349: invokestatic    ax/Ha/c.h:()Lax/Ha/b;
            //   352: ldc             "TEXT EDITOR OOM"
            //   354: invokevirtual   ax/Ha/b.d:(Ljava/lang/String;)Lax/Ha/b;
            //   357: aload_2        
            //   358: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
            //   361: invokevirtual   ax/Ha/b.g:(Ljava/lang/Object;)Lax/Ha/b;
            //   364: invokevirtual   ax/Ha/b.h:()V
            //   367: aload_1        
            //   368: ifnull          375
            //   371: aload_1        
            //   372: invokevirtual   ax/q3/a.close:()V
            //   375: iconst_m1      
            //   376: ireturn        
            //   377: aload           9
            //   379: ifnull          387
            //   382: aload           9
            //   384: invokevirtual   ax/q3/a.close:()V
            //   387: aload_1        
            //   388: athrow         
            //   389: aload_1        
            //   390: ifnull          397
            //   393: aload_1        
            //   394: invokevirtual   ax/q3/a.close:()V
            //   397: bipush          -10
            //   399: ireturn        
            //   400: astore_1       
            //   401: goto            196
            //   404: astore_1       
            //   405: goto            224
            //   408: astore_1       
            //   409: goto            282
            //   412: astore_1       
            //   413: goto            375
            //   416: astore_2       
            //   417: goto            387
            //   420: astore_1       
            //   421: goto            397
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                        
            //  -----  -----  -----  -----  ----------------------------
            //  28     33     339    346    Ljava/io/IOException;
            //  28     33     339    346    Lax/b3/j;
            //  28     33     332    339    Ljava/lang/OutOfMemoryError;
            //  28     33     328    332    Any
            //  37     42     339    346    Ljava/io/IOException;
            //  37     42     339    346    Lax/b3/j;
            //  37     42     332    339    Ljava/lang/OutOfMemoryError;
            //  37     42     328    332    Any
            //  46     64     339    346    Ljava/io/IOException;
            //  46     64     339    346    Lax/b3/j;
            //  46     64     332    339    Ljava/lang/OutOfMemoryError;
            //  46     64     328    332    Any
            //  68     75     339    346    Ljava/io/IOException;
            //  68     75     339    346    Lax/b3/j;
            //  68     75     332    339    Ljava/lang/OutOfMemoryError;
            //  68     75     328    332    Any
            //  80     87     143    150    Ljava/io/IOException;
            //  80     87     143    150    Lax/b3/j;
            //  80     87     136    143    Ljava/lang/OutOfMemoryError;
            //  80     87     128    136    Any
            //  97     125    143    150    Ljava/io/IOException;
            //  97     125    143    150    Lax/b3/j;
            //  97     125    136    143    Ljava/lang/OutOfMemoryError;
            //  97     125    128    136    Any
            //  150    191    143    150    Ljava/io/IOException;
            //  150    191    143    150    Lax/b3/j;
            //  150    191    136    143    Ljava/lang/OutOfMemoryError;
            //  150    191    128    136    Any
            //  191    196    400    404    Ljava/io/IOException;
            //  198    212    143    150    Ljava/io/IOException;
            //  198    212    143    150    Lax/b3/j;
            //  198    212    136    143    Ljava/lang/OutOfMemoryError;
            //  198    212    128    136    Any
            //  219    224    404    408    Ljava/io/IOException;
            //  233    256    143    150    Ljava/io/IOException;
            //  233    256    143    150    Lax/b3/j;
            //  233    256    136    143    Ljava/lang/OutOfMemoryError;
            //  233    256    128    136    Any
            //  277    282    408    412    Ljava/io/IOException;
            //  294    322    143    150    Ljava/io/IOException;
            //  294    322    143    150    Lax/b3/j;
            //  294    322    136    143    Ljava/lang/OutOfMemoryError;
            //  294    322    128    136    Any
            //  349    367    328    332    Any
            //  371    375    412    416    Ljava/io/IOException;
            //  382    387    416    420    Ljava/io/IOException;
            //  393    397    420    424    Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index 212 out of bounds for length 212
            //     at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            //     at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            //     at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            //     at java.util.Objects.checkIndex(Objects.java:371)
            //     at java.util.ArrayList.get(ArrayList.java:435)
            //     at q5.g.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
            //     at q5.g.b(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:2125)
            //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:21)
            //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
            //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:799)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
            //     at s5.b.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:90)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:367)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:162)
            //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
            //     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
            //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1100)
            //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
            //     at java.lang.Thread.run(Thread.java:1571)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        protected void B(final Integer n) {
            if (!this.h) {
                this.i.s.k0(false);
                this.h = true;
            }
            ((View)this.i.e).setVisibility(8);
            if (n == 0) {
                final TextEditorActivity i = this.i;
                i.c = new i(i.j);
                this.i.b.setAdapter((RecyclerView$h)this.i.c);
                this.i.O0(TextEditorActivity.h.c0);
                if (this.i.A != null && this.i.B != null) {
                    ax.Q2.a.i().o("text_editor_open").b("loc", this.i.A).b("ext", this.i.B).b("range", a$f.a(this.i.C)).c();
                }
                return;
            }
            if (n == -1) {
                Toast.makeText((Context)this.i, 2131951967, 1).show();
                ((Activity)this.i).finish();
                return;
            }
            if (n == -3) {
                Toast.makeText((Context)this.i, 2131951953, 1).show();
                ((Activity)this.i).finish();
                return;
            }
            Toast.makeText((Context)this.i, 2131951934, 1).show();
            ((Activity)this.i).finish();
        }
        
        protected void o() {
            super.o();
            if (!this.h) {
                this.i.s.k0(false);
                this.h = true;
            }
        }
        
        protected void r() {
            ((View)this.i.e).setVisibility(0);
            this.i.s.n0();
        }
        
        void w(final o p0, final com.alphainventor.filemanager.file.n p1) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: aconst_null    
            //     4: astore          7
            //     6: aload           7
            //     8: astore          4
            //    10: new             Ljava/io/BufferedInputStream;
            //    13: astore          5
            //    15: aload           7
            //    17: astore          4
            //    19: aload           5
            //    21: aload_1        
            //    22: aload_2        
            //    23: lconst_0       
            //    24: invokevirtual   com/alphainventor/filemanager/file/o.J:(Lcom/alphainventor/filemanager/file/n;J)Ljava/io/InputStream;
            //    27: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
            //    30: new             Lax/Rd/c;
            //    33: astore_1       
            //    34: aload_1        
            //    35: aconst_null    
            //    36: invokespecial   ax/Rd/c.<init>:(Lax/Rd/a;)V
            //    39: sipush          4096
            //    42: newarray        B
            //    44: astore_2       
            //    45: aload           5
            //    47: aload_2        
            //    48: invokevirtual   java/io/InputStream.read:([B)I
            //    51: istore_3       
            //    52: iload_3        
            //    53: iconst_m1      
            //    54: if_icmpeq       101
            //    57: aload_1        
            //    58: aload_2        
            //    59: iconst_0       
            //    60: iload_3        
            //    61: invokevirtual   ax/Rd/c.d:([BII)V
            //    64: aload_1        
            //    65: invokevirtual   ax/Rd/c.c:()Ljava/lang/String;
            //    68: ifnull          45
            //    71: goto            101
            //    74: astore_1       
            //    75: aload           5
            //    77: astore          4
            //    79: goto            288
            //    82: astore_1       
            //    83: aload           5
            //    85: astore_2       
            //    86: goto            208
            //    89: astore_1       
            //    90: goto            83
            //    93: astore_1       
            //    94: goto            83
            //    97: astore_1       
            //    98: goto            83
            //   101: aload_1        
            //   102: invokevirtual   ax/Rd/c.a:()V
            //   105: aload_1        
            //   106: invokevirtual   ax/Rd/c.c:()Ljava/lang/String;
            //   109: astore_1       
            //   110: aload_1        
            //   111: ifnull          150
            //   114: ldc_w           "US-ASCII"
            //   117: aload_1        
            //   118: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
            //   121: ifeq            138
            //   124: aload_0        
            //   125: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   128: invokestatic    java/nio/charset/Charset.defaultCharset:()Ljava/nio/charset/Charset;
            //   131: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.U:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
            //   134: pop            
            //   135: goto            150
            //   138: aload_0        
            //   139: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   142: aload_1        
            //   143: invokestatic    java/nio/charset/Charset.forName:(Ljava/lang/String;)Ljava/nio/charset/Charset;
            //   146: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.U:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
            //   149: pop            
            //   150: aload_0        
            //   151: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   154: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.T:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/nio/charset/Charset;
            //   157: ifnonnull       171
            //   160: aload_0        
            //   161: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   164: invokestatic    java/nio/charset/Charset.defaultCharset:()Ljava/nio/charset/Charset;
            //   167: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.U:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
            //   170: pop            
            //   171: aload           5
            //   173: invokevirtual   java/io/InputStream.close:()V
            //   176: goto            244
            //   179: astore_1       
            //   180: goto            288
            //   183: astore_1       
            //   184: aload           6
            //   186: astore_2       
            //   187: goto            208
            //   190: astore_1       
            //   191: aload           6
            //   193: astore_2       
            //   194: goto            208
            //   197: astore_1       
            //   198: aload           6
            //   200: astore_2       
            //   201: goto            208
            //   204: astore_1       
            //   205: aload           6
            //   207: astore_2       
            //   208: aload_2        
            //   209: astore          4
            //   211: aload_1        
            //   212: invokevirtual   java/lang/Throwable.printStackTrace:()V
            //   215: aload_0        
            //   216: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   219: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.T:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/nio/charset/Charset;
            //   222: ifnonnull       236
            //   225: aload_0        
            //   226: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   229: invokestatic    java/nio/charset/Charset.defaultCharset:()Ljava/nio/charset/Charset;
            //   232: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.U:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
            //   235: pop            
            //   236: aload_2        
            //   237: ifnull          244
            //   240: aload_2        
            //   241: invokevirtual   java/io/InputStream.close:()V
            //   244: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.g0:()Ljava/util/logging/Logger;
            //   247: astore_2       
            //   248: new             Ljava/lang/StringBuilder;
            //   251: dup            
            //   252: invokespecial   java/lang/StringBuilder.<init>:()V
            //   255: astore_1       
            //   256: aload_1        
            //   257: ldc_w           "DETECTED ENCODING : "
            //   260: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   263: pop            
            //   264: aload_1        
            //   265: aload_0        
            //   266: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   269: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.T:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/nio/charset/Charset;
            //   272: invokevirtual   java/nio/charset/Charset.name:()Ljava/lang/String;
            //   275: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   278: pop            
            //   279: aload_2        
            //   280: aload_1        
            //   281: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   284: invokevirtual   java/util/logging/Logger.fine:(Ljava/lang/String;)V
            //   287: return         
            //   288: aload_0        
            //   289: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   292: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.T:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/nio/charset/Charset;
            //   295: ifnonnull       309
            //   298: aload_0        
            //   299: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$m.i:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   302: invokestatic    java/nio/charset/Charset.defaultCharset:()Ljava/nio/charset/Charset;
            //   305: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.U:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
            //   308: pop            
            //   309: aload           4
            //   311: ifnull          319
            //   314: aload           4
            //   316: invokevirtual   java/io/InputStream.close:()V
            //   319: aload_1        
            //   320: athrow         
            //   321: astore_1       
            //   322: goto            244
            //   325: astore_2       
            //   326: goto            319
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                          
            //  -----  -----  -----  -----  ----------------------------------------------
            //  10     15     204    208    Ljava/io/IOException;
            //  10     15     197    204    Ljava/nio/charset/UnsupportedCharsetException;
            //  10     15     190    197    Ljava/nio/charset/IllegalCharsetNameException;
            //  10     15     183    190    Lax/b3/j;
            //  10     15     179    183    Any
            //  19     30     204    208    Ljava/io/IOException;
            //  19     30     197    204    Ljava/nio/charset/UnsupportedCharsetException;
            //  19     30     190    197    Ljava/nio/charset/IllegalCharsetNameException;
            //  19     30     183    190    Lax/b3/j;
            //  19     30     179    183    Any
            //  30     45     97     101    Ljava/io/IOException;
            //  30     45     93     97     Ljava/nio/charset/UnsupportedCharsetException;
            //  30     45     89     93     Ljava/nio/charset/IllegalCharsetNameException;
            //  30     45     82     83     Lax/b3/j;
            //  30     45     74     82     Any
            //  45     52     97     101    Ljava/io/IOException;
            //  45     52     93     97     Ljava/nio/charset/UnsupportedCharsetException;
            //  45     52     89     93     Ljava/nio/charset/IllegalCharsetNameException;
            //  45     52     82     83     Lax/b3/j;
            //  45     52     74     82     Any
            //  57     71     97     101    Ljava/io/IOException;
            //  57     71     93     97     Ljava/nio/charset/UnsupportedCharsetException;
            //  57     71     89     93     Ljava/nio/charset/IllegalCharsetNameException;
            //  57     71     82     83     Lax/b3/j;
            //  57     71     74     82     Any
            //  101    110    97     101    Ljava/io/IOException;
            //  101    110    93     97     Ljava/nio/charset/UnsupportedCharsetException;
            //  101    110    89     93     Ljava/nio/charset/IllegalCharsetNameException;
            //  101    110    82     83     Lax/b3/j;
            //  101    110    74     82     Any
            //  114    135    97     101    Ljava/io/IOException;
            //  114    135    93     97     Ljava/nio/charset/UnsupportedCharsetException;
            //  114    135    89     93     Ljava/nio/charset/IllegalCharsetNameException;
            //  114    135    82     83     Lax/b3/j;
            //  114    135    74     82     Any
            //  138    150    97     101    Ljava/io/IOException;
            //  138    150    93     97     Ljava/nio/charset/UnsupportedCharsetException;
            //  138    150    89     93     Ljava/nio/charset/IllegalCharsetNameException;
            //  138    150    82     83     Lax/b3/j;
            //  138    150    74     82     Any
            //  171    176    321    325    Ljava/io/IOException;
            //  211    215    179    183    Any
            //  240    244    321    325    Ljava/io/IOException;
            //  314    319    325    329    Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0171:
            //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
            //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
            //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
            //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
            //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:799)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
            //     at s5.b.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:90)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:367)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:162)
            //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
            //     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
            //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1100)
            //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
            //     at java.lang.Thread.run(Thread.java:1571)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        void x(o o, com.alphainventor.filemanager.file.n ex) {
            final Object o2 = null;
            ax.q3.a a2;
            final ax.q3.a a = a2 = null;
            Label_0308: {
                Label_0242: {
                    try {
                        try {
                            a2 = a;
                            a2 = a;
                            final InputStreamReader inputStreamReader = new InputStreamReader(((o)o).J((com.alphainventor.filemanager.file.n)ex, 0L), this.i.k);
                            a2 = a;
                            final ax.q3.a a3 = new ax.q3.a((Reader)inputStreamReader);
                            Label_0149: {
                                try {
                                    ex = (IOException)(Object)new char[2048];
                                    int i;
                                    int f0;
                                    do {
                                        final int read = ((Reader)a3).read((char[])(Object)ex);
                                        if (read == -1) {
                                            break Label_0149;
                                        }
                                        final String s = new String((char[])(Object)ex, 0, read);
                                        i = TextEditorActivity.F0(s, "\n");
                                        f0 = TextEditorActivity.F0(s, "\r\n");
                                    } while (i == 0);
                                    if (i > f0 * 2) {}
                                }
                                catch (final ax.b3.j j) {}
                                catch (final IOException ex) {}
                                finally {
                                    a2 = a3;
                                    break Label_0308;
                                }
                            }
                            final String s2;
                            this.i.l = s2;
                            if (this.i.l == null) {
                                this.i.l = "\n";
                            }
                            try {
                                a3.close();
                                break Label_0242;
                            }
                            catch (final IOException ex2) {
                                break Label_0242;
                            }
                        }
                        finally {}
                    }
                    catch (final ax.b3.j ex) {
                        o = o2;
                    }
                    catch (final IOException ex) {
                        o = o2;
                    }
                    ((Throwable)ex).printStackTrace();
                    if (this.i.l == null) {
                        this.i.l = "\n";
                    }
                    if (o != null) {
                        ((ax.q3.a)o).close();
                    }
                }
                final Logger g0 = TextEditorActivity.D;
                final StringBuilder sb = new StringBuilder();
                sb.append("DETECTED NEWLINE : ");
                String s3;
                if ("\r\n".equals((Object)this.i.l)) {
                    s3 = "CRLF";
                }
                else {
                    s3 = "LF";
                }
                sb.append(s3);
                g0.fine(sb.toString());
                return;
            }
            if (this.i.l == null) {
                this.i.l = "\n";
            }
            Label_0339: {
                if (a2 == null) {
                    break Label_0339;
                }
                try {
                    a2.close();
                    throw o;
                }
                catch (final IOException ex3) {
                    throw o;
                }
            }
        }
        
        protected Integer y(final Void... array) {
            try {
                final com.alphainventor.filemanager.file.n z = this.i.s.z(this.i.h);
                if (this.z(z)) {
                    return -1;
                }
                this.w(this.i.s, z);
                this.x(this.i.s, z);
                if (TextEditorActivity.E) {
                    this.i.r = true;
                    return this.C(this.i.s, z);
                }
                final int d = this.D(this.i.s, z);
                final TextEditorActivity i = this.i;
                i.C = i.j.size();
                if (d == 0 && this.i.j.size() < 1000) {
                    this.i.r = true;
                    return this.C(this.i.s, z);
                }
                this.i.r = false;
                return d;
            }
            catch (final ax.b3.j j) {
                return -10;
            }
        }
        
        boolean z(final com.alphainventor.filemanager.file.n n) {
            if (((ax.c3.b)n).p() < 102400L) {
                return false;
            }
            final long n2 = ((ax.c3.b)n).p() / 1048576L;
            return n2 > 30L || n2 > ((ActivityManager)((Context)this.i).getApplicationContext().getSystemService("activity")).getMemoryClass() * 4 / 10 || n2 > (Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) - Debug.getNativeHeapAllocatedSize()) / 1048576L * 4L / 10L;
        }
    }
    
    class n extends q<Void, Void, Boolean>
    {
        private boolean h;
        boolean i;
        boolean j;
        Throwable k;
        final TextEditorActivity l;
        
        n(final TextEditorActivity l, final boolean i) {
            this.l = l;
            super(q$e.d0);
            this.i = i;
        }
        
        private void A() throws IOException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: astore          4
            //     3: aload_0        
            //     4: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //     7: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.C0:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Lcom/alphainventor/filemanager/file/o;
            //    10: invokevirtual   com/alphainventor/filemanager/file/o.u:()Lcom/alphainventor/filemanager/file/m;
            //    13: astore_3       
            //    14: aload_3        
            //    15: instanceof      Lcom/alphainventor/filemanager/file/x;
            //    18: istore_2       
            //    19: iconst_0       
            //    20: istore_1       
            //    21: iload_2        
            //    22: ifeq            48
            //    25: aload_3        
            //    26: checkcast       Lcom/alphainventor/filemanager/file/x;
            //    29: aload_0        
            //    30: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //    33: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.L:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/lang/String;
            //    36: iconst_0       
            //    37: invokevirtual   com/alphainventor/filemanager/file/x.c:(Ljava/lang/String;Z)Ljava/io/OutputStream;
            //    40: astore_3       
            //    41: goto            79
            //    44: astore_3       
            //    45: goto            301
            //    48: aload_3        
            //    49: instanceof      Lcom/alphainventor/filemanager/file/h;
            //    52: ifeq            74
            //    55: aload_3        
            //    56: checkcast       Lcom/alphainventor/filemanager/file/h;
            //    59: aload_0        
            //    60: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //    63: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.L:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/lang/String;
            //    66: iconst_0       
            //    67: invokevirtual   com/alphainventor/filemanager/file/h.c:(Ljava/lang/String;Z)Ljava/io/OutputStream;
            //    70: astore_3       
            //    71: goto            79
            //    74: invokestatic    ax/u3/b.f:()V
            //    77: aconst_null    
            //    78: astore_3       
            //    79: ldc             "\r\n"
            //    81: aload_0        
            //    82: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //    85: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.R:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/lang/String;
            //    88: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
            //    91: istore_2       
            //    92: new             Ljava/io/BufferedWriter;
            //    95: astore          5
            //    97: new             Ljava/io/OutputStreamWriter;
            //   100: astore          6
            //   102: aload           6
            //   104: aload_3        
            //   105: aload_0        
            //   106: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   109: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.T:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/nio/charset/Charset;
            //   112: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
            //   115: aload           5
            //   117: aload           6
            //   119: invokespecial   java/io/BufferedWriter.<init>:(Ljava/io/Writer;)V
            //   122: aload_0        
            //   123: invokevirtual   com/alphainventor/filemanager/texteditor/TextEditorActivity$n.x:()Z
            //   126: ifne            290
            //   129: iload_1        
            //   130: aload_0        
            //   131: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   134: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   137: invokevirtual   java/util/ArrayList.size:()I
            //   140: if_icmpge       290
            //   143: aload_0        
            //   144: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   147: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   150: iload_1        
            //   151: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
            //   154: checkcast       Lcom/alphainventor/filemanager/texteditor/TextEditorActivity$j;
            //   157: astore_3       
            //   158: iload_2        
            //   159: ifeq            214
            //   162: aload_3        
            //   163: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$j.a:Ljava/lang/String;
            //   166: ifnull          214
            //   169: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.V:()Ljava/util/regex/Pattern;
            //   172: ifnonnull       195
            //   175: ldc             "(?<!\r)\n"
            //   177: invokestatic    java/util/regex/Pattern.compile:(Ljava/lang/String;)Ljava/util/regex/Pattern;
            //   180: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.W:(Ljava/util/regex/Pattern;)Ljava/util/regex/Pattern;
            //   183: pop            
            //   184: goto            195
            //   187: astore_3       
            //   188: aload           5
            //   190: astore          4
            //   192: goto            301
            //   195: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.V:()Ljava/util/regex/Pattern;
            //   198: aload_3        
            //   199: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$j.a:Ljava/lang/String;
            //   202: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
            //   205: ldc             "\r\n"
            //   207: invokevirtual   java/util/regex/Matcher.replaceAll:(Ljava/lang/String;)Ljava/lang/String;
            //   210: astore_3       
            //   211: goto            219
            //   214: aload_3        
            //   215: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$j.a:Ljava/lang/String;
            //   218: astore_3       
            //   219: iload_1        
            //   220: aload_0        
            //   221: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   224: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.O:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/util/ArrayList;
            //   227: invokevirtual   java/util/ArrayList.size:()I
            //   230: iconst_1       
            //   231: isub           
            //   232: if_icmpne       244
            //   235: aload           5
            //   237: aload_3        
            //   238: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
            //   241: goto            284
            //   244: new             Ljava/lang/StringBuilder;
            //   247: astore          4
            //   249: aload           4
            //   251: invokespecial   java/lang/StringBuilder.<init>:()V
            //   254: aload           4
            //   256: aload_3        
            //   257: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   260: pop            
            //   261: aload           4
            //   263: aload_0        
            //   264: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   267: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.R:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/lang/String;
            //   270: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   273: pop            
            //   274: aload           5
            //   276: aload           4
            //   278: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   281: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
            //   284: iinc            1, 1
            //   287: goto            129
            //   290: aload           5
            //   292: invokevirtual   java/io/BufferedWriter.flush:()V
            //   295: aload           5
            //   297: invokevirtual   java/io/BufferedWriter.close:()V
            //   300: return         
            //   301: aload           4
            //   303: ifnull          311
            //   306: aload           4
            //   308: invokevirtual   java/io/BufferedWriter.close:()V
            //   311: aload_3        
            //   312: athrow         
            //   313: astore_3       
            //   314: goto            300
            //   317: astore          4
            //   319: goto            311
            //    Exceptions:
            //  throws java.io.IOException
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                 
            //  -----  -----  -----  -----  ---------------------
            //  3      19     44     48     Any
            //  25     41     44     48     Any
            //  48     71     44     48     Any
            //  74     77     44     48     Any
            //  79     122    44     48     Any
            //  122    129    187    195    Any
            //  129    158    187    195    Any
            //  162    184    187    195    Any
            //  195    211    187    195    Any
            //  214    219    187    195    Any
            //  219    241    187    195    Any
            //  244    284    187    195    Any
            //  290    295    187    195    Any
            //  295    300    313    317    Ljava/io/IOException;
            //  306    311    317    322    Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0311:
            //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
            //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
            //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
            //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
            //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:799)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
            //     at s5.b.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:90)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:367)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:162)
            //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
            //     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
            //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1100)
            //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
            //     at java.lang.Thread.run(Thread.java:1571)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        protected void o() {
            if (!this.h) {
                this.l.s.k0(true);
                this.h = true;
            }
            if (!this.j) {
                this.l.I0();
            }
        }
        
        protected void r() {
            this.l.s.n0();
            if (!(this.j = this.l.M0())) {
                this.l.P0();
            }
        }
        
        protected Boolean w(final Void... p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$n.A:()V
            //     4: aload_0        
            //     5: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //     8: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.J:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Lax/Z2/k;
            //    11: ifnull          216
            //    14: aload_0        
            //    15: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.j:Z
            //    18: istore_2       
            //    19: iload_2        
            //    20: ifne            216
            //    23: aload_0        
            //    24: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //    27: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.J:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Lax/Z2/k;
            //    30: invokevirtual   ax/Z2/k.d:()Lax/c3/K;
            //    33: invokestatic    ax/c3/x.e:(Lax/c3/K;)Lcom/alphainventor/filemanager/file/o;
            //    36: astore          8
            //    38: aload           8
            //    40: invokevirtual   com/alphainventor/filemanager/file/o.a:()Z
            //    43: istore_2       
            //    44: iload_2        
            //    45: ifne            86
            //    48: aload           8
            //    50: ldc2_w          10000
            //    53: invokevirtual   com/alphainventor/filemanager/file/o.i:(J)Z
            //    56: ifeq            62
            //    59: goto            86
            //    62: new             Ljava/io/IOException;
            //    65: astore_1       
            //    66: aload_1        
            //    67: ldc             "Not connected to network storage"
            //    69: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
            //    72: aload_1        
            //    73: athrow         
            //    74: astore_1       
            //    75: goto            252
            //    78: astore_1       
            //    79: goto            197
            //    82: astore_1       
            //    83: goto            79
            //    86: aload           8
            //    88: aload_0        
            //    89: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //    92: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.J:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Lax/Z2/k;
            //    95: invokevirtual   ax/Z2/k.e:()Ljava/lang/String;
            //    98: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
            //   101: astore_1       
            //   102: aload_0        
            //   103: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   106: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.C0:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Lcom/alphainventor/filemanager/file/o;
            //   109: aload_0        
            //   110: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   113: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.L:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Ljava/lang/String;
            //   116: invokevirtual   com/alphainventor/filemanager/file/o.z:(Ljava/lang/String;)Lcom/alphainventor/filemanager/file/n;
            //   119: astore          5
            //   121: aload_1        
            //   122: invokevirtual   com/alphainventor/filemanager/file/n.N:()Ljava/io/File;
            //   125: invokevirtual   java/io/File.lastModified:()J
            //   128: lstore_3       
            //   129: aload_0        
            //   130: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   133: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.C0:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Lcom/alphainventor/filemanager/file/o;
            //   136: astore          7
            //   138: new             Lcom/alphainventor/filemanager/texteditor/TextEditorActivity$n$a;
            //   141: astore          6
            //   143: aload           6
            //   145: aload_0        
            //   146: invokespecial   com/alphainventor/filemanager/texteditor/TextEditorActivity$n$a.<init>:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity$n;)V
            //   149: aload           7
            //   151: aload           5
            //   153: aload           8
            //   155: aload_1        
            //   156: aload_0        
            //   157: aload           6
            //   159: invokevirtual   com/alphainventor/filemanager/file/o.t0:(Lcom/alphainventor/filemanager/file/n;Lcom/alphainventor/filemanager/file/o;Lcom/alphainventor/filemanager/file/n;Lax/u3/c;Lax/g3/i;)V
            //   162: invokestatic    ax/o3/e.b:()Lax/o3/e;
            //   165: aload_1        
            //   166: lload_3        
            //   167: invokevirtual   ax/o3/e.j:(Lcom/alphainventor/filemanager/file/n;J)V
            //   170: goto            216
            //   173: astore_1       
            //   174: goto            252
            //   177: astore_1       
            //   178: goto            197
            //   181: astore_1       
            //   182: goto            178
            //   185: astore_1       
            //   186: goto            174
            //   189: astore_1       
            //   190: goto            178
            //   193: astore_1       
            //   194: goto            190
            //   197: aload_0        
            //   198: aload_1        
            //   199: putfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.k:Ljava/lang/Throwable;
            //   202: new             Ljava/io/IOException;
            //   205: astore          5
            //   207: aload           5
            //   209: aload_1        
            //   210: invokespecial   java/io/IOException.<init>:(Ljava/lang/Throwable;)V
            //   213: aload           5
            //   215: athrow         
            //   216: invokestatic    ax/X2/Q.X1:()Z
            //   219: ifeq            246
            //   222: aload_0        
            //   223: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   226: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.C0:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Lcom/alphainventor/filemanager/file/o;
            //   229: invokevirtual   com/alphainventor/filemanager/file/o.Y:()Z
            //   232: ifeq            246
            //   235: aload_0        
            //   236: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.l:Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;
            //   239: invokestatic    com/alphainventor/filemanager/texteditor/TextEditorActivity.C0:(Lcom/alphainventor/filemanager/texteditor/TextEditorActivity;)Lcom/alphainventor/filemanager/file/o;
            //   242: aconst_null    
            //   243: invokevirtual   com/alphainventor/filemanager/file/o.n:(Lax/g3/i;)V
            //   246: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
            //   249: astore_1       
            //   250: aload_1        
            //   251: areturn        
            //   252: aload_0        
            //   253: getfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.k:Ljava/lang/Throwable;
            //   256: ifnonnull       264
            //   259: aload_0        
            //   260: aload_1        
            //   261: putfield        com/alphainventor/filemanager/texteditor/TextEditorActivity$n.k:Ljava/lang/Throwable;
            //   264: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
            //   267: areturn        
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                 
            //  -----  -----  -----  -----  ---------------------
            //  0      19     185    189    Ljava/io/IOException;
            //  23     44     193    197    Lax/b3/j;
            //  23     44     189    190    Lax/b3/a;
            //  23     44     185    189    Ljava/io/IOException;
            //  48     59     82     86     Lax/b3/j;
            //  48     59     78     79     Lax/b3/a;
            //  48     59     74     78     Ljava/io/IOException;
            //  62     74     82     86     Lax/b3/j;
            //  62     74     78     79     Lax/b3/a;
            //  62     74     74     78     Ljava/io/IOException;
            //  86     149    193    197    Lax/b3/j;
            //  86     149    189    190    Lax/b3/a;
            //  86     149    185    189    Ljava/io/IOException;
            //  149    170    181    185    Lax/b3/j;
            //  149    170    177    178    Lax/b3/a;
            //  149    170    173    174    Ljava/io/IOException;
            //  197    216    173    174    Ljava/io/IOException;
            //  216    246    173    174    Ljava/io/IOException;
            //  246    250    173    174    Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0062:
            //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
            //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
            //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
            //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
            //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:799)
            //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
            //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
            //     at s5.b.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:90)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:367)
            //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:162)
            //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
            //     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
            //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1100)
            //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
            //     at java.lang.Thread.run(Thread.java:1571)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        boolean x() {
            return this.l.j.size() == 1 && ((j)this.l.j.get(0)).a.length() == 0;
        }
        
        protected void y(final Boolean b) {
            if (!this.h) {
                this.l.s.k0(true);
                this.h = true;
            }
            if (!this.j) {
                this.l.I0();
            }
            if (b) {
                this.l.O0(TextEditorActivity.h.e0);
                if (this.i) {
                    ((Activity)this.l).finish();
                }
                return;
            }
            String s;
            if (ax.t3.j.o((Context)this.l) && this.k != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append(((Context)this.l).getString(2131951936));
                sb.append(" : ");
                sb.append(this.k.getMessage());
                s = sb.toString();
            }
            else {
                s = ((Context)this.l).getString(2131951936);
            }
            this.z(s);
        }
        
        void z(final String s) {
            final StringBuilder sb = new StringBuilder();
            sb.append("<font color='red'>");
            sb.append(s);
            sb.append("</font>");
            ax.u3.B.T(((ax.n.c)this.l).findViewById(16908290), (CharSequence)Html.fromHtml(sb.toString()), 0).a0();
        }
    }
}
