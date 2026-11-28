package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import r1.d0;
import r1.l;
import r1.x;
import v1.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new x();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2655c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2656e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f2657m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f2658n;

    public zzq(boolean z10, String str, int i10, int i11) {
        this.f2655c = z10;
        this.f2656e = str;
        this.f2657m = d0.a(i10) - 1;
        this.f2658n = l.a(i11) - 1;
    }

    public final String c() {
        return this.f2656e;
    }

    public final boolean f() {
        return this.f2655c;
    }

    public final int g() {
        return l.a(this.f2658n);
    }

    public final int h() {
        return d0.a(this.f2657m);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.c(parcel, 1, this.f2655c);
        a.o(parcel, 2, this.f2656e, false);
        a.j(parcel, 3, this.f2657m);
        a.j(parcel, 4, this.f2658n);
        a.b(parcel, iA);
    }
}
