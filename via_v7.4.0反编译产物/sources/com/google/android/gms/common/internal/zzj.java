package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import t1.a0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new a0();

    /* renamed from: e, reason: collision with root package name */
    public Bundle f3331e;

    /* renamed from: j, reason: collision with root package name */
    public Feature[] f3332j;

    /* renamed from: k, reason: collision with root package name */
    public int f3333k;

    /* renamed from: l, reason: collision with root package name */
    public ConnectionTelemetryConfiguration f3334l;

    public zzj(Bundle bundle, Feature[] featureArr, int i10, ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f3331e = bundle;
        this.f3332j = featureArr;
        this.f3333k = i10;
        this.f3334l = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = u1.a.a(parcel);
        u1.a.e(parcel, 1, this.f3331e, false);
        u1.a.q(parcel, 2, this.f3332j, i10, false);
        u1.a.j(parcel, 3, this.f3333k);
        u1.a.n(parcel, 4, this.f3334l, i10, false);
        u1.a.b(parcel, iA);
    }
}
