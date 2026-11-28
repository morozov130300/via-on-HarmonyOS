package jb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u3 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f6992u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6993v0;

    public static /* synthetic */ void f3(u3 u3Var, View view, int i10, v5.n nVar) {
        u3Var.getClass();
        nVar.j(!nVar.i());
        nVar.h(u3Var.g3(nVar.i()));
        u3Var.f6993v0.m(i10);
        u3Var.j3(nVar.i());
    }

    public static List h3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, u3.class, w7.u.Fc, w7.u.Xc, w7.u.Ja);
        hVar.b(1, w7.u.Ja, new String[0]);
        return hVar.f();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f6992u0 = la.s.j();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        ArrayList arrayList = new ArrayList();
        boolean zI3 = i3();
        arrayList.add(new v5.n(1, X0(w7.u.Ja), g3(zI3), zI3));
        this.f6993v0 = new t5.f(arrayList);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: jb.t3
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                u3.f3(this.f6979a, view2, i10, (v5.n) obj);
            }
        });
        this.f6993v0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f6993v0);
        SettingsSearchLocator.b(this, this.f7946t0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.Ja));
    }

    public final String g3(boolean z10) {
        return X0(z10 ? w7.u.f13996c1 : w7.u.Ka);
    }

    public final boolean i3() {
        return !this.f6992u0.n2().h();
    }

    public final void j3(boolean z10) {
        u9.p pVarN2 = this.f6992u0.n2();
        pVarN2.I(!z10);
        this.f6992u0.F1(pVarN2);
    }
}
