package jb;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n1 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public o1 f7794r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f7795s0;

    public static /* synthetic */ void g3(n1 n1Var, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (i11 == i10) {
            n1Var.getClass();
        } else {
            n1Var.f7794r0.u(i11 == 2, i11 != 1);
        }
    }

    public static /* synthetic */ void n3(n1 n1Var, View view, k.p pVar) {
        n1Var.getClass();
        String strF = ba.c.f(pVar.f13339c[0]);
        n1Var.f7794r0.l(strF, !r0.q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3() {
        w5.k.l(I()).d0(x7.u.f14216x0).J(Z0(this.f7794r0.q() ? x7.u.A6 : x7.u.f14248z6)).i("", "www.example.com", 1).V(R.string.ok, new k.m() { // from class: jb.h1
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                n1.n3(this.f7716a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    private void q3(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        w5.k.l(I()).e0(ba.c.e(str)).b0(new String[]{Z0(x7.u.U0), Z0(x7.u.f14139r1)}, !this.f7794r0.r(str) ? 1 : 0, new AdapterView.OnItemClickListener() { // from class: jb.l1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f7769a.f7794r0.l(str, i10 == 0);
            }
        }).V(R.string.ok, null).R(x7.u.f14215x, new View.OnClickListener() { // from class: jb.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7784a.f7794r0.t(str);
            }
        }).f0();
    }

    private void s3() {
        this.f7794r0.p().g(d1(), new androidx.lifecycle.m() { // from class: jb.i1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                n1 n1Var = this.f7730a;
                n1Var.u3(n1Var.p3((w9.p) obj, n1Var.f7794r0.m()));
            }
        });
        this.f7794r0.n().g(d1(), new androidx.lifecycle.m() { // from class: jb.j1
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                n1 n1Var = this.f7744a;
                n1Var.u3(n1Var.p3(n1Var.f7794r0.o(), (kb.a) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3(View view, int i10, a6.q qVar) {
        final int i11 = 1;
        if (qVar.c() != 1) {
            q3(qVar.a());
            return;
        }
        w9.p pVarO = this.f7794r0.o();
        if (pVarO == null) {
            return;
        }
        String[] strArr = {Z0(x7.u.f14209w6), Z0(x7.u.f14196v6), Z0(x7.u.f14183u6)};
        if (pVarO.r()) {
            i11 = 2;
        } else if (pVarO.q()) {
            i11 = 0;
        }
        w5.k.l(I()).e0(Z0(x7.u.f14235y6)).b0(strArr, i11, new AdapterView.OnItemClickListener() { // from class: jb.k1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i12, long j10) {
                n1.g3(this.f7754a, i11, adapterView, view2, i12, j10);
            }
        }).f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f7795s0.H(), list));
        this.f7795s0.M(list);
        eVarB.c(this.f7795s0);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7795s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: jb.f1
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7697a.t3(view2, i10, (a6.q) obj);
            }
        });
        this.f7795s0.K(a6.q.class, sVar);
        a6.f fVar = new a6.f();
        fVar.j(new y5.g() { // from class: jb.g1
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7705a.o3();
            }
        });
        this.f7795s0.K(a6.e.class, fVar);
        this.f7795s0.K(a6.l.class, new a6.m());
        this.f10459q0.setAdapter(this.f7795s0);
        s3();
        this.f7794r0.s();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.b(zVar, Z0(x7.u.f14235y6));
    }

    public final List p3(w9.p pVar, kb.a aVar) {
        ArrayList arrayList = new ArrayList();
        boolean z10 = pVar == null || pVar.q() || pVar.r();
        if (pVar == null) {
            arrayList.add(new a6.q(1, Z0(x7.u.f14235y6)));
        } else {
            arrayList.add(new a6.q(1, Z0(x7.u.f14235y6), r3(pVar.q(), pVar.r())));
        }
        arrayList.add(new a6.e(2, Z0(x7.u.f14216x0), lb.b.a(I(), x7.o.f13747n, x7.u.Rd)));
        if (aVar != null) {
            if (aVar.i() != null && !aVar.i().isEmpty()) {
                arrayList.add(new a6.l(Z0(x7.u.f14204w1)));
                for (String str : aVar.i()) {
                    arrayList.add(new a6.q(str.hashCode(), str));
                }
            }
            if (aVar.j() != null && !aVar.j().isEmpty()) {
                arrayList.add(new a6.l(Z0(z10 ? x7.u.Z0 : x7.u.I4)));
                for (String str2 : aVar.j()) {
                    arrayList.add(new a6.q(str2.hashCode(), str2));
                }
            }
        }
        return arrayList;
    }

    public final String r3(boolean z10, boolean z11) {
        return z11 ? Z0(x7.u.C6) : z10 ? Z0(x7.u.B6) : Z0(x7.u.f14204w1);
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f7794r0 = (o1) new androidx.lifecycle.y(this, pa.r.n()).a(o1.class);
    }
}
