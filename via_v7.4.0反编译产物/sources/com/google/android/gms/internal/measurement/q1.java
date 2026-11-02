package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
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
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
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
