package com.alphainventor.filemanager.file;

import androidx.fragment.app.e;
import ax.u3.B;
import ax.a3.U;
import ax.Q2.f;
import ax.g3.k;
import com.alphainventor.filemanager.activity.a;
import ax.Z2.s;
import java.io.InputStream;
import android.content.Context;
import ax.a3.U$d;

public class H extends W
{
    static a w;
    
    public static U$d T0(final String s, final boolean b) {
        return U$d.d0;
    }
    
    public static a U0(final Context context) {
        if (H.w == null) {
            H.w = new a(context.getApplicationContext());
        }
        return H.w;
    }
    
    @Override
    public InputStream A(final String s, final String s2, final String s3) {
        return super.A(s, s2, s3);
    }
    
    public static class a extends T
    {
        Context a;
        
        public a(final Context a) {
            this.a = a;
        }
        
        public void a(final int n) {
        }
        
        public s f(final int n) {
            return null;
        }
        
        public void g(final int n, final String s) {
        }
        
        public void j(final int n, final long n2) {
        }
        
        public void k(final com.alphainventor.filemanager.activity.a a, final String s, final k k) {
        }
        
        public void l(final com.alphainventor.filemanager.activity.a a) {
            B.d0(((androidx.fragment.app.f)a).getSupportFragmentManager(), (e)U.l3(f.U0), "serveraddress", true);
        }
    }
}
