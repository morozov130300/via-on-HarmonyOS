package mark.via.common.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o0 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f10014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f10015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f10016c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f10017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10018b;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new o0(this);
        }

        public b(Bitmap bitmap, int i10) {
            this.f10017a = bitmap;
            this.f10018b = i10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new o0(new b(this.f10017a, o0.b(resources)));
        }
    }

    public static int b(Resources resources) {
        if (resources == null) {
            return 160;
        }
        return resources.getDisplayMetrics().densityDpi;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f10014a.f10017a.isRecycled() || getBounds().isEmpty()) {
            return;
        }
        int iSave = canvas.save();
        canvas.clipRect(getBounds());
        canvas.drawBitmap(this.f10014a.f10017a, this.f10016c, this.f10015b);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f10014a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f10014a.f10017a.getScaledHeight(this.f10014a.f10018b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f10014a.f10017a.getScaledWidth(this.f10014a.f10018b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (this.f10014a.f10017a.hasAlpha() || this.f10015b.getAlpha() < 255) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int width = this.f10014a.f10017a.getWidth();
        int height = this.f10014a.f10017a.getHeight();
        if (rect.isEmpty() || width <= 0 || height <= 0) {
            this.f10016c.reset();
            return;
        }
        float f10 = width;
        float f11 = height;
        float fMax = Math.max(rect.width() / f10, rect.height() / f11);
        float fWidth = rect.left + ((rect.width() - (f10 * fMax)) / 2.0f);
        float fHeight = rect.top + ((rect.height() - (f11 * fMax)) / 2.0f);
        this.f10016c.setScale(fMax, fMax);
        this.f10016c.postTranslate(fWidth, fHeight);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f10015b.getAlpha() != i10) {
            this.f10015b.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f10015b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public o0(Resources resources, Bitmap bitmap) {
        this(new b(bitmap, b(resources)));
    }

    public o0(b bVar) {
        this.f10016c = new Matrix();
        this.f10014a = bVar;
        this.f10015b = new Paint(3);
    }
}
