package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import u1.a0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new a0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f2630c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Feature[] f2631e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ConnectionTelemetryConfiguration f2633n;

    public zzj(Bundle bundle, Feature[] featureArr, int i10, ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f2630c = bundle;
        this.f2631e = featureArr;
        this.f2632m = i10;
        this.f2633n = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = v1.a.a(parcel);
        v1.a.e(parcel, 1, this.f2630c, false);
        v1.a.q(parcel, 2, this.f2631e, i10, false);
        v1.a.j(parcel, 3, this.f2632m);
        v1.a.n(parcel, 4, this.f2633n, i10, false);
        v1.a.b(parcel, iA);
    }
}
