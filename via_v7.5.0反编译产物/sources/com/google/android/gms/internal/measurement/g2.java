package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g2 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f2812o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d1 f2813p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ u2 f2814q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(u2 u2Var, String str, d1 d1Var) {
        super(u2Var, true);
        this.f2814q = u2Var;
        this.f2812o = str;
        this.f2813p = d1Var;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f2814q.f3119i)).getMaxUserProperties(this.f2812o, this.f2813p);
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void b() {
        this.f2813p.v(null);
    }
}
