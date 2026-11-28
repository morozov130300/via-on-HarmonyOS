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
public class i extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public j f6837u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6838v0;

    public static /* synthetic */ void f3(i iVar, View view, int i10, v5.q qVar) {
        iVar.getClass();
        iVar.p3(qVar.a());
    }

    public static /* synthetic */ void g3(i iVar, Boolean bool) {
        iVar.getClass();
        iVar.s3(iVar.o3(bool.booleanValue(), iVar.f6837u0.n()));
    }

    public static /* synthetic */ void i3(i iVar, boolean z10, View view, q5.k.p pVar) {
        iVar.getClass();
        iVar.f6837u0.l(y9.c.f(pVar.f11819c[0]), !z10);
    }

    public static List q3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, i.class, w7.u.Fc, w7.u.Xc, w7.u.G1);
        hVar.c("mark.via.blocker.AdBlockFragment.1", 1, w7.u.G1, new String[0]);
        hVar.b(2, w7.u.f14312z0, new String[0]);
        return hVar.f();
    }

    private void r3() {
        this.f6837u0.m().g(b1(), new androidx.lifecycle.o() { // from class: jb.g
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                i.g3(this.f6813a, (Boolean) obj);
            }
        });
        this.f6837u0.o().g(b1(), new androidx.lifecycle.o() { // from class: jb.h
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                i iVar = this.f6825a;
                iVar.s3(iVar.o3(iVar.f6837u0.p(), (kb.a) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f6838v0.H(), list));
        this.f6838v0.M(list);
        eVarB.c(this.f6838v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6838v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: jb.a
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                i.f3(this.f6749a, view2, i10, (v5.q) obj);
            }
        });
        this.f6838v0.K(v5.q.class, sVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: jb.b
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6756a.n3();
            }
        });
        this.f6838v0.K(v5.e.class, fVar);
        this.f6838v0.K(v5.l.class, new v5.m());
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: jb.c
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6763a.f6837u0.t(!((v5.n) obj).i());
            }
        });
        this.f6838v0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f6838v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        r3();
        this.f6837u0.r();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.G1));
    }

    public final void n3() {
        final boolean zP = this.f6837u0.p();
        q5.k.l(G()).f0(w7.u.f14312z0).K(zP ? X0(w7.u.f14191q0) : X0(w7.u.f14205r0)).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: jb.f
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                i.i3(this.f6801a, zP, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final List o3(boolean z10, kb.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.n(1, X0(w7.u.G1), z10));
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

    public final void p3(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        q5.k.l(G()).g0(y9.c.e(str)).d0(new String[]{X0(w7.u.f14158n9), X0(w7.u.f14116k9)}, !this.f6837u0.q(str) ? 1 : 0, new AdapterView.OnItemClickListener() { // from class: jb.d
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f6775a.f6837u0.l(str, i10 == 0);
            }
        }).X(R.string.ok, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: jb.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6790a.f6837u0.s(str);
            }
        }).h0();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f6837u0 = (j) new androidx.lifecycle.a0(this, la.s.n()).a(j.class);
    }
}
