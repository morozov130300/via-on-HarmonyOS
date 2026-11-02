package b8;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final y9.a f1908f;

    /* renamed from: g, reason: collision with root package name */
    public final o9.c f1909g;

    /* renamed from: h, reason: collision with root package name */
    public int f1910h;

    /* renamed from: i, reason: collision with root package name */
    public long f1911i;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f1912j = new androidx.lifecycle.l();

    /* renamed from: k, reason: collision with root package name */
    public final androidx.lifecycle.l f1913k = new androidx.lifecycle.l();

    /* renamed from: l, reason: collision with root package name */
    public final androidx.lifecycle.l f1914l = new androidx.lifecycle.l();

    /* renamed from: m, reason: collision with root package name */
    public final androidx.lifecycle.l f1915m = new androidx.lifecycle.l();

    /* renamed from: n, reason: collision with root package name */
    public final k8.n f1916n = new k8.n();

    /* renamed from: o, reason: collision with root package name */
    public final k8.n f1917o = new k8.n();

    /* renamed from: p, reason: collision with root package name */
    public final k8.n f1918p = new k8.n();

    /* renamed from: q, reason: collision with root package name */
    public final k8.n f1919q = new k8.n();

    public y(y9.a aVar, o9.c cVar) {
        this.f1908f = aVar;
        this.f1909g = cVar;
    }

    public static /* synthetic */ Boolean m(y yVar, boolean z10, String str, String str2) {
        if (z10) {
            yVar.f1908f.s(new n9.b(str, str2));
            w9.n.e().w(true);
        }
        o9.b bVarL = yVar.L();
        bVarL.l(str2);
        bVarL.n(str);
        bVarL.i(yVar.K().b());
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        bVarL.m(jCurrentTimeMillis);
        if (!g6.p.f(bVarL.c())) {
            return Boolean.valueOf(yVar.f1909g.b(bVarL.c(), bVarL));
        }
        bVarL.h(jCurrentTimeMillis);
        bVarL.j(UUID.randomUUID().toString());
        if (yVar.f1909g.o(bVarL)) {
            v5.b.a().e("editbookmarkcache").f(180).d(Name.MARK, bVarL.b()).a();
            return Boolean.TRUE;
        }
        bVarL.j(null);
        return Boolean.FALSE;
    }

    public static /* synthetic */ List n(y yVar) {
        String strB = yVar.f1914l.e() == null ? null : ((o9.a) yVar.f1914l.e()).b();
        if (strB == null) {
            strB = o9.a.r().b();
        }
        return a8.d.b(yVar.f1909g.k(), strB);
    }

    public static /* synthetic */ w.d o(y yVar, String str, String str2, String str3) {
        o9.b bVarA;
        Bundle bundleC;
        if (str != null) {
            bVarA = yVar.f1909g.r(str);
        } else if (str2 != null) {
            bVarA = yVar.f1909g.a(str2);
        } else {
            yVar.getClass();
            bVarA = null;
        }
        o9.a aVarF = (bVarA == null || g6.p.f(bVarA.b())) ? null : yVar.f1909g.f(bVarA.b());
        if (aVarF == null && (bundleC = v5.b.d().c("editbookmarkcache")) != null) {
            String string = bundleC.getString(Name.MARK);
            if (!g6.p.f(string)) {
                aVarF = yVar.f1909g.f(string);
            }
        }
        if (aVarF == null) {
            aVarF = o9.a.r();
        }
        if (bVarA == null) {
            bVarA = new o9.b();
            bVarA.j(null);
            if (str2 == null) {
                str2 = "https://";
            }
            bVarA.n(str2);
            bVarA.l(str3);
        }
        return new w.d(bVarA, aVarF);
    }

    public static /* synthetic */ void p(y yVar, x5.a aVar) {
        yVar.getClass();
        if (aVar.d()) {
            w9.n.e().s(true);
            yVar.f1914l.m((o9.a) aVar.b());
            yVar.I();
            yVar.O(0);
        }
    }

    public static /* synthetic */ x5.a q(y yVar, o9.a aVar) {
        return yVar.f1909g.g(aVar) ? x5.a.f(aVar) : x5.a.a();
    }

    public static /* synthetic */ void r(y yVar, Boolean bool) {
        yVar.getClass();
        if (bool.booleanValue()) {
            w9.n.e().s(true);
            yVar.f1918p.o();
            yVar.f1916n.o();
        }
    }

    public static /* synthetic */ void s(y yVar, w.d dVar) {
        yVar.f1913k.m((o9.b) dVar.f13207a);
        yVar.f1914l.m((o9.a) dVar.f13208b);
    }

    public static /* synthetic */ List t(y yVar, String str) {
        String strB = yVar.f1914l.e() == null ? null : ((o9.a) yVar.f1914l.e()).b();
        if (strB == null) {
            strB = o9.a.r().b();
        }
        List<o9.a> listW = yVar.f1909g.w(str, "", 0);
        ArrayList arrayList = new ArrayList();
        for (o9.a aVar : listW) {
            arrayList.add(new a8.a(aVar, 0, strB.equals(aVar.b())));
        }
        return arrayList;
    }

    public static /* synthetic */ void u(y yVar, Boolean bool) {
        yVar.getClass();
        if (bool.booleanValue()) {
            w9.n.e().s(true);
            yVar.f1917o.o();
            yVar.f1916n.o();
        }
    }

    public LiveData A() {
        return this.f1915m;
    }

    public LiveData B() {
        return this.f1913k;
    }

    public LiveData C() {
        return this.f1918p;
    }

    public LiveData D() {
        return this.f1916n;
    }

    public LiveData E() {
        return this.f1919q;
    }

    public LiveData F() {
        return this.f1912j;
    }

    public int G() {
        return this.f1910h;
    }

    public LiveData H() {
        return this.f1917o;
    }

    public final void I() {
        autodispose2.r rVar = (autodispose2.r) x6.o.g(new Callable() { // from class: b8.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return y.n(this.f1907e);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this));
        androidx.lifecycle.l lVar = this.f1915m;
        Objects.requireNonNull(lVar);
        rVar.a(new a8.j0(lVar), new x7.g0());
    }

    public void J(final String str, final String str2, final String str3) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b8.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return y.o(this.f1890e, str, str2, str3);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).b(new a7.e() { // from class: b8.p
            @Override // a7.e
            public final void accept(Object obj) {
                y.s(this.f1894e, (w.d) obj);
            }
        });
    }

    public o9.a K() {
        o9.a aVar = (o9.a) this.f1914l.e();
        if (aVar != null) {
            return aVar;
        }
        throw new NullPointerException("Bookmark folder cannot be null");
    }

    public o9.b L() {
        o9.b bVar = (o9.b) this.f1913k.e();
        if (bVar != null) {
            return bVar;
        }
        throw new NullPointerException("Bookmark item cannot be null");
    }

    public void M(final String str, final String str2, final boolean z10) {
        if (SystemClock.elapsedRealtime() - this.f1911i < 300) {
            return;
        }
        this.f1911i = SystemClock.elapsedRealtime();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b8.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return y.m(this.f1902e, z10, str, str2);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).b(new a7.e() { // from class: b8.w
            @Override // a7.e
            public final void accept(Object obj) {
                y.u(this.f1906e, (Boolean) obj);
            }
        });
    }

    public void N(String str) {
        List<a8.a> list = (List) this.f1915m.e();
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            str = "";
        }
        o9.a aVarA = null;
        for (a8.a aVar : list) {
            if (str.equals(aVar.a().b())) {
                arrayList.add(new a8.a(aVar, true));
                aVarA = aVar.a();
            } else {
                arrayList.add(new a8.a(aVar, false));
            }
        }
        if (aVarA != null) {
            this.f1914l.m(aVarA);
        }
        this.f1915m.m(arrayList);
        O(0);
    }

    public void O(int i10) {
        this.f1912j.m(Integer.valueOf(i10));
    }

    public void P(int i10) {
        this.f1919q.m(Integer.valueOf(i10));
    }

    public void Q(int i10) {
        this.f1910h = i10;
    }

    public void v() {
        this.f1916n.o();
    }

    public void w(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        final o9.a aVarH = o9.a.h(str);
        aVarH.o(K().b());
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b8.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return y.q(this.f1895e, aVarH);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: b8.r
            @Override // a7.e
            public final void accept(Object obj) {
                y.p(this.f1897e, (x5.a) obj);
            }
        }, new x7.g0());
    }

    public void x() {
        if (SystemClock.elapsedRealtime() - this.f1911i < 300) {
            return;
        }
        this.f1911i = SystemClock.elapsedRealtime();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b8.t
            @Override // java.util.concurrent.Callable
            public final Object call() {
                y yVar = this.f1900e;
                return Boolean.valueOf(yVar.f1909g.q(yVar.L().c()));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: b8.u
            @Override // a7.e
            public final void accept(Object obj) {
                y.r(this.f1901e, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public void y(final String str) {
        if (str == null || str.isEmpty()) {
            I();
            return;
        }
        autodispose2.r rVar = (autodispose2.r) x6.o.g(new Callable() { // from class: b8.s
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return y.t(this.f1898e, str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this));
        androidx.lifecycle.l lVar = this.f1915m;
        Objects.requireNonNull(lVar);
        rVar.a(new a8.j0(lVar), new x7.g0());
    }

    public LiveData z() {
        return this.f1914l;
    }
}
