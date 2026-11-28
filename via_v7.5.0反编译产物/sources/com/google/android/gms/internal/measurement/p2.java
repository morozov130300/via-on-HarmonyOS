package com.google.android.gms.internal.measurement;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p2 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Activity f2953o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ t2 f2954p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(t2 t2Var, Activity activity) {
        super(t2Var.f3078c, true);
        this.f2954p = t2Var;
        this.f2953o = activity;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f2954p.f3078c.f3119i)).onActivityPaused(z1.b.b0(this.f2953o), this.f2868e);
    }
}
