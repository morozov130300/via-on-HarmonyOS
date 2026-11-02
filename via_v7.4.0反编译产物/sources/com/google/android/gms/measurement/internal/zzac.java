package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import f2.d;
import t1.f;
import u1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new d();

    /* renamed from: e, reason: collision with root package name */
    public String f3952e;

    /* renamed from: j, reason: collision with root package name */
    public String f3953j;

    /* renamed from: k, reason: collision with root package name */
    public zzlk f3954k;

    /* renamed from: l, reason: collision with root package name */
    public long f3955l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3956m;

    /* renamed from: n, reason: collision with root package name */
    public String f3957n;

    /* renamed from: o, reason: collision with root package name */
    public final zzau f3958o;

    /* renamed from: p, reason: collision with root package name */
    public long f3959p;

    /* renamed from: q, reason: collision with root package name */
    public zzau f3960q;

    /* renamed from: r, reason: collision with root package name */
    public final long f3961r;

    /* renamed from: s, reason: collision with root package name */
    public final zzau f3962s;

    public zzac(zzac zzacVar) {
        f.h(zzacVar);
        this.f3952e = zzacVar.f3952e;
        this.f3953j = zzacVar.f3953j;
        this.f3954k = zzacVar.f3954k;
        this.f3955l = zzacVar.f3955l;
        this.f3956m = zzacVar.f3956m;
        this.f3957n = zzacVar.f3957n;
        this.f3958o = zzacVar.f3958o;
        this.f3959p = zzacVar.f3959p;
        this.f3960q = zzacVar.f3960q;
        this.f3961r = zzacVar.f3961r;
        this.f3962s = zzacVar.f3962s;
    }

    public zzac(String str, String str2, zzlk zzlkVar, long j10, boolean z10, String str3, zzau zzauVar, long j11, zzau zzauVar2, long j12, zzau zzauVar3) {
        this.f3952e = str;
        this.f3953j = str2;
        this.f3954k = zzlkVar;
        this.f3955l = j10;
        this.f3956m = z10;
        this.f3957n = str3;
        this.f3958o = zzauVar;
        this.f3959p = j11;
        this.f3960q = zzauVar2;
        this.f3961r = j12;
        this.f3962s = zzauVar3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.o(parcel, 2, this.f3952e, false);
        a.o(parcel, 3, this.f3953j, false);
        a.n(parcel, 4, this.f3954k, i10, false);
        a.l(parcel, 5, this.f3955l);
        a.c(parcel, 6, this.f3956m);
        a.o(parcel, 7, this.f3957n, false);
        a.n(parcel, 8, this.f3958o, i10, false);
        a.l(parcel, 9, this.f3959p);
        a.n(parcel, 10, this.f3960q, i10, false);
        a.l(parcel, 11, this.f3961r);
        a.n(parcel, 12, this.f3962s, i10, false);
        a.b(parcel, iA);
    }
}
