package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.measurement.internal.zzq;
import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class bb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        long jQ = 0;
        long jQ2 = 0;
        long jQ3 = 0;
        long jQ4 = 0;
        long jQ5 = 0;
        long jQ6 = 0;
        String strD = null;
        String strD2 = null;
        String strD3 = null;
        String strD4 = null;
        String strD5 = null;
        String strD6 = null;
        String strD7 = null;
        Boolean boolJ = null;
        ArrayList arrayListE = null;
        String strD8 = null;
        String strD9 = null;
        String strD10 = "";
        String strD11 = strD10;
        long jQ7 = -2147483648L;
        boolean zI = true;
        boolean zI2 = false;
        int iP = 0;
        boolean zI3 = true;
        boolean zI4 = false;
        boolean zI5 = false;
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
                    strD3 = SafeParcelReader.d(parcel, iN);
                    break;
                case 5:
                    strD4 = SafeParcelReader.d(parcel, iN);
                    break;
                case 6:
                    jQ = SafeParcelReader.q(parcel, iN);
                    break;
                case 7:
                    jQ2 = SafeParcelReader.q(parcel, iN);
                    break;
                case 8:
                    strD5 = SafeParcelReader.d(parcel, iN);
                    break;
                case 9:
                    zI = SafeParcelReader.i(parcel, iN);
                    break;
                case 10:
                    zI2 = SafeParcelReader.i(parcel, iN);
                    break;
                case 11:
                    jQ7 = SafeParcelReader.q(parcel, iN);
                    break;
                case 12:
                    strD6 = SafeParcelReader.d(parcel, iN);
                    break;
                case 13:
                    jQ3 = SafeParcelReader.q(parcel, iN);
                    break;
                case 14:
                    jQ4 = SafeParcelReader.q(parcel, iN);
                    break;
                case 15:
                    iP = SafeParcelReader.p(parcel, iN);
                    break;
                case 16:
                    zI3 = SafeParcelReader.i(parcel, iN);
                    break;
                case 17:
                case 20:
                default:
                    SafeParcelReader.t(parcel, iN);
                    break;
                case 18:
                    zI4 = SafeParcelReader.i(parcel, iN);
                    break;
                case 19:
                    strD7 = SafeParcelReader.d(parcel, iN);
                    break;
                case 21:
                    boolJ = SafeParcelReader.j(parcel, iN);
                    break;
                case 22:
                    jQ5 = SafeParcelReader.q(parcel, iN);
                    break;
                case 23:
                    arrayListE = SafeParcelReader.e(parcel, iN);
                    break;
                case 24:
                    strD8 = SafeParcelReader.d(parcel, iN);
                    break;
                case 25:
                    strD10 = SafeParcelReader.d(parcel, iN);
                    break;
                case 26:
                    strD11 = SafeParcelReader.d(parcel, iN);
                    break;
                case 27:
                    strD9 = SafeParcelReader.d(parcel, iN);
                    break;
                case 28:
                    zI5 = SafeParcelReader.i(parcel, iN);
                    break;
                case 29:
                    jQ6 = SafeParcelReader.q(parcel, iN);
                    break;
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new zzq(strD, strD2, strD3, strD4, jQ, jQ2, strD5, zI, zI2, jQ7, strD6, jQ3, jQ4, iP, zI3, zI4, strD7, boolJ, jQ5, arrayListE, strD8, strD10, strD11, strD9, zI5, jQ6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzq[i10];
    }
}
