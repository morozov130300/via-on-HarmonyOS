package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z1 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d1 f3206o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ u2 f3207p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z1(u2 u2Var, d1 d1Var) {
        super(u2Var, true);
        this.f3207p = u2Var;
        this.f3206o = d1Var;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f3207p.f3119i)).getCachedAppInstanceId(this.f3206o);
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void b() {
        this.f3206o.v(null);
    }
}
