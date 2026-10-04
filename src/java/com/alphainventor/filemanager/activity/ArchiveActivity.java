package com.alphainventor.filemanager.activity;

import ax.c3.W;
import android.app.Activity;
import ax.d3.E;
import android.os.BaseBundle;
import android.content.ContentResolver;
import ax.g3.i;
import com.alphainventor.filemanager.file.p;
import ax.c3.G;
import java.io.InputStream;
import ax.c3.U;
import java.io.FileNotFoundException;
import android.database.sqlite.SQLiteException;
import ax.u3.q$e;
import ax.u3.q;
import com.alphainventor.filemanager.bookmark.Bookmark;
import android.view.MenuItem;
import android.view.KeyEvent;
import java.io.IOException;
import ax.c3.d0;
import ax.c3.B;
import ax.b3.j;
import com.alphainventor.filemanager.provider.MyFileProvider;
import android.widget.Toast;
import ax.c3.x;
import android.view.ViewGroup;
import ax.X2.v;
import ax.u3.z;
import ax.X2.Q;
import ax.Q2.f;
import ax.d3.n;
import android.content.Context;
import ax.Z2.a;
import com.alphainventor.filemanager.shizuku.c;
import com.alphainventor.filemanager.file.y;
import ax.c3.u;
import com.alphainventor.filemanager.file.o;
import androidx.fragment.app.Fragment;
import ax.Z2.k;
import android.os.Parcelable;
import android.os.Bundle;
import android.net.Uri;
import java.io.File;
import ax.x3.h;
import ax.d3.l;
import android.os.ParcelFileDescriptor;
import java.util.ArrayList;
import ax.x3.A;

public class ArchiveActivity extends com.alphainventor.filemanager.activity.b
{
    private A A;
    private ArrayList<ParcelFileDescriptor> B;
    private boolean C;
    private l y;
    h z;
    
    public ArchiveActivity() {
        this.B = (ArrayList<ParcelFileDescriptor>)new ArrayList();
    }
    
    private void S0(final Uri uri, final String s, final ParcelFileDescriptor parcelFileDescriptor, final Uri uri2) {
        final l l = new l();
        final Bundle bundle = new Bundle();
        bundle.putParcelable("archive_uri", (Parcelable)uri);
        ((BaseBundle)bundle).putInt("archive_file_type", 3);
        ((BaseBundle)bundle).putString("archive_name", s);
        ((BaseBundle)bundle).putInt("file_descriptor", parcelFileDescriptor.getFd());
        ((BaseBundle)bundle).putInt("location_key", com.alphainventor.filemanager.file.b.M0(uri));
        ((Fragment)l).v2(bundle);
        this.T0(l, uri2);
    }
    
    private void T0(final l y, final Uri uri) {
        this.y = y;
        Label_0045: {
            if (uri != null) {
                Label_0040: {
                    try {
                        final k a = ax.Z2.k.a(uri);
                        if (a.d() != ((n)y).A3()) {
                            break Label_0040;
                        }
                        ((E)y).Z3(a.e());
                    }
                    catch (final IllegalArgumentException ex) {}
                    break Label_0045;
                }
                ax.u3.b.g("location unit does not match");
            }
        }
        if (!((Activity)this).isFinishing() && !((androidx.fragment.app.f)this).getSupportFragmentManager().I0()) {
            ((androidx.fragment.app.f)this).getSupportFragmentManager().o().s(2131362331, (Fragment)this.y, "archive").g("archive").j();
        }
    }
    
    private void U0(final String s, final Uri uri, final int n, final Uri uri2, final o o) {
        final l l = new l();
        final Bundle bundle = new Bundle();
        bundle.putParcelable("archive_uri", (Parcelable)uri);
        ((BaseBundle)bundle).putInt("archive_file_type", n);
        ((BaseBundle)bundle).putString("archive_name", s);
        bundle.putParcelable("open_uri", (Parcelable)uri2);
        if (o != null) {
            l.Ea(o);
            ((BaseBundle)bundle).putInt("location_key", o.y());
        }
        else {
            ((BaseBundle)bundle).putInt("location_key", com.alphainventor.filemanager.file.b.M0(uri));
        }
        ((Fragment)l).v2(bundle);
        this.T0(l, uri2);
    }
    
    private void V0(final String s, final File file, final int n, final Uri uri) {
        this.U0(s, ax.c3.u.w(file), n, uri, null);
    }
    
