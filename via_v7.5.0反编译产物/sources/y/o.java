package y;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f14750c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewTreeObserver f14751e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f14752m;

    public o(View view, Runnable runnable) {
        this.f14750c = view;
        this.f14751e = view.getViewTreeObserver();
        this.f14752m = runnable;
    }

    public static o a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        o oVar = new o(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oVar);
        view.addOnAttachStateChangeListener(oVar);
        return oVar;
    }

    public void b() {
        if (this.f14751e.isAlive()) {
            this.f14751e.removeOnPreDrawListener(this);
        } else {
            this.f14750c.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f14750c.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f14752m.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f14751e = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
