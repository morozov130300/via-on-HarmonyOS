package jb;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f3 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public g3 f6810u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6811v0;

    public static /* synthetic */ void k3(f3 f3Var, View view, q5.k.p pVar) {
        int i10;
        f3Var.getClass();
        String strF = y9.c.f(pVar.f11819c[0]);
        if (pVar.f11818b) {
            i10 = 3;
        } else {
            i10 = f3Var.f6810u0.m() == 2 ? 1 : 2;
        }
        f3Var.f6810u0.l(strF, i10);
    }

    public static /* synthetic */ void m3(f3 f3Var, Integer num) {
        f3Var.getClass();
        f3Var.v3(f3Var.o3(num.intValue(), f3Var.f6810u0.p()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        q5.k kVarP = q5.k.l(G()).g0(X0(w7.u.f14312z0)).K(X0(this.f6810u0.m() != 2 ? w7.u.f14282w9 : w7.u.f14269v9)).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: jb.z2
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                f3.k3(this.f7059a, view, pVar);
            }
        }).P(R.string.cancel, null);
        if (this.f6810u0.m() == 2) {
            kVarP.x(w7.u.f14108k1, false);
        }
        kVarP.h0();
    }

    private List o3(int i10, kb.d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(1, X0(w7.u.f14256u9), i10 == 3 ? X0(w7.u.f14308y9) : X0(i10 == 2 ? w7.u.f14321z9 : w7.u.f14295x9)));
        arrayList.add(new v5.e(2, X0(w7.u.f14312z0), lb.g.a(G(), w7.o.f13810m, w7.u.ge)));
        if (dVar != null) {
            List<String> listE = dVar.e(2);
            if (!listE.isEmpty()) {
                arrayList.add(new v5.l(X0(w7.u.J1)));
                for (String str : listE) {
                    arrayList.add(new v5.q(str.hashCode(), str));
                }
            }
            List<String> listE2 = dVar.e(3);
            List<String> listE3 = dVar.e(1);
            if (!listE2.isEmpty() || !listE3.isEmpty()) {
                arrayList.add(new v5.l(X0(this.f6810u0.m() != 2 ? w7.u.f13996c1 : w7.u.V4)));
                for (String str2 : listE2) {
                    arrayList.add(new v5.q(str2.hashCode(), str2, X0(w7.u.f14108k1)));
                }
                for (String str3 : listE3) {
                    arrayList.add(new v5.q(str3.hashCode(), str3));
                }
            }
        }
        return arrayList;
    }

    private void p3(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        q5.k.l(G()).g0(y9.c.e(str)).d0(new String[]{X0(w7.u.X0), X0(w7.u.E1), X0(w7.u.f14108k1)}, t3(this.f6810u0.o(str)), new AdapterView.OnItemClickListener() { // from class: jb.d3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                f3 f3Var = this.f6785a;
                f3Var.f6810u0.l(str, f3Var.s3(i10));
            }
        }).X(R.string.ok, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: jb.e3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6797a.f6810u0.s(str);
            }
        }).h0();
    }

    public static List q3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, f3.class, w7.u.Fc, w7.u.Xc, w7.u.f14256u9);
        hVar.b(1, w7.u.f14256u9, new String[0]);
        hVar.b(2, w7.u.f14312z0, new String[0]);
        return hVar.f();
    }

    private void r3() {
        this.f6810u0.n().g(b1(), new androidx.lifecycle.o() { // from class: jb.a3
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                f3.m3(this.f6754a, (Integer) obj);
            }
        });
        this.f6810u0.q().g(b1(), new androidx.lifecycle.o() { // from class: jb.b3
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                f3 f3Var = this.f6760a;
                f3Var.v3(f3Var.o3(f3Var.f6810u0.m(), (kb.d) obj));
            }
        });
    }

    private int s3(int i10) {
        if (i10 == 2) {
            return 3;
        }
        return i10 == 1 ? 2 : 1;
    }

    private int t3(int i10) {
        if (i10 != 2) {
            return i10 != 3 ? 0 : 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(View view, int i10, v5.q qVar) {
        if (qVar.c() != 1) {
            p3(qVar.a());
        } else {
            q5.k.l(G()).f0(w7.u.f14256u9).d0(new String[]{X0(w7.u.X0), X0(w7.u.E1), X0(w7.u.f14108k1)}, t3(this.f6810u0.m()), new AdapterView.OnItemClickListener() { // from class: jb.c3
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                    f3 f3Var = this.f6769a;
                    f3Var.f6810u0.t(f3Var.s3(i11));
                }
            }).h0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f6811v0.H(), list));
        this.f6811v0.M(list);
        eVarB.c(this.f6811v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6811v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: jb.x2
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7034a.u3(view2, i10, (v5.q) obj);
            }
        });
        this.f6811v0.K(v5.q.class, sVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: jb.y2
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7045a.n3();
            }
        });
        this.f6811v0.K(v5.e.class, fVar);
        this.f6811v0.K(v5.l.class, new v5.m());
        this.f7946t0.setAdapter(this.f6811v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        r3();
        this.f6810u0.r();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.f14256u9));
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f6810u0 = (g3) new androidx.lifecycle.a0(this, la.s.n()).a(g3.class);
    }
}
