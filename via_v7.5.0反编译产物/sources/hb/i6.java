package hb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i6 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f5902u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f5903v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public List f5904w0 = new ArrayList();

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public androidx.recyclerview.widget.j f5905x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public l8.b f5906y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public ib.q f5907z0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements l8.a {
        public a() {
        }

        @Override // l8.a
        public boolean a(int i10) {
            if (i10 < 2) {
                return false;
            }
            return ((ib.r) i6.this.f5903v0.H().get(i10)).d();
        }

        @Override // l8.a
        public void b(int i10, boolean z10) {
            if (i10 < 2) {
                return;
            }
            ib.r rVar = (ib.r) i6.this.f5903v0.H().get(i10);
            if (rVar.d() == z10 || !TextUtils.isEmpty(rVar.b())) {
                return;
            }
            rVar.f(z10);
            i6.this.f5903v0.n(i10, Boolean.valueOf(z10));
        }

        @Override // l8.a
        public boolean c(int i10) {
            return i10 >= 2;
        }
    }

    public static /* synthetic */ boolean f3(i6 i6Var, View view, int i10, ib.r rVar) {
        i6Var.f5906y0.n(true, i10);
        return true;
    }

    public static /* synthetic */ void h3(i6 i6Var, List list) {
        i6Var.f5904w0.clear();
        i6Var.f5904w0.addAll(list);
        i6Var.s3(i6Var.p3());
    }

    public static /* synthetic */ void i3(i6 i6Var, View view, int i10, v5.n nVar) {
        i6Var.getClass();
        if (nVar.c() == 1) {
            u9.a aVarV = i6Var.f5902u0.v();
            aVarV.J(true ^ nVar.i());
            i6Var.f5902u0.Z(aVarV);
            i6Var.s3(i6Var.p3());
        }
    }

    public static /* synthetic */ void j3(i6 i6Var, View view, int i10, ib.r rVar) {
        i6Var.getClass();
        if (TextUtils.isEmpty(rVar.b())) {
            rVar.f(!rVar.d());
            i6Var.f5903v0.m(i10);
            i6Var.t3();
        }
    }

    private List p3() {
        ArrayList arrayList = new ArrayList();
        boolean zR = this.f5902u0.v().r();
        arrayList.add(new v5.n(1, X0(w7.u.I4), zR));
        this.f5907z0.b(this.f5902u0.I1());
        Collections.sort(this.f5904w0, this.f5907z0);
        int iM1 = this.f5902u0.M1();
        int[] iArrP = com.tuyafeng.support.utils.p.p(com.tuyafeng.support.utils.p.m(this.f5902u0.D()), ',');
        arrayList.add(new v5.l(X0(w7.u.f14049fc)));
        for (ga.c cVar : this.f5904w0) {
            arrayList.add(new ib.r(cVar.d(), cVar.g(), iM1 == cVar.d() ? X0(w7.u.f14110k3) : "", iM1 == cVar.d() || !com.tuyafeng.support.utils.a.b(iArrP, cVar.d()), !zR));
        }
        return arrayList;
    }

    public static List q3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, i6.class, w7.u.Fc, w7.u.f14161nc, w7.u.f14231sc);
        hVar.b(1, w7.u.I4, new String[0]);
        return hVar.f();
    }

    private void r3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.g6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x8.q2.e(this.f5882c.G());
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.h6
            @Override // u6.f
            public final void accept(Object obj) {
                i6.h3(this.f5891c, (List) obj);
            }
        }, new w7.e0());
    }

    private void s3(List list) {
        t5.f fVar = this.f5903v0;
        if (fVar == null) {
            return;
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new ib.s(fVar.H(), list));
        this.f5903v0.M(list);
        eVarB.c(this.f5903v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5902u0 = la.s.j();
        this.f5907z0 = new ib.q();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        androidx.recyclerview.widget.j jVar = new androidx.recyclerview.widget.j(new c());
        this.f5905x0 = jVar;
        jVar.m(this.f7946t0);
        this.f5903v0 = new t5.f(Collections.EMPTY_LIST);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: hb.c6
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                i6.i3(this.f5828a, view2, i10, (v5.n) obj);
            }
        });
        this.f5903v0.K(v5.n.class, pVar);
        this.f5903v0.K(v5.l.class, new v5.m());
        ib.w wVar = new ib.w();
        wVar.j(new t5.g() { // from class: hb.d6
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                i6.j3(this.f5843a, view2, i10, (ib.r) obj);
            }
        });
        wVar.k(new t5.h() { // from class: hb.e6
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return i6.f3(this.f5856a, view2, i10, (ib.r) obj);
            }
        });
        wVar.p(new ib.w.a() { // from class: hb.f6
            @Override // ib.w.a
            public final void a(RecyclerView.d0 d0Var) {
                this.f5871a.f5905x0.H(d0Var);
            }
        });
        this.f5903v0.K(ib.r.class, wVar);
        this.f7946t0.setAdapter(this.f5903v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        l8.b bVar = new l8.b(G(), new a());
        this.f5906y0 = bVar;
        bVar.p(com.tuyafeng.support.utils.x.h(G(), com.tuyafeng.support.utils.l.d(G()) ? 48.0f : -48.0f));
        this.f5906y0.o(new b());
        this.f7946t0.n(this.f5906y0);
        r3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.f14231sc));
    }

    public final void t3() {
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : this.f5903v0.H()) {
            if (obj instanceof ib.r) {
                ib.r rVar = (ib.r) obj;
                int iA = rVar.a();
                if (!rVar.d()) {
                    if (sb2.length() > 0) {
                        sb2.append(',');
                    }
                    sb2.append(iA);
                }
            }
        }
        this.f5902u0.S0(sb2.toString());
    }

    public final void u3(boolean z10) {
        com.tuyafeng.support.widget.d0 d0Var = (com.tuyafeng.support.widget.d0) A2().findViewById(com.tuyafeng.support.utils.x.f3593a);
        if (d0Var != null) {
            d0Var.setGestureEnabled(z10);
        }
    }

    public final void v3() {
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : this.f5903v0.H()) {
            if (obj instanceof ib.r) {
                int iA = ((ib.r) obj).a();
                if (sb2.length() > 0) {
                    sb2.append(',');
                }
                sb2.append(iA);
            }
        }
        this.f5902u0.f2(sb2.toString());
        tc.a.a("update order: %s", sb2);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements l8.b.InterfaceC0093b {
        public b() {
        }

        @Override // l8.b.InterfaceC0093b
        public void a(boolean z10) {
            i6.this.u3(!z10);
            if (z10) {
                return;
            }
            i6.this.t3();
        }

        @Override // l8.b.InterfaceC0093b
        public void b(boolean z10) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends androidx.recyclerview.widget.j.i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f5910f;

        public c() {
            super(3, 0);
            this.f5910f = false;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void A(RecyclerView.d0 d0Var, int i10) {
            super.A(d0Var, i10);
            if (i10 == 2 && d0Var != null) {
                d0Var.f1138a.setBackgroundColor(com.tuyafeng.support.utils.f.b(i6.this.G(), w7.m.f13738b));
            }
            if (this.f5910f && i10 == 0) {
                this.f5910f = false;
                i6.this.v3();
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public void c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            super.c(recyclerView, d0Var);
            View view = d0Var.f1138a;
            com.tuyafeng.support.utils.x.P(view, com.tuyafeng.support.utils.f.e(view.getContext(), w7.o.f13786e));
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean r() {
            return false;
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            int iL = d0Var.l();
            int iL2 = d0Var2.l();
            if (iL == iL2 || iL < 2 || iL2 < 2) {
                return false;
            }
            i6.this.f5903v0.p(iL, iL2);
            return true;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void z(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i10, RecyclerView.d0 d0Var2, int i11, int i12, int i13) {
            super.z(recyclerView, d0Var, i10, d0Var2, i11, i12, i13);
            List listH = i6.this.f5903v0.H();
            listH.add(i11, listH.remove(i10));
            this.f5910f = true;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void B(RecyclerView.d0 d0Var, int i10) {
        }
    }
}
