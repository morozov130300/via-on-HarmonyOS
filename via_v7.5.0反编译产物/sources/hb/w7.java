package hb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w7 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public t5.f f6131u0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public u9.l f6133w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public w9.a f6134x0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f6132v0 = -999;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final List f6135y0 = new ArrayList();

    public static /* synthetic */ void f3(w7 w7Var, View view, int i10, v5.g gVar) {
        if (w7Var.t3(w7Var.f6132v0) == i10) {
            return;
        }
        w7Var.w3((ga.c) w7Var.f6135y0.get(i10));
        w7Var.x3(w7Var.p3());
    }

    public static /* synthetic */ void h3(w7 w7Var, List list, AdapterView adapterView, View view, int i10, long j10) {
        w7Var.getClass();
        w7Var.v3((ga.c) list.get(i10));
        w7Var.x3(w7Var.p3());
    }

    public static /* synthetic */ void i3(w7 w7Var, String str, Bundle bundle) {
        w7Var.getClass();
        int i10 = bundle.getInt("ua_result", 0);
        if (i10 > 0) {
            w7Var.y3(i10);
        }
        w7Var.L0().x("ua_result");
    }

    public static /* synthetic */ void j3(w7 w7Var, int i10, int i11, AdapterView adapterView, View view, int i12, long j10) {
        if (i12 == 0) {
            w7Var.r3(i10);
            return;
        }
        if (i10 == w7Var.f6132v0) {
            w7Var.w3((ga.c) w7Var.f6135y0.get(0));
        }
        w7Var.f6134x0.z().a(i10);
        w7Var.f6135y0.remove(i11);
        w7Var.x3(w7Var.p3());
    }

    public static /* synthetic */ void k3(w7 w7Var, View view, int i10, v5.n nVar) {
        w7Var.getClass();
        if (nVar.c() == 2) {
            u9.o oVarJ1 = w7Var.f6133w0.j1();
            oVarJ1.f(!oVarJ1.e());
            w7Var.f6133w0.J2(oVarJ1);
            u9.n.e().w(true);
            w7Var.x3(w7Var.p3());
        }
    }

    public static /* synthetic */ boolean l3(final w7 w7Var, View view, final int i10, v5.g gVar) {
        final int iD = ((ga.c) w7Var.f6135y0.get(i10)).d();
        if (iD <= 0) {
            return true;
        }
        q5.k.l(w7Var.G()).G(new String[]{w7Var.X0(w7.u.E), w7Var.X0(w7.u.f14298y)}, new AdapterView.OnItemClickListener() { // from class: hb.q7
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                w7.j3(this.f6041a, iD, i10, adapterView, view2, i11, j10);
            }
        }).j0(view);
        return true;
    }

    public static /* synthetic */ void m3(w7 w7Var, int i10, int i11, ga.c cVar) {
        if (i10 < 0) {
            w7Var.f6135y0.add(cVar);
            w7Var.x3(w7Var.p3());
            w7Var.f7946t0.x1(w7Var.f6135y0.size());
        } else {
            w7Var.f6135y0.set(i10, cVar);
            if (i11 == w7Var.f6132v0) {
                w7Var.w3(cVar);
            }
            if (w7Var.f6133w0.V() == i11) {
                w7Var.v3(cVar);
            }
            w7Var.x3(w7Var.p3());
        }
    }

    public static /* synthetic */ void o3(w7 w7Var, View view, int i10, v5.q qVar) {
        w7Var.getClass();
        if (qVar.c() == 1) {
            w7Var.q3();
        }
    }

    private List p3() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f6135y0.iterator();
        while (true) {
            boolean z10 = true;
            if (!it.hasNext()) {
                arrayList.add(new v5.l(X0(w7.u.Dc)));
                arrayList.add(new v5.q(1, X0(w7.u.Sh), x8.c4.d(G(), this.f6133w0.V())));
                arrayList.add(new v5.n(2, X0(w7.u.Th), X0(w7.u.Uh), this.f6133w0.j1().e()));
                return arrayList;
            }
            ga.c cVar = (ga.c) it.next();
            int iD = cVar.d();
            String strG = cVar.g();
            if (cVar.d() != this.f6132v0) {
                z10 = false;
            }
            arrayList.add(new v5.g(iD, strG, z10));
        }
    }

    public static List s3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, w7.class, w7.u.Fc, w7.u.F0);
        hVar.b(1, w7.u.Sh, new String[0]);
        hVar.b(2, w7.u.Th, new String[0]);
        return hVar.f();
    }

    private int t3(int i10) {
        int size = this.f6135y0.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((ga.c) this.f6135y0.get(i11)).d() == i10) {
                return i11;
            }
        }
        return -1;
    }

    private void u3() {
        List listB = x8.c4.b(G());
        this.f6132v0 = this.f6133w0.o0();
        listB.addAll(this.f6134x0.z().b(1));
        this.f6135y0.clear();
        this.f6135y0.addAll(listB);
        this.f6131u0.M(listB);
    }

    private void x3(List list) {
        t5.f fVar = this.f6131u0;
        if (fVar == null) {
            return;
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(fVar.H(), list));
        this.f6131u0.M(list);
        eVarB.c(this.f6131u0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        t5.f fVar = new t5.f(Collections.EMPTY_LIST);
        this.f6131u0 = fVar;
        fVar.K(v5.l.class, new v5.m());
        v5.j jVar = new v5.j();
        jVar.j(new t5.g() { // from class: hb.m7
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                w7.f3(this.f5975a, view2, i10, (v5.g) obj);
            }
        });
        jVar.k(new t5.h() { // from class: hb.n7
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return w7.l3(this.f5994a, view2, i10, (v5.g) obj);
            }
        });
        this.f6131u0.K(v5.g.class, jVar);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: hb.o7
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                w7.o3(this.f6016a, view2, i10, (v5.q) obj);
            }
        });
        this.f6131u0.K(v5.q.class, sVar);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: hb.p7
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                w7.k3(this.f6028a, view2, i10, (v5.n) obj);
            }
        });
        this.f6131u0.K(v5.n.class, pVar);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7946t0.setAdapter(this.f6131u0);
        SettingsSearchLocator.b(this, this.f7946t0);
        this.f6133w0 = la.s.j();
        this.f6134x0 = la.s.f();
        u3();
        x3(p3());
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        x8.v3.a(e0Var, w7.u.F0);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 1, lb.g.a(G(), w7.o.f13810m, w7.u.ge), X0(w7.u.O)), new View.OnClickListener() { // from class: hb.s7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6066a.r3(0);
            }
        });
    }

    public final void q3() {
        final ArrayList arrayList = new ArrayList();
        int iV = this.f6133w0.V();
        for (ga.c cVar : this.f6135y0) {
            int iD = cVar.d();
            if (iD > 0) {
                arrayList.add(cVar);
            } else if (iD == 0 || x8.c4.f(iD)) {
                arrayList.add(cVar);
            }
        }
        String[] strArr = new String[arrayList.size()];
        int size = arrayList.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((ga.c) arrayList.get(i11)).g();
            if (((ga.c) arrayList.get(i11)).d() == iV) {
                i10 = i11;
            }
        }
        q5.k.l(G()).g0(X0(w7.u.Sh)).d0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: hb.r7
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                w7.h3(this.f6055a, arrayList, adapterView, view, i12, j10);
            }
        }).h0();
        u9.n.e().w(true);
    }

    public final void r3(int i10) {
        L0().z1("ua_result", this, new androidx.fragment.app.i0() { // from class: hb.t7
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                w7.i3(this.f6078a, str, bundle);
            }
        });
        FragmentUtils.k(this, y1.class, y1.p3(i10), null);
    }

    public final void v3(ga.c cVar) {
        this.f6133w0.F2(cVar.d());
        if (this.f6133w0.n2().l()) {
            u9.n.e().w(true);
        }
    }

    public final void w3(ga.c cVar) {
        int iD = cVar.d();
        this.f6132v0 = iD;
        this.f6133w0.J(iD);
        u9.n.e().w(true);
    }

    public final void y3(final int i10) {
        if (this.f6131u0 == null) {
            return;
        }
        final int iT3 = t3(i10);
        ((autodispose2.m) r6.f.h(new Callable() { // from class: hb.u7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6095c.f6134x0.z().c(i10);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: hb.v7
            @Override // u6.f
            public final void accept(Object obj) {
                w7.m3(this.f6111c, iT3, i10, (ga.c) obj);
            }
        }, new w7.a0());
    }
}
