package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h2 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ k2 f2825o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ u2 f2826p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h2(u2 u2Var, k2 k2Var) {
        super(u2Var, true);
        this.f2826p = u2Var;
        this.f2825o = k2Var;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f2826p.f3119i)).registerOnMeasurementEventListener(this.f2825o);
    }
}
