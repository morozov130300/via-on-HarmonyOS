package hb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class y4 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final u9.l f6161u0 = la.s.j();

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6162v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public u9.p f6163w0;

    public static List g3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, y4.class, w7.u.Hc);
        hVar.b(1, w7.u.U3, "DNT");
        hVar.b(6, w7.u.Q3, new String[0]);
        hVar.b(4, w7.u.S3, "GPC");
        return hVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3(View view, int i10, v5.n nVar) {
        int iC = nVar.c();
        if (iC == 1) {
            nVar.j(!nVar.i());
            this.f6163w0.O(nVar.i());
            this.f6161u0.F1(this.f6163w0);
            u9.n.e().w(true);
        } else if (iC == 4) {
            nVar.j(!nVar.i());
            this.f6163w0.e0(nVar.i());
            this.f6161u0.F1(this.f6163w0);
            u9.n.e().w(true);
        } else if (iC == 5) {
            nVar.j(!nVar.i());
            this.f6163w0.b0(nVar.i());
            this.f6161u0.F1(this.f6163w0);
            u9.n.e().w(true);
        } else if (iC == 6) {
            nVar.j(!nVar.i());
            this.f6163w0.i0(nVar.i());
            this.f6161u0.F1(this.f6163w0);
        }
        this.f6162v0.m(i10);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f6163w0 = this.f6161u0.n2();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.n(1, X0(w7.u.U3), this.f6163w0.m()));
        arrayList.add(new v5.n(6, X0(w7.u.Q3), this.f6163w0.E()));
        arrayList.add(new v5.n(4, X0(w7.u.S3), X0(w7.u.T3), this.f6163w0.A()));
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(null);
        t5.f fVar = new t5.f(arrayList);
        this.f6162v0 = fVar;
        fVar.K(v5.n.class, new v5.p(new t5.g() { // from class: hb.x4
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6146a.h3(view2, i10, (v5.n) obj);
            }
        }));
        this.f7946t0.setAdapter(this.f6162v0);
        SettingsSearchLocator.b(this, this.f7946t0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        x8.v3.a(e0Var, w7.u.Hc);
    }
}
