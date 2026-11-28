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
import w7.a0;
import w7.e0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class x extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w9.a f1879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f1880g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i8.n f1881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LiveData f1882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i8.n f1883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveData f1884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i8.n f1885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LiveData f1886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final i8.n f1887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LiveData f1888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final i8.n f1889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LiveData f1890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.lifecycle.n f1891r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LiveData f1892s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final androidx.lifecycle.n f1893t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LiveData f1894u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1895v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f1896w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final androidx.lifecycle.n f1897x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LiveData f1898y;

    public x(w9.a aVar, m9.c cVar, u9.l lVar) {
        i8.n nVar = new i8.n();
        this.f1881h = nVar;
        this.f1882i = nVar;
        i8.n nVar2 = new i8.n();
        this.f1883j = nVar2;
        this.f1884k = nVar2;
        i8.n nVar3 = new i8.n();
        this.f1885l = nVar3;
        this.f1886m = nVar3;
        i8.n nVar4 = new i8.n();
        this.f1887n = nVar4;
        this.f1888o = nVar4;
        i8.n nVar5 = new i8.n();
        this.f1889p = nVar5;
        this.f1890q = nVar5;
        androidx.lifecycle.n nVar6 = new androidx.lifecycle.n();
        this.f1891r = nVar6;
        this.f1892s = nVar6;
        androidx.lifecycle.n nVar7 = new androidx.lifecycle.n();
        this.f1893t = nVar7;
        this.f1894u = nVar7;
        this.f1895v = 0;
        androidx.lifecycle.n nVar8 = new androidx.lifecycle.n();
        this.f1897x = nVar8;
        this.f1898y = nVar8;
        this.f1879f = aVar;
    }

    public static /* synthetic */ void n(x xVar, int i10, int i11, List list) {
        xVar.getClass();
        if (list.isEmpty()) {
            if (i10 == 0 || xVar.f1893t.e() == null) {
                xVar.f1893t.m(new ArrayList());
            }
            xVar.f1897x.m(Boolean.FALSE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (i10 > 0 && xVar.f1893t.e() != null) {
            arrayList.addAll((Collection) xVar.f1893t.e());
        }
        arrayList.addAll(list);
        xVar.f1895v = arrayList.size();
        xVar.f1893t.m(arrayList);
        xVar.f1897x.m(Boolean.valueOf(list.size() >= i11));
    }

    public static /* synthetic */ boolean o(x xVar, long j10, List list) {
        return j10 == xVar.f1896w;
    }

    public static /* synthetic */ void p(x xVar, Boolean bool) {
        xVar.f1895v = 0;
        xVar.f1893t.m(new ArrayList());
        xVar.f1897x.m(Boolean.FALSE);
        xVar.H();
    }

    public static /* synthetic */ Boolean r(x xVar, int[] iArr) {
        xVar.f1879f.g(iArr);
        return Boolean.TRUE;
    }

    public static /* synthetic */ boolean t(x xVar, long j10, List list) {
        return j10 == xVar.f1896w;
    }

    public static /* synthetic */ void v(x xVar, List list) {
        xVar.f1897x.m(Boolean.FALSE);
        xVar.f1893t.m(list);
    }

    public static /* synthetic */ List w(List list) {
        long rawOffset = Calendar.getInstance().getTimeZone().getRawOffset() / 1000;
        long jCurrentTimeMillis = ((((System.currentTimeMillis() / 1000) + rawOffset) / 86400) * 86400) - rawOffset;
        int[] iArr = new int[5];
        iArr[0] = ((Integer) ((x.d) list.get(0)).f14456b).intValue();
        long[] jArr = {((Long) ((x.d) list.get(0)).f14455a).longValue(), jCurrentTimeMillis, jCurrentTimeMillis - 86400, jCurrentTimeMillis - 518400, 0};
        int size = list.size();
        for (int i10 = 1; i10 < size; i10++) {
            for (int i11 = 1; i11 < 5; i11++) {
                if (((Long) ((x.d) list.get(i10)).f14455a).longValue() >= jArr[i11]) {
                    iArr[i11] = iArr[i11] + ((Integer) ((x.d) list.get(i10)).f14456b).intValue();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < 5; i12++) {
            arrayList.add(new x.d(Long.valueOf(jArr[i12]), Integer.valueOf(iArr[i12])));
        }
        return arrayList;
    }

    public static /* synthetic */ void x(x xVar, Integer num) {
        xVar.f1895v = 0;
        xVar.f1893t.m(new ArrayList());
        xVar.f1897x.m(Boolean.FALSE);
        xVar.H();
    }

    public r6.q A() {
        final w9.a aVar = this.f1879f;
        Objects.requireNonNull(aVar);
        return r6.q.f(new Callable() { // from class: bb.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.i();
            }
        }).h(new u6.g() { // from class: bb.l
            @Override // u6.g
            public final Object apply(Object obj) {
                return x.w((List) obj);
            }
        }).k(a7.a.c()).i(q6.b.b());
    }

    public final void B(final int[] iArr, boolean z10) {
        if (!z10) {
            x8.h.b(new Runnable() { // from class: bb.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1874c.f1879f.g(iArr);
                }
            });
        } else {
            this.f1897x.m(Boolean.FALSE);
            ((autodispose2.r) r6.q.f(new Callable() { // from class: bb.v
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return x.r(this.f1876c, iArr);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: bb.w
                @Override // u6.f
                public final void accept(Object obj) {
                    x.p(this.f1878c, (Boolean) obj);
                }
            }, new e0());
        }
    }

    public void C(final long j10) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: bb.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(this.f1858c.f1879f.m(j10));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: bb.n
            @Override // u6.f
            public final void accept(Object obj) {
                x.x(this.f1860c, (Integer) obj);
            }
        }, new a0());
    }

    public final void D(final int i10) {
        x8.h.b(new Runnable() { // from class: bb.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f1872c.f1879f.p(i10);
            }
        });
    }

    public String E(int i10) {
        List list = (List) this.f1893t.e();
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return ((l9.b) list.get(i10)).g();
    }

    public List F() {
        return this.f1880g;
    }

    public void G() {
        this.f1896w++;
        this.f1897x.m(Boolean.FALSE);
    }

    public void H() {
        I(120);
    }

    public void I(final int i10) {
        final long j10 = this.f1896w + 1;
        this.f1896w = j10;
        final int i11 = this.f1895v;
        ((autodispose2.m) r6.q.f(new Callable() { // from class: bb.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1864c.f1879f.q(i11, i10);
            }
        }).k(a7.a.c()).i(q6.b.b()).d(new u6.i() { // from class: bb.r
            @Override // u6.i
            public final boolean test(Object obj) {
                return x.t(this.f1867c, j10, (List) obj);
            }
        }).p(s8.b.c(this))).a(new u6.f() { // from class: bb.s
            @Override // u6.f
            public final void accept(Object obj) {
                x.n(this.f1869c, i11, i10, (List) obj);
            }
        }, new a0());
    }

    public void J(int i10, int i11) {
        List list = (List) this.f1893t.e();
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return;
        }
        K(((l9.b) list.get(i10)).g(), i11);
    }

    public void K(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        y(str, i10);
        if (i10 != 2) {
            this.f1883j.o();
        } else {
            this.f1885l.o();
        }
    }

    public void L(List list) {
        Iterator it = list.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            j8.a aVar = (j8.a) it.next();
            if (!z10 && (aVar.b() == 1 || aVar.b() == 0)) {
                z10 = true;
            }
            y(aVar.a(), aVar.b());
        }
        if (z10) {
            this.f1883j.o();
        } else {
            this.f1885l.o();
        }
    }

    public boolean M(int[] iArr, boolean z10) {
        List list = this.f1893t.e() == null ? null : (List) this.f1893t.e();
        if (list == null || iArr == null || iArr.length == 0 || iArr.length > list.size()) {
            return false;
        }
        this.f1895v -= iArr.length;
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = ((l9.b) list.remove(iArr[i10])).c();
        }
        boolean z11 = !z10 && list.isEmpty();
        B(iArr2, z11);
        if (z11 || !list.isEmpty()) {
            return true ^ z11;
        }
        this.f1893t.m(new ArrayList());
        return false;
    }

    public l9.b N(int i10) {
        List list = (List) this.f1893t.e();
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        this.f1895v--;
        l9.b bVar = (l9.b) list.remove(i10);
        D(bVar.c());
        if (!list.isEmpty()) {
            return bVar;
        }
        this.f1893t.m(list);
        return null;
    }

    public void O(final String str) {
        if (str == null || str.isEmpty()) {
            this.f1895v = 0;
            H();
        } else {
            final long j10 = this.f1896w + 1;
            this.f1896w = j10;
            ((autodispose2.m) r6.q.f(new Callable() { // from class: bb.j
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f1855c.f1879f.l(str, 1024);
                }
            }).k(a7.a.c()).i(q6.b.b()).d(new u6.i() { // from class: bb.o
                @Override // u6.i
                public final boolean test(Object obj) {
                    return x.o(this.f1861c, j10, (List) obj);
                }
            }).p(s8.b.c(this))).a(new u6.f() { // from class: bb.p
                @Override // u6.f
                public final void accept(Object obj) {
                    x.v(this.f1863c, (List) obj);
                }
            }, new a0());
        }
    }

    public void P(boolean z10) {
        this.f1891r.m(Boolean.valueOf(z10));
    }

    public void Q() {
        this.f1889p.o();
    }

    public final void y(String str, int i10) {
        j8.a aVar = new j8.a(str, i10);
        int iIndexOf = this.f1880g.indexOf(aVar);
        if (iIndexOf >= 0) {
            ((j8.a) this.f1880g.get(iIndexOf)).c(i10);
        } else {
            this.f1880g.add(aVar);
        }
    }

    public boolean z(l9.b bVar) {
        u9.n.e().u(true);
        return this.f1879f.s(bVar) > 0;
    }
}
