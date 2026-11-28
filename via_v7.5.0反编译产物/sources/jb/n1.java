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
public class n1 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public o1 f6905u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6906v0;

    public static /* synthetic */ void f3(n1 n1Var, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (i11 == i10) {
            n1Var.getClass();
        } else {
            n1Var.f6905u0.u(i11 == 2, i11 != 1);
        }
    }

    public static /* synthetic */ void m3(n1 n1Var, View view, q5.k.p pVar) {
        n1Var.getClass();
        String strF = y9.c.f(pVar.f11819c[0]);
        o1 o1Var = n1Var.f6905u0;
        o1Var.l(strF, !o1Var.q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        q5.k.l(G()).f0(w7.u.f14312z0).K(X0(this.f6905u0.q() ? w7.u.M6 : w7.u.L6)).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: jb.h1
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                n1.m3(this.f6827a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    private void p3(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        q5.k.l(G()).g0(y9.c.e(str)).d0(new String[]{X0(w7.u.X0), X0(w7.u.E1)}, !this.f6905u0.r(str) ? 1 : 0, new AdapterView.OnItemClickListener() { // from class: jb.l1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f6880a.f6905u0.l(str, i10 == 0);
            }
        }).X(R.string.ok, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: jb.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6895a.f6905u0.t(str);
            }
        }).h0();
    }

    public static List r3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, n1.class, w7.u.Fc, w7.u.Xc, w7.u.K6);
        hVar.b(1, w7.u.K6, new String[0]);
        hVar.b(2, w7.u.f14312z0, new String[0]);
        return hVar.f();
    }

    private void s3() {
        this.f6905u0.p().g(b1(), new androidx.lifecycle.o() { // from class: jb.i1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                n1 n1Var = this.f6841a;
                n1Var.u3(n1Var.o3((u9.p) obj, n1Var.f6905u0.m()));
            }
        });
        this.f6905u0.n().g(b1(), new androidx.lifecycle.o() { // from class: jb.j1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                n1 n1Var = this.f6855a;
                n1Var.u3(n1Var.o3(n1Var.f6905u0.o(), (kb.a) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3(View view, int i10, v5.q qVar) {
        final int i11 = 1;
        if (qVar.c() != 1) {
            p3(qVar.a());
            return;
        }
        u9.p pVarO = this.f6905u0.o();
        if (pVarO == null) {
            return;
        }
        String[] strArr = {X0(w7.u.I6), X0(w7.u.H6), X0(w7.u.G6)};
        if (pVarO.r()) {
            i11 = 2;
        } else if (pVarO.q()) {
            i11 = 0;
        }
        q5.k.l(G()).g0(X0(w7.u.K6)).d0(strArr, i11, new AdapterView.OnItemClickListener() { // from class: jb.k1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i12, long j10) {
                n1.f3(this.f6865a, i11, adapterView, view2, i12, j10);
            }
        }).h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f6906v0.H(), list));
        this.f6906v0.M(list);
        eVarB.c(this.f6906v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6906v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: jb.f1
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6808a.t3(view2, i10, (v5.q) obj);
            }
        });
        this.f6906v0.K(v5.q.class, sVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: jb.g1
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6816a.n3();
            }
        });
        this.f6906v0.K(v5.e.class, fVar);
        this.f6906v0.K(v5.l.class, new v5.m());
        this.f7946t0.setAdapter(this.f6906v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        s3();
        this.f6905u0.s();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.K6));
    }

    public final List o3(u9.p pVar, kb.a aVar) {
        ArrayList arrayList = new ArrayList();
        boolean z10 = pVar == null || pVar.q() || pVar.r();
        if (pVar == null) {
            arrayList.add(new v5.q(1, X0(w7.u.K6)));
        } else {
            arrayList.add(new v5.q(1, X0(w7.u.K6), q3(pVar.q(), pVar.r())));
        }
        arrayList.add(new v5.e(2, X0(w7.u.f14312z0), lb.g.a(G(), w7.o.f13810m, w7.u.ge)));
        if (aVar != null) {
            if (aVar.i() != null && !aVar.i().isEmpty()) {
                arrayList.add(new v5.l(X0(w7.u.J1)));
                for (String str : aVar.i()) {
                    arrayList.add(new v5.q(str.hashCode(), str));
                }
            }
            if (aVar.j() != null && !aVar.j().isEmpty()) {
                arrayList.add(new v5.l(X0(z10 ? w7.u.f13996c1 : w7.u.V4)));
                for (String str2 : aVar.j()) {
                    arrayList.add(new v5.q(str2.hashCode(), str2));
                }
            }
        }
        return arrayList;
    }

    public final String q3(boolean z10, boolean z11) {
        if (z11) {
            return X0(w7.u.O6);
        }
        return z10 ? X0(w7.u.N6) : X0(w7.u.J1);
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f6905u0 = (o1) new androidx.lifecycle.a0(this, la.s.n()).a(o1.class);
    }
}
