package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x.e f1269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0019a f1272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f1273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f1275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1276h;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0019a {
        void a(int i10, int i11);

        void b(b bVar);

        void c(int i10, int i11, Object obj);

        void d(b bVar);

        RecyclerView.d0 e(int i10);

        void f(int i10, int i11);

        void g(int i10, int i11);

        void h(int i10, int i11);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f1279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1280d;

        public b(int i10, int i11, int i12, Object obj) {
            this.f1277a = i10;
            this.f1278b = i11;
            this.f1280d = i12;
            this.f1279c = obj;
        }

        public String a() {
            int i10 = this.f1277a;
            if (i10 == 1) {
                return "add";
            }
            if (i10 == 2) {
                return "rm";
            }
            if (i10 != 4) {
                return i10 != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f1277a;
            if (i10 != bVar.f1277a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f1280d - this.f1278b) == 1 && this.f1280d == bVar.f1278b && this.f1278b == bVar.f1280d) {
                return true;
            }
            if (this.f1280d != bVar.f1280d || this.f1278b != bVar.f1278b) {
                return false;
            }
            Object obj2 = this.f1279c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f1279c)) {
                    return false;
                }
            } else if (bVar.f1279c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1277a * 31) + this.f1278b) * 31) + this.f1280d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1278b + "c:" + this.f1280d + ",p:" + this.f1279c + "]";
        }
    }

    public a(InterfaceC0019a interfaceC0019a) {
        this(interfaceC0019a, false);
    }

    @Override // androidx.recyclerview.widget.p.a
    public void a(b bVar) {
        if (this.f1274f) {
            return;
        }
        bVar.f1279c = null;
        this.f1269a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.p.a
    public b b(int i10, int i11, int i12, Object obj) {
        b bVar = (b) this.f1269a.b();
        if (bVar == null) {
            return new b(i10, i11, i12, obj);
        }
        bVar.f1277a = i10;
        bVar.f1278b = i11;
        bVar.f1280d = i12;
        bVar.f1279c = obj;
        return bVar;
    }

    public final void c(b bVar) {
        v(bVar);
    }

    public final void d(b bVar) {
        v(bVar);
    }

    public int e(int i10) {
        int size = this.f1270b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f1270b.get(i11);
            int i12 = bVar.f1277a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f1278b;
                    if (i13 <= i10) {
                        int i14 = bVar.f1280d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f1278b;
                    if (i15 == i10) {
                        i10 = bVar.f1280d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f1280d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f1278b <= i10) {
                i10 += bVar.f1280d;
            }
        }
        return i10;
    }

    public final void f(b bVar) {
        boolean z10;
        byte b10;
        int i10 = bVar.f1278b;
        int i11 = bVar.f1280d + i10;
        byte b11 = -1;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f1272d.e(i12) != null || h(i12)) {
                if (b11 == 0) {
                    k(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                b10 = 1;
            } else {
                if (b11 == 1) {
                    v(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                b10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            b11 = b10;
        }
        if (i13 != bVar.f1280d) {
            a(bVar);
            bVar = b(2, i10, i13, null);
        }
        if (b11 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final void g(b bVar) {
        int i10 = bVar.f1278b;
        int i11 = bVar.f1280d + i10;
        int i12 = i10;
        byte b10 = -1;
        int i13 = 0;
        while (i10 < i11) {
            if (this.f1272d.e(i10) != null || h(i10)) {
                if (b10 == 0) {
                    k(b(4, i12, i13, bVar.f1279c));
                    i12 = i10;
                    i13 = 0;
                }
                b10 = 1;
            } else {
                if (b10 == 1) {
                    v(b(4, i12, i13, bVar.f1279c));
                    i12 = i10;
                    i13 = 0;
                }
                b10 = 0;
            }
            i13++;
            i10++;
        }
        if (i13 != bVar.f1280d) {
            Object obj = bVar.f1279c;
            a(bVar);
            bVar = b(4, i12, i13, obj);
        }
        if (b10 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final boolean h(int i10) {
        int size = this.f1271c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f1271c.get(i11);
            int i12 = bVar.f1277a;
            if (i12 == 8) {
                if (n(bVar.f1280d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f1278b;
                int i14 = bVar.f1280d + i13;
                while (i13 < i14) {
                    if (n(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void i() {
        int size = this.f1271c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f1272d.d((b) this.f1271c.get(i10));
        }
        x(this.f1271c);
        this.f1276h = 0;
    }

    public void j() {
        i();
        int size = this.f1270b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f1270b.get(i10);
            int i11 = bVar.f1277a;
            if (i11 == 1) {
                this.f1272d.d(bVar);
                this.f1272d.g(bVar.f1278b, bVar.f1280d);
            } else if (i11 == 2) {
                this.f1272d.d(bVar);
                this.f1272d.h(bVar.f1278b, bVar.f1280d);
            } else if (i11 == 4) {
                this.f1272d.d(bVar);
                this.f1272d.c(bVar.f1278b, bVar.f1280d, bVar.f1279c);
            } else if (i11 == 8) {
                this.f1272d.d(bVar);
                this.f1272d.a(bVar.f1278b, bVar.f1280d);
            }
            Runnable runnable = this.f1273e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f1270b);
        this.f1276h = 0;
    }

    public final void k(b bVar) {
        int i10;
        int i11 = bVar.f1277a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iZ = z(bVar.f1278b, i11);
        int i12 = bVar.f1278b;
        int i13 = bVar.f1277a;
        if (i13 == 2) {
            i10 = 0;
        } else {
            if (i13 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i10 = 1;
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f1280d; i15++) {
            int iZ2 = z(bVar.f1278b + (i10 * i15), bVar.f1277a);
            int i16 = bVar.f1277a;
            if (i16 == 2 ? iZ2 != iZ : !(i16 == 4 && iZ2 == iZ + 1)) {
                b bVarB = b(i16, iZ, i14, bVar.f1279c);
                l(bVarB, i12);
                a(bVarB);
                if (bVar.f1277a == 4) {
                    i12 += i14;
                }
                iZ = iZ2;
                i14 = 1;
            } else {
                i14++;
            }
        }
        Object obj = bVar.f1279c;
        a(bVar);
        if (i14 > 0) {
            b bVarB2 = b(bVar.f1277a, iZ, i14, obj);
            l(bVarB2, i12);
            a(bVarB2);
        }
    }

    public void l(b bVar, int i10) {
        this.f1272d.b(bVar);
        int i11 = bVar.f1277a;
        if (i11 == 2) {
            this.f1272d.h(i10, bVar.f1280d);
        } else {
            if (i11 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f1272d.c(i10, bVar.f1280d, bVar.f1279c);
        }
    }

    public int m(int i10) {
        return n(i10, 0);
    }

    public int n(int i10, int i11) {
        int size = this.f1271c.size();
        while (i11 < size) {
            b bVar = (b) this.f1271c.get(i11);
            int i12 = bVar.f1277a;
            if (i12 == 8) {
                int i13 = bVar.f1278b;
                if (i13 == i10) {
                    i10 = bVar.f1280d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f1280d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f1278b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f1280d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f1280d;
                }
            }
            i11++;
        }
        return i10;
    }

    public boolean o(int i10) {
        return (i10 & this.f1276h) != 0;
    }

    public boolean p() {
        return this.f1270b.size() > 0;
    }

    public boolean q() {
        return (this.f1271c.isEmpty() || this.f1270b.isEmpty()) ? false : true;
    }

    public boolean r(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f1270b.add(b(4, i10, i11, obj));
        this.f1276h |= 4;
        return this.f1270b.size() == 1;
    }

    public boolean s(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f1270b.add(b(1, i10, i11, null));
        this.f1276h |= 1;
        return this.f1270b.size() == 1;
    }

    public boolean t(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f1270b.add(b(8, i10, i11, null));
        this.f1276h |= 8;
        return this.f1270b.size() == 1;
    }

    public boolean u(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f1270b.add(b(2, i10, i11, null));
        this.f1276h |= 2;
        return this.f1270b.size() == 1;
    }

    public final void v(b bVar) {
        this.f1271c.add(bVar);
        int i10 = bVar.f1277a;
        if (i10 == 1) {
            this.f1272d.g(bVar.f1278b, bVar.f1280d);
            return;
        }
        if (i10 == 2) {
            this.f1272d.f(bVar.f1278b, bVar.f1280d);
            return;
        }
        if (i10 == 4) {
            this.f1272d.c(bVar.f1278b, bVar.f1280d, bVar.f1279c);
        } else {
            if (i10 == 8) {
                this.f1272d.a(bVar.f1278b, bVar.f1280d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void w() {
        this.f1275g.b(this.f1270b);
        int size = this.f1270b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f1270b.get(i10);
            int i11 = bVar.f1277a;
            if (i11 == 1) {
                c(bVar);
            } else if (i11 == 2) {
                f(bVar);
            } else if (i11 == 4) {
                g(bVar);
            } else if (i11 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f1273e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1270b.clear();
    }

    public void x(List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a((b) list.get(i10));
        }
        list.clear();
    }

    public void y() {
        x(this.f1270b);
        x(this.f1271c);
        this.f1276h = 0;
    }

    public final int z(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f1271c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f1271c.get(size);
            int i14 = bVar.f1277a;
            if (i14 == 8) {
                int i15 = bVar.f1278b;
                int i16 = bVar.f1280d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            bVar.f1278b = i15 + 1;
                            bVar.f1280d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f1278b = i15 - 1;
                            bVar.f1280d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f1280d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f1280d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f1278b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f1278b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f1278b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f1280d;
                    } else if (i14 == 2) {
                        i10 += bVar.f1280d;
                    }
                } else if (i11 == 1) {
                    bVar.f1278b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f1278b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f1271c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f1271c.get(size2);
            if (bVar2.f1277a == 8) {
                int i18 = bVar2.f1280d;
                if (i18 == bVar2.f1278b || i18 < 0) {
                    this.f1271c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f1280d <= 0) {
                this.f1271c.remove(size2);
                a(bVar2);
            }
        }
        return i10;
    }

    public a(InterfaceC0019a interfaceC0019a, boolean z10) {
        this.f1269a = new x.f(30);
        this.f1270b = new ArrayList();
        this.f1271c = new ArrayList();
        this.f1276h = 0;
        this.f1272d = interfaceC0019a;
        this.f1274f = z10;
        this.f1275g = new p(this);
    }
}
