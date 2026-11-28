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
public class z5 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f7062u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f7063v0;

    public static /* synthetic */ void f3(z5 z5Var, View view, int i10, v5.n nVar) {
        z5Var.getClass();
        nVar.j(!nVar.i());
        nVar.h(z5Var.h3(nVar.i()));
        z5Var.f7063v0.m(i10);
        z5Var.j3(nVar.i());
    }

    public static List g3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, z5.class, w7.u.Fc, w7.u.Xc, w7.u.gi);
        hVar.b(1, w7.u.gi, new String[0]);
        return hVar.f();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7062u0 = la.s.j();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        ArrayList arrayList = new ArrayList();
        boolean zI3 = i3();
        arrayList.add(new v5.n(1, X0(w7.u.gi), h3(zI3), zI3));
        this.f7063v0 = new t5.f(arrayList);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: jb.y5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                z5.f3(this.f7050a, view2, i10, (v5.n) obj);
            }
        });
        this.f7063v0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f7063v0);
        SettingsSearchLocator.b(this, this.f7946t0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.gi));
    }

    public final String h3(boolean z10) {
        return X0(z10 ? w7.u.hi : w7.u.R3);
    }

    public final boolean i3() {
        return this.f7062u0.n2().D();
    }

    public final void j3(boolean z10) {
        u9.p pVarN2 = this.f7062u0.n2();
        pVarN2.h0(z10);
        this.f7062u0.F1(pVarN2);
    }
}
