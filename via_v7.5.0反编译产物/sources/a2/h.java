package a2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h extends c2.a implements IInterface {
    public h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int a0() {
        Parcel parcelY = Y(6, Z());
        int i10 = parcelY.readInt();
        parcelY.recycle();
        return i10;
    }

    public final int b0(z1.a aVar, String str, boolean z10) {
        Parcel parcelZ = Z();
        c2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        c2.c.c(parcelZ, z10);
        Parcel parcelY = Y(3, parcelZ);
        int i10 = parcelY.readInt();
        parcelY.recycle();
        return i10;
    }

    public final int c0(z1.a aVar, String str, boolean z10) {
        Parcel parcelZ = Z();
        c2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        c2.c.c(parcelZ, z10);
        Parcel parcelY = Y(5, parcelZ);
        int i10 = parcelY.readInt();
        parcelY.recycle();
        return i10;
    }

    public final z1.a d0(z1.a aVar, String str, int i10) {
        Parcel parcelZ = Z();
        c2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i10);
        Parcel parcelY = Y(2, parcelZ);
        z1.a aVarZ = z1.a.AbstractBinderC0163a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }

    public final z1.a e0(z1.a aVar, String str, int i10, z1.a aVar2) {
        Parcel parcelZ = Z();
        c2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i10);
        c2.c.e(parcelZ, aVar2);
        Parcel parcelY = Y(8, parcelZ);
        z1.a aVarZ = z1.a.AbstractBinderC0163a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }

    public final z1.a f0(z1.a aVar, String str, int i10) {
        Parcel parcelZ = Z();
        c2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i10);
        Parcel parcelY = Y(4, parcelZ);
        z1.a aVarZ = z1.a.AbstractBinderC0163a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }

    public final z1.a g0(z1.a aVar, String str, boolean z10, long j10) {
        Parcel parcelZ = Z();
        c2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        c2.c.c(parcelZ, z10);
        parcelZ.writeLong(j10);
        Parcel parcelY = Y(7, parcelZ);
        z1.a aVarZ = z1.a.AbstractBinderC0163a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }
}
