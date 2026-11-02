package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements p.a {

    /* renamed from: a, reason: collision with root package name */
    public w.e f1368a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1369b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1370c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0020a f1371d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f1372e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1373f;

    /* renamed from: g, reason: collision with root package name */
    public final p f1374g;

    /* renamed from: h, reason: collision with root package name */
    public int f1375h;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0020a {
        void a(int i10, int i11);

        void b(b bVar);

        void c(int i10, int i11, Object obj);

        void d(b bVar);

        RecyclerView.c0 e(int i10);

        void f(int i10, int i11);

        void g(int i10, int i11);

        void h(int i10, int i11);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f1376a;

        /* renamed from: b, reason: collision with root package name */
        public int f1377b;

        /* renamed from: c, reason: collision with root package name */
        public Object f1378c;

        /* renamed from: d, reason: collision with root package name */
        public int f1379d;

        public b(int i10, int i11, int i12, Object obj) {
            this.f1376a = i10;
            this.f1377b = i11;
            this.f1379d = i12;
            this.f1378c = obj;
        }

        public String a() {
            int i10 = this.f1376a;
            return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f1376a;
            if (i10 != bVar.f1376a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f1379d - this.f1377b) == 1 && this.f1379d == bVar.f1377b && this.f1377b == bVar.f1379d) {
                return true;
            }
            if (this.f1379d != bVar.f1379d || this.f1377b != bVar.f1377b) {
                return false;
            }
            Object obj2 = this.f1378c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f1378c)) {
                    return false;
                }
            } else if (bVar.f1378c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1376a * 31) + this.f1377b) * 31) + this.f1379d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1377b + "c:" + this.f1379d + ",p:" + this.f1378c + "]";
        }
    }

    public a(InterfaceC0020a interfaceC0020a) {
        this(interfaceC0020a, false);
    }

    public a(InterfaceC0020a interfaceC0020a, boolean z10) {
        this.f1368a = new w.f(30);
        this.f1369b = new ArrayList();
        this.f1370c = new ArrayList();
        this.f1375h = 0;
        this.f1371d = interfaceC0020a;
        this.f1373f = z10;
        this.f1374g = new p(this);
    }

    @Override // androidx.recyclerview.widget.p.a
    public void a(b bVar) {
        if (this.f1373f) {
            return;
        }
        bVar.f1378c = null;
        this.f1368a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.p.a
    public b b(int i10, int i11, int i12, Object obj) {
        b bVar = (b) this.f1368a.b();
        if (bVar == null) {
            return new b(i10, i11, i12, obj);
        }
        bVar.f1376a = i10;
        bVar.f1377b = i11;
        bVar.f1379d = i12;
        bVar.f1378c = obj;
        return bVar;
    }

    public final void c(b bVar) {
        v(bVar);
    }

    public final void d(b bVar) {
        v(bVar);
    }

    public int e(int i10) {
        int size = this.f1369b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f1369b.get(i11);
            int i12 = bVar.f1376a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f1377b;
                    if (i13 <= i10) {
                        int i14 = bVar.f1379d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f1377b;
                    if (i15 == i10) {
                        i10 = bVar.f1379d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f1379d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f1377b <= i10) {
                i10 += bVar.f1379d;
            }
        }
        return i10;
    }

    public final void f(b bVar) {
        boolean z10;
        char c10;
        int i10 = bVar.f1377b;
        int i11 = bVar.f1379d + i10;
        char c11 = '\uffff';
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f1371d.e(i12) != null || h(i12)) {
                if (c11 == 0) {
                    k(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 1;
            } else {
                if (c11 == 1) {
                    v(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c11 = c10;
        }
        if (i13 != bVar.f1379d) {
            a(bVar);
            bVar = b(2, i10, i13, null);
        }
        if (c11 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final void g(b bVar) {
        int i10 = bVar.f1377b;
        int i11 = bVar.f1379d + i10;
        int i12 = i10;
        char c10 = '\uffff';
        int i13 = 0;
        while (i10 < i11) {
            if (this.f1371d.e(i10) != null || h(i10)) {
                if (c10 == 0) {
                    k(b(4, i12, i13, bVar.f1378c));
                    i12 = i10;
                    i13 = 0;
                }
                c10 = 1;
            } else {
                if (c10 == 1) {
                    v(b(4, i12, i13, bVar.f1378c));
                    i12 = i10;
                    i13 = 0;
                }
                c10 = 0;
            }
            i13++;
            i10++;
        }
        if (i13 != bVar.f1379d) {
            Object obj = bVar.f1378c;
            a(bVar);
            bVar = b(4, i12, i13, obj);
        }
        if (c10 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final boolean h(int i10) {
        int size = this.f1370c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f1370c.get(i11);
            int i12 = bVar.f1376a;
            if (i12 == 8) {
                if (n(bVar.f1379d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f1377b;
                int i14 = bVar.f1379d + i13;
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
        int size = this.f1370c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f1371d.d((b) this.f1370c.get(i10));
        }
        x(this.f1370c);
        this.f1375h = 0;
    }

    public void j() {
        i();
        int size = this.f1369b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f1369b.get(i10);
            int i11 = bVar.f1376a;
            if (i11 == 1) {
                this.f1371d.d(bVar);
                this.f1371d.g(bVar.f1377b, bVar.f1379d);
            } else if (i11 == 2) {
                this.f1371d.d(bVar);
                this.f1371d.h(bVar.f1377b, bVar.f1379d);
            } else if (i11 == 4) {
                this.f1371d.d(bVar);
                this.f1371d.c(bVar.f1377b, bVar.f1379d, bVar.f1378c);
            } else if (i11 == 8) {
                this.f1371d.d(bVar);
                this.f1371d.a(bVar.f1377b, bVar.f1379d);
            }
            Runnable runnable = this.f1372e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f1369b);
        this.f1375h = 0;
    }

    public final void k(b bVar) {
        int i10;
        int i11 = bVar.f1376a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iZ = z(bVar.f1377b, i11);
        int i12 = bVar.f1377b;
        int i13 = bVar.f1376a;
        if (i13 == 2) {
            i10 = 0;
        } else {
            if (i13 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i10 = 1;
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f1379d; i15++) {
            int iZ2 = z(bVar.f1377b + (i10 * i15), bVar.f1376a);
            int i16 = bVar.f1376a;
            if (i16 == 2 ? iZ2 != iZ : !(i16 == 4 && iZ2 == iZ + 1)) {
                b bVarB = b(i16, iZ, i14, bVar.f1378c);
                l(bVarB, i12);
                a(bVarB);
                if (bVar.f1376a == 4) {
                    i12 += i14;
                }
                iZ = iZ2;
                i14 = 1;
            } else {
                i14++;
            }
        }
        Object obj = bVar.f1378c;
        a(bVar);
        if (i14 > 0) {
            b bVarB2 = b(bVar.f1376a, iZ, i14, obj);
            l(bVarB2, i12);
            a(bVarB2);
        }
    }

    public void l(b bVar, int i10) {
        this.f1371d.b(bVar);
        int i11 = bVar.f1376a;
        if (i11 == 2) {
            this.f1371d.h(i10, bVar.f1379d);
        } else {
            if (i11 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f1371d.c(i10, bVar.f1379d, bVar.f1378c);
        }
    }

    public int m(int i10) {
        return n(i10, 0);
    }

    public int n(int i10, int i11) {
        int size = this.f1370c.size();
        while (i11 < size) {
            b bVar = (b) this.f1370c.get(i11);
            int i12 = bVar.f1376a;
            if (i12 == 8) {
                int i13 = bVar.f1377b;
                if (i13 == i10) {
                    i10 = bVar.f1379d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f1379d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f1377b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f1379d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f1379d;
                }
            }
            i11++;
        }
        return i10;
    }

    public boolean o(int i10) {
        return (i10 & this.f1375h) != 0;
    }

    public boolean p() {
        return this.f1369b.size() > 0;
    }

    public boolean q() {
        return (this.f1370c.isEmpty() || this.f1369b.isEmpty()) ? false : true;
    }

    public boolean r(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f1369b.add(b(4, i10, i11, obj));
        this.f1375h |= 4;
        return this.f1369b.size() == 1;
    }

    public boolean s(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f1369b.add(b(1, i10, i11, null));
        this.f1375h |= 1;
        return this.f1369b.size() == 1;
    }

    public boolean t(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f1369b.add(b(8, i10, i11, null));
        this.f1375h |= 8;
        return this.f1369b.size() == 1;
    }

    public boolean u(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f1369b.add(b(2, i10, i11, null));
        this.f1375h |= 2;
        return this.f1369b.size() == 1;
    }

    public final void v(b bVar) {
        this.f1370c.add(bVar);
        int i10 = bVar.f1376a;
        if (i10 == 1) {
            this.f1371d.g(bVar.f1377b, bVar.f1379d);
            return;
        }
        if (i10 == 2) {
            this.f1371d.f(bVar.f1377b, bVar.f1379d);
            return;
        }
        if (i10 == 4) {
            this.f1371d.c(bVar.f1377b, bVar.f1379d, bVar.f1378c);
        } else {
            if (i10 == 8) {
                this.f1371d.a(bVar.f1377b, bVar.f1379d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void w() {
        this.f1374g.b(this.f1369b);
        int size = this.f1369b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) this.f1369b.get(i10);
            int i11 = bVar.f1376a;
            if (i11 == 1) {
                c(bVar);
            } else if (i11 == 2) {
                f(bVar);
            } else if (i11 == 4) {
                g(bVar);
            } else if (i11 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f1372e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1369b.clear();
    }

    public void x(List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a((b) list.get(i10));
        }
        list.clear();
    }

    public void y() {
        x(this.f1369b);
        x(this.f1370c);
        this.f1375h = 0;
    }

    public final int z(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f1370c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f1370c.get(size);
            int i14 = bVar.f1376a;
            if (i14 == 8) {
                int i15 = bVar.f1377b;
                int i16 = bVar.f1379d;
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
                            bVar.f1377b = i15 + 1;
                            bVar.f1379d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f1377b = i15 - 1;
                            bVar.f1379d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f1379d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f1379d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f1377b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f1377b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f1377b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f1379d;
                    } else if (i14 == 2) {
                        i10 += bVar.f1379d;
                    }
                } else if (i11 == 1) {
                    bVar.f1377b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f1377b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f1370c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f1370c.get(size2);
            if (bVar2.f1376a == 8) {
                int i18 = bVar2.f1379d;
                if (i18 == bVar2.f1377b || i18 < 0) {
                    this.f1370c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f1379d <= 0) {
                this.f1370c.remove(size2);
                a(bVar2);
            }
        }
        return i10;
    }
}
