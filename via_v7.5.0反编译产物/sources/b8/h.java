package b8;

import android.content.Context;
import android.graphics.Canvas;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import mark.via.browser.q9;
import w7.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends t4.b implements r5.a.c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final r5.a f1787w;

    public h(Context context) {
        super(context);
        this.f1787w = new r5.a.b(this).e(TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics())).a();
    }

    @Override // r5.a.c
    public int a() {
        return super.computeVerticalScrollRange();
    }

    @Override // android.view.View
    public boolean awakenScrollBars() {
        return this.f1787w.c();
    }

    @Override // r5.a.c
    public void b(MotionEvent motionEvent) {
        l(motionEvent);
    }

    @Override // r5.a.c
    public int c() {
        return super.computeVerticalScrollExtent();
    }

    @Override // r5.a.c
    public int d() {
        return super.computeVerticalScrollOffset();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        r0.f fVar = (r0.f) getTag(p.H0);
        if (fVar != null) {
            q9.x(this, fVar, "via2");
            setTag(p.H0, null);
        }
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f1787w.e(canvas);
    }

    @Override // r5.a.c
    public r5.a getFastScrollDelegate() {
        return this.f1787w;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1787w.i();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f1787w.j();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f1787w.l(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // t4.b, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1787w.n(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        r5.a aVar = this.f1787w;
        if (aVar != null) {
            aVar.p(view, i10);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f1787w.q(i10);
    }

    public boolean r() {
        return this.f1787w.h();
    }

    @Override // r5.a.c
    public View getFastScrollableView() {
        return this;
    }
}
