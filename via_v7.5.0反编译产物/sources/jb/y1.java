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
public class y1 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public z1 f7043u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f7044v0;

    public static /* synthetic */ void g3(y1 y1Var, View view, int i10, v5.q qVar) {
        y1Var.getClass();
        y1Var.p3(qVar.a());
    }

    public static /* synthetic */ void h3(y1 y1Var, Boolean bool) {
        y1Var.getClass();
        y1Var.s3(y1Var.o3(bool.booleanValue(), y1Var.f7043u0.n()));
    }

    public static /* synthetic */ void j3(y1 y1Var, boolean z10, View view, q5.k.p pVar) {
        y1Var.getClass();
        y1Var.f7043u0.l(y9.c.f(pVar.f11819c[0]), !z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        final boolean zP = this.f7043u0.p();
        q5.k.l(G()).f0(w7.u.f14312z0).K(zP ? X0(w7.u.A7) : X0(w7.u.f14319z7)).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: jb.x1
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                y1.j3(this.f7032a, zP, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    private List o3(boolean z10, kb.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.n(1, X0(w7.u.f14306y7), X0(z10 ? w7.u.B7 : w7.u.J1), z10));
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

    private void p3(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        q5.k.l(G()).g0(y9.c.e(str)).d0(new String[]{X0(w7.u.X0), X0(w7.u.E1)}, !this.f7043u0.q(str) ? 1 : 0, new AdapterView.OnItemClickListener() { // from class: jb.t1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f6976a.f7043u0.l(str, i10 == 0);
            }
        }).X(R.string.ok, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: jb.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6988a.f7043u0.s(str);
            }
        }).h0();
    }

    public static List q3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, y1.class, w7.u.Fc, w7.u.Xc, w7.u.f14306y7);
        hVar.b(1, w7.u.f14306y7, new String[0]);
        hVar.b(2, w7.u.f14312z0, new String[0]);
        return hVar.f();
    }

    private void r3() {
        this.f7043u0.m().g(b1(), new androidx.lifecycle.o() { // from class: jb.v1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                y1.h3(this.f7007a, (Boolean) obj);
            }
        });
        this.f7043u0.o().g(b1(), new androidx.lifecycle.o() { // from class: jb.w1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                y1 y1Var = this.f7019a;
                y1Var.s3(y1Var.o3(y1Var.f7043u0.p(), (kb.a) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f7044v0.H(), list));
        this.f7044v0.M(list);
        eVarB.c(this.f7044v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7044v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: jb.q1
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                y1.g3(this.f6935a, view2, i10, (v5.q) obj);
            }
        });
        this.f7044v0.K(v5.q.class, sVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: jb.r1
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6947a.n3();
            }
        });
        this.f7044v0.K(v5.e.class, fVar);
        this.f7044v0.K(v5.l.class, new v5.m());
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: jb.s1
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6965a.f7043u0.t(!((v5.n) obj).i());
            }
        });
        this.f7044v0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f7044v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        r3();
        this.f7043u0.r();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.f14306y7));
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f7043u0 = (z1) new androidx.lifecycle.a0(this, la.s.n()).a(z1.class);
    }
}
