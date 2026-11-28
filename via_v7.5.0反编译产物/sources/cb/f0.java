package cb;

import android.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.simpleframework.xml.strategy.Name;
import x8.r2;
import x8.s1;
import x8.t1;
import z7.b2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f0 extends Fragment implements bb.i.c {
    public q5.k A0;
    public l8.b B0;
    public com.tuyafeng.support.widget.f0 C0;
    public com.tuyafeng.support.widget.f0.b D0;
    public com.tuyafeng.support.widget.f0.b E0;
    public com.tuyafeng.support.widget.f0.b F0;
    public com.tuyafeng.support.widget.f0.b G0;
    public com.tuyafeng.support.widget.f0.b H0;
    public com.tuyafeng.support.widget.f0.b I0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public bb.x f2381o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public n1 f2382p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public androidx.recyclerview.widget.j f2383q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public mark.via.common.widget.r0 f2384r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public RecyclerView f2385s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public View f2386t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public EditText f2387u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f2388v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public w5.a f2389w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public i0 f2390x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f2391y0 = 0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f2392z0 = false;
    public final n8.f J0 = new n8.f(this);
    public final n8.d K0 = new n8.d(this, "text/html");

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements l8.a {
        public a() {
        }

        @Override // l8.a
        public boolean a(int i10) {
            return f0.this.f2389w0.d(i10);
        }

        @Override // l8.a
        public void b(int i10, boolean z10) {
            if (f0.this.f2389w0.j(i10, z10)) {
                f0.this.f2388v0.n(i10, Boolean.valueOf(z10));
            }
        }

        @Override // l8.a
        public boolean c(int i10) {
            return f0.this.f2389w0.c() && !f0.this.f2382p0.h0(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends RecyclerView.t {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            if (i11 == 0 || f0.this.f2387u0 == null || !f0.this.f2387u0.hasFocus()) {
                return;
            }
            f0.this.f2387u0.clearFocus();
            x8.f.e(f0.this.f2387u0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements w5.a.InterfaceC0153a {
        public d() {
        }

        @Override // w5.a.InterfaceC0153a
        public void a(int i10) {
            f0.this.F0.l(f0.this.X0(i10 > 0 && (f0.this.N3() || m9.a.g(f0.this.f2382p0.p0()) ? f0.this.f2388v0.g() == i10 : f0.this.f2388v0.g() - 1 == i10) ? w7.u.W1 : w7.u.uc));
            f0.this.G0.j(i10 <= 0);
            f0.this.H0.j(i10 <= 0);
            f0.this.H0.h(i10 > 0);
            com.tuyafeng.support.widget.f0.b bVar = f0.this.H0;
            f0 f0Var = f0.this;
            bVar.l(i10 == 0 ? f0Var.X0(w7.u.f14298y) : f0Var.Y0(w7.u.f14194q3, Integer.valueOf(i10)));
            f0.this.I0.j(i10 <= 0);
            f0.this.C0.l(f0.this.F0, f0.this.G0, f0.this.H0, f0.this.I0);
        }

        @Override // w5.a.InterfaceC0153a
        public void b(boolean z10) {
            f0.this.f2390x0.u(z10);
            f0.this.f2390x0.v((!z10 || f0.this.N3() || f0.this.f2382p0.b0() == 2) ? false : true);
            f0.this.f2388v0.l();
            f0.this.W3(z10);
            if (z10) {
                a(f0.this.f2389w0.a());
            }
        }
    }

    public static /* synthetic */ void S2(f0 f0Var, Uri uri) {
        if (uri == null) {
            f0Var.getClass();
        } else {
            f0Var.d4();
            f0Var.f2382p0.e0(x8.b1.i(f0Var.G(), uri));
        }
    }

    public static void S3(String str) {
        T3(str, 0, 0);
    }

    public static /* synthetic */ void T2(f0 f0Var, RecyclerView.d0 d0Var) {
        if (f0Var.N3()) {
            return;
        }
        f0Var.f2383q0.H(d0Var);
    }

    public static void T3(String str, int i10, int i11) {
        p5.b.d().b("BOOKMARK_CACHE");
        p5.b.a().e("BOOKMARK_CACHE").f(180).d("folder", str).d("query", "").b("position", Math.max(i10, 0)).b("offset", i11).a();
    }

    public static /* synthetic */ void U2(final f0 f0Var, final m9.b bVar, AdapterView adapterView, View view, int i10, long j10) {
        f0Var.getClass();
        switch (i10) {
            case 0:
            case 1:
                f0Var.f2381o0.K(bVar.g(), i10 != 1 ? 2 : 1);
                break;
            case 2:
                f0Var.Q3(bVar.c(), bVar.b());
                break;
            case 3:
                if (f0Var.f2381o0.z(new l9.b(bVar.g(), bVar.e()))) {
                    com.tuyafeng.support.utils.n.q(f0Var.G(), w7.u.B0);
                }
                break;
            case 4:
                q5.k.l(f0Var.G()).f0(w7.u.f14298y).K(f0Var.Y0(w7.u.f14222s3, bVar.e())).X(R.string.ok, new q5.k.m() { // from class: cb.l
                    @Override // q5.k.m
                    public final void a(View view2, q5.k.p pVar) {
                        this.f2434a.f2382p0.Q(bVar.c());
                    }
                }).P(R.string.cancel, null).h0();
                break;
            case 5:
                com.tuyafeng.support.utils.n.a(f0Var.G(), bVar.g(), w7.u.Fg);
                break;
            case 6:
                x8.e1.k(f0Var.G(), bVar.g());
                break;
        }
    }

    public static /* synthetic */ void X2(f0 f0Var, View view, int i10, cb.a aVar) {
        if (f0Var.f2389w0.c()) {
            if (aVar.i()) {
                return;
            }
            f0Var.f2389w0.h(i10);
            f0Var.f2388v0.n(i10, Boolean.valueOf(f0Var.f2389w0.d(i10)));
            return;
        }
        if (aVar.a() != null) {
            if (f0Var.N3()) {
                f0Var.f2387u0.setText((CharSequence) null);
            }
            f0Var.f2382p0.i0(aVar.a());
        } else if (aVar.b() != null) {
            f0Var.f2381o0.K(aVar.b().g(), 0);
        }
    }

    public static /* synthetic */ void Y2(f0 f0Var, CharSequence charSequence) {
        if (f0Var.f2392z0) {
            f0Var.f2382p0.q0(charSequence.toString());
        }
    }

    public static /* synthetic */ void a3(f0 f0Var, List list) {
        int i10;
        boolean z10;
        int i11;
        f0Var.getClass();
        Iterator it = list.iterator();
        while (true) {
            i10 = 0;
            if (!it.hasNext()) {
                z10 = true;
                break;
            } else if (!((cb.a) it.next()).i()) {
                z10 = false;
                break;
            }
        }
        if (f0Var.f2389w0.c()) {
            if (z10) {
                f0Var.f2389w0.k(false);
            } else {
                f0Var.f2389w0.n();
            }
        }
        f0Var.f2384r0.setSearchVisible(f0Var.N3() || !list.isEmpty());
        f0Var.D0.j(z10);
        f0Var.C0.j(f0Var.D0);
        if (f0Var.f2389w0.c()) {
            f0Var.f2390x0.v((f0Var.N3() || f0Var.f2382p0.b0() == 2) ? false : true);
            f0Var.f2388v0.M(list);
            f0Var.f2388v0.l();
        } else {
            androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new cb.c(f0Var.f2388v0.H(), list));
            f0Var.f2388v0.M(list);
            eVarB.c(f0Var.f2388v0);
        }
        if (f0Var.f2392z0) {
            return;
        }
        f0Var.f2392z0 = true;
        Bundle bundleC = p5.b.d().c("BOOKMARK_CACHE");
        if (bundleC != null) {
            int i12 = bundleC.getInt("position", 0);
            i11 = bundleC.getInt("offset", 0);
            i10 = i12;
        } else {
            i11 = 0;
        }
        f0Var.V3(i10, i11);
    }

    public static /* synthetic */ List c3(int i10, List list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i11 = 0;
        while (i11 < size) {
            arrayList.add(new j8.a((String) list.get(i11), i11 == 0 ? i10 : 3));
            i11++;
        }
        return arrayList;
    }

    public static /* synthetic */ void d3(f0 f0Var, String str, Bundle bundle) {
        f0Var.getClass();
        String string = bundle.getString(Name.MARK);
        boolean z10 = bundle.getBoolean("folder_created", false);
        if (string != null || z10) {
            f0Var.f2382p0.n0();
        }
        Fragment fragmentK0 = f0Var.K0();
        f0 f0VarK0 = f0Var;
        if (fragmentK0 != null) {
            f0VarK0 = f0Var.K0();
        }
        f0VarK0.L0().x(str);
    }

    public static /* synthetic */ boolean f3(f0 f0Var, View view, int i10, cb.a aVar) {
        if (f0Var.f2389w0.c()) {
            f0Var.B0.n(true, i10);
            return true;
        }
        if (aVar.a() == null) {
            if (aVar.b() != null) {
                f0Var.Y3(aVar.b(), view, i10);
            }
            return true;
        }
        if (!m9.a.g(f0Var.f2382p0.p0()) && i10 <= 0) {
            return false;
        }
        f0Var.X3(aVar.a(), view, i10);
        return true;
    }

    public static /* synthetic */ void g3(f0 f0Var, m9.a aVar, View view, q5.k.p pVar) {
        f0Var.f2382p0.P(aVar.b());
        u9.n.e().q(true);
    }

    public static /* synthetic */ void h3(f0 f0Var, m9.a aVar) {
        f0Var.f2387u0.setHint(m9.a.g(aVar.b()) ? f0Var.X0(w7.u.f14063gc) : f0Var.Y0(w7.u.Sb, aVar.e()));
        if (f0Var.f2392z0) {
            f0Var.V3(0, 0);
        }
    }

    public static /* synthetic */ List j3(List list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            arrayList.add(new j8.a((String) list.get(i10), i10 == 0 ? 1 : 3));
            i10++;
        }
        return arrayList;
    }

    public static /* synthetic */ void l3(f0 f0Var, AdapterView adapterView, View view, int i10, long j10) {
        f0Var.getClass();
        if (j10 == 1) {
            f0Var.R3(null, f0Var.f2382p0.p0());
            return;
        }
        if (j10 == 2) {
            f0Var.c4();
            return;
        }
        if (j10 == 3) {
            f0Var.J3();
            return;
        }
        if (j10 == 4) {
            f0Var.H3();
            return;
        }
        if (j10 == 5) {
            f0Var.Q3(null, f0Var.f2382p0.p0());
            return;
        }
        if (j10 == 6 || j10 == 7) {
            int i11 = j10 == 6 ? 0 : 1;
            f0Var.f2390x0.r(i11);
            t5.f fVar = f0Var.f2388v0;
            fVar.r(0, fVar.g(), Integer.valueOf(i11));
            f0Var.f2382p0.u0(i11);
        }
    }

    public static /* synthetic */ void m3(f0 f0Var, String str, Bundle bundle) {
        f0Var.getClass();
        String string = bundle.getString("result_id");
        String strP0 = f0Var.f2382p0.p0();
        if (string != null && !t1.a(string, strP0)) {
            int[] iArrB = f0Var.f2389w0.b(false);
            int iG = f0Var.f2388v0.g();
            int iMax = 0;
            for (int i10 : iArrB) {
                iMax = Math.max(iMax, i10);
                iG = Math.min(iG, i10);
            }
            f0Var.f2382p0.m0(iArrB, string);
        }
        f0Var.z2().L0().x(b2.f15220x0);
    }

    public static /* synthetic */ void q3(final f0 f0Var, View view, com.tuyafeng.support.widget.f0.b bVar) {
        f0Var.getClass();
        int iA = bVar.a();
        if (iA == w7.p.N0) {
            w5.a aVar = f0Var.f2389w0;
            aVar.k(!aVar.c());
            return;
        }
        if (iA == w7.p.S0) {
            int i10 = (m9.a.g(f0Var.f2382p0.p0()) || f0Var.N3()) ? 0 : 1;
            int iG = f0Var.f2388v0.g();
            if (iG == i10) {
                return;
            }
            int i11 = iG - i10;
            if (i11 == f0Var.f2389w0.a()) {
                f0Var.f2389w0.l(i10, iG);
            } else {
                f0Var.f2389w0.f(i10, iG);
            }
            f0Var.f2388v0.q(i10, i11);
            return;
        }
        if (iA == w7.p.M0) {
            if (f0Var.f2389w0.a() == 0) {
                return;
            }
            q5.k.l(f0Var.G()).f0(w7.u.f14298y).J(w7.u.K3).X(R.string.ok, new q5.k.m() { // from class: cb.m
                @Override // q5.k.m
                public final void a(View view2, q5.k.p pVar) {
                    f0 f0Var2 = this.f2441a;
                    f0Var2.f2382p0.R(f0Var2.f2389w0.b(true));
                }
            }).P(R.string.cancel, null).h0();
        } else {
            if (iA == w7.p.Q0) {
                f0Var.P3();
                return;
            }
            if (iA == w7.p.P0) {
                f0Var.b4();
            } else if (iA == w7.p.R0) {
                int[] iArrB = f0Var.f2389w0.b(false);
                Arrays.sort(iArrB);
                ((autodispose2.m) f0Var.f2382p0.a0(iArrB).j(new u6.g() { // from class: cb.n
                    @Override // u6.g
                    public final Object apply(Object obj) {
                        return f0.j3((List) obj);
                    }
                }).p(s8.b.a(f0Var.b1()))).b(new u6.f() { // from class: cb.p
                    @Override // u6.f
                    public final void accept(Object obj) {
                        this.f2463c.f2381o0.L((List) obj);
                    }
                });
            }
        }
    }

    public static /* synthetic */ void r3(f0 f0Var, String str, Bundle bundle) {
        f0Var.getClass();
        if (bundle.getString(Name.MARK) != null) {
            f0Var.f2382p0.n0();
        }
        Fragment fragmentK0 = f0Var.K0();
        f0 f0VarK0 = f0Var;
        if (fragmentK0 != null) {
            f0VarK0 = f0Var.K0();
        }
        f0VarK0.L0().x(str);
    }

    public static /* synthetic */ void s3(final f0 f0Var, final m9.a aVar, AdapterView adapterView, View view, int i10, long j10) {
        f0Var.getClass();
        if (i10 == 0 || i10 == 1) {
            final int i11 = i10 != 0 ? 1 : 2;
            ((autodispose2.m) f0Var.f2382p0.c0(aVar.b()).j(new u6.g() { // from class: cb.i
                @Override // u6.g
                public final Object apply(Object obj) {
                    return f0.c3(i11, (List) obj);
                }
            }).p(s8.b.a(f0Var.b1()))).b(new u6.f() { // from class: cb.j
                @Override // u6.f
                public final void accept(Object obj) {
                    this.f2423c.f2381o0.L((List) obj);
                }
            });
            return;
        }
        if (i10 == 2) {
            f0Var.R3(aVar.b(), null);
            return;
        }
        if (i10 == 4) {
            q5.k.l(f0Var.G()).f0(w7.u.M8).K(f0Var.Y0(w7.u.f14180p3, aVar.e())).X(R.string.ok, new q5.k.m() { // from class: cb.k
                @Override // q5.k.m
                public final void a(View view2, q5.k.p pVar) {
                    f0.g3(this.f2428a, aVar, view2, pVar);
                }
            }).P(R.string.cancel, null).h0();
        } else if (i10 == 3) {
            String strE = aVar.e();
            if (f0Var.f2381o0.z(new l9.b(r2.e(aVar.b(), strE), strE))) {
                com.tuyafeng.support.utils.n.q(f0Var.G(), w7.u.B0);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        mark.via.common.widget.r0 r0Var = (mark.via.common.widget.r0) new b6.a(new mark.via.common.widget.r0(G()), new ViewGroup.LayoutParams(-1, -1)).l();
        this.f2385s0 = r0Var.f10038c;
        this.f2387u0 = r0Var.f10041n;
        r0Var.setSearchVisible(false);
        this.f2386t0 = r0Var.f10040m;
        this.C0 = r0Var.f10042o;
        com.tuyafeng.support.widget.f0.b bVar = new com.tuyafeng.support.widget.f0.b(w7.p.S0, X0(w7.u.uc));
        this.F0 = bVar;
        bVar.k(true);
        com.tuyafeng.support.widget.f0.b bVar2 = new com.tuyafeng.support.widget.f0.b(w7.p.M0, X0(w7.u.f14298y));
        this.H0 = bVar2;
        bVar2.i(true);
        this.H0.j(true);
        this.H0.k(true);
        this.D0 = new com.tuyafeng.support.widget.f0.b(w7.p.N0, X0(w7.u.E));
        this.E0 = new com.tuyafeng.support.widget.f0.b(w7.p.P0, X0(w7.u.H8));
        com.tuyafeng.support.widget.f0.b bVar3 = new com.tuyafeng.support.widget.f0.b(w7.p.Q0, X0(w7.u.J8));
        this.G0 = bVar3;
        bVar3.k(true);
        com.tuyafeng.support.widget.f0.b bVar4 = new com.tuyafeng.support.widget.f0.b(w7.p.R0, X0(w7.u.f14228s9));
        this.I0 = bVar4;
        bVar4.j(true);
        this.I0.k(true);
        this.C0.b(this.E0);
        this.C0.b(this.F0);
        this.C0.b(this.G0);
        this.C0.b(this.H0);
        this.C0.b(this.I0);
        this.C0.c(this.D0);
        this.f2384r0 = r0Var;
        return r0Var;
    }

    public final void G3() {
        q5.k kVar = this.A0;
        if (kVar == null) {
            return;
        }
        kVar.o();
        this.A0 = null;
    }

    public final void H3() {
        this.K0.d(G().getResources().getString(w7.u.f14066h1) + "_" + X0(w7.u.f14092j) + "_" + s1.d() + ".html", new n8.d.a() { // from class: cb.u
            @Override // n8.d.a
            public final void a(Uri uri, String str) {
                this.f2476a.I3(uri, str);
            }
        });
    }

    public final void I3(Uri uri, String str) {
        if (uri == null) {
            return;
        }
        d4();
        this.f2382p0.S(x8.b1.l(G(), uri), str);
    }

    public final void J3() {
        this.J0.b(new String[]{"text/html"}, new n8.f.a() { // from class: cb.w
            @Override // n8.f.a
            public final void a(Uri uri) {
                f0.S2(this.f2481a, uri);
            }
        });
    }

    public final void K3() {
        w5.a aVar = new w5.a();
        this.f2389w0 = aVar;
        aVar.i(new d());
    }

    public final void L3() {
        this.f2382p0.U().g(b1(), new androidx.lifecycle.o() { // from class: cb.d
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                f0.a3(this.f2372a, (List) obj);
            }
        });
        this.f2382p0.g0().g(b1(), new androidx.lifecycle.o() { // from class: cb.o
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f2458a.f2384r0.setEmpty(((Boolean) obj).booleanValue());
            }
        });
        this.f2382p0.X().g(b1(), new androidx.lifecycle.o() { // from class: cb.x
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                f0.h3(this.f2484a, (m9.a) obj);
            }
        });
        this.f2382p0.W().g(b1(), new androidx.lifecycle.o() { // from class: cb.y
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f2485a.a4(((Integer) obj).intValue());
            }
        });
        this.f2382p0.V().g(b1(), new androidx.lifecycle.o() { // from class: cb.z
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f2486a.Z3((String) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void M1() {
        U3();
        x8.f.e(this.f2387u0);
        super.M1();
    }

    public final void M3() {
        androidx.recyclerview.widget.j jVar = new androidx.recyclerview.widget.j(new e());
        this.f2383q0 = jVar;
        jVar.m(this.f2385s0);
        this.f2388v0 = new t5.f(Collections.EMPTY_LIST);
        i0 i0Var = new i0();
        this.f2390x0 = i0Var;
        i0Var.t(new i0.b() { // from class: cb.a0
            @Override // cb.i0.b
            public final boolean a(int i10) {
                return this.f2362a.f2389w0.d(i10);
            }
        });
        this.f2390x0.j(new t5.g() { // from class: cb.b0
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                f0.X2(this.f2365a, view, i10, (a) obj);
            }
        });
        this.f2390x0.k(new t5.h() { // from class: cb.c0
            @Override // t5.h
            public final boolean a(View view, int i10, Object obj) {
                return f0.f3(this.f2370a, view, i10, (a) obj);
            }
        });
        this.f2390x0.s(new i0.a() { // from class: cb.d0
            @Override // cb.i0.a
            public final void a(RecyclerView.d0 d0Var) {
                f0.T2(this.f2373a, d0Var);
            }
        });
        this.f2390x0.r(this.f2382p0.d0() != 1 ? 0 : 1);
        this.f2388v0.K(cb.a.class, this.f2390x0);
        this.f2385s0.setAdapter(this.f2388v0);
        l8.b bVar = new l8.b(G(), new a());
        this.B0 = bVar;
        bVar.p(com.tuyafeng.support.utils.x.h(G(), com.tuyafeng.support.utils.l.d(G()) ? 48.0f : -48.0f));
        this.B0.o(new b());
        this.f2385s0.n(this.B0);
        this.C0.setOnActionClickListener(new com.tuyafeng.support.widget.f0.c() { // from class: cb.e0
            @Override // com.tuyafeng.support.widget.f0.c
            public final void a(View view, com.tuyafeng.support.widget.f0.b bVar2) {
                f0.q3(this.f2377a, view, bVar2);
            }
        });
        ((autodispose2.n) s8.c.a(this.f2387u0).E(1L).n(new u6.f() { // from class: cb.e
            @Override // u6.f
            public final void accept(Object obj) {
                this.f2376c.f2382p0.f0();
            }
        }).g(100L, TimeUnit.MILLISECONDS).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: cb.f
            @Override // u6.f
            public final void accept(Object obj) {
                f0.Y2(this.f2380c, (CharSequence) obj);
            }
        }, new w7.e0());
        this.f2385s0.o(new c());
    }

    public final boolean N3() {
        return this.f2387u0.getText().length() > 0;
    }

    public final void O3() {
        Bundle bundleC = p5.b.d().c("BOOKMARK_CACHE");
        if (bundleC == null) {
            this.f2382p0.i0(null);
            return;
        }
        this.f2385s0.setScrollY(bundleC.getInt("scrollY", 0));
        String string = bundleC.getString("folder", "");
        String string2 = bundleC.getString("query", "");
        if (string2.isEmpty()) {
            this.f2382p0.j0(string);
        } else {
            this.f2387u0.setText(string2);
            this.f2382p0.s0(string2, string);
        }
    }

    public final void P3() {
        z2().L0().z1(b2.f15220x0, this, new androidx.fragment.app.i0() { // from class: cb.s
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                f0.m3(this.f2470a, str, bundle);
            }
        });
        FragmentUtils.j(z2(), b2.class, b2.l3(this.f2382p0.p0(), true));
    }

    public final void Q3(String str, String str2) {
        Fragment fragmentK0 = K0() == null ? this : K0();
        fragmentK0.L0().z1(z7.g1.B0, b1(), new androidx.fragment.app.i0() { // from class: cb.r
            @Override // androidx.fragment.app.i0
            public final void a(String str3, Bundle bundle) {
                f0.d3(this.f2468a, str3, bundle);
            }
        });
        FragmentUtils.j(fragmentK0, z7.g1.class, com.tuyafeng.support.utils.p.f(str) ? z7.g1.u3(null, null, str2, false) : z7.g1.v3(str, false));
    }

    public final void R3(String str, String str2) {
        Fragment fragmentK0 = K0() == null ? this : K0();
        fragmentK0.L0().z1(z7.d0.f15227z0, this, new androidx.fragment.app.i0() { // from class: cb.t
            @Override // androidx.fragment.app.i0
            public final void a(String str3, Bundle bundle) {
                f0.r3(this.f2473a, str3, bundle);
            }
        });
        FragmentUtils.j(fragmentK0, z7.d0.class, z7.d0.r3(str, str2, str != null));
    }

    @Override // bb.i.c
    public boolean S() {
        if (this.f2389w0.c()) {
            this.f2389w0.k(false);
            return true;
        }
        if (this.f2387u0.getText().length() > 0) {
            this.f2387u0.setText("");
            this.f2387u0.clearFocus();
            x8.f.e(this.f2387u0);
            return true;
        }
        if (m9.a.g(this.f2382p0.p0())) {
            return false;
        }
        n1 n1Var = this.f2382p0;
        n1Var.j0(n1Var.o0().d());
        return true;
    }

    public final void U3() {
        RecyclerView recyclerView = this.f2385s0;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        p5.b.C0110b c0110bD = p5.b.a().e("BOOKMARK_CACHE").f(180).d("folder", this.f2382p0.p0()).d("query", this.f2387u0.getText().toString());
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f2385s0.getLayoutManager();
        View viewJ = linearLayoutManager.J(0);
        if (viewJ != null) {
            c0110bD.b("scrollY", this.f2385s0.getScrollY()).b("position", linearLayoutManager.i0(viewJ)).b("offset", viewJ.getTop());
        }
        c0110bD.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        K3();
        M3();
        L3();
        O3();
    }

    public final void V3(int i10, int i11) {
        RecyclerView recyclerView = this.f2385s0;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        ((LinearLayoutManager) this.f2385s0.getLayoutManager()).B2(i10, i11);
    }

    public final void W3(boolean z10) {
        this.E0.k(z10);
        this.D0.l(X0(z10 ? w7.u.X3 : w7.u.E));
        this.F0.k(!z10);
        this.G0.k(!z10);
        this.H0.k(!z10);
        this.I0.k(!z10);
        this.C0.l(this.E0, this.D0, this.F0, this.G0, this.H0, this.I0);
    }

    public final void X3(final m9.a aVar, View view, int i10) {
        q5.k.l(G()).G(new String[]{X0(w7.u.R), X0(w7.u.S), X0(w7.u.E), X0(w7.u.f14022e), X0(w7.u.f14298y)}, new AdapterView.OnItemClickListener() { // from class: cb.h
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                f0.s3(this.f2408a, aVar, adapterView, view2, i11, j10);
            }
        }).j0(view);
    }

    public final void Y3(final m9.b bVar, View view, int i10) {
        q5.k.l(G()).G(new String[]{X0(w7.u.R), X0(w7.u.S), X0(w7.u.E), X0(w7.u.f14022e), X0(w7.u.f14298y), X0(w7.u.f14218s), X0(w7.u.f14037f0)}, new AdapterView.OnItemClickListener() { // from class: cb.g
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                f0.U2(this.f2402a, bVar, adapterView, view2, i11, j10);
            }
        }).j0(view);
    }

    public final void Z3(String str) {
        G3();
        if (str == null) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.W8);
        } else if (str.isEmpty()) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.P1);
        } else {
            com.tuyafeng.support.utils.n.m(G(), X0(w7.u.I3), Y0(w7.u.f14070h5, str));
        }
    }

    public void a4(int i10) {
        G3();
        if (i10 > 0) {
            com.tuyafeng.support.utils.n.s(G(), Y0(w7.u.Q1, Integer.valueOf(i10)));
        } else {
            com.tuyafeng.support.utils.n.q(G(), w7.u.Q6);
        }
    }

    public final void b4() {
        q5.k kVarL = q5.k.l(G());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new q5.k.l(5, X0(w7.u.f13994c)));
        arrayList.add(new q5.k.l(1, X0(w7.u.S8)));
        arrayList.add(new q5.k.l(2, X0(w7.u.od)));
        if (this.f2390x0.n() == 1) {
            arrayList.add(new q5.k.l(6, X0(w7.u.f14211r6)));
        } else {
            arrayList.add(new q5.k.l(7, X0(w7.u.Pc)));
        }
        if (m9.a.g(this.f2382p0.p0())) {
            arrayList.add(new q5.k.l(3, X0(w7.u.R6)));
            arrayList.add(new q5.k.l(4, X0(w7.u.f14056g5)));
        }
        kVarL.D(arrayList, new AdapterView.OnItemClickListener() { // from class: cb.q
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                f0.l3(this.f2465a, adapterView, view, i10, j10);
            }
        });
        TextView textViewF = this.C0.f(w7.p.P0);
        if (textViewF != null) {
            kVarL.k0(textViewF, -textViewF.getWidth(), 0);
        } else {
            kVarL.h0();
        }
    }

    public final void c4() {
        if (y0() == null) {
            return;
        }
        q5.k kVarD0 = q5.k.l(y0()).d0(new String[]{X0(w7.u.nd), X0(w7.u.md), X0(w7.u.ld)}, this.f2382p0.b0(), new AdapterView.OnItemClickListener() { // from class: cb.v
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f2479a.f2382p0.t0(i10);
            }
        });
        TextView textViewF = this.C0.f(w7.p.P0);
        if (textViewF != null) {
            kVarD0.k0(textViewF, -textViewF.getWidth(), 0);
        } else {
            kVarD0.h0();
        }
    }

    public final void d4() {
        q5.k kVar = this.A0;
        if (kVar != null) {
            kVar.h0();
            return;
        }
        q5.k kVarV = q5.k.l(G()).Z(w7.u.si).u(false).v(false);
        this.A0 = kVarV;
        kVarV.h0();
    }

    @Override // bb.i.c
    public boolean l() {
        return !this.f2389w0.c() && this.f2387u0.getText().length() == 0 && m9.a.g(this.f2382p0.p0());
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f2381o0 = (bb.x) new androidx.lifecycle.a0(z2(), la.s.n()).a(bb.x.class);
        this.f2382p0 = (n1) new androidx.lifecycle.a0(this, la.s.n()).a(n1.class);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements l8.b.InterfaceC0093b {
        public b() {
        }

        @Override // l8.b.InterfaceC0093b
        public void a(boolean z10) {
            f0.this.f2381o0.P(!z10);
        }

        @Override // l8.b.InterfaceC0093b
        public void b(boolean z10) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e extends androidx.recyclerview.widget.j.i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2397f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2398g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2399h;

        public e() {
            super(3, 0);
            this.f2399h = false;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void A(RecyclerView.d0 d0Var, int i10) {
            super.A(d0Var, i10);
            if (i10 != 0 && d0Var != null) {
                this.f2399h = i10 == 2;
                int iL = d0Var.l();
                this.f2397f = iL;
                this.f2398g = iL;
                if (this.f2399h) {
                    d0Var.f1138a.setBackgroundColor(com.tuyafeng.support.utils.f.b(f0.this.G(), w7.m.f13738b));
                }
            }
            if (this.f2399h && i10 == 0) {
                this.f2399h = false;
                if (this.f2397f != this.f2398g) {
                    u9.n.e().q(true);
                    f0.this.f2389w0.e(this.f2397f, this.f2398g);
                    f0.this.f2382p0.k0(this.f2397f, this.f2398g);
                }
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public void c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            super.c(recyclerView, d0Var);
            View view = d0Var.f1138a;
            com.tuyafeng.support.utils.x.P(view, com.tuyafeng.support.utils.f.e(view.getContext(), w7.o.f13786e));
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean r() {
            return false;
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            if (f0.this.f2382p0.b0() == 2 || f0.this.N3()) {
                return false;
            }
            int iL = d0Var.l();
            int iL2 = d0Var2.l();
            if (iL >= f0.this.f2382p0.Y()) {
                if (iL2 < f0.this.f2382p0.Y()) {
                    return false;
                }
            } else if ((!m9.a.g(f0.this.f2382p0.p0()) && (iL == 0 || iL2 == 0)) || iL2 >= f0.this.f2382p0.Y()) {
                return false;
            }
            f0.this.f2388v0.p(iL, iL2);
            return true;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void z(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i10, RecyclerView.d0 d0Var2, int i11, int i12, int i13) {
            super.z(recyclerView, d0Var, i10, d0Var2, i11, i12, i13);
            f0.this.f2382p0.l0(i10, i11);
            this.f2398g = i11;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void B(RecyclerView.d0 d0Var, int i10) {
        }
    }
}
