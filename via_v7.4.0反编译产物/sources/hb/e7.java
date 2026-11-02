package hb;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e7 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public final w9.l f6536r0 = pa.r.j();

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6537s0;

    public static /* synthetic */ void g3(e7 e7Var, a6.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        e7Var.f6536r0.A0(i11);
        qVar.h(g6.e.c(e7Var.I(), x7.j.f13649f, i11));
        e7Var.f6537s0.m(i10);
        if (i11 != 0) {
            g6.n.q(e7Var.I(), x7.u.f14122pb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(View view, int i10, a6.n nVar) {
        if (nVar.c() == 1) {
            nVar.j(!nVar.i());
            w9.a aVarV = this.f6536r0.v();
            aVarV.L(nVar.i());
            this.f6536r0.q0(aVarV);
            this.f6537s0.m(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k3(View view, final int i10, final a6.q qVar) {
        if (qVar.c() == 2) {
            w5.k.l(I()).d0(x7.u.f14094nb).Z(x7.j.f13649f, this.f6536r0.u1(), new AdapterView.OnItemClickListener() { // from class: hb.d7
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                    e7.g3(this.f6524a, qVar, i10, adapterView, view2, i11, j10);
                }
            }).f0();
        }
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.q(2, Z0(x7.u.f14094nb), g6.e.c(I(), x7.j.f13649f, this.f6536r0.u1())));
        arrayList.add(new a6.n(1, Z0(x7.u.Dc), Z0(x7.u.Ec), this.f6536r0.v().s()));
        y5.f fVar = new y5.f(arrayList);
        this.f6537s0 = fVar;
        fVar.K(a6.q.class, new a6.s(new y5.g() { // from class: hb.b7
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6485a.k3(view2, i10, (a6.q) obj);
            }
        }));
        this.f6537s0.K(a6.n.class, new a6.p(new y5.g() { // from class: hb.c7
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6513a.j3(view2, i10, (a6.n) obj);
            }
        }));
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(null);
        this.f10459q0.setAdapter(this.f6537s0);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.Pd);
    }
}
