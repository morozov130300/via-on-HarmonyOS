package a8;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o1 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final y9.a f236f;

    /* renamed from: g, reason: collision with root package name */
    public final o9.c f237g;

    /* renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.l f238h = new androidx.lifecycle.l();

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f239i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f240j = new androidx.lifecycle.l();

    /* renamed from: k, reason: collision with root package name */
    public final k8.n f241k = new k8.n();

    /* renamed from: l, reason: collision with root package name */
    public boolean f242l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f243m = false;

    /* renamed from: n, reason: collision with root package name */
    public long f244n;

    public o1(y9.a aVar, o9.c cVar) {
        this.f236f = aVar;
        this.f237g = cVar;
    }

    public static /* synthetic */ w.d l(o1 o1Var, String str, String str2, String str3, String str4) {
        o1Var.getClass();
        o9.b bVarR = !g6.p.f(str) ? o1Var.f237g.r(str) : g6.p.f(str2) ? o1Var.f237g.a(str2) : null;
        o9.a aVarF = (bVarR == null || g6.p.f(bVarR.b())) ? null : o1Var.f237g.f(bVarR.b());
        if (aVarF == null && !g6.p.f(str3)) {
            aVarF = o1Var.f237g.f(str3);
        }
        if (aVarF == null) {
            aVarF = o9.a.r();
        }
        if (bVarR == null) {
            o1Var.f242l = true;
            bVarR = new o9.b();
            bVarR.j(null);
            if (str2 == null) {
                str2 = "https://";
            }
            bVarR.n(str2);
            bVarR.l(str4);
        }
        return new w.d(bVarR, aVarF);
    }

    public static /* synthetic */ Boolean m(o1 o1Var, String str, String str2, boolean z10) {
        o9.b bVarA = o1Var.A();
        bVarA.l(str);
        bVarA.n(str2);
        bVarA.i(o1Var.z().b());
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        bVarA.m(jCurrentTimeMillis);
        if (z10) {
            o1Var.f236f.s(new n9.b(str2, str));
            w9.n.e().w(true);
        }
        if (!g6.p.f(bVarA.c())) {
            return Boolean.valueOf(o1Var.f237g.b(bVarA.c(), bVarA));
        }
        bVarA.h(jCurrentTimeMillis);
        bVarA.j(UUID.randomUUID().toString());
        if (o1Var.f237g.o(bVarA)) {
            return Boolean.TRUE;
        }
        bVarA.j(null);
        return Boolean.FALSE;
    }

    public static /* synthetic */ void n(o1 o1Var, Boolean bool) {
        o1Var.getClass();
        if (bool.booleanValue()) {
            o1Var.f243m = false;
            o1Var.f242l = false;
            o1Var.f241k.m(o1Var.A());
            w9.n.e().s(true);
        }
    }

    public static /* synthetic */ void p(o1 o1Var, w.d dVar) {
        o1Var.f238h.m((o9.b) dVar.f13207a);
        o1Var.f239i.m((o9.a) dVar.f13208b);
        o1Var.x();
    }

    public o9.b A() {
        o9.b bVar = (o9.b) this.f238h.e();
        if (bVar != null) {
            return bVar;
        }
        throw new NullPointerException("Bookmark item cannot be null");
    }

    public void B(final String str, final String str2, final boolean z10) {
        if (SystemClock.elapsedRealtime() - this.f244n < 300) {
            return;
        }
        this.f244n = SystemClock.elapsedRealtime();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: a8.h1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o1.m(this.f196e, str2, str, z10);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).b(new a7.e() { // from class: a8.i1
            @Override // a7.e
            public final void accept(Object obj) {
                o1.n(this.f202e, (Boolean) obj);
            }
        });
    }

    public void C(o9.a aVar) {
        this.f239i.m(aVar);
        x();
    }

    public void D(final String str) {
        ((autodispose2.m) x6.f.h(new Callable() { // from class: a8.m1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f229e.f237g.f(str);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.c(this))).a(new a7.e() { // from class: a8.n1
            @Override // a7.e
            public final void accept(Object obj) {
                this.f233e.C((o9.a) obj);
            }
        }, new x7.g0());
    }

    public void E(boolean z10) {
        this.f243m = z10;
    }

    public LiveData r() {
        return this.f239i;
    }

    public LiveData s() {
        return this.f240j;
    }

    public LiveData t() {
        return this.f238h;
    }

    public LiveData u() {
        return this.f241k;
    }

    public boolean v() {
        return this.f242l;
    }

    public boolean w() {
        return this.f243m;
    }

    public void x() {
        autodispose2.r rVar = (autodispose2.r) x6.o.g(new Callable() { // from class: a8.l1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                o1 o1Var = this.f220e;
                return d.b(o1Var.f237g.k(), o1Var.z().b());
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this));
        androidx.lifecycle.l lVar = this.f240j;
        Objects.requireNonNull(lVar);
        rVar.a(new j0(lVar), new x7.g0());
    }

    public void y(final String str, final String str2, final String str3, final String str4) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: a8.j1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o1.l(this.f206e, str, str3, str4, str2);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).b(new a7.e() { // from class: a8.k1
            @Override // a7.e
            public final void accept(Object obj) {
                o1.p(this.f216e, (w.d) obj);
            }
        });
    }

    public o9.a z() {
        o9.a aVar = (o9.a) this.f239i.e();
        if (aVar != null) {
            return aVar;
        }
        throw new NullPointerException("Bookmark folder cannot be null");
    }
}
