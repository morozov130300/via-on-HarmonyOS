package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q4 f2810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2811b;

    public g0(q4 q4Var, String str) {
        this.f2810a = q4Var;
        this.f2811b = str;
    }

    @Override // com.google.android.gms.internal.measurement.i0
    public final q4 a(r rVar) {
        q4 q4VarA = this.f2810a.a();
        q4VarA.f(this.f2811b, rVar);
        return q4VarA;
    }
}
