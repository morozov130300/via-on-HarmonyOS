package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: m, reason: collision with root package name */
    public static final ThreadLocal f1502m = new ThreadLocal();

    /* renamed from: n, reason: collision with root package name */
    public static Comparator f1503n = new a();

    /* renamed from: j, reason: collision with root package name */
    public long f1505j;

    /* renamed from: k, reason: collision with root package name */
    public long f1506k;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f1504e = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f1507l = new ArrayList();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f1515d;
            if ((recyclerView == null) != (cVar2.f1515d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = cVar.f1512a;
            if (z10 != cVar2.f1512a) {
                return z10 ? -1 : 1;
            }
            int i10 = cVar2.f1513b - cVar.f1513b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f1514c - cVar2.f1514c;
            if (i11 != 0) {
                return i11;
            }
            return 0;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b implements RecyclerView.o.c {

        /* renamed from: a, reason: collision with root package name */
        public int f1508a;

        /* renamed from: b, reason: collision with root package name */
        public int f1509b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f1510c;

        /* renamed from: d, reason: collision with root package name */
        public int f1511d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i11 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i12 = this.f1511d;
            int i13 = i12 * 2;
            int[] iArr = this.f1510c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f1510c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i13 >= iArr.length) {
                int[] iArr3 = new int[i12 * 4];
                this.f1510c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f1510c;
            iArr4[i13] = i10;
            iArr4[i13 + 1] = i11;
            this.f1511d++;
        }

        public void b() {
            int[] iArr = this.f1510c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1511d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z10) {
            this.f1511d = 0;
            int[] iArr = this.f1510c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f1192u;
            if (recyclerView.f1190t == null || oVar == null || !oVar.v0()) {
                return;
            }
            if (z10) {
                if (!recyclerView.f1174l.p()) {
                    oVar.q(recyclerView.f1190t.g(), this);
                }
            } else if (!recyclerView.s0()) {
                oVar.p(this.f1508a, this.f1509b, recyclerView.f1183p0, this);
            }
            int i10 = this.f1511d;
            if (i10 > oVar.f1265m) {
                oVar.f1265m = i10;
                oVar.f1266n = z10;
                recyclerView.f1170j.K();
            }
        }

        public boolean d(int i10) {
            if (this.f1510c != null) {
                int i11 = this.f1511d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f1510c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i10, int i11) {
            this.f1508a = i10;
            this.f1509b = i11;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1512a;

        /* renamed from: b, reason: collision with root package name */
        public int f1513b;

        /* renamed from: c, reason: collision with root package name */
        public int f1514c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f1515d;

        /* renamed from: e, reason: collision with root package name */
        public int f1516e;

        public void a() {
            this.f1512a = false;
            this.f1513b = 0;
            this.f1514c = 0;
            this.f1515d = null;
            this.f1516e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i10) {
        int iJ = recyclerView.f1176m.j();
        for (int i11 = 0; i11 < iJ; i11++) {
            RecyclerView.c0 c0VarL0 = RecyclerView.l0(recyclerView.f1176m.i(i11));
            if (c0VarL0.f1221c == i10 && !c0VarL0.v()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        this.f1504e.add(recyclerView);
    }

    public final void b() {
        c cVar;
        int size = this.f1504e.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = (RecyclerView) this.f1504e.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f1181o0.c(recyclerView, false);
                i10 += recyclerView.f1181o0.f1511d;
            }
        }
        this.f1507l.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f1504e.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f1181o0;
                int iAbs = Math.abs(bVar.f1508a) + Math.abs(bVar.f1509b);
                for (int i14 = 0; i14 < bVar.f1511d * 2; i14 += 2) {
                    if (i12 >= this.f1507l.size()) {
                        cVar = new c();
                        this.f1507l.add(cVar);
                    } else {
                        cVar = (c) this.f1507l.get(i12);
                    }
                    int[] iArr = bVar.f1510c;
                    int i15 = iArr[i14 + 1];
                    cVar.f1512a = i15 <= iAbs;
                    cVar.f1513b = iAbs;
                    cVar.f1514c = i15;
                    cVar.f1515d = recyclerView2;
                    cVar.f1516e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f1507l, f1503n);
    }

    public final void c(c cVar, long j10) {
        RecyclerView.c0 c0VarI = i(cVar.f1515d, cVar.f1516e, cVar.f1512a ? Long.MAX_VALUE : j10);
        if (c0VarI == null || c0VarI.f1220b == null || !c0VarI.u() || c0VarI.v()) {
            return;
        }
        h((RecyclerView) c0VarI.f1220b.get(), j10);
    }

    public final void d(long j10) {
        for (int i10 = 0; i10 < this.f1507l.size(); i10++) {
            c cVar = (c) this.f1507l.get(i10);
            if (cVar.f1515d == null) {
                return;
            }
            c(cVar, j10);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f1505j == 0) {
            this.f1505j = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f1181o0.e(i10, i11);
    }

    public void g(long j10) {
        b();
        d(j10);
    }

    public final void h(RecyclerView recyclerView, long j10) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.L && recyclerView.f1176m.j() != 0) {
            recyclerView.b1();
        }
        b bVar = recyclerView.f1181o0;
        bVar.c(recyclerView, true);
        if (bVar.f1511d != 0) {
            try {
                u.t.a("RV Nested Prefetch");
                recyclerView.f1183p0.f(recyclerView.f1190t);
                for (int i10 = 0; i10 < bVar.f1511d * 2; i10 += 2) {
                    i(recyclerView, bVar.f1510c[i10], j10);
                }
            } finally {
                u.t.b();
            }
        }
    }

    public final RecyclerView.c0 i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f1170j;
        try {
            recyclerView.N0();
            RecyclerView.c0 c0VarI = vVar.I(i10, false, j10);
            if (c0VarI != null) {
                if (!c0VarI.u() || c0VarI.v()) {
                    vVar.a(c0VarI, false);
                } else {
                    vVar.B(c0VarI.f1219a);
                }
            }
            recyclerView.P0(false);
            return c0VarI;
        } catch (Throwable th) {
            recyclerView.P0(false);
            throw th;
        }
    }

    public void j(RecyclerView recyclerView) {
        this.f1504e.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            u.t.a("RV Prefetch");
            if (!this.f1504e.isEmpty()) {
                int size = this.f1504e.size();
                long jMax = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = (RecyclerView) this.f1504e.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f1506k);
                }
            }
        } finally {
            this.f1505j = 0L;
            u.t.b();
        }
    }
}
