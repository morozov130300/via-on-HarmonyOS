package i6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import h6.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends ReplacementSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f6266c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f6267e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f6268m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f6270o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f6271p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6274s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6275t;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f6272q = new Rect();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f6273r = new Paint(1);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextPaint f6269n = new TextPaint();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f6276c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f6277e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b f6278m;

        public a(int i10, int i11, b bVar) {
            this.f6276c = i10;
            this.f6277e = i11;
            this.f6278m = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(c.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f6281b;

        public b(int i10, CharSequence charSequence) {
            this.f6280a = i10;
            this.f6281b = charSequence;
        }

        public String toString() {
            return "Cell{alignment=" + this.f6280a + ", text=" + ((Object) this.f6281b) + '}';
        }
    }

    /* JADX INFO: renamed from: i6.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0078c {
    }

    public c(e eVar, List list, boolean z10, boolean z11) {
        this.f6266c = eVar;
        this.f6267e = list;
        this.f6268m = new ArrayList(list.size());
        this.f6270o = z10;
        this.f6271p = z11;
        int i10 = eVar.f6288g;
        if (i10 > 0) {
            this.f6274s = i10;
        }
    }

    public static /* synthetic */ InterfaceC0078c a(c cVar) {
        cVar.getClass();
        return null;
    }

    public static Layout.Alignment b(int i10) {
        if (i10 != 1) {
            return i10 != 2 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    public int c() {
        return d(this.f6268m.size());
    }

    public int d(int i10) {
        return (int) (((this.f6274s * 1.0f) / i10) + 0.5f);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0156  */
    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        boolean z10;
        int iA = n6.e.a(canvas, charSequence);
        if (h(iA)) {
            this.f6274s = iA;
            if (paint instanceof TextPaint) {
                this.f6269n.set((TextPaint) paint);
            } else {
                this.f6269n.set(paint);
            }
            g();
        }
        int iH = this.f6266c.h();
        int size = this.f6268m.size();
        int iD = d(size);
        int i15 = iD - (this.f6274s / size);
        if (this.f6270o) {
            this.f6266c.c(this.f6273r);
        } else if (this.f6271p) {
            this.f6266c.d(this.f6273r);
        } else {
            this.f6266c.b(this.f6273r);
        }
        if (this.f6273r.getColor() != 0) {
            int iSave = canvas.save();
            try {
                this.f6272q.set(0, 0, this.f6274s, i14 - i12);
                canvas.translate(f10, i12);
                canvas.drawRect(this.f6272q, this.f6273r);
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
        this.f6273r.set(paint);
        this.f6266c.a(this.f6273r);
        int iG = this.f6266c.g(this.f6273r);
        boolean z11 = iG > 0;
        int i16 = i14 - i12;
        int i17 = (i16 - this.f6275t) / 4;
        if (z11) {
            d[] dVarArr = (d[]) ((Spanned) charSequence).getSpans(i10, i11, d.class);
            if (dVarArr == null || dVarArr.length <= 0 || !n6.c.b(i10, charSequence, dVarArr[0])) {
                z10 = false;
            } else {
                this.f6272q.set((int) f10, i12, this.f6274s, i12 + iG);
                canvas.drawRect(this.f6272q, this.f6273r);
                z10 = true;
            }
            this.f6272q.set((int) f10, i14 - iG, this.f6274s, i14);
            canvas.drawRect(this.f6272q, this.f6273r);
        } else {
            z10 = false;
        }
        int i18 = iG / 2;
        int i19 = z10 ? iG : 0;
        int i20 = i16 - iG;
        int i21 = 0;
        int height = 0;
        while (i21 < size) {
            Layout layout = (Layout) this.f6268m.get(i21);
            int iSave2 = canvas.save();
            int i22 = size;
            try {
                canvas.translate(f10 + (i21 * iD), i12);
                if (z11) {
                    if (i21 == 0) {
                        this.f6272q.set(0, i19, iG, i20);
                    } else {
                        this.f6272q.set(-i18, i19, i18, i20);
                    }
                    canvas.drawRect(this.f6272q, this.f6273r);
                    if (i21 == i22 - 1) {
                        this.f6272q.set((iD - iG) - i15, i19, iD - i15, i20);
                        canvas.drawRect(this.f6272q, this.f6273r);
                    }
                }
                canvas.translate(iH, iH + i17);
                layout.draw(canvas);
                if (layout.getHeight() > height) {
                    height = layout.getHeight();
                }
                canvas.restoreToCount(iSave2);
                i21++;
                i18 = i18;
                size = i22;
            } catch (Throwable th2) {
                canvas.restoreToCount(iSave2);
                throw th2;
            }
        }
    }

    public Layout e(int i10) {
        int size = this.f6268m.size();
        int iD = i10 / d(size);
        if (iD >= size) {
            return null;
        }
        return (Layout) this.f6268m.get(iD);
    }

    public final void f(int i10, int i11, b bVar) {
        a aVar = new a(i10, i11, bVar);
        CharSequence charSequence = bVar.f6281b;
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(bVar.f6281b);
        StaticLayout staticLayout = new StaticLayout(spannableString, this.f6269n, i11, b(bVar.f6280a), 1.0f, 0.0f, false);
        j.a(spannableString, staticLayout);
        i(spannableString, aVar);
        this.f6268m.add(i10, staticLayout);
    }

    public final void g() {
        this.f6269n.setFakeBoldText(this.f6270o);
        int size = this.f6267e.size();
        int iD = d(size) - (this.f6266c.h() * 2);
        this.f6268m.clear();
        int size2 = this.f6267e.size();
        for (int i10 = 0; i10 < size2; i10++) {
            f(i10, iD, (b) this.f6267e.get(i10));
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        if (paint instanceof TextPaint) {
            this.f6269n.set((TextPaint) paint);
        } else {
            this.f6269n.set(paint);
        }
        g();
        if (this.f6268m.size() > 0 && fontMetricsInt != null) {
            Iterator it = this.f6268m.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                int height = ((Layout) it.next()).getHeight();
                if (height > i12) {
                    i12 = height;
                }
            }
            this.f6275t = i12;
            int i13 = -(i12 + (this.f6266c.h() * 2));
            fontMetricsInt.ascent = i13;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i13;
            fontMetricsInt.bottom = 0;
        }
        return this.f6274s;
    }

    public final boolean h(int i10) {
        return this.f6274s != i10;
    }

    public final void i(Spannable spannable, Runnable runnable) {
        j6.c[] cVarArr = (j6.c[]) spannable.getSpans(0, spannable.length(), j6.c.class);
        if (cVarArr == null || cVarArr.length <= 0 || cVarArr.length <= 0) {
            return;
        }
        j6.c cVar = cVarArr[0];
        throw null;
    }
}
