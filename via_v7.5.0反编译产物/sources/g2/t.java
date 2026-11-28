package g2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Parcelable.Creator {
    public static void a(zzau zzauVar, Parcel parcel, int i10) {
        int iA = v1.a.a(parcel);
        v1.a.o(parcel, 2, zzauVar.f3263c, false);
        v1.a.n(parcel, 3, zzauVar.f3264e, i10, false);
        v1.a.o(parcel, 4, zzauVar.f3265m, false);
        v1.a.l(parcel, 5, zzauVar.f3266n);
        v1.a.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        long jQ = 0;
        String strD = null;
        zzas zzasVar = null;
        String strD2 = null;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            int iH = SafeParcelReader.h(iN);
            if (iH == 2) {
                strD = SafeParcelReader.d(parcel, iN);
            } else if (iH == 3) {
                zzasVar = (zzas) SafeParcelReader.c(parcel, iN, zzas.CREATOR);
            } else if (iH == 4) {
                strD2 = SafeParcelReader.d(parcel, iN);
            } else if (iH != 5) {
                SafeParcelReader.t(parcel, iN);
            } else {
                jQ = SafeParcelReader.q(parcel, iN);
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new zzau(strD, zzasVar, strD2, jQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzau[i10];
    }
}
