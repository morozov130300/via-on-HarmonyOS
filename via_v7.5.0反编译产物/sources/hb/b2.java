package hb;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b2 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f5802u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f5803v0;

    private List h3() {
        u9.d dVarT = this.f5802u0.t();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(2, X0(w7.u.jd)));
        if (Build.VERSION.SDK_INT >= 31) {
            arrayList.add(new v5.n(1, X0(w7.u.K1), X0(w7.u.L1), dVarT.e()));
        }
        if (x8.h3.f14580a) {
            arrayList.add(new v5.n(3, X0(w7.u.Nc), dVarT.g()));
        }
        return arrayList;
    }

    public static List i3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, b2.class, w7.u.f14028e5);
        hVar.b(2, w7.u.jd, new String[0]);
        if (Build.VERSION.SDK_INT >= 31) {
            hVar.b(1, w7.u.K1, new String[0]);
        }
        if (x8.h3.f14580a) {
            hVar.b(3, w7.u.Nc, new String[0]);
        }
        return hVar.f();
    }

    private void l3(List list) {
        t5.f fVar = this.f5803v0;
        if (fVar == null) {
            return;
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(fVar.H(), list));
        this.f5803v0.M(list);
        eVarB.c(this.f5803v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5802u0 = la.s.j();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f5803v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: hb.z1
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6172a.k3((v5.q) obj);
            }
        });
        this.f5803v0.K(v5.q.class, sVar);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: hb.a2
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5785a.j3((v5.n) obj, i10);
            }
        });
        this.f5803v0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f5803v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        l3(h3());
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.f14028e5));
    }

    public final void j3(v5.n nVar, int i10) {
        int iC = nVar.c();
        if (iC == 1) {
            u9.d dVarT = this.f5802u0.t();
            dVarT.h(true ^ nVar.i());
            this.f5802u0.X(dVarT);
            nVar.j(dVarT.e());
            this.f5803v0.m(i10);
            return;
        }
        if (iC == 3) {
            u9.d dVarT2 = this.f5802u0.t();
            dVarT2.j(true ^ nVar.i());
            this.f5802u0.X(dVarT2);
            nVar.j(dVarT2.g());
            this.f5803v0.m(i10);
            com.tuyafeng.support.utils.n.q(G(), w7.u.Oc);
        }
    }

    public final void k3(v5.q qVar) {
        if (qVar.c() == 2) {
            FragmentUtils.i(this, lb.p.class);
        }
    }
}
