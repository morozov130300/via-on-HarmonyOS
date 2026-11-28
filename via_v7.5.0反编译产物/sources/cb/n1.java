package cb;

import androidx.lifecycle.LiveData;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n1 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m9.c f2447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f2448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.n f2449h = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f2450i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f2451j = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f2452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i8.n f2453l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i8.n f2454m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2455n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f2456o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f2457p;

    public n1(m9.c cVar, u9.l lVar) {
        b bVarC = b.c(0);
        this.f2452k = bVarC;
        this.f2453l = new i8.n();
        this.f2454m = new i8.n();
        this.f2457p = null;
        this.f2447f = cVar;
        this.f2448g = lVar;
        bVarC.d(lVar.X0());
    }

    public static /* synthetic */ void B(n1 n1Var, String str, Integer num) {
        n1Var.getClass();
        if (num.intValue() == 0) {
            n1Var.f2454m.m(null);
        } else if (num.intValue() > 0) {
            if (str == null) {
                n1Var.f2454m.m("");
            } else {
                n1Var.f2454m.m(str);
            }
        }
    }

    public static /* synthetic */ Integer C(n1 n1Var, InputStream inputStream) {
        n1Var.getClass();
        try {
            return Integer.valueOf(n1Var.f2447f.A(x8.n.f(inputStream)));
        } catch (Exception e10) {
            tc.a.j(e10);
            return 0;
        } finally {
            com.tuyafeng.support.utils.j.a(inputStream);
        }
    }

    public static /* synthetic */ List D(n1 n1Var, String str) {
        List listO = n1Var.f2447f.o(str);
        if (listO == null || listO.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            arrayList.add(((m9.b) it.next()).g());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static /* synthetic */ void E(n1 n1Var, Boolean bool) {
        n1Var.getClass();
        if (bool.booleanValue()) {
            u9.n.e().q(true);
            n1Var.n0();
        }
    }

    public static /* synthetic */ void G(n1 n1Var, Boolean bool) {
        n1Var.getClass();
        if (bool.booleanValue()) {
            u9.n.e().q(true);
            n1Var.n0();
        }
    }

    public static /* synthetic */ Boolean H(n1 n1Var, x.d dVar, String str) {
        int i10;
        n1Var.getClass();
        if (((List) dVar.f14456b).size() > 0) {
            int iN = n1Var.f2447f.n(str);
            long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - ((long) ((List) dVar.f14456b).size());
            for (m9.b bVar : (List) dVar.f14456b) {
                bVar.i(str);
                iN++;
                bVar.k(iN);
                jCurrentTimeMillis++;
                bVar.m(jCurrentTimeMillis);
            }
            n1Var.f2447f.d((List) dVar.f14456b);
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (((List) dVar.f14455a).size() > 0) {
            HashSet hashSet = new HashSet();
            String strD = str;
            while (strD != null) {
                hashSet.add(strD);
                m9.a aVarE = n1Var.f2447f.e(strD);
                strD = aVarE == null ? null : aVarE.d();
            }
            for (int size = ((List) dVar.f14455a).size() - 1; size >= 0; size--) {
                m9.a aVar = (m9.a) ((List) dVar.f14455a).get(size);
                if (aVar != null && hashSet.contains(aVar.b())) {
                    ((List) dVar.f14455a).remove(size);
                }
            }
            if (((List) dVar.f14455a).size() > 0) {
                int iG = n1Var.f2447f.g(str);
                long jCurrentTimeMillis2 = (System.currentTimeMillis() / 1000) - ((long) ((List) dVar.f14455a).size());
                for (m9.a aVar2 : (List) dVar.f14455a) {
                    aVar2.o(str);
                    iG++;
                    aVar2.n(iG);
                    jCurrentTimeMillis2++;
                    aVar2.q(jCurrentTimeMillis2);
                }
                n1Var.f2447f.f((List) dVar.f14455a);
                i10++;
            }
        }
        return Boolean.valueOf(i10 > 0);
    }

    public static /* synthetic */ List I(n1 n1Var, String str, String str2) {
        n1Var.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = n1Var.f2447f.w(str, str2, 0).iterator();
        while (it.hasNext()) {
            arrayList.add(new a((m9.a) it.next()));
        }
        n1Var.T(arrayList);
        n1Var.f2455n = arrayList.size();
        Iterator it2 = n1Var.f2447f.z(str, str2, 0).iterator();
        while (it2.hasNext()) {
            arrayList.add(new a((m9.b) it2.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ x.d K(n1 n1Var, m9.a aVar) {
        m9.a aVarE = n1Var.f2447f.e(aVar.b());
        if (aVarE == null) {
            aVarE = m9.a.r();
        }
        String strB = aVarE.b();
        ArrayList arrayList = new ArrayList();
        if (!m9.a.g(strB)) {
            m9.a aVarK = m9.a.k(n1Var.f2447f.e(aVarE.d()));
            if (aVarK == null) {
                aVarK = m9.a.i("", null);
            }
            aVarK.p("..");
            a aVar2 = new a(aVarK);
            aVar2.k(true);
            arrayList.add(aVar2);
        }
        Iterator it = n1Var.f2447f.t(strB).iterator();
        while (it.hasNext()) {
            arrayList.add(new a((m9.a) it.next()));
        }
        n1Var.T(arrayList);
        n1Var.f2455n = arrayList.size();
        Iterator it2 = n1Var.f2447f.o(strB).iterator();
        while (it2.hasNext()) {
            arrayList.add(new a((m9.b) it2.next()));
        }
        return x.d.a(aVarE, arrayList);
    }

    public static /* synthetic */ void M(n1 n1Var, s5.a aVar) {
        n1Var.getClass();
        n1Var.i0(aVar.d() ? (m9.a) aVar.b() : null);
    }

    public static /* synthetic */ void N(n1 n1Var, Boolean bool) {
        n1Var.getClass();
        if (bool.booleanValue()) {
            n1Var.n0();
        }
    }

    public static /* synthetic */ boolean l(n1 n1Var, long j10, List list) {
        return j10 == n1Var.f2456o;
    }

    public static /* synthetic */ Integer m(n1 n1Var, OutputStream outputStream) {
        int iG;
        n1Var.getClass();
        try {
            try {
                iG = x8.n.g(outputStream, x.d.a(n1Var.f2447f.j(), n1Var.f2447f.u()));
                com.tuyafeng.support.utils.j.a(outputStream);
            } catch (Exception e10) {
                tc.a.j(e10);
                com.tuyafeng.support.utils.j.a(outputStream);
                iG = 0;
            }
            return Integer.valueOf(iG);
        } catch (Throwable th) {
            com.tuyafeng.support.utils.j.a(outputStream);
            throw th;
        }
    }

    public static /* synthetic */ boolean n(n1 n1Var, long j10, x.d dVar) {
        return j10 == n1Var.f2456o;
    }

    public static /* synthetic */ List o(n1 n1Var, int[] iArr) {
        x.d dVarZ = n1Var.Z(iArr);
        if (((List) dVarZ.f14455a).isEmpty() && ((List) dVarZ.f14456b).isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) dVarZ.f14455a).iterator();
        while (it.hasNext()) {
            Iterator it2 = n1Var.f2447f.o(((m9.a) it.next()).b()).iterator();
            while (it2.hasNext()) {
                arrayList.add(((m9.b) it2.next()).g());
            }
        }
        Iterator it3 = ((List) dVarZ.f14456b).iterator();
        while (it3.hasNext()) {
            arrayList.add(((m9.b) it3.next()).g());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static /* synthetic */ void p(n1 n1Var, Integer num) {
        n1Var.getClass();
        u9.n.e().q(true);
        if (num.intValue() > 0) {
            n1Var.n0();
        }
        n1Var.f2453l.m(num);
    }

    public static /* synthetic */ void q(n1 n1Var, Boolean bool) {
        n1Var.getClass();
        if (bool.booleanValue()) {
            n1Var.n0();
        }
    }

    public static /* synthetic */ void r(n1 n1Var, List list) {
        Collections.sort(list, n1Var.f2452k);
        n1Var.f2451j.m(Boolean.valueOf(list.isEmpty()));
        n1Var.f2449h.m(list);
    }

    public static /* synthetic */ Boolean s(n1 n1Var, x.d dVar) {
        int i10;
        n1Var.getClass();
        if (((List) dVar.f14455a).size() > 0) {
            String[] strArr = new String[((List) dVar.f14455a).size()];
            Iterator it = ((List) dVar.f14455a).iterator();
            int i11 = 0;
            while (it.hasNext()) {
                strArr[i11] = ((m9.a) it.next()).b();
                i11++;
            }
            n1Var.f2447f.p(strArr);
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (((List) dVar.f14456b).size() > 0) {
            String[] strArr2 = new String[((List) dVar.f14456b).size()];
            Iterator it2 = ((List) dVar.f14456b).iterator();
            int i12 = 0;
            while (it2.hasNext()) {
                strArr2[i12] = ((m9.b) it2.next()).c();
                i12++;
            }
            n1Var.f2447f.b(strArr2);
            i10++;
        }
        return Boolean.valueOf(i10 > 0);
    }

    public static /* synthetic */ boolean t(n1 n1Var, long j10, s5.a aVar) {
        return j10 == n1Var.f2456o;
    }

    public static /* synthetic */ void u(n1 n1Var, x.d dVar) {
        if (!t1.a(n1Var.f2450i.e(), dVar.f14455a)) {
            n1Var.f2450i.m((m9.a) dVar.f14455a);
        }
        Collections.sort((List) dVar.f14456b, n1Var.f2452k);
        n1Var.f2451j.m(Boolean.valueOf(((List) dVar.f14456b).isEmpty()));
        n1Var.f2449h.m((List) dVar.f14456b);
    }

    public static /* synthetic */ boolean w(n1 n1Var, long j10, s5.a aVar) {
        return j10 == n1Var.f2456o;
    }

    public static /* synthetic */ void x(n1 n1Var, String str, s5.a aVar) {
        n1Var.getClass();
        n1Var.r0(str, aVar.d() ? (m9.a) aVar.b() : null);
    }

    public void P(final String str) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: cb.q0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f2466c.f2447f.x(str));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).b(new u6.f() { // from class: cb.r0
            @Override // u6.f
            public final void accept(Object obj) {
                n1.G(this.f2469c, (Boolean) obj);
            }
        });
    }

    public void Q(final String str) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: cb.t0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f2474c.f2447f.r(str));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).b(new u6.f() { // from class: cb.v0
            @Override // u6.f
            public final void accept(Object obj) {
                n1.E(this.f2480c, (Boolean) obj);
            }
        });
    }

    public void R(int[] iArr) {
        final x.d dVarZ = Z(iArr);
        if (((List) dVarZ.f14455a).isEmpty() && ((List) dVarZ.f14456b).isEmpty()) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: cb.o0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return n1.s(this.f2459c, dVarZ);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: cb.p0
            @Override // u6.f
            public final void accept(Object obj) {
                n1.N(this.f2464c, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public void S(final OutputStream outputStream, final String str) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: cb.d1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return n1.m(this.f2374c, outputStream);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: cb.e1
            @Override // u6.f
            public final void accept(Object obj) {
                n1.B(this.f2378c, str, (Integer) obj);
            }
        }, new w7.e0());
    }

    public final void T(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!aVar.i() && aVar.h()) {
                i10++;
            }
        }
        if (i10 == 0) {
            return;
        }
        String[] strArr = new String[i10];
        int[] iArr = new int[i10];
        int size = list.size();
        int i11 = i10;
        for (int i12 = 0; i12 < size; i12++) {
            a aVar2 = (a) list.get(i12);
            if (!aVar2.i() && aVar2.h()) {
                i11--;
                strArr[i11] = aVar2.e();
                iArr[i11] = i12;
                if (i11 == 0) {
                    break;
                }
            }
        }
        Map mapY = this.f2447f.y(strArr);
        for (int i13 = 0; i13 < i10; i13++) {
            a aVar3 = (a) list.get(iArr[i13]);
            Integer num = (Integer) mapY.get(aVar3.e());
            if (num != null) {
                aVar3.j(num.intValue());
            }
        }
    }

    public LiveData U() {
        return this.f2449h;
    }

    public LiveData V() {
        return this.f2454m;
    }

    public LiveData W() {
        return this.f2453l;
    }

    public androidx.lifecycle.n X() {
        return this.f2450i;
    }

    public int Y() {
        return this.f2455n;
    }

    public final x.d Z(int[] iArr) {
        List list = (List) this.f2449h.e();
        if (iArr == null || iArr.length == 0 || list == null) {
            List list2 = Collections.EMPTY_LIST;
            return x.d.a(list2, list2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 : iArr) {
            a aVar = (a) list.get(i10);
            if (aVar.a() != null) {
                arrayList.add(aVar.a());
            } else if (aVar.b() != null) {
                arrayList2.add(aVar.b());
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: cb.x0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((m9.a) obj).c(), ((m9.a) obj2).c());
            }
        });
        Collections.sort(arrayList2, new Comparator() { // from class: cb.y0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((m9.b) obj).d(), ((m9.b) obj2).d());
            }
        });
        return x.d.a(arrayList, arrayList2);
    }

    public r6.f a0(final int[] iArr) {
        return r6.f.h(new Callable() { // from class: cb.w0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return n1.o(this.f2482c, iArr);
            }
        }).n(a7.a.c()).k(q6.b.b());
    }

    public int b0() {
        return this.f2452k.b();
    }

    public r6.f c0(final String str) {
        return r6.f.h(new Callable() { // from class: cb.s0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return n1.D(this.f2471c, str);
            }
        }).n(a7.a.c()).k(q6.b.b());
    }

    public int d0() {
        return this.f2448g.U2();
    }

    public void e0(final InputStream inputStream) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: cb.b1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return n1.C(this.f2366c, inputStream);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: cb.c1
            @Override // u6.f
            public final void accept(Object obj) {
                n1.p(this.f2371c, (Integer) obj);
            }
        }, new w7.a0());
    }

    public void f0() {
        this.f2456o++;
    }

    public LiveData g0() {
        return this.f2451j;
    }

    public boolean h0(int i10) {
        List list = (List) this.f2449h.e();
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return true;
        }
        return ((a) list.get(i10)).i();
    }

    public void i0(final m9.a aVar) {
        this.f2457p = null;
        if (aVar == null) {
            aVar = m9.a.r();
        }
        if (!t1.a(this.f2450i.e(), aVar)) {
            this.f2450i.m(aVar);
        }
        final long j10 = this.f2456o + 1;
        this.f2456o = j10;
        ((autodispose2.m) r6.q.f(new Callable() { // from class: cb.j0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return n1.K(this.f2424c, aVar);
            }
        }).k(a7.a.c()).i(q6.b.b()).d(new u6.i() { // from class: cb.u0
            @Override // u6.i
            public final boolean test(Object obj) {
                return n1.n(this.f2477c, j10, (x.d) obj);
            }
        }).p(s8.b.c(this))).a(new u6.f() { // from class: cb.f1
            @Override // u6.f
            public final void accept(Object obj) {
                n1.u(this.f2401c, (x.d) obj);
            }
        }, new w7.a0());
    }

    public void j0(final String str) {
        final long j10 = this.f2456o + 1;
        this.f2456o = j10;
        ((autodispose2.m) r6.q.f(new Callable() { // from class: cb.g1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s5.a.f(this.f2406c.f2447f.e(str));
            }
        }).k(a7.a.c()).i(q6.b.b()).d(new u6.i() { // from class: cb.h1
            @Override // u6.i
            public final boolean test(Object obj) {
                return n1.t(this.f2412c, j10, (s5.a) obj);
            }
        }).p(s8.b.c(this))).a(new u6.f() { // from class: cb.i1
            @Override // u6.f
            public final void accept(Object obj) {
                n1.M(this.f2422c, (s5.a) obj);
            }
        }, new w7.e0());
    }

    public void k0(int i10, int i11) {
        int iB0 = b0();
        List list = (List) this.f2449h.e();
        if (i10 == i11 || iB0 == 2 || list == null || list.isEmpty()) {
            return;
        }
        boolean z10 = iB0 == 1;
        int iY = Y();
        if (i10 >= iY) {
            final ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i12 = iY; i12 < size; i12++) {
                m9.b bVarB = ((a) list.get(i12)).b();
                if (bVarB != null) {
                    bVarB.k(z10 ? size - i12 : (i12 - iY) + 1);
                    arrayList.add(bVarB);
                }
            }
            x8.h.b(new Runnable() { // from class: cb.m1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2444c.f2447f.d(arrayList);
                }
            });
            return;
        }
        final ArrayList arrayList2 = new ArrayList();
        int i13 = !m9.a.g(p0()) ? 1 : 0;
        for (int i14 = i13; i14 < iY; i14++) {
            m9.a aVarA = ((a) list.get(i14)).a();
            if (aVarA != null) {
                aVarA.n(z10 ? (iY - i14) + i13 : (i14 - i13) + 1);
                arrayList2.add(aVarA);
            }
        }
        x8.h.b(new Runnable() { // from class: cb.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.f2430c.f2447f.f(arrayList2);
            }
        });
    }

    public void l0(int i10, int i11) {
        List list = (List) this.f2449h.e();
        if (list == null) {
            return;
        }
        list.add(i11, (a) list.remove(i10));
    }

    public void m0(int[] iArr, final String str) {
        final x.d dVarZ = Z(iArr);
        if (((List) dVarZ.f14455a).isEmpty() && ((List) dVarZ.f14456b).isEmpty()) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: cb.z0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return n1.H(this.f2487c, dVarZ, str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: cb.a1
            @Override // u6.f
            public final void accept(Object obj) {
                n1.q(this.f2363c, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public void n0() {
        String str = this.f2457p;
        if (str == null || str.isEmpty()) {
            i0(o0());
        } else {
            q0(this.f2457p);
        }
    }

    public m9.a o0() {
        m9.a aVar = (m9.a) this.f2450i.e();
        return aVar == null ? m9.a.r() : aVar;
    }

    public String p0() {
        return o0().b();
    }

    public void q0(String str) {
        r0(str, (m9.a) this.f2450i.e());
    }

    public void r0(String str, m9.a aVar) {
        if (str != null) {
            final String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                this.f2457p = strTrim;
                final long j10 = this.f2456o + 1;
                this.f2456o = j10;
                if (aVar == null) {
                    aVar = m9.a.r();
                }
                if (aVar != this.f2450i.e()) {
                    this.f2450i.m(aVar);
                }
                final String strB = aVar.b();
                ((autodispose2.m) r6.q.f(new Callable() { // from class: cb.l0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return n1.I(this.f2436c, strTrim, strB);
                    }
                }).k(a7.a.c()).i(q6.b.b()).d(new u6.i() { // from class: cb.m0
                    @Override // u6.i
                    public final boolean test(Object obj) {
                        return n1.l(this.f2442c, j10, (List) obj);
                    }
                }).p(s8.b.c(this))).a(new u6.f() { // from class: cb.n0
                    @Override // u6.f
                    public final void accept(Object obj) {
                        n1.r(this.f2446c, (List) obj);
                    }
                }, new w7.e0());
                return;
            }
        }
        i0(aVar);
    }

    public void s0(final String str, final String str2) {
        final long j10 = this.f2456o + 1;
        this.f2456o = j10;
        ((autodispose2.m) r6.q.f(new Callable() { // from class: cb.j1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s5.a.f(this.f2426c.f2447f.e(str2));
            }
        }).k(a7.a.c()).i(q6.b.b()).d(new u6.i() { // from class: cb.k1
            @Override // u6.i
            public final boolean test(Object obj) {
                return n1.w(this.f2432c, j10, (s5.a) obj);
            }
        }).p(s8.b.c(this))).a(new u6.f() { // from class: cb.l1
            @Override // u6.f
            public final void accept(Object obj) {
                n1.x(this.f2439c, str, (s5.a) obj);
            }
        }, new w7.e0());
    }

    public void t0(int i10) {
        if (this.f2452k.b() == i10) {
            return;
        }
        this.f2452k.d(i10);
        this.f2448g.o1(i10);
        u9.n.e().q(true);
        n0();
    }

    public void u0(int i10) {
        this.f2448g.i(i10);
    }
}
