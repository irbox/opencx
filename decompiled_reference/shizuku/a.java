package com.alphainventor.filemanager.shizuku;

import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.util.List;
import android.os.IInterface;

public interface a extends IInterface
{
    List<String> A0(final String p0, final long p1) throws RemoteException;
    
    ParcelFileDescriptor G1(final String p0, final boolean p1) throws RemoteException;
    
    int K1(final String p0, final boolean p1) throws RemoteException;
    
    a L0(final String p0) throws RemoteException;
    
    boolean W1(final String p0) throws RemoteException;
    
    boolean X0(final String p0, final String p1) throws RemoteException;
    
    List<a> d1(final String p0) throws RemoteException;
    
    void destroy() throws RemoteException;
    
    boolean h(final String p0) throws RemoteException;
    
    boolean l0(final String p0, final long p1) throws RemoteException;
    
    ParcelFileDescriptor w0(final String p0) throws RemoteException;
    
    boolean x1(final String p0) throws RemoteException;
    
    a z(final String p0) throws RemoteException;
    
    ParcelFileDescriptor z0(final String p0) throws RemoteException;
    
    public abstract static class a extends Binder implements a
    {
        public a() {
            this.attachInterface((IInterface)this, "com.alphainventor.filemanager.shizuku.IShizukuUserService");
        }
        
