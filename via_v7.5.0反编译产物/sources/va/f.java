package va;

import android.R;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import c6.a2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public t9.g f13481u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f13482v0;

    public static /* synthetic */ void g3(f fVar, View view, q5.k.p pVar) {
        fVar.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        String strK3 = fVar.k3(pVar.f11819c[0]);
        if (strK3.isEmpty()) {
            return;
        }
        fVar.m3(strK3, false);
        fVar.l3();
    }

    public static /* synthetic */ void h3(f fVar, String str, View view, q5.k.p pVar) {
        fVar.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        String strK3 = fVar.k3(pVar.f11819c[0]);
        if (strK3.isEmpty() || strK3.equals(str)) {
            return;
        }
        fVar.m3(str, true);
        fVar.m3(strK3, false);
        fVar.l3();
    }

    public static /* synthetic */ void i3(f fVar, View view, int i10, v5.q qVar) {
        fVar.getClass();
        fVar.o3(qVar.a());
    }

    public static /* synthetic */ void j3(f fVar, String str, View view) {
        fVar.m3(str, true);
        fVar.l3();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f13481u0 = la.s.i();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f13482v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: va.b
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                f.i3(this.f13460a, view2, i10, (v5.q) obj);
            }
        });
        this.f13482v0.K(v5.q.class, sVar);
        this.f7946t0.setAdapter(this.f13482v0);
        l3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.dd);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(0, 0, lb.g.a(G(), w7.o.f13810m, w7.u.ge), X0(w7.u.O)), new View.OnClickListener() { // from class: va.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13456a.n3();
            }
        });
    }

    public final String k3(String str) {
        String strTrim = str == null ? "" : str.trim();
        if (strTrim.contains("://")) {
            strTrim = a2.f1958a.f(strTrim);
        }
        return y9.c.f(strTrim);
    }

    public final void l3() {
        List<String> listL = this.f13481u0.l();
        Collections.sort(listL, new i8.p());
        ArrayList arrayList = new ArrayList(listL.size());
        for (String str : listL) {
            arrayList.add(new v5.q(str.hashCode(), str));
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f13482v0.H(), arrayList));
        this.f13482v0.M(arrayList);
        eVarB.c(this.f13482v0);
        d3(listL.isEmpty());
    }

    public final void m3(String str, boolean z10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f13481u0.c("https://" + str, z10);
    }

    public final void n3() {
        q5.k.l(G()).f0(w7.u.O).v(false).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: va.e
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                f.g3(this.f13472a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void o3(final String str) {
        q5.k.l(G()).f0(w7.u.E).v(false).i(str, "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: va.c
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                f.h3(this.f13464a, str, view, pVar);
            }
        }).P(R.string.cancel, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: va.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.j3(this.f13468a, str, view);
            }
        }).h0();
    }
}
