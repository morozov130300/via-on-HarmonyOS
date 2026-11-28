package h6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f6.a f5711c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f5712e = g.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f5713m = g.a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f5714n;

    public f(f6.a aVar, int i10) {
        this.f5711c = aVar;
        this.f5714n = i10;
    }

    public final void a(TextPaint textPaint) {
        this.f5711c.e(textPaint, this.f5714n);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int width;
        int i17 = this.f5714n;
        if ((i17 == 1 || i17 == 2) && n6.c.a(i16, charSequence, this)) {
            this.f5713m.set(paint);
            this.f5711c.d(this.f5713m);
            float strokeWidth = this.f5713m.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i18 = (int) ((i14 - strokeWidth) + 0.5f);
                if (i11 > 0) {
                    width = canvas.getWidth();
                } else {
                    width = i10;
                    i10 -= canvas.getWidth();
                }
                this.f5712e.set(i10, i18, width, i14);
                canvas.drawRect(this.f5712e, this.f5713m);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return 0;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
