package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t1 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f3074o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f3075p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ d1 f3076q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ u2 f3077r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t1(u2 u2Var, String str, String str2, d1 d1Var) {
        super(u2Var, true);
        this.f3077r = u2Var;
        this.f3074o = str;
        this.f3075p = str2;
        this.f3076q = d1Var;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f3077r.f3119i)).getConditionalUserProperties(this.f3074o, this.f3075p, this.f3076q);
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void b() {
        this.f3076q.v(null);
    }
}
