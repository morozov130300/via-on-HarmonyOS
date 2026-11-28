package mark.via.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v0 extends RecyclerView implements r5.a.c {
    public final r5.a U0;

    public v0(Context context) {
        super(context);
        this.U0 = new r5.a.b(this).d(true).a();
    }

    @Override // r5.a.c
    public int a() {
        return super.computeVerticalScrollRange();
    }

    @Override // android.view.View
    public boolean awakenScrollBars() {
        return this.U0.c();
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
        this.U0.e(canvas);
    }

    @Override // r5.a.c
    public r5.a getFastScrollDelegate() {
        return this.U0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.U0.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.U0.j();
        super.onDetachedFromWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.U0.l(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.U0.n(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        r5.a aVar = this.U0;
        if (aVar != null) {
            aVar.p(view, i10);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.U0.q(i10);
    }

    @Override // r5.a.c
    public View getFastScrollableView() {
        return this;
    }
}
