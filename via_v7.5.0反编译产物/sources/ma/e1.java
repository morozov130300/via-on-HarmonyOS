package ma;

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
import x8.h3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e1 extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public f1 f7996o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public ViewPager2 f7997p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f7998q0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends FragmentStateAdapter {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int[] f7999l;

        public a(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
            this.f7999l = new int[]{0, 1};
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            return this.f7999l[i10] != 0 ? new o() : new v0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int g() {
            return this.f7999l.length;
        }
    }

    public static /* synthetic */ void S2(e1 e1Var, Boolean bool) {
        e1Var.i0().K().y1("favoriteChanged", new Bundle());
        e1Var.i0().onBackPressed();
    }

    public static /* synthetic */ void W2(e1 e1Var, ViewGroup.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        e1Var.getClass();
        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        e1Var.f7997p0.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ y.k0 X2(e1 e1Var, View view, y.k0 k0Var) {
        e1Var.getClass();
        if (h3.f14580a) {
            r.f fVarF = k0Var.f(y.k0.m.f());
            e1Var.f7997p0.setPadding(fVarF.f11875a, 0, fVarF.f11877c, fVarF.f11878d);
        }
        return k0Var;
    }

    public static /* synthetic */ void Y2(final e1 e1Var, FrameLayout frameLayout) {
        e1Var.getClass();
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: ma.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7993a.L0().e1();
            }
        });
    }

    public static /* synthetic */ void Z2(final e1 e1Var, int i10, int i11) {
        final ViewGroup.LayoutParams layoutParams = e1Var.f7997p0.getLayoutParams();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, i11);
        valueAnimatorOfInt.setDuration((long) (((Math.abs(i10 - i11) / 512.0f) * 100.0f) + 80.0f));
        valueAnimatorOfInt.setInterpolator(v8.h.b());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ma.c1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e1.W2(this.f7988a, layoutParams, valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
    }

    public static Bundle a3(int i10, int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt("count", i10);
        bundle.putInt("height", i11);
        return bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(G()), new FrameLayout.LayoutParams(-1, -1)).f(com.tuyafeng.support.utils.f.b(G(), w7.m.f13746j)).V(new b6.a.InterfaceC0033a() { // from class: ma.a1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                e1.Y2(this.f7979a, (FrameLayout) obj);
            }
        }).l();
        ViewPager2 viewPager2 = (ViewPager2) new b6.a(new ViewPager2(G()), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.x.h(G(), 300.0f))).p(80).l();
        this.f7997p0 = viewPager2;
        frameLayout.addView(viewPager2);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void B1() {
        Window window;
        i0().K().y1("favoriteChanged", new Bundle());
        if (this.f7998q0 != 0 && (window = i0().getWindow()) != null) {
            window.setSoftInputMode(this.f7998q0);
        }
        super.B1();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        x8.f.e(this.f7997p0);
        super.M1();
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        if (w0() != null) {
            this.f7996o0.l(w0().getInt("count", 0));
        }
        b3(Resources.getSystem().getConfiguration());
        this.f7997p0.setOnClickListener(new View.OnClickListener() { // from class: ma.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e1.V2(view2);
            }
        });
        this.f7997p0.setUserInputEnabled(false);
        this.f7997p0.setAdapter(new a(x0(), h0()));
        this.f7997p0.j(1, false);
        this.f7997p0.j(0, false);
        com.tuyafeng.support.utils.x.P(this.f7997p0, new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.e.a(G(), w7.k.f13724d)).d(v8.h.e(G()), 0.0f).a());
        this.f7996o0.f8005e.g(b1(), new androidx.lifecycle.o() { // from class: ma.x0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f8079a.f7997p0.j(((Integer) obj).intValue(), true);
            }
        });
        this.f7996o0.f8011k.g(b1(), new androidx.lifecycle.o() { // from class: ma.y0
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                e1.S2(this.f8081a, (Boolean) obj);
            }
        });
        y.r.e0(this.f7997p0, new y.m() { // from class: ma.z0
            @Override // y.m
            public final y.k0 a(View view2, y.k0 k0Var) {
                return e1.X2(this.f8083a, view2, k0Var);
            }
        });
    }

    public final void b3(Configuration configuration) {
        ViewGroup.LayoutParams layoutParams = this.f7997p0.getLayoutParams();
        final int iD = w0() != null ? w0().getInt("height", 0) : 0;
        int iH = com.tuyafeng.support.utils.x.h(G(), configuration.screenHeightDp);
        if (iD == 0) {
            iD = com.tuyafeng.support.utils.f.d(G(), w7.n.D) + (iH / 2);
        }
        final int iMin = Math.min(Math.max(iD, com.tuyafeng.support.utils.f.d(G(), w7.n.D) + com.tuyafeng.support.utils.x.h(G(), 168.0f)), ((iH * 3) / 5) + com.tuyafeng.support.utils.f.d(G(), w7.n.D));
        if (iMin == iD || Math.abs(iMin - iD) > com.tuyafeng.support.utils.x.h(G(), 96.0f)) {
            layoutParams.height = iMin;
            this.f7997p0.setLayoutParams(layoutParams);
        } else {
            layoutParams.height = iD;
            this.f7997p0.setLayoutParams(layoutParams);
            this.f7997p0.postDelayed(new Runnable() { // from class: ma.b1
                @Override // java.lang.Runnable
                public final void run() {
                    e1.Z2(this.f7983c, iD, iMin);
                }
            }, 100L);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (w0() != null) {
            w0().clear();
        }
        super.onConfigurationChanged(configuration);
        if (this.f7997p0 != null) {
            b3(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f7996o0 = (f1) new androidx.lifecycle.a0(this).a(f1.class);
        Window window = i0().getWindow();
        if (window != null) {
            this.f7998q0 = window.getAttributes().softInputMode;
            window.setSoftInputMode(32);
        }
    }

    public static /* synthetic */ void V2(View view) {
    }
}
