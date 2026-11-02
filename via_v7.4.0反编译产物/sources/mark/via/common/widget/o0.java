package mark.via.common.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o0 extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final b f9725a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f9726b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f9727c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f9728a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9729b;

        public b(Bitmap bitmap, int i10) {
            this.f9728a = bitmap;
            this.f9729b = i10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new o0(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new o0(new b(this.f9728a, o0.b(resources)));
        }
    }

    public o0(Resources resources, Bitmap bitmap) {
        this(new b(bitmap, b(resources)));
    }

    public o0(b bVar) {
        this.f9727c = new Matrix();
        this.f9725a = bVar;
        this.f9726b = new Paint(3);
    }

    public static int b(Resources resources) {
        if (resources == null) {
            return 160;
        }
        return resources.getDisplayMetrics().densityDpi;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f9725a.f9728a.isRecycled() || getBounds().isEmpty()) {
            return;
        }
        int iSave = canvas.save();
        canvas.clipRect(getBounds());
        canvas.drawBitmap(this.f9725a.f9728a, this.f9727c, this.f9726b);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f9725a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f9725a.f9728a.getScaledHeight(this.f9725a.f9729b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f9725a.f9728a.getScaledWidth(this.f9725a.f9729b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (this.f9725a.f9728a.hasAlpha() || this.f9726b.getAlpha() < 255) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int width = this.f9725a.f9728a.getWidth();
        int height = this.f9725a.f9728a.getHeight();
        if (rect.isEmpty() || width <= 0 || height <= 0) {
            this.f9727c.reset();
            return;
        }
        float f10 = width;
        float f11 = height;
        float fMax = Math.max(rect.width() / f10, rect.height() / f11);
        this.f9727c.setScale(fMax, fMax);
        this.f9727c.postTranslate(rect.left + ((rect.width() - (f10 * fMax)) / 2.0f), rect.top + ((rect.height() - (f11 * fMax)) / 2.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f9726b.getAlpha() != i10) {
            this.f9726b.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9726b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
