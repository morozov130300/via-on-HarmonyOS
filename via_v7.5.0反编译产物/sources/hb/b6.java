package hb;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b6 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f5814u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f5815v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public String f5816w0;

    public static /* synthetic */ void f3(b6 b6Var, View view, q5.k.p pVar) {
        b6Var.getClass();
        int[] iArr = pVar.f11817a;
        int i10 = 0;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            int i11 = 0;
            while (i10 < length) {
                i11 += 1 << iArr[i10];
                i10++;
            }
            i10 = i11;
        }
        b6Var.f5814u0.g(i10);
        u9.n.e().u(true);
        b6Var.o3(b6Var.j3());
    }

    public static /* synthetic */ void h3(b6 b6Var, String str) {
        b6Var.f5816w0 = str;
        b6Var.o3(b6Var.j3());
    }

    private List j3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(1, X0(w7.u.Xb), this.f5816w0));
        StringBuilder sb2 = new StringBuilder();
        String[] strArr = {X0(w7.u.F), X0(w7.u.f14092j), X0(w7.u.sg), X0(w7.u.I), X0(w7.u.Xb), X0(w7.u.f14077hc)};
        int iX1 = this.f5814u0.X1();
        for (int i10 = 0; i10 < 6; i10++) {
            if (((1 << i10) & iX1) != 0) {
                if (sb2.length() > 0) {
                    sb2.append('/');
                }
                sb2.append(strArr[i10]);
            }
        }
        arrayList.add(new v5.q(2, X0(w7.u.xg), sb2.length() > 0 ? sb2.toString() : null));
        arrayList.add(new v5.q(3, X0(w7.u.f14231sc), X0(this.f5814u0.v().r() ? w7.u.N4 : w7.u.R3)));
        return arrayList;
    }

    public static List k3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, b6.class, w7.u.Fc, w7.u.f14161nc);
        hVar.b(1, w7.u.Xb, new String[0]);
        hVar.b(2, w7.u.xg, new String[0]);
        hVar.b(3, w7.u.f14231sc, new String[0]);
        return hVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m3(v5.q qVar) {
        int iC = qVar.c();
        if (iC == 1) {
            FragmentUtils.i(this, w5.class);
        } else if (iC == 2) {
            n3();
        } else {
            if (iC != 3) {
                return;
            }
            FragmentUtils.i(this, i6.class);
        }
    }

    private void n3() {
        String[] strArr = {X0(w7.u.F), X0(w7.u.f14092j), X0(w7.u.sg), X0(w7.u.I), X0(w7.u.Xb), X0(w7.u.f14077hc)};
        int iX1 = this.f5814u0.X1();
        int[] iArr = new int[10];
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            if (((1 << i11) & iX1) != 0) {
                iArr[i10] = i11;
                i10++;
            }
        }
        q5.k.l(G()).g0(X0(w7.u.xg)).K(X0(w7.u.f14268v8)).M(strArr, Arrays.copyOf(iArr, i10)).X(R.string.ok, new q5.k.m() { // from class: hb.a6
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                b6.f3(this.f5789a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    private void o3(List list) {
        t5.f fVar = this.f5815v0;
        if (fVar == null) {
            return;
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(fVar.H(), list));
        this.f5815v0.M(list);
        eVarB.c(this.f5815v0);
    }

    @Override // androidx.fragment.app.Fragment
    public void G1(boolean z10) {
        super.G1(z10);
        if (z10) {
            return;
        }
        l3();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5814u0 = la.s.j();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f5815v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: hb.x5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6147a.m3((v5.q) obj);
            }
        });
        this.f5815v0.K(v5.q.class, sVar);
        this.f7946t0.setAdapter(this.f5815v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        l3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.f14161nc));
    }

    public final void l3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.y5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                b6 b6Var = this.f6164c;
                return x8.q2.d(b6Var.G(), b6Var.f5814u0.M1());
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.z5
            @Override // u6.f
            public final void accept(Object obj) {
                b6.h3(this.f6178c, (String) obj);
            }
        }, new w7.e0());
    }
}
