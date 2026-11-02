package t1;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.GetServiceRequest;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k implements d {

    /* renamed from: d, reason: collision with root package name */
    public final IBinder f12062d;

    public k(IBinder iBinder) {
        this.f12062d = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f12062d;
    }

    @Override // t1.d
    public final void t(c cVar, GetServiceRequest getServiceRequest) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
            if (getServiceRequest != null) {
                parcelObtain.writeInt(1);
                c0.a(getServiceRequest, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f12062d.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            parcelObtain2.recycle();
            parcelObtain.recycle();
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }
}
