package n6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h implements LeadingMarginSpan {

    /* renamed from: e, reason: collision with root package name */
    public final l6.a f10219e;

    /* renamed from: j, reason: collision with root package name */
    public final String f10220j;

    /* renamed from: k, reason: collision with root package name */
    public final Paint f10221k = g.a();

    /* renamed from: l, reason: collision with root package name */
    public int f10222l;

    public h(l6.a aVar, String str) {
        this.f10219e = aVar;
        this.f10220j = str;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        if (z10 && t6.c.b(i15, charSequence, this)) {
            this.f10221k.set(paint);
            this.f10219e.g(this.f10221k);
            int iMeasureText = (int) (this.f10221k.measureText(this.f10220j) + 0.5f);
            int iJ = this.f10219e.j();
            if (iMeasureText > iJ) {
                this.f10222l = iMeasureText;
                iJ = iMeasureText;
            } else {
                this.f10222l = 0;
            }
            canvas.drawText(this.f10220j, i11 > 0 ? (i10 + (iJ * i11)) - iMeasureText : i10 + (i11 * iJ) + (iJ - iMeasureText), i13, this.f10221k);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return Math.max(this.f10222l, this.f10219e.j());
    }
}
