package a8;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a0 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w9.a f108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m9.c f109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f111i;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f117o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public s6.b f118p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f121s;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f112j = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.lifecycle.n f113k = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.lifecycle.n f114l = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final androidx.lifecycle.n f115m = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c0 f116n = new c0();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final s6.d f119q = new s6.d();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f120r = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f122t = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i8.n f123u = new i8.n();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i8.n f124v = new i8.n();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i8.n f125w = new i8.n();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final i8.n f126x = new i8.n();

    public a0(w9.a aVar, m9.c cVar) {
        this.f108f = aVar;
        this.f109g = cVar;
    }

    public static /* synthetic */ void l(a0 a0Var, List list) {
        a0Var.f117o = true;
        a0Var.f116n.c(list);
        a0Var.f116n.a(a0Var.U());
        a0Var.P();
    }

    public static /* synthetic */ void m(a0 a0Var, List list) {
        a0Var.f122t = list;
        a0Var.P();
    }

    public static /* synthetic */ x.d o(a0 a0Var, String str, String str2, String str3) {
        m9.b bVarA;
        Bundle bundleC;
        if (str != null) {
            bVarA = a0Var.f109g.s(str);
        } else if (str2 != null) {
            bVarA = a0Var.f109g.a(str2);
        } else {
            a0Var.getClass();
            bVarA = null;
        }
        m9.a aVarE = (bVarA == null || com.tuyafeng.support.utils.p.f(bVarA.b())) ? null : a0Var.f109g.e(bVarA.b());
        if (aVarE == null && (bundleC = p5.b.d().c("editbookmarkcache")) != null) {
            String string = bundleC.getString(Name.MARK);
            if (!com.tuyafeng.support.utils.p.f(string)) {
                aVarE = a0Var.f109g.e(string);
            }
        }
        if (aVarE == null) {
            aVarE = m9.a.r();
        }
        if (bVarA == null) {
            bVarA = new m9.b();
            bVarA.j(null);
            if (str2 == null) {
                str2 = "https://";
            }
            bVarA.n(str2);
            bVarA.l(str3);
        }
        return new x.d(bVarA, aVarE);
    }

    public static /* synthetic */ s5.a q(a0 a0Var, m9.a aVar) {
        return a0Var.f109g.q(aVar) ? s5.a.f(aVar) : s5.a.a();
    }

    public static /* synthetic */ void r(a0 a0Var, Boolean bool) {
        a0Var.getClass();
        if (bool.booleanValue()) {
            u9.n.e().q(true);
            a0Var.f125w.o();
            a0Var.f123u.o();
        }
    }

    public static /* synthetic */ void t(a0 a0Var, x.d dVar) {
        a0Var.f113k.m((m9.b) dVar.f14455a);
        a0Var.f114l.m((m9.a) dVar.f14456b);
        a0Var.f116n.a(a0Var.U());
        a0Var.f120r = true;
        a0Var.P();
    }

    public static /* synthetic */ void u(a0 a0Var, s5.a aVar) {
        a0Var.getClass();
        if (aVar.d()) {
            u9.n.e().q(true);
            a0Var.f114l.m((m9.a) aVar.b());
            a0Var.f120r = true;
            a0Var.f117o = false;
            a0Var.N(true);
            a0Var.V(0);
        }
    }

    public static /* synthetic */ void v(a0 a0Var, Boolean bool) {
        a0Var.getClass();
        if (bool.booleanValue()) {
            u9.n.e().q(true);
            a0Var.f124v.o();
            a0Var.f123u.o();
        }
    }

    public static /* synthetic */ Boolean w(a0 a0Var, boolean z10, String str, String str2) {
        if (z10) {
            a0Var.f108f.s(new l9.b(str, str2));
            u9.n.e().u(true);
        }
        m9.b bVarR = a0Var.R();
        bVarR.l(str2);
        bVarR.n(str);
        bVarR.i(a0Var.Q().b());
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        bVarR.m(jCurrentTimeMillis);
        if (!com.tuyafeng.support.utils.p.f(bVarR.c())) {
            return Boolean.valueOf(a0Var.f109g.k(bVarR.c(), bVarR));
        }
        bVarR.h(jCurrentTimeMillis);
        bVarR.j(UUID.randomUUID().toString());
        if (a0Var.f109g.i(bVarR)) {
            p5.b.a().e("editbookmarkcache").f(180).d(Name.MARK, bVarR.b()).a();
            return Boolean.TRUE;
        }
        bVarR.j(null);
        return Boolean.FALSE;
    }

    public void A() {
        if (SystemClock.elapsedRealtime() - this.f111i < 300) {
            return;
        }
        this.f111i = SystemClock.elapsedRealtime();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: a8.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                a0 a0Var = this.f202c;
                return Boolean.valueOf(a0Var.f109g.r(a0Var.R().c()));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: a8.z
            @Override // u6.f
            public final void accept(Object obj) {
                a0.r(this.f203c, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public void B(final String str) {
        if (str == null) {
            str = "";
        }
        boolean z10 = this.f121s && str.isEmpty();
        this.f121s = !str.isEmpty();
        this.f119q.a(null);
        if (!str.isEmpty()) {
            this.f122t = Collections.EMPTY_LIST;
            P();
            this.f119q.a(((autodispose2.r) r6.q.f(new Callable() { // from class: a8.u
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f192c.f109g.w(str, "", 0);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: a8.v
                @Override // u6.f
                public final void accept(Object obj) {
                    a0.m(this.f196c, (List) obj);
                }
            }, new w7.e0()));
        } else {
            if (z10) {
                this.f120r = true;
            }
            if (this.f117o) {
                P();
            } else {
                M();
            }
        }
    }

    public LiveData C() {
        return this.f114l;
    }

    public LiveData D() {
        return this.f115m;
    }

    public LiveData E() {
        return this.f113k;
    }

    public LiveData F() {
        return this.f125w;
    }

    public LiveData G() {
        return this.f123u;
    }

    public LiveData H() {
        return this.f126x;
    }

    public LiveData I() {
        return this.f112j;
    }

    public int J() {
        return this.f110h;
    }

    public LiveData K() {
        return this.f124v;
    }

    public boolean L() {
        return this.f121s;
    }

    public final void M() {
        N(false);
    }

    public final void N(boolean z10) {
        s6.b bVar = this.f118p;
        if (bVar != null && !bVar.isDisposed()) {
            if (!z10) {
                return;
            } else {
                this.f118p.dispose();
            }
        }
        this.f118p = ((autodispose2.r) r6.q.f(new Callable() { // from class: a8.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return z7.d.b(this.f200c.f109g.j(), "");
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: a8.x
            @Override // u6.f
            public final void accept(Object obj) {
                a0.l(this.f201c, (List) obj);
            }
        }, new w7.e0());
    }

    public void O(final String str, final String str2, final String str3) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: a8.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a0.o(this.f162c, str, str2, str3);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).b(new u6.f() { // from class: a8.r
            @Override // u6.f
            public final void accept(Object obj) {
                a0.t(this.f175c, (x.d) obj);
            }
        });
    }

    public final void P() {
        if (this.f121s) {
            this.f115m.m(c0.b(this.f122t, U()));
        } else if (this.f117o) {
            this.f115m.m(this.f116n.e(U()));
        }
    }

    public m9.a Q() {
        m9.a aVar = (m9.a) this.f114l.e();
        if (aVar != null) {
            return aVar;
        }
        throw new NullPointerException("Bookmark folder cannot be null");
    }

    public m9.b R() {
        m9.b bVar = (m9.b) this.f113k.e();
        if (bVar != null) {
            return bVar;
        }
        throw new NullPointerException("Bookmark item cannot be null");
    }

    public void S(final String str, final String str2, final boolean z10) {
        if (SystemClock.elapsedRealtime() - this.f111i < 300) {
            return;
        }
        this.f111i = SystemClock.elapsedRealtime();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: a8.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a0.w(this.f167c, z10, str, str2);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).b(new u6.f() { // from class: a8.q
            @Override // u6.f
            public final void accept(Object obj) {
                a0.v(this.f172c, (Boolean) obj);
            }
        });
    }

    public void T(String str) {
        List<t0> list = (List) this.f115m.e();
        if (list == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        for (t0 t0Var : list) {
            if (str.equals(t0Var.a().b())) {
                this.f114l.m(t0Var.a());
                P();
                V(0);
                return;
            }
        }
    }

    public final String U() {
        m9.a aVar = (m9.a) this.f114l.e();
        return aVar == null ? "" : aVar.b();
    }

    public void V(int i10) {
        if (i10 == 1) {
            this.f116n.a(U());
            this.f120r = true;
            if (this.f117o) {
                P();
            } else {
                M();
            }
        } else if (this.f121s) {
            this.f121s = false;
            this.f119q.a(null);
        }
        this.f112j.m(Integer.valueOf(i10));
    }

    public void W(int i10) {
        this.f126x.m(Integer.valueOf(i10));
    }

    public void X(int i10) {
        this.f110h = i10;
    }

    public void Y(String str) {
        if (this.f121s || !this.f116n.d(str)) {
            return;
        }
        P();
    }

    public void x() {
        this.f123u.o();
    }

    public boolean y() {
        boolean z10 = this.f120r;
        this.f120r = false;
        return z10;
    }

    public void z(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        final m9.a aVarH = m9.a.h(str);
        aVarH.o(Q().b());
        ((autodispose2.r) r6.q.f(new Callable() { // from class: a8.s
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a0.q(this.f177c, aVarH);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: a8.t
            @Override // u6.f
            public final void accept(Object obj) {
                a0.u(this.f190c, (s5.a) obj);
            }
        }, new w7.e0());
    }
}
