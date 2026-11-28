package a2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i extends c2.a implements IInterface {
    public i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final z1.a a0(z1.a aVar, String str, int i10, z1.a aVar2) {
        Parcel parcelZ = Z();
        c2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i10);
        c2.c.e(parcelZ, aVar2);
        Parcel parcelY = Y(2, parcelZ);
        z1.a aVarZ = z1.a.AbstractBinderC0163a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }

    public final z1.a b0(z1.a aVar, String str, int i10, z1.a aVar2) {
        Parcel parcelZ = Z();
        c2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i10);
        c2.c.e(parcelZ, aVar2);
        Parcel parcelY = Y(3, parcelZ);
        z1.a aVarZ = z1.a.AbstractBinderC0163a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }
}
