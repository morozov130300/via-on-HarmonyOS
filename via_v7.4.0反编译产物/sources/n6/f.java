package n6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f extends MetricAffectingSpan implements LeadingMarginSpan {

    /* renamed from: e, reason: collision with root package name */
    public final l6.a f10212e;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f10213j = g.b();

    /* renamed from: k, reason: collision with root package name */
    public final Paint f10214k = g.a();

    /* renamed from: l, reason: collision with root package name */
    public final int f10215l;

    public f(l6.a aVar, int i10) {
        this.f10212e = aVar;
        this.f10215l = i10;
    }

    public final void a(TextPaint textPaint) {
        this.f10212e.e(textPaint, this.f10215l);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int width;
        int i17 = this.f10215l;
        if ((i17 == 1 || i17 == 2) && t6.c.a(i16, charSequence, this)) {
            this.f10214k.set(paint);
            this.f10212e.d(this.f10214k);
            float strokeWidth = this.f10214k.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i18 = (int) ((i14 - strokeWidth) + 0.5f);
                if (i11 > 0) {
                    width = canvas.getWidth();
                } else {
                    width = i10;
                    i10 -= canvas.getWidth();
                }
                this.f10213j.set(i10, i18, width, i14);
                canvas.drawRect(this.f10213j, this.f10214k);
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
