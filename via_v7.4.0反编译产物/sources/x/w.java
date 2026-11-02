package x;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f13531a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f13532b = null;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f13533c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f13534d = -1;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {
        public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withEndAction(runnable);
        }

        public static ViewPropertyAnimator b(ViewPropertyAnimator viewPropertyAnimator) {
            return viewPropertyAnimator.withLayer();
        }

        public static ViewPropertyAnimator c(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withStartAction(runnable);
        }
    }

    public w(View view) {
        this.f13531a = new WeakReference(view);
    }

    public w a(float f10) {
        View view = (View) this.f13531a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void b() {
        View view = (View) this.f13531a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public w c(float f10) {
        View view = (View) this.f13531a.get();
        if (view != null) {
            view.animate().rotation(f10);
        }
        return this;
    }

    public w d(long j10) {
        View view = (View) this.f13531a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    public w e(Interpolator interpolator) {
        View view = (View) this.f13531a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public void f() {
        View view = (View) this.f13531a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public w g(float f10) {
        View view = (View) this.f13531a.get();
        if (view != null) {
            view.animate().translationX(f10);
        }
        return this;
    }

    public w h(float f10) {
        View view = (View) this.f13531a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }

    public w i(Runnable runnable) {
        View view = (View) this.f13531a.get();
        if (view != null) {
            a.a(view.animate(), runnable);
        }
        return this;
    }

    public w j(Runnable runnable) {
        View view = (View) this.f13531a.get();
        if (view != null) {
            a.c(view.animate(), runnable);
        }
        return this;
    }
}
