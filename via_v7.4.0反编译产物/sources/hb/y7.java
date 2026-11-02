package hb;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import com.tuyafeng.support.widget.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y7 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public y5.f f6846r0;

    /* renamed from: t0, reason: collision with root package name */
    public w9.l f6848t0;

    /* renamed from: u0, reason: collision with root package name */
    public y9.a f6849u0;

    /* renamed from: s0, reason: collision with root package name */
    public int f6847s0 = -999;

    /* renamed from: v0, reason: collision with root package name */
    public final List f6850v0 = new ArrayList();

    public static /* synthetic */ void g3(y7 y7Var, View view, int i10, a6.g gVar) {
        if (y7Var.t3(y7Var.f6847s0) == i10) {
            return;
        }
        y7Var.w3((ja.c) y7Var.f6850v0.get(i10));
        y7Var.x3(y7Var.q3());
    }

    public static /* synthetic */ void i3(y7 y7Var, List list, AdapterView adapterView, View view, int i10, long j10) {
        y7Var.getClass();
        y7Var.v3((ja.c) list.get(i10));
        y7Var.x3(y7Var.q3());
    }

    public static /* synthetic */ void j3(y7 y7Var, String str, Bundle bundle) {
        y7Var.getClass();
        int i10 = bundle.getInt("ua_result", 0);
        if (i10 > 0) {
            y7Var.y3(i10);
        }
        y7Var.N0().x("ua_result");
    }

    public static /* synthetic */ void k3(y7 y7Var, int i10, int i11, AdapterView adapterView, View view, int i12, long j10) {
        if (i12 == 0) {
            y7Var.s3(i10);
            return;
        }
        if (i10 == y7Var.f6847s0) {
            y7Var.w3((ja.c) y7Var.f6850v0.get(0));
        }
        y7Var.f6849u0.z().a(i10);
        y7Var.f6850v0.remove(i11);
        y7Var.x3(y7Var.q3());
    }

    public static /* synthetic */ void l3(y7 y7Var, View view, int i10, a6.n nVar) {
        y7Var.getClass();
        if (nVar.c() == 2) {
            w9.o oVarI1 = y7Var.f6848t0.i1();
            oVarI1.f(!oVarI1.e());
            y7Var.f6848t0.H1(oVarI1);
            w9.n.e().y(true);
            y7Var.x3(y7Var.q3());
        }
    }

    public static /* synthetic */ boolean m3(final y7 y7Var, View view, final int i10, a6.g gVar) {
        final int iD = ((ja.c) y7Var.f6850v0.get(i10)).d();
        if (iD <= 0) {
            return true;
        }
        w5.k.l(y7Var.I()).F(new String[]{y7Var.Z0(x7.u.D), y7Var.Z0(x7.u.f14215x)}, new AdapterView.OnItemClickListener() { // from class: hb.t7
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                y7.k3(this.f6763a, iD, i10, adapterView, view2, i11, j10);
            }
        }).h0(view);
        return true;
    }

    public static /* synthetic */ void n3(y7 y7Var, int i10, int i11, ja.c cVar) {
        if (i10 < 0) {
            y7Var.f6850v0.add(cVar);
            y7Var.x3(y7Var.q3());
            y7Var.f10459q0.x1(y7Var.f6850v0.size());
        } else {
            y7Var.f6850v0.set(i10, cVar);
            if (i11 == y7Var.f6847s0) {
                y7Var.w3(cVar);
            }
            if (y7Var.f6848t0.U() == i11) {
                y7Var.v3(cVar);
            }
            y7Var.x3(y7Var.q3());
        }
    }

    public static /* synthetic */ void p3(y7 y7Var, View view, int i10, a6.q qVar) {
        y7Var.getClass();
        if (qVar.c() == 1) {
            y7Var.r3();
        }
    }

    private List q3() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f6850v0.iterator();
        while (true) {
            boolean z10 = true;
            if (!it.hasNext()) {
                arrayList.add(new a6.l(Z0(x7.u.f14123pc)));
                arrayList.add(new a6.q(1, Z0(x7.u.sh), z8.b4.d(I(), this.f6848t0.U())));
                arrayList.add(new a6.n(2, Z0(x7.u.th), Z0(x7.u.uh), this.f6848t0.i1().e()));
                return arrayList;
            }
            ja.c cVar = (ja.c) it.next();
            int iD = cVar.d();
            String strG = cVar.g();
            if (cVar.d() != this.f6847s0) {
                z10 = false;
            }
            arrayList.add(new a6.g(iD, strG, z10));
        }
    }

    private int t3(int i10) {
        int size = this.f6850v0.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((ja.c) this.f6850v0.get(i11)).d() == i10) {
                return i11;
            }
        }
        return -1;
    }

    private void u3() {
        List listB = z8.b4.b(I());
        this.f6847s0 = this.f6848t0.l0();
        listB.addAll(this.f6849u0.z().c(1));
        this.f6850v0.clear();
        this.f6850v0.addAll(listB);
        this.f6846r0.M(listB);
    }

    private void x3(List list) {
        y5.f fVar = this.f6846r0;
        if (fVar == null) {
            return;
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(fVar.H(), list));
        this.f6846r0.M(list);
        eVarB.c(this.f6846r0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        y5.f fVar = new y5.f(Collections.EMPTY_LIST);
        this.f6846r0 = fVar;
        fVar.K(a6.l.class, new a6.m());
        a6.j jVar = new a6.j();
        jVar.j(new y5.g() { // from class: hb.p7
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                y7.g3(this.f6713a, view2, i10, (a6.g) obj);
            }
        });
        jVar.k(new y5.h() { // from class: hb.q7
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return y7.m3(this.f6725a, view2, i10, (a6.g) obj);
            }
        });
        this.f6846r0.K(a6.g.class, jVar);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: hb.r7
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                y7.p3(this.f6736a, view2, i10, (a6.q) obj);
            }
        });
        this.f6846r0.K(a6.q.class, sVar);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: hb.s7
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                y7.l3(this.f6750a, view2, i10, (a6.n) obj);
            }
        });
        this.f6846r0.K(a6.n.class, pVar);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f10459q0.setAdapter(this.f6846r0);
        this.f6848t0 = pa.r.j();
        this.f6849u0 = pa.r.f();
        u3();
        x3(q3());
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        z8.v3.a(zVar, x7.u.C0);
        zVar.c(new z.b(1, 1, lb.b.a(I(), x7.o.f13747n, x7.u.Rd), Z0(x7.u.N)), new View.OnClickListener() { // from class: hb.o7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6698a.s3(0);
            }
        });
    }

    public final void r3() {
        final ArrayList arrayList = new ArrayList();
        int iU = this.f6848t0.U();
        for (ja.c cVar : this.f6850v0) {
            int iD = cVar.d();
            if (iD > 0) {
                arrayList.add(cVar);
            } else if (iD == 0 || iD == -3 || iD == -4 || iD == -5) {
                arrayList.add(cVar);
            }
        }
        String[] strArr = new String[arrayList.size()];
        int size = arrayList.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((ja.c) arrayList.get(i11)).g();
            if (((ja.c) arrayList.get(i11)).d() == iU) {
                i10 = i11;
            }
        }
        w5.k.l(I()).e0(Z0(x7.u.sh)).b0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: hb.u7
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                y7.i3(this.f6785a, arrayList, adapterView, view, i12, j10);
            }
        }).f0();
        w9.n.e().y(true);
    }

    public final void s3(int i10) {
        N0().y1("ua_result", this, new androidx.fragment.app.i0() { // from class: hb.v7
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                y7.j3(this.f6801a, str, bundle);
            }
        });
        g6.i.i(this, v1.class, v1.p3(i10), null);
    }

    public final void v3(ja.c cVar) {
        this.f6848t0.D2(cVar.d());
        if (z8.b4.f(cVar.d())) {
            this.f6848t0.P2(cVar.a());
        }
        if (this.f6848t0.m2().l()) {
            w9.n.e().y(true);
        }
    }

    public final void w3(ja.c cVar) {
        int iD = cVar.d();
        this.f6847s0 = iD;
        this.f6848t0.I(iD);
        if (z8.b4.f(this.f6847s0)) {
            this.f6848t0.f2(cVar.a());
        }
        w9.n.e().y(true);
    }

    public final void y3(final int i10) {
        if (this.f6846r0 == null) {
            return;
        }
        final int iT3 = t3(i10);
        ((autodispose2.m) x6.f.h(new Callable() { // from class: hb.w7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6820e.f6849u0.z().d(i10);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: hb.x7
            @Override // a7.e
            public final void accept(Object obj) {
                y7.n3(this.f6830e, iT3, i10, (ja.c) obj);
            }
        }, new x7.c0());
    }
}
