package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p3 f2772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q4 f2773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f2774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gf f2775d;

    public e1() {
        p3 p3Var = new p3();
        this.f2772a = p3Var;
        this.f2773b = p3Var.f2956b.a();
        this.f2774c = new c();
        this.f2775d = new gf();
        p3Var.f2958d.a("internal.registerCallback", new Callable() { // from class: com.google.android.gms.internal.measurement.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2685c.b();
            }
        });
        p3Var.f2958d.a("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.c0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new f8(this.f2721c.f2774c);
            }
        });
    }

    public final c a() {
        return this.f2774c;
    }

    public final /* synthetic */ k b() {
        return new cf(this.f2775d);
    }

    public final void c(k5 k5Var) throws zzd {
        k kVar;
        try {
            this.f2773b = this.f2772a.f2956b.a();
            if (this.f2772a.a(this.f2773b, (p5[]) k5Var.F().toArray(new p5[0])) instanceof h) {
                throw new IllegalStateException("Program loading failed");
            }
            for (i5 i5Var : k5Var.D().G()) {
                List listF = i5Var.F();
                String strE = i5Var.E();
                Iterator it = listF.iterator();
                while (it.hasNext()) {
                    r rVarA = this.f2772a.a(this.f2773b, (p5) it.next());
                    if (!(rVarA instanceof o)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    q4 q4Var = this.f2773b;
                    if (q4Var.h(strE)) {
                        r rVarD = q4Var.d(strE);
                        if (!(rVarD instanceof k)) {
                            throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(strE)));
                        }
                        kVar = (k) rVarD;
                    } else {
                        kVar = null;
                    }
                    if (kVar == null) {
                        throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(strE)));
                    }
                    kVar.a(this.f2773b, Collections.singletonList(rVarA));
                }
            }
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final void d(String str, Callable callable) {
        this.f2772a.f2958d.a(str, callable);
    }

    public final boolean e(b bVar) throws zzd {
        try {
            this.f2774c.d(bVar);
            this.f2772a.f2957c.g("runtime.counter", new j(Double.valueOf(0.0d)));
            this.f2775d.b(this.f2773b.a(), this.f2774c);
            return g() || f();
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean f() {
        return !this.f2774c.c().isEmpty();
    }

    public final boolean g() {
        c cVar = this.f2774c;
        return !cVar.b().equals(cVar.a());
    }
}
