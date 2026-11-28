package g8;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.widget.e0;
import java.util.ArrayList;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f5581u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f5582v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public List f5583w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public List f5584x0;

    public static /* synthetic */ void g3(w wVar, View view, int i10, v5.n nVar) {
        wVar.getClass();
        int iC = nVar.c();
        if (wVar.f5584x0.contains(Integer.valueOf(iC))) {
            wVar.f5584x0.remove(Integer.valueOf(iC));
        } else {
            wVar.f5584x0.add(Integer.valueOf(iC));
        }
        nVar.j(!wVar.f5584x0.contains(Integer.valueOf(iC)));
        wVar.f5582v0.m(i10);
        int[] iArr = new int[wVar.f5584x0.size()];
        for (int i11 = 0; i11 < wVar.f5584x0.size(); i11++) {
            iArr[i11] = ((Integer) wVar.f5584x0.get(i11)).intValue();
        }
        wVar.f5581u0.V1(iArr);
    }

    public static /* synthetic */ void h3(w wVar, View view, q5.k.p pVar) {
        wVar.f5581u0.V1(null);
        wVar.j3();
    }

    public static List i3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, w.class, w7.u.Fc, w7.u.f13998c3);
        hVar.b(0, w7.u.R, new String[0]);
        hVar.b(1, w7.u.S, new String[0]);
        hVar.b(2, w7.u.f14135m0, new String[0]);
        hVar.b(6, w7.u.f13981b0, new String[0]);
        hVar.b(38, w7.u.C, new String[0]);
        hVar.b(39, w7.u.f14246u, new String[0]);
        hVar.b(33, w7.u.Lc, new String[0]);
        hVar.b(7, w7.u.f14035ec, new String[0]);
        hVar.b(8, w7.u.V, new String[0]);
        hVar.b(22, w7.u.T, new String[0]);
        hVar.b(23, w7.u.M, new String[0]);
        hVar.b(29, w7.u.f14259v, new String[0]);
        hVar.b(35, w7.u.f14023e0, new String[0]);
        hVar.b(34, w7.u.Qb, "扫码");
        hVar.b(3, w7.u.f14218s, new String[0]);
        hVar.b(31, w7.u.f14037f0, new String[0]);
        return hVar.f();
    }

    private void j3() {
        this.f5583w0.clear();
        this.f5583w0.add(new v5.n(0, X0(w7.u.R), true));
        this.f5583w0.add(new v5.n(1, X0(w7.u.S), true));
        this.f5583w0.add(new v5.n(2, X0(w7.u.f14135m0), true));
        this.f5583w0.add(new v5.n(6, X0(w7.u.f13981b0), true));
        this.f5583w0.add(new v5.n(38, X0(w7.u.C), true));
        this.f5583w0.add(new v5.n(39, X0(w7.u.f14246u), true));
        this.f5583w0.add(new v5.n(33, X0(w7.u.Lc), true));
        this.f5583w0.add(new v5.n(7, X0(w7.u.f14035ec), true));
        this.f5583w0.add(new v5.n(8, X0(w7.u.V), true));
        this.f5583w0.add(new v5.n(22, X0(w7.u.T), true));
        this.f5583w0.add(new v5.n(23, X0(w7.u.M), true));
        this.f5583w0.add(new v5.n(29, X0(w7.u.f14259v), true));
        this.f5583w0.add(new v5.n(35, X0(w7.u.f14023e0), true));
        this.f5583w0.add(new v5.n(34, X0(w7.u.Qb), true));
        this.f5583w0.add(new v5.n(3, X0(w7.u.f14218s), true));
        this.f5583w0.add(new v5.n(31, X0(w7.u.f14037f0), true));
        int[] iArrE1 = this.f5581u0.E1();
        this.f5584x0.clear();
        for (v5.n nVar : this.f5583w0) {
            if (com.tuyafeng.support.utils.a.b(iArrE1, nVar.c())) {
                this.f5584x0.add(Integer.valueOf(nVar.c()));
                nVar.j(false);
            }
        }
        this.f5582v0.l();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5584x0 = new ArrayList();
        this.f5581u0 = la.s.j();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f5583w0 = new ArrayList();
        this.f5582v0 = new t5.f(this.f5583w0);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: g8.t
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                w.g3(this.f5578a, view2, i10, (v5.n) obj);
            }
        });
        this.f5582v0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f5582v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        j3();
    }

    @Override // m8.g
    public void Z2(e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.f13998c3);
        e0Var.c(new e0.b(com.tuyafeng.support.utils.x.l(), 0, null, X0(w7.u.Z)), new View.OnClickListener() { // from class: g8.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w wVar = this.f5579a;
                q5.k.l(wVar.G()).f0(w7.u.f14230sb).J(w7.u.K3).X(w7.u.Z, new q5.k.m() { // from class: g8.v
                    @Override // q5.k.m
                    public final void a(View view2, q5.k.p pVar) {
                        w.h3(wVar, view2, pVar);
                    }
                }).P(R.string.cancel, null).h0();
            }
        });
    }
}
