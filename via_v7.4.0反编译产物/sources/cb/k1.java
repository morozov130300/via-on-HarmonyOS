package cb;

import androidx.lifecycle.LiveData;
import java.io.IOException;
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
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k1 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final o9.c f3140f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f3141g;

    /* renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.l f3142h = new androidx.lifecycle.l();

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f3143i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f3144j = new androidx.lifecycle.l();

    /* renamed from: k, reason: collision with root package name */
    public final b f3145k;

    /* renamed from: l, reason: collision with root package name */
    public final k8.n f3146l;

    /* renamed from: m, reason: collision with root package name */
    public final k8.n f3147m;

    /* renamed from: n, reason: collision with root package name */
    public int f3148n;

    /* renamed from: o, reason: collision with root package name */
    public long f3149o;

    /* renamed from: p, reason: collision with root package name */
    public String f3150p;

    public k1(o9.c cVar, w9.l lVar) {
        b bVarC = b.c(0);
        this.f3145k = bVarC;
        this.f3146l = new k8.n();
        this.f3147m = new k8.n();
        this.f3150p = null;
        this.f3140f = cVar;
        this.f3141g = lVar;
        bVarC.d(lVar.V0());
    }

    public static /* synthetic */ w.d A(k1 k1Var, o9.a aVar) {
        o9.a aVarF;
        if (aVar == null) {
            k1Var.getClass();
            aVarF = null;
        } else {
            aVarF = k1Var.f3140f.f(aVar.b());
        }
        if (aVarF == null) {
            aVarF = o9.a.r();
        }
        String strB = aVarF.b();
        ArrayList arrayList = new ArrayList();
        if (!o9.a.g(strB)) {
            o9.a aVarK = o9.a.k(k1Var.f3140f.f(aVarF.d()));
            if (aVarK == null) {
                aVarK = o9.a.i("", null);
            }
            aVarK.p("..");
            a aVar2 = new a(aVarK);
            aVar2.j(true);
            arrayList.add(aVar2);
        }
        Iterator it = k1Var.f3140f.s(strB).iterator();
        while (it.hasNext()) {
            arrayList.add(new a((o9.a) it.next()));
        }
        k1Var.R(arrayList);
        k1Var.f3148n = arrayList.size();
        Iterator it2 = k1Var.f3140f.n(strB).iterator();
        while (it2.hasNext()) {
            arrayList.add(new a((o9.b) it2.next()));
        }
        return w.d.a(aVarF, arrayList);
    }

    public static /* synthetic */ Integer B(k1 k1Var, InputStream inputStream) throws IOException {
        k1Var.getClass();
        try {
            try {
                return Integer.valueOf(k1Var.f3140f.z(z8.p.q(inputStream)));
            } catch (Exception e10) {
                pc.a.i(e10);
                g6.j.a(inputStream);
                return 0;
            }
        } finally {
            g6.j.a(inputStream);
        }
    }

    public static /* synthetic */ boolean D(k1 k1Var, long j10, List list) {
        return j10 == k1Var.f3149o;
    }

    public static /* synthetic */ void E(k1 k1Var, Integer num) {
        k1Var.getClass();
        w9.n.e().s(true);
        if (num.intValue() > 0) {
            k1Var.k0();
        }
        k1Var.f3146l.m(num);
    }

    public static /* synthetic */ void G(k1 k1Var, Boolean bool) {
        k1Var.getClass();
        if (bool.booleanValue()) {
            w9.n.e().s(true);
            k1Var.k0();
        }
    }

    public static /* synthetic */ Boolean H(k1 k1Var, w.d dVar, String str) {
        int i10;
        k1Var.getClass();
        if (((List) dVar.f13208b).size() > 0) {
            int iM = k1Var.f3140f.m(str);
            long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - ((List) dVar.f13208b).size();
            for (o9.b bVar : (List) dVar.f13208b) {
                bVar.i(str);
                iM++;
                bVar.k(iM);
                jCurrentTimeMillis++;
                bVar.m(jCurrentTimeMillis);
            }
            k1Var.f3140f.e((List) dVar.f13208b);
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (((List) dVar.f13207a).size() > 0) {
            HashSet hashSet = new HashSet();
            String strD = str;
            while (strD != null) {
                hashSet.add(strD);
                o9.a aVarF = k1Var.f3140f.f(strD);
                strD = aVarF == null ? null : aVarF.d();
            }
            for (int size = ((List) dVar.f13207a).size() - 1; size >= 0; size--) {
                o9.a aVar = (o9.a) ((List) dVar.f13207a).get(size);
                if (aVar != null && hashSet.contains(aVar.b())) {
                    ((List) dVar.f13207a).remove(size);
                }
            }
            if (((List) dVar.f13207a).size() > 0) {
                int i11 = k1Var.f3140f.i(str);
                long jCurrentTimeMillis2 = (System.currentTimeMillis() / 1000) - ((List) dVar.f13207a).size();
                for (o9.a aVar2 : (List) dVar.f13207a) {
                    aVar2.o(str);
                    i11++;
                    aVar2.n(i11);
                    jCurrentTimeMillis2++;
                    aVar2.q(jCurrentTimeMillis2);
                }
                k1Var.f3140f.h((List) dVar.f13207a);
                i10++;
            }
        }
        return Boolean.valueOf(i10 > 0);
    }

    public static /* synthetic */ void I(k1 k1Var, List list) {
        Collections.sort(list, k1Var.f3145k);
        k1Var.f3144j.m(Boolean.valueOf(list.isEmpty()));
        k1Var.f3142h.m(list);
    }

    public static /* synthetic */ void L(k1 k1Var, Boolean bool) {
        k1Var.getClass();
        if (bool.booleanValue()) {
            k1Var.k0();
        }
    }

    public static /* synthetic */ void M(k1 k1Var, x5.a aVar) {
        k1Var.getClass();
        k1Var.f0(aVar.d() ? (o9.a) aVar.b() : null);
    }

    public static /* synthetic */ void l(k1 k1Var, w.d dVar) {
        if (!u1.a(k1Var.f3143i.e(), dVar.f13207a)) {
            k1Var.f3143i.m((o9.a) dVar.f13207a);
        }
        Collections.sort((List) dVar.f13208b, k1Var.f3145k);
        k1Var.f3144j.m(Boolean.valueOf(((List) dVar.f13208b).isEmpty()));
        k1Var.f3142h.m((List) dVar.f13208b);
    }

    public static /* synthetic */ void m(k1 k1Var, String str, Integer num) {
        k1Var.getClass();
        if (num.intValue() == 0) {
            k1Var.f3147m.m(null);
        } else if (num.intValue() > 0) {
            if (str == null) {
                k1Var.f3147m.m("");
            } else {
                k1Var.f3147m.m(str);
            }
        }
    }

    public static /* synthetic */ Boolean n(k1 k1Var, w.d dVar) {
        int i10;
        k1Var.getClass();
        if (((List) dVar.f13207a).size() > 0) {
            String[] strArr = new String[((List) dVar.f13207a).size()];
            Iterator it = ((List) dVar.f13207a).iterator();
            int i11 = 0;
            while (it.hasNext()) {
                strArr[i11] = ((o9.a) it.next()).b();
                i11++;
            }
            k1Var.f3140f.p(strArr);
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (((List) dVar.f13208b).size() > 0) {
            String[] strArr2 = new String[((List) dVar.f13208b).size()];
            Iterator it2 = ((List) dVar.f13208b).iterator();
            int i12 = 0;
            while (it2.hasNext()) {
                strArr2[i12] = ((o9.b) it2.next()).c();
                i12++;
            }
            k1Var.f3140f.c(strArr2);
            i10++;
        }
        return Boolean.valueOf(i10 > 0);
    }

    public static /* synthetic */ Integer o(k1 k1Var, OutputStream outputStream) throws IOException {
        int iR;
        k1Var.getClass();
        try {
            try {
                iR = z8.p.r(outputStream, w.d.a(k1Var.f3140f.k(), k1Var.f3140f.u()));
            } catch (Exception e10) {
                pc.a.i(e10);
                g6.j.a(outputStream);
                iR = 0;
            }
            return Integer.valueOf(iR);
        } finally {
            g6.j.a(outputStream);
        }
    }

    public static /* synthetic */ List p(k1 k1Var, String str, String str2) {
        k1Var.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = k1Var.f3140f.w(str, str2, 0).iterator();
        while (it.hasNext()) {
            arrayList.add(new a((o9.a) it.next()));
        }
        k1Var.R(arrayList);
        k1Var.f3148n = arrayList.size();
        Iterator it2 = k1Var.f3140f.A(str, str2, 0).iterator();
        while (it2.hasNext()) {
            arrayList.add(new a((o9.b) it2.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ List q(k1 k1Var, String str) {
        List listN = k1Var.f3140f.n(str);
        if (listN == null || listN.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listN.iterator();
        while (it.hasNext()) {
            arrayList.add(((o9.b) it.next()).g());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static /* synthetic */ boolean r(k1 k1Var, long j10, w.d dVar) {
        return j10 == k1Var.f3149o;
    }

    public static /* synthetic */ void s(k1 k1Var, String str, x5.a aVar) {
        k1Var.getClass();
        k1Var.o0(str, aVar.d() ? (o9.a) aVar.b() : null);
    }

    public static /* synthetic */ List t(k1 k1Var, int[] iArr) {
        w.d dVarX = k1Var.X(iArr);
        if (((List) dVarX.f13207a).isEmpty() && ((List) dVarX.f13208b).isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) dVarX.f13207a).iterator();
        while (it.hasNext()) {
            Iterator it2 = k1Var.f3140f.n(((o9.a) it.next()).b()).iterator();
            while (it2.hasNext()) {
                arrayList.add(((o9.b) it2.next()).g());
            }
        }
        Iterator it3 = ((List) dVarX.f13208b).iterator();
        while (it3.hasNext()) {
            arrayList.add(((o9.b) it3.next()).g());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static /* synthetic */ void x(k1 k1Var, Boolean bool) {
        k1Var.getClass();
        if (bool.booleanValue()) {
            k1Var.k0();
        }
    }

    public static /* synthetic */ void y(k1 k1Var, Boolean bool) {
        k1Var.getClass();
        if (bool.booleanValue()) {
            w9.n.e().s(true);
            k1Var.k0();
        }
    }

    public void N(final String str) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: cb.n0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f3160e.f3140f.x(str));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).b(new a7.e() { // from class: cb.o0
            @Override // a7.e
            public final void accept(Object obj) {
                k1.y(this.f3163e, (Boolean) obj);
            }
        });
    }

    public void O(final String str) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: cb.q0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f3168e.f3140f.q(str));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).b(new a7.e() { // from class: cb.r0
            @Override // a7.e
            public final void accept(Object obj) {
                k1.G(this.f3171e, (Boolean) obj);
            }
        });
    }

    public void P(int[] iArr) {
        final w.d dVarX = X(iArr);
        if (((List) dVarX.f13207a).isEmpty() && ((List) dVarX.f13208b).isEmpty()) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: cb.l0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k1.n(this.f3152e, dVarX);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: cb.m0
            @Override // a7.e
            public final void accept(Object obj) {
                k1.L(this.f3157e, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public void Q(final OutputStream outputStream, final String str) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: cb.a1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k1.o(this.f3067e, outputStream);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: cb.b1
            @Override // a7.e
            public final void accept(Object obj) {
                k1.m(this.f3071e, str, (Integer) obj);
            }
        }, new x7.g0());
    }

    public final void R(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!aVar.h() && aVar.g()) {
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
            if (!aVar2.h() && aVar2.g()) {
                i11--;
                strArr[i11] = aVar2.d();
                iArr[i11] = i12;
                if (i11 == 0) {
                    break;
                }
            }
        }
        Map mapY = this.f3140f.y(strArr);
        for (int i13 = 0; i13 < i10; i13++) {
            a aVar3 = (a) list.get(iArr[i13]);
            Integer num = (Integer) mapY.get(aVar3.d());
            if (num != null) {
                aVar3.i(num.intValue());
            }
        }
    }

    public LiveData S() {
        return this.f3142h;
    }

    public LiveData T() {
        return this.f3147m;
    }

    public LiveData U() {
        return this.f3146l;
    }

    public androidx.lifecycle.l V() {
        return this.f3143i;
    }

    public int W() {
        return this.f3148n;
    }

    public final w.d X(int[] iArr) {
        List list = (List) this.f3142h.e();
        if (iArr == null || iArr.length == 0 || list == null) {
            List list2 = Collections.EMPTY_LIST;
            return w.d.a(list2, list2);
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
        Collections.sort(arrayList, new Comparator() { // from class: cb.u0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((o9.a) obj).c(), ((o9.a) obj2).c());
            }
        });
        Collections.sort(arrayList2, new Comparator() { // from class: cb.v0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((o9.b) obj).d(), ((o9.b) obj2).d());
            }
        });
        return w.d.a(arrayList, arrayList2);
    }

    public x6.f Y(final int[] iArr) {
        return x6.f.h(new Callable() { // from class: cb.s0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k1.t(this.f3173e, iArr);
            }
        }).n(g7.a.c()).k(w6.b.b());
    }

    public int Z() {
        return this.f3145k.b();
    }

    public x6.f a0(final String str) {
        return x6.f.h(new Callable() { // from class: cb.p0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k1.q(this.f3165e, str);
            }
        }).n(g7.a.c()).k(w6.b.b());
    }

    public int b0() {
        return this.f3141g.R2();
    }

    public void c0(final InputStream inputStream) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: cb.y0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k1.B(this.f3187e, inputStream);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: cb.z0
            @Override // a7.e
            public final void accept(Object obj) {
                k1.E(this.f3190e, (Integer) obj);
            }
        }, new x7.c0());
    }

    public LiveData d0() {
        return this.f3144j;
    }

    public boolean e0(int i10) {
        List list = (List) this.f3142h.e();
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return true;
        }
        return ((a) list.get(i10)).h();
    }

    public void f0(final o9.a aVar) {
        this.f3150p = null;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.f3149o = jCurrentTimeMillis;
        ((autodispose2.m) x6.o.g(new Callable() { // from class: cb.i0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k1.A(this.f3129e, aVar);
            }
        }).e(new a7.h() { // from class: cb.t0
            @Override // a7.h
            public final boolean test(Object obj) {
                return k1.r(this.f3176e, jCurrentTimeMillis, (w.d) obj);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.c(this))).a(new a7.e() { // from class: cb.c1
            @Override // a7.e
            public final void accept(Object obj) {
                k1.l(this.f3076e, (w.d) obj);
            }
        }, new x7.c0());
    }

    public void g0(final String str) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: cb.d1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x5.a.f(this.f3079e.f3140f.f(str));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: cb.e1
            @Override // a7.e
            public final void accept(Object obj) {
                k1.M(this.f3104e, (x5.a) obj);
            }
        }, new x7.g0());
    }

    public void h0(int i10, int i11) {
        int iZ = Z();
        List list = (List) this.f3142h.e();
        if (i10 == i11 || iZ == 2 || list == null || list.isEmpty()) {
            return;
        }
        boolean z10 = iZ == 1;
        int iW = W();
        if (i10 >= iW) {
            final ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i12 = iW; i12 < size; i12++) {
                o9.b bVarB = ((a) list.get(i12)).b();
                if (bVarB != null) {
                    bVarB.k(z10 ? size - i12 : (i12 - iW) + 1);
                    arrayList.add(bVarB);
                }
            }
            z8.h.b(new Runnable() { // from class: cb.h1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3126e.f3140f.e(arrayList);
                }
            });
            return;
        }
        final ArrayList arrayList2 = new ArrayList();
        int i13 = !o9.a.g(m0()) ? 1 : 0;
        for (int i14 = i13; i14 < iW; i14++) {
            o9.a aVarA = ((a) list.get(i14)).a();
            if (aVarA != null) {
                aVarA.n(z10 ? (iW - i14) + i13 : (i14 - i13) + 1);
                arrayList2.add(aVarA);
            }
        }
        z8.h.b(new Runnable() { // from class: cb.i1
            @Override // java.lang.Runnable
            public final void run() {
                this.f3131e.f3140f.h(arrayList2);
            }
        });
    }

    public void i0(int i10, int i11) {
        List list = (List) this.f3142h.e();
        if (list == null) {
            return;
        }
        list.add(i11, (a) list.remove(i10));
    }

    public void j0(int[] iArr, final String str) {
        final w.d dVarX = X(iArr);
        if (((List) dVarX.f13207a).isEmpty() && ((List) dVarX.f13208b).isEmpty()) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: cb.w0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k1.H(this.f3181e, dVarX, str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: cb.x0
            @Override // a7.e
            public final void accept(Object obj) {
                k1.x(this.f3185e, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public void k0() {
        String str = this.f3150p;
        if (str == null || str.isEmpty()) {
            f0(l0());
        } else {
            n0(this.f3150p);
        }
    }

    public o9.a l0() {
        o9.a aVar = (o9.a) this.f3143i.e();
        return aVar == null ? o9.a.r() : aVar;
    }

    public String m0() {
        return l0().b();
    }

    public void n0(String str) {
        o0(str, (o9.a) this.f3143i.e());
    }

    public void o0(String str, o9.a aVar) {
        if (str != null) {
            final String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                this.f3150p = strTrim;
                final long jCurrentTimeMillis = System.currentTimeMillis();
                this.f3149o = jCurrentTimeMillis;
                if (aVar == null) {
                    aVar = o9.a.r();
                }
                if (aVar != this.f3143i.e()) {
                    this.f3143i.m(aVar);
                }
                final String strB = aVar.b();
                ((autodispose2.m) x6.o.g(new Callable() { // from class: cb.j1
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return k1.p(this.f3135e, strTrim, strB);
                    }
                }).e(new a7.h() { // from class: cb.j0
                    @Override // a7.h
                    public final boolean test(Object obj) {
                        return k1.D(this.f3133e, jCurrentTimeMillis, (List) obj);
                    }
                }).n(g7.a.c()).k(w6.b.b()).p(u8.b.c(this))).a(new a7.e() { // from class: cb.k0
                    @Override // a7.e
                    public final void accept(Object obj) {
                        k1.I(this.f3139e, (List) obj);
                    }
                }, new x7.g0());
                return;
            }
        }
        f0(aVar);
    }

    public void p0(final String str, final String str2) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: cb.f1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x5.a.f(this.f3109e.f3140f.f(str2));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: cb.g1
            @Override // a7.e
            public final void accept(Object obj) {
                k1.s(this.f3115e, str, (x5.a) obj);
            }
        }, new x7.g0());
    }

    public void q0(int i10) {
        if (this.f3145k.b() == i10) {
            return;
        }
        this.f3145k.d(i10);
        this.f3141g.n1(i10);
        w9.n.e().s(true);
        k0();
    }

    public void r0(int i10) {
        this.f3141g.h(i10);
    }
}
