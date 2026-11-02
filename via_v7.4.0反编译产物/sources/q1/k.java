package q1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        String strD = null;
        int iP = 0;
        long jQ = -1;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            int iH = SafeParcelReader.h(iN);
            if (iH == 1) {
                strD = SafeParcelReader.d(parcel, iN);
            } else if (iH == 2) {
                iP = SafeParcelReader.p(parcel, iN);
            } else if (iH != 3) {
                SafeParcelReader.t(parcel, iN);
            } else {
                jQ = SafeParcelReader.q(parcel, iN);
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new Feature(strD, iP, jQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new Feature[i10];
    }
}
