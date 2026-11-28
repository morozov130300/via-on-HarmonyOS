package va;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t0 extends m8.g {
    public com.tuyafeng.support.widget.f0 A0;
    public com.tuyafeng.support.widget.f0.b B0;
    public com.tuyafeng.support.widget.f0.b C0;
    public com.tuyafeng.support.widget.f0.b D0;
    public l8.b E0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public t9.g f13526r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public t5.f f13527s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public mark.via.common.widget.r0 f13528t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public EditText f13529u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public RecyclerView f13530v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public View f13531w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f13532x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final wa.a f13533y0 = new wa.r(this);

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final w5.a f13534z0 = new w5.a();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends wa.s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13535b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, String str) {
            super(context);
            this.f13535b = str;
        }

        @Override // wa.b
        public void onSuccess() {
            t0.this.y3(this.f13535b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends wa.s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13537b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, String str) {
            super(context);
            this.f13537b = str;
        }

        @Override // wa.b
        public void onSuccess() {
            final String str = this.f13537b;
            ((autodispose2.m) r6.f.h(new Callable() { // from class: va.u0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return t0.this.f13526r0.f(str);
                }
            }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(t0.this.b1()))).a(new u6.f() { // from class: va.v0
                @Override // u6.f
                public final void accept(Object obj) {
                    t0.b bVar = this.f13546c;
                    com.tuyafeng.support.utils.n.c(t0.this.G(), ((t9.f) obj).e(), true, t0.this.X0(w7.u.Eg));
                }
            }, new w7.e0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements l8.a {
        public c() {
        }

        @Override // l8.a
        public boolean a(int i10) {
            return t0.this.f13534z0.d(i10);
        }

        @Override // l8.a
        public void b(int i10, boolean z10) {
            if (t0.this.f13534z0.j(i10, z10)) {
                t0.this.f13527s0.m(i10);
            }
        }

        @Override // l8.a
        public boolean c(int i10) {
            return t0.this.f13534z0.c() && (t0.this.f13527s0.H().get(i10) instanceof t9.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements w5.a.InterfaceC0153a {
        public e() {
        }

        @Override // w5.a.InterfaceC0153a
        public void a(int i10) {
            int iG = t0.this.f13527s0.g();
            int i11 = 0;
            for (int i12 = 0; i12 < iG; i12++) {
                if (t0.this.f13527s0.H().get(i12) instanceof t9.f) {
                    i11++;
                }
            }
            t0.this.C0.l(t0.this.X0(i10 > 0 && i11 == i10 ? w7.u.W1 : w7.u.uc));
            t0.this.D0.j(i10 <= 0);
            t0.this.D0.h(i10 > 0);
            t0.this.D0.l(i10 == 0 ? t0.this.X0(w7.u.f14298y) : t0.this.Y0(w7.u.f14194q3, Integer.valueOf(i10)));
            t0.this.A0.l(t0.this.C0, t0.this.D0);
        }

        @Override // w5.a.InterfaceC0153a
        public void b(boolean z10) {
            t0.this.f13527s0.l();
            c(z10);
            if (z10) {
                a(t0.this.f13534z0.a());
            }
        }

        public final void c(boolean z10) {
            t0.this.B0.l(t0.this.X0(z10 ? w7.u.X3 : w7.u.E));
            t0.this.C0.k(!z10);
            t0.this.D0.k(!z10);
            t0.this.A0.l(t0.this.B0, t0.this.C0, t0.this.D0);
        }
    }

    private void A3(boolean z10) {
        this.f13528t0.setSearchVisible(this.f13529u0.length() > 0 || !z10);
        if (z10 == this.f13532x0) {
            return;
        }
        this.f13528t0.setEmpty(z10);
        this.f13532x0 = z10;
        this.B0.j(z10);
        this.A0.l(this.B0);
    }

    private void B3(final String str) {
        if (str == null || str.isEmpty()) {
            z3();
        } else {
            ((autodispose2.r) r6.q.f(new Callable() { // from class: va.f0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f13483c.f13526r0.d(str);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: va.g0
                @Override // u6.f
                public final void accept(Object obj) {
                    t0.e3(this.f13485c, (List) obj);
                }
            }, new w7.e0());
        }
    }

    private void C3(List list) {
        if (list.isEmpty() != this.f13527s0.H().isEmpty()) {
            this.f13527s0.M(list);
            this.f13527s0.l();
        } else {
            androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new xa.a(this.f13527s0.H(), list));
            this.f13527s0.M(list);
            eVarB.c(this.f13527s0);
        }
    }

    public static /* synthetic */ void a3(t0 t0Var, String str, Bundle bundle) {
        t0Var.getClass();
        if (bundle.getString("result", null) != null) {
            t0Var.z3();
        }
        t0Var.L0().x("result");
    }

    public static /* synthetic */ void b3(t0 t0Var, CharSequence charSequence) {
        t0Var.getClass();
        t0Var.B3(charSequence.toString());
        t0Var.f13534z0.k(false);
    }

    public static /* synthetic */ void c3(t0 t0Var, t9.f fVar, View view, q5.k.p pVar) {
        if (t0Var.f13526r0.a(fVar.b())) {
            t0Var.z3();
        }
    }

    public static /* synthetic */ void e3(t0 t0Var, List list) {
        t0Var.C3(t0Var.w3(list));
        t0Var.A3(list.isEmpty());
    }

    public static /* synthetic */ void g3(t0 t0Var, View view, int i10, t9.f fVar) {
        if (t0Var.f13534z0.c()) {
            t0Var.f13534z0.h(i10);
            t0Var.f13527s0.m(i10);
        } else {
            t0Var.f13533y0.a(t0Var.X0(w7.u.pi), t0Var.X0(w7.u.zh), t0Var.new a(t0Var.G(), fVar.b()));
        }
    }

    public static /* synthetic */ void i3(t0 t0Var, List list) {
        t0Var.C3(t0Var.w3(list));
        t0Var.A3(list.isEmpty());
    }

    public static /* synthetic */ void j3(t0 t0Var, View view, com.tuyafeng.support.widget.f0.b bVar) {
        t0Var.getClass();
        int iA = bVar.a();
        if (iA == w7.p.M0) {
            t0Var.x3();
            return;
        }
        if (iA == w7.p.N0) {
            w5.a aVar = t0Var.f13534z0;
            aVar.k(!aVar.c());
            return;
        }
        if (iA == w7.p.S0) {
            ArrayList arrayList = new ArrayList();
            int iG = t0Var.f13527s0.g();
            for (int i10 = 0; i10 < iG; i10++) {
                if (t0Var.f13527s0.H().get(i10) instanceof t9.f) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            int[] iArrD = com.tuyafeng.support.utils.a.d(arrayList);
            if (iArrD.length == t0Var.f13534z0.a()) {
                t0Var.f13534z0.m(iArrD);
            } else {
                t0Var.f13534z0.g(iArrD);
            }
            t0Var.f13527s0.l();
        }
    }

    public static /* synthetic */ void k3(t0 t0Var, int[] iArr, View view, q5.k.p pVar) {
        t0Var.getClass();
        ArrayList arrayList = new ArrayList();
        int iG = t0Var.f13527s0.g();
        int i10 = 0;
        for (int i11 = 0; i11 < iG; i11++) {
            Object obj = t0Var.f13527s0.H().get(i11);
            if (obj instanceof t9.f) {
                if (!com.tuyafeng.support.utils.a.b(iArr, i11)) {
                    arrayList.add((t9.f) obj);
                } else if (t0Var.f13526r0.a(((t9.f) obj).b())) {
                    i10++;
                }
            }
        }
        if (i10 > 0) {
            t0Var.A3(arrayList.isEmpty());
            t0Var.C3(t0Var.w3(arrayList));
        }
        t0Var.f13534z0.k(false);
    }

    public static /* synthetic */ boolean l3(final t0 t0Var, View view, int i10, final t9.f fVar) {
        if (t0Var.f13534z0.c()) {
            t0Var.E0.n(true, i10);
            return true;
        }
        q5.k.l(t0Var.G()).G(new String[]{t0Var.X0(w7.u.Q2), t0Var.X0(w7.u.P2), t0Var.X0(w7.u.f14298y)}, new AdapterView.OnItemClickListener() { // from class: va.r0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                t0.n3(this.f13511a, fVar, adapterView, view2, i11, j10);
            }
        }).j0(view);
        return false;
    }

    public static /* synthetic */ void n3(final t0 t0Var, final t9.f fVar, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 2) {
            q5.k.l(t0Var.G()).f0(w7.u.f14298y).K(t0Var.Y0(w7.u.f14222s3, fVar.h())).X(R.string.ok, new q5.k.m() { // from class: va.i0
                @Override // q5.k.m
                public final void a(View view2, q5.k.p pVar) {
                    t0.c3(this.f13491a, fVar, view2, pVar);
                }
            }).P(R.string.cancel, null).h0();
            return;
        }
        if (i10 == 0) {
            com.tuyafeng.support.utils.n.a(t0Var.G(), fVar.h(), w7.u.Eg);
            return;
        }
        t0Var.getClass();
        if (i10 == 1) {
            t0Var.f13533y0.a(t0Var.X0(w7.u.P2), t0Var.X0(w7.u.wh), t0Var.new b(t0Var.G(), fVar.b()));
        }
    }

    private List w3(List list) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        final i8.p pVar = new i8.p();
        Collections.sort(list, new Comparator() { // from class: va.j0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return pVar.compare(((t9.f) obj).c(), ((t9.f) obj2).c());
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        String strC = null;
        while (it.hasNext()) {
            t9.f fVar = (t9.f) it.next();
            if (!fVar.c().equals(strC)) {
                strC = fVar.c();
                arrayList.add(new v5.l(strC));
            }
            arrayList.add(fVar);
        }
        return arrayList;
    }

    private void z3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: va.p0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13507c.f13526r0.g();
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: va.q0
            @Override // u6.f
            public final void accept(Object obj) {
                t0.i3(this.f13509c, (List) obj);
            }
        }, new w7.e0());
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f13526r0 = la.s.i();
        ((autodispose2.n) s8.c.a(this.f13529u0).E(1L).g(100L, TimeUnit.MILLISECONDS).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: va.l0
            @Override // u6.f
            public final void accept(Object obj) {
                t0.b3(this.f13498c, (CharSequence) obj);
            }
        }, new w7.e0());
        this.f13530v0.setLayoutManager(new LinearLayoutManager(G()));
        this.f13530v0.setItemAnimator(new androidx.recyclerview.widget.e());
        t5.f fVar = new t5.f(Collections.EMPTY_LIST);
        this.f13527s0 = fVar;
        fVar.K(v5.l.class, new v5.m());
        xa.c cVar = new xa.c();
        cVar.n(this.f13534z0);
        cVar.j(new t5.g() { // from class: va.m0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                t0.g3(this.f13500a, view2, i10, (t9.f) obj);
            }
        });
        cVar.k(new t5.h() { // from class: va.n0
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return t0.l3(this.f13502a, view2, i10, (t9.f) obj);
            }
        });
        this.f13527s0.K(t9.f.class, cVar);
        this.f13530v0.setAdapter(this.f13527s0);
        this.A0.setOnActionClickListener(new com.tuyafeng.support.widget.f0.c() { // from class: va.o0
            @Override // com.tuyafeng.support.widget.f0.c
            public final void a(View view2, com.tuyafeng.support.widget.f0.b bVar) {
                t0.j3(this.f13504a, view2, bVar);
            }
        });
        l8.b bVar = new l8.b(G(), new c());
        this.E0 = bVar;
        bVar.p(com.tuyafeng.support.utils.x.h(G(), com.tuyafeng.support.utils.l.d(G()) ? 48.0f : -48.0f));
        this.E0.o(new d());
        this.f13530v0.n(this.E0);
        this.f13534z0.i(new e());
        z3();
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        mark.via.common.widget.r0 r0Var = (mark.via.common.widget.r0) new b6.a(new mark.via.common.widget.r0(G()), new ViewGroup.LayoutParams(-1, -1)).l();
        r0Var.setSearchVisible(false);
        RecyclerView recyclerView = r0Var.f10038c;
        this.f13530v0 = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f13531w0 = r0Var.f10040m;
        this.f13529u0 = r0Var.f10041n;
        this.A0 = r0Var.f10042o;
        com.tuyafeng.support.widget.f0.b bVar = new com.tuyafeng.support.widget.f0.b(w7.p.S0, X0(w7.u.uc));
        this.C0 = bVar;
        bVar.k(true);
        com.tuyafeng.support.widget.f0.b bVar2 = new com.tuyafeng.support.widget.f0.b(w7.p.M0, X0(w7.u.f14298y));
        this.D0 = bVar2;
        bVar2.i(true);
        this.D0.j(true);
        this.D0.k(true);
        com.tuyafeng.support.widget.f0.b bVar3 = new com.tuyafeng.support.widget.f0.b(w7.p.N0, X0(w7.u.E));
        this.B0 = bVar3;
        this.A0.c(bVar3);
        this.A0.b(this.C0);
        this.A0.b(this.D0);
        this.f13528t0 = r0Var;
        Objects.requireNonNull(r0Var);
        X2(new e0(r0Var));
        return r0Var;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        v3.b(e0Var, X0(w7.u.f14296xa));
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 1, lb.g.a(G(), w7.o.f13810m, w7.u.ge), X0(w7.u.O)), new View.OnClickListener() { // from class: va.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13496a.y3(null);
            }
        });
    }

    public final void x3() {
        final int[] iArrB;
        if (!this.f13534z0.c() || this.f13534z0.a() <= 0 || (iArrB = this.f13534z0.b(true)) == null || iArrB.length == 0) {
            return;
        }
        q5.k.l(G()).f0(w7.u.f14298y).K(iArrB.length == 1 ? Y0(w7.u.f14222s3, ((t9.f) this.f13527s0.H().get(iArrB[0])).h()) : Y0(w7.u.f14236t3, Integer.valueOf(iArrB.length))).X(R.string.ok, new q5.k.m() { // from class: va.h0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                t0.k3(this.f13488a, iArrB, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void y3(String str) {
        L0().z1("result", this, new androidx.fragment.app.i0() { // from class: va.s0
            @Override // androidx.fragment.app.i0
            public final void a(String str2, Bundle bundle) {
                t0.a3(this.f13514a, str2, bundle);
            }
        });
        FragmentUtils.k(this, t.class, t.t3(str), null);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements l8.b.InterfaceC0093b {
        public d() {
        }

        @Override // l8.b.InterfaceC0093b
        public void a(boolean z10) {
        }

        @Override // l8.b.InterfaceC0093b
        public void b(boolean z10) {
        }
    }
}
