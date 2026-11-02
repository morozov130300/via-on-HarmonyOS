package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import t1.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new q();

    /* renamed from: e, reason: collision with root package name */
    public final int f3325e;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3326j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3327k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3328l;

    /* renamed from: m, reason: collision with root package name */
    public final int f3329m;

    public RootTelemetryConfiguration(int i10, boolean z10, boolean z11, int i11, int i12) {
        this.f3325e = i10;
        this.f3326j = z10;
        this.f3327k = z11;
        this.f3328l = i11;
        this.f3329m = i12;
    }

    public int c() {
        return this.f3328l;
    }

    public int f() {
        return this.f3329m;
    }

    public boolean g() {
        return this.f3326j;
    }

    public boolean h() {
        return this.f3327k;
    }

    public int k() {
        return this.f3325e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = u1.a.a(parcel);
        u1.a.j(parcel, 1, k());
        u1.a.c(parcel, 2, g());
        u1.a.c(parcel, 3, h());
        u1.a.j(parcel, 4, c());
        u1.a.j(parcel, 5, f());
        u1.a.b(parcel, iA);
    }
}
