package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r0 extends o0 implements t0 {
    public r0(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.t0
    public final Bundle y(Bundle bundle) {
        Parcel parcelY = Y();
        q0.d(parcelY, bundle);
        Parcel parcelZ = Z(1, parcelY);
        Bundle bundle2 = (Bundle) q0.a(parcelZ, Bundle.CREATOR);
        parcelZ.recycle();
        return bundle2;
    }
}
