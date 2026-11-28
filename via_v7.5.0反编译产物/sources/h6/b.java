package h6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements LeadingMarginSpan {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final boolean f5701p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f6.a f5702c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f5703e = g.a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f5704m = g.c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f5705n = g.b();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f5706o;

    static {
        int i10 = Build.VERSION.SDK_INT;
        f5701p = 24 == i10 || 25 == i10;
    }

    public b(f6.a aVar, int i10) {
        this.f5702c = aVar;
        this.f5706o = i10;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
        int iMin;
        int iMax;
        if (z10 && n6.c.b(i15, charSequence, this)) {
            this.f5703e.set(paint);
            this.f5702c.g(this.f5703e);
            int iSave = canvas.save();
            try {
                int iJ = this.f5702c.j();
                int iL = this.f5702c.l((int) ((this.f5703e.descent() - this.f5703e.ascent()) + 0.5f));
                int i17 = (iJ - iL) / 2;
                if (f5701p) {
                    int width = i11 < 0 ? i10 - (layout.getWidth() - (iJ * this.f5706o)) : (iJ * this.f5706o) - i10;
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
                int iDescent = (i13 + ((int) (((this.f5703e.descent() + this.f5703e.ascent()) / 2.0f) + 0.5f))) - (iL / 2);
                int i21 = iL + iDescent;
                int i22 = this.f5706o;
                if (i22 == 0 || i22 == 1) {
                    this.f5704m.set(iMin, iDescent, iMax, i21);
                    this.f5703e.setStyle(this.f5706o == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                    canvas.drawOval(this.f5704m, this.f5703e);
                } else {
                    this.f5705n.set(iMin, iDescent, iMax, i21);
                    this.f5703e.setStyle(Paint.Style.FILL);
                    canvas.drawRect(this.f5705n, this.f5703e);
                }
            } finally {
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z10) {
        return this.f5702c.j();
    }
}
