package z1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import y1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h extends b2.a implements IInterface {
    public h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int a0() {
        Parcel parcelY = Y(6, Z());
        int i10 = parcelY.readInt();
        parcelY.recycle();
        return i10;
    }

    public final int b0(y1.a aVar, String str, boolean z10) {
        Parcel parcelZ = Z();
        b2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        b2.c.c(parcelZ, z10);
        Parcel parcelY = Y(3, parcelZ);
        int i10 = parcelY.readInt();
        parcelY.recycle();
        return i10;
    }

    public final int c0(y1.a aVar, String str, boolean z10) {
        Parcel parcelZ = Z();
        b2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        b2.c.c(parcelZ, z10);
        Parcel parcelY = Y(5, parcelZ);
        int i10 = parcelY.readInt();
        parcelY.recycle();
        return i10;
    }

    public final y1.a d0(y1.a aVar, String str, int i10) {
        Parcel parcelZ = Z();
        b2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i10);
        Parcel parcelY = Y(2, parcelZ);
        y1.a aVarZ = a.AbstractBinderC0155a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }

    public final y1.a e0(y1.a aVar, String str, int i10, y1.a aVar2) {
        Parcel parcelZ = Z();
        b2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i10);
        b2.c.e(parcelZ, aVar2);
        Parcel parcelY = Y(8, parcelZ);
        y1.a aVarZ = a.AbstractBinderC0155a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }

    public final y1.a f0(y1.a aVar, String str, int i10) {
        Parcel parcelZ = Z();
        b2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i10);
        Parcel parcelY = Y(4, parcelZ);
        y1.a aVarZ = a.AbstractBinderC0155a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }

    public final y1.a g0(y1.a aVar, String str, boolean z10, long j10) {
        Parcel parcelZ = Z();
        b2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        b2.c.c(parcelZ, z10);
        parcelZ.writeLong(j10);
        Parcel parcelY = Y(7, parcelZ);
        y1.a aVarZ = a.AbstractBinderC0155a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }
}
