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
public class c extends MetricAffectingSpan implements LeadingMarginSpan {

    /* renamed from: e, reason: collision with root package name */
    public final l6.a f10208e;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f10209j = g.b();

    /* renamed from: k, reason: collision with root package name */
    public final Paint f10210k = g.a();

    public c(l6.a aVar) {
        this.f10208e = aVar;
    }

    public final void a(TextPaint textPaint) {
        this.f10208e.b(textPaint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int width;
        this.f10210k.setStyle(Paint.Style.FILL);
        this.f10210k.setColor(this.f10208e.n(paint));
        if (i11 > 0) {
            width = canvas.getWidth();
        } else {
            i10 -= canvas.getWidth();
            width = i10;
        }
        this.f10209j.set(i10, i12, width, i14);
        canvas.drawRect(this.f10209j, this.f10210k);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return this.f10208e.o();
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
