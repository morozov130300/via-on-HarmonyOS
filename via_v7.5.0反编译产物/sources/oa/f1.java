package oa;

import android.R;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import c6.a2;
import com.tuyafeng.support.utils.FragmentUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.browser.kd;
import mark.via.settings.search.SettingsSearchLocator;
import org.simpleframework.xml.strategy.Name;
import x8.o2;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f1 extends m8.f {
    public boolean A0 = false;
    public final n8.f B0 = new n8.f(this);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public List f11001u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f11002v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public qa.c f11003w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public u9.l f11004x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public View f11005y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f11006z0;

    public static /* synthetic */ void A3(f1 f1Var, View view, int i10, v5.q qVar) {
        f1Var.getClass();
        if (qVar.c() != 2) {
            return;
        }
        f1Var.q4(qVar, i10);
    }

    public static /* synthetic */ x.d B3(f1 f1Var, String str, String str2, int i10) {
        f1Var.getClass();
        ra.a aVarE = ra.a.e(str, str2);
        if (aVarE == null) {
            return new x.d(null, null);
        }
        return new x.d(aVarE, i10 > 0 ? f1Var.f11003w0.k(i10) : f1Var.f11003w0.r(aVarE.d()));
    }

    public static /* synthetic */ void C3(f1 f1Var, x.d dVar) {
        f1Var.getClass();
        f1Var.r4((ra.a) dVar.f14455a, (ra.c) dVar.f14456b);
    }

    public static /* synthetic */ s5.a D3(f1 f1Var, int i10, ra.a aVar) {
        if (i10 <= 0) {
            i10 = f1Var.f11003w0.a(aVar);
        } else if (!f1Var.f11003w0.p(i10, aVar)) {
            i10 = 0;
        }
        return s5.a.f(i10 > 0 ? f1Var.f11003w0.k(i10) : null);
    }

    public static /* synthetic */ void F3(f1 f1Var, s5.a aVar) {
        f1Var.getClass();
        if (aVar.d()) {
            ra.c cVar = (ra.c) aVar.b();
            int iH4 = f1Var.h4(cVar.e());
            if (iH4 < 0) {
                f1Var.f11001u0.add(0, cVar);
            } else {
                f1Var.f11001u0.set(iH4, cVar);
            }
            f1Var.s4(f1Var.W3());
        }
    }

    public static /* synthetic */ void G3(f1 f1Var, String str, String str2, s5.a aVar) {
        f1Var.getClass();
        if (!aVar.d()) {
            com.tuyafeng.support.utils.n.s(f1Var.G(), f1Var.Y0(w7.u.Kg, str));
            return;
        }
        com.tuyafeng.support.utils.n.s(f1Var.G(), f1Var.Y0(w7.u.Lg, str));
        f1Var.m4(((ra.c) aVar.b()).e());
        f1Var.Y3(str2, str);
    }

    public static /* synthetic */ void H3(f1 f1Var, List list) {
        int i10 = 0;
        int i11 = (f1Var.A0 || f1Var.w0() == null) ? 0 : f1Var.w0().getInt(Name.MARK, 0);
        int size = list.size();
        int i12 = -1;
        for (int i13 = 0; i13 < size; i13++) {
            ra.c cVar = (ra.c) list.get(i13);
            cVar.r(f1Var.f11003w0.x(cVar.e()));
            if (cVar.e() == i11) {
                i12 = i13;
            }
        }
        f1Var.f11001u0.clear();
        f1Var.f11001u0.addAll(list);
        List listW3 = f1Var.W3();
        f1Var.s4(listW3);
        if (i12 >= 0) {
            Iterator it = listW3.iterator();
            while (it.hasNext() && !(it.next() instanceof g1)) {
                i10++;
            }
            com.tuyafeng.support.utils.x.X(f1Var.f7946t0, i10 + i12);
        }
        f1Var.A0 = true;
    }

    public static /* synthetic */ void I3(f1 f1Var, int i10) {
        qa.c cVar = f1Var.f11003w0;
        cVar.J(cVar.B(i10));
    }

    public static /* synthetic */ void J3(final f1 f1Var, final ra.c cVar, View view, q5.k.p pVar) {
        f1Var.getClass();
        x8.h.b(new Runnable() { // from class: oa.j0
            @Override // java.lang.Runnable
            public final void run() {
                f1.R3(this.f11022c, cVar);
            }
        });
        int iH4 = f1Var.h4(cVar.e());
        if (iH4 >= 0) {
            f1Var.f11001u0.remove(iH4);
            f1Var.s4(f1Var.W3());
        }
    }

    public static /* synthetic */ void K3(f1 f1Var, List list, View view, q5.k.p pVar) {
        f1Var.getClass();
        if (list.size() == 1) {
            f1Var.v4(list);
            return;
        }
        int[] iArr = pVar.f11817a;
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            arrayList.add((ra.c) list.get(i10));
        }
        f1Var.v4(arrayList);
    }

    public static /* synthetic */ void M3(f1 f1Var, ra.c cVar, String str, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (j10 == 2) {
            f1Var.t4(cVar);
            return;
        }
        if (j10 == 3) {
            f1Var.n4(cVar);
            return;
        }
        if (j10 == 4) {
            com.tuyafeng.support.utils.n.a(f1Var.G(), str, w7.u.Fg);
        } else if (j10 == 5) {
            f1Var.X3(i10, cVar);
        } else {
            f1Var.getClass();
        }
    }

    public static /* synthetic */ void N3(f1 f1Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            f1Var.Z3(-1);
            return;
        }
        if (i10 == 1) {
            f1Var.g4();
        } else if (i10 != 2) {
            f1Var.getClass();
        } else {
            f1Var.f4();
        }
    }

    public static /* synthetic */ boolean O3(final f1 f1Var, View view, final int i10, g1 g1Var) {
        f1Var.getClass();
        final ra.c cVarA = g1Var.a();
        q5.k kVarL = q5.k.l(view.getContext());
        ArrayList arrayList = new ArrayList();
        final String strB = cVarA.b();
        boolean z10 = (strB == null || strB.isEmpty()) ? false : true;
        if (z10) {
            arrayList.add(new q5.k.l(2, f1Var.X0(w7.u.Bh)));
        }
        if (cVarA.c() != null && !cVarA.c().isEmpty()) {
            arrayList.add(new q5.k.l(3, f1Var.X0(w7.u.D6)));
        }
        if (z10) {
            arrayList.add(new q5.k.l(4, f1Var.X0(w7.u.f14218s)));
        }
        arrayList.add(new q5.k.l(5, f1Var.X0(w7.u.f14298y)));
        kVarL.D(arrayList, new AdapterView.OnItemClickListener() { // from class: oa.t
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                f1.M3(this.f11062a, cVarA, strB, i10, adapterView, view2, i11, j10);
            }
        });
        kVarL.j0(view);
        return true;
    }

    public static /* synthetic */ void P3(f1 f1Var, ra.a aVar, boolean z10, ra.c cVar, View view, q5.k.p pVar) {
        int iE;
        if (z10) {
            f1Var.getClass();
            iE = cVar.e();
        } else {
            iE = 0;
        }
        f1Var.U3(aVar, iE);
    }

    public static /* synthetic */ void Q3(f1 f1Var, x.d dVar) {
        f1Var.getClass();
        f1Var.r4((ra.a) dVar.f14455a, (ra.c) dVar.f14456b);
    }

    public static /* synthetic */ void R3(f1 f1Var, ra.c cVar) {
        f1Var.f11003w0.s(cVar.e());
        f1Var.f11003w0.u();
    }

    public static /* synthetic */ void S3(final f1 f1Var) {
        com.tuyafeng.support.utils.n.q(f1Var.G(), w7.u.Hh);
        x8.h.b(new Runnable() { // from class: oa.t0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11066c.f11003w0.I();
            }
        });
        f1Var.f11006z0 = false;
    }

    public static Bundle V3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, i10);
        return bundle;
    }

    private List W3() {
        boolean z10;
        if (this.f11001u0.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11001u0.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            if (((ra.c) it.next()).b() != null) {
                z10 = true;
                break;
            }
        }
        boolean zC = this.f11004x0.n2().C();
        arrayList.add(new v5.n(1, X0(w7.u.H4), zC));
        this.f11005y0.setVisibility(z10 ? 0 : 8);
        if (z10) {
            arrayList.add(new v5.q(2, X0(w7.u.Dh), com.tuyafeng.support.utils.e.c(G(), w7.j.f13718i, e4())));
        }
        arrayList.add(new v5.l(X0(w7.u.Ic)));
        Iterator it2 = this.f11001u0.iterator();
        while (it2.hasNext()) {
            arrayList.add(new g1((ra.c) it2.next(), zC));
        }
        return arrayList;
    }

    public static List b4(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, f1.class, w7.u.Ic);
        hVar.b(1, w7.u.H4, new String[0]);
        hVar.b(2, w7.u.Dh, new String[0]);
        return hVar.f();
    }

    private int e4() {
        long jA = this.f11004x0.A("scripts");
        int[] iArr = {0, 1, 3, 7, 15};
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            if (jA >= iArr[i11] * 86400000) {
                i10 = i11;
            }
        }
        return i10;
    }

    public static /* synthetic */ void g3(f1 f1Var, Uri uri) {
        if (uri == null) {
            f1Var.getClass();
        } else {
            f1Var.i4(x8.b1.i(f1Var.G(), uri));
        }
    }

    public static /* synthetic */ void j3(f1 f1Var, String str, Bundle bundle) {
        if (bundle != null) {
            f1Var.getClass();
            if (bundle.containsKey(Name.MARK)) {
                f1Var.m4(bundle.getInt(Name.MARK));
            }
        }
        f1Var.L0().x("script_result_v2");
    }

    public static /* synthetic */ s5.a k3(f1 f1Var, String str, boolean z10, int i10, s5.a aVar) {
        f1Var.getClass();
        if (!aVar.d()) {
            return s5.a.f(null);
        }
        ra.a aVarE = ra.a.e((String) aVar.b(), str);
        if (aVarE == null) {
            return s5.a.f(null);
        }
        aVarE.f(z10);
        if (i10 <= 0) {
            i10 = f1Var.f11003w0.a(aVarE);
        } else if (!f1Var.f11003w0.p(i10, aVarE)) {
            i10 = 0;
        }
        if (i10 <= 0) {
            return s5.a.f(null);
        }
        ra.c cVarK = f1Var.f11003w0.k(i10);
        if (cVarK != null) {
            cVarK.r(f1Var.f11003w0.x(i10));
        }
        return s5.a.f(cVarK);
    }

    public static /* synthetic */ void l3(f1 f1Var, String str, Bundle bundle) {
        if (bundle != null) {
            f1Var.getClass();
            if (bundle.containsKey(Name.MARK)) {
                f1Var.m4(bundle.getInt(Name.MARK));
            }
        }
        f1Var.L0().x("editor_result");
    }

    private void l4() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: oa.a1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f10981c.f11003w0.q();
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: oa.b1
            @Override // u6.f
            public final void accept(Object obj) {
                f1.H3(this.f10986c, (List) obj);
            }
        }, new w7.a0());
    }

    public static /* synthetic */ void m3(f1 f1Var, View view, int i10, v5.n nVar) {
        f1Var.getClass();
        if (nVar.c() != 1) {
            return;
        }
        u9.p pVarN2 = f1Var.f11004x0.n2();
        pVarN2.g0(true ^ nVar.i());
        f1Var.f11004x0.F1(pVarN2);
        f1Var.s4(f1Var.W3());
    }

    public static /* synthetic */ void p3(f1 f1Var, View view, q5.k.p pVar) {
        f1Var.getClass();
        String[] strArr = pVar.f11819c;
        if (strArr == null || strArr.length < 1) {
            return;
        }
        String strTrim = strArr[0].trim();
        if (a2.f1958a.t(strTrim)) {
            f1Var.j4(strTrim);
        } else {
            com.tuyafeng.support.utils.n.q(f1Var.G(), w7.u.Oh);
        }
    }

    public static /* synthetic */ void q3(f1 f1Var, g1 g1Var, View view, q5.k.p pVar) {
        f1Var.getClass();
        f1Var.k4(g1Var.a().b(), g1Var.a().e());
    }

    private void q4(v5.q qVar, int i10) {
        q5.k.l(G()).f0(w7.u.Dh).b0(w7.j.f13718i, e4(), new AdapterView.OnItemClickListener() { // from class: oa.c1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                f1.v3(this.f10989a, adapterView, view, i11, j10);
            }
        }).h0();
    }

    public static /* synthetic */ void r3(final f1 f1Var, String str, final String str2, Boolean bool) {
        f1Var.getClass();
        if (bool.booleanValue()) {
            return;
        }
        com.tuyafeng.support.utils.n.t(f1Var.G(), f1Var.Y0(w7.u.Ig, str), f1Var.X0(w7.u.oi), new View.OnClickListener() { // from class: oa.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f1.s3(this.f11079a, str2, view);
            }
        });
    }

    public static /* synthetic */ void s3(f1 f1Var, String str, View view) {
        f1Var.getClass();
        FragmentUtils.j(f1Var, sa.y.class, sa.y.E3(str, true));
    }

    private void s4(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new h1(this.f11002v0.H(), list));
        this.f11002v0.M(list);
        eVarB.c(this.f11002v0);
        d3(list.isEmpty());
    }

    public static /* synthetic */ void v3(f1 f1Var, AdapterView adapterView, View view, int i10, long j10) {
        f1Var.f11004x0.E("scripts", new int[]{0, 1, 3, 7, 15}[i10] * 86400000);
        f1Var.s4(f1Var.W3());
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0057  */
    /* JADX WARN: Code duplicated, block: B:40:0x005c A[ORIG_RETURN, RETURN] */
    public static /* synthetic */ String w3(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                int i11 = 0;
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        i10++;
                        if (i11 == 0) {
                            if (line.startsWith("// ==UserScript==")) {
                                i11 = 1;
                            }
                            if (i11 == 0 && i10 > 32) {
                                break;
                            }
                        }
                        sb2.append(line);
                        sb2.append("\n");
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            try {
                                th.addSuppressed(th2);
                            } catch (Exception e10) {
                                e = e10;
                                i10 = i11;
                                e.printStackTrace();
                                com.tuyafeng.support.utils.j.a(inputStream);
                                if (i10 != 0) {
                                    return sb2.toString();
                                }
                                return "";
                            }
                        }
                        throw th;
                    }
                }
                i10 = i11;
                bufferedReader.close();
            } catch (Throwable th3) {
                com.tuyafeng.support.utils.j.a(inputStream);
                throw th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
        com.tuyafeng.support.utils.j.a(inputStream);
        if (i10 != 0) {
            return sb2.toString();
        }
        return "";
    }

    public static /* synthetic */ void x3(f1 f1Var, View view, int i10, boolean z10, g1 g1Var) {
        f1Var.getClass();
        int iH4 = f1Var.h4(g1Var.a().e());
        if (iH4 >= 0) {
            ((ra.c) f1Var.f11001u0.get(iH4)).n(z10);
        }
        g1Var.a().n(z10);
        f1Var.f11003w0.l(g1Var.a().e(), z10);
    }

    public static /* synthetic */ void z3(final f1 f1Var, View view, int i10, final g1 g1Var) {
        f1Var.getClass();
        if (g1Var.a().k()) {
            q5.k.l(f1Var.G()).g0(g1Var.a().g()).K(f1Var.X0(w7.u.f14118kb)).X(R.string.ok, new q5.k.m() { // from class: oa.s
                @Override // q5.k.m
                public final void a(View view2, q5.k.p pVar) {
                    f1.q3(this.f11056a, g1Var, view2, pVar);
                }
            }).P(R.string.cancel, null).h0();
        } else {
            f1Var.a4(g1Var.a().e());
        }
    }

    public final void T3(View view) {
        q5.k.l(G()).G(new String[]{X0(w7.u.f14286x0), X0(w7.u.f13988b7), X0(w7.u.f13974a7)}, new AdapterView.OnItemClickListener() { // from class: oa.v
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                f1.N3(this.f11070a, adapterView, view2, i10, j10);
            }
        }).j0(view);
    }

    public final void U3(final ra.a aVar, final int i10) {
        final String strD = aVar.d();
        final String strG = aVar.c().g();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: oa.p0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f1.D3(this.f11038c, i10, aVar);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: oa.q0
            @Override // u6.f
            public final void accept(Object obj) {
                f1.G3(this.f11051c, strG, strD, (s5.a) obj);
            }
        }, new w7.a0());
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f11001u0 = new ArrayList();
        this.f11002v0 = new t5.f(Collections.EMPTY_LIST);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: oa.r
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                f1.m3(this.f11054a, view2, i10, (v5.n) obj);
            }
        });
        this.f11002v0.K(v5.n.class, pVar);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: oa.c0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                f1.A3(this.f10988a, view2, i10, (v5.q) obj);
            }
        });
        this.f11002v0.K(v5.q.class, sVar);
        this.f11002v0.K(v5.l.class, new v5.m());
        j1 j1Var = new j1();
        j1Var.o(new j1.a() { // from class: oa.n0
            @Override // oa.j1.a
            public final void a(View view2, int i10, boolean z10, g1 g1Var) {
                f1.x3(this.f11034a, view2, i10, z10, g1Var);
            }
        });
        j1Var.j(new t5.g() { // from class: oa.y0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                f1.z3(this.f11083a, view2, i10, (g1) obj);
            }
        });
        j1Var.k(new t5.h() { // from class: oa.z0
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return f1.O3(this.f11086a, view2, i10, (g1) obj);
            }
        });
        this.f11002v0.K(g1.class, j1Var);
        this.f7946t0.setAdapter(this.f11002v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        l4();
    }

    public final void X3(int i10, final ra.c cVar) {
        q5.k.l(G()).f0(w7.u.f14298y).K(Y0(w7.u.f14222s3, cVar.g())).X(R.string.ok, new q5.k.m() { // from class: oa.z
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                f1.J3(this.f11084a, cVar, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void Y3(final String str, final String str2) {
        if (com.tuyafeng.support.utils.p.f(str)) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: oa.u0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f11068c.f11003w0.J(str));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: oa.v0
            @Override // u6.f
            public final void accept(Object obj) {
                f1.r3(this.f11071c, str2, str, (Boolean) obj);
            }
        }, new w7.e0());
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.b(e0Var, X0(w7.u.Ic));
        e0Var.c(com.tuyafeng.support.widget.e0.b.a(lb.g.a(G(), w7.o.f13810m, w7.u.ge), X0(w7.u.f14286x0)), new View.OnClickListener() { // from class: oa.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10994a.T3(view);
            }
        });
        int iL = com.tuyafeng.support.utils.x.l();
        e0Var.c(new com.tuyafeng.support.widget.e0.b(iL, 0, null, X0(w7.u.Bh)), new View.OnClickListener() { // from class: oa.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10998a.p4();
            }
        });
        this.f11005y0 = e0Var.findViewById(iL);
    }

    public final void Z3(int i10) {
        L0().z1("script_result_v2", this, new androidx.fragment.app.i0() { // from class: oa.i0
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                f1.j3(this.f11017a, str, bundle);
            }
        });
        FragmentUtils.j(this, q.class, q.p3(i10));
    }

    public final void a4(int i10) {
        if (i10 <= 0) {
            return;
        }
        L0().z1("editor_result", this, new androidx.fragment.app.i0() { // from class: oa.u
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                f1.l3(this.f11067a, str, bundle);
            }
        });
        FragmentUtils.j(this, sa.y.class, sa.y.D3(i10));
    }

    public final r6.f c4(final String str) {
        return r6.f.h(new Callable() { // from class: oa.g0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ua.a.c(str);
            }
        });
    }

    public final r6.f d4(final InputStream inputStream) {
        return r6.f.h(new Callable() { // from class: oa.w0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f1.w3(inputStream);
            }
        });
    }

    public final void f4() {
        this.B0.b(new String[]{"text/plain", "application/javascript", "text/javascript"}, new n8.f.a() { // from class: oa.l0
            @Override // n8.f.a
            public final void a(Uri uri) {
                f1.g3(this.f11029a, uri);
            }
        });
    }

    public final void g4() {
        q5.k.l(G()).f0(w7.u.f13988b7).i("", X0(w7.u.f14305y6), 1).X(R.string.ok, new q5.k.m() { // from class: oa.k0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                f1.p3(this.f11026a, view, pVar);
            }
        }).h0();
    }

    public final int h4(int i10) {
        int size = this.f11001u0.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((ra.c) this.f11001u0.get(i11)).e() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void i4(InputStream inputStream) {
        com.tuyafeng.support.utils.n.s(G(), X0(w7.u.Og));
        ((autodispose2.m) d4(inputStream).f(new u6.g() { // from class: oa.m0
            @Override // u6.g
            public final Object apply(Object obj) {
                return this.f11032a.o4((String) obj, null, 0);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: oa.o0
            @Override // u6.f
            public final void accept(Object obj) {
                f1.Q3(this.f11036c, (x.d) obj);
            }
        }, new w7.e0());
    }

    public final void j4(String str) {
        k4(str, 0);
    }

    public final void k4(final String str, final int i10) {
        com.tuyafeng.support.utils.n.s(G(), X0(w7.u.Og));
        ((autodispose2.m) c4(str).f(new u6.g() { // from class: oa.w
            @Override // u6.g
            public final Object apply(Object obj) {
                return this.f11074a.o4((String) obj, str, i10);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: oa.x
            @Override // u6.f
            public final void accept(Object obj) {
                f1.C3(this.f11078c, (x.d) obj);
            }
        }, new w7.e0());
    }

    public final void m4(final int i10) {
        ra.c cVarK = this.f11003w0.k(i10);
        if (cVarK == null) {
            return;
        }
        cVarK.r(this.f11003w0.x(i10));
        int iH4 = h4(i10);
        if (iH4 < 0) {
            this.f11001u0.add(0, cVarK);
            s4(W3());
            if (this.f7946t0.getLayoutManager() != null) {
                this.f7946t0.getLayoutManager().y1(0);
            }
        } else {
            this.f11001u0.set(iH4, cVarK);
            s4(W3());
        }
        x8.h.b(new Runnable() { // from class: oa.a0
            @Override // java.lang.Runnable
            public final void run() {
                f1.I3(this.f10979c, i10);
            }
        });
    }

    public final void n4(ra.c cVar) {
        String strC = cVar.c();
        if (strC == null || strC.isEmpty()) {
            return;
        }
        x8.z.O(G(), strC);
    }

    public final r6.f o4(final String str, final String str2, final int i10) {
        return r6.f.h(new Callable() { // from class: oa.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f1.B3(this.f10982c, str, str2, i10);
            }
        });
    }

    public final void p4() {
        if (this.f11006z0) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (ra.c cVar : this.f11001u0) {
            if (cVar.j() && a2.f1958a.t(cVar.b())) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.size() <= 0) {
            return;
        }
        q5.k kVarL = q5.k.l(G());
        kVarL.f0(w7.u.Bh);
        if (arrayList.size() == 1) {
            kVarL.K(Y0(w7.u.f14104jb, ((ra.c) arrayList.get(0)).g()));
        } else {
            int size = arrayList.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                strArr[i10] = ((ra.c) arrayList.get(i10)).g();
                iArr[i10] = i10;
            }
            kVarL.M(strArr, iArr);
        }
        kVarL.X(R.string.ok, new q5.k.m() { // from class: oa.y
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                f1.K3(this.f11081a, arrayList, view, pVar);
            }
        });
        kVarL.P(R.string.cancel, null);
        kVarL.h0();
    }

    public final void r4(final ra.a aVar, final ra.c cVar) {
        if (aVar == null) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.Jg);
            return;
        }
        q5.k kVarK = o2.k(G(), aVar, cVar);
        if (kVarK == null) {
            return;
        }
        final boolean z10 = cVar != null;
        kVarK.X(R.string.ok, new q5.k.m() { // from class: oa.h0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                f1.P3(this.f11012a, aVar, z10, cVar, view, pVar);
            }
        });
        kVarK.P(R.string.cancel, null);
        kVarK.h0();
    }

    public final void t4(ra.c cVar) {
        String strB = cVar.b();
        if (strB == null || strB.isEmpty()) {
            return;
        }
        k4(strB, cVar.e());
    }

    public final r6.j u4(ra.c cVar) {
        final String strB = cVar.b();
        final boolean zJ = cVar.j();
        final int iE = cVar.e();
        return r6.j.v(new Callable() { // from class: oa.r0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s5.a.f(ua.a.c(strB));
            }
        }).A(new u6.g() { // from class: oa.s0
            @Override // u6.g
            public final Object apply(Object obj) {
                return f1.k3(this.f11058a, strB, zJ, iE, (s5.a) obj);
            }
        }).G(a7.a.c());
    }

    public final void v4(List list) {
        if (this.f11006z0 || list == null || list.size() <= 0) {
            return;
        }
        this.f11006z0 = true;
        com.tuyafeng.support.utils.n.q(G(), w7.u.Gh);
        ((autodispose2.n) (list.size() == 1 ? u4((ra.c) list.get(0)) : r6.j.w(list).q(new u6.g() { // from class: oa.d0
            @Override // u6.g
            public final Object apply(Object obj) {
                return this.f10993a.u4((ra.c) obj);
            }
        })).G(a7.a.c()).C(q6.b.b()).L(s8.b.a(this))).b(new u6.f() { // from class: oa.e0
            @Override // u6.f
            public final void accept(Object obj) {
                f1.F3(this.f10997c, (s5.a) obj);
            }
        }, new w7.a0(), new u6.a() { // from class: oa.f0
            @Override // u6.a
            public final void run() {
                f1.S3(this.f11000a);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f11003w0 = kd.c().f();
        this.f11004x0 = la.s.j();
    }
}
