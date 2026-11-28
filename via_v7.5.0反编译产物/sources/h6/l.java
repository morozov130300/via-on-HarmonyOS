package h6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l implements LeadingMarginSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f6.a f5723c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f5724e = g.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f5725m = g.a();

    public l(f6.a aVar) {
        this.f5723c = aVar;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int width;
        int i17 = i12 + ((i14 - i12) / 2);
        this.f5725m.set(paint);
        this.f5723c.h(this.f5725m);
        int strokeWidth = (int) ((((int) (this.f5725m.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
        if (i11 > 0) {
            width = canvas.getWidth();
        } else {
            width = i10;
            i10 -= canvas.getWidth();
        }
        this.f5724e.set(i10, i17 - strokeWidth, width, i17 + strokeWidth);
        canvas.drawRect(this.f5724e, this.f5725m);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return 0;
    }
}
