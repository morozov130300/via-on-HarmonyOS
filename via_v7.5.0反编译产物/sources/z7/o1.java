package z7;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o1 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w9.a f15307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m9.c f15308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.n f15309h = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f15310i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f15311j = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i8.n f15312k = new i8.n();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f15313l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f15314m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f15315n;

    public o1(w9.a aVar, m9.c cVar) {
        this.f15307f = aVar;
        this.f15308g = cVar;
    }

    public static /* synthetic */ x.d l(o1 o1Var, String str, String str2, String str3, String str4) {
        m9.b bVarA;
        o1Var.getClass();
        if (com.tuyafeng.support.utils.p.f(str)) {
            bVarA = com.tuyafeng.support.utils.p.f(str2) ? o1Var.f15308g.a(str2) : null;
        } else {
            bVarA = o1Var.f15308g.s(str);
        }
        m9.a aVarE = (bVarA == null || com.tuyafeng.support.utils.p.f(bVarA.b())) ? null : o1Var.f15308g.e(bVarA.b());
        if (aVarE == null && !com.tuyafeng.support.utils.p.f(str3)) {
            aVarE = o1Var.f15308g.e(str3);
        }
        if (aVarE == null) {
            aVarE = m9.a.r();
        }
        if (bVarA == null) {
            o1Var.f15313l = true;
            bVarA = new m9.b();
            bVarA.j(null);
            if (str2 == null) {
                str2 = "https://";
            }
            bVarA.n(str2);
            bVarA.l(str4);
        }
        return new x.d(bVarA, aVarE);
    }

    public static /* synthetic */ Boolean m(o1 o1Var, String str, String str2, boolean z10) {
        m9.b bVarA = o1Var.A();
        bVarA.l(str);
        bVarA.n(str2);
        bVarA.i(o1Var.z().b());
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        bVarA.m(jCurrentTimeMillis);
        if (z10) {
            o1Var.f15307f.s(new l9.b(str2, str));
            u9.n.e().u(true);
        }
        if (!com.tuyafeng.support.utils.p.f(bVarA.c())) {
            return Boolean.valueOf(o1Var.f15308g.k(bVarA.c(), bVarA));
        }
        bVarA.h(jCurrentTimeMillis);
        bVarA.j(UUID.randomUUID().toString());
        if (o1Var.f15308g.i(bVarA)) {
            return Boolean.TRUE;
        }
        bVarA.j(null);
        return Boolean.FALSE;
    }

    public static /* synthetic */ void n(o1 o1Var, Boolean bool) {
        o1Var.getClass();
        if (bool.booleanValue()) {
            o1Var.f15314m = false;
            o1Var.f15313l = false;
            o1Var.f15312k.m(o1Var.A());
            u9.n.e().q(true);
        }
    }

    public static /* synthetic */ void p(o1 o1Var, x.d dVar) {
        o1Var.f15309h.m((m9.b) dVar.f14455a);
        o1Var.f15310i.m((m9.a) dVar.f14456b);
        o1Var.x();
    }

    public m9.b A() {
        m9.b bVar = (m9.b) this.f15309h.e();
        if (bVar != null) {
            return bVar;
        }
        throw new NullPointerException("Bookmark item cannot be null");
    }

    public void B(final String str, final String str2, final boolean z10) {
        if (SystemClock.elapsedRealtime() - this.f15315n < 300) {
            return;
        }
        this.f15315n = SystemClock.elapsedRealtime();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z7.h1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o1.m(this.f15266c, str2, str, z10);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).b(new u6.f() { // from class: z7.i1
            @Override // u6.f
            public final void accept(Object obj) {
                o1.n(this.f15272c, (Boolean) obj);
            }
        });
    }

    public void C(m9.a aVar) {
        this.f15310i.m(aVar);
        x();
    }

    public void D(final String str) {
        ((autodispose2.m) r6.f.h(new Callable() { // from class: z7.m1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f15300c.f15308g.e(str);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.c(this))).a(new u6.f() { // from class: z7.n1
            @Override // u6.f
            public final void accept(Object obj) {
                this.f15304c.C((m9.a) obj);
            }
        }, new w7.e0());
    }

    public void E(boolean z10) {
        this.f15314m = z10;
    }

    public LiveData r() {
        return this.f15310i;
    }

    public LiveData s() {
        return this.f15311j;
    }

    public LiveData t() {
        return this.f15309h;
    }

    public LiveData u() {
        return this.f15312k;
    }

    public boolean v() {
        return this.f15313l;
    }

    public boolean w() {
        return this.f15314m;
    }

    public void x() {
        autodispose2.r rVar = (autodispose2.r) r6.q.f(new Callable() { // from class: z7.l1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                o1 o1Var = this.f15291c;
                return d.b(o1Var.f15308g.j(), o1Var.z().b());
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this));
        androidx.lifecycle.n nVar = this.f15311j;
        Objects.requireNonNull(nVar);
        rVar.a(new j0(nVar), new w7.e0());
    }

    public void y(final String str, final String str2, final String str3, final String str4) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z7.j1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o1.l(this.f15276c, str, str3, str4, str2);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).b(new u6.f() { // from class: z7.k1
            @Override // u6.f
            public final void accept(Object obj) {
                o1.p(this.f15287c, (x.d) obj);
            }
        });
    }

    public m9.a z() {
        m9.a aVar = (m9.a) this.f15310i.e();
        if (aVar != null) {
            return aVar;
        }
        throw new NullPointerException("Bookmark folder cannot be null");
    }
}
