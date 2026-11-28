package h6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements LeadingMarginSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f6.a f5698c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f5699e = g.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f5700m = g.a();

    public a(f6.a aVar) {
        this.f5698c = aVar;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int iK = this.f5698c.k();
        this.f5700m.set(paint);
        this.f5698c.a(this.f5700m);
        int i17 = i11 * iK;
        int i18 = i10 + i17;
        int i19 = i17 + i18;
        this.f5699e.set(Math.min(i18, i19), i12, Math.max(i18, i19), i14);
        canvas.drawRect(this.f5699e, this.f5700m);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return this.f5698c.j();
    }
}
