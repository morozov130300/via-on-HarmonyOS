package com.tuyafeng.support.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProgressBar f3670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f3673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3674e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f3676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f3677c;

        public a(int i10, float f10, int i11) {
            this.f3675a = i10;
            this.f3676b = f10;
            this.f3677c = i11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b0.this.f3670a.setProgress((int) (this.f3675a + (Math.min(this.f3676b * fFloatValue, 1.0f) * (this.f3677c - this.f3675a)) + (fFloatValue * Math.abs(b0.this.f3672c - this.f3677c))));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3679a;

        public b(int i10) {
            this.f3679a = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            double d10 = this.f3679a;
            double dPow = Math.pow(fFloatValue, 2.0d);
            double dAbs = Math.abs(b0.this.f3672c - this.f3679a);
            Double.isNaN(dAbs);
            Double.isNaN(d10);
            b0.this.f3670a.setProgress((int) (d10 + (dPow * dAbs)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3682b;

        public c(int i10, int i11) {
            this.f3681a = i10;
            this.f3682b = i11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i10 = this.f3681a;
            b0.this.f3670a.setProgress((int) (i10 + (fFloatValue * (this.f3682b - i10))));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3684a;

        public d(int i10) {
            this.f3684a = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b0.this.f3670a.setProgress((int) (this.f3684a + ((b0.this.f3671b - this.f3684a) * fFloatValue)));
            b0.this.f3670a.setAlpha(1.0f - fFloatValue);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b0.this.f3670a.setVisibility(8);
            b0.this.f3670a.setProgress(0);
            b0.this.f3674e = 0;
        }
    }

    public b0(ProgressBar progressBar) {
        if (progressBar == null) {
            throw new NullPointerException("progressBar can not be null");
        }
        progressBar.setVisibility(8);
        this.f3670a = progressBar;
        this.f3674e = 0;
        int max = progressBar.getMax() * 10;
        this.f3671b = max;
        progressBar.setMax(max);
        this.f3672c = (max / 10) * 8;
    }

    public final void e(int i10, int i11, boolean z10) {
        if (i10 >= this.f3671b || i11 == 0 || Math.abs(i10 - i11) >= this.f3671b / 8) {
            ValueAnimator valueAnimator = this.f3673d;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.f3673d.cancel();
                this.f3670a.setAlpha(1.0f);
            }
            this.f3673d = ValueAnimator.ofFloat(0.0f, 1.0f);
            long jAbs = Math.abs(i11 - i10);
            int i12 = this.f3672c;
            if (i10 < i12) {
                if (z10 || i11 < i10) {
                    long jAbs2 = ((long) (Math.abs(i12 - i10) * 30)) + jAbs;
                    this.f3673d.addUpdateListener(new a(i11, jAbs2 / jAbs, i10));
                    jAbs = jAbs2;
                } else {
                    jAbs = Math.abs(i12 - i11) * 30;
                    this.f3673d.addUpdateListener(new b(i11));
                }
            } else if (i10 < this.f3671b) {
                this.f3673d.addUpdateListener(new c(i11, i10));
            } else {
                jAbs /= 2;
                this.f3673d.addUpdateListener(new d(i11));
                this.f3673d.addListener(new e());
            }
            this.f3673d.setInterpolator(new DecelerateInterpolator());
            this.f3673d.setDuration(jAbs);
            this.f3673d.start();
        }
    }

    public void f(int i10) {
        g(i10, false);
    }

    public void g(int i10, boolean z10) {
        int i11 = i10 * 10;
        if (this.f3674e == 0 && i11 < this.f3671b) {
            this.f3670a.setAlpha(1.0f);
            this.f3670a.setVisibility(0);
            this.f3674e = 1;
        }
        if (this.f3674e != 0) {
            e(i11, this.f3670a.getProgress(), z10);
        }
    }
}
