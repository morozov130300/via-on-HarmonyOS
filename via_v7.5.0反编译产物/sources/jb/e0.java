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
public class e0 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public f0 f6792u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6793v0;

    public static /* synthetic */ void g3(e0 e0Var, Integer num) {
        e0Var.getClass();
        e0Var.v3(e0Var.o3(num.intValue(), e0Var.f6792u0.p()));
    }

    public static /* synthetic */ void h3(e0 e0Var, View view, q5.k.p pVar) {
        int i10;
        e0Var.getClass();
        String strF = y9.c.f(pVar.f11819c[0]);
        if (pVar.f11818b) {
            i10 = 3;
        } else {
            i10 = e0Var.f6792u0.o() == 2 ? 1 : 2;
        }
        e0Var.f6792u0.l(strF, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3() {
        q5.k kVarP = q5.k.l(G()).g0(X0(w7.u.f14312z0)).K(X0(this.f6792u0.o() != 2 ? w7.u.f14262v2 : w7.u.f14249u2)).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: jb.y
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                e0.h3(this.f7040a, view, pVar);
            }
        }).P(R.string.cancel, null);
        if (this.f6792u0.o() == 2) {
            kVarP.x(w7.u.f14108k1, false);
        }
        kVarP.h0();
    }

    private List o3(int i10, kb.d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(1, X0(w7.u.f14235t2), i10 == 3 ? X0(w7.u.f14288x2) : X0(i10 == 2 ? w7.u.f14301y2 : w7.u.f14275w2)));
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
                arrayList.add(new v5.l(X0(this.f6792u0.o() != 2 ? w7.u.f13996c1 : w7.u.V4)));
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
        q5.k.l(G()).g0(y9.c.e(str)).d0(new String[]{X0(w7.u.X0), X0(w7.u.E1), X0(w7.u.f14108k1)}, t3(this.f6792u0.m(str)), new AdapterView.OnItemClickListener() { // from class: jb.c0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                e0 e0Var = this.f6764a;
                e0Var.f6792u0.l(str, e0Var.s3(i10));
            }
        }).X(R.string.ok, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: jb.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6777a.f6792u0.s(str);
            }
        }).h0();
    }

    public static List q3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, e0.class, w7.u.Fc, w7.u.Xc, w7.u.f14235t2);
        hVar.b(1, w7.u.f14235t2, new String[0]);
        hVar.b(2, w7.u.f14312z0, new String[0]);
        return hVar.f();
    }

    private void r3() {
        this.f6792u0.n().g(b1(), new androidx.lifecycle.o() { // from class: jb.z
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                e0.g3(this.f7051a, (Integer) obj);
            }
        });
        this.f6792u0.q().g(b1(), new androidx.lifecycle.o() { // from class: jb.a0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                e0 e0Var = this.f6750a;
                e0Var.v3(e0Var.o3(e0Var.f6792u0.o(), (kb.d) obj));
            }
        });
    }

    private int t3(int i10) {
        if (i10 != 2) {
            return i10 != 3 ? 0 : 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(View view, int i10, v5.q qVar) {
        if (qVar.c() != 1) {
            p3(qVar.a());
        } else {
            q5.k.l(G()).f0(w7.u.f14235t2).d0(new String[]{X0(w7.u.X0), X0(w7.u.E1), X0(w7.u.f14108k1)}, t3(this.f6792u0.o()), new AdapterView.OnItemClickListener() { // from class: jb.b0
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                    e0 e0Var = this.f6757a;
                    e0Var.f6792u0.t(e0Var.s3(i11));
                }
            }).h0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f6793v0.H(), list));
        this.f6793v0.M(list);
        eVarB.c(this.f6793v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6793v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: jb.w
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7017a.u3(view2, i10, (v5.q) obj);
            }
        });
        this.f6793v0.K(v5.q.class, sVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: jb.x
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f7029a.n3();
            }
        });
        this.f6793v0.K(v5.e.class, fVar);
        this.f6793v0.K(v5.l.class, new v5.m());
        this.f7946t0.setAdapter(this.f6793v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        r3();
        this.f6792u0.r();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.b(e0Var, X0(w7.u.f14235t2));
    }

    public final int s3(int i10) {
        if (i10 == 2) {
            return 3;
        }
        return i10 == 1 ? 2 : 1;
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f6792u0 = (f0) new androidx.lifecycle.a0(this, la.s.n()).a(f0.class);
    }
}
