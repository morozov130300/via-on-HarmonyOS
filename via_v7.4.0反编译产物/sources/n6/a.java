package n6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements LeadingMarginSpan {

    /* renamed from: e, reason: collision with root package name */
    public final l6.a f10199e;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f10200j = g.b();

    /* renamed from: k, reason: collision with root package name */
    public final Paint f10201k = g.a();

    public a(l6.a aVar) {
        this.f10199e = aVar;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int iK = this.f10199e.k();
        this.f10201k.set(paint);
        this.f10199e.a(this.f10201k);
        int i17 = i11 * iK;
        int i18 = i10 + i17;
        int i19 = i17 + i18;
        this.f10200j.set(Math.min(i18, i19), i12, Math.max(i18, i19), i14);
        canvas.drawRect(this.f10200j, this.f10201k);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return this.f10199e.j();
    }
}
