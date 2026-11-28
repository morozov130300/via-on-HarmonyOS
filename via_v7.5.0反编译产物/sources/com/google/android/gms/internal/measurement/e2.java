package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e2 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f2776o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f2777p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ u2 f2778q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2(u2 u2Var, boolean z10, int i10, String str, Object obj, Object obj2, Object obj3) {
        super(u2Var, false);
        this.f2778q = u2Var;
        this.f2776o = str;
        this.f2777p = obj;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        ((h1) u1.f.h(this.f2778q.f3119i)).logHealthData(5, this.f2776o, z1.b.b0(this.f2777p), z1.b.b0(null), z1.b.b0(null));
    }
}
