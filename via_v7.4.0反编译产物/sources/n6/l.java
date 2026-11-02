package n6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l implements LeadingMarginSpan {

    /* renamed from: e, reason: collision with root package name */
    public final l6.a f10224e;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f10225j = g.b();

    /* renamed from: k, reason: collision with root package name */
    public final Paint f10226k = g.a();

    public l(l6.a aVar) {
        this.f10224e = aVar;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int width;
        int i17 = i12 + ((i14 - i12) / 2);
        this.f10226k.set(paint);
        this.f10224e.h(this.f10226k);
        int strokeWidth = (int) ((((int) (this.f10226k.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
        if (i11 > 0) {
            width = canvas.getWidth();
        } else {
            width = i10;
            i10 -= canvas.getWidth();
        }
        this.f10225j.set(i10, i17 - strokeWidth, width, i17 + strokeWidth);
        canvas.drawRect(this.f10225j, this.f10226k);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return 0;
    }
}
