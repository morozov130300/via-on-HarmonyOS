package f8;

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
import androidx.recyclerview.widget.j;
import f8.y;
import h6.a;
import java.util.ArrayList;
import java.util.List;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import w5.k;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l0 extends c implements r4.f {
    public boolean A0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f5994s0;

    /* renamed from: t0, reason: collision with root package name */
    public RecyclerView f5995t0;

    /* renamed from: u0, reason: collision with root package name */
    public ValueAnimator f5996u0;

    /* renamed from: w0, reason: collision with root package name */
    public b f5998w0;

    /* renamed from: z0, reason: collision with root package name */
    public androidx.recyclerview.widget.j f6001z0;

    /* renamed from: v0, reason: collision with root package name */
    public int f5997v0 = 500;

    /* renamed from: x0, reason: collision with root package name */
    public List f5999x0 = new ArrayList();

    /* renamed from: y0, reason: collision with root package name */
    public int f6000y0 = -1;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends j.i {
        public a(int i10, int i11) {
            super(i10, i11);
        }

        @Override // androidx.recyclerview.widget.j.f
        public void A(RecyclerView.c0 c0Var, int i10) {
            super.A(c0Var, i10);
            if (i10 == 2 && c0Var != null && l0.this.A0() != null) {
                c0Var.f1219a.setBackgroundColor(g6.f.b(l0.this.I(), x7.m.f13672b));
            } else if (i10 == 0) {
                l0.this.A0 = false;
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public void B(RecyclerView.c0 c0Var, int i10) {
            int iL = c0Var.l();
            if (l0.this.f5998w0 != null) {
                l0.this.f5998w0.e(iL);
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public void c(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            super.c(recyclerView, c0Var);
            if (l0.this.A0() != null) {
                g6.y.O(c0Var.f1219a, g6.f.e(l0.this.I(), x7.o.f13723f));
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean r() {
            return false;
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean y(RecyclerView recyclerView, RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            return l0.this.f5998w0 != null && l0.this.f5998w0.h(c0Var.l(), c0Var2.l());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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

    public static /* synthetic */ void a3(l0 l0Var, String str, int i10, AdapterView adapterView, View view, int i11, long j10) {
        int i12 = (int) j10;
        switch (i12) {
            case 1:
            case 2:
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
            case 4:
                b bVar = l0Var.f5998w0;
                if (bVar != null) {
                    bVar.b(i10, i12);
                    break;
                }
                break;
            case 5:
                g6.n.a(l0Var.I(), str, x7.u.pg);
                break;
            case 6:
                b bVar2 = l0Var.f5998w0;
                if (bVar2 != null) {
                    bVar2.a(i10);
                    break;
                }
                break;
            default:
                l0Var.getClass();
                break;
        }
    }

    public static /* synthetic */ void b3(l0 l0Var, RecyclerView.c0 c0Var) {
        if (l0Var.f5999x0.size() < 2) {
            return;
        }
        l0Var.A0 = true;
        l0Var.f6001z0.H(c0Var);
    }

    public static /* synthetic */ void c3(final l0 l0Var, ImageView imageView) {
        imageView.setContentDescription(l0Var.I().getString(x7.u.O));
        imageView.setImageDrawable(g6.e.f(lb.b.a(l0Var.I(), x7.o.f13747n, x7.u.Rd), g6.e.a(l0Var.I(), x7.k.f13662h)));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: f8.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l0.h3(this.f5992a, view);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: f8.b0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return l0.g3(this.f5965a, view);
            }
        });
    }

    public static /* synthetic */ void d3(l0 l0Var, View view, int i10, r4.a aVar) {
        b bVar = l0Var.f5998w0;
        if (bVar != null) {
            bVar.i(i10);
        }
    }

    public static /* synthetic */ void e3(l0 l0Var, ViewGroup.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        l0Var.getClass();
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        l0Var.f5995t0.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ boolean g3(l0 l0Var, View view) {
        b bVar = l0Var.f5998w0;
        if (bVar == null) {
            return false;
        }
        bVar.f();
        return true;
    }

    public static /* synthetic */ void h3(l0 l0Var, View view) {
        b bVar = l0Var.f5998w0;
        if (bVar != null) {
            bVar.d();
        }
    }

    public static /* synthetic */ void i3(l0 l0Var, int i10) {
        b bVar = l0Var.f5998w0;
        if (bVar != null) {
            bVar.e(i10);
        }
    }

    public static /* synthetic */ boolean j3(l0 l0Var, View view, int i10, r4.a aVar) {
        if (l0Var.A0) {
            return true;
        }
        l0Var.t3(view, aVar, i10);
        return true;
    }

    public static /* synthetic */ void k3(l0 l0Var) {
        l0Var.f5995t0.p1(l0Var.f6000y0);
        l0Var.q3(l0Var.f6000y0);
    }

    @Override // androidx.fragment.app.Fragment
    public void F1() {
        b bVar = this.f5998w0;
        if (bVar != null) {
            bVar.g(this);
            this.f5998w0 = null;
        }
        super.F1();
    }

    @Override // r4.f
    public void G(int i10, int i11, int i12) {
        this.f6000y0 = i12;
        y5.f fVar = this.f5994s0;
        if (fVar != null) {
            fVar.p(i10, i11);
        }
    }

    @Override // r4.f
    public void H(int i10) {
        y5.f fVar = this.f5994s0;
        if (fVar == null) {
            return;
        }
        fVar.u(i10);
        o3();
    }

    @Override // f8.c
    public CharSequence W2() {
        return Z0(x7.u.Qd);
    }

    @Override // f8.c, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f5994s0 = new y5.f(this.f5999x0);
        y yVar = new y();
        yVar.j(new y5.g() { // from class: f8.a0
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                l0.d3(this.f5962a, view2, i10, (r4.a) obj);
            }
        });
        yVar.k(new y5.h() { // from class: f8.c0
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return l0.j3(this.f5972a, view2, i10, (r4.a) obj);
            }
        });
        yVar.p(new y.b() { // from class: f8.d0
            @Override // f8.y.b
            public final void a(int i10) {
                l0.i3(this.f5973a, i10);
            }
        });
        yVar.q(new y.c() { // from class: f8.e0
            @Override // f8.y.c
            public final void a(RecyclerView.c0 c0Var) {
                l0.b3(this.f5975a, c0Var);
            }
        });
        this.f5994s0.K(r4.a.class, yVar);
        this.f5995t0.setAdapter(this.f5994s0);
        int i10 = this.f6000y0;
        if (i10 < 0 || i10 >= this.f5999x0.size()) {
            return;
        }
        this.f5995t0.p1(this.f6000y0);
        q3(this.f6000y0);
    }

    @Override // f8.c
    public View X2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5995t0 = (RecyclerView) new h6.a(new RecyclerView(I()), new FrameLayout.LayoutParams(-1, n3())).o(x7.p.G0).l();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(I());
        linearLayoutManager.E2((this.f5968o0 & 80) == 80);
        this.f5995t0.setLayoutManager(linearLayoutManager);
        r3.d(this.f5995t0);
        this.f5995t0.setHasFixedSize(true);
        androidx.recyclerview.widget.e eVar = new androidx.recyclerview.widget.e();
        eVar.z(100L);
        eVar.w(100L);
        eVar.x(100L);
        this.f5995t0.setItemAnimator(eVar);
        androidx.recyclerview.widget.j jVar = new androidx.recyclerview.widget.j(new a(3, 48));
        this.f6001z0 = jVar;
        jVar.m(this.f5995t0);
        ImageView imageView = (ImageView) new h6.a(new ImageView(I()), new FrameLayout.LayoutParams(-1, g6.f.d(I(), x7.n.f13706y))).E(g6.f.d(I(), x7.n.f13705x)).e(g6.f.e(I(), x7.o.f13723f)).o(x7.p.f13792c).V(new a.InterfaceC0076a() { // from class: f8.f0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                l0.c3(this.f5977a, (ImageView) obj);
            }
        }).l();
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -2)).S(g6.f.d(I(), x7.n.f13698q)).V(new a.InterfaceC0076a() { // from class: f8.g0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        linearLayout.addView(this.f5995t0);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    @Override // f8.c
    public void Y2() {
        int i10;
        RecyclerView recyclerView = this.f5995t0;
        if (recyclerView == null || (i10 = this.f6000y0) < 0) {
            super.Y2();
        } else {
            recyclerView.p1(i10);
            q3(this.f6000y0);
        }
    }

    @Override // r4.f
    public void a0(int i10, int i11) {
        this.f6000y0 = i11;
        y5.f fVar = this.f5994s0;
        if (fVar == null) {
            return;
        }
        if (i10 >= 0) {
            fVar.m(i10);
        }
        if (i11 < 0 || i11 == i10) {
            return;
        }
        this.f5994s0.m(i11);
    }

    @Override // r4.f
    public void b0(r4.a aVar, int i10) {
        y5.f fVar = this.f5994s0;
        if (fVar == null) {
            return;
        }
        fVar.o(i10);
        o3();
    }

    @Override // r4.f
    public void f(r4.a aVar, int i10) {
        y5.f fVar = this.f5994s0;
        if (fVar == null || i10 < 0) {
            return;
        }
        fVar.m(i10);
    }

    public final int n3() {
        int iD = g6.f.d(I(), x7.n.f13707z);
        int iD2 = g6.f.d(I(), x7.n.f13683b);
        return Math.min(Math.max(0, (this.f5997v0 - iD2) - (g6.f.d(I(), x7.n.f13698q) * 2)), iD * this.f5999x0.size());
    }

    public final void o3() {
        p3(true);
    }

    public final void p3(boolean z10) {
        RecyclerView recyclerView = this.f5995t0;
        if (recyclerView == null) {
            return;
        }
        final ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        int iN3 = n3();
        ValueAnimator valueAnimator = this.f5996u0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f5996u0.cancel();
            this.f5996u0 = null;
        }
        if (!z10 || !i1()) {
            layoutParams.height = iN3;
            this.f5995t0.setLayoutParams(layoutParams);
            return;
        }
        int i10 = layoutParams.height;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, i10, iN3);
        this.f5996u0 = valueAnimatorOfInt;
        valueAnimatorOfInt.setInterpolator(x8.h.b());
        this.f5996u0.setDuration(350L);
        this.f5996u0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: f8.j0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                l0.e3(this.f5989a, layoutParams, valueAnimator2);
            }
        });
        this.f5996u0.start();
    }

    public final void q3(int i10) {
        g6.y.M(this.f5995t0, i10);
    }

    public void r3(b bVar) {
        b bVar2 = this.f5998w0;
        if (bVar2 != null) {
            bVar2.g(this);
        }
        if (bVar != null) {
            bVar.c(this);
        }
        this.f5998w0 = bVar;
    }

    public void s3(List list, int i10) {
        this.f5999x0 = list;
        if (i10 < 0 || i10 >= list.size()) {
            i10 = -1;
        }
        this.f6000y0 = i10;
        y5.f fVar = this.f5994s0;
        if (fVar != null) {
            fVar.M(list);
            this.f5994s0.l();
        }
        RecyclerView recyclerView = this.f5995t0;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: f8.i0
                @Override // java.lang.Runnable
                public final void run() {
                    l0.k3(this.f5987e);
                }
            });
        }
    }

    public final void t3(View view, r4.a aVar, final int i10) {
        int iG = this.f5994s0.g();
        final String url = aVar.getUrl();
        ArrayList arrayList = new ArrayList();
        if (iG > 1) {
            arrayList.add(new k.l(4, Z0(x7.u.f14068m)));
            arrayList.add(new k.l(1, Z0(x7.u.f14082n)));
        }
        if (i10 != 0 && i10 != iG - 1) {
            arrayList.add(new k.l(3, Z0(x7.u.f14137r)));
            arrayList.add(new k.l(2, Z0(x7.u.f14096o)));
        }
        i6.i0 i0Var = i6.i0.f7006a;
        if (i0Var.s(url)) {
            arrayList.add(new k.l(6, Z0(x7.u.f14059l4)));
        }
        if (!i0Var.l(url)) {
            arrayList.add(new k.l(5, Z0(x7.u.f14150s)));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        w5.k.l(I()).C(arrayList, new AdapterView.OnItemClickListener() { // from class: f8.h0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                l0.a3(this.f5984a, url, i10, adapterView, view2, i11, j10);
            }
        }).h0(view);
    }

    @Override // f8.c, androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        Bundle bundleY0 = y0();
        if (bundleY0 == null || bundleY0.isEmpty()) {
            return;
        }
        this.f5997v0 = bundleY0.getInt("max_height", this.f5997v0);
    }
}
