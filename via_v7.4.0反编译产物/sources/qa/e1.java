package qa;

import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import h6.a;
import x.k0;
import z8.l3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e1 extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public f1 f11354m0;

    /* renamed from: n0, reason: collision with root package name */
    public ViewPager2 f11355n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f11356o0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends FragmentStateAdapter {

        /* renamed from: l, reason: collision with root package name */
        public final int[] f11357l;

        public a(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
            this.f11357l = new int[]{0, 1};
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            return this.f11357l[i10] != 0 ? new o() : new v0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int g() {
            return this.f11357l.length;
        }
    }

    public static /* synthetic */ void U2(e1 e1Var, Boolean bool) {
        e1Var.l0().L().x1("favoriteChanged", new Bundle());
        e1Var.l0().onBackPressed();
    }

    public static /* synthetic */ void X2(View view) {
    }

    public static /* synthetic */ void Y2(e1 e1Var, ViewGroup.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        e1Var.getClass();
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        e1Var.f11355n0.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ x.k0 Z2(e1 e1Var, View view, x.k0 k0Var) {
        e1Var.getClass();
        if (l3.f14720a) {
            r.f fVarF = k0Var.f(k0.m.f());
            e1Var.f11355n0.setPadding(fVarF.f11465a, 0, fVarF.f11467c, fVarF.f11468d);
        }
        return k0Var;
    }

    public static /* synthetic */ void a3(final e1 e1Var, FrameLayout frameLayout) {
        e1Var.getClass();
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: qa.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11351a.N0().e1();
            }
        });
    }

    public static /* synthetic */ void b3(final e1 e1Var, int i10, int i11) {
        final ViewGroup.LayoutParams layoutParams = e1Var.f11355n0.getLayoutParams();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, i11);
        valueAnimatorOfInt.setDuration((long) (((Math.abs(i10 - i11) / 512.0f) * 100.0f) + 80.0f));
        valueAnimatorOfInt.setInterpolator(x8.h.b());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: qa.b1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e1.Y2(this.f11343a, layoutParams, valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
    }

    public static Bundle c3(int i10, int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt("count", i10);
        bundle.putInt("height", i11);
        return bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(I()), new FrameLayout.LayoutParams(-1, -1)).f(g6.f.b(I(), x7.m.f13680j)).V(new a.InterfaceC0076a() { // from class: qa.c1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                e1.a3(this.f11347a, (FrameLayout) obj);
            }
        }).l();
        ViewPager2 viewPager2 = (ViewPager2) new h6.a(new ViewPager2(I()), new FrameLayout.LayoutParams(-1, g6.y.h(I(), 300.0f))).p(80).l();
        this.f11355n0 = viewPager2;
        frameLayout.addView(viewPager2);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        Window window;
        l0().L().x1("favoriteChanged", new Bundle());
        if (this.f11356o0 != 0 && (window = l0().getWindow()) != null) {
            window.setSoftInputMode(this.f11356o0);
        }
        super.D1();
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void O1() {
        z8.f.e(this.f11355n0);
        super.O1();
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        if (y0() != null) {
            this.f11354m0.l(y0().getInt("count", 0));
        }
        d3(Resources.getSystem().getConfiguration());
        this.f11355n0.setOnClickListener(new View.OnClickListener() { // from class: qa.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e1.X2(view2);
            }
        });
        this.f11355n0.setUserInputEnabled(false);
        this.f11355n0.setAdapter(new a(z0(), k0()));
        this.f11355n0.j(1, false);
        this.f11355n0.j(0, false);
        g6.y.O(this.f11355n0, new g6.g().h(g6.e.a(I(), x7.k.f13657c)).d(x8.h.e(I()), 0.0f).a());
        this.f11354m0.f11363e.g(d1(), new androidx.lifecycle.m() { // from class: qa.x0
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f11437a.f11355n0.j(((Integer) obj).intValue(), true);
            }
        });
        this.f11354m0.f11369k.g(d1(), new androidx.lifecycle.m() { // from class: qa.y0
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                e1.U2(this.f11439a, (Boolean) obj);
            }
        });
        x.r.d0(this.f11355n0, new x.m() { // from class: qa.z0
            @Override // x.m
            public final x.k0 a(View view2, x.k0 k0Var) {
                return e1.Z2(this.f11441a, view2, k0Var);
            }
        });
    }

    public final void d3(Configuration configuration) {
        ViewGroup.LayoutParams layoutParams = this.f11355n0.getLayoutParams();
        final int iD = y0() != null ? y0().getInt("height", 0) : 0;
        int iH = g6.y.h(I(), configuration.screenHeightDp);
        if (iD == 0) {
            iD = g6.f.d(I(), x7.n.B) + (iH / 2);
        }
        final int iMin = Math.min(Math.max(iD, g6.f.d(I(), x7.n.B) + g6.y.h(I(), 168.0f)), ((iH * 3) / 5) + g6.f.d(I(), x7.n.B));
        if (iMin == iD || Math.abs(iMin - iD) > g6.y.h(I(), 96.0f)) {
            layoutParams.height = iMin;
            this.f11355n0.setLayoutParams(layoutParams);
        } else {
            layoutParams.height = iD;
            this.f11355n0.setLayoutParams(layoutParams);
            this.f11355n0.postDelayed(new Runnable() { // from class: qa.a1
                @Override // java.lang.Runnable
                public final void run() {
                    e1.b3(this.f11337e, iD, iMin);
                }
            }, 100L);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (y0() != null) {
            y0().clear();
        }
        super.onConfigurationChanged(configuration);
        if (this.f11355n0 != null) {
            d3(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f11354m0 = (f1) new androidx.lifecycle.y(this).a(f1.class);
        Window window = l0().getWindow();
        if (window != null) {
            this.f11356o0 = window.getAttributes().softInputMode;
            window.setSoftInputMode(32);
        }
    }
}
