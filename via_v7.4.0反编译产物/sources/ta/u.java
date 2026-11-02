package ta;

import android.R;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import androidx.fragment.app.i0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import w5.k;
import x7.g0;
import z8.u3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public b0 f12344r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f12345s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f12346t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f12347u0 = false;

    public static Bundle E3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, i10);
        return bundle;
    }

    public static Bundle F3(String str, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString("script_id", str);
        if (z10) {
            bundle.putBoolean("view_dependencies", true);
        }
        return bundle;
    }

    private void H3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new c(this.f12345s0.H(), list));
        this.f12345s0.M(list);
        eVarB.c(this.f12345s0);
    }

    public static /* synthetic */ void g3(u uVar, View view, int i10, a6.e eVar) {
        uVar.getClass();
        int iD = eVar.d();
        if (iD == 1) {
            uVar.x3(true);
        } else if (iD == 2) {
            uVar.x3(false);
        }
    }

    public static /* synthetic */ void i3(u uVar, a aVar, View view, k.p pVar) {
        uVar.getClass();
        uVar.A3(aVar.b());
    }

    public static /* synthetic */ void p3(u uVar, a aVar, View view) {
        uVar.getClass();
        g6.i.h(uVar, k8.k.class, k8.k.h3(aVar.a()));
    }

    public static /* synthetic */ void t3(u uVar, String str, Bundle bundle) {
        if (bundle != null) {
            uVar.getClass();
            if (bundle.containsKey(Name.MARK)) {
                int i10 = bundle.getInt(Name.MARK);
                uVar.f12344r0.F(i10);
                uVar.N0().x1("editor_result", v5.a.b().d(Name.MARK, i10).a());
            }
        }
        uVar.N0().x("script_result_v2");
    }

    public static /* synthetic */ void u3(u uVar, String str, Boolean bool) {
        uVar.getClass();
        if (bool.booleanValue()) {
            uVar.I3(str);
        } else {
            g6.n.s(uVar.I(), uVar.a1(x7.u.f14208w5, l5.b.b(str, null, null)));
        }
    }

    public static /* synthetic */ void v3(u uVar, d0 d0Var, View view, k.p pVar) {
        String[] strArr;
        uVar.getClass();
        if (!d0Var.b() || (strArr = pVar.f13339c) == null || strArr.length <= 0) {
            return;
        }
        uVar.f12344r0.K(d0Var, strArr[0]);
    }

    public static /* synthetic */ void w3(u uVar, View view, int i10, a6.q qVar) {
        uVar.getClass();
        int iC = qVar.c();
        if (iC == 3) {
            uVar.z3();
            return;
        }
        if (iC == 4) {
            uVar.B3();
        } else if (iC == 6) {
            uVar.G3();
        } else if (iC == 5) {
            uVar.L3();
        }
    }

    private List y3() {
        ArrayList arrayList = new ArrayList();
        r5.c cVarB = this.f12344r0.B();
        if (cVarB != null) {
            arrayList.add(new a6.q(5, cVarB.g(), cVarB.i()));
            String strD3 = D3(this.f12344r0.D());
            if (strD3.isEmpty()) {
                String strD32 = D3(this.f12344r0.A());
                strD3 = strD32.isEmpty() ? Z0(x7.u.Y2) : a1(x7.u.X2, strD32);
            }
            arrayList.add(new a6.q(3, Z0(x7.u.f14162sb), strD3));
        }
        List listX = this.f12344r0.x();
        arrayList.add(new a6.l(Z0(x7.u.P7)));
        if (listX != null && !listX.isEmpty()) {
            arrayList.addAll(listX);
        }
        arrayList.add(new a6.e(1, Z0(x7.u.f14164t0), lb.b.a(I(), x7.o.f13747n, x7.u.Rd)));
        List listW = this.f12344r0.w();
        arrayList.add(new a6.l(Z0(x7.u.M4)));
        if (listW != null && !listW.isEmpty()) {
            arrayList.addAll(listW);
        }
        arrayList.add(new a6.e(2, Z0(x7.u.f14138r0), lb.b.a(I(), x7.o.f13747n, x7.u.Rd)));
        List listY = this.f12344r0.y();
        if (!listY.isEmpty()) {
            arrayList.add(new a6.l(Z0(x7.u.f13954db)));
            arrayList.addAll(listY);
        }
        List listZ = this.f12344r0.z();
        if (!listZ.isEmpty()) {
            arrayList.add(new a6.l(Z0(x7.u.f14066lb)));
            arrayList.addAll(listZ);
        }
        arrayList.add(new a6.l(Z0(x7.u.f14123pc)));
        arrayList.add(new a6.q(4, Z0(x7.u.f14087n4)));
        arrayList.add(new a6.q(6, Z0(x7.u.Y)));
        return arrayList;
    }

    public final void A3(final String str) {
        g6.n.q(I(), x7.u.f13919b4);
        ((autodispose2.r) x6.o.g(new Callable() { // from class: ta.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f12326e.f12344r0.u(str));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: ta.k
            @Override // a7.e
            public final void accept(Object obj) {
                u.u3(this.f12328e, str, (Boolean) obj);
            }
        }, new g0());
    }

    public final void B3() {
        if (this.f12344r0.B() == null) {
            return;
        }
        int iE = this.f12344r0.B().e();
        N0().y1("script_result_v2", this, new i0() { // from class: ta.e
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                u.t3(this.f12318a, str, bundle);
            }
        });
        g6.i.h(this, sa.o.class, sa.o.p3(iE));
    }

    public final void C3(final d0 d0Var) {
        w5.k kVarL = w5.k.l(I());
        kVarL.d0(x7.u.D);
        if (d0Var.b()) {
            kVarL.i(d0Var.a(), Z0(d0Var.c() ? x7.u.O7 : x7.u.J4), 1);
        } else {
            kVarL.J(d0Var.a());
        }
        kVarL.R(x7.u.f14215x, new View.OnClickListener() { // from class: ta.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12334a.f12344r0.t(d0Var);
            }
        });
        if (d0Var.b()) {
            kVarL.N(R.string.cancel, null);
            kVarL.V(R.string.ok, new k.m() { // from class: ta.q
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    u.v3(this.f12336a, d0Var, view, pVar);
                }
            });
        } else {
            kVarL.V(R.string.ok, null);
        }
        kVarL.f0();
    }

    public final String D3(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "" : "context-menu" : "document-idle" : "document-end" : "document-start";
    }

    public final void G3() {
        w5.k.l(I()).d0(x7.u.Y).I(x7.u.f13982fb).V(R.string.ok, new k.m() { // from class: ta.i
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                this.f12325a.f12344r0.I();
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void I3(String str) {
        List listH = this.f12345s0.H();
        int size = listH.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            }
            if (listH.get(i10) instanceof a) {
                a aVar = (a) listH.get(i10);
                if (str.equals(aVar.b())) {
                    aVar.d(new File(aVar.a()).exists());
                    break;
                }
            }
            i10++;
        }
        if (i10 == -1) {
            return;
        }
        this.f12345s0.m(i10);
    }

    public final void J3() {
        H3(y3());
        if (this.f12346t0) {
            return;
        }
        this.f12346t0 = true;
        if (this.f12347u0) {
            List listH = this.f12345s0.H();
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
                this.f10459q0.post(new Runnable() { // from class: ta.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g6.y.W(this.f12319e.f10459q0, i10);
                    }
                });
            }
        }
    }

    public final void K3(final a aVar, int i10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(w.d.a(Z0(x7.u.f13908a7), aVar.b()));
        boolean z10 = false;
        if (aVar.a() != null && !aVar.a().isEmpty()) {
            File file = new File(aVar.a());
            if (!file.exists()) {
                if (aVar.c()) {
                    aVar.d(false);
                    this.f12345s0.m(i10);
                }
                w5.k.l(I()).d0(x7.u.f14024ib).I(x7.u.f14010hb).V(x7.u.A, new k.m() { // from class: ta.r
                    @Override // w5.k.m
                    public final void a(View view, k.p pVar) {
                        u.i3(this.f12338a, aVar, view, pVar);
                    }
                }).N(R.string.cancel, null).R(x7.u.f14150s, new View.OnClickListener() { // from class: ta.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        g6.n.a(this.f12340a.I(), aVar.b(), x7.u.pg);
                    }
                }).f0();
                return;
            }
            arrayList.add(w.d.a(Z0(x7.u.U6), file.getAbsolutePath()));
            arrayList.add(w.d.a(Z0(x7.u.Z6), u3.a(I(), file.lastModified())));
            arrayList.add(w.d.a(Z0(x7.u.X6), z8.b0.w(I(), file.length())));
            z10 = true;
        }
        if (!aVar.c()) {
            aVar.d(true);
            this.f12345s0.m(i10);
        }
        w5.k kVarV = w5.k.l(I()).d0(x7.u.f14024ib).J(g6.p.c(arrayList)).V(R.string.ok, null);
        if (z10) {
            kVarV.R(x7.u.Jh, new View.OnClickListener() { // from class: ta.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.p3(this.f12342a, aVar, view);
                }
            });
        }
        kVarV.f0();
    }

    public final void L3() {
        ArrayList arrayList = new ArrayList();
        r5.c cVarB = this.f12344r0.B();
        arrayList.add(w.d.a(Z0(x7.u.W6), cVarB.g()));
        arrayList.add(w.d.a(Z0(x7.u.f13922b7), cVarB.i()));
        if (!TextUtils.isEmpty(cVarB.c())) {
            arrayList.add(w.d.a(Z0(x7.u.V6), cVarB.c()));
        }
        if (!TextUtils.isEmpty(cVarB.h())) {
            arrayList.add(w.d.a(Z0(x7.u.Y6), cVarB.h()));
        }
        if (!TextUtils.isEmpty(cVarB.b())) {
            arrayList.add(w.d.a(Z0(x7.u.T6), cVarB.b()));
        }
        arrayList.add(w.d.a(Z0(x7.u.Z6), u3.a(I(), cVarB.f())));
        arrayList.add(w.d.a(Z0(x7.u.S6), u3.a(I(), cVarB.a())));
        if (this.f12344r0.v() != 0) {
            arrayList.add(w.d.a(Z0(x7.u.X6), z8.b0.w(I(), this.f12344r0.v())));
        }
        w5.k.l(I()).d0(x7.u.Hb).J(g6.p.c(arrayList)).V(R.string.ok, null).f0();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        int i10 = y0() == null ? -1 : y0().getInt(Name.MARK, -1);
        String string = y0() != null ? y0().getString("script_id", null) : null;
        if (i10 == -1 && g6.p.f(string)) {
            return;
        }
        boolean z10 = false;
        if (y0() != null && y0().getBoolean("view_dependencies", false)) {
            z10 = true;
        }
        this.f12347u0 = z10;
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f12345s0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: ta.d
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                u.w3(this.f12314a, view2, i11, (a6.q) obj);
            }
        });
        this.f12345s0.K(a6.q.class, sVar);
        a6.f fVar = new a6.f();
        fVar.j(new y5.g() { // from class: ta.l
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                u.g3(this.f12330a, view2, i11, (a6.e) obj);
            }
        });
        this.f12345s0.K(a6.e.class, fVar);
        e0 e0Var = new e0();
        e0Var.j(new y5.g() { // from class: ta.m
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                this.f12331a.C3((d0) obj);
            }
        });
        this.f12345s0.K(d0.class, e0Var);
        this.f12345s0.K(a6.l.class, new a6.m());
        b bVar = new b();
        bVar.j(new y5.g() { // from class: ta.n
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                this.f12332a.K3((a) obj, i11);
            }
        });
        this.f12345s0.K(a.class, bVar);
        this.f10459q0.setAdapter(this.f12345s0);
        this.f12344r0.C().g(d1(), new androidx.lifecycle.m() { // from class: ta.o
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f12333a.J3();
            }
        });
        if (string != null) {
            this.f12344r0.G(string);
        } else {
            this.f12344r0.F(i10);
        }
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.a(zVar, x7.u.D);
    }

    public final void x3(final boolean z10) {
        w5.k.l(I()).d0(z10 ? x7.u.f14164t0 : x7.u.f14138r0).i("https://*/*", Z0(z10 ? x7.u.O7 : x7.u.J4), 1).V(R.string.ok, new k.m() { // from class: ta.h
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                this.f12323a.f12344r0.r(pVar.f13339c[0], z10);
            }
        }).N(R.string.cancel, null).f0();
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f12344r0 = (b0) new androidx.lifecycle.y(this, pa.r.n()).a(b0.class);
    }

    public void z3() {
        int iA = this.f12344r0.A();
        int iD = this.f12344r0.D();
        final int[] iArr = {0, 1, 2, 4};
        String[] strArr = new String[4];
        int i10 = 0;
        for (int i11 = 1; i11 < 4; i11++) {
            strArr[i11] = D3(iArr[i11]);
            if (iD == iArr[i11]) {
                i10 = i11;
            }
        }
        String strD3 = D3(iA);
        strArr[0] = strD3.isEmpty() ? Z0(x7.u.Y2) : a1(x7.u.X2, strD3);
        w5.k.l(I()).d0(x7.u.f14162sb).b0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: ta.g
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                this.f12321a.f12344r0.J(iArr[i12]);
            }
        }).f0();
    }
}
