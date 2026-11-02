package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzlk;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        String strD = null;
        String strD2 = null;
        zzlk zzlkVar = null;
        String strD3 = null;
        zzau zzauVar = null;
        zzau zzauVar2 = null;
        zzau zzauVar3 = null;
        long jQ = 0;
        long jQ2 = 0;
        long jQ3 = 0;
        boolean zI = false;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            switch (SafeParcelReader.h(iN)) {
                case 2:
                    strD = SafeParcelReader.d(parcel, iN);
                    break;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    strD2 = SafeParcelReader.d(parcel, iN);
                    break;
                case 4:
                    zzlkVar = (zzlk) SafeParcelReader.c(parcel, iN, zzlk.CREATOR);
                    break;
                case 5:
                    jQ = SafeParcelReader.q(parcel, iN);
                    break;
                case 6:
                    zI = SafeParcelReader.i(parcel, iN);
                    break;
                case 7:
                    strD3 = SafeParcelReader.d(parcel, iN);
                    break;
                case 8:
                    zzauVar = (zzau) SafeParcelReader.c(parcel, iN, zzau.CREATOR);
                    break;
                case 9:
                    jQ2 = SafeParcelReader.q(parcel, iN);
                    break;
                case 10:
                    zzauVar2 = (zzau) SafeParcelReader.c(parcel, iN, zzau.CREATOR);
                    break;
                case 11:
                    jQ3 = SafeParcelReader.q(parcel, iN);
                    break;
                case 12:
                    zzauVar3 = (zzau) SafeParcelReader.c(parcel, iN, zzau.CREATOR);
                    break;
                default:
                    SafeParcelReader.t(parcel, iN);
                    break;
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new zzac(strD, strD2, zzlkVar, jQ, zI, strD3, zzauVar, jQ2, zzauVar2, jQ3, zzauVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzac[i10];
    }
}
