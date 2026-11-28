package u1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zzj;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        Bundle bundleA = null;
        Feature[] featureArr = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int iP = 0;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            int iH = SafeParcelReader.h(iN);
            if (iH == 1) {
                bundleA = SafeParcelReader.a(parcel, iN);
            } else if (iH == 2) {
                featureArr = (Feature[]) SafeParcelReader.f(parcel, iN, Feature.CREATOR);
            } else if (iH == 3) {
                iP = SafeParcelReader.p(parcel, iN);
            } else if (iH != 4) {
                SafeParcelReader.t(parcel, iN);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.c(parcel, iN, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new zzj(bundleA, featureArr, iP, connectionTelemetryConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzj[i10];
    }
}
