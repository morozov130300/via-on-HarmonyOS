package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator f1343a = new a();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return dVar.f1346a - dVar2.f1346a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class b {
        public abstract boolean a(int i10, int i11);

        public abstract boolean b(int i10, int i11);

        public Object c(int i10, int i11) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f1344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1345b;

        public c(int i10) {
            int[] iArr = new int[i10];
            this.f1344a = iArr;
            this.f1345b = iArr.length / 2;
        }

        public int[] a() {
            return this.f1344a;
        }

        public int b(int i10) {
            return this.f1344a[i10 + this.f1345b];
        }

        public void c(int i10, int i11) {
            this.f1344a[i10 + this.f1345b] = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1348c;

        public d(int i10, int i11, int i12) {
            this.f1346a = i10;
            this.f1347b = i11;
            this.f1348c = i12;
        }

        public int a() {
            return this.f1346a + this.f1348c;
        }

        public int b() {
            return this.f1347b + this.f1348c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f1349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f1350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f1351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f1352d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1353e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f1354f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f1355g;

        public e(b bVar, List list, int[] iArr, int[] iArr2, boolean z10) {
            this.f1349a = list;
            this.f1350b = iArr;
            this.f1351c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f1352d = bVar;
            this.f1353e = bVar.e();
            this.f1354f = bVar.d();
            this.f1355g = z10;
            a();
            e();
        }

        public static C0021f g(Collection collection, int i10, boolean z10) {
            C0021f c0021f;
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0021f = null;
                    break;
                }
                c0021f = (C0021f) it.next();
                if (c0021f.f1356a == i10 && c0021f.f1358c == z10) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                C0021f c0021f2 = (C0021f) it.next();
                if (z10) {
                    c0021f2.f1357b--;
                } else {
                    c0021f2.f1357b++;
                }
            }
            return c0021f;
        }

        public final void a() {
            d dVar = this.f1349a.isEmpty() ? null : (d) this.f1349a.get(0);
            if (dVar == null || dVar.f1346a != 0 || dVar.f1347b != 0) {
                this.f1349a.add(0, new d(0, 0, 0));
            }
            this.f1349a.add(new d(this.f1353e, this.f1354f, 0));
        }

        public void b(o oVar) {
            int i10;
            androidx.recyclerview.widget.c cVar = oVar instanceof androidx.recyclerview.widget.c ? (androidx.recyclerview.widget.c) oVar : new androidx.recyclerview.widget.c(oVar);
            int i11 = this.f1353e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i12 = this.f1353e;
            int i13 = this.f1354f;
            for (int size = this.f1349a.size() - 1; size >= 0; size--) {
                d dVar = (d) this.f1349a.get(size);
                int iA = dVar.a();
                int iB = dVar.b();
                while (true) {
                    if (i12 <= iA) {
                        break;
                    }
                    i12--;
                    int i14 = this.f1350b[i12];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        C0021f c0021fG = g(arrayDeque, i15, false);
                        if (c0021fG != null) {
                            int i16 = (i11 - c0021fG.f1357b) - 1;
                            cVar.a(i12, i16);
                            if ((i14 & 4) != 0) {
                                cVar.d(i16, 1, this.f1352d.c(i12, i15));
                            }
                        } else {
                            arrayDeque.add(new C0021f(i12, (i11 - i12) - 1, true));
                        }
                    } else {
                        cVar.c(i12, 1);
                        i11--;
                    }
                }
                while (i13 > iB) {
                    i13--;
                    int i17 = this.f1351c[i13];
                    if ((i17 & 12) != 0) {
                        int i18 = i17 >> 4;
                        C0021f c0021fG2 = g(arrayDeque, i18, true);
                        if (c0021fG2 == null) {
                            arrayDeque.add(new C0021f(i13, i11 - i12, false));
                        } else {
                            cVar.a((i11 - c0021fG2.f1357b) - 1, i12);
                            if ((i17 & 4) != 0) {
                                cVar.d(i12, 1, this.f1352d.c(i18, i13));
                            }
                        }
                    } else {
                        cVar.b(i12, 1);
                        i11++;
                    }
                }
                int i19 = dVar.f1346a;
                int i20 = dVar.f1347b;
                for (i10 = 0; i10 < dVar.f1348c; i10++) {
                    if ((this.f1350b[i19] & 15) == 2) {
                        cVar.d(i19, 1, this.f1352d.c(i19, i20));
                    }
                    i19++;
                    i20++;
                }
                i12 = dVar.f1346a;
                i13 = dVar.f1347b;
            }
            cVar.e();
        }

        public void c(RecyclerView.Adapter adapter) {
            b(new androidx.recyclerview.widget.b(adapter));
        }

        public final void d(int i10) {
            int size = this.f1349a.size();
            int iB = 0;
            for (int i11 = 0; i11 < size; i11++) {
                d dVar = (d) this.f1349a.get(i11);
                while (iB < dVar.f1347b) {
                    if (this.f1351c[iB] == 0 && this.f1352d.b(i10, iB)) {
                        int i12 = this.f1352d.a(i10, iB) ? 8 : 4;
                        this.f1350b[i10] = (iB << 4) | i12;
                        this.f1351c[iB] = (i10 << 4) | i12;
                        return;
                    }
                    iB++;
                }
                iB = dVar.b();
            }
        }

        public final void e() {
            for (d dVar : this.f1349a) {
                for (int i10 = 0; i10 < dVar.f1348c; i10++) {
                    int i11 = dVar.f1346a + i10;
                    int i12 = dVar.f1347b + i10;
                    int i13 = this.f1352d.a(i11, i12) ? 1 : 2;
                    this.f1350b[i11] = (i12 << 4) | i13;
                    this.f1351c[i12] = (i11 << 4) | i13;
                }
            }
            if (this.f1355g) {
                f();
            }
        }

        public final void f() {
            int iA = 0;
            for (d dVar : this.f1349a) {
                while (iA < dVar.f1346a) {
                    if (this.f1350b[iA] == 0) {
                        d(iA);
                    }
                    iA++;
                }
                iA = dVar.a();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0021f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1358c;

        public C0021f(int i10, int i11, boolean z10) {
            this.f1356a = i10;
            this.f1357b = i11;
            this.f1358c = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1362d;

        public g() {
        }

        public int a() {
            return this.f1362d - this.f1361c;
        }

        public int b() {
            return this.f1360b - this.f1359a;
        }

        public g(int i10, int i11, int i12, int i13) {
            this.f1359a = i10;
            this.f1360b = i11;
            this.f1361c = i12;
            this.f1362d = i13;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1365c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1366d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1367e;

        public int a() {
            return Math.min(this.f1365c - this.f1363a, this.f1366d - this.f1364b);
        }

        public boolean b() {
            return this.f1366d - this.f1364b != this.f1365c - this.f1363a;
        }

        public boolean c() {
            return this.f1366d - this.f1364b > this.f1365c - this.f1363a;
        }

        public d d() {
            if (!b()) {
                int i10 = this.f1363a;
                return new d(i10, this.f1364b, this.f1365c - i10);
            }
            if (this.f1367e) {
                return new d(this.f1363a, this.f1364b, a());
            }
            return c() ? new d(this.f1363a, this.f1364b + 1, a()) : new d(this.f1363a + 1, this.f1364b, a());
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
            int i15 = gVar.f1362d - ((gVar.f1360b - i11) - i14);
            int i16 = (i10 == 0 || i11 != iB) ? i15 : i15 + 1;
            while (i11 > gVar.f1359a && i15 > gVar.f1361c && bVar.b(i11 - 1, i15 - 1)) {
                i11--;
                i15--;
            }
            cVar2.c(i14, i11);
            if (z10 && (i12 = iB2 - i14) >= i13 && i12 <= i10 && cVar.b(i12) >= i11) {
                h hVar = new h();
                hVar.f1363a = i11;
                hVar.f1364b = i15;
                hVar.f1365c = iB;
                hVar.f1366d = i16;
                hVar.f1367e = true;
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
                gVar2.f1359a = gVar.f1359a;
                gVar2.f1361c = gVar.f1361c;
                gVar2.f1360b = hVarE.f1363a;
                gVar2.f1362d = hVarE.f1364b;
                arrayList2.add(gVar2);
                gVar.f1360b = gVar.f1360b;
                gVar.f1362d = gVar.f1362d;
                gVar.f1359a = hVarE.f1365c;
                gVar.f1361c = hVarE.f1366d;
                arrayList2.add(gVar);
            } else {
                arrayList3.add(gVar);
            }
        }
        Collections.sort(arrayList, f1343a);
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
            int i15 = (gVar.f1361c + (i11 - gVar.f1359a)) - i14;
            int i16 = (i10 == 0 || i11 != iB) ? i15 : i15 - 1;
            while (i11 < gVar.f1360b && i15 < gVar.f1362d && bVar.b(i11, i15)) {
                i11++;
                i15++;
            }
            cVar.c(i14, i11);
            if (z10 && (i12 = iB2 - i14) >= i13 + 1 && i12 <= i10 - 1 && cVar2.b(i12) <= i11) {
                h hVar = new h();
                hVar.f1363a = iB;
                hVar.f1364b = i16;
                hVar.f1365c = i11;
                hVar.f1366d = i15;
                hVar.f1367e = false;
                return hVar;
            }
        }
        return null;
    }

    public static h e(g gVar, b bVar, c cVar, c cVar2) {
        if (gVar.b() >= 1 && gVar.a() >= 1) {
            int iB = ((gVar.b() + gVar.a()) + 1) / 2;
            cVar.c(1, gVar.f1359a);
            cVar2.c(1, gVar.f1360b);
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
