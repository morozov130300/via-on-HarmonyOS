package com.tuyafeng.support.widget;

import a0.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public a0.d f4298e;

    /* renamed from: j, reason: collision with root package name */
    public int f4299j;

    /* renamed from: k, reason: collision with root package name */
    public float f4300k;

    /* renamed from: l, reason: collision with root package name */
    public List f4301l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4302m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4303n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4304o;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(float f10, boolean z10);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends d.c {
        public c() {
        }

        @Override // a0.d.c
        public int a(View view, int i10, int i11) {
            return i10 - a.this.getPaddingLeft() > a.this.f4299j ? a.this.f4299j + a.this.getPaddingLeft() : Math.max(i10, a.this.getPaddingLeft() - a.this.f4299j);
        }

        @Override // a0.d.c
        public int d(View view) {
            return 1;
        }

        @Override // a0.d.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            super.k(view, i10, i11, i12, i13);
            a.this.f4300k = (i10 - r3.getPaddingLeft()) / a.this.f4299j;
            n(a.this.f4300k, false);
            a.this.invalidate();
        }

        @Override // a0.d.c
        public void l(View view, float f10, float f11) {
            n(a.this.f4300k, true);
            a.this.f4298e.I(a.this.getPaddingLeft(), a.this.getPaddingTop());
            a.this.invalidate();
        }

        @Override // a0.d.c
        public boolean m(View view, int i10) {
            return true;
        }

        public final void n(float f10, boolean z10) {
            if (a.this.f4301l == null || a.this.f4301l.isEmpty()) {
                return;
            }
            if (a.this.f4302m) {
                f10 = -f10;
            }
            for (b bVar : a.this.f4301l) {
                if (bVar != null) {
                    bVar.a(f10, z10);
                }
            }
        }
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4299j = 300;
        this.f4300k = 0.0f;
        this.f4302m = false;
        this.f4303n = true;
        this.f4304o = false;
        h();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f4298e.k(true)) {
            x.r.O(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f4304o) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (actionMasked == 1) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void g(b bVar) {
        if (this.f4301l == null) {
            this.f4301l = new ArrayList();
        }
        this.f4301l.add(bVar);
    }

    public final void h() {
        this.f4302m = g6.l.d(getContext());
        this.f4298e = a0.d.m(this, new c());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.f4303n ? super.onInterceptTouchEvent(motionEvent) : this.f4298e.J(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f4303n) {
            return super.onTouchEvent(motionEvent);
        }
        this.f4298e.A(motionEvent);
        return true;
    }

    public void setDragDistance(int i10) {
        this.f4299j = i10;
    }

    public void setDraggale(boolean z10) {
        this.f4303n = z10;
    }

    public void setInterceptTouchEvent(boolean z10) {
        this.f4304o = z10;
    }
}
