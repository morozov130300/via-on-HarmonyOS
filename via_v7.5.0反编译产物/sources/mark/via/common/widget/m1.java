package mark.via.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m1 extends View {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9984c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9985e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f9986m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9987n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9988o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9989p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9990q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f9991r;

    public m1(Context context) {
        this(context, null);
    }

    public int a(float f10) {
        return (int) ((f10 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void b() {
        this.f9991r = com.tuyafeng.support.utils.l.d(getContext());
        this.f9984c = com.tuyafeng.support.utils.e.a(getContext(), w7.k.f13731k);
        this.f9985e = com.tuyafeng.support.utils.f.b(getContext(), w7.m.f13746j);
        this.f9988o = a(4.0f);
        this.f9987n = a(2.0f);
        Paint paint = new Paint();
        this.f9986m = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f9986m.setAntiAlias(true);
    }

    public int getCurrentIndex() {
        return this.f9990q;
    }

    public int getIndicatorItemCount() {
        return this.f9989p;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9989p <= 1) {
            return;
        }
        float measuredHeight = ((getMeasuredHeight() + getPaddingTop()) - getPaddingBottom()) / 2.0f;
        int measuredWidth = (getMeasuredWidth() + getPaddingLeft()) - getPaddingRight();
        int i10 = this.f9989p;
        int i11 = 0;
        float fMax = (((measuredWidth - ((this.f9987n * i10) * 2)) - (Math.max(0, i10 - 1) * this.f9988o)) / 2.0f) + this.f9987n;
        int i12 = this.f9991r ? (this.f9989p - 1) - this.f9990q : this.f9990q;
        while (i11 < this.f9989p) {
            this.f9986m.setColor(i11 == i12 ? this.f9984c : this.f9985e);
            canvas.drawCircle(fMax, measuredHeight, this.f9987n, this.f9986m);
            fMax += this.f9988o + (this.f9987n * 2);
            i11++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            int i12 = this.f9987n * 2;
            int i13 = this.f9989p;
            size = (i12 * i13) + (Math.max(0, i13 - 1) * this.f9988o) + getPaddingLeft() + getPaddingRight();
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = (this.f9987n * 2) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    public void setCurrentIndex(int i10) {
        if (this.f9990q == i10) {
            return;
        }
        this.f9990q = i10;
        postInvalidate();
    }

    public void setIndicatorItemCount(int i10) {
        if (this.f9989p == i10) {
            return;
        }
        this.f9989p = i10;
        postInvalidate();
    }

    public m1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public m1(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9989p = 0;
        this.f9990q = 0;
        b();
    }
}
