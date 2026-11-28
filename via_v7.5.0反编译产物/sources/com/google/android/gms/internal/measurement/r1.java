package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r1 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Bundle f3021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ u2 f3022p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(u2 u2Var, Bundle bundle) {
        super(u2Var, true);
        this.f3022p = u2Var;
        this.f3021o = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f3022p.f3119i)).setConditionalUserProperty(this.f3021o, this.f2867c);
    }
}
