package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ThreadLocal f1403o = new ThreadLocal();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Comparator f1404p = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1406e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f1407m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f1405c = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f1408n = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f1416d;
            if ((recyclerView == null) != (cVar2.f1416d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = cVar.f1413a;
            if (z10 != cVar2.f1413a) {
                return z10 ? -1 : 1;
            }
            int i10 = cVar2.f1414b - cVar.f1414b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f1415c - cVar2.f1415c;
            if (i11 != 0) {
                return i11;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b implements RecyclerView.o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f1411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1412d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i11 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i12 = this.f1412d;
            int i13 = i12 * 2;
            int[] iArr = this.f1411c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f1411c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i13 >= iArr.length) {
                int[] iArr3 = new int[i12 * 4];
                this.f1411c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f1411c;
            iArr4[i13] = i10;
            iArr4[i13 + 1] = i11;
            this.f1412d++;
        }

        public void b() {
            int[] iArr = this.f1411c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1412d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z10) {
            this.f1412d = 0;
            int[] iArr = this.f1411c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f1097w;
            if (recyclerView.f1095v == null || oVar == null || !oVar.v0()) {
                return;
            }
            if (z10) {
                if (!recyclerView.f1079n.p()) {
                    oVar.q(recyclerView.f1095v.g(), this);
                }
            } else if (!recyclerView.s0()) {
                oVar.p(this.f1409a, this.f1410b, recyclerView.f1088r0, this);
            }
            int i10 = this.f1412d;
            if (i10 > oVar.f1183m) {
                oVar.f1183m = i10;
                oVar.f1184n = z10;
                recyclerView.f1068e.K();
            }
        }

        public boolean d(int i10) {
            if (this.f1411c != null) {
                int i11 = this.f1412d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f1411c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i10, int i11) {
            this.f1409a = i10;
            this.f1410b = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f1416d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1417e;

        public void a() {
            this.f1413a = false;
            this.f1414b = 0;
            this.f1415c = 0;
            this.f1416d = null;
            this.f1417e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i10) {
        int iJ = recyclerView.f1081o.j();
        for (int i11 = 0; i11 < iJ; i11++) {
            RecyclerView.d0 d0VarL0 = RecyclerView.l0(recyclerView.f1081o.i(i11));
            if (d0VarL0.f1140c == i10 && !d0VarL0.v()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        this.f1405c.add(recyclerView);
    }

    public final void b() {
        c cVar;
        int size = this.f1405c.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = (RecyclerView) this.f1405c.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f1086q0.c(recyclerView, false);
                i10 += recyclerView.f1086q0.f1412d;
            }
        }
        this.f1408n.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f1405c.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f1086q0;
                int iAbs = Math.abs(bVar.f1409a) + Math.abs(bVar.f1410b);
                for (int i14 = 0; i14 < bVar.f1412d * 2; i14 += 2) {
                    if (i12 >= this.f1408n.size()) {
                        cVar = new c();
                        this.f1408n.add(cVar);
                    } else {
                        cVar = (c) this.f1408n.get(i12);
                    }
                    int[] iArr = bVar.f1411c;
                    int i15 = iArr[i14 + 1];
                    cVar.f1413a = i15 <= iAbs;
                    cVar.f1414b = iAbs;
                    cVar.f1415c = i15;
                    cVar.f1416d = recyclerView2;
                    cVar.f1417e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f1408n, f1404p);
    }

    public final void c(c cVar, long j10) {
        RecyclerView.d0 d0VarI = i(cVar.f1416d, cVar.f1417e, cVar.f1413a ? Long.MAX_VALUE : j10);
        if (d0VarI == null || d0VarI.f1139b == null || !d0VarI.u() || d0VarI.v()) {
            return;
        }
        h((RecyclerView) d0VarI.f1139b.get(), j10);
    }

    public final void d(long j10) {
        for (int i10 = 0; i10 < this.f1408n.size(); i10++) {
            c cVar = (c) this.f1408n.get(i10);
            if (cVar.f1416d == null) {
                return;
            }
            c(cVar, j10);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f1406e == 0) {
            this.f1406e = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f1086q0.e(i10, i11);
    }

    public void g(long j10) {
        b();
        d(j10);
    }

    public final void h(RecyclerView recyclerView, long j10) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.N && recyclerView.f1081o.j() != 0) {
            recyclerView.b1();
        }
        b bVar = recyclerView.f1086q0;
        bVar.c(recyclerView, true);
        if (bVar.f1412d != 0) {
            try {
                v.t.a("RV Nested Prefetch");
                recyclerView.f1088r0.f(recyclerView.f1095v);
                for (int i10 = 0; i10 < bVar.f1412d * 2; i10 += 2) {
                    i(recyclerView, bVar.f1411c[i10], j10);
                }
                v.t.b();
            } catch (Throwable th) {
                v.t.b();
                throw th;
            }
        }
    }

    public final RecyclerView.d0 i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f1068e;
        try {
            recyclerView.N0();
            RecyclerView.d0 d0VarI = vVar.I(i10, false, j10);
            if (d0VarI != null) {
                if (!d0VarI.u() || d0VarI.v()) {
                    vVar.a(d0VarI, false);
                } else {
                    vVar.B(d0VarI.f1138a);
                }
            }
            return d0VarI;
        } finally {
            recyclerView.P0(false);
        }
    }

    public void j(RecyclerView recyclerView) {
        this.f1405c.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            v.t.a("RV Prefetch");
            if (!this.f1405c.isEmpty()) {
                int size = this.f1405c.size();
                long jMax = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = (RecyclerView) this.f1405c.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f1407m);
                }
            }
        } finally {
            this.f1406e = 0L;
            v.t.b();
        }
    }
}
