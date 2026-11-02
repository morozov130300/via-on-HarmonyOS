package c8;

import android.R;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y7 extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public RelativeLayout f2933e;

    /* renamed from: j, reason: collision with root package name */
    public FrameLayout f2934j;

    /* renamed from: k, reason: collision with root package name */
    public ProgressBar f2935k;

    /* renamed from: l, reason: collision with root package name */
    public View f2936l;

    /* renamed from: m, reason: collision with root package name */
    public FrameLayout f2937m;

    /* renamed from: n, reason: collision with root package name */
    public LinearLayout f2938n;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayout f2939o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f2940p;

    /* renamed from: q, reason: collision with root package name */
    public com.tuyafeng.support.widget.w f2941q;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f2942r;

    /* renamed from: s, reason: collision with root package name */
    public b f2943s;

    public y7(Context context) {
        super(context);
        this.f2943s = new b();
        j();
    }

    public static /* synthetic */ void d(y7 y7Var, ProgressBar progressBar) {
        y7Var.getClass();
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.setIndeterminate(false);
        progressBar.setVisibility(8);
        progressBar.setProgressDrawable(x8.h.x(y7Var.getContext()));
    }

    public static /* synthetic */ void f(y7 y7Var, ImageView imageView) {
        y7Var.getClass();
        imageView.setVisibility(4);
        g6.y.S(-1, imageView);
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setElevation(g6.y.h(y7Var.getContext(), 12.0f));
        }
    }

    public static /* synthetic */ void g(View view) {
        view.setAlpha(0.0f);
        view.setVisibility(8);
    }

    public boolean h() {
        return this.f2943s.c();
    }

    public boolean i() {
        if (this.f2936l.getVisibility() == 8) {
            return false;
        }
        this.f2934j.setDescendantFocusability(262144);
        x.r.c(this.f2936l).a(0.0f).d(getResources().getInteger(x7.q.f13865b)).i(new Runnable() { // from class: c8.x7
            @Override // java.lang.Runnable
            public final void run() {
                this.f2916e.f2936l.setVisibility(8);
            }
        }).f();
        z8.l.b(this.f2934j, this.f2942r);
        return true;
    }

    public final void j() {
        int i10 = x7.p.J1;
        int i11 = x7.p.U0;
        int i12 = x7.p.H;
        int i13 = x7.p.C;
        int i14 = x7.p.K1;
        this.f2933e = (RelativeLayout) new h6.a(new RelativeLayout(getContext()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.f2934j = (FrameLayout) new h6.a(new FrameLayout(getContext()), new RelativeLayout.LayoutParams(-1, -1)).o(i12).g(32, i10).g(64, i11).c(true).l();
        this.f2935k = (ProgressBar) new h6.a(new ProgressBar(getContext(), null, R.attr.progressBarStyleHorizontal), new RelativeLayout.LayoutParams(-1, -2)).n(1, 3).g(32, i10).c(true).f(0).V(new a.InterfaceC0076a() { // from class: c8.r7
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                y7.d(this.f2805a, (ProgressBar) obj);
            }
        }).l();
        this.f2936l = new h6.a(new View(getContext()), new RelativeLayout.LayoutParams(-1, -1)).o(i14).g(144, i12).i(x7.u.f13991g6).e(new g6.g().h(g6.f.b(getContext(), x7.m.f13680j)).i(1887469696).a()).V(new a.InterfaceC0076a() { // from class: c8.s7
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                y7.g((View) obj);
            }
        }).l();
        this.f2937m = (FrameLayout) new h6.a(new FrameLayout(getContext()), new RelativeLayout.LayoutParams(-1, -1)).o(i13).g(32, i10).g(64, i11).l();
        this.f2938n = (LinearLayout) new h6.a(new LinearLayout(getContext()), new RelativeLayout.LayoutParams(-1, -2)).o(i10).V(new a.InterfaceC0076a() { // from class: c8.t7
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        this.f2939o = (LinearLayout) new h6.a(new LinearLayout(getContext()), new RelativeLayout.LayoutParams(-1, -2)).o(i11).h(128).f(g6.e.a(getContext(), x7.k.f13656b)).V(new a.InterfaceC0076a() { // from class: c8.u7
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        this.f2940p = (ImageView) new h6.a(new ImageView(getContext()), new RelativeLayout.LayoutParams(-2, -2)).m(g6.f.d(getContext(), x7.n.f13699r)).X(g6.f.d(getContext(), x7.n.f13701t)).F(1, 20).i(x7.u.sc).h(144).y(g6.f.d(getContext(), x7.n.f13700s)).d(x7.o.N1).V(new a.InterfaceC0076a() { // from class: c8.v7
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                y7.f(this.f2885a, (ImageView) obj);
            }
        }).l();
        this.f2933e.addView(this.f2934j);
        this.f2933e.addView(this.f2935k);
        this.f2933e.addView(this.f2936l);
        this.f2933e.addView(this.f2937m);
        this.f2933e.addView(this.f2938n);
        this.f2933e.addView(this.f2939o);
        this.f2933e.addView(this.f2940p);
        addView(this.f2933e);
        this.f2941q = new com.tuyafeng.support.widget.w(this.f2935k);
        x7.f.a().c(this.f2943s);
    }

    public void k(int i10, boolean z10) {
        Window windowW;
        this.f2943s.f(i10);
        if (z10 || this.f2942r == null || (windowW = g6.y.w(getContext())) == null) {
            return;
        }
        if (i10 == 0 && (i10 = pa.r.j().c0()) == -1) {
            i10 = x8.h.a(getContext());
        }
        windowW.setBackgroundDrawable(new ColorDrawable(i10));
    }

    public boolean l() {
        if (this.f2936l.getVisibility() == 0) {
            return false;
        }
        this.f2934j.setDescendantFocusability(393216);
        this.f2934j.clearFocus();
        x.r.c(this.f2936l).a(z8.l.c(this.f2934j, this.f2942r) ? 0.5f : 1.0f).d(getResources().getInteger(x7.q.f13865b)).j(new Runnable() { // from class: c8.w7
            @Override // java.lang.Runnable
            public final void run() {
                this.f2900e.f2936l.setVisibility(0);
            }
        }).f();
        return true;
    }

    public void m(boolean z10) {
        int i10 = z10 ? 0 : 1887469696;
        Drawable background = this.f2936l.getBackground();
        if ((background instanceof ColorDrawable) && ((ColorDrawable) background).getColor() == i10) {
            return;
        }
        this.f2936l.setBackgroundColor(i10);
    }

    public void n(boolean z10) {
        if (z10) {
            if (this.f2942r == null) {
                mark.via.common.widget.n1 n1Var = new mark.via.common.widget.n1(getContext());
                this.f2942r = n1Var;
                n1Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                addView(this.f2942r, 0);
            }
            if (this.f2943s != this.f2942r.getDrawable()) {
                k(this.f2943s.b(), false);
                this.f2943s = this.f2943s.a(x8.h.a(getContext()));
                x7.f.a().c(this.f2943s);
                this.f2942r.setImageDrawable(this.f2943s);
                ((mark.via.common.widget.n1) this.f2942r).b();
                pc.a.a("set view background", new Object[0]);
                return;
            }
            return;
        }
        ImageView imageView = this.f2942r;
        if (imageView != null) {
            g6.y.O(imageView, null);
            ViewGroup viewGroup = (ViewGroup) this.f2942r.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f2942r);
            }
            this.f2942r = null;
        }
        Window windowW = g6.y.w(getContext());
        if (windowW == null || this.f2943s == windowW.getDecorView().getBackground()) {
            return;
        }
        this.f2943s = this.f2943s.a(x8.h.a(getContext()));
        x7.f.a().c(this.f2943s);
        windowW.setBackgroundDrawable(this.f2943s);
        pc.a.a("set window background", new Object[0]);
    }

    public void setBlurEnabled(boolean z10) {
        z8.l.e(this, z10);
    }

    public void setNightModeEnabled(boolean z10) {
        this.f2935k.setProgressDrawable(x8.h.x(getContext()));
    }

    public void setProgress(int i10) {
        this.f2941q.f(i10);
    }

    public void setWindowBackgroundImage(Drawable drawable) {
        this.f2943s.e(drawable);
        ImageView imageView = this.f2942r;
        if (imageView instanceof mark.via.common.widget.n1) {
            ((mark.via.common.widget.n1) imageView).b();
        }
    }

    public void setWindowFilterColor(int i10) {
        this.f2943s.g(i10);
    }
}
