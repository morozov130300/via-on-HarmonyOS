package r5;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends ScrollView implements a.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f12041c;

    public b(Context context) {
        super(context);
        this.f12041c = new a.b(this).a();
    }

    @Override // r5.a.c
    public int a() {
        return super.computeVerticalScrollRange();
    }

    @Override // android.view.View
    public boolean awakenScrollBars() {
        return this.f12041c.c();
    }

    @Override // r5.a.c
    public void b(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
    }

    @Override // r5.a.c
    public int c() {
        return super.computeVerticalScrollExtent();
    }

    @Override // r5.a.c
    public int d() {
        return super.computeVerticalScrollOffset();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f12041c.e(canvas);
    }

    @Override // r5.a.c
    public a getFastScrollDelegate() {
        return this.f12041c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12041c.i();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f12041c.j();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f12041c.l(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12041c.n(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        a aVar = this.f12041c;
        if (aVar != null) {
            aVar.p(view, i10);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f12041c.q(i10);
    }

    @Override // r5.a.c
    public View getFastScrollableView() {
        return this;
    }
}
