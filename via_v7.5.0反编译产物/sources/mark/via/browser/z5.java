package mark.via.browser;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class z5 extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RelativeLayout f9811c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f9812e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ProgressBar f9813m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f9814n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FrameLayout f9815o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LinearLayout f9816p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinearLayout f9817q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f9818r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.tuyafeng.support.widget.b0 f9819s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImageView f9820t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public e f9821u;

    public z5(Context context) {
        super(context);
        this.f9821u = new e();
        j();
    }

    public static /* synthetic */ void d(z5 z5Var, ProgressBar progressBar) {
        z5Var.getClass();
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.setIndeterminate(false);
        progressBar.setVisibility(8);
        progressBar.setProgressDrawable(v8.h.w(z5Var.getContext()));
    }

    public static /* synthetic */ void f(z5 z5Var, ImageView imageView) {
        z5Var.getClass();
        imageView.setVisibility(4);
        com.tuyafeng.support.utils.x.T(-1, imageView);
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setElevation(com.tuyafeng.support.utils.x.h(z5Var.getContext(), 12.0f));
        }
    }

    public static /* synthetic */ void g(View view) {
        view.setAlpha(0.0f);
        view.setVisibility(8);
    }

    public boolean h() {
        return this.f9821u.c();
    }

    public boolean i() {
        if (this.f9814n.getVisibility() == 8) {
            return false;
        }
        this.f9812e.setDescendantFocusability(262144);
        y.r.c(this.f9814n).a(0.0f).d(getResources().getInteger(w7.q.f13931b)).i(new Runnable() { // from class: mark.via.browser.y5
            @Override // java.lang.Runnable
            public final void run() {
                this.f9779c.f9814n.setVisibility(8);
            }
        }).f();
        x8.l.b(this.f9812e, this.f9820t);
        return true;
    }

    public final void j() {
        int i10 = w7.p.I1;
        int i11 = w7.p.U0;
        int i12 = w7.p.G;
        int i13 = w7.p.B;
        int i14 = w7.p.J1;
        this.f9811c = (RelativeLayout) new b6.a(new RelativeLayout(getContext()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.f9812e = (FrameLayout) new b6.a(new FrameLayout(getContext()), new RelativeLayout.LayoutParams(-1, -1)).o(i12).g(32, i10).g(64, i11).c(true).l();
        this.f9813m = (ProgressBar) new b6.a(new ProgressBar(getContext(), null, R.attr.progressBarStyleHorizontal), new RelativeLayout.LayoutParams(-1, -2)).n(1, 3).g(32, i10).c(true).f(0).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.s5
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                z5.d(this.f9638a, (ProgressBar) obj);
            }
        }).l();
        this.f9814n = new b6.a(new View(getContext()), new RelativeLayout.LayoutParams(-1, -1)).o(i14).g(32, i10).g(64, i11).c(true).i(w7.u.f14225s6).e(new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.f.b(getContext(), w7.m.f13746j)).i(1887469696).a()).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.t5
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                z5.g((View) obj);
            }
        }).l();
        this.f9815o = (FrameLayout) new b6.a(new FrameLayout(getContext()), new RelativeLayout.LayoutParams(-1, -1)).o(i13).g(32, i10).g(64, i11).l();
        this.f9816p = (LinearLayout) new b6.a(new LinearLayout(getContext()), new RelativeLayout.LayoutParams(-1, -2)).o(i10).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.u5
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        this.f9817q = (LinearLayout) new b6.a(new LinearLayout(getContext()), new RelativeLayout.LayoutParams(-1, -2)).o(i11).h(128).f(com.tuyafeng.support.utils.e.a(getContext(), w7.k.f13723c)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.v5
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        this.f9818r = (ImageView) new b6.a(new ImageView(getContext()), new RelativeLayout.LayoutParams(-2, -2)).m(com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13765r)).X(com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13767t)).F(1, 20).i(w7.u.Gc).h(144).y(com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13766s)).d(w7.o.K1).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.w5
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                z5.f(this.f9729a, (ImageView) obj);
            }
        }).l();
        this.f9811c.addView(this.f9812e);
        this.f9811c.addView(this.f9813m);
        this.f9811c.addView(this.f9814n);
        this.f9811c.addView(this.f9815o);
        this.f9811c.addView(this.f9816p);
        this.f9811c.addView(this.f9817q);
        this.f9811c.addView(this.f9818r);
        addView(this.f9811c);
        this.f9819s = new com.tuyafeng.support.widget.b0(this.f9813m);
        w7.f.a().c(this.f9821u);
    }

    public void k(int i10, boolean z10) {
        Window windowW;
        this.f9821u.f(i10);
        if (z10 || this.f9820t == null || (windowW = com.tuyafeng.support.utils.x.w(getContext())) == null) {
            return;
        }
        if (i10 == 0 && (i10 = la.s.j().f0()) == -1) {
            i10 = v8.h.a(getContext());
        }
        windowW.setBackgroundDrawable(new ColorDrawable(i10));
    }

    public boolean l() {
        if (this.f9814n.getVisibility() == 0) {
            return false;
        }
        this.f9812e.setDescendantFocusability(393216);
        this.f9812e.clearFocus();
        y.r.c(this.f9814n).a(x8.l.c(this.f9812e, this.f9820t) ? 0.5f : 1.0f).d(getResources().getInteger(w7.q.f13931b)).j(new Runnable() { // from class: mark.via.browser.x5
            @Override // java.lang.Runnable
            public final void run() {
                this.f9750c.f9814n.setVisibility(0);
            }
        }).f();
        return true;
    }

    public void m(boolean z10) {
        int i10 = z10 ? 0 : 1887469696;
        Drawable background = this.f9814n.getBackground();
        if ((background instanceof ColorDrawable) && ((ColorDrawable) background).getColor() == i10) {
            return;
        }
        this.f9814n.setBackgroundColor(i10);
    }

    public void n(boolean z10) {
        if (z10) {
            if (this.f9820t == null) {
                mark.via.common.widget.q1 q1Var = new mark.via.common.widget.q1(getContext());
                this.f9820t = q1Var;
                q1Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                addView(this.f9820t, 0);
            }
            if (this.f9821u != this.f9820t.getDrawable()) {
                k(this.f9821u.b(), false);
                this.f9821u = this.f9821u.a(v8.h.a(getContext()));
                w7.f.a().c(this.f9821u);
                this.f9820t.setImageDrawable(this.f9821u);
                ((mark.via.common.widget.q1) this.f9820t).b();
                tc.a.a("set view background", new Object[0]);
                return;
            }
            return;
        }
        ImageView imageView = this.f9820t;
        if (imageView != null) {
            com.tuyafeng.support.utils.x.P(imageView, null);
            ViewGroup viewGroup = (ViewGroup) this.f9820t.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f9820t);
            }
            this.f9820t = null;
        }
        Window windowW = com.tuyafeng.support.utils.x.w(getContext());
        if (windowW == null || this.f9821u == windowW.getDecorView().getBackground()) {
            return;
        }
        this.f9821u = this.f9821u.a(v8.h.a(getContext()));
        w7.f.a().c(this.f9821u);
        windowW.setBackgroundDrawable(this.f9821u);
        tc.a.a("set window background", new Object[0]);
    }

    public void setBlurEnabled(boolean z10) {
        x8.l.e(this, z10);
    }

    public void setNightModeEnabled(boolean z10) {
        this.f9813m.setProgressDrawable(v8.h.w(getContext()));
    }

    public void setProgress(int i10) {
        this.f9819s.f(i10);
    }

    public void setWindowBackgroundImage(Drawable drawable) {
        this.f9821u.e(drawable);
        ImageView imageView = this.f9820t;
        if (imageView instanceof mark.via.common.widget.q1) {
            ((mark.via.common.widget.q1) imageView).b();
        }
    }

    public void setWindowFilterColor(int i10) {
        this.f9821u.g(i10);
    }
}
