package h6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h implements LeadingMarginSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f6.a f5718c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5719e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f5720m = g.a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5721n;

    public h(f6.a aVar, String str) {
        this.f5718c = aVar;
        this.f5719e = str;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        if (z10 && n6.c.b(i15, charSequence, this)) {
            this.f5720m.set(paint);
            this.f5718c.g(this.f5720m);
            int iMeasureText = (int) (this.f5720m.measureText(this.f5719e) + 0.5f);
            int iJ = this.f5718c.j();
            if (iMeasureText > iJ) {
                this.f5721n = iMeasureText;
                iJ = iMeasureText;
            } else {
                this.f5721n = 0;
            }
            canvas.drawText(this.f5719e, i11 > 0 ? (i10 + (iJ * i11)) - iMeasureText : i10 + (i11 * iJ) + (iJ - iMeasureText), i13, this.f5720m);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return Math.max(this.f5721n, this.f5718c.j());
    }
}
