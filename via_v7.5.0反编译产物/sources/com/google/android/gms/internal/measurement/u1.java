package com.google.android.gms.internal.measurement;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u1 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Activity f3106o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f3107p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ String f3108q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ u2 f3109r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u1(u2 u2Var, Activity activity, String str, String str2) {
        super(u2Var, true);
        this.f3109r = u2Var;
        this.f3106o = activity;
        this.f3107p = str;
        this.f3108q = str2;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f3109r.f3119i)).setCurrentScreen(z1.b.b0(this.f3106o), this.f3107p, this.f3108q, this.f2867c);
    }
}
