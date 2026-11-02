package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import t1.c0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new c0();

    /* renamed from: w, reason: collision with root package name */
    public static final Scope[] f3309w = new Scope[0];

    /* renamed from: x, reason: collision with root package name */
    public static final Feature[] f3310x = new Feature[0];

    /* renamed from: e, reason: collision with root package name */
    public final int f3311e;

    /* renamed from: j, reason: collision with root package name */
    public final int f3312j;

    /* renamed from: k, reason: collision with root package name */
    public int f3313k;

    /* renamed from: l, reason: collision with root package name */
    public String f3314l;

    /* renamed from: m, reason: collision with root package name */
    public IBinder f3315m;

    /* renamed from: n, reason: collision with root package name */
    public Scope[] f3316n;

    /* renamed from: o, reason: collision with root package name */
    public Bundle f3317o;

    /* renamed from: p, reason: collision with root package name */
    public Account f3318p;

    /* renamed from: q, reason: collision with root package name */
    public Feature[] f3319q;

    /* renamed from: r, reason: collision with root package name */
    public Feature[] f3320r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3321s;

    /* renamed from: t, reason: collision with root package name */
    public int f3322t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3323u;

    /* renamed from: v, reason: collision with root package name */
    public String f3324v;

    public GetServiceRequest(int i10, int i11, int i12, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z10, int i13, boolean z11, String str2) {
        scopeArr = scopeArr == null ? f3309w : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? f3310x : featureArr;
        featureArr2 = featureArr2 == null ? f3310x : featureArr2;
        this.f3311e = i10;
        this.f3312j = i11;
        this.f3313k = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f3314l = "com.google.android.gms";
        } else {
            this.f3314l = str;
        }
        if (i10 < 2) {
            this.f3318p = iBinder != null ? a.a0(b.a.Z(iBinder)) : null;
        } else {
            this.f3315m = iBinder;
            this.f3318p = account;
        }
        this.f3316n = scopeArr;
        this.f3317o = bundle;
        this.f3319q = featureArr;
        this.f3320r = featureArr2;
        this.f3321s = z10;
        this.f3322t = i13;
        this.f3323u = z11;
        this.f3324v = str2;
    }

    public final String c() {
        return this.f3324v;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        c0.a(this, parcel, i10);
    }
}
