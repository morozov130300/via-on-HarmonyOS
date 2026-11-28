package y8;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.settings.search.SettingsSearchLocator;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f14996u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public n9.o f14997v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public t5.f f14998w0;

    public static /* synthetic */ void g3(o oVar, View view, int i10, v5.q qVar) {
        oVar.getClass();
        int iC = qVar.c();
        if (iC == 1) {
            FragmentUtils.i(oVar, k.class);
        } else if (iC == 2) {
            FragmentUtils.i(oVar, z.class);
        }
    }

    public static /* synthetic */ void h3(o oVar, s5.a aVar) {
        oVar.getClass();
        oVar.l3(oVar.i3((n9.l) aVar.c()));
    }

    public static List j3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, o.class, w7.u.Fc, w7.u.U0);
        hVar.b(1, w7.u.T0, new String[0]);
        hVar.b(2, w7.u.S0, new String[0]);
        return hVar.f();
    }

    private void k3() {
        l3(i3(null));
        final String strQ0 = this.f14996u0.q0();
        if (strQ0 == null || strQ0.isEmpty()) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y8.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s5.a.f(this.f14992c.f14997v0.h(strQ0));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y8.n
            @Override // u6.f
            public final void accept(Object obj) {
                o.h3(this.f14995c, (s5.a) obj);
            }
        }, new w7.e0());
    }

    private void l3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f14998w0.H(), list));
        this.f14998w0.M(list);
        eVarB.c(this.f14998w0);
    }

    @Override // androidx.fragment.app.Fragment
    public void G1(boolean z10) {
        super.G1(z10);
        if (z10) {
            return;
        }
        k3();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f14996u0 = la.s.j();
        this.f14997v0 = la.s.e();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.e(this.f7946t0);
        t5.f fVar = new t5.f(Collections.EMPTY_LIST);
        this.f14998w0 = fVar;
        fVar.K(v5.l.class, new v5.m());
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: y8.l
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                o.g3(this.f14989a, view2, i10, (v5.q) obj);
            }
        });
        this.f14998w0.K(v5.q.class, sVar);
        this.f7946t0.setAdapter(this.f14998w0);
        SettingsSearchLocator.b(this, this.f7946t0);
        k3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.U0);
    }

    public final List i3(n9.l lVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(1, X0(w7.u.T0), lVar == null ? X0(w7.u.f14060g9) : lVar.g()));
        arrayList.add(new v5.q(2, X0(w7.u.S0)));
        return arrayList;
    }
}
