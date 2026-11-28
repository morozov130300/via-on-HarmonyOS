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
public class c extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f6.a f5707c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f5708e = g.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f5709m = g.a();

    public c(f6.a aVar) {
        this.f5707c = aVar;
    }

    public final void a(TextPaint textPaint) {
        this.f5707c.b(textPaint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int width;
        this.f5709m.setStyle(Paint.Style.FILL);
        this.f5709m.setColor(this.f5707c.n(paint));
        if (i11 > 0) {
            width = canvas.getWidth();
        } else {
            i10 -= canvas.getWidth();
            width = i10;
        }
        this.f5708e.set(i10, i12, width, i14);
        canvas.drawRect(this.f5708e, this.f5709m);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return this.f5707c.o();
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
