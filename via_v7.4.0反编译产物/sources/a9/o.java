package a9;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import z8.r3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f333r0;

    /* renamed from: s0, reason: collision with root package name */
    public p9.o f334s0;

    /* renamed from: t0, reason: collision with root package name */
    public y5.f f335t0;

    public static /* synthetic */ void h3(o oVar, View view, int i10, a6.q qVar) {
        oVar.getClass();
        int iC = qVar.c();
        if (iC == 1) {
            g6.i.g(oVar, k.class);
        } else if (iC == 2) {
            g6.i.g(oVar, z.class);
        }
    }

    public static /* synthetic */ void i3(o oVar, x5.a aVar) {
        oVar.getClass();
        oVar.l3(oVar.j3((p9.l) aVar.c()));
    }

    private void k3() {
        l3(j3(null));
        final String strN0 = this.f333r0.n0();
        if (strN0 == null || strN0.isEmpty()) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: a9.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x5.a.f(this.f329e.f334s0.b(strN0));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: a9.n
            @Override // a7.e
            public final void accept(Object obj) {
                o.i3(this.f331e, (x5.a) obj);
            }
        }, new x7.g0());
    }

    private void l3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f335t0.H(), list));
        this.f335t0.M(list);
        eVarB.c(this.f335t0);
    }

    @Override // androidx.fragment.app.Fragment
    public void I1(boolean z10) {
        super.I1(z10);
        if (z10) {
            return;
        }
        k3();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f333r0 = pa.r.j();
        this.f334s0 = pa.r.e();
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.d(this.f10459q0);
        y5.f fVar = new y5.f(Collections.EMPTY_LIST);
        this.f335t0 = fVar;
        fVar.K(a6.l.class, new a6.m());
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: a9.l
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                o.h3(this.f327a, view2, i10, (a6.q) obj);
            }
        });
        this.f335t0.K(a6.q.class, sVar);
        this.f10459q0.setAdapter(this.f335t0);
        k3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.a(zVar, x7.u.R0);
    }

    public final List j3(p9.l lVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.q(1, Z0(x7.u.Q0), lVar == null ? Z0(x7.u.U8) : lVar.g()));
        arrayList.add(new a6.q(2, Z0(x7.u.P0)));
        return arrayList;
    }
}
