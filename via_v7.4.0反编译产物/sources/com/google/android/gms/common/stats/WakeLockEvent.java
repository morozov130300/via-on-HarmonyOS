package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
import u1.a;
import v1.c;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Deprecated
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new c();

    /* renamed from: e, reason: collision with root package name */
    public final int f3335e;

    /* renamed from: j, reason: collision with root package name */
    public final long f3336j;

    /* renamed from: k, reason: collision with root package name */
    public int f3337k;

    /* renamed from: l, reason: collision with root package name */
    public final String f3338l;

    /* renamed from: m, reason: collision with root package name */
    public final String f3339m;

    /* renamed from: n, reason: collision with root package name */
    public final String f3340n;

    /* renamed from: o, reason: collision with root package name */
    public final int f3341o;

    /* renamed from: p, reason: collision with root package name */
    public final List f3342p;

    /* renamed from: q, reason: collision with root package name */
    public final String f3343q;

    /* renamed from: r, reason: collision with root package name */
    public final long f3344r;

    /* renamed from: s, reason: collision with root package name */
    public int f3345s;

    /* renamed from: t, reason: collision with root package name */
    public final String f3346t;

    /* renamed from: u, reason: collision with root package name */
    public final float f3347u;

    /* renamed from: v, reason: collision with root package name */
    public final long f3348v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f3349w;

    /* renamed from: x, reason: collision with root package name */
    public long f3350x = -1;

    public WakeLockEvent(int i10, long j10, int i11, String str, int i12, List list, String str2, long j11, int i13, String str3, String str4, float f10, long j12, String str5, boolean z10) {
        this.f3335e = i10;
        this.f3336j = j10;
        this.f3337k = i11;
        this.f3338l = str;
        this.f3339m = str3;
        this.f3340n = str5;
        this.f3341o = i12;
        this.f3342p = list;
        this.f3343q = str2;
        this.f3344r = j11;
        this.f3345s = i13;
        this.f3346t = str4;
        this.f3347u = f10;
        this.f3348v = j12;
        this.f3349w = z10;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int c() {
        return this.f3337k;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long f() {
        return this.f3350x;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long g() {
        return this.f3336j;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String h() {
        List list = this.f3342p;
        String str = this.f3338l;
        int i10 = this.f3341o;
        String strJoin = list == null ? "" : TextUtils.join(",", list);
        int i11 = this.f3345s;
        String str2 = this.f3339m;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.f3346t;
        if (str3 == null) {
            str3 = "";
        }
        float f10 = this.f3347u;
        String str4 = this.f3340n;
        return "\t" + str + "\t" + i10 + "\t" + strJoin + "\t" + i11 + "\t" + str2 + "\t" + str3 + "\t" + f10 + "\t" + (str4 != null ? str4 : "") + "\t" + this.f3349w;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.j(parcel, 1, this.f3335e);
        a.l(parcel, 2, this.f3336j);
        a.o(parcel, 4, this.f3338l, false);
        a.j(parcel, 5, this.f3341o);
        a.p(parcel, 6, this.f3342p, false);
        a.l(parcel, 8, this.f3344r);
        a.o(parcel, 10, this.f3339m, false);
        a.j(parcel, 11, this.f3337k);
        a.o(parcel, 12, this.f3343q, false);
        a.o(parcel, 13, this.f3346t, false);
        a.j(parcel, 14, this.f3345s);
        a.g(parcel, 15, this.f3347u);
        a.l(parcel, 16, this.f3348v);
        a.o(parcel, 17, this.f3340n, false);
        a.c(parcel, 18, this.f3349w);
        a.b(parcel, iA);
    }
}
