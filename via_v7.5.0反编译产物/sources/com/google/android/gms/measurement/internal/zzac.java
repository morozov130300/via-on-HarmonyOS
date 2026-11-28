package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import g2.d;
import u1.f;
import v1.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3251c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3252e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public zzlk f3253m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f3254n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3255o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f3256p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final zzau f3257q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f3258r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public zzau f3259s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f3260t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final zzau f3261u;

    public zzac(zzac zzacVar) {
        f.h(zzacVar);
        this.f3251c = zzacVar.f3251c;
        this.f3252e = zzacVar.f3252e;
        this.f3253m = zzacVar.f3253m;
        this.f3254n = zzacVar.f3254n;
        this.f3255o = zzacVar.f3255o;
        this.f3256p = zzacVar.f3256p;
        this.f3257q = zzacVar.f3257q;
        this.f3258r = zzacVar.f3258r;
        this.f3259s = zzacVar.f3259s;
        this.f3260t = zzacVar.f3260t;
        this.f3261u = zzacVar.f3261u;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.o(parcel, 2, this.f3251c, false);
        a.o(parcel, 3, this.f3252e, false);
        a.n(parcel, 4, this.f3253m, i10, false);
        a.l(parcel, 5, this.f3254n);
        a.c(parcel, 6, this.f3255o);
        a.o(parcel, 7, this.f3256p, false);
        a.n(parcel, 8, this.f3257q, i10, false);
        a.l(parcel, 9, this.f3258r);
        a.n(parcel, 10, this.f3259s, i10, false);
        a.l(parcel, 11, this.f3260t);
        a.n(parcel, 12, this.f3261u, i10, false);
        a.b(parcel, iA);
    }

    public zzac(String str, String str2, zzlk zzlkVar, long j10, boolean z10, String str3, zzau zzauVar, long j11, zzau zzauVar2, long j12, zzau zzauVar3) {
        this.f3251c = str;
        this.f3252e = str2;
        this.f3253m = zzlkVar;
        this.f3254n = j10;
        this.f3255o = z10;
        this.f3256p = str3;
        this.f3257q = zzauVar;
        this.f3258r = j11;
        this.f3259s = zzauVar2;
        this.f3260t = j12;
        this.f3261u = zzauVar3;
    }
}
