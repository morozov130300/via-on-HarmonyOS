package mark.via.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.widget.SeekBar;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w0 extends SeekBar {

    /* renamed from: e, reason: collision with root package name */
    public int f9792e;

    /* renamed from: j, reason: collision with root package name */
    public Paint f9793j;

    /* renamed from: k, reason: collision with root package name */
    public int f9794k;

    /* renamed from: l, reason: collision with root package name */
    public int f9795l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9796m;

    public w0(Context context) {
        super(context);
        this.f9792e = -1;
        a();
    }

    public final void a() {
        this.f9796m = g6.l.d(getContext());
        Paint paint = new Paint(1);
        this.f9793j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f9794k = g6.f.b(getContext(), x7.m.f13680j);
        this.f9795l = x8.h.j(getContext());
        this.f9793j.setColor(this.f9794k);
    }

    public int getHighlightProgress() {
        return this.f9792e;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        int max;
        int paddingLeft;
        try {
            int i10 = this.f9792e;
            if (i10 >= 0 && i10 <= getMax()) {
                this.f9793j.setColor(this.f9792e <= getProgress() ? this.f9795l : this.f9794k);
                if (this.f9796m) {
                    max = (int) (((getMax() - this.f9792e) / getMax()) * ((getWidth() - getPaddingLeft()) - getPaddingRight()));
                    paddingLeft = getPaddingLeft();
                } else {
                    max = (int) ((this.f9792e / getMax()) * ((getWidth() - getPaddingLeft()) - getPaddingRight()));
                    paddingLeft = getPaddingLeft();
                }
                int i11 = max + paddingLeft;
                Drawable thumb = getThumb();
                if (thumb == null || thumb.getIntrinsicWidth() <= 0) {
                    canvas.drawCircle(i11, getHeight() / 2.0f, g6.y.h(getContext(), 2.0f), this.f9793j);
                } else {
                    canvas.drawCircle(i11, getHeight() / 2.0f, thumb.getIntrinsicWidth() / 3.0f, this.f9793j);
                }
            }
            super.onDraw(canvas);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setHighlightProgress(int i10) {
        this.f9792e = i10;
        invalidate();
    }
}
