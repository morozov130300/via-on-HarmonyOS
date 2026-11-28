package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q4 f2823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2824b;

    public h0(q4 q4Var, String str) {
        this.f2823a = q4Var;
        this.f2824b = str;
    }

    @Override // com.google.android.gms.internal.measurement.i0
    public final q4 a(r rVar) {
        q4 q4VarA = this.f2823a.a();
        q4VarA.e(this.f2824b, rVar);
        return q4VarA;
    }
}
