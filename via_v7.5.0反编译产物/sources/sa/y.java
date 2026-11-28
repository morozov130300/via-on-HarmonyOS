package sa;

import android.R;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import x8.u3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class y extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public g0 f12292u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f12293v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f12294w0 = false;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f12295x0 = false;

    public static Bundle D3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, i10);
        return bundle;
    }

    public static Bundle E3(String str, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString("script_id", str);
        if (z10) {
            bundle.putBoolean("view_dependencies", true);
        }
        return bundle;
    }

    private void G3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new g(this.f12293v0.H(), list));
        this.f12293v0.M(list);
        eVarB.c(this.f12293v0);
    }

    public static /* synthetic */ void f3(y yVar, View view, int i10, v5.e eVar) {
        yVar.getClass();
        int iD = eVar.d();
        if (iD == 1) {
            yVar.w3(true);
        } else if (iD == 2) {
            yVar.w3(false);
        }
    }

    public static /* synthetic */ void h3(y yVar, a aVar, View view, q5.k.p pVar) {
        yVar.getClass();
        yVar.z3(aVar.b());
    }

    public static /* synthetic */ void o3(y yVar, a aVar, View view) {
        yVar.getClass();
        FragmentUtils.j(yVar, i8.k.class, i8.k.g3(aVar.a()));
    }

    public static /* synthetic */ void s3(y yVar, String str, Bundle bundle) {
        if (bundle != null) {
            yVar.getClass();
            if (bundle.containsKey(Name.MARK)) {
                int i10 = bundle.getInt(Name.MARK);
                yVar.f12292u0.G(i10);
                yVar.L0().y1("editor_result", p5.a.b().d(Name.MARK, i10).a());
            }
        }
        yVar.L0().x("script_result_v2");
    }

    public static /* synthetic */ void t3(y yVar, String str, Boolean bool) {
        yVar.getClass();
        if (bool.booleanValue()) {
            return;
        }
        com.tuyafeng.support.utils.n.s(yVar.G(), yVar.Y0(w7.u.H5, l5.b.b(str, null, null)));
    }

    public static /* synthetic */ void u3(y yVar, i0 i0Var, View view, q5.k.p pVar) {
        String[] strArr;
        yVar.getClass();
        if (!i0Var.b() || (strArr = pVar.f11819c) == null || strArr.length <= 0) {
            return;
        }
        yVar.f12292u0.M(i0Var, strArr[0]);
    }

    public static /* synthetic */ void v3(y yVar, View view, int i10, v5.q qVar) {
        yVar.getClass();
        int iC = qVar.c();
        if (iC == 3) {
            yVar.y3();
            return;
        }
        if (iC == 4) {
            yVar.A3();
        } else if (iC == 6) {
            yVar.F3();
        } else if (iC == 5) {
            yVar.J3();
        }
    }

    private List x3() {
        ArrayList arrayList = new ArrayList();
        ra.c cVarC = this.f12292u0.C();
        if (cVarC != null) {
            arrayList.add(new v5.q(5, cVarC.g(), cVarC.i()));
            String strC3 = C3(this.f12292u0.E());
            if (strC3.isEmpty()) {
                String strC4 = C3(this.f12292u0.B());
                strC3 = strC4.isEmpty() ? X0(w7.u.f14110k3) : Y0(w7.u.f14096j3, strC4);
            }
            arrayList.add(new v5.q(3, X0(w7.u.Fb), strC3));
        }
        List listY = this.f12292u0.y();
        arrayList.add(new v5.l(X0(w7.u.f13989b8)));
        if (listY != null && !listY.isEmpty()) {
            arrayList.addAll(listY);
        }
        arrayList.add(new v5.e(1, X0(w7.u.f14260v0), lb.g.a(G(), w7.o.f13810m, w7.u.ge)));
        List listX = this.f12292u0.x();
        arrayList.add(new v5.l(X0(w7.u.Z4)));
        if (listX != null && !listX.isEmpty()) {
            arrayList.addAll(listX);
        }
        arrayList.add(new v5.e(2, X0(w7.u.f14233t0), lb.g.a(G(), w7.o.f13810m, w7.u.ge)));
        List listZ = this.f12292u0.z();
        if (!listZ.isEmpty()) {
            arrayList.add(new v5.l(X0(w7.u.f14188pb)));
            arrayList.addAll(listZ);
        }
        List listA = this.f12292u0.A();
        if (!listA.isEmpty()) {
            arrayList.add(new v5.l(X0(w7.u.f14297xb)));
            arrayList.addAll(listA);
        }
        arrayList.add(new v5.l(X0(w7.u.Dc)));
        arrayList.add(new v5.q(4, X0(w7.u.A4)));
        arrayList.add(new v5.q(6, X0(w7.u.Z)));
        return arrayList;
    }

    public final void A3() {
        if (this.f12292u0.C() == null) {
            return;
        }
        int iE = this.f12292u0.C().e();
        L0().z1("script_result_v2", this, new androidx.fragment.app.i0() { // from class: sa.i
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                y.s3(this.f12263a, str, bundle);
            }
        });
        FragmentUtils.j(this, oa.q.class, oa.q.p3(iE));
    }

    public final void B3(final i0 i0Var) {
        q5.k kVarL = q5.k.l(G());
        kVarL.f0(w7.u.E);
        if (i0Var.b()) {
            kVarL.i(i0Var.a(), X0(i0Var.c() ? w7.u.f13975a8 : w7.u.W4), 1);
        } else {
            kVarL.K(i0Var.a());
        }
        kVarL.T(w7.u.f14298y, new View.OnClickListener() { // from class: sa.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12282a.f12292u0.u(i0Var);
            }
        });
        if (i0Var.b()) {
            kVarL.P(R.string.cancel, null);
            kVarL.X(R.string.ok, new q5.k.m() { // from class: sa.u
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    y.u3(this.f12284a, i0Var, view, pVar);
                }
            });
        } else {
            kVarL.X(R.string.ok, null);
        }
        kVarL.h0();
    }

    public final String C3(int i10) {
        if (i10 == 1) {
            return "document-start";
        }
        if (i10 == 2) {
            return "document-end";
        }
        if (i10 != 4) {
            return i10 != 8 ? "" : "context-menu";
        }
        return "document-idle";
    }

    public final void F3() {
        q5.k.l(G()).f0(w7.u.Z).J(w7.u.f14216rb).X(R.string.ok, new q5.k.m() { // from class: sa.m
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                this.f12273a.f12292u0.K();
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void H3() {
        G3(x3());
        if (this.f12294w0) {
            return;
        }
        this.f12294w0 = true;
        if (this.f12295x0) {
            List listH = this.f12293v0.H();
            int size = listH.size();
            final int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                }
                Object obj = listH.get(i10);
                if ((obj instanceof a) && !((a) obj).c()) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 >= 0) {
                this.f7946t0.post(new Runnable() { // from class: sa.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tuyafeng.support.utils.x.X(this.f12267c.f7946t0, i10);
                    }
                });
            }
        }
    }

    public final void I3(final a aVar, int i10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x.d.a(X0(w7.u.f14142m7), aVar.b()));
        boolean z10 = false;
        if (aVar.a() != null && !aVar.a().isEmpty()) {
            File file = new File(aVar.a());
            if (!file.exists()) {
                if (aVar.c()) {
                    aVar.d(false);
                    this.f12293v0.m(i10);
                }
                q5.k.l(G()).f0(w7.u.f14258ub).J(w7.u.f14244tb).X(w7.u.B, new q5.k.m() { // from class: sa.v
                    @Override // q5.k.m
                    public final void a(View view, q5.k.p pVar) {
                        y.h3(this.f12286a, aVar, view, pVar);
                    }
                }).P(R.string.cancel, null).T(w7.u.f14218s, new View.OnClickListener() { // from class: sa.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.tuyafeng.support.utils.n.a(this.f12288a.G(), aVar.b(), w7.u.Fg);
                    }
                }).h0();
                return;
            }
            arrayList.add(x.d.a(X0(w7.u.f14058g7), file.getAbsolutePath()));
            arrayList.add(x.d.a(X0(w7.u.f14128l7), u3.a(G(), file.lastModified())));
            arrayList.add(x.d.a(X0(w7.u.f14100j7), x8.z.v(G(), file.length())));
            z10 = true;
        }
        if (!aVar.c()) {
            aVar.d(true);
            this.f12293v0.m(i10);
        }
        q5.k kVarX = q5.k.l(G()).f0(w7.u.f14258ub).K(com.tuyafeng.support.utils.p.c(arrayList)).X(R.string.ok, null);
        if (z10) {
            kVarX.T(w7.u.oi, new View.OnClickListener() { // from class: sa.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    y.o3(this.f12290a, aVar, view);
                }
            });
        }
        kVarX.h0();
    }

    public final void J3() {
        ArrayList arrayList = new ArrayList();
        ra.c cVarC = this.f12292u0.C();
        arrayList.add(x.d.a(X0(w7.u.f14086i7), cVarC.g()));
        arrayList.add(x.d.a(X0(w7.u.f14156n7), cVarC.i()));
        if (!TextUtils.isEmpty(cVarC.c())) {
            arrayList.add(x.d.a(X0(w7.u.f14072h7), cVarC.c()));
        }
        if (!TextUtils.isEmpty(cVarC.h())) {
            arrayList.add(x.d.a(X0(w7.u.f14114k7), cVarC.h()));
        }
        if (!TextUtils.isEmpty(cVarC.b())) {
            arrayList.add(x.d.a(X0(w7.u.f14044f7), cVarC.b()));
        }
        arrayList.add(x.d.a(X0(w7.u.f14128l7), u3.a(G(), cVarC.f())));
        arrayList.add(x.d.a(X0(w7.u.f14030e7), u3.a(G(), cVarC.a())));
        if (this.f12292u0.w() != 0) {
            arrayList.add(x.d.a(X0(w7.u.f14100j7), x8.z.v(G(), this.f12292u0.w())));
        }
        q5.k.l(G()).f0(w7.u.Ub).K(com.tuyafeng.support.utils.p.c(arrayList)).X(R.string.ok, null).h0();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        int i10 = w0() == null ? -1 : w0().getInt(Name.MARK, -1);
        String string = w0() != null ? w0().getString("script_id", null) : null;
        if (i10 == -1 && com.tuyafeng.support.utils.p.f(string)) {
            return;
        }
        boolean z10 = false;
        if (w0() != null && w0().getBoolean("view_dependencies", false)) {
            z10 = true;
        }
        this.f12295x0 = z10;
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f12293v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: sa.h
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                y.v3(this.f12261a, view2, i11, (v5.q) obj);
            }
        });
        this.f12293v0.K(v5.q.class, sVar);
        v5.f fVar = new v5.f();
        fVar.j(new t5.g() { // from class: sa.p
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                y.f3(this.f12278a, view2, i11, (v5.e) obj);
            }
        });
        this.f12293v0.K(v5.e.class, fVar);
        j0 j0Var = new j0();
        j0Var.j(new t5.g() { // from class: sa.q
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                this.f12279a.B3((i0) obj);
            }
        });
        this.f12293v0.K(i0.class, j0Var);
        this.f12293v0.K(v5.l.class, new v5.m());
        b bVar = new b();
        bVar.j(new t5.g() { // from class: sa.r
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                this.f12280a.I3((a) obj, i11);
            }
        });
        this.f12293v0.K(a.class, bVar);
        this.f7946t0.setAdapter(this.f12293v0);
        this.f12292u0.D().g(b1(), new androidx.lifecycle.o() { // from class: sa.s
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f12281a.H3();
            }
        });
        if (string != null) {
            this.f12292u0.H(string);
        } else {
            this.f12292u0.G(i10);
        }
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.E);
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f12292u0 = (g0) new androidx.lifecycle.a0(this, la.s.n()).a(g0.class);
    }

    public final void w3(final boolean z10) {
        q5.k.l(G()).f0(z10 ? w7.u.f14260v0 : w7.u.f14233t0).i("https://*/*", X0(z10 ? w7.u.f13975a8 : w7.u.W4), 1).X(R.string.ok, new q5.k.m() { // from class: sa.l
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                this.f12271a.f12292u0.s(pVar.f11819c[0], z10);
            }
        }).P(R.string.cancel, null).h0();
    }

    public void y3() {
        int iB = this.f12292u0.B();
        int iE = this.f12292u0.E();
        final int[] iArr = {0, 1, 2, 4};
        String[] strArr = new String[4];
        int i10 = 0;
        for (int i11 = 1; i11 < 4; i11++) {
            strArr[i11] = C3(iArr[i11]);
            if (iE == iArr[i11]) {
                i10 = i11;
            }
        }
        String strC3 = C3(iB);
        strArr[0] = strC3.isEmpty() ? X0(w7.u.f14110k3) : Y0(w7.u.f14096j3, strC3);
        q5.k.l(G()).f0(w7.u.Fb).d0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: sa.k
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                this.f12269a.f12292u0.L(iArr[i12]);
            }
        }).h0();
    }

    public final void z3(final String str) {
        com.tuyafeng.support.utils.n.q(G(), w7.u.f14167o4);
        ((autodispose2.r) r6.q.f(new Callable() { // from class: sa.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f12274c.f12292u0.v(str));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: sa.o
            @Override // u6.f
            public final void accept(Object obj) {
                y.t3(this.f12276c, str, (Boolean) obj);
            }
        }, new w7.e0());
    }
}
