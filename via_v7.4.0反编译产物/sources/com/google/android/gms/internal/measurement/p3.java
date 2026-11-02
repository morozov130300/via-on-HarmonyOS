package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p3 {

    /* renamed from: a, reason: collision with root package name */
    public final z f3656a;

    /* renamed from: b, reason: collision with root package name */
    public final q4 f3657b;

    /* renamed from: c, reason: collision with root package name */
    public final q4 f3658c;

    /* renamed from: d, reason: collision with root package name */
    public final n7 f3659d;

    public p3() {
        z zVar = new z();
        this.f3656a = zVar;
        q4 q4Var = new q4(null, zVar);
        this.f3658c = q4Var;
        this.f3657b = q4Var.a();
        n7 n7Var = new n7();
        this.f3659d = n7Var;
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
        r rVarA = r.f3714a;
        for (p5 p5Var : p5VarArr) {
            rVarA = t6.a(p5Var);
            r5.c(this.f3658c);
            if ((rVarA instanceof s) || (rVarA instanceof q)) {
                rVarA = this.f3656a.a(q4Var, rVarA);
            }
        }
        return rVarA;
    }
}
