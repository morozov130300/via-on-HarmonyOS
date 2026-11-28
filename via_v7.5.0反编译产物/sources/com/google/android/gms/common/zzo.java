package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import r1.w;
import z1.a;
import z1.b;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new w();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2650c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2651e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f2652m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f2653n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f2654o;

    public zzo(String str, boolean z10, boolean z11, IBinder iBinder, boolean z12) {
        this.f2650c = str;
        this.f2651e = z10;
        this.f2652m = z11;
        this.f2653n = (Context) b.a0(a.AbstractBinderC0163a.Z(iBinder));
        this.f2654o = z12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.IBinder, z1.a] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = v1.a.a(parcel);
        v1.a.o(parcel, 1, this.f2650c, false);
        v1.a.c(parcel, 2, this.f2651e);
        v1.a.c(parcel, 3, this.f2652m);
        v1.a.i(parcel, 4, b.b0(this.f2653n), false);
        v1.a.c(parcel, 5, this.f2654o);
        v1.a.b(parcel, iA);
    }
}
