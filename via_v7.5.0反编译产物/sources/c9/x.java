package c9;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.i0;
import com.tuyafeng.support.utils.FragmentUtils;
import hb.k1;
import java.util.ArrayList;
import java.util.List;
import x8.w3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class x extends j {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public g9.b f2354u0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements q5.k.m {
        public a() {
        }

        @Override // q5.k.m
        public void a(View view, q5.k.p pVar) {
            x.this.f2324o0.q();
        }
    }

    public static /* synthetic */ void Z2(x xVar, View view, q5.k.p pVar) {
        if (w3.d(w3.m(xVar.G()))) {
            com.tuyafeng.support.utils.n.q(xVar.G(), w7.u.f14026e3);
            xVar.f2324o0.j();
            xVar.f2324o0.p();
        }
    }

    public static /* synthetic */ void a3(x xVar, FragmentManager fragmentManager, String str, Bundle bundle) {
        xVar.getClass();
        String string = bundle.getString("text", null);
        if (string != null) {
            xVar.f2325p0.b2(string);
            u9.n.e().t(true);
            xVar.f2324o0.p();
        }
        fragmentManager.x("edit_text_result");
    }

    public static List b3(Context context) {
        Bundle bundle = new Bundle();
        bundle.putInt("settings_search_section", w7.p.f13898p0);
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, b9.q.class, bundle, w7.u.Kc, w7.u.Dc);
        hVar.c("custom.settings.5", 5, w7.u.f14105jc, new String[0]);
        hVar.c("custom.settings.3", 3, w7.u.Yb, new String[0]);
        hVar.c("custom.settings.1", 1, w7.u.f14119kc, new String[0]);
        hVar.c("custom.settings.0", 0, w7.u.W2, new String[0]);
        hVar.c("custom.settings.2", 2, w7.u.f14291x5, new String[0]);
        hVar.c("custom.settings.4", 4, w7.u.f13984b3, new String[0]);
        return hVar.f();
    }

    @Override // c9.j
    public List T2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f9.a.g(5).e(X0(w7.u.f14105jc), X0(w7.u.D6)).c(X0(w7.u.f14105jc), X0(w7.u.D0)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13836u1)).d(this.f2354u0.d()).a());
        arrayList.add(f9.a.g(3).e(X0(w7.u.Yb), X0(w7.u.Zb)).c(X0(w7.u.Yb), X0(w7.u.f13979ac)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13834u)).d(this.f2354u0.c()).a());
        arrayList.add(f9.a.g(1).e(X0(w7.u.f14119kc), X0(w7.u.f14133lc)).c(X0(w7.u.f14119kc), X0(w7.u.f14147mc)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.R)).d(this.f2354u0.e()).a());
        arrayList.add(f9.a.f(0).d(X0(w7.u.W2)).c("").b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13810m)).a());
        arrayList.add(f9.a.f(2).d(X0(w7.u.f14291x5)).c("").b(com.tuyafeng.support.utils.f.e(G(), w7.o.C)).a());
        arrayList.add(f9.a.f(4).d(X0(w7.u.f13984b3)).c("").b(com.tuyafeng.support.utils.f.e(G(), w7.o.V0)).a());
        return arrayList;
    }

    @Override // c9.j
    public void U2(f9.a aVar, int i10) {
        super.U2(aVar, i10);
        int iB = aVar.b();
        if (iB == 0) {
            c3();
            return;
        }
        if (iB == 1) {
            this.f2354u0.i(((f9.d) aVar).h());
            this.f2324o0.s(this.f2354u0);
            return;
        }
        if (iB == 2) {
            com.tuyafeng.support.utils.n.e(G(), w7.u.f14207r2, w7.u.f14221s2, new q5.k.m() { // from class: c9.v
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    x.Z2(this.f2351a, view, pVar);
                }
            });
            return;
        }
        if (iB == 3) {
            this.f2354u0.f(((f9.d) aVar).h());
            this.f2324o0.s(this.f2354u0);
        } else if (iB == 4) {
            com.tuyafeng.support.utils.n.e(G(), w7.u.f14230sb, w7.u.K3, new a());
        } else {
            if (iB != 5) {
                return;
            }
            this.f2354u0.h(((f9.d) aVar).h());
            u9.n.e().u(true);
            this.f2324o0.s(this.f2354u0);
        }
    }

    public final void c3() {
        final FragmentManager fragmentManagerL0 = K0() == null ? L0() : K0().L0();
        fragmentManagerL0.z1("edit_text_result", this, new i0() { // from class: c9.w
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                x.a3(this.f2352a, fragmentManagerL0, str, bundle);
            }
        });
        FragmentUtils.j(K0(), k1.class, k1.g3(X0(w7.u.W2), this.f2325p0.g0(), X0(w7.u.W2), true));
    }

    @Override // c9.j, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f2354u0 = this.f2324o0.l();
    }
}
