package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l1 extends o0 implements n1 {
    public l1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.n1
    public final int c() {
        Parcel parcelZ = Z(2, Y());
        int i10 = parcelZ.readInt();
        parcelZ.recycle();
        return i10;
    }

    @Override // com.google.android.gms.internal.measurement.n1
    public final void d(String str, String str2, Bundle bundle, long j10) {
        Parcel parcelY = Y();
        parcelY.writeString(str);
        parcelY.writeString(str2);
        q0.d(parcelY, bundle);
        parcelY.writeLong(j10);
        a0(1, parcelY);
    }
}
