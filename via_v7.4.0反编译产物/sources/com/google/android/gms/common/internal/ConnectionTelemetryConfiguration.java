package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import t1.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new b0();

    /* renamed from: e, reason: collision with root package name */
    public final RootTelemetryConfiguration f3302e;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3303j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3304k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f3305l;

    /* renamed from: m, reason: collision with root package name */
    public final int f3306m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f3307n;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z10, boolean z11, int[] iArr, int i10, int[] iArr2) {
        this.f3302e = rootTelemetryConfiguration;
        this.f3303j = z10;
        this.f3304k = z11;
        this.f3305l = iArr;
        this.f3306m = i10;
        this.f3307n = iArr2;
    }

    public int c() {
        return this.f3306m;
    }

    public int[] f() {
        return this.f3305l;
    }

    public int[] g() {
        return this.f3307n;
    }

    public boolean h() {
        return this.f3303j;
    }

    public boolean k() {
        return this.f3304k;
    }

    public final RootTelemetryConfiguration n() {
        return this.f3302e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = u1.a.a(parcel);
        u1.a.n(parcel, 1, this.f3302e, i10, false);
        u1.a.c(parcel, 2, h());
        u1.a.c(parcel, 3, k());
        u1.a.k(parcel, 4, f(), false);
        u1.a.j(parcel, 5, c());
        u1.a.k(parcel, 6, g(), false);
        u1.a.b(parcel, iA);
    }
}
