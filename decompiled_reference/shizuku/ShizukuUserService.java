package com.alphainventor.filemanager.shizuku;

import android.util.Log;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import ax.u3.r;
import java.util.List;
import android.content.Context;
import androidx.annotation.Keep;

public class ShizukuUserService extends a.a
{
    @Keep
    public ShizukuUserService() {
    }
    
    @Keep
    public ShizukuUserService(final Context context) {
    }
    
    public List<String> A0(final String s, final long n) throws RemoteException {
        try {
            return (List<String>)r.h(s, n);
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    public ParcelFileDescriptor G1(final String s, final boolean b) throws RemoteException {
        return b.k(s, b);
    }
    
    public int K1(final String s, final boolean b) throws RemoteException {
        return b.j(s, b);
    }
    
    public ax.p3.a L0(final String s) throws RemoteException {
        return com.alphainventor.filemanager.shizuku.b.h(s);
    }
    
    public boolean W1(final String s) throws RemoteException {
        return com.alphainventor.filemanager.shizuku.b.n(s);
    }
    
    public boolean X0(final String s, final String s2) throws RemoteException {
        return com.alphainventor.filemanager.shizuku.b.o(s, s2);
    }
    
    public List<ax.p3.a> d1(final String s) throws RemoteException {
        return com.alphainventor.filemanager.shizuku.b.m(s);
    }
    
    @Keep
    public void destroy() throws RemoteException {
        Log.i("ShizukuUserService", "destroy");
        System.exit(0);
    }
    
    public boolean h(final String s) throws RemoteException {
        return com.alphainventor.filemanager.shizuku.b.d(s);
    }
    
    public boolean l0(final String s, final long n) throws RemoteException {
        return com.alphainventor.filemanager.shizuku.b.p(s, n);
    }
    
    public ParcelFileDescriptor w0(final String s) throws RemoteException {
        return com.alphainventor.filemanager.shizuku.b.l(s);
    }
    
    public boolean x1(final String s) throws RemoteException {
        return com.alphainventor.filemanager.shizuku.b.b(s);
    }
    
    public ax.p3.a z(final String s) throws RemoteException {
        return com.alphainventor.filemanager.shizuku.b.f(s);
    }
    
    public ParcelFileDescriptor z0(final String s) throws RemoteException {
        return com.alphainventor.filemanager.shizuku.b.i(s);
    }
}
