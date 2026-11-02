package db;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
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
import b6.a;
import bb.i;
import bb.v;
import c8.ac;
import com.tuyafeng.support.widget.a0;
import e6.c;
import g6.p;
import g6.y;
import i6.g0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import mark.via.common.widget.r0;
import n8.b;
import v5.b;
import w5.k;
import x7.c0;
import x7.o;
import x7.u;
import z8.f1;
import z8.r3;
import z8.x0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n extends Fragment implements i.c {
    public n8.b A0;
    public e6.c B0;
    public e6.a C0;
    public Drawable E0;

    /* renamed from: m0, reason: collision with root package name */
    public r0 f4671m0;

    /* renamed from: n0, reason: collision with root package name */
    public RecyclerView f4672n0;

    /* renamed from: o0, reason: collision with root package name */
    public TextView f4673o0;

    /* renamed from: p0, reason: collision with root package name */
    public EditText f4674p0;

    /* renamed from: q0, reason: collision with root package name */
    public a0 f4675q0;

    /* renamed from: r0, reason: collision with root package name */
    public a0.b f4676r0;

    /* renamed from: s0, reason: collision with root package name */
    public a0.b f4677s0;

    /* renamed from: t0, reason: collision with root package name */
    public a0.b f4678t0;

    /* renamed from: u0, reason: collision with root package name */
    public a0.b f4679u0;

    /* renamed from: v0, reason: collision with root package name */
    public a0.b f4680v0;

    /* renamed from: w0, reason: collision with root package name */
    public y5.f f4681w0;

    /* renamed from: x0, reason: collision with root package name */
    public v f4682x0;

    /* renamed from: y0, reason: collision with root package name */
    public final v8.b f4683y0 = new v8.b();

    /* renamed from: z0, reason: collision with root package name */
    public final b6.a f4684z0 = new b6.a();
    public boolean D0 = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {
        public a() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            View viewA = b6.c.g().a(viewGroup);
            int i10 = b6.c.f1828c;
            r3.p((TextView) viewA.findViewById(i10));
            int i11 = b6.c.f1829d;
            r3.p((TextView) viewA.findViewById(i11));
            x8.g.d((TextView) viewA.findViewById(i10));
            x8.g.d((TextView) viewA.findViewById(i11));
            CheckBox checkBox = (CheckBox) viewA.findViewById(b6.c.f1832g);
            checkBox.setClickable(false);
            checkBox.setFocusable(false);
            return viewA;
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, n9.b bVar, int i10) {
            int i11 = b6.c.f1832g;
            gVar.Y(i11, n.this.f4684z0.c());
            gVar.T(i11, n.this.f4684z0.c() && n.this.f4684z0.d(i10));
            ImageView imageView = (ImageView) gVar.P(b6.c.f1830e);
            Bitmap bitmapD = x0.c().d(n.this.I(), bVar.g());
            if (bitmapD != null) {
                imageView.setImageBitmap(bitmapD);
            } else {
                imageView.setImageDrawable(n.this.E0);
            }
            gVar.X(b6.c.f1828c, p.j(bVar.e(), 256));
            gVar.X(b6.c.f1829d, g0.f6993a.d(bVar.g()));
        }

        @Override // y5.i
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void m(b6.g gVar, n9.b bVar, int i10, List list) {
            for (Object obj : list) {
                if (obj instanceof Boolean) {
                    gVar.T(b6.c.f1832g, ((Boolean) obj).booleanValue());
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements n8.a {
        public b() {
        }

        @Override // n8.a
        public boolean a(int i10) {
            return n.this.f4684z0.d(i10);
        }

        @Override // n8.a
        public void b(int i10, boolean z10) {
            if (n.this.f4684z0.j(i10, z10)) {
                n.this.f4681w0.n(i10, Boolean.valueOf(z10));
            }
        }

        @Override // n8.a
        public boolean c(int i10) {
            return n.this.f4684z0.c();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements b.InterfaceC0100b {
        public c() {
        }

        @Override // n8.b.InterfaceC0100b
        public void a(boolean z10) {
            n.this.f4682x0.M(!z10);
        }

        @Override // n8.b.InterfaceC0100b
        public void b(boolean z10) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements a.InterfaceC0033a {
        public d() {
        }

        @Override // b6.a.InterfaceC0033a
        public void a(int i10) {
            n.this.f4678t0.l(n.this.Z0(i10 > 0 && n.this.f4681w0.g() == i10 ? u.J1 : u.f13997gc));
            n.this.f4679u0.j(i10 <= 0);
            n.this.f4679u0.h(i10 > 0);
            n.this.f4679u0.l(i10 == 0 ? n.this.Z0(u.f14215x) : n.this.a1(u.f13960e3, Integer.valueOf(i10)));
            n.this.f4675q0.j(n.this.f4678t0, n.this.f4679u0);
        }

        @Override // b6.a.InterfaceC0033a
        public void b(boolean z10) {
            n.this.f4681w0.l();
            n.this.w3(z10);
            if (z10) {
                a(n.this.f4684z0.a());
            }
        }
    }

    public static /* synthetic */ void V2(n nVar, CharSequence charSequence) {
        if (nVar.D0) {
            nVar.f4682x0.L(charSequence.toString());
            nVar.f4684z0.k(false);
        }
    }

    public static /* synthetic */ void W2(n nVar, List list) {
        RecyclerView recyclerView;
        nVar.getClass();
        boolean zIsEmpty = list.isEmpty();
        if (nVar.f4674p0.getText().length() == 0) {
            nVar.f4676r0.j(zIsEmpty);
            nVar.f4680v0.j(zIsEmpty);
            nVar.f4675q0.j(nVar.f4676r0, nVar.f4680v0);
        }
        nVar.f4671m0.setEmpty(zIsEmpty);
        nVar.f4683y0.g(list, new v8.c() { // from class: db.b
            @Override // v8.c
            public final long a(Object obj) {
                return n.d3((n9.b) obj);
            }
        });
        nVar.f4681w0.M(list);
        nVar.f4681w0.l();
        if (nVar.f4684z0.c()) {
            nVar.f4678t0.l(nVar.Z0(nVar.f4684z0.a() == list.size() ? u.J1 : u.f13997gc));
            nVar.f4675q0.h(nVar.f4678t0);
        }
        if (nVar.D0) {
            return;
        }
        nVar.D0 = true;
        Bundle bundleC = v5.b.d().c("HISTORY_CACHE");
        if (bundleC == null || (recyclerView = nVar.f4672n0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        ((LinearLayoutManager) nVar.f4672n0.getLayoutManager()).B2(bundleC.getInt("position", 0), bundleC.getInt("offset", 0));
    }

    public static /* synthetic */ void X2(n nVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        nVar.getClass();
        if (i10 == -1) {
            return;
        }
        if (i11 == 0 || i11 == 1) {
            nVar.f4682x0.G(i10, i11 == 1 ? 1 : 2);
            return;
        }
        if (i11 == 2) {
            nVar.u3(i10);
        } else if (i11 == 3) {
            g6.n.a(nVar.I(), nVar.f4682x0.C(i10), u.pg);
        } else {
            if (i11 != 4) {
                return;
            }
            f1.k(nVar.I(), nVar.f4682x0.C(i10));
        }
    }

    public static /* synthetic */ void Y2(final n nVar, final List list) {
        nVar.getClass();
        final ArrayList arrayList = new ArrayList();
        Object[] objArr = {nVar.Z0(u.f14210w7), nVar.Z0(u.Ag), nVar.Z0(u.Bg), nVar.Z0(u.f14223x7), nVar.Z0(u.T0)};
        int size = list.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            if (((Integer) ((w.d) list.get(i11)).f13208b).intValue() != 0 && ((Integer) ((w.d) list.get(i11)).f13208b).intValue() != i10) {
                Integer num = (Integer) ((w.d) list.get(i11)).f13208b;
                int iIntValue = num.intValue();
                arrayList.add(new k.l(i11, nVar.a1(u.f14128q3, objArr[i11], num)));
                i10 = iIntValue;
            }
        }
        Collections.reverse(arrayList);
        w5.k.l(nVar.I()).d0(u.f13974f3).C(arrayList, new AdapterView.OnItemClickListener() { // from class: db.c
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                n nVar2 = this.f4653a;
                List list2 = arrayList;
                w5.k.l(nVar2.I()).d0(u.f13974f3).J(((k.l) list2.get(i12)).b()).V(R.string.ok, new k.m() { // from class: db.d
                    @Override // w5.k.m
                    public final void a(View view2, k.p pVar) {
                        n.e3(nVar2, list, list2, i12, view2, pVar);
                    }
                }).N(R.string.cancel, null).h0(nVar2.f4675q0.e(x7.p.K0));
            }
        }).h0(nVar.f4675q0.e(x7.p.K0));
    }

    public static /* synthetic */ void Z2(n nVar, View view, a0.b bVar) {
        int iG;
        nVar.getClass();
        int iA = bVar.a();
        if (iA == x7.p.K0) {
            nVar.p3();
            return;
        }
        if (iA == x7.p.T0) {
            nVar.f4682x0.N();
            return;
        }
        if (iA == x7.p.M0) {
            nVar.r3();
            return;
        }
        if (iA == x7.p.N0) {
            nVar.f4684z0.k(!r1.c());
        } else {
            if (iA != x7.p.S0 || (iG = nVar.f4681w0.g()) == 0) {
                return;
            }
            if (iG == nVar.f4684z0.a()) {
                nVar.f4684z0.l(0, iG);
            } else {
                nVar.f4684z0.f(0, iG);
            }
            nVar.f4681w0.q(0, iG);
        }
    }

    public static /* synthetic */ void a3(n nVar) {
        nVar.C0.I(0);
        nVar.f4682x0.E();
    }

    public static /* synthetic */ boolean b3(final n nVar, View view, final int i10, n9.b bVar) {
        if (nVar.f4684z0.c()) {
            nVar.A0.n(true, i10);
            return true;
        }
        w5.k.l(view.getContext()).F(new String[]{nVar.Z0(u.Q), nVar.Z0(u.R), nVar.Z0(u.f14215x), nVar.Z0(u.f14150s), nVar.Z0(u.f13943d0)}, new AdapterView.OnItemClickListener() { // from class: db.m
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                n.X2(this.f4669a, i10, adapterView, view2, i11, j10);
            }
        }).h0(view);
        return true;
    }

    public static /* synthetic */ void c3(n nVar, View view, int i10, n9.b bVar) {
        if (!nVar.f4684z0.c()) {
            nVar.f4682x0.G(i10, 0);
        } else {
            nVar.f4684z0.h(i10);
            nVar.f4681w0.n(i10, Boolean.valueOf(nVar.f4684z0.d(i10)));
        }
    }

    public static /* synthetic */ long d3(n9.b bVar) {
        return bVar.f() * 1000;
    }

    public static /* synthetic */ void e3(n nVar, List list, List list2, int i10, View view, k.p pVar) {
        nVar.getClass();
        nVar.f4682x0.A(((Long) ((w.d) list.get(((k.l) list2.get(i10)).a())).f13207a).longValue());
    }

    public static /* synthetic */ void f3(n nVar, Boolean bool) {
        nVar.B0.e(bool.booleanValue() ? 1 : 2);
        nVar.C0.I(bool.booleanValue() ? 1 : 2);
    }

    public static /* synthetic */ void g3(n nVar, int[] iArr, View view, k.p pVar) {
        if (nVar.f4682x0.J(iArr, nVar.f4674p0.getText().length() > 0)) {
            for (int i10 : iArr) {
                nVar.f4681w0.u(i10);
                nVar.f4683y0.f(i10);
            }
        }
        nVar.f4684z0.k(false);
    }

    private void s3() {
        this.f4684z0.i(new d());
    }

    private void v3() {
        RecyclerView recyclerView = this.f4672n0;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        b.C0148b c0148bD = v5.b.a().e("HISTORY_CACHE").f(180).d("query", this.f4674p0.getText().toString());
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f4672n0.getLayoutManager();
        View viewJ = linearLayoutManager.J(0);
        if (viewJ != null) {
            c0148bD.b("scrollY", this.f4672n0.getScrollY()).b("position", linearLayoutManager.i0(viewJ)).b("offset", viewJ.getTop());
        }
        c0148bD.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3(boolean z10) {
        this.f4680v0.l(Z0(z10 ? u.K3 : u.D));
        this.f4678t0.k(!z10);
        this.f4679u0.k(!z10);
        this.f4677s0.k(z10);
        this.f4676r0.k(z10);
        this.f4675q0.j(this.f4680v0, this.f4678t0, this.f4679u0, this.f4677s0, this.f4676r0);
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        r0 r0Var = (r0) new h6.a(new r0(I()), new ViewGroup.LayoutParams(-1, -1)).l();
        RecyclerView recyclerView = r0Var.f9734e;
        this.f4672n0 = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f4683y0.h(new v8.a(I()));
        Context contextI = I();
        v8.b bVar = this.f4683y0;
        Objects.requireNonNull(bVar);
        c6.b bVar2 = new c6.b(contextI, new ac(bVar));
        bVar2.o(1);
        bVar2.n(g6.e.a(I(), x7.k.f13655a));
        this.f4672n0.k(bVar2);
        this.f4673o0 = r0Var.f9736k;
        this.f4674p0 = r0Var.f9737l;
        this.f4675q0 = r0Var.f9738m;
        a0.b bVar3 = new a0.b(x7.p.K0, Z0(u.f14228y));
        this.f4676r0 = bVar3;
        bVar3.i(true);
        this.f4676r0.j(true);
        this.f4677s0 = new a0.b(x7.p.T0, Z0(u.Qd));
        a0.b bVar4 = new a0.b(x7.p.S0, Z0(u.f13997gc));
        this.f4678t0 = bVar4;
        bVar4.k(true);
        a0.b bVar5 = new a0.b(x7.p.M0, Z0(u.f14215x));
        this.f4679u0 = bVar5;
        bVar5.i(true);
        this.f4679u0.j(true);
        this.f4679u0.k(true);
        a0.b bVar6 = new a0.b(x7.p.N0, Z0(u.D));
        this.f4680v0 = bVar6;
        this.f4675q0.c(bVar6);
        this.f4675q0.c(this.f4676r0);
        this.f4675q0.b(this.f4677s0);
        this.f4675q0.b(this.f4678t0);
        this.f4675q0.b(this.f4679u0);
        this.f4671m0 = r0Var;
        return r0Var;
    }

    @Override // androidx.fragment.app.Fragment
    public void O1() {
        v3();
        z8.f.e(this.f4674p0);
        super.O1();
    }

    @Override // bb.i.c
    public boolean W() {
        if (this.f4684z0.c()) {
            this.f4684z0.k(false);
            return true;
        }
        if (this.f4674p0.getText().length() <= 0) {
            return false;
        }
        this.f4674p0.setText("");
        this.f4674p0.clearFocus();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        s3();
        Drawable drawableA = lb.b.a(I(), o.f13748n0, u.ie);
        this.E0 = drawableA;
        g6.h.a(drawableA, g6.e.a(view.getContext(), x7.k.f13662h));
        r3.e(this.f4673o0);
        this.f4672n0.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f4672n0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f4681w0 = new y5.f(new ArrayList());
        a aVar = new a();
        this.f4681w0.K(n9.b.class, aVar);
        e6.a aVar2 = new e6.a(this.f4681w0);
        this.C0 = aVar2;
        this.f4672n0.setAdapter(aVar2);
        aVar.j(new y5.g() { // from class: db.a
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                n.c3(this.f4652a, view2, i10, (n9.b) obj);
            }
        });
        aVar.k(new y5.h() { // from class: db.e
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return n.b3(this.f4660a, view2, i10, (n9.b) obj);
            }
        });
        Drawable drawableA2 = lb.b.a(I(), o.f13783z, u.Ud);
        if (drawableA2 != null) {
            drawableA2.setColorFilter(g6.e.a(I(), x7.k.f13662h), PorterDuff.Mode.SRC_IN);
        }
        y.P(this.f4674p0, drawableA2);
        ((autodispose2.n) u8.c.a(this.f4674p0).B(1L).f(100L, TimeUnit.MILLISECONDS).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: db.f
            @Override // a7.e
            public final void accept(Object obj) {
                n.V2(this.f4661e, (CharSequence) obj);
            }
        }, new x7.g0());
        this.f4675q0.setOnActionClickListener(new a0.c() { // from class: db.g
            @Override // com.tuyafeng.support.widget.a0.c
            public final void a(View view2, a0.b bVar) {
                n.Z2(this.f4662a, view2, bVar);
            }
        });
        n8.b bVar = new n8.b(I(), new b());
        this.A0 = bVar;
        bVar.p(y.h(I(), g6.l.d(I()) ? 48.0f : -48.0f));
        this.A0.o(new c());
        this.f4672n0.n(this.A0);
        this.f4682x0.f2158u.g(d1(), new androidx.lifecycle.m() { // from class: db.h
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                n.W2(this.f4663a, (List) obj);
            }
        });
        e6.c cVar = new e6.c();
        this.B0 = cVar;
        cVar.d(new c.a() { // from class: db.i
            @Override // e6.c.a
            public final void a() {
                n.a3(this.f4664a);
            }
        });
        this.f4672n0.o(this.B0);
        this.f4682x0.f2161x.g(d1(), new androidx.lifecycle.m() { // from class: db.j
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                n.f3(this.f4665a, (Boolean) obj);
            }
        });
        t3(view);
    }

    @Override // bb.i.c
    public boolean l() {
        return !this.f4684z0.c() && this.f4674p0.getText().length() == 0;
    }

    public final void p3() {
        if (this.f4674p0.getText().length() <= 0) {
            ((r) this.f4682x0.y().m(u8.b.a(d1()))).a(new a7.e() { // from class: db.k
                @Override // a7.e
                public final void accept(Object obj) {
                    n.Y2(this.f4666e, (List) obj);
                }
            }, new c0());
            return;
        }
        int iG = this.f4681w0.g();
        int[] iArr = new int[iG];
        for (int i10 = 0; i10 < iG; i10++) {
            iArr[i10] = (iG - 1) - i10;
        }
        q3(iArr);
    }

    public final void q3(final int[] iArr) {
        String strA1;
        if (iArr == null || iArr.length == 0) {
            return;
        }
        if (iArr.length == 1) {
            List list = (List) this.f4682x0.f2158u.e();
            if (list == null || iArr[0] >= list.size()) {
                return;
            }
            strA1 = a1(u.f13988g3, ((n9.b) list.get(iArr[0])).e());
        } else {
            strA1 = a1(u.f14002h3, Integer.valueOf(iArr.length));
        }
        w5.k.l(I()).d0(u.f14215x).J(strA1).V(R.string.ok, new k.m() { // from class: db.l
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                n.g3(this.f4667a, iArr, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void r3() {
        if (!this.f4684z0.c() || this.f4684z0.a() <= 0) {
            return;
        }
        q3(this.f4684z0.b(true));
    }

    public final void t3(View view) {
        Bundle bundleC = v5.b.d().c("HISTORY_CACHE");
        if (bundleC == null) {
            this.f4682x0.E();
            return;
        }
        this.f4672n0.setScrollY(bundleC.getInt("scrollY", 0));
        String string = bundleC.getString("query", "");
        if (string.isEmpty()) {
            this.f4682x0.F(Math.max(120, bundleC.getInt("position") + 20));
        } else {
            this.f4674p0.setText(string);
            this.f4682x0.L(string);
        }
    }

    public final void u3(int i10) {
        if (this.f4682x0.K(i10) == null) {
            return;
        }
        b6.b bVarC = this.f4683y0.c(i10);
        this.f4683y0.f(i10);
        this.f4681w0.u(i10);
        if (bVarC.c()) {
            this.f4681w0.n(i10 - 1, 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f4682x0 = (v) new androidx.lifecycle.y(B2(), pa.r.n()).a(v.class);
    }
}
