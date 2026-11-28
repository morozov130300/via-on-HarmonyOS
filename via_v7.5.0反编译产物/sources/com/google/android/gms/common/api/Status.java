package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import s1.a;
import s1.c;
import u1.e;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2595c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2596e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f2597m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PendingIntent f2598n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConnectionResult f2599o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Status f2587p = new Status(-1);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Status f2588q = new Status(0);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Status f2589r = new Status(14);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Status f2590s = new Status(8);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Status f2591t = new Status(15);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Status f2592u = new Status(16);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Status f2594w = new Status(17);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Status f2593v = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new c();

    public Status(int i10, int i11, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f2595c = i10;
        this.f2596e = i11;
        this.f2597m = str;
        this.f2598n = pendingIntent;
        this.f2599o = connectionResult;
    }

    public ConnectionResult c() {
        return this.f2599o;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f2595c == status.f2595c && this.f2596e == status.f2596e && e.a(this.f2597m, status.f2597m) && e.a(this.f2598n, status.f2598n) && e.a(this.f2599o, status.f2599o);
    }

    public int f() {
        return this.f2596e;
    }

    public String g() {
        return this.f2597m;
    }

    public final String h() {
        String str = this.f2597m;
        return str != null ? str : a.a(this.f2596e);
    }

    public int hashCode() {
        return e.b(Integer.valueOf(this.f2595c), Integer.valueOf(this.f2596e), this.f2597m, this.f2598n, this.f2599o);
    }

    public String toString() {
        e.a aVarC = e.c(this);
        aVarC.a("statusCode", h());
        aVarC.a("resolution", this.f2598n);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = v1.a.a(parcel);
        v1.a.j(parcel, 1, f());
        v1.a.o(parcel, 2, g(), false);
        v1.a.n(parcel, 3, this.f2598n, i10, false);
        v1.a.n(parcel, 4, c(), i10, false);
        v1.a.j(parcel, 1000, this.f2595c);
        v1.a.b(parcel, iA);
    }

    public Status(int i10) {
        this(i10, null);
    }

    public Status(int i10, String str) {
        this(1, i10, str, null, null);
    }
}
