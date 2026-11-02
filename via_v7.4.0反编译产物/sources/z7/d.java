package z7;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public boolean f14608r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f14609s0;

    /* renamed from: t0, reason: collision with root package name */
    public u4.a f14610t0;

    /* renamed from: u0, reason: collision with root package name */
    public w9.l f14611u0;

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        if (this.f14608r0) {
            z8.h.b(new Runnable() { // from class: z7.a
                @Override // java.lang.Runnable
                public final void run() {
                    d dVar = this.f14602e;
                    dVar.f14610t0.p(dVar.f14611u0.D0());
                }
            });
        }
        super.O1();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        ArrayList arrayList = new ArrayList();
        boolean zG = this.f14611u0.m2().g();
        arrayList.add(new a6.n(1, Z0(x7.u.f14165t1), !zG ? Z0(x7.u.f14245z3) : a1(x7.u.f14125q0, Integer.valueOf(this.f14611u0.G()), z8.b0.x(I(), this.f14611u0.B2())), zG));
        arrayList.add(new a6.n(2, Z0(x7.u.f14155s4), Z0(x7.u.f14168t4), this.f14611u0.D0()));
        arrayList.add(new a6.q(3, Z0(x7.u.L2), Z0(x7.u.M2)));
        arrayList.add(new a6.q(4, Z0(x7.u.C5), Z0(x7.u.D5)));
        boolean zE = r9.g.a().l().e();
        if ((z8.c0.f() || z8.f.h()) && zE) {
            boolean zD = this.f14611u0.m2().D();
            a6.n nVar = new a6.n(5, Z0(x7.u.P4), Z0(x7.u.Q4), zE && z8.j0.b());
            nVar.g((zD && zE) ? false : true);
            arrayList.add(nVar);
        }
        y5.f fVar = new y5.f(arrayList);
        this.f14609s0 = fVar;
        fVar.K(a6.q.class, new a6.s(new y5.g() { // from class: z7.b
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f14604a.k3(view2, i10, (a6.q) obj);
            }
        }));
        this.f14609s0.K(a6.n.class, new a6.p(new y5.g() { // from class: z7.c
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f14606a.j3(view2, i10, (a6.n) obj);
            }
        }));
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(null);
        this.f10459q0.setAdapter(this.f14609s0);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.a(zVar, x7.u.f14165t1);
    }

    public final void j3(View view, int i10, a6.n nVar) {
        int iC = nVar.c();
        if (iC == 1) {
            w9.p pVarM2 = this.f14611u0.m2();
            nVar.j(!nVar.i());
            pVarM2.I(nVar.i());
            this.f14611u0.g0(pVarM2);
            w9.n.e().y(true);
            if (nVar.i()) {
                nVar.h(a1(x7.u.f14125q0, Integer.valueOf(this.f14611u0.G()), z8.b0.x(I(), this.f14611u0.B2())));
            } else {
                nVar.h(Z0(x7.u.f14245z3));
            }
            this.f14609s0.m(i10);
            return;
        }
        if (iC == 2) {
            this.f14608r0 = true;
            nVar.j(!nVar.i());
            this.f14611u0.j0(nVar.i());
            this.f14609s0.m(i10);
            return;
        }
        if (iC != 5) {
            return;
        }
        w9.a aVarV = this.f14611u0.v();
        nVar.j(!nVar.i());
        aVarV.w(nVar.i());
        this.f14611u0.q0(aVarV);
        z8.j0.c(A0(), aVarV.e(), false);
        this.f14609s0.m(i10);
    }

    public final void k3(View view, int i10, a6.q qVar) {
        int iC = qVar.c();
        if (iC == 3) {
            g6.i.g(this, v.class);
        } else {
            if (iC != 4) {
                return;
            }
            g6.i.g(this, q0.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        pa.r.b(context).f(this);
    }
}
