package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
import v1.a;
import w1.c;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2634c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f2635e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f2637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f2638o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f2639p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f2640q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f2641r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f2642s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f2643t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2644u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f2645v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f2646w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f2647x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f2648y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f2649z = -1;

    public WakeLockEvent(int i10, long j10, int i11, String str, int i12, List list, String str2, long j11, int i13, String str3, String str4, float f10, long j12, String str5, boolean z10) {
        this.f2634c = i10;
        this.f2635e = j10;
        this.f2636m = i11;
        this.f2637n = str;
        this.f2638o = str3;
        this.f2639p = str5;
        this.f2640q = i12;
        this.f2641r = list;
        this.f2642s = str2;
        this.f2643t = j11;
        this.f2644u = i13;
        this.f2645v = str4;
        this.f2646w = f10;
        this.f2647x = j12;
        this.f2648y = z10;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int c() {
        return this.f2636m;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long f() {
        return this.f2649z;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long g() {
        return this.f2635e;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String h() {
        List list = this.f2641r;
        String str = this.f2637n;
        int i10 = this.f2640q;
        String strJoin = list == null ? "" : TextUtils.join(",", list);
        int i11 = this.f2644u;
        String str2 = this.f2638o;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.f2645v;
        if (str3 == null) {
            str3 = "";
        }
        float f10 = this.f2646w;
        String str4 = this.f2639p;
        return "\t" + str + "\t" + i10 + "\t" + strJoin + "\t" + i11 + "\t" + str2 + "\t" + str3 + "\t" + f10 + "\t" + (str4 != null ? str4 : "") + "\t" + this.f2648y;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.j(parcel, 1, this.f2634c);
        a.l(parcel, 2, this.f2635e);
        a.o(parcel, 4, this.f2637n, false);
        a.j(parcel, 5, this.f2640q);
        a.p(parcel, 6, this.f2641r, false);
        a.l(parcel, 8, this.f2643t);
        a.o(parcel, 10, this.f2638o, false);
        a.j(parcel, 11, this.f2636m);
        a.o(parcel, 12, this.f2642s, false);
        a.o(parcel, 13, this.f2645v, false);
        a.j(parcel, 14, this.f2644u);
        a.g(parcel, 15, this.f2646w);
        a.l(parcel, 16, this.f2647x);
        a.o(parcel, 17, this.f2639p, false);
        a.c(parcel, 18, this.f2648y);
        a.b(parcel, iA);
    }
}
