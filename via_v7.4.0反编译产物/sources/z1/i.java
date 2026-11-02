package z1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import y1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i extends b2.a implements IInterface {
    public i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final y1.a a0(y1.a aVar, String str, int i10, y1.a aVar2) {
        Parcel parcelZ = Z();
        b2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i10);
        b2.c.e(parcelZ, aVar2);
        Parcel parcelY = Y(2, parcelZ);
        y1.a aVarZ = a.AbstractBinderC0155a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }

    public final y1.a b0(y1.a aVar, String str, int i10, y1.a aVar2) {
        Parcel parcelZ = Z();
        b2.c.e(parcelZ, aVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i10);
        b2.c.e(parcelZ, aVar2);
        Parcel parcelY = Y(3, parcelZ);
        y1.a aVarZ = a.AbstractBinderC0155a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }
}
