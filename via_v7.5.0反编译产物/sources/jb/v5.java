package jb;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import hb.w7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v5 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public w5 f7015u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f7016v0;

    public static /* synthetic */ void f3(v5 v5Var, String str, View view, q5.k.p pVar) {
        v5Var.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        String str2 = pVar.f11819c[0];
        v5Var.f7015u0.l(str, ga.c.l(-999, str2, str2));
    }

    public static /* synthetic */ void j3(v5 v5Var, List list, String str, AdapterView adapterView, View view, int i10, long j10) {
        v5Var.getClass();
        if (((ga.c) list.get(i10)).d() == -999) {
            v5Var.p3(str);
        } else {
            v5Var.f7015u0.l(str, (ga.c) list.get(i10));
        }
    }

    public static /* synthetic */ void k3(v5 v5Var, View view, q5.k.p pVar) {
        v5Var.getClass();
        v5Var.q3(y9.c.f(pVar.f11819c[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        q5.k.l(G()).f0(w7.u.f14312z0).J(w7.u.G0).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: jb.p5
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                v5.k3(this.f6931a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    private void q3(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ga.c cVarQ = this.f7015u0.q(str);
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(x8.c4.b(G()));
        arrayList.addAll(this.f7015u0.m());
        arrayList.add(ga.c.l(-999, X0(w7.u.J0), null));
        int size = arrayList.size();
        String[] strArr = new String[size];
        int i10 = -1;
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((ga.c) arrayList.get(i11)).g();
            if (cVarQ.d() == ((ga.c) arrayList.get(i11)).d()) {
                i10 = i11;
            }
        }
        q5.k.l(G()).g0(y9.c.e(str)).d0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: jb.q5
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                v5.j3(this.f6940a, arrayList, str, adapterView, view, i12, j10);
            }
        }).X(R.string.ok, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: jb.r5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6956a.f7015u0.u(str);
            }
        }).h0();
    }

    public static List r3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, v5.class, w7.u.Fc, w7.u.Xc, w7.u.F0);
        hVar.b(1, w7.u.F0, "UA", "user agent", "浏览器标识");
        hVar.b(2, w7.u.f14312z0, new String[0]);
        return hVar.f();
    }

    private void s3() {
        this.f7015u0.s().g(b1(), new androidx.lifecycle.o() { // from class: jb.s5
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                v5 v5Var = this.f6971a;
                v5Var.v3(v5Var.o3((ga.c) obj, v5Var.f7015u0.o()));
            }
        });
        this.f7015u0.p().g(b1(), new androidx.lifecycle.o() { // from class: jb.t5
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                v5 v5Var = this.f6981a;
                v5Var.v3(v5Var.o3(v5Var.f7015u0.n(), (List) obj));
            }
        });
    }

    private void t3() {
        this.f7015u0.t(x8.c4.b(G()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(View view, int i10, v5.q qVar) {
        if (qVar.c() != 1) {
            q3(qVar.a());
        } else {
            FragmentUtils.i(this, w7.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f7016v0.H(), list));
        this.f7016v0.M(list);
        eVarB.c(this.f7016v0);
    }

    @Override // androidx.fragment.app.Fragment
    public void G1(boolean z10) {
        super.G1(z10);
        if (z10) {
            return;
        }
        t3();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7016v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: jb.n5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6911a.u3(view2, i10, (v5.q) obj);
            }
        });
        this.f7016v0.K(v5.q.class, sVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: jb.o5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6922a.n3();
            }
        });
        this.f7016v0.K(v5.e.class, fVar);
        this.f7016v0.K(v5.l.class, new v5.m());
        this.f7946t0.setAdapter(this.f7016v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        s3();
        t3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.F0));
    }

    public final List o3(ga.c cVar, List list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(1, X0(w7.u.F0), cVar == null ? null : cVar.g()));
        arrayList.add(new v5.e(2, X0(w7.u.f14312z0), lb.g.a(G(), w7.o.f13810m, w7.u.ge)));
        if (list != null && !list.isEmpty()) {
            arrayList.add(new v5.l(X0(w7.u.V4)));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                kb.b bVar = (kb.b) it.next();
                arrayList.add(new v5.q(bVar.hashCode(), bVar.h(), bVar.f()));
            }
        }
        return arrayList;
    }

    public final void p3(final String str) {
        ga.c cVarR = this.f7015u0.r(str, null);
        q5.k.l(G()).f0(w7.u.J0).v(false).i(cVarR == null ? null : cVarR.a(), X0(w7.u.F0), 3).X(R.string.ok, new q5.k.m() { // from class: jb.u5
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                v5.f3(this.f7002a, str, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f7015u0 = (w5) new androidx.lifecycle.a0(this, la.s.n()).a(w5.class);
    }
}
