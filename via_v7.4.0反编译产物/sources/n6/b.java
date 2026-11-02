package n6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements LeadingMarginSpan {

    /* renamed from: n, reason: collision with root package name */
    public static final boolean f10202n;

    /* renamed from: e, reason: collision with root package name */
    public l6.a f10203e;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f10204j = g.a();

    /* renamed from: k, reason: collision with root package name */
    public final RectF f10205k = g.c();

    /* renamed from: l, reason: collision with root package name */
    public final Rect f10206l = g.b();

    /* renamed from: m, reason: collision with root package name */
    public final int f10207m;

    static {
        int i10 = Build.VERSION.SDK_INT;
        f10202n = 24 == i10 || 25 == i10;
    }

    public b(l6.a aVar, int i10) {
        this.f10203e = aVar;
        this.f10207m = i10;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int iMin;
        int iMax;
        if (z10 && t6.c.b(i15, charSequence, this)) {
            this.f10204j.set(paint);
            this.f10203e.g(this.f10204j);
            int iSave = canvas.save();
            try {
                int iJ = this.f10203e.j();
                int iL = this.f10203e.l((int) ((this.f10204j.descent() - this.f10204j.ascent()) + 0.5f));
                int i17 = (iJ - iL) / 2;
                if (f10202n) {
                    int width = i11 < 0 ? i10 - (layout.getWidth() - (iJ * this.f10207m)) : (iJ * this.f10207m) - i10;
                    int i18 = i10 + (i17 * i11);
                    int i19 = (i11 * iL) + i18;
                    int i20 = i11 * width;
                    iMin = Math.min(i18, i19) + i20;
                    iMax = Math.max(i18, i19) + i20;
                } else {
                    if (i11 <= 0) {
                        i10 -= iJ;
                    }
                    iMin = i10 + i17;
                    iMax = iMin + iL;
                }
                int iDescent = (i13 + ((int) (((this.f10204j.descent() + this.f10204j.ascent()) / 2.0f) + 0.5f))) - (iL / 2);
                int i21 = iL + iDescent;
                int i22 = this.f10207m;
                if (i22 == 0 || i22 == 1) {
                    this.f10205k.set(iMin, iDescent, iMax, i21);
                    this.f10204j.setStyle(this.f10207m == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                    canvas.drawOval(this.f10205k, this.f10204j);
                } else {
                    this.f10206l.set(iMin, iDescent, iMax, i21);
                    this.f10204j.setStyle(Paint.Style.FILL);
                    canvas.drawRect(this.f10206l, this.f10204j);
                }
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return this.f10203e.j();
    }
}
