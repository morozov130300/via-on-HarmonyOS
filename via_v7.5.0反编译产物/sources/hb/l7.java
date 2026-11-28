package hb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l7 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f5958u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f5959v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public com.tuyafeng.support.widget.c f5960w0 = null;

    public static /* synthetic */ void f3(l7 l7Var, q5.k kVar, int i10) {
        l7Var.f5958u0.v2(i10);
        l7Var.q3();
        kVar.o();
    }

    public static /* synthetic */ void g3(l7 l7Var, AdapterView adapterView, View view, int i10, long j10) {
        l7Var.f5958u0.k(i10);
        u9.a aVarV = l7Var.f5958u0.v();
        boolean z10 = true;
        if (i10 != 2 && i10 != 1) {
            z10 = false;
        }
        if (aVarV.t() && !z10) {
            aVarV.L(false);
            l7Var.f5958u0.Z(aVarV);
        }
        l7Var.q3();
    }

    public static /* synthetic */ void j3(l7 l7Var, AdapterView adapterView, View view, int i10, long j10) {
        l7Var.f5958u0.E0(i10);
        l7Var.q3();
    }

    public static /* synthetic */ void k3(l7 l7Var, u9.a aVar, AdapterView adapterView, View view, int i10, long j10) {
        l7Var.f5958u0.k(i10 + 1);
        l7Var.f5958u0.v().L(true);
        l7Var.f5958u0.Z(aVar);
        l7Var.q3();
    }

    private List m3() {
        ArrayList arrayList = new ArrayList();
        int iZ0 = this.f5958u0.z0();
        boolean z10 = (iZ0 == 2 || iZ0 == 1) && this.f5958u0.v().t();
        int iI1 = this.f5958u0.i1();
        arrayList.add(new ib.b0(iZ0, z10, iI1));
        arrayList.add(new v5.q(1, X0(w7.u.oh), com.tuyafeng.support.utils.e.c(G(), w7.j.f13717h, iZ0)));
        arrayList.add(new v5.q(2, X0(w7.u.f13987b6), com.tuyafeng.support.utils.e.c(G(), w7.j.f13712c, this.f5958u0.s2())));
        arrayList.add(new v5.n(3, X0(w7.u.K4), z10));
        arrayList.add(new v5.q(4, X0(w7.u.Nh), com.tuyafeng.support.utils.e.c(G(), w7.j.f13719j, iI1)));
        arrayList.add(new v5.n(5, X0(w7.u.D2), X0(w7.u.E2), this.f5958u0.B2()));
        return arrayList;
    }

    public static List p3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, l7.class, w7.u.Fc, w7.u.Ug);
        hVar.b(1, w7.u.oh, new String[0]);
        hVar.a(2, w7.u.f13987b6, w7.j.f13712c);
        hVar.b(3, w7.u.K4, new String[0]);
        hVar.b(4, w7.u.Nh, new String[0]);
        hVar.b(5, w7.u.D2, "变色", "上色");
        return hVar.f();
    }

    private void q3() {
        t3(m3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(v5.n nVar, int i10) {
        int iC = nVar.c();
        if (iC == 3) {
            n3();
        } else if (iC == 5) {
            this.f5958u0.Z0(!nVar.i());
            q3();
        }
    }

    private void t3(List list) {
        t5.f fVar = this.f5959v0;
        if (fVar == null) {
            return;
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new ib.c0(fVar.H(), list));
        this.f5959v0.M(list);
        eVarB.c(this.f5959v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5958u0 = la.s.j();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f5959v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: hb.f7
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5872a.s3((v5.q) obj, i10);
            }
        });
        this.f5959v0.K(v5.q.class, sVar);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: hb.g7
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5883a.r3((v5.n) obj, i10);
            }
        });
        this.f5959v0.K(v5.n.class, pVar);
        this.f5959v0.K(ib.b0.class, new ib.k0());
        this.f7946t0.setAdapter(this.f5959v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        q3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.Ug);
    }

    public final void l3() {
        q5.k.l(G()).f0(w7.u.oh).b0(w7.j.f13717h, this.f5958u0.z0(), new AdapterView.OnItemClickListener() { // from class: hb.i7
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                l7.g3(this.f5912a, adapterView, view, i10, j10);
            }
        }).h0();
    }

    public final void n3() {
        int iZ0 = this.f5958u0.z0();
        boolean z10 = iZ0 == 2 || iZ0 == 1;
        final u9.a aVarV = this.f5958u0.v();
        boolean zT = aVarV.t();
        boolean z11 = !zT;
        if (!zT && !z10) {
            q5.k.l(G()).f0(w7.u.oh).J(w7.u.Gg).t(1).d0(new String[]{X0(w7.u.qh), X0(w7.u.ph)}, -1, new AdapterView.OnItemClickListener() { // from class: hb.h7
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                    l7.k3(this.f5892a, aVarV, adapterView, view, i10, j10);
                }
            }).h0();
            return;
        }
        aVarV.L(z11);
        this.f5958u0.Z(aVarV);
        q3();
    }

    public final void o3() {
        com.tuyafeng.support.widget.c cVar = this.f5960w0;
        if (cVar == null) {
            com.tuyafeng.support.widget.c cVar2 = new com.tuyafeng.support.widget.c(G());
            this.f5960w0 = cVar2;
            int[] iArr = {w7.o.f13838v0, w7.o.f13841w0, w7.o.f13844x0};
            cVar2.setItemTextColor(v8.h.o(G()));
            this.f5960w0.setItemHighlightColor(v8.h.j(G()));
            this.f5960w0.setItemDrawableTint(v8.h.l(G()));
            this.f5960w0.setItemDrawaleHeight(com.tuyafeng.support.utils.x.h(G(), 90.0f));
            this.f5960w0.setItemDrawableWidth(com.tuyafeng.support.utils.x.h(G(), 50.0f));
            this.f5960w0.setItemTextSize(v8.h.u(G()));
            this.f5960w0.setItemBackground(com.tuyafeng.support.utils.f.e(G(), w7.o.f13783d));
            this.f5960w0.c(w7.j.f13712c, iArr, this.f5958u0.s2());
        } else {
            ((ViewGroup) cVar.getParent()).removeAllViews();
        }
        final q5.k kVarZ = q5.k.l(G()).f0(w7.u.f13987b6).z(this.f5960w0);
        kVarZ.h0();
        this.f5960w0.setHighlightChangedListener(new com.tuyafeng.support.widget.c.b() { // from class: hb.k7
            @Override // com.tuyafeng.support.widget.c.b
            public final void a(int i10) {
                l7.f3(this.f5941a, kVarZ, i10);
            }
        });
    }

    public final void s3(v5.q qVar, int i10) {
        int iC = qVar.c();
        if (iC == 1) {
            l3();
        } else if (iC == 2) {
            o3();
        } else if (iC == 4) {
            u3();
        }
    }

    public final void u3() {
        q5.k.l(G()).f0(w7.u.Nh).b0(w7.j.f13719j, this.f5958u0.i1(), new AdapterView.OnItemClickListener() { // from class: hb.j7
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                l7.j3(this.f5925a, adapterView, view, i10, j10);
            }
        }).h0();
    }
}
