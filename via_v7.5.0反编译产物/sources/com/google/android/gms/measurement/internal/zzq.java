package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import g2.bb;
import java.util.List;
import u1.f;
import v1.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new bb();
    public final String A;
    public final Boolean B;
    public final long C;
    public final List D;
    public final String E;
    public final String F;
    public final String G;
    public final String H;
    public final boolean I;
    public final long J;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3275c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3276e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f3278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f3279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f3280p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f3281q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f3282r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f3283s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f3284t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f3285u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f3286v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f3287w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f3288x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f3289y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f3290z;

    public zzq(String str, String str2, String str3, long j10, String str4, long j11, long j12, String str5, boolean z10, boolean z11, String str6, long j13, long j14, int i10, boolean z12, boolean z13, String str7, Boolean bool, long j15, List list, String str8, String str9, String str10, String str11, boolean z14, long j16) {
        f.d(str);
        this.f3275c = str;
        this.f3276e = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f3277m = str3;
        this.f3284t = j10;
        this.f3278n = str4;
        this.f3279o = j11;
        this.f3280p = j12;
        this.f3281q = str5;
        this.f3282r = z10;
        this.f3283s = z11;
        this.f3285u = str6;
        this.f3286v = 0L;
        this.f3287w = j14;
        this.f3288x = i10;
        this.f3289y = z12;
        this.f3290z = z13;
        this.A = str7;
        this.B = bool;
        this.C = j15;
        this.D = list;
        this.E = null;
        this.F = str9;
        this.G = str10;
        this.H = str11;
        this.I = z14;
        this.J = j16;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.o(parcel, 2, this.f3275c, false);
        a.o(parcel, 3, this.f3276e, false);
        a.o(parcel, 4, this.f3277m, false);
        a.o(parcel, 5, this.f3278n, false);
        a.l(parcel, 6, this.f3279o);
        a.l(parcel, 7, this.f3280p);
        a.o(parcel, 8, this.f3281q, false);
        a.c(parcel, 9, this.f3282r);
        a.c(parcel, 10, this.f3283s);
        a.l(parcel, 11, this.f3284t);
        a.o(parcel, 12, this.f3285u, false);
        a.l(parcel, 13, this.f3286v);
        a.l(parcel, 14, this.f3287w);
        a.j(parcel, 15, this.f3288x);
        a.c(parcel, 16, this.f3289y);
        a.c(parcel, 18, this.f3290z);
        a.o(parcel, 19, this.A, false);
        a.d(parcel, 21, this.B, false);
        a.l(parcel, 22, this.C);
        a.p(parcel, 23, this.D, false);
        a.o(parcel, 24, this.E, false);
        a.o(parcel, 25, this.F, false);
        a.o(parcel, 26, this.G, false);
        a.o(parcel, 27, this.H, false);
        a.c(parcel, 28, this.I);
        a.l(parcel, 29, this.J);
        a.b(parcel, iA);
    }

    public zzq(String str, String str2, String str3, String str4, long j10, long j11, String str5, boolean z10, boolean z11, long j12, String str6, long j13, long j14, int i10, boolean z12, boolean z13, String str7, Boolean bool, long j15, List list, String str8, String str9, String str10, String str11, boolean z14, long j16) {
        this.f3275c = str;
        this.f3276e = str2;
        this.f3277m = str3;
        this.f3284t = j12;
        this.f3278n = str4;
        this.f3279o = j10;
        this.f3280p = j11;
        this.f3281q = str5;
        this.f3282r = z10;
        this.f3283s = z11;
        this.f3285u = str6;
        this.f3286v = j13;
        this.f3287w = j14;
        this.f3288x = i10;
        this.f3289y = z12;
        this.f3290z = z13;
        this.A = str7;
        this.B = bool;
        this.C = j15;
        this.D = list;
        this.E = str8;
        this.F = str9;
        this.G = str10;
        this.H = str11;
        this.I = z14;
        this.J = j16;
    }
}
