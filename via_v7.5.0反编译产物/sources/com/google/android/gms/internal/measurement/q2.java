package com.google.android.gms.internal.measurement;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q2 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Activity f2996o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ t2 f2997p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q2(t2 t2Var, Activity activity) {
        super(t2Var.f3078c, true);
        this.f2997p = t2Var;
        this.f2996o = activity;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f2997p.f3078c.f3119i)).onActivityStopped(z1.b.b0(this.f2996o), this.f2868e);
    }
}
