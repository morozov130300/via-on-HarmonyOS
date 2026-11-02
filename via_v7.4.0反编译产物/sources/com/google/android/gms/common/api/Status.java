package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import r1.a;
import r1.c;
import t1.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements ReflectedParcelable {

    /* renamed from: e, reason: collision with root package name */
    public final int f3296e;

    /* renamed from: j, reason: collision with root package name */
    public final int f3297j;

    /* renamed from: k, reason: collision with root package name */
    public final String f3298k;

    /* renamed from: l, reason: collision with root package name */
    public final PendingIntent f3299l;

    /* renamed from: m, reason: collision with root package name */
    public final ConnectionResult f3300m;

    /* renamed from: n, reason: collision with root package name */
    public static final Status f3288n = new Status(-1);

    /* renamed from: o, reason: collision with root package name */
    public static final Status f3289o = new Status(0);

    /* renamed from: p, reason: collision with root package name */
    public static final Status f3290p = new Status(14);

    /* renamed from: q, reason: collision with root package name */
    public static final Status f3291q = new Status(8);

    /* renamed from: r, reason: collision with root package name */
    public static final Status f3292r = new Status(15);

    /* renamed from: s, reason: collision with root package name */
    public static final Status f3293s = new Status(16);

    /* renamed from: u, reason: collision with root package name */
    public static final Status f3295u = new Status(17);

    /* renamed from: t, reason: collision with root package name */
    public static final Status f3294t = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new c();

    public Status(int i10) {
        this(i10, null);
    }

    public Status(int i10, int i11, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f3296e = i10;
        this.f3297j = i11;
        this.f3298k = str;
        this.f3299l = pendingIntent;
        this.f3300m = connectionResult;
    }

    public Status(int i10, String str) {
        this(1, i10, str, null, null);
    }

    public ConnectionResult c() {
        return this.f3300m;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f3296e == status.f3296e && this.f3297j == status.f3297j && e.a(this.f3298k, status.f3298k) && e.a(this.f3299l, status.f3299l) && e.a(this.f3300m, status.f3300m);
    }

    public int f() {
        return this.f3297j;
    }

    public String g() {
        return this.f3298k;
    }

    public final String h() {
        String str = this.f3298k;
        return str != null ? str : a.a(this.f3297j);
    }

    public int hashCode() {
        return e.b(Integer.valueOf(this.f3296e), Integer.valueOf(this.f3297j), this.f3298k, this.f3299l, this.f3300m);
    }

    public String toString() {
        e.a aVarC = e.c(this);
        aVarC.a("statusCode", h());
        aVarC.a("resolution", this.f3299l);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = u1.a.a(parcel);
        u1.a.j(parcel, 1, f());
        u1.a.o(parcel, 2, g(), false);
        u1.a.n(parcel, 3, this.f3299l, i10, false);
        u1.a.n(parcel, 4, c(), i10, false);
        u1.a.j(parcel, 1000, this.f3296e);
        u1.a.b(parcel, iA);
    }
}
