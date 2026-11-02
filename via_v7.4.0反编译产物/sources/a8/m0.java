package a8;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m0 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final o9.c f222f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.l f223g = new androidx.lifecycle.l();

    /* renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.l f224h = new androidx.lifecycle.l();

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f225i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final k8.n f226j = new k8.n();

    /* renamed from: k, reason: collision with root package name */
    public boolean f227k = false;

    /* renamed from: l, reason: collision with root package name */
    public long f228l;

    public m0(o9.c cVar) {
        this.f222f = cVar;
    }

    public static /* synthetic */ void l(m0 m0Var, w.d dVar) {
        m0Var.f223g.m((o9.a) dVar.f13207a);
        m0Var.f224h.m((o9.a) dVar.f13208b);
        m0Var.w();
    }

    public static /* synthetic */ void o(m0 m0Var, Boolean bool) {
        m0Var.getClass();
        if (bool.booleanValue()) {
            m0Var.f227k = false;
            w9.n.e().s(true);
            m0Var.f226j.m(m0Var.y());
        }
    }

    public static /* synthetic */ w.d p(m0 m0Var, String str, String str2) {
        o9.a aVarF = m0Var.f222f.f(str);
        if (aVarF == null) {
            m0Var.f227k = true;
            aVarF = new o9.a();
            aVarF.p("");
        }
        if (str2 == null) {
            str2 = aVarF.d();
        }
        o9.a aVarF2 = !"".equals(str2) ? m0Var.f222f.f(str2) : null;
        if (aVarF2 == null) {
            aVarF2 = o9.a.r();
        }
        return new w.d(aVarF, aVarF2);
    }

    public static /* synthetic */ Boolean q(m0 m0Var, String str) {
        o9.a aVarY = m0Var.y();
        aVarY.p(str);
        long jCurrentTimeMillis = System.currentTimeMillis() / 100;
        aVarY.q(jCurrentTimeMillis);
        if (g6.p.f(aVarY.b())) {
            aVarY.o(m0Var.z().b());
            aVarY.m(UUID.randomUUID().toString());
            aVarY.l(jCurrentTimeMillis);
            if (m0Var.f222f.g(aVarY)) {
                return Boolean.TRUE;
            }
            aVarY.m(null);
            return Boolean.FALSE;
        }
        o9.a aVarZ = m0Var.z();
        if (!aVarZ.b().equals(aVarY.b())) {
            while (true) {
                aVarZ = m0Var.f222f.f(aVarZ.d());
                if (aVarZ != null && aVarY.b().equals(aVarZ.b())) {
                    break;
                }
                if (aVarZ == null) {
                    aVarY.o(m0Var.z().b());
                    break;
                }
            }
        }
        return Boolean.valueOf(m0Var.f222f.t(aVarY.b(), aVarY));
    }

    public void A(final String str) {
        if (SystemClock.elapsedRealtime() - this.f228l < 300) {
            return;
        }
        this.f228l = SystemClock.elapsedRealtime();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: a8.e0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m0.q(this.f170e, str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).b(new a7.e() { // from class: a8.f0
            @Override // a7.e
            public final void accept(Object obj) {
                m0.o(this.f176e, (Boolean) obj);
            }
        });
    }

    public void B(o9.a aVar) {
        this.f224h.m(aVar);
        w();
    }

    public void C(final String str) {
        ((autodispose2.m) x6.f.h(new Callable() { // from class: a8.k0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f214e.f222f.f(str);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.c(this))).a(new a7.e() { // from class: a8.l0
            @Override // a7.e
            public final void accept(Object obj) {
                this.f219e.B((o9.a) obj);
            }
        }, new x7.g0());
    }

    public LiveData r() {
        return this.f223g;
    }

    public LiveData s() {
        return this.f225i;
    }

    public LiveData t() {
        return this.f224h;
    }

    public LiveData u() {
        return this.f226j;
    }

    public boolean v() {
        return this.f227k;
    }

    public void w() {
        autodispose2.r rVar = (autodispose2.r) x6.o.g(new Callable() { // from class: a8.i0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                m0 m0Var = this.f201e;
                return d.b(m0Var.f222f.k(), m0Var.z().b());
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this));
        androidx.lifecycle.l lVar = this.f225i;
        Objects.requireNonNull(lVar);
        rVar.a(new j0(lVar), new x7.g0());
    }

    public void x(final String str, final String str2) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: a8.g0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m0.p(this.f179e, str, str2);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: a8.h0
            @Override // a7.e
            public final void accept(Object obj) {
                m0.l(this.f195e, (w.d) obj);
            }
        }, new x7.g0());
    }

    public o9.a y() {
        o9.a aVar = (o9.a) this.f223g.e();
        if (aVar != null) {
            return aVar;
        }
        throw new NullPointerException("Editing folder cannot be null");
    }

    public o9.a z() {
        o9.a aVar = (o9.a) this.f224h.e();
        if (aVar != null) {
            return aVar;
        }
        throw new NullPointerException("Parent folder cannot be null");
    }
}
