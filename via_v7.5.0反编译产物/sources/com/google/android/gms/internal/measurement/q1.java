package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        String strD = null;
        String strD2 = null;
        String strD3 = null;
        Bundle bundleA = null;
        String strD4 = null;
        long jQ = 0;
        long jQ2 = 0;
        boolean zI = false;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            switch (SafeParcelReader.h(iN)) {
                case 1:
                    jQ = SafeParcelReader.q(parcel, iN);
                    break;
                case 2:
                    jQ2 = SafeParcelReader.q(parcel, iN);
                    break;
                case 3:
                    zI = SafeParcelReader.i(parcel, iN);
                    break;
                case 4:
                    strD = SafeParcelReader.d(parcel, iN);
                    break;
                case 5:
                    strD2 = SafeParcelReader.d(parcel, iN);
                    break;
                case 6:
                    strD3 = SafeParcelReader.d(parcel, iN);
                    break;
                case 7:
                    bundleA = SafeParcelReader.a(parcel, iN);
                    break;
                case 8:
                    strD4 = SafeParcelReader.d(parcel, iN);
                    break;
                default:
                    SafeParcelReader.t(parcel, iN);
                    break;
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new zzcl(jQ, jQ2, zI, strD, strD2, strD3, bundleA, strD4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzcl[i10];
    }
}
