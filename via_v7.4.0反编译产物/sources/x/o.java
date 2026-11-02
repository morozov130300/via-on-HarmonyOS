package x;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: e, reason: collision with root package name */
    public final View f13506e;

    /* renamed from: j, reason: collision with root package name */
    public ViewTreeObserver f13507j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f13508k;

    public o(View view, Runnable runnable) {
        this.f13506e = view;
        this.f13507j = view.getViewTreeObserver();
        this.f13508k = runnable;
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
        if (this.f13507j.isAlive()) {
            this.f13507j.removeOnPreDrawListener(this);
        } else {
            this.f13506e.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f13506e.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f13508k.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f13507j = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
