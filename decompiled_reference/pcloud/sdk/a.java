package com.pcloud.sdk;

import java.io.Serializable;
import j$.util.Objects;
import android.os.Parcel;
import ax.la.h;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class a implements Parcelable
{
    public static final Parcelable$Creator<a> CREATOR;
    public final h c0;
    public final String d0;
    public final long e0;
    public final long f0;
    public final String g0;
    public final String h0;
    public final String i0;
    public final b q;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<a>() {
            public a a(final Parcel parcel) {
                return new a(parcel);
            }
            
            public a[] b(final int n) {
                return new a[n];
            }
        };
    }
    
    protected a(final Parcel parcel) {
        this.q = (b)parcel.readParcelable(b.class.getClassLoader());
        this.c0 = (h)parcel.readSerializable();
        this.d0 = parcel.readString();
        this.e0 = parcel.readLong();
        this.f0 = parcel.readLong();
        this.g0 = parcel.readString();
        this.h0 = parcel.readString();
        this.i0 = parcel.readString();
    }
    
    a(final b q, final h c0, final String d0, final long e0, final long f0, final String g0, final String h0, final String i0) {
        this.q = q;
        this.c0 = c0;
        this.d0 = d0;
        this.e0 = e0;
        this.f0 = f0;
        this.g0 = g0;
        this.h0 = h0;
        this.i0 = i0;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && this.getClass() == o.getClass()) {
            final a a = (a)o;
            return this.e0 == a.e0 && this.f0 == a.f0 && this.q.equals(a.q) && this.c0 == a.c0 && Objects.equals((Object)this.d0, (Object)a.d0) && Objects.equals((Object)this.g0, (Object)a.g0) && Objects.equals((Object)this.h0, (Object)a.h0) && Objects.equals((Object)this.i0, (Object)a.i0);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.q.hashCode();
        final int hashCode2 = this.c0.hashCode();
        final String d0 = this.d0;
        int hashCode3 = 0;
        int hashCode4;
        if (d0 != null) {
            hashCode4 = d0.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final long e0 = this.e0;
        final int n = (int)(e0 ^ e0 >>> 32);
        final long f0 = this.f0;
        final int n2 = (int)(f0 ^ f0 >>> 32);
        final String g0 = this.g0;
        int hashCode5;
        if (g0 != null) {
            hashCode5 = g0.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String h0 = this.h0;
        int hashCode6;
        if (h0 != null) {
            hashCode6 = h0.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final String i0 = this.i0;
        if (i0 != null) {
            hashCode3 = i0.hashCode();
        }
        return ((((((hashCode * 31 + hashCode2) * 31 + hashCode4) * 31 + n) * 31 + n2) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode3;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AuthorizationData{request=");
        sb.append((Object)this.q);
        sb.append(", result=");
        sb.append((Object)this.c0);
        sb.append(", token='");
        sb.append(this.d0);
        sb.append('\'');
        sb.append(", userId=");
        sb.append(this.e0);
        sb.append(", locationId=");
        sb.append(this.f0);
        sb.append(", authCode='");
        sb.append(this.g0);
        sb.append('\'');
        sb.append(", apiHost='");
        sb.append(this.h0);
        sb.append('\'');
        sb.append(", errorMessage='");
        sb.append(this.i0);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeParcelable((Parcelable)this.q, n);
        parcel.writeSerializable((Serializable)this.c0);
        parcel.writeString(this.d0);
        parcel.writeLong(this.e0);
        parcel.writeLong(this.f0);
        parcel.writeString(this.g0);
        parcel.writeString(this.h0);
        parcel.writeString(this.i0);
    }
}
