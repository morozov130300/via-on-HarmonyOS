package hb;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.j;
import ib.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import n8.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i6 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f6588r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6589s0;

    /* renamed from: t0, reason: collision with root package name */
    public List f6590t0 = new ArrayList();

    /* renamed from: u0, reason: collision with root package name */
    public androidx.recyclerview.widget.j f6591u0;

    /* renamed from: v0, reason: collision with root package name */
    public n8.b f6592v0;

    /* renamed from: w0, reason: collision with root package name */
    public ib.q f6593w0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements n8.a {
        public a() {
        }

        @Override // n8.a
        public boolean a(int i10) {
            if (i10 < 2) {
                return false;
            }
            return ((ib.r) i6.this.f6589s0.H().get(i10)).d();
        }

        @Override // n8.a
        public void b(int i10, boolean z10) {
            if (i10 < 2) {
                return;
            }
            ib.r rVar = (ib.r) i6.this.f6589s0.H().get(i10);
            if (rVar.d() == z10 || !TextUtils.isEmpty(rVar.b())) {
                return;
            }
            rVar.f(z10);
            i6.this.f6589s0.n(i10, Boolean.valueOf(z10));
        }

        @Override // n8.a
        public boolean c(int i10) {
            return i10 >= 2;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements b.InterfaceC0100b {
        public b() {
        }

        @Override // n8.b.InterfaceC0100b
        public void a(boolean z10) {
            i6.this.u3(!z10);
            if (z10) {
                return;
            }
            i6.this.t3();
        }

        @Override // n8.b.InterfaceC0100b
        public void b(boolean z10) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends j.i {

        /* renamed from: f, reason: collision with root package name */
        public boolean f6596f;

        public c() {
            super(3, 0);
            this.f6596f = false;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void A(RecyclerView.c0 c0Var, int i10) {
            super.A(c0Var, i10);
            if (i10 == 2 && c0Var != null) {
                c0Var.f1219a.setBackgroundColor(g6.f.b(i6.this.I(), x7.m.f13672b));
            }
            if (this.f6596f && i10 == 0) {
                this.f6596f = false;
                i6.this.v3();
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public void B(RecyclerView.c0 c0Var, int i10) {
        }

        @Override // androidx.recyclerview.widget.j.f
        public void c(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            super.c(recyclerView, c0Var);
            View view = c0Var.f1219a;
            g6.y.O(view, g6.f.e(view.getContext(), x7.o.f13723f));
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean r() {
            return false;
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean y(RecyclerView recyclerView, RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            int iL = c0Var.l();
            int iL2 = c0Var2.l();
            if (iL == iL2 || iL < 2 || iL2 < 2) {
                return false;
            }
            i6.this.f6589s0.p(iL, iL2);
            return true;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void z(RecyclerView recyclerView, RecyclerView.c0 c0Var, int i10, RecyclerView.c0 c0Var2, int i11, int i12, int i13) {
            super.z(recyclerView, c0Var, i10, c0Var2, i11, i12, i13);
            List listH = i6.this.f6589s0.H();
            listH.add(i11, listH.remove(i10));
            this.f6596f = true;
        }
    }

    public static /* synthetic */ boolean g3(i6 i6Var, View view, int i10, ib.r rVar) {
        i6Var.f6592v0.n(true, i10);
        return true;
    }

    public static /* synthetic */ void i3(i6 i6Var, List list) {
        i6Var.f6590t0.clear();
        i6Var.f6590t0.addAll(list);
        i6Var.s3(i6Var.q3());
    }

    public static /* synthetic */ void j3(i6 i6Var, View view, int i10, a6.n nVar) {
        i6Var.getClass();
        if (nVar.c() == 1) {
            w9.a aVarV = i6Var.f6588r0.v();
            aVarV.K(true ^ nVar.i());
            i6Var.f6588r0.q0(aVarV);
            i6Var.s3(i6Var.q3());
        }
    }

    public static /* synthetic */ void k3(i6 i6Var, View view, int i10, ib.r rVar) {
        i6Var.getClass();
        if (TextUtils.isEmpty(rVar.b())) {
            rVar.f(!rVar.d());
            i6Var.f6589s0.m(i10);
            i6Var.t3();
        }
    }

    private List q3() {
        ArrayList arrayList = new ArrayList();
        boolean zR = this.f6588r0.v().r();
        arrayList.add(new a6.n(1, Z0(x7.u.f14194v4), zR));
        this.f6593w0.b(this.f6588r0.I1());
        Collections.sort(this.f6590t0, this.f6593w0);
        int iM1 = this.f6588r0.M1();
        int[] iArrP = g6.p.p(g6.p.m(this.f6588r0.C()), ',');
        arrayList.add(new a6.l(Z0(x7.u.Sb)));
        for (ja.c cVar : this.f6590t0) {
            arrayList.add(new ib.r(cVar.d(), cVar.g(), iM1 == cVar.d() ? Z0(x7.u.Y2) : "", iM1 == cVar.d() || !g6.a.b(iArrP, cVar.d()), !zR));
        }
        return arrayList;
    }

    private void r3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.g6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return z8.v2.e(this.f6562e.I());
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.h6
            @Override // a7.e
            public final void accept(Object obj) {
                i6.i3(this.f6571e, (List) obj);
            }
        }, new x7.g0());
    }

    private void s3(List list) {
        y5.f fVar = this.f6589s0;
        if (fVar == null) {
            return;
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new ib.s(fVar.H(), list));
        this.f6589s0.M(list);
        eVarB.c(this.f6589s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6588r0 = pa.r.j();
        this.f6593w0 = new ib.q();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        androidx.recyclerview.widget.j jVar = new androidx.recyclerview.widget.j(new c());
        this.f6591u0 = jVar;
        jVar.m(this.f10459q0);
        this.f6589s0 = new y5.f(Collections.EMPTY_LIST);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: hb.c6
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                i6.j3(this.f6512a, view2, i10, (a6.n) obj);
            }
        });
        this.f6589s0.K(a6.n.class, pVar);
        this.f6589s0.K(a6.l.class, new a6.m());
        ib.w wVar = new ib.w();
        wVar.j(new y5.g() { // from class: hb.d6
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                i6.k3(this.f6523a, view2, i10, (ib.r) obj);
            }
        });
        wVar.k(new y5.h() { // from class: hb.e6
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return i6.g3(this.f6535a, view2, i10, (ib.r) obj);
            }
        });
        wVar.p(new w.a() { // from class: hb.f6
            @Override // ib.w.a
            public final void a(RecyclerView.c0 c0Var) {
                this.f6548a.f6591u0.H(c0Var);
            }
        });
        this.f6589s0.K(ib.r.class, wVar);
        this.f10459q0.setAdapter(this.f6589s0);
        n8.b bVar = new n8.b(I(), new a());
        this.f6592v0 = bVar;
        bVar.p(g6.y.h(I(), g6.l.d(I()) ? 48.0f : -48.0f));
        this.f6592v0.o(new b());
        this.f10459q0.n(this.f6592v0);
        r3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.f13969ec));
    }

    public final void t3() {
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : this.f6589s0.H()) {
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
        this.f6588r0.P0(sb2.toString());
    }

    public final void u3(boolean z10) {
        com.tuyafeng.support.widget.y yVar = (com.tuyafeng.support.widget.y) C2().findViewById(g6.y.f6242a);
        if (yVar != null) {
            yVar.setGestureEnabled(z10);
        }
    }

    public final void v3() {
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : this.f6589s0.H()) {
            if (obj instanceof ib.r) {
                int iA = ((ib.r) obj).a();
                if (sb2.length() > 0) {
                    sb2.append(',');
                }
                sb2.append(iA);
            }
        }
        this.f6588r0.e2(sb2.toString());
        pc.a.a("update order: %s", sb2);
    }
}
