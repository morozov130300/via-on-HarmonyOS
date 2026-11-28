package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d2 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f2739o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f2740p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f2741q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ d1 f2742r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ u2 f2743s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(u2 u2Var, String str, String str2, boolean z10, d1 d1Var) {
        super(u2Var, true);
        this.f2743s = u2Var;
        this.f2739o = str;
        this.f2740p = str2;
        this.f2741q = z10;
        this.f2742r = d1Var;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f2743s.f3119i)).getUserProperties(this.f2739o, this.f2740p, this.f2741q, this.f2742r);
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void b() {
        this.f2742r.v(null);
    }
}
