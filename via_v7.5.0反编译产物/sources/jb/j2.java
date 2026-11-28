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
public class j2 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public k2 f6856u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6857v0;

    public static /* synthetic */ void g3(j2 j2Var, Integer num) {
        j2Var.getClass();
        j2Var.v3(j2Var.o3(num.intValue(), j2Var.f6856u0.p()));
    }

    public static /* synthetic */ void l3(j2 j2Var, View view, q5.k.p pVar) {
        int i10;
        j2Var.getClass();
        String strF = y9.c.f(pVar.f11819c[0]);
        if (pVar.f11818b) {
            i10 = 3;
        } else {
            i10 = j2Var.f6856u0.m() == 2 ? 1 : 2;
        }
        j2Var.f6856u0.l(strF, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        q5.k kVarP = q5.k.l(G()).g0(X0(w7.u.f14312z0)).K(X0(this.f6856u0.m() != 2 ? w7.u.U7 : w7.u.T7)).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: jb.e2
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                j2.l3(this.f6796a, view, pVar);
            }
        }).P(R.string.cancel, null);
        if (this.f6856u0.m() == 2) {
            kVarP.x(w7.u.f14108k1, false);
        }
        kVarP.h0();
    }

    private List o3(int i10, kb.d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.g(1, X0(w7.u.S7), i10 == 3 ? X0(w7.u.V7) : X0(w7.u.J1), i10 == 3));
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
                arrayList.add(new v5.l(X0(this.f6856u0.m() != 2 ? w7.u.f13996c1 : w7.u.V4)));
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
        q5.k.l(G()).g0(y9.c.e(str)).d0(new String[]{X0(w7.u.X0), X0(w7.u.E1), X0(w7.u.f14108k1)}, t3(this.f6856u0.o(str)), new AdapterView.OnItemClickListener() { // from class: jb.h2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                j2 j2Var = this.f6828a;
                j2Var.f6856u0.l(str, j2Var.s3(i10));
            }
        }).X(R.string.ok, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: jb.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6842a.f6856u0.s(str);
            }
        }).h0();
    }

    public static List q3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, j2.class, w7.u.Fc, w7.u.Xc, w7.u.S7);
        hVar.b(1, w7.u.S7, new String[0]);
        hVar.b(2, w7.u.f14312z0, new String[0]);
        return hVar.f();
    }

    private void r3() {
        this.f6856u0.n().g(b1(), new androidx.lifecycle.o() { // from class: jb.f2
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                j2.g3(this.f6809a, (Integer) obj);
            }
        });
        this.f6856u0.q().g(b1(), new androidx.lifecycle.o() { // from class: jb.g2
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                j2 j2Var = this.f6817a;
                j2Var.v3(j2Var.o3(j2Var.f6856u0.m(), (kb.d) obj));
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
        p3(qVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f6857v0.H(), list));
        this.f6857v0.M(list);
        eVarB.c(this.f6857v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        x8.z.T();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6857v0 = new t5.f(Collections.EMPTY_LIST);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: jb.b2
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6759a.f6856u0.t(((v5.n) obj).i() ? 2 : 3);
            }
        });
        this.f6857v0.K(v5.n.class, pVar);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: jb.c2
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6768a.u3(view2, i10, (v5.q) obj);
            }
        });
        this.f6857v0.K(v5.q.class, sVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: jb.d2
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6784a.n3();
            }
        });
        this.f6857v0.K(v5.e.class, fVar);
        this.f6857v0.K(v5.l.class, new v5.m());
        this.f7946t0.setAdapter(this.f6857v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        r3();
        this.f6856u0.r();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.S7));
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f6856u0 = (k2) new androidx.lifecycle.a0(this, la.s.n()).a(k2.class);
    }
}
