package com.tuyafeng.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0.d f3631c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3632e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3633m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f3634n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3635o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3636p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3637q;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(float f10, boolean z10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends b0.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f3638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f3639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f3640c;

        public c() {
        }

        @Override // b0.d.c
        public int a(View view, int i10, int i11) {
            if (!a.this.i()) {
                return Math.max(a.this.getPaddingLeft() - a.this.f3632e, Math.min(a.this.getPaddingLeft() + a.this.f3632e, i10));
            }
            this.f3640c = Math.max((-a.this.f3632e) * this.f3638a, Math.min(a.this.f3632e * this.f3639b, this.f3640c + i11));
            int paddingLeft = a.this.getPaddingLeft();
            float f10 = this.f3640c;
            return paddingLeft + ((int) (f10 / (f10 < 0.0f ? this.f3638a : this.f3639b)));
        }

        @Override // b0.d.c
        public int d(View view) {
            return 1;
        }

        @Override // b0.d.c
        public void i(View view, int i10) {
            a aVar = a.this;
            this.f3638a = aVar.g(aVar.f3635o) ? 1.6f : 1.0f;
            a aVar2 = a.this;
            this.f3639b = aVar2.g(aVar2.f3635o ^ true) ? 1.6f : 1.0f;
            int left = view.getLeft() - a.this.getPaddingLeft();
            this.f3640c = left * (left < 0 ? this.f3638a : this.f3639b);
        }

        @Override // b0.d.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            super.k(view, i10, i11, i12, i13);
            a aVar = a.this;
            aVar.f3633m = ((i10 - aVar.getPaddingLeft()) / a.this.f3632e) / 0.8f;
            if (a.this.f3635o) {
                a aVar2 = a.this;
                aVar2.f3633m = -aVar2.f3633m;
            }
            if (a.this.f3634n != null && a.this.i()) {
                a.this.f3634n.a(a.this.f3633m, false);
            }
            a.this.invalidate();
        }

        @Override // b0.d.c
        public void l(View view, float f10, float f11) {
            if (a.this.f3634n != null) {
                a.this.f3634n.a(a.this.f3633m, true);
            }
            a.this.f3631c.I(a.this.getPaddingLeft(), a.this.getPaddingTop());
            a.this.invalidate();
        }

        @Override // b0.d.c
        public boolean m(View view, int i10) {
            return true;
        }
    }

    public a(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f3631c.k(true)) {
            y.r.P(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f3637q) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (actionMasked == 1) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean g(boolean z10) {
        return false;
    }

    public final void h() {
        this.f3635o = com.tuyafeng.support.utils.l.d(getContext());
        this.f3631c = b0.d.m(this, new c());
    }

    public boolean i() {
        return this.f3631c.u() == 1;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.f3636p ? super.onInterceptTouchEvent(motionEvent) : this.f3631c.J(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f3636p) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 3) {
            this.f3633m = 0.0f;
        }
        this.f3631c.A(motionEvent);
        return true;
    }

    public void setDragDistance(int i10) {
        this.f3632e = i10;
    }

    public void setDragListener(b bVar) {
        this.f3634n = bVar;
    }

    public void setDraggale(boolean z10) {
        this.f3636p = z10;
    }

    public void setInterceptTouchEvent(boolean z10) {
        this.f3637q = z10;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3632e = 300;
        this.f3635o = false;
        this.f3636p = true;
        this.f3637q = false;
        h();
    }
}
