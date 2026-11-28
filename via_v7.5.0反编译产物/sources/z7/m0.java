package z7;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m0 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m9.c f15293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.n f15294g = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.n f15295h = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f15296i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i8.n f15297j = new i8.n();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f15298k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f15299l;

    public m0(m9.c cVar) {
        this.f15293f = cVar;
    }

    public static /* synthetic */ void l(m0 m0Var, x.d dVar) {
        m0Var.f15294g.m((m9.a) dVar.f14455a);
        m0Var.f15295h.m((m9.a) dVar.f14456b);
        m0Var.w();
    }

    public static /* synthetic */ void o(m0 m0Var, Boolean bool) {
        m0Var.getClass();
        if (bool.booleanValue()) {
            m0Var.f15298k = false;
            u9.n.e().q(true);
            m0Var.f15297j.m(m0Var.y());
        }
    }

    public static /* synthetic */ x.d p(m0 m0Var, String str, String str2) {
        m9.a aVarE = m0Var.f15293f.e(str);
        if (aVarE == null) {
            m0Var.f15298k = true;
            aVarE = new m9.a();
            aVarE.p("");
        }
        if (str2 == null) {
            str2 = aVarE.d();
        }
        m9.a aVarE2 = !"".equals(str2) ? m0Var.f15293f.e(str2) : null;
        if (aVarE2 == null) {
            aVarE2 = m9.a.r();
        }
        return new x.d(aVarE, aVarE2);
    }

    public static /* synthetic */ Boolean q(m0 m0Var, String str) {
        m9.a aVarY = m0Var.y();
        aVarY.p(str);
        long jCurrentTimeMillis = System.currentTimeMillis() / 100;
        aVarY.q(jCurrentTimeMillis);
        if (com.tuyafeng.support.utils.p.f(aVarY.b())) {
            aVarY.o(m0Var.z().b());
            aVarY.m(UUID.randomUUID().toString());
            aVarY.l(jCurrentTimeMillis);
            if (m0Var.f15293f.q(aVarY)) {
                return Boolean.TRUE;
            }
            aVarY.m(null);
            return Boolean.FALSE;
        }
        m9.a aVarZ = m0Var.z();
        if (!aVarZ.b().equals(aVarY.b())) {
            do {
                aVarZ = m0Var.f15293f.e(aVarZ.d());
                if (aVarZ == null || !aVarY.b().equals(aVarZ.b())) {
                }
            } while (aVarZ != null);
            aVarY.o(m0Var.z().b());
        }
        return Boolean.valueOf(m0Var.f15293f.m(aVarY.b(), aVarY));
    }

    public void A(final String str) {
        if (SystemClock.elapsedRealtime() - this.f15299l < 300) {
            return;
        }
        this.f15299l = SystemClock.elapsedRealtime();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z7.e0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m0.q(this.f15242c, str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).b(new u6.f() { // from class: z7.f0
            @Override // u6.f
            public final void accept(Object obj) {
                m0.o(this.f15248c, (Boolean) obj);
            }
        });
    }

    public void B(m9.a aVar) {
        this.f15295h.m(aVar);
        w();
    }

    public void C(final String str) {
        ((autodispose2.m) r6.f.h(new Callable() { // from class: z7.k0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f15285c.f15293f.e(str);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.c(this))).a(new u6.f() { // from class: z7.l0
            @Override // u6.f
            public final void accept(Object obj) {
                this.f15290c.B((m9.a) obj);
            }
        }, new w7.e0());
    }

    public LiveData r() {
        return this.f15294g;
    }

    public LiveData s() {
        return this.f15296i;
    }

    public LiveData t() {
        return this.f15295h;
    }

    public LiveData u() {
        return this.f15297j;
    }

    public boolean v() {
        return this.f15298k;
    }

    public void w() {
        autodispose2.r rVar = (autodispose2.r) r6.q.f(new Callable() { // from class: z7.i0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                m0 m0Var = this.f15271c;
                return d.b(m0Var.f15293f.j(), m0Var.z().b());
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this));
        androidx.lifecycle.n nVar = this.f15296i;
        Objects.requireNonNull(nVar);
        rVar.a(new j0(nVar), new w7.e0());
    }

    public void x(final String str, final String str2) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z7.g0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m0.p(this.f15251c, str, str2);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: z7.h0
            @Override // u6.f
            public final void accept(Object obj) {
                m0.l(this.f15265c, (x.d) obj);
            }
        }, new w7.e0());
    }

    public m9.a y() {
        m9.a aVar = (m9.a) this.f15294g.e();
        if (aVar != null) {
            return aVar;
        }
        throw new NullPointerException("Editing folder cannot be null");
    }

    public m9.a z() {
        m9.a aVar = (m9.a) this.f15295h.e();
        if (aVar != null) {
            return aVar;
        }
        throw new NullPointerException("Parent folder cannot be null");
    }
}
