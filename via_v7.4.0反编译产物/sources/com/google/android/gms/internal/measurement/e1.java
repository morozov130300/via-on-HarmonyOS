package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final p3 f3473a;

    /* renamed from: b, reason: collision with root package name */
    public q4 f3474b;

    /* renamed from: c, reason: collision with root package name */
    public final c f3475c;

    /* renamed from: d, reason: collision with root package name */
    public final gf f3476d;

    public e1() {
        p3 p3Var = new p3();
        this.f3473a = p3Var;
        this.f3474b = p3Var.f3657b.a();
        this.f3475c = new c();
        this.f3476d = new gf();
        p3Var.f3659d.a("internal.registerCallback", new Callable() { // from class: com.google.android.gms.internal.measurement.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f3386e.b();
            }
        });
        p3Var.f3659d.a("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.c0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new f8(this.f3422e.f3475c);
            }
        });
    }

    public final c a() {
        return this.f3475c;
    }

    public final /* synthetic */ k b() {
        return new cf(this.f3476d);
    }

    public final void c(k5 k5Var) throws zzd {
        k kVar;
        try {
            this.f3474b = this.f3473a.f3657b.a();
            if (this.f3473a.a(this.f3474b, (p5[]) k5Var.F().toArray(new p5[0])) instanceof h) {
                throw new IllegalStateException("Program loading failed");
            }
            for (i5 i5Var : k5Var.D().G()) {
                List listF = i5Var.F();
                String strE = i5Var.E();
                Iterator it = listF.iterator();
                while (it.hasNext()) {
                    r rVarA = this.f3473a.a(this.f3474b, (p5) it.next());
                    if (!(rVarA instanceof o)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    q4 q4Var = this.f3474b;
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
                    kVar.a(this.f3474b, Collections.singletonList(rVarA));
                }
            }
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final void d(String str, Callable callable) {
        this.f3473a.f3659d.a(str, callable);
    }

    public final boolean e(b bVar) throws zzd {
        try {
            this.f3475c.d(bVar);
            this.f3473a.f3658c.g("runtime.counter", new j(Double.valueOf(0.0d)));
            this.f3476d.b(this.f3474b.a(), this.f3475c);
            if (g()) {
                return true;
            }
            return f();
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean f() {
        return !this.f3475c.c().isEmpty();
    }

    public final boolean g() {
        c cVar = this.f3475c;
        return !cVar.b().equals(cVar.a());
    }
}
