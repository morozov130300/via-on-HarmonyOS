package y7;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import c6.a2;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.settings.search.SettingsSearchLocator;
import x8.c1;
import x8.s1;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t0 extends m8.f {
    public u9.l A0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public List f14918u0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public t5.f f14920w0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public u4.a f14923z0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final Map f14919v0 = new HashMap();

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f14921x0 = false;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f14922y0 = false;

    public static /* synthetic */ void B3(final t0 t0Var, Map map, List list) {
        t0Var.f14918u0 = list;
        t0Var.f14919v0.putAll(map);
        t0Var.N3(t0Var.D3());
        com.tuyafeng.support.widget.e0 e0Var = (com.tuyafeng.support.widget.e0) t0Var.f7947o0.findViewById(v3.f14644a);
        e0Var.c(com.tuyafeng.support.widget.e0.b.a(lb.g.a(t0Var.G(), w7.o.f13810m, w7.u.ge), t0Var.X0(w7.u.O)), new View.OnClickListener() { // from class: y7.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14940a.C3();
            }
        });
        e0Var.c(new com.tuyafeng.support.widget.e0.b(com.tuyafeng.support.utils.x.l(), 0, null, t0Var.X0(w7.u.Bh)), new View.OnClickListener() { // from class: y7.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14861a.O3();
            }
        });
    }

    public static List F3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, t0.class, w7.u.Fc, w7.u.G1, w7.u.O5);
        hVar.b(2, w7.u.Dh, new String[0]);
        return hVar.f();
    }

    private void I3() {
        final Context contextG = G();
        final HashMap map = new HashMap();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y7.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t0.w3(this.f14930c, contextG, map);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.b(b1(), Lifecycle.Event.ON_DESTROY))).a(new u6.f() { // from class: y7.y
            @Override // u6.f
            public final void accept(Object obj) {
                t0.B3(this.f14934c, map, (List) obj);
            }
        }, new w7.a0());
    }

    private void N3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new ib.h(this.f14920w0.H(), list));
        this.f14920w0.M(list);
        eVarB.c(this.f14920w0);
        d3(list.isEmpty());
    }

    public static /* synthetic */ Long f3(w4.c cVar, String str) throws Throwable {
        if (!b5.c.d(cVar.g(), str)) {
            return -1L;
        }
        b5.c.c(cVar);
        return Long.valueOf(c1.u(str));
    }

    public static /* synthetic */ void g3(t0 t0Var, AdapterView adapterView, View view, int i10, long j10) {
        t0Var.A0.E("filter_subscriptions", new int[]{0, 1, 3, 7, 15}[i10] * 86400000);
        t0Var.N3(t0Var.D3());
    }

    public static /* synthetic */ void h3(t0 t0Var, w4.c cVar, View view, q5.k.p pVar) {
        t0Var.getClass();
        int iH3 = t0Var.H3(cVar.g());
        if (iH3 < 0) {
            return;
        }
        t0Var.f14918u0.remove(iH3);
        c1.g(cVar.a());
        t0Var.f14921x0 = true;
        t0Var.N3(t0Var.D3());
    }

    public static /* synthetic */ void i3(t0 t0Var, w4.c cVar, w4.c cVar2, String str, Long l10) {
        t0Var.getClass();
        cVar.o(cVar2.f());
        cVar.l(cVar2.b());
        cVar.m(cVar2.d());
        cVar.n(cVar2.e());
        t0Var.f14919v0.put(str, l10);
    }

    public static /* synthetic */ void j3(final t0 t0Var, final w4.c cVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        t0Var.getClass();
        if (i11 == 0) {
            FragmentUtils.j(t0Var, y0.class, y0.h3(cVar.a(), cVar.f()));
            return;
        }
        if (i11 == 1) {
            com.tuyafeng.support.utils.n.q(t0Var.G(), w7.u.Gh);
            ((autodispose2.n) t0Var.P3(cVar).L(s8.b.a(t0Var.b1()))).a(new u6.f() { // from class: y7.e0
                @Override // u6.f
                public final void accept(Object obj) {
                    t0.o3(this.f14877c, (Long) obj);
                }
            }, new w7.a0());
        } else if (i11 == 2) {
            t0Var.E3(i10, cVar);
        } else if (i11 == 3) {
            com.tuyafeng.support.utils.n.a(t0Var.G(), cVar.g(), w7.u.Fg);
        } else {
            if (i11 != 4) {
                return;
            }
            com.tuyafeng.support.utils.n.f(t0Var.G(), w7.u.f14298y, t0Var.Y0(w7.u.f14222s3, cVar.f() != null ? cVar.f() : a2.f1958a.g(cVar.g())), new q5.k.m() { // from class: y7.f0
                @Override // q5.k.m
                public final void a(View view2, q5.k.p pVar) {
                    t0.h3(this.f14878a, cVar, view2, pVar);
                }
            });
        }
    }

    public static /* synthetic */ void l3(t0 t0Var, w4.c cVar, boolean z10, View view, q5.k.p pVar) {
        t0Var.getClass();
        String str = pVar.f11819c[0];
        a2 a2Var = a2.f1958a;
        if (!a2Var.u(str)) {
            com.tuyafeng.support.utils.n.q(t0Var.G(), w7.u.Oh);
            return;
        }
        String strG = cVar == null ? null : cVar.g();
        String strW = a2Var.w(str, null);
        if (t0Var.H3(strW) >= 0) {
            com.tuyafeng.support.utils.n.q(t0Var.G(), w7.u.M5);
            return;
        }
        int iH3 = t0Var.H3(strG);
        if (z10) {
            cVar = new w4.c();
            cVar.k(c1.z(t0Var.G(), UUID.randomUUID() + ".txt"));
        }
        cVar.p(strW);
        if (iH3 < 0) {
            t0Var.f14918u0.add(cVar);
        } else {
            t0Var.f14918u0.set(iH3, cVar);
        }
        t0Var.N3(t0Var.D3());
        t0Var.f14921x0 = true;
    }

    public static /* synthetic */ void m3(t0 t0Var, Long l10) {
        t0Var.f14921x0 = true;
        t0Var.N3(t0Var.D3());
    }

    public static /* synthetic */ void o3(t0 t0Var, Long l10) {
        t0Var.f14921x0 = true;
        t0Var.N3(t0Var.D3());
    }

    public static /* synthetic */ void p3(t0 t0Var, View view, int i10, v5.q qVar) {
        t0Var.getClass();
        if (qVar.c() == 1) {
            t0Var.O3();
        } else {
            t0Var.M3(qVar, i10);
        }
    }

    public static /* synthetic */ boolean r3(t0 t0Var, w4.c cVar) {
        return !t0Var.f14918u0.contains(cVar);
    }

    public static /* synthetic */ void s3(t0 t0Var, int i10, List list, AdapterView adapterView, View view, int i11, long j10) {
        if (i11 >= i10) {
            t0Var.E3(-1, null);
            return;
        }
        t0Var.f14918u0.add((w4.c) list.get(i11));
        t0Var.N3(t0Var.D3());
        t0Var.f14921x0 = true;
    }

    public static /* synthetic */ void t3(final t0 t0Var, final List list) {
        t0Var.getClass();
        final int size = list.size();
        if (size == 0) {
            t0Var.E3(-1, null);
            return;
        }
        String[] strArr = new String[size + 1];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = ((w4.c) list.get(i10)).f();
        }
        strArr[size] = t0Var.X0(w7.u.f13970a3);
        q5.k.l(t0Var.G()).f0(w7.u.f14247u0).G(strArr, new AdapterView.OnItemClickListener() { // from class: y7.k0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                t0.s3(this.f14893a, size, list, adapterView, view, i11, j10);
            }
        }).h0();
    }

    public static /* synthetic */ void u3(t0 t0Var) {
        if (t0Var.f14921x0) {
            com.tuyafeng.support.utils.n.q(t0Var.G(), w7.u.Ch);
        }
        t0Var.L3();
    }

    public static /* synthetic */ List w3(t0 t0Var, Context context, Map map) {
        List listB = t0Var.f14923z0.g() ? b5.d.b(c1.H(context), s1.b(context)) : t0Var.f14923z0.f();
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            String strA = ((w4.c) it.next()).a();
            map.put(strA, Long.valueOf(c1.u(strA)));
        }
        return listB;
    }

    public static /* synthetic */ boolean y3(t0 t0Var, w4.c cVar, w4.c cVar2, Long l10) {
        int iH3;
        t0Var.getClass();
        return l10.longValue() >= 0 && (iH3 = t0Var.H3(cVar.g())) >= 0 && t0Var.f14918u0.get(iH3) == cVar2;
    }

    public final void C3() {
        ((autodispose2.r) r6.j.w(b5.d.b(c1.H(G()), s1.b(G()))).p(new u6.i() { // from class: y7.i0
            @Override // u6.i
            public final boolean test(Object obj) {
                return t0.r3(this.f14889c, (w4.c) obj);
            }
        }).M().l(s8.b.a(b1()))).a(new u6.f() { // from class: y7.j0
            @Override // u6.f
            public final void accept(Object obj) {
                t0.t3(this.f14891c, (List) obj);
            }
        }, new w7.a0());
    }

    public final List D3() {
        ArrayList arrayList = new ArrayList();
        if (this.f14918u0.size() > 0) {
            arrayList.add(0, new v5.q(2, X0(w7.u.Dh), com.tuyafeng.support.utils.e.c(G(), w7.j.f13718i, G3())));
            arrayList.add(1, new v5.l(X0(w7.u.O5)));
        }
        arrayList.addAll(this.f14918u0);
        return arrayList;
    }

    public final void E3(int i10, final w4.c cVar) {
        final boolean z10 = i10 < 0 || cVar == null;
        q5.k.l(G()).f0(z10 ? w7.u.f14247u0 : w7.u.f14316z4).f(1, z10 ? "https://" : cVar.g(), w7.u.f14305y6, 3).v(false).X(R.string.ok, new q5.k.m() { // from class: y7.g0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                t0.l3(this.f14881a, cVar, z10, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final int G3() {
        long jA = this.A0.A("filter_subscriptions");
        int[] iArr = {0, 1, 3, 7, 15};
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            if (jA >= iArr[i11] * 86400000) {
                i10 = i11;
            }
        }
        return i10;
    }

    public final int H3(String str) {
        if (str != null && !str.isEmpty()) {
            int size = this.f14918u0.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (str.equalsIgnoreCase(((w4.c) this.f14918u0.get(i10)).g())) {
                    return i10;
                }
            }
        }
        return -1;
    }

    public final void J3(View view, int i10, w4.c cVar) {
        this.f14921x0 = true;
        cVar.j(true ^ cVar.h());
        this.f14920w0.m(i10);
    }

    public final boolean K3(View view, final int i10, final w4.c cVar) {
        q5.k.l(G()).G(new String[]{X0(w7.u.X), X0(w7.u.Bh), X0(w7.u.E), X0(w7.u.f14218s), X0(w7.u.f14298y)}, new AdapterView.OnItemClickListener() { // from class: y7.n0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                t0.j3(this.f14903a, cVar, i10, adapterView, view2, i11, j10);
            }
        }).j0(view);
        return false;
    }

    public final void L3() {
        if (this.f14921x0) {
            this.f14921x0 = false;
            final ArrayList arrayList = new ArrayList(this.f14918u0.size());
            Iterator it = this.f14918u0.iterator();
            while (it.hasNext()) {
                arrayList.add(new w4.c((w4.c) it.next()));
            }
            x8.h.b(new Runnable() { // from class: y7.m0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14900c.f14923z0.q(arrayList);
                }
            });
        }
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        L3();
        super.M1();
    }

    public final void M3(v5.q qVar, int i10) {
        q5.k.l(G()).f0(w7.u.Dh).b0(w7.j.f13718i, G3(), new AdapterView.OnItemClickListener() { // from class: y7.s0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                t0.g3(this.f14915a, adapterView, view, i11, j10);
            }
        }).h0();
    }

    public final void O3() {
        if (this.f14922y0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (w4.c cVar : this.f14918u0) {
            if (cVar.h()) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        this.f14922y0 = true;
        this.A0.s0("filter_subscriptions", System.currentTimeMillis());
        com.tuyafeng.support.utils.n.q(G(), w7.u.f14167o4);
        ((autodispose2.n) r6.j.w(arrayList).q(new u6.g() { // from class: y7.o0
            @Override // u6.g
            public final Object apply(Object obj) {
                return this.f14907a.P3((w4.c) obj);
            }
        }).k(new u6.a() { // from class: y7.p0
            @Override // u6.a
            public final void run() {
                this.f14909a.f14922y0 = false;
            }
        }).L(s8.b.a(b1()))).b(new u6.f() { // from class: y7.q0
            @Override // u6.f
            public final void accept(Object obj) {
                t0.m3(this.f14911c, (Long) obj);
            }
        }, new w7.a0(), new u6.a() { // from class: y7.r0
            @Override // u6.a
            public final void run() {
                t0.u3(this.f14913a);
            }
        });
    }

    public final r6.j P3(final w4.c cVar) {
        final String strA = cVar.a();
        final w4.c cVar2 = new w4.c(cVar);
        return r6.j.v(new Callable() { // from class: y7.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t0.f3(cVar2, strA);
            }
        }).G(a7.a.c()).C(q6.b.b()).p(new u6.i() { // from class: y7.c0
            @Override // u6.i
            public final boolean test(Object obj) {
                return t0.y3(this.f14866c, cVar2, cVar, (Long) obj);
            }
        }).n(new u6.f() { // from class: y7.d0
            @Override // u6.f
            public final void accept(Object obj) {
                t0.i3(this.f14873c, cVar, cVar2, strA, (Long) obj);
            }
        });
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f14919v0.clear();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f14920w0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: y7.w
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                t0.p3(this.f14929a, view2, i10, (v5.q) obj);
            }
        });
        this.f14920w0.K(v5.q.class, sVar);
        this.f14920w0.K(v5.l.class, new v5.m());
        ib.i iVar = new ib.i(this.f14919v0);
        iVar.j(new t5.g() { // from class: y7.h0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f14886a.J3(view2, i10, (w4.c) obj);
            }
        });
        iVar.k(new t5.h() { // from class: y7.l0
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return this.f14897a.K3(view2, i10, (w4.c) obj);
            }
        });
        this.f14920w0.K(w4.c.class, iVar);
        this.f7946t0.setAdapter(this.f14920w0);
        SettingsSearchLocator.b(this, this.f7946t0);
        I3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.O5);
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        la.s.b(context).n(this);
    }
}
