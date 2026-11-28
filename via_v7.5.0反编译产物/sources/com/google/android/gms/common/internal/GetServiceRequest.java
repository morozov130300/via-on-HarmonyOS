package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import u1.c0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new c0();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Scope[] f2608y = new Scope[0];

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Feature[] f2609z = new Feature[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2610c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2611e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2612m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f2613n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IBinder f2614o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Scope[] f2615p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bundle f2616q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Account f2617r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Feature[] f2618s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Feature[] f2619t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2620u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2621v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2622w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f2623x;

    public GetServiceRequest(int i10, int i11, int i12, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z10, int i13, boolean z11, String str2) {
        scopeArr = scopeArr == null ? f2608y : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? f2609z : featureArr;
        featureArr2 = featureArr2 == null ? f2609z : featureArr2;
        this.f2610c = i10;
        this.f2611e = i11;
        this.f2612m = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f2613n = "com.google.android.gms";
        } else {
            this.f2613n = str;
        }
        if (i10 < 2) {
            this.f2617r = iBinder != null ? a.a0(b.a.Z(iBinder)) : null;
        } else {
            this.f2614o = iBinder;
            this.f2617r = account;
        }
        this.f2615p = scopeArr;
        this.f2616q = bundle;
        this.f2618s = featureArr;
        this.f2619t = featureArr2;
        this.f2620u = z10;
        this.f2621v = i13;
        this.f2622w = z11;
        this.f2623x = str2;
    }

    public final String c() {
        return this.f2623x;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        c0.a(this, parcel, i10);
    }
}
