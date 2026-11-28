package sa;

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
import oa.k1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g0 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final qa.c f12244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ra.c f12246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12247i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12250l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12253o;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f12248j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f12249k = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f12251m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f12252n = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List f12254p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f12255q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f12256r = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List f12257s = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final i8.n f12258t = new i8.n();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s6.d f12259u = new s6.d();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final s6.d f12260v = new s6.d();

    public g0(k1 k1Var) {
        this.f12244f = k1Var.f();
    }

    public static /* synthetic */ void l(g0 g0Var, ra.c cVar) {
        g0Var.getClass();
        if (cVar != null) {
            g0Var.G(cVar.e());
        }
    }

    public static /* synthetic */ void m(g0 g0Var, Pair pair) {
        g0Var.getClass();
        Pair pair2 = (Pair) pair.first;
        g0Var.f12246h = (ra.c) pair2.first;
        ra.d dVar = (ra.d) pair2.second;
        g0Var.f12256r.clear();
        g0Var.f12257s.clear();
        if (dVar != null) {
            g0Var.f12253o = dVar.a();
            if (dVar.e() != null) {
                for (String str : dVar.e()) {
                    String strZ = g0Var.f12244f.z(str);
                    g0Var.f12256r.add(new a(str, strZ, g0Var.F(strZ)));
                }
                if (!g0Var.f12256r.isEmpty()) {
                    Collections.sort(g0Var.f12256r, new Comparator() { // from class: sa.d0
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return ((a) obj).b().compareTo(((a) obj2).b());
                        }
                    });
                }
            }
            for (String str2 : dVar.f().values()) {
                String strZ2 = g0Var.f12244f.z(str2);
                g0Var.f12257s.add(new a(str2, strZ2, g0Var.F(strZ2)));
            }
            Collections.sort(g0Var.f12257s, new Comparator() { // from class: sa.e0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ((a) obj).b().compareTo(((a) obj2).b());
                }
            });
        }
        Pair pair3 = (Pair) pair.second;
        g0Var.f12249k.clear();
        g0Var.f12248j.clear();
        g0Var.f12252n.clear();
        g0Var.f12251m.clear();
        Object obj = pair3.first;
        if (obj != null) {
            g0Var.f12247i = ((ra.e) obj).f();
            g0Var.f12249k.addAll(ua.c.b(((ra.e) pair3.first).e(), ((ra.e) pair3.first).d()));
            g0Var.f12248j.addAll(ua.c.b(((ra.e) pair3.first).b(), ((ra.e) pair3.first).c()));
        }
        Object obj2 = pair3.second;
        if (obj2 != null) {
            g0Var.f12250l = ((ra.e) obj2).f();
            g0Var.f12252n.addAll(ua.c.b(((ra.e) pair3.second).e(), ((ra.e) pair3.second).d()));
            g0Var.f12251m.addAll(ua.c.b(((ra.e) pair3.second).b(), ((ra.e) pair3.second).c()));
        }
        g0Var.J();
        g0Var.I();
    }

    public static /* synthetic */ void n(g0 g0Var, int i10, List list) {
        g0Var.getClass();
        List listSubList = list.subList(0, i10);
        List listSubList2 = list.subList(i10, list.size());
        if (g0Var.f12256r.equals(listSubList) && g0Var.f12257s.equals(listSubList2)) {
            return;
        }
        g0Var.f12256r.clear();
        g0Var.f12256r.addAll(listSubList);
        g0Var.f12257s.clear();
        g0Var.f12257s.addAll(listSubList2);
        g0Var.t();
    }

    public static /* synthetic */ Pair o(g0 g0Var, int i10) {
        ra.d dVarG = g0Var.f12244f.g(i10);
        return Pair.create(Pair.create(g0Var.f12244f.k(i10), dVarG), Pair.create(g0Var.f12244f.n(i10), g0Var.f12244f.o(i10)));
    }

    public List A() {
        return Collections.unmodifiableList(this.f12257s);
    }

    public int B() {
        return this.f12247i;
    }

    public ra.c C() {
        return this.f12246h;
    }

    public LiveData D() {
        return this.f12258t;
    }

    public int E() {
        return this.f12250l;
    }

    public final boolean F(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return new File(str).isFile();
    }

    public void G(final int i10) {
        this.f12260v.a(null);
        this.f12245g = i10;
        this.f12259u.a(((autodispose2.r) r6.q.f(new Callable() { // from class: sa.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return g0.o(this.f12234c, i10);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: sa.c0
            @Override // u6.f
            public final void accept(Object obj) {
                g0.m(this.f12237c, (Pair) obj);
            }
        }, new w7.e0()));
    }

    public void H(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f12260v.a(null);
        this.f12259u.a(((autodispose2.m) r6.f.h(new Callable() { // from class: sa.z
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12296c.f12244f.r(str);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.c(this))).a(new u6.f() { // from class: sa.a0
            @Override // u6.f
            public final void accept(Object obj) {
                g0.l(this.f12233c, (ra.c) obj);
            }
        }, new w7.e0()));
    }

    public final void I() {
        if (this.f12256r.isEmpty() && this.f12257s.isEmpty()) {
            return;
        }
        final int size = this.f12256r.size();
        ArrayList arrayList = new ArrayList(this.f12256r);
        arrayList.addAll(this.f12257s);
        this.f12260v.a(((autodispose2.n) f.c(arrayList).C(q6.b.b()).L(s8.b.c(this))).a(new u6.f() { // from class: sa.f0
            @Override // u6.f
            public final void accept(Object obj) {
                g0.n(this.f12242c, size, (List) obj);
            }
        }, new w7.e0()));
    }

    public final void J() {
        this.f12254p.clear();
        this.f12255q.clear();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (String str : this.f12248j) {
            if (!this.f12252n.contains(str) && !hashSet.contains(str)) {
                hashSet.add(str);
                this.f12255q.add(new i0(str, false, false));
            }
        }
        for (String str2 : this.f12251m) {
            if (!hashSet.contains(str2)) {
                hashSet.add(str2);
                this.f12255q.add(new i0(str2, false, true));
            }
        }
        for (String str3 : this.f12249k) {
            if (!hashSet.contains(str3) && !hashSet2.contains(str3)) {
                hashSet2.add(str3);
                this.f12254p.add(new i0(str3, true, false));
            }
        }
        for (String str4 : this.f12252n) {
            if (!hashSet2.contains(str4)) {
                hashSet2.add(str4);
                this.f12254p.add(new i0(str4, true, true));
            }
        }
        t();
    }

    public void K() {
        this.f12252n.clear();
        this.f12251m.clear();
        this.f12250l = 0;
        N();
        J();
    }

    public void L(int i10) {
        this.f12250l = i10;
        N();
        t();
    }

    public void M(i0 i0Var, String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty() || strTrim.equals(i0Var.a())) {
                return;
            }
            if (i0Var.c()) {
                this.f12252n.remove(i0Var.a());
                s(strTrim, true);
            } else {
                this.f12251m.remove(i0Var.a());
                s(strTrim, false);
            }
        }
    }

    public final void N() {
        ra.e eVar = new ra.e();
        int i10 = this.f12250l;
        if (i10 != this.f12247i && i10 != 0) {
            eVar.k(i10);
        }
        if (!this.f12252n.isEmpty()) {
            eVar.j(ua.c.d(this.f12252n));
        }
        if (!this.f12251m.isEmpty()) {
            eVar.g(ua.c.d(this.f12251m));
        }
        this.f12244f.m(this.f12245g, eVar);
    }

    public void s(String str, boolean z10) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            if (z10) {
                if (this.f12252n.contains(strTrim)) {
                    return;
                }
                this.f12251m.remove(strTrim);
                if (!this.f12249k.contains(strTrim)) {
                    this.f12252n.add(strTrim);
                }
            } else {
                if (this.f12251m.contains(strTrim)) {
                    return;
                }
                this.f12252n.remove(strTrim);
                if (!this.f12248j.contains(strTrim)) {
                    this.f12251m.add(strTrim);
                }
            }
            N();
            J();
        }
    }

    public final void t() {
        this.f12258t.o();
    }

    public void u(i0 i0Var) {
        if (!i0Var.b()) {
            s(i0Var.a(), !i0Var.c());
            return;
        }
        if (i0Var.c() && this.f12252n.contains(i0Var.a())) {
            this.f12252n.remove(i0Var.a());
        } else if (i0Var.c() || !this.f12251m.contains(i0Var.a())) {
            return;
        } else {
            this.f12251m.remove(i0Var.a());
        }
        N();
        J();
    }

    public boolean v(String str) {
        return this.f12244f.y(str);
    }

    public int w() {
        return this.f12253o;
    }

    public List x() {
        return Collections.unmodifiableList(this.f12255q);
    }

    public List y() {
        return Collections.unmodifiableList(this.f12254p);
    }

    public List z() {
        return Collections.unmodifiableList(this.f12256r);
    }
}
