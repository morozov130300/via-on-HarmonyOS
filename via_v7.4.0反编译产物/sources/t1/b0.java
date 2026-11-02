package t1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrB = null;
        int[] iArrB2 = null;
        boolean zI = false;
        boolean zI2 = false;
        int iP = 0;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            switch (SafeParcelReader.h(iN)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.c(parcel, iN, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zI = SafeParcelReader.i(parcel, iN);
                    break;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    zI2 = SafeParcelReader.i(parcel, iN);
                    break;
                case 4:
                    iArrB = SafeParcelReader.b(parcel, iN);
                    break;
                case 5:
                    iP = SafeParcelReader.p(parcel, iN);
                    break;
                case 6:
                    iArrB2 = SafeParcelReader.b(parcel, iN);
                    break;
                default:
                    SafeParcelReader.t(parcel, iN);
                    break;
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zI, zI2, iArrB, iP, iArrB2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new ConnectionTelemetryConfiguration[i10];
    }
}
