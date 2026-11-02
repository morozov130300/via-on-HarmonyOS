package m5;

import java.io.IOException;
import k5.o;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements l {

    /* renamed from: m, reason: collision with root package name */
    public static final String f8623m = "b";

    /* renamed from: e, reason: collision with root package name */
    public final g5.c f8624e;

    /* renamed from: j, reason: collision with root package name */
    public final h5.c f8625j;

    /* renamed from: k, reason: collision with root package name */
    public final o f8626k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8627l;

    public b(g5.c cVar, o oVar, h5.c cVar2) {
        this.f8624e = cVar;
        this.f8627l = cVar.t();
        this.f8625j = cVar2;
        this.f8626k = oVar;
        cVar.S(null);
    }

    @Override // m5.l
    public void a() {
        d5.a.d(f8623m, "Data uri task can not be paused");
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j call() throws Throwable {
        if (g5.b.e(this.f8624e.q())) {
            return j.d();
        }
        h hVarF = !l5.a.e(this.f8627l) ? h.f(2) : null;
        if (hVarF == null) {
            hVarF = d();
        }
        if (hVarF == null) {
            c(100);
            return j.d();
        }
        this.f8624e.A(hVarF.c());
        this.f8624e.B(hVarF.d());
        c(200);
        return j.c(hVarF);
    }

    public final void c(int i10) {
        if (this.f8624e.q() == i10) {
            return;
        }
        int iQ = this.f8624e.q();
        this.f8624e.P(i10);
        this.f8625j.b(this.f8624e, iQ, i10);
    }

    public final h d() throws Throwable {
        k5.c cVarA;
        Throwable th;
        try {
            try {
                cVarA = this.f8626k.a(this.f8624e.g());
                try {
                    if (l5.a.i(this.f8627l, cVarA)) {
                        if (cVarA != null) {
                            try {
                                cVarA.close();
                            } catch (IOException unused) {
                            }
                        }
                        return null;
                    }
                    h hVarF = h.f(40);
                    if (cVarA != null) {
                        try {
                            cVarA.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return hVarF;
                } catch (Throwable th2) {
                    th = th2;
                    if (cVarA != null) {
                        try {
                            cVarA.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                cVarA = null;
                th = th3;
            }
        } catch (IOException | IllegalArgumentException e10) {
            d5.a.c(f8623m, e10.getMessage(), e10);
            return h.h(12, e10);
        }
    }
}
