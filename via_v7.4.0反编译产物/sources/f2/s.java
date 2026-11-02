package f2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.measurement.internal.zzas;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        Bundle bundleA = null;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            if (SafeParcelReader.h(iN) != 2) {
                SafeParcelReader.t(parcel, iN);
            } else {
                bundleA = SafeParcelReader.a(parcel, iN);
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new zzas(bundleA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzas[i10];
    }
}
