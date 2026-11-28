package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import u1.b0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new b0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RootTelemetryConfiguration f2601c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2602e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f2603m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int[] f2604n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f2605o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f2606p;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z10, boolean z11, int[] iArr, int i10, int[] iArr2) {
        this.f2601c = rootTelemetryConfiguration;
        this.f2602e = z10;
        this.f2603m = z11;
        this.f2604n = iArr;
        this.f2605o = i10;
        this.f2606p = iArr2;
    }

    public int c() {
        return this.f2605o;
    }

    public int[] f() {
        return this.f2604n;
    }

    public int[] g() {
        return this.f2606p;
    }

    public boolean h() {
        return this.f2602e;
    }

    public boolean k() {
        return this.f2603m;
    }

    public final RootTelemetryConfiguration n() {
        return this.f2601c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = v1.a.a(parcel);
        v1.a.n(parcel, 1, this.f2601c, i10, false);
        v1.a.c(parcel, 2, h());
        v1.a.c(parcel, 3, k());
        v1.a.k(parcel, 4, f(), false);
        v1.a.j(parcel, 5, c());
        v1.a.k(parcel, 6, g(), false);
        v1.a.b(parcel, iA);
    }
}
