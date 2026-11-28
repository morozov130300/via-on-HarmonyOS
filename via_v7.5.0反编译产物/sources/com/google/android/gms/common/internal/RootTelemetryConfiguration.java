package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import u1.q;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new q();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2624c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2625e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f2626m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f2627n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f2628o;

    public RootTelemetryConfiguration(int i10, boolean z10, boolean z11, int i11, int i12) {
        this.f2624c = i10;
        this.f2625e = z10;
        this.f2626m = z11;
        this.f2627n = i11;
        this.f2628o = i12;
    }

    public int c() {
        return this.f2627n;
    }

    public int f() {
        return this.f2628o;
    }

    public boolean g() {
        return this.f2625e;
    }

    public boolean h() {
        return this.f2626m;
    }

    public int k() {
        return this.f2624c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = v1.a.a(parcel);
        v1.a.j(parcel, 1, k());
        v1.a.c(parcel, 2, g());
        v1.a.c(parcel, 3, h());
        v1.a.j(parcel, 4, c());
        v1.a.j(parcel, 5, f());
        v1.a.b(parcel, iA);
    }
}
