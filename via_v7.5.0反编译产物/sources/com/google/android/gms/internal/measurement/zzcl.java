package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzcl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcl> CREATOR = new q1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3222c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3223e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f3224m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f3225n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f3226o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f3227p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Bundle f3228q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f3229r;

    public zzcl(long j10, long j11, boolean z10, String str, String str2, String str3, Bundle bundle, String str4) {
        this.f3222c = j10;
        this.f3223e = j11;
        this.f3224m = z10;
        this.f3225n = str;
        this.f3226o = str2;
        this.f3227p = str3;
        this.f3228q = bundle;
        this.f3229r = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = v1.a.a(parcel);
        v1.a.l(parcel, 1, this.f3222c);
        v1.a.l(parcel, 2, this.f3223e);
        v1.a.c(parcel, 3, this.f3224m);
        v1.a.o(parcel, 4, this.f3225n, false);
        v1.a.o(parcel, 5, this.f3226o, false);
        v1.a.o(parcel, 6, this.f3227p, false);
        v1.a.e(parcel, 7, this.f3228q, false);
        v1.a.o(parcel, 8, this.f3229r, false);
        v1.a.b(parcel, iA);
    }
}
