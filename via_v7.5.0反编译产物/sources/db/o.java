package db;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import autodispose2.r;
import bb.x;
import c6.y1;
import com.tuyafeng.support.utils.p;
import com.tuyafeng.support.widget.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import la.s;
import mark.via.browser.zc;
import mark.via.common.widget.r0;
import w7.a0;
import w7.e0;
import w7.u;
import x8.e1;
import x8.r3;
import x8.x0;
import x8.y0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o extends Fragment implements bb.i.c {
    public l8.b C0;
    public z5.c D0;
    public z5.a E0;
    public Drawable G0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public r0 f4035o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public RecyclerView f4036p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public TextView f4037q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public EditText f4038r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public f0 f4039s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public f0.b f4040t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public f0.b f4041u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public f0.b f4042v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public f0.b f4043w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public f0.b f4044x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public t5.f f4045y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public x f4046z0;
    public final t8.b A0 = new t8.b();
    public final w5.a B0 = new w5.a();
    public boolean F0 = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.i {
        public a() {
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            View viewA = w5.c.g().a(viewGroup);
            int i10 = w5.c.f13659c;
            r3.q((TextView) viewA.findViewById(i10));
            int i11 = w5.c.f13660d;
            r3.q((TextView) viewA.findViewById(i11));
            v8.g.d((TextView) viewA.findViewById(i10));
            v8.g.d((TextView) viewA.findViewById(i11));
            CheckBox checkBox = (CheckBox) viewA.findViewById(w5.c.f13663g);
            checkBox.setClickable(false);
            checkBox.setFocusable(false);
            return viewA;
        }

        @Override // t5.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, l9.b bVar, int i10) {
            int i11 = w5.c.f13663g;
            gVar.Y(i11, o.this.B0.c());
            gVar.T(i11, o.this.B0.c() && o.this.B0.d(i10));
            y0.i((ImageView) gVar.P(w5.c.f13661e), x0.c().d(o.this.G(), bVar.g()), o.this.G0);
            gVar.X(w5.c.f13659c, p.j(bVar.e(), 256));
            gVar.X(w5.c.f13660d, y1.f2139a.d(bVar.g()));
        }

        @Override // t5.i
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void m(w5.g gVar, l9.b bVar, int i10, List list) {
            for (Object obj : list) {
                if (obj instanceof Boolean) {
                    gVar.T(w5.c.f13663g, ((Boolean) obj).booleanValue());
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements l8.a {
        public b() {
        }

        @Override // l8.a
        public boolean a(int i10) {
            return o.this.B0.d(i10);
        }

        @Override // l8.a
        public void b(int i10, boolean z10) {
            if (o.this.B0.j(i10, z10)) {
                o.this.f4045y0.n(i10, Boolean.valueOf(z10));
            }
        }

        @Override // l8.a
        public boolean c(int i10) {
            return o.this.B0.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements w5.a.InterfaceC0153a {
        public d() {
        }

        @Override // w5.a.InterfaceC0153a
        public void a(int i10) {
            o.this.f4042v0.l(o.this.X0(i10 > 0 && o.this.f4045y0.g() == i10 ? u.W1 : u.uc));
            o.this.f4043w0.j(i10 <= 0);
            o.this.f4043w0.h(i10 > 0);
            o.this.f4043w0.l(i10 == 0 ? o.this.X0(u.f14298y) : o.this.Y0(u.f14194q3, Integer.valueOf(i10)));
            o.this.f4039s0.l(o.this.f4042v0, o.this.f4043w0);
        }

        @Override // w5.a.InterfaceC0153a
        public void b(boolean z10) {
            o.this.f4045y0.l();
            o.this.v3(z10);
            if (z10) {
                a(o.this.B0.a());
            }
        }
    }

    public static /* synthetic */ void S2(o oVar, List list, List list2, int i10, View view, q5.k.p pVar) {
        oVar.getClass();
        oVar.f4046z0.C(((Long) ((x.d) list.get(((q5.k.l) list2.get(i10)).a())).f14455a).longValue());
    }

    public static /* synthetic */ long U2(l9.b bVar) {
        return bVar.f() * 1000;
    }

    public static /* synthetic */ void V2(o oVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        oVar.getClass();
        if (i10 == -1) {
            return;
        }
        if (i11 == 0 || i11 == 1) {
            oVar.f4046z0.J(i10, i11 == 1 ? 1 : 2);
            return;
        }
        if (i11 == 2) {
            oVar.t3(i10);
        } else if (i11 == 3) {
            com.tuyafeng.support.utils.n.a(oVar.G(), oVar.f4046z0.E(i10), u.Fg);
        } else {
            if (i11 != 4) {
                return;
            }
            e1.k(oVar.G(), oVar.f4046z0.E(i10));
        }
    }

    public static /* synthetic */ void W2(o oVar, CharSequence charSequence) {
        if (oVar.F0) {
            oVar.f4046z0.O(charSequence.toString());
            oVar.B0.k(false);
        }
    }

    public static /* synthetic */ void X2(o oVar, List list) {
        RecyclerView recyclerView;
        oVar.getClass();
        boolean zIsEmpty = list.isEmpty();
        if (oVar.f4038r0.getText().length() == 0) {
            oVar.f4040t0.j(zIsEmpty);
            oVar.f4044x0.j(zIsEmpty);
            oVar.f4039s0.l(oVar.f4040t0, oVar.f4044x0);
        }
        oVar.f4035o0.setSearchVisible(oVar.f4038r0.length() > 0 || !zIsEmpty);
        oVar.f4035o0.setEmpty(zIsEmpty);
        oVar.A0.g(list, new t8.c() { // from class: db.c
            @Override // t8.c
            public final long a(Object obj) {
                return o.U2((l9.b) obj);
            }
        });
        oVar.f4045y0.M(list);
        oVar.f4045y0.l();
        if (oVar.B0.c()) {
            oVar.f4042v0.l(oVar.X0(oVar.B0.a() == list.size() ? u.W1 : u.uc));
            oVar.f4039s0.j(oVar.f4042v0);
        }
        if (oVar.F0) {
            return;
        }
        oVar.F0 = true;
        Bundle bundleC = p5.b.d().c("HISTORY_CACHE");
        if (bundleC == null || (recyclerView = oVar.f4036p0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        ((LinearLayoutManager) oVar.f4036p0.getLayoutManager()).B2(bundleC.getInt("position", 0), bundleC.getInt("offset", 0));
    }

    public static /* synthetic */ boolean Z2(final o oVar, View view, final int i10, l9.b bVar) {
        if (oVar.B0.c()) {
            oVar.C0.n(true, i10);
            return true;
        }
        q5.k.l(view.getContext()).G(new String[]{oVar.X0(u.R), oVar.X0(u.S), oVar.X0(u.f14298y), oVar.X0(u.f14218s), oVar.X0(u.f14037f0)}, new AdapterView.OnItemClickListener() { // from class: db.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                o.V2(this.f4016a, i10, adapterView, view2, i11, j10);
            }
        }).j0(view);
        return true;
    }

    public static /* synthetic */ void a3(o oVar, View view, int i10, l9.b bVar) {
        if (!oVar.B0.c()) {
            oVar.f4046z0.J(i10, 0);
        } else {
            oVar.B0.h(i10);
            oVar.f4045y0.n(i10, Boolean.valueOf(oVar.B0.d(i10)));
        }
    }

    public static /* synthetic */ void b3(o oVar) {
        oVar.E0.I(0);
        oVar.f4046z0.H();
    }

    public static /* synthetic */ void c3(o oVar, View view, f0.b bVar) {
        int iG;
        oVar.getClass();
        int iA = bVar.a();
        if (iA == w7.p.K0) {
            oVar.o3();
            return;
        }
        if (iA == w7.p.T0) {
            oVar.f4046z0.Q();
            return;
        }
        if (iA == w7.p.M0) {
            oVar.q3();
            return;
        }
        if (iA == w7.p.N0) {
            w5.a aVar = oVar.B0;
            aVar.k(!aVar.c());
        } else {
            if (iA != w7.p.S0 || (iG = oVar.f4045y0.g()) == 0) {
                return;
            }
            if (iG == oVar.B0.a()) {
                oVar.B0.l(0, iG);
            } else {
                oVar.B0.f(0, iG);
            }
            oVar.f4045y0.q(0, iG);
        }
    }

    public static /* synthetic */ void d3(final o oVar, final List list) {
        oVar.getClass();
        final ArrayList arrayList = new ArrayList();
        Object[] objArr = {oVar.X0(u.I7), oVar.X0(u.Qg), oVar.X0(u.Rg), oVar.X0(u.J7), oVar.X0(u.W0)};
        int size = list.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            if (((Integer) ((x.d) list.get(i11)).f14456b).intValue() != 0 && ((Integer) ((x.d) list.get(i11)).f14456b).intValue() != i10) {
                Integer num = (Integer) ((x.d) list.get(i11)).f14456b;
                int iIntValue = num.intValue();
                arrayList.add(new q5.k.l(i11, oVar.Y0(u.E3, objArr[i11], num)));
                i10 = iIntValue;
            }
        }
        Collections.reverse(arrayList);
        q5.k.l(oVar.G()).f0(u.f14208r3).D(arrayList, new AdapterView.OnItemClickListener() { // from class: db.d
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                o oVar2 = this.f4018a;
                List list2 = arrayList;
                q5.k.l(oVar2.G()).f0(u.f14208r3).K(((q5.k.l) list2.get(i12)).b()).X(R.string.ok, new q5.k.m() { // from class: db.e
                    @Override // q5.k.m
                    public final void a(View view2, q5.k.p pVar) {
                        o.S2(oVar2, list, list2, i12, view2, pVar);
                    }
                }).P(R.string.cancel, null).j0(oVar2.f4039s0.f(w7.p.K0));
            }
        }).j0(oVar.f4039s0.f(w7.p.K0));
    }

    public static /* synthetic */ void e3(o oVar, int[] iArr, View view, q5.k.p pVar) {
        if (oVar.f4046z0.M(iArr, oVar.f4038r0.getText().length() > 0)) {
            for (int i10 : iArr) {
                oVar.f4045y0.u(i10);
                oVar.A0.f(i10);
            }
        }
        oVar.B0.k(false);
    }

    public static /* synthetic */ void f3(o oVar, Boolean bool) {
        oVar.D0.e(bool.booleanValue() ? 1 : 2);
        oVar.E0.I(bool.booleanValue() ? 1 : 2);
    }

    private void r3() {
        this.B0.i(new d());
    }

    private void u3() {
        RecyclerView recyclerView = this.f4036p0;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        p5.b.C0110b c0110bD = p5.b.a().e("HISTORY_CACHE").f(180).d("query", this.f4038r0.getText().toString());
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f4036p0.getLayoutManager();
        View viewJ = linearLayoutManager.J(0);
        if (viewJ != null) {
            c0110bD.b("scrollY", this.f4036p0.getScrollY()).b("position", linearLayoutManager.i0(viewJ)).b("offset", viewJ.getTop());
        }
        c0110bD.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(boolean z10) {
        this.f4044x0.l(X0(z10 ? u.X3 : u.E));
        this.f4042v0.k(!z10);
        this.f4043w0.k(!z10);
        this.f4041u0.k(z10);
        this.f4040t0.k(z10);
        this.f4039s0.l(this.f4044x0, this.f4042v0, this.f4043w0, this.f4041u0, this.f4040t0);
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        r0 r0Var = (r0) new b6.a(new r0(G()), new ViewGroup.LayoutParams(-1, -1)).l();
        RecyclerView recyclerView = r0Var.f10038c;
        this.f4036p0 = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.A0.h(new t8.a(G()));
        Context contextG = G();
        t8.b bVar = this.A0;
        Objects.requireNonNull(bVar);
        x5.b bVar2 = new x5.b(contextG, new zc(bVar));
        bVar2.o(1);
        bVar2.n(com.tuyafeng.support.utils.e.a(G(), w7.k.f13722b));
        this.f4036p0.k(bVar2);
        this.f4036p0.n(bVar2);
        this.f4037q0 = r0Var.f10040m;
        this.f4038r0 = r0Var.f10041n;
        r0Var.setSearchVisible(false);
        this.f4039s0 = r0Var.f10042o;
        f0.b bVar3 = new f0.b(w7.p.K0, X0(u.f14311z));
        this.f4040t0 = bVar3;
        bVar3.i(true);
        this.f4040t0.j(true);
        this.f4041u0 = new f0.b(w7.p.T0, X0(u.fe));
        f0.b bVar4 = new f0.b(w7.p.S0, X0(u.uc));
        this.f4042v0 = bVar4;
        bVar4.k(true);
        f0.b bVar5 = new f0.b(w7.p.M0, X0(u.f14298y));
        this.f4043w0 = bVar5;
        bVar5.i(true);
        this.f4043w0.j(true);
        this.f4043w0.k(true);
        f0.b bVar6 = new f0.b(w7.p.N0, X0(u.E));
        this.f4044x0 = bVar6;
        this.f4039s0.c(bVar6);
        this.f4039s0.c(this.f4040t0);
        this.f4039s0.b(this.f4041u0);
        this.f4039s0.b(this.f4042v0);
        this.f4039s0.b(this.f4043w0);
        this.f4035o0 = r0Var;
        return r0Var;
    }

    @Override // androidx.fragment.app.Fragment
    public void M1() {
        u3();
        x8.f.e(this.f4038r0);
        super.M1();
    }

    @Override // bb.i.c
    public boolean S() {
        if (this.B0.c()) {
            this.B0.k(false);
            return true;
        }
        if (this.f4038r0.getText().length() <= 0) {
            return false;
        }
        this.f4038r0.setText("");
        this.f4038r0.clearFocus();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        r3();
        Drawable drawableC = lb.g.c(G(), w7.o.f13817o0, u.ye);
        this.G0 = drawableC;
        com.tuyafeng.support.utils.h.a(drawableC, com.tuyafeng.support.utils.e.a(view.getContext(), w7.k.f13729i));
        r3.f(this.f4037q0);
        this.f4036p0.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f4036p0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f4045y0 = new t5.f(new ArrayList());
        a aVar = new a();
        this.f4045y0.K(l9.b.class, aVar);
        z5.a aVar2 = new z5.a(this.f4045y0);
        this.E0 = aVar2;
        this.f4036p0.setAdapter(aVar2);
        aVar.j(new t5.g() { // from class: db.a
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                o.a3(this.f4015a, view2, i10, (l9.b) obj);
            }
        });
        aVar.k(new t5.h() { // from class: db.f
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return o.Z2(this.f4025a, view2, i10, (l9.b) obj);
            }
        });
        ((autodispose2.n) s8.c.a(this.f4038r0).E(1L).n(new u6.f() { // from class: db.g
            @Override // u6.f
            public final void accept(Object obj) {
                this.f4026c.f4046z0.G();
            }
        }).g(100L, TimeUnit.MILLISECONDS).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: db.h
            @Override // u6.f
            public final void accept(Object obj) {
                o.W2(this.f4027c, (CharSequence) obj);
            }
        }, new e0());
        this.f4039s0.setOnActionClickListener(new f0.c() { // from class: db.i
            @Override // com.tuyafeng.support.widget.f0.c
            public final void a(View view2, f0.b bVar) {
                o.c3(this.f4028a, view2, bVar);
            }
        });
        l8.b bVar = new l8.b(G(), new b());
        this.C0 = bVar;
        bVar.p(com.tuyafeng.support.utils.x.h(G(), com.tuyafeng.support.utils.l.d(G()) ? 48.0f : -48.0f));
        this.C0.o(new c());
        this.f4036p0.n(this.C0);
        this.f4046z0.f1894u.g(b1(), new androidx.lifecycle.o() { // from class: db.j
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                o.X2(this.f4029a, (List) obj);
            }
        });
        z5.c cVar = new z5.c();
        this.D0 = cVar;
        cVar.d(new z5.c.a() { // from class: db.k
            @Override // z5.c.a
            public final void a() {
                o.b3(this.f4030a);
            }
        });
        this.f4036p0.o(this.D0);
        this.f4046z0.f1898y.g(b1(), new androidx.lifecycle.o() { // from class: db.l
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                o.f3(this.f4031a, (Boolean) obj);
            }
        });
        s3(view);
    }

    @Override // bb.i.c
    public boolean l() {
        return !this.B0.c() && this.f4038r0.getText().length() == 0;
    }

    public final void o3() {
        if (this.f4038r0.getText().length() <= 0) {
            ((r) this.f4046z0.A().l(s8.b.a(b1()))).a(new u6.f() { // from class: db.m
                @Override // u6.f
                public final void accept(Object obj) {
                    o.d3(this.f4032c, (List) obj);
                }
            }, new a0());
            return;
        }
        int iG = this.f4045y0.g();
        int[] iArr = new int[iG];
        for (int i10 = 0; i10 < iG; i10++) {
            iArr[i10] = (iG - 1) - i10;
        }
        p3(iArr);
    }

    public final void p3(final int[] iArr) {
        String strY0;
        if (iArr == null || iArr.length == 0) {
            return;
        }
        if (iArr.length == 1) {
            List list = (List) this.f4046z0.f1894u.e();
            if (list == null || iArr[0] >= list.size()) {
                return;
            }
            strY0 = Y0(u.f14222s3, ((l9.b) list.get(iArr[0])).e());
        } else {
            strY0 = Y0(u.f14236t3, Integer.valueOf(iArr.length));
        }
        q5.k.l(G()).f0(u.f14298y).K(strY0).X(R.string.ok, new q5.k.m() { // from class: db.n
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                o.e3(this.f4033a, iArr, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void q3() {
        if (!this.B0.c() || this.B0.a() <= 0) {
            return;
        }
        p3(this.B0.b(true));
    }

    public final void s3(View view) {
        Bundle bundleC = p5.b.d().c("HISTORY_CACHE");
        if (bundleC == null) {
            this.f4046z0.H();
            return;
        }
        this.f4036p0.setScrollY(bundleC.getInt("scrollY", 0));
        String string = bundleC.getString("query", "");
        if (string.isEmpty()) {
            this.f4046z0.I(Math.max(120, bundleC.getInt("position") + 20));
        } else {
            this.f4038r0.setText(string);
            this.f4046z0.O(string);
        }
    }

    public final void t3(int i10) {
        if (this.f4046z0.N(i10) == null) {
            return;
        }
        w5.b bVarC = this.A0.c(i10);
        this.A0.f(i10);
        this.f4045y0.u(i10);
        if (bVarC.c()) {
            this.f4045y0.n(i10 - 1, 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f4046z0 = (x) new androidx.lifecycle.a0(z2(), s.n()).a(x.class);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements l8.b.InterfaceC0093b {
        public c() {
        }

        @Override // l8.b.InterfaceC0093b
        public void a(boolean z10) {
            o.this.f4046z0.P(!z10);
        }

        @Override // l8.b.InterfaceC0093b
        public void b(boolean z10) {
        }
    }
}
