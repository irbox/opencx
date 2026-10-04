package com.pcloud.sdk;

import j$.util.Objects;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import android.os.Parcel;
import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.Set;
import java.util.List;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class b implements Parcelable
{
    public static final Parcelable$Creator<b> CREATOR;
    public static final List<String> g0;
    public final String c0;
    public final Set<String> d0;
    public final List<String> e0;
    public final boolean f0;
    public final c q;
    
    static {
        g0 = DesugarCollections.unmodifiableList(Arrays.asList((Object[])new String[] { "com.android.chrome", "com.chrome.beta", "com.chrome.dev", "org.mozilla.firefox", "org.mozilla.firefox_beta", "org.mozilla.fenix" }));
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<b>() {
            public b a(final Parcel parcel) {
                return new b(parcel);
            }
            
            public b[] b(final int n) {
                return new b[n];
            }
        };
    }
    
    protected b(final Parcel parcel) {
        this.q = c.h(parcel.readByte());
        this.c0 = parcel.readString();
        final int int1 = parcel.readInt();
        boolean f0 = false;
        if (int1 > 0) {
            final HashSet set = new HashSet(int1);
            for (int i = 0; i < int1; ++i) {
                ((Set)set).add((Object)parcel.readString());
            }
            this.d0 = (Set<String>)DesugarCollections.unmodifiableSet((Set)set);
        }
        else {
            this.d0 = (Set<String>)Collections.EMPTY_SET;
        }
        final int int2 = parcel.readInt();
        if (int2 > 0) {
            final ArrayList list = new ArrayList();
            for (int j = 0; j < int2; ++j) {
                ((List)list).add((Object)parcel.readString());
            }
            this.e0 = (List<String>)DesugarCollections.unmodifiableList((List)list);
        }
        else {
            this.e0 = (List<String>)Collections.EMPTY_LIST;
        }
        if (parcel.readByte() != 0) {
            f0 = true;
        }
        this.f0 = f0;
    }
    
    b(final b b) {
        this.q = b.a;
        this.c0 = b.b;
        this.d0 = (Set<String>)DesugarCollections.unmodifiableSet(b.c);
        this.e0 = (List<String>)DesugarCollections.unmodifiableList(b.d);
        this.f0 = b.e;
    }
    
    public static b a() {
        return new b();
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
            final b b = (b)o;
            return this.f0 == b.f0 && this.q == b.q && this.c0.equals((Object)b.c0) && this.d0.equals((Object)b.d0);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((this.q.hashCode() * 31 + this.c0.hashCode()) * 31 + this.d0.hashCode()) * 31 + (this.f0 ? 1 : 0);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AuthorizationRequest{type=");
        sb.append((Object)this.q);
        sb.append(", clientId='");
        sb.append(this.c0);
        sb.append('\'');
        sb.append(", permissions=");
        sb.append((Object)this.d0);
        sb.append(", customTabsPackages=");
        sb.append((Object)this.e0);
        sb.append(", forceAccessApproval=");
        sb.append(this.f0);
        sb.append('}');
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeByte((byte)this.q.q);
        parcel.writeString(this.c0);
        parcel.writeInt(this.d0.size());
        final Iterator iterator = this.d0.iterator();
        while (iterator.hasNext()) {
            parcel.writeString((String)iterator.next());
        }
        parcel.writeInt(this.e0.size());
        final Iterator iterator2 = this.e0.iterator();
        while (iterator2.hasNext()) {
            parcel.writeString((String)iterator2.next());
        }
        parcel.writeByte((byte)(byte)(this.f0 ? 1 : 0));
    }
    
    public static class b
    {
        private c a;
        private String b;
        private final Set<String> c;
        private final List<String> d;
        private boolean e;
        
        b() {
            this.e = false;
            this.d = (List<String>)new ArrayList((Collection)com.pcloud.sdk.b.g0);
            this.c = (Set<String>)new HashSet();
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o != null && this.getClass() == o.getClass()) {
                final b b = (b)o;
                return this.e == b.e && this.a == b.a && Objects.equals((Object)this.b, (Object)b.b) && this.c.equals((Object)b.c);
            }
            return false;
        }
        
        public b f(final String s) {
            this.c.add((Object)s);
            return this;
        }
        
        public com.pcloud.sdk.b g() {
            if (this.a == null) {
                throw new IllegalStateException("setType() not called.");
            }
            if (this.b != null) {
                return new com.pcloud.sdk.b(this);
            }
            throw new IllegalStateException("setClientId() not called.");
        }
        
        public b h(final String b) {
            this.b = b;
            return this;
        }
        
        @Override
        public int hashCode() {
            final c a = this.a;
            int hashCode = 0;
            int hashCode2;
            if (a != null) {
                hashCode2 = a.hashCode();
            }
            else {
                hashCode2 = 0;
            }
            final String b = this.b;
            if (b != null) {
                hashCode = b.hashCode();
            }
            return ((hashCode2 * 31 + hashCode) * 31 + this.c.hashCode()) * 31 + (this.e ? 1 : 0);
        }
        
        public b i(final boolean e) {
            this.e = e;
            return this;
        }
        
        public b j(final c a) {
            this.a = a;
            return this;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Builder{type=");
            sb.append((Object)this.a);
            sb.append(", clientId='");
            sb.append(this.b);
            sb.append('\'');
            sb.append(", permissions=");
            sb.append((Object)this.c);
            sb.append(", customTabsPackages=");
            sb.append((Object)this.d);
            sb.append(", forceAccessApproval=");
            sb.append(this.e);
            sb.append('}');
            return sb.toString();
        }
    }
    
    public enum c
    {
        c0(0), 
        d0(1);
        
        private static final c[] e0;
        protected final int q;
        
        static {
            e0 = d();
        }
        
        private c(final int q) {
            this.q = q;
        }
        
        private static /* synthetic */ c[] d() {
            return new c[] { c.c0, c.d0 };
        }
        
        static c h(final int n) {
            if (n == 0) {
                return c.c0;
            }
            if (n == 1) {
                return c.d0;
            }
            throw new IllegalArgumentException();
        }
    }
}
