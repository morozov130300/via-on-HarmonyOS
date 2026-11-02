package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator f1442a = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return dVar.f1445a - dVar2.f1445a;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class b {
        public abstract boolean a(int i10, int i11);

        public abstract boolean b(int i10, int i11);

        public Object c(int i10, int i11) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f1443a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1444b;

        public c(int i10) {
            int[] iArr = new int[i10];
            this.f1443a = iArr;
            this.f1444b = iArr.length / 2;
        }

        public int[] a() {
            return this.f1443a;
        }

        public int b(int i10) {
            return this.f1443a[i10 + this.f1444b];
        }

        public void c(int i10, int i11) {
            this.f1443a[i10 + this.f1444b] = i11;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f1445a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1446b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1447c;

        public d(int i10, int i11, int i12) {
            this.f1445a = i10;
            this.f1446b = i11;
            this.f1447c = i12;
        }

        public int a() {
            return this.f1445a + this.f1447c;
        }

        public int b() {
            return this.f1446b + this.f1447c;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final List f1448a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f1449b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f1450c;

        /* renamed from: d, reason: collision with root package name */
        public final b f1451d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1452e;

        /* renamed from: f, reason: collision with root package name */
        public final int f1453f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f1454g;

        public e(b bVar, List list, int[] iArr, int[] iArr2, boolean z10) {
            this.f1448a = list;
            this.f1449b = iArr;
            this.f1450c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f1451d = bVar;
            this.f1452e = bVar.e();
            this.f1453f = bVar.d();
            this.f1454g = z10;
            a();
            e();
        }

        public static C0022f g(Collection collection, int i10, boolean z10) {
            C0022f c0022f;
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0022f = null;
                    break;
                }
                c0022f = (C0022f) it.next();
                if (c0022f.f1455a == i10 && c0022f.f1457c == z10) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                C0022f c0022f2 = (C0022f) it.next();
                if (z10) {
                    c0022f2.f1456b--;
                } else {
                    c0022f2.f1456b++;
                }
            }
            return c0022f;
        }

        public final void a() {
            d dVar = this.f1448a.isEmpty() ? null : (d) this.f1448a.get(0);
            if (dVar == null || dVar.f1445a != 0 || dVar.f1446b != 0) {
                this.f1448a.add(0, new d(0, 0, 0));
            }
            this.f1448a.add(new d(this.f1452e, this.f1453f, 0));
        }

        public void b(o oVar) {
            int i10;
            androidx.recyclerview.widget.c cVar = oVar instanceof androidx.recyclerview.widget.c ? (androidx.recyclerview.widget.c) oVar : new androidx.recyclerview.widget.c(oVar);
            int i11 = this.f1452e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i12 = this.f1452e;
            int i13 = this.f1453f;
            for (int size = this.f1448a.size() - 1; size >= 0; size--) {
                d dVar = (d) this.f1448a.get(size);
                int iA = dVar.a();
                int iB = dVar.b();
                while (true) {
                    if (i12 <= iA) {
                        break;
                    }
                    i12--;
                    int i14 = this.f1449b[i12];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        C0022f c0022fG = g(arrayDeque, i15, false);
                        if (c0022fG != null) {
                            int i16 = (i11 - c0022fG.f1456b) - 1;
                            cVar.a(i12, i16);
                            if ((i14 & 4) != 0) {
                                cVar.d(i16, 1, this.f1451d.c(i12, i15));
                            }
                        } else {
                            arrayDeque.add(new C0022f(i12, (i11 - i12) - 1, true));
                        }
                    } else {
                        cVar.c(i12, 1);
                        i11--;
                    }
                }
                while (i13 > iB) {
                    i13--;
                    int i17 = this.f1450c[i13];
                    if ((i17 & 12) != 0) {
                        int i18 = i17 >> 4;
                        C0022f c0022fG2 = g(arrayDeque, i18, true);
                        if (c0022fG2 == null) {
                            arrayDeque.add(new C0022f(i13, i11 - i12, false));
                        } else {
                            cVar.a((i11 - c0022fG2.f1456b) - 1, i12);
                            if ((i17 & 4) != 0) {
                                cVar.d(i12, 1, this.f1451d.c(i18, i13));
                            }
                        }
                    } else {
                        cVar.b(i12, 1);
                        i11++;
                    }
                }
                int i19 = dVar.f1445a;
                int i20 = dVar.f1446b;
                for (i10 = 0; i10 < dVar.f1447c; i10++) {
                    if ((this.f1449b[i19] & 15) == 2) {
                        cVar.d(i19, 1, this.f1451d.c(i19, i20));
                    }
                    i19++;
                    i20++;
                }
                i12 = dVar.f1445a;
                i13 = dVar.f1446b;
            }
            cVar.e();
        }

        public void c(RecyclerView.Adapter adapter) {
            b(new androidx.recyclerview.widget.b(adapter));
        }

        public final void d(int i10) {
            int size = this.f1448a.size();
            int iB = 0;
            for (int i11 = 0; i11 < size; i11++) {
                d dVar = (d) this.f1448a.get(i11);
                while (iB < dVar.f1446b) {
                    if (this.f1450c[iB] == 0 && this.f1451d.b(i10, iB)) {
                        int i12 = this.f1451d.a(i10, iB) ? 8 : 4;
                        this.f1449b[i10] = (iB << 4) | i12;
                        this.f1450c[iB] = (i10 << 4) | i12;
                        return;
                    }
                    iB++;
                }
                iB = dVar.b();
            }
        }

        public final void e() {
            for (d dVar : this.f1448a) {
                for (int i10 = 0; i10 < dVar.f1447c; i10++) {
                    int i11 = dVar.f1445a + i10;
                    int i12 = dVar.f1446b + i10;
                    int i13 = this.f1451d.a(i11, i12) ? 1 : 2;
                    this.f1449b[i11] = (i12 << 4) | i13;
                    this.f1450c[i12] = (i11 << 4) | i13;
                }
            }
            if (this.f1454g) {
                f();
            }
        }

        public final void f() {
            int iA = 0;
            for (d dVar : this.f1448a) {
                while (iA < dVar.f1445a) {
                    if (this.f1449b[iA] == 0) {
                        d(iA);
                    }
                    iA++;
                }
                iA = dVar.a();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: androidx.recyclerview.widget.f$f, reason: collision with other inner class name */
    public static class C0022f {

        /* renamed from: a, reason: collision with root package name */
        public int f1455a;

        /* renamed from: b, reason: collision with root package name */
        public int f1456b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1457c;

        public C0022f(int i10, int i11, boolean z10) {
            this.f1455a = i10;
            this.f1456b = i11;
            this.f1457c = z10;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public int f1458a;

        /* renamed from: b, reason: collision with root package name */
        public int f1459b;

        /* renamed from: c, reason: collision with root package name */
        public int f1460c;

        /* renamed from: d, reason: collision with root package name */
        public int f1461d;

        public g() {
        }

        public g(int i10, int i11, int i12, int i13) {
            this.f1458a = i10;
            this.f1459b = i11;
            this.f1460c = i12;
            this.f1461d = i13;
        }

        public int a() {
            return this.f1461d - this.f1460c;
        }

        public int b() {
            return this.f1459b - this.f1458a;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public int f1462a;

        /* renamed from: b, reason: collision with root package name */
        public int f1463b;

        /* renamed from: c, reason: collision with root package name */
        public int f1464c;

        /* renamed from: d, reason: collision with root package name */
        public int f1465d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1466e;

        public int a() {
            return Math.min(this.f1464c - this.f1462a, this.f1465d - this.f1463b);
        }

        public boolean b() {
            return this.f1465d - this.f1463b != this.f1464c - this.f1462a;
        }

        public boolean c() {
            return this.f1465d - this.f1463b > this.f1464c - this.f1462a;
        }

        public d d() {
            if (b()) {
                return this.f1466e ? new d(this.f1462a, this.f1463b, a()) : c() ? new d(this.f1462a, this.f1463b + 1, a()) : new d(this.f1462a + 1, this.f1463b, a());
            }
            int i10 = this.f1462a;
            return new d(i10, this.f1463b, this.f1464c - i10);
        }
    }

    public static h a(g gVar, b bVar, c cVar, c cVar2, int i10) {
        int iB;
        int i11;
        int i12;
        boolean z10 = (gVar.b() - gVar.a()) % 2 == 0;
        int iB2 = gVar.b() - gVar.a();
        int i13 = -i10;
        for (int i14 = i13; i14 <= i10; i14 += 2) {
            if (i14 == i13 || (i14 != i10 && cVar2.b(i14 + 1) < cVar2.b(i14 - 1))) {
                iB = cVar2.b(i14 + 1);
                i11 = iB;
            } else {
                iB = cVar2.b(i14 - 1);
                i11 = iB - 1;
            }
            int i15 = gVar.f1461d - ((gVar.f1459b - i11) - i14);
            int i16 = (i10 == 0 || i11 != iB) ? i15 : i15 + 1;
            while (i11 > gVar.f1458a && i15 > gVar.f1460c && bVar.b(i11 - 1, i15 - 1)) {
                i11--;
                i15--;
            }
            cVar2.c(i14, i11);
            if (z10 && (i12 = iB2 - i14) >= i13 && i12 <= i10 && cVar.b(i12) >= i11) {
                h hVar = new h();
                hVar.f1462a = i11;
                hVar.f1463b = i15;
                hVar.f1464c = iB;
                hVar.f1465d = i16;
                hVar.f1466e = true;
                return hVar;
            }
        }
        return null;
    }

    public static e b(b bVar) {
        return c(bVar, true);
    }

    public static e c(b bVar, boolean z10) {
        int iE = bVar.e();
        int iD = bVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new g(0, iE, 0, iD));
        int i10 = ((((iE + iD) + 1) / 2) * 2) + 1;
        c cVar = new c(i10);
        c cVar2 = new c(i10);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            g gVar = (g) arrayList2.remove(arrayList2.size() - 1);
            h hVarE = e(gVar, bVar, cVar, cVar2);
            if (hVarE != null) {
                if (hVarE.a() > 0) {
                    arrayList.add(hVarE.d());
                }
                g gVar2 = arrayList3.isEmpty() ? new g() : (g) arrayList3.remove(arrayList3.size() - 1);
                gVar2.f1458a = gVar.f1458a;
                gVar2.f1460c = gVar.f1460c;
                gVar2.f1459b = hVarE.f1462a;
                gVar2.f1461d = hVarE.f1463b;
                arrayList2.add(gVar2);
                gVar.f1459b = gVar.f1459b;
                gVar.f1461d = gVar.f1461d;
                gVar.f1458a = hVarE.f1464c;
                gVar.f1460c = hVarE.f1465d;
                arrayList2.add(gVar);
            } else {
                arrayList3.add(gVar);
            }
        }
        Collections.sort(arrayList, f1442a);
        return new e(bVar, arrayList, cVar.a(), cVar2.a(), z10);
    }

    public static h d(g gVar, b bVar, c cVar, c cVar2, int i10) {
        int iB;
        int i11;
        int i12;
        boolean z10 = Math.abs(gVar.b() - gVar.a()) % 2 == 1;
        int iB2 = gVar.b() - gVar.a();
        int i13 = -i10;
        for (int i14 = i13; i14 <= i10; i14 += 2) {
            if (i14 == i13 || (i14 != i10 && cVar.b(i14 + 1) > cVar.b(i14 - 1))) {
                iB = cVar.b(i14 + 1);
                i11 = iB;
            } else {
                iB = cVar.b(i14 - 1);
                i11 = iB + 1;
            }
            int i15 = (gVar.f1460c + (i11 - gVar.f1458a)) - i14;
            int i16 = (i10 == 0 || i11 != iB) ? i15 : i15 - 1;
            while (i11 < gVar.f1459b && i15 < gVar.f1461d && bVar.b(i11, i15)) {
                i11++;
                i15++;
            }
            cVar.c(i14, i11);
            if (z10 && (i12 = iB2 - i14) >= i13 + 1 && i12 <= i10 - 1 && cVar2.b(i12) <= i11) {
                h hVar = new h();
                hVar.f1462a = iB;
                hVar.f1463b = i16;
                hVar.f1464c = i11;
                hVar.f1465d = i15;
                hVar.f1466e = false;
                return hVar;
            }
        }
        return null;
    }

    public static h e(g gVar, b bVar, c cVar, c cVar2) {
        if (gVar.b() >= 1 && gVar.a() >= 1) {
            int iB = ((gVar.b() + gVar.a()) + 1) / 2;
            cVar.c(1, gVar.f1458a);
            cVar2.c(1, gVar.f1459b);
            for (int i10 = 0; i10 < iB; i10++) {
                h hVarD = d(gVar, bVar, cVar, cVar2, i10);
                if (hVarD != null) {
                    return hVarD;
                }
                h hVarA = a(gVar, bVar, cVar, cVar2, i10);
                if (hVarA != null) {
                    return hVarA;
                }
            }
        }
        return null;
    }
}
