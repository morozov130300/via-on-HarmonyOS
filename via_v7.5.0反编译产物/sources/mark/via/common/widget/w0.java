package mark.via.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.widget.SeekBar;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w0 extends SeekBar {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10095c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f10096e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10097m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10098n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10099o;

    public w0(Context context) {
        super(context);
        this.f10095c = -1;
        a();
    }

    public final void a() {
        this.f10099o = com.tuyafeng.support.utils.l.d(getContext());
        Paint paint = new Paint(1);
        this.f10096e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f10097m = com.tuyafeng.support.utils.f.b(getContext(), w7.m.f13746j);
        this.f10098n = v8.h.j(getContext());
        this.f10096e.setColor(this.f10097m);
    }

    public int getHighlightProgress() {
        return this.f10095c;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        int max;
        int paddingLeft;
        try {
            int i10 = this.f10095c;
            if (i10 >= 0 && i10 <= getMax()) {
                this.f10096e.setColor(this.f10095c <= getProgress() ? this.f10098n : this.f10097m);
                if (this.f10099o) {
                    max = (int) (((getMax() - this.f10095c) / getMax()) * ((getWidth() - getPaddingLeft()) - getPaddingRight()));
                    paddingLeft = getPaddingLeft();
                } else {
                    max = (int) ((this.f10095c / getMax()) * ((getWidth() - getPaddingLeft()) - getPaddingRight()));
                    paddingLeft = getPaddingLeft();
                }
                int i11 = max + paddingLeft;
                Drawable thumb = getThumb();
                if (thumb == null || thumb.getIntrinsicWidth() <= 0) {
                    canvas.drawCircle(i11, getHeight() / 2.0f, com.tuyafeng.support.utils.x.h(getContext(), 2.0f), this.f10096e);
                } else {
                    canvas.drawCircle(i11, getHeight() / 2.0f, thumb.getIntrinsicWidth() / 3.0f, this.f10096e);
                }
            }
            super.onDraw(canvas);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setHighlightProgress(int i10) {
        this.f10095c = i10;
        invalidate();
    }
}
