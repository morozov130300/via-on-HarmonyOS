package hb;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e7 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final u9.l f5857u0 = la.s.j();

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f5858v0;

    public static /* synthetic */ void f3(e7 e7Var, v5.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        e7Var.f5857u0.C0(i11);
        qVar.h(com.tuyafeng.support.utils.e.c(e7Var.G(), w7.j.f13715f, i11));
        e7Var.f5858v0.m(i10);
        if (i11 != 0) {
            com.tuyafeng.support.utils.n.q(e7Var.G(), w7.u.Cb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3(View view, int i10, v5.n nVar) {
        if (nVar.c() == 1) {
            nVar.j(!nVar.i());
            u9.a aVarV = this.f5857u0.v();
            aVarV.K(nVar.i());
            this.f5857u0.Z(aVarV);
            this.f5858v0.m(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(View view, final int i10, final v5.q qVar) {
        if (qVar.c() == 2) {
            q5.k.l(G()).f0(w7.u.Ab).b0(w7.j.f13715f, this.f5857u0.v1(), new AdapterView.OnItemClickListener() { // from class: hb.d7
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                    e7.f3(this.f5844a, qVar, i10, adapterView, view2, i11, j10);
                }
            }).h0();
        }
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(2, X0(w7.u.Ab), com.tuyafeng.support.utils.e.c(G(), w7.j.f13715f, this.f5857u0.v1())));
        arrayList.add(new v5.n(1, X0(w7.u.Sc), X0(w7.u.Tc), this.f5857u0.v().s()));
        t5.f fVar = new t5.f(arrayList);
        this.f5858v0 = fVar;
        fVar.K(v5.q.class, new v5.s(new t5.g() { // from class: hb.b7
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5817a.j3(view2, i10, (v5.q) obj);
            }
        }));
        this.f5858v0.K(v5.n.class, new v5.p(new t5.g() { // from class: hb.c7
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5829a.i3(view2, i10, (v5.n) obj);
            }
        }));
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(null);
        this.f7946t0.setAdapter(this.f5858v0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.ee);
    }
}