        public static a r(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.alphainventor.filemanager.shizuku.IShizukuUserService");
            if (queryLocalInterface != null && queryLocalInterface instanceof a) {
                return (a)queryLocalInterface;
            }
            return new a(binder);
        }
        
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public boolean onTransact(int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            if (n >= 1 && n <= 16777215) {
                parcel.enforceInterface("com.alphainventor.filemanager.shizuku.IShizukuUserService");
            }
            if (n == 1598968902) {
                parcel2.writeString("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                return true;
            }
            if (n != 3) {
                if (n != 23) {
                    if (n != 16777115) {
                        boolean b = false;
                        final boolean b2 = false;
                        switch (n) {
                            default: {
                                return super.onTransact(n, parcel, parcel2, n2);
                            }
                            case 21: {
                                final ParcelFileDescriptor z0 = this.z0(parcel.readString());
                                parcel2.writeNoException();
                                f(parcel2, (Parcelable)z0, 1);
                                break;
                            }
                            case 20: {
                                final String string = parcel.readString();
                                boolean b3 = b2;
                                if (parcel.readInt() != 0) {
                                    b3 = true;
                                }
                                final ParcelFileDescriptor g1 = this.G1(string, b3);
                                parcel2.writeNoException();
                                f(parcel2, (Parcelable)g1, 1);
                                break;
                            }
                            case 19: {
                                n = (this.X0(parcel.readString(), parcel.readString()) ? 1 : 0);
                                parcel2.writeNoException();
                                parcel2.writeInt(n);
                                break;
                            }
                            case 18: {
                                n = (this.l0(parcel.readString(), parcel.readLong()) ? 1 : 0);
                                parcel2.writeNoException();
                                parcel2.writeInt(n);
                                break;
                            }
                            case 17: {
                                n = (this.h(parcel.readString()) ? 1 : 0);
                                parcel2.writeNoException();
                                parcel2.writeInt(n);
                                break;
                            }
                            case 16: {
                                n = (this.W1(parcel.readString()) ? 1 : 0);
                                parcel2.writeNoException();
                                parcel2.writeInt(n);
                                break;
                            }
                            case 15: {
                                n = (this.x1(parcel.readString()) ? 1 : 0);
                                parcel2.writeNoException();
                                parcel2.writeInt(n);
                                break;
                            }
                            case 14: {
                                final String string2 = parcel.readString();
                                if (parcel.readInt() != 0) {
                                    b = true;
                                }
                                n = this.K1(string2, b);
                                parcel2.writeNoException();
                                parcel2.writeInt(n);
                                break;
                            }
                            case 13: {
                                final a l0 = this.L0(parcel.readString());
                                parcel2.writeNoException();
                                f(parcel2, (Parcelable)l0, 1);
                                break;
                            }
                            case 12: {
                                final a z2 = this.z(parcel.readString());
                                parcel2.writeNoException();
                                f(parcel2, (Parcelable)z2, 1);
                                break;
                            }
                            case 11: {
                                final List<a> d1 = this.d1(parcel.readString());
                                parcel2.writeNoException();
                                e(parcel2, (java.util.List<Parcelable>)d1, 1);
                                break;
                            }
                        }
                    }
                    else {
                        this.destroy();
                        parcel2.writeNoException();
                    }
                }
                else {
                    final ParcelFileDescriptor w0 = this.w0(parcel.readString());
                    parcel2.writeNoException();
                    f(parcel2, (Parcelable)w0, 1);
                }
            }
            else {
                final List<String> a0 = this.A0(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeStringList((List)a0);
            }
            return true;
        }
        
        private static class a implements com.alphainventor.filemanager.shizuku.a
        {
            private IBinder e;
            
            a(final IBinder e) {
                this.e = e;
            }
            
            @Override
            public ParcelFileDescriptor G1(final String s, final boolean b) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    obtain.writeInt((int)(b ? 1 : 0));
                    this.e.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return (ParcelFileDescriptor)d(obtain2, (android.os.Parcelable$Creator<Object>)ParcelFileDescriptor.CREATOR);
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public int K1(final String s, final boolean b) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    obtain.writeInt((int)(b ? 1 : 0));
                    this.e.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public ax.p3.a L0(final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    this.e.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return (ax.p3.a)d(obtain2, (android.os.Parcelable$Creator<Object>)ax.p3.a.CREATOR);
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean W1(final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    final IBinder e = this.e;
                    boolean b = false;
                    e.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean X0(final String s, final String s2) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    obtain.writeString(s2);
                    final IBinder e = this.e;
                    boolean b = false;
                    e.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            public IBinder asBinder() {
                return this.e;
            }
            
            @Override
            public List<ax.p3.a> d1(final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    this.e.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return (List<ax.p3.a>)obtain2.createTypedArrayList(ax.p3.a.CREATOR);
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean h(final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    final IBinder e = this.e;
                    boolean b = false;
                    e.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean l0(final String s, final long n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    obtain.writeLong(n);
                    final IBinder e = this.e;
                    boolean b = false;
                    e.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public ParcelFileDescriptor w0(final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    this.e.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return (ParcelFileDescriptor)d(obtain2, (android.os.Parcelable$Creator<Object>)ParcelFileDescriptor.CREATOR);
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean x1(final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    final IBinder e = this.e;
                    boolean b = false;
                    e.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public ax.p3.a z(final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    this.e.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return (ax.p3.a)d(obtain2, (android.os.Parcelable$Creator<Object>)ax.p3.a.CREATOR);
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public ParcelFileDescriptor z0(final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alphainventor.filemanager.shizuku.IShizukuUserService");
                    obtain.writeString(s);
                    this.e.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return (ParcelFileDescriptor)d(obtain2, (android.os.Parcelable$Creator<Object>)ParcelFileDescriptor.CREATOR);
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
    
    public static class b
    {
        private static <T> T d(final Parcel parcel, final Parcelable$Creator<T> parcelable$Creator) {
            if (parcel.readInt() != 0) {
                return (T)parcelable$Creator.createFromParcel(parcel);
            }
            return null;
        }
        
        private static <T extends Parcelable> void e(final Parcel parcel, final List<T> list, final int n) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            final int size = list.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; ++i) {
                f(parcel, list.get(i), n);
            }
        }
        
        private static <T extends Parcelable> void f(final Parcel parcel, final T t, final int n) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, n);
                return;
            }
            parcel.writeInt(0);
        }
    }
}
