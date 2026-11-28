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
public class c1 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public d1 f6766u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6767v0;

    public static /* synthetic */ void f3(c1 c1Var, boolean z10, View view, q5.k.p pVar) {
        c1Var.getClass();
        c1Var.f6766u0.l(y9.c.f(pVar.f11819c[0]), !z10);
    }

    public static /* synthetic */ void k3(c1 c1Var, View view, int i10, v5.q qVar) {
        c1Var.getClass();
        c1Var.p3(qVar.a());
    }

    public static /* synthetic */ void l3(c1 c1Var, Boolean bool) {
        c1Var.getClass();
        c1Var.s3(c1Var.o3(bool.booleanValue(), c1Var.f6766u0.o()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        final boolean zM = this.f6766u0.m();
        q5.k.l(G()).f0(w7.u.f14312z0).K(zM ? X0(w7.u.Sa) : X0(w7.u.Ta)).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: jb.x0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                c1.f3(this.f7030a, zM, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    private List o3(boolean z10, kb.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.n(1, X0(w7.u.Ra), z10));
        arrayList.add(new v5.e(2, X0(w7.u.f14312z0), lb.g.a(G(), w7.o.f13810m, w7.u.ge)));
        if (aVar != null) {
            if (aVar.i() != null && !aVar.i().isEmpty()) {
                arrayList.add(new v5.l(X0(w7.u.f14116k9)));
                for (String str : aVar.i()) {
                    arrayList.add(new v5.q(str.hashCode(), str));
                }
            }
            if (aVar.j() != null && !aVar.j().isEmpty()) {
                arrayList.add(new v5.l(X0(z10 ? w7.u.f14158n9 : w7.u.V4)));
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
        q5.k.l(G()).g0(y9.c.e(str)).d0(new String[]{X0(w7.u.f14158n9), X0(w7.u.f14116k9)}, !this.f6766u0.q(str) ? 1 : 0, new AdapterView.OnItemClickListener() { // from class: jb.y0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f7041a.f6766u0.l(str, i10 == 0);
            }
        }).X(R.string.ok, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: jb.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7052a.f6766u0.s(str);
            }
        }).h0();
    }

    public static List q3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, c1.class, w7.u.Fc, w7.u.Xc, w7.u.Ra);
        hVar.b(1, w7.u.Ra, new String[0]);
        hVar.b(2, w7.u.f14312z0, new String[0]);
        return hVar.f();
    }

    private void r3() {
        this.f6766u0.n().g(b1(), new androidx.lifecycle.o() { // from class: jb.a1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                c1.l3(this.f6751a, (Boolean) obj);
            }
        });
        this.f6766u0.p().g(b1(), new androidx.lifecycle.o() { // from class: jb.b1
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                c1 c1Var = this.f6758a;
                c1Var.s3(c1Var.o3(c1Var.f6766u0.m(), (kb.a) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f6767v0.H(), list));
        this.f6767v0.M(list);
        eVarB.c(this.f6767v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6767v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: jb.u0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                c1.k3(this.f6987a, view2, i10, (v5.q) obj);
            }
        });
        this.f6767v0.K(v5.q.class, sVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: jb.v0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7006a.n3();
            }
        });
        this.f6767v0.K(v5.e.class, fVar);
        this.f6767v0.K(v5.l.class, new v5.m());
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: jb.w0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7018a.f6766u0.t(!((v5.n) obj).i());
            }
        });
        this.f6767v0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f6767v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        r3();
        this.f6766u0.r();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.Ra));
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f6766u0 = (d1) new androidx.lifecycle.a0(this, la.s.n()).a(d1.class);
    }
}
