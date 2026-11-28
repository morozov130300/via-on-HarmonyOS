package hb;

import android.R;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h5 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public t5.f f5889u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public q8.b f5890v0;

    public static /* synthetic */ void g3(h5 h5Var, View view, q5.k.p pVar) {
        h5Var.getClass();
        h5Var.f5890v0.b().m(pVar.f11819c[0].trim());
        h5Var.r3();
    }

    public static /* synthetic */ void h3(h5 h5Var, View view, q5.k.p pVar) {
        h5Var.getClass();
        h5Var.f5890v0.b().a(pVar.f11819c[0].trim());
        h5Var.r3();
    }

    public static /* synthetic */ void i3(h5 h5Var, View view, int i10, v5.n nVar) {
        h5Var.getClass();
        if (nVar.c() == 1) {
            h5Var.s3(!nVar.i());
        } else if (nVar.c() == 2) {
            h5Var.t3(!nVar.i());
        }
    }

    public static /* synthetic */ void j3(h5 h5Var, String str, View view) {
        h5Var.f5890v0.b().k(str);
        h5Var.r3();
    }

    public static /* synthetic */ void l3(h5 h5Var, View view, int i10, v5.q qVar) {
        h5Var.getClass();
        if (qVar.c() == 4) {
            h5Var.q3(qVar.d());
        } else {
            h5Var.p3(qVar.a());
        }
    }

    public static /* synthetic */ void m3(h5 h5Var, String str, View view, q5.k.p pVar) {
        h5Var.getClass();
        String strTrim = pVar.f11819c[0].trim();
        h5Var.f5890v0.b().k(str);
        h5Var.f5890v0.b().a(strTrim);
        h5Var.r3();
    }

    private void r3() {
        u3(o3(this.f5890v0.b()));
    }

    private void u3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f5889u0.H(), list));
        this.f5889u0.M(list);
        eVarB.c(this.f5889u0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void D1() {
        if (this.f5890v0.b().g()) {
            x8.h.b(new Runnable() { // from class: hb.z4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6177c.f5890v0.b().b();
                }
            });
            if (this.f5890v0.b().f()) {
                this.f5890v0.f();
                this.f5890v0.e();
            } else {
                this.f5890v0.f();
            }
        }
        super.D1();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f5889u0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: hb.a5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                h5.l3(this.f5788a, view2, i10, (v5.q) obj);
            }
        });
        this.f5889u0.K(v5.q.class, sVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: hb.b5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f5813a.n3();
            }
        });
        this.f5889u0.K(v5.e.class, fVar);
        this.f5889u0.K(v5.l.class, new v5.m());
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: hb.c5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                h5.i3(this.f5827a, view2, i10, (v5.n) obj);
            }
        });
        this.f5889u0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f5889u0);
        SettingsSearchLocator.b(this, this.f7946t0);
        r3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, "Proxy");
    }

    public final void n3() {
        q5.k.l(G()).g0(this.f5890v0.b().h() ? "Add proxy rule" : "Add bypass rule").i("", "*example.com", 1).X(R.string.ok, new q5.k.m() { // from class: hb.g5
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                h5.h3(this.f5881a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final List o3(q8.c cVar) {
        ArrayList arrayList = new ArrayList();
        if (!q8.b.c()) {
            arrayList.add(new v5.q(0, "Enable Proxy", "Proxy is not supported.", true));
            return arrayList;
        }
        arrayList.add(new v5.n(1, "Enable proxy", null, cVar.f()));
        arrayList.add(new v5.q(4, "Proxy url", cVar.d()));
        arrayList.add(new v5.n(2, "Reverse bypass rules", (String) null, cVar.h(), !q8.b.d()));
        arrayList.add(new v5.e(3, cVar.h() ? "Add proxy rule" : "Add bypass rule", lb.g.a(G(), w7.o.f13810m, w7.u.ge)));
        Set setC = cVar.c();
        if (setC != null && !setC.isEmpty()) {
            if (cVar.h()) {
                arrayList.add(new v5.l("Proxy rules"));
            } else {
                arrayList.add(new v5.l("Bypass rules"));
            }
            ArrayList<String> arrayList2 = new ArrayList(setC);
            Collections.sort(arrayList2);
            for (String str : arrayList2) {
                arrayList.add(new v5.q(str.hashCode(), str));
            }
        }
        return arrayList;
    }

    public final void p3(final String str) {
        q5.k.l(G()).g0(this.f5890v0.b().h() ? "Edit proxy rule" : "Edit bypass rule").i(str, "*example.com", 1).X(R.string.ok, new q5.k.m() { // from class: hb.e5
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                h5.m3(this.f5854a, str, view, pVar);
            }
        }).P(R.string.cancel, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: hb.f5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h5.j3(this.f5869a, str, view);
            }
        }).h0();
    }

    public final void q3(String str) {
        q5.k.l(G()).g0("Proxy url").i(str, "socks://127.0.0.1:1080", 1).X(R.string.ok, new q5.k.m() { // from class: hb.d5
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                h5.g3(this.f5842a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void s3(boolean z10) {
        this.f5890v0.b().l(z10);
        r3();
    }

    public final void t3(boolean z10) {
        this.f5890v0.b().n(z10);
        r3();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        la.s.b(G()).t(this);
    }
}
