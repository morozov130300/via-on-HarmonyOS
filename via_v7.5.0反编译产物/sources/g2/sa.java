package g2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.measurement.internal.zzlk;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class sa implements Parcelable.Creator {
    public static void a(zzlk zzlkVar, Parcel parcel, int i10) {
        int iA = v1.a.a(parcel);
        v1.a.j(parcel, 1, zzlkVar.f3268c);
        v1.a.o(parcel, 2, zzlkVar.f3269e, false);
        v1.a.l(parcel, 3, zzlkVar.f3270m);
        v1.a.m(parcel, 4, zzlkVar.f3271n, false);
        v1.a.h(parcel, 5, null, false);
        v1.a.o(parcel, 6, zzlkVar.f3272o, false);
        v1.a.o(parcel, 7, zzlkVar.f3273p, false);
        v1.a.f(parcel, 8, zzlkVar.f3274q, false);
        v1.a.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        String strD = null;
        Long lR = null;
        Float fM = null;
        String strD2 = null;
        String strD3 = null;
        Double dK = null;
        long jQ = 0;
        int iP = 0;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            switch (SafeParcelReader.h(iN)) {
                case 1:
                    iP = SafeParcelReader.p(parcel, iN);
                    break;
                case 2:
                    strD = SafeParcelReader.d(parcel, iN);
                    break;
                case 3:
                    jQ = SafeParcelReader.q(parcel, iN);
                    break;
                case 4:
                    lR = SafeParcelReader.r(parcel, iN);
                    break;
                case 5:
                    fM = SafeParcelReader.m(parcel, iN);
                    break;
                case 6:
                    strD2 = SafeParcelReader.d(parcel, iN);
                    break;
                case 7:
                    strD3 = SafeParcelReader.d(parcel, iN);
                    break;
                case 8:
                    dK = SafeParcelReader.k(parcel, iN);
                    break;
                default:
                    SafeParcelReader.t(parcel, iN);
                    break;
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new zzlk(iP, strD, jQ, lR, fM, strD2, strD3, dK);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzlk[i10];
    }
}
