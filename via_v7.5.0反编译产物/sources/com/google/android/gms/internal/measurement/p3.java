package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f2955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q4 f2956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q4 f2957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n7 f2958d;

    public p3() {
        z zVar = new z();
        this.f2955a = zVar;
        q4 q4Var = new q4(null, zVar);
        this.f2957c = q4Var;
        this.f2956b = q4Var.a();
        n7 n7Var = new n7();
        this.f2958d = n7Var;
        q4Var.g("require", new df(n7Var));
        n7Var.a("internal.platform", new Callable() { // from class: com.google.android.gms.internal.measurement.o2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new ff();
            }
        });
        q4Var.g("runtime.counter", new j(Double.valueOf(0.0d)));
    }

    public final r a(q4 q4Var, p5... p5VarArr) {
        r rVarA = r.f3013a;
        for (p5 p5Var : p5VarArr) {
            rVarA = t6.a(p5Var);
            r5.c(this.f2957c);
            if ((rVarA instanceof s) || (rVarA instanceof q)) {
                rVarA = this.f2955a.a(q4Var, rVarA);
            }
        }
        return rVarA;
    }
}
