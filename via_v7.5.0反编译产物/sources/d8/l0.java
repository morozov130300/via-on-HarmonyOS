package d8;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c6.a2;
import java.util.ArrayList;
import java.util.List;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l0 extends c implements r4.f {
    public androidx.recyclerview.widget.j B0;
    public boolean C0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public t5.f f3969u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public RecyclerView f3970v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ValueAnimator f3971w0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public b f3973y0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f3972x0 = 500;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public List f3974z0 = new ArrayList();
    public int A0 = -1;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends androidx.recyclerview.widget.j.i {
        public a(int i10, int i11) {
            super(i10, i11);
        }

        @Override // androidx.recyclerview.widget.j.f
        public void A(RecyclerView.d0 d0Var, int i10) {
            super.A(d0Var, i10);
            if (i10 == 2 && d0Var != null && l0.this.y0() != null) {
                d0Var.f1138a.setBackgroundColor(com.tuyafeng.support.utils.f.b(l0.this.G(), w7.m.f13738b));
            } else if (i10 == 0) {
                l0.this.C0 = false;
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public void B(RecyclerView.d0 d0Var, int i10) {
            int iL = d0Var.l();
            if (l0.this.f3973y0 != null) {
                l0.this.f3973y0.e(iL);
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public void c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            super.c(recyclerView, d0Var);
            if (l0.this.y0() != null) {
                com.tuyafeng.support.utils.x.P(d0Var.f1138a, com.tuyafeng.support.utils.f.e(l0.this.G(), w7.o.f13786e));
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean r() {
            return false;
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            return l0.this.f3973y0 != null && l0.this.f3973y0.h(d0Var.l(), d0Var2.l());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(int i10);

        void b(int i10, int i11);

        void c(r4.f fVar);

        void d();

        void e(int i10);

        void f();

        void g(r4.f fVar);

        boolean h(int i10, int i11);

        void i(int i10);
    }

    public static /* synthetic */ void Y2(l0 l0Var, String str, int i10, AdapterView adapterView, View view, int i11, long j10) {
        int i12 = (int) j10;
        switch (i12) {
            case 1:
            case 2:
            case 3:
            case 4:
                b bVar = l0Var.f3973y0;
                if (bVar != null) {
                    bVar.b(i10, i12);
                }
                break;
            case 5:
                com.tuyafeng.support.utils.n.a(l0Var.G(), str, w7.u.Fg);
                break;
            case 6:
                b bVar2 = l0Var.f3973y0;
                if (bVar2 != null) {
                    bVar2.a(i10);
                }
                break;
            default:
                l0Var.getClass();
                break;
        }
    }

    public static /* synthetic */ void Z2(l0 l0Var, RecyclerView.d0 d0Var) {
        if (l0Var.f3974z0.size() < 2) {
            return;
        }
        l0Var.C0 = true;
        l0Var.B0.H(d0Var);
    }

    public static /* synthetic */ void a3(final l0 l0Var, ImageView imageView) {
        imageView.setContentDescription(l0Var.G().getString(w7.u.P));
        imageView.setImageDrawable(com.tuyafeng.support.utils.e.f(lb.g.a(l0Var.G(), w7.o.f13810m, w7.u.ge), com.tuyafeng.support.utils.e.a(l0Var.G(), w7.k.f13729i)));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: d8.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l0.f3(this.f3965a, view);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: d8.k0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return l0.e3(this.f3967a, view);
            }
        });
    }

    public static /* synthetic */ void b3(l0 l0Var, View view, int i10, r4.a aVar) {
        b bVar = l0Var.f3973y0;
        if (bVar != null) {
            bVar.i(i10);
        }
    }

    public static /* synthetic */ void c3(l0 l0Var, ViewGroup.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        l0Var.getClass();
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        l0Var.f3970v0.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ boolean e3(l0 l0Var, View view) {
        b bVar = l0Var.f3973y0;
        if (bVar == null) {
            return false;
        }
        bVar.f();
        return true;
    }

    public static /* synthetic */ void f3(l0 l0Var, View view) {
        b bVar = l0Var.f3973y0;
        if (bVar != null) {
            bVar.d();
        }
    }

    public static /* synthetic */ void g3(l0 l0Var, int i10) {
        b bVar = l0Var.f3973y0;
        if (bVar != null) {
            bVar.e(i10);
        }
    }

    public static /* synthetic */ boolean h3(l0 l0Var, View view, int i10, r4.a aVar) {
        if (l0Var.C0) {
            return true;
        }
        l0Var.r3(view, aVar, i10);
        return true;
    }

    public static /* synthetic */ void i3(l0 l0Var) {
        l0Var.f3970v0.p1(l0Var.A0);
        l0Var.o3(l0Var.A0);
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        b bVar = this.f3973y0;
        if (bVar != null) {
            bVar.g(this);
            this.f3973y0 = null;
        }
        super.D1();
    }

    @Override // r4.f
    public void E(int i10, int i11, int i12) {
        this.A0 = i12;
        t5.f fVar = this.f3969u0;
        if (fVar != null) {
            fVar.p(i10, i11);
        }
    }

    @Override // r4.f
    public void F(int i10) {
        t5.f fVar = this.f3969u0;
        if (fVar == null) {
            return;
        }
        fVar.u(i10);
        m3();
    }

    @Override // d8.c
    public CharSequence U2() {
        return X0(w7.u.fe);
    }

    @Override // d8.c, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f3969u0 = new t5.f(this.f3974z0);
        y yVar = new y();
        yVar.j(new t5.g() { // from class: d8.a0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                l0.b3(this.f3937a, view2, i10, (r4.a) obj);
            }
        });
        yVar.k(new t5.h() { // from class: d8.c0
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return l0.h3(this.f3948a, view2, i10, (r4.a) obj);
            }
        });
        yVar.p(new y.b() { // from class: d8.d0
            @Override // d8.y.b
            public final void a(int i10) {
                l0.g3(this.f3949a, i10);
            }
        });
        yVar.q(new y.c() { // from class: d8.e0
            @Override // d8.y.c
            public final void a(RecyclerView.d0 d0Var) {
                l0.Z2(this.f3951a, d0Var);
            }
        });
        this.f3969u0.K(r4.a.class, yVar);
        this.f3970v0.setAdapter(this.f3969u0);
        int i10 = this.A0;
        if (i10 < 0 || i10 >= this.f3974z0.size()) {
            return;
        }
        this.f3970v0.p1(this.A0);
        o3(this.A0);
    }

    @Override // d8.c
    public View V2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3970v0 = (RecyclerView) new b6.a(new RecyclerView(G()), new FrameLayout.LayoutParams(-1, l3())).o(w7.p.C0).l();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(G());
        linearLayoutManager.E2((this.f3944q0 & 80) == 80);
        this.f3970v0.setLayoutManager(linearLayoutManager);
        r3.e(this.f3970v0);
        this.f3970v0.setHasFixedSize(true);
        androidx.recyclerview.widget.e eVar = new androidx.recyclerview.widget.e();
        eVar.z(100L);
        eVar.w(100L);
        eVar.x(100L);
        this.f3970v0.setItemAnimator(eVar);
        androidx.recyclerview.widget.j jVar = new androidx.recyclerview.widget.j(new a(3, 48));
        this.B0 = jVar;
        jVar.m(this.f3970v0);
        ImageView imageView = (ImageView) new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.f.d(G(), w7.n.A))).E(com.tuyafeng.support.utils.f.d(G(), w7.n.f13773z)).e(com.tuyafeng.support.utils.f.e(G(), w7.o.f13786e)).o(w7.p.f13858c).V(new b6.a.InterfaceC0033a() { // from class: d8.f0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                l0.a3(this.f3953a, (ImageView) obj);
            }
        }).l();
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.f.d(G(), w7.n.f13764q)).V(new b6.a.InterfaceC0033a() { // from class: d8.g0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        linearLayout.addView(this.f3970v0);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    @Override // r4.f
    public void W(int i10, int i11) {
        this.A0 = i11;
        t5.f fVar = this.f3969u0;
        if (fVar == null) {
            return;
        }
        if (i10 >= 0) {
            fVar.m(i10);
        }
        if (i11 < 0 || i11 == i10) {
            return;
        }
        this.f3969u0.m(i11);
    }

    @Override // d8.c
    public void W2() {
        int i10;
        RecyclerView recyclerView = this.f3970v0;
        if (recyclerView == null || (i10 = this.A0) < 0) {
            super.W2();
        } else {
            recyclerView.p1(i10);
            o3(this.A0);
        }
    }

    @Override // r4.f
    public void Y(r4.a aVar, int i10) {
        t5.f fVar = this.f3969u0;
        if (fVar == null) {
            return;
        }
        fVar.o(i10);
        m3();
    }

    @Override // r4.f
    public void f(r4.a aVar, int i10) {
        t5.f fVar = this.f3969u0;
        if (fVar == null || i10 < 0) {
            return;
        }
        fVar.m(i10);
    }

    public final int l3() {
        int iD = com.tuyafeng.support.utils.f.d(G(), w7.n.B);
        int iD2 = com.tuyafeng.support.utils.f.d(G(), w7.n.f13749b);
        return Math.min(Math.max(0, (this.f3972x0 - iD2) - (com.tuyafeng.support.utils.f.d(G(), w7.n.f13764q) * 2)), iD * this.f3974z0.size());
    }

    public final void m3() {
        n3(true);
    }

    public final void n3(boolean z10) {
        RecyclerView recyclerView = this.f3970v0;
        if (recyclerView == null) {
            return;
        }
        final ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        int iL3 = l3();
        ValueAnimator valueAnimator = this.f3971w0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f3971w0.cancel();
            this.f3971w0 = null;
        }
        if (!z10 || !g1()) {
            layoutParams.height = iL3;
            this.f3970v0.setLayoutParams(layoutParams);
            return;
        }
        int i10 = layoutParams.height;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, i10, iL3);
        this.f3971w0 = valueAnimatorOfInt;
        valueAnimatorOfInt.setInterpolator(v8.h.b());
        this.f3971w0.setDuration(350L);
        this.f3971w0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: d8.b0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                l0.c3(this.f3940a, layoutParams, valueAnimator2);
            }
        });
        this.f3971w0.start();
    }

    public final void o3(int i10) {
        com.tuyafeng.support.utils.x.N(this.f3970v0, i10);
    }

    public void p3(b bVar) {
        b bVar2 = this.f3973y0;
        if (bVar2 != null) {
            bVar2.g(this);
        }
        if (bVar != null) {
            bVar.c(this);
        }
        this.f3973y0 = bVar;
    }

    public void q3(List list, int i10) {
        this.f3974z0 = list;
        if (i10 < 0 || i10 >= list.size()) {
            i10 = -1;
        }
        this.A0 = i10;
        t5.f fVar = this.f3969u0;
        if (fVar != null) {
            fVar.M(list);
            this.f3969u0.l();
        }
        RecyclerView recyclerView = this.f3970v0;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: d8.i0
                @Override // java.lang.Runnable
                public final void run() {
                    l0.i3(this.f3963c);
                }
            });
        }
    }

    public final void r3(View view, r4.a aVar, final int i10) {
        int iG = this.f3969u0.g();
        final String url = aVar.getUrl();
        ArrayList arrayList = new ArrayList();
        if (iG > 1) {
            arrayList.add(new q5.k.l(4, X0(w7.u.f14134m)));
            arrayList.add(new q5.k.l(1, X0(w7.u.f14148n)));
        }
        if (i10 != 0 && i10 != iG - 1) {
            arrayList.add(new q5.k.l(3, X0(w7.u.f14204r)));
            arrayList.add(new q5.k.l(2, X0(w7.u.f14162o)));
        }
        a2 a2Var = a2.f1958a;
        if (a2Var.t(url)) {
            arrayList.add(new q5.k.l(6, X0(w7.u.f14303y4)));
        }
        if (!a2Var.m(url)) {
            arrayList.add(new q5.k.l(5, X0(w7.u.f14218s)));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        q5.k.l(G()).D(arrayList, new AdapterView.OnItemClickListener() { // from class: d8.h0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                l0.Y2(this.f3960a, url, i10, adapterView, view2, i11, j10);
            }
        }).j0(view);
    }

    @Override // d8.c, androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        Bundle bundleW0 = w0();
        if (bundleW0 == null || bundleW0.isEmpty()) {
            return;
        }
        this.f3972x0 = bundleW0.getInt("max_height", this.f3972x0);
    }
}
