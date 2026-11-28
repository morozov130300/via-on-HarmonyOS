package m5;

import java.io.IOException;
import k5.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements m {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f7873o = "b";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g5.c f7874c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h5.c f7875e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o f7876m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f7877n;

    public b(g5.c cVar, o oVar, h5.c cVar2) {
        this.f7874c = cVar;
        this.f7877n = cVar.t();
        this.f7875e = cVar2;
        this.f7876m = oVar;
        cVar.T(null);
    }

    @Override // m5.m
    public void a() {
        d5.a.d(f7873o, "Data uri task can not be paused");
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j call() {
        if (g5.b.e(this.f7874c.q())) {
            return j.d();
        }
        h hVarF = !l5.a.e(this.f7877n) ? h.f(2) : null;
        if (hVarF == null) {
            hVarF = d();
        }
        if (hVarF == null) {
            c(100);
            return j.d();
        }
        this.f7874c.A(hVarF.c());
        this.f7874c.B(hVarF.d());
        c(200);
        return j.c(hVarF);
    }

    public final void c(int i10) {
        if (this.f7874c.q() == i10) {
            return;
        }
        int iQ = this.f7874c.q();
        this.f7874c.Q(i10);
        this.f7875e.b(this.f7874c, iQ, i10);
    }

    public final h d() {
        h hVarF;
        try {
            k5.c cVarA = this.f7876m.a(this.f7874c.g());
            try {
                try {
                    cVarA.a(0L);
                    if (l5.a.i(this.f7877n, cVarA)) {
                        cVarA.b();
                        hVarF = null;
                    } else {
                        hVarF = h.f(40);
                    }
                    try {
                        cVarA.close();
                        return hVarF;
                    } catch (IOException e10) {
                        return hVarF == null ? h.h(12, e10) : hVarF;
                    }
                } catch (IOException e11) {
                    h hVarH = h.h(12, e11);
                    try {
                        cVarA.close();
                        return hVarH;
                    } catch (IOException e12) {
                        return hVarH == null ? h.h(12, e12) : hVarH;
                    }
                }
            } catch (Throwable th) {
                try {
                    cVarA.close();
                } catch (IOException e13) {
                    h.h(12, e13);
                }
                throw th;
            }
        } catch (IOException | IllegalArgumentException e14) {
            d5.a.c(f7873o, e14.getMessage(), e14);
            return h.h(12, e14);
        }
    }
}
