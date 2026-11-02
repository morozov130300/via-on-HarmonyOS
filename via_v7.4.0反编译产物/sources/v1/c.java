package v1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        long jQ = 0;
        long jQ2 = 0;
        long jQ3 = 0;
        String strD = null;
        ArrayList arrayListE = null;
        String strD2 = null;
        String strD3 = null;
        String strD4 = null;
        String strD5 = null;
        int iP = 0;
        int iP2 = 0;
        int iP3 = 0;
        int iP4 = 0;
        float fL = 0.0f;
        boolean zI = false;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            switch (SafeParcelReader.h(iN)) {
                case 1:
                    iP = SafeParcelReader.p(parcel, iN);
                    break;
                case 2:
                    jQ = SafeParcelReader.q(parcel, iN);
                    break;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                case 7:
                case 9:
                default:
                    SafeParcelReader.t(parcel, iN);
                    break;
                case 4:
                    strD = SafeParcelReader.d(parcel, iN);
                    break;
                case 5:
                    iP3 = SafeParcelReader.p(parcel, iN);
                    break;
                case 6:
                    arrayListE = SafeParcelReader.e(parcel, iN);
                    break;
                case 8:
                    jQ2 = SafeParcelReader.q(parcel, iN);
                    break;
                case 10:
                    strD3 = SafeParcelReader.d(parcel, iN);
                    break;
                case 11:
                    iP2 = SafeParcelReader.p(parcel, iN);
                    break;
                case 12:
                    strD2 = SafeParcelReader.d(parcel, iN);
                    break;
                case 13:
                    strD4 = SafeParcelReader.d(parcel, iN);
                    break;
                case 14:
                    iP4 = SafeParcelReader.p(parcel, iN);
                    break;
                case 15:
                    fL = SafeParcelReader.l(parcel, iN);
                    break;
                case 16:
                    jQ3 = SafeParcelReader.q(parcel, iN);
                    break;
                case 17:
                    strD5 = SafeParcelReader.d(parcel, iN);
                    break;
                case 18:
                    zI = SafeParcelReader.i(parcel, iN);
                    break;
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new WakeLockEvent(iP, jQ, iP2, strD, iP3, arrayListE, strD2, jQ2, iP4, strD3, strD4, fL, jQ3, strD5, zI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new WakeLockEvent[i10];
    }
}
