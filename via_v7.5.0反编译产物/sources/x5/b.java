package x5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.e;
import com.tuyafeng.support.utils.f;
import com.tuyafeng.support.utils.l;
import com.tuyafeng.support.utils.x;
import v8.g;
import w7.k;
import w7.m;
import w7.n;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends RecyclerView.n implements RecyclerView.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f14508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f14509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f14510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14520m;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        w5.b a(int i10);
    }

    public b(Context context, a aVar) {
        Paint paint = new Paint();
        this.f14509b = paint;
        this.f14510c = new RectF();
        this.f14508a = aVar;
        paint.setAntiAlias(true);
        this.f14519l = l.d(context);
        this.f14511d = x.h(context, 32.0f);
        this.f14512e = f.b(context, m.f13739c);
        this.f14513f = e.a(context, k.f13733m);
        this.f14514g = f.d(context, n.f13761n);
        this.f14515h = x.h(context, 18.0f);
        this.f14516i = x.h(context, 4.0f);
        this.f14517j = x.h(context, 12.0f);
        paint.setTextSize(this.f14514g);
        paint.setTypeface(g.i());
        if (this.f14519l) {
            paint.setTextAlign(Paint.Align.RIGHT);
        }
        this.f14518k = this.f14512e;
        this.f14520m = x8.l.f() ? 1 : 0;
    }

    public static int l(int i10, float f10) {
        return Color.argb(Math.round(f10 * 255.0f), Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 0 && recyclerView.getChildCount() > 0 && this.f14510c.contains(motionEvent.getX(), motionEvent.getY());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        super.g(rect, view, recyclerView, a0Var);
        if (this.f14508a == null) {
            return;
        }
        if (this.f14508a.a(recyclerView.i0(view)).a() == 0) {
            rect.top = this.f14511d;
        } else {
            rect.top = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        super.k(canvas, recyclerView, a0Var);
        this.f14510c.setEmpty();
        if (this.f14508a == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            w5.b bVarA = this.f14508a.a(recyclerView.i0(childAt));
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            if (i10 == 0) {
                int paddingTop = recyclerView.getPaddingTop();
                if (bVarA.d()) {
                    paddingTop = Math.min(childAt.getBottom() - this.f14511d, paddingTop);
                }
                int i11 = paddingTop;
                int i12 = i11 + this.f14511d;
                if (childAt.getTop() >= 0) {
                    float top = 1.0f - (childAt.getTop() / this.f14511d);
                    this.f14518k = l(this.f14512e, top);
                    m(canvas, bVarA.b(), paddingLeft, i11, width, i12, (int) (childAt.getTranslationY() + 0.5f), top);
                } else {
                    this.f14518k = l(this.f14512e, 1.0f);
                    m(canvas, bVarA.b(), paddingLeft, i11, width, i12, (int) (childAt.getTranslationY() + 0.5f), 1.0f);
                }
            } else if (bVarA.a() == 0) {
                int top2 = childAt.getTop() - this.f14511d;
                int top3 = childAt.getTop();
                this.f14518k = 0;
                m(canvas, bVarA.b(), paddingLeft, top2, width, top3, (int) (childAt.getTranslationY() + 0.5f), 0.0f);
            }
        }
    }

    public final void m(Canvas canvas, String str, int i10, int i11, int i12, int i13, int i14, float f10) {
        String str2 = str;
        this.f14509b.setColor(this.f14518k);
        int i15 = i11 + i14;
        int i16 = i13 + i14;
        float f11 = 0.0f;
        if (this.f14520m == 1) {
            float f12 = f10 * this.f14517j;
            float fMeasureText = this.f14509b.measureText(str2);
            int i17 = this.f14515h;
            int i18 = i17 >> 1;
            boolean z10 = this.f14519l;
            float f13 = z10 ? (((i12 - i18) - i17) - fMeasureText) - f12 : i10 + i18 + f12;
            float f14 = z10 ? (i12 - i18) - f12 : i10 + fMeasureText + i17 + i18 + f12;
            if (f10 > 0.0f) {
                this.f14510c.set(f13, this.f14516i + i15, f14, i16);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                int i19 = this.f14515h;
                canvas.drawRoundRect(f13, this.f14516i + i15, f14, i16, i19, i19, this.f14509b);
            } else {
                RectF rectF = new RectF(f13, this.f14516i + i15, f14, i16);
                int i20 = this.f14515h;
                canvas.drawRoundRect(rectF, i20, i20, this.f14509b);
            }
            f11 = f12;
        } else {
            if (f10 > 0.0f) {
                this.f14510c.set(i10, i15, i12, i16);
            }
            canvas.drawRect(i10, i15, i12, i16, this.f14509b);
        }
        float f15 = this.f14519l ? (i12 - this.f14515h) - f11 : this.f14515h + i10 + f11;
        float fDescent = (((i16 - i15) / 2.0f) - ((this.f14509b.descent() + this.f14509b.ascent()) / 2.0f)) + i15 + this.f14516i;
        this.f14509b.setColor(this.f14513f);
        if (str2 == null) {
            str2 = "";
        }
        canvas.drawText(str2, f15, fDescent, this.f14509b);
    }

    public void n(int i10) {
        this.f14512e = i10;
    }

    public void o(int i10) {
        this.f14520m = i10;
    }

    public void p(int i10) {
        this.f14517j = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void e(boolean z10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
