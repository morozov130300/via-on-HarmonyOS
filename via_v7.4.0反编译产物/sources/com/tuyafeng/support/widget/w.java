package com.tuyafeng.support.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public final ProgressBar f4373a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4374b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4375c;

    /* renamed from: d, reason: collision with root package name */
    public ValueAnimator f4376d;

    /* renamed from: e, reason: collision with root package name */
    public int f4377e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4378a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f4379b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f4380c;

        public a(int i10, float f10, int i11) {
            this.f4378a = i10;
            this.f4379b = f10;
            this.f4380c = i11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            w.this.f4373a.setProgress((int) (this.f4378a + (Math.min(this.f4379b * fFloatValue, 1.0f) * (this.f4380c - this.f4378a)) + (fFloatValue * Math.abs(w.this.f4375c - this.f4380c))));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4382a;

        public b(int i10) {
            this.f4382a = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            double d10 = this.f4382a;
            double dPow = Math.pow(fFloatValue, 2.0d);
            double dAbs = Math.abs(w.this.f4375c - this.f4382a);
            Double.isNaN(dAbs);
            Double.isNaN(d10);
            w.this.f4373a.setProgress((int) (d10 + (dPow * dAbs)));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4384a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4385b;

        public c(int i10, int i11) {
            this.f4384a = i10;
            this.f4385b = i11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            w.this.f4373a.setProgress((int) (this.f4384a + (fFloatValue * (this.f4385b - r0))));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4387a;

        public d(int i10) {
            this.f4387a = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            w.this.f4373a.setProgress((int) (this.f4387a + ((w.this.f4374b - this.f4387a) * fFloatValue)));
            w.this.f4373a.setAlpha(1.0f - fFloatValue);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w.this.f4373a.setVisibility(8);
            w.this.f4373a.setProgress(0);
            w.this.f4377e = 0;
        }
    }

    public w(ProgressBar progressBar) {
        if (progressBar == null) {
            throw new NullPointerException("progressBar can not be null");
        }
        progressBar.setVisibility(8);
        this.f4373a = progressBar;
        this.f4377e = 0;
        int max = progressBar.getMax() * 10;
        this.f4374b = max;
        progressBar.setMax(max);
        this.f4375c = (max / 10) * 8;
    }

    public final void e(int i10, int i11, boolean z10) {
        if (i10 >= this.f4374b || i11 == 0 || Math.abs(i10 - i11) >= this.f4374b / 8) {
            ValueAnimator valueAnimator = this.f4376d;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.f4376d.cancel();
                this.f4373a.setAlpha(1.0f);
            }
            this.f4376d = ValueAnimator.ofFloat(0.0f, 1.0f);
            long jAbs = Math.abs(i11 - i10);
            int i12 = this.f4375c;
            if (i10 < i12) {
                if (z10 || i11 < i10) {
                    long jAbs2 = (Math.abs(i12 - i10) * 30) + jAbs;
                    this.f4376d.addUpdateListener(new a(i11, jAbs2 / jAbs, i10));
                    jAbs = jAbs2;
                } else {
                    jAbs = Math.abs(i12 - i11) * 30;
                    this.f4376d.addUpdateListener(new b(i11));
                }
            } else if (i10 < this.f4374b) {
                this.f4376d.addUpdateListener(new c(i11, i10));
            } else {
                jAbs /= 2;
                this.f4376d.addUpdateListener(new d(i11));
                this.f4376d.addListener(new e());
            }
            this.f4376d.setInterpolator(new DecelerateInterpolator());
            this.f4376d.setDuration(jAbs);
            this.f4376d.start();
        }
    }

    public void f(int i10) {
        g(i10, false);
    }

    public void g(int i10, boolean z10) {
        int i11 = i10 * 10;
        if (this.f4377e == 0 && i11 < this.f4374b) {
            this.f4373a.setAlpha(1.0f);
            this.f4373a.setVisibility(0);
            this.f4377e = 1;
        }
        if (this.f4377e != 0) {
            e(i11, this.f4373a.getProgress(), z10);
        }
    }
}
