package mark.via.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m1 extends View {

    /* renamed from: e, reason: collision with root package name */
    public int f9693e;

    /* renamed from: j, reason: collision with root package name */
    public int f9694j;

    /* renamed from: k, reason: collision with root package name */
    public Paint f9695k;

    /* renamed from: l, reason: collision with root package name */
    public int f9696l;

    /* renamed from: m, reason: collision with root package name */
    public int f9697m;

    /* renamed from: n, reason: collision with root package name */
    public int f9698n;

    /* renamed from: o, reason: collision with root package name */
    public int f9699o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9700p;

    public m1(Context context) {
        this(context, null);
    }

    public m1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public m1(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9698n = 0;
        this.f9699o = 0;
        b();
    }

    public int a(float f10) {
        return (int) ((f10 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void b() {
        this.f9700p = g6.l.d(getContext());
        this.f9693e = g6.e.a(getContext(), x7.k.f13664j);
        this.f9694j = g6.f.b(getContext(), x7.m.f13680j);
        this.f9697m = a(4.0f);
        this.f9696l = a(2.0f);
        Paint paint = new Paint();
        this.f9695k = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f9695k.setAntiAlias(true);
    }

    public int getCurrentIndex() {
        return this.f9699o;
    }

    public int getIndicatorItemCount() {
        return this.f9698n;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9698n <= 1) {
            return;
        }
        float measuredHeight = ((getMeasuredHeight() + getPaddingTop()) - getPaddingBottom()) / 2.0f;
        int measuredWidth = (getMeasuredWidth() + getPaddingLeft()) - getPaddingRight();
        int i10 = this.f9698n;
        int i11 = 0;
        float fMax = (((measuredWidth - ((this.f9696l * i10) * 2)) - (Math.max(0, i10 - 1) * this.f9697m)) / 2.0f) + this.f9696l;
        int i12 = this.f9700p ? (this.f9698n - 1) - this.f9699o : this.f9699o;
        while (i11 < this.f9698n) {
            this.f9695k.setColor(i11 == i12 ? this.f9693e : this.f9694j);
            canvas.drawCircle(fMax, measuredHeight, this.f9696l, this.f9695k);
            fMax += this.f9697m + (this.f9696l * 2);
            i11++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            int i12 = this.f9696l * 2;
            int i13 = this.f9698n;
            size = (i12 * i13) + (Math.max(0, i13 - 1) * this.f9697m) + getPaddingLeft() + getPaddingRight();
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = (this.f9696l * 2) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    public void setCurrentIndex(int i10) {
        if (this.f9699o == i10) {
            return;
        }
        this.f9699o = i10;
        postInvalidate();
    }

    public void setIndicatorItemCount(int i10) {
        if (this.f9698n == i10) {
            return;
        }
        this.f9698n = i10;
        postInvalidate();
    }
}
