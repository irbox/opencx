package moe.shizuku.api;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class BinderContainer implements Parcelable
{
    public static final Parcelable$Creator<BinderContainer> CREATOR;
    public IBinder q;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<BinderContainer>() {
            public BinderContainer a(final Parcel parcel) {
                return new BinderContainer(parcel);
            }
            
            public BinderContainer[] b(final int n) {
                return new BinderContainer[n];
            }
        };
    }
    
    public BinderContainer(final IBinder q) {
        this.q = q;
    }
    
    protected BinderContainer(final Parcel parcel) {
        this.q = parcel.readStrongBinder();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeStrongBinder(this.q);
    }
}
