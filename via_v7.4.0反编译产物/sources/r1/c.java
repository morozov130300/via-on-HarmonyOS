package r1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        String strD = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        int iP = 0;
        int iP2 = 0;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            int iH = SafeParcelReader.h(iN);
            if (iH == 1) {
                iP2 = SafeParcelReader.p(parcel, iN);
            } else if (iH == 2) {
                strD = SafeParcelReader.d(parcel, iN);
            } else if (iH == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.c(parcel, iN, PendingIntent.CREATOR);
            } else if (iH == 4) {
                connectionResult = (ConnectionResult) SafeParcelReader.c(parcel, iN, ConnectionResult.CREATOR);
            } else if (iH != 1000) {
                SafeParcelReader.t(parcel, iN);
            } else {
                iP = SafeParcelReader.p(parcel, iN);
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new Status(iP, iP2, strD, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new Status[i10];
    }
}
