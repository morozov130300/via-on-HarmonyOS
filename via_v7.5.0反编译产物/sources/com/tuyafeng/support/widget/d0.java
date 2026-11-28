package com.tuyafeng.support.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d0 extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3710c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3711e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3712m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b0.d f3713n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3714o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f3715p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f3716q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3717r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3718s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3719t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3720u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3721v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3722w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List f3723x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b f3724y;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(int i10, float f10);

        boolean b(int i10);

        void c(int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Fragment f3725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Fragment f3726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f3727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3728d = false;

        public b(Fragment fragment) {
            this.f3725a = fragment;
        }

        @Override // com.tuyafeng.support.widget.d0.a
        public void a(int i10, float f10) {
            if (this.f3728d) {
                return;
            }
            if (f10 >= 1.0f) {
                e();
                return;
            }
            View viewA1 = this.f3726b.a1();
            if (viewA1 == null) {
                return;
            }
            if (this.f3726b.o1()) {
                this.f3728d = true;
                f(viewA1);
            } else {
                if (viewA1.getVisibility() != 0) {
                    viewA1.setVisibility(0);
                }
                viewA1.setTranslationX(this.f3727c * (1.0f - f10));
            }
        }

        @Override // com.tuyafeng.support.widget.d0.a
        public boolean b(int i10) {
            Fragment fragment = this.f3725a;
            if (fragment != null && !FragmentUtils.e(fragment)) {
                Fragment fragment2 = this.f3726b;
                if (fragment2 != null) {
                    View viewA1 = fragment2.a1();
                    if (viewA1 != null && viewA1.getVisibility() != 0) {
                        viewA1.setTranslationX(this.f3727c);
                        viewA1.setVisibility(0);
                    }
                    return true;
                }
                List listA0 = this.f3725a.L0().A0();
                if (listA0.size() <= 1) {
                    return false;
                }
                for (int iIndexOf = listA0.indexOf(this.f3725a) - 1; iIndexOf >= 0; iIndexOf--) {
                    Fragment fragment3 = (Fragment) listA0.get(iIndexOf);
                    if (fragment3 != null && fragment3.a1() != null) {
                        fragment3.a1().setVisibility(0);
                        float dimension = fragment3.R0().getDimension(w7.n.f13762o);
                        this.f3727c = Math.copySign(Math.max(fragment3.a1().getWidth() * 0.3f, Math.abs(dimension)), dimension);
                        this.f3726b = fragment3;
                        break;
                    }
                }
                if (this.f3726b != null) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tuyafeng.support.widget.d0.a
        public void c(int i10) {
            Fragment fragment;
            if (this.f3728d || i10 != 0 || (fragment = this.f3726b) == null || fragment.a1() == null) {
                return;
            }
            if (this.f3726b.o1()) {
                f(this.f3726b.a1());
            } else {
                this.f3726b.a1().setVisibility(8);
                this.f3726b.a1().setTranslationX(0.0f);
            }
        }

        public final void e() {
            if (this.f3728d) {
                return;
            }
            this.f3728d = true;
            Fragment fragment = this.f3726b;
            if (fragment != null && fragment.a1() != null) {
                y.r.c(this.f3726b.a1()).b();
                this.f3726b.a1().setTranslationX(0.0f);
            }
            Fragment fragment2 = this.f3725a;
            if (fragment2 == null || fragment2.h1() || this.f3725a.L0().V0()) {
                return;
            }
            this.f3725a.L0().e1();
        }

        public final void f(View view) {
            if (view.getTranslationX() == 0.0f) {
                return;
            }
            y.r.c(view).g(0.0f).d(120L).e(new DecelerateInterpolator()).f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends b0.d.c {
        public c() {
        }

        @Override // b0.d.c
        public int a(View view, int i10, int i11) {
            if ((d0.this.f3720u & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i10, 0));
            }
            if ((d0.this.f3720u & 2) != 0) {
                return Math.min(0, Math.max(i10, -view.getWidth()));
            }
            return 0;
        }

        @Override // b0.d.c
        public int d(View view) {
            return 1;
        }

        @Override // b0.d.c
        public void h(int i10, int i11) {
            super.h(i10, i11);
            if ((d0.this.f3717r & i10) != 0) {
                d0.this.f3720u = i10;
                d0.this.f3719t = i11;
            }
        }

        @Override // b0.d.c
        public void j(int i10) {
            super.j(i10);
            if (i10 == 0) {
                d0.this.f3719t = -1;
            }
            d0.this.w(i10);
        }

        @Override // b0.d.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            super.k(view, i10, i11, i12, i13);
            if ((d0.this.f3720u & 1) != 0) {
                d0 d0Var = d0.this;
                d0Var.f3714o = Math.abs(i10 / d0Var.getWidth());
            } else if ((d0.this.f3720u & 2) != 0) {
                d0 d0Var2 = d0.this;
                d0Var2.f3714o = Math.abs(i10 / d0Var2.f3716q.getWidth());
            }
            d0.this.invalidate();
            d0 d0Var3 = d0.this;
            d0Var3.v(d0Var3.f3713n.u());
        }

        @Override // b0.d.c
        public void l(View view, float f10, float f11) {
            int i10 = 1;
            int i11 = d0.this.f3714o > d0.this.f3710c ? 1 : 0;
            if ((d0.this.f3720u & 1) != 0) {
                i11 |= (f10 <= 300.0f || f10 <= Math.abs(f11) || d0.this.f3714o <= (d0.this.f3710c * 2.0f) / 5.0f) ? 0 : 1;
            } else if ((d0.this.f3720u & 2) != 0) {
                i11 |= (f10 >= -300.0f || f10 >= (-Math.abs(f11)) || d0.this.f3714o <= (d0.this.f3710c * 2.0f) / 5.0f) ? 0 : 1;
                i10 = -1;
            } else {
                i10 = 0;
            }
            if (d0.this.f3713n.I(i11 != 0 ? i10 * (view.getWidth() + 10) : 0, view.getTop())) {
                y.r.P(d0.this);
            }
        }

        @Override // b0.d.c
        public boolean m(View view, int i10) {
            if (view.getTranslationX() != 0.0f || i10 != d0.this.f3719t || !d0.this.f3713n.w(d0.this.f3717r, i10)) {
                return false;
            }
            if ((d0.this.f3717r & 1) == 1 && d0.this.f3713n.w(1, i10)) {
                d0.this.f3720u = 1;
            } else if ((d0.this.f3717r & 2) == 2 && d0.this.f3713n.w(2, i10)) {
                d0.this.f3720u = 2;
            }
            d0 d0Var = d0.this;
            return d0Var.x(d0Var.f3720u);
        }
    }

    public d0(Context context) {
        this(context, null);
    }

    private void settlePredictiveBackWithDragHelper(boolean z10) {
        int left = this.f3716q.getLeft() + Math.round(this.f3716q.getTranslationX());
        this.f3716q.setTranslationX(0.0f);
        View view = this.f3716q;
        view.offsetLeftAndRight(left - view.getLeft());
        this.f3722w = false;
        int width = z10 ? this.f3716q.getWidth() + 10 : 0;
        b0.d dVar = this.f3713n;
        View view2 = this.f3716q;
        if (dVar.K(view2, width, view2.getTop())) {
            y.r.P(this);
        } else if (z10) {
            this.f3724y.e();
        } else {
            this.f3724y.c(0);
        }
    }

    public final void A() {
        int width = getWidth();
        int i10 = this.f3712m;
        if (i10 > 0) {
            this.f3713n.G(i10);
        } else if (i10 != -2 && i10 != -1) {
            this.f3713n.G((int) ((getResources().getDisplayMetrics().density * 20.0f) + 0.5f));
        } else if (width > 0) {
            this.f3713n.G(i10 == -2 ? width : width / 2);
        }
        float f10 = this.f3711e;
        if (f10 < 0.0f || width <= 0) {
            return;
        }
        this.f3710c = Math.min(f10 / width, 0.46f);
    }

    public void B(float f10) {
        if (!this.f3722w || this.f3716q == null) {
            return;
        }
        this.f3714o = Math.max(0.0f, Math.min(0.999f, f10));
        View view = this.f3716q;
        view.setTranslationX(view.getWidth() * this.f3714o);
        float f11 = this.f3714o;
        this.f3715p = 1.0f - f11;
        this.f3724y.a(1, f11);
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f3715p = Math.max(0.0f, Math.min(1.0f, 1.0f - this.f3714o));
        if (this.f3713n.k(true)) {
            y.r.P(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        if (this.f3721v == 0) {
            return super.drawChild(canvas, view, j10);
        }
        boolean z10 = view == this.f3716q;
        boolean zDrawChild = super.drawChild(canvas, view, j10);
        if (z10 && this.f3715p > 0.0f && (this.f3722w || this.f3713n.u() != 0)) {
            s(canvas, view);
        }
        return zDrawChild;
    }

    public void n(a aVar) {
        this.f3723x.add(aVar);
    }

    public void o(Fragment fragment, View view) {
        addView(view);
        this.f3716q = view;
        b bVar = new b(fragment);
        this.f3724y = bVar;
        n(bVar);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (this.f3722w || (!this.f3718s && this.f3713n.u() == 0)) ? super.onInterceptTouchEvent(motionEvent) : this.f3713n.J(motionEvent);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        A();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3722w || (!this.f3718s && this.f3713n.u() == 0)) {
            return super.onTouchEvent(motionEvent);
        }
        this.f3713n.A(motionEvent);
        return true;
    }

    public void p(View view) {
        addView(view);
        this.f3716q = view;
    }

    public void q() {
        if (!this.f3722w || this.f3716q == null) {
            return;
        }
        settlePredictiveBackWithDragHelper(false);
    }

    public void r() {
        if (this.f3722w) {
            settlePredictiveBackWithDragHelper(true);
        }
    }

    public final void s(Canvas canvas, View view) {
        int i10 = ((int) (this.f3721v * this.f3715p)) << 24;
        int iSave = canvas.save();
        float left = view.getLeft() + view.getTranslationX();
        float right = view.getRight() + view.getTranslationX();
        int i11 = this.f3720u;
        if ((i11 & 1) != 0) {
            canvas.clipRect(0.0f, 0.0f, left, getHeight());
        } else if ((i11 & 2) != 0) {
            canvas.clipRect(right, 0.0f, getRight(), getHeight());
        }
        canvas.drawColor(i10);
        canvas.restoreToCount(iSave);
    }

    public void setDimAmount(float f10) {
        if (f10 > 1.0f || f10 < 0.0f) {
            throw new IllegalArgumentException("DimAmount value should be between 0 and 1.0");
        }
        this.f3721v = (int) (f10 * 255.0f);
    }

    public void setEdgeOrientation(int i10) {
        this.f3717r = i10;
        this.f3713n.H(i10);
    }

    public void setEdgeSize(int i10) {
        this.f3712m = i10;
        A();
    }

    public void setGestureEnabled(boolean z10) {
        this.f3718s = z10;
    }

    public void setScrollThresholdPercent(float f10) {
        if (f10 >= 1.0f || f10 <= 0.0f) {
            throw new IllegalArgumentException("Threshold percent should be between 0 and 1.0");
        }
        this.f3710c = f10;
        this.f3711e = -1.0f;
    }

    public void setScrollThresholdSize(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Threshold size should be greater than 0");
        }
        this.f3711e = f10;
        A();
    }

    public final void t() {
        this.f3713n = b0.d.l(this, 0.18f, new c());
        setEdgeOrientation(com.tuyafeng.support.utils.l.d(getContext()) ? 2 : 1);
    }

    public boolean u() {
        return this.f3718s;
    }

    public final void v(int i10) {
        Iterator it = this.f3723x.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i10, this.f3714o);
        }
    }

    public final void w(int i10) {
        Iterator it = this.f3723x.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(i10);
        }
    }

    public final boolean x(int i10) {
        Iterator it = this.f3723x.iterator();
        while (it.hasNext()) {
            if (!((a) it.next()).b(i10)) {
                return false;
            }
        }
        return true;
    }

    public void y() {
        View view;
        if (!this.f3722w || (view = this.f3716q) == null) {
            return;
        }
        y.r.c(view).b();
        this.f3716q.setTranslationX(0.0f);
        this.f3714o = 0.0f;
        this.f3715p = 1.0f;
        this.f3722w = false;
        this.f3724y.c(0);
        invalidate();
    }

    public boolean z() {
        View view;
        if (this.f3724y == null || (view = this.f3716q) == null || this.f3722w || view.getTranslationX() != 0.0f || this.f3713n.u() != 0) {
            return false;
        }
        this.f3720u = 1;
        if (!this.f3724y.b(1)) {
            return false;
        }
        this.f3722w = true;
        B(0.0f);
        return true;
    }

    public d0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3710c = 0.46f;
        this.f3711e = -1.0f;
        this.f3712m = 0;
        this.f3718s = true;
        this.f3721v = 64;
        this.f3722w = false;
        this.f3723x = new ArrayList();
        t();
    }
}