    private boolean W0(final File file) {
        try {
            final y i0 = com.alphainventor.filemanager.file.y.I0(file.getAbsolutePath());
            return i0.a1() && com.alphainventor.filemanager.shizuku.c.t().l() && i0.n();
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    private File Y0(final String s) {
        final File m = ax.Z2.a.m((Context)this, "archive-tmp");
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        final File file = new File(m, sb.toString());
        file.mkdir();
        return new File(file, s);
    }
    
    @Override
    public void L0() {
        this.invalidateOptionsMenu();
    }
    
    public n X0() {
        return (n)this.y;
    }
    
    @Override
    public void a0(final f f, final int n, final String s) {
        ((Activity)this).finish();
    }
    
    @Override
    public n d0() {
        return (n)this.y;
    }
    
    @Override
    public h e0() {
        return this.z;
    }
    
    @Override
    public A h0() {
        if (this.A == null) {
            (this.A = new A(this, this.findViewById(2131362675), this.findViewById(2131362676))).D();
        }
        return this.A;
    }
    
    public boolean isContentClipToPadding(final boolean b) {
        if (!this.m0()) {
            final A a = this.A;
            if (a == null || !a.m()) {
                return false;
            }
        }
        return true;
    }
    
    public void onApplyWindowsInsets(final ax.T.b b, final boolean b2) {
    }
    
    public void onBackPressed() {
        final l y = this.y;
        if (y != null && y.V2()) {
            return;
        }
        ((Activity)this).finish();
    }
    
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131558428);
        if (Q.N1() && ax.u3.z.w((Context)this)) {
            ax.X2.v.r(((Activity)this).getWindow(), -16777216);
        }
        this.z = new h(this, (ViewGroup)this.findViewById(2131362982));
        Uri uri;
        if (((Activity)this).getIntent().hasExtra("open_uri")) {
            uri = (Uri)((Activity)this).getIntent().getParcelableExtra("open_uri");
        }
        else {
            uri = null;
        }
        Uri data;
        if (((Activity)this).getIntent().hasExtra("data_uri")) {
            data = (Uri)((Activity)this).getIntent().getParcelableExtra("data_uri");
        }
        else {
            data = ((Activity)this).getIntent().getData();
        }
        this.C = (bundle != null);
        if (bundle != null) {
            final Fragment j0 = ((androidx.fragment.app.f)this).getSupportFragmentManager().j0(2131362331);
            if (j0 != null) {
                ((androidx.fragment.app.f)this).getSupportFragmentManager().o().q(j0).j();
            }
        }
        this.k0();
        if (uri != null && ax.Z2.k.h(uri.getScheme(), ax.Q2.f.X0)) {
            final Object o = ax.c3.x.e(ax.Z2.k.a(uri).d());
            if (((o)o).a()) {
                bundle = (Bundle)((com.alphainventor.filemanager.file.b)((o)o).u()).W0();
                this.U0((String)bundle, data, 4, uri, (o)o);
                this.z.q((String)bundle);
                if (((Activity)this).getIntent().getBooleanExtra("open_uri_release", false)) {
                    ((o)o).k0(false);
                }
                return;
            }
        }
        if (data == null) {
            Toast.makeText((Context)this, 2131951945, 1).show();
            ((Activity)this).finish();
            return;
        }
        bundle = (Bundle)data.getPath();
        Object o = data.getScheme();
        Label_0487: {
            if (!"content".equals(o)) {
                break Label_0487;
            }
            Label_0435: {
                if (!MyFileProvider.B(data)) {
                    break Label_0435;
                }
                o = MyFileProvider.m(data);
                bundle = (Bundle)((File)o).getName();
                Label_0417: {
                    if (((File)o).exists() || !this.W0((File)o)) {
                        break Label_0417;
                    }
                Block_21_Outer:
                    while (true) {
                        try {
                            final y i0 = com.alphainventor.filemanager.file.y.I0(((File)o).getAbsolutePath());
                            try {
                                try {
                                    new b((Context)this, data, i0, uri).h((Object[])new Void[0]);
                                }
                                catch (final j k) {}
                            }
                            catch (final j l) {}
                            this.V0((String)bundle, (File)o, 1, uri);
                            while (true) {
                                this.z.q((String)bundle);
                                return;
                                this.V0((String)bundle, (File)o, 1, uri);
                                continue Block_21_Outer;
                            }
                            while (true) {
                                ax.u3.b.g("Archive LocationUri");
                                bundle = (Bundle)ax.c3.x.e(ax.Z2.k.a(data).d());
                                iftrue(Label_0606:)(!((o)bundle).a());
                                Block_22: {
                                    break Block_22;
                                    Label_0622: {
                                        ax.Ha.c.h().d("AA").g((Object)data.toString()).h();
                                    }
                                    Toast.makeText((Context)this, 2131951945, 1).show();
                                    ((Activity)this).finish();
                                    return;
                                    o = ax.c3.B.x((Context)this, data, "zip");
                                    bundle = (Bundle)((W)o).a();
                                    new a((Context)this, data, (String)bundle, ((W)o).b, uri).h((Object[])new Void[0]);
                                    this.z.q((String)bundle);
                                    return;
                                    Label_0606:
                                    Toast.makeText((Context)this, 2131951945, 1).show();
                                    ((Activity)this).finish();
                                    return;
                                }
                                o = ((com.alphainventor.filemanager.file.b)((o)bundle).u()).W0();
                                this.U0((String)o, data, 4, uri, (o)bundle);
                                this.z.q((String)o);
                                return;
                                Label_0537: {
                                    iftrue(Label_0622:)(!ax.Z2.k.h((String)o, ax.Q2.f.X0));
                                }
                                continue;
                            }
                            iftrue(Label_0537:)(!"file".equals(o) || !d0.B((String)bundle));
                            final String h = d0.h((String)bundle);
                            this.V0(h, new File((String)bundle), 1, uri);
                            this.z.q(h);
                        }
                        catch (final j m) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        final ArrayList<ParcelFileDescriptor> b = this.B;
        final int size = b.size();
        int i = 0;
        while (i < size) {
            final Object value = b.get(i);
            ++i;
            final ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor)value;
            try {
                parcelFileDescriptor.close();
            }
            catch (final IOException ex) {}
        }
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return (this.X0() != null && this.X0().Y3(n, keyEvent)) || super.onKeyDown(n, keyEvent);
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        final l y = this.y;
        if (y == null) {
            ((Activity)this).finish();
        }
        else {
            ((E)y).na("toolbar_back");
        }
        return true;
    }
    
    @Override
    protected void onStart() {
        super.onStart();
    }
    
    @Override
    public void p0() {
        this.e0().b();
    }
    
    @Override
    public void q0(final String s) {
        ((Activity)this).finish();
    }
    
    @Override
    public void r0(final Bookmark bookmark) {
    }
    
    @Override
    public void t0(final f f, final int n, final String s, final boolean b) {
    }
    
    @Override
    public void w0(final f f, final int n, final String s, final boolean b) {
        if (b) {
            this.M0();
        }
    }
    
    @Override
    public void x0() {
    }
    
    private class a extends q<Void, Void, Boolean>
    {
        private Context h;
        private Uri i;
        private File j;
        private o k;
        private Throwable l;
        private long m;
        private ParcelFileDescriptor n;
        private String o;
        private Uri p;
        final ArchiveActivity q;
        
        public a(final ArchiveActivity q, final Context h, final Uri i, final String o, final long m, final Uri p6) {
            this.q = q;
            super(q$e.d0);
            this.h = h;
            this.i = i;
            this.j = q.Y0(o);
            this.m = m;
            this.o = o;
            this.p = p6;
        }
        
        protected void o() {
            this.k.k0(true);
        }
        
        protected void r() {
            (this.k = ax.c3.x.f(this.j)).n0();
        }
        
        protected Boolean w(Void... ex) {
            final ContentResolver contentResolver = this.h.getContentResolver();
            try {
                ex = (FileNotFoundException)contentResolver.openFileDescriptor(this.i, "r");
                this.n = (ParcelFileDescriptor)ex;
                if (ex != null) {
                    return Boolean.TRUE;
                }
            }
            catch (final SQLiteException ex2) {
                goto Label_0060;
            }
            catch (final IllegalStateException o) {
                goto Label_0118;
            }
            catch (final IllegalArgumentException o) {
                goto Label_0118;
            }
            catch (final NullPointerException o) {
                goto Label_0118;
            }
            catch (final SecurityException o) {
                goto Label_0118;
            }
            catch (final FileNotFoundException ex) {
                goto Label_0174;
            }
            catch (final RuntimeException ex) {}
            try {
                ex = (FileNotFoundException)this.k.z(this.j.getAbsolutePath());
                if (((ax.c3.b)ex).n()) {
                    try {
                        this.k.P((com.alphainventor.filemanager.file.n)ex);
                    }
                    catch (final j ex) {
                        goto Label_0616;
                    }
                }
                Label_0399: {
                    Label_0266: {
                        try {
                            ex = (FileNotFoundException)contentResolver.openInputStream(this.i);
                            break Label_0399;
                        }
                        catch (final RuntimeException ex) {
                            break Label_0266;
                        }
                        catch (final IllegalStateException ex) {
                            break Label_0266;
                        }
                        catch (final NullPointerException ex) {
                            break Label_0266;
                        }
                        catch (final IllegalArgumentException ex) {
                            break Label_0266;
                        }
                        catch (final SecurityException ex) {
                            break Label_0266;
                        }
                        catch (FileNotFoundException ex) {
                            this.l = (Throwable)ex;
                            ex = (FileNotFoundException)this.i.toString();
                            if (ex == null || ((String)ex).startsWith("content://downloads/")) {
                                break Label_0266;
                            }
                            ax.Ha.c.h().d("ARCHTEMP1").g((Object)this.i.toString()).h();
                            this.l = (Throwable)ex;
                            ex = (FileNotFoundException)ax.Ha.c.h().d("ARCHTEMP2").l((Throwable)ex);
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Restored:");
                            sb.append(this.q.C);
                            sb.append(",uri=");
                            sb.append(this.i.toString());
                            ((ax.Ha.b)ex).g((Object)sb.toString()).h();
                            break Label_0266;
                            this.l = (Throwable)ex;
                        }
                    }
                    ex = null;
                }
                if (ex == null) {
                    return Boolean.FALSE;
                }
                Label_0589: {
                    while (true) {
                        Label_0562: {
                            try {
                                final com.alphainventor.filemanager.file.n z = this.k.z(this.j.getAbsolutePath());
                                final U u = new U((InputStream)ex, -1L);
                                final o k = this.k;
                                final String s = ((ax.c3.b)z).s();
                                final long m = this.m;
                                try {
                                    try {
                                        k.D(z, (G)u, s, m, (Long)null, (p)null, true, (ax.u3.c)this, (i)null);
                                        u.e();
                                        final Boolean true = Boolean.TRUE;
                                        if (Q.X1() && this.k.Y()) {
                                            this.k.n((i)null);
                                        }
                                        return true;
                                    }
                                    finally {}
                                }
                                catch (final j j) {}
                                catch (final ax.b3.a a) {}
                            }
                            catch (final j ex) {}
                            catch (final ax.b3.a ex) {
                                break Label_0562;
                            }
                            finally {
                                break Label_0589;
                            }
                            ((Throwable)ex).printStackTrace();
                            if (!Q.X1() || !this.k.Y()) {
                                return Boolean.FALSE;
                            }
                            this.k.n((i)null);
                            return Boolean.FALSE;
                        }
                        ((Throwable)ex).printStackTrace();
                        if (Q.X1() && this.k.Y()) {
                            continue;
                        }
                        break;
                    }
                    return Boolean.FALSE;
                }
                if (Q.X1() && this.k.Y()) {
                    this.k.n((i)null);
                }
            }
            catch (final j i) {}
        }
        
        protected void x(final Boolean b) {
            this.k.k0(true);
            if (!b) {
                final Throwable l = this.l;
                if (l != null && l instanceof FileNotFoundException) {
                    Toast.makeText((Context)this.q, 2131952548, 1).show();
                }
                else {
                    Toast.makeText((Context)this.q, 2131951945, 1).show();
                }
                ((Activity)this.q).finish();
                return;
            }
            if (this.n != null) {
                this.q.B.add((Object)this.n);
                this.q.S0(this.i, this.o, this.n, this.p);
                return;
            }
            this.q.V0(this.o, this.j, 2, this.p);
        }
    }
    
    private class b extends q<Void, Void, Boolean>
    {
        private Context h;
        private File i;
        private o j;
        private long k;
        private ParcelFileDescriptor l;
        private String m;
        private y n;
        private Uri o;
        private Uri p;
        final ArchiveActivity q;
        
        public b(final ArchiveActivity q, final Context h, final Uri o, final y n, final Uri p5) {
            this.q = q;
            super(q$e.d0);
            this.h = h;
            final String b = ((com.alphainventor.filemanager.file.n)n).B();
            this.m = b;
            this.i = q.Y0(b);
            this.k = n.p();
            this.n = n;
            this.o = o;
            this.p = p5;
        }
        
        protected void o() {
            this.j.k0(true);
        }
        
        protected void r() {
            (this.j = ax.c3.x.f(this.i)).n0();
        }
        
        protected Boolean w(final Void... array) {
            final com.alphainventor.filemanager.file.x x = (com.alphainventor.filemanager.file.x)this.j.u();
            try {
                final ParcelFileDescriptor u0 = x.U0(this.n);
                this.l = u0;
                if (u0 != null) {
                    return Boolean.TRUE;
                }
            }
            catch (final j j) {
                ((Throwable)j).printStackTrace();
            }
            return Boolean.FALSE;
        }
        
        protected void x(final Boolean b) {
            this.j.k0(true);
            if (!b) {
                Toast.makeText((Context)this.q, 2131951945, 1).show();
                ((Activity)this.q).finish();
                return;
            }
            this.q.B.add((Object)this.l);
            this.q.S0(this.o, this.m, this.l, this.p);
        }
    }
}
