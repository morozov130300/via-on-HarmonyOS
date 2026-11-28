package u1;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends c2.a implements n0 {
    public l0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // u1.n0
    public final int b() {
        Parcel parcelY = Y(2, Z());
        int i10 = parcelY.readInt();
        parcelY.recycle();
        return i10;
    }

    @Override // u1.n0
    public final z1.a c() {
        Parcel parcelY = Y(1, Z());
        z1.a aVarZ = z1.a.AbstractBinderC0163a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }
}
