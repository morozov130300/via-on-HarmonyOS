package jb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import hb.w6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class y4 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f7048u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f7049v0;

    /* JADX INFO: Access modifiers changed from: private */
    public List i3() {
        String strG;
        u9.p pVarN2 = this.f7048u0.n2();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(1, X0(w7.u.V0)));
        arrayList.add(new v5.l(X0(w7.u.f14025e2)));
        arrayList.add(new v5.q(14, X0(w7.u.ed), String.format(Locale.ROOT, "%d%%", Integer.valueOf(this.f7048u0.H0()))));
        List listE = x8.c4.e(G());
        int iO0 = this.f7048u0.o0();
        Iterator it = listE.iterator();
        while (true) {
            if (!it.hasNext()) {
                strG = null;
                break;
            }
            ga.c cVar = (ga.c) it.next();
            if (cVar.d() == iO0) {
                strG = cVar.g();
                break;
            }
        }
        arrayList.add(new v5.q(3, X0(w7.u.F0), strG));
        arrayList.add(new v5.q(17, X0(w7.u.U), X0(pVarN2.l() ? w7.u.f14158n9 : w7.u.f14116k9)));
        String strK3 = k3(pVarN2.q());
        if (pVarN2.r()) {
            strK3 = X0(w7.u.P6);
        }
        arrayList.add(new v5.q(2, X0(w7.u.K6), strK3));
        arrayList.add(new v5.q(8, X0(w7.u.f14306y7), k3(pVarN2.t())));
        arrayList.add(new v5.q(9, X0(w7.u.L2), (!pVarN2.j() || pVarN2.B()) ? k3(pVarN2.j()) : X0(w7.u.N2)));
        arrayList.add(new v5.q(10, X0(w7.u.Ja), X0(pVarN2.h() ? w7.u.f14108k1 : w7.u.f13996c1)));
        arrayList.add(new v5.l(X0(w7.u.f14011d2)));
        arrayList.add(new v5.q(12, X0(w7.u.G1), X0(pVarN2.g() ? w7.u.f14158n9 : w7.u.f14116k9)));
        arrayList.add(new v5.l(X0(w7.u.f14039f2)));
        arrayList.add(new v5.q(4, X0(w7.u.f14235t2), m3(pVarN2.e())));
        arrayList.add(new v5.q(11, X0(w7.u.f14256u9), m3(pVarN2.f())));
        arrayList.add(new v5.q(5, X0(w7.u.S7), j3(pVarN2.u())));
        arrayList.add(new v5.q(6, X0(w7.u.S1), j3(pVarN2.i())));
        arrayList.add(new v5.q(7, X0(w7.u.A8), j3(pVarN2.v())));
        arrayList.add(new v5.q(13, X0(w7.u.f14103ja), pVarN2.k() ? k3(true) : X0(w7.u.f14173oa)));
        arrayList.add(new v5.q(15, X0(w7.u.gi), k3(pVarN2.D())));
        arrayList.add(new v5.l(X0(w7.u.Dc)));
        arrayList.add(new v5.q(16, X0(w7.u.Ra), X0(pVarN2.p() ? w7.u.f14158n9 : w7.u.f14116k9)));
        return arrayList;
    }

    public static List l3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, y4.class, w7.u.Fc, w7.u.Xc);
        hVar.b(1, w7.u.V0, new String[0]);
        hVar.c("mark.via.settings.site.TextSizeSettingsFragment.1", 14, w7.u.ed, new String[0]);
        hVar.c("mark.via.settings.site.UserAgentSettingsFragment.1", 3, w7.u.F0, new String[0]);
        hVar.c("mark.via.settings.site.DesktopModeSettingsFragment.1", 17, w7.u.U, new String[0]);
        hVar.c("mark.via.settings.site.ImagesSettingsFragment.1", 2, w7.u.K6, new String[0]);
        hVar.c("mark.via.settings.site.JavaScriptSettingsFragment.1", 8, w7.u.f14306y7, new String[0]);
        hVar.c("mark.via.settings.site.CookiesSettingsFragment.1", 9, w7.u.L2, new String[0]);
        hVar.c("mark.via.settings.site.PopupsSettingsFragment.1", 10, w7.u.Ja, new String[0]);
        hVar.c("mark.via.blocker.AdBlockFragment.1", 12, w7.u.G1, new String[0]);
        hVar.c("mark.via.settings.site.ClipboardSettingsFragment.1", 4, w7.u.f14235t2, new String[0]);
        hVar.c("mark.via.settings.site.OpenAppSettingsFragment.1", 11, w7.u.f14256u9, new String[0]);
        hVar.c("mark.via.settings.site.LocationSettingsFragment.1", 5, w7.u.S7, new String[0]);
        hVar.c("mark.via.settings.site.CameraSettingsFragment.1", 6, w7.u.S1, new String[0]);
        hVar.c("mark.via.settings.site.MicrophoneSettingsFragment.1", 7, w7.u.A8, new String[0]);
        hVar.c("mark.via.settings.site.PageRedirectionSettingsFragment.1", 13, w7.u.f14103ja, new String[0]);
        hVar.c("mark.via.settings.site.VibrateSettingsFragment.1", 15, w7.u.gi, new String[0]);
        hVar.c("mark.via.settings.site.GoBackWithoutReloadingSettingsFragment.1", 16, w7.u.Ra, new String[0]);
        return hVar.f();
    }

    private void n3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: jb.v4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f7014c.i3();
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: jb.w4
            @Override // u6.f
            public final void accept(Object obj) {
                this.f7023c.p3((List) obj);
            }
        }, new w7.e0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3(View view, int i10, v5.q qVar) {
        switch (qVar.c()) {
            case 1:
                FragmentUtils.i(this, w6.class);
                break;
            case 2:
                FragmentUtils.i(this, n1.class);
                break;
            case 3:
                FragmentUtils.i(this, v5.class);
                break;
            case 4:
                FragmentUtils.i(this, e0.class);
                break;
            case 5:
                FragmentUtils.i(this, j2.class);
                break;
            case 6:
                FragmentUtils.i(this, t.class);
                break;
            case 7:
                FragmentUtils.i(this, u2.class);
                break;
            case 8:
                FragmentUtils.i(this, y1.class);
                break;
            case 9:
                FragmentUtils.i(this, i0.class);
                break;
            case 10:
                FragmentUtils.i(this, u3.class);
                break;
            case 11:
                FragmentUtils.i(this, f3.class);
                break;
            case 12:
                FragmentUtils.i(this, i.class);
                break;
            case 13:
                FragmentUtils.i(this, q3.class);
                break;
            case 14:
                FragmentUtils.i(this, k5.class);
                break;
            case 15:
                FragmentUtils.i(this, z5.class);
                break;
            case 16:
                FragmentUtils.i(this, c1.class);
                break;
            case 17:
                FragmentUtils.i(this, r0.class);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f7049v0.H(), list));
        this.f7049v0.M(list);
        eVarB.c(this.f7049v0);
    }

    @Override // androidx.fragment.app.Fragment
    public void G1(boolean z10) {
        super.G1(z10);
        if (z10) {
            return;
        }
        n3();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7048u0 = la.s.j();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7049v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: jb.x4
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7036a.o3(view2, i10, (v5.q) obj);
            }
        });
        this.f7049v0.K(v5.q.class, sVar);
        this.f7049v0.K(v5.l.class, new v5.m());
        this.f7946t0.setAdapter(this.f7049v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        n3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.Xc));
    }

    public final String j3(boolean z10) {
        return X0(z10 ? w7.u.f14108k1 : w7.u.J1);
    }

    public final String k3(boolean z10) {
        return X0(z10 ? w7.u.f13996c1 : w7.u.J1);
    }

    public final String m3(int i10) {
        if (i10 == 1 || i10 == 2) {
            return k3(i10 == 1);
        }
        return i10 != 3 ? "" : X0(w7.u.f14108k1);
    }
}
