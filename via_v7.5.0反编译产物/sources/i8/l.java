package i8;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f6320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f6321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6324e;

    public l(Bitmap bitmap, int i10) {
        this.f6321b = bitmap;
        Bitmap bitmap2 = this.f6321b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
        Paint paint = new Paint();
        this.f6320a = paint;
        paint.setAntiAlias(true);
        this.f6320a.setShader(bitmapShader);
        this.f6322c = this.f6321b.getWidth();
        this.f6323d = this.f6321b.getHeight();
        this.f6324e = i10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, this.f6322c, this.f6323d);
        int i10 = this.f6324e;
        canvas.drawRoundRect(rectF, i10, i10, this.f6320a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f6323d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f6322c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f6320a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f6320a.setColorFilter(colorFilter);
    }
}
