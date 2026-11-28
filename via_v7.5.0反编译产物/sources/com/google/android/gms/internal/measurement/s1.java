package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s1 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f3045o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f3046p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Bundle f3047q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ u2 f3048r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(u2 u2Var, String str, String str2, Bundle bundle) {
        super(u2Var, true);
        this.f3048r = u2Var;
        this.f3045o = str;
        this.f3046p = str2;
        this.f3047q = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f3048r.f3119i)).clearConditionalUserProperty(this.f3045o, this.f3046p, this.f3047q);
    }
}
