package o6;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n6.j;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends ReplacementSpan {

    /* renamed from: e, reason: collision with root package name */
    public final e f10425e;

    /* renamed from: j, reason: collision with root package name */
    public final List f10426j;

    /* renamed from: k, reason: collision with root package name */
    public final List f10427k;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f10429m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f10430n;

    /* renamed from: q, reason: collision with root package name */
    public int f10433q;

    /* renamed from: r, reason: collision with root package name */
    public int f10434r;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f10431o = new Rect();

    /* renamed from: p, reason: collision with root package name */
    public final Paint f10432p = new Paint(1);

    /* renamed from: l, reason: collision with root package name */
    public final TextPaint f10428l = new TextPaint();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f10435e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f10436j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ b f10437k;

        public a(int i10, int i11, b bVar) {
            this.f10435e = i10;
            this.f10436j = i11;
            this.f10437k = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(c.this);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f10439a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f10440b;

        public b(int i10, CharSequence charSequence) {
            this.f10439a = i10;
            this.f10440b = charSequence;
        }

        public String toString() {
            return "Cell{alignment=" + this.f10439a + ", text=" + ((Object) this.f10440b) + '}';
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: o6.c$c, reason: collision with other inner class name */
    public interface InterfaceC0106c {
    }

    public c(e eVar, List list, boolean z10, boolean z11) {
        this.f10425e = eVar;
        this.f10426j = list;
        this.f10427k = new ArrayList(list.size());
        this.f10429m = z10;
        this.f10430n = z11;
        int i10 = eVar.f10447g;
        if (i10 > 0) {
            this.f10433q = i10;
        }
    }

    public static /* synthetic */ InterfaceC0106c a(c cVar) {
        cVar.getClass();
        return null;
    }

    public static Layout.Alignment b(int i10) {
        return i10 != 1 ? i10 != 2 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    public int c() {
        return d(this.f10427k.size());
    }

    public int d(int i10) {
        return (int) (((this.f10433q * 1.0f) / i10) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0156  */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        int i15;
        int i16;
        boolean z10;
        int iSave;
        int i17;
        int iA = t6.e.a(canvas, charSequence);
        if (h(iA)) {
            this.f10433q = iA;
            if (paint instanceof TextPaint) {
                this.f10428l.set((TextPaint) paint);
            } else {
                this.f10428l.set(paint);
            }
            g();
        }
        int iH = this.f10425e.h();
        int size = this.f10427k.size();
        int iD = d(size);
        int i18 = iD - (this.f10433q / size);
        if (this.f10429m) {
            this.f10425e.c(this.f10432p);
        } else if (this.f10430n) {
            this.f10425e.d(this.f10432p);
        } else {
            this.f10425e.b(this.f10432p);
        }
        if (this.f10432p.getColor() != 0) {
            iSave = canvas.save();
            try {
                i15 = iD;
                this.f10431o.set(0, 0, this.f10433q, i14 - i12);
                canvas.translate(f10, i12);
                canvas.drawRect(this.f10431o, this.f10432p);
            } finally {
                canvas.restoreToCount(iSave);
            }
        } else {
            i15 = iD;
        }
        this.f10432p.set(paint);
        this.f10425e.a(this.f10432p);
        int iG = this.f10425e.g(this.f10432p);
        boolean z11 = iG > 0;
        int i19 = i14 - i12;
        int i20 = (i19 - this.f10434r) / 4;
        if (z11) {
            i16 = i18;
            d[] dVarArr = (d[]) ((Spanned) charSequence).getSpans(i10, i11, d.class);
            if (dVarArr == null || dVarArr.length <= 0 || !t6.c.b(i10, charSequence, dVarArr[0])) {
                z10 = false;
            } else {
                this.f10431o.set((int) f10, i12, this.f10433q, i12 + iG);
                canvas.drawRect(this.f10431o, this.f10432p);
                z10 = true;
            }
            this.f10431o.set((int) f10, i14 - iG, this.f10433q, i14);
            canvas.drawRect(this.f10431o, this.f10432p);
        } else {
            i16 = i18;
            z10 = false;
        }
        int i21 = iG / 2;
        int i22 = z10 ? iG : 0;
        int i23 = i19 - iG;
        int i24 = 0;
        int height = 0;
        while (i24 < size) {
            Layout layout = (Layout) this.f10427k.get(i24);
            iSave = canvas.save();
            int i25 = size;
            try {
                canvas.translate(f10 + (i24 * i15), i12);
                if (z11) {
                    if (i24 == 0) {
                        this.f10431o.set(0, i22, iG, i23);
                    } else {
                        this.f10431o.set(-i21, i22, i21, i23);
                    }
                    canvas.drawRect(this.f10431o, this.f10432p);
                    if (i24 == i25 - 1) {
                        i17 = i21;
                        this.f10431o.set((i15 - iG) - i16, i22, i15 - i16, i23);
                        canvas.drawRect(this.f10431o, this.f10432p);
                    }
                } else {
                    i17 = i21;
                }
                canvas.translate(iH, iH + i20);
                layout.draw(canvas);
                if (layout.getHeight() > height) {
                    height = layout.getHeight();
                }
                canvas.restoreToCount(iSave);
                i24++;
                i21 = i17;
                size = i25;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Layout e(int i10) {
        int size = this.f10427k.size();
        int iD = i10 / d(size);
        if (iD >= size) {
            return null;
        }
        return (Layout) this.f10427k.get(iD);
    }

    public final void f(int i10, int i11, b bVar) {
        a aVar = new a(i10, i11, bVar);
        CharSequence charSequence = bVar.f10440b;
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(bVar.f10440b);
        StaticLayout staticLayout = new StaticLayout(spannableString, this.f10428l, i11, b(bVar.f10439a), 1.0f, 0.0f, false);
        j.a(spannableString, staticLayout);
        i(spannableString, aVar);
        this.f10427k.add(i10, staticLayout);
    }

    public final void g() {
        this.f10428l.setFakeBoldText(this.f10429m);
        int size = this.f10426j.size();
        int iD = d(size) - (this.f10425e.h() * 2);
        this.f10427k.clear();
        int size2 = this.f10426j.size();
        for (int i10 = 0; i10 < size2; i10++) {
            f(i10, iD, (b) this.f10426j.get(i10));
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        if (paint instanceof TextPaint) {
            this.f10428l.set((TextPaint) paint);
        } else {
            this.f10428l.set(paint);
        }
        g();
        if (this.f10427k.size() > 0 && fontMetricsInt != null) {
            Iterator it = this.f10427k.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                int height = ((Layout) it.next()).getHeight();
                if (height > i12) {
                    i12 = height;
                }
            }
            this.f10434r = i12;
            int i13 = -(i12 + (this.f10425e.h() * 2));
            fontMetricsInt.ascent = i13;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i13;
            fontMetricsInt.bottom = 0;
        }
        return this.f10433q;
    }

    public final boolean h(int i10) {
        return this.f10433q != i10;
    }

    public final void i(Spannable spannable, Runnable runnable) {
        p6.c[] cVarArr = (p6.c[]) spannable.getSpans(0, spannable.length(), p6.c.class);
        if (cVarArr == null || cVarArr.length <= 0 || cVarArr.length <= 0) {
            return;
        }
        p6.c cVar = cVarArr[0];
        throw null;
    }
}
