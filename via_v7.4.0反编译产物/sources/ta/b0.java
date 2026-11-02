package ta;

import android.util.Pair;
import androidx.lifecycle.LiveData;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;
import x7.g0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b0 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final p5.c f12298f;

    /* renamed from: g, reason: collision with root package name */
    public int f12299g;

    /* renamed from: h, reason: collision with root package name */
    public r5.c f12300h;

    /* renamed from: i, reason: collision with root package name */
    public int f12301i;

    /* renamed from: l, reason: collision with root package name */
    public int f12304l;

    /* renamed from: o, reason: collision with root package name */
    public int f12307o;

    /* renamed from: j, reason: collision with root package name */
    public final List f12302j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final List f12303k = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final List f12305m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public final List f12306n = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public final List f12308p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public final List f12309q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    public final List f12310r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final List f12311s = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public final k8.n f12312t = new k8.n();

    public b0(n5.b bVar) {
        this.f12298f = bVar.d();
    }

    public static /* synthetic */ void l(b0 b0Var, Pair pair) {
        b0Var.getClass();
        Pair pair2 = (Pair) pair.first;
        b0Var.f12300h = (r5.c) pair2.first;
        r5.d dVar = (r5.d) pair2.second;
        if (dVar != null) {
            b0Var.f12307o = dVar.a() == null ? 0 : dVar.a().length();
            b0Var.f12310r.clear();
            if (dVar.e() != null) {
                for (String str : dVar.e()) {
                    String strY = b0Var.f12298f.y(str);
                    b0Var.f12310r.add(new a(str, strY, b0Var.E(strY)));
                }
                if (!b0Var.f12310r.isEmpty()) {
                    Collections.sort(b0Var.f12310r, new Comparator() { // from class: ta.z
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return ((a) obj).b().compareTo(((a) obj2).b());
                        }
                    });
                }
            }
            b0Var.f12311s.clear();
            if (dVar.f() != null) {
                int length = dVar.f().length;
                for (int i10 = 0; i10 < length; i10++) {
                    String str2 = dVar.f()[i10][1];
                    String strY2 = b0Var.f12298f.y(str2);
                    b0Var.f12311s.add(new a(str2, strY2, b0Var.E(strY2)));
                }
                if (!b0Var.f12311s.isEmpty()) {
                    Collections.sort(b0Var.f12311s, new Comparator() { // from class: ta.a0
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return ((a) obj).b().compareTo(((a) obj2).b());
                        }
                    });
                }
            }
        }
        Pair pair3 = (Pair) pair.second;
        b0Var.f12303k.clear();
        b0Var.f12302j.clear();
        b0Var.f12306n.clear();
        b0Var.f12305m.clear();
        Object obj = pair3.first;
        if (obj != null) {
            b0Var.f12301i = ((r5.e) obj).f();
            b0Var.f12303k.addAll(s5.e.b(((r5.e) pair3.first).e(), ((r5.e) pair3.first).d()));
            b0Var.f12302j.addAll(s5.e.b(((r5.e) pair3.first).b(), ((r5.e) pair3.first).c()));
        }
        Object obj2 = pair3.second;
        if (obj2 != null) {
            b0Var.f12304l = ((r5.e) obj2).f();
            b0Var.f12306n.addAll(s5.e.b(((r5.e) pair3.second).e(), ((r5.e) pair3.second).d()));
            b0Var.f12305m.addAll(s5.e.b(((r5.e) pair3.second).b(), ((r5.e) pair3.second).c()));
        }
        b0Var.H();
    }

    public static /* synthetic */ Pair n(b0 b0Var, int i10) {
        r5.d dVarZ = b0Var.f12298f.z(i10);
        return Pair.create(Pair.create(b0Var.f12298f.k(i10), dVarZ), Pair.create(b0Var.f12298f.m(i10), b0Var.f12298f.n(i10)));
    }

    public static /* synthetic */ void q(b0 b0Var, r5.c cVar) {
        b0Var.getClass();
        if (cVar != null) {
            b0Var.F(cVar.e());
        }
    }

    public int A() {
        return this.f12301i;
    }

    public r5.c B() {
        return this.f12300h;
    }

    public LiveData C() {
        return this.f12312t;
    }

    public int D() {
        return this.f12304l;
    }

    public final boolean E(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return new File(str).isFile();
    }

    public void F(final int i10) {
        this.f12299g = i10;
        ((autodispose2.r) x6.o.g(new Callable() { // from class: ta.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b0.n(this.f12351e, i10);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: ta.y
            @Override // a7.e
            public final void accept(Object obj) {
                b0.l(this.f12353e, (Pair) obj);
            }
        }, new g0());
    }

    public void G(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ((autodispose2.m) x6.f.h(new Callable() { // from class: ta.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12348e.f12298f.q(str);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.c(this))).a(new a7.e() { // from class: ta.w
            @Override // a7.e
            public final void accept(Object obj) {
                b0.q(this.f12350e, (r5.c) obj);
            }
        }, new g0());
    }

    public final void H() {
        this.f12308p.clear();
        this.f12309q.clear();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (String str : this.f12302j) {
            if (!this.f12306n.contains(str) && !hashSet.contains(str)) {
                hashSet.add(str);
                this.f12309q.add(new d0(str, false, false));
            }
        }
        for (String str2 : this.f12305m) {
            if (!hashSet.contains(str2)) {
                hashSet.add(str2);
                this.f12309q.add(new d0(str2, false, true));
            }
        }
        for (String str3 : this.f12303k) {
            if (!hashSet.contains(str3) && !hashSet2.contains(str3)) {
                hashSet2.add(str3);
                this.f12308p.add(new d0(str3, true, false));
            }
        }
        for (String str4 : this.f12306n) {
            if (!hashSet2.contains(str4)) {
                hashSet2.add(str4);
                this.f12308p.add(new d0(str4, true, true));
            }
        }
        s();
    }

    public void I() {
        this.f12306n.clear();
        this.f12305m.clear();
        this.f12304l = 0;
        L();
        H();
    }

    public void J(int i10) {
        this.f12304l = i10;
        L();
        s();
    }

    public void K(d0 d0Var, String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty() || strTrim.equals(d0Var.a())) {
                return;
            }
            if (d0Var.c()) {
                this.f12306n.remove(d0Var.a());
                r(strTrim, true);
            } else {
                this.f12305m.remove(d0Var.a());
                r(strTrim, false);
            }
        }
    }

    public final void L() {
        r5.e eVar = new r5.e();
        int i10 = this.f12304l;
        if (i10 != this.f12301i && i10 != 0) {
            eVar.k(i10);
        }
        if (!this.f12306n.isEmpty()) {
            eVar.j(s5.e.d(this.f12306n));
        }
        if (!this.f12305m.isEmpty()) {
            eVar.g(s5.e.d(this.f12305m));
        }
        this.f12298f.b(this.f12299g, eVar);
    }

    public void r(String str, boolean z10) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            if (z10) {
                if (this.f12306n.contains(strTrim)) {
                    return;
                }
                this.f12305m.remove(strTrim);
                if (!this.f12303k.contains(strTrim)) {
                    this.f12306n.add(strTrim);
                }
            } else {
                if (this.f12305m.contains(strTrim)) {
                    return;
                }
                this.f12306n.remove(strTrim);
                if (!this.f12302j.contains(strTrim)) {
                    this.f12305m.add(strTrim);
                }
            }
            L();
            H();
        }
    }

    public final void s() {
        this.f12312t.o();
    }

    public void t(d0 d0Var) {
        if (!d0Var.b()) {
            r(d0Var.a(), !d0Var.c());
            return;
        }
        if (d0Var.c() && this.f12306n.contains(d0Var.a())) {
            this.f12306n.remove(d0Var.a());
        } else if (d0Var.c() || !this.f12305m.contains(d0Var.a())) {
            return;
        } else {
            this.f12305m.remove(d0Var.a());
        }
        L();
        H();
    }

    public boolean u(String str) {
        return this.f12298f.x(str);
    }

    public int v() {
        return this.f12307o;
    }

    public List w() {
        return Collections.unmodifiableList(this.f12309q);
    }

    public List x() {
        return Collections.unmodifiableList(this.f12308p);
    }

    public List y() {
        return Collections.unmodifiableList(this.f12310r);
    }

    public List z() {
        return Collections.unmodifiableList(this.f12311s);
    }
}
