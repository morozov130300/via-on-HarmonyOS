package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import f2.bb;
import java.util.List;
import t1.f;
import u1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new bb();
    public final long A;
    public final List B;
    public final String C;
    public final String D;
    public final String E;
    public final String F;
    public final boolean G;
    public final long H;

    /* renamed from: e, reason: collision with root package name */
    public final String f3976e;

    /* renamed from: j, reason: collision with root package name */
    public final String f3977j;

    /* renamed from: k, reason: collision with root package name */
    public final String f3978k;

    /* renamed from: l, reason: collision with root package name */
    public final String f3979l;

    /* renamed from: m, reason: collision with root package name */
    public final long f3980m;

    /* renamed from: n, reason: collision with root package name */
    public final long f3981n;

    /* renamed from: o, reason: collision with root package name */
    public final String f3982o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f3983p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3984q;

    /* renamed from: r, reason: collision with root package name */
    public final long f3985r;

    /* renamed from: s, reason: collision with root package name */
    public final String f3986s;

    /* renamed from: t, reason: collision with root package name */
    public final long f3987t;

    /* renamed from: u, reason: collision with root package name */
    public final long f3988u;

    /* renamed from: v, reason: collision with root package name */
    public final int f3989v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f3990w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f3991x;

    /* renamed from: y, reason: collision with root package name */
    public final String f3992y;

    /* renamed from: z, reason: collision with root package name */
    public final Boolean f3993z;

    public zzq(String str, String str2, String str3, long j10, String str4, long j11, long j12, String str5, boolean z10, boolean z11, String str6, long j13, long j14, int i10, boolean z12, boolean z13, String str7, Boolean bool, long j15, List list, String str8, String str9, String str10, String str11, boolean z14, long j16) {
        f.d(str);
        this.f3976e = str;
        this.f3977j = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f3978k = str3;
        this.f3985r = j10;
        this.f3979l = str4;
        this.f3980m = j11;
        this.f3981n = j12;
        this.f3982o = str5;
        this.f3983p = z10;
        this.f3984q = z11;
        this.f3986s = str6;
        this.f3987t = 0L;
        this.f3988u = j14;
        this.f3989v = i10;
        this.f3990w = z12;
        this.f3991x = z13;
        this.f3992y = str7;
        this.f3993z = bool;
        this.A = j15;
        this.B = list;
        this.C = null;
        this.D = str9;
        this.E = str10;
        this.F = str11;
        this.G = z14;
        this.H = j16;
    }

    public zzq(String str, String str2, String str3, String str4, long j10, long j11, String str5, boolean z10, boolean z11, long j12, String str6, long j13, long j14, int i10, boolean z12, boolean z13, String str7, Boolean bool, long j15, List list, String str8, String str9, String str10, String str11, boolean z14, long j16) {
        this.f3976e = str;
        this.f3977j = str2;
        this.f3978k = str3;
        this.f3985r = j12;
        this.f3979l = str4;
        this.f3980m = j10;
        this.f3981n = j11;
        this.f3982o = str5;
        this.f3983p = z10;
        this.f3984q = z11;
        this.f3986s = str6;
        this.f3987t = j13;
        this.f3988u = j14;
        this.f3989v = i10;
        this.f3990w = z12;
        this.f3991x = z13;
        this.f3992y = str7;
        this.f3993z = bool;
        this.A = j15;
        this.B = list;
        this.C = str8;
        this.D = str9;
        this.E = str10;
        this.F = str11;
        this.G = z14;
        this.H = j16;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.o(parcel, 2, this.f3976e, false);
        a.o(parcel, 3, this.f3977j, false);
        a.o(parcel, 4, this.f3978k, false);
        a.o(parcel, 5, this.f3979l, false);
        a.l(parcel, 6, this.f3980m);
        a.l(parcel, 7, this.f3981n);
        a.o(parcel, 8, this.f3982o, false);
        a.c(parcel, 9, this.f3983p);
        a.c(parcel, 10, this.f3984q);
        a.l(parcel, 11, this.f3985r);
        a.o(parcel, 12, this.f3986s, false);
        a.l(parcel, 13, this.f3987t);
        a.l(parcel, 14, this.f3988u);
        a.j(parcel, 15, this.f3989v);
        a.c(parcel, 16, this.f3990w);
        a.c(parcel, 18, this.f3991x);
        a.o(parcel, 19, this.f3992y, false);
        a.d(parcel, 21, this.f3993z, false);
        a.l(parcel, 22, this.A);
        a.p(parcel, 23, this.B, false);
        a.o(parcel, 24, this.C, false);
        a.o(parcel, 25, this.D, false);
        a.o(parcel, 26, this.E, false);
        a.o(parcel, 27, this.F, false);
        a.c(parcel, 28, this.G);
        a.l(parcel, 29, this.H);
        a.b(parcel, iA);
    }
}
