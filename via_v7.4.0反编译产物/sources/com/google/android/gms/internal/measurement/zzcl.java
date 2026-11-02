package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class zzcl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcl> CREATOR = new q1();

    /* renamed from: e, reason: collision with root package name */
    public final long f3923e;

    /* renamed from: j, reason: collision with root package name */
    public final long f3924j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3925k;

    /* renamed from: l, reason: collision with root package name */
    public final String f3926l;

    /* renamed from: m, reason: collision with root package name */
    public final String f3927m;

    /* renamed from: n, reason: collision with root package name */
    public final String f3928n;

    /* renamed from: o, reason: collision with root package name */
    public final Bundle f3929o;

    /* renamed from: p, reason: collision with root package name */
    public final String f3930p;

    public zzcl(long j10, long j11, boolean z10, String str, String str2, String str3, Bundle bundle, String str4) {
        this.f3923e = j10;
        this.f3924j = j11;
        this.f3925k = z10;
        this.f3926l = str;
        this.f3927m = str2;
        this.f3928n = str3;
        this.f3929o = bundle;
        this.f3930p = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = u1.a.a(parcel);
        u1.a.l(parcel, 1, this.f3923e);
        u1.a.l(parcel, 2, this.f3924j);
        u1.a.c(parcel, 3, this.f3925k);
        u1.a.o(parcel, 4, this.f3926l, false);
        u1.a.o(parcel, 5, this.f3927m, false);
        u1.a.o(parcel, 6, this.f3928n, false);
        u1.a.e(parcel, 7, this.f3929o, false);
        u1.a.o(parcel, 8, this.f3930p, false);
        u1.a.b(parcel, iA);
    }
}
