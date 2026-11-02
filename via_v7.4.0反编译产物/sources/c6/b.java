package c6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import g6.e;
import g6.f;
import g6.l;
import g6.y;
import x7.k;
import x7.m;
import x7.n;
import x8.g;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends RecyclerView.n {

    /* renamed from: a, reason: collision with root package name */
    public final a f2294a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f2295b;

    /* renamed from: c, reason: collision with root package name */
    public int f2296c;

    /* renamed from: d, reason: collision with root package name */
    public int f2297d;

    /* renamed from: e, reason: collision with root package name */
    public int f2298e;

    /* renamed from: f, reason: collision with root package name */
    public int f2299f;

    /* renamed from: g, reason: collision with root package name */
    public int f2300g;

    /* renamed from: h, reason: collision with root package name */
    public int f2301h;

    /* renamed from: i, reason: collision with root package name */
    public int f2302i;

    /* renamed from: j, reason: collision with root package name */
    public int f2303j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2304k;

    /* renamed from: l, reason: collision with root package name */
    public int f2305l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        b6.b a(int i10);
    }

    public b(Context context, a aVar) {
        Paint paint = new Paint();
        this.f2295b = paint;
        this.f2294a = aVar;
        paint.setAntiAlias(true);
        this.f2304k = l.d(context);
        this.f2296c = y.h(context, 32.0f);
        this.f2297d = f.b(context, m.f13673c);
        this.f2298e = e.a(context, k.f13666l);
        this.f2299f = f.d(context, n.f13695n);
        this.f2300g = y.h(context, 18.0f);
        this.f2301h = y.h(context, 4.0f);
        this.f2302i = y.h(context, 12.0f);
        paint.setTextSize(this.f2299f);
        paint.setTypeface(g.i());
        if (this.f2304k) {
            paint.setTextAlign(Paint.Align.RIGHT);
        }
        this.f2303j = this.f2297d;
        this.f2305l = z8.l.f() ? 1 : 0;
    }

    public static int l(int i10, float f10) {
        return Color.argb(Math.round(f10 * 255.0f), Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        super.g(rect, view, recyclerView, zVar);
        if (this.f2294a == null) {
            return;
        }
        if (this.f2294a.a(recyclerView.i0(view)).a() == 0) {
            rect.top = this.f2296c;
        } else {
            rect.top = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        super.k(canvas, recyclerView, zVar);
        if (this.f2294a == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            b6.b bVarA = this.f2294a.a(recyclerView.i0(childAt));
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            if (i10 == 0) {
                int paddingTop = recyclerView.getPaddingTop();
                if (bVarA.d()) {
                    paddingTop = Math.min(childAt.getBottom() - this.f2296c, paddingTop);
                }
                int i11 = paddingTop;
                int i12 = i11 + this.f2296c;
                if (childAt.getTop() >= 0) {
                    float top = 1.0f - (childAt.getTop() / this.f2296c);
                    this.f2303j = l(this.f2297d, top);
                    m(canvas, bVarA.b(), paddingLeft, i11, width, i12, (int) (childAt.getTranslationY() + 0.5f), top);
                } else {
                    this.f2303j = l(this.f2297d, 1.0f);
                    m(canvas, bVarA.b(), paddingLeft, i11, width, i12, (int) (childAt.getTranslationY() + 0.5f), 1.0f);
                }
            } else if (bVarA.a() == 0) {
                int top2 = childAt.getTop() - this.f2296c;
                int top3 = childAt.getTop();
                this.f2303j = 0;
                m(canvas, bVarA.b(), paddingLeft, top2, width, top3, (int) (childAt.getTranslationY() + 0.5f), 0.0f);
            }
        }
    }

    public final void m(Canvas canvas, String str, int i10, int i11, int i12, int i13, int i14, float f10) {
        float f11;
        String str2 = str;
        this.f2295b.setColor(this.f2303j);
        int i15 = i11 + i14;
        int i16 = i13 + i14;
        if (this.f2305l == 1) {
            f11 = f10 * this.f2302i;
            float fMeasureText = this.f2295b.measureText(str2);
            int i17 = this.f2300g;
            int i18 = i17 >> 1;
            boolean z10 = this.f2304k;
            float f12 = z10 ? (((i12 - i18) - i17) - fMeasureText) - f11 : i10 + i18 + f11;
            float f13 = z10 ? (i12 - i18) - f11 : i10 + fMeasureText + i17 + i18 + f11;
            if (Build.VERSION.SDK_INT >= 21) {
                canvas.drawRoundRect(f12, this.f2301h + i15, f13, i16, i17, i17, this.f2295b);
            } else {
                RectF rectF = new RectF(f12, this.f2301h + i15, f13, i16);
                int i19 = this.f2300g;
                canvas.drawRoundRect(rectF, i19, i19, this.f2295b);
            }
        } else {
            canvas.drawRect(i10, i15, i12, i16, this.f2295b);
            f11 = 0.0f;
        }
        float f14 = this.f2304k ? (i12 - this.f2300g) - f11 : this.f2300g + i10 + f11;
        float fDescent = (((i16 - i15) / 2.0f) - ((this.f2295b.descent() + this.f2295b.ascent()) / 2.0f)) + i15 + this.f2301h;
        this.f2295b.setColor(this.f2298e);
        if (str2 == null) {
            str2 = "";
        }
        canvas.drawText(str2, f14, fDescent, this.f2295b);
    }

    public void n(int i10) {
        this.f2297d = i10;
    }

    public void o(int i10) {
        this.f2305l = i10;
    }

    public void p(int i10) {
        this.f2302i = i10;
    }
}
