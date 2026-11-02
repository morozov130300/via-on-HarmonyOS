package sa;

import android.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import c8.lc;
import com.tuyafeng.support.widget.z;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import p8.f;
import sa.h1;
import w5.k;
import z8.t2;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d1 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public List f11883r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f11884s0;

    /* renamed from: t0, reason: collision with root package name */
    public p5.c f11885t0;

    /* renamed from: u0, reason: collision with root package name */
    public w9.l f11886u0;

    /* renamed from: v0, reason: collision with root package name */
    public View f11887v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f11888w0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f11889x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public final p8.f f11890y0 = new p8.f(this);

    public static /* synthetic */ void A3(d1 d1Var, View view, int i10, boolean z10, e1 e1Var) {
        d1Var.getClass();
        int iI4 = d1Var.i4(e1Var.a().e());
        if (iI4 >= 0) {
            ((r5.c) d1Var.f11883r0.get(iI4)).n(z10);
        }
        e1Var.a().n(z10);
        d1Var.f11885t0.l(e1Var.a().e(), z10);
    }

    public static /* synthetic */ void C3(d1 d1Var, r5.a aVar, boolean z10, r5.c cVar, View view, k.p pVar) {
        int iE;
        if (z10) {
            d1Var.getClass();
            iE = cVar.e();
        } else {
            iE = 0;
        }
        d1Var.V3(aVar, iE);
    }

    public static /* synthetic */ void D3(final d1 d1Var, View view, int i10, final e1 e1Var) {
        d1Var.getClass();
        if (e1Var.a().k()) {
            w5.k.l(d1Var.I()).e0(e1Var.a().g()).J(d1Var.Z0(x7.u.Ya)).V(R.string.ok, new k.m() { // from class: sa.s
                @Override // w5.k.m
                public final void a(View view2, k.p pVar) {
                    d1.r3(this.f11952a, e1Var, view2, pVar);
                }
            }).N(R.string.cancel, null).f0();
        } else {
            d1Var.a4(e1Var.a());
        }
    }

    public static /* synthetic */ x5.a E3(d1 d1Var, int i10, r5.a aVar) {
        if (i10 <= 0) {
            i10 = d1Var.f11885t0.h(aVar);
        } else if (!d1Var.f11885t0.p(i10, aVar)) {
            i10 = 0;
        }
        return x5.a.f(i10 > 0 ? d1Var.f11885t0.k(i10) : null);
    }

    public static /* synthetic */ void F3(d1 d1Var, View view, int i10, a6.q qVar) {
        d1Var.getClass();
        if (qVar.c() != 2) {
            return;
        }
        d1Var.r4(qVar, i10);
    }

    public static /* synthetic */ w.d G3(d1 d1Var, String str, String str2, int i10) {
        d1Var.getClass();
        r5.a aVarF = r5.a.f(str, str2);
        if (aVarF == null) {
            return new w.d(null, null);
        }
        return new w.d(aVarF, i10 > 0 ? d1Var.f11885t0.k(i10) : d1Var.f11885t0.q(aVarF.e()));
    }

    public static /* synthetic */ void H3(d1 d1Var, w.d dVar) {
        d1Var.getClass();
        d1Var.s4((r5.a) dVar.f13207a, (r5.c) dVar.f13208b);
    }

    public static /* synthetic */ void I3(d1 d1Var, x5.a aVar) {
        d1Var.getClass();
        if (aVar.d()) {
            r5.c cVar = (r5.c) aVar.b();
            int iI4 = d1Var.i4(cVar.e());
            if (iI4 < 0) {
                d1Var.f11883r0.add(0, cVar);
            } else {
                d1Var.f11883r0.set(iI4, cVar);
            }
            d1Var.t4(d1Var.X3());
        }
    }

    public static /* synthetic */ void J3(d1 d1Var, String str, String str2, x5.a aVar) {
        d1Var.getClass();
        if (!aVar.d()) {
            g6.n.s(d1Var.I(), d1Var.a1(x7.u.ug, str));
            return;
        }
        g6.n.s(d1Var.I(), d1Var.a1(x7.u.vg, str));
        d1Var.n4(((r5.c) aVar.b()).e());
        d1Var.Z3(str2, str);
    }

    public static /* synthetic */ void K3(d1 d1Var, List list) {
        int i10 = 0;
        int i11 = (d1Var.f11889x0 || d1Var.y0() == null) ? 0 : d1Var.y0().getInt(Name.MARK, 0);
        int size = list.size();
        int i12 = -1;
        for (int i13 = 0; i13 < size; i13++) {
            r5.c cVar = (r5.c) list.get(i13);
            cVar.r(d1Var.f11885t0.w(cVar.e()));
            if (cVar.e() == i11) {
                i12 = i13;
            }
        }
        d1Var.f11883r0.clear();
        d1Var.f11883r0.addAll(list);
        List listX3 = d1Var.X3();
        d1Var.t4(listX3);
        if (i12 >= 0) {
            Iterator it = listX3.iterator();
            while (it.hasNext() && !(it.next() instanceof e1)) {
                i10++;
            }
            g6.y.W(d1Var.f10459q0, i10 + i12);
        }
        d1Var.f11889x0 = true;
    }

    public static /* synthetic */ void L3(d1 d1Var, int i10) {
        p5.c cVar = d1Var.f11885t0;
        cVar.J(cVar.B(i10));
    }

    public static /* synthetic */ void M3(d1 d1Var, List list, View view, k.p pVar) {
        d1Var.getClass();
        if (list.size() == 1) {
            d1Var.w4(list);
            return;
        }
        int[] iArr = pVar.f13337a;
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            arrayList.add((r5.c) list.get(i10));
        }
        d1Var.w4(arrayList);
    }

    public static /* synthetic */ void O3(d1 d1Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            d1Var.b4(-1);
            return;
        }
        if (i10 == 1) {
            d1Var.h4();
        } else if (i10 != 2) {
            d1Var.getClass();
        } else {
            d1Var.g4();
        }
    }

    public static /* synthetic */ boolean P3(final d1 d1Var, View view, final int i10, e1 e1Var) {
        d1Var.getClass();
        final r5.c cVarA = e1Var.a();
        w5.k kVarL = w5.k.l(view.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new k.l(1, d1Var.Z0(x7.u.D)));
        if (cVarA.b() != null && !cVarA.b().isEmpty()) {
            arrayList.add(new k.l(2, d1Var.Z0(x7.u.ch)));
        }
        if (cVarA.c() != null && !cVarA.c().isEmpty()) {
            arrayList.add(new k.l(3, d1Var.Z0(x7.u.f14144r6)));
        }
        arrayList.add(new k.l(4, d1Var.Z0(x7.u.f14150s)));
        arrayList.add(new k.l(5, d1Var.Z0(x7.u.f14215x)));
        kVarL.C(arrayList, new AdapterView.OnItemClickListener() { // from class: sa.t
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                d1.T3(this.f11955a, cVarA, i10, adapterView, view2, i11, j10);
            }
        });
        kVarL.h0(view);
        return true;
    }

    public static /* synthetic */ void Q3(d1 d1Var, w.d dVar) {
        d1Var.getClass();
        d1Var.s4((r5.a) dVar.f13207a, (r5.c) dVar.f13208b);
    }

    public static /* synthetic */ void R3(d1 d1Var, r5.c cVar) {
        d1Var.f11885t0.r(cVar.e());
        d1Var.f11885t0.t();
    }

    public static /* synthetic */ void S3(final d1 d1Var) {
        g6.n.q(d1Var.I(), x7.u.ih);
        z8.h.b(new Runnable() { // from class: sa.o0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11939e.f11885t0.I();
            }
        });
        d1Var.f11888w0 = false;
    }

    public static /* synthetic */ void T3(d1 d1Var, r5.c cVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (j10 == 1) {
            d1Var.a4(cVar);
            return;
        }
        if (j10 == 2) {
            d1Var.u4(cVar);
            return;
        }
        if (j10 == 3) {
            d1Var.o4(cVar);
            return;
        }
        if (j10 == 4) {
            g6.n.a(d1Var.I(), cVar.b(), x7.u.pg);
        } else if (j10 == 5) {
            d1Var.Y3(i10, cVar);
        } else {
            d1Var.getClass();
        }
    }

    public static Bundle W3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(Name.MARK, i10);
        return bundle;
    }

    private List X3() {
        boolean z10;
        if (this.f11883r0.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11883r0.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            if (((r5.c) it.next()).b() != null) {
                z10 = true;
                break;
            }
        }
        boolean zD = this.f11886u0.m2().D();
        arrayList.add(new a6.n(1, Z0(x7.u.f14181u4), zD));
        this.f11887v0.setVisibility(z10 ? 0 : 8);
        if (z10) {
            arrayList.add(new a6.q(2, Z0(x7.u.eh), g6.e.c(I(), x7.j.f13652i, f4())));
        }
        arrayList.add(new a6.l(Z0(x7.u.uc)));
        Iterator it2 = this.f11883r0.iterator();
        while (it2.hasNext()) {
            arrayList.add(new e1((r5.c) it2.next(), zD));
        }
        return arrayList;
    }

    private int f4() {
        long jZ = this.f11886u0.z("scripts");
        int[] iArr = {0, 1, 3, 7, 15};
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            if (jZ >= iArr[i11] * 86400000) {
                i10 = i11;
            }
        }
        return i10;
    }

    public static /* synthetic */ void h3(d1 d1Var, Uri uri) {
        if (uri == null) {
            d1Var.getClass();
        } else {
            d1Var.j4(z8.b1.i(d1Var.I(), uri));
        }
    }

    public static /* synthetic */ void k3(d1 d1Var, String str, Bundle bundle) {
        if (bundle != null) {
            d1Var.getClass();
            if (bundle.containsKey(Name.MARK)) {
                d1Var.n4(bundle.getInt(Name.MARK));
            }
        }
        d1Var.N0().x("script_result_v2");
    }

    public static /* synthetic */ x5.a l3(d1 d1Var, String str, boolean z10, int i10, x5.a aVar) {
        r5.a aVarF;
        d1Var.getClass();
        if (aVar.d() && (aVarF = r5.a.f((String) aVar.b(), str)) != null) {
            aVarF.g(z10);
            if (i10 <= 0) {
                i10 = d1Var.f11885t0.h(aVarF);
            } else if (!d1Var.f11885t0.p(i10, aVarF)) {
                i10 = 0;
            }
            if (i10 <= 0) {
                return x5.a.f(null);
            }
            r5.c cVarK = d1Var.f11885t0.k(i10);
            if (cVarK != null) {
                cVarK.r(d1Var.f11885t0.w(i10));
            }
            return x5.a.f(cVarK);
        }
        return x5.a.f(null);
    }

    public static /* synthetic */ void m3(d1 d1Var, String str, Bundle bundle) {
        if (bundle != null) {
            d1Var.getClass();
            if (bundle.containsKey(Name.MARK)) {
                d1Var.n4(bundle.getInt(Name.MARK));
            }
        }
        d1Var.N0().x("editor_result");
    }

    private void m4() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: sa.a1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f11871e.f11885t0.o();
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: sa.b1
            @Override // a7.e
            public final void accept(Object obj) {
                d1.K3(this.f11876e, (List) obj);
            }
        }, new x7.c0());
    }

    public static /* synthetic */ void n3(d1 d1Var, View view, int i10, a6.n nVar) {
        d1Var.getClass();
        if (nVar.c() != 1) {
            return;
        }
        w9.p pVarM2 = d1Var.f11886u0.m2();
        pVarM2.i0(true ^ nVar.i());
        d1Var.f11886u0.g0(pVarM2);
        d1Var.t4(d1Var.X3());
    }

    public static /* synthetic */ void q3(d1 d1Var, View view, k.p pVar) {
        d1Var.getClass();
        String[] strArr = pVar.f13339c;
        if (strArr == null || strArr.length < 1) {
            return;
        }
        String strTrim = strArr[0].trim();
        if (i6.i0.f7006a.s(strTrim)) {
            d1Var.k4(strTrim);
        } else {
            g6.n.q(d1Var.I(), x7.u.ph);
        }
    }

    public static /* synthetic */ void r3(d1 d1Var, e1 e1Var, View view, k.p pVar) {
        d1Var.getClass();
        d1Var.l4(e1Var.a().b(), e1Var.a().e());
    }

    private void r4(a6.q qVar, int i10) {
        w5.k.l(I()).d0(x7.u.eh).Z(x7.j.f13652i, f4(), new AdapterView.OnItemClickListener() { // from class: sa.q
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                d1.x3(this.f11943a, adapterView, view, i11, j10);
            }
        }).f0();
    }

    public static /* synthetic */ void s3(final d1 d1Var, String str, final String str2, Boolean bool) {
        d1Var.getClass();
        if (bool.booleanValue()) {
            return;
        }
        g6.n.t(d1Var.I(), d1Var.a1(x7.u.sg, str), d1Var.Z0(x7.u.Jh), new View.OnClickListener() { // from class: sa.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d1.t3(this.f11967a, str2, view);
            }
        });
    }

    public static /* synthetic */ void t3(d1 d1Var, String str, View view) {
        d1Var.getClass();
        g6.i.h(d1Var, ta.u.class, ta.u.F3(str, true));
    }

    private void t4(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new f1(this.f11884s0.H(), list));
        this.f11884s0.M(list);
        eVarB.c(this.f11884s0);
        e3(list.isEmpty());
    }

    public static /* synthetic */ void x3(d1 d1Var, AdapterView adapterView, View view, int i10, long j10) {
        d1Var.f11886u0.D("scripts", new int[]{0, 1, 3, 7, 15}[i10] * 86400000);
        d1Var.t4(d1Var.X3());
    }

    public static /* synthetic */ void y3(final d1 d1Var, final r5.c cVar, View view, k.p pVar) {
        d1Var.getClass();
        z8.h.b(new Runnable() { // from class: sa.p0
            @Override // java.lang.Runnable
            public final void run() {
                d1.R3(this.f11941e, cVar);
            }
        });
        int iI4 = d1Var.i4(cVar.e());
        if (iI4 >= 0) {
            d1Var.f11883r0.remove(iI4);
            d1Var.t4(d1Var.X3());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005c A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ String z3(InputStream inputStream) throws IOException {
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
                                if (i10 == 0) {
                                }
                            }
                        }
                        throw th;
                    }
                }
                i10 = i11;
                bufferedReader.close();
            } finally {
                g6.j.a(inputStream);
            }
        } catch (Exception e11) {
            e = e11;
        }
        return i10 == 0 ? sb2.toString() : "";
    }

    public final void U3(View view) {
        w5.k.l(I()).F(new String[]{Z0(x7.u.f14190v0), Z0(x7.u.P6), Z0(x7.u.O6)}, new AdapterView.OnItemClickListener() { // from class: sa.c1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                d1.O3(this.f11880a, adapterView, view2, i10, j10);
            }
        }).h0(view);
    }

    public final void V3(final r5.a aVar, final int i10) {
        final String strE = aVar.e();
        final String strG = aVar.d().g();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: sa.q0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d1.E3(this.f11944e, i10, aVar);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: sa.r0
            @Override // a7.e
            public final void accept(Object obj) {
                d1.J3(this.f11949e, strG, strE, (x5.a) obj);
            }
        }, new x7.c0());
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f11883r0 = new ArrayList();
        this.f11884s0 = new y5.f(Collections.EMPTY_LIST);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: sa.p
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                d1.n3(this.f11940a, view2, i10, (a6.n) obj);
            }
        });
        this.f11884s0.K(a6.n.class, pVar);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: sa.a0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                d1.F3(this.f11870a, view2, i10, (a6.q) obj);
            }
        });
        this.f11884s0.K(a6.q.class, sVar);
        this.f11884s0.K(a6.l.class, new a6.m());
        h1 h1Var = new h1();
        h1Var.o(new h1.a() { // from class: sa.l0
            @Override // sa.h1.a
            public final void a(View view2, int i10, boolean z10, e1 e1Var) {
                d1.A3(this.f11918a, view2, i10, z10, e1Var);
            }
        });
        h1Var.j(new y5.g() { // from class: sa.w0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                d1.D3(this.f11970a, view2, i10, (e1) obj);
            }
        });
        h1Var.k(new y5.h() { // from class: sa.x0
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return d1.P3(this.f11972a, view2, i10, (e1) obj);
            }
        });
        this.f11884s0.K(e1.class, h1Var);
        this.f10459q0.setAdapter(this.f11884s0);
        m4();
    }

    public final void Y3(int i10, final r5.c cVar) {
        w5.k.l(I()).d0(x7.u.f14215x).J(a1(x7.u.f13988g3, cVar.g())).V(R.string.ok, new k.m() { // from class: sa.e0
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                d1.y3(this.f11891a, cVar, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void Z3(final String str, final String str2) {
        if (g6.p.f(str)) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: sa.t0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f11958e.f11885t0.J(str));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: sa.u0
            @Override // a7.e
            public final void accept(Object obj) {
                d1.s3(this.f11961e, str2, str, (Boolean) obj);
            }
        }, new x7.g0());
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        v3.b(zVar, Z0(x7.u.uc));
        zVar.c(z.b.a(lb.b.a(I(), x7.o.f13747n, x7.u.Rd), Z0(x7.u.f14190v0)), new View.OnClickListener() { // from class: sa.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11974a.U3(view);
            }
        });
        int iL = g6.y.l();
        zVar.c(new z.b(iL, 0, null, Z0(x7.u.ch)), new View.OnClickListener() { // from class: sa.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11976a.q4();
            }
        });
        this.f11887v0 = zVar.findViewById(iL);
    }

    public final void a4(r5.c cVar) {
        if (cVar == null) {
            return;
        }
        c4(cVar.e());
    }

    public final void b4(int i10) {
        N0().y1("script_result_v2", this, new androidx.fragment.app.i0() { // from class: sa.b0
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                d1.k3(this.f11875a, str, bundle);
            }
        });
        g6.i.h(this, o.class, o.p3(i10));
    }

    public final void c4(int i10) {
        if (i10 <= 0) {
            return;
        }
        N0().y1("editor_result", this, new androidx.fragment.app.i0() { // from class: sa.u
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                d1.m3(this.f11960a, str, bundle);
            }
        });
        g6.i.h(this, ta.u.class, ta.u.E3(i10));
    }

    public final x6.f d4(final String str) {
        return x6.f.h(new Callable() { // from class: sa.j0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s5.b.d(str);
            }
        });
    }

    public final x6.f e4(final InputStream inputStream) {
        return x6.f.h(new Callable() { // from class: sa.s0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d1.z3(inputStream);
            }
        });
    }

    public final void g4() {
        this.f11890y0.b(new String[]{"text/plain", "application/javascript", "text/javascript"}, new f.a() { // from class: sa.d0
            @Override // p8.f.a
            public final void a(Uri uri) {
                d1.h3(this.f11882a, uri);
            }
        });
    }

    public final void h4() {
        w5.k.l(I()).d0(x7.u.P6).i("", Z0(x7.u.f14075m6), 1).V(R.string.ok, new k.m() { // from class: sa.c0
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                d1.q3(this.f11879a, view, pVar);
            }
        }).f0();
    }

    public final int i4(int i10) {
        int size = this.f11883r0.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((r5.c) this.f11883r0.get(i11)).e() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void j4(InputStream inputStream) {
        g6.n.s(I(), Z0(x7.u.yg));
        ((autodispose2.m) e4(inputStream).f(new a7.f() { // from class: sa.g0
            @Override // a7.f
            public final Object apply(Object obj) {
                return this.f11899a.p4((String) obj, null, 0);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: sa.h0
            @Override // a7.e
            public final void accept(Object obj) {
                d1.Q3(this.f11904e, (w.d) obj);
            }
        }, new x7.g0());
    }

    public final void k4(String str) {
        l4(str, 0);
    }

    public final void l4(final String str, final int i10) {
        g6.n.s(I(), Z0(x7.u.yg));
        ((autodispose2.m) d4(str).f(new a7.f() { // from class: sa.v
            @Override // a7.f
            public final Object apply(Object obj) {
                return this.f11964a.p4((String) obj, str, i10);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: sa.w
            @Override // a7.e
            public final void accept(Object obj) {
                d1.H3(this.f11969e, (w.d) obj);
            }
        }, new x7.g0());
    }

    public final void n4(final int i10) {
        r5.c cVarK = this.f11885t0.k(i10);
        if (cVarK == null) {
            return;
        }
        cVarK.r(this.f11885t0.w(i10));
        int iI4 = i4(i10);
        if (iI4 < 0) {
            this.f11883r0.add(0, cVarK);
            t4(X3());
            if (this.f10459q0.getLayoutManager() != null) {
                this.f10459q0.getLayoutManager().y1(0);
            }
        } else {
            this.f11883r0.set(iI4, cVarK);
            t4(X3());
        }
        z8.h.b(new Runnable() { // from class: sa.f0
            @Override // java.lang.Runnable
            public final void run() {
                d1.L3(this.f11896e, i10);
            }
        });
    }

    public final void o4(r5.c cVar) {
        String strC = cVar.c();
        if (strC == null || strC.isEmpty()) {
            return;
        }
        z8.b0.P(I(), strC);
    }

    public final x6.f p4(final String str, final String str2, final int i10) {
        return x6.f.h(new Callable() { // from class: sa.i0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d1.G3(this.f11908e, str, str2, i10);
            }
        });
    }

    public final void q4() {
        if (this.f11888w0) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (r5.c cVar : this.f11883r0) {
            if (cVar.j() && i6.i0.f7006a.s(cVar.b())) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.size() <= 0) {
            return;
        }
        w5.k kVarL = w5.k.l(I());
        kVarL.d0(x7.u.ch);
        if (arrayList.size() == 1) {
            kVarL.J(a1(x7.u.Xa, ((r5.c) arrayList.get(0)).g()));
        } else {
            int size = arrayList.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                strArr[i10] = ((r5.c) arrayList.get(i10)).g();
                iArr[i10] = i10;
            }
            kVarL.L(strArr, iArr);
        }
        kVarL.V(R.string.ok, new k.m() { // from class: sa.r
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                d1.M3(this.f11947a, arrayList, view, pVar);
            }
        });
        kVarL.N(R.string.cancel, null);
        kVarL.f0();
    }

    public final void s4(final r5.a aVar, final r5.c cVar) {
        if (aVar == null) {
            g6.n.q(I(), x7.u.tg);
            return;
        }
        w5.k kVarN = t2.n(I(), aVar, cVar);
        if (kVarN == null) {
            return;
        }
        final boolean z10 = cVar != null;
        kVarN.V(R.string.ok, new k.m() { // from class: sa.n0
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                d1.C3(this.f11925a, aVar, z10, cVar, view, pVar);
            }
        });
        kVarN.N(R.string.cancel, null);
        kVarN.f0();
    }

    public final void u4(r5.c cVar) {
        String strB = cVar.b();
        if (strB == null || strB.isEmpty()) {
            return;
        }
        l4(strB, cVar.e());
    }

    public final x6.j v4(r5.c cVar) {
        final String strB = cVar.b();
        final boolean zJ = cVar.j();
        final int iE = cVar.e();
        return x6.j.s(new Callable() { // from class: sa.k0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x5.a.f(s5.b.d(strB));
            }
        }).x(new a7.f() { // from class: sa.m0
            @Override // a7.f
            public final Object apply(Object obj) {
                return d1.l3(this.f11920a, strB, zJ, iE, (x5.a) obj);
            }
        }).D(g7.a.c());
    }

    public final void w4(List list) {
        if (this.f11888w0 || list == null || list.size() <= 0) {
            return;
        }
        this.f11888w0 = true;
        g6.n.q(I(), x7.u.hh);
        ((autodispose2.n) (list.size() == 1 ? v4((r5.c) list.get(0)) : x6.j.t(list).n(new a7.f() { // from class: sa.x
            @Override // a7.f
            public final Object apply(Object obj) {
                return this.f11971a.v4((r5.c) obj);
            }
        })).D(g7.a.c()).z(w6.b.b()).I(u8.b.a(this))).c(new a7.e() { // from class: sa.y
            @Override // a7.e
            public final void accept(Object obj) {
                d1.I3(this.f11973e, (x5.a) obj);
            }
        }, new x7.c0(), new a7.a() { // from class: sa.z
            @Override // a7.a
            public final void run() {
                d1.S3(this.f11975a);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f11885t0 = lc.c().d();
        this.f11886u0 = pa.r.j();
    }
}
