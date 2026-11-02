package q1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.zzs;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        String strD = null;
        IBinder iBinderO = null;
        boolean zI = false;
        boolean zI2 = false;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            int iH = SafeParcelReader.h(iN);
            if (iH == 1) {
                strD = SafeParcelReader.d(parcel, iN);
            } else if (iH == 2) {
                iBinderO = SafeParcelReader.o(parcel, iN);
            } else if (iH == 3) {
                zI = SafeParcelReader.i(parcel, iN);
            } else if (iH != 4) {
                SafeParcelReader.t(parcel, iN);
            } else {
                zI2 = SafeParcelReader.i(parcel, iN);
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new zzs(strD, iBinderO, zI, zI2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzs[i10];
    }
}
