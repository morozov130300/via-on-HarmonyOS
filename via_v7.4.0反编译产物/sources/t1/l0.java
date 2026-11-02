package t1;

import android.os.IBinder;
import android.os.Parcel;
import y1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l0 extends b2.a implements n0 {
    public l0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // t1.n0
    public final int b() {
        Parcel parcelY = Y(2, Z());
        int i10 = parcelY.readInt();
        parcelY.recycle();
        return i10;
    }

    @Override // t1.n0
    public final y1.a c() {
        Parcel parcelY = Y(1, Z());
        y1.a aVarZ = a.AbstractBinderC0155a.Z(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarZ;
    }
}
