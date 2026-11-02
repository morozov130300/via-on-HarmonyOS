package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.measurement.internal.zzlk;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class sa implements Parcelable.Creator {
    public static void a(zzlk zzlkVar, Parcel parcel, int i10) {
        int iA = u1.a.a(parcel);
        u1.a.j(parcel, 1, zzlkVar.f3969e);
        u1.a.o(parcel, 2, zzlkVar.f3970j, false);
        u1.a.l(parcel, 3, zzlkVar.f3971k);
        u1.a.m(parcel, 4, zzlkVar.f3972l, false);
        u1.a.h(parcel, 5, null, false);
        u1.a.o(parcel, 6, zzlkVar.f3973m, false);
        u1.a.o(parcel, 7, zzlkVar.f3974n, false);
        u1.a.f(parcel, 8, zzlkVar.f3975o, false);
        u1.a.b(parcel, iA);
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
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
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
