package com.tuyafeng.support.widget;

import a0.d;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public float f4394e;

    /* renamed from: j, reason: collision with root package name */
    public a0.d f4395j;

    /* renamed from: k, reason: collision with root package name */
    public float f4396k;

    /* renamed from: l, reason: collision with root package name */
    public float f4397l;

    /* renamed from: m, reason: collision with root package name */
    public View f4398m;

    /* renamed from: n, reason: collision with root package name */
    public int f4399n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4400o;

    /* renamed from: p, reason: collision with root package name */
    public int f4401p;

    /* renamed from: q, reason: collision with root package name */
    public int f4402q;

    /* renamed from: r, reason: collision with root package name */
    public int f4403r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4404s;

    /* renamed from: t, reason: collision with root package name */
    public final List f4405t;

    /* renamed from: u, reason: collision with root package name */
    public b f4406u;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(int i10, float f10);

        boolean b(int i10);

        void c(int i10);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final Fragment f4407a;

        /* renamed from: b, reason: collision with root package name */
        public Fragment f4408b;

        /* renamed from: c, reason: collision with root package name */
        public float f4409c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f4410d = false;

        public b(Fragment fragment) {
            this.f4407a = fragment;
        }

        @Override // com.tuyafeng.support.widget.y.a
        public void a(int i10, float f10) {
            if (this.f4410d) {
                return;
            }
            if (f10 >= 1.0f) {
                e();
                return;
            }
            View viewC1 = this.f4408b.c1();
            if (viewC1 == null) {
                return;
            }
            if (this.f4408b.q1()) {
                this.f4410d = true;
                f(viewC1);
            } else {
                if (viewC1.getVisibility() != 0) {
                    viewC1.setVisibility(0);
                }
                viewC1.setTranslationX(this.f4409c * (1.0f - f10));
            }
        }

        @Override // com.tuyafeng.support.widget.y.a
        public boolean b(int i10) throws Resources.NotFoundException {
            Fragment fragment = this.f4407a;
            if (fragment != null && !g6.i.d(fragment)) {
                Fragment fragment2 = this.f4408b;
                if (fragment2 != null) {
                    View viewC1 = fragment2.c1();
                    if (viewC1 != null && viewC1.getVisibility() != 0) {
                        viewC1.setTranslationX(this.f4409c);
                        viewC1.setVisibility(0);
                    }
                    return true;
                }
                List listA0 = this.f4407a.N0().A0();
                if (listA0.size() <= 1) {
                    return false;
                }
                int iIndexOf = listA0.indexOf(this.f4407a) - 1;
                while (true) {
                    if (iIndexOf >= 0) {
                        Fragment fragment3 = (Fragment) listA0.get(iIndexOf);
                        if (fragment3 != null && fragment3.c1() != null) {
                            fragment3.c1().setVisibility(0);
                            float dimension = fragment3.T0().getDimension(x7.n.f13696o);
                            this.f4409c = Math.copySign(Math.max(fragment3.c1().getWidth() * 0.3f, Math.abs(dimension)), dimension);
                            this.f4408b = fragment3;
                            break;
                        }
                        iIndexOf--;
                    } else {
                        break;
                    }
                }
                if (this.f4408b != null) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tuyafeng.support.widget.y.a
        public void c(int i10) {
            Fragment fragment;
            if (this.f4410d || i10 != 0 || (fragment = this.f4408b) == null || fragment.c1() == null) {
                return;
            }
            if (this.f4408b.q1()) {
                f(this.f4408b.c1());
            } else {
                this.f4408b.c1().setVisibility(8);
                this.f4408b.c1().setTranslationX(0.0f);
            }
        }

        public final void e() {
            if (this.f4410d) {
                return;
            }
            this.f4410d = true;
            Fragment fragment = this.f4408b;
            if (fragment != null && fragment.c1() != null) {
                x.r.c(this.f4408b.c1()).b();
                this.f4408b.c1().setTranslationX(0.0f);
            }
            Fragment fragment2 = this.f4407a;
            if (fragment2 == null || fragment2.j1() || this.f4407a.N0().V0()) {
                return;
            }
            this.f4407a.N0().e1();
        }

        public final void f(View view) {
            if (view.getTranslationX() == 0.0f) {
                return;
            }
            x.r.c(view).g(0.0f).d(120L).e(new DecelerateInterpolator()).f();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends d.c {
        public c() {
        }

        @Override // a0.d.c
        public int a(View view, int i10, int i11) {
            if ((y.this.f4402q & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i10, 0));
            }
            if ((y.this.f4402q & 2) != 0) {
                return Math.min(0, Math.max(i10, -view.getWidth()));
            }
            return 0;
        }

        @Override // a0.d.c
        public int d(View view) {
            return 1;
        }

        @Override // a0.d.c
        public void h(int i10, int i11) {
            super.h(i10, i11);
            if ((y.this.f4399n & i10) != 0) {
                y.this.f4402q = i10;
                y.this.f4401p = i11;
            }
        }

        @Override // a0.d.c
        public void j(int i10) {
            super.j(i10);
            if (i10 == 0) {
                y.this.f4401p = -1;
            }
            y.this.w(i10);
        }

        @Override // a0.d.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            super.k(view, i10, i11, i12, i13);
            if ((y.this.f4402q & 1) != 0) {
                y.this.f4396k = Math.abs(i10 / r3.getWidth());
            } else if ((y.this.f4402q & 2) != 0) {
                y.this.f4396k = Math.abs(i10 / r3.f4398m.getWidth());
            }
            y.this.invalidate();
            y yVar = y.this;
            yVar.v(yVar.f4395j.u());
        }

        @Override // a0.d.c
        public void l(View view, float f10, float f11) {
            int i10 = y.this.f4396k > y.this.f4394e ? 1 : 0;
            if ((y.this.f4402q & 1) != 0) {
                i10 |= (f10 <= 300.0f || f10 <= Math.abs(f11) || y.this.f4396k <= (y.this.f4394e * 2.0f) / 5.0f) ? 0 : 1;
            } else if ((y.this.f4402q & 2) != 0) {
                i10 |= (f10 >= -300.0f || f10 >= (-Math.abs(f11)) || y.this.f4396k <= (y.this.f4394e * 2.0f) / 5.0f) ? 0 : 1;
                i = -1;
            } else {
                i = 0;
            }
            if (y.this.f4395j.I(i10 != 0 ? i * (view.getWidth() + 10) : 0, view.getTop())) {
                x.r.O(y.this);
            }
        }

        @Override // a0.d.c
        public boolean m(View view, int i10) {
            if (view.getTranslationX() != 0.0f || i10 != y.this.f4401p || !y.this.f4395j.w(y.this.f4399n, i10)) {
                return false;
            }
            if ((y.this.f4399n & 1) == 1 && y.this.f4395j.w(1, i10)) {
                y.this.f4402q = 1;
            } else if ((y.this.f4399n & 2) == 2 && y.this.f4395j.w(2, i10)) {
                y.this.f4402q = 2;
            }
            y yVar = y.this;
            return yVar.x(yVar.f4402q);
        }
    }

    public y(Context context) {
        this(context, null);
    }

    public y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public y(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4394e = 0.46f;
        this.f4400o = true;
        this.f4403r = 64;
        this.f4404s = false;
        this.f4405t = new ArrayList();
        t();
    }

    private void settlePredictiveBackWithDragHelper(boolean z10) {
        int left = this.f4398m.getLeft() + Math.round(this.f4398m.getTranslationX());
        this.f4398m.setTranslationX(0.0f);
        View view = this.f4398m;
        view.offsetLeftAndRight(left - view.getLeft());
        this.f4404s = false;
        int width = z10 ? this.f4398m.getWidth() + 10 : 0;
        a0.d dVar = this.f4395j;
        View view2 = this.f4398m;
        if (dVar.K(view2, width, view2.getTop())) {
            x.r.O(this);
        } else if (z10) {
            this.f4406u.e();
        } else {
            this.f4406u.c(0);
        }
    }

    public void A(float f10) {
        if (!this.f4404s || this.f4398m == null) {
            return;
        }
        this.f4396k = Math.max(0.0f, Math.min(0.999f, f10));
        this.f4398m.setTranslationX(r3.getWidth() * this.f4396k);
        float f11 = this.f4396k;
        this.f4397l = 1.0f - f11;
        this.f4406u.a(1, f11);
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f4397l = Math.max(0.0f, Math.min(1.0f, 1.0f - this.f4396k));
        if (this.f4395j.k(true)) {
            x.r.O(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        if (this.f4403r == 0) {
            return super.drawChild(canvas, view, j10);
        }
        boolean z10 = view == this.f4398m;
        boolean zDrawChild = super.drawChild(canvas, view, j10);
        if (z10 && this.f4397l > 0.0f && (this.f4404s || this.f4395j.u() != 0)) {
            s(canvas, view);
        }
        return zDrawChild;
    }

    public void n(a aVar) {
        this.f4405t.add(aVar);
    }

    public void o(Fragment fragment, View view) {
        addView(view);
        this.f4398m = view;
        b bVar = new b(fragment);
        this.f4406u = bVar;
        n(bVar);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (this.f4404s || (!this.f4400o && this.f4395j.u() == 0)) ? super.onInterceptTouchEvent(motionEvent) : this.f4395j.J(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4404s || (!this.f4400o && this.f4395j.u() == 0)) {
            return super.onTouchEvent(motionEvent);
        }
        this.f4395j.A(motionEvent);
        return true;
    }

    public void p(View view) {
        addView(view);
        this.f4398m = view;
    }

    public void q() {
        if (!this.f4404s || this.f4398m == null) {
            return;
        }
        settlePredictiveBackWithDragHelper(false);
    }

    public void r() {
        if (this.f4404s) {
            settlePredictiveBackWithDragHelper(true);
        }
    }

    public final void s(Canvas canvas, View view) {
        int i10 = ((int) (this.f4403r * this.f4397l)) << 24;
        int iSave = canvas.save();
        float left = view.getLeft() + view.getTranslationX();
        float right = view.getRight() + view.getTranslationX();
        int i11 = this.f4402q;
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
        this.f4403r = (int) (f10 * 255.0f);
    }

    public void setEdgeOrientation(int i10) {
        this.f4399n = i10;
        this.f4395j.H(i10);
    }

    public void setEdgeSize(int i10) {
        if (i10 > 0) {
            this.f4395j.G(i10);
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i10 == -2) {
            this.f4395j.G(displayMetrics.widthPixels);
        } else if (i10 == -1) {
            this.f4395j.G(displayMetrics.widthPixels / 2);
        } else {
            this.f4395j.G((int) ((displayMetrics.density * 20.0f) + 0.5f));
        }
    }

    public void setGestureEnabled(boolean z10) {
        this.f4400o = z10;
    }

    public void setScrollThresholdPercent(float f10) {
        if (f10 >= 1.0f || f10 <= 0.0f) {
            throw new IllegalArgumentException("Threshold percent should be between 0 and 1.0");
        }
        this.f4394e = f10;
    }

    public void setScrollThresholdSize(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Threshold size should be greater than 0");
        }
        this.f4394e = Math.min(f10 / getResources().getDisplayMetrics().widthPixels, 0.46f);
    }

    public final void t() {
        this.f4395j = a0.d.l(this, 0.18f, new c());
        setEdgeOrientation(g6.l.d(getContext()) ? 2 : 1);
    }

    public boolean u() {
        return this.f4400o;
    }

    public final void v(int i10) {
        Iterator it = this.f4405t.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i10, this.f4396k);
        }
    }

    public final void w(int i10) {
        Iterator it = this.f4405t.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(i10);
        }
    }

    public final boolean x(int i10) {
        Iterator it = this.f4405t.iterator();
        while (it.hasNext()) {
            if (!((a) it.next()).b(i10)) {
                return false;
            }
        }
        return true;
    }

    public void y() {
        View view;
        if (!this.f4404s || (view = this.f4398m) == null) {
            return;
        }
        x.r.c(view).b();
        this.f4398m.setTranslationX(0.0f);
        this.f4396k = 0.0f;
        this.f4397l = 1.0f;
        this.f4404s = false;
        this.f4406u.c(0);
        invalidate();
    }

    public boolean z() {
        View view;
        if (this.f4406u == null || (view = this.f4398m) == null || this.f4404s || view.getTranslationX() != 0.0f || this.f4395j.u() != 0) {
            return false;
        }
        this.f4402q = 1;
        if (!this.f4406u.b(1)) {
            return false;
        }
        this.f4404s = true;
        A(0.0f);
        return true;
    }
}
