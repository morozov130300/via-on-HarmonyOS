package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import g2.t;
import u1.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new t();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3263c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zzas f3264e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3265m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f3266n;

    public zzau(zzau zzauVar, long j10) {
        f.h(zzauVar);
        this.f3263c = zzauVar.f3263c;
        this.f3264e = zzauVar.f3264e;
        this.f3265m = zzauVar.f3265m;
        this.f3266n = j10;
    }

    public final String toString() {
        return "origin=" + this.f3265m + ",name=" + this.f3263c + ",params=" + String.valueOf(this.f3264e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        t.a(this, parcel, i10);
    }

    public zzau(String str, zzas zzasVar, String str2, long j10) {
        this.f3263c = str;
        this.f3264e = zzasVar;
        this.f3265m = str2;
        this.f3266n = j10;
    }
}
