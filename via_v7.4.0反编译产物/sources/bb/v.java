package bb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;
import x7.c0;
import x7.g0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final y9.a f2143f;

    /* renamed from: g, reason: collision with root package name */
    public final List f2144g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final k8.n f2145h;

    /* renamed from: i, reason: collision with root package name */
    public LiveData f2146i;

    /* renamed from: j, reason: collision with root package name */
    public final k8.n f2147j;

    /* renamed from: k, reason: collision with root package name */
    public LiveData f2148k;

    /* renamed from: l, reason: collision with root package name */
    public final k8.n f2149l;

    /* renamed from: m, reason: collision with root package name */
    public LiveData f2150m;

    /* renamed from: n, reason: collision with root package name */
    public final k8.n f2151n;

    /* renamed from: o, reason: collision with root package name */
    public LiveData f2152o;

    /* renamed from: p, reason: collision with root package name */
    public final k8.n f2153p;

    /* renamed from: q, reason: collision with root package name */
    public LiveData f2154q;

    /* renamed from: r, reason: collision with root package name */
    public final androidx.lifecycle.l f2155r;

    /* renamed from: s, reason: collision with root package name */
    public LiveData f2156s;

    /* renamed from: t, reason: collision with root package name */
    public final androidx.lifecycle.l f2157t;

    /* renamed from: u, reason: collision with root package name */
    public LiveData f2158u;

    /* renamed from: v, reason: collision with root package name */
    public int f2159v;

    /* renamed from: w, reason: collision with root package name */
    public final androidx.lifecycle.l f2160w;

    /* renamed from: x, reason: collision with root package name */
    public LiveData f2161x;

    public v(y9.a aVar, o9.c cVar, w9.l lVar) {
        k8.n nVar = new k8.n();
        this.f2145h = nVar;
        this.f2146i = nVar;
        k8.n nVar2 = new k8.n();
        this.f2147j = nVar2;
        this.f2148k = nVar2;
        k8.n nVar3 = new k8.n();
        this.f2149l = nVar3;
        this.f2150m = nVar3;
        k8.n nVar4 = new k8.n();
        this.f2151n = nVar4;
        this.f2152o = nVar4;
        k8.n nVar5 = new k8.n();
        this.f2153p = nVar5;
        this.f2154q = nVar5;
        androidx.lifecycle.l lVar2 = new androidx.lifecycle.l();
        this.f2155r = lVar2;
        this.f2156s = lVar2;
        androidx.lifecycle.l lVar3 = new androidx.lifecycle.l();
        this.f2157t = lVar3;
        this.f2158u = lVar3;
        this.f2159v = 0;
        androidx.lifecycle.l lVar4 = new androidx.lifecycle.l();
        this.f2160w = lVar4;
        this.f2161x = lVar4;
        this.f2143f = aVar;
    }

    public static /* synthetic */ void n(v vVar, int i10, List list) {
        vVar.getClass();
        if (list.isEmpty()) {
            if (vVar.f2157t.e() == null) {
                vVar.f2157t.m(new ArrayList());
            }
            vVar.f2160w.m(Boolean.FALSE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (vVar.f2157t.e() != null) {
            arrayList.addAll((Collection) vVar.f2157t.e());
        }
        arrayList.addAll(list);
        vVar.f2159v = arrayList.size();
        vVar.f2157t.m(arrayList);
        vVar.f2160w.m(Boolean.valueOf(list.size() >= i10));
    }

    public static /* synthetic */ Boolean o(v vVar, int[] iArr) {
        vVar.f2143f.g(iArr);
        return Boolean.TRUE;
    }

    public static /* synthetic */ void p(v vVar, List list) {
        vVar.f2160w.m(Boolean.FALSE);
        vVar.f2157t.m(list);
    }

    public static /* synthetic */ void q(v vVar, Boolean bool) {
        vVar.f2159v = 0;
        vVar.f2157t.m(new ArrayList());
        vVar.f2160w.m(Boolean.FALSE);
        vVar.E();
    }

    public static /* synthetic */ void s(v vVar, Integer num) {
        vVar.f2159v = 0;
        vVar.f2157t.m(new ArrayList());
        vVar.f2160w.m(Boolean.FALSE);
        vVar.E();
    }

    public static /* synthetic */ List t(List list) {
        long rawOffset = Calendar.getInstance().getTimeZone().getRawOffset() / 1000;
        long jCurrentTimeMillis = ((((System.currentTimeMillis() / 1000) + rawOffset) / 86400) * 86400) - rawOffset;
        int[] iArr = new int[5];
        iArr[0] = ((Integer) ((w.d) list.get(0)).f13208b).intValue();
        long[] jArr = {((Long) ((w.d) list.get(0)).f13207a).longValue(), jCurrentTimeMillis, jCurrentTimeMillis - 86400, jCurrentTimeMillis - 518400, 0};
        int size = list.size();
        for (int i10 = 1; i10 < size; i10++) {
            for (int i11 = 1; i11 < 5; i11++) {
                if (((Long) ((w.d) list.get(i10)).f13207a).longValue() >= jArr[i11]) {
                    iArr[i11] = iArr[i11] + ((Integer) ((w.d) list.get(i10)).f13208b).intValue();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < 5; i12++) {
            arrayList.add(new w.d(Long.valueOf(jArr[i12]), Integer.valueOf(iArr[i12])));
        }
        return arrayList;
    }

    public void A(final long j10) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: bb.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(this.f2127e.f2143f.m(j10));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: bb.l
            @Override // a7.e
            public final void accept(Object obj) {
                v.s(this.f2129e, (Integer) obj);
            }
        }, new c0());
    }

    public final void B(final int i10) {
        z8.h.b(new Runnable() { // from class: bb.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f2135e.f2143f.p(i10);
            }
        });
    }

    public String C(int i10) {
        List list = (List) this.f2157t.e();
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return ((n9.b) list.get(i10)).g();
    }

    public List D() {
        return this.f2144g;
    }

    public void E() {
        F(120);
    }

    public void F(final int i10) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: bb.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                v vVar = this.f2131e;
                return vVar.f2143f.q(vVar.f2159v, i10);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: bb.o
            @Override // a7.e
            public final void accept(Object obj) {
                v.n(this.f2133e, i10, (List) obj);
            }
        }, new c0());
    }

    public void G(int i10, int i11) {
        List list = (List) this.f2157t.e();
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return;
        }
        H(((n9.b) list.get(i10)).g(), i11);
    }

    public void H(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        w(str, i10);
        if (i10 != 2) {
            this.f2147j.o();
        } else {
            this.f2149l.o();
        }
    }

    public void I(List list) {
        Iterator it = list.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            l8.a aVar = (l8.a) it.next();
            if (!z10 && (aVar.b() == 1 || aVar.b() == 0)) {
                z10 = true;
            }
            w(aVar.a(), aVar.b());
        }
        if (z10) {
            this.f2147j.o();
        } else {
            this.f2149l.o();
        }
    }

    public boolean J(int[] iArr, boolean z10) {
        List list = this.f2157t.e() == null ? null : (List) this.f2157t.e();
        if (list == null || iArr == null || iArr.length == 0 || iArr.length > list.size()) {
            return false;
        }
        this.f2159v -= iArr.length;
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = ((n9.b) list.remove(iArr[i10])).c();
        }
        boolean z11 = !z10 && list.isEmpty();
        z(iArr2, z11);
        if (z11 || !list.isEmpty()) {
            return true ^ z11;
        }
        this.f2157t.m(new ArrayList());
        return false;
    }

    public n9.b K(int i10) {
        List list = (List) this.f2157t.e();
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        this.f2159v--;
        n9.b bVar = (n9.b) list.remove(i10);
        B(bVar.c());
        if (!list.isEmpty()) {
            return bVar;
        }
        this.f2157t.m(list);
        return null;
    }

    public void L(final String str) {
        if (str != null && !str.isEmpty()) {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: bb.j
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f2125e.f2143f.l(str, 1024);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: bb.m
                @Override // a7.e
                public final void accept(Object obj) {
                    v.p(this.f2130e, (List) obj);
                }
            }, new c0());
            return;
        }
        this.f2159v = 0;
        this.f2157t.m(new ArrayList());
        E();
    }

    public void M(boolean z10) {
        this.f2155r.m(Boolean.valueOf(z10));
    }

    public void N() {
        this.f2153p.o();
    }

    public final void w(String str, int i10) {
        l8.a aVar = new l8.a(str, i10);
        int iIndexOf = this.f2144g.indexOf(aVar);
        if (iIndexOf >= 0) {
            ((l8.a) this.f2144g.get(iIndexOf)).c(i10);
        } else {
            this.f2144g.add(aVar);
        }
    }

    public boolean x(n9.b bVar) {
        w9.n.e().w(true);
        return this.f2143f.s(bVar) > 0;
    }

    public x6.o y() {
        final y9.a aVar = this.f2143f;
        Objects.requireNonNull(aVar);
        return x6.o.g(new Callable() { // from class: bb.t
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.i();
            }
        }).i(new a7.f() { // from class: bb.u
            @Override // a7.f
            public final Object apply(Object obj) {
                return v.t((List) obj);
            }
        }).l(g7.a.c()).j(w6.b.b());
    }

    public final void z(final int[] iArr, boolean z10) {
        if (!z10) {
            z8.h.b(new Runnable() { // from class: bb.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2137e.f2143f.g(iArr);
                }
            });
        } else {
            this.f2160w.m(Boolean.FALSE);
            ((autodispose2.r) x6.o.g(new Callable() { // from class: bb.r
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return v.o(this.f2139e, iArr);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: bb.s
                @Override // a7.e
                public final void accept(Object obj) {
                    v.q(this.f2141e, (Boolean) obj);
                }
            }, new g0());
        }
    }
}
