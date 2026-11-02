package q4;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import q4.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends ScrollView implements a.c {

    /* renamed from: e, reason: collision with root package name */
    public a f11328e;

    public b(Context context) {
        super(context);
        e(context);
    }

    @Override // q4.a.c
    public int a() {
        return super.computeVerticalScrollRange();
    }

    @Override // android.view.View
    public boolean awakenScrollBars() {
        return this.f11328e.c();
    }

    @Override // q4.a.c
    public void b(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
    }

    @Override // q4.a.c
    public int c() {
        return super.computeVerticalScrollExtent();
    }

    @Override // q4.a.c
    public int d() {
        return super.computeVerticalScrollOffset();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f11328e.e(canvas);
    }

    public final void e(Context context) {
        this.f11328e = new a.b(this).a();
    }

    @Override // q4.a.c
    public a getFastScrollDelegate() {
        return this.f11328e;
    }

    @Override // q4.a.c
    public View getFastScrollableView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11328e.i();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f11328e.l(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f11328e.n(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        a aVar = this.f11328e;
        if (aVar != null) {
            aVar.p(view, i10);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f11328e.q(i10);
    }

    public void setFastScrollDelegate(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("setNewFastScrollDelegate must NOT be NULL.");
        }
        this.f11328e.j();
        this.f11328e = aVar;
        aVar.i();
    }
}
