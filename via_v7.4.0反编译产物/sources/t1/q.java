package t1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        int iP = 0;
        boolean zI = false;
        boolean zI2 = false;
        int iP2 = 0;
        int iP3 = 0;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            int iH = SafeParcelReader.h(iN);
            if (iH == 1) {
                iP = SafeParcelReader.p(parcel, iN);
            } else if (iH == 2) {
                zI = SafeParcelReader.i(parcel, iN);
            } else if (iH == 3) {
                zI2 = SafeParcelReader.i(parcel, iN);
            } else if (iH == 4) {
                iP2 = SafeParcelReader.p(parcel, iN);
            } else if (iH != 5) {
                SafeParcelReader.t(parcel, iN);
            } else {
                iP3 = SafeParcelReader.p(parcel, iN);
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new RootTelemetryConfiguration(iP, zI, zI2, iP2, iP3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new RootTelemetryConfiguration[i10];
    }
}
